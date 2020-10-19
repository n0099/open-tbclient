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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0224a, VoiceManager.c, x.a, i.a {
    private static int nvf = 0;
    private EditorTools eZf;
    private String fbp;
    private LocationModel fbq;
    private NewWriteModel fbr;
    List<af> geX;
    private com.baidu.tbadk.core.dialog.i iBU;
    private SaveDraftDialogView iBV;
    private String imN;
    private String imO;
    private String imP;
    private VoiceManager ioV;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout ldo;
    private PlayVoiceBntNew ldp;
    private ImageView ldr;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int mtB;
    private TextView mtX;
    private com.baidu.tieba.write.i mtY;
    private ImageView mtZ;
    private View mua;
    private FrsTabInfoData nnh;
    private ForumTabSelectedView nrC;
    private FindNewLinkBubbleController nss;
    private LinearLayout ntN;
    private LinearLayout ntO;
    private View ntR;
    private Toast ntT;
    private AdditionData ntU;
    private RelativeLayout ntV;
    private TextView ntW;
    private TextView ntX;
    private TextView ntY;
    af ntZ;
    private TitleTipView nuC;
    private View nuE;
    private View nuG;
    private i nuO;
    private int nua;
    private String nub;
    private int nuc;
    private PostCategoryView nud;
    private HotTopicBussinessData nug;
    private TextView nuh;
    private com.baidu.tieba.write.editor.b nuj;
    private g nul;
    private com.baidu.tieba.view.b nut;
    private TextView nvA;
    private List<com.baidu.tieba.i.a> nvB;
    private EBusinessProtocolView nvC;
    private View nvj;
    private View nvk;
    private TextView nvl;
    private com.baidu.tieba.c.e nvn;
    private b nvo;
    private ForumSelectedView nvp;
    private com.baidu.tbadk.data.i nvq;
    private View nvr;
    private com.baidu.tieba.write.write.video.a nvs;
    private com.baidu.tieba.write.write.vote.a nvt;
    private RelativeLayout nvu;
    private boolean nvv;
    private d nvx;
    private LinearLayout nvy;
    private ImageView nvz;
    private int privateThread;
    private String ntJ = "";
    private boolean ntK = false;
    protected WriteData mtA = null;
    private boolean nuz = false;
    private boolean nuA = false;
    private boolean ntM = false;
    private boolean nuB = false;
    private InputMethodManager mInputManager = null;
    private EditText mtS = null;
    private HeadImageView nuD = null;
    private View mtT = null;
    private LinearLayout mtV = null;
    private SpanGroupEditText ntP = null;
    private FeedBackModel ntQ = null;
    private FeedBackTopListView nuF = null;
    private ArrayList<WritePrefixItemLayout> ntS = new ArrayList<>();
    private String kwp = null;
    private final KeyEvent iaS = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView nuH = null;
    private TextView leh = null;
    private TextView mName = null;
    private ImageView nuI = null;
    private DialogInterface.OnCancelListener ifK = null;
    private final Handler mHandler = new Handler();
    private boolean nuJ = false;
    private String nuK = null;
    private RelativeLayout jCT = null;
    public boolean nuL = true;
    public String fbv = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fbw = 0;
    private int nuM = 0;
    private WriteImagesInfo nuN = new WriteImagesInfo();
    private View mRootView = null;
    private GridView nuP = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a nuQ = null;
    private ScrollView nue = null;
    private EditText nuR = null;
    private View nuS = null;
    private View nuT = null;
    private View nuU = null;
    private EditText nuV = null;
    private TextView nuW = null;
    private TextView nuX = null;
    private TextWatcher nuY = null;
    private TextWatcher nuZ = null;
    private boolean nuf = false;
    private boolean nva = false;
    private com.baidu.tbadk.core.view.a fjB = null;
    private String mFrom = "write";
    private File nvb = null;
    private TbImageView nvc = null;
    private View mBubbleView = null;
    private Dialog nvd = null;
    private LinearLayout nve = null;
    private boolean nvg = false;
    private long nvh = -1000;
    private boolean nvi = false;
    private String iSJ = "2";
    private int bvy = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder nui = new SpannableStringBuilder();
    private boolean nvm = false;
    private boolean bkk = false;
    private final c nuk = new c();
    private boolean nrg = false;
    private final d.a nvw = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void KY(int i) {
            if (WriteActivity.this.ntP != null) {
                WriteActivity.this.ntP.pT(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void fO(List<t> list) {
            WriteActivity.this.fP(list);
        }
    };
    private boolean nvD = false;
    private int nvE = 0;
    private boolean nvF = false;
    private final HttpMessageListener nvG = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.kwp)) {
                    WriteActivity.this.kwp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.yk(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.kwp)) {
                    WriteActivity.this.kwp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.kwp);
                    WriteActivity.this.yk(true);
                }
            }
        }
    };
    private CustomMessageListener nvH = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.mtA != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").aj("obj_locate", 1).dK("fid", WriteActivity.this.mtA.getForumId()).dK("fname", WriteActivity.this.mtA.getForumName()));
            }
        }
    };
    private final CustomMessageListener nvI = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nvp != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                WriteActivity.this.nvq = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                if (WriteActivity.this.nvq != null && !StringUtils.isNull(WriteActivity.this.nvq.forumId) && !StringUtils.isNull(WriteActivity.this.nvq.forumName)) {
                    if (WriteActivity.this.mtA != null) {
                        WriteActivity.this.mtA.setForumId(WriteActivity.this.nvq.forumId);
                        WriteActivity.this.mtA.setForumName(WriteActivity.this.nvq.forumName);
                    }
                    WriteActivity.this.nvp.setSelectedForum(WriteActivity.this.nvq.forumName);
                    WriteActivity.this.nnh = null;
                    if (!y.isEmpty(WriteActivity.this.nvq.tabInfoList)) {
                        WriteActivity.this.nnh = new FrsTabInfoData();
                        WriteActivity.this.nnh.selectedTabId = -1;
                        WriteActivity.this.nnh.tabList = WriteActivity.this.nvq.tabInfoList;
                    }
                    WriteActivity.this.nrC.setData(WriteActivity.this.nnh);
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.nvq.eXW != null && !y.isEmpty(WriteActivity.this.nvq.eXW.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.nvq.eXW;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.dQj();
                }
            }
        }
    };
    private TbFaceManager.a nun = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ds(String str) {
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
    private final AntiHelper.a iqr = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a nvJ = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.58
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.nss != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.nss.SU();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.59
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ctc();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.nvK = true;
            if (postWriteCallBackData != null && WriteActivity.this.mtA != null) {
                WriteActivity.this.nuk.bh(null);
                if (z) {
                    WriteActivity.this.jQ(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.mtA);
                    WriteActivity.this.cwN();
                    WriteActivity.this.dQd();
                    if ((WriteActivity.this.mtA.getType() == 0 || WriteActivity.this.mtA.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dK("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mtA.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mtA.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.mtA.getForumName())) {
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
                    WriteActivity.this.nuk.bh(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.nuk.TK(postWriteCallBackData.getErrorString());
                    WriteActivity.this.nuk.b(WriteActivity.this.mtS, WriteActivity.this.ntP);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AH(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AH(postWriteCallBackData.getErrorString());
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
                    aVar.b(WriteActivity.this.getPageContext()).bkJ();
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
                    writeData.setVcodeExtra(ahVar.bqD());
                    if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC());
                        if (WriteActivity.this.nuB) {
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
    private final LocationModel.a fbD = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bwe() {
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
    private final CustomMessageListener mGK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fbq.wW(false);
                    WriteActivity.this.fbq.go(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fbq.wW(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nuo = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dQz();
            }
        }
    };
    private final View.OnClickListener nup = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dPr = WriteActivity.this.dPr();
            if (dPr >= 0 && dPr < WriteActivity.this.ntP.getText().length()) {
                WriteActivity.this.ntP.setSelection(dPr);
            }
        }
    };
    private boolean nuq = true;
    private final View.OnFocusChangeListener gKu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mtS || view == WriteActivity.this.mBack || view == WriteActivity.this.leh) {
                if (z) {
                    WriteActivity.this.nuq = true;
                    WriteActivity.this.dPs();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mtS);
                    if (WriteActivity.this.eZf != null) {
                        WriteActivity.this.eZf.btC();
                    }
                } else if (view == WriteActivity.this.mtS) {
                    WriteActivity.this.mtX.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.ntP && z) {
                WriteActivity.this.nuq = false;
                WriteActivity.this.dPs();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.ntP);
                if (WriteActivity.this.eZf != null) {
                    WriteActivity.this.eZf.btC();
                }
            }
            WriteActivity.this.dPx();
        }
    };
    private com.baidu.tbadk.mutiprocess.h ioa = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Ul(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean nvK = false;
    private TextWatcher nur = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String nuv = "";
        private String nuw;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nuw = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nuw != null ? this.nuw.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dAQ();
            WriteActivity.this.dPy();
            EditText dPK = WriteActivity.this.dPK();
            if (editable != null && dPK != null && dPK.getText() != null) {
                if (this.nuv == null || !this.nuv.equals(editable.toString())) {
                    if (WriteActivity.this.nuk != null) {
                        this.nuv = dPK.getText().toString();
                        WriteActivity.this.nuk.b(dPK, true);
                        return;
                    }
                    return;
                }
                dPK.setSelection(dPK.getSelectionEnd());
            }
        }
    };
    private TextWatcher nus = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String nuw;
        private String nux = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nuw = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nuw != null ? this.nuw.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dAQ();
            EditText dPJ = WriteActivity.this.dPJ();
            if (editable != null && dPJ != null && dPJ.getText() != null) {
                if (this.nux == null || !this.nux.equals(editable.toString())) {
                    if (WriteActivity.this.nuk != null) {
                        this.nux = dPJ.getText().toString();
                        WriteActivity.this.nuk.b(dPJ, false);
                        return;
                    }
                    return;
                }
                dPJ.setSelection(dPJ.getSelectionEnd());
            }
        }
    };
    private int nvL = 0;
    private final a.InterfaceC0821a lkm = new a.InterfaceC0821a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0821a
        public void onRefresh() {
            WriteActivity.this.kwp = null;
            WriteActivity.this.yk(false);
            WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void bvN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bvP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bvR();
        } else if (this.fbq.dEX()) {
            bvN();
        } else {
            this.fbq.wW(false);
            a(1, true, (String) null);
            this.fbq.dEV();
        }
    }

    public void dPT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.nuj != null) {
                this.nuj.dOb();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bvR();
        } else if (this.fbq != null) {
            this.fbq.wW(false);
            a(1, true, (String) null);
            this.fbq.dEV();
        }
    }

    private void bvR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ob(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fbq.dEZ();
                } else {
                    WriteActivity.this.fbD.bwe();
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
        aVar.bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dPr() {
        int selectionEnd = dPJ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dPJ().getText().getSpans(0, dPJ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dPJ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dPJ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPs() {
        if (this.eZf != null) {
            if (this.nvs != null && this.nvs.isVisible()) {
                this.eZf.setBarLauncherEnabled(!this.nuq);
                this.eZf.setDeskLauncherEnabled(!this.nuq);
                this.eZf.setToolEnabled(true, 2);
                this.eZf.setToolEnabled(true, 32);
                this.eZf.setToolEnabled(false, 10);
                this.eZf.setToolEnabled(false, 6);
                this.eZf.setToolEnabled(false, 18);
                this.eZf.qP(5).jJ(false);
                if (this.nuj != null) {
                    this.nuj.xZ(true);
                    return;
                }
                return;
            }
            this.eZf.setBarLauncherEnabled(!this.nuq);
            this.eZf.setDeskLauncherEnabled(this.nuq ? false : true);
            this.eZf.setToolEnabled(true, 26);
            this.eZf.setToolEnabled(true, 2);
            this.eZf.setToolEnabled(true, 30);
            this.eZf.qP(5).jJ(true);
            if (this.nuj != null) {
                this.nuj.xZ(true);
            }
            dQv();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.nuf) {
            this.mtS.setVisibility(8);
            if (this.mtA.getType() == 5) {
                this.nuU.setVisibility(8);
            } else {
                this.nuU.setVisibility(0);
            }
            a(this.nuX, this.nuR);
            a(this.nuW, this.nuV);
            dAQ();
        }
        if (this.nuz) {
            this.nuq = true;
            dPs();
            if (this.eZf != null) {
                this.eZf.btC();
            }
            this.mtS.requestFocus();
            ShowSoftKeyPadDelay(this.mtS);
        }
        if (this.nvs != null) {
            this.nvs.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.nvs != null) {
            this.nvs.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.nvs != null) {
            this.nvs.onStop();
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
                    dPR();
                }
                yl(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mtA.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.mtA.setVideoInfo(null);
            }
            if (this.nvs == null) {
                this.nvs = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.mtA.getVideoInfo() != null && this.mtA.getVideoInfo().isEditVideoDataLegal()) {
                yj(false);
                this.nvs.dRo();
                return;
            }
            yj(true);
        }
    }

    public void Ej(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void yj(boolean z) {
        if (z) {
            this.mtA.setVideoInfo(null);
            this.nvs.setVideoInfo(null);
            this.nuO.dQI().setVisibility(0);
            yk(false);
        } else {
            this.nvs.setVideoInfo(this.mtA.getVideoInfo());
            this.writeImagesInfo.clear();
            this.nuO.dQI().setVisibility(8);
            dQl();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dAQ();
        dPs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mtA.getType() == 0) {
            Lb(this.bvy);
        }
        initUI();
        dQk();
        this.fbq = new LocationModel(getPageContext());
        this.fbq.a(this.fbD);
        registerListener(this.mGK);
        registerListener(this.nuo);
        registerListener(this.mBackgroundListener);
        dQG();
        cRT();
        dQy();
        if (this.nuf) {
            this.nuQ.setEditorTools(this.eZf);
        } else {
            this.ntP.requestFocus();
        }
        dvq();
        dPR();
        dQw();
        this.ioa.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.ioa);
        dPU();
    }

    private void dPU() {
        Ul(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cRT() {
        this.eZf = new EditorTools(getActivity());
        this.eZf.setBarMaxLauCount(5);
        this.eZf.setMoreButtonAtEnd(true);
        this.eZf.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.eZf.setBarLauncherType(1);
        this.eZf.jF(true);
        this.eZf.jG(true);
        switch (this.mtA.getType()) {
            case 4:
            case 5:
                dPX();
                break;
            default:
                dPt();
                break;
        }
        this.eZf.build();
        if (this.ntN != null) {
            this.ntN.addView(this.eZf);
        }
        cRl();
        this.eZf.display();
        com.baidu.tbadk.editortools.h qM = this.eZf.qM(6);
        if (qM != null && !TextUtils.isEmpty(this.fbv)) {
            ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fbv);
                }
            });
        }
        if (!this.nuf) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eZf.btC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.blO().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dPY();
            return;
        }
        if (!this.nrg) {
            dPv();
        }
        dQz();
    }

    private void dPV() {
        this.nuS = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.nuU = this.nuS.findViewById(R.id.live_post_title_container);
        this.nuR = (EditText) this.nuS.findViewById(R.id.live_post_content);
        this.nuP = (GridView) this.nuS.findViewById(R.id.photoLiveGridView);
        this.nuV = (EditText) this.nuS.findViewById(R.id.live_post_title);
        this.nuW = (TextView) this.nuS.findViewById(R.id.titleOverPlusNumber);
        this.nuX = (TextView) this.nuS.findViewById(R.id.contentOverPlusNumber);
        this.nuT = this.nuS.findViewById(R.id.live_interval_view);
        this.nuW.setText(String.valueOf(20));
        this.nuX.setText(String.valueOf(233));
        this.nuS.setVisibility(0);
        this.nuW.setVisibility(0);
        this.nuX.setVisibility(0);
        this.nuV.setHint(R.string.tips_title_limit_new);
        this.nuV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nva = true;
                    WriteActivity.this.nuq = true;
                    WriteActivity.this.dPs();
                    if (WriteActivity.this.eZf != null) {
                        WriteActivity.this.eZf.btC();
                    }
                }
            }
        });
        if (this.mtA.getType() == 4) {
            this.nuR.setHint(R.string.live_write_input_content_new);
        } else if (this.mtA.getType() == 5) {
            this.nuR.setHint(R.string.live_write_input_content_update);
        }
        this.nuR.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nva = false;
                    WriteActivity.this.nuq = false;
                    WriteActivity.this.dPs();
                    if (WriteActivity.this.eZf != null) {
                        WriteActivity.this.eZf.btC();
                    }
                }
            }
        });
        this.nuR.requestFocus();
        this.nuR.addTextChangedListener(arU());
        this.nuV.requestFocus();
        this.nuV.addTextChangedListener(arU());
        this.nuV.setOnClickListener(this.nup);
        this.nuR.setOnClickListener(this.nup);
        this.nuQ = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.nuP);
        this.nuQ.KS(6);
        this.nuP.setAdapter((ListAdapter) this.nuQ);
        View findViewById = this.nuS.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dOT() {
                WriteActivity.this.dQt();
            }
        });
        dPW();
    }

    private void dPW() {
        if (this.mtA.getType() == 0) {
            if (this.mtA.getTitle() != null) {
                this.nuV.setText(this.mtA.getTitle());
                this.nuV.setSelection(this.mtA.getTitle().length());
                return;
            }
            return;
        }
        if (this.mtA.getType() == 1 || this.mtA.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.nuf) {
            dQr();
        }
        if (this.eZf.bvj()) {
            this.eZf.btC();
        }
        Lb(0);
    }

    public boolean dNQ() {
        return !"1".equals(this.iSJ) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.nuk != null) {
                if (this.nuk.d(spannable)) {
                    return true;
                }
            }
            if (be.bmY().m(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void Lb(int i) {
        if (this.writeImagesInfo != null && this.mtA != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mtA.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mtA.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dNQ());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iSJ);
            albumFloatActivityConfig.setProfessionZone(this.mtA.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nnh);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fbv;
            antiData.setIfVoice(this.nuL);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mtA.getFirstDir(), this.mtA.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dPX() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.eZf.bj(arrayList);
        com.baidu.tbadk.editortools.m qP = this.eZf.qP(5);
        if (qP != null) {
            qP.eZS = 2;
        }
        this.eZf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.eZf.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dPt() {
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
            this.eZf.b(dVar);
        }
        if (!this.nrg) {
            Boolean dQo = dQo();
            if (!this.nuz && dQo != null && dQo.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dFB() && com.baidu.tieba.tbadkCore.t.d(this.mtA.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.eZS = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eZf.b(mVar4);
                }
            }
        }
        if (!this.nrg && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.eZS = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eZf.b(mVar3);
            }
        }
        if (!this.nrg && !com.baidu.tieba.write.c.b.dOu()) {
            this.eZf.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nrg) {
            this.eZf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eZf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.iSJ, "2")) {
            this.eZf.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eZf.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.nrg && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.eZU = true;
            mVar2.eZS = 9;
            mVar2.eZM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eZf.b(mVar2);
            }
        }
        if (!this.nrg && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.eZU = true;
            mVar.eZS = 10;
            mVar.eZM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eZf.b(mVar);
            }
        }
        if (!this.nrg && this.ntU == null) {
            if (this.nuj == null) {
                this.nuj = new com.baidu.tieba.write.editor.b(getActivity(), this.iSJ);
                this.nuj.KL(0);
                this.nuj.xY(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nuj.dNZ();
                this.nuj.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dPT();
            }
            if (!y.isEmpty(this.mList)) {
                this.nuj.dNZ();
            }
            this.eZf.b(this.nuj);
        }
        if (!this.nrg && this.canGoods) {
            this.eZf.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.eZf.bj(arrayList);
        com.baidu.tbadk.editortools.m qP = this.eZf.qP(5);
        if (qP != null) {
            qP.eZS = 4;
        }
    }

    private void dPu() {
        if (this.nul != null) {
            this.nul.hideTip();
        }
    }

    private void dPY() {
        if (this.eZf != null) {
            this.eZf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.eZf != null && WriteActivity.this.eZf.eZi != null) {
                        if (WriteActivity.this.nvo == null) {
                            WriteActivity.this.nvo = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.nvo.showTip(WriteActivity.this.eZf.eZi.qN(2));
                    }
                }
            });
        }
    }

    private void dPZ() {
        if (this.nvo != null) {
            this.nvo.hideTip();
        }
    }

    private void dPv() {
        if (this.nul == null) {
            this.nul = new g(getPageContext());
        }
        this.nul.d(this.eZf);
    }

    private void cRl() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 9));
                        if (WriteActivity.this.dPI()) {
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
                            if (uVar.bqt() == EmotionGroupType.BIG_EMOTION || uVar.bqt() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.yl(true);
                                    WriteActivity.this.dAQ();
                                }
                            } else if (WriteActivity.this.dPI()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dPL();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dfD();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dQv();
                        WriteActivity.this.dAQ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Lc(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.ntU == null) {
                            WriteActivity.this.bvS();
                            return;
                        }
                        switch (WriteActivity.this.fbw) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bvP();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bvN();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fbq != null) {
                            WriteActivity.this.fbq.wW(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.kwp = null;
                        } else {
                            WriteActivity.this.kwp = (String) aVar.data;
                        }
                        WriteActivity.this.yk(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dK("fid", WriteActivity.this.mtA != null ? WriteActivity.this.mtA.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.mtA == null || (videoInfo = WriteActivity.this.mtA.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.eZf.bvj()) {
                                        WriteActivity.this.eZf.btC();
                                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mtA.setVideoInfo(null);
                        WriteActivity.this.dAQ();
                        if (WriteActivity.this.ntP != null) {
                            WriteActivity.this.ntP.requestFocus();
                        }
                        WriteActivity.this.eZf.btC();
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.ntP);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.ntK = true;
                        WriteActivity.this.yh(true);
                        if (!WriteActivity.this.dPK().isFocused() || WriteActivity.this.ntO.getVisibility() != 0) {
                            WriteActivity.this.ntJ = "from_content";
                        } else {
                            WriteActivity.this.ntJ = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 8));
                        if (WriteActivity.this.ntO.getVisibility() == 0) {
                            if (WriteActivity.this.ntO.hasFocus()) {
                                WriteActivity.this.ntP.requestFocus();
                                WriteActivity.this.ntP.setSelection(WriteActivity.this.ntP.getText().toString().length());
                            }
                            WriteActivity.this.ntO.setVisibility(8);
                            WriteActivity.this.nuE.setVisibility(8);
                            WriteActivity.this.eZf.qM(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.ntO.setVisibility(0);
                            WriteActivity.this.nuE.setVisibility(0);
                            WriteActivity.this.ntO.requestFocus();
                            WriteActivity.this.eZf.qM(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dAQ();
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
                            if (WriteActivity.this.nvt != null && WriteActivity.this.nvt.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.nvt.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new aq("c13800").aj("obj_source", 2));
                        }
                        WriteActivity.this.dQa();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.nss != null) {
                            WriteActivity.this.nss.SU();
                        }
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dNv();
                    }
                }
            }
        };
        this.eZf.setActionListener(16, bVar);
        this.eZf.setActionListener(14, bVar);
        this.eZf.setActionListener(24, bVar);
        this.eZf.setActionListener(3, bVar);
        this.eZf.setActionListener(10, bVar);
        this.eZf.setActionListener(11, bVar);
        this.eZf.setActionListener(12, bVar);
        this.eZf.setActionListener(13, bVar);
        this.eZf.setActionListener(15, bVar);
        this.eZf.setActionListener(18, bVar);
        this.eZf.setActionListener(20, bVar);
        this.eZf.setActionListener(25, bVar);
        this.eZf.setActionListener(27, bVar);
        this.eZf.setActionListener(29, bVar);
        this.eZf.setActionListener(43, bVar);
        this.eZf.setActionListener(56, bVar);
        this.eZf.setActionListener(48, bVar);
        this.eZf.setActionListener(46, bVar);
        this.eZf.setActionListener(49, bVar);
        this.eZf.setActionListener(47, bVar);
        this.eZf.setActionListener(55, bVar);
        this.eZf.setActionListener(58, bVar);
        this.eZf.setActionListener(22, bVar);
        this.eZf.setActionListener(21, bVar);
        this.eZf.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQa() {
        if (this.nuI != null) {
            this.nuI.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.nvL;
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
                this.nvt.ao(onClickListener);
                this.nvt.setOnItemClickListener(onClickListener);
                this.nvt.b(writeVoteData);
                this.nvt.yn(true);
                dAQ();
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
    public void Lc(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        if (this.fbq.ccF()) {
            if (this.fbq.dEX()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dES().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fbq.dEV();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dAI() {
        if (this.fbr != null) {
            this.fbr.cancelLoadData();
        }
        if (this.ntQ != null) {
            this.ntQ.cancelLoadData();
        }
        if (this.fbq != null) {
            this.fbq.cancelLoadData();
        }
        if (this.nvs != null) {
            this.nvs.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nvH);
        dPu();
        dPZ();
        TiebaPrepareImageService.StopService();
        dAI();
        if (!this.nvK) {
            dQb();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.iBU, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.nuO != null) {
            this.nuO.destroy();
        }
        if (this.nvn != null) {
            this.nvn.Po();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQb() {
        if (this.mtA != null && this.mtA.getType() == 2 && this.nuJ) {
            finish();
        } else if (this.mtA == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mtA.setTitle(dPK().getText().toString());
            this.mtA.setContent(dPJ().getText().toString());
            int type = this.mtA.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nrg) {
                        x.e(this.mtA.getForumId(), this.mtA);
                    } else {
                        x.d(this.mtA.getForumId(), this.mtA);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.mtA);
                }
            } else if (type == 1) {
                x.f(this.mtA.getThreadId(), this.mtA);
            } else if (type == 4) {
                x.d(this.mtA.getForumId() + "photolive", this.mtA);
            } else if (type == 5) {
                x.f(this.mtA.getThreadId() + "updatephotolive", this.mtA);
            }
            this.nvK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQc() {
        if (this.leh == null || !this.leh.isEnabled() || this.nvv) {
            cwN();
            dQd();
            setResult(100);
            finish();
            return;
        }
        if (this.iBV == null) {
            this.iBV = new SaveDraftDialogView(this);
            this.iBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cwN();
                            WriteActivity.this.dQd();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dQb();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.iBU.dismiss();
                    }
                }
            });
        }
        if (this.iBU == null) {
            this.iBU = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.iBU.setContentView(this.iBV);
        }
        boolean z = (this.nvs == null || !this.nvs.isVisible() || this.mtA == null || this.mtA.getVideoInfo() == null || this.mtA.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.iBV.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.iBU.Pd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwN() {
        if (this.mtA.getType() == 0 || this.mtA.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nrg) {
                    x.e(this.mtA.getForumId(), (WriteData) null);
                } else {
                    x.d(this.mtA.getForumId(), (WriteData) null);
                }
            }
        } else if (this.mtA.getType() == 1) {
            x.f(this.mtA.getThreadId(), (WriteData) null);
        }
        this.nvK = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQd() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mTq));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mtY != null && this.mtY.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mtY, getPageContext().getPageActivity());
                return true;
            } else if (this.eZf.bvj()) {
                this.eZf.btC();
                return true;
            } else {
                dAI();
                dQc();
                return true;
            }
        }
        if (i == 67 && (text = dPJ().getText()) != null) {
            int selectionStart = dPJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dPJ().onKeyDown(67, this.iaS);
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
        getLayoutMode().onModeChanged(this.jCT);
        getLayoutMode().onModeChanged(this.nve);
        ap.setBackgroundColor(this.jCT, R.color.cp_bg_line_e);
        if (this.nvc != null && (i == 1 || i == 4)) {
            this.nvc.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.leh.setTextColor(ap.aO(R.color.cp_link_tip_a, i));
        dPs();
        ap.setBackgroundColor(this.mtT, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.nuT, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dPK(), R.color.cp_bg_line_e);
        ap.setImageResource(this.ldr, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.kwp)) {
            ap.setBackgroundColor(dPJ(), R.color.cp_bg_line_e);
        }
        dAQ();
        this.eZf.onChangeSkinType(i);
        if (this.nud != null) {
            this.nud.bok();
        }
        if (this.nvx != null) {
            this.nvx.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nuO.nwj.notifyDataSetChanged();
        dPx();
        dPy();
        yk(false);
        if (this.nuk != null) {
            this.nuk.c(dPK(), dPJ());
        }
        if (this.nvp != null) {
            this.nvp.onChangeSkinType();
        }
        if (this.nrC != null) {
            this.nrC.onChangeSkinType(i);
        }
        if (this.nvs != null) {
            this.nvs.changeSkin();
        }
        if (this.nvt != null) {
            this.nvt.onChangeSkinType(i);
        }
        if (this.nvC != null) {
            this.nvC.onChangeSkinType(i);
        }
        if (this.nuC != null) {
            this.nuC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPx() {
        if (this.mtS.hasFocus()) {
            this.mtS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mtS.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.ntP.hasFocus()) {
            this.ntP.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.ntP.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPy() {
        if (this.mtS != null && this.mtS.getText() != null && this.mtS.getText().toString() != null && this.mtS.getPaint() != null) {
            if (this.mtS.getText().toString().length() == 0) {
                this.mtS.getPaint().setFakeBoldText(false);
            } else if (this.mtS.getText().toString().length() > 0) {
                this.mtS.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fjB = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nuf = this.mtA.getType() == 4 || 5 == this.mtA.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nuH = (TextView) findViewById(R.id.btn_image_problem);
        dPB();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leh.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.leh.setLayoutParams(layoutParams);
        this.leh.setOnFocusChangeListener(this.gKu);
        this.nue = (ScrollView) findViewById(R.id.write_scrollview);
        this.nue.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.ntP != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.ntP);
                    }
                    if (WriteActivity.this.eZf != null) {
                        WriteActivity.this.eZf.btC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nuF = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.nuG = findViewById(R.id.feedback_divider);
        this.jCT = (RelativeLayout) findViewById(R.id.parent);
        this.ntN = (LinearLayout) findViewById(R.id.tool_view);
        this.ntN.setContentDescription(IStringUtil.TOP_PATH);
        this.ntO = (LinearLayout) findViewById(R.id.title_view);
        this.nuE = findViewById(R.id.title_view_divider);
        this.mtT = findViewById(R.id.interval_view);
        this.nvj = findViewById(R.id.hot_topic_fourm_view);
        this.nvk = findViewById(R.id.hot_topic_divider);
        this.nuh = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.nvl = (TextView) findViewById(R.id.change_one_tv);
        dAP();
        if (this.nuf) {
            this.nue.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dPV();
        } else {
            this.nuO = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nuO.xW(false);
            } else {
                this.nuO.xW(this.mtA.getType() == 0 || this.mtA.getType() == 9);
            }
            this.nvs = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.mtA.getVideoInfo() != null && this.mtA.getVideoInfo().isEditVideoDataLegal()) {
                yj(false);
                this.nvs.dRo();
            } else {
                yj(true);
            }
        }
        dAR();
        if (this.nuz || this.ntM) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eAg) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.mtV = (LinearLayout) findViewById(R.id.post_content_container);
        this.mtV.setDrawingCacheEnabled(false);
        this.mtV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.ntP.requestFocus();
            }
        });
        this.ldo = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.ldp = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.ldr = (ImageView) findViewById(R.id.iv_delete_voice);
        this.ldr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dfD();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gKu);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dAI();
                WriteActivity.this.dQc();
            }
        });
        this.nuH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dPE();
        u(dQo());
        dPG();
        dPA();
        dQm();
        dPs();
        dPF();
        dAO();
        dPM();
        if (this.mtA.getType() == 4 && this.mua != null && this.ntR != null) {
            this.mua.setVisibility(8);
            this.ntR.setVisibility(8);
        }
        dAQ();
        dQi();
        dOA();
        dQe();
        dPz();
        dQn();
        dQf();
        bKB();
    }

    private void dQe() {
        if ("main_tab".equals(this.mFrom)) {
            this.nvp = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.nvp.setVisibility(0);
        }
    }

    private void dPz() {
        this.nrC = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nvr = findViewById(R.id.frs_tab__divider);
        this.nrC.setData(this.nnh);
        if (this.nrC.getVisibility() == 0) {
            this.nvr.setVisibility(0);
        }
        this.nrC.setActivity(this);
    }

    private void dQf() {
        this.nvy = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.nvz = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.nvA = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.nvA, R.color.cp_cont_j);
        this.nvC = new EBusinessProtocolView(this);
        this.nvC.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.nvC.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.nvC, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.nvA.setText(spannableString);
        this.nvA.setMovementMethod(LinkMovementMethod.getInstance());
        this.nvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nvD) {
                    WriteActivity.this.nvD = false;
                    WriteActivity.this.nvz.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.nvD = true;
                    WriteActivity.this.nvz.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.nvD) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.od(R.color.cp_cont_b);
                    aVar.AG("");
                    aVar.AH(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.oe(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bkJ();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.nvD = true;
            this.nvz.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.nvD = false;
            this.nvz.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.nvC.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void yf(boolean z) {
                if (z) {
                    if (!WriteActivity.this.nvD) {
                        WriteActivity.this.nvD = true;
                        WriteActivity.this.nvz.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.nvD) {
                    WriteActivity.this.nvD = false;
                    WriteActivity.this.nvz.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dQg() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.nvL = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.nuI = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.nuI, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.nuI.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nuI.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.nuI.setLayoutParams(layoutParams2);
        this.nuI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dQh();
            }
        });
        this.nuI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQh() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dOA() {
        if (this.mName != null && this.mtA != null && this.mtA.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dPA() {
        String str;
        String str2;
        if (this.mtA != null) {
            switch (this.mtA.getType()) {
                case 0:
                case 9:
                    if (this.nuz || this.ntM) {
                        if (this.nuB) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iSJ != null && this.iSJ.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nrg) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iSJ != null && this.iSJ.equals("2")) {
                        if (StringUtils.isNull(this.mtA.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mtA.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mtA.getForumName() + getResources().getString(R.string.bar));
                        this.mtS.setVisibility(8);
                        String str3 = this.imP + " " + this.imN;
                        if (!StringUtils.isNull(str3)) {
                            this.ntP.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.mtS.setVisibility(0);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mtS.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mtA.getFloorNum() + 1)));
                    this.nuT.setVisibility(8);
                    return;
                case 7:
                    this.mtS.setVisibility(0);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dPB() {
        if (this.mtA.getType() == 7) {
            this.leh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.leh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dPC() {
        if (this.mtA != null && this.mtA.getType() == 0 && this.mtA.getType() == 9 && !this.nuz && !this.ntM && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dPK() != null) {
                dPK().setText(cutStringWithSuffix);
                dPK().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.ldo.setVisibility(0);
            this.ldp.setVoiceModel(voiceModel);
            this.ldp.bTK();
            dAQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfD() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BU(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.ldo.setVisibility(8);
        this.ldp.cEF();
        this.ldp.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qP = this.eZf.qP(6);
        if (qP != null && qP.eYZ != null) {
            qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dAQ();
    }

    private void dPD() {
        this.geX = null;
        this.nua = -1;
        this.nuc = -1;
        com.baidu.tieba.frs.ah yy = ag.cuG().yy(1);
        if (yy != null) {
            this.geX = yy.ity;
            this.nua = getIntent().getIntExtra("category_id", -1);
            if (this.geX != null && !this.geX.isEmpty() && this.nua >= 0) {
                this.ntZ = new af();
                this.ntZ.itu = 0;
                this.ntZ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nuc = this.ntZ.itu;
                this.nub = this.ntZ.name;
                for (af afVar : this.geX) {
                    if (afVar.itu == this.nua) {
                        this.nuc = afVar.itu;
                        this.nub = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dPE() {
        if (this.geX != null && !this.geX.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nud = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nud.setText(this.nub);
            this.nud.setCategoryContainerData(this.geX, this.ntZ, this.nuc);
            this.nud.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.nud.setText(bfVar.name);
                        WriteActivity.this.mtA.setCategoryTo(bfVar.itu);
                        WriteActivity.this.nuc = bfVar.itu;
                        WriteActivity.this.nud.dOV();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.nud.dOU();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPK());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPJ());
                }
            });
        }
    }

    private void dQi() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nut = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nut.setTitle(R.string.no_disturb_start_time);
        this.nut.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nut);
        this.nut.setButton(-2, getPageContext().getString(R.string.cancel), this.nut);
        return this.nut;
    }

    private void dPF() {
        this.ntV = (RelativeLayout) findViewById(R.id.addition_container);
        this.ntW = (TextView) findViewById(R.id.addition_create_time);
        this.ntX = (TextView) findViewById(R.id.addition_last_time);
        this.ntY = (TextView) findViewById(R.id.addition_last_content);
        if (this.ntU != null) {
            this.ntV.setVisibility(0);
            this.ntW.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.ntU.getCreateTime() * 1000));
            if (this.ntU.getAlreadyCount() == 0) {
                this.ntX.setVisibility(8);
            } else {
                this.ntX.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.ntU.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ntU.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ntY.setText(lastAdditionContent);
            } else {
                this.ntY.setVisibility(8);
            }
            dPJ().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.ntU.getAlreadyCount()), Integer.valueOf(this.ntU.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.ntV.setVisibility(8);
    }

    private void dAO() {
        this.mua = findViewById(R.id.post_prefix_layout);
        if (this.nvn == null) {
            this.nvn = new com.baidu.tieba.c.e(getPageContext(), this.mua);
            this.nvn.ff(R.drawable.bg_tip_blue_up_left);
            this.nvn.fe(16);
            this.nvn.of(true);
            this.nvn.setUseDirectOffset(true);
            this.nvn.wK(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.mtX = (TextView) findViewById(R.id.post_prefix);
        this.ntR = findViewById(R.id.prefix_divider);
        this.mtZ = (ImageView) findViewById(R.id.prefix_icon);
        dQj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQj() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mua.setVisibility(0);
            this.ntR.setVisibility(0);
            this.nvn.y(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mtB = 0;
            this.mua.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dK("fid", WriteActivity.this.mtA.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mtX.setVisibility(0);
                    WriteActivity.this.mua.setSelected(true);
                    SvgManager.bmU().a(WriteActivity.this.mtZ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mtY, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eZf.btC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mtS);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.ntP);
                }
            });
            this.mtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dK("fid", WriteActivity.this.mtA.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.mtX.setSelected(true);
                    SvgManager.bmU().a(WriteActivity.this.mtZ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mtY, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eZf.btC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPK());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPJ());
                }
            });
            this.mtY = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mtY.a(this);
            this.mtY.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mtY.setOutsideTouchable(true);
            this.mtY.setFocusable(true);
            this.mtY.setOnDismissListener(this);
            this.mtY.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.mtX, R.color.cp_bg_line_d);
            SvgManager.bmU().a(this.mtZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.mtX.setTextColor(color);
            this.ntS.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ntS.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xT(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xT(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mtY.addView(writePrefixItemLayout);
            }
            this.mtY.setCurrentIndex(0);
            this.mtX.setText(prefixs.get(0));
            La(0);
            return;
        }
        this.mua.setVisibility(8);
        this.ntR.setVisibility(8);
    }

    private void dQk() {
        if (this.nuz && this.mtA != null) {
            this.nuF.setVisibility(0);
            this.nuG.setVisibility(0);
            this.ntQ = new FeedBackModel(getPageContext());
            this.ntQ.Uh(this.mtA.getForumName());
            this.ntQ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.nuF.setVisibility(8);
                        WriteActivity.this.nuG.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.nuF.setVisibility(8);
                        WriteActivity.this.nuG.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.nuF.a(feedBackModel.dPd(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dPG() {
        this.leh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nvp == null || WriteActivity.this.nvq != null) {
                    if (WriteActivity.this.dQD()) {
                        if (!WriteActivity.this.nvF || WriteActivity.this.nvD) {
                            if (WriteActivity.this.dQF()) {
                                int dQE = WriteActivity.this.dQE();
                                if (dQE == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dQE == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.nuk.a(WriteActivity.this.mtS, WriteActivity.this.ntP)) {
                                    WriteActivity.this.showToast(WriteActivity.this.nuk.dNn());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPK());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dPJ());
                                WriteActivity.this.eZf.btC();
                                if (WriteActivity.this.mtA.getType() != 7) {
                                    if (WriteActivity.this.nuz) {
                                        WriteActivity.this.cwQ();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.aj("obj_type", StringUtils.isNull(WriteActivity.this.mtA.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.dPP();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cwQ();
                                }
                                MercatorModel.dFk().startLoad();
                                TiebaStatic.log(new aq("c12262").dK("obj_locate", WriteActivity.this.iSJ));
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

    protected void dAP() {
        this.nuD = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.nuD.setIsRound(true);
        this.nuD.setDrawBorder(false);
        this.nuD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String Be = q.Be(currentPortrait);
            this.nuD.setUrl(Be);
            this.nuD.startLoad(Be, 12, false);
        }
        if (this.mtA.isUserFeedback()) {
            this.nuD.setVisibility(0);
        }
        this.mtS = (EditText) findViewById(R.id.post_title);
        this.mtS.setOnClickListener(this.nup);
        this.mtS.setOnFocusChangeListener(this.gKu);
        if (this.mtA.getType() == 0 || this.mtA.getType() == 9 || this.mtA.getType() == 7) {
            if (this.mtA.getTitle() != null) {
                this.mtS.setText(this.mtA.getTitle());
                this.mtS.setSelection(this.mtA.getTitle().length());
            } else if (this.nuB) {
                this.mtS.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mtA.getType() == 1 || this.mtA.getType() != 2) {
        }
        this.mtS.addTextChangedListener(this.nur);
        if (!this.mtA.getHaveDraft()) {
            dPC();
            this.nvi = true;
        }
        this.nuC = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher arU() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int nvP;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dAQ();
                if (WriteActivity.this.nuf) {
                    this.nvP = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.nvP);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.nuf || !WriteActivity.this.nva) {
                    if (WriteActivity.this.nuf) {
                        if (this.mEditText != WriteActivity.this.nuR || this.mTextView != WriteActivity.this.nuX) {
                            this.mEditText = WriteActivity.this.nuR;
                            this.mTextView = WriteActivity.this.nuX;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.nuV || this.mTextView != WriteActivity.this.nuW) {
                    this.mEditText = WriteActivity.this.nuV;
                    this.mTextView = WriteActivity.this.nuW;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.nuf && this.nva) {
            if (this.nuY != null) {
                this.nuV.removeTextChangedListener(this.nuY);
            }
            this.nuY = textWatcher;
        } else if (this.nuf) {
            if (this.nuZ != null) {
                this.nuR.removeTextChangedListener(this.nuZ);
            }
            this.nuZ = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.nuR) {
            return 233L;
        }
        if (editText != this.nuV) {
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

    protected void dAR() {
        this.ntP = (SpanGroupEditText) findViewById(R.id.post_content);
        this.ntP.setDrawingCacheEnabled(false);
        this.ntP.setOnClickListener(this.nup);
        this.ntP.setOnSpanGroupChangedListener(new a.InterfaceC0556a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0556a
            public void G(int i, boolean z) {
                WriteActivity.this.Lf();
            }
        });
        this.ntP.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.ntP.setForumId(com.baidu.adp.lib.f.b.toLong(this.mtA.getForumId(), 0L));
        this.ntP.setTransLink(!this.nrg);
        if (this.fbr != null) {
            this.fbr.setSpanGroupManager(this.ntP.getSpanGroupManager());
        }
        if (this.mtA != null) {
            this.mtA.setSpanGroupManager(this.ntP.getSpanGroupManager());
        }
        if (this.mtA.getContent() != null && this.mtA.getContent().length() > 0) {
            this.ntP.setText(TbFaceManager.bwK().av(getPageContext().getPageActivity(), this.mtA.getContent()));
            if (this.ntP.getText() != null) {
                this.ntP.setSelection(this.ntP.getText().length());
            }
        } else if (this.mtA.getType() == 2) {
            if (this.nuJ) {
                if (this.nuK != null && this.nuK.length() > 0) {
                    this.ntP.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.nuK}));
                    this.ntP.setSelection(this.ntP.getText().length());
                }
            } else if (this.mtA.getFloorNum() > 0) {
                this.ntP.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mtA.getFloorNum())));
                this.ntP.setSelection(this.ntP.getText().length());
            }
        }
        this.ntP.setOnFocusChangeListener(this.gKu);
        this.ntP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.ntP.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.ntP.addTextChangedListener(this.nus);
        if (this.mtA.getType() == 0) {
            this.nvm = true;
        } else {
            yk(true);
            this.nvm = false;
        }
        if (this.mtA.isUserFeedback()) {
            this.ntP.setHint(R.string.write_input_content);
        } else {
            this.ntP.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void yk(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.nuf && !this.nrg && dPJ() != null) {
            dPJ().setPadding(0, 0, 0, 0);
            dPJ().setBackgroundDrawable(null);
            ap.setBackgroundColor(dPJ(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.kwp) || this.ntU != null) {
                return;
            }
            if (this.nvs == null || !this.nvs.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.kwp, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass42) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.nvs == null || !WriteActivity.this.nvs.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dPJ().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dPJ(), true, WriteActivity.this.lkm);
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

    private void dQl() {
        if (dPJ() != null) {
            dPJ().setPadding(0, 0, 0, 0);
            dPJ().setBackgroundDrawable(null);
            ap.setBackgroundColor(dPJ(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dPI() {
        int i = 5000;
        if (this.ntU != null) {
            i = 1000;
        }
        return dPJ().getText() != null && dPJ().getText().length() >= i;
    }

    private void Dc(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ntJ)) {
                this.ntJ = "";
                dPJ().requestFocus();
                if (dPJ().getText() != null && dPJ().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dPJ().getSelectionStart();
                    editable = dPJ().getText();
                }
            } else if ("from_title".equals(this.ntJ)) {
                this.ntJ = "";
                dPK().requestFocus();
                if (dPK().getText() != null && dPK().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dPK().getSelectionStart();
                    editable = dPK().getText();
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
    public void yh(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mtA != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mtA.getForumId(), 0L), this.mtA.getFirstDir(), this.mtA.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dPJ().getText().getSpans(0, dPJ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ntT == null) {
                this.ntT = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.ntT.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dPJ());
    }

    EditText dPJ() {
        return this.nuf ? this.nuR : this.ntP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dPK() {
        return this.nuf ? this.nuV : this.mtS;
    }

    protected void dPL() {
        if (dPJ().getSelectionStart() > 0) {
            String substring = dPJ().getText().toString().substring(0, dPJ().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iaR.matcher(substring);
            if (matcher.find()) {
                dPJ().getText().delete(dPJ().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dPJ().getSelectionStart());
                return;
            }
            dPJ().onKeyDown(67, this.iaS);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.mtA != null) {
            str = this.mtA.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.nuz = true;
        }
    }

    private void dQm() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dQn() {
        this.nvu = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.nvt = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.nvu);
        ao(getIntent());
    }

    private void bKB() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.nvx = new d(getPageContext());
        this.nvx.a(this.nvw);
        this.mListView.setAdapter((ListAdapter) this.nvx);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.nvx != null && (WriteActivity.this.nvx.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.nvx.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.elT == 1) {
                            be.bmY().b(WriteActivity.this.getPageContext(), new String[]{tVar.elL});
                        } else {
                            be.bmY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.elL)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.elO)) {
                            if (tVar.elO.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, tVar.elO));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.elO));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.elP)) {
                                be.bmY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.elP)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.elP)) {
                            be.bmY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.elP)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fjB.setCancelListener(null);
        this.fjB.setTipString(R.string.sending);
        this.fjB.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fjB.setDialogVisiable(false);
    }

    private Boolean dQo() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.nuL = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.fbv = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.nuL);
    }

    public void dAQ() {
        this.nvv = false;
        if (this.mtA != null) {
            String str = "";
            String str2 = "";
            if (dPK() != null) {
                str = dPK().getText().toString();
            }
            if (dPJ() != null) {
                str2 = dPJ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mtA.getType() == 0 || this.mtA.getType() == 9 || this.mtA.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.mtB == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mtA.setIsNoTitle(true);
                        } else if (this.ntO.getVisibility() == 0) {
                            this.mtA.setIsNoTitle(false);
                            yi(true);
                            return;
                        }
                    } else if (this.ntO.getVisibility() == 0) {
                        this.mtA.setIsNoTitle(false);
                        yi(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mtA.setIsNoTitle(true);
                } else if (this.ntO.getVisibility() == 0) {
                    this.mtA.setIsNoTitle(false);
                    yi(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nuf) {
                    yi(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yi(true);
                }
            }
            if (this.mtA.getType() == 4) {
                yi(m(this.nuR) && l(this.nuV));
            } else if (this.mtA.getType() == 5) {
                yi(m(this.nuR));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                yi(true);
            } else if (this.mtA.getVideoInfo() != null) {
                yi(this.mtA.getVideoInfo().isVideoMixFinished());
            } else if (dQB()) {
                yi(true);
                this.nvv = true;
            } else {
                yi(false);
            }
        }
    }

    public void yi(boolean z) {
        this.leh.setEnabled(z);
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
        this.fbr = new NewWriteModel(this);
        this.fbr.b(this.fbF);
        registerListener(this.nvG);
        registerListener(this.nvH);
        registerListener(this.nvI);
        this.ifK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.46
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dAI();
            }
        };
        this.mtA = new WriteData();
        if (bundle != null) {
            this.mtA.setType(bundle.getInt("type", 0));
            this.mtA.setForumId(bundle.getString("forum_id"));
            this.mtA.setForumName(bundle.getString("forum_name"));
            this.mtA.setFirstDir(bundle.getString("forum_first_dir"));
            this.mtA.setSecondDir(bundle.getString("forum_second_dir"));
            this.mtA.setThreadId(bundle.getString("thread_id"));
            this.mtA.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mtA.setFloorNum(bundle.getInt("floor_num", 0));
            this.nuz = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.nuA = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nuB = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nuJ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nuK = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fbp = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.ntU = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mtA.setIsAddition(this.ntU != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.nuM = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mtA.setTitle(bundle.getString("write_title"));
            this.mtA.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mtA.setTopicId(this.mTopicId);
            this.iSJ = bundle.getString("KEY_CALL_FROM");
            this.bvy = bundle.getInt("album_thread");
            this.nnh = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mtA.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mtA.setType(intent.getIntExtra("type", 0));
            this.mtA.setForumId(intent.getStringExtra("forum_id"));
            this.mtA.setForumName(intent.getStringExtra("forum_name"));
            this.mtA.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mtA.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mtA.setThreadId(intent.getStringExtra("thread_id"));
            this.mtA.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mtA.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nuz = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.nuA = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nuB = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nuJ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nuK = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.ntU = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mtA.setIsAddition(this.ntU != null);
            this.mtA.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.nuM = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.imO = intent.getStringExtra("more_forum_img");
            this.imP = intent.getStringExtra("more_forum_title");
            this.imN = intent.getStringExtra("more_forum_url");
            this.mtA.setTitle(intent.getStringExtra("write_title"));
            this.mtA.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mtA.setTopicId(this.mTopicId);
            this.iSJ = intent.getStringExtra("KEY_CALL_FROM");
            this.bvy = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nnh = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mtA.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mtA.mDynamicImageTextData = new ImageTextUploadData();
            this.nrg = true;
        }
        if (this.mtA.getType() == 9) {
            this.mtA.setEntranceType(1);
        } else if (this.mtA.getType() == 10) {
            this.mtA.setEntranceType(2);
            this.mtA.setType(9);
        } else if (this.mtA.getType() == 0) {
            this.mtA.setEntranceType(3);
        }
        this.mtA.setIsUserFeedback(this.nuz);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mtA.getType() == 4 ? 6 : 9);
        this.mtA.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mtA.getType() == 0 || this.mtA.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nrg) {
                    x.d(this.mtA.getForumId(), this);
                } else {
                    x.c(this.mtA.getForumId(), this);
                }
            }
        } else if (this.mtA.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.mtA.getType() == 1) {
            x.a(this.mtA.getThreadId(), this);
        } else if (this.mtA.getType() == 4) {
            x.c(this.mtA.getForumId() + "photolive", this);
        } else if (this.mtA.getType() == 5) {
            x.a(this.mtA.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.kwp = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mtA != null && this.mtA.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mtA.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ntM = true;
        }
        dPD();
        try {
            this.nvb = dQx();
        } catch (Throwable th) {
            this.nvb = null;
        }
    }

    private void dPM() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mtS.setText(com.baidu.tbadk.plugins.b.DH(com.baidu.tbadk.plugins.b.DI(hotTopicBussinessData.mTopicName)));
            this.mtS.setMovementMethod(com.baidu.tieba.view.c.dMO());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString DH = com.baidu.tbadk.plugins.b.DH(com.baidu.tbadk.plugins.b.DI(hotTopicBussinessData.mTopicName));
            if (DH != null) {
                this.mtS.setText(DH);
            }
            this.nuh.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.nvF) {
            if (writeData != null) {
                if (this.mtA != null) {
                    boolean z = this.mtA.getVideoInfo() != null && this.mtA.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.mtA.getWriteImagesInfo() == null || y.isEmpty(this.mtA.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dPK().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dPJ().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bwK().a(getPageContext().getPageActivity(), writeData.getContent(), this.nun));
                    if (!z || z7) {
                        this.mtA.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.nvi || ((this.nuz || this.ntM) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.nuz || this.ntM)) {
                            j(writeData);
                        }
                        if (this.mtA != null && !this.mtA.getHaveDraft()) {
                            dPC();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dQp();
                        }
                        dAQ();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.geX != null) {
                            this.nuc = this.ntZ.itu;
                            this.nub = this.ntZ.name;
                            while (true) {
                                if (i == this.geX.size()) {
                                    break;
                                }
                                af afVar = this.geX.get(i);
                                if (categoryTo != afVar.itu) {
                                    i++;
                                } else {
                                    this.nuc = categoryTo;
                                    this.nub = afVar.name;
                                    this.mtA.setCategoryTo(this.nuc);
                                    break;
                                }
                            }
                            if (this.nud != null) {
                                this.nud.setText(this.nub);
                                this.nud.setCategoryContainerData(this.geX, this.ntZ, this.nuc);
                            }
                        }
                        this.eZf.btC();
                        return;
                    }
                    return;
                }
                return;
            }
            dQp();
            dPC();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mtA.setVideoInfo(videoInfo);
            yj(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mtA.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dPR();
        }
        yl(false);
        yj(true);
    }

    private void i(WriteData writeData) {
        String str;
        String DI;
        if (com.baidu.adp.lib.util.k.isEmpty(this.mtA.getTitle())) {
            this.mtA.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                DI = this.mtA.getTitle();
            } else {
                DI = com.baidu.tbadk.plugins.b.DI(str);
            }
            SpannableString DH = com.baidu.tbadk.plugins.b.DH(DI);
            if (DH != null) {
                dPK().setText(DH);
                dPK().setSelection(DH.length() > DI.length() ? DI.length() : DH.length());
                return;
            }
            return;
        }
        SpannableString DH2 = com.baidu.tbadk.plugins.b.DH(this.mtA.getTitle());
        if (DH2 != null) {
            dPK().setText(DH2);
            dPK().setSelection(this.mtA.getTitle().length() > DH2.length() ? DH2.length() : this.mtA.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.mtA.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bwK().a(getPageContext().getPageActivity(), this.mtA.getContent(), this.nun);
        InputFilter[] filters = this.ntP.getFilters();
        this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dPJ().setText(a2);
        if (dPJ() == this.ntP && this.ntP.getSpanGroupManager() != null) {
            this.ntP.boX();
            this.ntP.getSpanGroupManager().bpd();
            this.ntP.boY();
            Lf();
        }
        this.ntP.setFilters(filters);
        if (dPJ().getText() != null) {
            dPJ().setSelection(dPJ().getText().length());
        }
        if (this.nuf) {
            a(this.nuX, this.nuR);
        }
    }

    private void dQp() {
        if ((!this.nuf || this.nuQ != null) && this.nuP != null) {
            this.nuQ.b(this.writeImagesInfo);
            dQt();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mtA.getType());
        bundle.putString("forum_id", this.mtA.getForumId());
        bundle.putString("forum_name", this.mtA.getForumName());
        bundle.putString("forum_first_dir", this.mtA.getFirstDir());
        bundle.putString("forum_second_dir", this.mtA.getSecondDir());
        bundle.putString("thread_id", this.mtA.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mtA.getFloor());
        bundle.putInt("floor_num", this.mtA.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.nuJ);
        if (this.nuz) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fbp);
        if (this.ntU != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ntU));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.nuM);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iSJ);
        bundle.putInt("album_thread", this.bvy);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nnh);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dPJ().getEditableText().toString();
        if (obj != null) {
            dPJ().setText(TbFaceManager.bwK().a(getPageContext().getPageActivity(), obj, this.nun));
            dPJ().setSelection(dPJ().getText().length());
        }
    }

    private String getContent() {
        return (dPJ() == null || dPJ().getText() == null) ? "" : dPJ().getText().toString();
    }

    private String dPO() {
        if (this.mtA == null || dPK() == null || dPK().getVisibility() != 0 || dPK().getText() == null) {
            return "";
        }
        String obj = dPK().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mtB != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mtA.getType() != 4 && this.mtX != null && this.mtX.getText() != null) {
            this.mtA.setPostPrefix(this.mtX.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mtA.getTitle();
        }
        return obj;
    }

    private void Ui(String str) {
        if (this.mtA != null && this.ntO != null) {
            if (this.ntO.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mtA.setIsNoTitle(true);
                    this.mtA.setTitle("");
                    return;
                }
                this.mtA.setIsNoTitle(false);
                this.mtA.setTitle(str);
                return;
            }
            this.mtA.setIsNoTitle(true);
            this.mtA.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwQ() {
        dAI();
        this.mtA.setContent(getContent());
        Ui(dPO());
        if (this.nuz || this.ntM) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mtA.getTitle()) || !this.mtA.getTitle().startsWith(string)) {
                Ui(string + this.mtA.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mtA.getContent()) || !this.mtA.getContent().startsWith(str)) {
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
                sb.append(this.mtA.getContent());
                this.mtA.setContent(sb.toString());
            }
        }
        if (this.nuA) {
            this.mtA.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.nua >= 0) {
            this.mtA.setCategoryFrom(this.nua);
        }
        if (this.nuc >= 0) {
            this.mtA.setCategoryTo(this.nuc);
        }
        this.mtA.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nvt != null) {
            this.mtA.setWriteVoteData(this.nvt.getWriteVoteData());
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
            this.mtA.setTakePhotoNum(i);
        }
        this.mtA.setHasLocationData(this.fbq != null && this.fbq.ccF());
        if (this.writeImagesInfo != null) {
            this.fbr.wY(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.nug != null && this.nug.mIsGlobalBlock == 0) {
            this.mtA.setForumId(String.valueOf(this.nug.mForumId));
            this.mtA.setForumName(this.nug.mForumName);
        }
        dOD();
        this.fbr.e(this.mtA);
        this.mtA.setContent(this.mtA.getContent().replaceAll("\u0000\n", ""));
        this.mtA.setContent(this.mtA.getContent().replaceAll("\u0000", ""));
        this.mtA.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.fbr.cSo().setVoice(this.mVoiceModel.getId());
                this.fbr.cSo().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.fbr.cSo().setVoice(null);
                this.fbr.cSo().setVoiceDuringTime(-1);
            }
        } else {
            this.fbr.cSo().setVoice(null);
            this.fbr.cSo().setVoiceDuringTime(-1);
        }
        if (!this.fbr.dFF()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mtA.mDynamicImageTextData != null) {
            dOC();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.ifK);
            this.fbr.dFC();
        }
    }

    private void dOD() {
        FrsTabItemData selectedTabItemData;
        if (this.mtA != null && this.nrC != null && (selectedTabItemData = this.nrC.getSelectedTabItemData()) != null) {
            this.mtA.setTabId(selectedTabItemData.tabId);
            this.mtA.setTabName(selectedTabItemData.name);
            this.mtA.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dOC() {
        if (this.mtA.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.mtA, new a.InterfaceC0843a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                @Override // com.baidu.tieba.write.b.a.InterfaceC0843a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dOl().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.47.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cwN();
                            x.e(WriteActivity.this.mtA.getForumId(), (WriteData) null);
                            WriteActivity.this.dQd();
                            com.baidu.tieba.write.b.a.dOf();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.jQ(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dOf();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0843a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void F(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ntU != null) {
                i2 = this.ntU.getTotalCount();
                i = this.ntU.getAlreadyCount() + 1;
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
                if (this.mtS == getCurrentFocus()) {
                    dPJ().clearFocus();
                    this.mtS.requestFocus();
                    if (this.eZf != null) {
                        this.eZf.btC();
                    }
                    ShowSoftKeyPadDelay(this.mtS);
                } else {
                    dPJ().requestFocus();
                    if (this.eZf != null) {
                        this.eZf.btC();
                    }
                    ShowSoftKeyPadDelay(this.ntP);
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
                            dPJ().getText().insert(dPJ().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cwN();
                dQd();
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
                                dQu();
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
                        yj(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.nvm) {
                            yk(true);
                            this.nvm = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.nuf) {
                        F(intent);
                        dAQ();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mtA.setVideoInfo(videoInfo);
                        this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.eZf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dAQ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ntK) {
                                sb2.append(com.baidu.tbadk.plugins.b.fiU);
                                this.ntK = false;
                            }
                            sb2.append(stringExtra);
                            Dc(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.nug = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.nug);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.ntP.getSelectionStart();
                    int selectionEnd = this.ntP.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.ntP.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.eZf != null && !this.eZf.bvj()) {
                this.ntP.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.eZf.btC();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bvV();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dQs();
                    if (this.nvm) {
                        yk(true);
                        this.nvm = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.mtS == getCurrentFocus()) {
                        dPJ().clearFocus();
                        this.mtS.requestFocus();
                        if (this.eZf != null) {
                            this.eZf.btC();
                        }
                        ShowSoftKeyPadDelay(this.mtS);
                        return;
                    }
                    dPJ().requestFocus();
                    if (this.eZf != null) {
                        this.eZf.btC();
                    }
                    ShowSoftKeyPadDelay(this.ntP);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.nuk.TK(postWriteCallBackData.getErrorString());
                        this.nuk.bh(postWriteCallBackData.getSensitiveWords());
                        this.nuk.b(this.mtS, this.ntP);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fbp = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fbp);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dQs();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.ntJ)) {
                        dPK().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ntJ)) {
                        dPJ().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPP() {
        if ("1".equals(this.iSJ)) {
            this.mtA.setCanNoForum(true);
            this.mtA.setTransmitForumData("[]");
        } else if ("2".equals(this.iSJ)) {
            this.mtA.setCanNoForum(false);
        }
        dPQ();
        this.mtA.setPrivacy(this.isPrivacy);
        dQq();
        this.mtA.setToDynamic(this.isToDynamic);
        this.mtA.setCallFrom(this.iSJ);
        if (this.mtA.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cwQ();
    }

    private void dPQ() {
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dQq() {
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dQr() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dQs() {
        if (this.nuf) {
            this.nuQ.b(this.writeImagesInfo);
            dQt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQt() {
        this.nuQ.notifyDataSetChanged();
        this.nuP.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.nuQ.notifyDataSetChanged();
                WriteActivity.this.nuP.invalidateViews();
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
        dAQ();
    }

    private void ap(Intent intent) {
        if (this.nuf) {
            aq(intent);
            dQs();
        } else {
            at(intent);
        }
        dAQ();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dQs();
            yl(true);
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

    private void dQu() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.nuN.parseJson(stringExtra);
            this.nuN.updateQuality();
            if (this.nuN.getChosedFiles() != null && this.nuN.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.nuN.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.nuN.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dPK());
        HidenSoftKeyPad(this.mInputManager, dPJ());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.nvs != null) {
            this.nvs.onPause();
        }
        if (this.eZf.bvj()) {
            this.eZf.btC();
        }
    }

    private void at(Intent intent) {
        d(intent, true);
    }

    private void E(Intent intent) {
        this.fbp = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fbp;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fbp, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dQv();
            dPR();
        }
        yl(true);
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
                dQv();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dPR();
                }
            }
            yl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dQv() {
        if (this.eZf.qP(10) != null) {
            this.eZf.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bvV() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.50
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fbp));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dQw() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.imO)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.imO, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.51
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
                            WriteActivity.this.yl(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        String forumId = this.mtA == null ? "" : this.mtA.getForumId();
        if (this.nuO != null) {
            this.nuO.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ctc() {
        this.ioV = getVoiceManager();
        this.ioV.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bM(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iqr) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mtA.getType() != 7) {
                if (this.ntU == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                F(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fbw = i;
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dPR() {
        if (!this.nuf) {
            if (this.eZf != null) {
                this.eZf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eZf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mtA == null ? "" : this.mtA.getForumId();
            if (this.nuO != null) {
                this.nuO.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(boolean z) {
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void La(int i) {
        if (i < this.ntS.size()) {
            for (int i2 = 0; i2 < this.ntS.size(); i2++) {
                this.ntS.get(i2).xU(false);
            }
            this.ntS.get(i).xU(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void IB(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").aj("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").aj("obj_type", 2));
        }
        this.mtB = i;
        this.mtY.setCurrentIndex(i);
        La(i);
        this.mtX.setText(this.mPrefixData.getPrefixs().get(i));
        dAQ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mtY, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mua.setSelected(false);
        SvgManager.bmU().a(this.mtZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.ntP);
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
        if (this.mtA != null) {
            if (this.mtA.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mtA.getType() == 5) {
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
            bvP();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fbp);
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
        this.bkk = z;
        if (this.nvg && System.currentTimeMillis() - this.nvh < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.nvg = false;
        }
        if (this.nuj != null && !z) {
            this.nuj.cmD();
        }
        if (this.nul != null && !z) {
            dPu();
        }
        if (this.nvo != null && !z) {
            dPZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uj(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.nvd != null) {
            Uk(str);
            this.nvd.dismiss();
        }
    }

    private void gc(Context context) {
        nvf = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void Uk(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.nvg = true;
        dQv();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dPR();
        }
        yl(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5418=4] */
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

    private File dQx() {
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

    private void dQy() {
        if (this.nvb != null && this.mtA.getType() == 0 && this.mtA.getType() == 9) {
            gc(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.nvb != null) {
                        WriteActivity.this.Uj(WriteActivity.this.nvb.getAbsolutePath());
                    }
                }
            });
            this.nvc = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.nve = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.nvb.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.nvb.getAbsolutePath());
                Bitmap g = g(this.nvb.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.nvc.setImageBitmap(g);
                    this.nvc.setDrawBorder(true);
                    this.nvc.setBorderWidth(2);
                    this.nvc.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.nvd = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.nvd.setCanceledOnTouchOutside(true);
                    this.nvd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.nvg) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.nvh = System.currentTimeMillis();
                            }
                        }
                    });
                    this.nvd.setContentView(this.mBubbleView);
                    this.nvd.show();
                    Window window = this.nvd.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (nvf / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bkk && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ntK = false;
            this.ntJ = "";
            if ("from_content".equals(str)) {
                this.ntJ = "from_content";
            } else if ("from_title".equals(str)) {
                this.ntJ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DG(String.valueOf(charSequence.charAt(i)))) {
                yh(false);
            }
        }
    }

    public void dvq() {
        if (com.baidu.tieba.write.c.b.dOu()) {
            this.mtS.setHint(R.string.title_hint_for_hot);
            this.ntO.setVisibility(0);
            this.nuE.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.nuC);
            this.ntO.requestFocus();
            return;
        }
        this.nuC.setVisibility(8);
        this.mtS.setHint(this.nuz ? R.string.feedback_title_hint : R.string.post_title_hint);
        if (this.nuz || !y.isEmpty(this.mList) || (this.mtA != null && !StringUtils.isNull(this.mtA.getTitle()))) {
            this.ntO.setVisibility(0);
            this.nuE.setVisibility(0);
            this.ntO.requestFocus();
            return;
        }
        this.ntO.setVisibility(8);
        this.nuE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQz() {
        if (this.eZf != null) {
            this.eZf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nrg && WriteActivity.this.eZf != null && WriteActivity.this.eZf.eZi != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bmY().k(clipBoardContent)) {
                            WriteActivity.this.nuj.dnR();
                            return;
                        }
                        if (WriteActivity.this.nss == null) {
                            WriteActivity.this.nss = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.nvJ);
                        }
                        WriteActivity.this.nss.a(WriteActivity.this.eZf.eZi.qN(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iSJ;
    }

    public WriteData cSo() {
        return this.mtA;
    }

    public FrsTabInfoData dQA() {
        return this.nnh;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dQB() {
        return (this.nvt == null || this.nvu == null || this.nvt.getWriteVoteData() == null || this.nvu.getVisibility() != 0) ? false : true;
    }

    public void dNv() {
        if (this.mtA != null) {
            TiebaStatic.log(new aq("c13897").aj("obj_locate", 2).dK("fid", this.mtA.getForumId()).dK("fname", this.mtA.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.oe(2);
            aVar.iA(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").aj("obj_locate", 2).dK("fid", WriteActivity.this.mtA != null ? WriteActivity.this.mtA.getForumId() : "").dK("fname", WriteActivity.this.mtA != null ? WriteActivity.this.mtA.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dQC()));
                    }
                }
            });
            aVar.ba(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").aj("obj_locate", 2).dK("fid", this.mtA != null ? this.mtA.getForumId() : "").dK("fname", this.mtA != null ? this.mtA.getForumName() : ""));
            aVar.b(getPageContext()).bkJ();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dQC()));
    }

    public void Lf() {
        if (this.nvx != null && this.nvx.dPf() == null && this.ntP != null && this.ntP.getSpanGroupManager() != null) {
            this.nvx.h(this.ntP.getSpanGroupManager().bpi());
            this.nvx.refreshData();
        } else if (this.nvx != null && this.nvx.dPf() != null) {
            this.nvx.refreshData();
        }
        if (this.nvx != null) {
            fP(this.nvx.dPe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(List<t> list) {
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
            if (!z && this.nvy != null) {
                this.nvy.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul(String str) {
        this.nvB = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.nvB.add(com.baidu.tieba.i.a.dV(jSONObject));
                }
                if (this.nvB.size() > 0) {
                    this.nvF = true;
                    this.ntP.j(this.nvB, arrayList);
                    dQg();
                    Lf();
                    this.nvy.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dQC() {
        if (this.ntP == null || this.ntP.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.ntP.getSpanGroupManager().bpj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQD() {
        return this.canGoods || this.ntP == null || this.ntP.getSpanGroupManager() == null || this.ntP.getSpanGroupManager().bpj() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dQE() {
        boolean z = this.nvx == null || this.nvx.dPg();
        boolean z2 = (this.nrC == null || this.nrC.getSelectedTabItemData() == null || this.nrC.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQF() {
        if (this.nnh == null || y.isEmpty(this.nnh.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nnh.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dQG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.57
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).xK(false).TD(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aH((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
