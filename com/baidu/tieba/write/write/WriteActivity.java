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
    private static int odu = 0;
    private EditorTools fuh;
    private String fws;
    private LocationModel fwt;
    private NewWriteModel fwu;
    List<ae> gDf;
    private String iQP;
    private String iQQ;
    private String iQR;
    private VoiceManager iSW;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private com.baidu.tbadk.core.dialog.i jfX;
    private SaveDraftDialogView jfY;
    private boolean jgh;
    private LinearLayout lJT;
    private PlayVoiceBntNew lJU;
    private ImageView lJW;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nVl;
    private ForumTabSelectedView nZE;
    private TextView nbB;
    private com.baidu.tieba.write.i nbC;
    private ImageView nbD;
    private View nbE;
    private int nbf;
    private FindNewLinkBubbleController oaF;
    private g ocB;
    private com.baidu.tieba.view.b ocI;
    private TitleTipView ocR;
    private View ocT;
    private View ocV;
    private LinearLayout occ;
    private LinearLayout ocd;
    private View ocg;
    private Toast oci;
    private AdditionData ocj;
    private RelativeLayout ock;
    private TextView ocl;
    private TextView ocm;
    private TextView ocn;
    ae oco;
    private int ocp;
    private String ocq;
    private int ocs;
    private PostCategoryView oct;
    private HotTopicBussinessData ocw;
    private TextView ocx;
    private com.baidu.tieba.write.editor.b ocz;
    private TextView odA;
    private com.baidu.tieba.d.e odC;
    private b odD;
    private ForumSelectedView odE;
    private com.baidu.tbadk.data.j odF;
    private WriteEvaluationHeaderView odG;
    private TextView odH;
    private View odI;
    private com.baidu.tieba.write.write.video.a odJ;
    private com.baidu.tieba.write.write.vote.a odK;
    private RelativeLayout odL;
    private boolean odM;
    private SerializableItemInfo odN;
    private boolean odO;
    private boolean odP;
    private int odQ;
    private d odS;
    private LinearLayout odT;
    private ImageView odU;
    private TextView odV;
    private List<com.baidu.tieba.j.a> odW;
    private EBusinessProtocolView odX;
    private i odd;
    private View ody;
    private View odz;
    private WriteImageGridView oef;
    private com.baidu.tbadk.editortools.c.a oeg;
    private int privateThread;
    private String obY = "";
    private boolean obZ = false;
    protected WriteData nbe = null;
    private boolean ocO = false;
    private boolean ocP = false;
    private boolean ocb = false;
    private boolean ocQ = false;
    private InputMethodManager mInputManager = null;
    private EditText nbw = null;
    private HeadImageView ocS = null;
    private View nbx = null;
    private LinearLayout nbz = null;
    private SpanGroupEditText oce = null;
    private FeedBackModel ocf = null;
    private FeedBackTopListView ocU = null;
    private ArrayList<WritePrefixItemLayout> och = new ArrayList<>();
    private String lcp = null;
    private final KeyEvent iEZ = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ocW = null;
    private TextView lKM = null;
    private TextView mName = null;
    private ImageView ocX = null;
    private DialogInterface.OnCancelListener iJO = null;
    private final Handler mHandler = new Handler();
    private boolean ocY = false;
    private String ocZ = null;
    private RelativeLayout kjG = null;
    public boolean oda = true;
    public String fwy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fwz = 0;
    private int odb = 0;
    private WriteImagesInfo odc = new WriteImagesInfo();
    private View mRootView = null;
    private GridView ode = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a odf = null;
    private ScrollView ocu = null;
    private EditText odg = null;
    private View odh = null;
    private View odi = null;
    private View odj = null;
    private EditText odk = null;
    private TextView odl = null;
    private TextView odm = null;
    private TextWatcher odn = null;
    private TextWatcher odo = null;
    private boolean ocv = false;
    private boolean odp = false;
    private com.baidu.tbadk.core.view.a fEW = null;
    private String mFrom = "write";
    private File odq = null;
    private TbImageView odr = null;
    private View mBubbleView = null;
    private Dialog ods = null;
    private LinearLayout odt = null;
    private boolean odv = false;
    private long odw = -1000;
    private boolean odx = false;
    private String jzs = "2";
    private int bHu = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder ocy = new SpannableStringBuilder();
    private boolean odB = false;
    private boolean bqA = false;
    private final c ocA = new c();
    private boolean nZi = false;
    private final d.a odR = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void MY(int i) {
            if (WriteActivity.this.oce != null) {
                WriteActivity.this.oce.rn(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gs(List<u> list) {
            WriteActivity.this.gt(list);
        }
    };
    private boolean odY = false;
    private int odZ = 0;
    private boolean oea = false;
    private final HttpMessageListener oeb = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.lcp)) {
                    WriteActivity.this.lcp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zv(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.lcp)) {
                    WriteActivity.this.lcp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.lcp);
                    WriteActivity.this.zv(true);
                }
            }
        }
    };
    private CustomMessageListener oec = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nbe != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").al("obj_locate", 1).dY("fid", WriteActivity.this.nbe.getForumId()).dY("fname", WriteActivity.this.nbe.getForumName()));
            }
        }
    };
    private final CustomMessageListener oed = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.odE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                WriteActivity.this.odF = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                if (WriteActivity.this.odF != null && !StringUtils.isNull(WriteActivity.this.odF.forumId) && !StringUtils.isNull(WriteActivity.this.odF.forumName)) {
                    if (WriteActivity.this.nbe != null) {
                        WriteActivity.this.nbe.setForumId(WriteActivity.this.odF.forumId);
                        WriteActivity.this.nbe.setForumName(WriteActivity.this.odF.forumName);
                    }
                    WriteActivity.this.odE.setSelectedForum(WriteActivity.this.odF.forumName);
                    WriteActivity.this.nVl = null;
                    if (!com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.odF.tabInfoList)) {
                        WriteActivity.this.nVl = new FrsTabInfoData();
                        WriteActivity.this.nVl.selectedTabId = -1;
                        WriteActivity.this.nVl.tabList = WriteActivity.this.odF.tabInfoList;
                        if (WriteActivity.this.odF.isForumBusinessAccount && WriteActivity.this.nVl.tabList != null) {
                            FrsTabItemData frsTabItemData = new FrsTabItemData();
                            frsTabItemData.tabId = 505;
                            frsTabItemData.name = "官方";
                            WriteActivity.this.nVl.tabList.add(0, frsTabItemData);
                        }
                        WriteActivity.this.nVl.isForumBusinessAccount = WriteActivity.this.odF.isForumBusinessAccount;
                    }
                    WriteActivity.this.nZE.setData(WriteActivity.this.nVl);
                    if (WriteActivity.this.nZE.getVisibility() == 0) {
                        WriteActivity.this.odI.setVisibility(0);
                    }
                    WriteActivity.this.mPrefixData = null;
                    if (WriteActivity.this.odF.fsW != null && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.odF.fsW.getPrefixs())) {
                        WriteActivity.this.mPrefixData = WriteActivity.this.odF.fsW;
                        WriteActivity.this.mPrefixData.getPrefixs().add(WriteActivity.this.getPageContext().getString(R.string.write_no_prefix));
                    }
                    WriteActivity.this.ebo();
                }
            }
        }
    };
    private TbFaceManager.a ocC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
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
    private final AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a oee = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.oaF != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.oaF.Yk();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cCF();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.oei = true;
            if (postWriteCallBackData != null && WriteActivity.this.nbe != null) {
                WriteActivity.this.ocA.bn(null);
                if (z) {
                    WriteActivity.this.kE(z);
                    if (WriteActivity.this.g(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.c.b.f(WriteActivity.this.nbe);
                    WriteActivity.this.cGt();
                    WriteActivity.this.ebg();
                    if ((WriteActivity.this.nbe.getType() == 0 || WriteActivity.this.nbe.getType() == 9 || WriteActivity.this.nbe.getType() == 11) && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dY("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.m(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.nbe.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.nbe.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.nbe.getForumName())) {
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
                    WriteActivity.this.ocA.bn(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.ocA.VA(postWriteCallBackData.getErrorString());
                    WriteActivity.this.ocA.b(WriteActivity.this.nbw, WriteActivity.this.oce);
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
                        if (WriteActivity.this.ocQ) {
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
    private final CustomMessageListener nox = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
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
    private CustomMessageListener ocD = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.ebE();
            }
        }
    };
    private CustomMessageListener oeh = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener ocE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int eav = WriteActivity.this.eav();
            if (eav >= 0 && eav < WriteActivity.this.oce.getText().length()) {
                WriteActivity.this.oce.setSelection(eav);
            }
        }
    };
    private boolean ocF = true;
    private final View.OnFocusChangeListener hlF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.nbw || view == WriteActivity.this.mBack || view == WriteActivity.this.lKM) {
                if (z) {
                    WriteActivity.this.ocF = true;
                    WriteActivity.this.eaw();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nbw);
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                } else if (view == WriteActivity.this.nbw) {
                    WriteActivity.this.nbB.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.oce && z) {
                WriteActivity.this.ocF = false;
                WriteActivity.this.eaw();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.oce);
                if (WriteActivity.this.fuh != null) {
                    WriteActivity.this.fuh.bAK();
                }
            }
            WriteActivity.this.eaB();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iSb = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
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
    private boolean oei = false;
    private TextWatcher ocG = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String ocK = "";
        private String ocL;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocL != null ? this.ocL.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLG();
            WriteActivity.this.eaC();
            EditText eaO = WriteActivity.this.eaO();
            if (editable != null && eaO != null && eaO.getText() != null) {
                if (this.ocK == null || !this.ocK.equals(editable.toString())) {
                    if (WriteActivity.this.ocA != null) {
                        this.ocK = eaO.getText().toString();
                        WriteActivity.this.ocA.b(eaO, true);
                        return;
                    }
                    return;
                }
                eaO.setSelection(eaO.getSelectionEnd());
            }
        }
    };
    private TextWatcher ocH = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String ocL;
        private String ocM = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocL != null ? this.ocL.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLG();
            EditText eaN = WriteActivity.this.eaN();
            if (editable != null && eaN != null && eaN.getText() != null) {
                if (this.ocM == null || !this.ocM.equals(editable.toString())) {
                    if (WriteActivity.this.ocA != null) {
                        this.ocM = eaN.getText().toString();
                        WriteActivity.this.ocA.b(eaN, false);
                    }
                    if (WriteActivity.this.odO) {
                        WriteActivity.this.d(editable);
                        return;
                    }
                    return;
                }
                eaN.setSelection(eaN.getSelectionEnd());
            }
        }
    };
    private int oej = 0;
    private final a.InterfaceC0868a lQX = new a.InterfaceC0868a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0868a
        public void onRefresh() {
            WriteActivity.this.lcp = null;
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
        this.odG.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.ET(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.y(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.nbe.setItemInfo(tbRichTextEvaluateItemInfo);
        this.odG.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bCX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt.dPZ()) {
            bCV();
        } else {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPX();
        }
    }

    public void eaX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.ocz != null) {
                this.ocz.dZd();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt != null) {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPX();
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fwt.dQb();
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
    public int eav() {
        int selectionEnd = eaN().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) eaN().getText().getSpans(0, eaN().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = eaN().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = eaN().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaw() {
        if (this.fuh != null) {
            if (this.odJ != null && this.odJ.isVisible()) {
                this.fuh.setBarLauncherEnabled(!this.ocF);
                this.fuh.setDeskLauncherEnabled(!this.ocF);
                this.fuh.setToolEnabled(true, 2);
                this.fuh.setToolEnabled(true, 32);
                this.fuh.setToolEnabled(false, 10);
                this.fuh.setToolEnabled(false, 6);
                this.fuh.setToolEnabled(false, 18);
                this.fuh.sj(5).kw(false);
                if (this.ocz != null) {
                    this.ocz.zl(true);
                }
            } else {
                this.fuh.setBarLauncherEnabled(!this.ocF);
                this.fuh.setDeskLauncherEnabled(!this.ocF);
                this.fuh.setToolEnabled(true, 26);
                this.fuh.setToolEnabled(true, 2);
                this.fuh.setToolEnabled(true, 30);
                this.fuh.sj(5).kw(true);
                if (this.ocz != null) {
                    this.ocz.zl(true);
                }
                ebA();
            }
            if (this.odO && this.oeg != null && !this.oeg.isEnable()) {
                this.fuh.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.ocv) {
            this.nbw.setVisibility(8);
            if (this.nbe.getType() == 5) {
                this.odj.setVisibility(8);
            } else {
                this.odj.setVisibility(0);
            }
            a(this.odm, this.odg);
            a(this.odl, this.odk);
            dLG();
        }
        if (this.ocO) {
            this.ocF = true;
            eaw();
            if (this.fuh != null) {
                this.fuh.bAK();
            }
            this.nbw.requestFocus();
            ShowSoftKeyPadDelay(this.nbw);
        }
        if (this.odJ != null) {
            this.odJ.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.odJ != null) {
            this.odJ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.odJ != null) {
            this.odJ.onStop();
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
                    eaV();
                }
                zw(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nbe.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.nbe.setVideoInfo(null);
            }
            if (this.odJ == null) {
                this.odJ = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.nbe.getVideoInfo() != null && this.nbe.getVideoInfo().isEditVideoDataLegal()) {
                aC(false, false);
                this.odJ.ecA();
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
            this.nbe.setVideoInfo(null);
            this.odJ.a(null, z2);
            this.odd.ebN().setVisibility(0);
            zv(false);
        } else {
            this.odJ.a(this.nbe.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.odd.ebN().setVisibility(8);
            ebq();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dLG();
        eaw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.nbe.getType() == 0) {
            Nb(this.bHu);
        }
        initUI();
        ebp();
        this.fwt = new LocationModel(getPageContext());
        this.fwt.a(this.fwG);
        registerListener(this.nox);
        registerListener(this.ocD);
        registerListener(this.mBackgroundListener);
        registerListener(this.oeh);
        ebL();
        dcj();
        ebD();
        if (this.ocv) {
            this.odf.setEditorTools(this.fuh);
        } else {
            this.oce.requestFocus();
        }
        dFO();
        eaV();
        ebB();
        this.iSb.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iSb);
        eaY();
    }

    private void eaY() {
        Wb(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void dcj() {
        this.fuh = new EditorTools(getActivity());
        this.fuh.setBarMaxLauCount(5);
        this.fuh.setMoreButtonAtEnd(true);
        this.fuh.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fuh.setBarLauncherType(1);
        this.fuh.ks(true);
        this.fuh.kt(false);
        switch (this.nbe.getType()) {
            case 4:
            case 5:
                ebb();
                break;
            default:
                eax();
                break;
        }
        this.fuh.build();
        if (this.occ != null) {
            this.occ.addView(this.fuh);
        }
        dbM();
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
        if (!this.ocv) {
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
            ebc();
            return;
        }
        if (!this.nZi) {
            eaz();
        }
        ebE();
    }

    private void eaZ() {
        this.odh = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.odj = this.odh.findViewById(R.id.live_post_title_container);
        this.odg = (EditText) this.odh.findViewById(R.id.live_post_content);
        this.ode = (GridView) this.odh.findViewById(R.id.photoLiveGridView);
        this.odk = (EditText) this.odh.findViewById(R.id.live_post_title);
        this.odl = (TextView) this.odh.findViewById(R.id.titleOverPlusNumber);
        this.odm = (TextView) this.odh.findViewById(R.id.contentOverPlusNumber);
        this.odi = this.odh.findViewById(R.id.live_interval_view);
        this.odl.setText(String.valueOf(20));
        this.odm.setText(String.valueOf(233));
        this.odh.setVisibility(0);
        this.odl.setVisibility(0);
        this.odm.setVisibility(0);
        this.odk.setHint(R.string.tips_title_limit_new);
        this.odk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.odp = true;
                    WriteActivity.this.ocF = true;
                    WriteActivity.this.eaw();
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                }
            }
        });
        if (this.nbe.getType() == 4) {
            this.odg.setHint(R.string.live_write_input_content_new);
        } else if (this.nbe.getType() == 5) {
            this.odg.setHint(R.string.live_write_input_content_update);
        }
        this.odg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.odp = false;
                    WriteActivity.this.ocF = false;
                    WriteActivity.this.eaw();
                    if (WriteActivity.this.fuh != null) {
                        WriteActivity.this.fuh.bAK();
                    }
                }
            }
        });
        this.odg.requestFocus();
        this.odg.addTextChangedListener(ayP());
        this.odk.requestFocus();
        this.odk.addTextChangedListener(ayP());
        this.odk.setOnClickListener(this.ocE);
        this.odg.setOnClickListener(this.ocE);
        this.odf = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.ode);
        this.odf.MS(6);
        this.ode.setAdapter((ListAdapter) this.odf);
        View findViewById = this.odh.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dZV() {
                WriteActivity.this.eby();
            }
        });
        eba();
    }

    private void eba() {
        if (this.nbe.getType() == 0) {
            if (this.nbe.getTitle() != null) {
                this.odk.setText(this.nbe.getTitle());
                this.odk.setSelection(this.nbe.getTitle().length());
                return;
            }
            return;
        }
        if (this.nbe.getType() == 1 || this.nbe.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.ocv) {
            ebw();
        }
        if (this.fuh.bCr()) {
            this.fuh.bAK();
        }
        Nb(0);
    }

    public boolean dYS() {
        return !"1".equals(this.jzs) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr == null || imageSpanArr.length <= 0) {
                if (this.ocA == null || !this.ocA.d(spannable)) {
                    return bf.bua().n(spannable);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void Nb(int i) {
        if (this.writeImagesInfo != null && this.nbe != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.nbe.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.nbe.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dYS());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jzs);
            albumFloatActivityConfig.setProfessionZone(this.nbe.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nVl);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fwy;
            antiData.setIfVoice(this.oda);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.nbe.getFirstDir(), this.nbe.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void ebb() {
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

    private void eax() {
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
        if (!this.nZi) {
            Boolean ebt = ebt();
            if (!this.ocO && ebt != null && ebt.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dQD() && com.baidu.tieba.tbadkCore.u.d(this.nbe.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.fuU = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.fuh.b(mVar4);
                }
            }
        }
        if (!this.nZi && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.fuU = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar3);
            }
        }
        if (!this.nZi && !com.baidu.tieba.write.c.b.dZw() && !this.odO) {
            this.fuh.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.nZi) {
            this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (au.equals(this.jzs, "2")) {
            this.oeg = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.odO) {
                this.oeg.kx(false);
                this.oeg.setEnable(false);
            }
            this.fuh.b(this.oeg);
            if (!this.odO) {
                this.fuh.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        if (!this.nZi && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.fuW = true;
            mVar2.fuU = 9;
            mVar2.fuO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar2);
            }
        }
        if (!this.nZi && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.fuW = true;
            mVar.fuU = 10;
            mVar.fuO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fuh.b(mVar);
            }
        }
        if (!this.nZi && this.ocj == null) {
            if (this.ocz == null) {
                this.ocz = new com.baidu.tieba.write.editor.b(getActivity(), this.jzs);
                this.ocz.ML(0);
                this.ocz.zk(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ocz.dZb();
                this.ocz.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                eaX();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                this.ocz.dZb();
            }
            this.fuh.b(this.ocz);
        }
        if (!this.odO) {
            this.fuh.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fuh.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(5);
        if (sj != null) {
            sj.fuU = 4;
        }
    }

    private void eay() {
        if (this.ocB != null) {
            this.ocB.hideTip();
        }
    }

    private void ebc() {
        if (this.fuh != null) {
            this.fuh.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fuh != null && WriteActivity.this.fuh.fuk != null) {
                        if (WriteActivity.this.odD == null) {
                            WriteActivity.this.odD = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.odD.showTip(WriteActivity.this.fuh.fuk.sh(2));
                    }
                }
            });
        }
    }

    private void ebd() {
        if (this.odD != null) {
            this.odD.hideTip();
        }
    }

    private void eaz() {
        if (this.ocB == null) {
            this.ocB = new g(getPageContext());
        }
        this.ocB.d(this.fuh);
    }

    private void dbM() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 9));
                        if (WriteActivity.this.eaM()) {
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
                                    WriteActivity.this.dLG();
                                }
                            } else if (WriteActivity.this.eaM()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.eaP();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dpZ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.ebA();
                        WriteActivity.this.dLG();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Nc(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.ocj == null) {
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
                            WriteActivity.this.lcp = null;
                        } else {
                            WriteActivity.this.lcp = (String) aVar.data;
                        }
                        WriteActivity.this.zv(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dY("fid", WriteActivity.this.nbe != null ? WriteActivity.this.nbe.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.nbe == null || (videoInfo = WriteActivity.this.nbe.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
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
                        WriteActivity.this.nbe.setVideoInfo(null);
                        WriteActivity.this.dLG();
                        if (WriteActivity.this.oce != null) {
                            WriteActivity.this.oce.requestFocus();
                        }
                        WriteActivity.this.fuh.bAK();
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.oce);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.obZ = true;
                        WriteActivity.this.zt(true);
                        if (!WriteActivity.this.eaO().isFocused() || WriteActivity.this.ocd.getVisibility() != 0) {
                            WriteActivity.this.obY = "from_content";
                        } else {
                            WriteActivity.this.obY = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 8));
                        if (WriteActivity.this.ocd.getVisibility() == 0) {
                            if (WriteActivity.this.ocd.hasFocus()) {
                                WriteActivity.this.oce.requestFocus();
                                WriteActivity.this.oce.setSelection(WriteActivity.this.oce.getText().toString().length());
                            }
                            WriteActivity.this.ocd.setVisibility(8);
                            if (WriteActivity.this.oef != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.oef.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.oef.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.ocT.setVisibility(8);
                            WriteActivity.this.fuh.sg(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.ocd.setVisibility(0);
                            if (WriteActivity.this.oef != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.oef.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.oef.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.ocT.setVisibility(0);
                            WriteActivity.this.ocd.requestFocus();
                            WriteActivity.this.fuh.sg(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dLG();
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
                            if (WriteActivity.this.odK != null && WriteActivity.this.odK.getWriteVoteData() != null) {
                                writeVoteData = WriteActivity.this.odK.getWriteVoteData();
                            }
                            WriteActivity.this.a(writeVoteData);
                            TiebaStatic.log(new ar("c13800").al("obj_source", 2));
                        }
                        WriteActivity.this.ebe();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.oaF != null) {
                            WriteActivity.this.oaF.Yk();
                        }
                        TiebaStatic.log(new ar("c12612").al("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dYw();
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
    public void ebe() {
        if (this.ocX != null) {
            this.ocX.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.oej;
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
                this.odK.ap(onClickListener);
                this.odK.setOnItemClickListener(onClickListener);
                this.odK.b(writeVoteData);
                this.odK.zy(true);
                dLG();
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
        if (this.fwt.clC()) {
            if (this.fwt.dPZ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPU().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fwt.dPX();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLy() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.ocf != null) {
            this.ocf.cancelLoadData();
        }
        if (this.fwt != null) {
            this.fwt.cancelLoadData();
        }
        if (this.odJ != null) {
            this.odJ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.oec);
        eay();
        ebd();
        TiebaPrepareImageService.StopService();
        dLy();
        if (!this.oei) {
            ebf();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jfX, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.odd != null) {
            this.odd.destroy();
        }
        if (this.odC != null) {
            this.odC.UG();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebf() {
        if (this.nbe != null && this.nbe.getType() == 2 && this.ocY) {
            finish();
        } else if (this.nbe == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.nbe.setTitle(eaO().getText().toString());
            this.nbe.setContent(eaN().getText().toString());
            if (this.odG != null) {
                this.nbe.setEvaluationStar(this.odG.getStarCount());
            }
            int type = this.nbe.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.nZi) {
                        y.e(this.nbe.getForumId(), this.nbe);
                    } else {
                        y.d(this.nbe.getForumId(), this.nbe);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    y.d("24591571", this.nbe);
                }
            } else if (type == 1) {
                y.f(this.nbe.getThreadId(), this.nbe);
            } else if (type == 4) {
                y.d(this.nbe.getForumId() + "photolive", this.nbe);
            } else if (type == 5) {
                y.f(this.nbe.getThreadId() + "updatephotolive", this.nbe);
            }
            this.oei = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHa() {
        if (this.lKM == null || ((!this.lKM.isEnabled() && !this.odO) || ((this.odO && TextUtils.isEmpty(this.oce.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.odJ == null || !this.odJ.isVisible()))) || this.odM))) {
            cGt();
            ebg();
            setResult(100);
            finish();
            return;
        }
        if (this.jfY == null) {
            this.jfY = new SaveDraftDialogView(this);
            this.jfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cGt();
                            WriteActivity.this.ebg();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.ebf();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jfX.dismiss();
                    }
                }
            });
        }
        if (this.jfX == null) {
            this.jfX = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jfX.setContentView(this.jfY);
        }
        boolean z = (this.odJ == null || !this.odJ.isVisible() || this.nbe == null || this.nbe.getVideoInfo() == null || this.nbe.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jfY.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jfX.RU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGt() {
        if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 11) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nZi) {
                    y.e(this.nbe.getForumId(), (WriteData) null);
                } else {
                    y.d(this.nbe.getForumId(), (WriteData) null);
                }
            }
        } else if (this.nbe.getType() == 1) {
            y.f(this.nbe.getThreadId(), (WriteData) null);
        }
        this.oei = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAZ));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nbC != null && this.nbC.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbC, getPageContext().getPageActivity());
                return true;
            } else if (this.fuh.bCr()) {
                this.fuh.bAK();
                return true;
            } else {
                dLy();
                cHa();
                return true;
            }
        }
        if (i == 67 && (text = eaN().getText()) != null) {
            int selectionStart = eaN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                eaN().onKeyDown(67, this.iEZ);
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
        getLayoutMode().onModeChanged(this.kjG);
        getLayoutMode().onModeChanged(this.odt);
        ap.setBackgroundColor(this.kjG, R.color.CAM_X0205);
        if (this.odr != null && (i == 1 || i == 4)) {
            this.odr.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lKM.setTextColor(ap.aS(R.color.CAM_X0302, i));
        eaw();
        ap.setBackgroundColor(this.nbx, R.color.CAM_X0204);
        ap.setBackgroundColor(this.odi, R.color.CAM_X0204);
        ap.setBackgroundColor(eaO(), R.color.CAM_X0205);
        this.lJW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.lcp)) {
            ap.setBackgroundColor(eaN(), R.color.CAM_X0205);
        }
        dLG();
        this.fuh.onChangeSkinType(i);
        if (this.oct != null) {
            this.oct.bvt();
        }
        if (this.odS != null) {
            this.odS.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.odd.oeI.notifyDataSetChanged();
        eaB();
        eaC();
        zv(false);
        if (this.ocA != null) {
            this.ocA.c(eaO(), eaN());
        }
        if (this.odE != null) {
            this.odE.onChangeSkinType();
        }
        if (this.odG != null) {
            this.odG.onChangeSkinType();
        }
        if (this.nZE != null) {
            this.nZE.onChangeSkinType(i);
        }
        if (this.odJ != null) {
            this.odJ.bvs();
        }
        if (this.odK != null) {
            this.odK.onChangeSkinType(i);
        }
        if (this.odX != null) {
            this.odX.onChangeSkinType(i);
        }
        if (this.ocR != null) {
            this.ocR.onChangeSkinType(i);
        }
        if (this.odH != null) {
            ap.setViewTextColor(this.odH, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaB() {
        if (this.nbw.hasFocus()) {
            this.nbw.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nbw.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.oce.hasFocus()) {
            this.oce.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.oce.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaC() {
        if (this.nbw != null && this.nbw.getText() != null && this.nbw.getText().toString() != null && this.nbw.getPaint() != null) {
            if (this.nbw.getText().toString().length() == 0) {
                this.nbw.getPaint().setFakeBoldText(true);
            } else if (this.nbw.getText().toString().length() > 0) {
                this.nbw.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Editable editable) {
        f(editable);
        e(editable);
    }

    private void e(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.odG.eaa()) {
            this.lKM.setEnabled(true);
        } else {
            this.lKM.setEnabled(false);
        }
    }

    private void f(Editable editable) {
        if (editable.length() > 500) {
            this.odH.setText((500 - editable.length()) + "/500");
            this.odH.setVisibility(0);
            return;
        }
        this.odH.setVisibility(4);
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.ocv = this.nbe.getType() == 4 || 5 == this.nbe.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.ocW = (TextView) findViewById(R.id.btn_image_problem);
        eaF();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKM.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lKM.setLayoutParams(layoutParams);
        this.lKM.setOnFocusChangeListener(this.hlF);
        this.ocu = (ScrollView) findViewById(R.id.write_scrollview);
        this.ocu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.oce != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.oce);
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
        this.ocU = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.ocV = findViewById(R.id.feedback_divider);
        this.kjG = (RelativeLayout) findViewById(R.id.parent);
        this.occ = (LinearLayout) findViewById(R.id.tool_view);
        this.occ.setContentDescription(IStringUtil.TOP_PATH);
        this.ocd = (LinearLayout) findViewById(R.id.title_view);
        this.oef = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.ocT = findViewById(R.id.title_view_divider);
        this.nbx = findViewById(R.id.interval_view);
        this.ody = findViewById(R.id.hot_topic_fourm_view);
        this.odz = findViewById(R.id.hot_topic_divider);
        this.ocx = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.odA = (TextView) findViewById(R.id.change_one_tv);
        dLF();
        if (this.ocv) {
            this.ocu.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            eaZ();
        } else {
            this.odd = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.odd.zi(false);
            } else {
                this.odd.zi(this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 11);
            }
            this.odJ = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.nbe.getVideoInfo() != null && this.nbe.getVideoInfo().isEditVideoDataLegal()) {
                aC(false, false);
                this.odJ.ecA();
            } else {
                aC(true, false);
            }
        }
        dLH();
        if (this.ocO || this.ocb) {
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
        this.nbz = (LinearLayout) findViewById(R.id.post_content_container);
        this.nbz.setDrawingCacheEnabled(false);
        this.nbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.oce.requestFocus();
            }
        });
        this.lJT = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lJU = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lJW = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dpZ();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hlF);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dLy();
                WriteActivity.this.cHa();
            }
        });
        this.ocW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        eaI();
        u(ebt());
        eaK();
        eaE();
        ebr();
        eaw();
        eaJ();
        dLE();
        eaQ();
        if (this.nbe.getType() == 4 && this.nbE != null && this.ocg != null) {
            this.nbE.setVisibility(8);
            this.ocg.setVisibility(8);
        }
        dLG();
        ebn();
        dZC();
        ebh();
        eaD();
        ebi();
        ebj();
        ebs();
        ebk();
        bSI();
    }

    private void ebh() {
        if ("main_tab".equals(this.mFrom)) {
            this.odE = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.odE.setVisibility(0);
        }
    }

    private void eaD() {
        if (!this.odO) {
            this.nZE = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.nZE.setBgColor(R.color.CAM_X0205);
            this.odI = findViewById(R.id.frs_tab__divider);
            this.nZE.setData(this.nVl);
            if (this.nZE.getVisibility() == 0) {
                this.odI.setVisibility(0);
            }
            this.nZE.setActivity(this);
        }
    }

    private void ebi() {
        if (this.odO) {
            this.odH = (TextView) findViewById(R.id.post_content_counter);
            this.odG = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.odG.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void an(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.oce.getText()) || WriteActivity.this.oce.getText().length() < 20 || WriteActivity.this.oce.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lKM.setEnabled(false);
                    } else {
                        WriteActivity.this.lKM.setEnabled(true);
                    }
                }
            });
            this.odG.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lKM.setEnabled(false);
                }
            });
        }
    }

    private void ebj() {
        if (this.odO) {
            this.odG.setVisibility(0);
            if (!this.jgh) {
                if (this.odP) {
                    this.odG.setShowItemInfo(false);
                }
                if (this.odN != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.ET(String.valueOf(this.odN.id));
                    tbRichTextEvaluateItemInfo.setTags(this.odN.tags);
                    tbRichTextEvaluateItemInfo.y(this.odN.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(M(this.odN.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.odN.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.odN.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.odN.name);
                    this.odG.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.odG.setStarCount(this.odQ);
                } else if (this.nbe.getItemInfo() != null) {
                    this.odG.setItemInfo(this.nbe.getItemInfo());
                    this.odG.setStarCount(this.nbe.getEvaluationStar());
                }
            }
        }
    }

    private int M(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void ebk() {
        this.odT = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.odU = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.odV = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.odV, R.color.CAM_X0107);
        this.odX = new EBusinessProtocolView(this);
        this.odX.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.odX.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.odX, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.odV.setText(spannableString);
        this.odV.setMovementMethod(LinkMovementMethod.getInstance());
        this.odU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.odY) {
                    WriteActivity.this.odY = false;
                    WriteActivity.this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.odY = true;
                    WriteActivity.this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.odY) {
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
            this.odY = true;
            this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.odY = false;
            this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.odX.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void zr(boolean z) {
                if (z) {
                    if (!WriteActivity.this.odY) {
                        WriteActivity.this.odY = true;
                        WriteActivity.this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.odY) {
                    WriteActivity.this.odY = false;
                    WriteActivity.this.odU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void ebl() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.oej = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.ocX = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ocX.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.ocX.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ocX.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.ocX.setLayoutParams(layoutParams2);
        this.ocX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.ebm();
            }
        });
        this.ocX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebm() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dZC() {
        if (this.mName != null && this.nbe != null && this.nbe.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void eaE() {
        String str;
        String str2;
        if (this.nbe != null) {
            switch (this.nbe.getType()) {
                case 0:
                case 9:
                    if (this.ocO || this.ocb) {
                        if (this.ocQ) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jzs != null && this.jzs.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.nZi) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.jzs != null && this.jzs.equals("2")) {
                        if (this.odO) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.nbe.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.nbe.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.nbe.getForumName() + getResources().getString(R.string.bar));
                        this.nbw.setVisibility(8);
                        String str3 = this.iQR + " " + this.iQP;
                        if (!StringUtils.isNull(str3)) {
                            this.oce.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.nbw.setVisibility(0);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nbw.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.nbe.getFloorNum() + 1)));
                    this.odi.setVisibility(8);
                    return;
                case 7:
                    this.nbw.setVisibility(0);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.nbw.setVisibility(0);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void eaF() {
        if (this.nbe.getType() == 7) {
            this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void eaG() {
        if (this.nbe != null && this.nbe.getType() == 0 && this.nbe.getType() == 9 && !this.ocO && !this.ocb && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && eaO() != null) {
                eaO().setText(cutStringWithSuffix);
                eaO().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.lJT.setVisibility(0);
            this.lJU.setVoiceModel(voiceModel);
            this.lJU.ccA();
            dLG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpZ() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CI(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.lJT.setVisibility(8);
        this.lJU.cPi();
        this.lJU.setVoiceModel(null);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(6);
        if (sj != null && sj.fub != null) {
            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dLG();
    }

    private void eaH() {
        this.gDf = null;
        this.ocp = -1;
        this.ocs = -1;
        ag Ah = af.cEi().Ah(1);
        if (Ah != null) {
            this.gDf = Ah.iXx;
            this.ocp = getIntent().getIntExtra("category_id", -1);
            if (this.gDf != null && !this.gDf.isEmpty() && this.ocp >= 0) {
                this.oco = new ae();
                this.oco.iXt = 0;
                this.oco.name = getPageContext().getResources().getString(R.string.category_auto);
                this.ocs = this.oco.iXt;
                this.ocq = this.oco.name;
                for (ae aeVar : this.gDf) {
                    if (aeVar.iXt == this.ocp) {
                        this.ocs = aeVar.iXt;
                        this.ocq = aeVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void eaI() {
        if (this.gDf != null && !this.gDf.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.oct = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.oct.setText(this.ocq);
            this.oct.setCategoryContainerData(this.gDf, this.oco, this.ocs);
            this.oct.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.oct.setText(bfVar.name);
                        WriteActivity.this.nbe.setCategoryTo(bfVar.iXt);
                        WriteActivity.this.ocs = bfVar.iXt;
                        WriteActivity.this.oct.dZX();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.oct.dZW();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                }
            });
        }
    }

    private void ebn() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ocI = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ocI.setTitle(R.string.no_disturb_start_time);
        this.ocI.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.ocI);
        this.ocI.setButton(-2, getPageContext().getString(R.string.cancel), this.ocI);
        return this.ocI;
    }

    private void eaJ() {
        this.ock = (RelativeLayout) findViewById(R.id.addition_container);
        this.ocl = (TextView) findViewById(R.id.addition_create_time);
        this.ocm = (TextView) findViewById(R.id.addition_last_time);
        this.ocn = (TextView) findViewById(R.id.addition_last_content);
        if (this.ocj != null) {
            this.ock.setVisibility(0);
            this.ocl.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.ocj.getCreateTime() * 1000));
            if (this.ocj.getAlreadyCount() == 0) {
                this.ocm.setVisibility(8);
            } else {
                this.ocm.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.ocj.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ocj.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ocn.setText(lastAdditionContent);
            } else {
                this.ocn.setVisibility(8);
            }
            eaN().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.ocj.getAlreadyCount()), Integer.valueOf(this.ocj.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.ock.setVisibility(8);
    }

    private void dLE() {
        this.nbE = findViewById(R.id.post_prefix_layout);
        if (this.odC == null) {
            this.odC = new com.baidu.tieba.d.e(getPageContext(), this.nbE);
            this.odC.fO(R.drawable.bg_tip_blue_up_left);
            this.odC.fN(16);
            this.odC.pf(true);
            this.odC.setUseDirectOffset(true);
            this.odC.yt(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.nbB = (TextView) findViewById(R.id.post_prefix);
        this.ocg = findViewById(R.id.prefix_divider);
        this.nbD = (ImageView) findViewById(R.id.prefix_icon);
        ebo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebo() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nbE.setVisibility(0);
            this.ocg.setVisibility(0);
            this.odC.A(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbf = 0;
            this.nbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dY("fid", WriteActivity.this.nbe.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nbB.setVisibility(0);
                    WriteActivity.this.nbE.setSelected(true);
                    SvgManager.btW().a(WriteActivity.this.nbD, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nbC, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fuh.bAK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nbw);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.oce);
                }
            });
            this.nbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dY("fid", WriteActivity.this.nbe.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nbB.setSelected(true);
                    SvgManager.btW().a(WriteActivity.this.nbD, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nbC, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fuh.bAK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                }
            });
            this.nbC = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nbC.a(this);
            this.nbC.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.nbC.setOutsideTouchable(true);
            this.nbC.setFocusable(true);
            this.nbC.setOnDismissListener(this);
            this.nbC.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.btW().a(this.nbD, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.nbB).ps(R.color.CAM_X0105).pu(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.och.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.och.add(writePrefixItemLayout);
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
                this.nbC.addView(writePrefixItemLayout);
            }
            this.nbC.setCurrentIndex(0);
            this.nbB.setText(prefixs.get(0));
            Na(0);
            return;
        }
        this.nbE.setVisibility(8);
        this.ocg.setVisibility(8);
    }

    private void ebp() {
        if (this.ocO && this.nbe != null) {
            this.ocU.setVisibility(0);
            this.ocV.setVisibility(0);
            this.ocf = new FeedBackModel(getPageContext());
            this.ocf.VX(this.nbe.getForumName());
            this.ocf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.ocU.setVisibility(8);
                        WriteActivity.this.ocV.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.ocU.setVisibility(8);
                        WriteActivity.this.ocV.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.ocU.a(feedBackModel.eah(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void eaK() {
        this.lKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.odE == null || WriteActivity.this.odF != null) {
                    if (WriteActivity.this.ebI()) {
                        if (!WriteActivity.this.oea || WriteActivity.this.odY) {
                            if (WriteActivity.this.ebK()) {
                                int ebJ = WriteActivity.this.ebJ();
                                if (ebJ == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (ebJ == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                                if (WriteActivity.this.ocA.a(WriteActivity.this.nbw, WriteActivity.this.oce)) {
                                    WriteActivity.this.showToast(WriteActivity.this.ocA.dYr());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaO());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.eaN());
                                WriteActivity.this.fuh.bAK();
                                if (WriteActivity.this.nbe.getType() != 7) {
                                    if (WriteActivity.this.ocO) {
                                        WriteActivity.this.cGw();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.al("obj_type", StringUtils.isNull(WriteActivity.this.nbe.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.eaT();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cGw();
                                }
                                MercatorModel.dQm().startLoad();
                                TiebaStatic.log(new ar("c12262").dY("obj_locate", WriteActivity.this.jzs));
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

    protected void dLF() {
        this.ocS = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.ocS.setIsRound(true);
        this.ocS.setDrawBorder(false);
        this.ocS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String BR = q.BR(currentPortrait);
            this.ocS.setUrl(BR);
            this.ocS.startLoad(BR, 12, false);
        }
        if (this.nbe.isUserFeedback()) {
            this.ocS.setVisibility(0);
        }
        this.nbw = (EditText) findViewById(R.id.post_title);
        this.nbw.setOnClickListener(this.ocE);
        this.nbw.setOnFocusChangeListener(this.hlF);
        if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 11 || this.nbe.getType() == 7) {
            if (this.nbe.getTitle() != null) {
                this.nbw.setText(this.nbe.getTitle());
                this.nbw.setSelection(this.nbe.getTitle().length());
            } else if (this.ocQ) {
                this.nbw.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.nbe.getType() == 1 || this.nbe.getType() != 2) {
        }
        this.nbw.addTextChangedListener(this.ocG);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.nbw).pu(R.string.F_X02);
        if (!this.nbe.getHaveDraft()) {
            eaG();
            this.odx = true;
        }
        this.ocR = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher ayP() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int oen;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dLG();
                if (WriteActivity.this.ocv) {
                    this.oen = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.oen);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.ocv || !WriteActivity.this.odp) {
                    if (WriteActivity.this.ocv) {
                        if (this.mEditText != WriteActivity.this.odg || this.mTextView != WriteActivity.this.odm) {
                            this.mEditText = WriteActivity.this.odg;
                            this.mTextView = WriteActivity.this.odm;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.odk || this.mTextView != WriteActivity.this.odl) {
                    this.mEditText = WriteActivity.this.odk;
                    this.mTextView = WriteActivity.this.odl;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.ocv && this.odp) {
            if (this.odn != null) {
                this.odk.removeTextChangedListener(this.odn);
            }
            this.odn = textWatcher;
        } else if (this.ocv) {
            if (this.odo != null) {
                this.odg.removeTextChangedListener(this.odo);
            }
            this.odo = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.odg) {
            return 233L;
        }
        if (editText != this.odk) {
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

    protected void dLH() {
        this.oce = (SpanGroupEditText) findViewById(R.id.post_content);
        this.oce.setDrawingCacheEnabled(false);
        this.oce.setOnClickListener(this.ocE);
        this.oce.setOnSpanGroupChangedListener(new a.InterfaceC0594a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0594a
            public void G(int i, boolean z) {
                WriteActivity.this.Nv();
            }
        });
        this.oce.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.oce.setForumId(com.baidu.adp.lib.f.b.toLong(this.nbe.getForumId(), 0L));
        this.oce.setTransLink(!this.nZi);
        if (this.fwu != null) {
            this.fwu.setSpanGroupManager(this.oce.getSpanGroupManager());
        }
        if (this.nbe != null) {
            this.nbe.setSpanGroupManager(this.oce.getSpanGroupManager());
        }
        if (this.nbe.getContent() != null && this.nbe.getContent().length() > 0) {
            this.oce.setText(TbFaceManager.bDU().aw(getPageContext().getPageActivity(), this.nbe.getContent()));
            if (this.oce.getText() != null) {
                this.oce.setSelection(this.oce.getText().length());
            }
        } else if (this.nbe.getType() == 2) {
            if (this.ocY) {
                if (this.ocZ != null && this.ocZ.length() > 0) {
                    this.oce.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.ocZ}));
                    this.oce.setSelection(this.oce.getText().length());
                }
            } else if (this.nbe.getFloorNum() > 0) {
                this.oce.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.nbe.getFloorNum())));
                this.oce.setSelection(this.oce.getText().length());
            }
        }
        this.oce.setOnFocusChangeListener(this.hlF);
        this.oce.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.oce.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.oce.addTextChangedListener(this.ocH);
        if (this.nbe.getType() == 0) {
            this.odB = true;
        } else {
            zv(true);
            this.odB = false;
        }
        if (this.odO) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.oce.setHint(spannableString);
        } else if (this.nbe.isUserFeedback()) {
            this.oce.setHint(R.string.write_input_content);
        } else {
            this.oce.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zv(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.ocv && !this.nZi && eaN() != null) {
            eaN().setPadding(0, 0, 0, 0);
            eaN().setBackgroundDrawable(null);
            ap.setBackgroundColor(eaN(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.lcp) || this.ocj != null) {
                return;
            }
            if (this.odJ == null || !this.odJ.isVisible()) {
                com.baidu.adp.lib.e.c.mS().a(this.lcp, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.odJ == null || !WriteActivity.this.odJ.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.eaN().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.eaN(), true, WriteActivity.this.lQX);
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

    private void ebq() {
        if (eaN() != null) {
            eaN().setPadding(0, 0, 0, 0);
            eaN().setBackgroundDrawable(null);
            ap.setBackgroundColor(eaN(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaM() {
        int i = 5000;
        if (this.ocj != null) {
            i = 1000;
        }
        return eaN().getText() != null && eaN().getText().length() >= i;
    }

    private void DQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.obY)) {
                this.obY = "";
                eaN().requestFocus();
                if (eaN().getText() != null && eaN().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaN().getSelectionStart();
                    editable = eaN().getText();
                }
            } else if ("from_title".equals(this.obY)) {
                this.obY = "";
                eaO().requestFocus();
                if (eaO().getText() != null && eaO().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaO().getSelectionStart();
                    editable = eaO().getText();
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
            if (this.nbe != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nbe.getForumId(), 0L), this.nbe.getFirstDir(), this.nbe.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) eaN().getText().getSpans(0, eaN().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.oci == null) {
                this.oci = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.oci.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, eaN());
    }

    EditText eaN() {
        return this.ocv ? this.odg : this.oce;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaO() {
        return this.ocv ? this.odk : this.nbw;
    }

    protected void eaP() {
        if (eaN().getSelectionStart() > 0) {
            String substring = eaN().getText().toString().substring(0, eaN().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iEY.matcher(substring);
            if (matcher.find()) {
                eaN().getText().delete(eaN().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), eaN().getSelectionStart());
                return;
            }
            eaN().onKeyDown(67, this.iEZ);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.nbe != null) {
            str = this.nbe.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.ocO = true;
        }
    }

    private void ebr() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void ebs() {
        this.odL = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.odK = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.odL);
        ao(getIntent());
    }

    private void bSI() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.odS = new d(getPageContext());
        this.odS.a(this.odR);
        this.mListView.setAdapter((ListAdapter) this.odS);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.odS != null && (WriteActivity.this.odS.getItem(i) instanceof u)) {
                    u uVar = (u) WriteActivity.this.odS.getItem(i);
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

    private Boolean ebt() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.oda = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.fwy = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.oda);
    }

    public void dLG() {
        this.odM = false;
        if (this.nbe != null) {
            String str = "";
            String str2 = "";
            if (eaO() != null) {
                str = eaO().getText().toString();
            }
            if (eaN() != null) {
                str2 = eaN().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.nbf == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nbe.setIsNoTitle(true);
                        } else if (this.ocd.getVisibility() == 0) {
                            this.nbe.setIsNoTitle(false);
                            zu(true);
                            return;
                        }
                    } else if (this.ocd.getVisibility() == 0) {
                        this.nbe.setIsNoTitle(false);
                        zu(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nbe.setIsNoTitle(true);
                } else if (this.ocd.getVisibility() == 0) {
                    this.nbe.setIsNoTitle(false);
                    zu(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ocv) {
                    zu(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zu(true);
                }
            }
            if (this.nbe.getType() == 4) {
                zu(m(this.odg) && l(this.odk));
            } else if (this.nbe.getType() == 5) {
                zu(m(this.odg));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zu(true);
            } else if (this.nbe.getVideoInfo() != null) {
                zu(this.nbe.getVideoInfo().isVideoMixFinished());
            } else if (ebG()) {
                zu(true);
                this.odM = true;
            } else {
                zu(false);
            }
        }
    }

    public void zu(boolean z) {
        if (!z || !this.odO || (this.oce != null && TextUtils.isEmpty(this.oce.getText()) && this.oce.getText().length() < 20 && this.oce.getText().length() > 500 && this.odG != null && this.odG.eaa())) {
            this.lKM.setEnabled(z);
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
        registerListener(this.oeb);
        registerListener(this.oec);
        registerListener(this.oed);
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dLy();
            }
        };
        this.nbe = new WriteData();
        if (bundle != null) {
            this.nbe.setType(bundle.getInt("type", 0));
            this.nbe.setForumId(bundle.getString("forum_id"));
            this.nbe.setForumName(bundle.getString("forum_name"));
            this.nbe.setFirstDir(bundle.getString("forum_first_dir"));
            this.nbe.setSecondDir(bundle.getString("forum_second_dir"));
            this.nbe.setThreadId(bundle.getString("thread_id"));
            this.nbe.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.nbe.setFloorNum(bundle.getInt("floor_num", 0));
            this.ocO = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ocP = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ocQ = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ocY = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ocZ = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fws = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.ocj = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.nbe.setIsAddition(this.ocj != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.odb = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.nbe.setTitle(bundle.getString("write_title"));
            this.nbe.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.nbe.setTopicId(this.mTopicId);
            this.jzs = bundle.getString("KEY_CALL_FROM");
            this.bHu = bundle.getInt("album_thread");
            this.nVl = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.nbe.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.nbe.setType(intent.getIntExtra("type", 9));
            this.nbe.setForumId(intent.getStringExtra("forum_id"));
            this.nbe.setForumName(intent.getStringExtra("forum_name"));
            this.nbe.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nbe.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nbe.setThreadId(intent.getStringExtra("thread_id"));
            this.nbe.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.nbe.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.ocO = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ocP = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ocQ = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ocY = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ocZ = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.ocj = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nbe.setIsAddition(this.ocj != null);
            this.nbe.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.odb = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.iQQ = intent.getStringExtra("more_forum_img");
            this.iQR = intent.getStringExtra("more_forum_title");
            this.iQP = intent.getStringExtra("more_forum_url");
            this.nbe.setTitle(intent.getStringExtra("write_title"));
            this.nbe.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.nbe.setTopicId(this.mTopicId);
            this.jzs = intent.getStringExtra("KEY_CALL_FROM");
            this.bHu = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nVl = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nbe.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.odO = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.odP = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.odQ = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra != null && (serializableExtra instanceof SerializableItemInfo)) {
                this.odN = (SerializableItemInfo) serializableExtra;
            }
            this.jgh = getIntent().getBooleanExtra("item_is_school", false);
            str = stringExtra;
        }
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.nbe.mDynamicImageTextData = new ImageTextUploadData();
            this.nZi = true;
        }
        if (this.nbe.getType() == 9) {
            this.nbe.setEntranceType(1);
        } else if (this.nbe.getType() == 10) {
            this.nbe.setEntranceType(2);
            this.nbe.setType(9);
        } else if (this.nbe.getType() == 0) {
            this.nbe.setEntranceType(3);
        }
        this.nbe.setIsUserFeedback(this.ocO);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nbe.getType() == 4 ? 6 : 9);
        this.nbe.setWriteImagesInfo(this.writeImagesInfo);
        if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 11) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.nZi) {
                    y.d(this.nbe.getForumId(), this);
                } else {
                    y.c(this.nbe.getForumId(), this);
                }
            }
        } else if (this.nbe.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                y.c("24591571", this);
            }
        } else if (this.nbe.getType() == 1) {
            y.a(this.nbe.getThreadId(), this);
        } else if (this.nbe.getType() == 4) {
            y.c(this.nbe.getForumId() + "photolive", this);
        } else if (this.nbe.getType() == 5) {
            y.a(this.nbe.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.lcp = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.nbe != null && this.nbe.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nbe.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ocb = true;
        }
        eaH();
        try {
            this.odq = ebC();
        } catch (Throwable th) {
            this.odq = null;
        }
    }

    private void eaQ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nbw.setText(com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName)));
            this.nbw.setMovementMethod(com.baidu.tieba.view.c.dXS());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName));
            if (Ey != null) {
                this.nbw.setText(Ey);
            }
            this.ocx.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.oea) {
            if (writeData != null) {
                if (this.nbe != null) {
                    boolean z = this.nbe.getVideoInfo() != null && this.nbe.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.nbe.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.nbe.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(eaO().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(eaN().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = au.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bDU().a(getPageContext().getPageActivity(), writeData.getContent(), this.ocC));
                    if (!z || z7) {
                        this.nbe.setHaveDraft(true);
                        if (!z2 && !z) {
                            h(writeData);
                        }
                        if (!z && (!z3 || this.odx || ((this.ocO || this.ocb) && z5))) {
                            i(writeData);
                        }
                        if (z6 && (!z4 || this.ocO || this.ocb)) {
                            j(writeData);
                        }
                        if (this.nbe != null && !this.nbe.getHaveDraft()) {
                            eaG();
                        }
                        if (writeData.getItemInfo() != null) {
                            this.nbe.setItemInfo(writeData.getItemInfo());
                            this.nbe.setEvaluationStar(writeData.getEvaluationStar());
                            ebj();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            ebu();
                        }
                        dLG();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.gDf != null) {
                            this.ocs = this.oco.iXt;
                            this.ocq = this.oco.name;
                            while (true) {
                                if (i == this.gDf.size()) {
                                    break;
                                }
                                ae aeVar = this.gDf.get(i);
                                if (categoryTo != aeVar.iXt) {
                                    i++;
                                } else {
                                    this.ocs = categoryTo;
                                    this.ocq = aeVar.name;
                                    this.nbe.setCategoryTo(this.ocs);
                                    break;
                                }
                            }
                            if (this.oct != null) {
                                this.oct.setText(this.ocq);
                                this.oct.setCategoryContainerData(this.gDf, this.oco, this.ocs);
                            }
                        }
                        this.fuh.bAK();
                        return;
                    }
                    return;
                }
                return;
            }
            ebu();
            eaG();
        }
    }

    private void h(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.nbe.setVideoInfo(videoInfo);
            aC(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.nbe.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            eaV();
        }
        zw(false);
        aC(true, true);
    }

    private void i(WriteData writeData) {
        String str;
        String Ez;
        if (com.baidu.adp.lib.util.k.isEmpty(this.nbe.getTitle())) {
            this.nbe.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Ez = this.nbe.getTitle();
            } else {
                Ez = com.baidu.tbadk.plugins.b.Ez(str);
            }
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(Ez);
            if (Ey != null) {
                eaO().setText(Ey);
                eaO().setSelection(Ey.length() > Ez.length() ? Ez.length() : Ey.length());
                return;
            }
            return;
        }
        SpannableString Ey2 = com.baidu.tbadk.plugins.b.Ey(this.nbe.getTitle());
        if (Ey2 != null) {
            eaO().setText(Ey2);
            eaO().setSelection(this.nbe.getTitle().length() > Ey2.length() ? Ey2.length() : this.nbe.getTitle().length());
        }
    }

    private void j(WriteData writeData) {
        this.nbe.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bDU().a(getPageContext().getPageActivity(), this.nbe.getContent(), this.ocC);
        InputFilter[] filters = this.oce.getFilters();
        this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        eaN().setText(a2);
        if (eaN() == this.oce && this.oce.getSpanGroupManager() != null) {
            this.oce.bwg();
            this.oce.getSpanGroupManager().bwm();
            this.oce.bwh();
            Nv();
        }
        this.oce.setFilters(filters);
        if (eaN().getText() != null) {
            eaN().setSelection(eaN().getText().length());
        }
        if (this.ocv) {
            a(this.odm, this.odg);
        }
    }

    private void ebu() {
        if ((!this.ocv || this.odf != null) && this.ode != null) {
            this.odf.b(this.writeImagesInfo);
            eby();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nbe.getType());
        bundle.putString("forum_id", this.nbe.getForumId());
        bundle.putString("forum_name", this.nbe.getForumName());
        bundle.putString("forum_first_dir", this.nbe.getFirstDir());
        bundle.putString("forum_second_dir", this.nbe.getSecondDir());
        bundle.putString("thread_id", this.nbe.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.nbe.getFloor());
        bundle.putInt("floor_num", this.nbe.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ocY);
        if (this.ocO) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fws);
        if (this.ocj != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ocj));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.odb);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzs);
        bundle.putInt("album_thread", this.bHu);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nVl);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = eaN().getEditableText().toString();
        if (obj != null) {
            eaN().setText(TbFaceManager.bDU().a(getPageContext().getPageActivity(), obj, this.ocC));
            eaN().setSelection(eaN().getText().length());
        }
    }

    private String getContent() {
        return (eaN() == null || eaN().getText() == null) ? "" : eaN().getText().toString();
    }

    private String eaS() {
        if (this.nbe == null || eaO() == null || eaO().getVisibility() != 0 || eaO().getText() == null) {
            return "";
        }
        String obj = eaO().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nbf != com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.nbe.getType() != 4 && this.nbB != null && this.nbB.getText() != null) {
            this.nbe.setPostPrefix(this.nbB.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.nbe.getTitle();
        }
        return obj;
    }

    private void VY(String str) {
        if (this.nbe != null && this.ocd != null) {
            if (this.ocd.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.nbe.setIsNoTitle(true);
                    this.nbe.setTitle("");
                    return;
                }
                this.nbe.setIsNoTitle(false);
                this.nbe.setTitle(str);
                return;
            }
            this.nbe.setIsNoTitle(true);
            this.nbe.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGw() {
        dLy();
        this.nbe.setContent(getContent());
        VY(eaS());
        if (this.ocO || this.ocb) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.nbe.getTitle()) || !this.nbe.getTitle().startsWith(string)) {
                VY(string + this.nbe.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.nbe.getContent()) || !this.nbe.getContent().startsWith(str)) {
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
                sb.append(this.nbe.getContent());
                this.nbe.setContent(sb.toString());
            }
        }
        if (this.ocP) {
            this.nbe.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.ocp >= 0) {
            this.nbe.setCategoryFrom(this.ocp);
        }
        if (this.ocs >= 0) {
            this.nbe.setCategoryTo(this.ocs);
        }
        this.nbe.setWriteImagesInfo(this.writeImagesInfo);
        if (this.odK != null) {
            this.nbe.setWriteVoteData(this.odK.getWriteVoteData());
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
            this.nbe.setTakePhotoNum(i);
        }
        this.nbe.setHasLocationData(this.fwt != null && this.fwt.clC());
        if (this.writeImagesInfo != null) {
            this.fwu.yk(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && this.ocw != null && this.ocw.mIsGlobalBlock == 0) {
            this.nbe.setForumId(String.valueOf(this.ocw.mForumId));
            this.nbe.setForumName(this.ocw.mForumName);
        }
        if (this.odG != null && this.odG.getEvaluateItemInfo() != null) {
            this.nbe.setItem_id(this.odG.getEvaluateItemInfo().bIT());
            this.nbe.setComment_head(cGv());
        }
        dZF();
        this.fwu.e(this.nbe);
        this.nbe.setContent(this.nbe.getContent().replaceAll("\u0000\n", ""));
        this.nbe.setContent(this.nbe.getContent().replaceAll("\u0000", ""));
        this.nbe.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.fwu.dcE().setVoice(this.mVoiceModel.getId());
                this.fwu.dcE().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.fwu.dcE().setVoice(null);
                this.fwu.dcE().setVoiceDuringTime(-1);
            }
        } else {
            this.fwu.dcE().setVoice(null);
            this.fwu.dcE().setVoiceDuringTime(-1);
        }
        if (!this.fwu.dQH()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.nbe.mDynamicImageTextData != null) {
            dZE();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iJO);
            this.fwu.dQE();
        }
    }

    private void dZF() {
        if (this.nbe != null && this.nZE != null) {
            this.nbe.setIsForumBusinessAccount(this.nVl == null ? false : this.nVl.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.nZE.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.nbe.setTabId(selectedTabItemData.tabId);
                this.nbe.setTabName(selectedTabItemData.name);
                this.nbe.setIsGeneralTab(selectedTabItemData.isGeneralTab);
            }
        }
    }

    public void dZE() {
        if (this.nbe.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.nbe, new a.InterfaceC0892a() { // from class: com.baidu.tieba.write.write.WriteActivity.50
                @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dZn().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.50.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cGt();
                            y.e(WriteActivity.this.nbe.getForumId(), (WriteData) null);
                            WriteActivity.this.ebg();
                            com.baidu.tieba.write.b.a.dZh();
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
                            com.baidu.tieba.write.b.a.dZh();
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
            if (this.ocj != null) {
                i2 = this.ocj.getTotalCount();
                i = this.ocj.getAlreadyCount() + 1;
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
                if (this.nbw == getCurrentFocus()) {
                    eaN().clearFocus();
                    this.nbw.requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.nbw);
                } else {
                    eaN().requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.oce);
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
                            eaN().getText().insert(eaN().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cGt();
                ebg();
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
                                ebz();
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
                        if (this.odB) {
                            zv(true);
                            this.odB = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.ocv) {
                        F(intent);
                        dLG();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.nbe.setVideoInfo(videoInfo);
                        this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fuh.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dLG();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.obZ) {
                                sb2.append(com.baidu.tbadk.plugins.b.fEp);
                                this.obZ = false;
                            }
                            sb2.append(stringExtra);
                            DQ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.ocw = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.ocw);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.oce.getSelectionStart();
                    int selectionEnd = this.oce.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.oce.getText();
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
                this.oce.requestFocus();
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
                    ebx();
                    if (this.odB) {
                        zv(true);
                        this.odB = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.nbw == getCurrentFocus()) {
                        eaN().clearFocus();
                        this.nbw.requestFocus();
                        if (this.fuh != null) {
                            this.fuh.bAK();
                        }
                        ShowSoftKeyPadDelay(this.nbw);
                        return;
                    }
                    eaN().requestFocus();
                    if (this.fuh != null) {
                        this.fuh.bAK();
                    }
                    ShowSoftKeyPadDelay(this.oce);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.ocA.VA(postWriteCallBackData.getErrorString());
                        this.ocA.bn(postWriteCallBackData.getSensitiveWords());
                        this.ocA.b(this.nbw, this.oce);
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
                    ebx();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.obY)) {
                        eaO().requestFocus();
                        return;
                    } else if ("from_content".equals(this.obY)) {
                        eaN().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaT() {
        if ("1".equals(this.jzs)) {
            this.nbe.setCanNoForum(true);
            this.nbe.setTransmitForumData("[]");
        } else if ("2".equals(this.jzs)) {
            this.nbe.setCanNoForum(false);
        }
        eaU();
        this.nbe.setPrivacy(this.isPrivacy);
        ebv();
        this.nbe.setToDynamic(this.isToDynamic);
        this.nbe.setCallFrom(this.jzs);
        if (this.nbe.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cGw();
    }

    private void eaU() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void ebv() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void ebw() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void ebx() {
        if (this.ocv) {
            this.odf.b(this.writeImagesInfo);
            eby();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eby() {
        this.odf.notifyDataSetChanged();
        this.ode.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.odf.notifyDataSetChanged();
                WriteActivity.this.ode.invalidateViews();
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
        dLG();
    }

    private void ap(Intent intent) {
        if (this.ocv) {
            aq(intent);
            ebx();
        } else {
            at(intent);
        }
        dLG();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            ebx();
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

    private void ebz() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.odc.parseJson(stringExtra);
            this.odc.updateQuality();
            if (this.odc.getChosedFiles() != null && this.odc.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.odc.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.odc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, eaO());
        HidenSoftKeyPad(this.mInputManager, eaN());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.odJ != null) {
            this.odJ.onPause();
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
            ebA();
            eaV();
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
                ebA();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    eaV();
                }
            }
            zw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebA() {
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

    private void ebB() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.iQQ)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.iQQ, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.54
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
        String forumId = this.nbe == null ? "" : this.nbe.getForumId();
        if (this.odd != null) {
            this.odd.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cCF() {
        this.iSW = getVoiceManager();
        this.iSW.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iUs) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.nbe.getType() != 7) {
                if (this.ocj == null) {
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

    private void eaV() {
        if (!this.ocv) {
            if (this.fuh != null) {
                this.fuh.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fuh.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.nbe == null ? "" : this.nbe.getForumId();
            if (this.odd != null) {
                this.odd.a(this.writeImagesInfo, this.mFrom, forumId);
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
        if (i < this.och.size()) {
            for (int i2 = 0; i2 < this.och.size(); i2++) {
                this.och.get(i2).zg(false);
            }
            this.och.get(i).zg(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void KA(int i) {
        if (i == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").al("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").al("obj_type", 2));
        }
        this.nbf = i;
        this.nbC.setCurrentIndex(i);
        Na(i);
        this.nbB.setText(this.mPrefixData.getPrefixs().get(i));
        dLG();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbC, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nbE.setSelected(false);
        SvgManager.btW().a(this.nbD, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.oce);
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
        if (this.nbe != null) {
            if (this.nbe.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nbe.getType() == 5) {
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
        if (this.odv && System.currentTimeMillis() - this.odw < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.odv = false;
        }
        if (this.ocz != null && !z) {
            this.ocz.cwe();
        }
        if (this.ocB != null && !z) {
            eay();
        }
        if (this.odD != null && !z) {
            ebd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VZ(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.ods != null) {
            Wa(str);
            this.ods.dismiss();
        }
    }

    private void gN(Context context) {
        odu = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void Wa(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.odv = true;
        ebA();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            eaV();
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

    private File ebC() {
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

    private void ebD() {
        if (this.odq != null && this.nbe.getType() == 0 && this.nbe.getType() == 9 && this.nbe.getType() == 11) {
            gN(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.odq != null) {
                        WriteActivity.this.VZ(WriteActivity.this.odq.getAbsolutePath());
                    }
                }
            });
            this.odr = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.odt = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.odq.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.odq.getAbsolutePath());
                Bitmap g = g(this.odq.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.odr.setImageBitmap(g);
                    this.odr.setDrawBorder(true);
                    this.odr.setBorderWidth(2);
                    this.odr.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.ods = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.ods.setCanceledOnTouchOutside(true);
                    this.ods.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.odv) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.odw = System.currentTimeMillis();
                            }
                        }
                    });
                    this.ods.setContentView(this.mBubbleView);
                    this.ods.show();
                    Window window = this.ods.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (odu / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
            this.obZ = false;
            this.obY = "";
            if ("from_content".equals(str)) {
                this.obY = "from_content";
            } else if ("from_title".equals(str)) {
                this.obY = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ex(String.valueOf(charSequence.charAt(i)))) {
                zt(false);
            }
        }
    }

    public void dFO() {
        if (this.odO) {
            this.ocd.setVisibility(8);
            if (this.oef != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oef.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.oef.setLayoutParams(layoutParams);
            }
            this.ocT.setVisibility(8);
        } else if (com.baidu.tieba.write.c.b.dZw()) {
            this.nbw.setHint(R.string.title_hint_for_hot);
            this.ocd.setVisibility(0);
            if (this.oef != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oef.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.oef.setLayoutParams(layoutParams2);
            }
            this.ocT.setVisibility(0);
            com.baidu.tieba.write.c.b.a(this.ocR);
            this.ocd.requestFocus();
        } else {
            this.ocR.setVisibility(8);
            this.nbw.setHint(this.ocO ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.ocO || !com.baidu.tbadk.core.util.y.isEmpty(this.mList) || (this.nbe != null && !StringUtils.isNull(this.nbe.getTitle()))) {
                this.ocd.setVisibility(0);
                if (this.oef != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oef.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.oef.setLayoutParams(layoutParams3);
                }
                this.ocT.setVisibility(0);
                this.ocd.requestFocus();
                return;
            }
            this.ocd.setVisibility(8);
            if (this.oef != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.oef.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.oef.setLayoutParams(layoutParams4);
            }
            this.ocT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebE() {
        if (this.fuh != null) {
            this.fuh.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.nZi && WriteActivity.this.fuh != null && WriteActivity.this.fuh.fuk != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bua().l(clipBoardContent)) {
                            WriteActivity.this.ocz.dyt();
                            return;
                        }
                        if (WriteActivity.this.oaF == null) {
                            WriteActivity.this.oaF = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.oee);
                        }
                        WriteActivity.this.oaF.a(WriteActivity.this.fuh.fuk.sh(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jzs;
    }

    public WriteData dcE() {
        return this.nbe;
    }

    public FrsTabInfoData ebF() {
        return this.nVl;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean ebG() {
        return (this.odK == null || this.odL == null || this.odK.getWriteVoteData() == null || this.odL.getVisibility() != 0) ? false : true;
    }

    public void dYw() {
        if (this.nbe != null) {
            TiebaStatic.log(new ar("c13897").al("obj_locate", 2).dY("fid", this.nbe.getForumId()).dY("fname", this.nbe.getForumName()));
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
                        TiebaStatic.log(new ar("c13959").al("obj_locate", 2).dY("fid", WriteActivity.this.nbe != null ? WriteActivity.this.nbe.getForumId() : "").dY("fname", WriteActivity.this.nbe != null ? WriteActivity.this.nbe.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.ebH()));
                    }
                }
            });
            aVar.bi(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new ar("c13958").al("obj_locate", 2).dY("fid", this.nbe != null ? this.nbe.getForumId() : "").dY("fname", this.nbe != null ? this.nbe.getForumName() : ""));
            aVar.b(getPageContext()).brv();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + ebH()));
    }

    public void Nv() {
        if (this.odS != null && this.odS.eaj() == null && this.oce != null && this.oce.getSpanGroupManager() != null) {
            this.odS.h(this.oce.getSpanGroupManager().bwr());
            this.odS.refreshData();
        } else if (this.odS != null && this.odS.eaj() != null) {
            this.odS.refreshData();
        }
        if (this.odS != null) {
            gt(this.odS.eai());
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
            if (!z && this.odT != null) {
                this.odT.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb(String str) {
        this.odW = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.odW.add(com.baidu.tieba.j.a.ed(jSONObject));
                }
                if (this.odW.size() > 0) {
                    this.oea = true;
                    this.oce.m(this.odW, arrayList);
                    ebl();
                    Nv();
                    this.odT.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ebH() {
        if (this.oce == null || this.oce.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.oce.getSpanGroupManager().bws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebI() {
        return this.canGoods || this.oce == null || this.oce.getSpanGroupManager() == null || this.oce.getSpanGroupManager().bws() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ebJ() {
        boolean z = this.odS == null || this.odS.eak();
        boolean z2 = (this.nZE == null || this.nZE.getSelectedTabItemData() == null || this.nZE.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebK() {
        if (this.nVl == null || com.baidu.tbadk.core.util.y.isEmpty(this.nVl.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nVl.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void ebL() {
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

    private String cGv() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.odG != null) {
            i = this.odG.getStarCount();
        }
        arrayList.add(new v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
