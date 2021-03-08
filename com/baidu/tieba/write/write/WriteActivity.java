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
/* loaded from: classes7.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0154a, VoiceManager.c, y.a, i.a {
    private static int onA = 0;
    private EditorTools fCT;
    private String fFe;
    private LocationModel fFf;
    List<ab> gOO;
    private boolean isEvaluate;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private String jfY;
    private String jfZ;
    private String jga;
    private VoiceManager jie;
    private boolean jvE;
    private com.baidu.tbadk.core.dialog.i jvu;
    private SaveDraftDialogView jvv;
    private LinearLayout lVQ;
    private PlayVoiceBntNew lVR;
    private ImageView lVT;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private TextView noN;
    private com.baidu.tieba.write.i noO;
    private ImageView noP;
    private View noQ;
    private int nop;
    private FrsTabInfoData ogN;
    private WriteTipBubbleController okX;
    private TextView omA;
    private com.baidu.tieba.write.editor.b omC;
    private g omE;
    private ForumTabSelectedView omF;
    private com.baidu.tieba.view.b omM;
    private TitleTipView omV;
    private View omX;
    private View omZ;
    private LinearLayout omg;
    private LinearLayout omh;
    private View omk;
    private Toast omm;
    private AdditionData omn;
    private RelativeLayout omo;
    private TextView omp;
    private TextView omq;
    private TextView omr;
    ab oms;
    private String omu;
    private PostCategoryView omw;
    private HotTopicBussinessData omz;
    private com.baidu.tieba.c.e onF;
    private b onG;
    private ForumSelectedView onH;
    private com.baidu.tbadk.data.j onI;
    private WriteEvaluationHeaderView onJ;
    private TextView onK;
    private View onL;
    private com.baidu.tieba.write.write.video.a onM;
    private com.baidu.tieba.write.write.vote.a onN;
    private RelativeLayout onO;
    private SerializableItemInfo onP;
    private boolean onQ;
    private int onR;
    private Serializable onV;
    private String onW;
    private d onY;
    private LinearLayout onZ;
    private com.baidu.tieba.tbadkCore.writeModel.a ong;
    private i oni;
    private ImageView ooa;
    private TextView oob;
    private List<com.baidu.tieba.j.a> ooc;
    private EBusinessProtocolView ood;
    private WriteImageGridView ook;
    private com.baidu.tbadk.editortools.c.a ool;
    private int privateThread;
    private String omc = "";
    private boolean omd = false;
    protected WriteData noo = null;
    private boolean omS = false;
    private boolean omT = false;
    private boolean omf = false;
    private boolean omU = false;
    private InputMethodManager mInputManager = null;
    private EditText noI = null;
    private HeadImageView omW = null;
    private View noJ = null;
    private LinearLayout noL = null;
    private SpanGroupEditText omi = null;
    private FeedBackModel omj = null;
    private FeedBackTopListView omY = null;
    private ArrayList<WritePrefixItemLayout> oml = new ArrayList<>();
    private String lnH = null;
    private final KeyEvent iUi = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ona = null;
    private TextView lWH = null;
    private TextView mName = null;
    private ImageView onb = null;
    private final Handler mHandler = new Handler();
    private boolean onc = false;
    private String ond = null;
    private RelativeLayout lzu = null;
    public boolean onf = true;
    public String fFk = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fFl = 0;
    private int omt = -1;
    private int omv = -1;
    private WriteImagesInfo onh = new WriteImagesInfo();
    private View mRootView = null;
    private GridView onj = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a onk = null;
    private ScrollView omx = null;
    private EditText onl = null;
    private View onm = null;
    private View onn = null;
    private View ono = null;
    private EditText onp = null;
    private TextView onq = null;
    private TextView onr = null;
    private TextWatcher ons = null;
    private TextWatcher ont = null;
    private boolean omy = false;
    private boolean onu = false;
    private com.baidu.tbadk.core.view.a fNE = null;
    private String mFrom = "write";
    private File onv = null;
    private TbImageView onw = null;
    private View onx = null;
    private Dialog ony = null;
    private LinearLayout onz = null;
    private boolean onB = false;
    private long onC = -1000;
    private boolean onD = false;
    private String jOM = "2";
    private int bMF = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder omB = new SpannableStringBuilder();
    private boolean onE = false;
    private boolean bsF = false;
    private final c omD = new c();
    private boolean onS = true;
    private boolean onT = false;
    private String onU = null;
    private final d.a onX = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void LC(int i) {
            if (WriteActivity.this.omi != null) {
                WriteActivity.this.omi.pZ(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gj(List<v> list) {
            WriteActivity.this.gk(list);
        }
    };
    private boolean ooe = false;
    private boolean oof = false;
    private final HttpMessageListener oog = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.lnH)) {
                    WriteActivity.this.lnH = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zJ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.lnH)) {
                    WriteActivity.this.lnH = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.lnH);
                    WriteActivity.this.zJ(true);
                }
            }
        }
    };
    private CustomMessageListener ooh = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.noo != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new ar("c13896").aq("obj_locate", 1).dR("fid", WriteActivity.this.noo.getForumId()).dR("fname", WriteActivity.this.noo.getForumName()));
            }
        }
    };
    private final CustomMessageListener ooi = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (WriteActivity.this.onH != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.forumId) && !StringUtils.isNull(jVar.forumName)) {
                WriteActivity.this.a(jVar);
            }
        }
    };
    private TbFaceManager.a omG = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dn(String str) {
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
    private final AntiHelper.a jjA = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private WriteTipBubbleController.a ooj = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (WriteActivity.this.okX != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.okX.Xm();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cDh();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.oon = true;
            if (postWriteCallBackData != null && WriteActivity.this.noo != null) {
                WriteActivity.this.omD.bg(null);
                if (z) {
                    WriteActivity.this.kZ(z);
                    if (WriteActivity.this.h(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.b.b.g(WriteActivity.this.noo);
                    WriteActivity.this.cHb();
                    WriteActivity.this.dPt();
                    if ((WriteActivity.this.noo.getType() == 0 || WriteActivity.this.noo.getType() == 9 || WriteActivity.this.noo.getType() == 11) && !com.baidu.tbadk.core.util.y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ar("c11731").dR("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    if (!au.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.noo.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.noo.getVideoInfo().getVideoMd5();
                        if (!au.isEmpty(WriteActivity.this.noo.getForumName())) {
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
                    WriteActivity.this.omD.bg(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.omD.Vo(postWriteCallBackData.getErrorString());
                    WriteActivity.this.omD.b(WriteActivity.this.noI, WriteActivity.this.omi);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AB(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AB(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ar("c13746").aq("obj_locate", 1).aq("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bqz();
                    TiebaStatic.log(new ar("c13745").aq("obj_locate", 1).aq("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwI());
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwH());
                        if (WriteActivity.this.omU) {
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
    private final LocationModel.a fFt = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bCk() {
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
    private final CustomMessageListener nBP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fFf.yB(false);
                    WriteActivity.this.fFf.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fFf.yB(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener omH = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dZB();
            }
        }
    };
    private CustomMessageListener oom = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener omI = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dYo = WriteActivity.this.dYo();
            if (dYo >= 0 && dYo < WriteActivity.this.omi.getText().length()) {
                WriteActivity.this.omi.setSelection(dYo);
            }
        }
    };
    private boolean omJ = true;
    private final View.OnFocusChangeListener hzb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.noI || view == WriteActivity.this.mBack || view == WriteActivity.this.lWH) {
                if (z) {
                    WriteActivity.this.omJ = true;
                    WriteActivity.this.dYp();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.noI);
                    if (WriteActivity.this.fCT != null) {
                        WriteActivity.this.fCT.bzG();
                    }
                } else if (view == WriteActivity.this.noI) {
                    WriteActivity.this.noN.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.omi && z) {
                WriteActivity.this.omJ = false;
                WriteActivity.this.dYp();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.omi);
                if (WriteActivity.this.fCT != null) {
                    WriteActivity.this.fCT.bzG();
                }
            }
            WriteActivity.this.dYu();
        }
    };
    private com.baidu.tbadk.mutiprocess.h jhj = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.VI(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean oon = false;
    private TextWatcher omK = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String omO = "";
        private String omP;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.omP = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.omP != null ? this.omP.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dKh();
            WriteActivity.this.dYv();
            EditText dYH = WriteActivity.this.dYH();
            if (editable != null && dYH != null && dYH.getText() != null) {
                if (this.omO == null || !this.omO.equals(editable.toString())) {
                    if (WriteActivity.this.omD != null) {
                        this.omO = dYH.getText().toString();
                        WriteActivity.this.omD.b(dYH, true);
                        return;
                    }
                    return;
                }
                dYH.setSelection(dYH.getSelectionEnd());
            }
        }
    };
    private TextWatcher omL = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String omP;
        private String omQ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.omP = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.omP != null ? this.omP.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dKh();
            EditText dYG = WriteActivity.this.dYG();
            if (editable != null && dYG != null && dYG.getText() != null) {
                if (this.omQ == null || !this.omQ.equals(editable.toString())) {
                    if (WriteActivity.this.omD != null) {
                        this.omQ = dYG.getText().toString();
                        WriteActivity.this.omD.b(dYG, false);
                    }
                    if (WriteActivity.this.isEvaluate) {
                        WriteActivity.this.e(editable);
                        return;
                    }
                    return;
                }
                dYG.setSelection(dYG.getSelectionEnd());
            }
        }
    };
    private int ooo = 0;
    private final a.InterfaceC0878a mcV = new a.InterfaceC0878a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0878a
        public void onRefresh() {
            WriteActivity.this.lnH = null;
            WriteActivity.this.zJ(false);
            WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };
    private final Runnable oop = new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.onT) {
                WriteActivity.this.fFv.callback(false, com.baidu.tieba.tbadkCore.writeModel.c.nDo, com.baidu.tieba.tbadkCore.writeModel.c.nDp, com.baidu.tieba.tbadkCore.writeModel.c.nDq, com.baidu.tieba.tbadkCore.writeModel.c.antiData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null) {
            this.onI = jVar;
            if (this.noo != null) {
                this.noo.setForumId(this.onI.forumId);
                this.noo.setForumName(this.onI.forumName);
            }
            this.onH.setSelectedForum(this.onI.forumName);
            this.ogN = null;
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.onI.tabInfoList)) {
                this.ogN = new FrsTabInfoData();
                this.ogN.selectedTabId = -1;
                this.ogN.tabList = this.onI.tabInfoList;
                if (this.onI.isForumBusinessAccount && this.ogN.tabList != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    this.ogN.tabList.add(0, frsTabItemData);
                }
                this.ogN.isForumBusinessAccount = this.onI.isForumBusinessAccount;
            }
            this.omF.setData(this.ogN);
            if (this.noo != null) {
                this.noo.setFrsTabInfoData(this.ogN);
            }
            if (this.omF.getVisibility() == 0) {
                this.onL.setVisibility(0);
            }
            this.mPrefixData = null;
            if (this.onI.fBI != null && !com.baidu.tbadk.core.util.y.isEmpty(this.onI.fBI.getPrefixs())) {
                this.mPrefixData = this.onI.fBI;
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
            }
            dZj();
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
    public void bBS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.onJ.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.noo.setItemInfo(tbRichTextEvaluateItemInfo);
        this.onJ.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bBU() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBW();
        } else if (this.fFf.dOG()) {
            bBS();
        } else {
            this.fFf.yB(false);
            b(1, true, null);
            this.fFf.dOE();
        }
    }

    public void dYR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.omC != null) {
                this.omC.dXx();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBW();
        } else if (this.fFf != null) {
            this.fFf.yB(false);
            b(1, true, null);
            this.fFf.dOE();
        }
    }

    private void bBW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ny(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.fFf.dOI();
                } else {
                    WriteActivity.this.fFt.bCk();
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
        aVar.bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dYo() {
        int selectionEnd = dYG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dYG().getText().getSpans(0, dYG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dYG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dYG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYp() {
        if (this.fCT != null) {
            if (this.onM != null && this.onM.isVisible()) {
                this.fCT.setBarLauncherEnabled(!this.omJ);
                this.fCT.setDeskLauncherEnabled(!this.omJ);
                this.fCT.setToolEnabled(true, 2);
                this.fCT.setToolEnabled(true, 32);
                this.fCT.setToolEnabled(false, 10);
                this.fCT.setToolEnabled(false, 6);
                this.fCT.setToolEnabled(false, 18);
                this.fCT.qV(5).kR(false);
                if (this.omC != null) {
                    this.omC.zE(true);
                }
            } else {
                this.fCT.setBarLauncherEnabled(!this.omJ);
                this.fCT.setDeskLauncherEnabled(!this.omJ);
                this.fCT.setToolEnabled(true, 26);
                this.fCT.setToolEnabled(true, 2);
                this.fCT.setToolEnabled(true, 30);
                this.fCT.qV(5).kR(true);
                if (this.omC != null) {
                    this.omC.zE(true);
                }
                dZx();
            }
            if (this.isEvaluate && this.ool != null && !this.ool.isEnable()) {
                this.fCT.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.omy) {
            this.noI.setVisibility(8);
            if (this.noo.getType() == 5) {
                this.ono.setVisibility(8);
            } else {
                this.ono.setVisibility(0);
            }
            a(this.onr, this.onl);
            a(this.onq, this.onp);
            dKh();
        }
        if (this.omS) {
            this.omJ = true;
            dYp();
            if (this.fCT != null) {
                this.fCT.bzG();
            }
            this.noI.requestFocus();
            ShowSoftKeyPadDelay(this.noI);
        }
        if (this.onM != null) {
            this.onM.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.onM != null) {
            this.onM.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.onM != null) {
            this.onM.onStop();
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
                    dYP();
                }
                zK(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.noo.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.noo.setVideoInfo(null);
            }
            if (this.onM == null) {
                this.onM = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.noo.getVideoInfo() != null && this.noo.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.onM.eag();
                return;
            }
            aD(true, false);
        }
    }

    public void Et(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aD(boolean z, boolean z2) {
        if (z) {
            this.noo.setVideoInfo(null);
            this.onM.a(null, z2);
            this.oni.XR().setVisibility(0);
            zJ(false);
        } else {
            this.onM.a(this.noo.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.oni.XR().setVisibility(8);
            dZl();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dKh();
        dYp();
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
        if (this.noo.getType() == 0) {
            LF(this.bMF);
        }
        initUI();
        dZk();
        this.fFf = new LocationModel(getPageContext());
        this.fFf.a(this.fFt);
        dZH();
        dan();
        dZA();
        if (this.omy) {
            this.onk.setEditorTools(this.fCT);
        } else {
            this.omi.requestFocus();
        }
        dEk();
        dYP();
        dZy();
        this.jhj.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.jhj);
        dYS();
        if (this.onT) {
            k(this.noo);
            dKh();
            dZp();
        }
    }

    private void initListener() {
        registerListener(this.oog);
        registerListener(this.ooh);
        registerListener(this.ooi);
        registerListener(this.nBP);
        registerListener(this.omH);
        registerListener(this.mBackgroundListener);
        registerListener(this.oom);
    }

    private void dYS() {
        VI(this.onU);
    }

    @SuppressLint({"ResourceAsColor"})
    private void dan() {
        this.fCT = new EditorTools(getActivity());
        this.fCT.setBarMaxLauCount(5);
        this.fCT.setMoreButtonAtEnd(true);
        this.fCT.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fCT.setBarLauncherType(1);
        this.fCT.kN(true);
        this.fCT.kO(false);
        switch (this.noo.getType()) {
            case 4:
            case 5:
                dYV();
                break;
            default:
                dYq();
                break;
        }
        this.fCT.build();
        if (this.omg != null) {
            this.omg.addView(this.fCT);
        }
        cZL();
        this.fCT.display();
        com.baidu.tbadk.editortools.h qS = this.fCT.qS(6);
        if (qS != null && !TextUtils.isEmpty(this.fFk)) {
            ((View) qS).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fFk);
                }
            });
        }
        if (!this.omy) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fCT.bzG();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dYW();
            return;
        }
        dYs();
        dZB();
    }

    private void dYT() {
        this.onm = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.ono = this.onm.findViewById(R.id.live_post_title_container);
        this.onl = (EditText) this.onm.findViewById(R.id.live_post_content);
        this.onj = (GridView) this.onm.findViewById(R.id.photoLiveGridView);
        this.onp = (EditText) this.onm.findViewById(R.id.live_post_title);
        this.onq = (TextView) this.onm.findViewById(R.id.titleOverPlusNumber);
        this.onr = (TextView) this.onm.findViewById(R.id.contentOverPlusNumber);
        this.onn = this.onm.findViewById(R.id.live_interval_view);
        this.onq.setText(String.valueOf(20));
        this.onr.setText(String.valueOf(233));
        this.onm.setVisibility(0);
        this.onq.setVisibility(0);
        this.onr.setVisibility(0);
        this.onp.setHint(R.string.tips_title_limit_new);
        this.onp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.onu = true;
                    WriteActivity.this.omJ = true;
                    WriteActivity.this.dYp();
                    if (WriteActivity.this.fCT != null) {
                        WriteActivity.this.fCT.bzG();
                    }
                }
            }
        });
        if (this.noo.getType() == 4) {
            this.onl.setHint(R.string.live_write_input_content_new);
        } else if (this.noo.getType() == 5) {
            this.onl.setHint(R.string.live_write_input_content_update);
        }
        this.onl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.onu = false;
                    WriteActivity.this.omJ = false;
                    WriteActivity.this.dYp();
                    if (WriteActivity.this.fCT != null) {
                        WriteActivity.this.fCT.bzG();
                    }
                }
            }
        });
        this.onl.requestFocus();
        this.onl.addTextChangedListener(awO());
        this.onp.requestFocus();
        this.onp.addTextChangedListener(awO());
        this.onp.setOnClickListener(this.omI);
        this.onl.setOnClickListener(this.omI);
        this.onk = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.onj);
        this.onk.Lx(6);
        this.onj.setAdapter((ListAdapter) this.onk);
        View findViewById = this.onm.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dXR() {
                WriteActivity.this.dZv();
            }
        });
        dYU();
    }

    private void dYU() {
        if (this.noo.getType() == 0) {
            if (this.noo.getTitle() != null) {
                this.onp.setText(this.noo.getTitle());
                this.onp.setSelection(this.noo.getTitle().length());
                return;
            }
            return;
        }
        if (this.noo.getType() == 1 || this.noo.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.omy) {
            dZt();
        }
        if (this.fCT.bBo()) {
            this.fCT.bzG();
        }
        LF(0);
    }

    public boolean dXi() {
        return !"1".equals(this.jOM) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private void LF(int i) {
        if (this.writeImagesInfo != null && this.noo != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.noo.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.noo.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dXi());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jOM);
            albumFloatActivityConfig.setStatisticFrom(this.noo.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(this.noo.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.ogN);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fFk;
            antiData.setIfVoice(this.onf);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.noo.getFirstDir(), this.noo.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dYV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fCT.bG(arrayList);
        m qV = this.fCT.qV(5);
        if (qV != null) {
            qV.fDG = 2;
        }
        this.fCT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fCT.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dYq() {
        m mVar;
        m mVar2;
        m mVar3;
        CustomResponsedMessage runTask;
        m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.fCT.b(dVar);
        }
        Boolean dZo = dZo();
        if (!this.omS && dZo != null && dZo.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dPk() && u.e(this.noo.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), m.class)) != null && (mVar4 = (m) runTask.getData()) != null) {
            mVar4.fDG = 2;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fCT.b(mVar4);
            }
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), m.class);
        if (runTask2 != null && (mVar3 = (m) runTask2.getData()) != null) {
            mVar3.fDG = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fCT.b(mVar3);
            }
        }
        if (!com.baidu.tieba.write.b.b.dXG() && !this.isEvaluate) {
            this.fCT.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        this.fCT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        if (au.equals(this.jOM, "2")) {
            this.ool = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.isEvaluate) {
                this.ool.kS(false);
                this.ool.setEnable(false);
            }
            this.fCT.b(this.ool);
            if (!this.isEvaluate) {
                this.fCT.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), m.class);
        if (runTask3 != null && (mVar2 = (m) runTask3.getData()) != null) {
            mVar2.fDI = true;
            mVar2.fDG = 9;
            mVar2.fDA = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fCT.b(mVar2);
            }
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), m.class);
        if (runTask4 != null && (mVar = (m) runTask4.getData()) != null) {
            mVar.fDI = true;
            mVar.fDG = 10;
            mVar.fDA = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fCT.b(mVar);
            }
        }
        if (this.omn == null) {
            if (this.omC == null) {
                this.omC = new com.baidu.tieba.write.editor.b(getActivity(), this.jOM);
                this.omC.Lr(0);
                this.omC.zD(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.omC.dXv();
                this.omC.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dYR();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                this.omC.dXv();
            }
            this.fCT.b(this.omC);
        }
        if (!this.isEvaluate && !"main_tab".equals(this.mFrom)) {
            this.fCT.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fCT.bG(arrayList);
        m qV = this.fCT.qV(5);
        if (qV != null) {
            qV.fDG = 4;
        }
    }

    private void dYr() {
        if (this.omE != null) {
            this.omE.hideTip();
        }
    }

    private void dYW() {
        if (this.fCT != null) {
            this.fCT.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fCT != null && WriteActivity.this.fCT.fCW != null) {
                        if (WriteActivity.this.onG == null) {
                            WriteActivity.this.onG = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.onG.showTip(WriteActivity.this.fCT.fCW.qT(2));
                    }
                }
            });
        }
    }

    private void dYX() {
        if (this.onG != null) {
            this.onG.hideTip();
        }
    }

    private void dYs() {
        if (this.omE == null) {
            this.omE = new g(getPageContext());
        }
        this.omE.d(this.fCT);
    }

    private void cZL() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 9));
                        if (WriteActivity.this.dYF()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u)) {
                            com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                            if (uVar.bwy() == EmotionGroupType.BIG_EMOTION || uVar.bwy() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.zK(true);
                                    WriteActivity.this.dKh();
                                }
                            } else if (WriteActivity.this.dYF()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dYI();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.doy();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dZx();
                        WriteActivity.this.dKh();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.LG(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.omn == null) {
                            WriteActivity.this.bBX();
                            return;
                        }
                        switch (WriteActivity.this.fFl) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bBU();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bBS();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fFf != null) {
                            WriteActivity.this.fFf.yB(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.lnH = null;
                        } else {
                            WriteActivity.this.lnH = (String) aVar.data;
                        }
                        WriteActivity.this.zJ(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        arVar.dR("fid", WriteActivity.this.noo != null ? WriteActivity.this.noo.getForumId() : "");
                        TiebaStatic.log(arVar);
                        if (WriteActivity.this.noo == null || (videoInfo = WriteActivity.this.noo.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fCT.bBo()) {
                                        WriteActivity.this.fCT.bzG();
                                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.noo.setVideoInfo(null);
                        WriteActivity.this.dKh();
                        if (WriteActivity.this.omi != null) {
                            WriteActivity.this.omi.requestFocus();
                        }
                        WriteActivity.this.fCT.bzG();
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.omi);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.omd = true;
                        WriteActivity.this.zG(true);
                        if (!WriteActivity.this.dYH().isFocused() || WriteActivity.this.omh.getVisibility() != 0) {
                            WriteActivity.this.omc = "from_content";
                        } else {
                            WriteActivity.this.omc = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 8));
                        if (WriteActivity.this.omh.getVisibility() == 0) {
                            if (WriteActivity.this.omh.hasFocus()) {
                                WriteActivity.this.omi.requestFocus();
                                WriteActivity.this.omi.setSelection(WriteActivity.this.omi.getText().toString().length());
                            }
                            WriteActivity.this.omh.setVisibility(8);
                            if (WriteActivity.this.ook != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.ook.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.ook.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.omX.setVisibility(8);
                            WriteActivity.this.fCT.qS(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.omh.setVisibility(0);
                            if (WriteActivity.this.ook != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.ook.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.ook.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.omX.setVisibility(0);
                            WriteActivity.this.omh.requestFocus();
                            WriteActivity.this.fCT.qS(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dKh();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 10));
                        if (WriteActivity.this.onN != null && WriteActivity.this.onN.getWriteVoteData() != null) {
                            writeVoteData = WriteActivity.this.onN.getWriteVoteData();
                        }
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ar("c13800").aq("obj_source", 2));
                        WriteActivity.this.dYY();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.okX != null) {
                            WriteActivity.this.okX.Xm();
                        }
                        TiebaStatic.log(new ar("c12612").aq("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dWN();
                    }
                }
            }
        };
        this.fCT.setActionListener(16, bVar);
        this.fCT.setActionListener(14, bVar);
        this.fCT.setActionListener(24, bVar);
        this.fCT.setActionListener(3, bVar);
        this.fCT.setActionListener(10, bVar);
        this.fCT.setActionListener(11, bVar);
        this.fCT.setActionListener(12, bVar);
        this.fCT.setActionListener(13, bVar);
        this.fCT.setActionListener(15, bVar);
        this.fCT.setActionListener(18, bVar);
        this.fCT.setActionListener(20, bVar);
        this.fCT.setActionListener(25, bVar);
        this.fCT.setActionListener(27, bVar);
        this.fCT.setActionListener(29, bVar);
        this.fCT.setActionListener(43, bVar);
        this.fCT.setActionListener(56, bVar);
        this.fCT.setActionListener(48, bVar);
        this.fCT.setActionListener(46, bVar);
        this.fCT.setActionListener(49, bVar);
        this.fCT.setActionListener(47, bVar);
        this.fCT.setActionListener(55, bVar);
        this.fCT.setActionListener(58, bVar);
        this.fCT.setActionListener(22, bVar);
        this.fCT.setActionListener(21, bVar);
        this.fCT.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYY() {
        if (this.onb != null) {
            this.onb.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.ooo;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void dYZ() {
        final WriteVoteData writeVoteData;
        if (this.onV instanceof WriteVoteData) {
            writeVoteData = (WriteVoteData) this.onV;
            this.noo.setWriteVoteData(writeVoteData);
        } else if (this.noo.getWriteVoteData() != null) {
            writeVoteData = this.noo.getWriteVoteData();
        } else {
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.a(writeVoteData);
                TiebaStatic.log(new ar("c13800").aq("obj_source", 3));
            }
        };
        this.onN.aq(onClickListener);
        this.onN.setOnItemClickListener(onClickListener);
        this.onN.b(writeVoteData);
        this.onN.zM(true);
        dKh();
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
    public void LG(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBX() {
        if (this.fFf.clN()) {
            if (this.fFf.dOG()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dOB().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fFf.dOE();
            return;
        }
        b(0, true, null);
    }

    protected void zI(boolean z) {
        if (!z && this.ong != null) {
            this.ong.cFK();
        }
        if (this.omj != null) {
            this.omj.cancelLoadData();
        }
        if (this.fFf != null) {
            this.fFf.cancelLoadData();
        }
        if (this.onM != null) {
            this.onM.onDestroy();
        }
    }

    protected void dJZ() {
        zI(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.oop);
        if (this.ong != null) {
            this.ong.dPn();
        }
        dYr();
        dYX();
        TiebaPrepareImageService.StopService();
        zI(true);
        if (!this.oon) {
            dZa();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jvu, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.oni != null) {
            this.oni.destroy();
        }
        if (this.onF != null) {
            this.onF.TC();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZa() {
        if (this.noo != null && this.noo.getType() == 2 && this.onc) {
            finish();
        } else if (this.noo == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.noo.setTitle(dYH().getText().toString());
            this.noo.setContent(dYG().getText().toString());
            if (this.onJ != null) {
                this.noo.setEvaluationStar(this.onJ.getStarCount());
            }
            int type = this.noo.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.onS) {
                    if (this.noo.isEvaluate()) {
                        y.d(this.noo.getItem_id(), this.noo);
                    } else if (TextUtils.isEmpty(this.noo.getTopicId())) {
                        y.c(this.noo.getForumId(), this.noo);
                    } else {
                        y.e(this.noo.getTopicId(), this.noo);
                    }
                }
            } else if (type == 7) {
                if (this.onS) {
                    y.c("24591571", this.noo);
                }
            } else if (type == 1) {
                y.b(this.noo.getThreadId(), this.noo);
            } else if (type == 4) {
                y.c(this.noo.getForumId() + "photolive", this.noo);
            } else if (type == 5) {
                y.b(this.noo.getThreadId() + "updatephotolive", this.noo);
            }
            this.oon = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHI() {
        if (this.lWH == null || ((!this.lWH.isEnabled() && !this.isEvaluate) || ((this.isEvaluate && TextUtils.isEmpty(this.omi.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.onM == null || !this.onM.isVisible()))) || !this.onS))) {
            cHb();
            dPt();
            setResult(100);
            finish();
            return;
        }
        if (this.jvv == null) {
            this.jvv = new SaveDraftDialogView(this);
            this.jvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cHb();
                            WriteActivity.this.dPt();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dZa();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jvu.dismiss();
                    }
                }
            });
        }
        if (this.jvu == null) {
            this.jvu = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jvu.setContentView(this.jvv);
        }
        boolean z = (this.onM == null || !this.onM.isVisible() || this.noo == null || this.noo.getVideoInfo() == null || this.noo.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jvv.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jvu.QH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHb() {
        if (this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 11) {
            if (this.onS) {
                if (this.noo.isEvaluate()) {
                    y.d(this.noo.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(this.noo.getTopicId())) {
                    y.a(this.noo.getForumId(), this.noo, true);
                } else {
                    y.e(this.noo.getTopicId(), (WriteData) null);
                }
            }
        } else if (this.noo.getType() == 1) {
            y.b(this.noo.getThreadId(), (WriteData) null);
        }
        this.oon = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPt() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nMR));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.noO != null && this.noO.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.noO, getPageContext().getPageActivity());
                return true;
            } else if (this.fCT.bBo()) {
                this.fCT.bzG();
                return true;
            } else {
                dJZ();
                cHI();
                return true;
            }
        }
        if (i == 67 && (text = dYG().getText()) != null) {
            int selectionStart = dYG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dYG().onKeyDown(67, this.iUi);
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
        getLayoutMode().onModeChanged(this.lzu);
        getLayoutMode().onModeChanged(this.onz);
        ap.setBackgroundColor(this.lzu, R.color.CAM_X0205);
        if (this.onw != null && (i == 1 || i == 4)) {
            this.onw.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lWH.setTextColor(ap.aM(R.color.CAM_X0302, i));
        dYp();
        ap.setBackgroundColor(this.noJ, R.color.CAM_X0204);
        ap.setBackgroundColor(this.onn, R.color.CAM_X0204);
        ap.setBackgroundColor(dYH(), R.color.CAM_X0205);
        this.lVT.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.lnH)) {
            ap.setBackgroundColor(dYG(), R.color.CAM_X0205);
        }
        dKh();
        this.fCT.onChangeSkinType(i);
        if (this.omw != null) {
            this.omw.bus();
        }
        if (this.onY != null) {
            this.onY.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.oni.ooN.notifyDataSetChanged();
        dYu();
        dYv();
        zJ(false);
        if (this.omD != null) {
            this.omD.c(dYH(), dYG());
        }
        if (this.onH != null) {
            this.onH.onChangeSkinType();
        }
        if (this.onJ != null) {
            this.onJ.onChangeSkinType();
        }
        if (this.omF != null) {
            this.omF.onChangeSkinType(i);
        }
        if (this.onM != null) {
            this.onM.bur();
        }
        if (this.onN != null) {
            this.onN.onChangeSkinType(i);
        }
        if (this.ood != null) {
            this.ood.onChangeSkinType(i);
        }
        if (this.omV != null) {
            this.omV.onChangeSkinType(i);
        }
        if (this.onK != null) {
            ap.setViewTextColor(this.onK, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYu() {
        if (this.noI.hasFocus()) {
            this.noI.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.noI.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        if (this.omi.hasFocus()) {
            this.omi.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.omi.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYv() {
        if (this.noI != null && this.noI.getText() != null && this.noI.getText().toString() != null && this.noI.getPaint() != null) {
            if (this.noI.getText().toString().length() == 0) {
                this.noI.getPaint().setFakeBoldText(true);
            } else if (this.noI.getText().toString().length() > 0) {
                this.noI.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable) {
        g(editable);
        f(editable);
    }

    private void f(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.onJ.dXW()) {
            this.lWH.setEnabled(true);
        } else {
            this.lWH.setEnabled(false);
        }
    }

    private void g(Editable editable) {
        if (editable.length() > 500) {
            this.onK.setText((500 - editable.length()) + "/500");
            this.onK.setVisibility(0);
            return;
        }
        this.onK.setVisibility(4);
    }

    private void initUI() {
        this.fNE = new com.baidu.tbadk.core.view.a(getPageContext());
        this.omy = this.noo.getType() == 4 || 5 == this.noo.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.ona = (TextView) findViewById(R.id.btn_image_problem);
        dYy();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lWH.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lWH.setLayoutParams(layoutParams);
        this.lWH.setOnFocusChangeListener(this.hzb);
        this.omx = (ScrollView) findViewById(R.id.write_scrollview);
        this.omx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.omi != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.omi);
                    }
                    if (WriteActivity.this.fCT != null) {
                        WriteActivity.this.fCT.bzG();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.omY = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.omZ = findViewById(R.id.feedback_divider);
        this.lzu = (RelativeLayout) findViewById(R.id.parent);
        this.omg = (LinearLayout) findViewById(R.id.tool_view);
        this.omg.setContentDescription(IStringUtil.TOP_PATH);
        this.omh = (LinearLayout) findViewById(R.id.title_view);
        this.ook = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.omX = findViewById(R.id.title_view_divider);
        this.noJ = findViewById(R.id.interval_view);
        this.omA = (TextView) findViewById(R.id.hot_topic_title_edt);
        dKg();
        if (this.omy) {
            this.omx.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dYT();
        } else {
            this.oni = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.oni.zA(false);
            } else {
                this.oni.zA(this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 11);
            }
            this.onM = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.noo.getVideoInfo() != null && this.noo.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.onM.eag();
            } else {
                aD(true, false);
            }
        }
        dKi();
        if (this.omS || this.omf) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.b.e.getInstance().fdq) {
                    com.baidu.tbadk.core.util.b.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.b.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.noL = (LinearLayout) findViewById(R.id.post_content_container);
        this.noL.setDrawingCacheEnabled(false);
        this.noL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.omi.requestFocus();
            }
        });
        this.lVQ = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lVR = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lVT = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lVT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.doy();
            }
        });
        f(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.hzb);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dJZ();
                WriteActivity.this.cHI();
            }
        });
        this.ona.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dYB();
        u(dZo());
        dYD();
        dYx();
        dZm();
        dYp();
        dYC();
        dKf();
        dYJ();
        if (this.noo.getType() == 4 && this.noQ != null && this.omk != null) {
            this.noQ.setVisibility(8);
            this.omk.setVisibility(8);
        }
        dKh();
        dZi();
        dZh();
        dZb();
        dYw();
        dZc();
        dZd();
        dZn();
        dZe();
        bSl();
    }

    private void dZb() {
        if ("main_tab".equals(this.mFrom) && !this.onT) {
            this.onH = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.onH.setVisibility(0);
        }
    }

    private void dYw() {
        if (!this.isEvaluate) {
            this.omF = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.omF.setBgColor(R.color.CAM_X0205);
            this.onL = findViewById(R.id.frs_tab__divider);
            this.omF.setData(this.ogN);
            if (this.omF.getVisibility() == 0) {
                this.onL.setVisibility(0);
            }
            this.omF.setActivity(this);
        }
    }

    private void dZc() {
        if (this.isEvaluate) {
            this.onK = (TextView) findViewById(R.id.post_content_counter);
            this.onJ = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.onJ.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void au(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.omi.getText()) || WriteActivity.this.omi.getText().length() < 20 || WriteActivity.this.omi.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lWH.setEnabled(false);
                    } else {
                        WriteActivity.this.lWH.setEnabled(true);
                    }
                }
            });
            this.onJ.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lWH.setEnabled(false);
                }
            });
        }
    }

    private void dZd() {
        if (this.isEvaluate) {
            this.onJ.setVisibility(0);
            if (!this.jvE) {
                if (this.onQ) {
                    this.onJ.setShowItemInfo(false);
                }
                if (this.onP != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.onP.id));
                    tbRichTextEvaluateItemInfo.setTags(this.onP.tags);
                    tbRichTextEvaluateItemInfo.setScore(this.onP.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(F(this.onP.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.onP.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.onP.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.onP.name);
                    this.onJ.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.onJ.setStarCount(this.onR);
                    this.noo.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.noo.setEvaluationStar(this.onR);
                } else if (this.noo.getItemInfo() != null) {
                    this.onJ.setItemInfo(this.noo.getItemInfo());
                    this.onJ.setStarCount(this.noo.getEvaluationStar());
                }
            }
        }
    }

    private int F(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void dZe() {
        this.onZ = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.ooa = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.oob = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.oob, R.color.CAM_X0107);
        this.ood = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
        this.ood.setTitle(getResources().getString(R.string.protocol_title));
        this.ood.Vh("file:///android_asset/protocol.html");
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.ood, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.oob.setText(spannableString);
        this.oob.setMovementMethod(LinkMovementMethod.getInstance());
        this.ooa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.ooe) {
                    WriteActivity.this.ooe = false;
                    WriteActivity.this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.ooe = true;
                    WriteActivity.this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.ooe) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nA(R.color.CAM_X0105);
                    aVar.AA("");
                    aVar.AB(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.nB(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bqz();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.ooe = true;
            this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.ooe = false;
            this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.ood.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.view.EBusinessProtocolView.a
            public void zn(boolean z) {
                if (z) {
                    if (!WriteActivity.this.ooe) {
                        WriteActivity.this.ooe = true;
                        WriteActivity.this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.ooe) {
                    WriteActivity.this.ooe = false;
                    WriteActivity.this.ooa.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void dZf() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.ooo = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.onb = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.onb.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.onb.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.onb.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.onb.setLayoutParams(layoutParams2);
        this.onb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dZg();
            }
        });
        this.onb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZg() {
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

    private void dZh() {
        if (this.mName != null && this.noo != null && this.noo.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dYx() {
        String str;
        String str2;
        if (this.noo != null) {
            switch (this.noo.getType()) {
                case 0:
                case 9:
                    if (this.omS || this.omf) {
                        if (this.omU) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jOM != null && this.jOM.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.jOM != null && this.jOM.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.noo.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.noo.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.noo.getForumName() + getResources().getString(R.string.bar));
                        this.noI.setVisibility(8);
                        String str3 = this.jga + " " + this.jfY;
                        if (!StringUtils.isNull(str3)) {
                            this.omi.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.noI.setVisibility(0);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.noI.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.noo.getFloorNum() + 1)));
                    this.onn.setVisibility(8);
                    return;
                case 7:
                    this.noI.setVisibility(0);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.noI.setVisibility(0);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void dYy() {
        if (this.noo.getType() == 7) {
            this.lWH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lWH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dYz() {
        if (this.noo != null && this.noo.getType() == 0 && this.noo.getType() == 9 && !this.omS && !this.omf && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dYH() != null) {
                dYH().setText(cutStringWithSuffix);
                dYH().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.noo.setVoiceModel(voiceModel);
            this.lVQ.setVisibility(0);
            this.lVR.setVoiceModel(voiceModel);
            this.lVR.ccH();
            dKh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BS(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.noo.setVoiceModel(null);
        this.lVQ.setVisibility(8);
        this.lVR.cQI();
        this.lVR.setVoiceModel(null);
        m qV = this.fCT.qV(6);
        if (qV != null && qV.fCN != null) {
            qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dKh();
    }

    private void dYA() {
        ad yY = ac.cEL().yY(1);
        if (yY != null) {
            this.gOO = yY.jmH;
            if (this.gOO != null && !this.gOO.isEmpty() && this.omt >= 0) {
                this.oms = new ab();
                this.oms.jmD = 0;
                this.oms.name = getPageContext().getResources().getString(R.string.category_auto);
                this.omv = this.oms.jmD;
                this.omu = this.oms.name;
                for (ab abVar : this.gOO) {
                    if (abVar.jmD == this.omt) {
                        this.omv = abVar.jmD;
                        this.omu = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dYB() {
        if (this.gOO != null && !this.gOO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.omw = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.omw.setText(this.omu);
            this.omw.setCategoryContainerData(this.gOO, this.oms, this.omv);
            this.omw.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        WriteActivity.this.omw.setText(bcVar.name);
                        WriteActivity.this.noo.setCategoryTo(bcVar.jmD);
                        WriteActivity.this.omv = bcVar.jmD;
                        WriteActivity.this.omw.dXT();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.omw.dXS();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYG());
                }
            });
        }
    }

    private void dZi() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.omM = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.omM.setTitle(R.string.no_disturb_start_time);
        this.omM.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.omM);
        this.omM.setButton(-2, getPageContext().getString(R.string.cancel), this.omM);
        return this.omM;
    }

    private void dYC() {
        this.omo = (RelativeLayout) findViewById(R.id.addition_container);
        this.omp = (TextView) findViewById(R.id.addition_create_time);
        this.omq = (TextView) findViewById(R.id.addition_last_time);
        this.omr = (TextView) findViewById(R.id.addition_last_content);
        if (this.omn != null) {
            this.omo.setVisibility(0);
            this.omp.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.omn.getCreateTime() * 1000));
            if (this.omn.getAlreadyCount() == 0) {
                this.omq.setVisibility(8);
            } else {
                this.omq.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.omn.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.omn.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.omr.setText(lastAdditionContent);
            } else {
                this.omr.setVisibility(8);
            }
            dYG().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.omn.getAlreadyCount()), Integer.valueOf(this.omn.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.omo.setVisibility(8);
    }

    private void dKf() {
        this.noQ = findViewById(R.id.post_prefix_layout);
        if (this.onF == null) {
            this.onF = new com.baidu.tieba.c.e(getPageContext(), this.noQ);
            this.onF.eo(R.drawable.bg_tip_blue_up_left);
            this.onF.en(16);
            this.onF.pJ(true);
            this.onF.setUseDirectOffset(true);
            this.onF.xm(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.noN = (TextView) findViewById(R.id.post_prefix);
        this.omk = findViewById(R.id.prefix_divider);
        this.noP = (ImageView) findViewById(R.id.prefix_icon);
        dZj();
    }

    private void dZj() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.noQ.setVisibility(0);
            this.omk.setVisibility(0);
            this.onF.C(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nop = 0;
            this.noQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.noo.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.noN.setVisibility(0);
                    WriteActivity.this.noQ.setSelected(true);
                    SvgManager.bsU().a(WriteActivity.this.noP, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.noO, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fCT.bzG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.noI);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.omi);
                }
            });
            this.noN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ar("c13013").dR("fid", WriteActivity.this.noo.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.noN.setSelected(true);
                    SvgManager.bsU().a(WriteActivity.this.noP, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.noO, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fCT.bzG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYG());
                }
            });
            this.noO = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.noO.a(this);
            this.noO.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.noO.setOutsideTouchable(true);
            this.noO.setFocusable(true);
            this.noO.setOnDismissListener(this);
            this.noO.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            ap.getColor(R.color.CAM_X0108);
            SvgManager.bsU().a(this.noP, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.br(this.noN).nZ(R.color.CAM_X0105).ob(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.oml.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.oml.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zx(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zx(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.noO.addView(writePrefixItemLayout);
            }
            this.noO.setCurrentIndex(0);
            this.noN.setText(prefixs.get(0));
            LE(0);
            return;
        }
        this.noQ.setVisibility(8);
        this.omk.setVisibility(8);
    }

    private void dZk() {
        if (this.omS && this.noo != null) {
            this.omY.setVisibility(0);
            this.omZ.setVisibility(0);
            this.omj = new FeedBackModel(getPageContext());
            this.omj.VE(this.noo.getForumName());
            this.omj.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.omY.setVisibility(8);
                        WriteActivity.this.omZ.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.omY.setVisibility(8);
                        WriteActivity.this.omZ.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.omY.a(feedBackModel.dYa(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dYD() {
        this.lWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.onH == null || WriteActivity.this.onI != null) {
                    if (WriteActivity.this.dZE()) {
                        if (!WriteActivity.this.oof || WriteActivity.this.ooe) {
                            if (WriteActivity.this.dZG()) {
                                int dZF = WriteActivity.this.dZF();
                                if (dZF == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dZF == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                                if (WriteActivity.this.omD.a(WriteActivity.this.noI, WriteActivity.this.omi)) {
                                    WriteActivity.this.showToast(WriteActivity.this.omD.dWH());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYH());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dYG());
                                WriteActivity.this.fCT.bzG();
                                if (WriteActivity.this.noo.getType() != 7) {
                                    if (WriteActivity.this.omS) {
                                        WriteActivity.this.cHe();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        ar arVar = new ar("c12102");
                                        arVar.aq("obj_type", StringUtils.isNull(WriteActivity.this.noo.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(arVar);
                                        WriteActivity.this.dYN();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cHe();
                                }
                                MercatorModel.dOT().startLoad();
                                TiebaStatic.log(new ar("c12262").dR("obj_locate", WriteActivity.this.jOM));
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

    protected void dKg() {
        this.omW = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.omW.setIsRound(true);
        this.omW.setDrawBorder(false);
        this.omW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String Bc = r.Bc(currentPortrait);
            this.omW.setUrl(Bc);
            this.omW.startLoad(Bc, 12, false);
        }
        if (this.noo.isUserFeedback()) {
            this.omW.setVisibility(0);
        }
        this.noI = (EditText) findViewById(R.id.post_title);
        this.noI.setOnClickListener(this.omI);
        this.noI.setOnFocusChangeListener(this.hzb);
        if (this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 11 || this.noo.getType() == 7) {
            if (this.noo.getTitle() != null) {
                this.noI.setText(this.noo.getTitle());
                this.noI.setSelection(this.noo.getTitle().length());
            } else if (this.omU) {
                this.noI.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.noo.getType() == 1 || this.noo.getType() != 2) {
        }
        this.noI.addTextChangedListener(this.omK);
        com.baidu.tbadk.core.elementsMaven.c.br(this.noI).ob(R.string.F_X02);
        if (!this.noo.getHaveDraft()) {
            dYz();
            this.onD = true;
        }
        this.omV = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher awO() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText cCD = null;
            private TextView mTextView = null;
            private int oot;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dKh();
                if (WriteActivity.this.omy) {
                    this.oot = this.cCD.getSelectionStart();
                    this.cCD.setSelection(this.oot);
                    WriteActivity.this.a(this.mTextView, this.cCD);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.omy || !WriteActivity.this.onu) {
                    if (WriteActivity.this.omy) {
                        if (this.cCD != WriteActivity.this.onl || this.mTextView != WriteActivity.this.onr) {
                            this.cCD = WriteActivity.this.onl;
                            this.mTextView = WriteActivity.this.onr;
                        }
                    }
                } else if (this.cCD != WriteActivity.this.onp || this.mTextView != WriteActivity.this.onq) {
                    this.cCD = WriteActivity.this.onp;
                    this.mTextView = WriteActivity.this.onq;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.omy && this.onu) {
            if (this.ons != null) {
                this.onp.removeTextChangedListener(this.ons);
            }
            this.ons = textWatcher;
        } else if (this.omy) {
            if (this.ont != null) {
                this.onl.removeTextChangedListener(this.ont);
            }
            this.ont = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.onl) {
            return 233L;
        }
        if (editText != this.onp) {
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

    protected void dKi() {
        this.omi = (SpanGroupEditText) findViewById(R.id.post_content);
        this.omi.setDrawingCacheEnabled(false);
        this.omi.setOnClickListener(this.omI);
        this.omi.setOnSpanGroupChangedListener(new a.InterfaceC0571a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0571a
            public void G(int i, boolean z) {
                WriteActivity.this.KA();
            }
        });
        this.omi.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.omi.setForumId(com.baidu.adp.lib.f.b.toLong(this.noo.getForumId(), 0L));
        if (this.ong != null) {
            this.ong.setSpanGroupManager(this.omi.getSpanGroupManager());
        }
        if (this.noo != null) {
            this.noo.setSpanGroupManager(this.omi.getSpanGroupManager());
        }
        if (this.noo.getContent() != null && this.noo.getContent().length() > 0) {
            this.omi.setText(TbFaceManager.bCR().aD(getPageContext().getPageActivity(), this.noo.getContent()));
            if (this.omi.getText() != null) {
                this.omi.setSelection(this.omi.getText().length());
            }
        } else if (this.noo.getType() == 2) {
            if (this.onc) {
                if (this.ond != null && this.ond.length() > 0) {
                    this.omi.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.ond}));
                    this.omi.setSelection(this.omi.getText().length());
                }
            } else if (this.noo.getFloorNum() > 0) {
                this.omi.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.noo.getFloorNum())));
                this.omi.setSelection(this.omi.getText().length());
            }
        }
        this.omi.setOnFocusChangeListener(this.hzb);
        this.omi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.omi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.omi.addTextChangedListener(this.omL);
        if (this.noo.getType() == 0) {
            this.onE = true;
        } else {
            zJ(true);
            this.onE = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.omi.setHint(spannableString);
        } else if (this.noo.isUserFeedback()) {
            this.omi.setHint(R.string.write_input_content);
        } else {
            this.omi.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zJ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.omy && dYG() != null) {
            dYG().setPadding(0, 0, 0, 0);
            dYG().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYG(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.lnH) || this.omn != null) {
                return;
            }
            if (this.onM == null || !this.onM.isVisible()) {
                com.baidu.adp.lib.e.d.mw().a(this.lnH, 19, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.onM == null || !WriteActivity.this.onM.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dYG().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dYG(), true, WriteActivity.this.mcV);
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

    private void dZl() {
        if (dYG() != null) {
            dYG().setPadding(0, 0, 0, 0);
            dYG().setBackgroundDrawable(null);
            ap.setBackgroundColor(dYG(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYF() {
        int i = 5000;
        if (this.omn != null) {
            i = 1000;
        }
        return dYG().getText() != null && dYG().getText().length() >= i;
    }

    private void CX(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.omc)) {
                this.omc = "";
                dYG().requestFocus();
                if (dYG().getText() != null && dYG().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYG().getSelectionStart();
                    editable = dYG().getText();
                }
            } else if ("from_title".equals(this.omc)) {
                this.omc = "";
                dYH().requestFocus();
                if (dYH().getText() != null && dYH().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYH().getSelectionStart();
                    editable = dYH().getText();
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
    public void zG(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.noo != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.noo.getForumId(), 0L), this.noo.getFirstDir(), this.noo.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dYG().getText().getSpans(0, dYG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.omm == null) {
                this.omm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.omm.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dYG());
    }

    EditText dYG() {
        return this.omy ? this.onl : this.omi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYH() {
        return this.omy ? this.onp : this.noI;
    }

    protected void dYI() {
        if (dYG().getSelectionStart() > 0) {
            String substring = dYG().getText().toString().substring(0, dYG().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iUh.matcher(substring);
            if (matcher.find()) {
                dYG().getText().delete(dYG().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dYG().getSelectionStart());
                return;
            }
            dYG().onKeyDown(67, this.iUi);
        }
    }

    private void u(Boolean bool) {
        String str = null;
        if (this.noo != null) {
            str = this.noo.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.omS = true;
        }
    }

    private void dZm() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dZn() {
        this.onO = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.onN = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.onO);
        dYZ();
    }

    private void bSl() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.onY = new d(getPageContext());
        this.onY.a(this.onX);
        this.mListView.setAdapter((ListAdapter) this.onY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.onY != null && (WriteActivity.this.onY.getItem(i) instanceof v)) {
                    v vVar = (v) WriteActivity.this.onY.getItem(i);
                    if (vVar.mType == 1) {
                        if (vVar.eOu == 1) {
                            bf.bsY().b(WriteActivity.this.getPageContext(), new String[]{vVar.eOm});
                        } else {
                            bf.bsY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eOm)});
                        }
                    } else if (vVar.mType == 2) {
                        if (!TextUtils.isEmpty(vVar.eOp)) {
                            if (vVar.eOp.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, vVar.eOp));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(vVar.eOp));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(vVar.eOq)) {
                                bf.bsY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eOq)});
                            }
                        } else if (!TextUtils.isEmpty(vVar.eOq)) {
                            bf.bsY().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(vVar.eOq)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fNE.setCancelListener(null);
        this.fNE.setTipString(R.string.sending);
        this.fNE.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fNE != null) {
            this.fNE.setDialogVisiable(false);
        }
    }

    private Boolean dZo() {
        return Boolean.valueOf(this.onf);
    }

    public void dKh() {
        if (this.noo != null) {
            String str = "";
            String str2 = "";
            if (dYH() != null) {
                str = dYH().getText().toString();
            }
            if (dYG() != null) {
                str2 = dYG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.nop == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.noo.setIsNoTitle(true);
                        } else if (this.omh.getVisibility() == 0) {
                            this.noo.setIsNoTitle(false);
                            zH(true);
                            return;
                        }
                    } else if (this.omh.getVisibility() == 0) {
                        this.noo.setIsNoTitle(false);
                        zH(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.noo.setIsNoTitle(true);
                } else if (this.omh.getVisibility() == 0) {
                    this.noo.setIsNoTitle(false);
                    zH(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.omy) {
                    zH(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zH(true);
                }
            }
            if (this.noo.getType() == 4) {
                zH(n(this.onl) && m(this.onp));
            } else if (this.noo.getType() == 5) {
                zH(n(this.onl));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zH(true);
            } else if (this.noo.getVideoInfo() != null) {
                zH(this.noo.getVideoInfo().isVideoMixFinished());
            } else if (dZC()) {
                zH(true);
            } else {
                zH(false);
            }
        }
    }

    public void zH(boolean z) {
        if (!z || !this.isEvaluate || (this.omi != null && !TextUtils.isEmpty(this.omi.getText()) && this.omi.getText().length() >= 20 && this.omi.getText().length() <= 500 && this.onJ != null && this.onJ.dXW())) {
            this.lWH.setEnabled(z);
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
        this.ong = com.baidu.tieba.tbadkCore.writeModel.a.dPl();
        this.ong.a(this);
        this.noo = new WriteData();
        if (bundle != null) {
            this.noo.setType(bundle.getInt("type", 0));
            this.noo.setForumId(bundle.getString("forum_id"));
            this.noo.setForumName(bundle.getString("forum_name"));
            this.noo.setFirstDir(bundle.getString("forum_first_dir"));
            this.noo.setSecondDir(bundle.getString("forum_second_dir"));
            this.noo.setThreadId(bundle.getString("thread_id"));
            this.noo.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.noo.setFloorNum(bundle.getInt("floor_num", 0));
            this.noo.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.omn = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.noo.setIsAddition(this.omn != null);
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.noo.setTopicId(this.mTopicId);
            this.noo.setTitle(bundle.getString("write_title"));
            this.noo.setContent(bundle.getString("write_content"));
            this.noo.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.omS = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.omT = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.omU = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.onc = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ond = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.onW = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fFe = bundle.getString(WriteActivityConfig.PHOTO_NAME);
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
            this.jOM = bundle.getString("KEY_CALL_FROM");
            this.bMF = bundle.getInt("album_thread");
            this.ogN = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.noo.setType(intent.getIntExtra("type", 9));
            this.noo.setForumId(intent.getStringExtra("forum_id"));
            this.noo.setForumName(intent.getStringExtra("forum_name"));
            this.noo.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.noo.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.noo.setThreadId(intent.getStringExtra("thread_id"));
            this.noo.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.noo.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.omn = (AdditionData) intent.getSerializableExtra("addition_data");
            this.noo.setIsAddition(this.omn != null);
            this.noo.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.noo.setTitle(intent.getStringExtra("write_title"));
            this.noo.setContent(intent.getStringExtra("write_content"));
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.noo.setTopicId(this.mTopicId);
            this.noo.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.noo.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.omS = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.omT = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.omU = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.onc = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ond = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.jfZ = intent.getStringExtra("more_forum_img");
            this.jga = intent.getStringExtra("more_forum_title");
            this.jfY = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jOM = intent.getStringExtra("KEY_CALL_FROM");
            this.bMF = intent.getIntExtra("album_thread", 0);
            this.onW = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.ogN = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.noo.setFrsTabInfoData(this.ogN);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.isEvaluate = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.noo.setIsEvaluate(this.isEvaluate);
            this.onQ = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.onR = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                this.onP = (SerializableItemInfo) serializableExtra;
                this.noo.setItem_id(String.valueOf(this.onP.id));
            }
            this.jvE = getIntent().getBooleanExtra("item_is_school", false);
            this.onS = getIntent().getBooleanExtra("need_save_draft", true);
            this.onT = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.omt = getIntent().getIntExtra("category_id", -1);
            this.onU = getIntent().getStringExtra("goods_list");
            this.onV = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.onf = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.fFk = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.onT && com.baidu.tieba.tbadkCore.writeModel.c.nDq != null) {
                this.noo = com.baidu.tieba.tbadkCore.writeModel.c.nDq;
                this.noo.setType(9);
                this.noo.setContent(this.noo.getContentString());
                this.writeImagesInfo = this.noo.getWriteImagesInfo();
                this.ogN = this.noo.getFrsTabInfoData();
                if (this.noo.getItemInfo() != null) {
                    this.onP = null;
                }
                this.mVoiceModel = this.noo.getVoiceModel();
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.noo.getType() == 9) {
            this.noo.setEntranceType(1);
        } else if (this.noo.getType() == 10) {
            this.noo.setEntranceType(2);
            this.noo.setType(9);
        } else if (this.noo.getType() == 0) {
            this.noo.setEntranceType(3);
        }
        this.noo.setIsUserFeedback(this.omS);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.onW != null) {
            this.writeImagesInfo.parseJson(this.onW);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.noo.getType() == 4 ? 6 : 9);
        this.noo.setWriteImagesInfo(this.writeImagesInfo);
        this.lnH = TbadkCoreApplication.getInst().getDefaultBubble();
        dYA();
        if (this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 11) {
            if (this.onS) {
                if (this.noo.isEvaluate()) {
                    y.c(this.noo.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.noo.getTopicId())) {
                    y.b(this.noo.getForumId(), this);
                } else {
                    y.d(this.noo.getTopicId(), this);
                }
            }
        } else if (this.noo.getType() == 7) {
            if (this.onS) {
                y.b("24591571", this);
            }
        } else if (this.noo.getType() == 1) {
            y.a(this.noo.getThreadId(), this);
        } else if (this.noo.getType() == 4) {
            y.b(this.noo.getForumId() + "photolive", this);
        } else if (this.noo.getType() == 5) {
            y.a(this.noo.getThreadId() + "updatephotolive", this);
        }
        if (this.noo != null && this.noo.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.noo.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.omf = true;
        }
        try {
            this.onv = dZz();
        } catch (Throwable th) {
            this.onv = null;
        }
    }

    private void dZp() {
        this.mNavigationBar.postDelayed(this.oop, 500L);
    }

    private void dYJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.noI.setText(com.baidu.tbadk.plugins.b.DF(com.baidu.tbadk.plugins.b.DG(hotTopicBussinessData.mTopicName)));
            this.noI.setMovementMethod(com.baidu.tieba.view.c.dWg());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString DF = com.baidu.tbadk.plugins.b.DF(com.baidu.tbadk.plugins.b.DG(hotTopicBussinessData.mTopicName));
            if (DF != null) {
                this.noI.setText(DF);
            }
            this.omA.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.oof && !this.onT) {
            if (writeData != null) {
                if (this.noo != null && writeData.isEvaluate() == this.noo.isEvaluate()) {
                    boolean z = this.noo.getVideoInfo() != null && this.noo.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.noo.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.noo.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dYH().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dYG().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    this.noo.setHaveDraft(true);
                    if (!z2 && !z) {
                        i(writeData);
                    }
                    if (!z3 || this.onD || ((this.omS || this.omf) && z5)) {
                        j(writeData);
                    }
                    if (z6 && (!z4 || this.omS || this.omf)) {
                        k(writeData);
                    }
                    if (this.noo != null && !this.noo.getHaveDraft()) {
                        dYz();
                    }
                    if (writeData.getItemInfo() != null) {
                        this.noo.setItemInfo(writeData.getItemInfo());
                        this.noo.setEvaluationStar(writeData.getEvaluationStar());
                        this.onP = null;
                        dZd();
                    }
                    if (writeData.getWriteVoteData() != null) {
                        this.noo.setWriteVoteData(writeData.getWriteVoteData());
                        dYZ();
                    }
                    if (writeData.getVoiceModel() != null) {
                        f(writeData.getVoiceModel());
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dZq();
                    }
                    dKh();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.gOO != null) {
                        this.omv = this.oms.jmD;
                        this.omu = this.oms.name;
                        while (true) {
                            if (i == this.gOO.size()) {
                                break;
                            }
                            ab abVar = this.gOO.get(i);
                            if (categoryTo != abVar.jmD) {
                                i++;
                            } else {
                                this.omv = categoryTo;
                                this.omu = abVar.name;
                                this.noo.setCategoryTo(this.omv);
                                break;
                            }
                        }
                        if (this.omw != null) {
                            this.omw.setText(this.omu);
                            this.omw.setCategoryContainerData(this.gOO, this.oms, this.omv);
                        }
                    }
                    this.fCT.bzG();
                    return;
                }
                return;
            }
            dZq();
            dYz();
        }
    }

    private void i(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.noo.setVideoInfo(videoInfo);
            aD(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.noo.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dYP();
        }
        zK(false);
        aD(true, true);
    }

    private void j(WriteData writeData) {
        String str;
        String DG;
        if (com.baidu.adp.lib.util.k.isEmpty(this.noo.getTitle())) {
            this.noo.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                DG = this.noo.getTitle();
            } else {
                DG = com.baidu.tbadk.plugins.b.DG(str);
            }
            SpannableString DF = com.baidu.tbadk.plugins.b.DF(DG);
            if (DF != null) {
                dYH().setText(DF);
                dYH().setSelection(DF.length() > DG.length() ? DG.length() : DF.length());
                return;
            }
            return;
        }
        SpannableString DF2 = com.baidu.tbadk.plugins.b.DF(this.noo.getTitle());
        if (DF2 != null) {
            dYH().setText(DF2);
            dYH().setSelection(this.noo.getTitle().length() > DF2.length() ? DF2.length() : this.noo.getTitle().length());
        }
    }

    private void k(WriteData writeData) {
        this.noo.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bCR().a(getPageContext().getPageActivity(), this.noo.getContent(), this.omG);
        InputFilter[] filters = this.omi.getFilters();
        this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dYG().setText(a2);
        if (dYG() == this.omi && this.omi.getSpanGroupManager() != null) {
            this.omi.bvd();
            this.omi.getSpanGroupManager().bvj();
            this.omi.bve();
            KA();
        }
        this.omi.setFilters(filters);
        if (dYG().getText() != null) {
            dYG().setSelection(dYG().getText().length());
        }
        if (this.omy) {
            a(this.onr, this.onl);
        }
    }

    private void dZq() {
        if ((!this.omy || this.onk != null) && this.onj != null) {
            this.onk.b(this.writeImagesInfo);
            dZv();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.noo.getType());
        bundle.putString("forum_id", this.noo.getForumId());
        bundle.putString("forum_name", this.noo.getForumName());
        bundle.putString("forum_first_dir", this.noo.getFirstDir());
        bundle.putString("forum_second_dir", this.noo.getSecondDir());
        bundle.putString("thread_id", this.noo.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.noo.getFloor());
        bundle.putInt("floor_num", this.noo.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.onc);
        if (this.omS) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fFe);
        if (this.omn != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.omn));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jOM);
        bundle.putInt("album_thread", this.bMF);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.ogN);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.noo.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dYG().getEditableText().toString();
        if (obj != null) {
            dYG().setText(TbFaceManager.bCR().a(getPageContext().getPageActivity(), obj, this.omG));
            dYG().setSelection(dYG().getText().length());
        }
    }

    private String getContent() {
        return (dYG() == null || dYG().getText() == null) ? "" : dYG().getText().toString();
    }

    private String dYL() {
        if (this.noo == null || dYH() == null || dYH().getVisibility() != 0 || dYH().getText() == null) {
            return "";
        }
        String obj = dYH().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nop != com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.noo.getType() != 4 && this.noN != null && this.noN.getText() != null) {
            this.noo.setPostPrefix(this.noN.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.noo.getTitle();
        }
        return obj;
    }

    private void VF(String str) {
        if (this.noo != null && this.omh != null) {
            if (this.omh.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.noo.setIsNoTitle(true);
                    this.noo.setTitle("");
                    return;
                }
                this.noo.setIsNoTitle(false);
                this.noo.setTitle(str);
                return;
            }
            this.noo.setIsNoTitle(true);
            this.noo.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHe() {
        dJZ();
        this.noo.setContent(getContent());
        VF(dYL());
        if (this.omS || this.omf) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.noo.getTitle()) || !this.noo.getTitle().startsWith(string)) {
                VF(string + this.noo.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.noo.getContent()) || !this.noo.getContent().startsWith(str)) {
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
                sb.append(this.noo.getContent());
                this.noo.setContent(sb.toString());
            }
        }
        if (this.omT) {
            this.noo.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.omt >= 0) {
            this.noo.setCategoryFrom(this.omt);
        }
        if (this.omv >= 0) {
            this.noo.setCategoryTo(this.omv);
        }
        this.noo.setWriteImagesInfo(this.writeImagesInfo);
        if (this.onN != null) {
            this.noo.setWriteVoteData(this.onN.getWriteVoteData());
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
            this.noo.setTakePhotoNum(i);
        }
        this.noo.setHasLocationData(this.fFf != null && this.fFf.clN());
        if (this.writeImagesInfo != null) {
            this.ong.yD(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && this.omz != null && this.omz.mIsGlobalBlock == 0) {
            this.noo.setForumId(String.valueOf(this.omz.mForumId));
            this.noo.setForumName(this.omz.mForumName);
        }
        if (this.onJ != null && this.onJ.getEvaluateItemInfo() != null) {
            this.noo.setItem_id(this.onJ.getEvaluateItemInfo().getItemID());
            this.noo.setComment_head(cHd());
        }
        dYM();
        this.ong.f(this.noo);
        this.noo.setContent(this.noo.getContent().replaceAll("\u0000\n", ""));
        this.noo.setContent(this.noo.getContent().replaceAll("\u0000", ""));
        this.noo.setVcode(null);
        this.noo.setVoiceModel(this.mVoiceModel);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ong.daL().setVoice(this.mVoiceModel.getId());
                this.ong.daL().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ong.daL().setVoice(null);
                this.ong.daL().setVoiceDuringTime(-1);
            }
        } else {
            this.ong.daL().setVoice(null);
            this.ong.daL().setVoiceDuringTime(-1);
        }
        if (!this.ong.dPo()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            dZr();
        }
    }

    private void dZr() {
        this.ong.dPm();
        com.baidu.tieba.write.b.b.g(this.noo);
        cDh();
        dZa();
        setResult(100);
        finish();
    }

    private void dYM() {
        if (this.noo != null && this.omF != null) {
            this.noo.setIsForumBusinessAccount(this.ogN == null ? false : this.ogN.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.omF.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.noo.setTabId(selectedTabItemData.tabId);
                this.noo.setTabName(selectedTabItemData.name);
                this.noo.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.omn != null) {
                i2 = this.omn.getTotalCount();
                i = this.omn.getAlreadyCount() + 1;
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
                if (this.noI == getCurrentFocus()) {
                    dYG().clearFocus();
                    this.noI.requestFocus();
                    if (this.fCT != null) {
                        this.fCT.bzG();
                    }
                    ShowSoftKeyPadDelay(this.noI);
                } else {
                    dYG().requestFocus();
                    if (this.fCT != null) {
                        this.fCT.bzG();
                    }
                    ShowSoftKeyPadDelay(this.omi);
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
                            dYG().getText().insert(dYG().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cHb();
                dPt();
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
                                dZw();
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
                        if (this.onE) {
                            zJ(true);
                            this.onE = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.omy) {
                        G(intent);
                        dKh();
                        return;
                    }
                    ap(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.noo.setVideoInfo(videoInfo);
                        this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dKh();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.omd) {
                                sb2.append(com.baidu.tbadk.plugins.b.fMY);
                                this.omd = false;
                            }
                            sb2.append(stringExtra);
                            CX(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.omz = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.omz);
                    }
                } else if (i == 25048) {
                    Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                    if (serializableExtra instanceof WriteVoteData) {
                        this.onV = serializableExtra;
                        dYZ();
                    }
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.omi.getSelectionStart();
                    int selectionEnd = this.omi.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.omi.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fCT != null && !this.fCT.bBo()) {
                this.omi.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fCT.bzG();
            }
            switch (i) {
                case 12001:
                    bCa();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dZu();
                    if (this.onE) {
                        zJ(true);
                        this.onE = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.noI == getCurrentFocus()) {
                        dYG().clearFocus();
                        this.noI.requestFocus();
                        if (this.fCT != null) {
                            this.fCT.bzG();
                        }
                        ShowSoftKeyPadDelay(this.noI);
                        return;
                    }
                    dYG().requestFocus();
                    if (this.fCT != null) {
                        this.fCT.bzG();
                    }
                    ShowSoftKeyPadDelay(this.omi);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.omD.Vo(postWriteCallBackData.getErrorString());
                        this.omD.bg(postWriteCallBackData.getSensitiveWords());
                        this.omD.b(this.noI, this.omi);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fFe = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.fFe);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dZu();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.omc)) {
                        dYH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.omc)) {
                        dYG().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYN() {
        if ("1".equals(this.jOM)) {
            this.noo.setCanNoForum(true);
            this.noo.setTransmitForumData("[]");
        } else if ("2".equals(this.jOM)) {
            this.noo.setCanNoForum(false);
        }
        dYO();
        this.noo.setPrivacy(this.isPrivacy);
        dZs();
        this.noo.setToDynamic(this.isToDynamic);
        this.noo.setCallFrom(this.jOM);
        if (this.noo.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cHe();
    }

    private void dYO() {
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dZs() {
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dZt() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dZu() {
        if (this.omy) {
            this.onk.b(this.writeImagesInfo);
            dZv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZv() {
        this.onk.notifyDataSetChanged();
        this.onj.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.onk.notifyDataSetChanged();
                WriteActivity.this.onj.invalidateViews();
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
        dKh();
    }

    private void ao(Intent intent) {
        if (this.omy) {
            ap(intent);
            dZu();
        } else {
            as(intent);
        }
        dKh();
    }

    private void ap(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dZu();
            zK(true);
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

    private void dZw() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ar(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.onh.parseJson(stringExtra);
            this.onh.updateQuality();
            if (this.onh.getChosedFiles() != null && this.onh.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.onh.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.onh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dYH());
        HidenSoftKeyPad(this.mInputManager, dYG());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.onM != null) {
            this.onM.onPause();
        }
        if (this.fCT.bBo()) {
            this.fCT.bzG();
        }
    }

    private void as(Intent intent) {
        e(intent, true);
    }

    private void F(Intent intent) {
        this.fFe = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFe;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fFe, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dZx();
            dYP();
        }
        zK(true);
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
                dZx();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dYP();
                }
            }
            zK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZx() {
        if (this.fCT.qV(10) != null) {
            this.fCT.setToolEnabled(this.writeImagesInfo == null || com.baidu.tbadk.core.util.y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bCa() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                o.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fFe));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dZy() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.jfZ)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                p pVar = new p(this, this.jfZ, new p.a() { // from class: com.baidu.tieba.write.write.WriteActivity.53
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
                            WriteActivity.this.zK(true);
                        }
                    }
                });
                pVar.setFrom(1);
                pVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(boolean z) {
        String forumId = this.noo == null ? "" : this.noo.getForumId();
        if (this.oni != null) {
            this.oni.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cDh() {
        this.jie = getVoiceManager();
        this.jie.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jjA) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.noo.getType() != 7) {
                if (this.omn == null) {
                    com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                Q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fFl = i;
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dYP() {
        if (!this.omy) {
            if (this.fCT != null) {
                this.fCT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fCT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.noo == null ? "" : this.noo.getForumId();
            if (this.oni != null) {
                this.oni.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LE(int i) {
        if (i < this.oml.size()) {
            for (int i2 = 0; i2 < this.oml.size(); i2++) {
                this.oml.get(i2).zy(false);
            }
            this.oml.get(i).zy(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Jm(int i) {
        if (i == com.baidu.tbadk.core.util.y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ar("c13014").aq("obj_type", 1));
        } else {
            TiebaStatic.log(new ar("c13014").aq("obj_type", 2));
        }
        this.nop = i;
        this.noO.setCurrentIndex(i);
        LE(i);
        this.noN.setText(this.mPrefixData.getPrefixs().get(i));
        dKh();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.noO, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.noQ.setSelected(false);
        SvgManager.bsU().a(this.noP, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.omi);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes7.dex */
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
        if (this.noo != null) {
            if (this.noo.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.noo.getType() == 5) {
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
            bBU();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.fFe);
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
        this.bsF = z;
        if (this.onB && System.currentTimeMillis() - this.onC < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.onB = false;
        }
        if (this.omC != null && !z) {
            this.omC.cwF();
        }
        if (this.omE != null && !z) {
            dYr();
        }
        if (this.onG != null && !z) {
            dYX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VG(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.ony != null) {
            VH(str);
            this.ony.dismiss();
        }
    }

    private void hf(Context context) {
        onA = l.getEquipmentHeight(context);
    }

    private void VH(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.onB = true;
        dZx();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dYP();
        }
        zK(true);
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

    private File dZz() {
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

    private void dZA() {
        if (this.onv != null && this.noo.getType() == 0 && this.noo.getType() == 9 && this.noo.getType() == 11) {
            hf(getActivity());
            this.onx = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.onx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.onv != null) {
                        WriteActivity.this.VG(WriteActivity.this.onv.getAbsolutePath());
                    }
                }
            });
            this.onw = (TbImageView) this.onx.findViewById(R.id.rec_img_view);
            this.onz = (LinearLayout) this.onx.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.onv.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.onv.getAbsolutePath());
                Bitmap h = h(this.onv.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.onw.setImageBitmap(h);
                    this.onw.setDrawBorder(true);
                    this.onw.setBorderWidth(2);
                    this.onw.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.ony = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.ony.setCanceledOnTouchOutside(true);
                    this.ony.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.onB) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.onC = System.currentTimeMillis();
                            }
                        }
                    });
                    this.ony.setContentView(this.onx);
                    this.ony.show();
                    Window window = this.ony.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (onA / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bsF && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.omd = false;
            this.omc = "";
            if ("from_content".equals(str)) {
                this.omc = "from_content";
            } else if ("from_title".equals(str)) {
                this.omc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DE(String.valueOf(charSequence.charAt(i)))) {
                zG(false);
            }
        }
    }

    public void dEk() {
        if (this.isEvaluate) {
            this.omh.setVisibility(8);
            if (this.ook != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ook.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ook.setLayoutParams(layoutParams);
            }
            this.omX.setVisibility(8);
        } else if (com.baidu.tieba.write.b.b.dXG()) {
            this.noI.setHint(R.string.title_hint_for_hot);
            this.omh.setVisibility(0);
            if (this.ook != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ook.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.ook.setLayoutParams(layoutParams2);
            }
            this.omX.setVisibility(0);
            com.baidu.tieba.write.b.b.a(this.omV);
            this.omh.requestFocus();
        } else {
            this.omV.setVisibility(8);
            this.noI.setHint(this.omS ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.omS || !com.baidu.tbadk.core.util.y.isEmpty(this.mList) || (this.noo != null && !StringUtils.isNull(this.noo.getTitle()))) {
                this.omh.setVisibility(0);
                if (this.ook != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ook.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.ook.setLayoutParams(layoutParams3);
                }
                this.omX.setVisibility(0);
                this.omh.requestFocus();
                return;
            }
            this.omh.setVisibility(8);
            if (this.ook != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.ook.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ook.setLayoutParams(layoutParams4);
            }
            this.omX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZB() {
        if (this.fCT != null) {
            this.fCT.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fCT != null && WriteActivity.this.fCT.fCW != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (au.isEmpty(clipBoardContent) || !bf.bsY().l(clipBoardContent)) {
                            WriteActivity.this.omC.dwQ();
                            return;
                        }
                        if (WriteActivity.this.okX == null) {
                            WriteActivity.this.okX = new WriteTipBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.ooj);
                        }
                        WriteActivity.this.okX.a(WriteActivity.this.fCT.fCW.qT(31), WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jOM;
    }

    public WriteData daL() {
        return this.noo;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.ogN;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dZC() {
        return (this.onN == null || this.onO == null || this.onN.getWriteVoteData() == null || this.onO.getVisibility() != 0) ? false : true;
    }

    public void dWN() {
        if (!dZG()) {
            BdToast.b(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
        } else if (!this.canGoods) {
            BdToast.b(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
        } else {
            if (this.noo != null) {
                TiebaStatic.log(new ar("c13897").aq("obj_locate", 2).dR("fid", this.noo.getForumId()).dR("fname", this.noo.getForumName()));
            }
            if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nB(2);
                aVar.jG(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new ar("c13959").aq("obj_locate", 2).dR("fid", WriteActivity.this.noo != null ? WriteActivity.this.noo.getForumId() : "").dR("fname", WriteActivity.this.noo != null ? WriteActivity.this.noo.getForumName() : ""));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dZD()));
                        }
                    }
                });
                aVar.bn(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new ar("c13958").aq("obj_locate", 2).dR("fid", this.noo != null ? this.noo.getForumId() : "").dR("fname", this.noo != null ? this.noo.getForumName() : ""));
                aVar.b(getPageContext()).bqz();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dZD()));
        }
    }

    public void KA() {
        if (this.onY != null && this.onY.dYc() == null && this.omi != null && this.omi.getSpanGroupManager() != null) {
            this.onY.h(this.omi.getSpanGroupManager().bvo());
            this.onY.refreshData();
        } else if (this.onY != null && this.onY.dYc() != null) {
            this.onY.refreshData();
        }
        if (this.onY != null) {
            gk(this.onY.dYb());
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
            if (!z && this.onZ != null) {
                this.onZ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI(String str) {
        this.ooc = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.ooc.add(com.baidu.tieba.j.a.eu(jSONObject));
                }
                if (this.ooc.size() > 0) {
                    this.oof = true;
                    this.omi.m(this.ooc, arrayList);
                    dZf();
                    KA();
                    this.onZ.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZD() {
        if (this.omi == null || this.omi.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.omi.getSpanGroupManager().bvp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZE() {
        return this.canGoods || this.omi == null || this.omi.getSpanGroupManager() == null || this.omi.getSpanGroupManager().bvp() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZF() {
        boolean z = this.onY == null || this.onY.dYd();
        boolean z2 = (this.omF == null || this.omF.getSelectedTabItemData() == null || this.omF.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZG() {
        if (this.ogN == null || com.baidu.tbadk.core.util.y.isEmpty(this.ogN.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.ogN.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dZH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.59
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).zm(false).Vg(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aR((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cHd() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.onJ != null) {
            i = this.onJ.getStarCount();
        }
        arrayList.add(new com.baidu.tbadk.coreExtra.data.v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
