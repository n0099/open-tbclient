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
    private static int olu = 0;
    private EditorTools fBu;
    private String fDF;
    private LocationModel fDG;
    List<ab> gNf;
    private boolean isEvaluate;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private String jep;
    private String jeq;
    private String jer;
    private VoiceManager jgu;
    private com.baidu.tbadk.core.dialog.i jtL;
    private SaveDraftDialogView jtM;
    private boolean jtV;
    private LinearLayout lTO;
    private PlayVoiceBntNew lTP;
    private ImageView lTR;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private TextView nmH;
    private com.baidu.tieba.write.i nmI;
    private ImageView nmJ;
    private View nmK;
    private int nml;
    private FrsTabInfoData oeH;
    private WriteTipBubbleController oiS;
    private ForumTabSelectedView okA;
    private com.baidu.tieba.view.b okH;
    private TitleTipView okQ;
    private View okS;
    private View okU;
    private LinearLayout okb;
    private LinearLayout okc;
    private View okf;
    private Toast okh;
    private AdditionData oki;
    private RelativeLayout okj;
    private TextView okk;
    private TextView okl;
    private TextView okm;
    ab okn;
    private String okp;
    private PostCategoryView okr;
    private HotTopicBussinessData oku;
    private TextView okv;
    private com.baidu.tieba.write.editor.b okx;
    private g okz;
    private b olA;
    private ForumSelectedView olB;
    private com.baidu.tbadk.data.j olC;
    private WriteEvaluationHeaderView olD;
    private TextView olE;
    private View olF;
    private com.baidu.tieba.write.write.video.a olG;
    private com.baidu.tieba.write.write.vote.a olH;
    private RelativeLayout olI;
    private SerializableItemInfo olJ;
    private boolean olK;
    private int olL;
    private Serializable olP;
    private String olQ;
    private d olS;
    private LinearLayout olT;
    private ImageView olU;
    private TextView olV;
    private List<com.baidu.tieba.j.a> olW;
    private EBusinessProtocolView olX;
    private com.baidu.tieba.tbadkCore.writeModel.a ola;
    private i olc;
    private com.baidu.tieba.c.e olz;
    private WriteImageGridView ome;
    private com.baidu.tbadk.editortools.c.a omf;
    private int privateThread;
    private String ojX = "";
    private boolean ojY = false;
    protected WriteData nmk = null;
    private boolean okN = false;
    private boolean okO = false;
    private boolean oka = false;
    private boolean okP = false;
    private InputMethodManager mInputManager = null;
    private EditText nmC = null;
    private HeadImageView okR = null;
    private View nmD = null;
    private LinearLayout nmF = null;
    private SpanGroupEditText okd = null;
    private FeedBackModel oke = null;
    private FeedBackTopListView okT = null;
    private ArrayList<WritePrefixItemLayout> okg = new ArrayList<>();
    private String llE = null;
    private final KeyEvent iSz = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView okV = null;
    private TextView lUF = null;
    private TextView mName = null;
    private ImageView okW = null;
    private final Handler mHandler = new Handler();
    private boolean okX = false;
    private String okY = null;
    private RelativeLayout lxr = null;
    public boolean okZ = true;
    public String fDL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fDM = 0;
    private int oko = -1;
    private int okq = -1;
    private WriteImagesInfo olb = new WriteImagesInfo();
    private View mRootView = null;
    private GridView old = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a ole = null;
    private ScrollView oks = null;
    private EditText olf = null;
    private View olg = null;
    private View olh = null;
    private View oli = null;
    private EditText olj = null;
    private TextView olk = null;
    private TextView oll = null;
    private TextWatcher olm = null;
    private TextWatcher oln = null;
    private boolean okt = false;
    private boolean olo = false;
    private com.baidu.tbadk.core.view.a fMe = null;
    private String mFrom = "write";
    private File olp = null;
    private TbImageView olq = null;
    private View olr = null;
    private Dialog ols = null;
    private LinearLayout olt = null;
    private boolean olv = false;
    private long olw = -1000;
    private boolean olx = false;
    private String jNd = "2";
    private int bLf = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder okw = new SpannableStringBuilder();
    private boolean oly = false;
    private boolean brf = false;
    private final c oky = new c();
    private boolean olM = true;
    private boolean olN = false;
    private String olO = null;
    private final d.a olR = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Ly(int i) {
            if (WriteActivity.this.okd != null) {
                WriteActivity.this.okd.pY(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gj(List<v> list) {
            WriteActivity.this.gk(list);
        }
    };
    private boolean olY = false;
    private boolean olZ = false;
    private final HttpMessageListener oma = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.llE)) {
                    WriteActivity.this.llE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zK(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.llE)) {
                    WriteActivity.this.llE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.llE);
                    WriteActivity.this.zK(true);
                }
            }
        }
    };
    private CustomMessageListener omb = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.nmk != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").ap("obj_locate", 1).dR("fid", WriteActivity.this.nmk.getForumId()).dR("fname", WriteActivity.this.nmk.getForumName()));
            }
        }
    };
    private final CustomMessageListener omc = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (WriteActivity.this.olB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.forumId) && !StringUtils.isNull(jVar.forumName)) {
                WriteActivity.this.a(jVar);
            }
        }
    };
    private TbFaceManager.a okB = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dg(String str) {
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
    private final AntiHelper.a jhQ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private WriteTipBubbleController.a omd = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (WriteActivity.this.oiS != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.oiS.Xj();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cDb();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.omh = true;
            if (postWriteCallBackData != null && WriteActivity.this.nmk != null) {
                WriteActivity.this.oky.bg(null);
                if (z) {
                    WriteActivity.this.kZ(z);
                    if (WriteActivity.this.h(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.b.b.g(WriteActivity.this.nmk);
                    WriteActivity.this.cGV();
                    WriteActivity.this.dPk();
                    if ((WriteActivity.this.nmk.getType() == 0 || WriteActivity.this.nmk.getType() == 9 || WriteActivity.this.nmk.getType() == 11) && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.nmk.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.nmk.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.nmk.getForumName())) {
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
                    WriteActivity.this.oky.bg(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.oky.Vh(postWriteCallBackData.getErrorString());
                    WriteActivity.this.oky.b(WriteActivity.this.nmC, WriteActivity.this.okd);
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
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE());
                        if (WriteActivity.this.okP) {
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
    private final CustomMessageListener nzK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fDG.yC(false);
                    WriteActivity.this.fDG.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fDG.yC(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener okC = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dZt();
            }
        }
    };
    private CustomMessageListener omg = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener okD = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dYg = WriteActivity.this.dYg();
            if (dYg >= 0 && dYg < WriteActivity.this.okd.getText().length()) {
                WriteActivity.this.okd.setSelection(dYg);
            }
        }
    };
    private boolean okE = true;
    private final View.OnFocusChangeListener hxs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.nmC || view == WriteActivity.this.mBack || view == WriteActivity.this.lUF) {
                if (z) {
                    WriteActivity.this.okE = true;
                    WriteActivity.this.dYh();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nmC);
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                } else if (view == WriteActivity.this.nmC) {
                    WriteActivity.this.nmH.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.okd && z) {
                WriteActivity.this.okE = false;
                WriteActivity.this.dYh();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.okd);
                if (WriteActivity.this.fBu != null) {
                    WriteActivity.this.fBu.bzD();
                }
            }
            WriteActivity.this.dYm();
        }
    };
    private com.baidu.tbadk.mutiprocess.h jfA = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.VB(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean omh = false;
    private TextWatcher okF = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String okJ = "";
        private String okK;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okK = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okK != null ? this.okK.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dJZ();
            WriteActivity.this.dYn();
            EditText dYz = WriteActivity.this.dYz();
            if (editable != null && dYz != null && dYz.getText() != null) {
                if (this.okJ == null || !this.okJ.equals(editable.toString())) {
                    if (WriteActivity.this.oky != null) {
                        this.okJ = dYz.getText().toString();
                        WriteActivity.this.oky.b(dYz, true);
                        return;
                    }
                    return;
                }
                dYz.setSelection(dYz.getSelectionEnd());
            }
        }
    };
    private TextWatcher okG = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String okK;
        private String okL = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okK = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okK != null ? this.okK.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dJZ();
            EditText dYy = WriteActivity.this.dYy();
            if (editable != null && dYy != null && dYy.getText() != null) {
                if (this.okL == null || !this.okL.equals(editable.toString())) {
                    if (WriteActivity.this.oky != null) {
                        this.okL = dYy.getText().toString();
                        WriteActivity.this.oky.b(dYy, false);
                    }
                    if (WriteActivity.this.isEvaluate) {
                        WriteActivity.this.e(editable);
                        return;
                    }
                    return;
                }
                dYy.setSelection(dYy.getSelectionEnd());
            }
        }
    };
    private int omi = 0;
    private final a.InterfaceC0872a maT = new a.InterfaceC0872a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0872a
        public void onRefresh() {
            WriteActivity.this.llE = null;
            WriteActivity.this.zK(false);
            WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };
    private final Runnable omj = new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.olN) {
                WriteActivity.this.fDW.callback(false, com.baidu.tieba.tbadkCore.writeModel.c.nBj, com.baidu.tieba.tbadkCore.writeModel.c.nBk, com.baidu.tieba.tbadkCore.writeModel.c.nBl, com.baidu.tieba.tbadkCore.writeModel.c.antiData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null) {
            this.olC = jVar;
            if (this.nmk != null) {
                this.nmk.setForumId(this.olC.forumId);
                this.nmk.setForumName(this.olC.forumName);
            }
            this.olB.setSelectedForum(this.olC.forumName);
            this.oeH = null;
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.olC.tabInfoList)) {
                this.oeH = new FrsTabInfoData();
                this.oeH.selectedTabId = -1;
                this.oeH.tabList = this.olC.tabInfoList;
                if (this.olC.isForumBusinessAccount && this.oeH.tabList != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    this.oeH.tabList.add(0, frsTabItemData);
                }
                this.oeH.isForumBusinessAccount = this.olC.isForumBusinessAccount;
            }
            this.okA.setData(this.oeH);
            if (this.nmk != null) {
                this.nmk.setFrsTabInfoData(this.oeH);
            }
            if (this.okA.getVisibility() == 0) {
                this.olF.setVisibility(0);
            }
            this.mPrefixData = null;
            if (this.olC.fAj != null && !com.baidu.tbadk.core.util.y.isEmpty(this.olC.fAj.getPrefixs())) {
                this.mPrefixData = this.olC.fAj;
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
            }
            dZb();
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
        this.olD.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.nmk.setItemInfo(tbRichTextEvaluateItemInfo);
        this.olD.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bBR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG.dOx()) {
            bBP();
        } else {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOv();
        }
    }

    public void dYJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.okx != null) {
                this.okx.dXp();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG != null) {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOv();
        }
    }

    private void bBT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nx(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.fDG.dOz();
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
    public int dYg() {
        int selectionEnd = dYy().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dYy().getText().getSpans(0, dYy().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dYy().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dYy().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYh() {
        if (this.fBu != null) {
            if (this.olG != null && this.olG.isVisible()) {
                this.fBu.setBarLauncherEnabled(!this.okE);
                this.fBu.setDeskLauncherEnabled(!this.okE);
                this.fBu.setToolEnabled(true, 2);
                this.fBu.setToolEnabled(true, 32);
                this.fBu.setToolEnabled(false, 10);
                this.fBu.setToolEnabled(false, 6);
                this.fBu.setToolEnabled(false, 18);
                this.fBu.qU(5).kR(false);
                if (this.okx != null) {
                    this.okx.zF(true);
                }
            } else {
                this.fBu.setBarLauncherEnabled(!this.okE);
                this.fBu.setDeskLauncherEnabled(!this.okE);
                this.fBu.setToolEnabled(true, 26);
                this.fBu.setToolEnabled(true, 2);
                this.fBu.setToolEnabled(true, 30);
                this.fBu.qU(5).kR(true);
                if (this.okx != null) {
                    this.okx.zF(true);
                }
                dZp();
            }
            if (this.isEvaluate && this.omf != null && !this.omf.isEnable()) {
                this.fBu.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.okt) {
            this.nmC.setVisibility(8);
            if (this.nmk.getType() == 5) {
                this.oli.setVisibility(8);
            } else {
                this.oli.setVisibility(0);
            }
            a(this.oll, this.olf);
            a(this.olk, this.olj);
            dJZ();
        }
        if (this.okN) {
            this.okE = true;
            dYh();
            if (this.fBu != null) {
                this.fBu.bzD();
            }
            this.nmC.requestFocus();
            ShowSoftKeyPadDelay(this.nmC);
        }
        if (this.olG != null) {
            this.olG.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.olG != null) {
            this.olG.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.olG != null) {
            this.olG.onStop();
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
                    dYH();
                }
                zL(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nmk.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.nmk.setVideoInfo(null);
            }
            if (this.olG == null) {
                this.olG = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.nmk.getVideoInfo() != null && this.nmk.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.olG.dZY();
                return;
            }
            aD(true, false);
        }
    }

    public void Em(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aD(boolean z, boolean z2) {
        if (z) {
            this.nmk.setVideoInfo(null);
            this.olG.a(null, z2);
            this.olc.XO().setVisibility(0);
            zK(false);
        } else {
            this.olG.a(this.nmk.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.olc.XO().setVisibility(8);
            dZd();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dJZ();
        dYh();
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
        if (this.nmk.getType() == 0) {
            LB(this.bLf);
        }
        initUI();
        dZc();
        this.fDG = new LocationModel(getPageContext());
        this.fDG.a(this.fDU);
        dZz();
        dae();
        dZs();
        if (this.okt) {
            this.ole.setEditorTools(this.fBu);
        } else {
            this.okd.requestFocus();
        }
        dEc();
        dYH();
        dZq();
        this.jfA.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.jfA);
        dYK();
        if (this.olN) {
            k(this.nmk);
            dJZ();
            dZh();
        }
    }

    private void initListener() {
        registerListener(this.oma);
        registerListener(this.omb);
        registerListener(this.omc);
        registerListener(this.nzK);
        registerListener(this.okC);
        registerListener(this.mBackgroundListener);
        registerListener(this.omg);
    }

    private void dYK() {
        VB(this.olO);
    }

    @SuppressLint({"ResourceAsColor"})
    private void dae() {
        this.fBu = new EditorTools(getActivity());
        this.fBu.setBarMaxLauCount(5);
        this.fBu.setMoreButtonAtEnd(true);
        this.fBu.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fBu.setBarLauncherType(1);
        this.fBu.kN(true);
        this.fBu.kO(false);
        switch (this.nmk.getType()) {
            case 4:
            case 5:
                dYN();
                break;
            default:
                dYi();
                break;
        }
        this.fBu.build();
        if (this.okb != null) {
            this.okb.addView(this.fBu);
        }
        cZE();
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
        if (!this.okt) {
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
            dYO();
            return;
        }
        dYk();
        dZt();
    }

    private void dYL() {
        this.olg = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.oli = this.olg.findViewById(R.id.live_post_title_container);
        this.olf = (EditText) this.olg.findViewById(R.id.live_post_content);
        this.old = (GridView) this.olg.findViewById(R.id.photoLiveGridView);
        this.olj = (EditText) this.olg.findViewById(R.id.live_post_title);
        this.olk = (TextView) this.olg.findViewById(R.id.titleOverPlusNumber);
        this.oll = (TextView) this.olg.findViewById(R.id.contentOverPlusNumber);
        this.olh = this.olg.findViewById(R.id.live_interval_view);
        this.olk.setText(String.valueOf(20));
        this.oll.setText(String.valueOf(233));
        this.olg.setVisibility(0);
        this.olk.setVisibility(0);
        this.oll.setVisibility(0);
        this.olj.setHint(R.string.tips_title_limit_new);
        this.olj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.olo = true;
                    WriteActivity.this.okE = true;
                    WriteActivity.this.dYh();
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                }
            }
        });
        if (this.nmk.getType() == 4) {
            this.olf.setHint(R.string.live_write_input_content_new);
        } else if (this.nmk.getType() == 5) {
            this.olf.setHint(R.string.live_write_input_content_update);
        }
        this.olf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.olo = false;
                    WriteActivity.this.okE = false;
                    WriteActivity.this.dYh();
                    if (WriteActivity.this.fBu != null) {
                        WriteActivity.this.fBu.bzD();
                    }
                }
            }
        });
        this.olf.requestFocus();
        this.olf.addTextChangedListener(awL());
        this.olj.requestFocus();
        this.olj.addTextChangedListener(awL());
        this.olj.setOnClickListener(this.okD);
        this.olf.setOnClickListener(this.okD);
        this.ole = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.old);
        this.ole.Lt(6);
        this.old.setAdapter((ListAdapter) this.ole);
        View findViewById = this.olg.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dXJ() {
                WriteActivity.this.dZn();
            }
        });
        dYM();
    }

    private void dYM() {
        if (this.nmk.getType() == 0) {
            if (this.nmk.getTitle() != null) {
                this.olj.setText(this.nmk.getTitle());
                this.olj.setSelection(this.nmk.getTitle().length());
                return;
            }
            return;
        }
        if (this.nmk.getType() == 1 || this.nmk.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.okt) {
            dZl();
        }
        if (this.fBu.bBl()) {
            this.fBu.bzD();
        }
        LB(0);
    }

    public boolean dXa() {
        return !"1".equals(this.jNd) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private void LB(int i) {
        if (this.writeImagesInfo != null && this.nmk != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.nmk.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.nmk.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dXa());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jNd);
            albumFloatActivityConfig.setStatisticFrom(this.nmk.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(this.nmk.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.oeH);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fDL;
            antiData.setIfVoice(this.okZ);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.nmk.getFirstDir(), this.nmk.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dYN() {
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

    private void dYi() {
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
        Boolean dZg = dZg();
        if (!this.okN && dZg != null && dZg.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dPb() && u.d(this.nmk.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), m.class)) != null && (mVar4 = (m) runTask.getData()) != null) {
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
        if (!com.baidu.tieba.write.b.b.dXy() && !this.isEvaluate) {
            this.fBu.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        this.fBu.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        if (au.equals(this.jNd, "2")) {
            this.omf = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.isEvaluate) {
                this.omf.kS(false);
                this.omf.setEnable(false);
            }
            this.fBu.b(this.omf);
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
        if (this.oki == null) {
            if (this.okx == null) {
                this.okx = new com.baidu.tieba.write.editor.b(getActivity(), this.jNd);
                this.okx.Ln(0);
                this.okx.zE(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.okx.dXn();
                this.okx.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dYJ();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                this.okx.dXn();
            }
            this.fBu.b(this.okx);
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

    private void dYj() {
        if (this.okz != null) {
            this.okz.hideTip();
        }
    }

    private void dYO() {
        if (this.fBu != null) {
            this.fBu.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fBu != null && WriteActivity.this.fBu.fBx != null) {
                        if (WriteActivity.this.olA == null) {
                            WriteActivity.this.olA = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.olA.showTip(WriteActivity.this.fBu.fBx.qS(2));
                    }
                }
            });
        }
    }

    private void dYP() {
        if (this.olA != null) {
            this.olA.hideTip();
        }
    }

    private void dYk() {
        if (this.okz == null) {
            this.okz = new g(getPageContext());
        }
        this.okz.d(this.fBu);
    }

    private void cZE() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 9));
                        if (WriteActivity.this.dYx()) {
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
                                    WriteActivity.this.dJZ();
                                }
                            } else if (WriteActivity.this.dYx()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dYA();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dop();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dZp();
                        WriteActivity.this.dJZ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.LC(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.oki == null) {
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
                            WriteActivity.this.llE = null;
                        } else {
                            WriteActivity.this.llE = (String) aVar.data;
                        }
                        WriteActivity.this.zK(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dR("fid", WriteActivity.this.nmk != null ? WriteActivity.this.nmk.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.nmk == null || (videoInfo = WriteActivity.this.nmk.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
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
                        WriteActivity.this.nmk.setVideoInfo(null);
                        WriteActivity.this.dJZ();
                        if (WriteActivity.this.okd != null) {
                            WriteActivity.this.okd.requestFocus();
                        }
                        WriteActivity.this.fBu.bzD();
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.okd);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.ojY = true;
                        WriteActivity.this.zH(true);
                        if (!WriteActivity.this.dYz().isFocused() || WriteActivity.this.okc.getVisibility() != 0) {
                            WriteActivity.this.ojX = "from_content";
                        } else {
                            WriteActivity.this.ojX = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 8));
                        if (WriteActivity.this.okc.getVisibility() == 0) {
                            if (WriteActivity.this.okc.hasFocus()) {
                                WriteActivity.this.okd.requestFocus();
                                WriteActivity.this.okd.setSelection(WriteActivity.this.okd.getText().toString().length());
                            }
                            WriteActivity.this.okc.setVisibility(8);
                            if (WriteActivity.this.ome != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.ome.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.ome.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.okS.setVisibility(8);
                            WriteActivity.this.fBu.qR(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.okc.setVisibility(0);
                            if (WriteActivity.this.ome != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.ome.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.ome.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.okS.setVisibility(0);
                            WriteActivity.this.okc.requestFocus();
                            WriteActivity.this.fBu.qR(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dJZ();
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
                        if (WriteActivity.this.olH != null && WriteActivity.this.olH.getWriteVoteData() != null) {
                            writeVoteData = WriteActivity.this.olH.getWriteVoteData();
                        }
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ar("c13800").ap("obj_source", 2));
                        WriteActivity.this.dYQ();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.oiS != null) {
                            WriteActivity.this.oiS.Xj();
                        }
                        TiebaStatic.log(new ar("c12612").ap("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dWF();
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
    public void dYQ() {
        if (this.okW != null) {
            this.okW.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.omi;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void dYR() {
        final WriteVoteData writeVoteData;
        if (this.olP instanceof WriteVoteData) {
            writeVoteData = (WriteVoteData) this.olP;
            this.nmk.setWriteVoteData(writeVoteData);
        } else if (this.nmk.getWriteVoteData() != null) {
            writeVoteData = this.nmk.getWriteVoteData();
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
        this.olH.ap(onClickListener);
        this.olH.setOnItemClickListener(onClickListener);
        this.olH.b(writeVoteData);
        this.olH.zN(true);
        dJZ();
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
    public void LC(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (this.fDG.clH()) {
            if (this.fDG.dOx()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fDG.dOv();
            return;
        }
        b(0, true, null);
    }

    protected void zJ(boolean z) {
        if (!z && this.ola != null) {
            this.ola.cFE();
        }
        if (this.oke != null) {
            this.oke.cancelLoadData();
        }
        if (this.fDG != null) {
            this.fDG.cancelLoadData();
        }
        if (this.olG != null) {
            this.olG.onDestroy();
        }
    }

    protected void dJR() {
        zJ(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.omj);
        if (this.ola != null) {
            this.ola.dPe();
        }
        dYj();
        dYP();
        TiebaPrepareImageService.StopService();
        zJ(true);
        if (!this.omh) {
            dYS();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jtL, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.olc != null) {
            this.olc.destroy();
        }
        if (this.olz != null) {
            this.olz.Tz();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYS() {
        if (this.nmk != null && this.nmk.getType() == 2 && this.okX) {
            finish();
        } else if (this.nmk == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.nmk.setTitle(dYz().getText().toString());
            this.nmk.setContent(dYy().getText().toString());
            if (this.olD != null) {
                this.nmk.setEvaluationStar(this.olD.getStarCount());
            }
            int type = this.nmk.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.olM) {
                    if (this.nmk.isEvaluate()) {
                        y.d(this.nmk.getItem_id(), this.nmk);
                    } else if (TextUtils.isEmpty(this.nmk.getTopicId())) {
                        y.c(this.nmk.getForumId(), this.nmk);
                    } else {
                        y.e(this.nmk.getTopicId(), this.nmk);
                    }
                }
            } else if (type == 7) {
                if (this.olM) {
                    y.c("24591571", this.nmk);
                }
            } else if (type == 1) {
                y.b(this.nmk.getThreadId(), this.nmk);
            } else if (type == 4) {
                y.c(this.nmk.getForumId() + "photolive", this.nmk);
            } else if (type == 5) {
                y.b(this.nmk.getThreadId() + "updatephotolive", this.nmk);
            }
            this.omh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHC() {
        if (this.lUF == null || ((!this.lUF.isEnabled() && !this.isEvaluate) || ((this.isEvaluate && TextUtils.isEmpty(this.okd.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.olG == null || !this.olG.isVisible()))) || !this.olM))) {
            cGV();
            dPk();
            setResult(100);
            finish();
            return;
        }
        if (this.jtM == null) {
            this.jtM = new SaveDraftDialogView(this);
            this.jtM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cGV();
                            WriteActivity.this.dPk();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dYS();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jtL.dismiss();
                    }
                }
            });
        }
        if (this.jtL == null) {
            this.jtL = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jtL.setContentView(this.jtM);
        }
        boolean z = (this.olG == null || !this.olG.isVisible() || this.nmk == null || this.nmk.getVideoInfo() == null || this.nmk.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jtM.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jtL.QE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGV() {
        if (this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 11) {
            if (this.olM) {
                if (this.nmk.isEvaluate()) {
                    y.d(this.nmk.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(this.nmk.getTopicId())) {
                    y.a(this.nmk.getForumId(), this.nmk, true);
                } else {
                    y.e(this.nmk.getTopicId(), (WriteData) null);
                }
            }
        } else if (this.nmk.getType() == 1) {
            y.b(this.nmk.getThreadId(), (WriteData) null);
        }
        this.omh = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPk() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nKM));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nmI != null && this.nmI.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmI, getPageContext().getPageActivity());
                return true;
            } else if (this.fBu.bBl()) {
                this.fBu.bzD();
                return true;
            } else {
                dJR();
                cHC();
                return true;
            }
        }
        if (i == 67 && (text = dYy().getText()) != null) {
            int selectionStart = dYy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dYy().onKeyDown(67, this.iSz);
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
        getLayoutMode().onModeChanged(this.lxr);
        getLayoutMode().onModeChanged(this.olt);
        ap.setBackgroundColor(this.lxr, R.color.CAM_X0205);
        if (this.olq != null && (i == 1 || i == 4)) {
            this.olq.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lUF.setTextColor(ap.aM(R.color.CAM_X0302, i));
        dYh();
        ap.setBackgroundColor(this.nmD, R.color.CAM_X0204);
        ap.setBackgroundColor(this.olh, R.color.CAM_X0204);
        ap.setBackgroundColor(dYz(), R.color.CAM_X0205);
        this.lTR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.llE)) {
            ap.setBackgroundColor(dYy(), R.color.CAM_X0205);
        }
        dJZ();
        this.fBu.onChangeSkinType(i);
        if (this.okr != null) {
            this.okr.bup();
        }
        if (this.olS != null) {
            this.olS.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.olc.omH.notifyDataSetChanged();
        dYm();
        dYn();
        zK(false);
        if (this.oky != null) {
            this.oky.c(dYz(), dYy());
        }
        if (this.olB != null) {
            this.olB.onChangeSkinType();
        }
        if (this.olD != null) {
            this.olD.onChangeSkinType();
        }
        if (this.okA != null) {
            this.okA.onChangeSkinType(i);
        }
        if (this.olG != null) {
            this.olG.buo();
        }
        if (this.olH != null) {
            this.olH.onChangeSkinType(i);
        }
        if (this.olX != null) {
            this.olX.onChangeSkinType(i);
        }
        if (this.okQ != null) {
            this.okQ.onChangeSkinType(i);
        }
        if (this.olE != null) {
            ap.setViewTextColor(this.olE, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYm() {
        if (this.nmC.hasFocus()) {
            this.nmC.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nmC.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.okd.hasFocus()) {
            this.okd.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.okd.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYn() {
        if (this.nmC != null && this.nmC.getText() != null && this.nmC.getText().toString() != null && this.nmC.getPaint() != null) {
            if (this.nmC.getText().toString().length() == 0) {
                this.nmC.getPaint().setFakeBoldText(true);
            } else if (this.nmC.getText().toString().length() > 0) {
                this.nmC.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable) {
        g(editable);
        f(editable);
    }

    private void f(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.olD.dXO()) {
            this.lUF.setEnabled(true);
        } else {
            this.lUF.setEnabled(false);
        }
    }

    private void g(Editable editable) {
        if (editable.length() > 500) {
            this.olE.setText((500 - editable.length()) + "/500");
            this.olE.setVisibility(0);
            return;
        }
        this.olE.setVisibility(4);
    }

    private void initUI() {
        this.fMe = new com.baidu.tbadk.core.view.a(getPageContext());
        this.okt = this.nmk.getType() == 4 || 5 == this.nmk.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.okV = (TextView) findViewById(R.id.btn_image_problem);
        dYq();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lUF.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lUF.setLayoutParams(layoutParams);
        this.lUF.setOnFocusChangeListener(this.hxs);
        this.oks = (ScrollView) findViewById(R.id.write_scrollview);
        this.oks.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.okd != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.okd);
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
        this.okT = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.okU = findViewById(R.id.feedback_divider);
        this.lxr = (RelativeLayout) findViewById(R.id.parent);
        this.okb = (LinearLayout) findViewById(R.id.tool_view);
        this.okb.setContentDescription(IStringUtil.TOP_PATH);
        this.okc = (LinearLayout) findViewById(R.id.title_view);
        this.ome = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.okS = findViewById(R.id.title_view_divider);
        this.nmD = findViewById(R.id.interval_view);
        this.okv = (TextView) findViewById(R.id.hot_topic_title_edt);
        dJY();
        if (this.okt) {
            this.oks.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dYL();
        } else {
            this.olc = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.olc.zB(false);
            } else {
                this.olc.zB(this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 11);
            }
            this.olG = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.nmk.getVideoInfo() != null && this.nmk.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.olG.dZY();
            } else {
                aD(true, false);
            }
        }
        dKa();
        if (this.okN || this.oka) {
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
        this.nmF = (LinearLayout) findViewById(R.id.post_content_container);
        this.nmF.setDrawingCacheEnabled(false);
        this.nmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.okd.requestFocus();
            }
        });
        this.lTO = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lTP = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lTR = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dop();
            }
        });
        f(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.hxs);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dJR();
                WriteActivity.this.cHC();
            }
        });
        this.okV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dYt();
        u(dZg());
        dYv();
        dYp();
        dZe();
        dYh();
        dYu();
        dJX();
        dYB();
        if (this.nmk.getType() == 4 && this.nmK != null && this.okf != null) {
            this.nmK.setVisibility(8);
            this.okf.setVisibility(8);
        }
        dJZ();
        dZa();
        dYZ();
        dYT();
        dYo();
        dYU();
        dYV();
        dZf();
        dYW();
        bSf();
    }

    private void dYT() {
        if ("main_tab".equals(this.mFrom) && !this.olN) {
            this.olB = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.olB.setVisibility(0);
        }
    }

    private void dYo() {
        if (!this.isEvaluate) {
            this.okA = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.okA.setBgColor(R.color.CAM_X0205);
            this.olF = findViewById(R.id.frs_tab__divider);
            this.okA.setData(this.oeH);
            if (this.okA.getVisibility() == 0) {
                this.olF.setVisibility(0);
            }
            this.okA.setActivity(this);
        }
    }

    private void dYU() {
        if (this.isEvaluate) {
            this.olE = (TextView) findViewById(R.id.post_content_counter);
            this.olD = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.olD.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void aq(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.okd.getText()) || WriteActivity.this.okd.getText().length() < 20 || WriteActivity.this.okd.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lUF.setEnabled(false);
                    } else {
                        WriteActivity.this.lUF.setEnabled(true);
                    }
                }
            });
            this.olD.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lUF.setEnabled(false);
                }
            });
        }
    }

    private void dYV() {
        if (this.isEvaluate) {
            this.olD.setVisibility(0);
            if (!this.jtV) {
                if (this.olK) {
                    this.olD.setShowItemInfo(false);
                }
                if (this.olJ != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.olJ.id));
                    tbRichTextEvaluateItemInfo.setTags(this.olJ.tags);
                    tbRichTextEvaluateItemInfo.setScore(this.olJ.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(F(this.olJ.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.olJ.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.olJ.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.olJ.name);
                    this.olD.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.olD.setStarCount(this.olL);
                    this.nmk.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.nmk.setEvaluationStar(this.olL);
                } else if (this.nmk.getItemInfo() != null) {
                    this.olD.setItemInfo(this.nmk.getItemInfo());
                    this.olD.setStarCount(this.nmk.getEvaluationStar());
                }
            }
        }
    }

    private int F(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void dYW() {
        this.olT = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.olU = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.olV = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.olV, R.color.CAM_X0107);
        this.olX = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
        this.olX.setTitle(getResources().getString(R.string.protocol_title));
        this.olX.Va("file:///android_asset/protocol.html");
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.olX, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.olV.setText(spannableString);
        this.olV.setMovementMethod(LinkMovementMethod.getInstance());
        this.olU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.olY) {
                    WriteActivity.this.olY = false;
                    WriteActivity.this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.olY = true;
                    WriteActivity.this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.olY) {
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
            this.olY = true;
            this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.olY = false;
            this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.olX.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.view.EBusinessProtocolView.a
            public void zo(boolean z) {
                if (z) {
                    if (!WriteActivity.this.olY) {
                        WriteActivity.this.olY = true;
                        WriteActivity.this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.olY) {
                    WriteActivity.this.olY = false;
                    WriteActivity.this.olU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void dYX() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.omi = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.okW = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.okW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.okW.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.okW.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.okW.setLayoutParams(layoutParams2);
        this.okW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dYY();
            }
        });
        this.okW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYY() {
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

    private void dYZ() {
        if (this.mName != null && this.nmk != null && this.nmk.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dYp() {
        String str;
        String str2;
        if (this.nmk != null) {
            switch (this.nmk.getType()) {
                case 0:
                case 9:
                    if (this.okN || this.oka) {
                        if (this.okP) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jNd != null && this.jNd.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.jNd != null && this.jNd.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.nmk.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.nmk.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.nmk.getForumName() + getResources().getString(R.string.bar));
                        this.nmC.setVisibility(8);
                        String str3 = this.jer + " " + this.jep;
                        if (!StringUtils.isNull(str3)) {
                            this.okd.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.nmC.setVisibility(0);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nmC.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.nmk.getFloorNum() + 1)));
                    this.olh.setVisibility(8);
                    return;
                case 7:
                    this.nmC.setVisibility(0);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.nmC.setVisibility(0);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void dYq() {
        if (this.nmk.getType() == 7) {
            this.lUF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lUF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dYr() {
        if (this.nmk != null && this.nmk.getType() == 0 && this.nmk.getType() == 9 && !this.okN && !this.oka && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dYz() != null) {
                dYz().setText(cutStringWithSuffix);
                dYz().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.nmk.setVoiceModel(voiceModel);
            this.lTO.setVisibility(0);
            this.lTP.setVoiceModel(voiceModel);
            this.lTP.ccB();
            dJZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dop() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BL(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.nmk.setVoiceModel(null);
        this.lTO.setVisibility(8);
        this.lTP.cQB();
        this.lTP.setVoiceModel(null);
        m qU = this.fBu.qU(6);
        if (qU != null && qU.fBo != null) {
            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dJZ();
    }

    private void dYs() {
        ad yX = ac.cEF().yX(1);
        if (yX != null) {
            this.gNf = yX.jkX;
            if (this.gNf != null && !this.gNf.isEmpty() && this.oko >= 0) {
                this.okn = new ab();
                this.okn.jkT = 0;
                this.okn.name = getPageContext().getResources().getString(R.string.category_auto);
                this.okq = this.okn.jkT;
                this.okp = this.okn.name;
                for (ab abVar : this.gNf) {
                    if (abVar.jkT == this.oko) {
                        this.okq = abVar.jkT;
                        this.okp = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dYt() {
        if (this.gNf != null && !this.gNf.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.okr = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.okr.setText(this.okp);
            this.okr.setCategoryContainerData(this.gNf, this.okn, this.okq);
            this.okr.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        WriteActivity.this.okr.setText(bcVar.name);
                        WriteActivity.this.nmk.setCategoryTo(bcVar.jkT);
                        WriteActivity.this.okq = bcVar.jkT;
                        WriteActivity.this.okr.dXL();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.okr.dXK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYz());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYy());
                }
            });
        }
    }

    private void dZa() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.okH = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.okH.setTitle(R.string.no_disturb_start_time);
        this.okH.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.okH);
        this.okH.setButton(-2, getPageContext().getString(R.string.cancel), this.okH);
        return this.okH;
    }

    private void dYu() {
        this.okj = (RelativeLayout) findViewById(R.id.addition_container);
        this.okk = (TextView) findViewById(R.id.addition_create_time);
        this.okl = (TextView) findViewById(R.id.addition_last_time);
        this.okm = (TextView) findViewById(R.id.addition_last_content);
        if (this.oki != null) {
            this.okj.setVisibility(0);
            this.okk.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.oki.getCreateTime() * 1000));
            if (this.oki.getAlreadyCount() == 0) {
                this.okl.setVisibility(8);
            } else {
                this.okl.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.oki.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.oki.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.okm.setText(lastAdditionContent);
            } else {
                this.okm.setVisibility(8);
            }
            dYy().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.oki.getAlreadyCount()), Integer.valueOf(this.oki.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.okj.setVisibility(8);
    }

    private void dJX() {
        this.nmK = findViewById(R.id.post_prefix_layout);
        if (this.olz == null) {
            this.olz = new com.baidu.tieba.c.e(getPageContext(), this.nmK);
            this.olz.en(R.drawable.bg_tip_blue_up_left);
            this.olz.em(16);
            this.olz.pJ(true);
            this.olz.setUseDirectOffset(true);
            this.olz.xl(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.nmH = (TextView) findViewById(R.id.post_prefix);
        this.okf = findViewById(R.id.prefix_divider);
        this.nmJ = (ImageView) findViewById(R.id.prefix_icon);
        dZb();
    }

    private void dZb() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nmK.setVisibility(0);
            this.okf.setVisibility(0);
            this.olz.C(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nml = 0;
            this.nmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.nmk.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nmH.setVisibility(0);
                    WriteActivity.this.nmK.setSelected(true);
                    SvgManager.bsR().a(WriteActivity.this.nmJ, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nmI, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fBu.bzD();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nmC);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.okd);
                }
            });
            this.nmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.nmk.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nmH.setSelected(true);
                    SvgManager.bsR().a(WriteActivity.this.nmJ, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nmI, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fBu.bzD();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYz());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYy());
                }
            });
            this.nmI = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nmI.a(this);
            this.nmI.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nmI.setOutsideTouchable(true);
            this.nmI.setFocusable(true);
            this.nmI.setOnDismissListener(this);
            this.nmI.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.bsR().a(this.nmJ, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nmH).nY(R.color.CAM_X0105).oa(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.okg.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.okg.add(writePrefixItemLayout);
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
                this.nmI.addView(writePrefixItemLayout);
            }
            this.nmI.setCurrentIndex(0);
            this.nmH.setText(prefixs.get(0));
            LA(0);
            return;
        }
        this.nmK.setVisibility(8);
        this.okf.setVisibility(8);
    }

    private void dZc() {
        if (this.okN && this.nmk != null) {
            this.okT.setVisibility(0);
            this.okU.setVisibility(0);
            this.oke = new FeedBackModel(getPageContext());
            this.oke.Vx(this.nmk.getForumName());
            this.oke.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.okT.setVisibility(8);
                        WriteActivity.this.okU.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.okT.setVisibility(8);
                        WriteActivity.this.okU.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.okT.a(feedBackModel.dXS(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dYv() {
        this.lUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.olB == null || WriteActivity.this.olC != null) {
                    if (WriteActivity.this.dZw()) {
                        if (!WriteActivity.this.olZ || WriteActivity.this.olY) {
                            if (WriteActivity.this.dZy()) {
                                int dZx = WriteActivity.this.dZx();
                                if (dZx == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dZx == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                                if (WriteActivity.this.oky.a(WriteActivity.this.nmC, WriteActivity.this.okd)) {
                                    WriteActivity.this.showToast(WriteActivity.this.oky.dWz());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYz());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYy());
                                WriteActivity.this.fBu.bzD();
                                if (WriteActivity.this.nmk.getType() != 7) {
                                    if (WriteActivity.this.okN) {
                                        WriteActivity.this.cGY();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.ap("obj_type", StringUtils.isNull(WriteActivity.this.nmk.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.dYF();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cGY();
                                }
                                MercatorModel.dOK().startLoad();
                                TiebaStatic.log(new ar("c12262").dR("obj_locate", WriteActivity.this.jNd));
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

    protected void dJY() {
        this.okR = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.okR.setIsRound(true);
        this.okR.setDrawBorder(false);
        this.okR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String AV = r.AV(currentPortrait);
            this.okR.setUrl(AV);
            this.okR.startLoad(AV, 12, false);
        }
        if (this.nmk.isUserFeedback()) {
            this.okR.setVisibility(0);
        }
        this.nmC = (EditText) findViewById(R.id.post_title);
        this.nmC.setOnClickListener(this.okD);
        this.nmC.setOnFocusChangeListener(this.hxs);
        if (this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 11 || this.nmk.getType() == 7) {
            if (this.nmk.getTitle() != null) {
                this.nmC.setText(this.nmk.getTitle());
                this.nmC.setSelection(this.nmk.getTitle().length());
            } else if (this.okP) {
                this.nmC.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.nmk.getType() == 1 || this.nmk.getType() != 2) {
        }
        this.nmC.addTextChangedListener(this.okF);
        com.baidu.tbadk.core.elementsMaven.c.br(this.nmC).oa(R.string.F_X02);
        if (!this.nmk.getHaveDraft()) {
            dYr();
            this.olx = true;
        }
        this.okQ = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher awL() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText cBd = null;
            private TextView mTextView = null;
            private int omn;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dJZ();
                if (WriteActivity.this.okt) {
                    this.omn = this.cBd.getSelectionStart();
                    this.cBd.setSelection(this.omn);
                    WriteActivity.this.a(this.mTextView, this.cBd);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.okt || !WriteActivity.this.olo) {
                    if (WriteActivity.this.okt) {
                        if (this.cBd != WriteActivity.this.olf || this.mTextView != WriteActivity.this.oll) {
                            this.cBd = WriteActivity.this.olf;
                            this.mTextView = WriteActivity.this.oll;
                        }
                    }
                } else if (this.cBd != WriteActivity.this.olj || this.mTextView != WriteActivity.this.olk) {
                    this.cBd = WriteActivity.this.olj;
                    this.mTextView = WriteActivity.this.olk;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.okt && this.olo) {
            if (this.olm != null) {
                this.olj.removeTextChangedListener(this.olm);
            }
            this.olm = textWatcher;
        } else if (this.okt) {
            if (this.oln != null) {
                this.olf.removeTextChangedListener(this.oln);
            }
            this.oln = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.olf) {
            return 233L;
        }
        if (editText != this.olj) {
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

    protected void dKa() {
        this.okd = (SpanGroupEditText) findViewById(R.id.post_content);
        this.okd.setDrawingCacheEnabled(false);
        this.okd.setOnClickListener(this.okD);
        this.okd.setOnSpanGroupChangedListener(new a.InterfaceC0565a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0565a
            public void G(int i, boolean z) {
                WriteActivity.this.Kx();
            }
        });
        this.okd.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.okd.setForumId(com.baidu.adp.lib.f.b.toLong(this.nmk.getForumId(), 0L));
        if (this.ola != null) {
            this.ola.setSpanGroupManager(this.okd.getSpanGroupManager());
        }
        if (this.nmk != null) {
            this.nmk.setSpanGroupManager(this.okd.getSpanGroupManager());
        }
        if (this.nmk.getContent() != null && this.nmk.getContent().length() > 0) {
            this.okd.setText(TbFaceManager.bCO().aD(getPageContext().getPageActivity(), this.nmk.getContent()));
            if (this.okd.getText() != null) {
                this.okd.setSelection(this.okd.getText().length());
            }
        } else if (this.nmk.getType() == 2) {
            if (this.okX) {
                if (this.okY != null && this.okY.length() > 0) {
                    this.okd.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.okY}));
                    this.okd.setSelection(this.okd.getText().length());
                }
            } else if (this.nmk.getFloorNum() > 0) {
                this.okd.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.nmk.getFloorNum())));
                this.okd.setSelection(this.okd.getText().length());
            }
        }
        this.okd.setOnFocusChangeListener(this.hxs);
        this.okd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.okd.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.okd.addTextChangedListener(this.okG);
        if (this.nmk.getType() == 0) {
            this.oly = true;
        } else {
            zK(true);
            this.oly = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.okd.setHint(spannableString);
        } else if (this.nmk.isUserFeedback()) {
            this.okd.setHint(R.string.write_input_content);
        } else {
            this.okd.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zK(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.okt && dYy() != null) {
            dYy().setPadding(0, 0, 0, 0);
            dYy().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYy(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.llE) || this.oki != null) {
                return;
            }
            if (this.olG == null || !this.olG.isVisible()) {
                com.baidu.adp.lib.e.d.mw().a(this.llE, 19, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.olG == null || !WriteActivity.this.olG.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dYy().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dYy(), true, WriteActivity.this.maT);
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

    private void dZd() {
        if (dYy() != null) {
            dYy().setPadding(0, 0, 0, 0);
            dYy().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYy(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYx() {
        int i = 5000;
        if (this.oki != null) {
            i = 1000;
        }
        return dYy().getText() != null && dYy().getText().length() >= i;
    }

    private void CQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ojX)) {
                this.ojX = "";
                dYy().requestFocus();
                if (dYy().getText() != null && dYy().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYy().getSelectionStart();
                    editable = dYy().getText();
                }
            } else if ("from_title".equals(this.ojX)) {
                this.ojX = "";
                dYz().requestFocus();
                if (dYz().getText() != null && dYz().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYz().getSelectionStart();
                    editable = dYz().getText();
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
            if (this.nmk != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nmk.getForumId(), 0L), this.nmk.getFirstDir(), this.nmk.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dYy().getText().getSpans(0, dYy().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.okh == null) {
                this.okh = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.okh.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dYy());
    }

    EditText dYy() {
        return this.okt ? this.olf : this.okd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYz() {
        return this.okt ? this.olj : this.nmC;
    }

    protected void dYA() {
        if (dYy().getSelectionStart() > 0) {
            String substring = dYy().getText().toString().substring(0, dYy().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iSy.matcher(substring);
            if (matcher.find()) {
                dYy().getText().delete(dYy().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dYy().getSelectionStart());
                return;
            }
            dYy().onKeyDown(67, this.iSz);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.nmk != null) {
            str = this.nmk.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.okN = true;
        }
    }

    private void dZe() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dZf() {
        this.olI = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.olH = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.olI);
        dYR();
    }

    private void bSf() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.olS = new d(getPageContext());
        this.olS.a(this.olR);
        this.mListView.setAdapter((ListAdapter) this.olS);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.olS != null && (WriteActivity.this.olS.getItem(i) instanceof v)) {
                    v vVar = (v) WriteActivity.this.olS.getItem(i);
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

    private Boolean dZg() {
        return Boolean.valueOf(this.okZ);
    }

    public void dJZ() {
        if (this.nmk != null) {
            String str = "";
            String str2 = "";
            if (dYz() != null) {
                str = dYz().getText().toString();
            }
            if (dYy() != null) {
                str2 = dYy().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.nml == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nmk.setIsNoTitle(true);
                        } else if (this.okc.getVisibility() == 0) {
                            this.nmk.setIsNoTitle(false);
                            zI(true);
                            return;
                        }
                    } else if (this.okc.getVisibility() == 0) {
                        this.nmk.setIsNoTitle(false);
                        zI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nmk.setIsNoTitle(true);
                } else if (this.okc.getVisibility() == 0) {
                    this.nmk.setIsNoTitle(false);
                    zI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.okt) {
                    zI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zI(true);
                }
            }
            if (this.nmk.getType() == 4) {
                zI(n(this.olf) && m(this.olj));
            } else if (this.nmk.getType() == 5) {
                zI(n(this.olf));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zI(true);
            } else if (this.nmk.getVideoInfo() != null) {
                zI(this.nmk.getVideoInfo().isVideoMixFinished());
            } else if (dZu()) {
                zI(true);
            } else {
                zI(false);
            }
        }
    }

    public void zI(boolean z) {
        if (!z || !this.isEvaluate || (this.okd != null && !TextUtils.isEmpty(this.okd.getText()) && this.okd.getText().length() >= 20 && this.okd.getText().length() <= 500 && this.olD != null && this.olD.dXO())) {
            this.lUF.setEnabled(z);
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
        this.ola = com.baidu.tieba.tbadkCore.writeModel.a.dPc();
        this.ola.a(this);
        this.nmk = new WriteData();
        if (bundle != null) {
            this.nmk.setType(bundle.getInt("type", 0));
            this.nmk.setForumId(bundle.getString("forum_id"));
            this.nmk.setForumName(bundle.getString("forum_name"));
            this.nmk.setFirstDir(bundle.getString("forum_first_dir"));
            this.nmk.setSecondDir(bundle.getString("forum_second_dir"));
            this.nmk.setThreadId(bundle.getString("thread_id"));
            this.nmk.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.nmk.setFloorNum(bundle.getInt("floor_num", 0));
            this.nmk.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.oki = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.nmk.setIsAddition(this.oki != null);
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.nmk.setTopicId(this.mTopicId);
            this.nmk.setTitle(bundle.getString("write_title"));
            this.nmk.setContent(bundle.getString("write_content"));
            this.nmk.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.okN = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.okO = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.okP = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.okX = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.okY = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.olQ = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
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
            this.jNd = bundle.getString("KEY_CALL_FROM");
            this.bLf = bundle.getInt("album_thread");
            this.oeH = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.nmk.setType(intent.getIntExtra("type", 9));
            this.nmk.setForumId(intent.getStringExtra("forum_id"));
            this.nmk.setForumName(intent.getStringExtra("forum_name"));
            this.nmk.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nmk.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nmk.setThreadId(intent.getStringExtra("thread_id"));
            this.nmk.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.nmk.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.oki = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nmk.setIsAddition(this.oki != null);
            this.nmk.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.nmk.setTitle(intent.getStringExtra("write_title"));
            this.nmk.setContent(intent.getStringExtra("write_content"));
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.nmk.setTopicId(this.mTopicId);
            this.nmk.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.nmk.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.okN = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.okO = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.okP = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.okX = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.okY = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.jeq = intent.getStringExtra("more_forum_img");
            this.jer = intent.getStringExtra("more_forum_title");
            this.jep = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jNd = intent.getStringExtra("KEY_CALL_FROM");
            this.bLf = intent.getIntExtra("album_thread", 0);
            this.olQ = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.oeH = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.nmk.setFrsTabInfoData(this.oeH);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.isEvaluate = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.nmk.setIsEvaluate(this.isEvaluate);
            this.olK = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.olL = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                this.olJ = (SerializableItemInfo) serializableExtra;
                this.nmk.setItem_id(String.valueOf(this.olJ.id));
            }
            this.jtV = getIntent().getBooleanExtra("item_is_school", false);
            this.olM = getIntent().getBooleanExtra("need_save_draft", true);
            this.olN = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.oko = getIntent().getIntExtra("category_id", -1);
            this.olO = getIntent().getStringExtra("goods_list");
            this.olP = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.okZ = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.fDL = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.olN && com.baidu.tieba.tbadkCore.writeModel.c.nBl != null) {
                this.nmk = com.baidu.tieba.tbadkCore.writeModel.c.nBl;
                this.nmk.setType(9);
                this.nmk.setContent(this.nmk.getContentString());
                this.writeImagesInfo = this.nmk.getWriteImagesInfo();
                this.oeH = this.nmk.getFrsTabInfoData();
                if (this.nmk.getItemInfo() != null) {
                    this.olJ = null;
                }
                this.mVoiceModel = this.nmk.getVoiceModel();
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.nmk.getType() == 9) {
            this.nmk.setEntranceType(1);
        } else if (this.nmk.getType() == 10) {
            this.nmk.setEntranceType(2);
            this.nmk.setType(9);
        } else if (this.nmk.getType() == 0) {
            this.nmk.setEntranceType(3);
        }
        this.nmk.setIsUserFeedback(this.okN);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.olQ != null) {
            this.writeImagesInfo.parseJson(this.olQ);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nmk.getType() == 4 ? 6 : 9);
        this.nmk.setWriteImagesInfo(this.writeImagesInfo);
        this.llE = TbadkCoreApplication.getInst().getDefaultBubble();
        dYs();
        if (this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 11) {
            if (this.olM) {
                if (this.nmk.isEvaluate()) {
                    y.c(this.nmk.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.nmk.getTopicId())) {
                    y.b(this.nmk.getForumId(), this);
                } else {
                    y.d(this.nmk.getTopicId(), this);
                }
            }
        } else if (this.nmk.getType() == 7) {
            if (this.olM) {
                y.b("24591571", this);
            }
        } else if (this.nmk.getType() == 1) {
            y.a(this.nmk.getThreadId(), this);
        } else if (this.nmk.getType() == 4) {
            y.b(this.nmk.getForumId() + "photolive", this);
        } else if (this.nmk.getType() == 5) {
            y.a(this.nmk.getThreadId() + "updatephotolive", this);
        }
        if (this.nmk != null && this.nmk.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nmk.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.oka = true;
        }
        try {
            this.olp = dZr();
        } catch (Throwable th) {
            this.olp = null;
        }
    }

    private void dZh() {
        this.mNavigationBar.postDelayed(this.omj, 500L);
    }

    private void dYB() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nmC.setText(com.baidu.tbadk.plugins.b.Dy(com.baidu.tbadk.plugins.b.Dz(hotTopicBussinessData.mTopicName)));
            this.nmC.setMovementMethod(com.baidu.tieba.view.c.dVY());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Dy = com.baidu.tbadk.plugins.b.Dy(com.baidu.tbadk.plugins.b.Dz(hotTopicBussinessData.mTopicName));
            if (Dy != null) {
                this.nmC.setText(Dy);
            }
            this.okv.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.olZ && !this.olN) {
            if (writeData != null) {
                if (this.nmk != null && writeData.isEvaluate() == this.nmk.isEvaluate()) {
                    boolean z = this.nmk.getVideoInfo() != null && this.nmk.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.nmk.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.nmk.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dYz().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dYy().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    this.nmk.setHaveDraft(true);
                    if (!z2 && !z) {
                        i(writeData);
                    }
                    if (!z3 || this.olx || ((this.okN || this.oka) && z5)) {
                        j(writeData);
                    }
                    if (z6 && (!z4 || this.okN || this.oka)) {
                        k(writeData);
                    }
                    if (this.nmk != null && !this.nmk.getHaveDraft()) {
                        dYr();
                    }
                    if (writeData.getItemInfo() != null) {
                        this.nmk.setItemInfo(writeData.getItemInfo());
                        this.nmk.setEvaluationStar(writeData.getEvaluationStar());
                        this.olJ = null;
                        dYV();
                    }
                    if (writeData.getWriteVoteData() != null) {
                        this.nmk.setWriteVoteData(writeData.getWriteVoteData());
                        dYR();
                    }
                    if (writeData.getVoiceModel() != null) {
                        f(writeData.getVoiceModel());
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dZi();
                    }
                    dJZ();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.gNf != null) {
                        this.okq = this.okn.jkT;
                        this.okp = this.okn.name;
                        while (true) {
                            if (i == this.gNf.size()) {
                                break;
                            }
                            ab abVar = this.gNf.get(i);
                            if (categoryTo != abVar.jkT) {
                                i++;
                            } else {
                                this.okq = categoryTo;
                                this.okp = abVar.name;
                                this.nmk.setCategoryTo(this.okq);
                                break;
                            }
                        }
                        if (this.okr != null) {
                            this.okr.setText(this.okp);
                            this.okr.setCategoryContainerData(this.gNf, this.okn, this.okq);
                        }
                    }
                    this.fBu.bzD();
                    return;
                }
                return;
            }
            dZi();
            dYr();
        }
    }

    private void i(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.nmk.setVideoInfo(videoInfo);
            aD(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.nmk.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dYH();
        }
        zL(false);
        aD(true, true);
    }

    private void j(WriteData writeData) {
        String str;
        String Dz;
        if (com.baidu.adp.lib.util.k.isEmpty(this.nmk.getTitle())) {
            this.nmk.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Dz = this.nmk.getTitle();
            } else {
                Dz = com.baidu.tbadk.plugins.b.Dz(str);
            }
            SpannableString Dy = com.baidu.tbadk.plugins.b.Dy(Dz);
            if (Dy != null) {
                dYz().setText(Dy);
                dYz().setSelection(Dy.length() > Dz.length() ? Dz.length() : Dy.length());
                return;
            }
            return;
        }
        SpannableString Dy2 = com.baidu.tbadk.plugins.b.Dy(this.nmk.getTitle());
        if (Dy2 != null) {
            dYz().setText(Dy2);
            dYz().setSelection(this.nmk.getTitle().length() > Dy2.length() ? Dy2.length() : this.nmk.getTitle().length());
        }
    }

    private void k(WriteData writeData) {
        this.nmk.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bCO().a(getPageContext().getPageActivity(), this.nmk.getContent(), this.okB);
        InputFilter[] filters = this.okd.getFilters();
        this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dYy().setText(a2);
        if (dYy() == this.okd && this.okd.getSpanGroupManager() != null) {
            this.okd.bva();
            this.okd.getSpanGroupManager().bvg();
            this.okd.bvb();
            Kx();
        }
        this.okd.setFilters(filters);
        if (dYy().getText() != null) {
            dYy().setSelection(dYy().getText().length());
        }
        if (this.okt) {
            a(this.oll, this.olf);
        }
    }

    private void dZi() {
        if ((!this.okt || this.ole != null) && this.old != null) {
            this.ole.b(this.writeImagesInfo);
            dZn();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nmk.getType());
        bundle.putString("forum_id", this.nmk.getForumId());
        bundle.putString("forum_name", this.nmk.getForumName());
        bundle.putString("forum_first_dir", this.nmk.getFirstDir());
        bundle.putString("forum_second_dir", this.nmk.getSecondDir());
        bundle.putString("thread_id", this.nmk.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.nmk.getFloor());
        bundle.putInt("floor_num", this.nmk.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.okX);
        if (this.okN) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fDF);
        if (this.oki != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.oki));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jNd);
        bundle.putInt("album_thread", this.bLf);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.oeH);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.nmk.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dYy().getEditableText().toString();
        if (obj != null) {
            dYy().setText(TbFaceManager.bCO().a(getPageContext().getPageActivity(), obj, this.okB));
            dYy().setSelection(dYy().getText().length());
        }
    }

    private String getContent() {
        return (dYy() == null || dYy().getText() == null) ? "" : dYy().getText().toString();
    }

    private String dYD() {
        if (this.nmk == null || dYz() == null || dYz().getVisibility() != 0 || dYz().getText() == null) {
            return "";
        }
        String obj = dYz().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nml != com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.nmk.getType() != 4 && this.nmH != null && this.nmH.getText() != null) {
            this.nmk.setPostPrefix(this.nmH.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.nmk.getTitle();
        }
        return obj;
    }

    private void Vy(String str) {
        if (this.nmk != null && this.okc != null) {
            if (this.okc.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.nmk.setIsNoTitle(true);
                    this.nmk.setTitle("");
                    return;
                }
                this.nmk.setIsNoTitle(false);
                this.nmk.setTitle(str);
                return;
            }
            this.nmk.setIsNoTitle(true);
            this.nmk.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGY() {
        dJR();
        this.nmk.setContent(getContent());
        Vy(dYD());
        if (this.okN || this.oka) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.nmk.getTitle()) || !this.nmk.getTitle().startsWith(string)) {
                Vy(string + this.nmk.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.nmk.getContent()) || !this.nmk.getContent().startsWith(str)) {
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
                sb.append(this.nmk.getContent());
                this.nmk.setContent(sb.toString());
            }
        }
        if (this.okO) {
            this.nmk.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.oko >= 0) {
            this.nmk.setCategoryFrom(this.oko);
        }
        if (this.okq >= 0) {
            this.nmk.setCategoryTo(this.okq);
        }
        this.nmk.setWriteImagesInfo(this.writeImagesInfo);
        if (this.olH != null) {
            this.nmk.setWriteVoteData(this.olH.getWriteVoteData());
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
            this.nmk.setTakePhotoNum(i);
        }
        this.nmk.setHasLocationData(this.fDG != null && this.fDG.clH());
        if (this.writeImagesInfo != null) {
            this.ola.yE(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && this.oku != null && this.oku.mIsGlobalBlock == 0) {
            this.nmk.setForumId(String.valueOf(this.oku.mForumId));
            this.nmk.setForumName(this.oku.mForumName);
        }
        if (this.olD != null && this.olD.getEvaluateItemInfo() != null) {
            this.nmk.setItem_id(this.olD.getEvaluateItemInfo().getItemID());
            this.nmk.setComment_head(cGX());
        }
        dYE();
        this.ola.f(this.nmk);
        this.nmk.setContent(this.nmk.getContent().replaceAll("\u0000\n", ""));
        this.nmk.setContent(this.nmk.getContent().replaceAll("\u0000", ""));
        this.nmk.setVcode(null);
        this.nmk.setVoiceModel(this.mVoiceModel);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ola.daC().setVoice(this.mVoiceModel.getId());
                this.ola.daC().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ola.daC().setVoice(null);
                this.ola.daC().setVoiceDuringTime(-1);
            }
        } else {
            this.ola.daC().setVoice(null);
            this.ola.daC().setVoiceDuringTime(-1);
        }
        if (!this.ola.dPf()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            dZj();
        }
    }

    private void dZj() {
        this.ola.dPd();
        com.baidu.tieba.write.b.b.g(this.nmk);
        cDb();
        dYS();
        setResult(100);
        finish();
    }

    private void dYE() {
        if (this.nmk != null && this.okA != null) {
            this.nmk.setIsForumBusinessAccount(this.oeH == null ? false : this.oeH.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.okA.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.nmk.setTabId(selectedTabItemData.tabId);
                this.nmk.setTabName(selectedTabItemData.name);
                this.nmk.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.oki != null) {
                i2 = this.oki.getTotalCount();
                i = this.oki.getAlreadyCount() + 1;
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
                if (this.nmC == getCurrentFocus()) {
                    dYy().clearFocus();
                    this.nmC.requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.nmC);
                } else {
                    dYy().requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.okd);
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
                            dYy().getText().insert(dYy().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cGV();
                dPk();
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
                                dZo();
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
                        if (this.oly) {
                            zK(true);
                            this.oly = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.okt) {
                        G(intent);
                        dJZ();
                        return;
                    }
                    ap(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.nmk.setVideoInfo(videoInfo);
                        this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fBu.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dJZ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ojY) {
                                sb2.append(com.baidu.tbadk.plugins.b.fLy);
                                this.ojY = false;
                            }
                            sb2.append(stringExtra);
                            CQ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.oku = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.oku);
                    }
                } else if (i == 25048) {
                    Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                    if (serializableExtra instanceof WriteVoteData) {
                        this.olP = serializableExtra;
                        dYR();
                    }
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.okd.getSelectionStart();
                    int selectionEnd = this.okd.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.okd.getText();
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
                this.okd.requestFocus();
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
                    dZm();
                    if (this.oly) {
                        zK(true);
                        this.oly = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.nmC == getCurrentFocus()) {
                        dYy().clearFocus();
                        this.nmC.requestFocus();
                        if (this.fBu != null) {
                            this.fBu.bzD();
                        }
                        ShowSoftKeyPadDelay(this.nmC);
                        return;
                    }
                    dYy().requestFocus();
                    if (this.fBu != null) {
                        this.fBu.bzD();
                    }
                    ShowSoftKeyPadDelay(this.okd);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.oky.Vh(postWriteCallBackData.getErrorString());
                        this.oky.bg(postWriteCallBackData.getSensitiveWords());
                        this.oky.b(this.nmC, this.okd);
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
                    dZm();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.ojX)) {
                        dYz().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ojX)) {
                        dYy().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYF() {
        if ("1".equals(this.jNd)) {
            this.nmk.setCanNoForum(true);
            this.nmk.setTransmitForumData("[]");
        } else if ("2".equals(this.jNd)) {
            this.nmk.setCanNoForum(false);
        }
        dYG();
        this.nmk.setPrivacy(this.isPrivacy);
        dZk();
        this.nmk.setToDynamic(this.isToDynamic);
        this.nmk.setCallFrom(this.jNd);
        if (this.nmk.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cGY();
    }

    private void dYG() {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dZk() {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dZl() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dZm() {
        if (this.okt) {
            this.ole.b(this.writeImagesInfo);
            dZn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZn() {
        this.ole.notifyDataSetChanged();
        this.old.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.ole.notifyDataSetChanged();
                WriteActivity.this.old.invalidateViews();
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
        dJZ();
    }

    private void ao(Intent intent) {
        if (this.okt) {
            ap(intent);
            dZm();
        } else {
            as(intent);
        }
        dJZ();
    }

    private void ap(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dZm();
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

    private void dZo() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ar(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.olb.parseJson(stringExtra);
            this.olb.updateQuality();
            if (this.olb.getChosedFiles() != null && this.olb.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.olb.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.olb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dYz());
        HidenSoftKeyPad(this.mInputManager, dYy());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.olG != null) {
            this.olG.onPause();
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
            dZp();
            dYH();
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
                dZp();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dYH();
                }
            }
            zL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZp() {
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

    private void dZq() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.jeq)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.jeq, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.53
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
        String forumId = this.nmk == null ? "" : this.nmk.getForumId();
        if (this.olc != null) {
            this.olc.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cDb() {
        this.jgu = getVoiceManager();
        this.jgu.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jhQ) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.nmk.getType() != 7) {
                if (this.oki == null) {
                    com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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

    private void dYH() {
        if (!this.okt) {
            if (this.fBu != null) {
                this.fBu.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fBu.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.nmk == null ? "" : this.nmk.getForumId();
            if (this.olc != null) {
                this.olc.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LA(int i) {
        if (i < this.okg.size()) {
            for (int i2 = 0; i2 < this.okg.size(); i2++) {
                this.okg.get(i2).zz(false);
            }
            this.okg.get(i).zz(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Ji(int i) {
        if (i == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").ap("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").ap("obj_type", 2));
        }
        this.nml = i;
        this.nmI.setCurrentIndex(i);
        LA(i);
        this.nmH.setText(this.mPrefixData.getPrefixs().get(i));
        dJZ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmI, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nmK.setSelected(false);
        SvgManager.bsR().a(this.nmJ, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.okd);
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
        if (this.nmk != null) {
            if (this.nmk.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nmk.getType() == 5) {
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
        if (this.olv && System.currentTimeMillis() - this.olw < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.olv = false;
        }
        if (this.okx != null && !z) {
            this.okx.cwz();
        }
        if (this.okz != null && !z) {
            dYj();
        }
        if (this.olA != null && !z) {
            dYP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vz(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.ols != null) {
            VA(str);
            this.ols.dismiss();
        }
    }

    private void hg(Context context) {
        olu = l.getEquipmentHeight(context);
    }

    private void VA(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.olv = true;
        dZp();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dYH();
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

    private File dZr() {
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

    private void dZs() {
        if (this.olp != null && this.nmk.getType() == 0 && this.nmk.getType() == 9 && this.nmk.getType() == 11) {
            hg(getActivity());
            this.olr = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.olr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.olp != null) {
                        WriteActivity.this.Vz(WriteActivity.this.olp.getAbsolutePath());
                    }
                }
            });
            this.olq = (TbImageView) this.olr.findViewById(R.id.rec_img_view);
            this.olt = (LinearLayout) this.olr.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.olp.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.olp.getAbsolutePath());
                Bitmap h = h(this.olp.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.olq.setImageBitmap(h);
                    this.olq.setDrawBorder(true);
                    this.olq.setBorderWidth(2);
                    this.olq.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.ols = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.ols.setCanceledOnTouchOutside(true);
                    this.ols.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.olv) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.olw = System.currentTimeMillis();
                            }
                        }
                    });
                    this.ols.setContentView(this.olr);
                    this.ols.show();
                    Window window = this.ols.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (olu / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
            this.ojY = false;
            this.ojX = "";
            if ("from_content".equals(str)) {
                this.ojX = "from_content";
            } else if ("from_title".equals(str)) {
                this.ojX = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Dx(String.valueOf(charSequence.charAt(i)))) {
                zH(false);
            }
        }
    }

    public void dEc() {
        if (this.isEvaluate) {
            this.okc.setVisibility(8);
            if (this.ome != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ome.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ome.setLayoutParams(layoutParams);
            }
            this.okS.setVisibility(8);
        } else if (com.baidu.tieba.write.b.b.dXy()) {
            this.nmC.setHint(R.string.title_hint_for_hot);
            this.okc.setVisibility(0);
            if (this.ome != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ome.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.ome.setLayoutParams(layoutParams2);
            }
            this.okS.setVisibility(0);
            com.baidu.tieba.write.b.b.a(this.okQ);
            this.okc.requestFocus();
        } else {
            this.okQ.setVisibility(8);
            this.nmC.setHint(this.okN ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.okN || !com.baidu.tbadk.core.util.y.isEmpty(this.mList) || (this.nmk != null && !StringUtils.isNull(this.nmk.getTitle()))) {
                this.okc.setVisibility(0);
                if (this.ome != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ome.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.ome.setLayoutParams(layoutParams3);
                }
                this.okS.setVisibility(0);
                this.okc.requestFocus();
                return;
            }
            this.okc.setVisibility(8);
            if (this.ome != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.ome.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ome.setLayoutParams(layoutParams4);
            }
            this.okS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZt() {
        if (this.fBu != null) {
            this.fBu.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fBu != null && WriteActivity.this.fBu.fBx != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bsV().l(clipBoardContent)) {
                            WriteActivity.this.okx.dwH();
                            return;
                        }
                        if (WriteActivity.this.oiS == null) {
                            WriteActivity.this.oiS = new WriteTipBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.omd);
                        }
                        WriteActivity.this.oiS.a(WriteActivity.this.fBu.fBx.qS(31), WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jNd;
    }

    public WriteData daC() {
        return this.nmk;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.oeH;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dZu() {
        return (this.olH == null || this.olI == null || this.olH.getWriteVoteData() == null || this.olI.getVisibility() != 0) ? false : true;
    }

    public void dWF() {
        if (!dZy()) {
            BdToast.b(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else if (!this.canGoods) {
            BdToast.b(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else {
            if (this.nmk != null) {
                TiebaStatic.log(new ar("c13897").ap("obj_locate", 2).dR("fid", this.nmk.getForumId()).dR("fname", this.nmk.getForumName()));
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
                            TiebaStatic.log(new ar("c13959").ap("obj_locate", 2).dR("fid", WriteActivity.this.nmk != null ? WriteActivity.this.nmk.getForumId() : "").dR("fname", WriteActivity.this.nmk != null ? WriteActivity.this.nmk.getForumName() : ""));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dZv()));
                        }
                    }
                });
                aVar.bn(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new ar("c13958").ap("obj_locate", 2).dR("fid", this.nmk != null ? this.nmk.getForumId() : "").dR("fname", this.nmk != null ? this.nmk.getForumName() : ""));
                aVar.b(getPageContext()).bqx();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dZv()));
        }
    }

    public void Kx() {
        if (this.olS != null && this.olS.dXU() == null && this.okd != null && this.okd.getSpanGroupManager() != null) {
            this.olS.h(this.okd.getSpanGroupManager().bvl());
            this.olS.refreshData();
        } else if (this.olS != null && this.olS.dXU() != null) {
            this.olS.refreshData();
        }
        if (this.olS != null) {
            gk(this.olS.dXT());
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
            if (!z && this.olT != null) {
                this.olT.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB(String str) {
        this.olW = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.olW.add(com.baidu.tieba.j.a.es(jSONObject));
                }
                if (this.olW.size() > 0) {
                    this.olZ = true;
                    this.okd.n(this.olW, arrayList);
                    dYX();
                    Kx();
                    this.olT.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZv() {
        if (this.okd == null || this.okd.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.okd.getSpanGroupManager().bvm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZw() {
        return this.canGoods || this.okd == null || this.okd.getSpanGroupManager() == null || this.okd.getSpanGroupManager().bvm() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZx() {
        boolean z = this.olS == null || this.olS.dXV();
        boolean z2 = (this.okA == null || this.okA.getSelectedTabItemData() == null || this.okA.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZy() {
        if (this.oeH == null || com.baidu.tbadk.core.util.y.isEmpty(this.oeH.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.oeH.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dZz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.59
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).zn(false).UZ(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aR((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cGX() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.olD != null) {
            i = this.olD.getStarCount();
        }
        arrayList.add(new com.baidu.tbadk.coreExtra.data.v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
