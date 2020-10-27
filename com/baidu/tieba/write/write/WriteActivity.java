package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.m.a.a;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.tieba.write.write.EBusinessProtocolView;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
import com.baidu.tieba.write.write.d;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0238a, VoiceManager.c, x.a, i.a {
    private static int nHD = 0;
    private EditorTools fhB;
    private String fjO;
    private LocationModel fjP;
    private NewWriteModel fjQ;
    List<af> gpa;
    private VoiceManager iBr;
    private com.baidu.tbadk.core.dialog.i iOq;
    private SaveDraftDialogView iOr;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private String izk;
    private String izl;
    private String izm;
    private LinearLayout lpR;
    private PlayVoiceBntNew lpS;
    private ImageView lpU;
    private TextView mGD;
    private com.baidu.tieba.write.i mGE;
    private ImageView mGF;
    private View mGG;
    private GestureDetector mGestureDetector;
    private int mGg;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FindNewLinkBubbleController nER;
    private ForumTabSelectedView nEb;
    private String nGA;
    private int nGB;
    private PostCategoryView nGC;
    private HotTopicBussinessData nGF;
    private TextView nGG;
    private com.baidu.tieba.write.editor.b nGI;
    private g nGK;
    private com.baidu.tieba.view.b nGR;
    private LinearLayout nGm;
    private LinearLayout nGn;
    private View nGq;
    private Toast nGs;
    private AdditionData nGt;
    private RelativeLayout nGu;
    private TextView nGv;
    private TextView nGw;
    private TextView nGx;
    af nGy;
    private int nGz;
    private View nHH;
    private View nHI;
    private TextView nHJ;
    private com.baidu.tieba.c.e nHL;
    private b nHM;
    private ForumSelectedView nHN;
    private com.baidu.tbadk.data.i nHO;
    private View nHP;
    private com.baidu.tieba.write.write.video.a nHQ;
    private com.baidu.tieba.write.write.vote.a nHR;
    private RelativeLayout nHS;
    private boolean nHT;
    private d nHV;
    private LinearLayout nHW;
    private ImageView nHX;
    private TextView nHY;
    private List<com.baidu.tieba.i.a> nHZ;
    private TitleTipView nHa;
    private View nHc;
    private View nHe;
    private i nHm;
    private EBusinessProtocolView nIa;
    private FrsTabInfoData nzI;
    private int privateThread;
    private String nGi = "";
    private boolean nGj = false;
    protected WriteData mGf = null;
    private boolean nGX = false;
    private boolean nGY = false;
    private boolean nGl = false;
    private boolean nGZ = false;
    private InputMethodManager mInputManager = null;
    private EditText mGy = null;
    private HeadImageView nHb = null;
    private View mGz = null;
    private LinearLayout mGB = null;
    private SpanGroupEditText nGo = null;
    private FeedBackModel nGp = null;
    private FeedBackTopListView nHd = null;
    private ArrayList<WritePrefixItemLayout> nGr = new ArrayList<>();
    private String kIM = null;
    private final KeyEvent inu = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView nHf = null;
    private TextView lqK = null;
    private TextView mName = null;
    private ImageView nHg = null;
    private DialogInterface.OnCancelListener isi = null;
    private final Handler mHandler = new Handler();
    private boolean nHh = false;
    private String nHi = null;
    private RelativeLayout jPs = null;
    public boolean nHj = true;
    public String fjU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fjV = 0;
    private int nHk = 0;
    private WriteImagesInfo nHl = new WriteImagesInfo();
    private View mRootView = null;
    private GridView nHn = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a nHo = null;
    private ScrollView nGD = null;
    private EditText nHp = null;
    private View nHq = null;
    private View nHr = null;
    private View nHs = null;
    private EditText nHt = null;
    private TextView nHu = null;
    private TextView nHv = null;
    private TextWatcher nHw = null;
    private TextWatcher nHx = null;
    private boolean nGE = false;
    private boolean nHy = false;
    private com.baidu.tbadk.core.view.a fsa = null;
    private String mFrom = "write";
    private File nHz = null;
    private TbImageView nHA = null;
    private View mBubbleView = null;
    private Dialog nHB = null;
    private LinearLayout nHC = null;
    private boolean nHE = false;
    private long nHF = -1000;
    private boolean nHG = false;
    private String jff = "2";
    private int bxM = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder nGH = new SpannableStringBuilder();
    private boolean nHK = false;
    private boolean blF = false;
    private final c nGJ = new c();
    private boolean nDF = false;
    private final d.a nHU = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Lq(int i) {
            if (WriteActivity.this.nGo != null) {
                WriteActivity.this.nGo.qe(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void fW(List<t> list) {
            WriteActivity.this.fX(list);
        }
    };
    private boolean nIb = false;
    private int nIc = 0;
    private boolean nId = false;
    private final HttpMessageListener nIe = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.kIM)) {
                    WriteActivity.this.kIM = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.yB(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.kIM)) {
                    WriteActivity.this.kIM = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.kIM);
                    WriteActivity.this.yB(true);
                }
            }
        }
    };
    private CustomMessageListener nIf = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.mGf != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").aj("obj_locate", 1).dR("fid", WriteActivity.this.mGf.getForumId()).dR("fname", WriteActivity.this.mGf.getForumName()));
            }
        }
    };
    private final CustomMessageListener nIg = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nHN != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                WriteActivity.this.nHO = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                if (WriteActivity.this.nHO != null && !StringUtils.isNull(WriteActivity.this.nHO.forumId) && !StringUtils.isNull(WriteActivity.this.nHO.forumName)) {
                    if (WriteActivity.this.mGf != null) {
                        WriteActivity.this.mGf.setForumId(WriteActivity.this.nHO.forumId);
                        WriteActivity.this.mGf.setForumName(WriteActivity.this.nHO.forumName);
                    }
                    WriteActivity.this.nHN.setSelectedForum(WriteActivity.this.nHO.forumName);
                    WriteActivity.this.nzI = null;
                    if (!y.isEmpty(WriteActivity.this.nHO.tabInfoList)) {
                        WriteActivity.this.nzI = new FrsTabInfoData();
                        WriteActivity.this.nzI.selectedTabId = -1;
                        WriteActivity.this.nzI.tabList = WriteActivity.this.nHO.tabInfoList;
                    }
                    WriteActivity.this.nEb.setData(WriteActivity.this.nzI);
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.nHO.fgs != null && !y.isEmpty(WriteActivity.this.nHO.fgs.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.nHO.fgs;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.dTr();
                }
            }
        }
    };
    private TbFaceManager.a nGL = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan DL(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.e(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a iCN = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a nIh = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.58
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.nER != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.nER.TT();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.59
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cwj();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.nIi = true;
            if (postWriteCallBackData != null && WriteActivity.this.mGf != null) {
                WriteActivity.this.nGJ.bk(null);
                if (z) {
                    WriteActivity.this.kd(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.mGf);
                    WriteActivity.this.czU();
                    WriteActivity.this.dTl();
                    if ((WriteActivity.this.mGf.getType() == 0 || WriteActivity.this.mGf.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mGf.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mGf.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.mGf.getForumName())) {
                            postWriteCallBackData.mFrom = 2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                    } else {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        WriteActivity.this.setResult(-1, intent);
                    }
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.nGJ.bk(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.nGJ.Uj(postWriteCallBackData.getErrorString());
                    WriteActivity.this.nGJ.b(WriteActivity.this.mGy, WriteActivity.this.nGo);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Ba(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Ba(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.59.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.59.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bmC();
                    TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bsw());
                    if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bsv());
                        if (WriteActivity.this.nGZ) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fkc = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bxX() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                WriteActivity.this.a(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener mTu = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fjP.xn(false);
                    WriteActivity.this.fjP.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fjP.xn(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nGM = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.WriteActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                WriteActivity.this.dTH();
            }
        }
    };
    private final View.OnClickListener nGN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dSz = WriteActivity.this.dSz();
            if (dSz >= 0 && dSz < WriteActivity.this.nGo.getText().length()) {
                WriteActivity.this.nGo.setSelection(dSz);
            }
        }
    };
    private boolean nGO = true;
    private final View.OnFocusChangeListener gWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mGy || view == WriteActivity.this.mBack || view == WriteActivity.this.lqK) {
                if (z) {
                    WriteActivity.this.nGO = true;
                    WriteActivity.this.dSA();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mGy);
                    if (WriteActivity.this.fhB != null) {
                        WriteActivity.this.fhB.bvv();
                    }
                } else if (view == WriteActivity.this.mGy) {
                    WriteActivity.this.mGD.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.nGo && z) {
                WriteActivity.this.nGO = false;
                WriteActivity.this.dSA();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nGo);
                if (WriteActivity.this.fhB != null) {
                    WriteActivity.this.fhB.bvv();
                }
            }
            WriteActivity.this.dSF();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iAw = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.UK(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean nIi = false;
    private TextWatcher nGP = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String nGT = "";
        private String nGU;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nGU = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nGU != null ? this.nGU.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dDY();
            WriteActivity.this.dSG();
            EditText dSS = WriteActivity.this.dSS();
            if (editable != null && dSS != null && dSS.getText() != null) {
                if (this.nGT == null || !this.nGT.equals(editable.toString())) {
                    if (WriteActivity.this.nGJ != null) {
                        this.nGT = dSS.getText().toString();
                        WriteActivity.this.nGJ.b(dSS, true);
                        return;
                    }
                    return;
                }
                dSS.setSelection(dSS.getSelectionEnd());
            }
        }
    };
    private TextWatcher nGQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String nGU;
        private String nGV = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nGU = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nGU != null ? this.nGU.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dDY();
            EditText dSR = WriteActivity.this.dSR();
            if (editable != null && dSR != null && dSR.getText() != null) {
                if (this.nGV == null || !this.nGV.equals(editable.toString())) {
                    if (WriteActivity.this.nGJ != null) {
                        this.nGV = dSR.getText().toString();
                        WriteActivity.this.nGJ.b(dSR, false);
                        return;
                    }
                    return;
                }
                dSR.setSelection(dSR.getSelectionEnd());
            }
        }
    };
    private int nIj = 0;
    private final a.InterfaceC0836a lwP = new a.InterfaceC0836a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0836a
        public void onRefresh() {
            WriteActivity.this.kIM = null;
            WriteActivity.this.yB(false);
            WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bxI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bxK();
        } else if (this.fjP.dIf()) {
            bxG();
        } else {
            this.fjP.xn(false);
            a(1, true, (String) null);
            this.fjP.dId();
        }
    }

    public void dTb() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.nGI != null) {
                this.nGI.dRj();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bxK();
        } else if (this.fjP != null) {
            this.fjP.xn(false);
            a(1, true, (String) null);
            this.fjP.dId();
        }
    }

    private void bxK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.om(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fjP.dIh();
                } else {
                    WriteActivity.this.fkc.bxX();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dSz() {
        int selectionEnd = dSR().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dSR().getText().getSpans(0, dSR().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dSR().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dSR().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSA() {
        if (this.fhB != null) {
            if (this.nHQ != null && this.nHQ.isVisible()) {
                this.fhB.setBarLauncherEnabled(!this.nGO);
                this.fhB.setDeskLauncherEnabled(!this.nGO);
                this.fhB.setToolEnabled(true, 2);
                this.fhB.setToolEnabled(true, 32);
                this.fhB.setToolEnabled(false, 10);
                this.fhB.setToolEnabled(false, 6);
                this.fhB.setToolEnabled(false, 18);
                this.fhB.ra(5).jW(false);
                if (this.nGI != null) {
                    this.nGI.yq(true);
                    return;
                }
                return;
            }
            this.fhB.setBarLauncherEnabled(!this.nGO);
            this.fhB.setDeskLauncherEnabled(this.nGO ? false : true);
            this.fhB.setToolEnabled(true, 26);
            this.fhB.setToolEnabled(true, 2);
            this.fhB.setToolEnabled(true, 30);
            this.fhB.ra(5).jW(true);
            if (this.nGI != null) {
                this.nGI.yq(true);
            }
            dTD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.nGE) {
            this.mGy.setVisibility(8);
            if (this.mGf.getType() == 5) {
                this.nHs.setVisibility(8);
            } else {
                this.nHs.setVisibility(0);
            }
            a(this.nHv, this.nHp);
            a(this.nHu, this.nHt);
            dDY();
        }
        if (this.nGX) {
            this.nGO = true;
            dSA();
            if (this.fhB != null) {
                this.fhB.bvv();
            }
            this.mGy.requestFocus();
            ShowSoftKeyPadDelay(this.mGy);
        }
        if (this.nHQ != null) {
            this.nHQ.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.nHQ != null) {
            this.nHQ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.nHQ != null) {
            this.nHQ.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            if (stringExtra != null && this.writeImagesInfo != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dSZ();
                }
                yC(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mGf.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.mGf.setVideoInfo(null);
            }
            if (this.nHQ == null) {
                this.nHQ = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.mGf.getVideoInfo() != null && this.mGf.getVideoInfo().isEditVideoDataLegal()) {
                yA(false);
                this.nHQ.dUw();
                return;
            }
            yA(true);
        }
    }

    public void EC(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void yA(boolean z) {
        if (z) {
            this.mGf.setVideoInfo(null);
            this.nHQ.setVideoInfo(null);
            this.nHm.dTQ().setVisibility(0);
            yB(false);
        } else {
            this.nHQ.setVideoInfo(this.mGf.getVideoInfo());
            this.writeImagesInfo.clear();
            this.nHm.dTQ().setVisibility(8);
            dTt();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dDY();
        dSA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mGf.getType() == 0) {
            Lt(this.bxM);
        }
        initUI();
        dTs();
        this.fjP = new LocationModel(getPageContext());
        this.fjP.a(this.fkc);
        registerListener(this.mTu);
        registerListener(this.nGM);
        registerListener(this.mBackgroundListener);
        dTO();
        cVa();
        dTG();
        if (this.nGE) {
            this.nHo.setEditorTools(this.fhB);
        } else {
            this.nGo.requestFocus();
        }
        dyx();
        dSZ();
        dTE();
        this.iAw.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iAw);
        dTc();
    }

    private void dTc() {
        UK(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cVa() {
        this.fhB = new EditorTools(getActivity());
        this.fhB.setBarMaxLauCount(5);
        this.fhB.setMoreButtonAtEnd(true);
        this.fhB.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.fhB.setBarLauncherType(1);
        this.fhB.jS(true);
        this.fhB.jT(true);
        switch (this.mGf.getType()) {
            case 4:
            case 5:
                dTf();
                break;
            default:
                dSB();
                break;
        }
        this.fhB.build();
        if (this.nGm != null) {
            this.nGm.addView(this.fhB);
        }
        cUs();
        this.fhB.display();
        com.baidu.tbadk.editortools.h qX = this.fhB.qX(6);
        if (qX != null && !TextUtils.isEmpty(this.fjU)) {
            ((View) qX).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fjU);
                }
            });
        }
        if (!this.nGE) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fhB.bvv();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dTg();
            return;
        }
        if (!this.nDF) {
            dSD();
        }
        dTH();
    }

    private void dTd() {
        this.nHq = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.nHs = this.nHq.findViewById(R.id.live_post_title_container);
        this.nHp = (EditText) this.nHq.findViewById(R.id.live_post_content);
        this.nHn = (GridView) this.nHq.findViewById(R.id.photoLiveGridView);
        this.nHt = (EditText) this.nHq.findViewById(R.id.live_post_title);
        this.nHu = (TextView) this.nHq.findViewById(R.id.titleOverPlusNumber);
        this.nHv = (TextView) this.nHq.findViewById(R.id.contentOverPlusNumber);
        this.nHr = this.nHq.findViewById(R.id.live_interval_view);
        this.nHu.setText(String.valueOf(20));
        this.nHv.setText(String.valueOf(233));
        this.nHq.setVisibility(0);
        this.nHu.setVisibility(0);
        this.nHv.setVisibility(0);
        this.nHt.setHint(R.string.tips_title_limit_new);
        this.nHt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nHy = true;
                    WriteActivity.this.nGO = true;
                    WriteActivity.this.dSA();
                    if (WriteActivity.this.fhB != null) {
                        WriteActivity.this.fhB.bvv();
                    }
                }
            }
        });
        if (this.mGf.getType() == 4) {
            this.nHp.setHint(R.string.live_write_input_content_new);
        } else if (this.mGf.getType() == 5) {
            this.nHp.setHint(R.string.live_write_input_content_update);
        }
        this.nHp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nHy = false;
                    WriteActivity.this.nGO = false;
                    WriteActivity.this.dSA();
                    if (WriteActivity.this.fhB != null) {
                        WriteActivity.this.fhB.bvv();
                    }
                }
            }
        });
        this.nHp.requestFocus();
        this.nHp.addTextChangedListener(atP());
        this.nHt.requestFocus();
        this.nHt.addTextChangedListener(atP());
        this.nHt.setOnClickListener(this.nGN);
        this.nHp.setOnClickListener(this.nGN);
        this.nHo = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.nHn);
        this.nHo.Lk(6);
        this.nHn.setAdapter((ListAdapter) this.nHo);
        View findViewById = this.nHq.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dSb() {
                WriteActivity.this.dTB();
            }
        });
        dTe();
    }

    private void dTe() {
        if (this.mGf.getType() == 0) {
            if (this.mGf.getTitle() != null) {
                this.nHt.setText(this.mGf.getTitle());
                this.nHt.setSelection(this.mGf.getTitle().length());
                return;
            }
            return;
        }
        if (this.mGf.getType() == 1 || this.mGf.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.nGE) {
            dTz();
        }
        if (this.fhB.bxc()) {
            this.fhB.bvv();
        }
        Lt(0);
    }

    public boolean dQY() {
        return !"1".equals(this.jff) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.nGJ != null) {
                if (this.nGJ.d(spannable)) {
                    return true;
                }
            }
            if (be.boR().m(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void Lt(int i) {
        if (this.writeImagesInfo != null && this.mGf != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mGf.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mGf.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dQY());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jff);
            albumFloatActivityConfig.setProfessionZone(this.mGf.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nzI);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fjU;
            antiData.setIfVoice(this.nHj);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mGf.getFirstDir(), this.mGf.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dTf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fhB.bt(arrayList);
        com.baidu.tbadk.editortools.m ra = this.fhB.ra(5);
        if (ra != null) {
            ra.fiq = 2;
        }
        this.fhB.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fhB.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dSB() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.m mVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.m mVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.fhB.b(dVar);
        }
        if (!this.nDF) {
            Boolean dTw = dTw();
            if (!this.nGX && dTw != null && dTw.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dIJ() && com.baidu.tieba.tbadkCore.t.d(this.mGf.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.fiq = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.fhB.b(mVar4);
                }
            }
        }
        if (!this.nDF && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.fiq = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fhB.b(mVar3);
            }
        }
        if (!this.nDF && !com.baidu.tieba.write.c.b.dRC()) {
            this.fhB.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nDF) {
            this.fhB.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.fhB.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.jff, "2")) {
            this.fhB.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.fhB.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.nDF && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.fis = true;
            mVar2.fiq = 9;
            mVar2.fij = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fhB.b(mVar2);
            }
        }
        if (!this.nDF && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.fis = true;
            mVar.fiq = 10;
            mVar.fij = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fhB.b(mVar);
            }
        }
        if (!this.nDF && this.nGt == null) {
            if (this.nGI == null) {
                this.nGI = new com.baidu.tieba.write.editor.b(getActivity(), this.jff);
                this.nGI.Ld(0);
                this.nGI.yp(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nGI.dRh();
                this.nGI.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dTb();
            }
            if (!y.isEmpty(this.mList)) {
                this.nGI.dRh();
            }
            this.fhB.b(this.nGI);
        }
        if (!this.nDF && this.canGoods) {
            this.fhB.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fhB.bt(arrayList);
        com.baidu.tbadk.editortools.m ra = this.fhB.ra(5);
        if (ra != null) {
            ra.fiq = 4;
        }
    }

    private void dSC() {
        if (this.nGK != null) {
            this.nGK.hideTip();
        }
    }

    private void dTg() {
        if (this.fhB != null) {
            this.fhB.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fhB != null && WriteActivity.this.fhB.fhE != null) {
                        if (WriteActivity.this.nHM == null) {
                            WriteActivity.this.nHM = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.nHM.showTip(WriteActivity.this.fhB.fhE.qY(2));
                    }
                }
            });
        }
    }

    private void dTh() {
        if (this.nHM != null) {
            this.nHM.hideTip();
        }
    }

    private void dSD() {
        if (this.nGK == null) {
            this.nGK = new g(getPageContext());
        }
        this.nGK.d(this.fhB);
    }

    private void cUs() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 9));
                        if (WriteActivity.this.dSQ()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof u)) {
                            u uVar = (u) aVar.data;
                            if (uVar.bsm() == EmotionGroupType.BIG_EMOTION || uVar.bsm() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(uVar.getName());
                                    imageFileInfo.width = uVar.getWidth();
                                    imageFileInfo.height = uVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.yC(true);
                                    WriteActivity.this.dDY();
                                }
                            } else if (WriteActivity.this.dSQ()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dST();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.diK();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dTD();
                        WriteActivity.this.dDY();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Lu(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.nGt == null) {
                            WriteActivity.this.bxL();
                            return;
                        }
                        switch (WriteActivity.this.fjV) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bxI();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bxG();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fjP != null) {
                            WriteActivity.this.fjP.xn(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.kIM = null;
                        } else {
                            WriteActivity.this.kIM = (String) aVar.data;
                        }
                        WriteActivity.this.yB(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dR("fid", WriteActivity.this.mGf != null ? WriteActivity.this.mGf.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.mGf == null || (videoInfo = WriteActivity.this.mGf.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fhB.bxc()) {
                                        WriteActivity.this.fhB.bvv();
                                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_not_active), WriteActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_install_tips), WriteActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mGf.setVideoInfo(null);
                        WriteActivity.this.dDY();
                        if (WriteActivity.this.nGo != null) {
                            WriteActivity.this.nGo.requestFocus();
                        }
                        WriteActivity.this.fhB.bvv();
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nGo);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.nGj = true;
                        WriteActivity.this.yy(true);
                        if (!WriteActivity.this.dSS().isFocused() || WriteActivity.this.nGn.getVisibility() != 0) {
                            WriteActivity.this.nGi = "from_content";
                        } else {
                            WriteActivity.this.nGi = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 8));
                        if (WriteActivity.this.nGn.getVisibility() == 0) {
                            if (WriteActivity.this.nGn.hasFocus()) {
                                WriteActivity.this.nGo.requestFocus();
                                WriteActivity.this.nGo.setSelection(WriteActivity.this.nGo.getText().toString().length());
                            }
                            WriteActivity.this.nGn.setVisibility(8);
                            WriteActivity.this.nHc.setVisibility(8);
                            WriteActivity.this.fhB.qX(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.nGn.setVisibility(0);
                            WriteActivity.this.nHc.setVisibility(0);
                            WriteActivity.this.nGn.requestFocus();
                            WriteActivity.this.fhB.qX(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dDY();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        if (WriteActivity.this.getIntent() != null) {
                            TiebaStatic.log(new aq("c12612").aj("obj_locate", 10));
                            if (WriteActivity.this.nHR != null && WriteActivity.this.nHR.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.nHR.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new aq("c13800").aj("obj_source", 2));
                        }
                        WriteActivity.this.dTi();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.nER != null) {
                            WriteActivity.this.nER.TT();
                        }
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dQD();
                    }
                }
            }
        };
        this.fhB.setActionListener(16, bVar);
        this.fhB.setActionListener(14, bVar);
        this.fhB.setActionListener(24, bVar);
        this.fhB.setActionListener(3, bVar);
        this.fhB.setActionListener(10, bVar);
        this.fhB.setActionListener(11, bVar);
        this.fhB.setActionListener(12, bVar);
        this.fhB.setActionListener(13, bVar);
        this.fhB.setActionListener(15, bVar);
        this.fhB.setActionListener(18, bVar);
        this.fhB.setActionListener(20, bVar);
        this.fhB.setActionListener(25, bVar);
        this.fhB.setActionListener(27, bVar);
        this.fhB.setActionListener(29, bVar);
        this.fhB.setActionListener(43, bVar);
        this.fhB.setActionListener(56, bVar);
        this.fhB.setActionListener(48, bVar);
        this.fhB.setActionListener(46, bVar);
        this.fhB.setActionListener(49, bVar);
        this.fhB.setActionListener(47, bVar);
        this.fhB.setActionListener(55, bVar);
        this.fhB.setActionListener(58, bVar);
        this.fhB.setActionListener(22, bVar);
        this.fhB.setActionListener(21, bVar);
        this.fhB.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTi() {
        if (this.nHg != null) {
            this.nHg.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.nIj;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void ao(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new aq("c13800").aj("obj_source", 3));
                    }
                };
                this.nHR.ao(onClickListener);
                this.nHR.setOnItemClickListener(onClickListener);
                this.nHR.b(writeVoteData);
                this.nHR.yE(true);
                dDY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteVoteData writeVoteData) {
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        if (writeVoteData != null) {
            writeVoteActivityConfig.setExtraData(writeVoteData);
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxL() {
        if (this.fjP.cfL()) {
            if (this.fjP.dIf()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dIa().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fjP.dId();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dDQ() {
        if (this.fjQ != null) {
            this.fjQ.cancelLoadData();
        }
        if (this.nGp != null) {
            this.nGp.cancelLoadData();
        }
        if (this.fjP != null) {
            this.fjP.cancelLoadData();
        }
        if (this.nHQ != null) {
            this.nHQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nIf);
        dSC();
        dTh();
        TiebaPrepareImageService.StopService();
        dDQ();
        if (!this.nIi) {
            dTj();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.iOq, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.nHm != null) {
            this.nHm.destroy();
        }
        if (this.nHL != null) {
            this.nHL.Qh();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTj() {
        if (this.mGf != null && this.mGf.getType() == 2 && this.nHh) {
            finish();
        } else if (this.mGf == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mGf.setTitle(dSS().getText().toString());
            this.mGf.setContent(dSR().getText().toString());
            int type = this.mGf.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nDF) {
                        x.e(this.mGf.getForumId(), this.mGf);
                    } else {
                        x.d(this.mGf.getForumId(), this.mGf);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.mGf);
                }
            } else if (type == 1) {
                x.f(this.mGf.getThreadId(), this.mGf);
            } else if (type == 4) {
                x.d(this.mGf.getForumId() + "photolive", this.mGf);
            } else if (type == 5) {
                x.f(this.mGf.getThreadId() + "updatephotolive", this.mGf);
            }
            this.nIi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTk() {
        if (this.lqK == null || !this.lqK.isEnabled() || this.nHT) {
            czU();
            dTl();
            setResult(100);
            finish();
            return;
        }
        if (this.iOr == null) {
            this.iOr = new SaveDraftDialogView(this);
            this.iOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.czU();
                            WriteActivity.this.dTl();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dTj();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.iOq.dismiss();
                    }
                }
            });
        }
        if (this.iOq == null) {
            this.iOq = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.iOq.setContentView(this.iOr);
        }
        boolean z = (this.nHQ == null || !this.nHQ.isVisible() || this.mGf == null || this.mGf.getVideoInfo() == null || this.mGf.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.iOr.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.iOq.PJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czU() {
        if (this.mGf.getType() == 0 || this.mGf.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nDF) {
                    x.e(this.mGf.getForumId(), (WriteData) null);
                } else {
                    x.d(this.mGf.getForumId(), (WriteData) null);
                }
            }
        } else if (this.mGf.getType() == 1) {
            x.f(this.mGf.getThreadId(), (WriteData) null);
        }
        this.nIi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTl() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nfR));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mGE != null && this.mGE.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mGE, getPageContext().getPageActivity());
                return true;
            } else if (this.fhB.bxc()) {
                this.fhB.bvv();
                return true;
            } else {
                dDQ();
                dTk();
                return true;
            }
        }
        if (i == 67 && (text = dSR().getText()) != null) {
            int selectionStart = dSR().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dSR().onKeyDown(67, this.inu);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jPs);
        getLayoutMode().onModeChanged(this.nHC);
        ap.setBackgroundColor(this.jPs, R.color.cp_bg_line_e);
        if (this.nHA != null && (i == 1 || i == 4)) {
            this.nHA.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lqK.setTextColor(ap.aP(R.color.cp_link_tip_a, i));
        dSA();
        ap.setBackgroundColor(this.mGz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.nHr, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dSS(), R.color.cp_bg_line_e);
        ap.setImageResource(this.lpU, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.kIM)) {
            ap.setBackgroundColor(dSR(), R.color.cp_bg_line_e);
        }
        dDY();
        this.fhB.onChangeSkinType(i);
        if (this.nGC != null) {
            this.nGC.bqd();
        }
        if (this.nHV != null) {
            this.nHV.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nHm.nIH.notifyDataSetChanged();
        dSF();
        dSG();
        yB(false);
        if (this.nGJ != null) {
            this.nGJ.c(dSS(), dSR());
        }
        if (this.nHN != null) {
            this.nHN.onChangeSkinType();
        }
        if (this.nEb != null) {
            this.nEb.onChangeSkinType(i);
        }
        if (this.nHQ != null) {
            this.nHQ.changeSkin();
        }
        if (this.nHR != null) {
            this.nHR.onChangeSkinType(i);
        }
        if (this.nIa != null) {
            this.nIa.onChangeSkinType(i);
        }
        if (this.nHa != null) {
            this.nHa.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSF() {
        if (this.mGy.hasFocus()) {
            this.mGy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mGy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.nGo.hasFocus()) {
            this.nGo.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.nGo.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSG() {
        if (this.mGy != null && this.mGy.getText() != null && this.mGy.getText().toString() != null && this.mGy.getPaint() != null) {
            if (this.mGy.getText().toString().length() == 0) {
                this.mGy.getPaint().setFakeBoldText(false);
            } else if (this.mGy.getText().toString().length() > 0) {
                this.mGy.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fsa = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nGE = this.mGf.getType() == 4 || 5 == this.mGf.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nHf = (TextView) findViewById(R.id.btn_image_problem);
        dSJ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lqK.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lqK.setLayoutParams(layoutParams);
        this.lqK.setOnFocusChangeListener(this.gWj);
        this.nGD = (ScrollView) findViewById(R.id.write_scrollview);
        this.nGD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.nGo != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.nGo);
                    }
                    if (WriteActivity.this.fhB != null) {
                        WriteActivity.this.fhB.bvv();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nHd = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.nHe = findViewById(R.id.feedback_divider);
        this.jPs = (RelativeLayout) findViewById(R.id.parent);
        this.nGm = (LinearLayout) findViewById(R.id.tool_view);
        this.nGm.setContentDescription(IStringUtil.TOP_PATH);
        this.nGn = (LinearLayout) findViewById(R.id.title_view);
        this.nHc = findViewById(R.id.title_view_divider);
        this.mGz = findViewById(R.id.interval_view);
        this.nHH = findViewById(R.id.hot_topic_fourm_view);
        this.nHI = findViewById(R.id.hot_topic_divider);
        this.nGG = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.nHJ = (TextView) findViewById(R.id.change_one_tv);
        dDX();
        if (this.nGE) {
            this.nGD.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dTd();
        } else {
            this.nHm = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nHm.yn(false);
            } else {
                this.nHm.yn(this.mGf.getType() == 0 || this.mGf.getType() == 9);
            }
            this.nHQ = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.mGf.getVideoInfo() != null && this.mGf.getVideoInfo().isEditVideoDataLegal()) {
                yA(false);
                this.nHQ.dUw();
            } else {
                yA(true);
            }
        }
        dDZ();
        if (this.nGX || this.nGl) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eIC) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.mGB = (LinearLayout) findViewById(R.id.post_content_container);
        this.mGB.setDrawingCacheEnabled(false);
        this.mGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.nGo.requestFocus();
            }
        });
        this.lpR = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lpS = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lpU = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lpU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.diK();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gWj);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dDQ();
                WriteActivity.this.dTk();
            }
        });
        this.nHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dSM();
        u(dTw());
        dSO();
        dSI();
        dTu();
        dSA();
        dSN();
        dDW();
        dSU();
        if (this.mGf.getType() == 4 && this.mGG != null && this.nGq != null) {
            this.mGG.setVisibility(8);
            this.nGq.setVisibility(8);
        }
        dDY();
        dTq();
        dRI();
        dTm();
        dSH();
        dTv();
        dTn();
        bNd();
    }

    private void dTm() {
        if ("main_tab".equals(this.mFrom)) {
            this.nHN = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.nHN.setVisibility(0);
        }
    }

    private void dSH() {
        this.nEb = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nHP = findViewById(R.id.frs_tab__divider);
        this.nEb.setData(this.nzI);
        if (this.nEb.getVisibility() == 0) {
            this.nHP.setVisibility(0);
        }
        this.nEb.setActivity(this);
    }

    private void dTn() {
        this.nHW = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.nHX = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.nHY = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.nHY, R.color.cp_cont_j);
        this.nIa = new EBusinessProtocolView(this);
        this.nIa.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.nIa.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.nIa, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.nHY.setText(spannableString);
        this.nHY.setMovementMethod(LinkMovementMethod.getInstance());
        this.nHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nIb) {
                    WriteActivity.this.nIb = false;
                    WriteActivity.this.nHX.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.nIb = true;
                    WriteActivity.this.nHX.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.nIb) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.oo(R.color.cp_cont_b);
                    aVar.AZ("");
                    aVar.Ba(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.op(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bmC();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.nIb = true;
            this.nHX.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.nIb = false;
            this.nHX.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.nIa.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void yw(boolean z) {
                if (z) {
                    if (!WriteActivity.this.nIb) {
                        WriteActivity.this.nIb = true;
                        WriteActivity.this.nHX.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.nIb) {
                    WriteActivity.this.nIb = false;
                    WriteActivity.this.nHX.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dTo() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.nIj = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.nHg = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.nHg, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.nHg.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nHg.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.nHg.setLayoutParams(layoutParams2);
        this.nHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dTp();
            }
        });
        this.nHg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTp() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dRI() {
        if (this.mName != null && this.mGf != null && this.mGf.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dSI() {
        String str;
        String str2;
        if (this.mGf != null) {
            switch (this.mGf.getType()) {
                case 0:
                case 9:
                    if (this.nGX || this.nGl) {
                        if (this.nGZ) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jff != null && this.jff.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nDF) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.jff != null && this.jff.equals("2")) {
                        if (StringUtils.isNull(this.mGf.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mGf.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mGf.getForumName() + getResources().getString(R.string.bar));
                        this.mGy.setVisibility(8);
                        String str3 = this.izm + " " + this.izk;
                        if (!StringUtils.isNull(str3)) {
                            this.nGo.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.mGy.setVisibility(0);
                    this.nGo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nGo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mGy.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nGo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mGf.getFloorNum() + 1)));
                    this.nHr.setVisibility(8);
                    return;
                case 7:
                    this.mGy.setVisibility(0);
                    this.nGo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dSJ() {
        if (this.mGf.getType() == 7) {
            this.lqK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lqK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dSK() {
        if (this.mGf != null && this.mGf.getType() == 0 && this.mGf.getType() == 9 && !this.nGX && !this.nGl && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dSS() != null) {
                dSS().setText(cutStringWithSuffix);
                dSS().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.lpR.setVisibility(0);
            this.lpS.setVoiceModel(voiceModel);
            this.lpS.bWJ();
            dDY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diK() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Cn(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.lpR.setVisibility(8);
        this.lpS.cHM();
        this.lpS.setVoiceModel(null);
        com.baidu.tbadk.editortools.m ra = this.fhB.ra(6);
        if (ra != null && ra.fhv != null) {
            ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dDY();
    }

    private void dSL() {
        this.gpa = null;
        this.nGz = -1;
        this.nGB = -1;
        com.baidu.tieba.frs.ah yR = ag.cxN().yR(1);
        if (yR != null) {
            this.gpa = yR.iFU;
            this.nGz = getIntent().getIntExtra("category_id", -1);
            if (this.gpa != null && !this.gpa.isEmpty() && this.nGz >= 0) {
                this.nGy = new af();
                this.nGy.iFQ = 0;
                this.nGy.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nGB = this.nGy.iFQ;
                this.nGA = this.nGy.name;
                for (af afVar : this.gpa) {
                    if (afVar.iFQ == this.nGz) {
                        this.nGB = afVar.iFQ;
                        this.nGA = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dSM() {
        if (this.gpa != null && !this.gpa.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nGC = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nGC.setText(this.nGA);
            this.nGC.setCategoryContainerData(this.gpa, this.nGy, this.nGB);
            this.nGC.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.nGC.setText(bfVar.name);
                        WriteActivity.this.mGf.setCategoryTo(bfVar.iFQ);
                        WriteActivity.this.nGB = bfVar.iFQ;
                        WriteActivity.this.nGC.dSd();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.nGC.dSc();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSS());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSR());
                }
            });
        }
    }

    private void dTq() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nGR = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nGR.setTitle(R.string.no_disturb_start_time);
        this.nGR.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nGR);
        this.nGR.setButton(-2, getPageContext().getString(R.string.cancel), this.nGR);
        return this.nGR;
    }

    private void dSN() {
        this.nGu = (RelativeLayout) findViewById(R.id.addition_container);
        this.nGv = (TextView) findViewById(R.id.addition_create_time);
        this.nGw = (TextView) findViewById(R.id.addition_last_time);
        this.nGx = (TextView) findViewById(R.id.addition_last_content);
        if (this.nGt != null) {
            this.nGu.setVisibility(0);
            this.nGv.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.nGt.getCreateTime() * 1000));
            if (this.nGt.getAlreadyCount() == 0) {
                this.nGw.setVisibility(8);
            } else {
                this.nGw.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.nGt.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nGt.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nGx.setText(lastAdditionContent);
            } else {
                this.nGx.setVisibility(8);
            }
            dSR().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nGt.getAlreadyCount()), Integer.valueOf(this.nGt.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nGu.setVisibility(8);
    }

    private void dDW() {
        this.mGG = findViewById(R.id.post_prefix_layout);
        if (this.nHL == null) {
            this.nHL = new com.baidu.tieba.c.e(getPageContext(), this.mGG);
            this.nHL.fh(R.drawable.bg_tip_blue_up_left);
            this.nHL.fg(16);
            this.nHL.ox(true);
            this.nHL.setUseDirectOffset(true);
            this.nHL.xd(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.mGD = (TextView) findViewById(R.id.post_prefix);
        this.nGq = findViewById(R.id.prefix_divider);
        this.mGF = (ImageView) findViewById(R.id.prefix_icon);
        dTr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTr() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mGG.setVisibility(0);
            this.nGq.setVisibility(0);
            this.nHL.y(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mGg = 0;
            this.mGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dR("fid", WriteActivity.this.mGf.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mGD.setVisibility(0);
                    WriteActivity.this.mGG.setSelected(true);
                    SvgManager.boN().a(WriteActivity.this.mGF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mGE, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fhB.bvv();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mGy);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nGo);
                }
            });
            this.mGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dR("fid", WriteActivity.this.mGf.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mGD.setSelected(true);
                    SvgManager.boN().a(WriteActivity.this.mGF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mGE, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fhB.bvv();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSS());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSR());
                }
            });
            this.mGE = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mGE.a(this);
            this.mGE.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mGE.setOutsideTouchable(true);
            this.mGE.setFocusable(true);
            this.mGE.setOnDismissListener(this);
            this.mGE.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.mGD, R.color.cp_bg_line_d);
            SvgManager.boN().a(this.mGF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.mGD.setTextColor(color);
            this.nGr.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nGr.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yk(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yk(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mGE.addView(writePrefixItemLayout);
            }
            this.mGE.setCurrentIndex(0);
            this.mGD.setText(prefixs.get(0));
            Ls(0);
            return;
        }
        this.mGG.setVisibility(8);
        this.nGq.setVisibility(8);
    }

    private void dTs() {
        if (this.nGX && this.mGf != null) {
            this.nHd.setVisibility(0);
            this.nHe.setVisibility(0);
            this.nGp = new FeedBackModel(getPageContext());
            this.nGp.UG(this.mGf.getForumName());
            this.nGp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.nHd.setVisibility(8);
                        WriteActivity.this.nHe.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.nHd.setVisibility(8);
                        WriteActivity.this.nHe.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.nHd.a(feedBackModel.dSl(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dSO() {
        this.lqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nHN == null || WriteActivity.this.nHO != null) {
                    if (WriteActivity.this.dTL()) {
                        if (!WriteActivity.this.nId || WriteActivity.this.nIb) {
                            if (WriteActivity.this.dTN()) {
                                int dTM = WriteActivity.this.dTM();
                                if (dTM == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dTM == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.nGJ.a(WriteActivity.this.mGy, WriteActivity.this.nGo)) {
                                    WriteActivity.this.showToast(WriteActivity.this.nGJ.dQv());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSS());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dSR());
                                WriteActivity.this.fhB.bvv();
                                if (WriteActivity.this.mGf.getType() != 7) {
                                    if (WriteActivity.this.nGX) {
                                        WriteActivity.this.czX();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.aj("obj_type", StringUtils.isNull(WriteActivity.this.mGf.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.dSX();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.czX();
                                }
                                MercatorModel.dIs().startLoad();
                                TiebaStatic.log(new aq("c12262").dR("obj_locate", WriteActivity.this.jff));
                                return;
                            }
                            return;
                        }
                        WriteActivity.this.showToast(WriteActivity.this.getResources().getString(R.string.publish_faile_toast));
                        return;
                    }
                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_cant_but_commodity));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectForumConfig(WriteActivity.this)));
            }
        });
    }

    protected void dDX() {
        this.nHb = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.nHb.setIsRound(true);
        this.nHb.setDrawBorder(false);
        this.nHb.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String Bx = q.Bx(currentPortrait);
            this.nHb.setUrl(Bx);
            this.nHb.startLoad(Bx, 12, false);
        }
        if (this.mGf.isUserFeedback()) {
            this.nHb.setVisibility(0);
        }
        this.mGy = (EditText) findViewById(R.id.post_title);
        this.mGy.setOnClickListener(this.nGN);
        this.mGy.setOnFocusChangeListener(this.gWj);
        if (this.mGf.getType() == 0 || this.mGf.getType() == 9 || this.mGf.getType() == 7) {
            if (this.mGf.getTitle() != null) {
                this.mGy.setText(this.mGf.getTitle());
                this.mGy.setSelection(this.mGf.getTitle().length());
            } else if (this.nGZ) {
                this.mGy.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mGf.getType() == 1 || this.mGf.getType() != 2) {
        }
        this.mGy.addTextChangedListener(this.nGP);
        if (!this.mGf.getHaveDraft()) {
            dSK();
            this.nHG = true;
        }
        this.nHa = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher atP() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int nIn;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dDY();
                if (WriteActivity.this.nGE) {
                    this.nIn = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.nIn);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.nGE || !WriteActivity.this.nHy) {
                    if (WriteActivity.this.nGE) {
                        if (this.mEditText != WriteActivity.this.nHp || this.mTextView != WriteActivity.this.nHv) {
                            this.mEditText = WriteActivity.this.nHp;
                            this.mTextView = WriteActivity.this.nHv;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.nHt || this.mTextView != WriteActivity.this.nHu) {
                    this.mEditText = WriteActivity.this.nHt;
                    this.mTextView = WriteActivity.this.nHu;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.nGE && this.nHy) {
            if (this.nHw != null) {
                this.nHt.removeTextChangedListener(this.nHw);
            }
            this.nHw = textWatcher;
        } else if (this.nGE) {
            if (this.nHx != null) {
                this.nHp.removeTextChangedListener(this.nHx);
            }
            this.nHx = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.nHp) {
            return 233L;
        }
        if (editText != this.nHt) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long k = j - k(editText);
            String valueOf = String.valueOf(k);
            if (j == 20) {
                if (k < 0) {
                    if (k < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ap.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(ap.getColor(R.color.cp_cont_d));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ap.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ap.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.t(editText.getText().toString().trim());
    }

    protected void dDZ() {
        this.nGo = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nGo.setDrawingCacheEnabled(false);
        this.nGo.setOnClickListener(this.nGN);
        this.nGo.setOnSpanGroupChangedListener(new a.InterfaceC0570a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0570a
            public void G(int i, boolean z) {
                WriteActivity.this.Lz();
            }
        });
        this.nGo.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.nGo.setForumId(com.baidu.adp.lib.f.b.toLong(this.mGf.getForumId(), 0L));
        this.nGo.setTransLink(!this.nDF);
        if (this.fjQ != null) {
            this.fjQ.setSpanGroupManager(this.nGo.getSpanGroupManager());
        }
        if (this.mGf != null) {
            this.mGf.setSpanGroupManager(this.nGo.getSpanGroupManager());
        }
        if (this.mGf.getContent() != null && this.mGf.getContent().length() > 0) {
            this.nGo.setText(TbFaceManager.byD().aw(getPageContext().getPageActivity(), this.mGf.getContent()));
            if (this.nGo.getText() != null) {
                this.nGo.setSelection(this.nGo.getText().length());
            }
        } else if (this.mGf.getType() == 2) {
            if (this.nHh) {
                if (this.nHi != null && this.nHi.length() > 0) {
                    this.nGo.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.nHi}));
                    this.nGo.setSelection(this.nGo.getText().length());
                }
            } else if (this.mGf.getFloorNum() > 0) {
                this.nGo.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mGf.getFloorNum())));
                this.nGo.setSelection(this.nGo.getText().length());
            }
        }
        this.nGo.setOnFocusChangeListener(this.gWj);
        this.nGo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.nGo.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nGo.addTextChangedListener(this.nGQ);
        if (this.mGf.getType() == 0) {
            this.nHK = true;
        } else {
            yB(true);
            this.nHK = false;
        }
        if (this.mGf.isUserFeedback()) {
            this.nGo.setHint(R.string.write_input_content);
        } else {
            this.nGo.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void yB(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.nGE && !this.nDF && dSR() != null) {
            dSR().setPadding(0, 0, 0, 0);
            dSR().setBackgroundDrawable(null);
            ap.setBackgroundColor(dSR(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.kIM) || this.nGt != null) {
                return;
            }
            if (this.nHQ == null || !this.nHQ.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.kIM, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass42) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.nHQ == null || !WriteActivity.this.nHQ.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dSR().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dSR(), true, WriteActivity.this.lwP);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, true));
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    private void dTt() {
        if (dSR() != null) {
            dSR().setPadding(0, 0, 0, 0);
            dSR().setBackgroundDrawable(null);
            ap.setBackgroundColor(dSR(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dSQ() {
        int i = 5000;
        if (this.nGt != null) {
            i = 1000;
        }
        return dSR().getText() != null && dSR().getText().length() >= i;
    }

    private void Dv(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nGi)) {
                this.nGi = "";
                dSR().requestFocus();
                if (dSR().getText() != null && dSR().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dSR().getSelectionStart();
                    editable = dSR().getText();
                }
            } else if ("from_title".equals(this.nGi)) {
                this.nGi = "";
                dSS().requestFocus();
                if (dSS().getText() != null && dSS().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dSS().getSelectionStart();
                    editable = dSS().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mGf != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mGf.getForumId(), 0L), this.mGf.getFirstDir(), this.mGf.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dSR().getText().getSpans(0, dSR().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nGs == null) {
                this.nGs = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.nGs.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dSR());
    }

    EditText dSR() {
        return this.nGE ? this.nHp : this.nGo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dSS() {
        return this.nGE ? this.nHt : this.mGy;
    }

    protected void dST() {
        if (dSR().getSelectionStart() > 0) {
            String substring = dSR().getText().toString().substring(0, dSR().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.f3int.matcher(substring);
            if (matcher.find()) {
                dSR().getText().delete(dSR().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dSR().getSelectionStart());
                return;
            }
            dSR().onKeyDown(67, this.inu);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.mGf != null) {
            str = this.mGf.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.nGX = true;
        }
    }

    private void dTu() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dTv() {
        this.nHS = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.nHR = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.nHS);
        ao(getIntent());
    }

    private void bNd() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.nHV = new d(getPageContext());
        this.nHV.a(this.nHU);
        this.mListView.setAdapter((ListAdapter) this.nHV);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.nHV != null && (WriteActivity.this.nHV.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.nHV.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.eut == 1) {
                            be.boR().b(WriteActivity.this.getPageContext(), new String[]{tVar.eul});
                        } else {
                            be.boR().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eul)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.euo)) {
                            if (tVar.euo.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, tVar.euo));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.euo));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.eup)) {
                                be.boR().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eup)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.eup)) {
                            be.boR().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eup)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fsa.setCancelListener(null);
        this.fsa.setTipString(R.string.sending);
        this.fsa.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fsa.setDialogVisiable(false);
    }

    private Boolean dTw() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.nHj = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.fjU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.nHj);
    }

    public void dDY() {
        this.nHT = false;
        if (this.mGf != null) {
            String str = "";
            String str2 = "";
            if (dSS() != null) {
                str = dSS().getText().toString();
            }
            if (dSR() != null) {
                str2 = dSR().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mGf.getType() == 0 || this.mGf.getType() == 9 || this.mGf.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.mGg == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mGf.setIsNoTitle(true);
                        } else if (this.nGn.getVisibility() == 0) {
                            this.mGf.setIsNoTitle(false);
                            yz(true);
                            return;
                        }
                    } else if (this.nGn.getVisibility() == 0) {
                        this.mGf.setIsNoTitle(false);
                        yz(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mGf.setIsNoTitle(true);
                } else if (this.nGn.getVisibility() == 0) {
                    this.mGf.setIsNoTitle(false);
                    yz(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nGE) {
                    yz(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yz(true);
                }
            }
            if (this.mGf.getType() == 4) {
                yz(m(this.nHp) && l(this.nHt));
            } else if (this.mGf.getType() == 5) {
                yz(m(this.nHp));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                yz(true);
            } else if (this.mGf.getVideoInfo() != null) {
                yz(this.mGf.getVideoInfo().isVideoMixFinished());
            } else if (dTJ()) {
                yz(true);
                this.nHT = true;
            } else {
                yz(false);
            }
        }
    }

    public void yz(boolean z) {
        this.lqK.setEnabled(z);
    }

    private boolean l(EditText editText) {
        long k = k(editText);
        return k <= 20 && k > 0;
    }

    private boolean m(EditText editText) {
        long k = k(editText);
        if (k > 233) {
            return false;
        }
        return k > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String str;
        this.fjQ = new NewWriteModel(this);
        this.fjQ.b(this.fke);
        registerListener(this.nIe);
        registerListener(this.nIf);
        registerListener(this.nIg);
        this.isi = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.46
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dDQ();
            }
        };
        this.mGf = new WriteData();
        if (bundle != null) {
            this.mGf.setType(bundle.getInt("type", 0));
            this.mGf.setForumId(bundle.getString("forum_id"));
            this.mGf.setForumName(bundle.getString("forum_name"));
            this.mGf.setFirstDir(bundle.getString("forum_first_dir"));
            this.mGf.setSecondDir(bundle.getString("forum_second_dir"));
            this.mGf.setThreadId(bundle.getString("thread_id"));
            this.mGf.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mGf.setFloorNum(bundle.getInt("floor_num", 0));
            this.nGX = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.nGY = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nGZ = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nHh = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nHi = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fjO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nGt = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mGf.setIsAddition(this.nGt != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.nHk = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mGf.setTitle(bundle.getString("write_title"));
            this.mGf.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mGf.setTopicId(this.mTopicId);
            this.jff = bundle.getString("KEY_CALL_FROM");
            this.bxM = bundle.getInt("album_thread");
            this.nzI = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mGf.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mGf.setType(intent.getIntExtra("type", 0));
            this.mGf.setForumId(intent.getStringExtra("forum_id"));
            this.mGf.setForumName(intent.getStringExtra("forum_name"));
            this.mGf.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mGf.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mGf.setThreadId(intent.getStringExtra("thread_id"));
            this.mGf.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mGf.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nGX = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.nGY = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nGZ = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nHh = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nHi = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.nGt = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mGf.setIsAddition(this.nGt != null);
            this.mGf.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.nHk = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.izl = intent.getStringExtra("more_forum_img");
            this.izm = intent.getStringExtra("more_forum_title");
            this.izk = intent.getStringExtra("more_forum_url");
            this.mGf.setTitle(intent.getStringExtra("write_title"));
            this.mGf.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mGf.setTopicId(this.mTopicId);
            this.jff = intent.getStringExtra("KEY_CALL_FROM");
            this.bxM = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nzI = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mGf.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mGf.mDynamicImageTextData = new ImageTextUploadData();
            this.nDF = true;
        }
        if (this.mGf.getType() == 9) {
            this.mGf.setEntranceType(1);
        } else if (this.mGf.getType() == 10) {
            this.mGf.setEntranceType(2);
            this.mGf.setType(9);
        } else if (this.mGf.getType() == 0) {
            this.mGf.setEntranceType(3);
        }
        this.mGf.setIsUserFeedback(this.nGX);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mGf.getType() == 4 ? 6 : 9);
        this.mGf.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mGf.getType() == 0 || this.mGf.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nDF) {
                    x.d(this.mGf.getForumId(), this);
                } else {
                    x.c(this.mGf.getForumId(), this);
                }
            }
        } else if (this.mGf.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.mGf.getType() == 1) {
            x.a(this.mGf.getThreadId(), this);
        } else if (this.mGf.getType() == 4) {
            x.c(this.mGf.getForumId() + "photolive", this);
        } else if (this.mGf.getType() == 5) {
            x.a(this.mGf.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.kIM = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mGf != null && this.mGf.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mGf.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nGl = true;
        }
        dSL();
        try {
            this.nHz = dTF();
        } catch (Throwable th) {
            this.nHz = null;
        }
    }

    private void dSU() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mGy.setText(com.baidu.tbadk.plugins.b.Ea(com.baidu.tbadk.plugins.b.Eb(hotTopicBussinessData.mTopicName)));
            this.mGy.setMovementMethod(com.baidu.tieba.view.c.dPW());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ea = com.baidu.tbadk.plugins.b.Ea(com.baidu.tbadk.plugins.b.Eb(hotTopicBussinessData.mTopicName));
            if (Ea != null) {
                this.mGy.setText(Ea);
            }
            this.nGG.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.nId) {
            if (writeData != null) {
                if (this.mGf != null) {
                    boolean z = this.mGf.getVideoInfo() != null && this.mGf.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.mGf.getWriteImagesInfo() == null || y.isEmpty(this.mGf.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dSS().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dSR().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.byD().a(getPageContext().getPageActivity(), writeData.getContent(), this.nGL));
                    if (!z || z7) {
                        this.mGf.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.nHG || ((this.nGX || this.nGl) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.nGX || this.nGl)) {
                            j(writeData);
                        }
                        if (this.mGf != null && !this.mGf.getHaveDraft()) {
                            dSK();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dTx();
                        }
                        dDY();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.gpa != null) {
                            this.nGB = this.nGy.iFQ;
                            this.nGA = this.nGy.name;
                            while (true) {
                                if (i == this.gpa.size()) {
                                    break;
                                }
                                af afVar = this.gpa.get(i);
                                if (categoryTo != afVar.iFQ) {
                                    i++;
                                } else {
                                    this.nGB = categoryTo;
                                    this.nGA = afVar.name;
                                    this.mGf.setCategoryTo(this.nGB);
                                    break;
                                }
                            }
                            if (this.nGC != null) {
                                this.nGC.setText(this.nGA);
                                this.nGC.setCategoryContainerData(this.gpa, this.nGy, this.nGB);
                            }
                        }
                        this.fhB.bvv();
                        return;
                    }
                    return;
                }
                return;
            }
            dTx();
            dSK();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mGf.setVideoInfo(videoInfo);
            yA(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mGf.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dSZ();
        }
        yC(false);
        yA(true);
    }

    private void i(WriteData writeData) {
        String str;
        String Eb;
        if (com.baidu.adp.lib.util.k.isEmpty(this.mGf.getTitle())) {
            this.mGf.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Eb = this.mGf.getTitle();
            } else {
                Eb = com.baidu.tbadk.plugins.b.Eb(str);
            }
            SpannableString Ea = com.baidu.tbadk.plugins.b.Ea(Eb);
            if (Ea != null) {
                dSS().setText(Ea);
                dSS().setSelection(Ea.length() > Eb.length() ? Eb.length() : Ea.length());
                return;
            }
            return;
        }
        SpannableString Ea2 = com.baidu.tbadk.plugins.b.Ea(this.mGf.getTitle());
        if (Ea2 != null) {
            dSS().setText(Ea2);
            dSS().setSelection(this.mGf.getTitle().length() > Ea2.length() ? Ea2.length() : this.mGf.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.mGf.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.byD().a(getPageContext().getPageActivity(), this.mGf.getContent(), this.nGL);
        InputFilter[] filters = this.nGo.getFilters();
        this.nGo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dSR().setText(a2);
        if (dSR() == this.nGo && this.nGo.getSpanGroupManager() != null) {
            this.nGo.bqQ();
            this.nGo.getSpanGroupManager().bqW();
            this.nGo.bqR();
            Lz();
        }
        this.nGo.setFilters(filters);
        if (dSR().getText() != null) {
            dSR().setSelection(dSR().getText().length());
        }
        if (this.nGE) {
            a(this.nHv, this.nHp);
        }
    }

    private void dTx() {
        if ((!this.nGE || this.nHo != null) && this.nHn != null) {
            this.nHo.b(this.writeImagesInfo);
            dTB();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mGf.getType());
        bundle.putString("forum_id", this.mGf.getForumId());
        bundle.putString("forum_name", this.mGf.getForumName());
        bundle.putString("forum_first_dir", this.mGf.getFirstDir());
        bundle.putString("forum_second_dir", this.mGf.getSecondDir());
        bundle.putString("thread_id", this.mGf.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mGf.getFloor());
        bundle.putInt("floor_num", this.mGf.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.nHh);
        if (this.nGX) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fjO);
        if (this.nGt != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nGt));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.nHk);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jff);
        bundle.putInt("album_thread", this.bxM);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nzI);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dSR().getEditableText().toString();
        if (obj != null) {
            dSR().setText(TbFaceManager.byD().a(getPageContext().getPageActivity(), obj, this.nGL));
            dSR().setSelection(dSR().getText().length());
        }
    }

    private String getContent() {
        return (dSR() == null || dSR().getText() == null) ? "" : dSR().getText().toString();
    }

    private String dSW() {
        if (this.mGf == null || dSS() == null || dSS().getVisibility() != 0 || dSS().getText() == null) {
            return "";
        }
        String obj = dSS().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mGg != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mGf.getType() != 4 && this.mGD != null && this.mGD.getText() != null) {
            this.mGf.setPostPrefix(this.mGD.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mGf.getTitle();
        }
        return obj;
    }

    private void UH(String str) {
        if (this.mGf != null && this.nGn != null) {
            if (this.nGn.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mGf.setIsNoTitle(true);
                    this.mGf.setTitle("");
                    return;
                }
                this.mGf.setIsNoTitle(false);
                this.mGf.setTitle(str);
                return;
            }
            this.mGf.setIsNoTitle(true);
            this.mGf.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czX() {
        dDQ();
        this.mGf.setContent(getContent());
        UH(dSW());
        if (this.nGX || this.nGl) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mGf.getTitle()) || !this.mGf.getTitle().startsWith(string)) {
                UH(string + this.mGf.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mGf.getContent()) || !this.mGf.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    sb.append(com.baidu.adp.lib.util.j.netTypeNameInUpperCase());
                } else {
                    sb.append(RomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.mGf.getContent());
                this.mGf.setContent(sb.toString());
            }
        }
        if (this.nGY) {
            this.mGf.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.nGz >= 0) {
            this.mGf.setCategoryFrom(this.nGz);
        }
        if (this.nGB >= 0) {
            this.mGf.setCategoryTo(this.nGB);
        }
        this.mGf.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nHR != null) {
            this.mGf.setWriteVoteData(this.nHR.getWriteVoteData());
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i++;
                }
                i = i;
            }
            this.mGf.setTakePhotoNum(i);
        }
        this.mGf.setHasLocationData(this.fjP != null && this.fjP.cfL());
        if (this.writeImagesInfo != null) {
            this.fjQ.xp(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.nGF != null && this.nGF.mIsGlobalBlock == 0) {
            this.mGf.setForumId(String.valueOf(this.nGF.mForumId));
            this.mGf.setForumName(this.nGF.mForumName);
        }
        dRL();
        this.fjQ.e(this.mGf);
        this.mGf.setContent(this.mGf.getContent().replaceAll("\u0000\n", ""));
        this.mGf.setContent(this.mGf.getContent().replaceAll("\u0000", ""));
        this.mGf.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.fjQ.cVv().setVoice(this.mVoiceModel.getId());
                this.fjQ.cVv().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.fjQ.cVv().setVoice(null);
                this.fjQ.cVv().setVoiceDuringTime(-1);
            }
        } else {
            this.fjQ.cVv().setVoice(null);
            this.fjQ.cVv().setVoiceDuringTime(-1);
        }
        if (!this.fjQ.dIN()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mGf.mDynamicImageTextData != null) {
            dRK();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.isi);
            this.fjQ.dIK();
        }
    }

    private void dRL() {
        FrsTabItemData selectedTabItemData;
        if (this.mGf != null && this.nEb != null && (selectedTabItemData = this.nEb.getSelectedTabItemData()) != null) {
            this.mGf.setTabId(selectedTabItemData.tabId);
            this.mGf.setTabName(selectedTabItemData.name);
            this.mGf.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dRK() {
        if (this.mGf.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.mGf, new a.InterfaceC0858a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                @Override // com.baidu.tieba.write.b.a.InterfaceC0858a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dRt().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.47.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.czU();
                            x.e(WriteActivity.this.mGf.getForumId(), (WriteData) null);
                            WriteActivity.this.dTl();
                            com.baidu.tieba.write.b.a.dRn();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.kd(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dRn();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0858a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void H(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.nGt != null) {
                i2 = this.nGt.getTotalCount();
                i = this.nGt.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.mGy == getCurrentFocus()) {
                    dSR().clearFocus();
                    this.mGy.requestFocus();
                    if (this.fhB != null) {
                        this.fhB.bvv();
                    }
                    ShowSoftKeyPadDelay(this.mGy);
                } else {
                    dSR().requestFocus();
                    if (this.fhB != null) {
                        this.fhB.bvv();
                    }
                    ShowSoftKeyPadDelay(this.nGo);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append(UgcConstant.AT_RULE_TAG);
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            dSR().getText().insert(dSR().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                czU();
                dTl();
                m(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                dTC();
                            } else {
                                ar(intent);
                            }
                        } else if (intExtra == 1) {
                            as(intent);
                        } else {
                            ap(intent);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.48
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        yA(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.nHK) {
                            yB(true);
                            this.nHK = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.nGE) {
                        F(intent);
                        dDY();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mGf.setVideoInfo(videoInfo);
                        this.fhB.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fhB.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fhB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dDY();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.nGj) {
                                sb2.append(com.baidu.tbadk.plugins.b.frt);
                                this.nGj = false;
                            }
                            sb2.append(stringExtra);
                            Dv(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.nGF = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.nGF);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.nGo.getSelectionStart();
                    int selectionEnd = this.nGo.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.nGo.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fhB != null && !this.fhB.bxc()) {
                this.nGo.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fhB.bvv();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bxO();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dTA();
                    if (this.nHK) {
                        yB(true);
                        this.nHK = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.mGy == getCurrentFocus()) {
                        dSR().clearFocus();
                        this.mGy.requestFocus();
                        if (this.fhB != null) {
                            this.fhB.bvv();
                        }
                        ShowSoftKeyPadDelay(this.mGy);
                        return;
                    }
                    dSR().requestFocus();
                    if (this.fhB != null) {
                        this.fhB.bvv();
                    }
                    ShowSoftKeyPadDelay(this.nGo);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.nGJ.Uj(postWriteCallBackData.getErrorString());
                        this.nGJ.bk(postWriteCallBackData.getSensitiveWords());
                        this.nGJ.b(this.mGy, this.nGo);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fjO = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fjO);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dTA();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nGi)) {
                        dSS().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nGi)) {
                        dSR().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSX() {
        if ("1".equals(this.jff)) {
            this.mGf.setCanNoForum(true);
            this.mGf.setTransmitForumData("[]");
        } else if ("2".equals(this.jff)) {
            this.mGf.setCanNoForum(false);
        }
        dSY();
        this.mGf.setPrivacy(this.isPrivacy);
        dTy();
        this.mGf.setToDynamic(this.isToDynamic);
        this.mGf.setCallFrom(this.jff);
        if (this.mGf.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        czX();
    }

    private void dSY() {
        if (this.fhB != null) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dTy() {
        if (this.fhB != null) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dTz() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dTA() {
        if (this.nGE) {
            this.nHo.b(this.writeImagesInfo);
            dTB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTB() {
        this.nHo.notifyDataSetChanged();
        this.nHn.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.nHo.notifyDataSetChanged();
                WriteActivity.this.nHn.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        dDY();
    }

    private void ap(Intent intent) {
        if (this.nGE) {
            aq(intent);
            dTA();
        } else {
            at(intent);
        }
        dDY();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dTA();
            yC(true);
        }
    }

    private void ar(Intent intent) {
        if (this.writeImagesInfo != null) {
            E(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dTC() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.nHl.parseJson(stringExtra);
            this.nHl.updateQuality();
            if (this.nHl.getChosedFiles() != null && this.nHl.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.nHl.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.nHl.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dSS());
        HidenSoftKeyPad(this.mInputManager, dSR());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.nHQ != null) {
            this.nHQ.onPause();
        }
        if (this.fhB.bxc()) {
            this.fhB.bvv();
        }
    }

    private void at(Intent intent) {
        d(intent, true);
    }

    private void E(Intent intent) {
        this.fjO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fjO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fjO, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dTD();
            dSZ();
        }
        yC(true);
    }

    private void F(Intent intent) {
        d(intent, false);
    }

    private void d(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dTD();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dSZ();
                }
            }
            yC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dTD() {
        if (this.fhB.ra(10) != null) {
            this.fhB.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bxO() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.50
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fjO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dTE() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.izl)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.izl, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.51
                    @Override // com.baidu.tbadk.util.p.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.p.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.yC(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC(boolean z) {
        String forumId = this.mGf == null ? "" : this.mGf.getForumId();
        if (this.nHm != null) {
            this.nHm.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cwj() {
        this.iBr = getVoiceManager();
        this.iBr.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iCN) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mGf.getType() != 7) {
                if (this.nGt == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                H(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fjV = i;
        if (this.fhB != null) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dSZ() {
        if (!this.nGE) {
            if (this.fhB != null) {
                this.fhB.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fhB.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mGf == null ? "" : this.mGf.getForumId();
            if (this.nHm != null) {
                this.nHm.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (this.fhB != null) {
            this.fhB.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ls(int i) {
        if (i < this.nGr.size()) {
            for (int i2 = 0; i2 < this.nGr.size(); i2++) {
                this.nGr.get(i2).yl(false);
            }
            this.nGr.get(i).yl(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void IU(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").aj("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").aj("obj_type", 2));
        }
        this.mGg = i;
        this.mGE.setCurrentIndex(i);
        Ls(i);
        this.mGD.setText(this.mPrefixData.getPrefixs().get(i));
        dDY();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mGE, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mGG.setSelected(false);
        SvgManager.boN().a(this.mGF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.nGo);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.mGf != null) {
            if (this.mGf.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mGf.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            bxI();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fjO);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blF = z;
        if (this.nHE && System.currentTimeMillis() - this.nHF < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.nHE = false;
        }
        if (this.nGI != null && !z) {
            this.nGI.cpK();
        }
        if (this.nGK != null && !z) {
            dSC();
        }
        if (this.nHM != null && !z) {
            dTh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UI(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.nHB != null) {
            UJ(str);
            this.nHB.dismiss();
        }
    }

    private void ge(Context context) {
        nHD = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void UJ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.nHE = true;
        dTD();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dSZ();
        }
        yC(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5418=4] */
    private static Bitmap h(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap = null;
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap2 = BitmapHelper.getResizedBitmap(bitmap, i);
                if (bitmap != null && bitmap != bitmap2 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return bitmap2;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap2;
    }

    private File dTF() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
        String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("_data"));
                File file = new File(string);
                if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                    break;
                }
                String upperCase = string.toUpperCase();
                if (upperCase.contains("DCIM/CAMERA") || upperCase.contains("DCIM/100ANDRO") || upperCase.contains("DCIM/100MEDIA") || upperCase.contains("SCREENSHOTS") || upperCase.contains(name.toUpperCase()) || upperCase.contains(name2.toUpperCase())) {
                    return file;
                }
                query.moveToNext();
            }
            return null;
        } finally {
            query.close();
        }
    }

    private void dTG() {
        if (this.nHz != null && this.mGf.getType() == 0 && this.mGf.getType() == 9) {
            ge(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.nHz != null) {
                        WriteActivity.this.UI(WriteActivity.this.nHz.getAbsolutePath());
                    }
                }
            });
            this.nHA = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.nHC = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.nHz.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.nHz.getAbsolutePath());
                Bitmap h = h(this.nHz.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.nHA.setImageBitmap(h);
                    this.nHA.setDrawBorder(true);
                    this.nHA.setBorderWidth(2);
                    this.nHA.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.nHB = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.nHB.setCanceledOnTouchOutside(true);
                    this.nHB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.nHE) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.nHF = System.currentTimeMillis();
                            }
                        }
                    });
                    this.nHB.setContentView(this.mBubbleView);
                    this.nHB.show();
                    Window window = this.nHB.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (nHD / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
                    attributes.width = getResources().getDimensionPixelSize(R.dimen.ds168);
                    attributes.height = getResources().getDimensionPixelSize(R.dimen.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.blF && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nGj = false;
            this.nGi = "";
            if ("from_content".equals(str)) {
                this.nGi = "from_content";
            } else if ("from_title".equals(str)) {
                this.nGi = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DZ(String.valueOf(charSequence.charAt(i)))) {
                yy(false);
            }
        }
    }

    public void dyx() {
        if (com.baidu.tieba.write.c.b.dRC()) {
            this.mGy.setHint(R.string.title_hint_for_hot);
            this.nGn.setVisibility(0);
            this.nHc.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.nHa);
            this.nGn.requestFocus();
            return;
        }
        this.nHa.setVisibility(8);
        this.mGy.setHint(this.nGX ? R.string.feedback_title_hint : R.string.post_title_hint);
        if (this.nGX || !y.isEmpty(this.mList) || (this.mGf != null && !StringUtils.isNull(this.mGf.getTitle()))) {
            this.nGn.setVisibility(0);
            this.nHc.setVisibility(0);
            this.nGn.requestFocus();
            return;
        }
        this.nGn.setVisibility(8);
        this.nHc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTH() {
        if (this.fhB != null) {
            this.fhB.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nDF && WriteActivity.this.fhB != null && WriteActivity.this.fhB.fhE != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.boR().k(clipBoardContent)) {
                            WriteActivity.this.nGI.dqY();
                            return;
                        }
                        if (WriteActivity.this.nER == null) {
                            WriteActivity.this.nER = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.nIh);
                        }
                        WriteActivity.this.nER.a(WriteActivity.this.fhB.fhE.qY(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jff;
    }

    public WriteData cVv() {
        return this.mGf;
    }

    public FrsTabInfoData dTI() {
        return this.nzI;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dTJ() {
        return (this.nHR == null || this.nHS == null || this.nHR.getWriteVoteData() == null || this.nHS.getVisibility() != 0) ? false : true;
    }

    public void dQD() {
        if (this.mGf != null) {
            TiebaStatic.log(new aq("c13897").aj("obj_locate", 2).dR("fid", this.mGf.getForumId()).dR("fname", this.mGf.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.op(2);
            aVar.iN(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").aj("obj_locate", 2).dR("fid", WriteActivity.this.mGf != null ? WriteActivity.this.mGf.getForumId() : "").dR("fname", WriteActivity.this.mGf != null ? WriteActivity.this.mGf.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dTK()));
                    }
                }
            });
            aVar.bb(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").aj("obj_locate", 2).dR("fid", this.mGf != null ? this.mGf.getForumId() : "").dR("fname", this.mGf != null ? this.mGf.getForumName() : ""));
            aVar.b(getPageContext()).bmC();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dTK()));
    }

    public void Lz() {
        if (this.nHV != null && this.nHV.dSn() == null && this.nGo != null && this.nGo.getSpanGroupManager() != null) {
            this.nHV.h(this.nGo.getSpanGroupManager().brb());
            this.nHV.refreshData();
        } else if (this.nHV != null && this.nHV.dSn() != null) {
            this.nHV.refreshData();
        }
        if (this.nHV != null) {
            fX(this.nHV.dSm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(List<t> list) {
        boolean z;
        if (list != null) {
            Iterator<t> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().mType == 2) {
                    z = true;
                    break;
                }
            }
            if (!z && this.nHW != null) {
                this.nHW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UK(String str) {
        this.nHZ = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.nHZ.add(com.baidu.tieba.i.a.eb(jSONObject));
                }
                if (this.nHZ.size() > 0) {
                    this.nId = true;
                    this.nGo.l(this.nHZ, arrayList);
                    dTo();
                    Lz();
                    this.nHW.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dTK() {
        if (this.nGo == null || this.nGo.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.nGo.getSpanGroupManager().brc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTL() {
        return this.canGoods || this.nGo == null || this.nGo.getSpanGroupManager() == null || this.nGo.getSpanGroupManager().brc() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dTM() {
        boolean z = this.nHV == null || this.nHV.dSo();
        boolean z2 = (this.nEb == null || this.nEb.getSelectedTabItemData() == null || this.nEb.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTN() {
        if (this.nzI == null || y.isEmpty(this.nzI.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nzI.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dTO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.57
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yb(false).Uc(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aH((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
