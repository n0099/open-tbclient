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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0250a, VoiceManager.c, x.a, i.a {
    private static int nNx = 0;
    private EditorTools fnv;
    private String fpG;
    private LocationModel fpH;
    private NewWriteModel fpI;
    List<af> guN;
    private String iFh;
    private String iFi;
    private String iFj;
    private VoiceManager iHo;
    private com.baidu.tbadk.core.dialog.i iUn;
    private SaveDraftDialogView iUo;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout lvO;
    private PlayVoiceBntNew lvP;
    private ImageView lvR;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private TextView mMD;
    private com.baidu.tieba.write.i mME;
    private ImageView mMF;
    private View mMG;
    private int mMh;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nFC;
    private ForumTabSelectedView nJV;
    private FindNewLinkBubbleController nKL;
    private TextView nMA;
    private com.baidu.tieba.write.editor.b nMC;
    private g nME;
    private com.baidu.tieba.view.b nML;
    private TitleTipView nMU;
    private View nMW;
    private View nMY;
    private LinearLayout nMg;
    private LinearLayout nMh;
    private View nMk;
    private Toast nMm;
    private AdditionData nMn;
    private RelativeLayout nMo;
    private TextView nMp;
    private TextView nMq;
    private TextView nMr;
    af nMs;
    private int nMt;
    private String nMu;
    private int nMv;
    private PostCategoryView nMw;
    private HotTopicBussinessData nMz;
    private View nNB;
    private View nNC;
    private TextView nND;
    private com.baidu.tieba.c.e nNF;
    private b nNG;
    private ForumSelectedView nNH;
    private com.baidu.tbadk.data.i nNI;
    private View nNJ;
    private com.baidu.tieba.write.write.video.a nNK;
    private com.baidu.tieba.write.write.vote.a nNL;
    private RelativeLayout nNM;
    private boolean nNN;
    private d nNP;
    private LinearLayout nNQ;
    private ImageView nNR;
    private TextView nNS;
    private List<com.baidu.tieba.i.a> nNT;
    private EBusinessProtocolView nNU;
    private i nNg;
    private int privateThread;
    private String nMc = "";
    private boolean nMd = false;
    protected WriteData mMg = null;
    private boolean nMR = false;
    private boolean nMS = false;
    private boolean nMf = false;
    private boolean nMT = false;
    private InputMethodManager mInputManager = null;
    private EditText mMy = null;
    private HeadImageView nMV = null;
    private View mMz = null;
    private LinearLayout mMB = null;
    private SpanGroupEditText nMi = null;
    private FeedBackModel nMj = null;
    private FeedBackTopListView nMX = null;
    private ArrayList<WritePrefixItemLayout> nMl = new ArrayList<>();
    private String kOI = null;
    private final KeyEvent itr = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView nMZ = null;
    private TextView lwH = null;
    private TextView mName = null;
    private ImageView nNa = null;
    private DialogInterface.OnCancelListener iyf = null;
    private final Handler mHandler = new Handler();
    private boolean nNb = false;
    private String nNc = null;
    private RelativeLayout jVp = null;
    public boolean nNd = true;
    public String fpM = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fpN = 0;
    private int nNe = 0;
    private WriteImagesInfo nNf = new WriteImagesInfo();
    private View mRootView = null;
    private GridView nNh = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a nNi = null;
    private ScrollView nMx = null;
    private EditText nNj = null;
    private View nNk = null;
    private View nNl = null;
    private View nNm = null;
    private EditText nNn = null;
    private TextView nNo = null;
    private TextView nNp = null;
    private TextWatcher nNq = null;
    private TextWatcher nNr = null;
    private boolean nMy = false;
    private boolean nNs = false;
    private com.baidu.tbadk.core.view.a fxS = null;
    private String mFrom = "write";
    private File nNt = null;
    private TbImageView nNu = null;
    private View mBubbleView = null;
    private Dialog nNv = null;
    private LinearLayout nNw = null;
    private boolean nNy = false;
    private long nNz = -1000;
    private boolean nNA = false;
    private String jld = "2";
    private int bDX = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder nMB = new SpannableStringBuilder();
    private boolean nNE = false;
    private boolean bmZ = false;
    private final c nMD = new c();
    private boolean nJz = false;
    private final d.a nNO = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void LD(int i) {
            if (WriteActivity.this.nMi != null) {
                WriteActivity.this.nMi.qo(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void ge(List<t> list) {
            WriteActivity.this.gf(list);
        }
    };
    private boolean nNV = false;
    private int nNW = 0;
    private boolean nNX = false;
    private final HttpMessageListener nNY = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.kOI)) {
                    WriteActivity.this.kOI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.yK(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.kOI)) {
                    WriteActivity.this.kOI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.kOI);
                    WriteActivity.this.yK(true);
                }
            }
        }
    };
    private CustomMessageListener nNZ = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.mMg != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").al("obj_locate", 1).dR("fid", WriteActivity.this.mMg.getForumId()).dR("fname", WriteActivity.this.mMg.getForumName()));
            }
        }
    };
    private final CustomMessageListener nOa = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nNH != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                WriteActivity.this.nNI = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                if (WriteActivity.this.nNI != null && !StringUtils.isNull(WriteActivity.this.nNI.forumId) && !StringUtils.isNull(WriteActivity.this.nNI.forumName)) {
                    if (WriteActivity.this.mMg != null) {
                        WriteActivity.this.mMg.setForumId(WriteActivity.this.nNI.forumId);
                        WriteActivity.this.mMg.setForumName(WriteActivity.this.nNI.forumName);
                    }
                    WriteActivity.this.nNH.setSelectedForum(WriteActivity.this.nNI.forumName);
                    WriteActivity.this.nFC = null;
                    if (!y.isEmpty(WriteActivity.this.nNI.tabInfoList)) {
                        WriteActivity.this.nFC = new FrsTabInfoData();
                        WriteActivity.this.nFC.selectedTabId = -1;
                        WriteActivity.this.nFC.tabList = WriteActivity.this.nNI.tabInfoList;
                    }
                    WriteActivity.this.nJV.setData(WriteActivity.this.nFC);
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.nNI.fml != null && !y.isEmpty(WriteActivity.this.nNI.fml.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.nNI.fml;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.dVR();
                }
            }
        }
    };
    private TbFaceManager.a nMF = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan DZ(String str) {
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
    private final AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a nOb = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.58
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.nKL != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.nKL.Wt();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.59
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cyK();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.nOc = true;
            if (postWriteCallBackData != null && WriteActivity.this.mMg != null) {
                WriteActivity.this.nMD.bk(null);
                if (z) {
                    WriteActivity.this.km(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.mMg);
                    WriteActivity.this.cCv();
                    WriteActivity.this.dVL();
                    if ((WriteActivity.this.mMg.getType() == 0 || WriteActivity.this.mMg.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mMg.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mMg.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.mMg.getForumName())) {
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
                    WriteActivity.this.nMD.bk(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.nMD.UA(postWriteCallBackData.getErrorString());
                    WriteActivity.this.nMD.b(WriteActivity.this.mMy, WriteActivity.this.nMi);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bo(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bo(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bpc();
                    TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.buW());
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV());
                        if (WriteActivity.this.nMT) {
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
    private final LocationModel.a fpU = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bAw() {
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
    private final CustomMessageListener mZs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fpH.xw(false);
                    WriteActivity.this.fpH.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fpH.xw(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nMG = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dWh();
            }
        }
    };
    private final View.OnClickListener nMH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dUZ = WriteActivity.this.dUZ();
            if (dUZ >= 0 && dUZ < WriteActivity.this.nMi.getText().length()) {
                WriteActivity.this.nMi.setSelection(dUZ);
            }
        }
    };
    private boolean nMI = true;
    private final View.OnFocusChangeListener hcn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mMy || view == WriteActivity.this.mBack || view == WriteActivity.this.lwH) {
                if (z) {
                    WriteActivity.this.nMI = true;
                    WriteActivity.this.dVa();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mMy);
                    if (WriteActivity.this.fnv != null) {
                        WriteActivity.this.fnv.bxU();
                    }
                } else if (view == WriteActivity.this.mMy) {
                    WriteActivity.this.mMD.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.nMi && z) {
                WriteActivity.this.nMI = false;
                WriteActivity.this.dVa();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nMi);
                if (WriteActivity.this.fnv != null) {
                    WriteActivity.this.fnv.bxU();
                }
            }
            WriteActivity.this.dVf();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iGt = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Vb(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean nOc = false;
    private TextWatcher nMJ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String nMN = "";
        private String nMO;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nMO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nMO != null ? this.nMO.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dGA();
            WriteActivity.this.dVg();
            EditText dVs = WriteActivity.this.dVs();
            if (editable != null && dVs != null && dVs.getText() != null) {
                if (this.nMN == null || !this.nMN.equals(editable.toString())) {
                    if (WriteActivity.this.nMD != null) {
                        this.nMN = dVs.getText().toString();
                        WriteActivity.this.nMD.b(dVs, true);
                        return;
                    }
                    return;
                }
                dVs.setSelection(dVs.getSelectionEnd());
            }
        }
    };
    private TextWatcher nMK = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String nMO;
        private String nMP = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nMO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nMO != null ? this.nMO.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dGA();
            EditText dVr = WriteActivity.this.dVr();
            if (editable != null && dVr != null && dVr.getText() != null) {
                if (this.nMP == null || !this.nMP.equals(editable.toString())) {
                    if (WriteActivity.this.nMD != null) {
                        this.nMP = dVr.getText().toString();
                        WriteActivity.this.nMD.b(dVr, false);
                        return;
                    }
                    return;
                }
                dVr.setSelection(dVr.getSelectionEnd());
            }
        }
    };
    private int nOd = 0;
    private final a.InterfaceC0851a lCM = new a.InterfaceC0851a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0851a
        public void onRefresh() {
            WriteActivity.this.kOI = null;
            WriteActivity.this.yK(false);
            WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void bAf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bAh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH.dKH()) {
            bAf();
        } else {
            this.fpH.xw(false);
            a(1, true, (String) null);
            this.fpH.dKF();
        }
    }

    public void dVB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.nMC != null) {
                this.nMC.dTJ();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH != null) {
            this.fpH.xw(false);
            a(1, true, (String) null);
            this.fpH.dKF();
        }
    }

    private void bAj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ow(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fpH.dKJ();
                } else {
                    WriteActivity.this.fpU.bAw();
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
        aVar.bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dUZ() {
        int selectionEnd = dVr().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dVr().getText().getSpans(0, dVr().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dVr().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dVr().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVa() {
        if (this.fnv != null) {
            if (this.nNK != null && this.nNK.isVisible()) {
                this.fnv.setBarLauncherEnabled(!this.nMI);
                this.fnv.setDeskLauncherEnabled(!this.nMI);
                this.fnv.setToolEnabled(true, 2);
                this.fnv.setToolEnabled(true, 32);
                this.fnv.setToolEnabled(false, 10);
                this.fnv.setToolEnabled(false, 6);
                this.fnv.setToolEnabled(false, 18);
                this.fnv.rk(5).kf(false);
                if (this.nMC != null) {
                    this.nMC.yz(true);
                    return;
                }
                return;
            }
            this.fnv.setBarLauncherEnabled(!this.nMI);
            this.fnv.setDeskLauncherEnabled(this.nMI ? false : true);
            this.fnv.setToolEnabled(true, 26);
            this.fnv.setToolEnabled(true, 2);
            this.fnv.setToolEnabled(true, 30);
            this.fnv.rk(5).kf(true);
            if (this.nMC != null) {
                this.nMC.yz(true);
            }
            dWd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.nMy) {
            this.mMy.setVisibility(8);
            if (this.mMg.getType() == 5) {
                this.nNm.setVisibility(8);
            } else {
                this.nNm.setVisibility(0);
            }
            a(this.nNp, this.nNj);
            a(this.nNo, this.nNn);
            dGA();
        }
        if (this.nMR) {
            this.nMI = true;
            dVa();
            if (this.fnv != null) {
                this.fnv.bxU();
            }
            this.mMy.requestFocus();
            ShowSoftKeyPadDelay(this.mMy);
        }
        if (this.nNK != null) {
            this.nNK.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.nNK != null) {
            this.nNK.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.nNK != null) {
            this.nNK.onStop();
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
                    dVz();
                }
                yL(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mMg.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.mMg.setVideoInfo(null);
            }
            if (this.nNK == null) {
                this.nNK = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.mMg.getVideoInfo() != null && this.mMg.getVideoInfo().isEditVideoDataLegal()) {
                yJ(false);
                this.nNK.dWW();
                return;
            }
            yJ(true);
        }
    }

    public void EQ(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void yJ(boolean z) {
        if (z) {
            this.mMg.setVideoInfo(null);
            this.nNK.setVideoInfo(null);
            this.nNg.dWq().setVisibility(0);
            yK(false);
        } else {
            this.nNK.setVideoInfo(this.mMg.getVideoInfo());
            this.writeImagesInfo.clear();
            this.nNg.dWq().setVisibility(8);
            dVT();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dGA();
        dVa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mMg.getType() == 0) {
            LG(this.bDX);
        }
        initUI();
        dVS();
        this.fpH = new LocationModel(getPageContext());
        this.fpH.a(this.fpU);
        registerListener(this.mZs);
        registerListener(this.nMG);
        registerListener(this.mBackgroundListener);
        dWo();
        cXB();
        dWg();
        if (this.nMy) {
            this.nNi.setEditorTools(this.fnv);
        } else {
            this.nMi.requestFocus();
        }
        dAZ();
        dVz();
        dWe();
        this.iGt.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iGt);
        dVC();
    }

    private void dVC() {
        Vb(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cXB() {
        this.fnv = new EditorTools(getActivity());
        this.fnv.setBarMaxLauCount(5);
        this.fnv.setMoreButtonAtEnd(true);
        this.fnv.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.fnv.setBarLauncherType(1);
        this.fnv.kb(true);
        this.fnv.kc(true);
        switch (this.mMg.getType()) {
            case 4:
            case 5:
                dVF();
                break;
            default:
                dVb();
                break;
        }
        this.fnv.build();
        if (this.nMg != null) {
            this.nMg.addView(this.fnv);
        }
        cWT();
        this.fnv.display();
        com.baidu.tbadk.editortools.h rh = this.fnv.rh(6);
        if (rh != null && !TextUtils.isEmpty(this.fpM)) {
            ((View) rh).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fpM);
                }
            });
        }
        if (!this.nMy) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fnv.bxU();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dVG();
            return;
        }
        if (!this.nJz) {
            dVd();
        }
        dWh();
    }

    private void dVD() {
        this.nNk = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.nNm = this.nNk.findViewById(R.id.live_post_title_container);
        this.nNj = (EditText) this.nNk.findViewById(R.id.live_post_content);
        this.nNh = (GridView) this.nNk.findViewById(R.id.photoLiveGridView);
        this.nNn = (EditText) this.nNk.findViewById(R.id.live_post_title);
        this.nNo = (TextView) this.nNk.findViewById(R.id.titleOverPlusNumber);
        this.nNp = (TextView) this.nNk.findViewById(R.id.contentOverPlusNumber);
        this.nNl = this.nNk.findViewById(R.id.live_interval_view);
        this.nNo.setText(String.valueOf(20));
        this.nNp.setText(String.valueOf(233));
        this.nNk.setVisibility(0);
        this.nNo.setVisibility(0);
        this.nNp.setVisibility(0);
        this.nNn.setHint(R.string.tips_title_limit_new);
        this.nNn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nNs = true;
                    WriteActivity.this.nMI = true;
                    WriteActivity.this.dVa();
                    if (WriteActivity.this.fnv != null) {
                        WriteActivity.this.fnv.bxU();
                    }
                }
            }
        });
        if (this.mMg.getType() == 4) {
            this.nNj.setHint(R.string.live_write_input_content_new);
        } else if (this.mMg.getType() == 5) {
            this.nNj.setHint(R.string.live_write_input_content_update);
        }
        this.nNj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nNs = false;
                    WriteActivity.this.nMI = false;
                    WriteActivity.this.dVa();
                    if (WriteActivity.this.fnv != null) {
                        WriteActivity.this.fnv.bxU();
                    }
                }
            }
        });
        this.nNj.requestFocus();
        this.nNj.addTextChangedListener(awp());
        this.nNn.requestFocus();
        this.nNn.addTextChangedListener(awp());
        this.nNn.setOnClickListener(this.nMH);
        this.nNj.setOnClickListener(this.nMH);
        this.nNi = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.nNh);
        this.nNi.Lx(6);
        this.nNh.setAdapter((ListAdapter) this.nNi);
        View findViewById = this.nNk.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dUB() {
                WriteActivity.this.dWb();
            }
        });
        dVE();
    }

    private void dVE() {
        if (this.mMg.getType() == 0) {
            if (this.mMg.getTitle() != null) {
                this.nNn.setText(this.mMg.getTitle());
                this.nNn.setSelection(this.mMg.getTitle().length());
                return;
            }
            return;
        }
        if (this.mMg.getType() == 1 || this.mMg.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.nMy) {
            dVZ();
        }
        if (this.fnv.bzB()) {
            this.fnv.bxU();
        }
        LG(0);
    }

    public boolean dTy() {
        return !"1".equals(this.jld) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.nMD != null) {
                if (this.nMD.d(spannable)) {
                    return true;
                }
            }
            if (be.brr().m(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void LG(int i) {
        if (this.writeImagesInfo != null && this.mMg != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mMg.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mMg.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dTy());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jld);
            albumFloatActivityConfig.setProfessionZone(this.mMg.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nFC);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fpM;
            antiData.setIfVoice(this.nNd);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mMg.getFirstDir(), this.mMg.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dVF() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fnv.bA(arrayList);
        com.baidu.tbadk.editortools.m rk = this.fnv.rk(5);
        if (rk != null) {
            rk.foi = 2;
        }
        this.fnv.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fnv.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dVb() {
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
            this.fnv.b(dVar);
        }
        if (!this.nJz) {
            Boolean dVW = dVW();
            if (!this.nMR && dVW != null && dVW.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dLl() && com.baidu.tieba.tbadkCore.t.d(this.mMg.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.foi = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.fnv.b(mVar4);
                }
            }
        }
        if (!this.nJz && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.foi = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fnv.b(mVar3);
            }
        }
        if (!this.nJz && !com.baidu.tieba.write.c.b.dUc()) {
            this.fnv.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nJz) {
            this.fnv.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.fnv.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.jld, "2")) {
            this.fnv.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.fnv.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.nJz && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.fok = true;
            mVar2.foi = 9;
            mVar2.foc = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fnv.b(mVar2);
            }
        }
        if (!this.nJz && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.fok = true;
            mVar.foi = 10;
            mVar.foc = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fnv.b(mVar);
            }
        }
        if (!this.nJz && this.nMn == null) {
            if (this.nMC == null) {
                this.nMC = new com.baidu.tieba.write.editor.b(getActivity(), this.jld);
                this.nMC.Lq(0);
                this.nMC.yy(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nMC.dTH();
                this.nMC.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dVB();
            }
            if (!y.isEmpty(this.mList)) {
                this.nMC.dTH();
            }
            this.fnv.b(this.nMC);
        }
        if (!this.nJz && this.canGoods) {
            this.fnv.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fnv.bA(arrayList);
        com.baidu.tbadk.editortools.m rk = this.fnv.rk(5);
        if (rk != null) {
            rk.foi = 4;
        }
    }

    private void dVc() {
        if (this.nME != null) {
            this.nME.hideTip();
        }
    }

    private void dVG() {
        if (this.fnv != null) {
            this.fnv.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fnv != null && WriteActivity.this.fnv.fny != null) {
                        if (WriteActivity.this.nNG == null) {
                            WriteActivity.this.nNG = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.nNG.showTip(WriteActivity.this.fnv.fny.ri(2));
                    }
                }
            });
        }
    }

    private void dVH() {
        if (this.nNG != null) {
            this.nNG.hideTip();
        }
    }

    private void dVd() {
        if (this.nME == null) {
            this.nME = new g(getPageContext());
        }
        this.nME.d(this.fnv);
    }

    private void cWT() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").al("obj_locate", 9));
                        if (WriteActivity.this.dVq()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new aq("c12612").al("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof u)) {
                            u uVar = (u) aVar.data;
                            if (uVar.buM() == EmotionGroupType.BIG_EMOTION || uVar.buM() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.yL(true);
                                    WriteActivity.this.dGA();
                                }
                            } else if (WriteActivity.this.dVq()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dVt();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dlm();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dWd();
                        WriteActivity.this.dGA();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.LH(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.nMn == null) {
                            WriteActivity.this.bAk();
                            return;
                        }
                        switch (WriteActivity.this.fpN) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bAh();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bAf();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fpH != null) {
                            WriteActivity.this.fpH.xw(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.kOI = null;
                        } else {
                            WriteActivity.this.kOI = (String) aVar.data;
                        }
                        WriteActivity.this.yK(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dR("fid", WriteActivity.this.mMg != null ? WriteActivity.this.mMg.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.mMg == null || (videoInfo = WriteActivity.this.mMg.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fnv.bzB()) {
                                        WriteActivity.this.fnv.bxU();
                                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mMg.setVideoInfo(null);
                        WriteActivity.this.dGA();
                        if (WriteActivity.this.nMi != null) {
                            WriteActivity.this.nMi.requestFocus();
                        }
                        WriteActivity.this.fnv.bxU();
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nMi);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").al("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.nMd = true;
                        WriteActivity.this.yH(true);
                        if (!WriteActivity.this.dVs().isFocused() || WriteActivity.this.nMh.getVisibility() != 0) {
                            WriteActivity.this.nMc = "from_content";
                        } else {
                            WriteActivity.this.nMc = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").al("obj_locate", 8));
                        if (WriteActivity.this.nMh.getVisibility() == 0) {
                            if (WriteActivity.this.nMh.hasFocus()) {
                                WriteActivity.this.nMi.requestFocus();
                                WriteActivity.this.nMi.setSelection(WriteActivity.this.nMi.getText().toString().length());
                            }
                            WriteActivity.this.nMh.setVisibility(8);
                            WriteActivity.this.nMW.setVisibility(8);
                            WriteActivity.this.fnv.rh(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.nMh.setVisibility(0);
                            WriteActivity.this.nMW.setVisibility(0);
                            WriteActivity.this.nMh.requestFocus();
                            WriteActivity.this.fnv.rh(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dGA();
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
                            TiebaStatic.log(new aq("c12612").al("obj_locate", 10));
                            if (WriteActivity.this.nNL != null && WriteActivity.this.nNL.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.nNL.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new aq("c13800").al("obj_source", 2));
                        }
                        WriteActivity.this.dVI();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.nKL != null) {
                            WriteActivity.this.nKL.Wt();
                        }
                        TiebaStatic.log(new aq("c12612").al("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dTd();
                    }
                }
            }
        };
        this.fnv.setActionListener(16, bVar);
        this.fnv.setActionListener(14, bVar);
        this.fnv.setActionListener(24, bVar);
        this.fnv.setActionListener(3, bVar);
        this.fnv.setActionListener(10, bVar);
        this.fnv.setActionListener(11, bVar);
        this.fnv.setActionListener(12, bVar);
        this.fnv.setActionListener(13, bVar);
        this.fnv.setActionListener(15, bVar);
        this.fnv.setActionListener(18, bVar);
        this.fnv.setActionListener(20, bVar);
        this.fnv.setActionListener(25, bVar);
        this.fnv.setActionListener(27, bVar);
        this.fnv.setActionListener(29, bVar);
        this.fnv.setActionListener(43, bVar);
        this.fnv.setActionListener(56, bVar);
        this.fnv.setActionListener(48, bVar);
        this.fnv.setActionListener(46, bVar);
        this.fnv.setActionListener(49, bVar);
        this.fnv.setActionListener(47, bVar);
        this.fnv.setActionListener(55, bVar);
        this.fnv.setActionListener(58, bVar);
        this.fnv.setActionListener(22, bVar);
        this.fnv.setActionListener(21, bVar);
        this.fnv.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVI() {
        if (this.nNa != null) {
            this.nNa.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.nOd;
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
                        TiebaStatic.log(new aq("c13800").al("obj_source", 3));
                    }
                };
                this.nNL.ap(onClickListener);
                this.nNL.setOnItemClickListener(onClickListener);
                this.nNL.b(writeVoteData);
                this.nNL.yN(true);
                dGA();
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
    public void LH(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAk() {
        if (this.fpH.cin()) {
            if (this.fpH.dKH()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fpH.dKF();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dGs() {
        if (this.fpI != null) {
            this.fpI.cancelLoadData();
        }
        if (this.nMj != null) {
            this.nMj.cancelLoadData();
        }
        if (this.fpH != null) {
            this.fpH.cancelLoadData();
        }
        if (this.nNK != null) {
            this.nNK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nNZ);
        dVc();
        dVH();
        TiebaPrepareImageService.StopService();
        dGs();
        if (!this.nOc) {
            dVJ();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.iUn, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.nNg != null) {
            this.nNg.destroy();
        }
        if (this.nNF != null) {
            this.nNF.SR();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVJ() {
        if (this.mMg != null && this.mMg.getType() == 2 && this.nNb) {
            finish();
        } else if (this.mMg == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mMg.setTitle(dVs().getText().toString());
            this.mMg.setContent(dVr().getText().toString());
            int type = this.mMg.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nJz) {
                        x.e(this.mMg.getForumId(), this.mMg);
                    } else {
                        x.d(this.mMg.getForumId(), this.mMg);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.mMg);
                }
            } else if (type == 1) {
                x.f(this.mMg.getThreadId(), this.mMg);
            } else if (type == 4) {
                x.d(this.mMg.getForumId() + "photolive", this.mMg);
            } else if (type == 5) {
                x.f(this.mMg.getThreadId() + "updatephotolive", this.mMg);
            }
            this.nOc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVK() {
        if (this.lwH == null || !this.lwH.isEnabled() || this.nNN) {
            cCv();
            dVL();
            setResult(100);
            finish();
            return;
        }
        if (this.iUo == null) {
            this.iUo = new SaveDraftDialogView(this);
            this.iUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cCv();
                            WriteActivity.this.dVL();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dVJ();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.iUn.dismiss();
                    }
                }
            });
        }
        if (this.iUn == null) {
            this.iUn = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.iUn.setContentView(this.iUo);
        }
        boolean z = (this.nNK == null || !this.nNK.isVisible() || this.mMg == null || this.mMg.getVideoInfo() == null || this.mMg.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.iUo.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.iUn.Qj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCv() {
        if (this.mMg.getType() == 0 || this.mMg.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nJz) {
                    x.e(this.mMg.getForumId(), (WriteData) null);
                } else {
                    x.d(this.mMg.getForumId(), (WriteData) null);
                }
            }
        } else if (this.mMg.getType() == 1) {
            x.f(this.mMg.getThreadId(), (WriteData) null);
        }
        this.nOc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVL() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nlN));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mME != null && this.mME.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mME, getPageContext().getPageActivity());
                return true;
            } else if (this.fnv.bzB()) {
                this.fnv.bxU();
                return true;
            } else {
                dGs();
                dVK();
                return true;
            }
        }
        if (i == 67 && (text = dVr().getText()) != null) {
            int selectionStart = dVr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dVr().onKeyDown(67, this.itr);
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
        getLayoutMode().onModeChanged(this.jVp);
        getLayoutMode().onModeChanged(this.nNw);
        ap.setBackgroundColor(this.jVp, R.color.cp_bg_line_e);
        if (this.nNu != null && (i == 1 || i == 4)) {
            this.nNu.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lwH.setTextColor(ap.aP(R.color.cp_link_tip_a, i));
        dVa();
        ap.setBackgroundColor(this.mMz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.nNl, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dVs(), R.color.cp_bg_line_e);
        ap.setImageResource(this.lvR, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.kOI)) {
            ap.setBackgroundColor(dVr(), R.color.cp_bg_line_e);
        }
        dGA();
        this.fnv.onChangeSkinType(i);
        if (this.nMw != null) {
            this.nMw.bsD();
        }
        if (this.nNP != null) {
            this.nNP.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nNg.nOB.notifyDataSetChanged();
        dVf();
        dVg();
        yK(false);
        if (this.nMD != null) {
            this.nMD.c(dVs(), dVr());
        }
        if (this.nNH != null) {
            this.nNH.onChangeSkinType();
        }
        if (this.nJV != null) {
            this.nJV.onChangeSkinType(i);
        }
        if (this.nNK != null) {
            this.nNK.changeSkin();
        }
        if (this.nNL != null) {
            this.nNL.onChangeSkinType(i);
        }
        if (this.nNU != null) {
            this.nNU.onChangeSkinType(i);
        }
        if (this.nMU != null) {
            this.nMU.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVf() {
        if (this.mMy.hasFocus()) {
            this.mMy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mMy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.nMi.hasFocus()) {
            this.nMi.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.nMi.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVg() {
        if (this.mMy != null && this.mMy.getText() != null && this.mMy.getText().toString() != null && this.mMy.getPaint() != null) {
            if (this.mMy.getText().toString().length() == 0) {
                this.mMy.getPaint().setFakeBoldText(false);
            } else if (this.mMy.getText().toString().length() > 0) {
                this.mMy.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fxS = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nMy = this.mMg.getType() == 4 || 5 == this.mMg.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nMZ = (TextView) findViewById(R.id.btn_image_problem);
        dVj();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwH.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lwH.setLayoutParams(layoutParams);
        this.lwH.setOnFocusChangeListener(this.hcn);
        this.nMx = (ScrollView) findViewById(R.id.write_scrollview);
        this.nMx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.nMi != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.nMi);
                    }
                    if (WriteActivity.this.fnv != null) {
                        WriteActivity.this.fnv.bxU();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nMX = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.nMY = findViewById(R.id.feedback_divider);
        this.jVp = (RelativeLayout) findViewById(R.id.parent);
        this.nMg = (LinearLayout) findViewById(R.id.tool_view);
        this.nMg.setContentDescription(IStringUtil.TOP_PATH);
        this.nMh = (LinearLayout) findViewById(R.id.title_view);
        this.nMW = findViewById(R.id.title_view_divider);
        this.mMz = findViewById(R.id.interval_view);
        this.nNB = findViewById(R.id.hot_topic_fourm_view);
        this.nNC = findViewById(R.id.hot_topic_divider);
        this.nMA = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.nND = (TextView) findViewById(R.id.change_one_tv);
        dGz();
        if (this.nMy) {
            this.nMx.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dVD();
        } else {
            this.nNg = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nNg.yw(false);
            } else {
                this.nNg.yw(this.mMg.getType() == 0 || this.mMg.getType() == 9);
            }
            this.nNK = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.mMg.getVideoInfo() != null && this.mMg.getVideoInfo().isEditVideoDataLegal()) {
                yJ(false);
                this.nNK.dWW();
            } else {
                yJ(true);
            }
        }
        dGB();
        if (this.nMR || this.nMf) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eOr) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.mMB = (LinearLayout) findViewById(R.id.post_content_container);
        this.mMB.setDrawingCacheEnabled(false);
        this.mMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.nMi.requestFocus();
            }
        });
        this.lvO = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lvP = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lvR = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lvR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dlm();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hcn);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dGs();
                WriteActivity.this.dVK();
            }
        });
        this.nMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dVm();
        u(dVW());
        dVo();
        dVi();
        dVU();
        dVa();
        dVn();
        dGy();
        dVu();
        if (this.mMg.getType() == 4 && this.mMG != null && this.nMk != null) {
            this.mMG.setVisibility(8);
            this.nMk.setVisibility(8);
        }
        dGA();
        dVQ();
        dUi();
        dVM();
        dVh();
        dVV();
        dVN();
        bPD();
    }

    private void dVM() {
        if ("main_tab".equals(this.mFrom)) {
            this.nNH = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.nNH.setVisibility(0);
        }
    }

    private void dVh() {
        this.nJV = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nNJ = findViewById(R.id.frs_tab__divider);
        this.nJV.setData(this.nFC);
        if (this.nJV.getVisibility() == 0) {
            this.nNJ.setVisibility(0);
        }
        this.nJV.setActivity(this);
    }

    private void dVN() {
        this.nNQ = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.nNR = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.nNS = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.nNS, R.color.cp_cont_j);
        this.nNU = new EBusinessProtocolView(this);
        this.nNU.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.nNU.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.nNU, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.nNS.setText(spannableString);
        this.nNS.setMovementMethod(LinkMovementMethod.getInstance());
        this.nNR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nNV) {
                    WriteActivity.this.nNV = false;
                    WriteActivity.this.nNR.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.nNV = true;
                    WriteActivity.this.nNR.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.nNV) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.oy(R.color.cp_cont_b);
                    aVar.Bn("");
                    aVar.Bo(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.oz(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bpc();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.nNV = true;
            this.nNR.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.nNV = false;
            this.nNR.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.nNU.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void yF(boolean z) {
                if (z) {
                    if (!WriteActivity.this.nNV) {
                        WriteActivity.this.nNV = true;
                        WriteActivity.this.nNR.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.nNV) {
                    WriteActivity.this.nNV = false;
                    WriteActivity.this.nNR.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dVO() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.nOd = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.nNa = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.nNa, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.nNa.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nNa.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.nNa.setLayoutParams(layoutParams2);
        this.nNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dVP();
            }
        });
        this.nNa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVP() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dUi() {
        if (this.mName != null && this.mMg != null && this.mMg.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dVi() {
        String str;
        String str2;
        if (this.mMg != null) {
            switch (this.mMg.getType()) {
                case 0:
                case 9:
                    if (this.nMR || this.nMf) {
                        if (this.nMT) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jld != null && this.jld.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nJz) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.jld != null && this.jld.equals("2")) {
                        if (StringUtils.isNull(this.mMg.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mMg.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mMg.getForumName() + getResources().getString(R.string.bar));
                        this.mMy.setVisibility(8);
                        String str3 = this.iFj + " " + this.iFh;
                        if (!StringUtils.isNull(str3)) {
                            this.nMi.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.mMy.setVisibility(0);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mMy.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mMg.getFloorNum() + 1)));
                    this.nNl.setVisibility(8);
                    return;
                case 7:
                    this.mMy.setVisibility(0);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dVj() {
        if (this.mMg.getType() == 7) {
            this.lwH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lwH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dVk() {
        if (this.mMg != null && this.mMg.getType() == 0 && this.mMg.getType() == 9 && !this.nMR && !this.nMf && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dVs() != null) {
                dVs().setText(cutStringWithSuffix);
                dVs().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.lvO.setVisibility(0);
            this.lvP.setVoiceModel(voiceModel);
            this.lvP.bZl();
            dGA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CB(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.lvO.setVisibility(8);
        this.lvP.cKn();
        this.lvP.setVoiceModel(null);
        com.baidu.tbadk.editortools.m rk = this.fnv.rk(6);
        if (rk != null && rk.fnp != null) {
            rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dGA();
    }

    private void dVl() {
        this.guN = null;
        this.nMt = -1;
        this.nMv = -1;
        com.baidu.tieba.frs.ah ze = ag.cAo().ze(1);
        if (ze != null) {
            this.guN = ze.iLR;
            this.nMt = getIntent().getIntExtra("category_id", -1);
            if (this.guN != null && !this.guN.isEmpty() && this.nMt >= 0) {
                this.nMs = new af();
                this.nMs.iLN = 0;
                this.nMs.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nMv = this.nMs.iLN;
                this.nMu = this.nMs.name;
                for (af afVar : this.guN) {
                    if (afVar.iLN == this.nMt) {
                        this.nMv = afVar.iLN;
                        this.nMu = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dVm() {
        if (this.guN != null && !this.guN.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nMw = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nMw.setText(this.nMu);
            this.nMw.setCategoryContainerData(this.guN, this.nMs, this.nMv);
            this.nMw.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.nMw.setText(bfVar.name);
                        WriteActivity.this.mMg.setCategoryTo(bfVar.iLN);
                        WriteActivity.this.nMv = bfVar.iLN;
                        WriteActivity.this.nMw.dUD();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.nMw.dUC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVs());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                }
            });
        }
    }

    private void dVQ() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nML = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nML.setTitle(R.string.no_disturb_start_time);
        this.nML.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nML);
        this.nML.setButton(-2, getPageContext().getString(R.string.cancel), this.nML);
        return this.nML;
    }

    private void dVn() {
        this.nMo = (RelativeLayout) findViewById(R.id.addition_container);
        this.nMp = (TextView) findViewById(R.id.addition_create_time);
        this.nMq = (TextView) findViewById(R.id.addition_last_time);
        this.nMr = (TextView) findViewById(R.id.addition_last_content);
        if (this.nMn != null) {
            this.nMo.setVisibility(0);
            this.nMp.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.nMn.getCreateTime() * 1000));
            if (this.nMn.getAlreadyCount() == 0) {
                this.nMq.setVisibility(8);
            } else {
                this.nMq.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.nMn.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nMn.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nMr.setText(lastAdditionContent);
            } else {
                this.nMr.setVisibility(8);
            }
            dVr().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nMn.getAlreadyCount()), Integer.valueOf(this.nMn.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nMo.setVisibility(8);
    }

    private void dGy() {
        this.mMG = findViewById(R.id.post_prefix_layout);
        if (this.nNF == null) {
            this.nNF = new com.baidu.tieba.c.e(getPageContext(), this.mMG);
            this.nNF.fu(R.drawable.bg_tip_blue_up_left);
            this.nNF.ft(16);
            this.nNF.oG(true);
            this.nNF.setUseDirectOffset(true);
            this.nNF.xq(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.mMD = (TextView) findViewById(R.id.post_prefix);
        this.nMk = findViewById(R.id.prefix_divider);
        this.mMF = (ImageView) findViewById(R.id.prefix_icon);
        dVR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVR() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mMG.setVisibility(0);
            this.nMk.setVisibility(0);
            this.nNF.z(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mMh = 0;
            this.mMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dR("fid", WriteActivity.this.mMg.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mMD.setVisibility(0);
                    WriteActivity.this.mMG.setSelected(true);
                    SvgManager.brn().a(WriteActivity.this.mMF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mME, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fnv.bxU();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mMy);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nMi);
                }
            });
            this.mMD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dR("fid", WriteActivity.this.mMg.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mMD.setSelected(true);
                    SvgManager.brn().a(WriteActivity.this.mMF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mME, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fnv.bxU();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVs());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                }
            });
            this.mME = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mME.a(this);
            this.mME.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mME.setOutsideTouchable(true);
            this.mME.setFocusable(true);
            this.mME.setOnDismissListener(this);
            this.mME.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.mMD, R.color.cp_bg_line_d);
            SvgManager.brn().a(this.mMF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.mMD.setTextColor(color);
            this.nMl.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nMl.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yt(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yt(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mME.addView(writePrefixItemLayout);
            }
            this.mME.setCurrentIndex(0);
            this.mMD.setText(prefixs.get(0));
            LF(0);
            return;
        }
        this.mMG.setVisibility(8);
        this.nMk.setVisibility(8);
    }

    private void dVS() {
        if (this.nMR && this.mMg != null) {
            this.nMX.setVisibility(0);
            this.nMY.setVisibility(0);
            this.nMj = new FeedBackModel(getPageContext());
            this.nMj.UX(this.mMg.getForumName());
            this.nMj.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.nMX.setVisibility(8);
                        WriteActivity.this.nMY.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.nMX.setVisibility(8);
                        WriteActivity.this.nMY.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.nMX.a(feedBackModel.dUL(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dVo() {
        this.lwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nNH == null || WriteActivity.this.nNI != null) {
                    if (WriteActivity.this.dWl()) {
                        if (!WriteActivity.this.nNX || WriteActivity.this.nNV) {
                            if (WriteActivity.this.dWn()) {
                                int dWm = WriteActivity.this.dWm();
                                if (dWm == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dWm == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.nMD.a(WriteActivity.this.mMy, WriteActivity.this.nMi)) {
                                    WriteActivity.this.showToast(WriteActivity.this.nMD.dSX());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVs());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                                WriteActivity.this.fnv.bxU();
                                if (WriteActivity.this.mMg.getType() != 7) {
                                    if (WriteActivity.this.nMR) {
                                        WriteActivity.this.cCy();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.al("obj_type", StringUtils.isNull(WriteActivity.this.mMg.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.dVx();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cCy();
                                }
                                MercatorModel.dKU().startLoad();
                                TiebaStatic.log(new aq("c12262").dR("obj_locate", WriteActivity.this.jld));
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

    protected void dGz() {
        this.nMV = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.nMV.setIsRound(true);
        this.nMV.setDrawBorder(false);
        this.nMV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String BL = q.BL(currentPortrait);
            this.nMV.setUrl(BL);
            this.nMV.startLoad(BL, 12, false);
        }
        if (this.mMg.isUserFeedback()) {
            this.nMV.setVisibility(0);
        }
        this.mMy = (EditText) findViewById(R.id.post_title);
        this.mMy.setOnClickListener(this.nMH);
        this.mMy.setOnFocusChangeListener(this.hcn);
        if (this.mMg.getType() == 0 || this.mMg.getType() == 9 || this.mMg.getType() == 7) {
            if (this.mMg.getTitle() != null) {
                this.mMy.setText(this.mMg.getTitle());
                this.mMy.setSelection(this.mMg.getTitle().length());
            } else if (this.nMT) {
                this.mMy.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mMg.getType() == 1 || this.mMg.getType() != 2) {
        }
        this.mMy.addTextChangedListener(this.nMJ);
        if (!this.mMg.getHaveDraft()) {
            dVk();
            this.nNA = true;
        }
        this.nMU = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher awp() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int nOh;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dGA();
                if (WriteActivity.this.nMy) {
                    this.nOh = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.nOh);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.nMy || !WriteActivity.this.nNs) {
                    if (WriteActivity.this.nMy) {
                        if (this.mEditText != WriteActivity.this.nNj || this.mTextView != WriteActivity.this.nNp) {
                            this.mEditText = WriteActivity.this.nNj;
                            this.mTextView = WriteActivity.this.nNp;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.nNn || this.mTextView != WriteActivity.this.nNo) {
                    this.mEditText = WriteActivity.this.nNn;
                    this.mTextView = WriteActivity.this.nNo;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.nMy && this.nNs) {
            if (this.nNq != null) {
                this.nNn.removeTextChangedListener(this.nNq);
            }
            this.nNq = textWatcher;
        } else if (this.nMy) {
            if (this.nNr != null) {
                this.nNj.removeTextChangedListener(this.nNr);
            }
            this.nNr = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.nNj) {
            return 233L;
        }
        if (editText != this.nNn) {
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

    protected void dGB() {
        this.nMi = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nMi.setDrawingCacheEnabled(false);
        this.nMi.setOnClickListener(this.nMH);
        this.nMi.setOnSpanGroupChangedListener(new a.InterfaceC0582a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0582a
            public void G(int i, boolean z) {
                WriteActivity.this.LZ();
            }
        });
        this.nMi.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.nMi.setForumId(com.baidu.adp.lib.f.b.toLong(this.mMg.getForumId(), 0L));
        this.nMi.setTransLink(!this.nJz);
        if (this.fpI != null) {
            this.fpI.setSpanGroupManager(this.nMi.getSpanGroupManager());
        }
        if (this.mMg != null) {
            this.mMg.setSpanGroupManager(this.nMi.getSpanGroupManager());
        }
        if (this.mMg.getContent() != null && this.mMg.getContent().length() > 0) {
            this.nMi.setText(TbFaceManager.bBc().aw(getPageContext().getPageActivity(), this.mMg.getContent()));
            if (this.nMi.getText() != null) {
                this.nMi.setSelection(this.nMi.getText().length());
            }
        } else if (this.mMg.getType() == 2) {
            if (this.nNb) {
                if (this.nNc != null && this.nNc.length() > 0) {
                    this.nMi.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.nNc}));
                    this.nMi.setSelection(this.nMi.getText().length());
                }
            } else if (this.mMg.getFloorNum() > 0) {
                this.nMi.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mMg.getFloorNum())));
                this.nMi.setSelection(this.nMi.getText().length());
            }
        }
        this.nMi.setOnFocusChangeListener(this.hcn);
        this.nMi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.nMi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nMi.addTextChangedListener(this.nMK);
        if (this.mMg.getType() == 0) {
            this.nNE = true;
        } else {
            yK(true);
            this.nNE = false;
        }
        if (this.mMg.isUserFeedback()) {
            this.nMi.setHint(R.string.write_input_content);
        } else {
            this.nMi.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void yK(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.nMy && !this.nJz && dVr() != null) {
            dVr().setPadding(0, 0, 0, 0);
            dVr().setBackgroundDrawable(null);
            ap.setBackgroundColor(dVr(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.kOI) || this.nMn != null) {
                return;
            }
            if (this.nNK == null || !this.nNK.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.kOI, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass42) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.nNK == null || !WriteActivity.this.nNK.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dVr().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dVr(), true, WriteActivity.this.lCM);
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

    private void dVT() {
        if (dVr() != null) {
            dVr().setPadding(0, 0, 0, 0);
            dVr().setBackgroundDrawable(null);
            ap.setBackgroundColor(dVr(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVq() {
        int i = 5000;
        if (this.nMn != null) {
            i = 1000;
        }
        return dVr().getText() != null && dVr().getText().length() >= i;
    }

    private void DJ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nMc)) {
                this.nMc = "";
                dVr().requestFocus();
                if (dVr().getText() != null && dVr().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVr().getSelectionStart();
                    editable = dVr().getText();
                }
            } else if ("from_title".equals(this.nMc)) {
                this.nMc = "";
                dVs().requestFocus();
                if (dVs().getText() != null && dVs().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVs().getSelectionStart();
                    editable = dVs().getText();
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
    public void yH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mMg != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mMg.getForumId(), 0L), this.mMg.getFirstDir(), this.mMg.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dVr().getText().getSpans(0, dVr().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nMm == null) {
                this.nMm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.nMm.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dVr());
    }

    EditText dVr() {
        return this.nMy ? this.nNj : this.nMi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVs() {
        return this.nMy ? this.nNn : this.mMy;
    }

    protected void dVt() {
        if (dVr().getSelectionStart() > 0) {
            String substring = dVr().getText().toString().substring(0, dVr().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.itq.matcher(substring);
            if (matcher.find()) {
                dVr().getText().delete(dVr().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dVr().getSelectionStart());
                return;
            }
            dVr().onKeyDown(67, this.itr);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.mMg != null) {
            str = this.mMg.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.nMR = true;
        }
    }

    private void dVU() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dVV() {
        this.nNM = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.nNL = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.nNM);
        ao(getIntent());
    }

    private void bPD() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.nNP = new d(getPageContext());
        this.nNP.a(this.nNO);
        this.mListView.setAdapter((ListAdapter) this.nNP);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.nNP != null && (WriteActivity.this.nNP.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.nNP.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.eAm == 1) {
                            be.brr().b(WriteActivity.this.getPageContext(), new String[]{tVar.eAe});
                        } else {
                            be.brr().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eAe)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.eAh)) {
                            if (tVar.eAh.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, tVar.eAh));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.eAh));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.eAi)) {
                                be.brr().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eAi)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.eAi)) {
                            be.brr().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.eAi)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fxS.setCancelListener(null);
        this.fxS.setTipString(R.string.sending);
        this.fxS.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fxS.setDialogVisiable(false);
    }

    private Boolean dVW() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.nNd = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.fpM = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.nNd);
    }

    public void dGA() {
        this.nNN = false;
        if (this.mMg != null) {
            String str = "";
            String str2 = "";
            if (dVs() != null) {
                str = dVs().getText().toString();
            }
            if (dVr() != null) {
                str2 = dVr().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mMg.getType() == 0 || this.mMg.getType() == 9 || this.mMg.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.mMh == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mMg.setIsNoTitle(true);
                        } else if (this.nMh.getVisibility() == 0) {
                            this.mMg.setIsNoTitle(false);
                            yI(true);
                            return;
                        }
                    } else if (this.nMh.getVisibility() == 0) {
                        this.mMg.setIsNoTitle(false);
                        yI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mMg.setIsNoTitle(true);
                } else if (this.nMh.getVisibility() == 0) {
                    this.mMg.setIsNoTitle(false);
                    yI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nMy) {
                    yI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yI(true);
                }
            }
            if (this.mMg.getType() == 4) {
                yI(m(this.nNj) && l(this.nNn));
            } else if (this.mMg.getType() == 5) {
                yI(m(this.nNj));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                yI(true);
            } else if (this.mMg.getVideoInfo() != null) {
                yI(this.mMg.getVideoInfo().isVideoMixFinished());
            } else if (dWj()) {
                yI(true);
                this.nNN = true;
            } else {
                yI(false);
            }
        }
    }

    public void yI(boolean z) {
        this.lwH.setEnabled(z);
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
        this.fpI = new NewWriteModel(this);
        this.fpI.b(this.fpW);
        registerListener(this.nNY);
        registerListener(this.nNZ);
        registerListener(this.nOa);
        this.iyf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.46
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dGs();
            }
        };
        this.mMg = new WriteData();
        if (bundle != null) {
            this.mMg.setType(bundle.getInt("type", 0));
            this.mMg.setForumId(bundle.getString("forum_id"));
            this.mMg.setForumName(bundle.getString("forum_name"));
            this.mMg.setFirstDir(bundle.getString("forum_first_dir"));
            this.mMg.setSecondDir(bundle.getString("forum_second_dir"));
            this.mMg.setThreadId(bundle.getString("thread_id"));
            this.mMg.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mMg.setFloorNum(bundle.getInt("floor_num", 0));
            this.nMR = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.nMS = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nMT = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nNb = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nNc = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fpG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nMn = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mMg.setIsAddition(this.nMn != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.nNe = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mMg.setTitle(bundle.getString("write_title"));
            this.mMg.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mMg.setTopicId(this.mTopicId);
            this.jld = bundle.getString("KEY_CALL_FROM");
            this.bDX = bundle.getInt("album_thread");
            this.nFC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mMg.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mMg.setType(intent.getIntExtra("type", 0));
            this.mMg.setForumId(intent.getStringExtra("forum_id"));
            this.mMg.setForumName(intent.getStringExtra("forum_name"));
            this.mMg.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mMg.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mMg.setThreadId(intent.getStringExtra("thread_id"));
            this.mMg.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mMg.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nMR = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.nMS = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nMT = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nNb = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nNc = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.nMn = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mMg.setIsAddition(this.nMn != null);
            this.mMg.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.nNe = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.iFi = intent.getStringExtra("more_forum_img");
            this.iFj = intent.getStringExtra("more_forum_title");
            this.iFh = intent.getStringExtra("more_forum_url");
            this.mMg.setTitle(intent.getStringExtra("write_title"));
            this.mMg.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mMg.setTopicId(this.mTopicId);
            this.jld = intent.getStringExtra("KEY_CALL_FROM");
            this.bDX = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nFC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mMg.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mMg.mDynamicImageTextData = new ImageTextUploadData();
            this.nJz = true;
        }
        if (this.mMg.getType() == 9) {
            this.mMg.setEntranceType(1);
        } else if (this.mMg.getType() == 10) {
            this.mMg.setEntranceType(2);
            this.mMg.setType(9);
        } else if (this.mMg.getType() == 0) {
            this.mMg.setEntranceType(3);
        }
        this.mMg.setIsUserFeedback(this.nMR);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mMg.getType() == 4 ? 6 : 9);
        this.mMg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mMg.getType() == 0 || this.mMg.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nJz) {
                    x.d(this.mMg.getForumId(), this);
                } else {
                    x.c(this.mMg.getForumId(), this);
                }
            }
        } else if (this.mMg.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.mMg.getType() == 1) {
            x.a(this.mMg.getThreadId(), this);
        } else if (this.mMg.getType() == 4) {
            x.c(this.mMg.getForumId() + "photolive", this);
        } else if (this.mMg.getType() == 5) {
            x.a(this.mMg.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.kOI = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mMg != null && this.mMg.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mMg.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nMf = true;
        }
        dVl();
        try {
            this.nNt = dWf();
        } catch (Throwable th) {
            this.nNt = null;
        }
    }

    private void dVu() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mMy.setText(com.baidu.tbadk.plugins.b.Eo(com.baidu.tbadk.plugins.b.Ep(hotTopicBussinessData.mTopicName)));
            this.mMy.setMovementMethod(com.baidu.tieba.view.c.dSy());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Eo = com.baidu.tbadk.plugins.b.Eo(com.baidu.tbadk.plugins.b.Ep(hotTopicBussinessData.mTopicName));
            if (Eo != null) {
                this.mMy.setText(Eo);
            }
            this.nMA.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.nNX) {
            if (writeData != null) {
                if (this.mMg != null) {
                    boolean z = this.mMg.getVideoInfo() != null && this.mMg.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.mMg.getWriteImagesInfo() == null || y.isEmpty(this.mMg.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dVs().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dVr().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bBc().a(getPageContext().getPageActivity(), writeData.getContent(), this.nMF));
                    if (!z || z7) {
                        this.mMg.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.nNA || ((this.nMR || this.nMf) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.nMR || this.nMf)) {
                            j(writeData);
                        }
                        if (this.mMg != null && !this.mMg.getHaveDraft()) {
                            dVk();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dVX();
                        }
                        dGA();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.guN != null) {
                            this.nMv = this.nMs.iLN;
                            this.nMu = this.nMs.name;
                            while (true) {
                                if (i == this.guN.size()) {
                                    break;
                                }
                                af afVar = this.guN.get(i);
                                if (categoryTo != afVar.iLN) {
                                    i++;
                                } else {
                                    this.nMv = categoryTo;
                                    this.nMu = afVar.name;
                                    this.mMg.setCategoryTo(this.nMv);
                                    break;
                                }
                            }
                            if (this.nMw != null) {
                                this.nMw.setText(this.nMu);
                                this.nMw.setCategoryContainerData(this.guN, this.nMs, this.nMv);
                            }
                        }
                        this.fnv.bxU();
                        return;
                    }
                    return;
                }
                return;
            }
            dVX();
            dVk();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mMg.setVideoInfo(videoInfo);
            yJ(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mMg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dVz();
        }
        yL(false);
        yJ(true);
    }

    private void i(WriteData writeData) {
        String str;
        String Ep;
        if (com.baidu.adp.lib.util.k.isEmpty(this.mMg.getTitle())) {
            this.mMg.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Ep = this.mMg.getTitle();
            } else {
                Ep = com.baidu.tbadk.plugins.b.Ep(str);
            }
            SpannableString Eo = com.baidu.tbadk.plugins.b.Eo(Ep);
            if (Eo != null) {
                dVs().setText(Eo);
                dVs().setSelection(Eo.length() > Ep.length() ? Ep.length() : Eo.length());
                return;
            }
            return;
        }
        SpannableString Eo2 = com.baidu.tbadk.plugins.b.Eo(this.mMg.getTitle());
        if (Eo2 != null) {
            dVs().setText(Eo2);
            dVs().setSelection(this.mMg.getTitle().length() > Eo2.length() ? Eo2.length() : this.mMg.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.mMg.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bBc().a(getPageContext().getPageActivity(), this.mMg.getContent(), this.nMF);
        InputFilter[] filters = this.nMi.getFilters();
        this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dVr().setText(a2);
        if (dVr() == this.nMi && this.nMi.getSpanGroupManager() != null) {
            this.nMi.btq();
            this.nMi.getSpanGroupManager().btw();
            this.nMi.btr();
            LZ();
        }
        this.nMi.setFilters(filters);
        if (dVr().getText() != null) {
            dVr().setSelection(dVr().getText().length());
        }
        if (this.nMy) {
            a(this.nNp, this.nNj);
        }
    }

    private void dVX() {
        if ((!this.nMy || this.nNi != null) && this.nNh != null) {
            this.nNi.b(this.writeImagesInfo);
            dWb();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mMg.getType());
        bundle.putString("forum_id", this.mMg.getForumId());
        bundle.putString("forum_name", this.mMg.getForumName());
        bundle.putString("forum_first_dir", this.mMg.getFirstDir());
        bundle.putString("forum_second_dir", this.mMg.getSecondDir());
        bundle.putString("thread_id", this.mMg.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mMg.getFloor());
        bundle.putInt("floor_num", this.mMg.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.nNb);
        if (this.nMR) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fpG);
        if (this.nMn != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nMn));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.nNe);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jld);
        bundle.putInt("album_thread", this.bDX);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nFC);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dVr().getEditableText().toString();
        if (obj != null) {
            dVr().setText(TbFaceManager.bBc().a(getPageContext().getPageActivity(), obj, this.nMF));
            dVr().setSelection(dVr().getText().length());
        }
    }

    private String getContent() {
        return (dVr() == null || dVr().getText() == null) ? "" : dVr().getText().toString();
    }

    private String dVw() {
        if (this.mMg == null || dVs() == null || dVs().getVisibility() != 0 || dVs().getText() == null) {
            return "";
        }
        String obj = dVs().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mMh != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mMg.getType() != 4 && this.mMD != null && this.mMD.getText() != null) {
            this.mMg.setPostPrefix(this.mMD.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mMg.getTitle();
        }
        return obj;
    }

    private void UY(String str) {
        if (this.mMg != null && this.nMh != null) {
            if (this.nMh.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mMg.setIsNoTitle(true);
                    this.mMg.setTitle("");
                    return;
                }
                this.mMg.setIsNoTitle(false);
                this.mMg.setTitle(str);
                return;
            }
            this.mMg.setIsNoTitle(true);
            this.mMg.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCy() {
        dGs();
        this.mMg.setContent(getContent());
        UY(dVw());
        if (this.nMR || this.nMf) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mMg.getTitle()) || !this.mMg.getTitle().startsWith(string)) {
                UY(string + this.mMg.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mMg.getContent()) || !this.mMg.getContent().startsWith(str)) {
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
                sb.append(this.mMg.getContent());
                this.mMg.setContent(sb.toString());
            }
        }
        if (this.nMS) {
            this.mMg.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.nMt >= 0) {
            this.mMg.setCategoryFrom(this.nMt);
        }
        if (this.nMv >= 0) {
            this.mMg.setCategoryTo(this.nMv);
        }
        this.mMg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nNL != null) {
            this.mMg.setWriteVoteData(this.nNL.getWriteVoteData());
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
            this.mMg.setTakePhotoNum(i);
        }
        this.mMg.setHasLocationData(this.fpH != null && this.fpH.cin());
        if (this.writeImagesInfo != null) {
            this.fpI.xy(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.nMz != null && this.nMz.mIsGlobalBlock == 0) {
            this.mMg.setForumId(String.valueOf(this.nMz.mForumId));
            this.mMg.setForumName(this.nMz.mForumName);
        }
        dUl();
        this.fpI.e(this.mMg);
        this.mMg.setContent(this.mMg.getContent().replaceAll("\u0000\n", ""));
        this.mMg.setContent(this.mMg.getContent().replaceAll("\u0000", ""));
        this.mMg.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.fpI.cXW().setVoice(this.mVoiceModel.getId());
                this.fpI.cXW().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.fpI.cXW().setVoice(null);
                this.fpI.cXW().setVoiceDuringTime(-1);
            }
        } else {
            this.fpI.cXW().setVoice(null);
            this.fpI.cXW().setVoiceDuringTime(-1);
        }
        if (!this.fpI.dLp()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mMg.mDynamicImageTextData != null) {
            dUk();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iyf);
            this.fpI.dLm();
        }
    }

    private void dUl() {
        FrsTabItemData selectedTabItemData;
        if (this.mMg != null && this.nJV != null && (selectedTabItemData = this.nJV.getSelectedTabItemData()) != null) {
            this.mMg.setTabId(selectedTabItemData.tabId);
            this.mMg.setTabName(selectedTabItemData.name);
            this.mMg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dUk() {
        if (this.mMg.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.mMg, new a.InterfaceC0873a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                @Override // com.baidu.tieba.write.b.a.InterfaceC0873a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dTT().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.47.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cCv();
                            x.e(WriteActivity.this.mMg.getForumId(), (WriteData) null);
                            WriteActivity.this.dVL();
                            com.baidu.tieba.write.b.a.dTN();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.km(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dTN();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0873a
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
            if (this.nMn != null) {
                i2 = this.nMn.getTotalCount();
                i = this.nMn.getAlreadyCount() + 1;
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
                if (this.mMy == getCurrentFocus()) {
                    dVr().clearFocus();
                    this.mMy.requestFocus();
                    if (this.fnv != null) {
                        this.fnv.bxU();
                    }
                    ShowSoftKeyPadDelay(this.mMy);
                } else {
                    dVr().requestFocus();
                    if (this.fnv != null) {
                        this.fnv.bxU();
                    }
                    ShowSoftKeyPadDelay(this.nMi);
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
                            dVr().getText().insert(dVr().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cCv();
                dVL();
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
                                dWc();
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
                        yJ(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.nNE) {
                            yK(true);
                            this.nNE = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.nMy) {
                        F(intent);
                        dGA();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mMg.setVideoInfo(videoInfo);
                        this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fnv.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dGA();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.nMd) {
                                sb2.append(com.baidu.tbadk.plugins.b.fxl);
                                this.nMd = false;
                            }
                            sb2.append(stringExtra);
                            DJ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.nMz = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.nMz);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.nMi.getSelectionStart();
                    int selectionEnd = this.nMi.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.nMi.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fnv != null && !this.fnv.bzB()) {
                this.nMi.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fnv.bxU();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bAn();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dWa();
                    if (this.nNE) {
                        yK(true);
                        this.nNE = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.mMy == getCurrentFocus()) {
                        dVr().clearFocus();
                        this.mMy.requestFocus();
                        if (this.fnv != null) {
                            this.fnv.bxU();
                        }
                        ShowSoftKeyPadDelay(this.mMy);
                        return;
                    }
                    dVr().requestFocus();
                    if (this.fnv != null) {
                        this.fnv.bxU();
                    }
                    ShowSoftKeyPadDelay(this.nMi);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.nMD.UA(postWriteCallBackData.getErrorString());
                        this.nMD.bk(postWriteCallBackData.getSensitiveWords());
                        this.nMD.b(this.mMy, this.nMi);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fpG = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fpG);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dWa();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nMc)) {
                        dVs().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nMc)) {
                        dVr().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVx() {
        if ("1".equals(this.jld)) {
            this.mMg.setCanNoForum(true);
            this.mMg.setTransmitForumData("[]");
        } else if ("2".equals(this.jld)) {
            this.mMg.setCanNoForum(false);
        }
        dVy();
        this.mMg.setPrivacy(this.isPrivacy);
        dVY();
        this.mMg.setToDynamic(this.isToDynamic);
        this.mMg.setCallFrom(this.jld);
        if (this.mMg.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cCy();
    }

    private void dVy() {
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dVY() {
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dVZ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dWa() {
        if (this.nMy) {
            this.nNi.b(this.writeImagesInfo);
            dWb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWb() {
        this.nNi.notifyDataSetChanged();
        this.nNh.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.nNi.notifyDataSetChanged();
                WriteActivity.this.nNh.invalidateViews();
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
        dGA();
    }

    private void ap(Intent intent) {
        if (this.nMy) {
            aq(intent);
            dWa();
        } else {
            at(intent);
        }
        dGA();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dWa();
            yL(true);
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

    private void dWc() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.nNf.parseJson(stringExtra);
            this.nNf.updateQuality();
            if (this.nNf.getChosedFiles() != null && this.nNf.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.nNf.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.nNf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dVs());
        HidenSoftKeyPad(this.mInputManager, dVr());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.nNK != null) {
            this.nNK.onPause();
        }
        if (this.fnv.bzB()) {
            this.fnv.bxU();
        }
    }

    private void at(Intent intent) {
        d(intent, true);
    }

    private void E(Intent intent) {
        this.fpG = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fpG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fpG, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dWd();
            dVz();
        }
        yL(true);
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
                dWd();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dVz();
                }
            }
            yL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dWd() {
        if (this.fnv.rk(10) != null) {
            this.fnv.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bAn() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.50
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fpG));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dWe() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.iFi)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.iFi, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.51
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
                            WriteActivity.this.yL(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL(boolean z) {
        String forumId = this.mMg == null ? "" : this.mMg.getForumId();
        if (this.nNg != null) {
            this.nNg.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cyK() {
        this.iHo = getVoiceManager();
        this.iHo.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iIK) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mMg.getType() != 7) {
                if (this.nMn == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                H(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fpN = i;
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dVz() {
        if (!this.nMy) {
            if (this.fnv != null) {
                this.fnv.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fnv.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mMg == null ? "" : this.mMg.getForumId();
            if (this.nNg != null) {
                this.nNg.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LF(int i) {
        if (i < this.nMl.size()) {
            for (int i2 = 0; i2 < this.nMl.size(); i2++) {
                this.nMl.get(i2).yu(false);
            }
            this.nMl.get(i).yu(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Jh(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").al("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").al("obj_type", 2));
        }
        this.mMh = i;
        this.mME.setCurrentIndex(i);
        LF(i);
        this.mMD.setText(this.mPrefixData.getPrefixs().get(i));
        dGA();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mME, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mMG.setSelected(false);
        SvgManager.brn().a(this.mMF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.nMi);
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
        if (this.mMg != null) {
            if (this.mMg.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mMg.getType() == 5) {
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
            bAh();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fpG);
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
        this.bmZ = z;
        if (this.nNy && System.currentTimeMillis() - this.nNz < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.nNy = false;
        }
        if (this.nMC != null && !z) {
            this.nMC.csl();
        }
        if (this.nME != null && !z) {
            dVc();
        }
        if (this.nNG != null && !z) {
            dVH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UZ(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.nNv != null) {
            Va(str);
            this.nNv.dismiss();
        }
    }

    private void ge(Context context) {
        nNx = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void Va(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.nNy = true;
        dWd();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dVz();
        }
        yL(true);
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

    private File dWf() {
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

    private void dWg() {
        if (this.nNt != null && this.mMg.getType() == 0 && this.mMg.getType() == 9) {
            ge(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.nNt != null) {
                        WriteActivity.this.UZ(WriteActivity.this.nNt.getAbsolutePath());
                    }
                }
            });
            this.nNu = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.nNw = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.nNt.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.nNt.getAbsolutePath());
                Bitmap h = h(this.nNt.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.nNu.setImageBitmap(h);
                    this.nNu.setDrawBorder(true);
                    this.nNu.setBorderWidth(2);
                    this.nNu.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.nNv = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.nNv.setCanceledOnTouchOutside(true);
                    this.nNv.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.nNy) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.nNz = System.currentTimeMillis();
                            }
                        }
                    });
                    this.nNv.setContentView(this.mBubbleView);
                    this.nNv.show();
                    Window window = this.nNv.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (nNx / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bmZ && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nMd = false;
            this.nMc = "";
            if ("from_content".equals(str)) {
                this.nMc = "from_content";
            } else if ("from_title".equals(str)) {
                this.nMc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.En(String.valueOf(charSequence.charAt(i)))) {
                yH(false);
            }
        }
    }

    public void dAZ() {
        if (com.baidu.tieba.write.c.b.dUc()) {
            this.mMy.setHint(R.string.title_hint_for_hot);
            this.nMh.setVisibility(0);
            this.nMW.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.nMU);
            this.nMh.requestFocus();
            return;
        }
        this.nMU.setVisibility(8);
        this.mMy.setHint(this.nMR ? R.string.feedback_title_hint : R.string.post_title_hint);
        if (this.nMR || !y.isEmpty(this.mList) || (this.mMg != null && !StringUtils.isNull(this.mMg.getTitle()))) {
            this.nMh.setVisibility(0);
            this.nMW.setVisibility(0);
            this.nMh.requestFocus();
            return;
        }
        this.nMh.setVisibility(8);
        this.nMW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWh() {
        if (this.fnv != null) {
            this.fnv.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nJz && WriteActivity.this.fnv != null && WriteActivity.this.fnv.fny != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.brr().k(clipBoardContent)) {
                            WriteActivity.this.nMC.dtA();
                            return;
                        }
                        if (WriteActivity.this.nKL == null) {
                            WriteActivity.this.nKL = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.nOb);
                        }
                        WriteActivity.this.nKL.a(WriteActivity.this.fnv.fny.ri(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jld;
    }

    public WriteData cXW() {
        return this.mMg;
    }

    public FrsTabInfoData dWi() {
        return this.nFC;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dWj() {
        return (this.nNL == null || this.nNM == null || this.nNL.getWriteVoteData() == null || this.nNM.getVisibility() != 0) ? false : true;
    }

    public void dTd() {
        if (this.mMg != null) {
            TiebaStatic.log(new aq("c13897").al("obj_locate", 2).dR("fid", this.mMg.getForumId()).dR("fname", this.mMg.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.oz(2);
            aVar.iW(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").al("obj_locate", 2).dR("fid", WriteActivity.this.mMg != null ? WriteActivity.this.mMg.getForumId() : "").dR("fname", WriteActivity.this.mMg != null ? WriteActivity.this.mMg.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dWk()));
                    }
                }
            });
            aVar.bf(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").al("obj_locate", 2).dR("fid", this.mMg != null ? this.mMg.getForumId() : "").dR("fname", this.mMg != null ? this.mMg.getForumName() : ""));
            aVar.b(getPageContext()).bpc();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dWk()));
    }

    public void LZ() {
        if (this.nNP != null && this.nNP.dUN() == null && this.nMi != null && this.nMi.getSpanGroupManager() != null) {
            this.nNP.h(this.nMi.getSpanGroupManager().btB());
            this.nNP.refreshData();
        } else if (this.nNP != null && this.nNP.dUN() != null) {
            this.nNP.refreshData();
        }
        if (this.nNP != null) {
            gf(this.nNP.dUM());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(List<t> list) {
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
            if (!z && this.nNQ != null) {
                this.nNQ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vb(String str) {
        this.nNT = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.nNT.add(com.baidu.tieba.i.a.eh(jSONObject));
                }
                if (this.nNT.size() > 0) {
                    this.nNX = true;
                    this.nMi.m(this.nNT, arrayList);
                    dVO();
                    LZ();
                    this.nNQ.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dWk() {
        if (this.nMi == null || this.nMi.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.nMi.getSpanGroupManager().btC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWl() {
        return this.canGoods || this.nMi == null || this.nMi.getSpanGroupManager() == null || this.nMi.getSpanGroupManager().btC() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dWm() {
        boolean z = this.nNP == null || this.nNP.dUO();
        boolean z2 = (this.nJV == null || this.nJV.getSelectedTabItemData() == null || this.nJV.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWn() {
        if (this.nFC == null || y.isEmpty(this.nFC.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nFC.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dWo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.57
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yk(false).Ut(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aJ((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
