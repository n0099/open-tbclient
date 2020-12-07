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
import android.graphics.drawable.Drawable;
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
import com.baidu.n.a.a;
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
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
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
import com.baidu.tbadk.coreExtra.data.v;
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
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
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
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.write.EBusinessProtocolView;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
import com.baidu.tieba.write.write.d;
import com.google.gson.Gson;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0276a, VoiceManager.c, y.a, i.a {
    private static int ods = 0;
    private EditorTools fuh;
    private String fws;
    private LocationModel fwt;
    private NewWriteModel fwu;
    List<ae> gDd;
    private String iQN;
    private String iQO;
    private String iQP;
    private VoiceManager iSU;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private com.baidu.tbadk.core.dialog.i jfV;
    private SaveDraftDialogView jfW;
    private boolean jgf;
    private LinearLayout lJR;
    private PlayVoiceBntNew lJS;
    private ImageView lJU;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nVj;
    private ForumTabSelectedView nZC;
    private com.baidu.tieba.write.i nbA;
    private ImageView nbB;
    private View nbC;
    private int nbd;
    private TextView nbz;
    private FindNewLinkBubbleController oaD;
    private com.baidu.tieba.view.b ocG;
    private TitleTipView ocP;
    private View ocR;
    private View ocT;
    private LinearLayout oca;
    private LinearLayout ocb;
    private View oce;
    private Toast ocg;
    private AdditionData och;
    private RelativeLayout oci;
    private TextView ocj;
    private TextView ock;
    private TextView ocl;
    ae ocm;
    private int ocn;
    private String oco;
    private int ocp;
    private PostCategoryView ocq;
    private HotTopicBussinessData ocu;
    private TextView ocv;
    private com.baidu.tieba.write.editor.b ocx;
    private g ocz;
    private com.baidu.tieba.d.e odA;
    private b odB;
    private ForumSelectedView odC;
    private com.baidu.tbadk.data.j odD;
    private WriteEvaluationHeaderView odE;
    private TextView odF;
    private View odG;
    private com.baidu.tieba.write.write.video.a odH;
    private com.baidu.tieba.write.write.vote.a odI;
    private RelativeLayout odJ;
    private boolean odK;
    private SerializableItemInfo odL;
    private boolean odM;
    private boolean odN;
    private int odO;
    private d odQ;
    private LinearLayout odR;
    private ImageView odS;
    private TextView odT;
    private List<com.baidu.tieba.j.a> odU;
    private EBusinessProtocolView odV;
    private i odb;
    private View odw;
    private View odx;
    private TextView ody;
    private WriteImageGridView oed;
    private com.baidu.tbadk.editortools.c.a oee;
    private int privateThread;
    private String obW = "";
    private boolean obX = false;
    protected WriteData nbc = null;
    private boolean ocM = false;
    private boolean ocN = false;
    private boolean obZ = false;
    private boolean ocO = false;
    private InputMethodManager mInputManager = null;
    private EditText nbu = null;
    private HeadImageView ocQ = null;
    private View nbv = null;
    private LinearLayout nbx = null;
    private SpanGroupEditText occ = null;
    private FeedBackModel ocd = null;
    private FeedBackTopListView ocS = null;
    private ArrayList<WritePrefixItemLayout> ocf = new ArrayList<>();
    private String lcn = null;
    private final KeyEvent iEX = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ocU = null;
    private TextView lKK = null;
    private TextView mName = null;
    private ImageView ocV = null;
    private DialogInterface.OnCancelListener iJM = null;
    private final Handler mHandler = new Handler();
    private boolean ocW = false;
    private String ocX = null;
    private RelativeLayout kjE = null;
    public boolean ocY = true;
    public String fwy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fwz = 0;
    private int ocZ = 0;
    private WriteImagesInfo oda = new WriteImagesInfo();
    private View mRootView = null;
    private GridView odc = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a odd = null;
    private ScrollView ocs = null;
    private EditText ode = null;
    private View odf = null;
    private View odg = null;
    private View odh = null;
    private EditText odi = null;
    private TextView odj = null;
    private TextView odk = null;
    private TextWatcher odl = null;
    private TextWatcher odm = null;
    private boolean oct = false;
    private boolean odn = false;
    private com.baidu.tbadk.core.view.a fEW = null;
    private String mFrom = "write";
    private File odo = null;
    private TbImageView odp = null;
    private View mBubbleView = null;
    private Dialog odq = null;
    private LinearLayout odr = null;
    private boolean odt = false;
    private long odu = -1000;
    private boolean odv = false;
    private String jzq = "2";
    private int bHu = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder ocw = new SpannableStringBuilder();
    private boolean odz = false;
    private boolean bqA = false;
    private final c ocy = new c();
    private boolean nZg = false;
    private final d.a odP = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void MY(int i) {
            if (WriteActivity.this.occ != null) {
                WriteActivity.this.occ.rn(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gs(List<u> list) {
            WriteActivity.this.gt(list);
        }
    };
    private boolean odW = false;
    private int odX = 0;
    private boolean odY = false;
    private final HttpMessageListener odZ = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.lcn)) {
                    WriteActivity.this.lcn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zv(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.lcn)) {
                    WriteActivity.this.lcn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.lcn);
                    WriteActivity.this.zv(true);
                }
            }
        }
    };
    private CustomMessageListener oea = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nbc != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").al("obj_locate", 1).dY("fid", WriteActivity.this.nbc.getForumId()).dY("fname", WriteActivity.this.nbc.getForumName()));
            }
        }
    };
    private final CustomMessageListener oeb = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.odC != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                WriteActivity.this.odD = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                if (WriteActivity.this.odD != null && !StringUtils.isNull(WriteActivity.this.odD.forumId) && !StringUtils.isNull(WriteActivity.this.odD.forumName)) {
                    if (WriteActivity.this.nbc != null) {
                        WriteActivity.this.nbc.setForumId(WriteActivity.this.odD.forumId);
                        WriteActivity.this.nbc.setForumName(WriteActivity.this.odD.forumName);
                    }
                    WriteActivity.this.odC.setSelectedForum(WriteActivity.this.odD.forumName);
                    WriteActivity.this.nVj = null;
                    if (!com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.odD.tabInfoList)) {
                        WriteActivity.this.nVj = new FrsTabInfoData();
                        WriteActivity.this.nVj.selectedTabId = -1;
                        WriteActivity.this.nVj.tabList = WriteActivity.this.odD.tabInfoList;
                        if (WriteActivity.this.odD.isForumBusinessAccount && WriteActivity.this.nVj.tabList != null) {
                            FrsTabItemData frsTabItemData = new FrsTabItemData();
                            frsTabItemData.tabId = 505;
                            frsTabItemData.name = "官方";
                            WriteActivity.this.nVj.tabList.add(0, frsTabItemData);
                        }
                        WriteActivity.this.nVj.isForumBusinessAccount = WriteActivity.this.odD.isForumBusinessAccount;
                    }
                    WriteActivity.this.nZC.setData(WriteActivity.this.nVj);
                    if (WriteActivity.this.nZC.getVisibility() == 0) {
                        WriteActivity.this.odG.setVisibility(0);
                    }
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.odD.fsW != null && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.odD.fsW.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.odD.fsW;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.ebn();
                }
            }
        }
    };
    private TbFaceManager.a ocA = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Eg(String str) {
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
    private final AntiHelper.a iUq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a oec = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.oaD != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.oaD.Yk();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cCE();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.oeg = true;
            if (postWriteCallBackData != null && WriteActivity.this.nbc != null) {
                WriteActivity.this.ocy.bn(null);
                if (z) {
                    WriteActivity.this.kE(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.nbc);
                    WriteActivity.this.cGs();
                    WriteActivity.this.ebf();
                    if ((WriteActivity.this.nbc.getType() == 0 || WriteActivity.this.nbc.getType() == 9 || WriteActivity.this.nbc.getType() == 11) && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dY("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.nbc.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.nbc.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.nbc.getForumName())) {
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
                    WriteActivity.this.ocy.bn(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.ocy.VA(postWriteCallBackData.getErrorString());
                    WriteActivity.this.ocy.b(WriteActivity.this.nbu, WriteActivity.this.occ);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bq(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bq(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.62.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.62.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).brv();
                    TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bxM());
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL());
                        if (WriteActivity.this.ocO) {
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
    private final LocationModel.a fwG = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.63
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bDm() {
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
    private final CustomMessageListener nou = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fwt.yi(false);
                    WriteActivity.this.fwt.gy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fwt.yi(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener ocB = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.ebD();
            }
        }
    };
    private CustomMessageListener oef = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener ocC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int eau = WriteActivity.this.eau();
            if (eau >= 0 && eau < WriteActivity.this.occ.getText().length()) {
                WriteActivity.this.occ.setSelection(eau);
            }
        }
    };
    private boolean ocD = true;
    private final View.OnFocusChangeListener hlD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.nbu || view == WriteActivity.this.mBack || view == WriteActivity.this.lKK) {
                if (z) {
                    WriteActivity.this.ocD = true;
                    WriteActivity.this.eav();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nbu);
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                } else if (view == WriteActivity.this.nbu) {
                    WriteActivity.this.nbz.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.occ && z) {
                WriteActivity.this.ocD = false;
                WriteActivity.this.eav();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.occ);
                if (WriteActivity.this.fuh != null) {
                    WriteActivity.this.fuh.bAK();
                }
            }
            WriteActivity.this.eaA();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iRZ = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Wb(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean oeg = false;
    private TextWatcher ocE = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String ocI = "";
        private String ocJ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocJ != null ? this.ocJ.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLF();
            WriteActivity.this.eaB();
            EditText eaN = WriteActivity.this.eaN();
            if (editable != null && eaN != null && eaN.getText() != null) {
                if (this.ocI == null || !this.ocI.equals(editable.toString())) {
                    if (WriteActivity.this.ocy != null) {
                        this.ocI = eaN.getText().toString();
                        WriteActivity.this.ocy.b(eaN, true);
                        return;
                    }
                    return;
                }
                eaN.setSelection(eaN.getSelectionEnd());
            }
        }
    };
    private TextWatcher ocF = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String ocJ;
        private String ocK = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocJ != null ? this.ocJ.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLF();
            EditText eaM = WriteActivity.this.eaM();
            if (editable != null && eaM != null && eaM.getText() != null) {
                if (this.ocK == null || !this.ocK.equals(editable.toString())) {
                    if (WriteActivity.this.ocy != null) {
                        this.ocK = eaM.getText().toString();
                        WriteActivity.this.ocy.b(eaM, false);
                    }
                    if (WriteActivity.this.odM) {
                        WriteActivity.this.d(editable);
                        return;
                    }
                    return;
                }
                eaM.setSelection(eaM.getSelectionEnd());
            }
        }
    };
    private int oeh = 0;
    private final a.InterfaceC0868a lQV = new a.InterfaceC0868a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0868a
        public void onRefresh() {
            WriteActivity.this.lcn = null;
            WriteActivity.this.zv(false);
            WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void bCV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.odE.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.ET(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.y(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.nbc.setItemInfo(tbRichTextEvaluateItemInfo);
        this.odE.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bCX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt.dPY()) {
            bCV();
        } else {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPW();
        }
    }

    public void eaW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.ocx != null) {
                this.ocx.dZc();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt != null) {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPW();
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fwt.dQa();
                } else {
                    WriteActivity.this.fwG.bDm();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eau() {
        int selectionEnd = eaM().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) eaM().getText().getSpans(0, eaM().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = eaM().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = eaM().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eav() {
        if (this.fuh != null) {
            if (this.odH != null && this.odH.isVisible()) {
                this.fuh.setBarLauncherEnabled(!this.ocD);
                this.fuh.setDeskLauncherEnabled(!this.ocD);
                this.fuh.setToolEnabled(true, 2);
                this.fuh.setToolEnabled(true, 32);
                this.fuh.setToolEnabled(false, 10);
                this.fuh.setToolEnabled(false, 6);
                this.fuh.setToolEnabled(false, 18);
                this.fuh.sj(5).kw(false);
                if (this.ocx != null) {
                    this.ocx.zl(true);
                }
            } else {
                this.fuh.setBarLauncherEnabled(!this.ocD);
                this.fuh.setDeskLauncherEnabled(!this.ocD);
                this.fuh.setToolEnabled(true, 26);
                this.fuh.setToolEnabled(true, 2);
                this.fuh.setToolEnabled(true, 30);
                this.fuh.sj(5).kw(true);
                if (this.ocx != null) {
                    this.ocx.zl(true);
                }
                ebz();
            }
            if (this.odM && this.oee != null && !this.oee.isEnable()) {
                this.fuh.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.oct) {
            this.nbu.setVisibility(8);
            if (this.nbc.getType() == 5) {
                this.odh.setVisibility(8);
            } else {
                this.odh.setVisibility(0);
            }
            a(this.odk, this.ode);
            a(this.odj, this.odi);
            dLF();
        }
        if (this.ocM) {
            this.ocD = true;
            eav();
            if (this.fuh != null) {
                this.fuh.bAK();
            }
            this.nbu.requestFocus();
            ShowSoftKeyPadDelay(this.nbu);
        }
        if (this.odH != null) {
            this.odH.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.odH != null) {
            this.odH.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.odH != null) {
            this.odH.onStop();
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
                    eaU();
                }
                zw(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nbc.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.nbc.setVideoInfo(null);
            }
            if (this.odH == null) {
                this.odH = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.nbc.getVideoInfo() != null && this.nbc.getVideoInfo().isEditVideoDataLegal()) {
                aC(false, false);
                this.odH.ecz();
                return;
            }
            aC(true, false);
        }
    }

    public void Ff(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aC(boolean z, boolean z2) {
        if (z) {
            this.nbc.setVideoInfo(null);
            this.odH.a(null, z2);
            this.odb.ebM().setVisibility(0);
            zv(false);
        } else {
            this.odH.a(this.nbc.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.odb.ebM().setVisibility(8);
            ebp();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dLF();
        eav();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.nbc.getType() == 0) {
            Nb(this.bHu);
        }
        initUI();
        ebo();
        this.fwt = new LocationModel(getPageContext());
        this.fwt.a(this.fwG);
        registerListener(this.nou);
        registerListener(this.ocB);
        registerListener(this.mBackgroundListener);
        registerListener(this.oef);
        ebK();
        dci();
        ebC();
        if (this.oct) {
            this.odd.setEditorTools(this.fuh);
        } else {
            this.occ.requestFocus();
        }
        dFN();
        eaU();
        ebA();
        this.iRZ.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iRZ);
        eaX();
    }

    private void eaX() {
        Wb(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void dci() {
        this.fuh = new EditorTools(getActivity());
        this.fuh.setBarMaxLauCount(5);
        this.fuh.setMoreButtonAtEnd(true);
        this.fuh.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fuh.setBarLauncherType(1);
        this.fuh.ks(true);
        this.fuh.kt(false);
        switch (this.nbc.getType()) {
            case 4:
            case 5:
                eba();
                break;
            default:
                eaw();
                break;
        }
        this.fuh.build();
        if (this.oca != null) {
            this.oca.addView(this.fuh);
        }
        dbL();
        this.fuh.su();
        com.baidu.tbadk.editortools.h sg = this.fuh.sg(6);
        if (sg != null && !TextUtils.isEmpty(this.fwy)) {
            ((View) sg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fwy);
                }
            });
        }
        if (!this.oct) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fuh.bAK();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            ebb();
            return;
        }
        if (!this.nZg) {
            eay();
        }
        ebD();
    }

    private void eaY() {
        this.odf = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.odh = this.odf.findViewById(R.id.live_post_title_container);
        this.ode = (EditText) this.odf.findViewById(R.id.live_post_content);
        this.odc = (GridView) this.odf.findViewById(R.id.photoLiveGridView);
        this.odi = (EditText) this.odf.findViewById(R.id.live_post_title);
        this.odj = (TextView) this.odf.findViewById(R.id.titleOverPlusNumber);
        this.odk = (TextView) this.odf.findViewById(R.id.contentOverPlusNumber);
        this.odg = this.odf.findViewById(R.id.live_interval_view);
        this.odj.setText(String.valueOf(20));
        this.odk.setText(String.valueOf(233));
        this.odf.setVisibility(0);
        this.odj.setVisibility(0);
        this.odk.setVisibility(0);
        this.odi.setHint(R.string.tips_title_limit_new);
        this.odi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.odn = true;
                    WriteActivity.this.ocD = true;
                    WriteActivity.this.eav();
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                }
            }
        });
        if (this.nbc.getType() == 4) {
            this.ode.setHint(R.string.live_write_input_content_new);
        } else if (this.nbc.getType() == 5) {
            this.ode.setHint(R.string.live_write_input_content_update);
        }
        this.ode.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.odn = false;
                    WriteActivity.this.ocD = false;
                    WriteActivity.this.eav();
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                }
            }
        });
        this.ode.requestFocus();
        this.ode.addTextChangedListener(ayP());
        this.odi.requestFocus();
        this.odi.addTextChangedListener(ayP());
        this.odi.setOnClickListener(this.ocC);
        this.ode.setOnClickListener(this.ocC);
        this.odd = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.odc);
        this.odd.MS(6);
        this.odc.setAdapter((ListAdapter) this.odd);
        View findViewById = this.odf.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dZU() {
                WriteActivity.this.ebx();
            }
        });
        eaZ();
    }

    private void eaZ() {
        if (this.nbc.getType() == 0) {
            if (this.nbc.getTitle() != null) {
                this.odi.setText(this.nbc.getTitle());
                this.odi.setSelection(this.nbc.getTitle().length());
                return;
            }
            return;
        }
        if (this.nbc.getType() == 1 || this.nbc.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.oct) {
            ebv();
        }
        if (this.fuh.bCr()) {
            this.fuh.bAK();
        }
        Nb(0);
    }

    public boolean dYR() {
        return !"1".equals(this.jzq) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr == null || imageSpanArr.length <= 0) {
                if (this.ocy == null || !this.ocy.d(spannable)) {
                    return bf.bua().n(spannable);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void Nb(int i) {
        if (this.writeImagesInfo != null && this.nbc != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.nbc.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.nbc.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dYR());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jzq);
            albumFloatActivityConfig.setProfessionZone(this.nbc.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nVj);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fwy;
            antiData.setIfVoice(this.ocY);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.nbc.getFirstDir(), this.nbc.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void eba() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fuh.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(5);
        if (sj != null) {
            sj.fuU = 2;
        }
        this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fuh.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void eaw() {
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
            this.fuh.b(dVar);
        }
        if (!this.nZg) {
            Boolean ebs = ebs();
            if (!this.ocM && ebs != null && ebs.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dQC() && com.baidu.tieba.tbadkCore.u.d(this.nbc.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.fuU = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.fuh.b(mVar4);
                }
            }
        }
        if (!this.nZg && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.fuU = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar3);
            }
        }
        if (!this.nZg && !com.baidu.tieba.write.c.b.dZv() && !this.odM) {
            this.fuh.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nZg) {
            this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (au.equals(this.jzq, "2")) {
            this.oee = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.odM) {
                this.oee.kx(false);
                this.oee.setEnable(false);
            }
            this.fuh.b(this.oee);
            if (!this.odM) {
                this.fuh.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        if (!this.nZg && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.fuW = true;
            mVar2.fuU = 9;
            mVar2.fuO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar2);
            }
        }
        if (!this.nZg && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.fuW = true;
            mVar.fuU = 10;
            mVar.fuO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar);
            }
        }
        if (!this.nZg && this.och == null) {
            if (this.ocx == null) {
                this.ocx = new com.baidu.tieba.write.editor.b(getActivity(), this.jzq);
                this.ocx.ML(0);
                this.ocx.zk(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ocx.dZa();
                this.ocx.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                eaW();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                this.ocx.dZa();
            }
            this.fuh.b(this.ocx);
        }
        if (!this.odM) {
            this.fuh.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fuh.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(5);
        if (sj != null) {
            sj.fuU = 4;
        }
    }

    private void eax() {
        if (this.ocz != null) {
            this.ocz.hideTip();
        }
    }

    private void ebb() {
        if (this.fuh != null) {
            this.fuh.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fuh != null && WriteActivity.this.fuh.fuk != null) {
                        if (WriteActivity.this.odB == null) {
                            WriteActivity.this.odB = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.odB.showTip(WriteActivity.this.fuh.fuk.sh(2));
                    }
                }
            });
        }
    }

    private void ebc() {
        if (this.odB != null) {
            this.odB.hideTip();
        }
    }

    private void eay() {
        if (this.ocz == null) {
            this.ocz = new g(getPageContext());
        }
        this.ocz.d(this.fuh);
    }

    private void dbL() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 9));
                        if (WriteActivity.this.eaL()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u)) {
                            com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                            if (uVar.bxC() == EmotionGroupType.BIG_EMOTION || uVar.bxC() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.zw(true);
                                    WriteActivity.this.dLF();
                                }
                            } else if (WriteActivity.this.eaL()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.eaO();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dpY();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.ebz();
                        WriteActivity.this.dLF();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Nc(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.och == null) {
                            WriteActivity.this.bDa();
                            return;
                        }
                        switch (WriteActivity.this.fwz) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bCX();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bCV();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fwt != null) {
                            WriteActivity.this.fwt.yi(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.lcn = null;
                        } else {
                            WriteActivity.this.lcn = (String) aVar.data;
                        }
                        WriteActivity.this.zv(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dY("fid", WriteActivity.this.nbc != null ? WriteActivity.this.nbc.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.nbc == null || (videoInfo = WriteActivity.this.nbc.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fuh.bCr()) {
                                        WriteActivity.this.fuh.bAK();
                                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.nbc.setVideoInfo(null);
                        WriteActivity.this.dLF();
                        if (WriteActivity.this.occ != null) {
                            WriteActivity.this.occ.requestFocus();
                        }
                        WriteActivity.this.fuh.bAK();
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.occ);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.obX = true;
                        WriteActivity.this.zt(true);
                        if (!WriteActivity.this.eaN().isFocused() || WriteActivity.this.ocb.getVisibility() != 0) {
                            WriteActivity.this.obW = "from_content";
                        } else {
                            WriteActivity.this.obW = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 8));
                        if (WriteActivity.this.ocb.getVisibility() == 0) {
                            if (WriteActivity.this.ocb.hasFocus()) {
                                WriteActivity.this.occ.requestFocus();
                                WriteActivity.this.occ.setSelection(WriteActivity.this.occ.getText().toString().length());
                            }
                            WriteActivity.this.ocb.setVisibility(8);
                            if (WriteActivity.this.oed != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.oed.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.oed.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.ocR.setVisibility(8);
                            WriteActivity.this.fuh.sg(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.ocb.setVisibility(0);
                            if (WriteActivity.this.oed != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.oed.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.oed.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.ocR.setVisibility(0);
                            WriteActivity.this.ocb.requestFocus();
                            WriteActivity.this.fuh.sg(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dLF();
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
                            TiebaStatic.log(new ar("c12612").al("obj_locate", 10));
                            if (WriteActivity.this.odI != null && WriteActivity.this.odI.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.odI.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new ar("c13800").al("obj_source", 2));
                        }
                        WriteActivity.this.ebd();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.oaD != null) {
                            WriteActivity.this.oaD.Yk();
                        }
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dYv();
                    }
                }
            }
        };
        this.fuh.setActionListener(16, bVar);
        this.fuh.setActionListener(14, bVar);
        this.fuh.setActionListener(24, bVar);
        this.fuh.setActionListener(3, bVar);
        this.fuh.setActionListener(10, bVar);
        this.fuh.setActionListener(11, bVar);
        this.fuh.setActionListener(12, bVar);
        this.fuh.setActionListener(13, bVar);
        this.fuh.setActionListener(15, bVar);
        this.fuh.setActionListener(18, bVar);
        this.fuh.setActionListener(20, bVar);
        this.fuh.setActionListener(25, bVar);
        this.fuh.setActionListener(27, bVar);
        this.fuh.setActionListener(29, bVar);
        this.fuh.setActionListener(43, bVar);
        this.fuh.setActionListener(56, bVar);
        this.fuh.setActionListener(48, bVar);
        this.fuh.setActionListener(46, bVar);
        this.fuh.setActionListener(49, bVar);
        this.fuh.setActionListener(47, bVar);
        this.fuh.setActionListener(55, bVar);
        this.fuh.setActionListener(58, bVar);
        this.fuh.setActionListener(22, bVar);
        this.fuh.setActionListener(21, bVar);
        this.fuh.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebd() {
        if (this.ocV != null) {
            this.ocV.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.oeh;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void ao(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ar("c13800").al("obj_source", 3));
                    }
                };
                this.odI.ap(onClickListener);
                this.odI.setOnItemClickListener(onClickListener);
                this.odI.b(writeVoteData);
                this.odI.zy(true);
                dLF();
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
    public void Nc(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        if (this.fwt.clB()) {
            if (this.fwt.dPY()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPT().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fwt.dPW();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLx() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.ocd != null) {
            this.ocd.cancelLoadData();
        }
        if (this.fwt != null) {
            this.fwt.cancelLoadData();
        }
        if (this.odH != null) {
            this.odH.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.oea);
        eax();
        ebc();
        TiebaPrepareImageService.StopService();
        dLx();
        if (!this.oeg) {
            ebe();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jfV, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.odb != null) {
            this.odb.destroy();
        }
        if (this.odA != null) {
            this.odA.UG();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebe() {
        if (this.nbc != null && this.nbc.getType() == 2 && this.ocW) {
            finish();
        } else if (this.nbc == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.nbc.setTitle(eaN().getText().toString());
            this.nbc.setContent(eaM().getText().toString());
            if (this.odE != null) {
                this.nbc.setEvaluationStar(this.odE.getStarCount());
            }
            int type = this.nbc.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nZg) {
                        y.e(this.nbc.getForumId(), this.nbc);
                    } else {
                        y.d(this.nbc.getForumId(), this.nbc);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    y.d("24591571", this.nbc);
                }
            } else if (type == 1) {
                y.f(this.nbc.getThreadId(), this.nbc);
            } else if (type == 4) {
                y.d(this.nbc.getForumId() + "photolive", this.nbc);
            } else if (type == 5) {
                y.f(this.nbc.getThreadId() + "updatephotolive", this.nbc);
            }
            this.oeg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGZ() {
        if (this.lKK == null || ((!this.lKK.isEnabled() && !this.odM) || ((this.odM && TextUtils.isEmpty(this.occ.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.odH == null || !this.odH.isVisible()))) || this.odK))) {
            cGs();
            ebf();
            setResult(100);
            finish();
            return;
        }
        if (this.jfW == null) {
            this.jfW = new SaveDraftDialogView(this);
            this.jfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cGs();
                            WriteActivity.this.ebf();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.ebe();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jfV.dismiss();
                    }
                }
            });
        }
        if (this.jfV == null) {
            this.jfV = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jfV.setContentView(this.jfW);
        }
        boolean z = (this.odH == null || !this.odH.isVisible() || this.nbc == null || this.nbc.getVideoInfo() == null || this.nbc.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jfW.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jfV.RU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGs() {
        if (this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 11) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nZg) {
                    y.e(this.nbc.getForumId(), (WriteData) null);
                } else {
                    y.d(this.nbc.getForumId(), (WriteData) null);
                }
            }
        } else if (this.nbc.getType() == 1) {
            y.f(this.nbc.getThreadId(), (WriteData) null);
        }
        this.oeg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebf() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAX));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nbA != null && this.nbA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbA, getPageContext().getPageActivity());
                return true;
            } else if (this.fuh.bCr()) {
                this.fuh.bAK();
                return true;
            } else {
                dLx();
                cGZ();
                return true;
            }
        }
        if (i == 67 && (text = eaM().getText()) != null) {
            int selectionStart = eaM().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                eaM().onKeyDown(67, this.iEX);
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
        getLayoutMode().onModeChanged(this.kjE);
        getLayoutMode().onModeChanged(this.odr);
        ap.setBackgroundColor(this.kjE, R.color.CAM_X0205);
        if (this.odp != null && (i == 1 || i == 4)) {
            this.odp.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lKK.setTextColor(ap.aS(R.color.CAM_X0302, i));
        eav();
        ap.setBackgroundColor(this.nbv, R.color.CAM_X0204);
        ap.setBackgroundColor(this.odg, R.color.CAM_X0204);
        ap.setBackgroundColor(eaN(), R.color.CAM_X0205);
        this.lJU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.lcn)) {
            ap.setBackgroundColor(eaM(), R.color.CAM_X0205);
        }
        dLF();
        this.fuh.onChangeSkinType(i);
        if (this.ocq != null) {
            this.ocq.bvt();
        }
        if (this.odQ != null) {
            this.odQ.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.odb.oeG.notifyDataSetChanged();
        eaA();
        eaB();
        zv(false);
        if (this.ocy != null) {
            this.ocy.c(eaN(), eaM());
        }
        if (this.odC != null) {
            this.odC.onChangeSkinType();
        }
        if (this.odE != null) {
            this.odE.onChangeSkinType();
        }
        if (this.nZC != null) {
            this.nZC.onChangeSkinType(i);
        }
        if (this.odH != null) {
            this.odH.bvs();
        }
        if (this.odI != null) {
            this.odI.onChangeSkinType(i);
        }
        if (this.odV != null) {
            this.odV.onChangeSkinType(i);
        }
        if (this.ocP != null) {
            this.ocP.onChangeSkinType(i);
        }
        if (this.odF != null) {
            ap.setViewTextColor(this.odF, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        if (this.nbu.hasFocus()) {
            this.nbu.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nbu.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.occ.hasFocus()) {
            this.occ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.occ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaB() {
        if (this.nbu != null && this.nbu.getText() != null && this.nbu.getText().toString() != null && this.nbu.getPaint() != null) {
            if (this.nbu.getText().toString().length() == 0) {
                this.nbu.getPaint().setFakeBoldText(true);
            } else if (this.nbu.getText().toString().length() > 0) {
                this.nbu.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Editable editable) {
        f(editable);
        e(editable);
    }

    private void e(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.odE.dZZ()) {
            this.lKK.setEnabled(true);
        } else {
            this.lKK.setEnabled(false);
        }
    }

    private void f(Editable editable) {
        if (editable.length() > 500) {
            this.odF.setText((500 - editable.length()) + "/500");
            this.odF.setVisibility(0);
            return;
        }
        this.odF.setVisibility(4);
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.oct = this.nbc.getType() == 4 || 5 == this.nbc.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.ocU = (TextView) findViewById(R.id.btn_image_problem);
        eaE();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKK.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lKK.setLayoutParams(layoutParams);
        this.lKK.setOnFocusChangeListener(this.hlD);
        this.ocs = (ScrollView) findViewById(R.id.write_scrollview);
        this.ocs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.occ != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.occ);
                    }
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ocS = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.ocT = findViewById(R.id.feedback_divider);
        this.kjE = (RelativeLayout) findViewById(R.id.parent);
        this.oca = (LinearLayout) findViewById(R.id.tool_view);
        this.oca.setContentDescription(IStringUtil.TOP_PATH);
        this.ocb = (LinearLayout) findViewById(R.id.title_view);
        this.oed = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.ocR = findViewById(R.id.title_view_divider);
        this.nbv = findViewById(R.id.interval_view);
        this.odw = findViewById(R.id.hot_topic_fourm_view);
        this.odx = findViewById(R.id.hot_topic_divider);
        this.ocv = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.ody = (TextView) findViewById(R.id.change_one_tv);
        dLE();
        if (this.oct) {
            this.ocs.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            eaY();
        } else {
            this.odb = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.odb.zi(false);
            } else {
                this.odb.zi(this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 11);
            }
            this.odH = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.nbc.getVideoInfo() != null && this.nbc.getVideoInfo().isEditVideoDataLegal()) {
                aC(false, false);
                this.odH.ecz();
            } else {
                aC(true, false);
            }
        }
        dLG();
        if (this.ocM || this.obZ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eUK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.nbx = (LinearLayout) findViewById(R.id.post_content_container);
        this.nbx.setDrawingCacheEnabled(false);
        this.nbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.occ.requestFocus();
            }
        });
        this.lJR = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lJS = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lJU = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lJU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dpY();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hlD);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dLx();
                WriteActivity.this.cGZ();
            }
        });
        this.ocU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        eaH();
        u(ebs());
        eaJ();
        eaD();
        ebq();
        eav();
        eaI();
        dLD();
        eaP();
        if (this.nbc.getType() == 4 && this.nbC != null && this.oce != null) {
            this.nbC.setVisibility(8);
            this.oce.setVisibility(8);
        }
        dLF();
        ebm();
        dZB();
        ebg();
        eaC();
        ebh();
        ebi();
        ebr();
        ebj();
        bSH();
    }

    private void ebg() {
        if ("main_tab".equals(this.mFrom)) {
            this.odC = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.odC.setVisibility(0);
        }
    }

    private void eaC() {
        if (!this.odM) {
            this.nZC = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.nZC.setBgColor(R.color.CAM_X0205);
            this.odG = findViewById(R.id.frs_tab__divider);
            this.nZC.setData(this.nVj);
            if (this.nZC.getVisibility() == 0) {
                this.odG.setVisibility(0);
            }
            this.nZC.setActivity(this);
        }
    }

    private void ebh() {
        if (this.odM) {
            this.odF = (TextView) findViewById(R.id.post_content_counter);
            this.odE = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.odE.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void an(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.occ.getText()) || WriteActivity.this.occ.getText().length() < 20 || WriteActivity.this.occ.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lKK.setEnabled(false);
                    } else {
                        WriteActivity.this.lKK.setEnabled(true);
                    }
                }
            });
            this.odE.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lKK.setEnabled(false);
                }
            });
        }
    }

    private void ebi() {
        if (this.odM) {
            this.odE.setVisibility(0);
            if (!this.jgf) {
                if (this.odN) {
                    this.odE.setShowItemInfo(false);
                }
                if (this.odL != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.ET(String.valueOf(this.odL.id));
                    tbRichTextEvaluateItemInfo.setTags(this.odL.tags);
                    tbRichTextEvaluateItemInfo.y(this.odL.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(M(this.odL.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.odL.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.odL.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.odL.name);
                    this.odE.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.odE.setStarCount(this.odO);
                } else if (this.nbc.getItemInfo() != null) {
                    this.odE.setItemInfo(this.nbc.getItemInfo());
                    this.odE.setStarCount(this.nbc.getEvaluationStar());
                }
            }
        }
    }

    private int M(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void ebj() {
        this.odR = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.odS = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.odT = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.odT, R.color.CAM_X0107);
        this.odV = new EBusinessProtocolView(this);
        this.odV.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.odV.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.odV, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.odT.setText(spannableString);
        this.odT.setMovementMethod(LinkMovementMethod.getInstance());
        this.odS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.odW) {
                    WriteActivity.this.odW = false;
                    WriteActivity.this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.odW = true;
                    WriteActivity.this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.odW) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.oS(R.color.CAM_X0105);
                    aVar.Bp("");
                    aVar.Bq(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.oT(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).brv();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.odW = true;
            this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.odW = false;
            this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.odV.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void zr(boolean z) {
                if (z) {
                    if (!WriteActivity.this.odW) {
                        WriteActivity.this.odW = true;
                        WriteActivity.this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.odW) {
                    WriteActivity.this.odW = false;
                    WriteActivity.this.odS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void ebk() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.oeh = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.ocV = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ocV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.ocV.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ocV.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.ocV.setLayoutParams(layoutParams2);
        this.ocV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.ebl();
            }
        });
        this.ocV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dZB() {
        if (this.mName != null && this.nbc != null && this.nbc.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void eaD() {
        String str;
        String str2;
        if (this.nbc != null) {
            switch (this.nbc.getType()) {
                case 0:
                case 9:
                    if (this.ocM || this.obZ) {
                        if (this.ocO) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jzq != null && this.jzq.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nZg) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.jzq != null && this.jzq.equals("2")) {
                        if (this.odM) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.nbc.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.nbc.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.nbc.getForumName() + getResources().getString(R.string.bar));
                        this.nbu.setVisibility(8);
                        String str3 = this.iQP + " " + this.iQN;
                        if (!StringUtils.isNull(str3)) {
                            this.occ.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.nbu.setVisibility(0);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nbu.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.nbc.getFloorNum() + 1)));
                    this.odg.setVisibility(8);
                    return;
                case 7:
                    this.nbu.setVisibility(0);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.nbu.setVisibility(0);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void eaE() {
        if (this.nbc.getType() == 7) {
            this.lKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void eaF() {
        if (this.nbc != null && this.nbc.getType() == 0 && this.nbc.getType() == 9 && !this.ocM && !this.obZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && eaN() != null) {
                eaN().setText(cutStringWithSuffix);
                eaN().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.lJR.setVisibility(0);
            this.lJS.setVoiceModel(voiceModel);
            this.lJS.ccz();
            dLF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpY() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CI(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.lJR.setVisibility(8);
        this.lJS.cPh();
        this.lJS.setVoiceModel(null);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(6);
        if (sj != null && sj.fub != null) {
            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dLF();
    }

    private void eaG() {
        this.gDd = null;
        this.ocn = -1;
        this.ocp = -1;
        ag Ah = af.cEh().Ah(1);
        if (Ah != null) {
            this.gDd = Ah.iXv;
            this.ocn = getIntent().getIntExtra("category_id", -1);
            if (this.gDd != null && !this.gDd.isEmpty() && this.ocn >= 0) {
                this.ocm = new ae();
                this.ocm.iXr = 0;
                this.ocm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.ocp = this.ocm.iXr;
                this.oco = this.ocm.name;
                for (ae aeVar : this.gDd) {
                    if (aeVar.iXr == this.ocn) {
                        this.ocp = aeVar.iXr;
                        this.oco = aeVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void eaH() {
        if (this.gDd != null && !this.gDd.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.ocq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.ocq.setText(this.oco);
            this.ocq.setCategoryContainerData(this.gDd, this.ocm, this.ocp);
            this.ocq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.ocq.setText(bfVar.name);
                        WriteActivity.this.nbc.setCategoryTo(bfVar.iXr);
                        WriteActivity.this.ocp = bfVar.iXr;
                        WriteActivity.this.ocq.dZW();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.ocq.dZV();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaM());
                }
            });
        }
    }

    private void ebm() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ocG = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ocG.setTitle(R.string.no_disturb_start_time);
        this.ocG.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.ocG);
        this.ocG.setButton(-2, getPageContext().getString(R.string.cancel), this.ocG);
        return this.ocG;
    }

    private void eaI() {
        this.oci = (RelativeLayout) findViewById(R.id.addition_container);
        this.ocj = (TextView) findViewById(R.id.addition_create_time);
        this.ock = (TextView) findViewById(R.id.addition_last_time);
        this.ocl = (TextView) findViewById(R.id.addition_last_content);
        if (this.och != null) {
            this.oci.setVisibility(0);
            this.ocj.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.och.getCreateTime() * 1000));
            if (this.och.getAlreadyCount() == 0) {
                this.ock.setVisibility(8);
            } else {
                this.ock.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.och.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.och.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ocl.setText(lastAdditionContent);
            } else {
                this.ocl.setVisibility(8);
            }
            eaM().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.och.getAlreadyCount()), Integer.valueOf(this.och.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.oci.setVisibility(8);
    }

    private void dLD() {
        this.nbC = findViewById(R.id.post_prefix_layout);
        if (this.odA == null) {
            this.odA = new com.baidu.tieba.d.e(getPageContext(), this.nbC);
            this.odA.fO(R.drawable.bg_tip_blue_up_left);
            this.odA.fN(16);
            this.odA.pf(true);
            this.odA.setUseDirectOffset(true);
            this.odA.yt(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.nbz = (TextView) findViewById(R.id.post_prefix);
        this.oce = findViewById(R.id.prefix_divider);
        this.nbB = (ImageView) findViewById(R.id.prefix_icon);
        ebn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebn() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nbC.setVisibility(0);
            this.oce.setVisibility(0);
            this.odA.A(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbd = 0;
            this.nbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dY("fid", WriteActivity.this.nbc.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nbz.setVisibility(0);
                    WriteActivity.this.nbC.setSelected(true);
                    SvgManager.btW().a(WriteActivity.this.nbB, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nbA, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fuh.bAK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nbu);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.occ);
                }
            });
            this.nbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dY("fid", WriteActivity.this.nbc.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nbz.setSelected(true);
                    SvgManager.btW().a(WriteActivity.this.nbB, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nbA, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fuh.bAK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaM());
                }
            });
            this.nbA = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nbA.a(this);
            this.nbA.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.nbA.setOutsideTouchable(true);
            this.nbA.setFocusable(true);
            this.nbA.setOnDismissListener(this);
            this.nbA.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.btW().a(this.nbB, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.nbz).ps(R.color.CAM_X0105).pu(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.ocf.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ocf.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zf(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zf(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nbA.addView(writePrefixItemLayout);
            }
            this.nbA.setCurrentIndex(0);
            this.nbz.setText(prefixs.get(0));
            Na(0);
            return;
        }
        this.nbC.setVisibility(8);
        this.oce.setVisibility(8);
    }

    private void ebo() {
        if (this.ocM && this.nbc != null) {
            this.ocS.setVisibility(0);
            this.ocT.setVisibility(0);
            this.ocd = new FeedBackModel(getPageContext());
            this.ocd.VX(this.nbc.getForumName());
            this.ocd.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.ocS.setVisibility(8);
                        WriteActivity.this.ocT.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.ocS.setVisibility(8);
                        WriteActivity.this.ocT.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.ocS.a(feedBackModel.eag(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void eaJ() {
        this.lKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.odC == null || WriteActivity.this.odD != null) {
                    if (WriteActivity.this.ebH()) {
                        if (!WriteActivity.this.odY || WriteActivity.this.odW) {
                            if (WriteActivity.this.ebJ()) {
                                int ebI = WriteActivity.this.ebI();
                                if (ebI == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (ebI == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.ocy.a(WriteActivity.this.nbu, WriteActivity.this.occ)) {
                                    WriteActivity.this.showToast(WriteActivity.this.ocy.dYq());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaM());
                                WriteActivity.this.fuh.bAK();
                                if (WriteActivity.this.nbc.getType() != 7) {
                                    if (WriteActivity.this.ocM) {
                                        WriteActivity.this.cGv();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.al("obj_type", StringUtils.isNull(WriteActivity.this.nbc.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.eaS();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cGv();
                                }
                                MercatorModel.dQl().startLoad();
                                TiebaStatic.log(new ar("c12262").dY("obj_locate", WriteActivity.this.jzq));
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

    protected void dLE() {
        this.ocQ = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.ocQ.setIsRound(true);
        this.ocQ.setDrawBorder(false);
        this.ocQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String BR = q.BR(currentPortrait);
            this.ocQ.setUrl(BR);
            this.ocQ.startLoad(BR, 12, false);
        }
        if (this.nbc.isUserFeedback()) {
            this.ocQ.setVisibility(0);
        }
        this.nbu = (EditText) findViewById(R.id.post_title);
        this.nbu.setOnClickListener(this.ocC);
        this.nbu.setOnFocusChangeListener(this.hlD);
        if (this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 11 || this.nbc.getType() == 7) {
            if (this.nbc.getTitle() != null) {
                this.nbu.setText(this.nbc.getTitle());
                this.nbu.setSelection(this.nbc.getTitle().length());
            } else if (this.ocO) {
                this.nbu.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.nbc.getType() == 1 || this.nbc.getType() != 2) {
        }
        this.nbu.addTextChangedListener(this.ocE);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.nbu).pu(R.string.F_X02);
        if (!this.nbc.getHaveDraft()) {
            eaF();
            this.odv = true;
        }
        this.ocP = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher ayP() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int oel;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dLF();
                if (WriteActivity.this.oct) {
                    this.oel = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.oel);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.oct || !WriteActivity.this.odn) {
                    if (WriteActivity.this.oct) {
                        if (this.mEditText != WriteActivity.this.ode || this.mTextView != WriteActivity.this.odk) {
                            this.mEditText = WriteActivity.this.ode;
                            this.mTextView = WriteActivity.this.odk;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.odi || this.mTextView != WriteActivity.this.odj) {
                    this.mEditText = WriteActivity.this.odi;
                    this.mTextView = WriteActivity.this.odj;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.oct && this.odn) {
            if (this.odl != null) {
                this.odi.removeTextChangedListener(this.odl);
            }
            this.odl = textWatcher;
        } else if (this.oct) {
            if (this.odm != null) {
                this.ode.removeTextChangedListener(this.odm);
            }
            this.odm = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.ode) {
            return 233L;
        }
        if (editText != this.odi) {
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
        return com.baidu.tieba.write.c.a.v(editText.getText().toString().trim());
    }

    protected void dLG() {
        this.occ = (SpanGroupEditText) findViewById(R.id.post_content);
        this.occ.setDrawingCacheEnabled(false);
        this.occ.setOnClickListener(this.ocC);
        this.occ.setOnSpanGroupChangedListener(new a.InterfaceC0594a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0594a
            public void G(int i, boolean z) {
                WriteActivity.this.Nv();
            }
        });
        this.occ.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.occ.setForumId(com.baidu.adp.lib.f.b.toLong(this.nbc.getForumId(), 0L));
        this.occ.setTransLink(!this.nZg);
        if (this.fwu != null) {
            this.fwu.setSpanGroupManager(this.occ.getSpanGroupManager());
        }
        if (this.nbc != null) {
            this.nbc.setSpanGroupManager(this.occ.getSpanGroupManager());
        }
        if (this.nbc.getContent() != null && this.nbc.getContent().length() > 0) {
            this.occ.setText(TbFaceManager.bDU().aw(getPageContext().getPageActivity(), this.nbc.getContent()));
            if (this.occ.getText() != null) {
                this.occ.setSelection(this.occ.getText().length());
            }
        } else if (this.nbc.getType() == 2) {
            if (this.ocW) {
                if (this.ocX != null && this.ocX.length() > 0) {
                    this.occ.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.ocX}));
                    this.occ.setSelection(this.occ.getText().length());
                }
            } else if (this.nbc.getFloorNum() > 0) {
                this.occ.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.nbc.getFloorNum())));
                this.occ.setSelection(this.occ.getText().length());
            }
        }
        this.occ.setOnFocusChangeListener(this.hlD);
        this.occ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.occ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.occ.addTextChangedListener(this.ocF);
        if (this.nbc.getType() == 0) {
            this.odz = true;
        } else {
            zv(true);
            this.odz = false;
        }
        if (this.odM) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.occ.setHint(spannableString);
        } else if (this.nbc.isUserFeedback()) {
            this.occ.setHint(R.string.write_input_content);
        } else {
            this.occ.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zv(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.oct && !this.nZg && eaM() != null) {
            eaM().setPadding(0, 0, 0, 0);
            eaM().setBackgroundDrawable(null);
            ap.setBackgroundColor(eaM(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.lcn) || this.och != null) {
                return;
            }
            if (this.odH == null || !this.odH.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.lcn, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.odH == null || !WriteActivity.this.odH.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.eaM().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.eaM(), true, WriteActivity.this.lQV);
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

    private void ebp() {
        if (eaM() != null) {
            eaM().setPadding(0, 0, 0, 0);
            eaM().setBackgroundDrawable(null);
            ap.setBackgroundColor(eaM(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaL() {
        int i = 5000;
        if (this.och != null) {
            i = 1000;
        }
        return eaM().getText() != null && eaM().getText().length() >= i;
    }

    private void DQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.obW)) {
                this.obW = "";
                eaM().requestFocus();
                if (eaM().getText() != null && eaM().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaM().getSelectionStart();
                    editable = eaM().getText();
                }
            } else if ("from_title".equals(this.obW)) {
                this.obW = "";
                eaN().requestFocus();
                if (eaN().getText() != null && eaN().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaN().getSelectionStart();
                    editable = eaN().getText();
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
    public void zt(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.nbc != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nbc.getForumId(), 0L), this.nbc.getFirstDir(), this.nbc.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) eaM().getText().getSpans(0, eaM().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ocg == null) {
                this.ocg = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.ocg.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, eaM());
    }

    EditText eaM() {
        return this.oct ? this.ode : this.occ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaN() {
        return this.oct ? this.odi : this.nbu;
    }

    protected void eaO() {
        if (eaM().getSelectionStart() > 0) {
            String substring = eaM().getText().toString().substring(0, eaM().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iEW.matcher(substring);
            if (matcher.find()) {
                eaM().getText().delete(eaM().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), eaM().getSelectionStart());
                return;
            }
            eaM().onKeyDown(67, this.iEX);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.nbc != null) {
            str = this.nbc.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.ocM = true;
        }
    }

    private void ebq() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void ebr() {
        this.odJ = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.odI = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.odJ);
        ao(getIntent());
    }

    private void bSH() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.odQ = new d(getPageContext());
        this.odQ.a(this.odP);
        this.mListView.setAdapter((ListAdapter) this.odQ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.odQ != null && (WriteActivity.this.odQ.getItem(i) instanceof u)) {
                    u uVar = (u) WriteActivity.this.odQ.getItem(i);
                    if (uVar.mType == 1) {
                        if (uVar.eFC == 1) {
                            bf.bua().b(WriteActivity.this.getPageContext(), new String[]{uVar.eFu});
                        } else {
                            bf.bua().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eFu)});
                        }
                    } else if (uVar.mType == 2) {
                        if (!TextUtils.isEmpty(uVar.eFx)) {
                            if (uVar.eFx.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, uVar.eFx));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uVar.eFx));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(uVar.eFy)) {
                                bf.bua().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eFy)});
                            }
                        } else if (!TextUtils.isEmpty(uVar.eFy)) {
                            bf.bua().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eFy)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.sending);
        this.fEW.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fEW.setDialogVisiable(false);
    }

    private Boolean ebs() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.ocY = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.fwy = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.ocY);
    }

    public void dLF() {
        this.odK = false;
        if (this.nbc != null) {
            String str = "";
            String str2 = "";
            if (eaN() != null) {
                str = eaN().getText().toString();
            }
            if (eaM() != null) {
                str2 = eaM().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.nbd == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nbc.setIsNoTitle(true);
                        } else if (this.ocb.getVisibility() == 0) {
                            this.nbc.setIsNoTitle(false);
                            zu(true);
                            return;
                        }
                    } else if (this.ocb.getVisibility() == 0) {
                        this.nbc.setIsNoTitle(false);
                        zu(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nbc.setIsNoTitle(true);
                } else if (this.ocb.getVisibility() == 0) {
                    this.nbc.setIsNoTitle(false);
                    zu(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.oct) {
                    zu(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zu(true);
                }
            }
            if (this.nbc.getType() == 4) {
                zu(m(this.ode) && l(this.odi));
            } else if (this.nbc.getType() == 5) {
                zu(m(this.ode));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zu(true);
            } else if (this.nbc.getVideoInfo() != null) {
                zu(this.nbc.getVideoInfo().isVideoMixFinished());
            } else if (ebF()) {
                zu(true);
                this.odK = true;
            } else {
                zu(false);
            }
        }
    }

    public void zu(boolean z) {
        if (!z || !this.odM || (this.occ != null && TextUtils.isEmpty(this.occ.getText()) && this.occ.getText().length() < 20 && this.occ.getText().length() > 500 && this.odE != null && this.odE.dZZ())) {
            this.lKK.setEnabled(z);
        }
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
        this.fwu = new NewWriteModel(this);
        this.fwu.b(this.fwI);
        registerListener(this.odZ);
        registerListener(this.oea);
        registerListener(this.oeb);
        this.iJM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dLx();
            }
        };
        this.nbc = new WriteData();
        if (bundle != null) {
            this.nbc.setType(bundle.getInt("type", 0));
            this.nbc.setForumId(bundle.getString("forum_id"));
            this.nbc.setForumName(bundle.getString("forum_name"));
            this.nbc.setFirstDir(bundle.getString("forum_first_dir"));
            this.nbc.setSecondDir(bundle.getString("forum_second_dir"));
            this.nbc.setThreadId(bundle.getString("thread_id"));
            this.nbc.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.nbc.setFloorNum(bundle.getInt("floor_num", 0));
            this.ocM = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ocN = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ocO = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ocW = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ocX = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fws = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.och = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.nbc.setIsAddition(this.och != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.ocZ = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.nbc.setTitle(bundle.getString("write_title"));
            this.nbc.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.nbc.setTopicId(this.mTopicId);
            this.jzq = bundle.getString("KEY_CALL_FROM");
            this.bHu = bundle.getInt("album_thread");
            this.nVj = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.nbc.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.nbc.setType(intent.getIntExtra("type", 9));
            this.nbc.setForumId(intent.getStringExtra("forum_id"));
            this.nbc.setForumName(intent.getStringExtra("forum_name"));
            this.nbc.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nbc.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nbc.setThreadId(intent.getStringExtra("thread_id"));
            this.nbc.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.nbc.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.ocM = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ocN = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ocO = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ocW = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ocX = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.och = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nbc.setIsAddition(this.och != null);
            this.nbc.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.ocZ = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.iQO = intent.getStringExtra("more_forum_img");
            this.iQP = intent.getStringExtra("more_forum_title");
            this.iQN = intent.getStringExtra("more_forum_url");
            this.nbc.setTitle(intent.getStringExtra("write_title"));
            this.nbc.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.nbc.setTopicId(this.mTopicId);
            this.jzq = intent.getStringExtra("KEY_CALL_FROM");
            this.bHu = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nVj = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nbc.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.odM = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.odN = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.odO = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra != null && (serializableExtra instanceof SerializableItemInfo)) {
                this.odL = (SerializableItemInfo) serializableExtra;
            }
            this.jgf = getIntent().getBooleanExtra("item_is_school", false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.nbc.mDynamicImageTextData = new ImageTextUploadData();
            this.nZg = true;
        }
        if (this.nbc.getType() == 9) {
            this.nbc.setEntranceType(1);
        } else if (this.nbc.getType() == 10) {
            this.nbc.setEntranceType(2);
            this.nbc.setType(9);
        } else if (this.nbc.getType() == 0) {
            this.nbc.setEntranceType(3);
        }
        this.nbc.setIsUserFeedback(this.ocM);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nbc.getType() == 4 ? 6 : 9);
        this.nbc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 11) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nZg) {
                    y.d(this.nbc.getForumId(), this);
                } else {
                    y.c(this.nbc.getForumId(), this);
                }
            }
        } else if (this.nbc.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                y.c("24591571", this);
            }
        } else if (this.nbc.getType() == 1) {
            y.a(this.nbc.getThreadId(), this);
        } else if (this.nbc.getType() == 4) {
            y.c(this.nbc.getForumId() + "photolive", this);
        } else if (this.nbc.getType() == 5) {
            y.a(this.nbc.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.lcn = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.nbc != null && this.nbc.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nbc.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.obZ = true;
        }
        eaG();
        try {
            this.odo = ebB();
        } catch (Throwable th) {
            this.odo = null;
        }
    }

    private void eaP() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nbu.setText(com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName)));
            this.nbu.setMovementMethod(com.baidu.tieba.view.c.dXR());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName));
            if (Ey != null) {
                this.nbu.setText(Ey);
            }
            this.ocv.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.odY) {
            if (writeData != null) {
                if (this.nbc != null) {
                    boolean z = this.nbc.getVideoInfo() != null && this.nbc.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.nbc.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.nbc.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(eaN().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(eaM().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = au.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bDU().a(getPageContext().getPageActivity(), writeData.getContent(), this.ocA));
                    if (!z || z7) {
                        this.nbc.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.odv || ((this.ocM || this.obZ) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.ocM || this.obZ)) {
                            j(writeData);
                        }
                        if (this.nbc != null && !this.nbc.getHaveDraft()) {
                            eaF();
                        }
                        if (writeData.getItemInfo() != null) {
                            this.nbc.setItemInfo(writeData.getItemInfo());
                            this.nbc.setEvaluationStar(writeData.getEvaluationStar());
                            ebi();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            ebt();
                        }
                        dLF();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.gDd != null) {
                            this.ocp = this.ocm.iXr;
                            this.oco = this.ocm.name;
                            while (true) {
                                if (i == this.gDd.size()) {
                                    break;
                                }
                                ae aeVar = this.gDd.get(i);
                                if (categoryTo != aeVar.iXr) {
                                    i++;
                                } else {
                                    this.ocp = categoryTo;
                                    this.oco = aeVar.name;
                                    this.nbc.setCategoryTo(this.ocp);
                                    break;
                                }
                            }
                            if (this.ocq != null) {
                                this.ocq.setText(this.oco);
                                this.ocq.setCategoryContainerData(this.gDd, this.ocm, this.ocp);
                            }
                        }
                        this.fuh.bAK();
                        return;
                    }
                    return;
                }
                return;
            }
            ebt();
            eaF();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.nbc.setVideoInfo(videoInfo);
            aC(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.nbc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            eaU();
        }
        zw(false);
        aC(true, true);
    }

    private void i(WriteData writeData) {
        String str;
        String Ez;
        if (com.baidu.adp.lib.util.k.isEmpty(this.nbc.getTitle())) {
            this.nbc.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Ez = this.nbc.getTitle();
            } else {
                Ez = com.baidu.tbadk.plugins.b.Ez(str);
            }
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(Ez);
            if (Ey != null) {
                eaN().setText(Ey);
                eaN().setSelection(Ey.length() > Ez.length() ? Ez.length() : Ey.length());
                return;
            }
            return;
        }
        SpannableString Ey2 = com.baidu.tbadk.plugins.b.Ey(this.nbc.getTitle());
        if (Ey2 != null) {
            eaN().setText(Ey2);
            eaN().setSelection(this.nbc.getTitle().length() > Ey2.length() ? Ey2.length() : this.nbc.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.nbc.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bDU().a(getPageContext().getPageActivity(), this.nbc.getContent(), this.ocA);
        InputFilter[] filters = this.occ.getFilters();
        this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        eaM().setText(a2);
        if (eaM() == this.occ && this.occ.getSpanGroupManager() != null) {
            this.occ.bwg();
            this.occ.getSpanGroupManager().bwm();
            this.occ.bwh();
            Nv();
        }
        this.occ.setFilters(filters);
        if (eaM().getText() != null) {
            eaM().setSelection(eaM().getText().length());
        }
        if (this.oct) {
            a(this.odk, this.ode);
        }
    }

    private void ebt() {
        if ((!this.oct || this.odd != null) && this.odc != null) {
            this.odd.b(this.writeImagesInfo);
            ebx();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nbc.getType());
        bundle.putString("forum_id", this.nbc.getForumId());
        bundle.putString("forum_name", this.nbc.getForumName());
        bundle.putString("forum_first_dir", this.nbc.getFirstDir());
        bundle.putString("forum_second_dir", this.nbc.getSecondDir());
        bundle.putString("thread_id", this.nbc.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.nbc.getFloor());
        bundle.putInt("floor_num", this.nbc.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ocW);
        if (this.ocM) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fws);
        if (this.och != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.och));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.ocZ);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzq);
        bundle.putInt("album_thread", this.bHu);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nVj);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = eaM().getEditableText().toString();
        if (obj != null) {
            eaM().setText(TbFaceManager.bDU().a(getPageContext().getPageActivity(), obj, this.ocA));
            eaM().setSelection(eaM().getText().length());
        }
    }

    private String getContent() {
        return (eaM() == null || eaM().getText() == null) ? "" : eaM().getText().toString();
    }

    private String eaR() {
        if (this.nbc == null || eaN() == null || eaN().getVisibility() != 0 || eaN().getText() == null) {
            return "";
        }
        String obj = eaN().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nbd != com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.nbc.getType() != 4 && this.nbz != null && this.nbz.getText() != null) {
            this.nbc.setPostPrefix(this.nbz.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.nbc.getTitle();
        }
        return obj;
    }

    private void VY(String str) {
        if (this.nbc != null && this.ocb != null) {
            if (this.ocb.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.nbc.setIsNoTitle(true);
                    this.nbc.setTitle("");
                    return;
                }
                this.nbc.setIsNoTitle(false);
                this.nbc.setTitle(str);
                return;
            }
            this.nbc.setIsNoTitle(true);
            this.nbc.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGv() {
        dLx();
        this.nbc.setContent(getContent());
        VY(eaR());
        if (this.ocM || this.obZ) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.nbc.getTitle()) || !this.nbc.getTitle().startsWith(string)) {
                VY(string + this.nbc.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.nbc.getContent()) || !this.nbc.getContent().startsWith(str)) {
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
                sb.append(this.nbc.getContent());
                this.nbc.setContent(sb.toString());
            }
        }
        if (this.ocN) {
            this.nbc.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.ocn >= 0) {
            this.nbc.setCategoryFrom(this.ocn);
        }
        if (this.ocp >= 0) {
            this.nbc.setCategoryTo(this.ocp);
        }
        this.nbc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.odI != null) {
            this.nbc.setWriteVoteData(this.odI.getWriteVoteData());
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
            this.nbc.setTakePhotoNum(i);
        }
        this.nbc.setHasLocationData(this.fwt != null && this.fwt.clB());
        if (this.writeImagesInfo != null) {
            this.fwu.yk(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && this.ocu != null && this.ocu.mIsGlobalBlock == 0) {
            this.nbc.setForumId(String.valueOf(this.ocu.mForumId));
            this.nbc.setForumName(this.ocu.mForumName);
        }
        if (this.odE != null && this.odE.getEvaluateItemInfo() != null) {
            this.nbc.setItem_id(this.odE.getEvaluateItemInfo().bIT());
            this.nbc.setComment_head(cGu());
        }
        dZE();
        this.fwu.e(this.nbc);
        this.nbc.setContent(this.nbc.getContent().replaceAll("\u0000\n", ""));
        this.nbc.setContent(this.nbc.getContent().replaceAll("\u0000", ""));
        this.nbc.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.fwu.dcD().setVoice(this.mVoiceModel.getId());
                this.fwu.dcD().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.fwu.dcD().setVoice(null);
                this.fwu.dcD().setVoiceDuringTime(-1);
            }
        } else {
            this.fwu.dcD().setVoice(null);
            this.fwu.dcD().setVoiceDuringTime(-1);
        }
        if (!this.fwu.dQG()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.nbc.mDynamicImageTextData != null) {
            dZD();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iJM);
            this.fwu.dQD();
        }
    }

    private void dZE() {
        if (this.nbc != null && this.nZC != null) {
            this.nbc.setIsForumBusinessAccount(this.nVj == null ? false : this.nVj.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.nZC.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.nbc.setTabId(selectedTabItemData.tabId);
                this.nbc.setTabName(selectedTabItemData.name);
                this.nbc.setIsGeneralTab(selectedTabItemData.isGeneralTab);
            }
        }
    }

    public void dZD() {
        if (this.nbc.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.nbc, new a.InterfaceC0892a() { // from class: com.baidu.tieba.write.write.WriteActivity.50
                @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dZm().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.50.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cGs();
                            y.e(WriteActivity.this.nbc.getForumId(), (WriteData) null);
                            WriteActivity.this.ebf();
                            com.baidu.tieba.write.b.a.dZg();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.h(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.kE(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dZg();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
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
            if (this.och != null) {
                i2 = this.och.getTotalCount();
                i = this.och.getAlreadyCount() + 1;
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
                if (this.nbu == getCurrentFocus()) {
                    eaM().clearFocus();
                    this.nbu.requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.nbu);
                } else {
                    eaM().requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.occ);
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
                            eaM().getText().insert(eaM().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cGs();
                ebf();
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
                                eby();
                            } else {
                                ar(intent);
                            }
                        } else if (intExtra == 1) {
                            as(intent);
                        } else {
                            ap(intent);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        aC(com.baidu.tbadk.core.util.y.getCount(this.writeImagesInfo.getChosedFiles()) > 0, false);
                        if (this.odz) {
                            zv(true);
                            this.odz = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.oct) {
                        F(intent);
                        dLF();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.nbc.setVideoInfo(videoInfo);
                        this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fuh.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dLF();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.obX) {
                                sb2.append(com.baidu.tbadk.plugins.b.fEp);
                                this.obX = false;
                            }
                            sb2.append(stringExtra);
                            DQ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.ocu = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.ocu);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.occ.getSelectionStart();
                    int selectionEnd = this.occ.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.occ.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fuh != null && !this.fuh.bCr()) {
                this.occ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fuh.bAK();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bDd();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    ebw();
                    if (this.odz) {
                        zv(true);
                        this.odz = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.nbu == getCurrentFocus()) {
                        eaM().clearFocus();
                        this.nbu.requestFocus();
                        if (this.fuh != null) {
                            this.fuh.bAK();
                        }
                        ShowSoftKeyPadDelay(this.nbu);
                        return;
                    }
                    eaM().requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.occ);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.ocy.VA(postWriteCallBackData.getErrorString());
                        this.ocy.bn(postWriteCallBackData.getSensitiveWords());
                        this.ocy.b(this.nbu, this.occ);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fws = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fws);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    ebw();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.obW)) {
                        eaN().requestFocus();
                        return;
                    } else if ("from_content".equals(this.obW)) {
                        eaM().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaS() {
        if ("1".equals(this.jzq)) {
            this.nbc.setCanNoForum(true);
            this.nbc.setTransmitForumData("[]");
        } else if ("2".equals(this.jzq)) {
            this.nbc.setCanNoForum(false);
        }
        eaT();
        this.nbc.setPrivacy(this.isPrivacy);
        ebu();
        this.nbc.setToDynamic(this.isToDynamic);
        this.nbc.setCallFrom(this.jzq);
        if (this.nbc.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cGv();
    }

    private void eaT() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void ebu() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void ebv() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void ebw() {
        if (this.oct) {
            this.odd.b(this.writeImagesInfo);
            ebx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebx() {
        this.odd.notifyDataSetChanged();
        this.odc.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.odd.notifyDataSetChanged();
                WriteActivity.this.odc.invalidateViews();
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
        dLF();
    }

    private void ap(Intent intent) {
        if (this.oct) {
            aq(intent);
            ebw();
        } else {
            at(intent);
        }
        dLF();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            ebw();
            zw(true);
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

    private void eby() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.oda.parseJson(stringExtra);
            this.oda.updateQuality();
            if (this.oda.getChosedFiles() != null && this.oda.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.oda.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.oda.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, eaN());
        HidenSoftKeyPad(this.mInputManager, eaM());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.odH != null) {
            this.odH.onPause();
        }
        if (this.fuh.bCr()) {
            this.fuh.bAK();
        }
    }

    private void at(Intent intent) {
        d(intent, true);
    }

    private void E(Intent intent) {
        this.fws = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fws;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fws, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            ebz();
            eaU();
        }
        zw(true);
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
                ebz();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    eaU();
                }
            }
            zw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebz() {
        if (this.fuh.sj(10) != null) {
            this.fuh.setToolEnabled(this.writeImagesInfo == null || com.baidu.tbadk.core.util.y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bDd() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.53
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fws));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void ebA() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.iQO)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.iQO, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.54
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
                            WriteActivity.this.zw(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw(boolean z) {
        String forumId = this.nbc == null ? "" : this.nbc.getForumId();
        if (this.odb != null) {
            this.odb.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cCE() {
        this.iSU = getVoiceManager();
        this.iSU.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iUq) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.nbc.getType() != 7) {
                if (this.och == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                I(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fwz = i;
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eaU() {
        if (!this.oct) {
            if (this.fuh != null) {
                this.fuh.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fuh.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.nbc == null ? "" : this.nbc.getForumId();
            if (this.odb != null) {
                this.odb.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Na(int i) {
        if (i < this.ocf.size()) {
            for (int i2 = 0; i2 < this.ocf.size(); i2++) {
                this.ocf.get(i2).zg(false);
            }
            this.ocf.get(i).zg(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void KA(int i) {
        if (i == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").al("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").al("obj_type", 2));
        }
        this.nbd = i;
        this.nbA.setCurrentIndex(i);
        Na(i);
        this.nbz.setText(this.mPrefixData.getPrefixs().get(i));
        dLF();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nbC.setSelected(false);
        SvgManager.btW().a(this.nbB, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.occ);
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
        if (this.nbc != null) {
            if (this.nbc.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nbc.getType() == 5) {
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
            bCX();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = com.baidu.tbadk.core.util.ae.transformPermissionResult(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fws);
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
        this.bqA = z;
        if (this.odt && System.currentTimeMillis() - this.odu < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.odt = false;
        }
        if (this.ocx != null && !z) {
            this.ocx.cwd();
        }
        if (this.ocz != null && !z) {
            eax();
        }
        if (this.odB != null && !z) {
            ebc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VZ(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.odq != null) {
            Wa(str);
            this.odq.dismiss();
        }
    }

    private void gN(Context context) {
        ods = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void Wa(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.odt = true;
        ebz();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            eaU();
        }
        zw(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5691=4] */
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

    private File ebB() {
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

    private void ebC() {
        if (this.odo != null && this.nbc.getType() == 0 && this.nbc.getType() == 9 && this.nbc.getType() == 11) {
            gN(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.odo != null) {
                        WriteActivity.this.VZ(WriteActivity.this.odo.getAbsolutePath());
                    }
                }
            });
            this.odp = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.odr = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.odo.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.odo.getAbsolutePath());
                Bitmap g = g(this.odo.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.odp.setImageBitmap(g);
                    this.odp.setDrawBorder(true);
                    this.odp.setBorderWidth(2);
                    this.odp.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.odq = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.odq.setCanceledOnTouchOutside(true);
                    this.odq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.odt) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.odu = System.currentTimeMillis();
                            }
                        }
                    });
                    this.odq.setContentView(this.mBubbleView);
                    this.odq.show();
                    Window window = this.odq.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (ods / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bqA && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.obX = false;
            this.obW = "";
            if ("from_content".equals(str)) {
                this.obW = "from_content";
            } else if ("from_title".equals(str)) {
                this.obW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ex(String.valueOf(charSequence.charAt(i)))) {
                zt(false);
            }
        }
    }

    public void dFN() {
        if (this.odM) {
            this.ocb.setVisibility(8);
            if (this.oed != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oed.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.oed.setLayoutParams(layoutParams);
            }
            this.ocR.setVisibility(8);
        } else if (com.baidu.tieba.write.c.b.dZv()) {
            this.nbu.setHint(R.string.title_hint_for_hot);
            this.ocb.setVisibility(0);
            if (this.oed != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oed.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.oed.setLayoutParams(layoutParams2);
            }
            this.ocR.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.ocP);
            this.ocb.requestFocus();
        } else {
            this.ocP.setVisibility(8);
            this.nbu.setHint(this.ocM ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.ocM || !com.baidu.tbadk.core.util.y.isEmpty(this.mList) || (this.nbc != null && !StringUtils.isNull(this.nbc.getTitle()))) {
                this.ocb.setVisibility(0);
                if (this.oed != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oed.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.oed.setLayoutParams(layoutParams3);
                }
                this.ocR.setVisibility(0);
                this.ocb.requestFocus();
                return;
            }
            this.ocb.setVisibility(8);
            if (this.oed != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.oed.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.oed.setLayoutParams(layoutParams4);
            }
            this.ocR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebD() {
        if (this.fuh != null) {
            this.fuh.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nZg && WriteActivity.this.fuh != null && WriteActivity.this.fuh.fuk != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bua().l(clipBoardContent)) {
                            WriteActivity.this.ocx.dys();
                            return;
                        }
                        if (WriteActivity.this.oaD == null) {
                            WriteActivity.this.oaD = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.oec);
                        }
                        WriteActivity.this.oaD.a(WriteActivity.this.fuh.fuk.sh(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jzq;
    }

    public WriteData dcD() {
        return this.nbc;
    }

    public FrsTabInfoData ebE() {
        return this.nVj;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean ebF() {
        return (this.odI == null || this.odJ == null || this.odI.getWriteVoteData() == null || this.odJ.getVisibility() != 0) ? false : true;
    }

    public void dYv() {
        if (this.nbc != null) {
            TiebaStatic.log(new ar("c13897").al("obj_locate", 2).dY("fid", this.nbc.getForumId()).dY("fname", this.nbc.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.oT(2);
            aVar.jm(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.59
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new ar("c13959").al("obj_locate", 2).dY("fid", WriteActivity.this.nbc != null ? WriteActivity.this.nbc.getForumId() : "").dY("fname", WriteActivity.this.nbc != null ? WriteActivity.this.nbc.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.ebG()));
                    }
                }
            });
            aVar.bi(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new ar("c13958").al("obj_locate", 2).dY("fid", this.nbc != null ? this.nbc.getForumId() : "").dY("fname", this.nbc != null ? this.nbc.getForumName() : ""));
            aVar.b(getPageContext()).brv();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + ebG()));
    }

    public void Nv() {
        if (this.odQ != null && this.odQ.eai() == null && this.occ != null && this.occ.getSpanGroupManager() != null) {
            this.odQ.h(this.occ.getSpanGroupManager().bwr());
            this.odQ.refreshData();
        } else if (this.odQ != null && this.odQ.eai() != null) {
            this.odQ.refreshData();
        }
        if (this.odQ != null) {
            gt(this.odQ.eah());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(List<u> list) {
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
            if (!z && this.odR != null) {
                this.odR.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb(String str) {
        this.odU = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.odU.add(com.baidu.tieba.j.a.ed(jSONObject));
                }
                if (this.odU.size() > 0) {
                    this.odY = true;
                    this.occ.m(this.odU, arrayList);
                    ebk();
                    Nv();
                    this.odR.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ebG() {
        if (this.occ == null || this.occ.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.occ.getSpanGroupManager().bws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebH() {
        return this.canGoods || this.occ == null || this.occ.getSpanGroupManager() == null || this.occ.getSpanGroupManager().bws() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ebI() {
        boolean z = this.odQ == null || this.odQ.eaj();
        boolean z2 = (this.nZC == null || this.nZC.getSelectedTabItemData() == null || this.nZC.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebJ() {
        if (this.nVj == null || com.baidu.tbadk.core.util.y.isEmpty(this.nVj.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nVj.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void ebK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.60
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yW(false).Vt(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aF((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cGu() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.odE != null) {
            i = this.odE.getStarCount();
        }
        arrayList.add(new v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
