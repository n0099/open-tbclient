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
import android.view.ViewStub;
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
import com.baidu.tbadk.core.data.DealInfoData;
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
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.EcommCardView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, ad.a, b.a {
    private static int goV = 0;
    private String adE;
    private com.baidu.tbadk.editortools.l auI;
    private String awA;
    private com.baidu.tieba.tbadkCore.location.d awB;
    private com.baidu.tieba.tbadkCore.writeModel.b awC;
    private VoiceData.VoiceModel awz;
    private VoiceManager bRV;
    List<com.baidu.tieba.frs.bw> cug;
    private String cur;
    private DealInfoData dealInfoData;
    private TextView fsS;
    private com.baidu.tieba.write.b fsT;
    private ImageView fsU;
    private View fsV;
    private int fsu;
    private PostCategoryView goA;
    private HotTopicBussinessData goZ;
    private LinearLayout gog;
    private View goj;
    private View gok;
    private Toast goq;
    private AdditionData gor;
    private RelativeLayout gos;
    private TextView got;
    private TextView gou;
    private TextView gov;
    private ViewGroup gow;
    com.baidu.tieba.frs.bw gox;
    private int goy;
    private int goz;
    private View gpa;
    private View gpb;
    private TextView gpc;
    private TextView gpd;
    private com.baidu.tieba.view.c gpo;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String goa = "";
    private boolean gob = false;
    private WriteData fst = null;
    private boolean goc = false;
    private boolean goe = false;
    private boolean gof = false;
    private InputMethodManager mInputManager = null;
    private EditText fsM = null;
    private HeadImageView gmh = null;
    private View fsN = null;
    private LinearLayout fsP = null;
    private EditText fsQ = null;
    private p goh = null;
    private FeedBackTopListView goi = null;
    private ArrayList<com.baidu.tieba.write.a> gnd = new ArrayList<>();
    private String dUK = null;
    private final KeyEvent gol = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View ajQ = null;
    private TextView gom = null;
    private TextView fsR = null;
    private TextView daX = null;
    private DialogInterface.OnCancelListener eOK = null;
    private com.baidu.tbadk.core.dialog.a gon = null;
    private final Handler mHandler = new Handler();
    private boolean goo = false;
    private String gop = null;
    private RelativeLayout cZW = null;
    private String awI = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int awK = 0;
    private int bqW = 0;
    private WriteImagesInfo eYB = new WriteImagesInfo();
    private View mRootView = null;
    private GridView goB = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a goC = null;
    private ScrollView goD = null;
    private EditText goE = null;
    private View goF = null;
    private View goG = null;
    private View goH = null;
    private EditText goI = null;
    private TextView goJ = null;
    private TextView goK = null;
    private TextWatcher goL = null;
    private TextWatcher goM = null;
    private boolean goN = false;
    private boolean goO = false;
    private com.baidu.tbadk.core.view.a aEK = null;
    private bm goP = null;
    private File goQ = null;
    private TbImageView goR = null;
    private View goS = null;
    private Dialog goT = null;
    private LinearLayout goU = null;
    private boolean goW = false;
    private long goX = -1000;
    private boolean goY = false;
    private String gpe = "";
    private String gpf = "";
    private int gpg = 0;
    private SpannableStringBuilder gph = new SpannableStringBuilder();
    private final HttpMessageListener gpi = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a gpj = new ag(this);
    private final b.d awS = new as(this);
    private final d.a awQ = new bd(this);
    private final CustomMessageListener fEt = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener gpk = new bh(this);
    private boolean gpl = true;
    private final View.OnFocusChangeListener fsK = new bi(this);
    private TextWatcher gpm = new bj(this);
    private TextWatcher gpn = new bk(this);
    private final a.InterfaceC0078a eCp = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if ("from_add_photo_live_in_misson".equals(this.adE)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(r.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dx();
        } else if (this.awB.bmP()) {
            Dv();
        } else {
            this.awB.ln(false);
            b(1, true, null);
            this.awB.bmN();
        }
    }

    private void Dx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(r.j.location_app_permission_prompt).a(r.j.isopen, new x(this)).b(r.j.cancel, new y(this)).b(getPageContext());
        aVar.tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bwi() {
        int selectionEnd = bwx().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bwx().getText().getSpans(0, bwx().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bwx().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bwx().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwj() {
        if (this.auI != null) {
            this.auI.setBarLauncherEnabled(!this.gpl);
            this.auI.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.goN) {
            this.fsM.setVisibility(8);
            if (this.fst.getType() == 5) {
                this.goH.setVisibility(8);
            } else {
                this.goH.setVisibility(0);
            }
            b(this.goK, this.goE);
            b(this.goJ, this.goI);
            bih();
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
        bwt();
        this.awB = new com.baidu.tieba.tbadkCore.location.d(this);
        this.awB.a(this.awQ);
        registerListener(this.fEt);
        initEditor();
        bwK();
        if (this.goN) {
            this.goC.setEditorTools(this.auI);
        } else {
            this.fsM.requestFocus();
        }
    }

    private void initEditor() {
        this.auI = new com.baidu.tbadk.editortools.l(getActivity());
        this.auI.setBarMaxLauCount(5);
        this.auI.setMoreButtonAtEnd(true);
        this.auI.setBarLauncherType(1);
        this.auI.bD(true);
        this.auI.bC(true);
        this.auI.setMoreLauncherIcon(r.f.write_more);
        this.auI.setBackgroundColorId(r.d.cp_bg_line_d);
        switch (this.fst.getType()) {
            case 4:
            case 5:
                bwl();
                break;
            default:
                bwm();
                break;
        }
        this.auI.CP();
        if (this.gog != null) {
            this.gog.addView(this.auI);
        }
        bwn();
        this.auI.lz();
        com.baidu.tbadk.editortools.s ez = this.auI.ez(6);
        if (ez != null && !TextUtils.isEmpty(this.awI)) {
            ((View) ez).setOnClickListener(new z(this));
        }
        if (!this.goN) {
            this.auI.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.auI.Bc();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.um().getBoolean("xiaoying_has_click", false)) {
            this.auI.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.um().getBoolean("hot_topic_has_click", false)) {
            this.auI.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        DD();
        this.goP = new bm(this, this.auI);
    }

    private void DD() {
        String str;
        if (this.auI != null) {
            this.auI.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            boolean z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("graffiti_write_notice_show", true);
            com.baidu.tbadk.editortools.l lVar = this.auI;
            if (z) {
                str = "";
            } else {
                str = null;
            }
            lVar.b(new com.baidu.tbadk.editortools.a(2, 24, str));
        }
    }

    private void WS() {
        this.goF = this.mRootView.findViewById(r.g.photo_live_scroll);
        this.goH = this.goF.findViewById(r.g.live_post_title_container);
        this.goE = (EditText) this.goF.findViewById(r.g.live_post_content);
        this.goB = (GridView) this.goF.findViewById(r.g.photoLiveGridView);
        this.goI = (EditText) this.goF.findViewById(r.g.live_post_title);
        this.goJ = (TextView) this.goF.findViewById(r.g.titleOverPlusNumber);
        this.goK = (TextView) this.goF.findViewById(r.g.contentOverPlusNumber);
        this.goG = this.goF.findViewById(r.g.live_interval_view);
        this.goJ.setText(String.valueOf(20));
        this.goK.setText(String.valueOf(233));
        this.goF.setVisibility(0);
        this.goJ.setVisibility(0);
        this.goK.setVisibility(0);
        this.goI.setHint(r.j.tips_title_limit_new);
        this.goI.setOnFocusChangeListener(new aa(this));
        if (this.fst.getType() == 4) {
            this.goE.setHint(r.j.live_write_input_content_new);
        } else if (this.fst.getType() == 5) {
            this.goE.setHint(r.j.live_write_input_content_update);
        }
        this.goE.setOnFocusChangeListener(new ab(this));
        this.goE.requestFocus();
        this.goE.addTextChangedListener(aXA());
        this.goI.requestFocus();
        this.goI.addTextChangedListener(aXA());
        this.goI.setOnClickListener(this.gpk);
        this.goE.setOnClickListener(this.gpk);
        this.goC = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.goB);
        this.goC.tN(6);
        this.goB.setAdapter((ListAdapter) this.goC);
        View findViewById = this.goF.findViewById(r.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ac(this));
        bwk();
    }

    private void bwk() {
        if (this.fst.getType() == 0) {
            if (this.fst.getTitle() != null) {
                this.goI.setText(this.fst.getTitle());
                this.goI.setSelection(this.fst.getTitle().length());
            }
        } else if (this.fst.getType() != 1) {
            this.fst.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.goN) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bwF();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            DH();
            return;
        }
        if (this.auI.CR()) {
            this.auI.Bc();
        }
        String str = null;
        if (this.fst != null) {
            str = this.fst.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.goN) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bwl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.auI.y(arrayList);
        com.baidu.tbadk.editortools.aa eB = this.auI.eB(5);
        if (eB != null) {
            eB.avw = 2;
            eB.avu = r.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.avu = r.f.write_at;
        this.auI.b(aVar);
        this.auI.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bwm() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.avu = r.f.write_picture;
        this.auI.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.auI.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.auI.b(aVar);
        aVar.avu = r.f.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 != null && (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) != null) {
            aaVar5.avy = true;
            aaVar5.avu = r.f.write_graffiti;
            aaVar5.avw = 4;
            this.auI.b(aaVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 != null && (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) != null) {
            aaVar4.avw = 5;
            aaVar4.avu = r.f.write_privilege;
            this.auI.b(aaVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.avu = r.f.write_at;
        this.auI.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.avy = true;
            aaVar3.avw = 9;
            aaVar3.avu = 0;
            this.auI.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.avy = true;
            aaVar2.avw = 10;
            aaVar2.avu = 0;
            this.auI.b(aaVar2);
        }
        Boolean bwC = bwC();
        if (!this.goc && bwC != null && bwC.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bnn() && com.baidu.tieba.tbadkCore.u.a(this.fst.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.avw = 6;
            aaVar.avu = r.f.write_recorder;
            this.auI.b(aaVar);
        }
        if (this.gor == null) {
            this.auI.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.auI.y(arrayList);
        com.baidu.tbadk.editortools.aa eB = this.auI.eB(5);
        if (eB != null) {
            eB.avw = 1;
            eB.avu = r.f.write_emotion;
        }
    }

    private void bwn() {
        ad adVar = new ad(this);
        this.auI.a(16, adVar);
        this.auI.a(14, adVar);
        this.auI.a(24, adVar);
        this.auI.a(3, adVar);
        this.auI.a(10, adVar);
        this.auI.a(11, adVar);
        this.auI.a(12, adVar);
        this.auI.a(13, adVar);
        this.auI.a(15, adVar);
        this.auI.a(18, adVar);
        this.auI.a(25, adVar);
        this.auI.a(27, adVar);
        this.auI.a(29, adVar);
        this.auI.a(40, adVar);
        this.auI.a(43, adVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy() {
        if (this.awB.bmR()) {
            if (this.awB.bmP()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bmL().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.awB.bmN();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhY() {
        if (this.awC != null) {
            this.awC.cancelLoadData();
        }
        if (this.goh != null) {
            this.goh.cancelLoadData();
        }
        if (this.awB != null) {
            this.awB.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bhY();
        bwB();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        if (this.fst != null && this.fst.getType() == 2 && this.goo) {
            finish();
        } else if (this.fst == null) {
            finish();
        } else {
            this.fst.setTitle(bwy().getText().toString());
            this.fst.setContent(bwx().getText().toString());
            int type = this.fst.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.ad.b(this.fst.getForumId(), this.fst);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.fst.getThreadId(), this.fst);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.fst.getForumId()) + "photolive", this.fst);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.fst.getThreadId()) + "updatephotolive", this.fst);
            } else if (type == 7) {
                com.baidu.tieba.tbadkCore.ad.b(this.fst.getForumId(), this.fst);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fsT != null && this.fsT.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.fsT, getPageContext().getPageActivity());
                return true;
            } else if (this.auI.CR()) {
                this.auI.Bc();
                return true;
            } else {
                bhY();
                bvH();
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
        getLayoutMode().x(this.cZW);
        getLayoutMode().x(this.goU);
        if (this.goR != null && i == 1) {
            this.goR.setBorderColor(com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.c(this.fsR, r.d.cp_link_tip_a, 1);
        bwj();
        com.baidu.tbadk.core.util.at.l(this.goF, r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.fsN, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.goG, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(bwy(), r.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dUK)) {
            com.baidu.tbadk.core.util.at.l(bwx(), r.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_e);
        bwy().setTextColor(color);
        bwx().setTextColor(color);
        a(bwy(), color2);
        a(bwx(), color2);
        bih();
        this.auI.onChangeSkinType(i);
        if (this.goA != null) {
            this.goA.wM();
        }
        com.baidu.tbadk.core.util.at.j((View) this.daX, r.d.cp_cont_f);
        if (this.gow != null) {
            com.baidu.tbadk.i.a.a(getPageContext(), this.gow);
        }
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
        this.aEK = new com.baidu.tbadk.core.view.a(getPageContext());
        this.goN = this.fst.getType() == 4 || 5 == this.fst.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(r.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.ajQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajQ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ajQ != null && (this.ajQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ajQ.getLayoutParams();
            layoutParams2.width = -2;
            this.ajQ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.f.icon_nav_close_selector, r.f.icon_nav_close_selector);
        this.daX = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.at.j((View) this.daX, r.d.cp_cont_f);
        this.gom = (TextView) findViewById(r.g.btn_image_problem);
        this.fsR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fsR.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds10);
        this.fsR.setLayoutParams(layoutParams3);
        this.fsR.setOnFocusChangeListener(this.fsK);
        this.goD = (ScrollView) findViewById(r.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.goi = (FeedBackTopListView) findViewById(r.g.feedback_top_list);
        this.goj = findViewById(r.g.feedback_divider);
        this.cZW = (RelativeLayout) findViewById(r.g.parent);
        this.gog = (LinearLayout) findViewById(r.g.tool_view);
        this.gog.setContentDescription("..");
        this.fsN = findViewById(r.g.interval_view);
        this.gpa = findViewById(r.g.hot_topic_fourm_view);
        this.gpb = findViewById(r.g.hot_topic_divider);
        this.gpc = (TextView) findViewById(r.g.hot_topic_title_edt);
        this.gpd = (TextView) findViewById(r.g.change_one_tv);
        big();
        if (this.goN) {
            this.goD.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            WS();
        }
        if (this.fst.getType() == 7) {
            this.gow = (ViewGroup) ((ViewStub) findViewById(r.g.ecomm_card)).inflate();
            ((EcommCardView) this.gow.findViewById(r.g.ecomm_card_root)).setData(this.dealInfoData);
        }
        bii();
        if (this.goc || this.goe) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adf) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(r.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(r.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fsP = (LinearLayout) findViewById(r.g.post_content_container);
        this.fsP.setDrawingCacheEnabled(false);
        this.fsP.setOnClickListener(new ae(this));
        this.ajQ.setOnFocusChangeListener(this.fsK);
        this.ajQ.setOnClickListener(new af(this));
        this.gom.setOnClickListener(new ah(this));
        bwq();
        k(bwC());
        bwu();
        switch (this.fst.getType()) {
            case 0:
                if (this.goc || this.goe) {
                    if (this.gof) {
                        this.daX.setText(r.j.feedback_vcode);
                    } else {
                        this.daX.setText(r.j.feedback);
                    }
                } else {
                    this.daX.setText(r.j.post_new_thread);
                }
                this.fsM.setVisibility(0);
                this.fsQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.daX.setText(r.j.send_reply);
                this.fsQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fsM.setVisibility(8);
                break;
            case 4:
                this.daX.setText(r.j.publish_photo_live);
                this.fsQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.daX.setText(getPageContext().getResources().getString(r.j.update_photo_live_tip, Integer.valueOf(this.fst.getFloorNum() + 1)));
                this.goG.setVisibility(8);
                break;
            case 7:
                this.fsM.setVisibility(0);
                this.fsQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
        }
        bwv();
        bwA();
        bwj();
        bws();
        bif();
        if (com.baidu.tbadk.core.util.x.t(this.mList) || this.mList.get(0) == null) {
            this.fsM.getPaint().setFakeBoldText(true);
        } else {
            this.fsM.getPaint().setFakeBoldText(false);
            bwD();
        }
        if (this.fst.getType() == 4 && this.fsV != null && this.gok != null) {
            this.fsV.setVisibility(8);
            this.gok.setVisibility(8);
        }
        bih();
        ShowSoftKeyPad(this.mInputManager, this.fsM);
        bwr();
    }

    private void bwo() {
        if (this.fst != null && this.fst.getType() == 0 && !this.goc && !this.goe && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.ax.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bwy() != null) {
                bwy().setText(c);
                bwy().setSelection(c.length());
            }
        }
    }

    private void bwp() {
        this.cug = null;
        this.goy = -1;
        this.goz = -1;
        com.baidu.tieba.frs.by hY = com.baidu.tieba.frs.bx.adE().hY(1);
        if (hY != null) {
            this.cug = hY.bVs;
            this.goy = getIntent().getIntExtra("category_id", -1);
            if (this.cug != null && !this.cug.isEmpty() && this.goy >= 0) {
                this.gox = new com.baidu.tieba.frs.bw();
                this.gox.bVo = 0;
                this.gox.name = getPageContext().getResources().getString(r.j.category_auto);
                this.goz = this.gox.bVo;
                this.cur = this.gox.name;
                for (com.baidu.tieba.frs.bw bwVar : this.cug) {
                    if (bwVar.bVo == this.goy) {
                        this.goz = bwVar.bVo;
                        this.cur = bwVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bwq() {
        if (this.cug != null && !this.cug.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(r.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(r.g.interval_view_cate).setVisibility(0);
            this.goA = (PostCategoryView) linearLayout.findViewById(r.g.category_selected);
            this.goA.setText(this.cur);
            this.goA.b(this.cug, this.gox, this.goz);
            this.goA.setCategoryContainerClickCallback(new ai(this));
            linearLayout.setOnClickListener(new aj(this));
        }
    }

    private void bwr() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gpo = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new ak(this), new Date().getHours(), new Date().getMinutes(), false);
        this.gpo.setTitle(r.j.no_disturb_start_time);
        this.gpo.setButton(-1, getPageContext().getString(r.j.alert_yes_button), this.gpo);
        this.gpo.setButton(-2, getPageContext().getString(r.j.alert_no_button), this.gpo);
        return this.gpo;
    }

    private void bws() {
        this.gos = (RelativeLayout) findViewById(r.g.addition_container);
        this.got = (TextView) findViewById(r.g.addition_create_time);
        this.gou = (TextView) findViewById(r.g.addition_last_time);
        this.gov = (TextView) findViewById(r.g.addition_last_content);
        if (this.gor != null) {
            this.gos.setVisibility(0);
            this.got.setText(String.valueOf(getPageContext().getString(r.j.write_addition_create)) + com.baidu.tbadk.core.util.ax.s(this.gor.getCreateTime() * 1000));
            if (this.gor.getAlreadyCount() == 0) {
                this.gou.setVisibility(8);
            } else {
                this.gou.setText(String.valueOf(getPageContext().getString(r.j.write_addition_last)) + com.baidu.tbadk.core.util.ax.s(this.gor.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gor.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gov.setText(lastAdditionContent);
            } else {
                this.gov.setVisibility(8);
            }
            bwx().setHint(String.format(getPageContext().getString(r.j.write_addition_hint), Integer.valueOf(this.gor.getAlreadyCount()), Integer.valueOf(this.gor.getTotalCount())));
            this.daX.setText(r.j.write_addition_title);
            return;
        }
        this.gos.setVisibility(8);
    }

    private void bif() {
        this.fsV = findViewById(r.g.post_prefix_layout);
        this.fsS = (TextView) findViewById(r.g.post_prefix);
        this.gok = findViewById(r.g.prefix_divider);
        this.fsU = (ImageView) findViewById(r.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fsV.setVisibility(0);
            this.gok.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fsu = 1;
            this.fsV.setOnClickListener(new al(this));
            this.fsU = (ImageView) findViewById(r.g.prefix_icon);
            if (size > 1) {
                this.fsU.setVisibility(0);
                this.fsS.setOnClickListener(new am(this));
            }
            this.fsT = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fsT.a(this);
            this.fsT.setMaxHeight(com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds510));
            this.fsT.setOutsideTouchable(true);
            this.fsT.setFocusable(true);
            this.fsT.setOnDismissListener(this);
            this.fsT.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(r.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(this.fsS, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(this.fsU, r.f.icon_title_down);
            this.fsS.setTextColor(color);
            this.gnd.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.gnd.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fsT.addView(aVar);
            }
            this.fsT.tD(0);
            this.fsS.setText(prefixs.get(1));
            tX(1);
            return;
        }
        this.fsV.setVisibility(8);
    }

    private void bwt() {
        if (this.goc && this.fst != null) {
            this.goi.setVisibility(0);
            this.goj.setVisibility(0);
            this.goh = new p(this);
            this.goh.te(this.fst.getForumName());
            this.goh.setLoadDataCallBack(new an(this));
        }
    }

    protected void bwu() {
        this.fsR.setOnClickListener(new ao(this));
    }

    protected void bwv() {
        this.gon = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gon.cF(getPageContext().getString(r.j.is_save_draft)).at(false).a(getPageContext().getString(r.j.save), new ap(this)).b(getPageContext().getString(r.j.not_save), new ar(this));
        this.gon.b(getPageContext());
    }

    protected void big() {
        this.gmh = (HeadImageView) findViewById(r.g.user_head_portrait);
        this.gmh.setIsRound(true);
        this.gmh.setDrawBorder(false);
        this.gmh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String m11do = com.baidu.tbadk.core.util.q.m11do(currentPortrait);
            this.gmh.setUrl(m11do);
            this.gmh.c(m11do, 12, false);
        }
        this.fsM = (EditText) findViewById(r.g.post_title);
        this.fsM.setOnClickListener(this.gpk);
        this.fsM.setOnFocusChangeListener(this.fsK);
        if (this.fst.getType() == 0) {
            if (this.fst.getTitle() != null) {
                this.fsM.setText(this.fst.getTitle());
                this.fsM.setSelection(this.fst.getTitle().length());
            } else if (this.gof) {
                this.fsM.setText(getResources().getString(r.j.vcode_feed_back_title));
            }
        } else if (this.fst.getType() != 1) {
            this.fst.getType();
        }
        this.fsM.addTextChangedListener(this.gpm);
        if (!this.fst.getHaveDraft()) {
            bwo();
            this.goY = true;
        }
    }

    private TextWatcher aXA() {
        at atVar = new at(this);
        if (this.goN && this.goO) {
            if (this.goL != null) {
                this.goI.removeTextChangedListener(this.goL);
            }
            this.goL = atVar;
        } else if (this.goN) {
            if (this.goM != null) {
                this.goE.removeTextChangedListener(this.goM);
            }
            this.goM = atVar;
        }
        return atVar;
    }

    private long g(EditText editText) {
        if (editText == this.goE) {
            return 233L;
        }
        if (editText != this.goI) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bii() {
        this.fsQ = (EditText) findViewById(r.g.post_content);
        this.fsQ.setDrawingCacheEnabled(false);
        this.fsQ.setOnClickListener(this.gpk);
        if (this.fst.getContent() != null && this.fst.getContent().length() > 0) {
            SpannableString z = TbFaceManager.Eo().z(getPageContext().getPageActivity(), this.fst.getContent());
            this.fsQ.setText(z);
            this.fsQ.setSelection(z.length());
        } else if (this.fst.getType() == 2) {
            if (this.goo) {
                if (this.gop != null && this.gop.length() > 0) {
                    this.fsQ.setText(getPageContext().getPageActivity().getString(r.j.reply_sub_floor, new Object[]{this.gop}));
                    this.fsQ.setSelection(this.fsQ.getText().length());
                }
            } else if (this.fst.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(r.j.reply_x_floor), Integer.valueOf(this.fst.getFloorNum()));
                this.fsQ.setText(format);
                this.fsQ.setSelection(format.length());
            }
        }
        this.fsQ.setOnFocusChangeListener(this.fsK);
        this.fsQ.setOnTouchListener(new au(this));
        this.fsQ.addTextChangedListener(this.gpn);
        mq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.goN) {
            bwx().setPadding(0, 0, 0, 0);
            bwx().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.at.l(bwx(), r.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dUK) && this.gor == null) {
                com.baidu.adp.lib.g.c.eA().a(this.dUK, 19, new av(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bww() {
        int i = 5000;
        if (this.gor != null) {
            i = 1000;
        }
        return bwx().getText() != null && bwx().getText().length() >= i;
    }

    private void fD(String str) {
        if (!StringUtils.isNull(str)) {
            if ("from_content".equals(this.goa)) {
                this.goa = "";
                bwx().requestFocus();
                if (bwx().getText() != null && bwx().getText().length() + str.length() > 5000) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                bwx().getText().insert(bwx().getSelectionStart(), str);
            } else if ("from_title".equals(this.goa)) {
                this.goa = "";
                bwy().requestFocus();
                if (bwy().getText() != null && bwy().getText().length() + str.length() > 31) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                bwy().getText().insert(bwy().getSelectionStart(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bwx().getText().getSpans(0, bwx().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.goq == null) {
                this.goq = Toast.makeText(getPageContext().getPageActivity(), r.j.too_many_face, 0);
            }
            this.goq.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xU = lVar.xU();
        if (name != null) {
            com.baidu.adp.lib.g.c.eA().a(name, 20, new aw(this, new SpannableStringBuilder(name), xU), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bwx() != null) {
            Bitmap jV = aVar.jV();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
            int width = jV.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            bwx().getText().insert(i, spannableStringBuilder);
            Editable text = bwx().getText();
            if (text != null) {
                this.gph.clear();
                this.gph.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gph);
                bwx().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bwx() {
        return this.goN ? this.goE : this.fsQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bwy() {
        return this.goN ? this.goI : this.fsM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwz() {
        if (bwx() != null) {
            bwx().onKeyDown(67, this.gol);
            int selectionStart = bwx().getSelectionStart();
            Editable text = bwx().getText();
            if (text != null) {
                this.gph.clear();
                this.gph.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gph);
                bwx().setSelection(selectionStart);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.fst != null) {
            str = this.fst.getForumName();
        }
        if (getPageContext().getString(r.j.feedback_bar_name).equals(str)) {
            this.goc = true;
        }
    }

    private void bwA() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bwB() {
        try {
            if (this.gon != null) {
                this.gon.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aEK.c(null);
        this.aEK.cX(r.j.sending);
        this.aEK.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aEK.aI(false);
    }

    private Boolean bwC() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.awI = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bih() {
        if (this.fst != null) {
            String str = "";
            String str2 = "";
            if (bwy() != null) {
                str = bwy().getText().toString();
            }
            if (bwx() != null) {
                str2 = bwx().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.fst.getType() == 0 || this.fst.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fsu == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.fst.setIsNoTitle(true);
                        } else {
                            this.fst.setIsNoTitle(false);
                            ms(true);
                            return;
                        }
                    } else {
                        this.fst.setIsNoTitle(false);
                        ms(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.fst.setIsNoTitle(true);
                } else {
                    this.fst.setIsNoTitle(false);
                    ms(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.goN) {
                    ms(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ms(true);
                }
            }
            if (this.fst.getType() == 4) {
                ms(i(this.goE) && h(this.goI));
            } else if (this.fst.getType() == 5) {
                ms(i(this.goE));
            } else if (!TextUtils.isEmpty(str2)) {
                ms(true);
            } else if (this.awz != null) {
                ms(true);
            } else if (this.fst.getVideoInfo() != null) {
                ms(true);
            } else if (!StringUtils.isNull(this.fst.getGraffitiFileName())) {
                ms(true);
            } else {
                ms(false);
            }
        }
    }

    private void ms(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.at.b(this.fsR, r.d.cp_link_tip_a, r.d.s_navbar_title_color);
            this.fsR.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.at.c(this.fsR, r.d.cp_cont_d, 1);
        this.fsR.setEnabled(false);
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
        this.awC = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        this.awC.b(this.awS);
        registerListener(this.gpi);
        this.eOK = new ax(this);
        this.fst = new WriteData();
        if (bundle != null) {
            this.fst.setType(bundle.getInt("type", 0));
            this.fst.setForumId(bundle.getString("forum_id"));
            this.fst.setForumName(bundle.getString("forum_name"));
            this.fst.setThreadId(bundle.getString("thread_id"));
            this.fst.setFloor(bundle.getString("floor_id"));
            this.fst.setFloorNum(bundle.getInt("floor_num", 0));
            this.goc = bundle.getBoolean("feed_back", false);
            this.gof = bundle.getBoolean("vcode_feed_back", false);
            this.goo = bundle.getBoolean("reply_sub_pb", false);
            this.gop = bundle.getString("sub_user_name");
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.awA = bundle.getString("photo_name");
            this.gor = (AdditionData) bundle.getSerializable("addition_data");
            this.fst.setIsAddition(this.gor != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.bqW = bundle.getInt("mem_type", 0);
            this.adE = bundle.getString("from");
            this.fst.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.fst.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gpe = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.fst.setType(intent.getIntExtra("type", 0));
            this.fst.setForumId(intent.getStringExtra("forum_id"));
            this.fst.setForumName(intent.getStringExtra("forum_name"));
            this.fst.setThreadId(intent.getStringExtra("thread_id"));
            this.fst.setFloor(intent.getStringExtra("floor_id"));
            this.fst.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.goc = intent.getBooleanExtra("feed_back", false);
            this.gof = intent.getBooleanExtra("vcode_feed_back", false);
            this.goo = intent.getBooleanExtra("reply_sub_pb", false);
            this.gop = intent.getStringExtra("sub_user_name");
            this.gor = (AdditionData) intent.getSerializableExtra("addition_data");
            this.fst.setIsAddition(this.gor != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.bqW = intent.getIntExtra("mem_type", 0);
            this.adE = intent.getStringExtra("from");
            this.fst.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.fst.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gpe = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.fst.getType() == 4 ? 6 : 10);
        this.fst.setWriteImagesInfo(this.writeImagesInfo);
        if (this.fst.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.ad.c(this.fst.getForumId(), this);
            }
        } else if (this.fst.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.fst.getThreadId(), this);
        } else if (this.fst.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.fst.getForumId()) + "photolive", this);
        } else if (this.fst.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.fst.getThreadId()) + "updatephotolive", this);
        } else if (this.fst.getType() == 7) {
            com.baidu.tieba.tbadkCore.ad.c(this.fst.getForumId(), this);
            this.dealInfoData = (DealInfoData) getIntent().getSerializableExtra("deal_info");
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(r.j.write_no_prefix));
        }
        this.dUK = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.fst != null && this.fst.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.fst.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.goe = true;
        }
        bwp();
        try {
            this.goQ = bwJ();
        } catch (Throwable th) {
            this.goQ = null;
        }
    }

    private void bwD() {
        this.gmh.setVisibility(8);
        this.gpa.setVisibility(0);
        this.gpb.setVisibility(0);
        this.fsM.setText(tf(this.mList.get(0).mTopicName));
        this.fsM.setMovementMethod(com.baidu.tieba.view.g.bti());
        this.gpc.setText(this.mList.get(0).mForumName);
        this.fsM.addTextChangedListener(new ay(this));
        this.gpd.setOnClickListener(new az(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString go = com.baidu.tbadk.plugins.a.go(tf(hotTopicBussinessData.mTopicName));
            if (go != null) {
                this.fsM.setText(go);
            }
            this.gpc.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tf(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.fst != null) {
                this.fst.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bwy().getText().toString()) || this.goY || ((this.goc || this.goe) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.fst.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.t(this.mList)) {
                        SpannableString go = com.baidu.tbadk.plugins.a.go(this.fst.getTitle());
                        if (go != null) {
                            bwy().setText(go);
                        }
                    } else {
                        bwy().setText(this.fst.getTitle());
                    }
                    bwy().setSelection(this.fst.getTitle().length());
                }
                if (this.fst != null && !this.fst.getHaveDraft()) {
                    bwo();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.fst.setVideoInfo(videoInfo);
                    this.auI.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bwx().getText().toString()) || this.goc || this.goe) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.fst.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Eo().a(getPageContext().getPageActivity(), this.fst.getContent(), this.gpj);
                    bwx().setText(a2);
                    bwx().setSelection(a2.length());
                    if (this.goN) {
                        b(this.goK, this.goE);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.fst.setWriteImagesInfo(this.writeImagesInfo);
                    bwI();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DH();
                    }
                    mt(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bwE();
                }
                bih();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.cug != null) {
                    this.goz = this.gox.bVo;
                    this.cur = this.gox.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.cug.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bw bwVar = this.cug.get(i2);
                        if (categoryTo != bwVar.bVo) {
                            i = i2 + 1;
                        } else {
                            this.goz = categoryTo;
                            this.cur = bwVar.name;
                            this.fst.setCategoryTo(this.goz);
                            break;
                        }
                    }
                    if (this.goA != null) {
                        this.goA.setText(this.cur);
                        this.goA.b(this.cug, this.gox, this.goz);
                    }
                }
                this.fst.setGraffitiFileName(writeData.getGraffitiFileName());
                this.auI.b(new com.baidu.tbadk.editortools.a(42, 24, this.fst.getGraffitiFileName()));
                this.auI.Bc();
                return;
            }
            return;
        }
        bwE();
        bwo();
    }

    private void bwE() {
        if ((!this.goN || this.goC != null) && this.goB != null) {
            this.goC.f(this.writeImagesInfo);
            bwH();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.fst.getType());
        bundle.putString("forum_id", this.fst.getForumId());
        bundle.putString("forum_name", this.fst.getForumName());
        bundle.putString("thread_id", this.fst.getThreadId());
        bundle.putString("floor_id", this.fst.getFloor());
        bundle.putInt("floor_num", this.fst.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.goo);
        if (this.goc) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putString("photo_name", this.awA);
        bundle.putSerializable("addition_data", this.gor);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.bqW);
        bundle.putString("from", this.adE);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bwx().getEditableText().toString();
        if (editable != null) {
            bwx().setText(TbFaceManager.Eo().a(getPageContext().getPageActivity(), editable, this.gpj));
            bwx().setSelection(bwx().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        bhY();
        String editable = bwy().getText().toString();
        this.fst.setContent(bwx().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fsu != 0 && this.fst.getType() != 4) {
            this.fst.setTitle(String.valueOf(this.fsS.getText().toString()) + editable);
        } else {
            this.fst.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.fst.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.fst.getTitle());
        }
        if (this.goc || this.goe) {
            String string = getResources().getString(r.j.android_feedback);
            if (TextUtils.isEmpty(this.fst.getTitle()) || !this.fst.getTitle().startsWith(string)) {
                this.fst.setTitle(string + this.fst.getTitle());
            }
            String str = String.valueOf(getResources().getString(r.j.app_name)) + getResources().getString(r.j.tieba_client);
            if (TextUtils.isEmpty(this.fst.getContent()) || !this.fst.getContent().startsWith(str)) {
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
                sb.append(this.fst.getContent());
                this.fst.setContent(sb.toString());
            }
        }
        if (this.goy >= 0) {
            this.fst.setCategoryFrom(this.goy);
        }
        if (this.goz >= 0) {
            this.fst.setCategoryTo(this.goz);
        }
        if (this.fst.getType() == 7 && this.dealInfoData != null) {
            this.fst.productId = this.dealInfoData.productId;
        }
        this.fst.setWriteImagesInfo(this.writeImagesInfo);
        this.fst.setHasLocationData(this.awB != null && this.awB.bmR());
        this.awC.lp(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.t(this.mList) && this.goZ != null && this.goZ.mIsGlobalBlock == 0) {
            this.fst.setForumId(String.valueOf(this.goZ.mForumId));
            this.fst.setForumName(this.goZ.mForumName);
        }
        this.awC.d(this.fst);
        this.fst.setVcode(null);
        if (this.awz != null) {
            if (this.awz.getId() != null) {
                this.awC.bia().setVoice(this.awz.getId());
                this.awC.bia().setVoiceDuringTime(this.awz.duration);
            } else {
                this.awC.bia().setVoice(null);
                this.awC.bia().setVoiceDuringTime(-1);
            }
        } else {
            this.awC.bia().setVoice(null);
            this.awC.bia().setVoiceDuringTime(-1);
        }
        if (!this.awC.bnr()) {
            showToast(r.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(r.j.sending), this.eOK);
            this.awC.bno();
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
            if (this.gor != null) {
                i2 = this.gor.getTotalCount();
                i = this.gor.getAlreadyCount() + 1;
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
                if (this.auI != null && !this.auI.CR()) {
                    bwx().requestFocus();
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
                            bwx().getText().insert(bwx().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.fst.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.fst.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.fst.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.fst.getThreadId(), (WriteData) null);
                } else if (this.fst.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.fst.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                } else if (this.fst.getType() == 7) {
                    com.baidu.tieba.tbadkCore.ad.b(this.fst.getForumId(), (WriteData) null);
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
                                aYW();
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
                    if (!this.goN) {
                        d(intent);
                        bih();
                        return;
                    }
                    E(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.fst.setVideoInfo(videoInfo);
                        this.auI.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.auI.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.auI.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bih();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.n(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gob) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gob = false;
                            }
                            sb2.append(stringExtra);
                            fD(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.t(this.mList) && !com.baidu.tbadk.core.util.x.t(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.goZ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.goZ);
                }
            }
        } else if (i2 == 0) {
            if (this.auI != null && !this.auI.CR()) {
                this.fsQ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DB();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bwG();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.awA = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.as.b(getPageContext(), this.awA);
                    return;
                case 12012:
                    bwG();
                    return;
                case 25004:
                    if ("from_title".equals(this.goa)) {
                        bwy().requestFocus();
                        return;
                    } else if ("from_content".equals(this.goa)) {
                        bwx().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bwF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bwG() {
        if (this.goN) {
            this.goC.f(this.writeImagesInfo);
            bwH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwH() {
        this.goC.notifyDataSetChanged();
        this.goB.invalidate();
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
        bih();
    }

    private void B(Intent intent) {
        if (this.goN) {
            E(intent);
            bwG();
        } else {
            F(intent);
        }
        bih();
    }

    private void E(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bwG();
            mt(true);
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

    private void aYW() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void w(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eYB.parseJson(stringExtra);
            this.eYB.updateQuality();
            if (this.eYB.getChosedFiles() != null && this.eYB.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eYB.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eYB.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bwy());
        HidenSoftKeyPad(this.mInputManager, bwx());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void F(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.awA = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.awA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.awA, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bwI();
            DH();
        }
        mt(true);
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
                bwI();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DH();
                }
            }
            mt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwI() {
        if (this.auI.eB(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void DB() {
        new bc(this).execute(new Void[0]);
    }

    private void mt(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bRV == null) {
            this.bRV = VoiceManager.instance();
        }
        return this.bRV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void acp() {
        this.bRV = getVoiceManager();
        this.bRV.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.sm(postWriteCallBackData.getErrorCode())) {
                AntiHelper.S(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(r.j.error_write);
                }
                showToast(errorString2);
            } else if (this.gor == null) {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.awK = i;
        if (this.auI != null) {
            this.auI.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.auI.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DH() {
        if (!this.goN && this.auI != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.auI.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.auI.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.auI.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.auI.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (this.auI != null) {
            this.auI.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tX(int i) {
        if (i < this.gnd.size()) {
            for (int i2 = 0; i2 < this.gnd.size(); i2++) {
                this.gnd.get(i2).mg(false);
            }
            this.gnd.get(i).mg(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rK(int i) {
        this.fsu = i;
        this.fsT.tD(i);
        tX(i);
        this.fsS.setText(this.mPrefixData.getPrefixs().get(i));
        bih();
        com.baidu.adp.lib.h.j.a(this.fsT, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fsV.setSelected(false);
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
        if (this.fst != null) {
            if (this.fst.getType() == 4) {
                return "a015";
            }
            if (this.fst.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dw();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.aa(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.b(getPageContext(), this.awA);
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
        if (this.goP != null) {
            this.goP.onKeyboardVisibilityChanged(z);
        }
        if (this.goW && System.currentTimeMillis() - this.goX < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.goW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.goT != null) {
            th(str);
            this.goT.dismiss();
        }
    }

    private void bx(Context context) {
        goV = com.baidu.adp.lib.util.k.L(context);
    }

    private void th(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.goW = true;
        bwI();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DH();
        }
        mt(true);
    }

    private static Bitmap d(String str, float f) {
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

    private File bwJ() {
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

    private void bwK() {
        if (this.goQ != null && this.fst.getType() == 0) {
            bx(getActivity());
            this.goS = getPageContext().getPageActivity().getLayoutInflater().inflate(r.h.rec_dialog, (ViewGroup) null);
            this.goS.setOnClickListener(new be(this));
            this.goR = (TbImageView) this.goS.findViewById(r.g.rec_img_view);
            this.goU = (LinearLayout) this.goS.findViewById(r.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.um().getString("write_rec_pic_path", "").equalsIgnoreCase(this.goQ.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.um().putString("write_rec_pic_path", this.goQ.getAbsolutePath());
                Bitmap d = d(this.goQ.getAbsolutePath(), getResources().getDimensionPixelSize(r.e.ds160));
                if (d != null) {
                    this.goR.setImageBitmap(d);
                    this.goR.setDrawBorder(true);
                    this.goR.setBorderWidth(2);
                    this.goR.setBorderColor(com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10264));
                    this.goT = new Dialog(getActivity(), r.k.bubble_dialog);
                    this.goT.setCanceledOnTouchOutside(true);
                    this.goT.setOnDismissListener(new bf(this));
                    this.goT.setContentView(this.goS);
                    this.goT.show();
                    Window window = this.goT.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(r.e.ds28);
                    attributes.y = (goV / 18) + getResources().getDimensionPixelSize(r.e.ds12);
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
            this.gob = false;
            this.goa = "";
            if ("from_content".equals(str)) {
                this.goa = "from_content";
            } else if ("from_title".equals(str)) {
                this.goa = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                mr(false);
            }
        }
    }
}
