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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.DealInfoData;
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
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ae;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, ae.a, b.a {
    private static int ghq = 0;
    private static int ghr = 0;
    private String adg;
    private com.baidu.tbadk.editortools.l atO;
    private VoiceData.VoiceModel avF;
    private String avH;
    private com.baidu.tieba.tbadkCore.location.d avI;
    private com.baidu.tieba.tbadkCore.writeModel.b avJ;
    private VoiceManager bQb;
    List<cy> cpb;
    private String cpm;
    private DealInfoData dealInfoData;
    private TextView flJ;
    private com.baidu.tieba.write.b flK;
    private ImageView flL;
    private View flM;
    private int fll;
    private LinearLayout ggB;
    private View ggE;
    private View ggF;
    private Toast ggL;
    private AdditionData ggM;
    private RelativeLayout ggN;
    private TextView ggO;
    private TextView ggP;
    private TextView ggQ;
    private ViewGroup ggR;
    cy ggS;
    private int ggT;
    private int ggU;
    private PostCategoryView ggV;
    private com.baidu.tieba.view.c ghC;
    private GestureDetector mGestureDetector;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String ggw = "";
    private boolean ggx = false;
    private WriteData flk = null;
    private boolean ggy = false;
    private boolean ggz = false;
    private boolean ggA = false;
    private InputMethodManager mInputManager = null;
    private EditText flD = null;
    private HeadImageView geD = null;
    private View flE = null;
    private LinearLayout flG = null;
    private EditText flH = null;
    private p ggC = null;
    private FeedBackTopListView ggD = null;
    private ArrayList<com.baidu.tieba.write.a> gfz = new ArrayList<>();
    private String dPf = null;
    private final KeyEvent ggG = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aiY = null;
    private TextView ggH = null;
    private TextView flI = null;
    private TextView cVm = null;
    private DialogInterface.OnCancelListener eIl = null;
    private com.baidu.tbadk.core.dialog.a ggI = null;
    private final Handler mHandler = new Handler();
    private boolean ggJ = false;
    private String ggK = null;
    private RelativeLayout cUo = null;
    private String avP = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int avR = 0;
    private int bob = 0;
    private WriteImagesInfo eSe = new WriteImagesInfo();
    private View mRootView = null;
    private GridView ggW = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a ggX = null;
    private ScrollView ggY = null;
    private EditText ggZ = null;
    private View gha = null;
    private View ghb = null;
    private View ghc = null;
    private EditText ghd = null;
    private TextView ghe = null;
    private TextView ghf = null;
    private TextWatcher ghg = null;
    private TextWatcher ghh = null;
    private boolean ghi = false;
    private boolean ghj = false;
    private com.baidu.tbadk.core.view.a aDU = null;
    private bl ghk = null;
    private File ghl = null;
    private TbImageView ghm = null;
    private View ghn = null;
    private Dialog gho = null;
    private LinearLayout ghp = null;
    private boolean ghs = false;
    private long ght = -1000;
    private boolean ghu = false;
    private final HttpMessageListener ghv = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a ghw = new ag(this);
    private final b.d avZ = new as(this);
    private final d.a avX = new bd(this);
    private final CustomMessageListener fxo = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener ghx = new bg(this);
    private boolean ghy = true;
    private final View.OnFocusChangeListener flB = new bh(this);
    private final CustomMessageListener ghz = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private TextWatcher ghA = new bj(this);
    private TextWatcher ghB = new w(this);
    private final a.InterfaceC0077a ewf = new x(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if ("from_add_photo_live_in_misson".equals(this.adg)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Do() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(r.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dp();
        } else if (this.avI.bkz()) {
            Dn();
        } else {
            this.avI.kO(false);
            b(1, true, null);
            this.avI.bkx();
        }
    }

    private void Dp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(r.j.location_app_permission_prompt).a(r.j.isopen, new y(this)).b(r.j.cancel, new z(this)).b(getPageContext());
        aVar.tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int btN() {
        int selectionEnd = buf().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) buf().getText().getSpans(0, buf().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = buf().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = buf().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        if (this.atO != null) {
            this.atO.setBarLauncherEnabled(!this.ghy);
            this.atO.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.ghi) {
            this.flD.setVisibility(8);
            if (this.flk.getType() == 5) {
                this.ghc.setVisibility(8);
            } else {
                this.ghc.setVisibility(0);
            }
            b(this.ghf, this.ggZ);
            b(this.ghe, this.ghd);
            bfL();
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
        btZ();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.ghz.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.ghz);
        this.avI = new com.baidu.tieba.tbadkCore.location.d(this);
        this.avI.a(this.avX);
        registerListener(this.fxo);
        initEditor();
        bur();
        if (this.ghi) {
            this.ggX.setEditorTools(this.atO);
        } else {
            this.flD.requestFocus();
        }
    }

    private void initEditor() {
        this.atO = new com.baidu.tbadk.editortools.l(getActivity());
        this.atO.setBarMaxLauCount(5);
        this.atO.setMoreButtonAtEnd(true);
        this.atO.setBarLauncherType(1);
        this.atO.bz(true);
        this.atO.by(true);
        this.atO.setMoreLauncherIcon(r.f.write_more);
        this.atO.setBackgroundColorId(r.d.cp_bg_line_d);
        switch (this.flk.getType()) {
            case 4:
            case 5:
                btQ();
                break;
            default:
                btR();
                break;
        }
        this.atO.CH();
        if (this.ggB != null) {
            this.ggB.addView(this.atO);
        }
        btS();
        this.atO.lw();
        com.baidu.tbadk.editortools.s ew = this.atO.ew(6);
        if (ew != null && !TextUtils.isEmpty(this.avP)) {
            ((View) ew).setOnClickListener(new aa(this));
        }
        if (!this.ghi) {
            this.atO.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.atO.AV();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("xiaoying_has_click", false)) {
            this.atO.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("hot_topic_has_click", false)) {
            this.atO.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        Dv();
        this.ghk = new bl(this, this.atO);
    }

    private void Dv() {
        if (this.atO != null) {
            this.atO.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.atO.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void VQ() {
        this.gha = this.mRootView.findViewById(r.g.photo_live_scroll);
        this.ghc = this.gha.findViewById(r.g.live_post_title_container);
        this.ggZ = (EditText) this.gha.findViewById(r.g.live_post_content);
        this.ggW = (GridView) this.gha.findViewById(r.g.photoLiveGridView);
        this.ghd = (EditText) this.gha.findViewById(r.g.live_post_title);
        this.ghe = (TextView) this.gha.findViewById(r.g.titleOverPlusNumber);
        this.ghf = (TextView) this.gha.findViewById(r.g.contentOverPlusNumber);
        this.ghb = this.gha.findViewById(r.g.live_interval_view);
        this.ghe.setText(String.valueOf(20));
        this.ghf.setText(String.valueOf(233));
        this.gha.setVisibility(0);
        this.ghe.setVisibility(0);
        this.ghf.setVisibility(0);
        this.ghd.setHint(r.j.tips_title_limit_new);
        this.ghd.setOnFocusChangeListener(new ab(this));
        if (this.flk.getType() == 4) {
            this.ggZ.setHint(r.j.live_write_input_content_new);
        } else if (this.flk.getType() == 5) {
            this.ggZ.setHint(r.j.live_write_input_content_update);
        }
        this.ggZ.setOnFocusChangeListener(new ac(this));
        this.ggZ.requestFocus();
        this.ggZ.addTextChangedListener(aVt());
        this.ghd.requestFocus();
        this.ghd.addTextChangedListener(aVt());
        this.ghd.setOnClickListener(this.ghx);
        this.ggZ.setOnClickListener(this.ghx);
        this.ggX = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.ggW);
        this.ggX.tr(6);
        this.ggW.setAdapter((ListAdapter) this.ggX);
        View findViewById = this.gha.findViewById(r.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ad(this));
        btP();
    }

    private void btP() {
        if (this.flk.getType() == 0) {
            if (this.flk.getTitle() != null) {
                this.ghd.setText(this.flk.getTitle());
                this.ghd.setSelection(this.flk.getTitle().length());
            }
        } else if (this.flk.getType() != 1) {
            this.flk.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.ghi) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bum();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            DA();
            return;
        }
        if (this.atO.CJ()) {
            this.atO.AV();
        }
        String str = null;
        if (this.flk != null) {
            str = this.flk.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.ghi) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void btQ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.atO.y(arrayList);
        com.baidu.tbadk.editortools.aa ey = this.atO.ey(5);
        if (ey != null) {
            ey.auC = 2;
            ey.auA = r.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.auA = r.f.write_at;
        this.atO.b(aVar);
        this.atO.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void btR() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.auA = r.f.write_picture;
        this.atO.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.atO.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.atO.b(aVar);
        aVar.auA = r.f.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 != null && (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) != null) {
            aaVar5.auE = true;
            aaVar5.auA = r.f.write_graffiti;
            aaVar5.auC = 4;
            this.atO.b(aaVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 != null && (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) != null) {
            aaVar4.auC = 5;
            aaVar4.auA = r.f.write_privilege;
            this.atO.b(aaVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.auA = r.f.write_at;
        this.atO.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.auE = true;
            aaVar3.auC = 9;
            aaVar3.auA = 0;
            this.atO.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.auE = true;
            aaVar2.auC = 10;
            aaVar2.auA = 0;
            this.atO.b(aaVar2);
        }
        Boolean buk = buk();
        if (!this.ggy && buk != null && buk.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bkX() && com.baidu.tieba.tbadkCore.u.a(this.flk.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.auC = 6;
            aaVar.auA = r.f.write_recorder;
            this.atO.b(aaVar);
        }
        if (this.flk != null && this.flk.getType() == 0 && !this.ggy && !this.ggz) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.ggM == null) {
            this.atO.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.atO.y(arrayList);
        com.baidu.tbadk.editortools.aa ey = this.atO.ey(5);
        if (ey != null) {
            ey.auC = 1;
            ey.auA = r.f.write_emotion;
        }
        com.baidu.tbadk.editortools.aa ey2 = this.atO.ey(13);
        if (ey2 != null) {
            ey2.auC = 8;
        }
    }

    private void btS() {
        ae aeVar = new ae(this);
        this.atO.a(16, aeVar);
        this.atO.a(21, aeVar);
        this.atO.a(14, aeVar);
        this.atO.a(24, aeVar);
        this.atO.a(3, aeVar);
        this.atO.a(10, aeVar);
        this.atO.a(11, aeVar);
        this.atO.a(12, aeVar);
        this.atO.a(13, aeVar);
        this.atO.a(22, aeVar);
        this.atO.a(23, aeVar);
        this.atO.a(15, aeVar);
        this.atO.a(18, aeVar);
        this.atO.a(25, aeVar);
        this.atO.a(27, aeVar);
        this.atO.a(29, aeVar);
        this.atO.a(40, aeVar);
        this.atO.a(43, aeVar);
    }

    public void amo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        if (this.avI.bkB()) {
            if (this.avI.bkz()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bkv().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.avI.bkx();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bfC() {
        if (this.avJ != null) {
            this.avJ.cancelLoadData();
        }
        if (this.ggC != null) {
            this.ggC.cancelLoadData();
        }
        if (this.avI != null) {
            this.avI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bfC();
        buj();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        if (this.flk != null && this.flk.getType() == 2 && this.ggJ) {
            finish();
        } else if (this.flk == null) {
            finish();
        } else {
            this.flk.setTitle(bug().getText().toString());
            this.flk.setContent(buf().getText().toString());
            int type = this.flk.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.ae.b(this.flk.getForumId(), this.flk);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ae.c(this.flk.getThreadId(), this.flk);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.flk.getForumId()) + "photolive", this.flk);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.flk.getThreadId()) + "updatephotolive", this.flk);
            } else if (type == 7) {
                com.baidu.tieba.tbadkCore.ae.b(this.flk.getForumId(), this.flk);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.flK != null && this.flK.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.flK, getPageContext().getPageActivity());
                return true;
            } else if (this.atO.CJ()) {
                this.atO.AV();
                return true;
            } else {
                bfC();
                btm();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.cUo);
        getLayoutMode().x(this.ghp);
        if (this.ghm != null && i == 1) {
            this.ghm.setBorderColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.av.c(this.flI, r.d.cp_link_tip_a, 1);
        btO();
        com.baidu.tbadk.core.util.av.l(this.gha, r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.flE, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.ghb, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(bug(), r.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dPf)) {
            com.baidu.tbadk.core.util.av.l(buf(), r.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_e);
        bug().setTextColor(color);
        buf().setTextColor(color);
        a(bug(), color2);
        a(buf(), color2);
        bfL();
        this.atO.onChangeSkinType(i);
        if (this.ggV != null) {
            this.ggV.wH();
        }
        com.baidu.tbadk.core.util.av.j((View) this.cVm, r.d.cp_cont_f);
        if (this.ggR != null) {
            com.baidu.tbadk.i.a.a(getPageContext(), this.ggR);
        }
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    private boolean btT() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ggx = false;
            this.ggw = "";
            if ("from_content".equals(str)) {
                this.ggw = "from_content";
            } else if ("from_title".equals(str)) {
                this.ggw = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i))) && btT()) {
                bud();
            }
        }
    }

    private void initUI() {
        this.aDU = new com.baidu.tbadk.core.view.a(getPageContext());
        this.ghi = this.flk.getType() == 4 || 5 == this.flk.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(r.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.aiY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aiY != null && (this.aiY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aiY.getLayoutParams();
            layoutParams2.width = -2;
            this.aiY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.f.icon_nav_close_selector, r.f.icon_nav_close_selector);
        this.cVm = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.av.j((View) this.cVm, r.d.cp_cont_f);
        this.ggH = (TextView) findViewById(r.g.btn_image_problem);
        this.flI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.flI.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds10);
        this.flI.setLayoutParams(layoutParams3);
        this.flI.setOnFocusChangeListener(this.flB);
        this.ggY = (ScrollView) findViewById(r.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ggD = (FeedBackTopListView) findViewById(r.g.feedback_top_list);
        this.ggE = findViewById(r.g.feedback_divider);
        this.cUo = (RelativeLayout) findViewById(r.g.parent);
        this.ggB = (LinearLayout) findViewById(r.g.tool_view);
        this.ggB.setContentDescription("..");
        this.flE = findViewById(r.g.interval_view);
        bfK();
        if (this.ghi) {
            this.ggY.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            VQ();
        }
        if (this.flk.getType() == 7) {
            this.ggR = (ViewGroup) ((ViewStub) findViewById(r.g.ecomm_card)).inflate();
            ((EcommCardView) this.ggR.findViewById(r.g.ecomm_card_root)).setData(this.dealInfoData);
        }
        bfM();
        if (this.ggy || this.ggz) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(r.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(r.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.flG = (LinearLayout) findViewById(r.g.post_content_container);
        this.flG.setDrawingCacheEnabled(false);
        this.flG.setOnClickListener(new af(this));
        this.aiY.setOnFocusChangeListener(this.flB);
        this.aiY.setOnClickListener(new ah(this));
        this.ggH.setOnClickListener(new ai(this));
        btW();
        k(buk());
        bua();
        amo();
        switch (this.flk.getType()) {
            case 0:
                if (this.ggy || this.ggz) {
                    if (this.ggA) {
                        this.cVm.setText(r.j.feedback_vcode);
                    } else {
                        this.cVm.setText(r.j.feedback);
                    }
                } else {
                    this.cVm.setText(r.j.post_new_thread);
                }
                this.flD.setVisibility(0);
                this.flH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.cVm.setText(r.j.send_reply);
                this.flH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.flD.setVisibility(8);
                break;
            case 4:
                this.cVm.setText(r.j.publish_photo_live);
                this.flH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cVm.setText(getPageContext().getResources().getString(r.j.update_photo_live_tip, Integer.valueOf(this.flk.getFloorNum() + 1)));
                this.ghb.setVisibility(8);
                break;
            case 7:
                this.flD.setVisibility(0);
                this.flH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
        }
        bub();
        bui();
        btO();
        btY();
        bfJ();
        if (this.flk.getType() == 4 && this.flM != null && this.ggF != null) {
            this.flM.setVisibility(8);
            this.ggF.setVisibility(8);
        }
        bfL();
        ShowSoftKeyPad(this.mInputManager, this.flD);
        btX();
    }

    private void btU() {
        if (this.flk != null && this.flk.getType() == 0 && !this.ggy && !this.ggz && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.az.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bug() != null) {
                bug().setText(c);
                bug().setSelection(c.length());
            }
        }
    }

    private void btV() {
        this.cpb = null;
        this.ggT = -1;
        this.ggU = -1;
        da hZ = cz.acy().hZ(1);
        if (hZ != null) {
            this.cpb = hZ.bTm;
            this.ggT = getIntent().getIntExtra("category_id", -1);
            if (this.cpb != null && !this.cpb.isEmpty() && this.ggT >= 0) {
                this.ggS = new cy();
                this.ggS.bTi = 0;
                this.ggS.name = getPageContext().getResources().getString(r.j.category_auto);
                this.ggU = this.ggS.bTi;
                this.cpm = this.ggS.name;
                for (cy cyVar : this.cpb) {
                    if (cyVar.bTi == this.ggT) {
                        this.ggU = cyVar.bTi;
                        this.cpm = cyVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void btW() {
        if (this.cpb != null && !this.cpb.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(r.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(r.g.interval_view_cate).setVisibility(0);
            this.ggV = (PostCategoryView) linearLayout.findViewById(r.g.category_selected);
            this.ggV.setText(this.cpm);
            this.ggV.b(this.cpb, this.ggS, this.ggU);
            this.ggV.setCategoryContainerClickCallback(new aj(this));
            linearLayout.setOnClickListener(new ak(this));
        }
    }

    private void btX() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ghC = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.ghC.setTitle(r.j.no_disturb_start_time);
        this.ghC.setButton(-1, getPageContext().getString(r.j.alert_yes_button), this.ghC);
        this.ghC.setButton(-2, getPageContext().getString(r.j.alert_no_button), this.ghC);
        return this.ghC;
    }

    private void btY() {
        this.ggN = (RelativeLayout) findViewById(r.g.addition_container);
        this.ggO = (TextView) findViewById(r.g.addition_create_time);
        this.ggP = (TextView) findViewById(r.g.addition_last_time);
        this.ggQ = (TextView) findViewById(r.g.addition_last_content);
        if (this.ggM != null) {
            this.ggN.setVisibility(0);
            this.ggO.setText(String.valueOf(getPageContext().getString(r.j.write_addition_create)) + com.baidu.tbadk.core.util.az.t(this.ggM.getCreateTime() * 1000));
            if (this.ggM.getAlreadyCount() == 0) {
                this.ggP.setVisibility(8);
            } else {
                this.ggP.setText(String.valueOf(getPageContext().getString(r.j.write_addition_last)) + com.baidu.tbadk.core.util.az.t(this.ggM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ggM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ggQ.setText(lastAdditionContent);
            } else {
                this.ggQ.setVisibility(8);
            }
            buf().setHint(String.format(getPageContext().getString(r.j.write_addition_hint), Integer.valueOf(this.ggM.getAlreadyCount()), Integer.valueOf(this.ggM.getTotalCount())));
            this.cVm.setText(r.j.write_addition_title);
            return;
        }
        this.ggN.setVisibility(8);
    }

    private void bfJ() {
        this.flM = findViewById(r.g.post_prefix_layout);
        this.flJ = (TextView) findViewById(r.g.post_prefix);
        this.ggF = findViewById(r.g.prefix_divider);
        this.flL = (ImageView) findViewById(r.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.flM.setVisibility(0);
            this.ggF.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fll = 1;
            this.flM.setOnClickListener(new am(this));
            this.flL = (ImageView) findViewById(r.g.prefix_icon);
            if (size > 1) {
                this.flL.setVisibility(0);
                this.flJ.setOnClickListener(new an(this));
            }
            this.flK = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.flK.a(this);
            this.flK.setMaxHeight(com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds510));
            this.flK.setOutsideTouchable(true);
            this.flK.setFocusable(true);
            this.flK.setOnDismissListener(this);
            this.flK.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(r.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.k(this.flJ, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.flL, r.f.icon_title_down);
            this.flJ.setTextColor(color);
            this.gfz.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.gfz.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.flK.addView(aVar);
            }
            this.flK.th(0);
            this.flJ.setText(prefixs.get(1));
            tB(1);
            return;
        }
        this.flM.setVisibility(8);
    }

    private void btZ() {
        if (this.ggy && this.flk != null) {
            this.ggD.setVisibility(0);
            this.ggE.setVisibility(0);
            this.ggC = new p(this);
            this.ggC.sI(this.flk.getForumName());
            this.ggC.setLoadDataCallBack(new ao(this));
        }
    }

    protected void bua() {
        this.flI.setOnClickListener(new ap(this));
    }

    protected void bub() {
        this.ggI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ggI.cD(getPageContext().getString(r.j.is_save_draft)).aq(false).a(getPageContext().getString(r.j.save), new aq(this)).b(getPageContext().getString(r.j.not_save), new at(this));
        this.ggI.b(getPageContext());
    }

    protected void bfK() {
        this.geD = (HeadImageView) findViewById(r.g.user_head_portrait);
        this.geD.setIsRound(true);
        this.geD.setDrawBorder(false);
        this.geD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dm = com.baidu.tbadk.core.util.q.dm(currentPortrait);
            this.geD.setUrl(dm);
            this.geD.c(dm, 12, false);
        }
        this.flD = (EditText) findViewById(r.g.post_title);
        this.flD.setOnClickListener(this.ghx);
        this.flD.setOnFocusChangeListener(this.flB);
        if (this.flk.getType() == 0) {
            if (this.flk.getTitle() != null) {
                this.flD.setText(this.flk.getTitle());
                this.flD.setSelection(this.flk.getTitle().length());
            } else if (this.ggA) {
                this.flD.setText(getResources().getString(r.j.vcode_feed_back_title));
            }
        } else if (this.flk.getType() != 1) {
            this.flk.getType();
        }
        this.flD.addTextChangedListener(this.ghA);
        if (!this.flk.getHaveDraft()) {
            btU();
            this.ghu = true;
        }
    }

    private TextWatcher aVt() {
        au auVar = new au(this);
        if (this.ghi && this.ghj) {
            if (this.ghg != null) {
                this.ghd.removeTextChangedListener(this.ghg);
            }
            this.ghg = auVar;
        } else if (this.ghi) {
            if (this.ghh != null) {
                this.ggZ.removeTextChangedListener(this.ghh);
            }
            this.ghh = auVar;
        }
        return auVar;
    }

    private long g(EditText editText) {
        if (editText == this.ggZ) {
            return 233L;
        }
        if (editText != this.ghd) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bfM() {
        this.flH = (EditText) findViewById(r.g.post_content);
        this.flH.setDrawingCacheEnabled(false);
        this.flH.setOnClickListener(this.ghx);
        if (this.flk.getContent() != null && this.flk.getContent().length() > 0) {
            SpannableString z = TbFaceManager.Ej().z(getPageContext().getPageActivity(), this.flk.getContent());
            this.flH.setText(z);
            this.flH.setSelection(z.length());
        } else if (this.flk.getType() == 2) {
            if (this.ggJ) {
                if (this.ggK != null && this.ggK.length() > 0) {
                    this.flH.setText(getPageContext().getPageActivity().getString(r.j.reply_sub_floor, new Object[]{this.ggK}));
                    this.flH.setSelection(this.flH.getText().length());
                }
            } else if (this.flk.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(r.j.reply_x_floor), Integer.valueOf(this.flk.getFloorNum()));
                this.flH.setText(format);
                this.flH.setSelection(format.length());
            }
        }
        this.flH.setOnFocusChangeListener(this.flB);
        this.flH.setOnTouchListener(new av(this));
        this.flH.addTextChangedListener(this.ghB);
        lR(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.ghi) {
            buf().setPadding(0, 0, 0, 0);
            buf().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.av.l(buf(), r.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dPf) && this.ggM == null) {
                com.baidu.adp.lib.g.c.eA().a(this.dPf, 19, new aw(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buc() {
        int i = 5000;
        if (this.ggM != null) {
            i = 1000;
        }
        return buf().getText() != null && buf().getText().length() >= i;
    }

    private void fA(String str) {
        if (!StringUtils.isNull(str)) {
            if ("from_content".equals(this.ggw)) {
                this.ggw = "";
                buf().requestFocus();
                if (buf().getText() != null && buf().getText().length() + str.length() > 5000) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                buf().getText().insert(buf().getSelectionStart(), str);
            } else if ("from_title".equals(this.ggw)) {
                this.ggw = "";
                bug().requestFocus();
                if (bug().getText() != null && bug().getText().length() + str.length() > 31) {
                    showToast(r.j.over_limit_tip);
                    return;
                }
                bug().getText().insert(bug().getSelectionStart(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bud() {
        if (!com.baidu.tbadk.plugins.a.f(getPageContext())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bue() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.atO != null) {
                this.atO.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.bjb() && this.bob == 0) {
            showToast(r.j.baobao_over_limit);
        } else {
            String charSequence = this.cVm.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra(VrPlayerActivityConfig.TITLE, charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) buf().getText().getSpans(0, buf().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ggL == null) {
                this.ggL = Toast.makeText(getPageContext().getPageActivity(), r.j.too_many_face, 0);
            }
            this.ggL.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xO = lVar.xO();
        if (name != null) {
            com.baidu.adp.lib.g.c.eA().a(name, 20, new ax(this, new SpannableStringBuilder(name), xO), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap jV = aVar.jV();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
        int width = jV.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        buf().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText buf() {
        return this.ghi ? this.ggZ : this.flH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bug() {
        return this.ghi ? this.ghd : this.flD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buh() {
        buf().onKeyDown(67, this.ggG);
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.flk != null) {
            str = this.flk.getForumName();
        }
        if (getPageContext().getString(r.j.feedback_bar_name).equals(str)) {
            this.ggy = true;
        }
    }

    private void bui() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void buj() {
        try {
            if (this.ggI != null) {
                this.ggI.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aDU.c(null);
        this.aDU.cW(r.j.sending);
        this.aDU.aF(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aDU.aF(false);
    }

    private Boolean buk() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.avP = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfL() {
        if (this.flk != null) {
            String str = "";
            String str2 = "";
            if (bug() != null) {
                str = bug().getText().toString();
            }
            if (buf() != null) {
                str2 = buf().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.flk.getType() == 0 || this.flk.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fll == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.flk.setIsNoTitle(true);
                        } else {
                            this.flk.setIsNoTitle(false);
                            lS(true);
                            return;
                        }
                    } else {
                        this.flk.setIsNoTitle(false);
                        lS(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.flk.setIsNoTitle(true);
                } else {
                    this.flk.setIsNoTitle(false);
                    lS(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ghi) {
                    lS(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lS(true);
                }
            }
            if (this.flk.getType() == 4) {
                lS(i(this.ggZ) && h(this.ghd));
            } else if (this.flk.getType() == 5) {
                lS(i(this.ggZ));
            } else if (!TextUtils.isEmpty(str2)) {
                lS(true);
            } else if (this.avF != null) {
                lS(true);
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                lS(true);
            } else if (this.flk.getVideoInfo() != null) {
                lS(true);
            } else if (!StringUtils.isNull(this.flk.getGraffitiFileName())) {
                lS(true);
            } else {
                lS(false);
            }
        }
    }

    private void lS(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.av.b(this.flI, r.d.cp_link_tip_a, r.d.s_navbar_title_color);
            this.flI.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.av.c(this.flI, r.d.cp_cont_d, 1);
        this.flI.setEnabled(false);
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
        this.avJ = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        this.avJ.b(this.avZ);
        registerListener(this.ghv);
        this.eIl = new ay(this);
        this.flk = new WriteData();
        if (bundle != null) {
            this.flk.setType(bundle.getInt("type", 0));
            this.flk.setForumId(bundle.getString("forum_id"));
            this.flk.setForumName(bundle.getString("forum_name"));
            this.flk.setThreadId(bundle.getString("thread_id"));
            this.flk.setFloor(bundle.getString("floor_id"));
            this.flk.setFloorNum(bundle.getInt("floor_num", 0));
            this.ggy = bundle.getBoolean("feed_back", false);
            this.ggA = bundle.getBoolean("vcode_feed_back", false);
            this.ggJ = bundle.getBoolean("reply_sub_pb", false);
            this.ggK = bundle.getString("sub_user_name");
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.avH = bundle.getString("photo_name");
            this.ggM = (AdditionData) bundle.getSerializable("addition_data");
            this.flk.setIsAddition(this.ggM != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.bob = bundle.getInt("mem_type", 0);
            this.adg = bundle.getString("from");
            this.flk.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.flk.setContent(bundle.getString(WriteActivityConfig.CONTENT));
        } else {
            Intent intent = getIntent();
            this.flk.setType(intent.getIntExtra("type", 0));
            this.flk.setForumId(intent.getStringExtra("forum_id"));
            this.flk.setForumName(intent.getStringExtra("forum_name"));
            this.flk.setThreadId(intent.getStringExtra("thread_id"));
            this.flk.setFloor(intent.getStringExtra("floor_id"));
            this.flk.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.ggy = intent.getBooleanExtra("feed_back", false);
            this.ggA = intent.getBooleanExtra("vcode_feed_back", false);
            this.ggJ = intent.getBooleanExtra("reply_sub_pb", false);
            this.ggK = intent.getStringExtra("sub_user_name");
            this.ggM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.flk.setIsAddition(this.ggM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.bob = intent.getIntExtra("mem_type", 0);
            this.adg = intent.getStringExtra("from");
            this.flk.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.flk.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.flk.getType() == 4 ? 6 : 10);
        this.flk.setWriteImagesInfo(this.writeImagesInfo);
        this.flk.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.flk.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.ae.c(this.flk.getForumId(), this);
            }
        } else if (this.flk.getType() == 1) {
            com.baidu.tieba.tbadkCore.ae.a(this.flk.getThreadId(), this);
        } else if (this.flk.getType() == 4) {
            com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.flk.getForumId()) + "photolive", this);
        } else if (this.flk.getType() == 5) {
            com.baidu.tieba.tbadkCore.ae.a(String.valueOf(this.flk.getThreadId()) + "updatephotolive", this);
        } else if (this.flk.getType() == 7) {
            com.baidu.tieba.tbadkCore.ae.c(this.flk.getForumId(), this);
            this.dealInfoData = (DealInfoData) getIntent().getSerializableExtra("deal_info");
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(r.j.write_no_prefix));
        }
        this.dPf = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.flk != null && this.flk.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.flk.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.ggz = true;
        }
        btV();
        try {
            this.ghl = buq();
        } catch (Throwable th) {
            this.ghl = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.flk != null) {
                this.flk.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bug().getText().toString()) || this.ghu || ((this.ggy || this.ggz) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.flk.setTitle(writeData.getTitle());
                    bug().setText(this.flk.getTitle());
                    bug().setSelection(this.flk.getTitle().length());
                }
                if (this.flk != null && !this.flk.getHaveDraft()) {
                    btU();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.flk.setVideoInfo(videoInfo);
                    this.atO.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(buf().getText().toString()) || this.ggy || this.ggz) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.flk.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ej().a(getPageContext().getPageActivity(), this.flk.getContent(), this.ghw);
                    buf().setText(a2);
                    buf().setSelection(a2.length());
                    if (this.ghi) {
                        b(this.ghf, this.ggZ);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.flk.setWriteImagesInfo(this.writeImagesInfo);
                    bup();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DA();
                    }
                    lT(false);
                }
                if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.flk.setIsBaobao(writeData.getIsBaobao());
                        this.flk.setBaobaoContent(writeData.getBaobaoContent());
                        this.flk.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.flk.getIsBaobao()) {
                        DC();
                        lU(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bul();
                }
                bfL();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.cpb != null) {
                    this.ggU = this.ggS.bTi;
                    this.cpm = this.ggS.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.cpb.size()) {
                            break;
                        }
                        cy cyVar = this.cpb.get(i2);
                        if (categoryTo != cyVar.bTi) {
                            i = i2 + 1;
                        } else {
                            this.ggU = categoryTo;
                            this.cpm = cyVar.name;
                            this.flk.setCategoryTo(this.ggU);
                            break;
                        }
                    }
                    if (this.ggV != null) {
                        this.ggV.setText(this.cpm);
                        this.ggV.b(this.cpb, this.ggS, this.ggU);
                    }
                }
                this.flk.setGraffitiFileName(writeData.getGraffitiFileName());
                this.atO.b(new com.baidu.tbadk.editortools.a(42, 24, this.flk.getGraffitiFileName()));
                this.atO.AV();
                return;
            }
            return;
        }
        bul();
        btU();
    }

    private void bul() {
        if ((!this.ghi || this.ggX != null) && this.ggW != null) {
            this.ggX.f(this.writeImagesInfo);
            buo();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.flk.getType());
        bundle.putString("forum_id", this.flk.getForumId());
        bundle.putString("forum_name", this.flk.getForumName());
        bundle.putString("thread_id", this.flk.getThreadId());
        bundle.putString("floor_id", this.flk.getFloor());
        bundle.putInt("floor_num", this.flk.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.ggJ);
        if (this.ggy) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putSerializable("baobao_images", this.baobaoImagesInfo);
        bundle.putString("photo_name", this.avH);
        bundle.putSerializable("addition_data", this.ggM);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.bob);
        bundle.putString("from", this.adg);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = buf().getEditableText().toString();
        if (editable != null) {
            buf().setText(TbFaceManager.Ej().a(getPageContext().getPageActivity(), editable, this.ghw));
            buf().setSelection(buf().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn() {
        bfC();
        String editable = bug().getText().toString();
        this.flk.setContent(buf().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fll != 0 && this.flk.getType() != 4) {
            this.flk.setTitle(String.valueOf(this.flJ.getText().toString()) + editable);
        } else {
            this.flk.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.flk.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.flk.getTitle());
        }
        if (this.ggy || this.ggz) {
            String string = getResources().getString(r.j.android_feedback);
            if (TextUtils.isEmpty(this.flk.getTitle()) || !this.flk.getTitle().startsWith(string)) {
                this.flk.setTitle(string + this.flk.getTitle());
            }
            String str = String.valueOf(getResources().getString(r.j.app_name)) + getResources().getString(r.j.tieba_client);
            if (TextUtils.isEmpty(this.flk.getContent()) || !this.flk.getContent().startsWith(str)) {
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
                sb.append(this.flk.getContent());
                this.flk.setContent(sb.toString());
            }
        }
        if (this.ggT >= 0) {
            this.flk.setCategoryFrom(this.ggT);
        }
        if (this.ggU >= 0) {
            this.flk.setCategoryTo(this.ggU);
        }
        if (this.flk.getType() == 7 && this.dealInfoData != null) {
            this.flk.productId = this.dealInfoData.productId;
        }
        this.flk.setWriteImagesInfo(this.writeImagesInfo);
        this.flk.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.flk.setHasLocationData(this.avI == null ? false : this.avI.bkB());
        this.avJ.kQ(this.writeImagesInfo.size() > 0);
        this.avJ.d(this.flk);
        this.flk.setVcode(null);
        if (this.avF != null) {
            if (this.avF.getId() != null) {
                this.avJ.bfE().setVoice(this.avF.getId());
                this.avJ.bfE().setVoiceDuringTime(this.avF.duration);
            } else {
                this.avJ.bfE().setVoice(null);
                this.avJ.bfE().setVoiceDuringTime(-1);
            }
        } else {
            this.avJ.bfE().setVoice(null);
            this.avJ.bfE().setVoiceDuringTime(-1);
        }
        if (!this.avJ.blb()) {
            showToast(r.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(r.j.sending), this.eIl);
            if (!this.avJ.bkY()) {
            }
        }
    }

    private void p(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ggM != null) {
                i2 = this.ggM.getTotalCount();
                i = this.ggM.getAlreadyCount() + 1;
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
                if (this.atO != null && !this.atO.CJ()) {
                    buf().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                if (y != null && y.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < y.size()) {
                            sb.append("@");
                            sb.append(y.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            buf().getText().insert(buf().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.flk.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ae.b(this.flk.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.flk.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ae.c(this.flk.getThreadId(), (WriteData) null);
                } else if (this.flk.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.flk.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                } else if (this.flk.getType() == 7) {
                    com.baidu.tieba.tbadkCore.ae.b(this.flk.getForumId(), (WriteData) null);
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
                                aWP();
                            } else {
                                E(intent);
                            }
                        } else if (intExtra == 1) {
                            x(intent);
                        } else {
                            D(intent);
                            com.baidu.adp.lib.h.h.eG().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.ghi) {
                        d(intent);
                        bfL();
                        return;
                    }
                    G(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.flk.setVideoInfo(videoInfo);
                        this.atO.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.atO.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.atO.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bfL();
                } else if (i == 12013) {
                    e(intent);
                    bfL();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.n(intent);
                } else if (i == 25004 && intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ggx) {
                            sb3.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.ggx = false;
                        }
                        sb3.append(stringExtra);
                        fA(sb3.toString());
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.atO != null && !this.atO.CJ()) {
                this.flH.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dt();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bun();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.avH = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.au.b(getPageContext(), this.avH);
                    return;
                case 12012:
                    bun();
                    return;
                case 25004:
                    if ("from_title".equals(this.ggw)) {
                        bug().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ggw)) {
                        buf().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bum() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bun() {
        if (this.ghi) {
            this.ggX.f(this.writeImagesInfo);
            buo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buo() {
        this.ggX.notifyDataSetChanged();
        this.ggW.invalidate();
        this.mHandler.postDelayed(new ba(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bfL();
    }

    private void D(Intent intent) {
        if (this.ghi) {
            G(intent);
            bun();
        } else {
            H(intent);
        }
        bfL();
    }

    private void G(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bun();
            lT(true);
        }
    }

    private void E(Intent intent) {
        if (this.writeImagesInfo != null) {
            c(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aWP() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void x(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eSe.parseJson(stringExtra);
            this.eSe.updateQuality();
            if (this.eSe.getChosedFiles() != null && this.eSe.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eSe.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eSe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bug());
        HidenSoftKeyPad(this.mInputManager, buf());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void H(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.avH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.avH, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bup();
            DA();
        }
        lT(true);
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
                bup();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DA();
                }
            }
            lT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        if (this.atO.ey(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void e(Intent intent) {
        if (this.flk != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.flk.setIsBaobao(true);
            this.flk.setBaobaoContent(stringExtra2);
            DC();
            lU(true);
        }
    }

    private void Dt() {
        new bb(this).execute(new Void[0]);
    }

    private void lT(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void lU(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bQb == null) {
            this.bQb = VoiceManager.instance();
        }
        return this.bQb;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abb() {
        this.bQb = getVoiceManager();
        this.bQb.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rU(postWriteCallBackData.getErrorCode())) {
                AntiHelper.R(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(r.j.error_write);
                }
                showToast(errorString2);
            } else if (this.ggM == null) {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avR = i;
        if (this.atO != null) {
            this.atO.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.atO.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DA() {
        if (!this.ghi && this.atO != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.atO.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.atO.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.atO.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.atO.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void DC() {
        if (this.atO != null) {
            this.atO.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.atO.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.atO.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.atO != null) {
            this.atO.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tB(int i) {
        if (i < this.gfz.size()) {
            for (int i2 = 0; i2 < this.gfz.size(); i2++) {
                this.gfz.get(i2).lH(false);
            }
            this.gfz.get(i).lH(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rr(int i) {
        this.fll = i;
        this.flK.th(i);
        tB(i);
        this.flJ.setText(this.mPrefixData.getPrefixs().get(i));
        bfL();
        com.baidu.adp.lib.h.j.a(this.flK, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.flM.setSelected(false);
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
        if (this.flk != null) {
            if (this.flk.getType() == 4) {
                return "a015";
            }
            if (this.flk.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Do();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.aa(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.b(getPageContext(), this.avH);
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
        if (this.ghk != null) {
            this.ghk.onKeyboardVisibilityChanged(z);
        }
        if (this.ghs && System.currentTimeMillis() - this.ght < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.ghs = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.gho != null) {
            sK(str);
            this.gho.dismiss();
        }
    }

    private void bj(Context context) {
        ghq = com.baidu.adp.lib.util.k.K(context);
        ghr = com.baidu.adp.lib.util.k.L(context);
    }

    private void sK(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(r.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.ghs = true;
        bup();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DA();
        }
        lT(true);
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

    private File buq() {
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

    private void bur() {
        if (this.ghl != null && this.flk.getType() == 0) {
            bj(getActivity());
            this.ghn = getPageContext().getPageActivity().getLayoutInflater().inflate(r.h.rec_dialog, (ViewGroup) null);
            this.ghn.setOnClickListener(new bc(this));
            this.ghm = (TbImageView) this.ghn.findViewById(r.g.rec_img_view);
            this.ghp = (LinearLayout) this.ghn.findViewById(r.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.uh().getString("write_rec_pic_path", "").equalsIgnoreCase(this.ghl.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.uh().putString("write_rec_pic_path", this.ghl.getAbsolutePath());
                Bitmap d = d(this.ghl.getAbsolutePath(), getResources().getDimensionPixelSize(r.e.ds160));
                if (d != null) {
                    this.ghm.setImageBitmap(d);
                    this.ghm.setDrawBorder(true);
                    this.ghm.setBorderWidth(2);
                    this.ghm.setBorderColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10264));
                    this.gho = new Dialog(getActivity(), r.k.bubble_dialog);
                    this.gho.setCanceledOnTouchOutside(true);
                    this.gho.setOnDismissListener(new be(this));
                    this.gho.setContentView(this.ghn);
                    this.gho.show();
                    Window window = this.gho.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(r.e.ds28);
                    attributes.y = (ghr / 18) + getResources().getDimensionPixelSize(r.e.ds12);
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
}
