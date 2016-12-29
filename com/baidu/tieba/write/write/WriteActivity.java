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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, ac.a, b.a {
    private static int fDw = 0;
    private String acW;
    private com.baidu.tbadk.editortools.j aun;
    private VoiceData.VoiceModel avW;
    private String avX;
    private com.baidu.tieba.tbadkCore.location.d avY;
    private com.baidu.tieba.tbadkCore.writeModel.b avZ;
    private String bZC;
    List<com.baidu.tieba.frs.bv> bZr;
    private VoiceManager byf;
    private TextView eWL;
    private com.baidu.tieba.write.b eWM;
    private ImageView eWN;
    private View eWO;
    private int eWn;
    private LinearLayout fCI;
    private View fCL;
    private View fCM;
    private Toast fCS;
    private AdditionData fCT;
    private RelativeLayout fCU;
    private TextView fCV;
    private TextView fCW;
    private TextView fCX;
    com.baidu.tieba.frs.bv fCZ;
    private HotTopicBussinessData fDA;
    private View fDB;
    private View fDC;
    private TextView fDD;
    private TextView fDE;
    private com.baidu.tieba.view.c fDP;
    private int fDa;
    private int fDb;
    private PostCategoryView fDc;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fCD = "";
    private boolean fCE = false;
    private WriteData eWm = null;
    private boolean fCF = false;
    private boolean fCG = false;
    private boolean fCH = false;
    private InputMethodManager mInputManager = null;
    private EditText eWF = null;
    private HeadImageView fAK = null;
    private View eWG = null;
    private LinearLayout eWI = null;
    private EditText eWJ = null;
    private p fCJ = null;
    private FeedBackTopListView fCK = null;
    private ArrayList<com.baidu.tieba.write.a> fBG = new ArrayList<>();
    private String dzm = null;
    private final KeyEvent fCN = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View ajr = null;
    private TextView fCO = null;
    private TextView eWK = null;
    private TextView cGh = null;
    private DialogInterface.OnCancelListener esg = null;
    private com.baidu.tbadk.core.dialog.a fCP = null;
    private final Handler mHandler = new Handler();
    private boolean fCQ = false;
    private String fCR = null;
    private RelativeLayout cFi = null;
    private String awf = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int awh = 0;
    private int fCY = 0;
    private WriteImagesInfo eCc = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fDd = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fDe = null;
    private ScrollView fDf = null;
    private EditText fDg = null;
    private View fDh = null;
    private View fDi = null;
    private View fDj = null;
    private EditText fDk = null;
    private TextView fDl = null;
    private TextView fDm = null;
    private TextWatcher fDn = null;
    private TextWatcher fDo = null;
    private boolean fDp = false;
    private boolean fDq = false;
    private com.baidu.tbadk.core.view.a aEd = null;
    private File fDr = null;
    private TbImageView fDs = null;
    private View fDt = null;
    private Dialog fDu = null;
    private LinearLayout fDv = null;
    private boolean fDx = false;
    private long fDy = -1000;
    private boolean fDz = false;
    private String fDF = "";
    private String fDG = "";
    private int fDH = 0;
    private SpannableStringBuilder fDI = new SpannableStringBuilder();
    private final HttpMessageListener fDJ = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fDK = new ag(this);
    private final b.d awp = new as(this);
    private final d.a awn = new bd(this);
    private final CustomMessageListener fiA = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fDL = new bh(this);
    private boolean fDM = true;
    private final View.OnFocusChangeListener eWD = new bi(this);
    private TextWatcher fDN = new bj(this);
    private TextWatcher fDO = new bk(this);
    private final a.InterfaceC0072a egv = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.acW)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Df() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(r.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dg();
        } else if (this.avY.bgJ()) {
            De();
        } else {
            this.avY.kY(false);
            b(1, true, null);
            this.avY.bgH();
        }
    }

    private void Dg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cb(r.j.location_app_permission_prompt).a(r.j.isopen, new x(this)).b(r.j.cancel, new y(this)).b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bng() {
        int selectionEnd = bnw().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bnw().getText().getSpans(0, bnw().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bnw().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bnw().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnh() {
        if (this.aun != null) {
            this.aun.setBarLauncherEnabled(!this.fDM);
            this.aun.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fDp) {
            this.eWF.setVisibility(8);
            if (this.eWm.getType() == 5) {
                this.fDj.setVisibility(8);
            } else {
                this.fDj.setVisibility(0);
            }
            b(this.fDm, this.fDg);
            b(this.fDl, this.fDk);
            bbU();
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
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        bns();
        this.avY = new com.baidu.tieba.tbadkCore.location.d(this);
        this.avY.a(this.awn);
        registerListener(this.fiA);
        initEditor();
        bnJ();
        if (this.fDp) {
            this.fDe.setEditorTools(this.aun);
        } else {
            this.eWF.requestFocus();
        }
    }

    private void initEditor() {
        this.aun = new com.baidu.tbadk.editortools.j(getActivity());
        this.aun.setBarMaxLauCount(5);
        this.aun.setMoreButtonAtEnd(true);
        this.aun.setBarLauncherType(1);
        this.aun.bD(true);
        this.aun.bC(true);
        this.aun.setMoreLauncherIcon(r.f.write_more);
        this.aun.setBackgroundColorId(r.d.cp_bg_line_d);
        switch (this.eWm.getType()) {
            case 4:
            case 5:
                bnk();
                break;
            default:
                bnl();
                break;
        }
        this.aun.CC();
        if (this.fCI != null) {
            this.fCI.addView(this.aun);
        }
        bnm();
        this.aun.lz();
        com.baidu.tbadk.editortools.p eA = this.aun.eA(6);
        if (eA != null && !TextUtils.isEmpty(this.awf)) {
            ((View) eA).setOnClickListener(new z(this));
        }
        if (!this.fDp) {
            this.aun.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aun.AP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("xiaoying_has_click", false)) {
            this.aun.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("hot_topic_has_click", false)) {
            this.aun.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bni() {
        this.fDh = this.mRootView.findViewById(r.g.photo_live_scroll);
        this.fDj = this.fDh.findViewById(r.g.live_post_title_container);
        this.fDg = (EditText) this.fDh.findViewById(r.g.live_post_content);
        this.fDd = (GridView) this.fDh.findViewById(r.g.photoLiveGridView);
        this.fDk = (EditText) this.fDh.findViewById(r.g.live_post_title);
        this.fDl = (TextView) this.fDh.findViewById(r.g.titleOverPlusNumber);
        this.fDm = (TextView) this.fDh.findViewById(r.g.contentOverPlusNumber);
        this.fDi = this.fDh.findViewById(r.g.live_interval_view);
        this.fDl.setText(String.valueOf(20));
        this.fDm.setText(String.valueOf(233));
        this.fDh.setVisibility(0);
        this.fDl.setVisibility(0);
        this.fDm.setVisibility(0);
        this.fDk.setHint(r.j.tips_title_limit_new);
        this.fDk.setOnFocusChangeListener(new aa(this));
        if (this.eWm.getType() == 4) {
            this.fDg.setHint(r.j.live_write_input_content_new);
        } else if (this.eWm.getType() == 5) {
            this.fDg.setHint(r.j.live_write_input_content_update);
        }
        this.fDg.setOnFocusChangeListener(new ab(this));
        this.fDg.requestFocus();
        this.fDg.addTextChangedListener(aRk());
        this.fDk.requestFocus();
        this.fDk.addTextChangedListener(aRk());
        this.fDk.setOnClickListener(this.fDL);
        this.fDg.setOnClickListener(this.fDL);
        this.fDe = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fDd);
        this.fDe.sm(6);
        this.fDd.setAdapter((ListAdapter) this.fDe);
        View findViewById = this.fDh.findViewById(r.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ac(this));
        bnj();
    }

    private void bnj() {
        if (this.eWm.getType() == 0) {
            if (this.eWm.getTitle() != null) {
                this.fDk.setText(this.eWm.getTitle());
                this.fDk.setSelection(this.eWm.getTitle().length());
            }
        } else if (this.eWm.getType() != 1) {
            this.eWm.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fDp) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bnE();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Dp();
            return;
        }
        if (this.aun.CE()) {
            this.aun.AP();
        }
        String str = null;
        if (this.eWm != null) {
            str = this.eWm.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fDp) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bnk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aun.y(arrayList);
        com.baidu.tbadk.editortools.x eC = this.aun.eC(5);
        if (eC != null) {
            eC.auT = 2;
            eC.auR = r.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.auR = r.f.write_at;
        this.aun.b(aVar);
        this.aun.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bnl() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        com.baidu.tbadk.editortools.x xVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.auR = r.f.write_picture;
        this.aun.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.aun.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aun.b(aVar);
        aVar.auR = r.f.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar5 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar5.auV = true;
            xVar5.auR = r.f.write_graffiti;
            xVar5.auT = 4;
            this.aun.b(xVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar4.auT = 5;
            xVar4.auR = r.f.write_privilege;
            this.aun.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.auR = r.f.write_at;
        this.aun.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar3.auV = true;
            xVar3.auT = 9;
            xVar3.auR = 0;
            this.aun.b(xVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask5 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask5.getData()) != null) {
            xVar2.auV = true;
            xVar2.auT = 10;
            xVar2.auR = 0;
            this.aun.b(xVar2);
        }
        Boolean bnB = bnB();
        if (!this.fCF && bnB != null && bnB.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bhh() && com.baidu.tieba.tbadkCore.t.a(this.eWm.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.auT = 6;
            xVar.auR = r.f.write_recorder;
            this.aun.b(xVar);
        }
        if (this.fCT == null) {
            this.aun.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.aun.y(arrayList);
        com.baidu.tbadk.editortools.x eC = this.aun.eC(5);
        if (eC != null) {
            eC.auT = 1;
            eC.auR = r.f.write_emotion;
        }
    }

    private void bnm() {
        ad adVar = new ad(this);
        this.aun.a(16, adVar);
        this.aun.a(14, adVar);
        this.aun.a(24, adVar);
        this.aun.a(3, adVar);
        this.aun.a(10, adVar);
        this.aun.a(11, adVar);
        this.aun.a(12, adVar);
        this.aun.a(13, adVar);
        this.aun.a(15, adVar);
        this.aun.a(18, adVar);
        this.aun.a(25, adVar);
        this.aun.a(27, adVar);
        this.aun.a(29, adVar);
        this.aun.a(40, adVar);
        this.aun.a(43, adVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        if (this.avY.bgL()) {
            if (this.avY.bgJ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bgE().getLocationData().bgA());
                return;
            }
            b(1, true, null);
            this.avY.bgH();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbL() {
        if (this.avZ != null) {
            this.avZ.cancelLoadData();
        }
        if (this.fCJ != null) {
            this.fCJ.cancelLoadData();
        }
        if (this.avY != null) {
            this.avY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bbL();
        bnA();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmF() {
        if (this.eWm != null && this.eWm.getType() == 2 && this.fCQ) {
            finish();
        } else if (this.eWm == null) {
            finish();
        } else {
            this.eWm.setTitle(bnx().getText().toString());
            this.eWm.setContent(bnw().getText().toString());
            int type = this.eWm.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.ac.b(this.eWm.getForumId(), this.eWm);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ac.c(this.eWm.getThreadId(), this.eWm);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ac.b(String.valueOf(this.eWm.getForumId()) + "photolive", this.eWm);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ac.c(String.valueOf(this.eWm.getThreadId()) + "updatephotolive", this.eWm);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eWM != null && this.eWM.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.eWM, getPageContext().getPageActivity());
                return true;
            } else if (this.aun.CE()) {
                this.aun.AP();
                return true;
            } else {
                bbL();
                bmF();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.cFi);
        getLayoutMode().x(this.fDv);
        if (this.fDs != null && i == 1) {
            this.fDs.setBorderColor(com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ar.c(this.eWK, r.d.cp_link_tip_a, 1);
        bnh();
        com.baidu.tbadk.core.util.ar.l(this.fDh, r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(this.eWG, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.fDi, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(bnx(), r.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dzm)) {
            com.baidu.tbadk.core.util.ar.l(bnw(), r.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_e);
        bnx().setTextColor(color);
        bnw().setTextColor(color);
        a(bnx(), color2);
        a(bnw(), color2);
        bbU();
        this.aun.onChangeSkinType(i);
        if (this.fDc != null) {
            this.fDc.wx();
        }
        com.baidu.tbadk.core.util.ar.j((View) this.cGh, r.d.cp_cont_f);
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart <= selectionEnd) {
            editText.setSelection(selectionStart, selectionEnd);
        }
    }

    private void initUI() {
        this.aEd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fDp = this.eWm.getType() == 4 || 5 == this.eWm.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(r.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.ajr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajr.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ajr != null && (this.ajr.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ajr.getLayoutParams();
            layoutParams2.width = -2;
            this.ajr.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.f.icon_nav_close_selector, r.f.icon_nav_close_selector);
        this.cGh = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.ar.j((View) this.cGh, r.d.cp_cont_f);
        this.fCO = (TextView) findViewById(r.g.btn_image_problem);
        this.eWK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eWK.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds10);
        this.eWK.setLayoutParams(layoutParams3);
        this.eWK.setOnFocusChangeListener(this.eWD);
        this.fDf = (ScrollView) findViewById(r.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fCK = (FeedBackTopListView) findViewById(r.g.feedback_top_list);
        this.fCL = findViewById(r.g.feedback_divider);
        this.cFi = (RelativeLayout) findViewById(r.g.parent);
        this.fCI = (LinearLayout) findViewById(r.g.tool_view);
        this.fCI.setContentDescription("..");
        this.eWG = findViewById(r.g.interval_view);
        this.fDB = findViewById(r.g.hot_topic_fourm_view);
        this.fDC = findViewById(r.g.hot_topic_divider);
        this.fDD = (TextView) findViewById(r.g.hot_topic_title_edt);
        this.fDE = (TextView) findViewById(r.g.change_one_tv);
        bbT();
        if (this.fDp) {
            this.fDf.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bni();
        }
        bbV();
        if (this.fCF || this.fCG) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(r.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(r.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.eWI = (LinearLayout) findViewById(r.g.post_content_container);
        this.eWI.setDrawingCacheEnabled(false);
        this.eWI.setOnClickListener(new ae(this));
        this.ajr.setOnFocusChangeListener(this.eWD);
        this.ajr.setOnClickListener(new af(this));
        this.fCO.setOnClickListener(new ah(this));
        bnp();
        k(bnB());
        bnt();
        switch (this.eWm.getType()) {
            case 0:
                if (this.fCF || this.fCG) {
                    if (this.fCH) {
                        this.cGh.setText(r.j.feedback_vcode);
                    } else {
                        this.cGh.setText(r.j.feedback);
                    }
                } else {
                    this.cGh.setText(r.j.post_new_thread);
                }
                this.eWF.setVisibility(0);
                this.eWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.cGh.setText(r.j.send_reply);
                this.eWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.eWF.setVisibility(8);
                break;
            case 4:
                this.cGh.setText(r.j.publish_photo_live);
                this.eWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cGh.setText(getPageContext().getResources().getString(r.j.update_photo_live_tip, Integer.valueOf(this.eWm.getFloorNum() + 1)));
                this.fDi.setVisibility(8);
                break;
        }
        bnu();
        bnz();
        bnh();
        bnr();
        bbS();
        if (com.baidu.tbadk.core.util.x.t(this.mList) || this.mList.get(0) == null) {
            this.eWF.getPaint().setFakeBoldText(true);
        } else {
            this.eWF.getPaint().setFakeBoldText(false);
            bnC();
        }
        if (this.eWm.getType() == 4 && this.eWO != null && this.fCM != null) {
            this.eWO.setVisibility(8);
            this.fCM.setVisibility(8);
        }
        bbU();
        ShowSoftKeyPad(this.mInputManager, this.eWF);
        bnq();
    }

    private void bnn() {
        if (this.eWm != null && this.eWm.getType() == 0 && !this.fCF && !this.fCG && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.av.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bnx() != null) {
                bnx().setText(c);
                bnx().setSelection(c.length());
            }
        }
    }

    private void bno() {
        this.bZr = null;
        this.fDa = -1;
        this.fDb = -1;
        com.baidu.tieba.frs.bx hj = com.baidu.tieba.frs.bw.XX().hj(1);
        if (hj != null) {
            this.bZr = hj.bBA;
            this.fDa = getIntent().getIntExtra("category_id", -1);
            if (this.bZr != null && !this.bZr.isEmpty() && this.fDa >= 0) {
                this.fCZ = new com.baidu.tieba.frs.bv();
                this.fCZ.bBw = 0;
                this.fCZ.name = getPageContext().getResources().getString(r.j.category_auto);
                this.fDb = this.fCZ.bBw;
                this.bZC = this.fCZ.name;
                for (com.baidu.tieba.frs.bv bvVar : this.bZr) {
                    if (bvVar.bBw == this.fDa) {
                        this.fDb = bvVar.bBw;
                        this.bZC = bvVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bnp() {
        if (this.bZr != null && !this.bZr.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(r.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(r.g.interval_view_cate).setVisibility(0);
            this.fDc = (PostCategoryView) linearLayout.findViewById(r.g.category_selected);
            this.fDc.setText(this.bZC);
            this.fDc.b(this.bZr, this.fCZ, this.fDb);
            this.fDc.setCategoryContainerClickCallback(new ai(this));
            linearLayout.setOnClickListener(new aj(this));
        }
    }

    private void bnq() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fDP = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new ak(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fDP.setTitle(r.j.no_disturb_start_time);
        this.fDP.setButton(-1, getPageContext().getString(r.j.alert_yes_button), this.fDP);
        this.fDP.setButton(-2, getPageContext().getString(r.j.alert_no_button), this.fDP);
        return this.fDP;
    }

    private void bnr() {
        this.fCU = (RelativeLayout) findViewById(r.g.addition_container);
        this.fCV = (TextView) findViewById(r.g.addition_create_time);
        this.fCW = (TextView) findViewById(r.g.addition_last_time);
        this.fCX = (TextView) findViewById(r.g.addition_last_content);
        if (this.fCT != null) {
            this.fCU.setVisibility(0);
            this.fCV.setText(String.valueOf(getPageContext().getString(r.j.write_addition_create)) + com.baidu.tbadk.core.util.av.s(this.fCT.getCreateTime() * 1000));
            if (this.fCT.getAlreadyCount() == 0) {
                this.fCW.setVisibility(8);
            } else {
                this.fCW.setText(String.valueOf(getPageContext().getString(r.j.write_addition_last)) + com.baidu.tbadk.core.util.av.s(this.fCT.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fCT.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fCX.setText(lastAdditionContent);
            } else {
                this.fCX.setVisibility(8);
            }
            bnw().setHint(String.format(getPageContext().getString(r.j.write_addition_hint), Integer.valueOf(this.fCT.getAlreadyCount()), Integer.valueOf(this.fCT.getTotalCount())));
            this.cGh.setText(r.j.write_addition_title);
            return;
        }
        this.fCU.setVisibility(8);
    }

    private void bbS() {
        this.eWO = findViewById(r.g.post_prefix_layout);
        this.eWL = (TextView) findViewById(r.g.post_prefix);
        this.fCM = findViewById(r.g.prefix_divider);
        this.eWN = (ImageView) findViewById(r.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.eWO.setVisibility(0);
            this.fCM.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.eWn = 1;
            this.eWO.setOnClickListener(new al(this));
            this.eWN = (ImageView) findViewById(r.g.prefix_icon);
            if (size > 1) {
                this.eWN.setVisibility(0);
                this.eWL.setOnClickListener(new am(this));
            }
            this.eWM = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.eWM.a(this);
            this.eWM.setMaxHeight(com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds510));
            this.eWM.setOutsideTouchable(true);
            this.eWM.setFocusable(true);
            this.eWM.setOnDismissListener(this);
            this.eWM.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(r.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.k(this.eWL, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.c(this.eWN, r.f.icon_title_down);
            this.eWL.setTextColor(color);
            this.fBG.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fBG.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.eWM.addView(aVar);
            }
            this.eWM.sc(0);
            this.eWL.setText(prefixs.get(1));
            sw(1);
            return;
        }
        this.eWO.setVisibility(8);
    }

    private void bns() {
        if (this.fCF && this.eWm != null) {
            this.fCK.setVisibility(0);
            this.fCL.setVisibility(0);
            this.fCJ = new p(this);
            this.fCJ.rr(this.eWm.getForumName());
            this.fCJ.setLoadDataCallBack(new an(this));
        }
    }

    protected void bnt() {
        this.eWK.setOnClickListener(new ao(this));
    }

    protected void bnu() {
        this.fCP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fCP.cG(getPageContext().getString(r.j.is_save_draft)).au(false).a(getPageContext().getString(r.j.save), new ap(this)).b(getPageContext().getString(r.j.not_save), new ar(this));
        this.fCP.b(getPageContext());
    }

    protected void bbT() {
        this.fAK = (HeadImageView) findViewById(r.g.user_head_portrait);
        this.fAK.setIsRound(true);
        this.fAK.setDrawBorder(false);
        this.fAK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dp = com.baidu.tbadk.core.util.q.dp(currentPortrait);
            this.fAK.setUrl(dp);
            this.fAK.c(dp, 12, false);
        }
        this.eWF = (EditText) findViewById(r.g.post_title);
        this.eWF.setOnClickListener(this.fDL);
        this.eWF.setOnFocusChangeListener(this.eWD);
        if (this.eWm.getType() == 0) {
            if (this.eWm.getTitle() != null) {
                this.eWF.setText(this.eWm.getTitle());
                this.eWF.setSelection(this.eWm.getTitle().length());
            } else if (this.fCH) {
                this.eWF.setText(getResources().getString(r.j.vcode_feed_back_title));
            }
        } else if (this.eWm.getType() != 1) {
            this.eWm.getType();
        }
        this.eWF.addTextChangedListener(this.fDN);
        if (!this.eWm.getHaveDraft()) {
            bnn();
            this.fDz = true;
        }
    }

    private TextWatcher aRk() {
        at atVar = new at(this);
        if (this.fDp && this.fDq) {
            if (this.fDn != null) {
                this.fDk.removeTextChangedListener(this.fDn);
            }
            this.fDn = atVar;
        } else if (this.fDp) {
            if (this.fDo != null) {
                this.fDg.removeTextChangedListener(this.fDo);
            }
            this.fDo = atVar;
        }
        return atVar;
    }

    private long g(EditText editText) {
        if (editText == this.fDg) {
            return 233L;
        }
        if (editText != this.fDk) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long g = g(editText);
            long e = g - e(editText);
            String valueOf = String.valueOf(e);
            if (g == 20) {
                if (e < 0) {
                    if (e < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bbV() {
        this.eWJ = (EditText) findViewById(r.g.post_content);
        this.eWJ.setDrawingCacheEnabled(false);
        this.eWJ.setOnClickListener(this.fDL);
        if (this.eWm.getContent() != null && this.eWm.getContent().length() > 0) {
            SpannableString z = TbFaceManager.DW().z(getPageContext().getPageActivity(), this.eWm.getContent());
            this.eWJ.setText(z);
            this.eWJ.setSelection(z.length());
        } else if (this.eWm.getType() == 2) {
            if (this.fCQ) {
                if (this.fCR != null && this.fCR.length() > 0) {
                    this.eWJ.setText(getPageContext().getPageActivity().getString(r.j.reply_sub_floor, new Object[]{this.fCR}));
                    this.eWJ.setSelection(this.eWJ.getText().length());
                }
            } else if (this.eWm.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(r.j.reply_x_floor), Integer.valueOf(this.eWm.getFloorNum()));
                this.eWJ.setText(format);
                this.eWJ.setSelection(format.length());
            }
        }
        this.eWJ.setOnFocusChangeListener(this.eWD);
        this.eWJ.setOnTouchListener(new au(this));
        this.eWJ.addTextChangedListener(this.fDO);
        lF(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fDp) {
            bnw().setPadding(0, 0, 0, 0);
            bnw().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ar.l(bnw(), r.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dzm) && this.fCT == null) {
                com.baidu.adp.lib.g.c.eA().a(this.dzm, 19, new av(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnv() {
        int i = 5000;
        if (this.fCT != null) {
            i = 1000;
        }
        return bnw().getText() != null && bnw().getText().length() >= i;
    }

    private void fz(String str) {
        if (!StringUtils.isNull(str)) {
            if ("from_content".equals(this.fCD)) {
                this.fCD = "";
                bnw().requestFocus();
                if (bnw().getText() != null && bnw().getText().length() + str.length() > 5000) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                bnw().getText().insert(bnw().getSelectionStart(), str);
            } else if ("from_title".equals(this.fCD)) {
                this.fCD = "";
                bnx().requestFocus();
                if (bnx().getText() != null && bnx().getText().length() + str.length() > 31) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                bnx().getText().insert(bnx().getSelectionStart(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bnw().getText().getSpans(0, bnw().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fCS == null) {
                this.fCS = Toast.makeText(getPageContext().getPageActivity(), r.j.too_many_face, 0);
            }
            this.fCS.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xI = lVar.xI();
        if (name != null) {
            com.baidu.adp.lib.g.c.eA().a(name, 20, new aw(this, new SpannableStringBuilder(name), xI), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bnw() != null) {
            Bitmap jV = aVar.jV();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
            int width = jV.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            bnw().getText().insert(i, spannableStringBuilder);
            Editable text = bnw().getText();
            if (text != null) {
                this.fDI.clear();
                this.fDI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fDI);
                bnw().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bnw() {
        return this.fDp ? this.fDg : this.eWJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bnx() {
        return this.fDp ? this.fDk : this.eWF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bny() {
        if (bnw() != null) {
            bnw().onKeyDown(67, this.fCN);
            int selectionStart = bnw().getSelectionStart();
            Editable text = bnw().getText();
            if (text != null) {
                this.fDI.clear();
                this.fDI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fDI);
                bnw().setSelection(selectionStart);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.eWm != null) {
            str = this.eWm.getForumName();
        }
        if (getPageContext().getString(r.j.feedback_bar_name).equals(str)) {
            this.fCF = true;
        }
    }

    private void bnz() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bnA() {
        try {
            if (this.fCP != null) {
                this.fCP.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aEd.c(null);
        this.aEd.cZ(r.j.sending);
        this.aEd.aJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aEd.aJ(false);
    }

    private Boolean bnB() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.awf = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbU() {
        if (this.eWm != null) {
            String str = "";
            String str2 = "";
            if (bnx() != null) {
                str = bnx().getText().toString();
            }
            if (bnw() != null) {
                str2 = bnw().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.eWm.getType() == 0) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.eWn == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.eWm.setIsNoTitle(true);
                        } else {
                            this.eWm.setIsNoTitle(false);
                            lH(true);
                            return;
                        }
                    } else {
                        this.eWm.setIsNoTitle(false);
                        lH(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.eWm.setIsNoTitle(true);
                } else {
                    this.eWm.setIsNoTitle(false);
                    lH(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fDp) {
                    lH(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lH(true);
                }
            }
            if (this.eWm.getType() == 4) {
                lH(i(this.fDg) && h(this.fDk));
            } else if (this.eWm.getType() == 5) {
                lH(i(this.fDg));
            } else if (!TextUtils.isEmpty(str2)) {
                lH(true);
            } else if (this.avW != null) {
                lH(true);
            } else if (this.eWm.getVideoInfo() != null) {
                lH(true);
            } else if (!StringUtils.isNull(this.eWm.getGraffitiFileName())) {
                lH(true);
            } else {
                lH(false);
            }
        }
    }

    private void lH(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.ar.b(this.eWK, r.d.cp_link_tip_a, r.d.s_navbar_title_color);
            this.eWK.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.ar.c(this.eWK, r.d.cp_cont_d, 1);
        this.eWK.setEnabled(false);
    }

    private boolean h(EditText editText) {
        long e = e(editText);
        return e <= 20 && e > 0;
    }

    private boolean i(EditText editText) {
        long e = e(editText);
        if (e > 233) {
            return false;
        }
        return e > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.avZ = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        this.avZ.b(this.awp);
        registerListener(this.fDJ);
        this.esg = new ax(this);
        this.eWm = new WriteData();
        if (bundle != null) {
            this.eWm.setType(bundle.getInt("type", 0));
            this.eWm.setForumId(bundle.getString("forum_id"));
            this.eWm.setForumName(bundle.getString("forum_name"));
            this.eWm.setThreadId(bundle.getString("thread_id"));
            this.eWm.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.eWm.setFloorNum(bundle.getInt("floor_num", 0));
            this.fCF = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fCH = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fCQ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fCR = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.avX = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fCT = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.eWm.setIsAddition(this.fCT != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fCY = bundle.getInt("mem_type", 0);
            this.acW = bundle.getString("from");
            this.eWm.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.eWm.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fDF = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.eWm.setType(intent.getIntExtra("type", 0));
            this.eWm.setForumId(intent.getStringExtra("forum_id"));
            this.eWm.setForumName(intent.getStringExtra("forum_name"));
            this.eWm.setThreadId(intent.getStringExtra("thread_id"));
            this.eWm.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.eWm.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fCF = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fCH = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fCQ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fCR = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fCT = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.eWm.setIsAddition(this.fCT != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fCY = intent.getIntExtra("mem_type", 0);
            this.acW = intent.getStringExtra("from");
            this.eWm.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.eWm.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fDF = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.eWm.getType() == 4 ? 6 : 10);
        this.eWm.setWriteImagesInfo(this.writeImagesInfo);
        if (this.eWm.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.ac.c(this.eWm.getForumId(), this);
            }
        } else if (this.eWm.getType() == 1) {
            com.baidu.tieba.tbadkCore.ac.a(this.eWm.getThreadId(), this);
        } else if (this.eWm.getType() == 4) {
            com.baidu.tieba.tbadkCore.ac.c(String.valueOf(this.eWm.getForumId()) + "photolive", this);
        } else if (this.eWm.getType() == 5) {
            com.baidu.tieba.tbadkCore.ac.a(String.valueOf(this.eWm.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(r.j.write_no_prefix));
        }
        this.dzm = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.eWm != null && this.eWm.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.eWm.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fCG = true;
        }
        bno();
        try {
            this.fDr = bnI();
        } catch (Throwable th) {
            this.fDr = null;
        }
    }

    private void bnC() {
        this.fAK.setVisibility(8);
        this.fDB.setVisibility(0);
        this.fDC.setVisibility(0);
        this.eWF.setText(rs(this.mList.get(0).mTopicName));
        this.eWF.setMovementMethod(com.baidu.tieba.view.g.bki());
        this.fDD.setText(this.mList.get(0).mForumName);
        this.eWF.addTextChangedListener(new ay(this));
        this.fDE.setOnClickListener(new az(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gj = com.baidu.tbadk.plugins.a.gj(rs(hotTopicBussinessData.mTopicName));
            if (gj != null) {
                this.eWF.setText(gj);
            }
            this.fDD.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rs(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.eWm != null) {
                this.eWm.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bnx().getText().toString()) || this.fDz || ((this.fCF || this.fCG) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.eWm.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.t(this.mList)) {
                        SpannableString gj = com.baidu.tbadk.plugins.a.gj(this.eWm.getTitle());
                        if (gj != null) {
                            bnx().setText(gj);
                        }
                    } else {
                        bnx().setText(this.eWm.getTitle());
                    }
                    bnx().setSelection(this.eWm.getTitle().length());
                }
                if (this.eWm != null && !this.eWm.getHaveDraft()) {
                    bnn();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.eWm.setVideoInfo(videoInfo);
                    this.aun.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bnw().getText().toString()) || this.fCF || this.fCG) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.eWm.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DW().a(getPageContext().getPageActivity(), this.eWm.getContent(), this.fDK);
                    bnw().setText(a2);
                    bnw().setSelection(a2.length());
                    if (this.fDp) {
                        b(this.fDm, this.fDg);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.eWm.setWriteImagesInfo(this.writeImagesInfo);
                    bnH();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Dp();
                    }
                    lI(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bnD();
                }
                bbU();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.bZr != null) {
                    this.fDb = this.fCZ.bBw;
                    this.bZC = this.fCZ.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.bZr.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bv bvVar = this.bZr.get(i2);
                        if (categoryTo != bvVar.bBw) {
                            i = i2 + 1;
                        } else {
                            this.fDb = categoryTo;
                            this.bZC = bvVar.name;
                            this.eWm.setCategoryTo(this.fDb);
                            break;
                        }
                    }
                    if (this.fDc != null) {
                        this.fDc.setText(this.bZC);
                        this.fDc.b(this.bZr, this.fCZ, this.fDb);
                    }
                }
                this.eWm.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aun.b(new com.baidu.tbadk.editortools.a(42, 24, this.eWm.getGraffitiFileName()));
                this.aun.AP();
                return;
            }
            return;
        }
        bnD();
        bnn();
    }

    private void bnD() {
        if ((!this.fDp || this.fDe != null) && this.fDd != null) {
            this.fDe.b(this.writeImagesInfo);
            bnG();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.eWm.getType());
        bundle.putString("forum_id", this.eWm.getForumId());
        bundle.putString("forum_name", this.eWm.getForumName());
        bundle.putString("thread_id", this.eWm.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.eWm.getFloor());
        bundle.putInt("floor_num", this.eWm.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fCQ);
        if (this.fCF) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avX);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fCT);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fCY);
        bundle.putString("from", this.acW);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bnw().getEditableText().toString();
        if (editable != null) {
            bnw().setText(TbFaceManager.DW().a(getPageContext().getPageActivity(), editable, this.fDK));
            bnw().setSelection(bnw().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmG() {
        bbL();
        String editable = bnx().getText().toString();
        this.eWm.setContent(bnw().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eWn != 0 && this.eWm.getType() != 4) {
            this.eWm.setTitle(String.valueOf(this.eWL.getText().toString()) + editable);
        } else {
            this.eWm.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.eWm.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.eWm.getTitle());
        }
        if (this.fCF || this.fCG) {
            String string = getResources().getString(r.j.android_feedback);
            if (TextUtils.isEmpty(this.eWm.getTitle()) || !this.eWm.getTitle().startsWith(string)) {
                this.eWm.setTitle(string + this.eWm.getTitle());
            }
            String str = String.valueOf(getResources().getString(r.j.app_name)) + getResources().getString(r.j.tieba_client);
            if (TextUtils.isEmpty(this.eWm.getContent()) || !this.eWm.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.gm()) {
                    sb.append(com.baidu.adp.lib.util.i.gu());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.eWm.getContent());
                this.eWm.setContent(sb.toString());
            }
        }
        if (this.fDa >= 0) {
            this.eWm.setCategoryFrom(this.fDa);
        }
        if (this.fDb >= 0) {
            this.eWm.setCategoryTo(this.fDb);
        }
        this.eWm.setWriteImagesInfo(this.writeImagesInfo);
        this.eWm.setHasLocationData(this.avY != null && this.avY.bgL());
        this.avZ.la(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.t(this.mList) && this.fDA != null && this.fDA.mIsGlobalBlock == 0) {
            this.eWm.setForumId(String.valueOf(this.fDA.mForumId));
            this.eWm.setForumName(this.fDA.mForumName);
        }
        this.avZ.d(this.eWm);
        this.eWm.setVcode(null);
        if (this.avW != null) {
            if (this.avW.getId() != null) {
                this.avZ.bbN().setVoice(this.avW.getId());
                this.avZ.bbN().setVoiceDuringTime(this.avW.duration);
            } else {
                this.avZ.bbN().setVoice(null);
                this.avZ.bbN().setVoiceDuringTime(-1);
            }
        } else {
            this.avZ.bbN().setVoice(null);
            this.avZ.bbN().setVoiceDuringTime(-1);
        }
        if (!this.avZ.bhl()) {
            showToast(r.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(r.j.sending), this.esg);
            this.avZ.bhi();
        }
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.fCT != null) {
                i2 = this.fCT.getTotalCount();
                i = this.fCT.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(r.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aun != null && !this.aun.CE()) {
                    bnw().requestFocus();
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
                            bnw().getText().insert(bnw().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.eWm.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ac.b(this.eWm.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.eWm.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ac.c(this.eWm.getThreadId(), (WriteData) null);
                } else if (this.eWm.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ac.b(String.valueOf(this.eWm.getForumId()) + "photolive", (WriteData) null);
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
                                aSH();
                            } else {
                                C(intent);
                            }
                        } else if (intExtra == 1) {
                            w(intent);
                        } else {
                            B(intent);
                            com.baidu.adp.lib.h.h.eG().post(new ba(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fDp) {
                        d(intent);
                        bbU();
                        return;
                    }
                    E(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.eWm.setVideoInfo(videoInfo);
                        this.aun.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aun.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aun.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bbU();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.n(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fCE) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fCE = false;
                            }
                            sb2.append(stringExtra);
                            fz(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.t(this.mList) && !com.baidu.tbadk.core.util.x.t(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.fDA = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.fDA);
                }
            }
        } else if (i2 == 0) {
            if (this.aun != null && !this.aun.CE()) {
                this.eWJ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dk();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bnF();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.avX = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.aq.b(getPageContext(), this.avX);
                    return;
                case 12012:
                    bnF();
                    return;
                case 25004:
                    if ("from_title".equals(this.fCD)) {
                        bnx().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fCD)) {
                        bnw().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bnE() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bnF() {
        if (this.fDp) {
            this.fDe.b(this.writeImagesInfo);
            bnG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnG() {
        this.fDe.notifyDataSetChanged();
        this.fDd.invalidate();
        this.mHandler.postDelayed(new bb(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bbU();
    }

    private void B(Intent intent) {
        if (this.fDp) {
            E(intent);
            bnF();
        } else {
            F(intent);
        }
        bbU();
    }

    private void E(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bnF();
            lI(true);
        }
    }

    private void C(Intent intent) {
        if (this.writeImagesInfo != null) {
            c(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aSH() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void w(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eCc.parseJson(stringExtra);
            this.eCc.updateQuality();
            if (this.eCc.getChosedFiles() != null && this.eCc.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eCc.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eCc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bnx());
        HidenSoftKeyPad(this.mInputManager, bnw());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void F(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.avX = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.I(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.J(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.avX, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bnH();
            Dp();
        }
        lI(true);
    }

    private void d(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bnH();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Dp();
                }
            }
            lI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnH() {
        if (this.aun.eC(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void Dk() {
        new bc(this).execute(new Void[0]);
    }

    private void lI(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.byf == null) {
            this.byf = VoiceManager.instance();
        }
        return this.byf;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WD() {
        this.byf = getVoiceManager();
        this.byf.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rp(postWriteCallBackData.getErrorCode())) {
                AntiHelper.S(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(r.j.error_write);
                }
                showToast(errorString2);
            } else if (this.fCT == null) {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.awh = i;
        if (this.aun != null) {
            this.aun.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aun.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Dp() {
        if (!this.fDp && this.aun != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.aun.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.aun.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aun.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aun.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (this.aun != null) {
            this.aun.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void sw(int i) {
        if (i < this.fBG.size()) {
            for (int i2 = 0; i2 < this.fBG.size(); i2++) {
                this.fBG.get(i2).lu(false);
            }
            this.fBG.get(i).lu(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void qL(int i) {
        this.eWn = i;
        this.eWM.sc(i);
        sw(i);
        this.eWL.setText(this.mPrefixData.getPrefixs().get(i));
        bbU();
        com.baidu.adp.lib.h.j.a(this.eWM, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.eWO.setSelected(false);
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
        if (this.eWm != null) {
            if (this.eWm.getType() == 4) {
                return "a015";
            }
            if (this.eWm.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Df();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.Y(getApplicationContext())) {
                com.baidu.tbadk.core.util.aq.b(getPageContext(), this.avX);
            } else {
                showToast(r.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(r.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fDx && System.currentTimeMillis() - this.fDy < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fDx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fDu != null) {
            ru(str);
            this.fDu.dismiss();
        }
    }

    private void bv(Context context) {
        fDw = com.baidu.adp.lib.util.k.J(context);
    }

    private void ru(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fDx = true;
        bnH();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Dp();
        }
        lI(true);
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

    private File bnI() {
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

    private void bnJ() {
        if (this.fDr != null && this.eWm.getType() == 0) {
            bv(getActivity());
            this.fDt = getPageContext().getPageActivity().getLayoutInflater().inflate(r.h.rec_dialog, (ViewGroup) null);
            this.fDt.setOnClickListener(new be(this));
            this.fDs = (TbImageView) this.fDt.findViewById(r.g.rec_img_view);
            this.fDv = (LinearLayout) this.fDt.findViewById(r.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.tW().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fDr.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.tW().putString("write_rec_pic_path", this.fDr.getAbsolutePath());
                Bitmap c = c(this.fDr.getAbsolutePath(), getResources().getDimensionPixelSize(r.e.ds160));
                if (c != null) {
                    this.fDs.setImageBitmap(c);
                    this.fDs.setDrawBorder(true);
                    this.fDs.setBorderWidth(2);
                    this.fDs.setBorderColor(com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10264));
                    this.fDu = new Dialog(getActivity(), r.k.bubble_dialog);
                    this.fDu.setCanceledOnTouchOutside(true);
                    this.fDu.setOnDismissListener(new bf(this));
                    this.fDu.setContentView(this.fDt);
                    this.fDu.show();
                    Window window = this.fDu.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(r.e.ds28);
                    attributes.y = (fDw / 18) + getResources().getDimensionPixelSize(r.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(r.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(r.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(r.a.activity_open_from_bottom, r.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.fCE = false;
            this.fCD = "";
            if ("from_content".equals(str)) {
                this.fCD = "from_content";
            } else if ("from_title".equals(str)) {
                this.fCD = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                lG(false);
            }
        }
    }
}
