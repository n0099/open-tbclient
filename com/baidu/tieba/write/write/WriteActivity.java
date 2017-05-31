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
    private static int gav = 0;
    private LocationModel aAA;
    private NewWriteModel aAB;
    private VoiceData.VoiceModel aAy;
    private String aAz;
    private String agW;
    private com.baidu.tbadk.editortools.j ayP;
    private VoiceManager bTZ;
    private LinearLayout dZL;
    private com.baidu.tieba.write.transmit.model.a fXo;
    private LinearLayout fZC;
    private View fZF;
    private View fZG;
    private Toast fZM;
    private AdditionData fZN;
    private RelativeLayout fZO;
    private TextView fZP;
    private TextView fZQ;
    private TextView fZR;
    private com.baidu.tieba.d.a fZT;
    List<com.baidu.tieba.frs.bp> fZU;
    com.baidu.tieba.frs.bp fZV;
    private int fZW;
    private String fZX;
    private int fZY;
    private PostCategoryView fZZ;
    private int frX;
    private TextView fsu;
    private com.baidu.tieba.write.b fsv;
    private ImageView fsw;
    private View fsx;
    private HotTopicBussinessData gaA;
    private View gaB;
    private View gaC;
    private TextView gaD;
    private TextView gaE;
    private com.baidu.tieba.view.c gaQ;
    private NewFrameMultiImgToolView gaa;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fZx = "";
    private boolean fZy = false;
    private WriteData mData = null;
    private boolean fZz = false;
    private boolean fZA = false;
    private boolean fZB = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fsp = null;
    private HeadImageView fXz = null;
    private View fsq = null;
    private LinearLayout fss = null;
    private EditText fst = null;
    private FeedBackModel fZD = null;
    private FeedBackTopListView fZE = null;
    private ArrayList<com.baidu.tieba.write.a> fYA = new ArrayList<>();
    private String dJM = null;
    private final KeyEvent fZH = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aob = null;
    private TextView fZI = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fZJ = null;
    private final Handler mHandler = new Handler();
    private boolean fZK = false;
    private String fZL = null;
    private RelativeLayout mParent = null;
    private String aAG = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aAI = 0;
    private int fZS = 0;
    private WriteImagesInfo eUv = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gab = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gac = null;
    private ScrollView gad = null;
    private EditText gae = null;
    private View gaf = null;
    private View gag = null;
    private View gah = null;
    private EditText gai = null;
    private TextView gaj = null;
    private TextView gak = null;
    private TextWatcher gal = null;
    private TextWatcher gam = null;
    private boolean gan = false;
    private boolean gao = false;
    private com.baidu.tbadk.core.view.a aIy = null;
    private com.baidu.tbadk.core.view.a gap = null;
    private File gaq = null;
    private TbImageView gar = null;
    private View gas = null;
    private Dialog gat = null;
    private LinearLayout gau = null;
    private boolean gaw = false;
    private long gax = -1000;
    private boolean gay = false;
    private String gaz = "2";
    private String gaF = "";
    private String gaG = "";
    private int gaH = 0;
    private SpannableStringBuilder gaI = new SpannableStringBuilder();
    private final HttpMessageListener gaJ = new t(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a gaK = new ae(this);
    private final NewWriteModel.d aAR = new ap(this);
    private final LocationModel.a aAP = new bb(this);
    private final CustomMessageListener fEk = new bi(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener gaL = new bj(this);
    private boolean gaM = true;
    private final View.OnFocusChangeListener fsn = new bk(this);
    private TextWatcher gaN = new bl(this);
    private TextWatcher gaO = new bm(this);
    private DialogInterface.OnCancelListener gaP = new u(this);
    private a.InterfaceC0086a fWS = new v(this);
    private final a.InterfaceC0080a euI = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.agW)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void CP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(w.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            CQ();
        } else if (this.aAA.biQ()) {
            CO();
        } else {
            this.aAA.lv(false);
            b(1, true, null);
            this.aAA.biO();
        }
    }

    private void CQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.location_app_permission_prompt).a(w.l.isopen, new x(this)).b(w.l.cancel, new y(this)).b(getPageContext());
        aVar.tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpC() {
        int selectionEnd = bpV().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bpV().getText().getSpans(0, bpV().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bpV().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bpV().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        if (this.ayP != null) {
            this.ayP.setBarLauncherEnabled(!this.gaM);
            this.ayP.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gan) {
            this.fsp.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gah.setVisibility(8);
            } else {
                this.gah.setVisibility(0);
            }
            b(this.gak, this.gae);
            b(this.gaj, this.gai);
            bed();
        }
        if (this.fZz) {
            this.fsp.requestFocus();
            ShowSoftKeyPadDelay(this.fsp);
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
        bpR();
        this.aAA = new LocationModel(this);
        this.aAA.a(this.aAP);
        registerListener(this.fEk);
        initEditor();
        bqh();
        if (this.gan) {
            this.gac.setEditorTools(this.ayP);
        } else {
            this.fst.requestFocus();
        }
        AI();
        bpK();
        CZ();
        if (StringUtils.isNull(this.mData.getForumName())) {
            this.fZT = new com.baidu.tieba.d.a(getPageContext(), this.mPost);
            this.fZT.hz(3);
            this.fZT.hA(-5);
            this.fZT.aB(getResources().getString(w.l.write_select_forum_tips), "show_write_activity_tips");
        }
    }

    private void initEditor() {
        this.ayP = new com.baidu.tbadk.editortools.j(getActivity());
        this.ayP.setBarMaxLauCount(5);
        this.ayP.setMoreButtonAtEnd(true);
        this.ayP.setBarLauncherType(1);
        this.ayP.bA(true);
        this.ayP.setMoreLauncherIcon(w.g.write_more);
        this.ayP.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bpG();
                break;
            default:
                bpH();
                break;
        }
        this.ayP.Cn();
        if (this.fZC != null) {
            this.fZC.addView(this.ayP);
        }
        bpI();
        this.ayP.lO();
        com.baidu.tbadk.editortools.p ew = this.ayP.ew(6);
        if (ew != null && !TextUtils.isEmpty(this.aAG)) {
            ((View) ew).setOnClickListener(new z(this));
        }
        if (!this.gan) {
            this.ayP.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ayP.AG();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ayP.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ayP.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
        beVar.setForumName(this.mData.getForumName());
        beVar.setForumLevel(this.forumLevel);
        this.ayP.b(new com.baidu.tbadk.editortools.a(50, 15, beVar));
        if (this.gaa != null) {
            this.gaa.setEditorTools(this.ayP);
            this.gaa.boO();
        }
    }

    private void bpE() {
        this.gaf = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.gah = this.gaf.findViewById(w.h.live_post_title_container);
        this.gae = (EditText) this.gaf.findViewById(w.h.live_post_content);
        this.gab = (GridView) this.gaf.findViewById(w.h.photoLiveGridView);
        this.gai = (EditText) this.gaf.findViewById(w.h.live_post_title);
        this.gaj = (TextView) this.gaf.findViewById(w.h.titleOverPlusNumber);
        this.gak = (TextView) this.gaf.findViewById(w.h.contentOverPlusNumber);
        this.gag = this.gaf.findViewById(w.h.live_interval_view);
        this.gaj.setText(String.valueOf(20));
        this.gak.setText(String.valueOf(233));
        this.gaf.setVisibility(0);
        this.gaj.setVisibility(0);
        this.gak.setVisibility(0);
        this.gai.setHint(w.l.tips_title_limit_new);
        this.gai.setOnFocusChangeListener(new aa(this));
        if (this.mData.getType() == 4) {
            this.gae.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gae.setHint(w.l.live_write_input_content_update);
        }
        this.gae.setOnFocusChangeListener(new ab(this));
        this.gae.requestFocus();
        this.gae.addTextChangedListener(aSL());
        this.gai.requestFocus();
        this.gai.addTextChangedListener(aSL());
        this.gai.setOnClickListener(this.gaL);
        this.gae.setOnClickListener(this.gaL);
        this.gac = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gab);
        this.gac.ts(6);
        this.gab.setAdapter((ListAdapter) this.gac);
        View findViewById = this.gaf.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ac(this));
        bpF();
    }

    private void bpF() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gai.setText(this.mData.getTitle());
                this.gai.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gan) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bqd();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            CZ();
            return;
        }
        if (this.ayP.Cp()) {
            this.ayP.AG();
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

    private void bpG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ayP.v(arrayList);
        com.baidu.tbadk.editortools.x ey = this.ayP.ey(5);
        if (ey != null) {
            ey.azv = 2;
            ey.azt = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.azt = w.g.write_at;
        this.ayP.b(aVar);
        this.ayP.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bpH() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.ayP.b(aVar);
        aVar.azt = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar4.azv = 5;
            xVar4.azt = w.g.write_privilege;
            this.ayP.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar2.azt = w.g.write_at;
        this.ayP.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar3.azx = true;
            xVar3.azv = 9;
            xVar3.azt = 0;
            this.ayP.b(xVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar2.azx = true;
            xVar2.azv = 10;
            xVar2.azt = 0;
            this.ayP.b(xVar2);
        }
        Boolean bqa = bqa();
        if (!this.fZz && bqa != null && bqa.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bjl() && com.baidu.tieba.tbadkCore.r.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.azv = 2;
            xVar.azt = w.g.write_recorder;
            this.ayP.b(xVar);
        }
        if (this.fZN == null) {
            this.ayP.b(new com.baidu.tieba.write.b.d(getActivity()));
        }
        this.ayP.v(arrayList);
        com.baidu.tbadk.editortools.x ey = this.ayP.ey(5);
        if (ey != null) {
            ey.azv = 1;
            ey.azt = w.g.write_emotion;
        }
    }

    private void bpI() {
        ad adVar = new ad(this);
        this.ayP.a(16, adVar);
        this.ayP.a(14, adVar);
        this.ayP.a(24, adVar);
        this.ayP.a(3, adVar);
        this.ayP.a(10, adVar);
        this.ayP.a(11, adVar);
        this.ayP.a(12, adVar);
        this.ayP.a(13, adVar);
        this.ayP.a(15, adVar);
        this.ayP.a(18, adVar);
        this.ayP.a(25, adVar);
        this.ayP.a(27, adVar);
        this.ayP.a(29, adVar);
        this.ayP.a(40, adVar);
        this.ayP.a(43, adVar);
        this.ayP.a(45, adVar);
        this.ayP.a(48, adVar);
        this.ayP.a(46, adVar);
        this.ayP.a(49, adVar);
        this.ayP.a(47, adVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR() {
        if (this.aAA.QG()) {
            if (this.aAA.biQ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.d.biM().getLocationData().biI());
                return;
            }
            b(1, true, null);
            this.aAA.biO();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdV() {
        if (this.aAB != null) {
            this.aAB.cancelLoadData();
        }
        if (this.fZD != null) {
            this.fZD.cancelLoadData();
        }
        if (this.aAA != null) {
            this.aAA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bdV();
        bpZ();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fXo != null) {
            this.fXo.destroy();
        }
        if (this.fZT != null) {
            this.fZT.We();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpb() {
        if (this.mData != null && this.mData.getType() == 2 && this.fZK) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bpW().getText().toString());
            this.mData.setContent(bpV().getText().toString());
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
            if (this.fsv != null && this.fsv.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fsv, getPageContext().getPageActivity());
                return true;
            } else if (this.ayP.Cp()) {
                this.ayP.AG();
                return true;
            } else {
                bdV();
                bpb();
                return true;
            }
        }
        if (i == 67 && (text = bpV().getText()) != null) {
            int selectionStart = bpV().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bpV().onKeyDown(67, this.fZH);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gau);
        if (this.gar != null && i == 1) {
            this.gar.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_link_tip_a, 1);
        bpD();
        com.baidu.tbadk.core.util.aq.k(this.gaf, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.fsq, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.gag, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(bpW(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dJM)) {
            com.baidu.tbadk.core.util.aq.k(bpV(), w.e.cp_bg_line_d);
        }
        bed();
        this.ayP.onChangeSkinType(i);
        if (this.fZZ != null) {
            this.fZZ.ws();
        }
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_b);
        this.fsp.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.fst.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
    }

    private void bpJ() {
        this.gaa = (NewFrameMultiImgToolView) this.mRootView.findViewById(w.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gaa.initView();
        this.gaa.setVisibility(0);
        this.gaa.setAsyncLocalImageLoader(bVar);
        if (this.gaa.getDragLayer() != null && this.gaa.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gaa.getDragLayer());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.g) this.gaa.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.f) this.gaa.getDragHorizonScrollView());
            this.gaa.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(w.f.ds44));
            this.gaa.getDragHorizonScrollView().setPadding((int) getResources().getDimension(w.f.ds0));
            this.gaa.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            this.gaa.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gaa));
            this.gaa.getDragHorizonScrollView().setOnSwapDataListener(this.gaa);
            this.gaa.getDragHorizonScrollView().setMaxItemNum(10);
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
        this.aIy = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gap = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gap.c(this.gaP);
        this.gan = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(w.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aob = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aob.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aob != null && (this.aob.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aob.getLayoutParams();
            layoutParams2.width = -2;
            this.aob.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.write_close_selector, w.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_b);
        this.fZI = (TextView) findViewById(w.h.btn_image_problem);
        bpL();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fsn);
        this.gad = (ScrollView) findViewById(w.h.write_scrollview);
        this.gad.setOnTouchListener(new ag(this));
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fZE = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.fZF = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.fZC = (LinearLayout) findViewById(w.h.tool_view);
        this.fZC.setContentDescription("..");
        this.dZL = (LinearLayout) findViewById(w.h.title_view);
        this.fsq = findViewById(w.h.interval_view);
        this.gaB = findViewById(w.h.hot_topic_fourm_view);
        this.gaC = findViewById(w.h.hot_topic_divider);
        this.gaD = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.gaE = (TextView) findViewById(w.h.change_one_tv);
        bec();
        if (this.gan) {
            this.gad.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bpE();
        } else {
            bpJ();
        }
        bee();
        if (this.fZz || this.fZA) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().agx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fss = (LinearLayout) findViewById(w.h.post_content_container);
        this.fss.setDrawingCacheEnabled(false);
        this.fss.setOnClickListener(new ah(this));
        this.aob.setOnFocusChangeListener(this.fsn);
        this.aob.setOnClickListener(new ai(this));
        this.fZI.setOnClickListener(new aj(this));
        bpO();
        j(bqa());
        bpS();
        switch (this.mData.getType()) {
            case 0:
                if (this.fZz || this.fZA) {
                    if (this.fZB) {
                        this.mName.setText(w.l.feedback_vcode);
                    } else {
                        this.mName.setText(w.l.feedback);
                    }
                } else {
                    this.mName.setText(w.l.post_new_thread);
                }
                this.fsp.setVisibility(0);
                this.fst.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.mName.setText(w.l.send_reply);
                this.fst.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fsp.setVisibility(8);
                break;
            case 4:
                this.mName.setText(w.l.publish_photo_live);
                this.fst.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gag.setVisibility(8);
                break;
            case 7:
                this.fsp.setVisibility(0);
                this.fst.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(w.l.post_drift_bottle);
                break;
        }
        bpT();
        bpY();
        bpD();
        bpQ();
        beb();
        bqb();
        if (this.mData.getType() == 4 && this.fsx != null && this.fZG != null) {
            this.fsx.setVisibility(8);
            this.fZG.setVisibility(8);
        }
        bed();
        ShowSoftKeyPad(this.mInputManager, this.fsp);
        bpP();
    }

    private void bpK() {
        this.fXo = new com.baidu.tieba.write.transmit.model.a(getUniqueId());
        this.fXo.a(this.fWS);
        this.fXo.setForumId(this.mData.getForumId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(List<SimpleForum> list) {
        this.gap.aH(false);
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        if (!StringUtils.isNull(this.mData.getForumId()) && !this.mData.getForumId().equals("0") && !StringUtils.isNull(this.mData.getForumName())) {
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

    private void bpL() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
    }

    private void bpM() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fZz && !this.fZA && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.au.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bpW() != null) {
                bpW().setText(c);
                bpW().setSelection(c.length());
            }
        }
    }

    private void bpN() {
        this.fZU = null;
        this.fZW = -1;
        this.fZY = -1;
        com.baidu.tieba.frs.br io = com.baidu.tieba.frs.bq.abd().io(1);
        if (io != null) {
            this.fZU = io.bWM;
            this.fZW = getIntent().getIntExtra("category_id", -1);
            if (this.fZU != null && !this.fZU.isEmpty() && this.fZW >= 0) {
                this.fZV = new com.baidu.tieba.frs.bp();
                this.fZV.bWI = 0;
                this.fZV.name = getPageContext().getResources().getString(w.l.category_auto);
                this.fZY = this.fZV.bWI;
                this.fZX = this.fZV.name;
                for (com.baidu.tieba.frs.bp bpVar : this.fZU) {
                    if (bpVar.bWI == this.fZW) {
                        this.fZY = bpVar.bWI;
                        this.fZX = bpVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bpO() {
        if (this.fZU != null && !this.fZU.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.fZZ = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.fZZ.setText(this.fZX);
            this.fZZ.b(this.fZU, this.fZV, this.fZY);
            this.fZZ.setCategoryContainerClickCallback(new ak(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void bpP() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gaQ = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.gaQ.setTitle(w.l.no_disturb_start_time);
        this.gaQ.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.gaQ);
        this.gaQ.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.gaQ);
        return this.gaQ;
    }

    private void bpQ() {
        this.fZO = (RelativeLayout) findViewById(w.h.addition_container);
        this.fZP = (TextView) findViewById(w.h.addition_create_time);
        this.fZQ = (TextView) findViewById(w.h.addition_last_time);
        this.fZR = (TextView) findViewById(w.h.addition_last_content);
        if (this.fZN != null) {
            this.fZO.setVisibility(0);
            this.fZP.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.au.q(this.fZN.getCreateTime() * 1000));
            if (this.fZN.getAlreadyCount() == 0) {
                this.fZQ.setVisibility(8);
            } else {
                this.fZQ.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.au.q(this.fZN.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fZN.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fZR.setText(lastAdditionContent);
            } else {
                this.fZR.setVisibility(8);
            }
            bpV().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.fZN.getAlreadyCount()), Integer.valueOf(this.fZN.getTotalCount())));
            this.mName.setText(w.l.write_addition_title);
            return;
        }
        this.fZO.setVisibility(8);
    }

    private void beb() {
        this.fsx = findViewById(w.h.post_prefix_layout);
        this.fsu = (TextView) findViewById(w.h.post_prefix);
        this.fZG = findViewById(w.h.prefix_divider);
        this.fsw = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fsx.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.frX = 1;
            this.fsx.setOnClickListener(new an(this));
            this.fsw = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.fsw.setVisibility(0);
                this.fsu.setOnClickListener(new ao(this));
            }
            this.fsv = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fsv.a(this);
            this.fsv.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.fsv.setOutsideTouchable(true);
            this.fsv.setFocusable(true);
            this.fsv.setOnDismissListener(this);
            this.fsv.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b);
            int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.j(this.fsu, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.c(this.fsw, w.g.icon_frs_arrow_n);
            this.fsu.setTextColor(color);
            this.fYA.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fYA.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fsv.addView(aVar);
            }
            this.fsv.te(0);
            this.fsu.setText(prefixs.get(1));
            tC(1);
            return;
        }
        this.fsx.setVisibility(8);
    }

    private void bpR() {
        if (this.fZz && this.mData != null) {
            this.fZE.setVisibility(0);
            this.fZF.setVisibility(0);
            this.fZD = new FeedBackModel(this);
            this.fZD.rw(this.mData.getForumName());
            this.fZD.setLoadDataCallBack(new aq(this));
        }
    }

    protected void bpS() {
        this.mPost.setOnClickListener(new ar(this));
    }

    protected void bpT() {
        this.fZJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fZJ.cB(getPageContext().getString(w.l.is_save_draft)).ar(false).a(getPageContext().getString(w.l.save), new as(this)).b(getPageContext().getString(w.l.not_save), new au(this));
        this.fZJ.b(getPageContext());
    }

    protected void bec() {
        this.fXz = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.fXz.setIsRound(true);
        this.fXz.setDrawBorder(false);
        this.fXz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String di = com.baidu.tbadk.core.util.q.di(currentPortrait);
            this.fXz.setUrl(di);
            this.fXz.c(di, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.fXz.setVisibility(0);
        }
        this.fsp = (EditText) findViewById(w.h.post_title);
        this.fsp.setOnClickListener(this.gaL);
        this.fsp.setOnFocusChangeListener(this.fsn);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fsp.setText(this.mData.getTitle());
                this.fsp.setSelection(this.mData.getTitle().length());
            } else if (this.fZB) {
                this.fsp.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fsp.addTextChangedListener(this.gaN);
        if (!this.mData.getHaveDraft()) {
            bpM();
            this.gay = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fsp.setHint(getResources().getString(w.l.feedback_title_hint));
        } else {
            this.fsp.setHint(getResources().getString(w.l.post_title_hint));
        }
    }

    private TextWatcher aSL() {
        av avVar = new av(this);
        if (this.gan && this.gao) {
            if (this.gal != null) {
                this.gai.removeTextChangedListener(this.gal);
            }
            this.gal = avVar;
        } else if (this.gan) {
            if (this.gam != null) {
                this.gae.removeTextChangedListener(this.gam);
            }
            this.gam = avVar;
        }
        return avVar;
    }

    private long h(EditText editText) {
        if (editText == this.gae) {
            return 233L;
        }
        if (editText != this.gai) {
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
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void bee() {
        this.fst = (EditText) findViewById(w.h.post_content);
        this.fst.setDrawingCacheEnabled(false);
        this.fst.setOnClickListener(this.gaL);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString X = TbFaceManager.DG().X(getPageContext().getPageActivity(), this.mData.getContent());
            this.fst.setText(X);
            this.fst.setSelection(X.length());
        } else if (this.mData.getType() == 2) {
            if (this.fZK) {
                if (this.fZL != null && this.fZL.length() > 0) {
                    this.fst.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.fZL}));
                    this.fst.setSelection(this.fst.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fst.setText(format);
                this.fst.setSelection(format.length());
            }
        }
        this.fst.setOnFocusChangeListener(this.fsn);
        this.fst.setOnTouchListener(new aw(this));
        this.fst.addTextChangedListener(this.gaO);
        mc(true);
        if (this.mData.isUserFeedback()) {
            this.fst.setHint(w.l.write_input_content);
        } else {
            this.fst.setHint(w.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gan) {
            bpV().setPadding(0, 0, 0, 0);
            bpV().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.aq.k(bpV(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dJM) && this.fZN == null) {
                com.baidu.adp.lib.f.c.fM().a(this.dJM, 19, new ax(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpU() {
        int i = 5000;
        if (this.fZN != null) {
            i = 1000;
        }
        return bpV().getText() != null && bpV().getText().length() >= i;
    }

    private void fm(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.fZx)) {
                this.fZx = "";
                bpV().requestFocus();
                if (bpV().getText() != null && bpV().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bpV().getSelectionStart();
                    editable = bpV().getText();
                }
            } else if ("from_title".equals(this.fZx)) {
                this.fZx = "";
                bpW().requestFocus();
                if (bpW().getText() != null && bpW().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bpW().getSelectionStart();
                    editable = bpW().getText();
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
    public void md(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bpV().getText().getSpans(0, bpV().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fZM == null) {
                this.fZM = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.fZM.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xF = lVar.xF();
        if (name != null) {
            com.baidu.adp.lib.f.c.fM().a(name, 20, new ay(this, new SpannableStringBuilder(name), xF), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bpV() != null && bpV().getText() != null) {
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
                int selectionStart = bpV().getSelectionStart() - 1;
                if (bpV().getText().length() > 1 && selectionStart >= 0 && bpV().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bpV().getText().insert(bpV().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bpV().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bpV().getText().insert(bpV().getSelectionStart(), spannableString2);
            }
            Editable text = bpV().getText();
            if (text != null) {
                this.gaI.clear();
                this.gaI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gaI);
                if (EmotionGroupType.BIG_EMOTION == emotionGroupType && spannableString2 != null && bpV().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bpV().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bpV().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bpV() {
        return this.gan ? this.gae : this.fst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bpW() {
        return this.gan ? this.gai : this.fsp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpX() {
        Editable text;
        if (bpV() != null && (text = bpV().getText()) != null) {
            int selectionStart = bpV().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bpV().onKeyDown(67, this.fZH);
            }
            bpV().onKeyDown(67, this.fZH);
            int selectionStart2 = bpV().getSelectionStart();
            if (text != null) {
                this.gaI.clear();
                this.gaI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gaI);
                bpV().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.fZz = true;
        }
    }

    private void bpY() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bpZ() {
        try {
            if (this.fZJ != null) {
                this.fZJ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aIy.c(null);
        this.aIy.cW(w.l.sending);
        this.aIy.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aIy.aH(false);
    }

    private Boolean bqa() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aAG = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bpW() != null) {
                str = bpW().getText().toString();
            }
            if (bpV() != null) {
                str2 = bpV().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.frX == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            me(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        me(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    me(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gan) {
                    me(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    me(true);
                }
            }
            if (this.mData.getType() == 4) {
                me(j(this.gae) && i(this.gai));
            } else if (this.mData.getType() == 5) {
                me(j(this.gae));
            } else if (!TextUtils.isEmpty(str2) || this.aAy != null) {
                me(true);
            } else if (this.mData.getVideoInfo() != null) {
                me(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                me(true);
            } else {
                me(false);
            }
        }
    }

    private void me(boolean z) {
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
        this.aAB = new NewWriteModel(this);
        this.aAB.b(this.aAR);
        registerListener(this.gaJ);
        this.mDialogCancelListener = new az(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fZz = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fZB = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fZK = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fZL = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fZN = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fZN != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fZS = bundle.getInt("mem_type", 0);
            this.agW = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gaF = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gaz = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fZz = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fZB = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fZK = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fZL = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.fZN = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fZN != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fZS = intent.getIntExtra("mem_type", 0);
            this.agW = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gaF = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gaz = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.fZz);
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
        this.dJM = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fZA = true;
        }
        bpN();
        try {
            this.gaq = bqg();
        } catch (Throwable th) {
            this.gaq = null;
        }
    }

    private void bqb() {
        if (com.baidu.tbadk.core.util.x.q(this.mList) > 0 && this.mList.get(0) != null) {
            this.fXz.setVisibility(8);
            this.gaB.setVisibility(0);
            this.gaC.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fsp.setText(com.baidu.tbadk.plugins.a.fX(rx(this.mList.get(0).mTopicName)));
                this.fsp.setMovementMethod(com.baidu.tieba.view.g.bmr());
            }
            this.gaD.setText(this.mList.get(0).mForumName);
            this.fsp.addTextChangedListener(new ba(this));
            this.gaE.setOnClickListener(new bc(this));
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString fX = com.baidu.tbadk.plugins.a.fX(rx(hotTopicBussinessData.mTopicName));
            if (fX != null) {
                this.fsp.setText(fX);
            }
            this.gaD.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rx(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        String rx;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle())) {
                    this.dZL.setVisibility(0);
                    this.dZL.requestFocus();
                    this.ayP.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (com.baidu.adp.lib.util.j.isEmpty(bpW().getText().toString()) || this.gay || ((this.fZz || this.fZA) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.r(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.x.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            rx = this.mData.getTitle();
                        } else {
                            rx = rx(str);
                        }
                        SpannableString fX = com.baidu.tbadk.plugins.a.fX(rx);
                        if (fX != null) {
                            bpW().setText(fX);
                            bpW().setSelection(rx.length());
                        }
                    } else {
                        bpW().setText(com.baidu.tbadk.plugins.a.fX(this.mData.getTitle()));
                        bpW().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bpM();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ayP.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bpV().getText().toString()) || this.fZz || this.fZA) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DG().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gaK);
                    bpV().setText(a2);
                    bpV().setSelection(a2.length());
                    if (this.gan) {
                        b(this.gak, this.gae);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bqf();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        CZ();
                    }
                    mf(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bqc();
                }
                bed();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.fZU != null) {
                    this.fZY = this.fZV.bWI;
                    this.fZX = this.fZV.name;
                    int i = 0;
                    while (true) {
                        if (i == this.fZU.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bp bpVar = this.fZU.get(i);
                        if (categoryTo != bpVar.bWI) {
                            i++;
                        } else {
                            this.fZY = categoryTo;
                            this.fZX = bpVar.name;
                            this.mData.setCategoryTo(this.fZY);
                            break;
                        }
                    }
                    if (this.fZZ != null) {
                        this.fZZ.setText(this.fZX);
                        this.fZZ.b(this.fZU, this.fZV, this.fZY);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.ayP.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.ayP.AG();
                return;
            }
            return;
        }
        bqc();
        bpM();
    }

    private void bqc() {
        if ((!this.gan || this.gac != null) && this.gab != null) {
            this.gac.c(this.writeImagesInfo);
            aAw();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fZK);
        if (this.fZz) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAz);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fZN);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fZS);
        bundle.putString("from", this.agW);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gaz);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bpV().getEditableText().toString();
        if (editable != null) {
            bpV().setText(TbFaceManager.DG().a(getPageContext().getPageActivity(), editable, this.gaK));
            bpV().setSelection(bpV().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
        bdV();
        String editable = bpW().getText().toString();
        this.mData.setContent(bpV().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.frX != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.fsu.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fZz || this.fZA) {
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
        if (this.fZW >= 0) {
            this.mData.setCategoryFrom(this.fZW);
        }
        if (this.fZY >= 0) {
            this.mData.setCategoryTo(this.fZY);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aAA != null && this.aAA.QG());
        this.aAB.lx(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.r(this.mList) && this.gaA != null && this.gaA.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gaA.mForumId));
            this.mData.setForumName(this.gaA.mForumName);
        }
        this.aAB.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aAy != null) {
            if (this.aAy.getId() != null) {
                this.aAB.getWriteData().setVoice(this.aAy.getId());
                this.aAB.getWriteData().setVoiceDuringTime(this.aAy.duration);
            } else {
                this.aAB.getWriteData().setVoice(null);
                this.aAB.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aAB.getWriteData().setVoice(null);
            this.aAB.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aAB.bjm()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aAB.startPostWrite();
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
            if (this.fZN != null) {
                i2 = this.fZN.getTotalCount();
                i = this.fZN.getAlreadyCount() + 1;
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
                if (this.ayP != null && !this.ayP.Cp()) {
                    bpV().requestFocus();
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
                            bpV().getText().insert(bpV().getSelectionStart(), sb.toString());
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
                                aUh();
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
                    if (!this.gan) {
                        B(intent);
                        bed();
                        return;
                    }
                    ad(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ayP.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ayP.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ayP.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bed();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.M(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fZy) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fZy = false;
                            }
                            sb2.append(stringExtra);
                            fm(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.r(this.mList)) {
                    if (!com.baidu.tbadk.core.util.x.r(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gaA = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gaA);
                    }
                } else if (i == 25013) {
                    if (intent != null) {
                        this.mData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                    }
                    this.mData.setForumId("0");
                    this.mData.setCanNoForum(true);
                    this.mData.setCallFrom(this.gaz);
                    this.mData.setRecommendExt(this.fXo.getRecommendExt());
                    if (this.mData.getVideoInfo() != null) {
                        TiebaStatic.log("c10063");
                    }
                    bpc();
                }
            }
        } else if (i2 == 0) {
            if (this.ayP != null && !this.ayP.Cp()) {
                this.fst.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    CU();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bqe();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aAz = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAz);
                    return;
                case 12012:
                    bqe();
                    return;
                case 25004:
                    if ("from_title".equals(this.fZx)) {
                        bpW().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fZx)) {
                        bpV().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bqd() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bqe() {
        if (this.gan) {
            this.gac.c(this.writeImagesInfo);
            aAw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAw() {
        this.gac.notifyDataSetChanged();
        this.gab.invalidate();
        this.mHandler.postDelayed(new be(this), 550L);
    }

    public void r(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bed();
    }

    private void aa(Intent intent) {
        if (this.gan) {
            ad(intent);
            bqe();
        } else {
            ae(intent);
        }
        bed();
    }

    private void ad(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bqe();
            mf(true);
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

    private void aUh() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void V(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eUv.parseJson(stringExtra);
            this.eUv.updateQuality();
            if (this.eUv.getChosedFiles() != null && this.eUv.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eUv.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eUv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bpW());
        HidenSoftKeyPad(this.mInputManager, bpV());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ae(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aAz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAz, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bqf();
            CZ();
        }
        mf(true);
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
                bqf();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    CZ();
                }
            }
            mf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqf() {
        if (this.ayP.ey(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void CU() {
        new bf(this).execute(new Void[0]);
    }

    private void mf(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bTZ == null) {
            this.bTZ = VoiceManager.instance();
        }
        return this.bTZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aas() {
        this.bTZ = getVoiceManager();
        this.bTZ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.sr(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ap(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.fZN == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAI = i;
        if (this.ayP != null) {
            this.ayP.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.ayP.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void CZ() {
        if (!this.gan) {
            if (this.ayP != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.ayP.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.ayP.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.ayP.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.ayP.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gaa != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.gaa.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.gaa.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.gaa.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gaa.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (this.ayP != null) {
            this.ayP.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tC(int i) {
        if (i < this.fYA.size()) {
            for (int i2 = 0; i2 < this.fYA.size(); i2++) {
                this.fYA.get(i2).lS(false);
            }
            this.fYA.get(i).lS(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rP(int i) {
        this.frX = i;
        this.fsv.te(i);
        tC(i);
        this.fsu.setText(this.mPrefixData.getPrefixs().get(i));
        bed();
        com.baidu.adp.lib.g.j.a(this.fsv, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fsx.setSelected(false);
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
            CP();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAz);
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
        if (this.gaw && System.currentTimeMillis() - this.gax < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.gaw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.gat != null) {
            rz(str);
            this.gat.dismiss();
        }
    }

    private void bW(Context context) {
        gav = com.baidu.adp.lib.util.k.ag(context);
    }

    private void rz(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gaw = true;
        bqf();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            CZ();
        }
        mf(true);
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

    private File bqg() {
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

    private void bqh() {
        if (this.gaq != null && this.mData.getType() == 0) {
            bW(getActivity());
            this.gas = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.gas.setOnClickListener(new bg(this));
            this.gar = (TbImageView) this.gas.findViewById(w.h.rec_img_view);
            this.gau = (LinearLayout) this.gas.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gaq.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gaq.getAbsolutePath());
                Bitmap c = c(this.gaq.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.gar.setImageBitmap(c);
                    this.gar.setDrawBorder(true);
                    this.gar.setBorderWidth(2);
                    this.gar.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10264));
                    this.gat = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.gat.setCanceledOnTouchOutside(true);
                    this.gat.setOnDismissListener(new bh(this));
                    this.gat.setContentView(this.gas);
                    this.gat.show();
                    Window window = this.gat.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (gav / 18) + getResources().getDimensionPixelSize(w.f.ds12);
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
            this.fZy = false;
            this.fZx = "";
            if ("from_content".equals(str)) {
                this.fZx = "from_content";
            } else if ("from_title".equals(str)) {
                this.fZx = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                md(false);
            }
        }
    }

    public void AI() {
        if (this.fZz || !com.baidu.tbadk.core.util.x.r(this.mList)) {
            this.dZL.setVisibility(0);
            this.dZL.requestFocus();
            this.ayP.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.dZL.setVisibility(8);
    }
}
