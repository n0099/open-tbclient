package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.a.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.w;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.TransmitForumData;
import com.baidu.tieba.write.transmit.model.a;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, x.a, b.a {
    private static int fSz = 0;
    private VoiceData.VoiceModel aAM;
    private String aAN;
    private LocationModel aAO;
    private NewWriteModel aAP;
    private String ahf;
    private com.baidu.tbadk.editortools.j azd;
    private VoiceManager bOm;
    private LinearLayout dUp;
    private com.baidu.tieba.write.transmit.model.a fPs;
    private LinearLayout fRG;
    private View fRJ;
    private View fRK;
    private Toast fRQ;
    private AdditionData fRR;
    private RelativeLayout fRS;
    private TextView fRT;
    private TextView fRU;
    private TextView fRV;
    private com.baidu.tieba.d.a fRX;
    List<com.baidu.tieba.frs.bo> fRY;
    com.baidu.tieba.frs.bo fRZ;
    private HotTopicBussinessData fSE;
    private View fSF;
    private View fSG;
    private TextView fSH;
    private TextView fSI;
    private com.baidu.tieba.view.c fSU;
    private int fSa;
    private String fSb;
    private int fSc;
    private PostCategoryView fSd;
    private NewFrameMultiImgToolView fSe;
    private TextView fkC;
    private com.baidu.tieba.write.b fkD;
    private ImageView fkE;
    private View fkF;
    private int fkf;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fRB = "";
    private boolean fRC = false;
    private WriteData mData = null;
    private boolean fRD = false;
    private boolean fRE = false;
    private boolean fRF = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fkx = null;
    private HeadImageView fPD = null;
    private View fky = null;
    private LinearLayout fkA = null;
    private EditText fkB = null;
    private FeedBackModel fRH = null;
    private FeedBackTopListView fRI = null;
    private ArrayList<com.baidu.tieba.write.a> fQE = new ArrayList<>();
    private String dEo = null;
    private final KeyEvent fRL = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aor = null;
    private TextView fRM = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fRN = null;
    private final Handler mHandler = new Handler();
    private boolean fRO = false;
    private String fRP = null;
    private RelativeLayout mParent = null;
    private String aAU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aAW = 0;
    private int fRW = 0;
    private WriteImagesInfo eLK = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fSf = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fSg = null;
    private ScrollView fSh = null;
    private EditText fSi = null;
    private View fSj = null;
    private View fSk = null;
    private View fSl = null;
    private EditText fSm = null;
    private TextView fSn = null;
    private TextView fSo = null;
    private TextWatcher fSp = null;
    private TextWatcher fSq = null;
    private boolean fSr = false;
    private boolean fSs = false;
    private com.baidu.tbadk.core.view.a aIL = null;
    private com.baidu.tbadk.core.view.a fSt = null;
    private File fSu = null;
    private TbImageView fSv = null;
    private View fSw = null;
    private Dialog fSx = null;
    private LinearLayout fSy = null;
    private boolean fSA = false;
    private long fSB = -1000;
    private boolean fSC = false;
    private String fSD = "2";
    private String fSJ = "";
    private String fSK = "";
    private int fSL = 0;
    private SpannableStringBuilder fSM = new SpannableStringBuilder();
    private final HttpMessageListener fSN = new t(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fSO = new ae(this);
    private final NewWriteModel.d aBf = new ap(this);
    private final LocationModel.a aBd = new bb(this);
    private final CustomMessageListener fws = new bi(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fSP = new bj(this);
    private boolean fSQ = true;
    private final View.OnFocusChangeListener fkv = new bk(this);
    private TextWatcher fSR = new bl(this);
    private TextWatcher fSS = new bm(this);
    private DialogInterface.OnCancelListener fST = new u(this);
    private a.InterfaceC0083a fOW = new v(this);
    private final a.InterfaceC0078a eoS = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ahf)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void CV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(w.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            CW();
        } else if (this.aAO.bhw()) {
            CU();
        } else {
            this.aAO.la(false);
            b(1, true, null);
            this.aAO.bhu();
        }
    }

    private void CW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bX(w.l.location_app_permission_prompt).a(w.l.isopen, new x(this)).b(w.l.cancel, new y(this)).b(getPageContext());
        aVar.td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bod() {
        int selectionEnd = bow().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bow().getText().getSpans(0, bow().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bow().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bow().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boe() {
        if (this.azd != null) {
            this.azd.setBarLauncherEnabled(!this.fSQ);
            this.azd.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fSr) {
            this.fkx.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.fSl.setVisibility(8);
            } else {
                this.fSl.setVisibility(0);
            }
            b(this.fSo, this.fSi);
            b(this.fSn, this.fSm);
            bcJ();
        }
        if (this.fRD) {
            this.fkx.requestFocus();
            ShowSoftKeyPadDelay(this.fkx);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        bos();
        this.aAO = new LocationModel(this);
        this.aAO.a(this.aBd);
        registerListener(this.fws);
        initEditor();
        boI();
        if (this.fSr) {
            this.fSg.setEditorTools(this.azd);
        } else {
            this.fkB.requestFocus();
        }
        AP();
        bol();
        Df();
        if (StringUtils.isNull(this.mData.getForumName())) {
            this.fRX = new com.baidu.tieba.d.a(getPageContext(), this.mPost);
            this.fRX.hb(3);
            this.fRX.hc(-5);
            this.fRX.aD(getResources().getString(w.l.write_select_forum_tips), "show_write_activity_tips");
        }
    }

    private void initEditor() {
        this.azd = new com.baidu.tbadk.editortools.j(getActivity());
        this.azd.setBarMaxLauCount(5);
        this.azd.setMoreButtonAtEnd(true);
        this.azd.setBarLauncherType(1);
        this.azd.bD(true);
        this.azd.setMoreLauncherIcon(w.g.write_more);
        this.azd.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                boh();
                break;
            default:
                boi();
                break;
        }
        this.azd.Ct();
        if (this.fRG != null) {
            this.fRG.addView(this.azd);
        }
        boj();
        this.azd.lW();
        com.baidu.tbadk.editortools.p ev = this.azd.ev(6);
        if (ev != null && !TextUtils.isEmpty(this.aAU)) {
            ((View) ev).setOnClickListener(new z(this));
        }
        if (!this.fSr) {
            this.azd.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.azd.AN();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("xiaoying_has_click", false)) {
            this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("hot_topic_has_click", false)) {
            this.azd.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
        bdVar.setForumName(this.mData.getForumName());
        bdVar.setForumLevel(this.forumLevel);
        this.azd.b(new com.baidu.tbadk.editortools.a(50, 15, bdVar));
        if (this.fSe != null) {
            this.fSe.setEditorTools(this.azd);
            this.fSe.bnp();
        }
    }

    private void bof() {
        this.fSj = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.fSl = this.fSj.findViewById(w.h.live_post_title_container);
        this.fSi = (EditText) this.fSj.findViewById(w.h.live_post_content);
        this.fSf = (GridView) this.fSj.findViewById(w.h.photoLiveGridView);
        this.fSm = (EditText) this.fSj.findViewById(w.h.live_post_title);
        this.fSn = (TextView) this.fSj.findViewById(w.h.titleOverPlusNumber);
        this.fSo = (TextView) this.fSj.findViewById(w.h.contentOverPlusNumber);
        this.fSk = this.fSj.findViewById(w.h.live_interval_view);
        this.fSn.setText(String.valueOf(20));
        this.fSo.setText(String.valueOf(233));
        this.fSj.setVisibility(0);
        this.fSn.setVisibility(0);
        this.fSo.setVisibility(0);
        this.fSm.setHint(w.l.tips_title_limit_new);
        this.fSm.setOnFocusChangeListener(new aa(this));
        if (this.mData.getType() == 4) {
            this.fSi.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.fSi.setHint(w.l.live_write_input_content_update);
        }
        this.fSi.setOnFocusChangeListener(new ab(this));
        this.fSi.requestFocus();
        this.fSi.addTextChangedListener(aRu());
        this.fSm.requestFocus();
        this.fSm.addTextChangedListener(aRu());
        this.fSm.setOnClickListener(this.fSP);
        this.fSi.setOnClickListener(this.fSP);
        this.fSg = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fSf);
        this.fSg.sX(6);
        this.fSf.setAdapter((ListAdapter) this.fSg);
        View findViewById = this.fSj.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ac(this));
        bog();
    }

    private void bog() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.fSm.setText(this.mData.getTitle());
                this.fSm.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fSr) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            boE();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Df();
            return;
        }
        if (this.azd.Cv()) {
            this.azd.AN();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void boh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.azd.v(arrayList);
        com.baidu.tbadk.editortools.x ex = this.azd.ex(5);
        if (ex != null) {
            ex.azJ = 2;
            ex.azH = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.azH = w.g.write_at;
        this.azd.b(aVar);
        this.azd.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void boi() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.azd.b(aVar);
        aVar.azH = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar4.azJ = 5;
            xVar4.azH = w.g.write_privilege;
            this.azd.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar2.azH = w.g.write_at;
        this.azd.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar3.azL = true;
            xVar3.azJ = 9;
            xVar3.azH = 0;
            this.azd.b(xVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar2.azL = true;
            xVar2.azJ = 10;
            xVar2.azH = 0;
            this.azd.b(xVar2);
        }
        Boolean boB = boB();
        if (!this.fRD && boB != null && boB.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bhR() && com.baidu.tieba.tbadkCore.r.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.azJ = 2;
            xVar.azH = w.g.write_recorder;
            this.azd.b(xVar);
        }
        if (this.fRR == null) {
            this.azd.b(new com.baidu.tieba.write.b.d(getActivity()));
        }
        this.azd.v(arrayList);
        com.baidu.tbadk.editortools.x ex = this.azd.ex(5);
        if (ex != null) {
            ex.azJ = 1;
            ex.azH = w.g.write_emotion;
        }
    }

    private void boj() {
        ad adVar = new ad(this);
        this.azd.a(16, adVar);
        this.azd.a(14, adVar);
        this.azd.a(24, adVar);
        this.azd.a(3, adVar);
        this.azd.a(10, adVar);
        this.azd.a(11, adVar);
        this.azd.a(12, adVar);
        this.azd.a(13, adVar);
        this.azd.a(15, adVar);
        this.azd.a(18, adVar);
        this.azd.a(25, adVar);
        this.azd.a(27, adVar);
        this.azd.a(29, adVar);
        this.azd.a(40, adVar);
        this.azd.a(43, adVar);
        this.azd.a(45, adVar);
        this.azd.a(48, adVar);
        this.azd.a(46, adVar);
        this.azd.a(49, adVar);
        this.azd.a(47, adVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX() {
        if (this.aAO.Qu()) {
            if (this.aAO.bhw()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.d.bhs().getLocationData().bho());
                return;
            }
            b(1, true, null);
            this.aAO.bhu();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcB() {
        if (this.aAP != null) {
            this.aAP.cancelLoadData();
        }
        if (this.fRH != null) {
            this.fRH.cancelLoadData();
        }
        if (this.aAO != null) {
            this.aAO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bcB();
        boA();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fPs != null) {
            this.fPs.destroy();
        }
        if (this.fRX != null) {
            this.fRX.Vb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnC() {
        if (this.mData != null && this.mData.getType() == 2 && this.fRO) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(box().getText().toString());
            this.mData.setContent(bow().getText().toString());
            int type = this.mData.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.x.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.x.b("24591571", this.mData);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.x.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.x.b(String.valueOf(this.mData.getForumId()) + "photolive", this.mData);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.x.c(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fkD != null && this.fkD.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fkD, getPageContext().getPageActivity());
                return true;
            } else if (this.azd.Cv()) {
                this.azd.AN();
                return true;
            } else {
                bcB();
                bnC();
                return true;
            }
        }
        if (i == 67 && (text = bow().getText()) != null) {
            int selectionStart = bow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bow().onKeyDown(67, this.fRL);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.fSy);
        if (this.fSv != null && i == 1) {
            this.fSv.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_link_tip_a, 1);
        boe();
        com.baidu.tbadk.core.util.aq.k(this.fSj, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.fky, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.fSk, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(box(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dEo)) {
            com.baidu.tbadk.core.util.aq.k(bow(), w.e.cp_bg_line_d);
        }
        bcJ();
        this.azd.onChangeSkinType(i);
        if (this.fSd != null) {
            this.fSd.ww();
        }
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_b);
        this.fkx.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.fkB.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
    }

    private void bok() {
        this.fSe = (NewFrameMultiImgToolView) this.mRootView.findViewById(w.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.fSe.initView();
        this.fSe.setVisibility(0);
        this.fSe.setAsyncLocalImageLoader(bVar);
        if (this.fSe.getDragLayer() != null && this.fSe.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.fSe.getDragLayer());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.g) this.fSe.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.f) this.fSe.getDragHorizonScrollView());
            this.fSe.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(w.f.ds44));
            this.fSe.getDragHorizonScrollView().setPadding((int) getResources().getDimension(w.f.ds0));
            this.fSe.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            this.fSe.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.fSe));
            this.fSe.getDragHorizonScrollView().setOnSwapDataListener(this.fSe);
            this.fSe.getDragHorizonScrollView().setMaxItemNum(10);
        }
    }

    private View a(Context context, com.baidu.tbadk.editortools.y yVar) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dimension = (int) getResources().getDimension(w.f.ds194);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(dimension, dimension);
        }
        imageView.setLayoutParams(layoutParams);
        com.baidu.tbadk.core.util.aq.c(imageView, w.g.new_frame_btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(w.l.add));
        imageView.setOnClickListener(new af(this, yVar));
        return imageView;
    }

    private void initUI() {
        this.aIL = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fSt = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fSt.c(this.fST);
        this.fSr = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(w.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aor = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aor.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aor != null && (this.aor.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aor.getLayoutParams();
            layoutParams2.width = -2;
            this.aor.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.write_close_selector, w.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_b);
        this.fRM = (TextView) findViewById(w.h.btn_image_problem);
        bom();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fkv);
        this.fSh = (ScrollView) findViewById(w.h.write_scrollview);
        this.fSh.setOnTouchListener(new ag(this));
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fRI = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.fRJ = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.fRG = (LinearLayout) findViewById(w.h.tool_view);
        this.fRG.setContentDescription("..");
        this.dUp = (LinearLayout) findViewById(w.h.title_view);
        this.fky = findViewById(w.h.interval_view);
        this.fSF = findViewById(w.h.hot_topic_fourm_view);
        this.fSG = findViewById(w.h.hot_topic_divider);
        this.fSH = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.fSI = (TextView) findViewById(w.h.change_one_tv);
        bcI();
        if (this.fSr) {
            this.fSh.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bof();
        } else {
            bok();
        }
        bcK();
        if (this.fRD || this.fRE) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().agG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fkA = (LinearLayout) findViewById(w.h.post_content_container);
        this.fkA.setDrawingCacheEnabled(false);
        this.fkA.setOnClickListener(new ah(this));
        this.aor.setOnFocusChangeListener(this.fkv);
        this.aor.setOnClickListener(new ai(this));
        this.fRM.setOnClickListener(new aj(this));
        bop();
        j(boB());
        bot();
        switch (this.mData.getType()) {
            case 0:
                if (this.fRD || this.fRE) {
                    if (this.fRF) {
                        this.mName.setText(w.l.feedback_vcode);
                    } else {
                        this.mName.setText(w.l.feedback);
                    }
                } else {
                    this.mName.setText(w.l.post_new_thread);
                }
                this.fkx.setVisibility(0);
                this.fkB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.mName.setText(w.l.send_reply);
                this.fkB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fkx.setVisibility(8);
                break;
            case 4:
                this.mName.setText(w.l.publish_photo_live);
                this.fkB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.fSk.setVisibility(8);
                break;
            case 7:
                this.fkx.setVisibility(0);
                this.fkB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(w.l.post_drift_bottle);
                break;
        }
        bou();
        boz();
        boe();
        bor();
        bcH();
        if (com.baidu.tbadk.core.util.x.q(this.mList) > 0 && this.mList.get(0) != null) {
            boC();
        }
        if (this.mData.getType() == 4 && this.fkF != null && this.fRK != null) {
            this.fkF.setVisibility(8);
            this.fRK.setVisibility(8);
        }
        bcJ();
        ShowSoftKeyPad(this.mInputManager, this.fkx);
        boq();
    }

    private void bol() {
        this.fPs = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.fPs.a(this.fOW);
        this.fPs.setForumId(this.mData.getForumId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(List<SimpleForum> list) {
        this.fSt.aI(false);
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.mData.getForumId()) && !StringUtils.isNull(this.mData.getForumName())) {
            TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getForumName(), true, 0);
            if (arrayList != null) {
                arrayList.add(transmitForumData);
            }
        }
        if (com.baidu.tbadk.core.util.x.q(list) > 0) {
            for (SimpleForum simpleForum : list) {
                if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L)) {
                    arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                }
            }
        }
        TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(getPageContext().getPageActivity(), 25013);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
        transmitForumActivityConfig.setRecommendForumList(arrayList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    private void bom() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
    }

    private void bon() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fRD && !this.fRE && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.au.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && box() != null) {
                box().setText(c);
                box().setSelection(c.length());
            }
        }
    }

    private void boo() {
        this.fRY = null;
        this.fSa = -1;
        this.fSc = -1;
        com.baidu.tieba.frs.bq hQ = com.baidu.tieba.frs.bp.aab().hQ(1);
        if (hQ != null) {
            this.fRY = hQ.bQV;
            this.fSa = getIntent().getIntExtra("category_id", -1);
            if (this.fRY != null && !this.fRY.isEmpty() && this.fSa >= 0) {
                this.fRZ = new com.baidu.tieba.frs.bo();
                this.fRZ.bQR = 0;
                this.fRZ.name = getPageContext().getResources().getString(w.l.category_auto);
                this.fSc = this.fRZ.bQR;
                this.fSb = this.fRZ.name;
                for (com.baidu.tieba.frs.bo boVar : this.fRY) {
                    if (boVar.bQR == this.fSa) {
                        this.fSc = boVar.bQR;
                        this.fSb = boVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bop() {
        if (this.fRY != null && !this.fRY.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.fSd = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.fSd.setText(this.fSb);
            this.fSd.b(this.fRY, this.fRZ, this.fSc);
            this.fSd.setCategoryContainerClickCallback(new ak(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void boq() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fSU = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fSU.setTitle(w.l.no_disturb_start_time);
        this.fSU.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.fSU);
        this.fSU.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.fSU);
        return this.fSU;
    }

    private void bor() {
        this.fRS = (RelativeLayout) findViewById(w.h.addition_container);
        this.fRT = (TextView) findViewById(w.h.addition_create_time);
        this.fRU = (TextView) findViewById(w.h.addition_last_time);
        this.fRV = (TextView) findViewById(w.h.addition_last_content);
        if (this.fRR != null) {
            this.fRS.setVisibility(0);
            this.fRT.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.au.q(this.fRR.getCreateTime() * 1000));
            if (this.fRR.getAlreadyCount() == 0) {
                this.fRU.setVisibility(8);
            } else {
                this.fRU.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.au.q(this.fRR.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fRR.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fRV.setText(lastAdditionContent);
            } else {
                this.fRV.setVisibility(8);
            }
            bow().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.fRR.getAlreadyCount()), Integer.valueOf(this.fRR.getTotalCount())));
            this.mName.setText(w.l.write_addition_title);
            return;
        }
        this.fRS.setVisibility(8);
    }

    private void bcH() {
        this.fkF = findViewById(w.h.post_prefix_layout);
        this.fkC = (TextView) findViewById(w.h.post_prefix);
        this.fRK = findViewById(w.h.prefix_divider);
        this.fkE = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fkF.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fkf = 1;
            this.fkF.setOnClickListener(new an(this));
            this.fkE = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.fkE.setVisibility(0);
                this.fkC.setOnClickListener(new ao(this));
            }
            this.fkD = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fkD.a(this);
            this.fkD.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.fkD.setOutsideTouchable(true);
            this.fkD.setFocusable(true);
            this.fkD.setOnDismissListener(this);
            this.fkD.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b);
            int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.j(this.fkC, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.c(this.fkE, w.g.icon_frs_arrow_n);
            this.fkC.setTextColor(color);
            this.fQE.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fQE.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fkD.addView(aVar);
            }
            this.fkD.sJ(0);
            this.fkC.setText(prefixs.get(1));
            th(1);
            return;
        }
        this.fkF.setVisibility(8);
    }

    private void bos() {
        if (this.fRD && this.mData != null) {
            this.fRI.setVisibility(0);
            this.fRJ.setVisibility(0);
            this.fRH = new FeedBackModel(this);
            this.fRH.ri(this.mData.getForumName());
            this.fRH.setLoadDataCallBack(new aq(this));
        }
    }

    protected void bot() {
        this.mPost.setOnClickListener(new ar(this));
    }

    protected void bou() {
        this.fRN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fRN.cC(getPageContext().getString(w.l.is_save_draft)).as(false).a(getPageContext().getString(w.l.save), new as(this)).b(getPageContext().getString(w.l.not_save), new au(this));
        this.fRN.b(getPageContext());
    }

    protected void bcI() {
        this.fPD = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.fPD.setIsRound(true);
        this.fPD.setDrawBorder(false);
        this.fPD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dl = com.baidu.tbadk.core.util.q.dl(currentPortrait);
            this.fPD.setUrl(dl);
            this.fPD.c(dl, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.fPD.setVisibility(0);
        }
        this.fkx = (EditText) findViewById(w.h.post_title);
        this.fkx.setOnClickListener(this.fSP);
        this.fkx.setOnFocusChangeListener(this.fkv);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fkx.setText(this.mData.getTitle());
                this.fkx.setSelection(this.mData.getTitle().length());
            } else if (this.fRF) {
                this.fkx.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fkx.addTextChangedListener(this.fSR);
        if (!this.mData.getHaveDraft()) {
            bon();
            this.fSC = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fkx.setHint(getResources().getString(w.l.feedback_title_hint));
        } else {
            this.fkx.setHint(getResources().getString(w.l.post_title_hint));
        }
    }

    private TextWatcher aRu() {
        av avVar = new av(this);
        if (this.fSr && this.fSs) {
            if (this.fSp != null) {
                this.fSm.removeTextChangedListener(this.fSp);
            }
            this.fSp = avVar;
        } else if (this.fSr) {
            if (this.fSq != null) {
                this.fSi.removeTextChangedListener(this.fSq);
            }
            this.fSq = avVar;
        }
        return avVar;
    }

    private long h(EditText editText) {
        if (editText == this.fSi) {
            return 233L;
        }
        if (editText != this.fSm) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long h = h(editText);
            long f = h - f(editText);
            String valueOf = String.valueOf(f);
            if (h == 20) {
                if (f < 0) {
                    if (f < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bcK() {
        this.fkB = (EditText) findViewById(w.h.post_content);
        this.fkB.setDrawingCacheEnabled(false);
        this.fkB.setOnClickListener(this.fSP);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString X = TbFaceManager.DM().X(getPageContext().getPageActivity(), this.mData.getContent());
            this.fkB.setText(X);
            this.fkB.setSelection(X.length());
        } else if (this.mData.getType() == 2) {
            if (this.fRO) {
                if (this.fRP != null && this.fRP.length() > 0) {
                    this.fkB.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.fRP}));
                    this.fkB.setSelection(this.fkB.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fkB.setText(format);
                this.fkB.setSelection(format.length());
            }
        }
        this.fkB.setOnFocusChangeListener(this.fkv);
        this.fkB.setOnTouchListener(new aw(this));
        this.fkB.addTextChangedListener(this.fSS);
        lJ(true);
        if (this.mData.isUserFeedback()) {
            this.fkB.setHint(w.l.write_input_content);
        } else {
            this.fkB.setHint(w.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fSr) {
            bow().setPadding(0, 0, 0, 0);
            bow().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.aq.k(bow(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dEo) && this.fRR == null) {
                com.baidu.adp.lib.f.c.fM().a(this.dEo, 19, new ax(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bov() {
        int i = 5000;
        if (this.fRR != null) {
            i = 1000;
        }
        return bow().getText() != null && bow().getText().length() >= i;
    }

    private void fo(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.fRB)) {
                this.fRB = "";
                bow().requestFocus();
                if (bow().getText() != null && bow().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bow().getSelectionStart();
                    editable = bow().getText();
                }
            } else if ("from_title".equals(this.fRB)) {
                this.fRB = "";
                box().requestFocus();
                if (box().getText() != null && box().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = box().getSelectionStart();
                    editable = box().getText();
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
    public void lK(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bow().getText().getSpans(0, bow().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fRQ == null) {
                this.fRQ = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.fRQ.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xM = lVar.xM();
        if (name != null) {
            com.baidu.adp.lib.f.c.fM().a(name, 20, new ay(this, new SpannableStringBuilder(name), xM), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bow() != null && bow().getText() != null) {
            Bitmap kR = aVar.kR();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
            int width = kR.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType) {
                int selectionStart = bow().getSelectionStart() - 1;
                if (bow().getText().length() > 1 && selectionStart >= 0 && bow().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bow().getText().insert(bow().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bow().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bow().getText().insert(bow().getSelectionStart(), spannableString2);
            }
            Editable text = bow().getText();
            if (text != null) {
                this.fSM.clear();
                this.fSM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fSM);
                if (EmotionGroupType.BIG_EMOTION == emotionGroupType && spannableString2 != null && bow().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bow().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bow().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bow() {
        return this.fSr ? this.fSi : this.fkB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText box() {
        return this.fSr ? this.fSm : this.fkx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boy() {
        Editable text;
        if (bow() != null && (text = bow().getText()) != null) {
            int selectionStart = bow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bow().onKeyDown(67, this.fRL);
            }
            bow().onKeyDown(67, this.fRL);
            int selectionStart2 = bow().getSelectionStart();
            if (text != null) {
                this.fSM.clear();
                this.fSM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fSM);
                bow().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.fRD = true;
        }
    }

    private void boz() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void boA() {
        try {
            if (this.fRN != null) {
                this.fRN.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aIL.c(null);
        this.aIL.cV(w.l.sending);
        this.aIL.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aIL.aI(false);
    }

    private Boolean boB() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aAU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcJ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (box() != null) {
                str = box().getText().toString();
            }
            if (bow() != null) {
                str2 = bow().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fkf == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            lL(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        lL(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    lL(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fSr) {
                    lL(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lL(true);
                }
            }
            if (this.mData.getType() == 4) {
                lL(j(this.fSi) && i(this.fSm));
            } else if (this.mData.getType() == 5) {
                lL(j(this.fSi));
            } else if (!TextUtils.isEmpty(str2)) {
                lL(true);
            } else if (this.aAM != null) {
                lL(true);
            } else if (this.mData.getVideoInfo() != null) {
                lL(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                lL(true);
            } else {
                lL(false);
            }
        }
    }

    private void lL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.aq.b(this.mPost, w.e.cp_link_tip_a, w.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean i(EditText editText) {
        long f = f(editText);
        return f <= 20 && f > 0;
    }

    private boolean j(EditText editText) {
        long f = f(editText);
        if (f > 233) {
            return false;
        }
        return f > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aAP = new NewWriteModel(this);
        this.aAP.b(this.aBf);
        registerListener(this.fSN);
        this.mDialogCancelListener = new az(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fRD = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fRF = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fRO = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fRP = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fRR = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fRR != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fRW = bundle.getInt("mem_type", 0);
            this.ahf = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fSJ = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.fSD = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fRD = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fRF = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fRO = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fRP = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.fRR = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fRR != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fRW = intent.getIntExtra("mem_type", 0);
            this.ahf = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fSJ = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.fSD = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.fRD);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.x.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.x.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            com.baidu.tieba.tbadkCore.x.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            com.baidu.tieba.tbadkCore.x.c(String.valueOf(this.mData.getForumId()) + "photolive", this);
        } else if (this.mData.getType() == 5) {
            com.baidu.tieba.tbadkCore.x.a(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(w.l.write_no_prefix));
        }
        this.dEo = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fRE = true;
        }
        boo();
        try {
            this.fSu = boH();
        } catch (Throwable th) {
            this.fSu = null;
        }
    }

    private void boC() {
        this.fPD.setVisibility(8);
        this.fSF.setVisibility(0);
        this.fSG.setVisibility(0);
        if (this.mData.getType() != 7) {
            this.fkx.setText(rj(this.mList.get(0).mTopicName));
            this.fkx.setMovementMethod(com.baidu.tieba.view.g.bkT());
        }
        this.fSH.setText(this.mList.get(0).mForumName);
        this.fkx.addTextChangedListener(new ba(this));
        this.fSI.setOnClickListener(new bc(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString fY = com.baidu.tbadk.plugins.a.fY(rj(hotTopicBussinessData.mTopicName));
            if (fY != null) {
                this.fkx.setText(fY);
            }
            this.fSH.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rj(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        String rj;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle())) {
                    this.dUp.setVisibility(0);
                    this.dUp.requestFocus();
                    this.azd.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (com.baidu.adp.lib.util.j.isEmpty(box().getText().toString()) || this.fSC || ((this.fRD || this.fRE) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.r(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.x.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            rj = this.mData.getTitle();
                        } else {
                            rj = rj(str);
                        }
                        SpannableString fY = com.baidu.tbadk.plugins.a.fY(rj);
                        if (fY != null) {
                            box().setText(fY);
                            box().setSelection(rj.length());
                        }
                    } else {
                        box().setText(this.mData.getTitle());
                        box().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bon();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bow().getText().toString()) || this.fRD || this.fRE) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DM().a(getPageContext().getPageActivity(), this.mData.getContent(), this.fSO);
                    bow().setText(a2);
                    bow().setSelection(a2.length());
                    if (this.fSr) {
                        b(this.fSo, this.fSi);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    boG();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Df();
                    }
                    lM(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    boD();
                }
                bcJ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.fRY != null) {
                    this.fSc = this.fRZ.bQR;
                    this.fSb = this.fRZ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.fRY.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bo boVar = this.fRY.get(i);
                        if (categoryTo != boVar.bQR) {
                            i++;
                        } else {
                            this.fSc = categoryTo;
                            this.fSb = boVar.name;
                            this.mData.setCategoryTo(this.fSc);
                            break;
                        }
                    }
                    if (this.fSd != null) {
                        this.fSd.setText(this.fSb);
                        this.fSd.b(this.fRY, this.fRZ, this.fSc);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.azd.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.azd.AN();
                return;
            }
            return;
        }
        boD();
        bon();
    }

    private void boD() {
        if ((!this.fSr || this.fSg != null) && this.fSf != null) {
            this.fSg.c(this.writeImagesInfo);
            azB();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fRO);
        if (this.fRD) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAN);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fRR);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fRW);
        bundle.putString("from", this.ahf);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.fSD);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bow().getEditableText().toString();
        if (editable != null) {
            bow().setText(TbFaceManager.DM().a(getPageContext().getPageActivity(), editable, this.fSO));
            bow().setSelection(bow().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnD() {
        bcB();
        String editable = box().getText().toString();
        this.mData.setContent(bow().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fkf != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.fkC.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fRD || this.fRE) {
            String string = getResources().getString(w.l.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
            }
            String str = String.valueOf(getResources().getString(w.l.app_name)) + getResources().getString(w.l.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.hk()) {
                    sb.append(com.baidu.adp.lib.util.i.hs());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.fSa >= 0) {
            this.mData.setCategoryFrom(this.fSa);
        }
        if (this.fSc >= 0) {
            this.mData.setCategoryTo(this.fSc);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aAO != null && this.aAO.Qu());
        this.aAP.lc(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.r(this.mList) && this.fSE != null && this.fSE.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.fSE.mForumId));
            this.mData.setForumName(this.fSE.mForumName);
        }
        this.aAP.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aAM != null) {
            if (this.aAM.getId() != null) {
                this.aAP.getWriteData().setVoice(this.aAM.getId());
                this.aAP.getWriteData().setVoiceDuringTime(this.aAM.duration);
            } else {
                this.aAP.getWriteData().setVoice(null);
                this.aAP.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aAP.getWriteData().setVoice(null);
            this.aAP.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aAP.bhS()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aAP.startPostWrite();
        }
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.fRR != null) {
                i2 = this.fRR.getTotalCount();
                i = this.fRR.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(w.l.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    private void a(PostWriteCallBackData postWriteCallBackData, String str) {
        if (postWriteCallBackData != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.azd != null && !this.azd.Cv()) {
                    bow().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra(IntentConfig.NAME_SHOW) : null;
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
                            bow().getText().insert(bow().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0) {
                    com.baidu.tieba.tbadkCore.x.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null) {
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                        } else {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(TbadkCoreApplication.m9getInst().getContext()).createNormalCfg(postWriteCallBackData.getThreadId(), null, null);
                            createNormalCfg.setNeedRepostRecommendForum(true);
                            createNormalCfg.setPostThreadTip(postWriteCallBackData.getErrorString());
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        }
                    }
                } else if (this.mData.getType() == 1) {
                    com.baidu.tieba.tbadkCore.x.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    com.baidu.tieba.tbadkCore.x.b(String.valueOf(this.mData.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                c(postWriteCallBackData);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                aSQ();
                            } else {
                                ab(intent);
                            }
                        } else if (intExtra == 1) {
                            V(intent);
                        } else {
                            aa(intent);
                            com.baidu.adp.lib.g.h.fS().post(new bd(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fSr) {
                        B(intent);
                        bcJ();
                        return;
                    }
                    ad(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.azd.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.azd.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bcJ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.M(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fRC) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fRC = false;
                            }
                            sb2.append(stringExtra);
                            fo(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.r(this.mList)) {
                    if (!com.baidu.tbadk.core.util.x.r(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.fSE = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.fSE);
                    }
                } else if (i == 25013) {
                    if (intent != null) {
                        this.mData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                    }
                    this.mData.setForumId("0");
                    this.mData.setCanNoForum(true);
                    this.mData.setCallFrom(this.fSD);
                    this.mData.setRecommendExt(this.fPs.getRecommendExt());
                    if (this.mData.getVideoInfo() != null) {
                        TiebaStatic.log("c10063");
                    }
                    bnD();
                }
            }
        } else if (i2 == 0) {
            if (this.azd != null && !this.azd.Cv()) {
                this.fkB.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Da();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    boF();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aAN = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAN);
                    return;
                case 12012:
                    boF();
                    return;
                case 25004:
                    if ("from_title".equals(this.fRB)) {
                        box().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fRB)) {
                        bow().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void boE() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void boF() {
        if (this.fSr) {
            this.fSg.c(this.writeImagesInfo);
            azB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azB() {
        this.fSg.notifyDataSetChanged();
        this.fSf.invalidate();
        this.mHandler.postDelayed(new be(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bcJ();
    }

    private void aa(Intent intent) {
        if (this.fSr) {
            ad(intent);
            boF();
        } else {
            ae(intent);
        }
        bcJ();
    }

    private void ad(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            boF();
            lM(true);
        }
    }

    private void ab(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aSQ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void V(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eLK.parseJson(stringExtra);
            this.eLK.updateQuality();
            if (this.eLK.getChosedFiles() != null && this.eLK.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eLK.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eLK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, box());
        HidenSoftKeyPad(this.mInputManager, bow());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ae(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aAN = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAN, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            boG();
            Df();
        }
        lM(true);
    }

    private void B(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                boG();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Df();
                }
            }
            lM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
        if (this.azd.ex(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void Da() {
        new bf(this).execute(new Void[0]);
    }

    private void lM(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bOm == null) {
            this.bOm = VoiceManager.instance();
        }
        return this.bOm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Zo() {
        this.bOm = getVoiceManager();
        this.bOm.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rV(postWriteCallBackData.getErrorCode())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.fRR == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAW = i;
        if (this.azd != null) {
            this.azd.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.azd.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Df() {
        if (!this.fSr) {
            if (this.azd != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.azd.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.azd.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.azd.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.azd.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.fSe != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.fSe.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.fSe.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.fSe.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fSe.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (this.azd != null) {
            this.azd.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void th(int i) {
        if (i < this.fQE.size()) {
            for (int i2 = 0; i2 < this.fQE.size(); i2++) {
                this.fQE.get(i2).lz(false);
            }
            this.fQE.get(i).lz(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rs(int i) {
        this.fkf = i;
        this.fkD.sJ(i);
        th(i);
        this.fkC.setText(this.mPrefixData.getPrefixs().get(i));
        bcJ();
        com.baidu.adp.lib.g.j.a(this.fkD, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fkF.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(WriteActivity writeActivity, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mData != null) {
            if (this.mData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            CV();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAN);
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fSA && System.currentTimeMillis() - this.fSB < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fSA = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fSx != null) {
            rl(str);
            this.fSx.dismiss();
        }
    }

    private void bV(Context context) {
        fSz = com.baidu.adp.lib.util.k.ag(context);
    }

    private void rl(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fSA = true;
        boG();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Df();
        }
        lM(true);
    }

    private static Bitmap c(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && i > 0) {
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

    private File boH() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
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
                if ((currentTimeMillis - file.lastModified()) / TbConfig.USE_TIME_INTERVAL > 1) {
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

    private void boI() {
        if (this.fSu != null && this.mData.getType() == 0) {
            bV(getActivity());
            this.fSw = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.fSw.setOnClickListener(new bg(this));
            this.fSv = (TbImageView) this.fSw.findViewById(w.h.rec_img_view);
            this.fSy = (LinearLayout) this.fSw.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.tX().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fSu.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.tX().putString("write_rec_pic_path", this.fSu.getAbsolutePath());
                Bitmap c = c(this.fSu.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.fSv.setImageBitmap(c);
                    this.fSv.setDrawBorder(true);
                    this.fSv.setBorderWidth(2);
                    this.fSv.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10264));
                    this.fSx = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.fSx.setCanceledOnTouchOutside(true);
                    this.fSx.setOnDismissListener(new bh(this));
                    this.fSx.setContentView(this.fSw);
                    this.fSx.show();
                    Window window = this.fSx.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (fSz / 18) + getResources().getDimensionPixelSize(w.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(w.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(w.f.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(w.a.activity_open_from_bottom, w.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.fRC = false;
            this.fRB = "";
            if ("from_content".equals(str)) {
                this.fRB = "from_content";
            } else if ("from_title".equals(str)) {
                this.fRB = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                lK(false);
            }
        }
    }

    public void AP() {
        if (this.fRD) {
            this.dUp.setVisibility(0);
            this.dUp.requestFocus();
            this.azd.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.dUp.setVisibility(8);
    }
}
