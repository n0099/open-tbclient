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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0209a, VoiceManager.c, x.a, i.a {
    private static int nfG = 0;
    private EditorTools eMY;
    private String ePi;
    private LocationModel ePj;
    private NewWriteModel ePk;
    List<af> fSE;
    private String hXN;
    private String hXO;
    private String hXP;
    private VoiceManager hZU;
    private com.baidu.tbadk.core.dialog.i ina;
    private SaveDraftDialogView inb;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout kOc;
    private PlayVoiceBntNew kOd;
    private ImageView kOf;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData mXJ;
    private int mdX;
    private TextView meu;
    private com.baidu.tieba.write.i mev;
    private ImageView mew;
    private View mex;
    private FindNewLinkBubbleController ncT;
    private ForumTabSelectedView ncd;
    private TextView neA;
    af neB;
    private int neC;
    private String neD;
    private int neE;
    private PostCategoryView neF;
    private HotTopicBussinessData neI;
    private TextView neJ;
    private com.baidu.tieba.write.editor.b neL;
    private g neN;
    private com.baidu.tieba.view.b neU;
    private LinearLayout neo;
    private LinearLayout nep;
    private View nes;
    private Toast nev;

    /* renamed from: new  reason: not valid java name */
    private AdditionData f5new;
    private RelativeLayout nex;
    private TextView ney;
    private TextView nez;
    private View nfK;
    private View nfL;
    private TextView nfM;
    private com.baidu.tieba.c.e nfO;
    private b nfP;
    private ForumSelectedView nfQ;
    private com.baidu.tbadk.data.i nfR;
    private View nfS;
    private com.baidu.tieba.write.write.video.a nfT;
    private com.baidu.tieba.write.write.vote.a nfU;
    private RelativeLayout nfV;
    private boolean nfW;
    private d nfY;
    private LinearLayout nfZ;
    private TitleTipView nfd;
    private View nff;
    private View nfh;
    private i nfp;
    private ImageView nga;
    private TextView ngb;
    private List<com.baidu.tieba.i.a> ngc;
    private EBusinessProtocolView ngd;
    private int privateThread;
    private String nek = "";
    private boolean nel = false;
    protected WriteData mdW = null;
    private boolean nfa = false;
    private boolean nfb = false;
    private boolean nen = false;
    private boolean nfc = false;
    private InputMethodManager mInputManager = null;
    private EditText mep = null;
    private HeadImageView nfe = null;
    private View meq = null;
    private LinearLayout mes = null;
    private SpanGroupEditText neq = null;
    private FeedBackModel ner = null;
    private FeedBackTopListView nfg = null;
    private ArrayList<WritePrefixItemLayout> neu = new ArrayList<>();
    private String khc = null;
    private final KeyEvent hLX = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView nfi = null;
    private TextView kOV = null;
    private TextView mName = null;
    private ImageView nfj = null;
    private DialogInterface.OnCancelListener hQL = null;
    private final Handler mHandler = new Handler();
    private boolean nfk = false;
    private String nfl = null;
    private RelativeLayout jnW = null;
    public boolean nfm = true;
    public String ePo = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ePp = 0;
    private int nfn = 0;
    private WriteImagesInfo nfo = new WriteImagesInfo();
    private View mRootView = null;
    private GridView nfq = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a nfr = null;
    private ScrollView neG = null;
    private EditText nfs = null;
    private View nft = null;
    private View nfu = null;
    private View nfv = null;
    private EditText nfw = null;
    private TextView nfx = null;
    private TextView nfy = null;
    private TextWatcher nfz = null;
    private TextWatcher nfA = null;
    private boolean neH = false;
    private boolean nfB = false;
    private com.baidu.tbadk.core.view.a eXp = null;
    private String mFrom = "write";
    private File nfC = null;
    private TbImageView nfD = null;
    private View mBubbleView = null;
    private Dialog nfE = null;
    private LinearLayout nfF = null;
    private boolean nfH = false;
    private long nfI = -1000;
    private boolean nfJ = false;
    private String iDT = "2";
    private int brK = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder neK = new SpannableStringBuilder();
    private boolean nfN = false;
    private boolean bgv = false;
    private final c neM = new c();
    private boolean nbH = false;
    private final d.a nfX = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Ks(int i) {
            if (WriteActivity.this.neq != null) {
                WriteActivity.this.neq.pv(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void fL(List<t> list) {
            WriteActivity.this.fM(list);
        }
    };
    private boolean nge = false;
    private int ngf = 0;
    private boolean ngg = false;
    private final HttpMessageListener ngh = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.khc)) {
                    WriteActivity.this.khc = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.xD(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.khc)) {
                    WriteActivity.this.khc = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.khc);
                    WriteActivity.this.xD(true);
                }
            }
        }
    };
    private CustomMessageListener ngi = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.mdW != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").ai("obj_locate", 1).dF("fid", WriteActivity.this.mdW.getForumId()).dF("fname", WriteActivity.this.mdW.getForumName()));
            }
        }
    };
    private final CustomMessageListener ngj = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nfQ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                WriteActivity.this.nfR = (com.baidu.tbadk.data.i) customResponsedMessage.getData();
                if (WriteActivity.this.nfR != null && !StringUtils.isNull(WriteActivity.this.nfR.forumId) && !StringUtils.isNull(WriteActivity.this.nfR.forumName)) {
                    if (WriteActivity.this.mdW != null) {
                        WriteActivity.this.mdW.setForumId(WriteActivity.this.nfR.forumId);
                        WriteActivity.this.mdW.setForumName(WriteActivity.this.nfR.forumName);
                    }
                    WriteActivity.this.nfQ.setSelectedForum(WriteActivity.this.nfR.forumName);
                    WriteActivity.this.mXJ = null;
                    if (!y.isEmpty(WriteActivity.this.nfR.tabInfoList)) {
                        WriteActivity.this.mXJ = new FrsTabInfoData();
                        WriteActivity.this.mXJ.selectedTabId = -1;
                        WriteActivity.this.mXJ.tabList = WriteActivity.this.nfR.tabInfoList;
                    }
                    WriteActivity.this.ncd.setData(WriteActivity.this.mXJ);
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.nfR.eLP != null && !y.isEmpty(WriteActivity.this.nfR.eLP.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.nfR.eLP;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.dMx();
                }
            }
        }
    };
    private TbFaceManager.a neO = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan CG(String str) {
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
    private final AntiHelper.a ibq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a ngk = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.58
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.ncT != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.ncT.Rc();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.59
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cpE();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.ngl = true;
            if (postWriteCallBackData != null && WriteActivity.this.mdW != null) {
                WriteActivity.this.neM.bh(null);
                if (z) {
                    WriteActivity.this.js(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.mdW);
                    WriteActivity.this.ctq();
                    WriteActivity.this.dMr();
                    if ((WriteActivity.this.mdW.getType() == 0 || WriteActivity.this.mdW.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dF("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mdW.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mdW.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.mdW.getForumName())) {
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
                    WriteActivity.this.neM.bh(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.neM.SW(postWriteCallBackData.getErrorString());
                    WriteActivity.this.neM.b(WriteActivity.this.mep, WriteActivity.this.neq);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.zV(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.zV(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bia();
                    TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bnT());
                    if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS());
                        if (WriteActivity.this.nfc) {
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
    private final LocationModel.a ePw = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void btu() {
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
    private final CustomMessageListener mrc = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ePj.wp(false);
                    WriteActivity.this.ePj.gh(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ePj.wp(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener neP = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dMN();
            }
        }
    };
    private final View.OnClickListener neQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dLF = WriteActivity.this.dLF();
            if (dLF >= 0 && dLF < WriteActivity.this.neq.getText().length()) {
                WriteActivity.this.neq.setSelection(dLF);
            }
        }
    };
    private boolean neR = true;
    private final View.OnFocusChangeListener gwb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mep || view == WriteActivity.this.mBack || view == WriteActivity.this.kOV) {
                if (z) {
                    WriteActivity.this.neR = true;
                    WriteActivity.this.dLG();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mep);
                    if (WriteActivity.this.eMY != null) {
                        WriteActivity.this.eMY.bqS();
                    }
                } else if (view == WriteActivity.this.mep) {
                    WriteActivity.this.meu.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.neq && z) {
                WriteActivity.this.neR = false;
                WriteActivity.this.dLG();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.neq);
                if (WriteActivity.this.eMY != null) {
                    WriteActivity.this.eMY.bqS();
                }
            }
            WriteActivity.this.dLL();
        }
    };
    private com.baidu.tbadk.mutiprocess.h hYZ = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Tx(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean ngl = false;
    private TextWatcher neS = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String neW = "";
        private String neX;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.neX = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.neX != null ? this.neX.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dxf();
            WriteActivity.this.dLM();
            EditText dLY = WriteActivity.this.dLY();
            if (editable != null && dLY != null && dLY.getText() != null) {
                if (this.neW == null || !this.neW.equals(editable.toString())) {
                    if (WriteActivity.this.neM != null) {
                        this.neW = dLY.getText().toString();
                        WriteActivity.this.neM.b(dLY, true);
                        return;
                    }
                    return;
                }
                dLY.setSelection(dLY.getSelectionEnd());
            }
        }
    };
    private TextWatcher neT = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String neX;
        private String neY = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.neX = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.neX != null ? this.neX.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dxf();
            EditText dLX = WriteActivity.this.dLX();
            if (editable != null && dLX != null && dLX.getText() != null) {
                if (this.neY == null || !this.neY.equals(editable.toString())) {
                    if (WriteActivity.this.neM != null) {
                        this.neY = dLX.getText().toString();
                        WriteActivity.this.neM.b(dLX, false);
                        return;
                    }
                    return;
                }
                dLX.setSelection(dLX.getSelectionEnd());
            }
        }
    };
    private int ngm = 0;
    private final a.InterfaceC0803a kUZ = new a.InterfaceC0803a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0803a
        public void onRefresh() {
            WriteActivity.this.khc = null;
            WriteActivity.this.xD(false);
            WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void btd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void btf() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bth();
        } else if (this.ePj.dBl()) {
            btd();
        } else {
            this.ePj.wp(false);
            a(1, true, (String) null);
            this.ePj.dBj();
        }
    }

    public void dMh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.neL != null) {
                this.neL.dKp();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bth();
        } else if (this.ePj != null) {
            this.ePj.wp(false);
            a(1, true, (String) null);
            this.ePj.dBj();
        }
    }

    private void bth() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nE(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.ePj.dBn();
                } else {
                    WriteActivity.this.ePw.btu();
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
        aVar.bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dLF() {
        int selectionEnd = dLX().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dLX().getText().getSpans(0, dLX().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dLX().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dLX().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLG() {
        if (this.eMY != null) {
            if (this.nfT != null && this.nfT.isVisible()) {
                this.eMY.setBarLauncherEnabled(!this.neR);
                this.eMY.setDeskLauncherEnabled(!this.neR);
                this.eMY.setToolEnabled(true, 2);
                this.eMY.setToolEnabled(true, 32);
                this.eMY.setToolEnabled(false, 10);
                this.eMY.setToolEnabled(false, 6);
                this.eMY.setToolEnabled(false, 18);
                this.eMY.qr(5).jl(false);
                if (this.neL != null) {
                    this.neL.xs(true);
                    return;
                }
                return;
            }
            this.eMY.setBarLauncherEnabled(!this.neR);
            this.eMY.setDeskLauncherEnabled(this.neR ? false : true);
            this.eMY.setToolEnabled(true, 26);
            this.eMY.setToolEnabled(true, 2);
            this.eMY.setToolEnabled(true, 30);
            this.eMY.qr(5).jl(true);
            if (this.neL != null) {
                this.neL.xs(true);
            }
            dMJ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.neH) {
            this.mep.setVisibility(8);
            if (this.mdW.getType() == 5) {
                this.nfv.setVisibility(8);
            } else {
                this.nfv.setVisibility(0);
            }
            a(this.nfy, this.nfs);
            a(this.nfx, this.nfw);
            dxf();
        }
        if (this.nfa) {
            this.neR = true;
            dLG();
            if (this.eMY != null) {
                this.eMY.bqS();
            }
            this.mep.requestFocus();
            ShowSoftKeyPadDelay(this.mep);
        }
        if (this.nfT != null) {
            this.nfT.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.nfT != null) {
            this.nfT.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.nfT != null) {
            this.nfT.onStop();
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
                    dMf();
                }
                xE(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mdW.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.mdW.setVideoInfo(null);
            }
            if (this.nfT == null) {
                this.nfT = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.mdW.getVideoInfo() != null && this.mdW.getVideoInfo().isEditVideoDataLegal()) {
                xC(false);
                this.nfT.dNC();
                return;
            }
            xC(true);
        }
    }

    public void Dy(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void xC(boolean z) {
        if (z) {
            this.mdW.setVideoInfo(null);
            this.nfT.setVideoInfo(null);
            this.nfp.dMW().setVisibility(0);
            xD(false);
        } else {
            this.nfT.setVideoInfo(this.mdW.getVideoInfo());
            this.writeImagesInfo.clear();
            this.nfp.dMW().setVisibility(8);
            dMz();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dxf();
        dLG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mdW.getType() == 0) {
            Kv(this.brK);
        }
        initUI();
        dMy();
        this.ePj = new LocationModel(getPageContext());
        this.ePj.a(this.ePw);
        registerListener(this.mrc);
        registerListener(this.neP);
        registerListener(this.mBackgroundListener);
        dMU();
        cOl();
        dMM();
        if (this.neH) {
            this.nfr.setEditorTools(this.eMY);
        } else {
            this.neq.requestFocus();
        }
        drF();
        dMf();
        dMK();
        this.hYZ.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.hYZ);
        dMi();
    }

    private void dMi() {
        Tx(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cOl() {
        this.eMY = new EditorTools(getActivity());
        this.eMY.setBarMaxLauCount(5);
        this.eMY.setMoreButtonAtEnd(true);
        this.eMY.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.eMY.setBarLauncherType(1);
        this.eMY.jh(true);
        this.eMY.ji(true);
        switch (this.mdW.getType()) {
            case 4:
            case 5:
                dMl();
                break;
            default:
                dLH();
                break;
        }
        this.eMY.build();
        if (this.neo != null) {
            this.neo.addView(this.eMY);
        }
        cND();
        this.eMY.display();
        com.baidu.tbadk.editortools.h qo = this.eMY.qo(6);
        if (qo != null && !TextUtils.isEmpty(this.ePo)) {
            ((View) qo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.ePo);
                }
            });
        }
        if (!this.neH) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eMY.bqS();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dMm();
            return;
        }
        if (!this.nbH) {
            dLJ();
        }
        dMN();
    }

    private void dMj() {
        this.nft = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.nfv = this.nft.findViewById(R.id.live_post_title_container);
        this.nfs = (EditText) this.nft.findViewById(R.id.live_post_content);
        this.nfq = (GridView) this.nft.findViewById(R.id.photoLiveGridView);
        this.nfw = (EditText) this.nft.findViewById(R.id.live_post_title);
        this.nfx = (TextView) this.nft.findViewById(R.id.titleOverPlusNumber);
        this.nfy = (TextView) this.nft.findViewById(R.id.contentOverPlusNumber);
        this.nfu = this.nft.findViewById(R.id.live_interval_view);
        this.nfx.setText(String.valueOf(20));
        this.nfy.setText(String.valueOf(233));
        this.nft.setVisibility(0);
        this.nfx.setVisibility(0);
        this.nfy.setVisibility(0);
        this.nfw.setHint(R.string.tips_title_limit_new);
        this.nfw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nfB = true;
                    WriteActivity.this.neR = true;
                    WriteActivity.this.dLG();
                    if (WriteActivity.this.eMY != null) {
                        WriteActivity.this.eMY.bqS();
                    }
                }
            }
        });
        if (this.mdW.getType() == 4) {
            this.nfs.setHint(R.string.live_write_input_content_new);
        } else if (this.mdW.getType() == 5) {
            this.nfs.setHint(R.string.live_write_input_content_update);
        }
        this.nfs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.nfB = false;
                    WriteActivity.this.neR = false;
                    WriteActivity.this.dLG();
                    if (WriteActivity.this.eMY != null) {
                        WriteActivity.this.eMY.bqS();
                    }
                }
            }
        });
        this.nfs.requestFocus();
        this.nfs.addTextChangedListener(apj());
        this.nfw.requestFocus();
        this.nfw.addTextChangedListener(apj());
        this.nfw.setOnClickListener(this.neQ);
        this.nfs.setOnClickListener(this.neQ);
        this.nfr = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.nfq);
        this.nfr.Km(6);
        this.nfq.setAdapter((ListAdapter) this.nfr);
        View findViewById = this.nft.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dLh() {
                WriteActivity.this.dMH();
            }
        });
        dMk();
    }

    private void dMk() {
        if (this.mdW.getType() == 0) {
            if (this.mdW.getTitle() != null) {
                this.nfw.setText(this.mdW.getTitle());
                this.nfw.setSelection(this.mdW.getTitle().length());
                return;
            }
            return;
        }
        if (this.mdW.getType() == 1 || this.mdW.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.neH) {
            dMF();
        }
        if (this.eMY.bsz()) {
            this.eMY.bqS();
        }
        Kv(0);
    }

    public boolean dKe() {
        return !"1".equals(this.iDT) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.neM != null) {
                if (this.neM.d(spannable)) {
                    return true;
                }
            }
            if (be.bkp().l(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void Kv(int i) {
        if (this.writeImagesInfo != null && this.mdW != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mdW.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mdW.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dKe());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iDT);
            albumFloatActivityConfig.setProfessionZone(this.mdW.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mXJ);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.ePo;
            antiData.setIfVoice(this.nfm);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mdW.getFirstDir(), this.mdW.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dMl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.eMY.bg(arrayList);
        com.baidu.tbadk.editortools.m qr = this.eMY.qr(5);
        if (qr != null) {
            qr.eNL = 2;
        }
        this.eMY.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.eMY.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dLH() {
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
            this.eMY.b(dVar);
        }
        if (!this.nbH) {
            Boolean dMC = dMC();
            if (!this.nfa && dMC != null && dMC.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dBP() && com.baidu.tieba.tbadkCore.t.d(this.mdW.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.eNL = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eMY.b(mVar4);
                }
            }
        }
        if (!this.nbH && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.eNL = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eMY.b(mVar3);
            }
        }
        if (!this.nbH && !com.baidu.tieba.write.c.b.dKI()) {
            this.eMY.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nbH) {
            this.eMY.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eMY.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.iDT, "2")) {
            this.eMY.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eMY.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.nbH && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.eNN = true;
            mVar2.eNL = 9;
            mVar2.eNF = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eMY.b(mVar2);
            }
        }
        if (!this.nbH && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.eNN = true;
            mVar.eNL = 10;
            mVar.eNF = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eMY.b(mVar);
            }
        }
        if (!this.nbH && this.f5new == null) {
            if (this.neL == null) {
                this.neL = new com.baidu.tieba.write.editor.b(getActivity(), this.iDT);
                this.neL.Kf(0);
                this.neL.xr(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.neL.dKn();
                this.neL.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dMh();
            }
            if (!y.isEmpty(this.mList)) {
                this.neL.dKn();
            }
            this.eMY.b(this.neL);
        }
        if (!this.nbH && this.canGoods) {
            this.eMY.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.eMY.bg(arrayList);
        com.baidu.tbadk.editortools.m qr = this.eMY.qr(5);
        if (qr != null) {
            qr.eNL = 4;
        }
    }

    private void dLI() {
        if (this.neN != null) {
            this.neN.hideTip();
        }
    }

    private void dMm() {
        if (this.eMY != null) {
            this.eMY.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.eMY != null && WriteActivity.this.eMY.eNb != null) {
                        if (WriteActivity.this.nfP == null) {
                            WriteActivity.this.nfP = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.nfP.showTip(WriteActivity.this.eMY.eNb.qp(2));
                    }
                }
            });
        }
    }

    private void dMn() {
        if (this.nfP != null) {
            this.nfP.hideTip();
        }
    }

    private void dLJ() {
        if (this.neN == null) {
            this.neN = new g(getPageContext());
        }
        this.neN.d(this.eMY);
    }

    private void cND() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 9));
                        if (WriteActivity.this.dLW()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof u)) {
                            u uVar = (u) aVar.data;
                            if (uVar.bnJ() == EmotionGroupType.BIG_EMOTION || uVar.bnJ() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.xE(true);
                                    WriteActivity.this.dxf();
                                }
                            } else if (WriteActivity.this.dLW()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dLZ();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dbU();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dMJ();
                        WriteActivity.this.dxf();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Kw(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.f5new == null) {
                            WriteActivity.this.bti();
                            return;
                        }
                        switch (WriteActivity.this.ePp) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.btf();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.btd();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ePj != null) {
                            WriteActivity.this.ePj.wp(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.khc = null;
                        } else {
                            WriteActivity.this.khc = (String) aVar.data;
                        }
                        WriteActivity.this.xD(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dF("fid", WriteActivity.this.mdW != null ? WriteActivity.this.mdW.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.mdW == null || (videoInfo = WriteActivity.this.mdW.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.eMY.bsz()) {
                                        WriteActivity.this.eMY.bqS();
                                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mdW.setVideoInfo(null);
                        WriteActivity.this.dxf();
                        if (WriteActivity.this.neq != null) {
                            WriteActivity.this.neq.requestFocus();
                        }
                        WriteActivity.this.eMY.bqS();
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.neq);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.nel = true;
                        WriteActivity.this.xA(true);
                        if (!WriteActivity.this.dLY().isFocused() || WriteActivity.this.nep.getVisibility() != 0) {
                            WriteActivity.this.nek = "from_content";
                        } else {
                            WriteActivity.this.nek = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 8));
                        if (WriteActivity.this.nep.getVisibility() == 0) {
                            if (WriteActivity.this.nep.hasFocus()) {
                                WriteActivity.this.neq.requestFocus();
                                WriteActivity.this.neq.setSelection(WriteActivity.this.neq.getText().toString().length());
                            }
                            WriteActivity.this.nep.setVisibility(8);
                            WriteActivity.this.nff.setVisibility(8);
                            WriteActivity.this.eMY.qo(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.nep.setVisibility(0);
                            WriteActivity.this.nff.setVisibility(0);
                            WriteActivity.this.nep.requestFocus();
                            WriteActivity.this.eMY.qo(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dxf();
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
                            TiebaStatic.log(new aq("c12612").ai("obj_locate", 10));
                            if (WriteActivity.this.nfU != null && WriteActivity.this.nfU.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.nfU.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new aq("c13800").ai("obj_source", 2));
                        }
                        WriteActivity.this.dMo();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.ncT != null) {
                            WriteActivity.this.ncT.Rc();
                        }
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dJJ();
                    }
                }
            }
        };
        this.eMY.setActionListener(16, bVar);
        this.eMY.setActionListener(14, bVar);
        this.eMY.setActionListener(24, bVar);
        this.eMY.setActionListener(3, bVar);
        this.eMY.setActionListener(10, bVar);
        this.eMY.setActionListener(11, bVar);
        this.eMY.setActionListener(12, bVar);
        this.eMY.setActionListener(13, bVar);
        this.eMY.setActionListener(15, bVar);
        this.eMY.setActionListener(18, bVar);
        this.eMY.setActionListener(20, bVar);
        this.eMY.setActionListener(25, bVar);
        this.eMY.setActionListener(27, bVar);
        this.eMY.setActionListener(29, bVar);
        this.eMY.setActionListener(43, bVar);
        this.eMY.setActionListener(56, bVar);
        this.eMY.setActionListener(48, bVar);
        this.eMY.setActionListener(46, bVar);
        this.eMY.setActionListener(49, bVar);
        this.eMY.setActionListener(47, bVar);
        this.eMY.setActionListener(55, bVar);
        this.eMY.setActionListener(58, bVar);
        this.eMY.setActionListener(22, bVar);
        this.eMY.setActionListener(21, bVar);
        this.eMY.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMo() {
        if (this.nfj != null) {
            this.nfj.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.ngm;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void aq(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new aq("c13800").ai("obj_source", 3));
                    }
                };
                this.nfU.ao(onClickListener);
                this.nfU.setOnItemClickListener(onClickListener);
                this.nfU.b(writeVoteData);
                this.nfU.xG(true);
                dxf();
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
    public void Kw(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.ePj.bZh()) {
            if (this.ePj.dBl()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dBg().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.ePj.dBj();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dwX() {
        if (this.ePk != null) {
            this.ePk.cancelLoadData();
        }
        if (this.ner != null) {
            this.ner.cancelLoadData();
        }
        if (this.ePj != null) {
            this.ePj.cancelLoadData();
        }
        if (this.nfT != null) {
            this.nfT.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ngi);
        dLI();
        dMn();
        TiebaPrepareImageService.StopService();
        dwX();
        if (!this.ngl) {
            dMp();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.ina, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.nfp != null) {
            this.nfp.destroy();
        }
        if (this.nfO != null) {
            this.nfO.Oj();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMp() {
        if (this.mdW != null && this.mdW.getType() == 2 && this.nfk) {
            finish();
        } else if (this.mdW == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mdW.setTitle(dLY().getText().toString());
            this.mdW.setContent(dLX().getText().toString());
            int type = this.mdW.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nbH) {
                        x.e(this.mdW.getForumId(), this.mdW);
                    } else {
                        x.d(this.mdW.getForumId(), this.mdW);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.mdW);
                }
            } else if (type == 1) {
                x.f(this.mdW.getThreadId(), this.mdW);
            } else if (type == 4) {
                x.d(this.mdW.getForumId() + "photolive", this.mdW);
            } else if (type == 5) {
                x.f(this.mdW.getThreadId() + "updatephotolive", this.mdW);
            }
            this.ngl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMq() {
        if (this.kOV == null || !this.kOV.isEnabled() || this.nfW) {
            ctq();
            dMr();
            setResult(100);
            finish();
            return;
        }
        if (this.inb == null) {
            this.inb = new SaveDraftDialogView(this);
            this.inb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.ctq();
                            WriteActivity.this.dMr();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dMp();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.ina.dismiss();
                    }
                }
            });
        }
        if (this.ina == null) {
            this.ina = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.ina.setContentView(this.inb);
        }
        boolean z = (this.nfT == null || !this.nfT.isVisible() || this.mdW == null || this.mdW.getVideoInfo() == null || this.mdW.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.inb.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.ina.NY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctq() {
        if (this.mdW.getType() == 0 || this.mdW.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nbH) {
                    x.e(this.mdW.getForumId(), (WriteData) null);
                } else {
                    x.d(this.mdW.getForumId(), (WriteData) null);
                }
            }
        } else if (this.mdW.getType() == 1) {
            x.f(this.mdW.getThreadId(), (WriteData) null);
        }
        this.ngl = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMr() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mDD));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mev != null && this.mev.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mev, getPageContext().getPageActivity());
                return true;
            } else if (this.eMY.bsz()) {
                this.eMY.bqS();
                return true;
            } else {
                dwX();
                dMq();
                return true;
            }
        }
        if (i == 67 && (text = dLX().getText()) != null) {
            int selectionStart = dLX().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dLX().onKeyDown(67, this.hLX);
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
        getLayoutMode().onModeChanged(this.jnW);
        getLayoutMode().onModeChanged(this.nfF);
        ap.setBackgroundColor(this.jnW, R.color.cp_bg_line_e);
        if (this.nfD != null && (i == 1 || i == 4)) {
            this.nfD.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kOV.setTextColor(ap.aP(R.color.cp_link_tip_a, i));
        dLG();
        ap.setBackgroundColor(this.meq, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.nfu, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dLY(), R.color.cp_bg_line_e);
        ap.setImageResource(this.kOf, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.khc)) {
            ap.setBackgroundColor(dLX(), R.color.cp_bg_line_e);
        }
        dxf();
        this.eMY.onChangeSkinType(i);
        if (this.neF != null) {
            this.neF.blA();
        }
        if (this.nfY != null) {
            this.nfY.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nfp.ngK.notifyDataSetChanged();
        dLL();
        dLM();
        xD(false);
        if (this.neM != null) {
            this.neM.c(dLY(), dLX());
        }
        if (this.nfQ != null) {
            this.nfQ.onChangeSkinType();
        }
        if (this.ncd != null) {
            this.ncd.onChangeSkinType(i);
        }
        if (this.nfT != null) {
            this.nfT.changeSkin();
        }
        if (this.nfU != null) {
            this.nfU.onChangeSkinType(i);
        }
        if (this.ngd != null) {
            this.ngd.onChangeSkinType(i);
        }
        if (this.nfd != null) {
            this.nfd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLL() {
        if (this.mep.hasFocus()) {
            this.mep.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mep.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.neq.hasFocus()) {
            this.neq.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.neq.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLM() {
        if (this.mep != null && this.mep.getText() != null && this.mep.getText().toString() != null && this.mep.getPaint() != null) {
            if (this.mep.getText().toString().length() == 0) {
                this.mep.getPaint().setFakeBoldText(false);
            } else if (this.mep.getText().toString().length() > 0) {
                this.mep.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eXp = new com.baidu.tbadk.core.view.a(getPageContext());
        this.neH = this.mdW.getType() == 4 || 5 == this.mdW.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.nfi = (TextView) findViewById(R.id.btn_image_problem);
        dLP();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kOV.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kOV.setLayoutParams(layoutParams);
        this.kOV.setOnFocusChangeListener(this.gwb);
        this.neG = (ScrollView) findViewById(R.id.write_scrollview);
        this.neG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.neq != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.neq);
                    }
                    if (WriteActivity.this.eMY != null) {
                        WriteActivity.this.eMY.bqS();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nfg = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.nfh = findViewById(R.id.feedback_divider);
        this.jnW = (RelativeLayout) findViewById(R.id.parent);
        this.neo = (LinearLayout) findViewById(R.id.tool_view);
        this.neo.setContentDescription(IStringUtil.TOP_PATH);
        this.nep = (LinearLayout) findViewById(R.id.title_view);
        this.nff = findViewById(R.id.title_view_divider);
        this.meq = findViewById(R.id.interval_view);
        this.nfK = findViewById(R.id.hot_topic_fourm_view);
        this.nfL = findViewById(R.id.hot_topic_divider);
        this.neJ = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.nfM = (TextView) findViewById(R.id.change_one_tv);
        dxe();
        if (this.neH) {
            this.neG.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dMj();
        } else {
            this.nfp = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.nfp.xp(false);
            } else {
                this.nfp.xp(this.mdW.getType() == 0 || this.mdW.getType() == 9);
            }
            this.nfT = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.mdW.getVideoInfo() != null && this.mdW.getVideoInfo().isEditVideoDataLegal()) {
                xC(false);
                this.nfT.dNC();
            } else {
                xC(true);
            }
        }
        dxg();
        if (this.nfa || this.nen) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().enT) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.mes = (LinearLayout) findViewById(R.id.post_content_container);
        this.mes.setDrawingCacheEnabled(false);
        this.mes.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.neq.requestFocus();
            }
        });
        this.kOc = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kOd = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kOf = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kOf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dbU();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gwb);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dwX();
                WriteActivity.this.dMq();
            }
        });
        this.nfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dLS();
        t(dMC());
        dLU();
        dLO();
        dMA();
        dLG();
        dLT();
        dxd();
        dMa();
        if (this.mdW.getType() == 4 && this.mex != null && this.nes != null) {
            this.mex.setVisibility(8);
            this.nes.setVisibility(8);
        }
        dxf();
        dMw();
        dKO();
        dMs();
        dLN();
        dMB();
        dMt();
        bHP();
    }

    private void dMs() {
        if ("main_tab".equals(this.mFrom)) {
            this.nfQ = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.nfQ.setVisibility(0);
        }
    }

    private void dLN() {
        this.ncd = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nfS = findViewById(R.id.frs_tab__divider);
        this.ncd.setData(this.mXJ);
        if (this.ncd.getVisibility() == 0) {
            this.nfS.setVisibility(0);
        }
        this.ncd.setActivity(this);
    }

    private void dMt() {
        this.nfZ = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.nga = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.ngb = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.ngb, R.color.cp_cont_j);
        this.ngd = new EBusinessProtocolView(this);
        this.ngd.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.ngd.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.ngd, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.ngb.setText(spannableString);
        this.ngb.setMovementMethod(LinkMovementMethod.getInstance());
        this.nga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nge) {
                    WriteActivity.this.nge = false;
                    WriteActivity.this.nga.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.nge = true;
                    WriteActivity.this.nga.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.nge) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nG(R.color.cp_cont_b);
                    aVar.zU("");
                    aVar.zV(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.nH(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.28.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bia();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.nge = true;
            this.nga.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.nge = false;
            this.nga.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.ngd.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void xy(boolean z) {
                if (z) {
                    if (!WriteActivity.this.nge) {
                        WriteActivity.this.nge = true;
                        WriteActivity.this.nga.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.nge) {
                    WriteActivity.this.nge = false;
                    WriteActivity.this.nga.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dMu() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.ngm = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.nfj = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.nfj, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.nfj.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nfj.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.nfj.setLayoutParams(layoutParams2);
        this.nfj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dMv();
            }
        });
        this.nfj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMv() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dKO() {
        if (this.mName != null && this.mdW != null && this.mdW.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dLO() {
        String str;
        String str2;
        if (this.mdW != null) {
            switch (this.mdW.getType()) {
                case 0:
                case 9:
                    if (this.nfa || this.nen) {
                        if (this.nfc) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iDT != null && this.iDT.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nbH) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iDT != null && this.iDT.equals("2")) {
                        if (StringUtils.isNull(this.mdW.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mdW.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mdW.getForumName() + getResources().getString(R.string.bar));
                        this.mep.setVisibility(8);
                        String str3 = this.hXP + " " + this.hXN;
                        if (!StringUtils.isNull(str3)) {
                            this.neq.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.mep.setVisibility(0);
                    this.neq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.neq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mep.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.neq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mdW.getFloorNum() + 1)));
                    this.nfu.setVisibility(8);
                    return;
                case 7:
                    this.mep.setVisibility(0);
                    this.neq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dLP() {
        if (this.mdW.getType() == 7) {
            this.kOV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.kOV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dLQ() {
        if (this.mdW != null && this.mdW.getType() == 0 && this.mdW.getType() == 9 && !this.nfa && !this.nen && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dLY() != null) {
                dLY().setText(cutStringWithSuffix);
                dLY().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.kOc.setVisibility(0);
            this.kOd.setVoiceModel(voiceModel);
            this.kOd.bQr();
            dxf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbU() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Bi(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.kOc.setVisibility(8);
        this.kOd.cAY();
        this.kOd.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qr = this.eMY.qr(6);
        if (qr != null && qr.eMS != null) {
            qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dxf();
    }

    private void dLR() {
        this.fSE = null;
        this.neC = -1;
        this.neE = -1;
        com.baidu.tieba.frs.ah xS = ag.cri().xS(1);
        if (xS != null) {
            this.fSE = xS.ieB;
            this.neC = getIntent().getIntExtra("category_id", -1);
            if (this.fSE != null && !this.fSE.isEmpty() && this.neC >= 0) {
                this.neB = new af();
                this.neB.iex = 0;
                this.neB.name = getPageContext().getResources().getString(R.string.category_auto);
                this.neE = this.neB.iex;
                this.neD = this.neB.name;
                for (af afVar : this.fSE) {
                    if (afVar.iex == this.neC) {
                        this.neE = afVar.iex;
                        this.neD = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dLS() {
        if (this.fSE != null && !this.fSE.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.neF = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.neF.setText(this.neD);
            this.neF.setCategoryContainerData(this.fSE, this.neB, this.neE);
            this.neF.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.neF.setText(bfVar.name);
                        WriteActivity.this.mdW.setCategoryTo(bfVar.iex);
                        WriteActivity.this.neE = bfVar.iex;
                        WriteActivity.this.neF.dLj();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.neF.dLi();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLY());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLX());
                }
            });
        }
    }

    private void dMw() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.neU = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.neU.setTitle(R.string.no_disturb_start_time);
        this.neU.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.neU);
        this.neU.setButton(-2, getPageContext().getString(R.string.cancel), this.neU);
        return this.neU;
    }

    private void dLT() {
        this.nex = (RelativeLayout) findViewById(R.id.addition_container);
        this.ney = (TextView) findViewById(R.id.addition_create_time);
        this.nez = (TextView) findViewById(R.id.addition_last_time);
        this.neA = (TextView) findViewById(R.id.addition_last_content);
        if (this.f5new != null) {
            this.nex.setVisibility(0);
            this.ney.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.f5new.getCreateTime() * 1000));
            if (this.f5new.getAlreadyCount() == 0) {
                this.nez.setVisibility(8);
            } else {
                this.nez.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.f5new.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.f5new.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.neA.setText(lastAdditionContent);
            } else {
                this.neA.setVisibility(8);
            }
            dLX().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.f5new.getAlreadyCount()), Integer.valueOf(this.f5new.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nex.setVisibility(8);
    }

    private void dxd() {
        this.mex = findViewById(R.id.post_prefix_layout);
        if (this.nfO == null) {
            this.nfO = new com.baidu.tieba.c.e(getPageContext(), this.mex);
            this.nfO.eW(R.drawable.bg_tip_blue_up_left);
            this.nfO.eV(16);
            this.nfO.nA(true);
            this.nfO.setUseDirectOffset(true);
            this.nfO.we(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.meu = (TextView) findViewById(R.id.post_prefix);
        this.nes = findViewById(R.id.prefix_divider);
        this.mew = (ImageView) findViewById(R.id.prefix_icon);
        dMx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMx() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mex.setVisibility(0);
            this.nes.setVisibility(0);
            this.nfO.y(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mdX = 0;
            this.mex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dF("fid", WriteActivity.this.mdW.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.meu.setVisibility(0);
                    WriteActivity.this.mex.setSelected(true);
                    SvgManager.bkl().a(WriteActivity.this.mew, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mev, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eMY.bqS();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mep);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.neq);
                }
            });
            this.meu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dF("fid", WriteActivity.this.mdW.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.meu.setSelected(true);
                    SvgManager.bkl().a(WriteActivity.this.mew, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.mev, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eMY.bqS();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLY());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLX());
                }
            });
            this.mev = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mev.a(this);
            this.mev.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mev.setOutsideTouchable(true);
            this.mev.setFocusable(true);
            this.mev.setOnDismissListener(this);
            this.mev.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.meu, R.color.cp_bg_line_d);
            SvgManager.bkl().a(this.mew, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.meu.setTextColor(color);
            this.neu.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.neu.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xm(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xm(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mev.addView(writePrefixItemLayout);
            }
            this.mev.setCurrentIndex(0);
            this.meu.setText(prefixs.get(0));
            Ku(0);
            return;
        }
        this.mex.setVisibility(8);
        this.nes.setVisibility(8);
    }

    private void dMy() {
        if (this.nfa && this.mdW != null) {
            this.nfg.setVisibility(0);
            this.nfh.setVisibility(0);
            this.ner = new FeedBackModel(getPageContext());
            this.ner.Tt(this.mdW.getForumName());
            this.ner.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.nfg.setVisibility(8);
                        WriteActivity.this.nfh.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.nfg.setVisibility(8);
                        WriteActivity.this.nfh.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.nfg.a(feedBackModel.dLr(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dLU() {
        this.kOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.nfQ == null || WriteActivity.this.nfR != null) {
                    if (WriteActivity.this.dMR()) {
                        if (!WriteActivity.this.ngg || WriteActivity.this.nge) {
                            if (WriteActivity.this.dMT()) {
                                int dMS = WriteActivity.this.dMS();
                                if (dMS == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dMS == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.neM.a(WriteActivity.this.mep, WriteActivity.this.neq)) {
                                    WriteActivity.this.showToast(WriteActivity.this.neM.dJB());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLY());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dLX());
                                WriteActivity.this.eMY.bqS();
                                if (WriteActivity.this.mdW.getType() != 7) {
                                    if (WriteActivity.this.nfa) {
                                        WriteActivity.this.ctt();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.ai("obj_type", StringUtils.isNull(WriteActivity.this.mdW.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.dMd();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.ctt();
                                }
                                MercatorModel.dBy().startLoad();
                                TiebaStatic.log(new aq("c12262").dF("obj_locate", WriteActivity.this.iDT));
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

    protected void dxe() {
        this.nfe = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.nfe.setIsRound(true);
        this.nfe.setDrawBorder(false);
        this.nfe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String As = q.As(currentPortrait);
            this.nfe.setUrl(As);
            this.nfe.startLoad(As, 12, false);
        }
        if (this.mdW.isUserFeedback()) {
            this.nfe.setVisibility(0);
        }
        this.mep = (EditText) findViewById(R.id.post_title);
        this.mep.setOnClickListener(this.neQ);
        this.mep.setOnFocusChangeListener(this.gwb);
        if (this.mdW.getType() == 0 || this.mdW.getType() == 9 || this.mdW.getType() == 7) {
            if (this.mdW.getTitle() != null) {
                this.mep.setText(this.mdW.getTitle());
                this.mep.setSelection(this.mdW.getTitle().length());
            } else if (this.nfc) {
                this.mep.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mdW.getType() == 1 || this.mdW.getType() != 2) {
        }
        this.mep.addTextChangedListener(this.neS);
        if (!this.mdW.getHaveDraft()) {
            dLQ();
            this.nfJ = true;
        }
        this.nfd = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher apj() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int ngq;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dxf();
                if (WriteActivity.this.neH) {
                    this.ngq = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.ngq);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.neH || !WriteActivity.this.nfB) {
                    if (WriteActivity.this.neH) {
                        if (this.mEditText != WriteActivity.this.nfs || this.mTextView != WriteActivity.this.nfy) {
                            this.mEditText = WriteActivity.this.nfs;
                            this.mTextView = WriteActivity.this.nfy;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.nfw || this.mTextView != WriteActivity.this.nfx) {
                    this.mEditText = WriteActivity.this.nfw;
                    this.mTextView = WriteActivity.this.nfx;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.neH && this.nfB) {
            if (this.nfz != null) {
                this.nfw.removeTextChangedListener(this.nfz);
            }
            this.nfz = textWatcher;
        } else if (this.neH) {
            if (this.nfA != null) {
                this.nfs.removeTextChangedListener(this.nfA);
            }
            this.nfA = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.nfs) {
            return 233L;
        }
        if (editText != this.nfw) {
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
        return com.baidu.tieba.write.c.a.s(editText.getText().toString().trim());
    }

    protected void dxg() {
        this.neq = (SpanGroupEditText) findViewById(R.id.post_content);
        this.neq.setDrawingCacheEnabled(false);
        this.neq.setOnClickListener(this.neQ);
        this.neq.setOnSpanGroupChangedListener(new a.InterfaceC0539a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0539a
            public void E(int i, boolean z) {
                WriteActivity.this.Ka();
            }
        });
        this.neq.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.neq.setForumId(com.baidu.adp.lib.f.b.toLong(this.mdW.getForumId(), 0L));
        this.neq.setTransLink(!this.nbH);
        if (this.ePk != null) {
            this.ePk.setSpanGroupManager(this.neq.getSpanGroupManager());
        }
        if (this.mdW != null) {
            this.mdW.setSpanGroupManager(this.neq.getSpanGroupManager());
        }
        if (this.mdW.getContent() != null && this.mdW.getContent().length() > 0) {
            this.neq.setText(TbFaceManager.bua().as(getPageContext().getPageActivity(), this.mdW.getContent()));
            if (this.neq.getText() != null) {
                this.neq.setSelection(this.neq.getText().length());
            }
        } else if (this.mdW.getType() == 2) {
            if (this.nfk) {
                if (this.nfl != null && this.nfl.length() > 0) {
                    this.neq.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.nfl}));
                    this.neq.setSelection(this.neq.getText().length());
                }
            } else if (this.mdW.getFloorNum() > 0) {
                this.neq.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mdW.getFloorNum())));
                this.neq.setSelection(this.neq.getText().length());
            }
        }
        this.neq.setOnFocusChangeListener(this.gwb);
        this.neq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.neq.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.neq.addTextChangedListener(this.neT);
        if (this.mdW.getType() == 0) {
            this.nfN = true;
        } else {
            xD(true);
            this.nfN = false;
        }
        if (this.mdW.isUserFeedback()) {
            this.neq.setHint(R.string.write_input_content);
        } else {
            this.neq.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void xD(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.neH && !this.nbH && dLX() != null) {
            dLX().setPadding(0, 0, 0, 0);
            dLX().setBackgroundDrawable(null);
            ap.setBackgroundColor(dLX(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.khc) || this.f5new != null) {
                return;
            }
            if (this.nfT == null || !this.nfT.isVisible()) {
                com.baidu.adp.lib.e.c.mR().a(this.khc, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass42) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.nfT == null || !WriteActivity.this.nfT.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dLX().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dLX(), true, WriteActivity.this.kUZ);
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

    private void dMz() {
        if (dLX() != null) {
            dLX().setPadding(0, 0, 0, 0);
            dLX().setBackgroundDrawable(null);
            ap.setBackgroundColor(dLX(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dLW() {
        int i = 5000;
        if (this.f5new != null) {
            i = 1000;
        }
        return dLX().getText() != null && dLX().getText().length() >= i;
    }

    private void Cq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nek)) {
                this.nek = "";
                dLX().requestFocus();
                if (dLX().getText() != null && dLX().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dLX().getSelectionStart();
                    editable = dLX().getText();
                }
            } else if ("from_title".equals(this.nek)) {
                this.nek = "";
                dLY().requestFocus();
                if (dLY().getText() != null && dLY().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dLY().getSelectionStart();
                    editable = dLY().getText();
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
    public void xA(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mdW != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mdW.getForumId(), 0L), this.mdW.getFirstDir(), this.mdW.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dLX().getText().getSpans(0, dLX().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nev == null) {
                this.nev = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.nev.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dLX());
    }

    EditText dLX() {
        return this.neH ? this.nfs : this.neq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dLY() {
        return this.neH ? this.nfw : this.mep;
    }

    protected void dLZ() {
        if (dLX().getSelectionStart() > 0) {
            String substring = dLX().getText().toString().substring(0, dLX().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hLW.matcher(substring);
            if (matcher.find()) {
                dLX().getText().delete(dLX().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dLX().getSelectionStart());
                return;
            }
            dLX().onKeyDown(67, this.hLX);
        }
    }

    private void t(Boolean bool) {
        String str = null;
        if (this.mdW != null) {
            str = this.mdW.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.nfa = true;
        }
    }

    private void dMA() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dMB() {
        this.nfV = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.nfU = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.nfV);
        aq(getIntent());
    }

    private void bHP() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.nfY = new d(getPageContext());
        this.nfY.a(this.nfX);
        this.mListView.setAdapter((ListAdapter) this.nfY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.nfY != null && (WriteActivity.this.nfY.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.nfY.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.dZR == 1) {
                            be.bkp().b(WriteActivity.this.getPageContext(), new String[]{tVar.dZJ});
                        } else {
                            be.bkp().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dZJ)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.dZM)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.dZM));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.dZN)) {
                                be.bkp().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dZN)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.dZN)) {
                            be.bkp().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dZN)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eXp.setCancelListener(null);
        this.eXp.setTipString(R.string.sending);
        this.eXp.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eXp.setDialogVisiable(false);
    }

    private Boolean dMC() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.nfm = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.ePo = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.nfm);
    }

    public void dxf() {
        this.nfW = false;
        if (this.mdW != null) {
            String str = "";
            String str2 = "";
            if (dLY() != null) {
                str = dLY().getText().toString();
            }
            if (dLX() != null) {
                str2 = dLX().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mdW.getType() == 0 || this.mdW.getType() == 9 || this.mdW.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.mdX == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mdW.setIsNoTitle(true);
                        } else if (this.nep.getVisibility() == 0) {
                            this.mdW.setIsNoTitle(false);
                            xB(true);
                            return;
                        }
                    } else if (this.nep.getVisibility() == 0) {
                        this.mdW.setIsNoTitle(false);
                        xB(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mdW.setIsNoTitle(true);
                } else if (this.nep.getVisibility() == 0) {
                    this.mdW.setIsNoTitle(false);
                    xB(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.neH) {
                    xB(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    xB(true);
                }
            }
            if (this.mdW.getType() == 4) {
                xB(m(this.nfs) && l(this.nfw));
            } else if (this.mdW.getType() == 5) {
                xB(m(this.nfs));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                xB(true);
            } else if (this.mdW.getVideoInfo() != null) {
                xB(this.mdW.getVideoInfo().isVideoMixFinished());
            } else if (dMP()) {
                xB(true);
                this.nfW = true;
            } else {
                xB(false);
            }
        }
    }

    public void xB(boolean z) {
        this.kOV.setEnabled(z);
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
        this.ePk = new NewWriteModel(this);
        this.ePk.b(this.ePy);
        registerListener(this.ngh);
        registerListener(this.ngi);
        registerListener(this.ngj);
        this.hQL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.46
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dwX();
            }
        };
        this.mdW = new WriteData();
        if (bundle != null) {
            this.mdW.setType(bundle.getInt("type", 0));
            this.mdW.setForumId(bundle.getString("forum_id"));
            this.mdW.setForumName(bundle.getString("forum_name"));
            this.mdW.setFirstDir(bundle.getString("forum_first_dir"));
            this.mdW.setSecondDir(bundle.getString("forum_second_dir"));
            this.mdW.setThreadId(bundle.getString("thread_id"));
            this.mdW.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mdW.setFloorNum(bundle.getInt("floor_num", 0));
            this.nfa = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.nfb = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nfc = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nfk = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nfl = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ePi = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.f5new = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mdW.setIsAddition(this.f5new != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.nfn = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mdW.setTitle(bundle.getString("write_title"));
            this.mdW.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mdW.setTopicId(this.mTopicId);
            this.iDT = bundle.getString("KEY_CALL_FROM");
            this.brK = bundle.getInt("album_thread");
            this.mXJ = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mdW.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mdW.setType(intent.getIntExtra("type", 0));
            this.mdW.setForumId(intent.getStringExtra("forum_id"));
            this.mdW.setForumName(intent.getStringExtra("forum_name"));
            this.mdW.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mdW.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mdW.setThreadId(intent.getStringExtra("thread_id"));
            this.mdW.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mdW.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nfa = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.nfb = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.nfc = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.nfk = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.nfl = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.f5new = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mdW.setIsAddition(this.f5new != null);
            this.mdW.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.nfn = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hXO = intent.getStringExtra("more_forum_img");
            this.hXP = intent.getStringExtra("more_forum_title");
            this.hXN = intent.getStringExtra("more_forum_url");
            this.mdW.setTitle(intent.getStringExtra("write_title"));
            this.mdW.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mdW.setTopicId(this.mTopicId);
            this.iDT = intent.getStringExtra("KEY_CALL_FROM");
            this.brK = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mXJ = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mdW.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mdW.mDynamicImageTextData = new ImageTextUploadData();
            this.nbH = true;
        }
        if (this.mdW.getType() == 9) {
            this.mdW.setEntranceType(1);
        } else if (this.mdW.getType() == 10) {
            this.mdW.setEntranceType(2);
            this.mdW.setType(9);
        } else if (this.mdW.getType() == 0) {
            this.mdW.setEntranceType(3);
        }
        this.mdW.setIsUserFeedback(this.nfa);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mdW.getType() == 4 ? 6 : 9);
        this.mdW.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mdW.getType() == 0 || this.mdW.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nbH) {
                    x.d(this.mdW.getForumId(), this);
                } else {
                    x.c(this.mdW.getForumId(), this);
                }
            }
        } else if (this.mdW.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.mdW.getType() == 1) {
            x.a(this.mdW.getThreadId(), this);
        } else if (this.mdW.getType() == 4) {
            x.c(this.mdW.getForumId() + "photolive", this);
        } else if (this.mdW.getType() == 5) {
            x.a(this.mdW.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.khc = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mdW != null && this.mdW.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mdW.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nen = true;
        }
        dLR();
        try {
            this.nfC = dML();
        } catch (Throwable th) {
            this.nfC = null;
        }
    }

    private void dMa() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mep.setText(com.baidu.tbadk.plugins.b.CV(com.baidu.tbadk.plugins.b.CW(hotTopicBussinessData.mTopicName)));
            this.mep.setMovementMethod(com.baidu.tieba.view.c.dJc());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString CV = com.baidu.tbadk.plugins.b.CV(com.baidu.tbadk.plugins.b.CW(hotTopicBussinessData.mTopicName));
            if (CV != null) {
                this.mep.setText(CV);
            }
            this.neJ.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.ngg) {
            if (writeData != null) {
                if (this.mdW != null) {
                    boolean z = this.mdW.getVideoInfo() != null && this.mdW.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.mdW.getWriteImagesInfo() == null || y.isEmpty(this.mdW.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dLY().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dLX().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bua().a(getPageContext().getPageActivity(), writeData.getContent(), this.neO));
                    if (!z || z7) {
                        this.mdW.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.nfJ || ((this.nfa || this.nen) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.nfa || this.nen)) {
                            j(writeData);
                        }
                        if (this.mdW != null && !this.mdW.getHaveDraft()) {
                            dLQ();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dMD();
                        }
                        dxf();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fSE != null) {
                            this.neE = this.neB.iex;
                            this.neD = this.neB.name;
                            while (true) {
                                if (i == this.fSE.size()) {
                                    break;
                                }
                                af afVar = this.fSE.get(i);
                                if (categoryTo != afVar.iex) {
                                    i++;
                                } else {
                                    this.neE = categoryTo;
                                    this.neD = afVar.name;
                                    this.mdW.setCategoryTo(this.neE);
                                    break;
                                }
                            }
                            if (this.neF != null) {
                                this.neF.setText(this.neD);
                                this.neF.setCategoryContainerData(this.fSE, this.neB, this.neE);
                            }
                        }
                        this.eMY.bqS();
                        return;
                    }
                    return;
                }
                return;
            }
            dMD();
            dLQ();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mdW.setVideoInfo(videoInfo);
            xC(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mdW.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dMf();
        }
        xE(false);
        xC(true);
    }

    private void i(WriteData writeData) {
        String str;
        String CW;
        if (com.baidu.adp.lib.util.k.isEmpty(this.mdW.getTitle())) {
            this.mdW.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                CW = this.mdW.getTitle();
            } else {
                CW = com.baidu.tbadk.plugins.b.CW(str);
            }
            SpannableString CV = com.baidu.tbadk.plugins.b.CV(CW);
            if (CV != null) {
                dLY().setText(CV);
                dLY().setSelection(CV.length() > CW.length() ? CW.length() : CV.length());
                return;
            }
            return;
        }
        SpannableString CV2 = com.baidu.tbadk.plugins.b.CV(this.mdW.getTitle());
        if (CV2 != null) {
            dLY().setText(CV2);
            dLY().setSelection(this.mdW.getTitle().length() > CV2.length() ? CV2.length() : this.mdW.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.mdW.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bua().a(getPageContext().getPageActivity(), this.mdW.getContent(), this.neO);
        InputFilter[] filters = this.neq.getFilters();
        this.neq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dLX().setText(a2);
        if (dLX() == this.neq && this.neq.getSpanGroupManager() != null) {
            this.neq.bmn();
            this.neq.getSpanGroupManager().bmt();
            this.neq.bmo();
            Ka();
        }
        this.neq.setFilters(filters);
        if (dLX().getText() != null) {
            dLX().setSelection(dLX().getText().length());
        }
        if (this.neH) {
            a(this.nfy, this.nfs);
        }
    }

    private void dMD() {
        if ((!this.neH || this.nfr != null) && this.nfq != null) {
            this.nfr.b(this.writeImagesInfo);
            dMH();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mdW.getType());
        bundle.putString("forum_id", this.mdW.getForumId());
        bundle.putString("forum_name", this.mdW.getForumName());
        bundle.putString("forum_first_dir", this.mdW.getFirstDir());
        bundle.putString("forum_second_dir", this.mdW.getSecondDir());
        bundle.putString("thread_id", this.mdW.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mdW.getFloor());
        bundle.putInt("floor_num", this.mdW.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.nfk);
        if (this.nfa) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ePi);
        if (this.f5new != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.f5new));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.nfn);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iDT);
        bundle.putInt("album_thread", this.brK);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mXJ);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dLX().getEditableText().toString();
        if (obj != null) {
            dLX().setText(TbFaceManager.bua().a(getPageContext().getPageActivity(), obj, this.neO));
            dLX().setSelection(dLX().getText().length());
        }
    }

    private String getContent() {
        return (dLX() == null || dLX().getText() == null) ? "" : dLX().getText().toString();
    }

    private String dMc() {
        if (this.mdW == null || dLY() == null || dLY().getVisibility() != 0 || dLY().getText() == null) {
            return "";
        }
        String obj = dLY().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mdX != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mdW.getType() != 4 && this.meu != null && this.meu.getText() != null) {
            this.mdW.setPostPrefix(this.meu.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mdW.getTitle();
        }
        return obj;
    }

    private void Tu(String str) {
        if (this.mdW != null && this.nep != null) {
            if (this.nep.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mdW.setIsNoTitle(true);
                    this.mdW.setTitle("");
                    return;
                }
                this.mdW.setIsNoTitle(false);
                this.mdW.setTitle(str);
                return;
            }
            this.mdW.setIsNoTitle(true);
            this.mdW.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctt() {
        dwX();
        this.mdW.setContent(getContent());
        Tu(dMc());
        if (this.nfa || this.nen) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mdW.getTitle()) || !this.mdW.getTitle().startsWith(string)) {
                Tu(string + this.mdW.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mdW.getContent()) || !this.mdW.getContent().startsWith(str)) {
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
                sb.append(this.mdW.getContent());
                this.mdW.setContent(sb.toString());
            }
        }
        if (this.nfb) {
            this.mdW.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.neC >= 0) {
            this.mdW.setCategoryFrom(this.neC);
        }
        if (this.neE >= 0) {
            this.mdW.setCategoryTo(this.neE);
        }
        this.mdW.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nfU != null) {
            this.mdW.setWriteVoteData(this.nfU.getWriteVoteData());
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
            this.mdW.setTakePhotoNum(i);
        }
        this.mdW.setHasLocationData(this.ePj != null && this.ePj.bZh());
        if (this.writeImagesInfo != null) {
            this.ePk.wr(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.neI != null && this.neI.mIsGlobalBlock == 0) {
            this.mdW.setForumId(String.valueOf(this.neI.mForumId));
            this.mdW.setForumName(this.neI.mForumName);
        }
        dKR();
        this.ePk.e(this.mdW);
        this.mdW.setContent(this.mdW.getContent().replaceAll("\u0000\n", ""));
        this.mdW.setContent(this.mdW.getContent().replaceAll("\u0000", ""));
        this.mdW.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ePk.cOG().setVoice(this.mVoiceModel.getId());
                this.ePk.cOG().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ePk.cOG().setVoice(null);
                this.ePk.cOG().setVoiceDuringTime(-1);
            }
        } else {
            this.ePk.cOG().setVoice(null);
            this.ePk.cOG().setVoiceDuringTime(-1);
        }
        if (!this.ePk.dBT()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mdW.mDynamicImageTextData != null) {
            dKQ();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hQL);
            this.ePk.dBQ();
        }
    }

    private void dKR() {
        FrsTabItemData selectedTabItemData;
        if (this.mdW != null && this.ncd != null && (selectedTabItemData = this.ncd.getSelectedTabItemData()) != null) {
            this.mdW.setTabId(selectedTabItemData.tabId);
            this.mdW.setTabName(selectedTabItemData.name);
            this.mdW.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dKQ() {
        if (this.mdW.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.mdW, new a.InterfaceC0825a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                @Override // com.baidu.tieba.write.b.a.InterfaceC0825a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dKz().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.47.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.ctq();
                            x.e(WriteActivity.this.mdW.getForumId(), (WriteData) null);
                            WriteActivity.this.dMr();
                            com.baidu.tieba.write.b.a.dKt();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.js(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dKt();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0825a
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
            if (this.f5new != null) {
                i2 = this.f5new.getTotalCount();
                i = this.f5new.getAlreadyCount() + 1;
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
                if (this.mep == getCurrentFocus()) {
                    dLX().clearFocus();
                    this.mep.requestFocus();
                    if (this.eMY != null) {
                        this.eMY.bqS();
                    }
                    ShowSoftKeyPadDelay(this.mep);
                } else {
                    dLX().requestFocus();
                    if (this.eMY != null) {
                        this.eMY.bqS();
                    }
                    ShowSoftKeyPadDelay(this.neq);
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
                            dLX().getText().insert(dLX().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                ctq();
                dMr();
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
                                dMI();
                            } else {
                                at(intent);
                            }
                        } else if (intExtra == 1) {
                            au(intent);
                        } else {
                            ar(intent);
                            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.48
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        xC(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.nfN) {
                            xD(true);
                            this.nfN = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.neH) {
                        F(intent);
                        dxf();
                        return;
                    }
                    as(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mdW.setVideoInfo(videoInfo);
                        this.eMY.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.eMY.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.eMY.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dxf();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.nel) {
                                sb2.append(com.baidu.tbadk.plugins.b.eWI);
                                this.nel = false;
                            }
                            sb2.append(stringExtra);
                            Cq(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.neI = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.neI);
                    }
                } else if (i == 25048) {
                    aq(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.neq.getSelectionStart();
                    int selectionEnd = this.neq.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.neq.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.eMY != null && !this.eMY.bsz()) {
                this.neq.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.eMY.bqS();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    btl();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dMG();
                    if (this.nfN) {
                        xD(true);
                        this.nfN = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.mep == getCurrentFocus()) {
                        dLX().clearFocus();
                        this.mep.requestFocus();
                        if (this.eMY != null) {
                            this.eMY.bqS();
                        }
                        ShowSoftKeyPadDelay(this.mep);
                        return;
                    }
                    dLX().requestFocus();
                    if (this.eMY != null) {
                        this.eMY.bqS();
                    }
                    ShowSoftKeyPadDelay(this.neq);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.neM.SW(postWriteCallBackData.getErrorString());
                        this.neM.bh(postWriteCallBackData.getSensitiveWords());
                        this.neM.b(this.mep, this.neq);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.ePi = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.ePi);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dMG();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nek)) {
                        dLY().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nek)) {
                        dLX().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMd() {
        if ("1".equals(this.iDT)) {
            this.mdW.setCanNoForum(true);
            this.mdW.setTransmitForumData("[]");
        } else if ("2".equals(this.iDT)) {
            this.mdW.setCanNoForum(false);
        }
        dMe();
        this.mdW.setPrivacy(this.isPrivacy);
        dME();
        this.mdW.setToDynamic(this.isToDynamic);
        this.mdW.setCallFrom(this.iDT);
        if (this.mdW.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        ctt();
    }

    private void dMe() {
        if (this.eMY != null) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dME() {
        if (this.eMY != null) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dMF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dMG() {
        if (this.neH) {
            this.nfr.b(this.writeImagesInfo);
            dMH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMH() {
        this.nfr.notifyDataSetChanged();
        this.nfq.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.nfr.notifyDataSetChanged();
                WriteActivity.this.nfq.invalidateViews();
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
        dxf();
    }

    private void ar(Intent intent) {
        if (this.neH) {
            as(intent);
            dMG();
        } else {
            av(intent);
        }
        dxf();
    }

    private void as(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dMG();
            xE(true);
        }
    }

    private void at(Intent intent) {
        if (this.writeImagesInfo != null) {
            E(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dMI() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void au(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.nfo.parseJson(stringExtra);
            this.nfo.updateQuality();
            if (this.nfo.getChosedFiles() != null && this.nfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.nfo.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.nfo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dLY());
        HidenSoftKeyPad(this.mInputManager, dLX());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.nfT != null) {
            this.nfT.onPause();
        }
        if (this.eMY.bsz()) {
            this.eMY.bqS();
        }
    }

    private void av(Intent intent) {
        b(intent, true);
    }

    private void E(Intent intent) {
        this.ePi = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.ePi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.ePi, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dMJ();
            dMf();
        }
        xE(true);
    }

    private void F(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dMJ();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dMf();
                }
            }
            xE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dMJ() {
        if (this.eMY.qr(10) != null) {
            this.eMY.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void btl() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.50
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.ePi));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dMK() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hXO)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.hXO, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.51
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
                            WriteActivity.this.xE(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(boolean z) {
        String forumId = this.mdW == null ? "" : this.mdW.getForumId();
        if (this.nfp != null) {
            this.nfp.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cpE() {
        this.hZU = getVoiceManager();
        this.hZU.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bC(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.ibq) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mdW.getType() != 7) {
                if (this.f5new == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                F(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.ePp = i;
        if (this.eMY != null) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dMf() {
        if (!this.neH) {
            if (this.eMY != null) {
                this.eMY.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eMY.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mdW == null ? "" : this.mdW.getForumId();
            if (this.nfp != null) {
                this.nfp.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (this.eMY != null) {
            this.eMY.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ku(int i) {
        if (i < this.neu.size()) {
            for (int i2 = 0; i2 < this.neu.size(); i2++) {
                this.neu.get(i2).xn(false);
            }
            this.neu.get(i).xn(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void HV(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 2));
        }
        this.mdX = i;
        this.mev.setCurrentIndex(i);
        Ku(i);
        this.meu.setText(this.mPrefixData.getPrefixs().get(i));
        dxf();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mev, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mex.setSelected(false);
        SvgManager.bkl().a(this.mew, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.neq);
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
        if (this.mdW != null) {
            if (this.mdW.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mdW.getType() == 5) {
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
            btf();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.ePi);
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
        this.bgv = z;
        if (this.nfH && System.currentTimeMillis() - this.nfI < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.nfH = false;
        }
        if (this.neL != null && !z) {
            this.neL.cjh();
        }
        if (this.neN != null && !z) {
            dLI();
        }
        if (this.nfP != null && !z) {
            dMn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tv(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.nfE != null) {
            Tw(str);
            this.nfE.dismiss();
        }
    }

    private void fV(Context context) {
        nfG = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void Tw(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.nfH = true;
        dMJ();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dMf();
        }
        xE(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5413=4] */
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

    private File dML() {
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

    private void dMM() {
        if (this.nfC != null && this.mdW.getType() == 0 && this.mdW.getType() == 9) {
            fV(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.nfC != null) {
                        WriteActivity.this.Tv(WriteActivity.this.nfC.getAbsolutePath());
                    }
                }
            });
            this.nfD = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.nfF = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.nfC.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.nfC.getAbsolutePath());
                Bitmap g = g(this.nfC.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.nfD.setImageBitmap(g);
                    this.nfD.setDrawBorder(true);
                    this.nfD.setBorderWidth(2);
                    this.nfD.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.nfE = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.nfE.setCanceledOnTouchOutside(true);
                    this.nfE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.nfH) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.nfI = System.currentTimeMillis();
                            }
                        }
                    });
                    this.nfE.setContentView(this.mBubbleView);
                    this.nfE.show();
                    Window window = this.nfE.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (nfG / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bgv && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nel = false;
            this.nek = "";
            if ("from_content".equals(str)) {
                this.nek = "from_content";
            } else if ("from_title".equals(str)) {
                this.nek = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.CU(String.valueOf(charSequence.charAt(i)))) {
                xA(false);
            }
        }
    }

    public void drF() {
        if (com.baidu.tieba.write.c.b.dKI()) {
            this.mep.setHint(R.string.title_hint_for_hot);
            this.nep.setVisibility(0);
            this.nff.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.nfd);
            this.nep.requestFocus();
            return;
        }
        this.nfd.setVisibility(8);
        this.mep.setHint(this.nfa ? R.string.feedback_title_hint : R.string.post_title_hint);
        if (this.nfa || !y.isEmpty(this.mList) || (this.mdW != null && !StringUtils.isNull(this.mdW.getTitle()))) {
            this.nep.setVisibility(0);
            this.nff.setVisibility(0);
            this.nep.requestFocus();
            return;
        }
        this.nep.setVisibility(8);
        this.nff.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMN() {
        if (this.eMY != null) {
            this.eMY.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nbH && WriteActivity.this.eMY != null && WriteActivity.this.eMY.eNb != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bkp().j(clipBoardContent)) {
                            WriteActivity.this.neL.dkh();
                            return;
                        }
                        if (WriteActivity.this.ncT == null) {
                            WriteActivity.this.ncT = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.ngk);
                        }
                        WriteActivity.this.ncT.a(WriteActivity.this.eMY.eNb.qp(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iDT;
    }

    public WriteData cOG() {
        return this.mdW;
    }

    public FrsTabInfoData dMO() {
        return this.mXJ;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dMP() {
        return (this.nfU == null || this.nfV == null || this.nfU.getWriteVoteData() == null || this.nfV.getVisibility() != 0) ? false : true;
    }

    public void dJJ() {
        if (this.mdW != null) {
            TiebaStatic.log(new aq("c13897").ai("obj_locate", 2).dF("fid", this.mdW.getForumId()).dF("fname", this.mdW.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.nH(2);
            aVar.ie(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").ai("obj_locate", 2).dF("fid", WriteActivity.this.mdW != null ? WriteActivity.this.mdW.getForumId() : "").dF("fname", WriteActivity.this.mdW != null ? WriteActivity.this.mdW.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dMQ()));
                    }
                }
            });
            aVar.aZ(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").ai("obj_locate", 2).dF("fid", this.mdW != null ? this.mdW.getForumId() : "").dF("fname", this.mdW != null ? this.mdW.getForumName() : ""));
            aVar.b(getPageContext()).bia();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dMQ()));
    }

    public void Ka() {
        if (this.nfY != null && this.nfY.dLt() == null && this.neq != null && this.neq.getSpanGroupManager() != null) {
            this.nfY.h(this.neq.getSpanGroupManager().bmy());
            this.nfY.refreshData();
        } else if (this.nfY != null && this.nfY.dLt() != null) {
            this.nfY.refreshData();
        }
        if (this.nfY != null) {
            fM(this.nfY.dLs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(List<t> list) {
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
            if (!z && this.nfZ != null) {
                this.nfZ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx(String str) {
        this.ngc = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.ngc.add(com.baidu.tieba.i.a.dR(jSONObject));
                }
                if (this.ngc.size() > 0) {
                    this.ngg = true;
                    this.neq.j(this.ngc, arrayList);
                    dMu();
                    Ka();
                    this.nfZ.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dMQ() {
        if (this.neq == null || this.neq.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.neq.getSpanGroupManager().bmz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMR() {
        return this.canGoods || this.neq == null || this.neq.getSpanGroupManager() == null || this.neq.getSpanGroupManager().bmz() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dMS() {
        boolean z = this.nfY == null || this.nfY.dLu();
        boolean z2 = (this.ncd == null || this.ncd.getSelectedTabItemData() == null || this.ncd.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMT() {
        if (this.mXJ == null || y.isEmpty(this.mXJ.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.mXJ.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dMU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.57
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).xd(false).SP(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aF((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
