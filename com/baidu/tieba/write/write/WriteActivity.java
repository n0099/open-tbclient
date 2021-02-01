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
import android.text.Editable;
import android.text.InputFilter;
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
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
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
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.l.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
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
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.r;
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
import com.baidu.tbadk.editortools.m;
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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.write.d;
import com.google.gson.Gson;
import com.kwad.sdk.collector.AppStatusRules;
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
/* loaded from: classes8.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0148a, VoiceManager.c, y.a, i.a {
    private static int okU = 0;
    private EditorTools fBu;
    private String fDF;
    private LocationModel fDG;
    List<ab> gMR;
    private boolean isEvaluate;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private String jeb;
    private String jec;
    private String jed;
    private VoiceManager jgg;
    private boolean jtH;
    private com.baidu.tbadk.core.dialog.i jtx;
    private SaveDraftDialogView jty;
    private PlayVoiceBntNew lTA;
    private ImageView lTC;
    private LinearLayout lTz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int nlL;
    private TextView nmh;
    private com.baidu.tieba.write.i nmi;
    private ImageView nmj;
    private View nmk;
    private FrsTabInfoData oeh;
    private WriteTipBubbleController ois;
    private LinearLayout ojB;
    private LinearLayout ojC;
    private View ojF;
    private Toast ojH;
    private AdditionData ojI;
    private RelativeLayout ojJ;
    private TextView ojK;
    private TextView ojL;
    private TextView ojM;
    ab ojN;
    private String ojP;
    private PostCategoryView ojR;
    private HotTopicBussinessData ojU;
    private TextView ojV;
    private com.baidu.tieba.write.editor.b ojX;
    private g ojZ;
    private com.baidu.tieba.tbadkCore.writeModel.a okA;
    private i okC;
    private com.baidu.tieba.c.e okZ;
    private ForumTabSelectedView oka;
    private com.baidu.tieba.view.b okh;
    private TitleTipView okq;
    private View oks;
    private View oku;
    private WriteImageGridView olE;
    private com.baidu.tbadk.editortools.c.a olF;
    private b ola;
    private ForumSelectedView olb;
    private com.baidu.tbadk.data.j olc;
    private WriteEvaluationHeaderView old;
    private TextView ole;
    private View olf;
    private com.baidu.tieba.write.write.video.a olg;
    private com.baidu.tieba.write.write.vote.a olh;
    private RelativeLayout oli;
    private SerializableItemInfo olj;
    private boolean olk;
    private int oll;
    private Serializable olp;
    private String olq;
    private d ols;
    private LinearLayout olt;
    private ImageView olu;
    private TextView olv;
    private List<com.baidu.tieba.j.a> olw;
    private EBusinessProtocolView olx;
    private int privateThread;
    private String ojx = "";
    private boolean ojy = false;
    protected WriteData nlK = null;
    private boolean okn = false;
    private boolean oko = false;
    private boolean ojA = false;
    private boolean okp = false;
    private InputMethodManager mInputManager = null;
    private EditText nmc = null;
    private HeadImageView okr = null;
    private View nmd = null;
    private LinearLayout nmf = null;
    private SpanGroupEditText ojD = null;
    private FeedBackModel ojE = null;
    private FeedBackTopListView okt = null;
    private ArrayList<WritePrefixItemLayout> ojG = new ArrayList<>();
    private String llq = null;
    private final KeyEvent iSl = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView okv = null;
    private TextView lUq = null;
    private TextView mName = null;
    private ImageView okw = null;
    private final Handler mHandler = new Handler();
    private boolean okx = false;
    private String oky = null;
    private RelativeLayout lxd = null;
    public boolean okz = true;
    public String fDL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fDM = 0;
    private int ojO = -1;
    private int ojQ = -1;
    private WriteImagesInfo okB = new WriteImagesInfo();
    private View mRootView = null;
    private GridView okD = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a okE = null;
    private ScrollView ojS = null;
    private EditText okF = null;
    private View okG = null;
    private View okH = null;
    private View okI = null;
    private EditText okJ = null;
    private TextView okK = null;
    private TextView okL = null;
    private TextWatcher okM = null;
    private TextWatcher okN = null;
    private boolean ojT = false;
    private boolean okO = false;
    private com.baidu.tbadk.core.view.a fMe = null;
    private String mFrom = "write";
    private File okP = null;
    private TbImageView okQ = null;
    private View okR = null;
    private Dialog okS = null;
    private LinearLayout okT = null;
    private boolean okV = false;
    private long okW = -1000;
    private boolean okX = false;
    private String jMP = "2";
    private int bLf = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder ojW = new SpannableStringBuilder();
    private boolean okY = false;
    private boolean brf = false;
    private final c ojY = new c();
    private boolean olm = true;
    private boolean oln = false;
    private String olo = null;
    private final d.a olr = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Lx(int i) {
            if (WriteActivity.this.ojD != null) {
                WriteActivity.this.ojD.pY(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gj(List<v> list) {
            WriteActivity.this.gk(list);
        }
    };
    private boolean oly = false;
    private boolean olz = false;
    private final HttpMessageListener olA = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.llq)) {
                    WriteActivity.this.llq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zK(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.llq)) {
                    WriteActivity.this.llq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.llq);
                    WriteActivity.this.zK(true);
                }
            }
        }
    };
    private CustomMessageListener olB = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nlK != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").ap("obj_locate", 1).dR("fid", WriteActivity.this.nlK.getForumId()).dR("fname", WriteActivity.this.nlK.getForumName()));
            }
        }
    };
    private final CustomMessageListener olC = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (WriteActivity.this.olb != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.forumId) && !StringUtils.isNull(jVar.forumName)) {
                WriteActivity.this.a(jVar);
            }
        }
    };
    private TbFaceManager.a okb = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Di(String str) {
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
    private final AntiHelper.a jhC = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private WriteTipBubbleController.a olD = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (WriteActivity.this.ois != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.ois.Xj();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cCU();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.olH = true;
            if (postWriteCallBackData != null && WriteActivity.this.nlK != null) {
                WriteActivity.this.ojY.bg(null);
                if (z) {
                    WriteActivity.this.kZ(z);
                    if (WriteActivity.this.h(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.b.b.g(WriteActivity.this.nlK);
                    WriteActivity.this.cGO();
                    WriteActivity.this.dPc();
                    if ((WriteActivity.this.nlK.getType() == 0 || WriteActivity.this.nlK.getType() == 9 || WriteActivity.this.nlK.getType() == 11) && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.nlK.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.nlK.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.nlK.getForumName())) {
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
                    WriteActivity.this.ojY.bg(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.ojY.UV(postWriteCallBackData.getErrorString());
                    WriteActivity.this.ojY.b(WriteActivity.this.nmc, WriteActivity.this.ojD);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Au(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Au(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.61.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.61.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ar("c13746").ap("obj_locate", 1).ap("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bqx();
                    TiebaStatic.log(new ar("c13745").ap("obj_locate", 1).ap("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwF());
                    if (com.baidu.tbadk.t.a.Ea(ahVar.bwE())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE());
                        if (WriteActivity.this.okp) {
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
    private final LocationModel.a fDU = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bCh() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                WriteActivity.this.b(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener nzk = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fDG.yC(false);
                    WriteActivity.this.fDG.gA(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fDG.yC(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener okc = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dZl();
            }
        }
    };
    private CustomMessageListener olG = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener okd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dXY = WriteActivity.this.dXY();
            if (dXY >= 0 && dXY < WriteActivity.this.ojD.getText().length()) {
                WriteActivity.this.ojD.setSelection(dXY);
            }
        }
    };
    private boolean oke = true;
    private final View.OnFocusChangeListener hxe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.nmc || view == WriteActivity.this.mBack || view == WriteActivity.this.lUq) {
                if (z) {
                    WriteActivity.this.oke = true;
                    WriteActivity.this.dXZ();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nmc);
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                } else if (view == WriteActivity.this.nmc) {
                    WriteActivity.this.nmh.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.ojD && z) {
                WriteActivity.this.oke = false;
                WriteActivity.this.dXZ();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.ojD);
                if (WriteActivity.this.fBu != null) {
                    WriteActivity.this.fBu.bzD();
                }
            }
            WriteActivity.this.dYe();
        }
    };
    private com.baidu.tbadk.mutiprocess.h jfm = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Vp(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean olH = false;
    private TextWatcher okf = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String okj = "";
        private String okk;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okk != null ? this.okk.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dJR();
            WriteActivity.this.dYf();
            EditText dYr = WriteActivity.this.dYr();
            if (editable != null && dYr != null && dYr.getText() != null) {
                if (this.okj == null || !this.okj.equals(editable.toString())) {
                    if (WriteActivity.this.ojY != null) {
                        this.okj = dYr.getText().toString();
                        WriteActivity.this.ojY.b(dYr, true);
                        return;
                    }
                    return;
                }
                dYr.setSelection(dYr.getSelectionEnd());
            }
        }
    };
    private TextWatcher okg = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String okk;
        private String okl = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okk != null ? this.okk.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dJR();
            EditText dYq = WriteActivity.this.dYq();
            if (editable != null && dYq != null && dYq.getText() != null) {
                if (this.okl == null || !this.okl.equals(editable.toString())) {
                    if (WriteActivity.this.ojY != null) {
                        this.okl = dYq.getText().toString();
                        WriteActivity.this.ojY.b(dYq, false);
                    }
                    if (WriteActivity.this.isEvaluate) {
                        WriteActivity.this.e(editable);
                        return;
                    }
                    return;
                }
                dYq.setSelection(dYq.getSelectionEnd());
            }
        }
    };
    private int olI = 0;
    private final a.InterfaceC0870a maE = new a.InterfaceC0870a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0870a
        public void onRefresh() {
            WriteActivity.this.llq = null;
            WriteActivity.this.zK(false);
            WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };
    private final Runnable olJ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.oln) {
                WriteActivity.this.fDW.callback(false, com.baidu.tieba.tbadkCore.writeModel.c.nAJ, com.baidu.tieba.tbadkCore.writeModel.c.nAK, com.baidu.tieba.tbadkCore.writeModel.c.nAL, com.baidu.tieba.tbadkCore.writeModel.c.antiData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null) {
            this.olc = jVar;
            if (this.nlK != null) {
                this.nlK.setForumId(this.olc.forumId);
                this.nlK.setForumName(this.olc.forumName);
            }
            this.olb.setSelectedForum(this.olc.forumName);
            this.oeh = null;
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.olc.tabInfoList)) {
                this.oeh = new FrsTabInfoData();
                this.oeh.selectedTabId = -1;
                this.oeh.tabList = this.olc.tabInfoList;
                if (this.olc.isForumBusinessAccount && this.oeh.tabList != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    this.oeh.tabList.add(0, frsTabItemData);
                }
                this.oeh.isForumBusinessAccount = this.olc.isForumBusinessAccount;
            }
            this.oka.setData(this.oeh);
            if (this.nlK != null) {
                this.nlK.setFrsTabInfoData(this.oeh);
            }
            if (this.oka.getVisibility() == 0) {
                this.olf.setVisibility(0);
            }
            this.mPrefixData = null;
            if (this.olc.fAj != null && !com.baidu.tbadk.core.util.y.isEmpty(this.olc.fAj.getPrefixs())) {
                this.mPrefixData = this.olc.fAj;
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
            }
            dYT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.old.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.nlK.setItemInfo(tbRichTextEvaluateItemInfo);
        this.old.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bBR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG.dOp()) {
            bBP();
        } else {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOn();
        }
    }

    public void dYB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.ojX != null) {
                this.ojX.dXh();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG != null) {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOn();
        }
    }

    private void bBT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nx(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.fDG.dOr();
                } else {
                    WriteActivity.this.fDU.bCh();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dXY() {
        int selectionEnd = dYq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dYq().getText().getSpans(0, dYq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dYq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dYq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXZ() {
        if (this.fBu != null) {
            if (this.olg != null && this.olg.isVisible()) {
                this.fBu.setBarLauncherEnabled(!this.oke);
                this.fBu.setDeskLauncherEnabled(!this.oke);
                this.fBu.setToolEnabled(true, 2);
                this.fBu.setToolEnabled(true, 32);
                this.fBu.setToolEnabled(false, 10);
                this.fBu.setToolEnabled(false, 6);
                this.fBu.setToolEnabled(false, 18);
                this.fBu.qU(5).kR(false);
                if (this.ojX != null) {
                    this.ojX.zF(true);
                }
            } else {
                this.fBu.setBarLauncherEnabled(!this.oke);
                this.fBu.setDeskLauncherEnabled(!this.oke);
                this.fBu.setToolEnabled(true, 26);
                this.fBu.setToolEnabled(true, 2);
                this.fBu.setToolEnabled(true, 30);
                this.fBu.qU(5).kR(true);
                if (this.ojX != null) {
                    this.ojX.zF(true);
                }
                dZh();
            }
            if (this.isEvaluate && this.olF != null && !this.olF.isEnable()) {
                this.fBu.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.ojT) {
            this.nmc.setVisibility(8);
            if (this.nlK.getType() == 5) {
                this.okI.setVisibility(8);
            } else {
                this.okI.setVisibility(0);
            }
            a(this.okL, this.okF);
            a(this.okK, this.okJ);
            dJR();
        }
        if (this.okn) {
            this.oke = true;
            dXZ();
            if (this.fBu != null) {
                this.fBu.bzD();
            }
            this.nmc.requestFocus();
            ShowSoftKeyPadDelay(this.nmc);
        }
        if (this.olg != null) {
            this.olg.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.olg != null) {
            this.olg.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.olg != null) {
            this.olg.onStop();
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
                    dYz();
                }
                zL(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nlK.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.nlK.setVideoInfo(null);
            }
            if (this.olg == null) {
                this.olg = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.nlK.getVideoInfo() != null && this.nlK.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.olg.dZQ();
                return;
            }
            aD(true, false);
        }
    }

    public void Eo(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aD(boolean z, boolean z2) {
        if (z) {
            this.nlK.setVideoInfo(null);
            this.olg.a(null, z2);
            this.okC.XO().setVisibility(0);
            zK(false);
        } else {
            this.olg.a(this.nlK.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.okC.XO().setVisibility(8);
            dYV();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dJR();
        dXZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initListener();
        initData(bundle);
        if (this.nlK.getType() == 0) {
            LA(this.bLf);
        }
        initUI();
        dYU();
        this.fDG = new LocationModel(getPageContext());
        this.fDG.a(this.fDU);
        dZr();
        cZX();
        dZk();
        if (this.ojT) {
            this.okE.setEditorTools(this.fBu);
        } else {
            this.ojD.requestFocus();
        }
        dDU();
        dYz();
        dZi();
        this.jfm.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.jfm);
        dYC();
        if (this.oln) {
            k(this.nlK);
            dJR();
            dYZ();
        }
    }

    private void initListener() {
        registerListener(this.olA);
        registerListener(this.olB);
        registerListener(this.olC);
        registerListener(this.nzk);
        registerListener(this.okc);
        registerListener(this.mBackgroundListener);
        registerListener(this.olG);
    }

    private void dYC() {
        Vp(this.olo);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cZX() {
        this.fBu = new EditorTools(getActivity());
        this.fBu.setBarMaxLauCount(5);
        this.fBu.setMoreButtonAtEnd(true);
        this.fBu.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fBu.setBarLauncherType(1);
        this.fBu.kN(true);
        this.fBu.kO(false);
        switch (this.nlK.getType()) {
            case 4:
            case 5:
                dYF();
                break;
            default:
                dYa();
                break;
        }
        this.fBu.build();
        if (this.ojB != null) {
            this.ojB.addView(this.fBu);
        }
        cZx();
        this.fBu.display();
        com.baidu.tbadk.editortools.h qR = this.fBu.qR(6);
        if (qR != null && !TextUtils.isEmpty(this.fDL)) {
            ((View) qR).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fDL);
                }
            });
        }
        if (!this.ojT) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fBu.bzD();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dYG();
            return;
        }
        dYc();
        dZl();
    }

    private void dYD() {
        this.okG = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.okI = this.okG.findViewById(R.id.live_post_title_container);
        this.okF = (EditText) this.okG.findViewById(R.id.live_post_content);
        this.okD = (GridView) this.okG.findViewById(R.id.photoLiveGridView);
        this.okJ = (EditText) this.okG.findViewById(R.id.live_post_title);
        this.okK = (TextView) this.okG.findViewById(R.id.titleOverPlusNumber);
        this.okL = (TextView) this.okG.findViewById(R.id.contentOverPlusNumber);
        this.okH = this.okG.findViewById(R.id.live_interval_view);
        this.okK.setText(String.valueOf(20));
        this.okL.setText(String.valueOf(233));
        this.okG.setVisibility(0);
        this.okK.setVisibility(0);
        this.okL.setVisibility(0);
        this.okJ.setHint(R.string.tips_title_limit_new);
        this.okJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.okO = true;
                    WriteActivity.this.oke = true;
                    WriteActivity.this.dXZ();
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                }
            }
        });
        if (this.nlK.getType() == 4) {
            this.okF.setHint(R.string.live_write_input_content_new);
        } else if (this.nlK.getType() == 5) {
            this.okF.setHint(R.string.live_write_input_content_update);
        }
        this.okF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.okO = false;
                    WriteActivity.this.oke = false;
                    WriteActivity.this.dXZ();
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                }
            }
        });
        this.okF.requestFocus();
        this.okF.addTextChangedListener(awL());
        this.okJ.requestFocus();
        this.okJ.addTextChangedListener(awL());
        this.okJ.setOnClickListener(this.okd);
        this.okF.setOnClickListener(this.okd);
        this.okE = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.okD);
        this.okE.Ls(6);
        this.okD.setAdapter((ListAdapter) this.okE);
        View findViewById = this.okG.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dXB() {
                WriteActivity.this.dZf();
            }
        });
        dYE();
    }

    private void dYE() {
        if (this.nlK.getType() == 0) {
            if (this.nlK.getTitle() != null) {
                this.okJ.setText(this.nlK.getTitle());
                this.okJ.setSelection(this.nlK.getTitle().length());
                return;
            }
            return;
        }
        if (this.nlK.getType() == 1 || this.nlK.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.ojT) {
            dZd();
        }
        if (this.fBu.bBl()) {
            this.fBu.bzD();
        }
        LA(0);
    }

    public boolean dWS() {
        return !"1".equals(this.jMP) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private void LA(int i) {
        if (this.writeImagesInfo != null && this.nlK != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.nlK.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.nlK.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dWS());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jMP);
            albumFloatActivityConfig.setStatisticFrom(this.nlK.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(this.nlK.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.oeh);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fDL;
            antiData.setIfVoice(this.okz);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.nlK.getFirstDir(), this.nlK.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dYF() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fBu.bG(arrayList);
        m qU = this.fBu.qU(5);
        if (qU != null) {
            qU.fCh = 2;
        }
        this.fBu.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fBu.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dYa() {
        m mVar;
        m mVar2;
        m mVar3;
        CustomResponsedMessage runTask;
        m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.fBu.b(dVar);
        }
        Boolean dYY = dYY();
        if (!this.okn && dYY != null && dYY.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dOT() && u.d(this.nlK.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), m.class)) != null && (mVar4 = (m) runTask.getData()) != null) {
            mVar4.fCh = 2;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fBu.b(mVar4);
            }
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), m.class);
        if (runTask2 != null && (mVar3 = (m) runTask2.getData()) != null) {
            mVar3.fCh = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fBu.b(mVar3);
            }
        }
        if (!com.baidu.tieba.write.b.b.dXq() && !this.isEvaluate) {
            this.fBu.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        this.fBu.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        if (au.equals(this.jMP, "2")) {
            this.olF = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.isEvaluate) {
                this.olF.kS(false);
                this.olF.setEnable(false);
            }
            this.fBu.b(this.olF);
            if (!this.isEvaluate) {
                this.fBu.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), m.class);
        if (runTask3 != null && (mVar2 = (m) runTask3.getData()) != null) {
            mVar2.fCj = true;
            mVar2.fCh = 9;
            mVar2.fCb = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fBu.b(mVar2);
            }
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), m.class);
        if (runTask4 != null && (mVar = (m) runTask4.getData()) != null) {
            mVar.fCj = true;
            mVar.fCh = 10;
            mVar.fCb = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fBu.b(mVar);
            }
        }
        if (this.ojI == null) {
            if (this.ojX == null) {
                this.ojX = new com.baidu.tieba.write.editor.b(getActivity(), this.jMP);
                this.ojX.Lm(0);
                this.ojX.zE(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ojX.dXf();
                this.ojX.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dYB();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                this.ojX.dXf();
            }
            this.fBu.b(this.ojX);
        }
        if (!this.isEvaluate && !"main_tab".equals(this.mFrom)) {
            this.fBu.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fBu.bG(arrayList);
        m qU = this.fBu.qU(5);
        if (qU != null) {
            qU.fCh = 4;
        }
    }

    private void dYb() {
        if (this.ojZ != null) {
            this.ojZ.hideTip();
        }
    }

    private void dYG() {
        if (this.fBu != null) {
            this.fBu.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fBu != null && WriteActivity.this.fBu.fBx != null) {
                        if (WriteActivity.this.ola == null) {
                            WriteActivity.this.ola = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.ola.showTip(WriteActivity.this.fBu.fBx.qS(2));
                    }
                }
            });
        }
    }

    private void dYH() {
        if (this.ola != null) {
            this.ola.hideTip();
        }
    }

    private void dYc() {
        if (this.ojZ == null) {
            this.ojZ = new g(getPageContext());
        }
        this.ojZ.d(this.fBu);
    }

    private void cZx() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 9));
                        if (WriteActivity.this.dYp()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u)) {
                            com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                            if (uVar.bwv() == EmotionGroupType.BIG_EMOTION || uVar.bwv() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.zL(true);
                                    WriteActivity.this.dJR();
                                }
                            } else if (WriteActivity.this.dYp()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dYs();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.doi();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dZh();
                        WriteActivity.this.dJR();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.LB(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.ojI == null) {
                            WriteActivity.this.bBU();
                            return;
                        }
                        switch (WriteActivity.this.fDM) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bBR();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bBP();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fDG != null) {
                            WriteActivity.this.fDG.yC(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.llq = null;
                        } else {
                            WriteActivity.this.llq = (String) aVar.data;
                        }
                        WriteActivity.this.zK(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dR("fid", WriteActivity.this.nlK != null ? WriteActivity.this.nlK.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.nlK == null || (videoInfo = WriteActivity.this.nlK.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fBu.bBl()) {
                                        WriteActivity.this.fBu.bzD();
                                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.nlK.setVideoInfo(null);
                        WriteActivity.this.dJR();
                        if (WriteActivity.this.ojD != null) {
                            WriteActivity.this.ojD.requestFocus();
                        }
                        WriteActivity.this.fBu.bzD();
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.ojD);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.ojy = true;
                        WriteActivity.this.zH(true);
                        if (!WriteActivity.this.dYr().isFocused() || WriteActivity.this.ojC.getVisibility() != 0) {
                            WriteActivity.this.ojx = "from_content";
                        } else {
                            WriteActivity.this.ojx = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 8));
                        if (WriteActivity.this.ojC.getVisibility() == 0) {
                            if (WriteActivity.this.ojC.hasFocus()) {
                                WriteActivity.this.ojD.requestFocus();
                                WriteActivity.this.ojD.setSelection(WriteActivity.this.ojD.getText().toString().length());
                            }
                            WriteActivity.this.ojC.setVisibility(8);
                            if (WriteActivity.this.olE != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.olE.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.olE.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.oks.setVisibility(8);
                            WriteActivity.this.fBu.qR(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.ojC.setVisibility(0);
                            if (WriteActivity.this.olE != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.olE.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.olE.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.oks.setVisibility(0);
                            WriteActivity.this.ojC.requestFocus();
                            WriteActivity.this.fBu.qR(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dJR();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 10));
                        if (WriteActivity.this.olh != null && WriteActivity.this.olh.getWriteVoteData() != null) {
                            writeVoteData = WriteActivity.this.olh.getWriteVoteData();
                        }
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ar("c13800").ap("obj_source", 2));
                        WriteActivity.this.dYI();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.ois != null) {
                            WriteActivity.this.ois.Xj();
                        }
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dWx();
                    }
                }
            }
        };
        this.fBu.setActionListener(16, bVar);
        this.fBu.setActionListener(14, bVar);
        this.fBu.setActionListener(24, bVar);
        this.fBu.setActionListener(3, bVar);
        this.fBu.setActionListener(10, bVar);
        this.fBu.setActionListener(11, bVar);
        this.fBu.setActionListener(12, bVar);
        this.fBu.setActionListener(13, bVar);
        this.fBu.setActionListener(15, bVar);
        this.fBu.setActionListener(18, bVar);
        this.fBu.setActionListener(20, bVar);
        this.fBu.setActionListener(25, bVar);
        this.fBu.setActionListener(27, bVar);
        this.fBu.setActionListener(29, bVar);
        this.fBu.setActionListener(43, bVar);
        this.fBu.setActionListener(56, bVar);
        this.fBu.setActionListener(48, bVar);
        this.fBu.setActionListener(46, bVar);
        this.fBu.setActionListener(49, bVar);
        this.fBu.setActionListener(47, bVar);
        this.fBu.setActionListener(55, bVar);
        this.fBu.setActionListener(58, bVar);
        this.fBu.setActionListener(22, bVar);
        this.fBu.setActionListener(21, bVar);
        this.fBu.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYI() {
        if (this.okw != null) {
            this.okw.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.olI;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void dYJ() {
        final WriteVoteData writeVoteData;
        if (this.olp instanceof WriteVoteData) {
            writeVoteData = (WriteVoteData) this.olp;
            this.nlK.setWriteVoteData(writeVoteData);
        } else if (this.nlK.getWriteVoteData() != null) {
            writeVoteData = this.nlK.getWriteVoteData();
        } else {
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.a(writeVoteData);
                TiebaStatic.log(new ar("c13800").ap("obj_source", 3));
            }
        };
        this.olh.ap(onClickListener);
        this.olh.setOnItemClickListener(onClickListener);
        this.olh.b(writeVoteData);
        this.olh.zN(true);
        dJR();
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
    public void LB(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (this.fDG.clA()) {
            if (this.fDG.dOp()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dOk().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fDG.dOn();
            return;
        }
        b(0, true, null);
    }

    protected void zJ(boolean z) {
        if (!z && this.okA != null) {
            this.okA.cFx();
        }
        if (this.ojE != null) {
            this.ojE.cancelLoadData();
        }
        if (this.fDG != null) {
            this.fDG.cancelLoadData();
        }
        if (this.olg != null) {
            this.olg.onDestroy();
        }
    }

    protected void dJJ() {
        zJ(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.olJ);
        if (this.okA != null) {
            this.okA.dOW();
        }
        dYb();
        dYH();
        TiebaPrepareImageService.StopService();
        zJ(true);
        if (!this.olH) {
            dYK();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jtx, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.okC != null) {
            this.okC.destroy();
        }
        if (this.okZ != null) {
            this.okZ.Tz();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYK() {
        if (this.nlK != null && this.nlK.getType() == 2 && this.okx) {
            finish();
        } else if (this.nlK == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.nlK.setTitle(dYr().getText().toString());
            this.nlK.setContent(dYq().getText().toString());
            if (this.old != null) {
                this.nlK.setEvaluationStar(this.old.getStarCount());
            }
            int type = this.nlK.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.olm) {
                    if (this.nlK.isEvaluate()) {
                        y.d(this.nlK.getItem_id(), this.nlK);
                    } else if (TextUtils.isEmpty(this.nlK.getTopicId())) {
                        y.c(this.nlK.getForumId(), this.nlK);
                    } else {
                        y.e(this.nlK.getTopicId(), this.nlK);
                    }
                }
            } else if (type == 7) {
                if (this.olm) {
                    y.c("24591571", this.nlK);
                }
            } else if (type == 1) {
                y.b(this.nlK.getThreadId(), this.nlK);
            } else if (type == 4) {
                y.c(this.nlK.getForumId() + "photolive", this.nlK);
            } else if (type == 5) {
                y.b(this.nlK.getThreadId() + "updatephotolive", this.nlK);
            }
            this.olH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHv() {
        if (this.lUq == null || ((!this.lUq.isEnabled() && !this.isEvaluate) || ((this.isEvaluate && TextUtils.isEmpty(this.ojD.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.olg == null || !this.olg.isVisible()))) || !this.olm))) {
            cGO();
            dPc();
            setResult(100);
            finish();
            return;
        }
        if (this.jty == null) {
            this.jty = new SaveDraftDialogView(this);
            this.jty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cGO();
                            WriteActivity.this.dPc();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dYK();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jtx.dismiss();
                    }
                }
            });
        }
        if (this.jtx == null) {
            this.jtx = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jtx.setContentView(this.jty);
        }
        boolean z = (this.olg == null || !this.olg.isVisible() || this.nlK == null || this.nlK.getVideoInfo() == null || this.nlK.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jty.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jtx.QE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGO() {
        if (this.nlK.getType() == 0 || this.nlK.getType() == 9 || this.nlK.getType() == 11) {
            if (this.olm) {
                if (this.nlK.isEvaluate()) {
                    y.d(this.nlK.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(this.nlK.getTopicId())) {
                    y.a(this.nlK.getForumId(), this.nlK, true);
                } else {
                    y.e(this.nlK.getTopicId(), (WriteData) null);
                }
            }
        } else if (this.nlK.getType() == 1) {
            y.b(this.nlK.getThreadId(), (WriteData) null);
        }
        this.olH = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPc() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nKm));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nmi != null && this.nmi.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmi, getPageContext().getPageActivity());
                return true;
            } else if (this.fBu.bBl()) {
                this.fBu.bzD();
                return true;
            } else {
                dJJ();
                cHv();
                return true;
            }
        }
        if (i == 67 && (text = dYq().getText()) != null) {
            int selectionStart = dYq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dYq().onKeyDown(67, this.iSl);
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
        getLayoutMode().onModeChanged(this.lxd);
        getLayoutMode().onModeChanged(this.okT);
        ap.setBackgroundColor(this.lxd, R.color.CAM_X0205);
        if (this.okQ != null && (i == 1 || i == 4)) {
            this.okQ.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lUq.setTextColor(ap.aM(R.color.CAM_X0302, i));
        dXZ();
        ap.setBackgroundColor(this.nmd, R.color.CAM_X0204);
        ap.setBackgroundColor(this.okH, R.color.CAM_X0204);
        ap.setBackgroundColor(dYr(), R.color.CAM_X0205);
        this.lTC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.llq)) {
            ap.setBackgroundColor(dYq(), R.color.CAM_X0205);
        }
        dJR();
        this.fBu.onChangeSkinType(i);
        if (this.ojR != null) {
            this.ojR.bup();
        }
        if (this.ols != null) {
            this.ols.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.okC.omh.notifyDataSetChanged();
        dYe();
        dYf();
        zK(false);
        if (this.ojY != null) {
            this.ojY.c(dYr(), dYq());
        }
        if (this.olb != null) {
            this.olb.onChangeSkinType();
        }
        if (this.old != null) {
            this.old.onChangeSkinType();
        }
        if (this.oka != null) {
            this.oka.onChangeSkinType(i);
        }
        if (this.olg != null) {
            this.olg.buo();
        }
        if (this.olh != null) {
            this.olh.onChangeSkinType(i);
        }
        if (this.olx != null) {
            this.olx.onChangeSkinType(i);
        }
        if (this.okq != null) {
            this.okq.onChangeSkinType(i);
        }
        if (this.ole != null) {
            ap.setViewTextColor(this.ole, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYe() {
        if (this.nmc.hasFocus()) {
            this.nmc.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nmc.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.ojD.hasFocus()) {
            this.ojD.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.ojD.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYf() {
        if (this.nmc != null && this.nmc.getText() != null && this.nmc.getText().toString() != null && this.nmc.getPaint() != null) {
            if (this.nmc.getText().toString().length() == 0) {
                this.nmc.getPaint().setFakeBoldText(true);
            } else if (this.nmc.getText().toString().length() > 0) {
                this.nmc.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable) {
        g(editable);
        f(editable);
    }

    private void f(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.old.dXG()) {
            this.lUq.setEnabled(true);
        } else {
            this.lUq.setEnabled(false);
        }
    }

    private void g(Editable editable) {
        if (editable.length() > 500) {
            this.ole.setText((500 - editable.length()) + "/500");
            this.ole.setVisibility(0);
            return;
        }
        this.ole.setVisibility(4);
    }

    private void initUI() {
        this.fMe = new com.baidu.tbadk.core.view.a(getPageContext());
        this.ojT = this.nlK.getType() == 4 || 5 == this.nlK.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.okv = (TextView) findViewById(R.id.btn_image_problem);
        dYi();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lUq.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lUq.setLayoutParams(layoutParams);
        this.lUq.setOnFocusChangeListener(this.hxe);
        this.ojS = (ScrollView) findViewById(R.id.write_scrollview);
        this.ojS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.ojD != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.ojD);
                    }
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.okt = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.oku = findViewById(R.id.feedback_divider);
        this.lxd = (RelativeLayout) findViewById(R.id.parent);
        this.ojB = (LinearLayout) findViewById(R.id.tool_view);
        this.ojB.setContentDescription(IStringUtil.TOP_PATH);
        this.ojC = (LinearLayout) findViewById(R.id.title_view);
        this.olE = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.oks = findViewById(R.id.title_view_divider);
        this.nmd = findViewById(R.id.interval_view);
        this.ojV = (TextView) findViewById(R.id.hot_topic_title_edt);
        dJQ();
        if (this.ojT) {
            this.ojS.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dYD();
        } else {
            this.okC = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.okC.zB(false);
            } else {
                this.okC.zB(this.nlK.getType() == 0 || this.nlK.getType() == 9 || this.nlK.getType() == 11);
            }
            this.olg = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.nlK.getVideoInfo() != null && this.nlK.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.olg.dZQ();
            } else {
                aD(true, false);
            }
        }
        dJS();
        if (this.okn || this.ojA) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.b.e.getInstance().fbQ) {
                    com.baidu.tbadk.core.util.b.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.b.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.nmf = (LinearLayout) findViewById(R.id.post_content_container);
        this.nmf.setDrawingCacheEnabled(false);
        this.nmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.ojD.requestFocus();
            }
        });
        this.lTz = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lTA = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lTC = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lTC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.doi();
            }
        });
        f(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.hxe);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dJJ();
                WriteActivity.this.cHv();
            }
        });
        this.okv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dYl();
        u(dYY());
        dYn();
        dYh();
        dYW();
        dXZ();
        dYm();
        dJP();
        dYt();
        if (this.nlK.getType() == 4 && this.nmk != null && this.ojF != null) {
            this.nmk.setVisibility(8);
            this.ojF.setVisibility(8);
        }
        dJR();
        dYS();
        dYR();
        dYL();
        dYg();
        dYM();
        dYN();
        dYX();
        dYO();
        bRY();
    }

    private void dYL() {
        if ("main_tab".equals(this.mFrom) && !this.oln) {
            this.olb = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.olb.setVisibility(0);
        }
    }

    private void dYg() {
        if (!this.isEvaluate) {
            this.oka = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.oka.setBgColor(R.color.CAM_X0205);
            this.olf = findViewById(R.id.frs_tab__divider);
            this.oka.setData(this.oeh);
            if (this.oka.getVisibility() == 0) {
                this.olf.setVisibility(0);
            }
            this.oka.setActivity(this);
        }
    }

    private void dYM() {
        if (this.isEvaluate) {
            this.ole = (TextView) findViewById(R.id.post_content_counter);
            this.old = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.old.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void aq(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.ojD.getText()) || WriteActivity.this.ojD.getText().length() < 20 || WriteActivity.this.ojD.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lUq.setEnabled(false);
                    } else {
                        WriteActivity.this.lUq.setEnabled(true);
                    }
                }
            });
            this.old.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lUq.setEnabled(false);
                }
            });
        }
    }

    private void dYN() {
        if (this.isEvaluate) {
            this.old.setVisibility(0);
            if (!this.jtH) {
                if (this.olk) {
                    this.old.setShowItemInfo(false);
                }
                if (this.olj != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.olj.id));
                    tbRichTextEvaluateItemInfo.setTags(this.olj.tags);
                    tbRichTextEvaluateItemInfo.setScore(this.olj.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(F(this.olj.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.olj.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.olj.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.olj.name);
                    this.old.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.old.setStarCount(this.oll);
                    this.nlK.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.nlK.setEvaluationStar(this.oll);
                } else if (this.nlK.getItemInfo() != null) {
                    this.old.setItemInfo(this.nlK.getItemInfo());
                    this.old.setStarCount(this.nlK.getEvaluationStar());
                }
            }
        }
    }

    private int F(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void dYO() {
        this.olt = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.olu = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.olv = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.olv, R.color.CAM_X0107);
        this.olx = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
        this.olx.setTitle(getResources().getString(R.string.protocol_title));
        this.olx.UO("file:///android_asset/protocol.html");
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.olx, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.olv.setText(spannableString);
        this.olv.setMovementMethod(LinkMovementMethod.getInstance());
        this.olu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.oly) {
                    WriteActivity.this.oly = false;
                    WriteActivity.this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.oly = true;
                    WriteActivity.this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.oly) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nz(R.color.CAM_X0105);
                    aVar.At("");
                    aVar.Au(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.nA(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bqx();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.oly = true;
            this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.oly = false;
            this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.olx.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.view.EBusinessProtocolView.a
            public void zo(boolean z) {
                if (z) {
                    if (!WriteActivity.this.oly) {
                        WriteActivity.this.oly = true;
                        WriteActivity.this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.oly) {
                    WriteActivity.this.oly = false;
                    WriteActivity.this.olu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void dYP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.olI = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.okw = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.okw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.okw.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.okw.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.okw.setLayoutParams(layoutParams2);
        this.okw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dYQ();
            }
        });
        this.okw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYQ() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_1)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_2)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_3)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_4)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_5));
        eBusinessProtocolView.v(spannableStringBuilder);
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dYR() {
        if (this.mName != null && this.nlK != null && this.nlK.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dYh() {
        String str;
        String str2;
        if (this.nlK != null) {
            switch (this.nlK.getType()) {
                case 0:
                case 9:
                    if (this.okn || this.ojA) {
                        if (this.okp) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jMP != null && this.jMP.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.jMP != null && this.jMP.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.nlK.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.nlK.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.nlK.getForumName() + getResources().getString(R.string.bar));
                        this.nmc.setVisibility(8);
                        String str3 = this.jed + " " + this.jeb;
                        if (!StringUtils.isNull(str3)) {
                            this.ojD.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.nmc.setVisibility(0);
                    this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nmc.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.nlK.getFloorNum() + 1)));
                    this.okH.setVisibility(8);
                    return;
                case 7:
                    this.nmc.setVisibility(0);
                    this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.nmc.setVisibility(0);
                    this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void dYi() {
        if (this.nlK.getType() == 7) {
            this.lUq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lUq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dYj() {
        if (this.nlK != null && this.nlK.getType() == 0 && this.nlK.getType() == 9 && !this.okn && !this.ojA && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dYr() != null) {
                dYr().setText(cutStringWithSuffix);
                dYr().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.nlK.setVoiceModel(voiceModel);
            this.lTz.setVisibility(0);
            this.lTA.setVoiceModel(voiceModel);
            this.lTA.ccu();
            dJR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BL(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.nlK.setVoiceModel(null);
        this.lTz.setVisibility(8);
        this.lTA.cQu();
        this.lTA.setVoiceModel(null);
        m qU = this.fBu.qU(6);
        if (qU != null && qU.fBo != null) {
            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dJR();
    }

    private void dYk() {
        ad yX = ac.cEy().yX(1);
        if (yX != null) {
            this.gMR = yX.jkJ;
            if (this.gMR != null && !this.gMR.isEmpty() && this.ojO >= 0) {
                this.ojN = new ab();
                this.ojN.jkF = 0;
                this.ojN.name = getPageContext().getResources().getString(R.string.category_auto);
                this.ojQ = this.ojN.jkF;
                this.ojP = this.ojN.name;
                for (ab abVar : this.gMR) {
                    if (abVar.jkF == this.ojO) {
                        this.ojQ = abVar.jkF;
                        this.ojP = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dYl() {
        if (this.gMR != null && !this.gMR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.ojR = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.ojR.setText(this.ojP);
            this.ojR.setCategoryContainerData(this.gMR, this.ojN, this.ojQ);
            this.ojR.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        WriteActivity.this.ojR.setText(bcVar.name);
                        WriteActivity.this.nlK.setCategoryTo(bcVar.jkF);
                        WriteActivity.this.ojQ = bcVar.jkF;
                        WriteActivity.this.ojR.dXD();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.ojR.dXC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYq());
                }
            });
        }
    }

    private void dYS() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.okh = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.okh.setTitle(R.string.no_disturb_start_time);
        this.okh.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.okh);
        this.okh.setButton(-2, getPageContext().getString(R.string.cancel), this.okh);
        return this.okh;
    }

    private void dYm() {
        this.ojJ = (RelativeLayout) findViewById(R.id.addition_container);
        this.ojK = (TextView) findViewById(R.id.addition_create_time);
        this.ojL = (TextView) findViewById(R.id.addition_last_time);
        this.ojM = (TextView) findViewById(R.id.addition_last_content);
        if (this.ojI != null) {
            this.ojJ.setVisibility(0);
            this.ojK.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.ojI.getCreateTime() * 1000));
            if (this.ojI.getAlreadyCount() == 0) {
                this.ojL.setVisibility(8);
            } else {
                this.ojL.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.ojI.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ojI.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ojM.setText(lastAdditionContent);
            } else {
                this.ojM.setVisibility(8);
            }
            dYq().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.ojI.getAlreadyCount()), Integer.valueOf(this.ojI.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.ojJ.setVisibility(8);
    }

    private void dJP() {
        this.nmk = findViewById(R.id.post_prefix_layout);
        if (this.okZ == null) {
            this.okZ = new com.baidu.tieba.c.e(getPageContext(), this.nmk);
            this.okZ.en(R.drawable.bg_tip_blue_up_left);
            this.okZ.em(16);
            this.okZ.pJ(true);
            this.okZ.setUseDirectOffset(true);
            this.okZ.xl(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.nmh = (TextView) findViewById(R.id.post_prefix);
        this.ojF = findViewById(R.id.prefix_divider);
        this.nmj = (ImageView) findViewById(R.id.prefix_icon);
        dYT();
    }

    private void dYT() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nmk.setVisibility(0);
            this.ojF.setVisibility(0);
            this.okZ.C(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nlL = 0;
            this.nmk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.nlK.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nmh.setVisibility(0);
                    WriteActivity.this.nmk.setSelected(true);
                    SvgManager.bsR().a(WriteActivity.this.nmj, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nmi, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fBu.bzD();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nmc);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.ojD);
                }
            });
            this.nmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.nlK.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nmh.setSelected(true);
                    SvgManager.bsR().a(WriteActivity.this.nmj, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nmi, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fBu.bzD();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYq());
                }
            });
            this.nmi = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nmi.a(this);
            this.nmi.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nmi.setOutsideTouchable(true);
            this.nmi.setFocusable(true);
            this.nmi.setOnDismissListener(this);
            this.nmi.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.bsR().a(this.nmj, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nmh).nY(R.color.CAM_X0105).oa(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.ojG.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ojG.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zy(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zy(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nmi.addView(writePrefixItemLayout);
            }
            this.nmi.setCurrentIndex(0);
            this.nmh.setText(prefixs.get(0));
            Lz(0);
            return;
        }
        this.nmk.setVisibility(8);
        this.ojF.setVisibility(8);
    }

    private void dYU() {
        if (this.okn && this.nlK != null) {
            this.okt.setVisibility(0);
            this.oku.setVisibility(0);
            this.ojE = new FeedBackModel(getPageContext());
            this.ojE.Vl(this.nlK.getForumName());
            this.ojE.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.okt.setVisibility(8);
                        WriteActivity.this.oku.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.okt.setVisibility(8);
                        WriteActivity.this.oku.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.okt.a(feedBackModel.dXK(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dYn() {
        this.lUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.olb == null || WriteActivity.this.olc != null) {
                    if (WriteActivity.this.dZo()) {
                        if (!WriteActivity.this.olz || WriteActivity.this.oly) {
                            if (WriteActivity.this.dZq()) {
                                int dZp = WriteActivity.this.dZp();
                                if (dZp == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dZp == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                                if (WriteActivity.this.ojY.a(WriteActivity.this.nmc, WriteActivity.this.ojD)) {
                                    WriteActivity.this.showToast(WriteActivity.this.ojY.dWr());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYr());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYq());
                                WriteActivity.this.fBu.bzD();
                                if (WriteActivity.this.nlK.getType() != 7) {
                                    if (WriteActivity.this.okn) {
                                        WriteActivity.this.cGR();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.ap("obj_type", StringUtils.isNull(WriteActivity.this.nlK.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.dYx();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cGR();
                                }
                                MercatorModel.dOC().startLoad();
                                TiebaStatic.log(new ar("c12262").dR("obj_locate", WriteActivity.this.jMP));
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

    protected void dJQ() {
        this.okr = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.okr.setIsRound(true);
        this.okr.setDrawBorder(false);
        this.okr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String AV = r.AV(currentPortrait);
            this.okr.setUrl(AV);
            this.okr.startLoad(AV, 12, false);
        }
        if (this.nlK.isUserFeedback()) {
            this.okr.setVisibility(0);
        }
        this.nmc = (EditText) findViewById(R.id.post_title);
        this.nmc.setOnClickListener(this.okd);
        this.nmc.setOnFocusChangeListener(this.hxe);
        if (this.nlK.getType() == 0 || this.nlK.getType() == 9 || this.nlK.getType() == 11 || this.nlK.getType() == 7) {
            if (this.nlK.getTitle() != null) {
                this.nmc.setText(this.nlK.getTitle());
                this.nmc.setSelection(this.nlK.getTitle().length());
            } else if (this.okp) {
                this.nmc.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.nlK.getType() == 1 || this.nlK.getType() != 2) {
        }
        this.nmc.addTextChangedListener(this.okf);
        com.baidu.tbadk.core.elementsMaven.c.br(this.nmc).oa(R.string.F_X02);
        if (!this.nlK.getHaveDraft()) {
            dYj();
            this.okX = true;
        }
        this.okq = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher awL() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText cBd = null;
            private TextView mTextView = null;
            private int olN;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dJR();
                if (WriteActivity.this.ojT) {
                    this.olN = this.cBd.getSelectionStart();
                    this.cBd.setSelection(this.olN);
                    WriteActivity.this.a(this.mTextView, this.cBd);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.ojT || !WriteActivity.this.okO) {
                    if (WriteActivity.this.ojT) {
                        if (this.cBd != WriteActivity.this.okF || this.mTextView != WriteActivity.this.okL) {
                            this.cBd = WriteActivity.this.okF;
                            this.mTextView = WriteActivity.this.okL;
                        }
                    }
                } else if (this.cBd != WriteActivity.this.okJ || this.mTextView != WriteActivity.this.okK) {
                    this.cBd = WriteActivity.this.okJ;
                    this.mTextView = WriteActivity.this.okK;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.ojT && this.okO) {
            if (this.okM != null) {
                this.okJ.removeTextChangedListener(this.okM);
            }
            this.okM = textWatcher;
        } else if (this.ojT) {
            if (this.okN != null) {
                this.okF.removeTextChangedListener(this.okN);
            }
            this.okN = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.okF) {
            return 233L;
        }
        if (editText != this.okJ) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long k = k(editText);
            long l = k - l(editText);
            String valueOf = String.valueOf(l);
            if (k == 20) {
                if (l < 0) {
                    if (l < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ap.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(ap.getColor(R.color.CAM_X0109));
                }
            } else if (l < 0) {
                if (l < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ap.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ap.getColor(R.color.CAM_X0109));
            }
            textView.setText(valueOf);
        }
    }

    private long l(EditText editText) {
        return com.baidu.tieba.write.b.a.w(editText.getText().toString().trim());
    }

    protected void dJS() {
        this.ojD = (SpanGroupEditText) findViewById(R.id.post_content);
        this.ojD.setDrawingCacheEnabled(false);
        this.ojD.setOnClickListener(this.okd);
        this.ojD.setOnSpanGroupChangedListener(new a.InterfaceC0565a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0565a
            public void G(int i, boolean z) {
                WriteActivity.this.Kx();
            }
        });
        this.ojD.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.ojD.setForumId(com.baidu.adp.lib.f.b.toLong(this.nlK.getForumId(), 0L));
        if (this.okA != null) {
            this.okA.setSpanGroupManager(this.ojD.getSpanGroupManager());
        }
        if (this.nlK != null) {
            this.nlK.setSpanGroupManager(this.ojD.getSpanGroupManager());
        }
        if (this.nlK.getContent() != null && this.nlK.getContent().length() > 0) {
            this.ojD.setText(TbFaceManager.bCO().aD(getPageContext().getPageActivity(), this.nlK.getContent()));
            if (this.ojD.getText() != null) {
                this.ojD.setSelection(this.ojD.getText().length());
            }
        } else if (this.nlK.getType() == 2) {
            if (this.okx) {
                if (this.oky != null && this.oky.length() > 0) {
                    this.ojD.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.oky}));
                    this.ojD.setSelection(this.ojD.getText().length());
                }
            } else if (this.nlK.getFloorNum() > 0) {
                this.ojD.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.nlK.getFloorNum())));
                this.ojD.setSelection(this.ojD.getText().length());
            }
        }
        this.ojD.setOnFocusChangeListener(this.hxe);
        this.ojD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.ojD.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.ojD.addTextChangedListener(this.okg);
        if (this.nlK.getType() == 0) {
            this.okY = true;
        } else {
            zK(true);
            this.okY = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.ojD.setHint(spannableString);
        } else if (this.nlK.isUserFeedback()) {
            this.ojD.setHint(R.string.write_input_content);
        } else {
            this.ojD.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zK(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.ojT && dYq() != null) {
            dYq().setPadding(0, 0, 0, 0);
            dYq().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYq(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.llq) || this.ojI != null) {
                return;
            }
            if (this.olg == null || !this.olg.isVisible()) {
                com.baidu.adp.lib.e.d.mw().a(this.llq, 19, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.olg == null || !WriteActivity.this.olg.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dYq().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dYq(), true, WriteActivity.this.maE);
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

    private void dYV() {
        if (dYq() != null) {
            dYq().setPadding(0, 0, 0, 0);
            dYq().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYq(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYp() {
        int i = 5000;
        if (this.ojI != null) {
            i = 1000;
        }
        return dYq().getText() != null && dYq().getText().length() >= i;
    }

    private void CS(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ojx)) {
                this.ojx = "";
                dYq().requestFocus();
                if (dYq().getText() != null && dYq().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYq().getSelectionStart();
                    editable = dYq().getText();
                }
            } else if ("from_title".equals(this.ojx)) {
                this.ojx = "";
                dYr().requestFocus();
                if (dYr().getText() != null && dYr().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYr().getSelectionStart();
                    editable = dYr().getText();
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
    public void zH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.nlK != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nlK.getForumId(), 0L), this.nlK.getFirstDir(), this.nlK.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dYq().getText().getSpans(0, dYq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ojH == null) {
                this.ojH = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.ojH.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dYq());
    }

    EditText dYq() {
        return this.ojT ? this.okF : this.ojD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYr() {
        return this.ojT ? this.okJ : this.nmc;
    }

    protected void dYs() {
        if (dYq().getSelectionStart() > 0) {
            String substring = dYq().getText().toString().substring(0, dYq().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iSk.matcher(substring);
            if (matcher.find()) {
                dYq().getText().delete(dYq().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dYq().getSelectionStart());
                return;
            }
            dYq().onKeyDown(67, this.iSl);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.nlK != null) {
            str = this.nlK.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.okn = true;
        }
    }

    private void dYW() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dYX() {
        this.oli = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.olh = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.oli);
        dYJ();
    }

    private void bRY() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.ols = new d(getPageContext());
        this.ols.a(this.olr);
        this.mListView.setAdapter((ListAdapter) this.ols);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.ols != null && (WriteActivity.this.ols.getItem(i) instanceof v)) {
                    v vVar = (v) WriteActivity.this.ols.getItem(i);
                    if (vVar.mType == 1) {
                        if (vVar.eMT == 1) {
                            bf.bsV().b(WriteActivity.this.getPageContext(), new String[]{vVar.eML});
                        } else {
                            bf.bsV().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eML)});
                        }
                    } else if (vVar.mType == 2) {
                        if (!TextUtils.isEmpty(vVar.eMO)) {
                            if (vVar.eMO.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, vVar.eMO));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(vVar.eMO));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(vVar.eMP)) {
                                bf.bsV().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eMP)});
                            }
                        } else if (!TextUtils.isEmpty(vVar.eMP)) {
                            bf.bsV().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eMP)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fMe.setCancelListener(null);
        this.fMe.setTipString(R.string.sending);
        this.fMe.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fMe != null) {
            this.fMe.setDialogVisiable(false);
        }
    }

    private Boolean dYY() {
        return Boolean.valueOf(this.okz);
    }

    public void dJR() {
        if (this.nlK != null) {
            String str = "";
            String str2 = "";
            if (dYr() != null) {
                str = dYr().getText().toString();
            }
            if (dYq() != null) {
                str2 = dYq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nlK.getType() == 0 || this.nlK.getType() == 9 || this.nlK.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.nlL == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nlK.setIsNoTitle(true);
                        } else if (this.ojC.getVisibility() == 0) {
                            this.nlK.setIsNoTitle(false);
                            zI(true);
                            return;
                        }
                    } else if (this.ojC.getVisibility() == 0) {
                        this.nlK.setIsNoTitle(false);
                        zI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nlK.setIsNoTitle(true);
                } else if (this.ojC.getVisibility() == 0) {
                    this.nlK.setIsNoTitle(false);
                    zI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ojT) {
                    zI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zI(true);
                }
            }
            if (this.nlK.getType() == 4) {
                zI(n(this.okF) && m(this.okJ));
            } else if (this.nlK.getType() == 5) {
                zI(n(this.okF));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zI(true);
            } else if (this.nlK.getVideoInfo() != null) {
                zI(this.nlK.getVideoInfo().isVideoMixFinished());
            } else if (dZm()) {
                zI(true);
            } else {
                zI(false);
            }
        }
    }

    public void zI(boolean z) {
        if (!z || !this.isEvaluate || (this.ojD != null && !TextUtils.isEmpty(this.ojD.getText()) && this.ojD.getText().length() >= 20 && this.ojD.getText().length() <= 500 && this.old != null && this.old.dXG())) {
            this.lUq.setEnabled(z);
        }
    }

    private boolean m(EditText editText) {
        long l = l(editText);
        return l <= 20 && l > 0;
    }

    private boolean n(EditText editText) {
        long l = l(editText);
        if (l > 233) {
            return false;
        }
        return l > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.okA = com.baidu.tieba.tbadkCore.writeModel.a.dOU();
        this.okA.a(this);
        this.nlK = new WriteData();
        if (bundle != null) {
            this.nlK.setType(bundle.getInt("type", 0));
            this.nlK.setForumId(bundle.getString("forum_id"));
            this.nlK.setForumName(bundle.getString("forum_name"));
            this.nlK.setFirstDir(bundle.getString("forum_first_dir"));
            this.nlK.setSecondDir(bundle.getString("forum_second_dir"));
            this.nlK.setThreadId(bundle.getString("thread_id"));
            this.nlK.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.nlK.setFloorNum(bundle.getInt("floor_num", 0));
            this.nlK.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.ojI = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.nlK.setIsAddition(this.ojI != null);
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.nlK.setTopicId(this.mTopicId);
            this.nlK.setTitle(bundle.getString("write_title"));
            this.nlK.setContent(bundle.getString("write_content"));
            this.nlK.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.okn = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.oko = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.okp = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.okx = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.oky = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.olq = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fDF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string2)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
            }
            String string3 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string3)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jMP = bundle.getString("KEY_CALL_FROM");
            this.bLf = bundle.getInt("album_thread");
            this.oeh = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.nlK.setType(intent.getIntExtra("type", 9));
            this.nlK.setForumId(intent.getStringExtra("forum_id"));
            this.nlK.setForumName(intent.getStringExtra("forum_name"));
            this.nlK.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nlK.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nlK.setThreadId(intent.getStringExtra("thread_id"));
            this.nlK.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.nlK.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.ojI = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nlK.setIsAddition(this.ojI != null);
            this.nlK.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.nlK.setTitle(intent.getStringExtra("write_title"));
            this.nlK.setContent(intent.getStringExtra("write_content"));
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.nlK.setTopicId(this.mTopicId);
            this.nlK.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.nlK.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.okn = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.oko = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.okp = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.okx = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.oky = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.jec = intent.getStringExtra("more_forum_img");
            this.jed = intent.getStringExtra("more_forum_title");
            this.jeb = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jMP = intent.getStringExtra("KEY_CALL_FROM");
            this.bLf = intent.getIntExtra("album_thread", 0);
            this.olq = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.oeh = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nlK.setFrsTabInfoData(this.oeh);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.isEvaluate = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.nlK.setIsEvaluate(this.isEvaluate);
            this.olk = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.oll = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                this.olj = (SerializableItemInfo) serializableExtra;
                this.nlK.setItem_id(String.valueOf(this.olj.id));
            }
            this.jtH = getIntent().getBooleanExtra("item_is_school", false);
            this.olm = getIntent().getBooleanExtra("need_save_draft", true);
            this.oln = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.ojO = getIntent().getIntExtra("category_id", -1);
            this.olo = getIntent().getStringExtra("goods_list");
            this.olp = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.okz = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.fDL = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.oln && com.baidu.tieba.tbadkCore.writeModel.c.nAL != null) {
                this.nlK = com.baidu.tieba.tbadkCore.writeModel.c.nAL;
                this.nlK.setType(9);
                this.nlK.setContent(this.nlK.getContentString());
                this.writeImagesInfo = this.nlK.getWriteImagesInfo();
                this.oeh = this.nlK.getFrsTabInfoData();
                if (this.nlK.getItemInfo() != null) {
                    this.olj = null;
                }
                this.mVoiceModel = this.nlK.getVoiceModel();
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.nlK.getType() == 9) {
            this.nlK.setEntranceType(1);
        } else if (this.nlK.getType() == 10) {
            this.nlK.setEntranceType(2);
            this.nlK.setType(9);
        } else if (this.nlK.getType() == 0) {
            this.nlK.setEntranceType(3);
        }
        this.nlK.setIsUserFeedback(this.okn);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.olq != null) {
            this.writeImagesInfo.parseJson(this.olq);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nlK.getType() == 4 ? 6 : 9);
        this.nlK.setWriteImagesInfo(this.writeImagesInfo);
        this.llq = TbadkCoreApplication.getInst().getDefaultBubble();
        dYk();
        if (this.nlK.getType() == 0 || this.nlK.getType() == 9 || this.nlK.getType() == 11) {
            if (this.olm) {
                if (this.nlK.isEvaluate()) {
                    y.c(this.nlK.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.nlK.getTopicId())) {
                    y.b(this.nlK.getForumId(), this);
                } else {
                    y.d(this.nlK.getTopicId(), this);
                }
            }
        } else if (this.nlK.getType() == 7) {
            if (this.olm) {
                y.b("24591571", this);
            }
        } else if (this.nlK.getType() == 1) {
            y.a(this.nlK.getThreadId(), this);
        } else if (this.nlK.getType() == 4) {
            y.b(this.nlK.getForumId() + "photolive", this);
        } else if (this.nlK.getType() == 5) {
            y.a(this.nlK.getThreadId() + "updatephotolive", this);
        }
        if (this.nlK != null && this.nlK.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nlK.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ojA = true;
        }
        try {
            this.okP = dZj();
        } catch (Throwable th) {
            this.okP = null;
        }
    }

    private void dYZ() {
        this.mNavigationBar.postDelayed(this.olJ, 500L);
    }

    private void dYt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nmc.setText(com.baidu.tbadk.plugins.b.DA(com.baidu.tbadk.plugins.b.DB(hotTopicBussinessData.mTopicName)));
            this.nmc.setMovementMethod(com.baidu.tieba.view.c.dVQ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString DA = com.baidu.tbadk.plugins.b.DA(com.baidu.tbadk.plugins.b.DB(hotTopicBussinessData.mTopicName));
            if (DA != null) {
                this.nmc.setText(DA);
            }
            this.ojV.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.olz && !this.oln) {
            if (writeData != null) {
                if (this.nlK != null && writeData.isEvaluate() == this.nlK.isEvaluate()) {
                    boolean z = this.nlK.getVideoInfo() != null && this.nlK.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.nlK.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.nlK.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dYr().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dYq().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    this.nlK.setHaveDraft(true);
                    if (!z2 && !z) {
                        i(writeData);
                    }
                    if (!z3 || this.okX || ((this.okn || this.ojA) && z5)) {
                        j(writeData);
                    }
                    if (z6 && (!z4 || this.okn || this.ojA)) {
                        k(writeData);
                    }
                    if (this.nlK != null && !this.nlK.getHaveDraft()) {
                        dYj();
                    }
                    if (writeData.getItemInfo() != null) {
                        this.nlK.setItemInfo(writeData.getItemInfo());
                        this.nlK.setEvaluationStar(writeData.getEvaluationStar());
                        this.olj = null;
                        dYN();
                    }
                    if (writeData.getWriteVoteData() != null) {
                        this.nlK.setWriteVoteData(writeData.getWriteVoteData());
                        dYJ();
                    }
                    if (writeData.getVoiceModel() != null) {
                        f(writeData.getVoiceModel());
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dZa();
                    }
                    dJR();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.gMR != null) {
                        this.ojQ = this.ojN.jkF;
                        this.ojP = this.ojN.name;
                        while (true) {
                            if (i == this.gMR.size()) {
                                break;
                            }
                            ab abVar = this.gMR.get(i);
                            if (categoryTo != abVar.jkF) {
                                i++;
                            } else {
                                this.ojQ = categoryTo;
                                this.ojP = abVar.name;
                                this.nlK.setCategoryTo(this.ojQ);
                                break;
                            }
                        }
                        if (this.ojR != null) {
                            this.ojR.setText(this.ojP);
                            this.ojR.setCategoryContainerData(this.gMR, this.ojN, this.ojQ);
                        }
                    }
                    this.fBu.bzD();
                    return;
                }
                return;
            }
            dZa();
            dYj();
        }
    }

    private void i(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.nlK.setVideoInfo(videoInfo);
            aD(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.nlK.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dYz();
        }
        zL(false);
        aD(true, true);
    }

    private void j(WriteData writeData) {
        String str;
        String DB;
        if (com.baidu.adp.lib.util.k.isEmpty(this.nlK.getTitle())) {
            this.nlK.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                DB = this.nlK.getTitle();
            } else {
                DB = com.baidu.tbadk.plugins.b.DB(str);
            }
            SpannableString DA = com.baidu.tbadk.plugins.b.DA(DB);
            if (DA != null) {
                dYr().setText(DA);
                dYr().setSelection(DA.length() > DB.length() ? DB.length() : DA.length());
                return;
            }
            return;
        }
        SpannableString DA2 = com.baidu.tbadk.plugins.b.DA(this.nlK.getTitle());
        if (DA2 != null) {
            dYr().setText(DA2);
            dYr().setSelection(this.nlK.getTitle().length() > DA2.length() ? DA2.length() : this.nlK.getTitle().length());
        }
    }

    private void k(WriteData writeData) {
        this.nlK.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bCO().a(getPageContext().getPageActivity(), this.nlK.getContent(), this.okb);
        InputFilter[] filters = this.ojD.getFilters();
        this.ojD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dYq().setText(a2);
        if (dYq() == this.ojD && this.ojD.getSpanGroupManager() != null) {
            this.ojD.bva();
            this.ojD.getSpanGroupManager().bvg();
            this.ojD.bvb();
            Kx();
        }
        this.ojD.setFilters(filters);
        if (dYq().getText() != null) {
            dYq().setSelection(dYq().getText().length());
        }
        if (this.ojT) {
            a(this.okL, this.okF);
        }
    }

    private void dZa() {
        if ((!this.ojT || this.okE != null) && this.okD != null) {
            this.okE.b(this.writeImagesInfo);
            dZf();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nlK.getType());
        bundle.putString("forum_id", this.nlK.getForumId());
        bundle.putString("forum_name", this.nlK.getForumName());
        bundle.putString("forum_first_dir", this.nlK.getFirstDir());
        bundle.putString("forum_second_dir", this.nlK.getSecondDir());
        bundle.putString("thread_id", this.nlK.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.nlK.getFloor());
        bundle.putInt("floor_num", this.nlK.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.okx);
        if (this.okn) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fDF);
        if (this.ojI != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ojI));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jMP);
        bundle.putInt("album_thread", this.bLf);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.oeh);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.nlK.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dYq().getEditableText().toString();
        if (obj != null) {
            dYq().setText(TbFaceManager.bCO().a(getPageContext().getPageActivity(), obj, this.okb));
            dYq().setSelection(dYq().getText().length());
        }
    }

    private String getContent() {
        return (dYq() == null || dYq().getText() == null) ? "" : dYq().getText().toString();
    }

    private String dYv() {
        if (this.nlK == null || dYr() == null || dYr().getVisibility() != 0 || dYr().getText() == null) {
            return "";
        }
        String obj = dYr().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nlL != com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.nlK.getType() != 4 && this.nmh != null && this.nmh.getText() != null) {
            this.nlK.setPostPrefix(this.nmh.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.nlK.getTitle();
        }
        return obj;
    }

    private void Vm(String str) {
        if (this.nlK != null && this.ojC != null) {
            if (this.ojC.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.nlK.setIsNoTitle(true);
                    this.nlK.setTitle("");
                    return;
                }
                this.nlK.setIsNoTitle(false);
                this.nlK.setTitle(str);
                return;
            }
            this.nlK.setIsNoTitle(true);
            this.nlK.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGR() {
        dJJ();
        this.nlK.setContent(getContent());
        Vm(dYv());
        if (this.okn || this.ojA) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.nlK.getTitle()) || !this.nlK.getTitle().startsWith(string)) {
                Vm(string + this.nlK.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.nlK.getContent()) || !this.nlK.getContent().startsWith(str)) {
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
                sb.append(this.nlK.getContent());
                this.nlK.setContent(sb.toString());
            }
        }
        if (this.oko) {
            this.nlK.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.ojO >= 0) {
            this.nlK.setCategoryFrom(this.ojO);
        }
        if (this.ojQ >= 0) {
            this.nlK.setCategoryTo(this.ojQ);
        }
        this.nlK.setWriteImagesInfo(this.writeImagesInfo);
        if (this.olh != null) {
            this.nlK.setWriteVoteData(this.olh.getWriteVoteData());
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
            this.nlK.setTakePhotoNum(i);
        }
        this.nlK.setHasLocationData(this.fDG != null && this.fDG.clA());
        if (this.writeImagesInfo != null) {
            this.okA.yE(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && this.ojU != null && this.ojU.mIsGlobalBlock == 0) {
            this.nlK.setForumId(String.valueOf(this.ojU.mForumId));
            this.nlK.setForumName(this.ojU.mForumName);
        }
        if (this.old != null && this.old.getEvaluateItemInfo() != null) {
            this.nlK.setItem_id(this.old.getEvaluateItemInfo().getItemID());
            this.nlK.setComment_head(cGQ());
        }
        dYw();
        this.okA.f(this.nlK);
        this.nlK.setContent(this.nlK.getContent().replaceAll("\u0000\n", ""));
        this.nlK.setContent(this.nlK.getContent().replaceAll("\u0000", ""));
        this.nlK.setVcode(null);
        this.nlK.setVoiceModel(this.mVoiceModel);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.okA.dav().setVoice(this.mVoiceModel.getId());
                this.okA.dav().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.okA.dav().setVoice(null);
                this.okA.dav().setVoiceDuringTime(-1);
            }
        } else {
            this.okA.dav().setVoice(null);
            this.okA.dav().setVoiceDuringTime(-1);
        }
        if (!this.okA.dOX()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            dZb();
        }
    }

    private void dZb() {
        this.okA.dOV();
        com.baidu.tieba.write.b.b.g(this.nlK);
        cCU();
        dYK();
        setResult(100);
        finish();
    }

    private void dYw() {
        if (this.nlK != null && this.oka != null) {
            this.nlK.setIsForumBusinessAccount(this.oeh == null ? false : this.oeh.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.oka.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.nlK.setTabId(selectedTabItemData.tabId);
                this.nlK.setTabName(selectedTabItemData.name);
                this.nlK.setIsGeneralTab(selectedTabItemData.isGeneralTab);
            }
        }
    }

    private void Q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ojI != null) {
                i2 = this.ojI.getTotalCount();
                i = this.ojI.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
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
                if (this.nmc == getCurrentFocus()) {
                    dYq().clearFocus();
                    this.nmc.requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.nmc);
                } else {
                    dYq().requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.ojD);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            dYq().getText().insert(dYq().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cGO();
                dPc();
                j(postWriteCallBackData2);
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
                                dZg();
                            } else {
                                aq(intent);
                            }
                        } else if (intExtra == 1) {
                            ar(intent);
                        } else {
                            ao(intent);
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.50
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        aD(com.baidu.tbadk.core.util.y.getCount(this.writeImagesInfo.getChosedFiles()) > 0, false);
                        if (this.okY) {
                            zK(true);
                            this.okY = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.ojT) {
                        G(intent);
                        dJR();
                        return;
                    }
                    ap(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.nlK.setVideoInfo(videoInfo);
                        this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fBu.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dJR();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ojy) {
                                sb2.append(com.baidu.tbadk.plugins.b.fLy);
                                this.ojy = false;
                            }
                            sb2.append(stringExtra);
                            CS(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.ojU = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.ojU);
                    }
                } else if (i == 25048) {
                    Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                    if (serializableExtra instanceof WriteVoteData) {
                        this.olp = serializableExtra;
                        dYJ();
                    }
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.ojD.getSelectionStart();
                    int selectionEnd = this.ojD.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.ojD.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fBu != null && !this.fBu.bBl()) {
                this.ojD.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fBu.bzD();
            }
            switch (i) {
                case 12001:
                    bBX();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dZe();
                    if (this.okY) {
                        zK(true);
                        this.okY = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.nmc == getCurrentFocus()) {
                        dYq().clearFocus();
                        this.nmc.requestFocus();
                        if (this.fBu != null) {
                            this.fBu.bzD();
                        }
                        ShowSoftKeyPadDelay(this.nmc);
                        return;
                    }
                    dYq().requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.ojD);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.ojY.UV(postWriteCallBackData.getErrorString());
                        this.ojY.bg(postWriteCallBackData.getSensitiveWords());
                        this.ojY.b(this.nmc, this.ojD);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fDF = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fDF);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dZe();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.ojx)) {
                        dYr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ojx)) {
                        dYq().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYx() {
        if ("1".equals(this.jMP)) {
            this.nlK.setCanNoForum(true);
            this.nlK.setTransmitForumData("[]");
        } else if ("2".equals(this.jMP)) {
            this.nlK.setCanNoForum(false);
        }
        dYy();
        this.nlK.setPrivacy(this.isPrivacy);
        dZc();
        this.nlK.setToDynamic(this.isToDynamic);
        this.nlK.setCallFrom(this.jMP);
        if (this.nlK.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cGR();
    }

    private void dYy() {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dZc() {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dZd() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dZe() {
        if (this.ojT) {
            this.okE.b(this.writeImagesInfo);
            dZf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZf() {
        this.okE.notifyDataSetChanged();
        this.okD.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.okE.notifyDataSetChanged();
                WriteActivity.this.okD.invalidateViews();
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
        dJR();
    }

    private void ao(Intent intent) {
        if (this.ojT) {
            ap(intent);
            dZe();
        } else {
            as(intent);
        }
        dJR();
    }

    private void ap(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dZe();
            zL(true);
        }
    }

    private void aq(Intent intent) {
        if (this.writeImagesInfo != null) {
            F(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dZg() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ar(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.okB.parseJson(stringExtra);
            this.okB.updateQuality();
            if (this.okB.getChosedFiles() != null && this.okB.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.okB.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.okB.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dYr());
        HidenSoftKeyPad(this.mInputManager, dYq());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.olg != null) {
            this.olg.onPause();
        }
        if (this.fBu.bBl()) {
            this.fBu.bzD();
        }
    }

    private void as(Intent intent) {
        e(intent, true);
    }

    private void F(Intent intent) {
        this.fDF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fDF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fDF, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dZh();
            dYz();
        }
        zL(true);
    }

    private void G(Intent intent) {
        e(intent, false);
    }

    private void e(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dZh();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dYz();
                }
            }
            zL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZh() {
        if (this.fBu.qU(10) != null) {
            this.fBu.setToolEnabled(this.writeImagesInfo == null || com.baidu.tbadk.core.util.y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bBX() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                o.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fDF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dZi() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.jec)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.jec, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.53
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
                            WriteActivity.this.zL(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(boolean z) {
        String forumId = this.nlK == null ? "" : this.nlK.getForumId();
        if (this.okC != null) {
            this.okC.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cCU() {
        this.jgg = getVoiceManager();
        this.jgg.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jhC) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.nlK.getType() != 7) {
                if (this.ojI == null) {
                    com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                Q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fDM = i;
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dYz() {
        if (!this.ojT) {
            if (this.fBu != null) {
                this.fBu.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fBu.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.nlK == null ? "" : this.nlK.getForumId();
            if (this.okC != null) {
                this.okC.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Lz(int i) {
        if (i < this.ojG.size()) {
            for (int i2 = 0; i2 < this.ojG.size(); i2++) {
                this.ojG.get(i2).zz(false);
            }
            this.ojG.get(i).zz(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Ji(int i) {
        if (i == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").ap("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").ap("obj_type", 2));
        }
        this.nlL = i;
        this.nmi.setCurrentIndex(i);
        Lz(i);
        this.nmh.setText(this.mPrefixData.getPrefixs().get(i));
        dJR();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmi, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nmk.setSelected(false);
        SvgManager.bsR().a(this.nmj, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.ojD);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes8.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.nlK != null) {
            if (this.nlK.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nlK.getType() == 5) {
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
            bBR();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fDF);
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
        this.brf = z;
        if (this.okV && System.currentTimeMillis() - this.okW < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.okV = false;
        }
        if (this.ojX != null && !z) {
            this.ojX.cws();
        }
        if (this.ojZ != null && !z) {
            dYb();
        }
        if (this.ola != null && !z) {
            dYH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.okS != null) {
            Vo(str);
            this.okS.dismiss();
        }
    }

    private void hg(Context context) {
        okU = l.getEquipmentHeight(context);
    }

    private void Vo(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.okV = true;
        dZh();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dYz();
        }
        zL(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5677=4] */
    private static Bitmap h(String str, float f) {
        Throwable th;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap2 = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap2 = null;
            } catch (Throwable th2) {
                th = th2;
                bitmap = null;
            }
            try {
                bitmap3 = BitmapHelper.getResizedBitmap(bitmap2, i);
                if (bitmap2 != null && bitmap2 != bitmap3 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap2 != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                System.gc();
                return bitmap3;
            } catch (Throwable th3) {
                th = th3;
                bitmap = bitmap2;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap3;
    }

    private File dZj() {
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
                if ((currentTimeMillis - file.lastModified()) / AppStatusRules.DEFAULT_GRANULARITY > 1) {
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

    private void dZk() {
        if (this.okP != null && this.nlK.getType() == 0 && this.nlK.getType() == 9 && this.nlK.getType() == 11) {
            hg(getActivity());
            this.okR = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.okR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.okP != null) {
                        WriteActivity.this.Vn(WriteActivity.this.okP.getAbsolutePath());
                    }
                }
            });
            this.okQ = (TbImageView) this.okR.findViewById(R.id.rec_img_view);
            this.okT = (LinearLayout) this.okR.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.okP.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.okP.getAbsolutePath());
                Bitmap h = h(this.okP.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.okQ.setImageBitmap(h);
                    this.okQ.setDrawBorder(true);
                    this.okQ.setBorderWidth(2);
                    this.okQ.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.okS = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.okS.setCanceledOnTouchOutside(true);
                    this.okS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.okV) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.okW = System.currentTimeMillis();
                            }
                        }
                    });
                    this.okS.setContentView(this.okR);
                    this.okS.show();
                    Window window = this.okS.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (okU / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.brf && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ojy = false;
            this.ojx = "";
            if ("from_content".equals(str)) {
                this.ojx = "from_content";
            } else if ("from_title".equals(str)) {
                this.ojx = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Dz(String.valueOf(charSequence.charAt(i)))) {
                zH(false);
            }
        }
    }

    public void dDU() {
        if (this.isEvaluate) {
            this.ojC.setVisibility(8);
            if (this.olE != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.olE.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.olE.setLayoutParams(layoutParams);
            }
            this.oks.setVisibility(8);
        } else if (com.baidu.tieba.write.b.b.dXq()) {
            this.nmc.setHint(R.string.title_hint_for_hot);
            this.ojC.setVisibility(0);
            if (this.olE != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.olE.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.olE.setLayoutParams(layoutParams2);
            }
            this.oks.setVisibility(0);
            com.baidu.tieba.write.b.b.a(this.okq);
            this.ojC.requestFocus();
        } else {
            this.okq.setVisibility(8);
            this.nmc.setHint(this.okn ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.okn || !com.baidu.tbadk.core.util.y.isEmpty(this.mList) || (this.nlK != null && !StringUtils.isNull(this.nlK.getTitle()))) {
                this.ojC.setVisibility(0);
                if (this.olE != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.olE.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.olE.setLayoutParams(layoutParams3);
                }
                this.oks.setVisibility(0);
                this.ojC.requestFocus();
                return;
            }
            this.ojC.setVisibility(8);
            if (this.olE != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.olE.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.olE.setLayoutParams(layoutParams4);
            }
            this.oks.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZl() {
        if (this.fBu != null) {
            this.fBu.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fBu != null && WriteActivity.this.fBu.fBx != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bsV().l(clipBoardContent)) {
                            WriteActivity.this.ojX.dwA();
                            return;
                        }
                        if (WriteActivity.this.ois == null) {
                            WriteActivity.this.ois = new WriteTipBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.olD);
                        }
                        WriteActivity.this.ois.a(WriteActivity.this.fBu.fBx.qS(31), WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jMP;
    }

    public WriteData dav() {
        return this.nlK;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.oeh;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dZm() {
        return (this.olh == null || this.oli == null || this.olh.getWriteVoteData() == null || this.oli.getVisibility() != 0) ? false : true;
    }

    public void dWx() {
        if (!dZq()) {
            BdToast.b(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else if (!this.canGoods) {
            BdToast.b(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else {
            if (this.nlK != null) {
                TiebaStatic.log(new ar("c13897").ap("obj_locate", 2).dR("fid", this.nlK.getForumId()).dR("fname", this.nlK.getForumName()));
            }
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nA(2);
                aVar.jG(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new ar("c13959").ap("obj_locate", 2).dR("fid", WriteActivity.this.nlK != null ? WriteActivity.this.nlK.getForumId() : "").dR("fname", WriteActivity.this.nlK != null ? WriteActivity.this.nlK.getForumName() : ""));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dZn()));
                        }
                    }
                });
                aVar.bn(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new ar("c13958").ap("obj_locate", 2).dR("fid", this.nlK != null ? this.nlK.getForumId() : "").dR("fname", this.nlK != null ? this.nlK.getForumName() : ""));
                aVar.b(getPageContext()).bqx();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dZn()));
        }
    }

    public void Kx() {
        if (this.ols != null && this.ols.dXM() == null && this.ojD != null && this.ojD.getSpanGroupManager() != null) {
            this.ols.h(this.ojD.getSpanGroupManager().bvl());
            this.ols.refreshData();
        } else if (this.ols != null && this.ols.dXM() != null) {
            this.ols.refreshData();
        }
        if (this.ols != null) {
            gk(this.ols.dXL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(List<v> list) {
        boolean z;
        if (list != null) {
            Iterator<v> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().mType == 2) {
                    z = true;
                    break;
                }
            }
            if (!z && this.olt != null) {
                this.olt.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp(String str) {
        this.olw = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.olw.add(com.baidu.tieba.j.a.es(jSONObject));
                }
                if (this.olw.size() > 0) {
                    this.olz = true;
                    this.ojD.n(this.olw, arrayList);
                    dYP();
                    Kx();
                    this.olt.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZn() {
        if (this.ojD == null || this.ojD.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.ojD.getSpanGroupManager().bvm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZo() {
        return this.canGoods || this.ojD == null || this.ojD.getSpanGroupManager() == null || this.ojD.getSpanGroupManager().bvm() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZp() {
        boolean z = this.ols == null || this.ols.dXN();
        boolean z2 = (this.oka == null || this.oka.getSelectedTabItemData() == null || this.oka.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZq() {
        if (this.oeh == null || com.baidu.tbadk.core.util.y.isEmpty(this.oeh.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.oeh.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dZr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.59
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).zn(false).UN(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aR((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cGQ() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.old != null) {
            i = this.old.getStarCount();
        }
        arrayList.add(new com.baidu.tbadk.coreExtra.data.v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
