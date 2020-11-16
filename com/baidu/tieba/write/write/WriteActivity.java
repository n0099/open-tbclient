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
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
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
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.t;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0248a, VoiceManager.c, x.a, i.a {
    private static int nOZ = 0;
    private EditorTools fmD;
    private String foN;
    private LocationModel foO;
    private NewWriteModel foP;
    List<af> guu;
    private String iFV;
    private String iFW;
    private String iFX;
    private VoiceManager iIc;
    private com.baidu.tbadk.core.dialog.i iUZ;
    private SaveDraftDialogView iVa;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout lwe;
    private PlayVoiceBntNew lwf;
    private ImageView lwh;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private int mNa;
    private TextView mNw;
    private com.baidu.tieba.write.i mNx;
    private ImageView mNy;
    private View mNz;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nHd;
    private ForumTabSelectedView nLw;
    private FindNewLinkBubbleController nMm;
    private LinearLayout nNI;
    private LinearLayout nNJ;
    private View nNM;
    private Toast nNO;
    private AdditionData nNP;
    private RelativeLayout nNQ;
    private TextView nNR;
    private TextView nNS;
    private TextView nNT;
    af nNU;
    private int nNV;
    private String nNW;
    private int nNX;
    private PostCategoryView nNY;
    private View nOA;
    private i nOI;
    private HotTopicBussinessData nOb;
    private TextView nOc;
    private com.baidu.tieba.write.editor.b nOe;
    private g nOg;
    private com.baidu.tieba.view.b nOn;
    private TitleTipView nOw;
    private View nOy;
    private WriteImageGridView nPE;
    private View nPd;
    private View nPe;
    private TextView nPf;
    private com.baidu.tieba.d.e nPh;
    private b nPi;
    private ForumSelectedView nPj;
    private com.baidu.tbadk.data.i nPk;
    private View nPl;
    private com.baidu.tieba.write.write.video.a nPm;
    private com.baidu.tieba.write.write.vote.a nPn;
    private RelativeLayout nPo;
    private boolean nPp;
    private d nPr;
    private LinearLayout nPs;
    private ImageView nPt;
    private TextView nPu;
    private List<com.baidu.tieba.j.a> nPv;
    private EBusinessProtocolView nPw;
    private int privateThread;
    private String nNE = "";
    private boolean nNF = false;
    protected WriteData mMZ = null;
    private boolean nOt = false;
    private boolean nOu = false;
    private boolean nNH = false;
    private boolean nOv = false;
    private InputMethodManager mInputManager = null;
    private EditText mNr = null;
    private HeadImageView nOx = null;
    private View mNs = null;
    private LinearLayout mNu = null;
    private SpanGroupEditText nNK = null;
    private FeedBackModel nNL = null;
    private FeedBackTopListView nOz = null;
    private ArrayList<WritePrefixItemLayout> nNN = new ArrayList<>();
    private String kOV = null;
    private final KeyEvent iuf = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView nOB = null;
    private TextView lwX = null;
    private TextView mName = null;
    private ImageView nOC = null;
    private DialogInterface.OnCancelListener iyU = null;
    private final Handler mHandler = new Handler();
    private boolean nOD = false;
    private String nOE = null;
    private RelativeLayout jVZ = null;
    public boolean nOF = true;
    public String foT = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int foU = 0;
    private int nOG = 0;
    private WriteImagesInfo nOH = new WriteImagesInfo();
    private View mRootView = null;
    private GridView nOJ = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a nOK = null;
    private ScrollView nNZ = null;
    private EditText nOL = null;
    private View nOM = null;
    private View nON = null;
    private View nOO = null;
    private EditText nOP = null;
    private TextView nOQ = null;
    private TextView nOR = null;
    private TextWatcher nOS = null;
    private TextWatcher nOT = null;
    private boolean nOa = false;
    private boolean nOU = false;
    private com.baidu.tbadk.core.view.a fxh = null;
    private String mFrom = "write";
    private File nOV = null;
    private TbImageView nOW = null;
    private View mBubbleView = null;
    private Dialog nOX = null;
    private LinearLayout nOY = null;
    private boolean nPa = false;
    private long nPb = -1000;
    private boolean nPc = false;
    private String jlN = "2";
    private int bCm = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder nOd = new SpannableStringBuilder();
    private boolean nPg = false;
    private boolean blo = false;
    private final c nOf = new c();
    private boolean nLa = false;
    private final d.a nPq = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Mg(int i) {
            if (WriteActivity.this.nNK != null) {
                WriteActivity.this.nNK.qM(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void ge(List<u> list) {
            WriteActivity.this.gf(list);
        }
    };
    private boolean nPx = false;
    private int nPy = 0;
    private boolean nPz = false;
    private final HttpMessageListener nPA = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.kOV)) {
                    WriteActivity.this.kOV = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.yR(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.kOV)) {
                    WriteActivity.this.kOV = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.kOV);
                    WriteActivity.this.yR(true);
                }
            }
        }
    };
    private CustomMessageListener nPB = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.mMZ != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").ak("obj_locate", 1).dR("fid", WriteActivity.this.mMZ.getForumId()).dR("fname", WriteActivity.this.mMZ.getForumName()));
            }
        }
    };
    private final CustomMessageListener nPC = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nPj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                WriteActivity.this.nPk = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                if (WriteActivity.this.nPk != null && !StringUtils.isNull(WriteActivity.this.nPk.forumId) && !StringUtils.isNull(WriteActivity.this.nPk.forumName)) {
                    if (WriteActivity.this.mMZ != null) {
                        WriteActivity.this.mMZ.setForumId(WriteActivity.this.nPk.forumId);
                        WriteActivity.this.mMZ.setForumName(WriteActivity.this.nPk.forumName);
                    }
                    WriteActivity.this.nPj.setSelectedForum(WriteActivity.this.nPk.forumName);
                    WriteActivity.this.nHd = null;
                    if (!y.isEmpty(WriteActivity.this.nPk.tabInfoList)) {
                        WriteActivity.this.nHd = new FrsTabInfoData();
                        WriteActivity.this.nHd.selectedTabId = -1;
                        WriteActivity.this.nHd.tabList = WriteActivity.this.nPk.tabInfoList;
                    }
                    WriteActivity.this.nLw.setData(WriteActivity.this.nHd);
                    if (WriteActivity.this.nLw.getVisibility() == 0) {
                        WriteActivity.this.nPl.setVisibility(0);
                    }
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.nPk.flt != null && !y.isEmpty(WriteActivity.this.nPk.flt.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.nPk.flt;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.dVQ();
                }
            }
        }
    };
    private TbFaceManager.a nOh = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dy(String str) {
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
    private final AntiHelper.a iJy = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a nPD = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.58
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.nMm != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.nMm.VK();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.59
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cyn();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.nPF = true;
            if (postWriteCallBackData != null && WriteActivity.this.mMZ != null) {
                WriteActivity.this.nOf.bl(null);
                if (z) {
                    WriteActivity.this.kn(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.mMZ);
                    WriteActivity.this.cBZ();
                    WriteActivity.this.dVK();
                    if ((WriteActivity.this.mMZ.getType() == 0 || WriteActivity.this.mMZ.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mMZ.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mMZ.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.mMZ.getForumName())) {
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
                    WriteActivity.this.nOf.bl(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.nOf.Ul(postWriteCallBackData.getErrorString());
                    WriteActivity.this.nOf.b(WriteActivity.this.mNr, WriteActivity.this.nNK);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AJ(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AJ(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bog();
                    TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bum());
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul());
                        if (WriteActivity.this.nOv) {
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
    private final LocationModel.a fpb = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bzM() {
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
    private final CustomMessageListener nat = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.foO.xD(false);
                    WriteActivity.this.foO.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.foO.xD(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nOi = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dWg();
            }
        }
    };
    private final View.OnClickListener nOj = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dUY = WriteActivity.this.dUY();
            if (dUY >= 0 && dUY < WriteActivity.this.nNK.getText().length()) {
                WriteActivity.this.nNK.setSelection(dUY);
            }
        }
    };
    private boolean nOk = true;
    private final View.OnFocusChangeListener hbU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mNr || view == WriteActivity.this.mBack || view == WriteActivity.this.lwX) {
                if (z) {
                    WriteActivity.this.nOk = true;
                    WriteActivity.this.dUZ();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mNr);
                    if (WriteActivity.this.fmD != null) {
                        WriteActivity.this.fmD.bxk();
                    }
                } else if (view == WriteActivity.this.mNr) {
                    WriteActivity.this.mNw.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.nNK && z) {
                WriteActivity.this.nOk = false;
                WriteActivity.this.dUZ();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nNK);
                if (WriteActivity.this.fmD != null) {
                    WriteActivity.this.fmD.bxk();
                }
            }
            WriteActivity.this.dVe();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iHh = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.UM(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean nPF = false;
    private TextWatcher nOl = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String nOp = "";
        private String nOq;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nOq = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nOq != null ? this.nOq.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dGr();
            WriteActivity.this.dVf();
            EditText dVr = WriteActivity.this.dVr();
            if (editable != null && dVr != null && dVr.getText() != null) {
                if (this.nOp == null || !this.nOp.equals(editable.toString())) {
                    if (WriteActivity.this.nOf != null) {
                        this.nOp = dVr.getText().toString();
                        WriteActivity.this.nOf.b(dVr, true);
                        return;
                    }
                    return;
                }
                dVr.setSelection(dVr.getSelectionEnd());
            }
        }
    };
    private TextWatcher nOm = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String nOq;
        private String nOr = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nOq = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nOq != null ? this.nOq.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dGr();
            EditText dVq = WriteActivity.this.dVq();
            if (editable != null && dVq != null && dVq.getText() != null) {
                if (this.nOr == null || !this.nOr.equals(editable.toString())) {
                    if (WriteActivity.this.nOf != null) {
                        this.nOr = dVq.getText().toString();
                        WriteActivity.this.nOf.b(dVq, false);
                        return;
                    }
                    return;
                }
                dVq.setSelection(dVq.getSelectionEnd());
            }
        }
    };
    private int nPG = 0;
    private final a.InterfaceC0853a lDe = new a.InterfaceC0853a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0853a
        public void onRefresh() {
            WriteActivity.this.kOV = null;
            WriteActivity.this.yR(false);
            WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void bzv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bzx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bzz();
        } else if (this.foO.dKG()) {
            bzv();
        } else {
            this.foO.xD(false);
            a(1, true, (String) null);
            this.foO.dKE();
        }
    }

    public void dVA() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.nOe != null) {
                this.nOe.dTI();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bzz();
        } else if (this.foO != null) {
            this.foO.xD(false);
            a(1, true, (String) null);
            this.foO.dKE();
        }
    }

    private void bzz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.os(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.foO.dKI();
                } else {
                    WriteActivity.this.fpb.bzM();
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
        aVar.bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dUY() {
        int selectionEnd = dVq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dVq().getText().getSpans(0, dVq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dVq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dVq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUZ() {
        if (this.fmD != null) {
            if (this.nPm != null && this.nPm.isVisible()) {
                this.fmD.setBarLauncherEnabled(!this.nOk);
                this.fmD.setDeskLauncherEnabled(!this.nOk);
                this.fmD.setToolEnabled(true, 2);
                this.fmD.setToolEnabled(true, 32);
                this.fmD.setToolEnabled(false, 10);
                this.fmD.setToolEnabled(false, 6);
                this.fmD.setToolEnabled(false, 18);
                this.fmD.rI(5).kg(false);
                if (this.nOe != null) {
                    this.nOe.yG(true);
                    return;
                }
                return;
            }
            this.fmD.setBarLauncherEnabled(!this.nOk);
            this.fmD.setDeskLauncherEnabled(this.nOk ? false : true);
            this.fmD.setToolEnabled(true, 26);
            this.fmD.setToolEnabled(true, 2);
            this.fmD.setToolEnabled(true, 30);
            this.fmD.rI(5).kg(true);
            if (this.nOe != null) {
                this.nOe.yG(true);
            }
            dWc();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.nOa) {
            this.mNr.setVisibility(8);
            if (this.mMZ.getType() == 5) {
                this.nOO.setVisibility(8);
            } else {
                this.nOO.setVisibility(0);
            }
            a(this.nOR, this.nOL);
            a(this.nOQ, this.nOP);
            dGr();
        }
        if (this.nOt) {
            this.nOk = true;
            dUZ();
            if (this.fmD != null) {
                this.fmD.bxk();
            }
            this.mNr.requestFocus();
            ShowSoftKeyPadDelay(this.mNr);
        }
        if (this.nPm != null) {
            this.nPm.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.nPm != null) {
            this.nPm.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.nPm != null) {
            this.nPm.onStop();
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
                    dVy();
                }
                yS(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mMZ.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.mMZ.setVideoInfo(null);
            }
            if (this.nPm == null) {
                this.nPm = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.mMZ.getVideoInfo() != null && this.mMZ.getVideoInfo().isEditVideoDataLegal()) {
                yQ(false);
                this.nPm.dWV();
                return;
            }
            yQ(true);
        }
    }

    public void Er(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void yQ(boolean z) {
        if (z) {
            this.mMZ.setVideoInfo(null);
            this.nPm.setVideoInfo(null);
            this.nOI.dWp().setVisibility(0);
            yR(false);
        } else {
            this.nPm.setVideoInfo(this.mMZ.getVideoInfo());
            this.writeImagesInfo.clear();
            this.nOI.dWp().setVisibility(8);
            dVS();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dGr();
        dUZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mMZ.getType() == 0) {
            Mj(this.bCm);
        }
        initUI();
        dVR();
        this.foO = new LocationModel(getPageContext());
        this.foO.a(this.fpb);
        registerListener(this.nat);
        registerListener(this.nOi);
        registerListener(this.mBackgroundListener);
        dWn();
        cWX();
        dWf();
        if (this.nOa) {
            this.nOK.setEditorTools(this.fmD);
        } else {
            this.nNK.requestFocus();
        }
        dAw();
        dVy();
        dWd();
        this.iHh.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iHh);
        dVB();
    }

    private void dVB() {
        UM(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cWX() {
        this.fmD = new EditorTools(getActivity());
        this.fmD.setBarMaxLauCount(5);
        this.fmD.setMoreButtonAtEnd(true);
        this.fmD.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fmD.setBarLauncherType(1);
        this.fmD.kc(true);
        this.fmD.kd(false);
        switch (this.mMZ.getType()) {
            case 4:
            case 5:
                dVE();
                break;
            default:
                dVa();
                break;
        }
        this.fmD.build();
        if (this.nNI != null) {
            this.nNI.addView(this.fmD);
        }
        cWz();
        this.fmD.display();
        com.baidu.tbadk.editortools.h rF = this.fmD.rF(6);
        if (rF != null && !TextUtils.isEmpty(this.foT)) {
            ((View) rF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.foT);
                }
            });
        }
        if (!this.nOa) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fmD.bxk();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dVF();
            return;
        }
        if (!this.nLa) {
            dVc();
        }
        dWg();
    }

    private void dVC() {
        this.nOM = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.nOO = this.nOM.findViewById(R.id.live_post_title_container);
        this.nOL = (EditText) this.nOM.findViewById(R.id.live_post_content);
        this.nOJ = (GridView) this.nOM.findViewById(R.id.photoLiveGridView);
        this.nOP = (EditText) this.nOM.findViewById(R.id.live_post_title);
        this.nOQ = (TextView) this.nOM.findViewById(R.id.titleOverPlusNumber);
        this.nOR = (TextView) this.nOM.findViewById(R.id.contentOverPlusNumber);
        this.nON = this.nOM.findViewById(R.id.live_interval_view);
        this.nOQ.setText(String.valueOf(20));
        this.nOR.setText(String.valueOf(233));
        this.nOM.setVisibility(0);
        this.nOQ.setVisibility(0);
        this.nOR.setVisibility(0);
        this.nOP.setHint(R.string.tips_title_limit_new);
        this.nOP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nOU = true;
                    WriteActivity.this.nOk = true;
                    WriteActivity.this.dUZ();
                    if (WriteActivity.this.fmD != null) {
                        WriteActivity.this.fmD.bxk();
                    }
                }
            }
        });
        if (this.mMZ.getType() == 4) {
            this.nOL.setHint(R.string.live_write_input_content_new);
        } else if (this.mMZ.getType() == 5) {
            this.nOL.setHint(R.string.live_write_input_content_update);
        }
        this.nOL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nOU = false;
                    WriteActivity.this.nOk = false;
                    WriteActivity.this.dUZ();
                    if (WriteActivity.this.fmD != null) {
                        WriteActivity.this.fmD.bxk();
                    }
                }
            }
        });
        this.nOL.requestFocus();
        this.nOL.addTextChangedListener(avH());
        this.nOP.requestFocus();
        this.nOP.addTextChangedListener(avH());
        this.nOP.setOnClickListener(this.nOj);
        this.nOL.setOnClickListener(this.nOj);
        this.nOK = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.nOJ);
        this.nOK.Ma(6);
        this.nOJ.setAdapter((ListAdapter) this.nOK);
        View findViewById = this.nOM.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dUA() {
                WriteActivity.this.dWa();
            }
        });
        dVD();
    }

    private void dVD() {
        if (this.mMZ.getType() == 0) {
            if (this.mMZ.getTitle() != null) {
                this.nOP.setText(this.mMZ.getTitle());
                this.nOP.setSelection(this.mMZ.getTitle().length());
                return;
            }
            return;
        }
        if (this.mMZ.getType() == 1 || this.mMZ.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.nOa) {
            dVY();
        }
        if (this.fmD.byR()) {
            this.fmD.bxk();
        }
        Mj(0);
    }

    public boolean dTx() {
        return !"1".equals(this.jlN) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.nOf != null) {
                if (this.nOf.d(spannable)) {
                    return true;
                }
            }
            if (bf.bqF().n(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void Mj(int i) {
        if (this.writeImagesInfo != null && this.mMZ != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mMZ.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mMZ.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dTx());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jlN);
            albumFloatActivityConfig.setProfessionZone(this.mMZ.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nHd);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.foT;
            antiData.setIfVoice(this.nOF);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mMZ.getFirstDir(), this.mMZ.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dVE() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fmD.bA(arrayList);
        com.baidu.tbadk.editortools.m rI = this.fmD.rI(5);
        if (rI != null) {
            rI.fnq = 2;
        }
        this.fmD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fmD.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dVa() {
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
            this.fmD.b(dVar);
        }
        if (!this.nLa) {
            Boolean dVV = dVV();
            if (!this.nOt && dVV != null && dVV.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dLk() && t.d(this.mMZ.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.fnq = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.fmD.b(mVar4);
                }
            }
        }
        if (!this.nLa && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.fnq = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fmD.b(mVar3);
            }
        }
        if (!this.nLa && !com.baidu.tieba.write.c.b.dUb()) {
            this.fmD.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nLa) {
            this.fmD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.fmD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (au.equals(this.jlN, "2")) {
            this.fmD.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.fmD.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.nLa && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.fns = true;
            mVar2.fnq = 9;
            mVar2.fnk = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fmD.b(mVar2);
            }
        }
        if (!this.nLa && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.fns = true;
            mVar.fnq = 10;
            mVar.fnk = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fmD.b(mVar);
            }
        }
        if (!this.nLa && this.nNP == null) {
            if (this.nOe == null) {
                this.nOe = new com.baidu.tieba.write.editor.b(getActivity(), this.jlN);
                this.nOe.LT(0);
                this.nOe.yF(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nOe.dTG();
                this.nOe.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dVA();
            }
            if (!y.isEmpty(this.mList)) {
                this.nOe.dTG();
            }
            this.fmD.b(this.nOe);
        }
        this.fmD.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        this.fmD.bA(arrayList);
        com.baidu.tbadk.editortools.m rI = this.fmD.rI(5);
        if (rI != null) {
            rI.fnq = 4;
        }
    }

    private void dVb() {
        if (this.nOg != null) {
            this.nOg.hideTip();
        }
    }

    private void dVF() {
        if (this.fmD != null) {
            this.fmD.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fmD != null && WriteActivity.this.fmD.fmG != null) {
                        if (WriteActivity.this.nPi == null) {
                            WriteActivity.this.nPi = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.nPi.showTip(WriteActivity.this.fmD.fmG.rG(2));
                    }
                }
            });
        }
    }

    private void dVG() {
        if (this.nPi != null) {
            this.nPi.hideTip();
        }
    }

    private void dVc() {
        if (this.nOg == null) {
            this.nOg = new g(getPageContext());
        }
        this.nOg.d(this.fmD);
    }

    private void cWz() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").ak("obj_locate", 9));
                        if (WriteActivity.this.dVp()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ar("c12612").ak("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u)) {
                            com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                            if (uVar.buc() == EmotionGroupType.BIG_EMOTION || uVar.buc() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.yS(true);
                                    WriteActivity.this.dGr();
                                }
                            } else if (WriteActivity.this.dVp()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dVs();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dkJ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dWc();
                        WriteActivity.this.dGr();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Mk(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.nNP == null) {
                            WriteActivity.this.bzA();
                            return;
                        }
                        switch (WriteActivity.this.foU) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bzx();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bzv();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.foO != null) {
                            WriteActivity.this.foO.xD(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.kOV = null;
                        } else {
                            WriteActivity.this.kOV = (String) aVar.data;
                        }
                        WriteActivity.this.yR(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dR("fid", WriteActivity.this.mMZ != null ? WriteActivity.this.mMZ.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.mMZ == null || (videoInfo = WriteActivity.this.mMZ.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fmD.byR()) {
                                        WriteActivity.this.fmD.bxk();
                                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mMZ.setVideoInfo(null);
                        WriteActivity.this.dGr();
                        if (WriteActivity.this.nNK != null) {
                            WriteActivity.this.nNK.requestFocus();
                        }
                        WriteActivity.this.fmD.bxk();
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nNK);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").ak("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.nNF = true;
                        WriteActivity.this.yO(true);
                        if (!WriteActivity.this.dVr().isFocused() || WriteActivity.this.nNJ.getVisibility() != 0) {
                            WriteActivity.this.nNE = "from_content";
                        } else {
                            WriteActivity.this.nNE = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").ak("obj_locate", 8));
                        if (WriteActivity.this.nNJ.getVisibility() == 0) {
                            if (WriteActivity.this.nNJ.hasFocus()) {
                                WriteActivity.this.nNK.requestFocus();
                                WriteActivity.this.nNK.setSelection(WriteActivity.this.nNK.getText().toString().length());
                            }
                            WriteActivity.this.nNJ.setVisibility(8);
                            if (WriteActivity.this.nPE != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.nPE.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.nPE.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.nOy.setVisibility(8);
                            WriteActivity.this.fmD.rF(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.nNJ.setVisibility(0);
                            if (WriteActivity.this.nPE != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.nPE.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.nPE.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.nOy.setVisibility(0);
                            WriteActivity.this.nNJ.requestFocus();
                            WriteActivity.this.fmD.rF(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dGr();
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
                            TiebaStatic.log(new ar("c12612").ak("obj_locate", 10));
                            if (WriteActivity.this.nPn != null && WriteActivity.this.nPn.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.nPn.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new ar("c13800").ak("obj_source", 2));
                        }
                        WriteActivity.this.dVH();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.nMm != null) {
                            WriteActivity.this.nMm.VK();
                        }
                        TiebaStatic.log(new ar("c12612").ak("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dTc();
                    }
                }
            }
        };
        this.fmD.setActionListener(16, bVar);
        this.fmD.setActionListener(14, bVar);
        this.fmD.setActionListener(24, bVar);
        this.fmD.setActionListener(3, bVar);
        this.fmD.setActionListener(10, bVar);
        this.fmD.setActionListener(11, bVar);
        this.fmD.setActionListener(12, bVar);
        this.fmD.setActionListener(13, bVar);
        this.fmD.setActionListener(15, bVar);
        this.fmD.setActionListener(18, bVar);
        this.fmD.setActionListener(20, bVar);
        this.fmD.setActionListener(25, bVar);
        this.fmD.setActionListener(27, bVar);
        this.fmD.setActionListener(29, bVar);
        this.fmD.setActionListener(43, bVar);
        this.fmD.setActionListener(56, bVar);
        this.fmD.setActionListener(48, bVar);
        this.fmD.setActionListener(46, bVar);
        this.fmD.setActionListener(49, bVar);
        this.fmD.setActionListener(47, bVar);
        this.fmD.setActionListener(55, bVar);
        this.fmD.setActionListener(58, bVar);
        this.fmD.setActionListener(22, bVar);
        this.fmD.setActionListener(21, bVar);
        this.fmD.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVH() {
        if (this.nOC != null) {
            this.nOC.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.nPG;
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
                        TiebaStatic.log(new ar("c13800").ak("obj_source", 3));
                    }
                };
                this.nPn.ap(onClickListener);
                this.nPn.setOnItemClickListener(onClickListener);
                this.nPn.b(writeVoteData);
                this.nPn.yU(true);
                dGr();
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
    public void Mk(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        if (this.foO.chG()) {
            if (this.foO.dKG()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dKB().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.foO.dKE();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dGj() {
        if (this.foP != null) {
            this.foP.cancelLoadData();
        }
        if (this.nNL != null) {
            this.nNL.cancelLoadData();
        }
        if (this.foO != null) {
            this.foO.cancelLoadData();
        }
        if (this.nPm != null) {
            this.nPm.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nPB);
        dVb();
        dVG();
        TiebaPrepareImageService.StopService();
        dGj();
        if (!this.nPF) {
            dVI();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.iUZ, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.nOI != null) {
            this.nOI.destroy();
        }
        if (this.nPh != null) {
            this.nPh.Si();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVI() {
        if (this.mMZ != null && this.mMZ.getType() == 2 && this.nOD) {
            finish();
        } else if (this.mMZ == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mMZ.setTitle(dVr().getText().toString());
            this.mMZ.setContent(dVq().getText().toString());
            int type = this.mMZ.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nLa) {
                        x.e(this.mMZ.getForumId(), this.mMZ);
                    } else {
                        x.d(this.mMZ.getForumId(), this.mMZ);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.mMZ);
                }
            } else if (type == 1) {
                x.f(this.mMZ.getThreadId(), this.mMZ);
            } else if (type == 4) {
                x.d(this.mMZ.getForumId() + "photolive", this.mMZ);
            } else if (type == 5) {
                x.f(this.mMZ.getThreadId() + "updatephotolive", this.mMZ);
            }
            this.nPF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVJ() {
        if (this.lwX == null || !this.lwX.isEnabled() || this.nPp) {
            cBZ();
            dVK();
            setResult(100);
            finish();
            return;
        }
        if (this.iVa == null) {
            this.iVa = new SaveDraftDialogView(this);
            this.iVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cBZ();
                            WriteActivity.this.dVK();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dVI();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.iUZ.dismiss();
                    }
                }
            });
        }
        if (this.iUZ == null) {
            this.iUZ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.iUZ.setContentView(this.iVa);
        }
        boolean z = (this.nPm == null || !this.nPm.isVisible() || this.mMZ == null || this.mMZ.getVideoInfo() == null || this.mMZ.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.iVa.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.iUZ.PA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBZ() {
        if (this.mMZ.getType() == 0 || this.mMZ.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nLa) {
                    x.e(this.mMZ.getForumId(), (WriteData) null);
                } else {
                    x.d(this.mMZ.getForumId(), (WriteData) null);
                }
            }
        } else if (this.mMZ.getType() == 1) {
            x.f(this.mMZ.getThreadId(), (WriteData) null);
        }
        this.nPF = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVK() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nmU));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mNx != null && this.mNx.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mNx, getPageContext().getPageActivity());
                return true;
            } else if (this.fmD.byR()) {
                this.fmD.bxk();
                return true;
            } else {
                dGj();
                dVJ();
                return true;
            }
        }
        if (i == 67 && (text = dVq().getText()) != null) {
            int selectionStart = dVq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dVq().onKeyDown(67, this.iuf);
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
        getLayoutMode().onModeChanged(this.jVZ);
        getLayoutMode().onModeChanged(this.nOY);
        ap.setBackgroundColor(this.jVZ, R.color.CAM_X0205);
        if (this.nOW != null && (i == 1 || i == 4)) {
            this.nOW.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lwX.setTextColor(ap.aQ(R.color.CAM_X0302, i));
        dUZ();
        ap.setBackgroundColor(this.mNs, R.color.CAM_X0204);
        ap.setBackgroundColor(this.nON, R.color.CAM_X0204);
        ap.setBackgroundColor(dVr(), R.color.CAM_X0205);
        this.lwh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.kOV)) {
            ap.setBackgroundColor(dVq(), R.color.CAM_X0205);
        }
        dGr();
        this.fmD.onChangeSkinType(i);
        if (this.nNY != null) {
            this.nNY.brT();
        }
        if (this.nPr != null) {
            this.nPr.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.nOI.nQe.notifyDataSetChanged();
        dVe();
        dVf();
        yR(false);
        if (this.nOf != null) {
            this.nOf.c(dVr(), dVq());
        }
        if (this.nPj != null) {
            this.nPj.onChangeSkinType();
        }
        if (this.nLw != null) {
            this.nLw.onChangeSkinType(i);
        }
        if (this.nPm != null) {
            this.nPm.changeSkin();
        }
        if (this.nPn != null) {
            this.nPn.onChangeSkinType(i);
        }
        if (this.nPw != null) {
            this.nPw.onChangeSkinType(i);
        }
        if (this.nOw != null) {
            this.nOw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVe() {
        if (this.mNr.hasFocus()) {
            this.mNr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.mNr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.nNK.hasFocus()) {
            this.nNK.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nNK.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVf() {
        if (this.mNr != null && this.mNr.getText() != null && this.mNr.getText().toString() != null && this.mNr.getPaint() != null) {
            if (this.mNr.getText().toString().length() == 0) {
                this.mNr.getPaint().setFakeBoldText(true);
            } else if (this.mNr.getText().toString().length() > 0) {
                this.mNr.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fxh = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nOa = this.mMZ.getType() == 4 || 5 == this.mMZ.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.nOB = (TextView) findViewById(R.id.btn_image_problem);
        dVi();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwX.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lwX.setLayoutParams(layoutParams);
        this.lwX.setOnFocusChangeListener(this.hbU);
        this.nNZ = (ScrollView) findViewById(R.id.write_scrollview);
        this.nNZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.nNK != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.nNK);
                    }
                    if (WriteActivity.this.fmD != null) {
                        WriteActivity.this.fmD.bxk();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nOz = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.nOA = findViewById(R.id.feedback_divider);
        this.jVZ = (RelativeLayout) findViewById(R.id.parent);
        this.nNI = (LinearLayout) findViewById(R.id.tool_view);
        this.nNI.setContentDescription(IStringUtil.TOP_PATH);
        this.nNJ = (LinearLayout) findViewById(R.id.title_view);
        this.nPE = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.nOy = findViewById(R.id.title_view_divider);
        this.mNs = findViewById(R.id.interval_view);
        this.nPd = findViewById(R.id.hot_topic_fourm_view);
        this.nPe = findViewById(R.id.hot_topic_divider);
        this.nOc = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.nPf = (TextView) findViewById(R.id.change_one_tv);
        dGq();
        if (this.nOa) {
            this.nNZ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dVC();
        } else {
            this.nOI = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nOI.yD(false);
            } else {
                this.nOI.yD(this.mMZ.getType() == 0 || this.mMZ.getType() == 9);
            }
            this.nPm = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.mMZ.getVideoInfo() != null && this.mMZ.getVideoInfo().isEditVideoDataLegal()) {
                yQ(false);
                this.nPm.dWV();
            } else {
                yQ(true);
            }
        }
        dGs();
        if (this.nOt || this.nNH) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eNv) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.mNu = (LinearLayout) findViewById(R.id.post_content_container);
        this.mNu.setDrawingCacheEnabled(false);
        this.mNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.nNK.requestFocus();
            }
        });
        this.lwe = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lwf = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lwh = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dkJ();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hbU);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dGj();
                WriteActivity.this.dVJ();
            }
        });
        this.nOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dVl();
        u(dVV());
        dVn();
        dVh();
        dVT();
        dUZ();
        dVm();
        dGp();
        dVt();
        if (this.mMZ.getType() == 4 && this.mNz != null && this.nNM != null) {
            this.mNz.setVisibility(8);
            this.nNM.setVisibility(8);
        }
        dGr();
        dVP();
        dUh();
        dVL();
        dVg();
        dVU();
        dVM();
        bOW();
    }

    private void dVL() {
        if ("main_tab".equals(this.mFrom)) {
            this.nPj = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.nPj.setVisibility(0);
        }
    }

    private void dVg() {
        this.nLw = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nLw.setBgColor(R.color.CAM_X0205);
        this.nPl = findViewById(R.id.frs_tab__divider);
        this.nLw.setData(this.nHd);
        if (this.nLw.getVisibility() == 0) {
            this.nPl.setVisibility(0);
        }
        this.nLw.setActivity(this);
    }

    private void dVM() {
        this.nPs = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.nPt = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.nPu = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.nPu, R.color.CAM_X0107);
        this.nPw = new EBusinessProtocolView(this);
        this.nPw.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.nPw.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.nPw, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.nPu.setText(spannableString);
        this.nPu.setMovementMethod(LinkMovementMethod.getInstance());
        this.nPt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nPx) {
                    WriteActivity.this.nPx = false;
                    WriteActivity.this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.nPx = true;
                    WriteActivity.this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.nPx) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.ou(R.color.CAM_X0105);
                    aVar.AI("");
                    aVar.AJ(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.ov(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bog();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.nPx = true;
            this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.nPx = false;
            this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.nPw.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void yM(boolean z) {
                if (z) {
                    if (!WriteActivity.this.nPx) {
                        WriteActivity.this.nPx = true;
                        WriteActivity.this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.nPx) {
                    WriteActivity.this.nPx = false;
                    WriteActivity.this.nPt.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void dVN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.nPG = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.nOC = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.nOC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.nOC.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nOC.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.nOC.setLayoutParams(layoutParams2);
        this.nOC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dVO();
            }
        });
        this.nOC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVO() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dUh() {
        if (this.mName != null && this.mMZ != null && this.mMZ.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dVh() {
        String str;
        String str2;
        if (this.mMZ != null) {
            switch (this.mMZ.getType()) {
                case 0:
                case 9:
                    if (this.nOt || this.nNH) {
                        if (this.nOv) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jlN != null && this.jlN.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nLa) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.jlN != null && this.jlN.equals("2")) {
                        if (StringUtils.isNull(this.mMZ.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mMZ.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mMZ.getForumName() + getResources().getString(R.string.bar));
                        this.mNr.setVisibility(8);
                        String str3 = this.iFX + " " + this.iFV;
                        if (!StringUtils.isNull(str3)) {
                            this.nNK.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.mNr.setVisibility(0);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mNr.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mMZ.getFloorNum() + 1)));
                    this.nON.setVisibility(8);
                    return;
                case 7:
                    this.mNr.setVisibility(0);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dVi() {
        if (this.mMZ.getType() == 7) {
            this.lwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dVj() {
        if (this.mMZ != null && this.mMZ.getType() == 0 && this.mMZ.getType() == 9 && !this.nOt && !this.nNH && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dVr() != null) {
                dVr().setText(cutStringWithSuffix);
                dVr().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.lwe.setVisibility(0);
            this.lwf.setVoiceModel(voiceModel);
            this.lwf.bYE();
            dGr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkJ() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Ca(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.lwe.setVisibility(8);
        this.lwf.cJS();
        this.lwf.setVoiceModel(null);
        com.baidu.tbadk.editortools.m rI = this.fmD.rI(6);
        if (rI != null && rI.fmx != null) {
            rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dGr();
    }

    private void dVk() {
        this.guu = null;
        this.nNV = -1;
        this.nNX = -1;
        com.baidu.tieba.frs.ah zC = ag.czR().zC(1);
        if (zC != null) {
            this.guu = zC.iME;
            this.nNV = getIntent().getIntExtra("category_id", -1);
            if (this.guu != null && !this.guu.isEmpty() && this.nNV >= 0) {
                this.nNU = new af();
                this.nNU.iMA = 0;
                this.nNU.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nNX = this.nNU.iMA;
                this.nNW = this.nNU.name;
                for (af afVar : this.guu) {
                    if (afVar.iMA == this.nNV) {
                        this.nNX = afVar.iMA;
                        this.nNW = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dVl() {
        if (this.guu != null && !this.guu.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nNY = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nNY.setText(this.nNW);
            this.nNY.setCategoryContainerData(this.guu, this.nNU, this.nNX);
            this.nNY.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.nNY.setText(bfVar.name);
                        WriteActivity.this.mMZ.setCategoryTo(bfVar.iMA);
                        WriteActivity.this.nNX = bfVar.iMA;
                        WriteActivity.this.nNY.dUC();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.nNY.dUB();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVq());
                }
            });
        }
    }

    private void dVP() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nOn = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nOn.setTitle(R.string.no_disturb_start_time);
        this.nOn.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nOn);
        this.nOn.setButton(-2, getPageContext().getString(R.string.cancel), this.nOn);
        return this.nOn;
    }

    private void dVm() {
        this.nNQ = (RelativeLayout) findViewById(R.id.addition_container);
        this.nNR = (TextView) findViewById(R.id.addition_create_time);
        this.nNS = (TextView) findViewById(R.id.addition_last_time);
        this.nNT = (TextView) findViewById(R.id.addition_last_content);
        if (this.nNP != null) {
            this.nNQ.setVisibility(0);
            this.nNR.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.nNP.getCreateTime() * 1000));
            if (this.nNP.getAlreadyCount() == 0) {
                this.nNS.setVisibility(8);
            } else {
                this.nNS.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.nNP.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nNP.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nNT.setText(lastAdditionContent);
            } else {
                this.nNT.setVisibility(8);
            }
            dVq().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nNP.getAlreadyCount()), Integer.valueOf(this.nNP.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nNQ.setVisibility(8);
    }

    private void dGp() {
        this.mNz = findViewById(R.id.post_prefix_layout);
        if (this.nPh == null) {
            this.nPh = new com.baidu.tieba.d.e(getPageContext(), this.mNz);
            this.nPh.fq(R.drawable.bg_tip_blue_up_left);
            this.nPh.fp(16);
            this.nPh.oJ(true);
            this.nPh.setUseDirectOffset(true);
            this.nPh.xO(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.mNw = (TextView) findViewById(R.id.post_prefix);
        this.nNM = findViewById(R.id.prefix_divider);
        this.mNy = (ImageView) findViewById(R.id.prefix_icon);
        dVQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVQ() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mNz.setVisibility(0);
            this.nNM.setVisibility(0);
            this.nPh.z(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mNa = 0;
            this.mNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.mMZ.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mNw.setVisibility(0);
                    WriteActivity.this.mNz.setSelected(true);
                    SvgManager.bqB().a(WriteActivity.this.mNy, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mNx, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fmD.bxk();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mNr);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nNK);
                }
            });
            this.mNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.mMZ.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mNw.setSelected(true);
                    SvgManager.bqB().a(WriteActivity.this.mNy, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mNx, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fmD.bxk();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVq());
                }
            });
            this.mNx = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mNx.a(this);
            this.mNx.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mNx.setOutsideTouchable(true);
            this.mNx.setFocusable(true);
            this.mNx.setOnDismissListener(this);
            this.mNx.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.bqB().a(this.mNy, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.mNw).oT(R.color.CAM_X0105).oV(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.nNN.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nNN.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yA(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.yA(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mNx.addView(writePrefixItemLayout);
            }
            this.mNx.setCurrentIndex(0);
            this.mNw.setText(prefixs.get(0));
            Mi(0);
            return;
        }
        this.mNz.setVisibility(8);
        this.nNM.setVisibility(8);
    }

    private void dVR() {
        if (this.nOt && this.mMZ != null) {
            this.nOz.setVisibility(0);
            this.nOA.setVisibility(0);
            this.nNL = new FeedBackModel(getPageContext());
            this.nNL.UI(this.mMZ.getForumName());
            this.nNL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.nOz.setVisibility(8);
                        WriteActivity.this.nOA.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.nOz.setVisibility(8);
                        WriteActivity.this.nOA.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.nOz.a(feedBackModel.dUK(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dVn() {
        this.lwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nPj == null || WriteActivity.this.nPk != null) {
                    if (WriteActivity.this.dWk()) {
                        if (!WriteActivity.this.nPz || WriteActivity.this.nPx) {
                            if (WriteActivity.this.dWm()) {
                                int dWl = WriteActivity.this.dWl();
                                if (dWl == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dWl == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.nOf.a(WriteActivity.this.mNr, WriteActivity.this.nNK)) {
                                    WriteActivity.this.showToast(WriteActivity.this.nOf.dSW());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVr());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dVq());
                                WriteActivity.this.fmD.bxk();
                                if (WriteActivity.this.mMZ.getType() != 7) {
                                    if (WriteActivity.this.nOt) {
                                        WriteActivity.this.cCc();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.ak("obj_type", StringUtils.isNull(WriteActivity.this.mMZ.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.dVw();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cCc();
                                }
                                MercatorModel.dKT().startLoad();
                                TiebaStatic.log(new ar("c12262").dR("obj_locate", WriteActivity.this.jlN));
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

    protected void dGq() {
        this.nOx = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.nOx.setIsRound(true);
        this.nOx.setDrawBorder(false);
        this.nOx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String Bk = q.Bk(currentPortrait);
            this.nOx.setUrl(Bk);
            this.nOx.startLoad(Bk, 12, false);
        }
        if (this.mMZ.isUserFeedback()) {
            this.nOx.setVisibility(0);
        }
        this.mNr = (EditText) findViewById(R.id.post_title);
        this.mNr.setOnClickListener(this.nOj);
        this.mNr.setOnFocusChangeListener(this.hbU);
        if (this.mMZ.getType() == 0 || this.mMZ.getType() == 9 || this.mMZ.getType() == 7) {
            if (this.mMZ.getTitle() != null) {
                this.mNr.setText(this.mMZ.getTitle());
                this.mNr.setSelection(this.mMZ.getTitle().length());
            } else if (this.nOv) {
                this.mNr.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mMZ.getType() == 1 || this.mMZ.getType() != 2) {
        }
        this.mNr.addTextChangedListener(this.nOl);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.mNr).oV(R.string.F_X02);
        if (!this.mMZ.getHaveDraft()) {
            dVj();
            this.nPc = true;
        }
        this.nOw = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher avH() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int nPK;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dGr();
                if (WriteActivity.this.nOa) {
                    this.nPK = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.nPK);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.nOa || !WriteActivity.this.nOU) {
                    if (WriteActivity.this.nOa) {
                        if (this.mEditText != WriteActivity.this.nOL || this.mTextView != WriteActivity.this.nOR) {
                            this.mEditText = WriteActivity.this.nOL;
                            this.mTextView = WriteActivity.this.nOR;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.nOP || this.mTextView != WriteActivity.this.nOQ) {
                    this.mEditText = WriteActivity.this.nOP;
                    this.mTextView = WriteActivity.this.nOQ;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.nOa && this.nOU) {
            if (this.nOS != null) {
                this.nOP.removeTextChangedListener(this.nOS);
            }
            this.nOS = textWatcher;
        } else if (this.nOa) {
            if (this.nOT != null) {
                this.nOL.removeTextChangedListener(this.nOT);
            }
            this.nOT = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.nOL) {
            return 233L;
        }
        if (editText != this.nOP) {
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
                    textView.setTextColor(ap.getColor(R.color.CAM_X0109));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ap.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ap.getColor(R.color.CAM_X0109));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.u(editText.getText().toString().trim());
    }

    protected void dGs() {
        this.nNK = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nNK.setDrawingCacheEnabled(false);
        this.nNK.setOnClickListener(this.nOj);
        this.nNK.setOnSpanGroupChangedListener(new a.InterfaceC0581a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0581a
            public void G(int i, boolean z) {
                WriteActivity.this.Lq();
            }
        });
        this.nNK.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.nNK.setForumId(com.baidu.adp.lib.f.b.toLong(this.mMZ.getForumId(), 0L));
        this.nNK.setTransLink(!this.nLa);
        if (this.foP != null) {
            this.foP.setSpanGroupManager(this.nNK.getSpanGroupManager());
        }
        if (this.mMZ != null) {
            this.mMZ.setSpanGroupManager(this.nNK.getSpanGroupManager());
        }
        if (this.mMZ.getContent() != null && this.mMZ.getContent().length() > 0) {
            this.nNK.setText(TbFaceManager.bAs().at(getPageContext().getPageActivity(), this.mMZ.getContent()));
            if (this.nNK.getText() != null) {
                this.nNK.setSelection(this.nNK.getText().length());
            }
        } else if (this.mMZ.getType() == 2) {
            if (this.nOD) {
                if (this.nOE != null && this.nOE.length() > 0) {
                    this.nNK.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.nOE}));
                    this.nNK.setSelection(this.nNK.getText().length());
                }
            } else if (this.mMZ.getFloorNum() > 0) {
                this.nNK.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mMZ.getFloorNum())));
                this.nNK.setSelection(this.nNK.getText().length());
            }
        }
        this.nNK.setOnFocusChangeListener(this.hbU);
        this.nNK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.nNK.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nNK.addTextChangedListener(this.nOm);
        if (this.mMZ.getType() == 0) {
            this.nPg = true;
        } else {
            yR(true);
            this.nPg = false;
        }
        if (this.mMZ.isUserFeedback()) {
            this.nNK.setHint(R.string.write_input_content);
        } else {
            this.nNK.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void yR(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.nOa && !this.nLa && dVq() != null) {
            dVq().setPadding(0, 0, 0, 0);
            dVq().setBackgroundDrawable(null);
            ap.setBackgroundColor(dVq(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.kOV) || this.nNP != null) {
                return;
            }
            if (this.nPm == null || !this.nPm.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.kOV, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass42) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.nPm == null || !WriteActivity.this.nPm.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dVq().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dVq(), true, WriteActivity.this.lDe);
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

    private void dVS() {
        if (dVq() != null) {
            dVq().setPadding(0, 0, 0, 0);
            dVq().setBackgroundDrawable(null);
            ap.setBackgroundColor(dVq(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVp() {
        int i = 5000;
        if (this.nNP != null) {
            i = 1000;
        }
        return dVq().getText() != null && dVq().getText().length() >= i;
    }

    private void Di(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nNE)) {
                this.nNE = "";
                dVq().requestFocus();
                if (dVq().getText() != null && dVq().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVq().getSelectionStart();
                    editable = dVq().getText();
                }
            } else if ("from_title".equals(this.nNE)) {
                this.nNE = "";
                dVr().requestFocus();
                if (dVr().getText() != null && dVr().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVr().getSelectionStart();
                    editable = dVr().getText();
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
    public void yO(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mMZ != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mMZ.getForumId(), 0L), this.mMZ.getFirstDir(), this.mMZ.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dVq().getText().getSpans(0, dVq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nNO == null) {
                this.nNO = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.nNO.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dVq());
    }

    EditText dVq() {
        return this.nOa ? this.nOL : this.nNK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVr() {
        return this.nOa ? this.nOP : this.mNr;
    }

    protected void dVs() {
        if (dVq().getSelectionStart() > 0) {
            String substring = dVq().getText().toString().substring(0, dVq().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iue.matcher(substring);
            if (matcher.find()) {
                dVq().getText().delete(dVq().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dVq().getSelectionStart());
                return;
            }
            dVq().onKeyDown(67, this.iuf);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.mMZ != null) {
            str = this.mMZ.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.nOt = true;
        }
    }

    private void dVT() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dVU() {
        this.nPo = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.nPn = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.nPo);
        ao(getIntent());
    }

    private void bOW() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.nPr = new d(getPageContext());
        this.nPr.a(this.nPq);
        this.mListView.setAdapter((ListAdapter) this.nPr);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.nPr != null && (WriteActivity.this.nPr.getItem(i) instanceof u)) {
                    u uVar = (u) WriteActivity.this.nPr.getItem(i);
                    if (uVar.mType == 1) {
                        if (uVar.eyD == 1) {
                            bf.bqF().b(WriteActivity.this.getPageContext(), new String[]{uVar.eyv});
                        } else {
                            bf.bqF().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eyv)});
                        }
                    } else if (uVar.mType == 2) {
                        if (!TextUtils.isEmpty(uVar.eyy)) {
                            if (uVar.eyy.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, uVar.eyy));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uVar.eyy));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(uVar.eyz)) {
                                bf.bqF().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eyz)});
                            }
                        } else if (!TextUtils.isEmpty(uVar.eyz)) {
                            bf.bqF().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eyz)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fxh.setCancelListener(null);
        this.fxh.setTipString(R.string.sending);
        this.fxh.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fxh.setDialogVisiable(false);
    }

    private Boolean dVV() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.nOF = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.foT = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.nOF);
    }

    public void dGr() {
        this.nPp = false;
        if (this.mMZ != null) {
            String str = "";
            String str2 = "";
            if (dVr() != null) {
                str = dVr().getText().toString();
            }
            if (dVq() != null) {
                str2 = dVq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mMZ.getType() == 0 || this.mMZ.getType() == 9 || this.mMZ.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.mNa == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mMZ.setIsNoTitle(true);
                        } else if (this.nNJ.getVisibility() == 0) {
                            this.mMZ.setIsNoTitle(false);
                            yP(true);
                            return;
                        }
                    } else if (this.nNJ.getVisibility() == 0) {
                        this.mMZ.setIsNoTitle(false);
                        yP(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mMZ.setIsNoTitle(true);
                } else if (this.nNJ.getVisibility() == 0) {
                    this.mMZ.setIsNoTitle(false);
                    yP(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nOa) {
                    yP(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yP(true);
                }
            }
            if (this.mMZ.getType() == 4) {
                yP(m(this.nOL) && l(this.nOP));
            } else if (this.mMZ.getType() == 5) {
                yP(m(this.nOL));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                yP(true);
            } else if (this.mMZ.getVideoInfo() != null) {
                yP(this.mMZ.getVideoInfo().isVideoMixFinished());
            } else if (dWi()) {
                yP(true);
                this.nPp = true;
            } else {
                yP(false);
            }
        }
    }

    public void yP(boolean z) {
        this.lwX.setEnabled(z);
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
        this.foP = new NewWriteModel(this);
        this.foP.b(this.fpd);
        registerListener(this.nPA);
        registerListener(this.nPB);
        registerListener(this.nPC);
        this.iyU = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.46
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dGj();
            }
        };
        this.mMZ = new WriteData();
        if (bundle != null) {
            this.mMZ.setType(bundle.getInt("type", 0));
            this.mMZ.setForumId(bundle.getString("forum_id"));
            this.mMZ.setForumName(bundle.getString("forum_name"));
            this.mMZ.setFirstDir(bundle.getString("forum_first_dir"));
            this.mMZ.setSecondDir(bundle.getString("forum_second_dir"));
            this.mMZ.setThreadId(bundle.getString("thread_id"));
            this.mMZ.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mMZ.setFloorNum(bundle.getInt("floor_num", 0));
            this.nOt = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.nOu = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nOv = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nOD = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nOE = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.foN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nNP = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mMZ.setIsAddition(this.nNP != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.nOG = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mMZ.setTitle(bundle.getString("write_title"));
            this.mMZ.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mMZ.setTopicId(this.mTopicId);
            this.jlN = bundle.getString("KEY_CALL_FROM");
            this.bCm = bundle.getInt("album_thread");
            this.nHd = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mMZ.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mMZ.setType(intent.getIntExtra("type", 0));
            this.mMZ.setForumId(intent.getStringExtra("forum_id"));
            this.mMZ.setForumName(intent.getStringExtra("forum_name"));
            this.mMZ.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mMZ.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mMZ.setThreadId(intent.getStringExtra("thread_id"));
            this.mMZ.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mMZ.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nOt = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.nOu = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nOv = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nOD = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nOE = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.nNP = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mMZ.setIsAddition(this.nNP != null);
            this.mMZ.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.nOG = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.iFW = intent.getStringExtra("more_forum_img");
            this.iFX = intent.getStringExtra("more_forum_title");
            this.iFV = intent.getStringExtra("more_forum_url");
            this.mMZ.setTitle(intent.getStringExtra("write_title"));
            this.mMZ.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mMZ.setTopicId(this.mTopicId);
            this.jlN = intent.getStringExtra("KEY_CALL_FROM");
            this.bCm = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nHd = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mMZ.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mMZ.mDynamicImageTextData = new ImageTextUploadData();
            this.nLa = true;
        }
        if (this.mMZ.getType() == 9) {
            this.mMZ.setEntranceType(1);
        } else if (this.mMZ.getType() == 10) {
            this.mMZ.setEntranceType(2);
            this.mMZ.setType(9);
        } else if (this.mMZ.getType() == 0) {
            this.mMZ.setEntranceType(3);
        }
        this.mMZ.setIsUserFeedback(this.nOt);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mMZ.getType() == 4 ? 6 : 9);
        this.mMZ.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mMZ.getType() == 0 || this.mMZ.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nLa) {
                    x.d(this.mMZ.getForumId(), this);
                } else {
                    x.c(this.mMZ.getForumId(), this);
                }
            }
        } else if (this.mMZ.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.mMZ.getType() == 1) {
            x.a(this.mMZ.getThreadId(), this);
        } else if (this.mMZ.getType() == 4) {
            x.c(this.mMZ.getForumId() + "photolive", this);
        } else if (this.mMZ.getType() == 5) {
            x.a(this.mMZ.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.kOV = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mMZ != null && this.mMZ.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mMZ.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nNH = true;
        }
        dVk();
        try {
            this.nOV = dWe();
        } catch (Throwable th) {
            this.nOV = null;
        }
    }

    private void dVt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mNr.setText(com.baidu.tbadk.plugins.b.DN(com.baidu.tbadk.plugins.b.DO(hotTopicBussinessData.mTopicName)));
            this.mNr.setMovementMethod(com.baidu.tieba.view.c.dSx());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString DN = com.baidu.tbadk.plugins.b.DN(com.baidu.tbadk.plugins.b.DO(hotTopicBussinessData.mTopicName));
            if (DN != null) {
                this.mNr.setText(DN);
            }
            this.nOc.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.nPz) {
            if (writeData != null) {
                if (this.mMZ != null) {
                    boolean z = this.mMZ.getVideoInfo() != null && this.mMZ.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.mMZ.getWriteImagesInfo() == null || y.isEmpty(this.mMZ.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dVr().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dVq().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = au.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bAs().a(getPageContext().getPageActivity(), writeData.getContent(), this.nOh));
                    if (!z || z7) {
                        this.mMZ.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.nPc || ((this.nOt || this.nNH) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.nOt || this.nNH)) {
                            j(writeData);
                        }
                        if (this.mMZ != null && !this.mMZ.getHaveDraft()) {
                            dVj();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dVW();
                        }
                        dGr();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.guu != null) {
                            this.nNX = this.nNU.iMA;
                            this.nNW = this.nNU.name;
                            while (true) {
                                if (i == this.guu.size()) {
                                    break;
                                }
                                af afVar = this.guu.get(i);
                                if (categoryTo != afVar.iMA) {
                                    i++;
                                } else {
                                    this.nNX = categoryTo;
                                    this.nNW = afVar.name;
                                    this.mMZ.setCategoryTo(this.nNX);
                                    break;
                                }
                            }
                            if (this.nNY != null) {
                                this.nNY.setText(this.nNW);
                                this.nNY.setCategoryContainerData(this.guu, this.nNU, this.nNX);
                            }
                        }
                        this.fmD.bxk();
                        return;
                    }
                    return;
                }
                return;
            }
            dVW();
            dVj();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mMZ.setVideoInfo(videoInfo);
            yQ(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mMZ.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dVy();
        }
        yS(false);
        yQ(true);
    }

    private void i(WriteData writeData) {
        String str;
        String DO;
        if (com.baidu.adp.lib.util.k.isEmpty(this.mMZ.getTitle())) {
            this.mMZ.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                DO = this.mMZ.getTitle();
            } else {
                DO = com.baidu.tbadk.plugins.b.DO(str);
            }
            SpannableString DN = com.baidu.tbadk.plugins.b.DN(DO);
            if (DN != null) {
                dVr().setText(DN);
                dVr().setSelection(DN.length() > DO.length() ? DO.length() : DN.length());
                return;
            }
            return;
        }
        SpannableString DN2 = com.baidu.tbadk.plugins.b.DN(this.mMZ.getTitle());
        if (DN2 != null) {
            dVr().setText(DN2);
            dVr().setSelection(this.mMZ.getTitle().length() > DN2.length() ? DN2.length() : this.mMZ.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.mMZ.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bAs().a(getPageContext().getPageActivity(), this.mMZ.getContent(), this.nOh);
        InputFilter[] filters = this.nNK.getFilters();
        this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dVq().setText(a2);
        if (dVq() == this.nNK && this.nNK.getSpanGroupManager() != null) {
            this.nNK.bsG();
            this.nNK.getSpanGroupManager().bsM();
            this.nNK.bsH();
            Lq();
        }
        this.nNK.setFilters(filters);
        if (dVq().getText() != null) {
            dVq().setSelection(dVq().getText().length());
        }
        if (this.nOa) {
            a(this.nOR, this.nOL);
        }
    }

    private void dVW() {
        if ((!this.nOa || this.nOK != null) && this.nOJ != null) {
            this.nOK.b(this.writeImagesInfo);
            dWa();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mMZ.getType());
        bundle.putString("forum_id", this.mMZ.getForumId());
        bundle.putString("forum_name", this.mMZ.getForumName());
        bundle.putString("forum_first_dir", this.mMZ.getFirstDir());
        bundle.putString("forum_second_dir", this.mMZ.getSecondDir());
        bundle.putString("thread_id", this.mMZ.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mMZ.getFloor());
        bundle.putInt("floor_num", this.mMZ.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.nOD);
        if (this.nOt) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.foN);
        if (this.nNP != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nNP));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.nOG);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jlN);
        bundle.putInt("album_thread", this.bCm);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nHd);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dVq().getEditableText().toString();
        if (obj != null) {
            dVq().setText(TbFaceManager.bAs().a(getPageContext().getPageActivity(), obj, this.nOh));
            dVq().setSelection(dVq().getText().length());
        }
    }

    private String getContent() {
        return (dVq() == null || dVq().getText() == null) ? "" : dVq().getText().toString();
    }

    private String dVv() {
        if (this.mMZ == null || dVr() == null || dVr().getVisibility() != 0 || dVr().getText() == null) {
            return "";
        }
        String obj = dVr().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mNa != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mMZ.getType() != 4 && this.mNw != null && this.mNw.getText() != null) {
            this.mMZ.setPostPrefix(this.mNw.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mMZ.getTitle();
        }
        return obj;
    }

    private void UJ(String str) {
        if (this.mMZ != null && this.nNJ != null) {
            if (this.nNJ.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mMZ.setIsNoTitle(true);
                    this.mMZ.setTitle("");
                    return;
                }
                this.mMZ.setIsNoTitle(false);
                this.mMZ.setTitle(str);
                return;
            }
            this.mMZ.setIsNoTitle(true);
            this.mMZ.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCc() {
        dGj();
        this.mMZ.setContent(getContent());
        UJ(dVv());
        if (this.nOt || this.nNH) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mMZ.getTitle()) || !this.mMZ.getTitle().startsWith(string)) {
                UJ(string + this.mMZ.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mMZ.getContent()) || !this.mMZ.getContent().startsWith(str)) {
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
                sb.append(this.mMZ.getContent());
                this.mMZ.setContent(sb.toString());
            }
        }
        if (this.nOu) {
            this.mMZ.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.nNV >= 0) {
            this.mMZ.setCategoryFrom(this.nNV);
        }
        if (this.nNX >= 0) {
            this.mMZ.setCategoryTo(this.nNX);
        }
        this.mMZ.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nPn != null) {
            this.mMZ.setWriteVoteData(this.nPn.getWriteVoteData());
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
            this.mMZ.setTakePhotoNum(i);
        }
        this.mMZ.setHasLocationData(this.foO != null && this.foO.chG());
        if (this.writeImagesInfo != null) {
            this.foP.xF(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.nOb != null && this.nOb.mIsGlobalBlock == 0) {
            this.mMZ.setForumId(String.valueOf(this.nOb.mForumId));
            this.mMZ.setForumName(this.nOb.mForumName);
        }
        dUk();
        this.foP.e(this.mMZ);
        this.mMZ.setContent(this.mMZ.getContent().replaceAll("\u0000\n", ""));
        this.mMZ.setContent(this.mMZ.getContent().replaceAll("\u0000", ""));
        this.mMZ.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.foP.cXs().setVoice(this.mVoiceModel.getId());
                this.foP.cXs().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.foP.cXs().setVoice(null);
                this.foP.cXs().setVoiceDuringTime(-1);
            }
        } else {
            this.foP.cXs().setVoice(null);
            this.foP.cXs().setVoiceDuringTime(-1);
        }
        if (!this.foP.dLo()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mMZ.mDynamicImageTextData != null) {
            dUj();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iyU);
            this.foP.dLl();
        }
    }

    private void dUk() {
        FrsTabItemData selectedTabItemData;
        if (this.mMZ != null && this.nLw != null && (selectedTabItemData = this.nLw.getSelectedTabItemData()) != null) {
            this.mMZ.setTabId(selectedTabItemData.tabId);
            this.mMZ.setTabName(selectedTabItemData.name);
            this.mMZ.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dUj() {
        if (this.mMZ.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.mMZ, new a.InterfaceC0876a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                @Override // com.baidu.tieba.write.b.a.InterfaceC0876a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dTS().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.47.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cBZ();
                            x.e(WriteActivity.this.mMZ.getForumId(), (WriteData) null);
                            WriteActivity.this.dVK();
                            com.baidu.tieba.write.b.a.dTM();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.kn(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dTM();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0876a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void I(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.nNP != null) {
                i2 = this.nNP.getTotalCount();
                i = this.nNP.getAlreadyCount() + 1;
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
                if (this.mNr == getCurrentFocus()) {
                    dVq().clearFocus();
                    this.mNr.requestFocus();
                    if (this.fmD != null) {
                        this.fmD.bxk();
                    }
                    ShowSoftKeyPadDelay(this.mNr);
                } else {
                    dVq().requestFocus();
                    if (this.fmD != null) {
                        this.fmD.bxk();
                    }
                    ShowSoftKeyPadDelay(this.nNK);
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
                            dVq().getText().insert(dVq().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cBZ();
                dVK();
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
                                dWb();
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
                        yQ(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.nPg) {
                            yR(true);
                            this.nPg = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.nOa) {
                        F(intent);
                        dGr();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mMZ.setVideoInfo(videoInfo);
                        this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fmD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dGr();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.nNF) {
                                sb2.append(com.baidu.tbadk.plugins.b.fwA);
                                this.nNF = false;
                            }
                            sb2.append(stringExtra);
                            Di(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.nOb = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.nOb);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.nNK.getSelectionStart();
                    int selectionEnd = this.nNK.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.nNK.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fmD != null && !this.fmD.byR()) {
                this.nNK.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fmD.bxk();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bzD();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dVZ();
                    if (this.nPg) {
                        yR(true);
                        this.nPg = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.mNr == getCurrentFocus()) {
                        dVq().clearFocus();
                        this.mNr.requestFocus();
                        if (this.fmD != null) {
                            this.fmD.bxk();
                        }
                        ShowSoftKeyPadDelay(this.mNr);
                        return;
                    }
                    dVq().requestFocus();
                    if (this.fmD != null) {
                        this.fmD.bxk();
                    }
                    ShowSoftKeyPadDelay(this.nNK);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.nOf.Ul(postWriteCallBackData.getErrorString());
                        this.nOf.bl(postWriteCallBackData.getSensitiveWords());
                        this.nOf.b(this.mNr, this.nNK);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.foN = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.foN);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dVZ();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nNE)) {
                        dVr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nNE)) {
                        dVq().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVw() {
        if ("1".equals(this.jlN)) {
            this.mMZ.setCanNoForum(true);
            this.mMZ.setTransmitForumData("[]");
        } else if ("2".equals(this.jlN)) {
            this.mMZ.setCanNoForum(false);
        }
        dVx();
        this.mMZ.setPrivacy(this.isPrivacy);
        dVX();
        this.mMZ.setToDynamic(this.isToDynamic);
        this.mMZ.setCallFrom(this.jlN);
        if (this.mMZ.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cCc();
    }

    private void dVx() {
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dVX() {
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dVY() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dVZ() {
        if (this.nOa) {
            this.nOK.b(this.writeImagesInfo);
            dWa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWa() {
        this.nOK.notifyDataSetChanged();
        this.nOJ.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.nOK.notifyDataSetChanged();
                WriteActivity.this.nOJ.invalidateViews();
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
        dGr();
    }

    private void ap(Intent intent) {
        if (this.nOa) {
            aq(intent);
            dVZ();
        } else {
            at(intent);
        }
        dGr();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dVZ();
            yS(true);
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

    private void dWb() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.nOH.parseJson(stringExtra);
            this.nOH.updateQuality();
            if (this.nOH.getChosedFiles() != null && this.nOH.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.nOH.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.nOH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dVr());
        HidenSoftKeyPad(this.mInputManager, dVq());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.nPm != null) {
            this.nPm.onPause();
        }
        if (this.fmD.byR()) {
            this.fmD.bxk();
        }
    }

    private void at(Intent intent) {
        d(intent, true);
    }

    private void E(Intent intent) {
        this.foN = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.foN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.foN, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dWc();
            dVy();
        }
        yS(true);
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
                dWc();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dVy();
                }
            }
            yS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dWc() {
        if (this.fmD.rI(10) != null) {
            this.fmD.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bzD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.50
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.foN));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dWd() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.iFW)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.iFW, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.51
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
                            WriteActivity.this.yS(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS(boolean z) {
        String forumId = this.mMZ == null ? "" : this.mMZ.getForumId();
        if (this.nOI != null) {
            this.nOI.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cyn() {
        this.iIc = getVoiceManager();
        this.iIc.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iJy) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mMZ.getType() != 7) {
                if (this.nNP == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                I(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.foU = i;
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dVy() {
        if (!this.nOa) {
            if (this.fmD != null) {
                this.fmD.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fmD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mMZ == null ? "" : this.mMZ.getForumId();
            if (this.nOI != null) {
                this.nOI.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Mi(int i) {
        if (i < this.nNN.size()) {
            for (int i2 = 0; i2 < this.nNN.size(); i2++) {
                this.nNN.get(i2).yB(false);
            }
            this.nNN.get(i).yB(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void JJ(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").ak("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").ak("obj_type", 2));
        }
        this.mNa = i;
        this.mNx.setCurrentIndex(i);
        Mi(i);
        this.mNw.setText(this.mPrefixData.getPrefixs().get(i));
        dGr();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mNx, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mNz.setSelected(false);
        SvgManager.bqB().a(this.mNy, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.nNK);
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
        if (this.mMZ != null) {
            if (this.mMZ.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mMZ.getType() == 5) {
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
            bzx();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.foN);
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
        this.blo = z;
        if (this.nPa && System.currentTimeMillis() - this.nPb < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.nPa = false;
        }
        if (this.nOe != null && !z) {
            this.nOe.crO();
        }
        if (this.nOg != null && !z) {
            dVb();
        }
        if (this.nPi != null && !z) {
            dVG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UK(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.nOX != null) {
            UL(str);
            this.nOX.dismiss();
        }
    }

    private void gc(Context context) {
        nOZ = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void UL(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.nPa = true;
        dWc();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dVy();
        }
        yS(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5448=4] */
    private static Bitmap g(String str, float f) {
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

    private File dWe() {
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

    private void dWf() {
        if (this.nOV != null && this.mMZ.getType() == 0 && this.mMZ.getType() == 9) {
            gc(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.nOV != null) {
                        WriteActivity.this.UK(WriteActivity.this.nOV.getAbsolutePath());
                    }
                }
            });
            this.nOW = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.nOY = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.nOV.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.nOV.getAbsolutePath());
                Bitmap g = g(this.nOV.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.nOW.setImageBitmap(g);
                    this.nOW.setDrawBorder(true);
                    this.nOW.setBorderWidth(2);
                    this.nOW.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.nOX = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.nOX.setCanceledOnTouchOutside(true);
                    this.nOX.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.nPa) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.nPb = System.currentTimeMillis();
                            }
                        }
                    });
                    this.nOX.setContentView(this.mBubbleView);
                    this.nOX.show();
                    Window window = this.nOX.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (nOZ / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.blo && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nNF = false;
            this.nNE = "";
            if ("from_content".equals(str)) {
                this.nNE = "from_content";
            } else if ("from_title".equals(str)) {
                this.nNE = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DM(String.valueOf(charSequence.charAt(i)))) {
                yO(false);
            }
        }
    }

    public void dAw() {
        if (com.baidu.tieba.write.c.b.dUb()) {
            this.mNr.setHint(R.string.title_hint_for_hot);
            this.nNJ.setVisibility(0);
            if (this.nPE != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nPE.getLayoutParams();
                layoutParams.topMargin = 0;
                this.nPE.setLayoutParams(layoutParams);
            }
            this.nOy.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.nOw);
            this.nNJ.requestFocus();
            return;
        }
        this.nOw.setVisibility(8);
        this.mNr.setHint(this.nOt ? R.string.feedback_title_hint : R.string.post_title_hint);
        if (this.nOt || !y.isEmpty(this.mList) || (this.mMZ != null && !StringUtils.isNull(this.mMZ.getTitle()))) {
            this.nNJ.setVisibility(0);
            if (this.nPE != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nPE.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.nPE.setLayoutParams(layoutParams2);
            }
            this.nOy.setVisibility(0);
            this.nNJ.requestFocus();
            return;
        }
        this.nNJ.setVisibility(8);
        if (this.nPE != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.nPE.getLayoutParams();
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
            this.nPE.setLayoutParams(layoutParams3);
        }
        this.nOy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWg() {
        if (this.fmD != null) {
            this.fmD.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nLa && WriteActivity.this.fmD != null && WriteActivity.this.fmD.fmG != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bqF().l(clipBoardContent)) {
                            WriteActivity.this.nOe.dta();
                            return;
                        }
                        if (WriteActivity.this.nMm == null) {
                            WriteActivity.this.nMm = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.nPD);
                        }
                        WriteActivity.this.nMm.a(WriteActivity.this.fmD.fmG.rG(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jlN;
    }

    public WriteData cXs() {
        return this.mMZ;
    }

    public FrsTabInfoData dWh() {
        return this.nHd;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dWi() {
        return (this.nPn == null || this.nPo == null || this.nPn.getWriteVoteData() == null || this.nPo.getVisibility() != 0) ? false : true;
    }

    public void dTc() {
        if (this.mMZ != null) {
            TiebaStatic.log(new ar("c13897").ak("obj_locate", 2).dR("fid", this.mMZ.getForumId()).dR("fname", this.mMZ.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ov(2);
            aVar.iX(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new ar("c13959").ak("obj_locate", 2).dR("fid", WriteActivity.this.mMZ != null ? WriteActivity.this.mMZ.getForumId() : "").dR("fname", WriteActivity.this.mMZ != null ? WriteActivity.this.mMZ.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dWj()));
                    }
                }
            });
            aVar.bg(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new ar("c13958").ak("obj_locate", 2).dR("fid", this.mMZ != null ? this.mMZ.getForumId() : "").dR("fname", this.mMZ != null ? this.mMZ.getForumName() : ""));
            aVar.b(getPageContext()).bog();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dWj()));
    }

    public void Lq() {
        if (this.nPr != null && this.nPr.dUM() == null && this.nNK != null && this.nNK.getSpanGroupManager() != null) {
            this.nPr.h(this.nNK.getSpanGroupManager().bsR());
            this.nPr.refreshData();
        } else if (this.nPr != null && this.nPr.dUM() != null) {
            this.nPr.refreshData();
        }
        if (this.nPr != null) {
            gf(this.nPr.dUL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(List<u> list) {
        boolean z;
        if (list != null) {
            Iterator<u> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().mType == 2) {
                    z = true;
                    break;
                }
            }
            if (!z && this.nPs != null) {
                this.nPs.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UM(String str) {
        this.nPv = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.nPv.add(com.baidu.tieba.j.a.eb(jSONObject));
                }
                if (this.nPv.size() > 0) {
                    this.nPz = true;
                    this.nNK.m(this.nPv, arrayList);
                    dVN();
                    Lq();
                    this.nPs.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dWj() {
        if (this.nNK == null || this.nNK.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.nNK.getSpanGroupManager().bsS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWk() {
        return this.canGoods || this.nNK == null || this.nNK.getSpanGroupManager() == null || this.nNK.getSpanGroupManager().bsS() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dWl() {
        boolean z = this.nPr == null || this.nPr.dUN();
        boolean z2 = (this.nLw == null || this.nLw.getSelectedTabItemData() == null || this.nLw.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWm() {
        if (this.nHd == null || y.isEmpty(this.nHd.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nHd.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dWn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.57
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yr(false).Ue(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aF((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
