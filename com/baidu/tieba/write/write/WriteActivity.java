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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.PostPrefixData;
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
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, af.a, b.a {
    private static int fVc = 0;
    private static int fVd = 0;
    private String aaf;
    private com.baidu.tbadk.editortools.l ard;
    private VoiceData.VoiceModel asV;
    private String asX;
    private com.baidu.tieba.tbadkCore.location.d asY;
    private com.baidu.tieba.tbadkCore.writeModel.a asZ;
    private VoiceManager bEE;
    private String cdC;
    List<dc> cdr;
    private DealInfoData dealInfoData;
    private TextView fUA;
    private TextView fUB;
    private TextView fUC;
    private ViewGroup fUD;
    dc fUE;
    private int fUF;
    private int fUG;
    private PostCategoryView fUH;
    private LinearLayout fUl;
    private View fUo;
    private View fUp;
    private Toast fUv;
    private String fUw;
    private AdditionData fUy;
    private RelativeLayout fUz;
    private com.baidu.tieba.view.c fVm;
    private TextView faP;
    private com.baidu.tieba.write.b faQ;
    private ImageView faR;
    private View faS;
    private int far;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData faq = null;
    private boolean fUi = false;
    private boolean fUj = false;
    private boolean fUk = false;
    private InputMethodManager mInputManager = null;
    private EditText faJ = null;
    private HeadImageView fSo = null;
    private View faK = null;
    private LinearLayout faM = null;
    private EditText faN = null;
    private p fUm = null;
    private FeedBackTopListView fUn = null;
    private ArrayList<com.baidu.tieba.write.a> fTk = new ArrayList<>();
    private String dBu = null;
    private final KeyEvent fUq = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View agC = null;
    private TextView fUr = null;
    private TextView faO = null;
    private TextView cIn = null;
    private DialogInterface.OnCancelListener ezF = null;
    private com.baidu.tbadk.core.dialog.a fUs = null;
    private final Handler mHandler = new Handler();
    private boolean fUt = false;
    private String fUu = null;
    private RelativeLayout cHo = null;
    private String atf = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean fUx = false;
    private int ath = 0;
    private int bcs = 0;
    private WriteImagesInfo eIR = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fUI = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fUJ = null;
    private ScrollView fUK = null;
    private EditText fUL = null;
    private View fUM = null;
    private View fUN = null;
    private View fUO = null;
    private EditText fUP = null;
    private TextView fUQ = null;
    private TextView fUR = null;
    private TextWatcher fUS = null;
    private TextWatcher fUT = null;
    private boolean fUU = false;
    private boolean fUV = false;
    private com.baidu.tbadk.core.view.b aBp = null;
    private bl fUW = null;
    private File fUX = null;
    private TbImageView fUY = null;
    private View fUZ = null;
    private Dialog fVa = null;
    private LinearLayout fVb = null;
    private boolean fVe = false;
    private long fVf = -1000;
    private final HttpMessageListener fVg = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fVh = new ag(this);
    private final a.d atp = new as(this);
    private final d.a atn = new bd(this);
    private final CustomMessageListener fmN = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fVi = new bg(this);
    private boolean fVj = true;
    private final View.OnFocusChangeListener faH = new bh(this);
    private final CustomMessageListener fVk = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private TextWatcher fVl = new bj(this);
    private final a.InterfaceC0074a ehS = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if ("from_add_photo_live_in_misson".equals(this.aaf)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(u.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m10getInst().getLocationShared()) {
            BU();
        } else if (this.asY.bgm()) {
            BS();
        } else {
            this.asY.kz(false);
            b(1, true, null);
            this.asY.bgk();
        }
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new x(this)).b(u.j.cancel, new y(this)).b(getPageContext());
        aVar.rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int boS() {
        int selectionEnd = bpj().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bpj().getText().getSpans(0, bpj().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bpj().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bpj().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boT() {
        if (this.ard != null) {
            this.ard.setBarLauncherEnabled(!this.fVj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fUU) {
            this.faJ.setVisibility(8);
            if (this.faq.getType() == 5) {
                this.fUO.setVisibility(8);
            } else {
                this.fUO.setVisibility(0);
            }
            b(this.fUR, this.fUL);
            b(this.fUQ, this.fUP);
            bbv();
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
        bpc();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.fVk.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.fVk);
        this.asY = new com.baidu.tieba.tbadkCore.location.d(this);
        this.asY.a(this.atn);
        registerListener(this.fmN);
        initEditor();
        bpw();
        if (this.fUU) {
            this.fUJ.setEditorTools(this.ard);
        } else {
            this.faJ.requestFocus();
        }
    }

    private void initEditor() {
        com.baidu.tbadk.editortools.s ej;
        com.baidu.tbadk.editortools.aa el;
        this.ard = new com.baidu.tbadk.editortools.l(getActivity());
        this.ard.setBarMaxLauCount(5);
        this.ard.setMoreButtonAtEnd(true);
        this.ard.setBarLauncherType(1);
        this.ard.by(true);
        this.ard.bx(true);
        this.ard.setMoreLauncherIcon(u.f.write_more);
        this.ard.setBackgroundColorId(u.d.cp_bg_line_d);
        this.ard.setCanshowTogetherhi(Boolean.valueOf(this.fUx));
        switch (this.faq.getType()) {
            case 4:
            case 5:
                boV();
                break;
            default:
                boW();
                break;
        }
        this.ard.Bm();
        if (this.fUl != null) {
            this.fUl.addView(this.ard);
        }
        boX();
        this.ard.kB();
        com.baidu.tbadk.editortools.s ej2 = this.ard.ej(6);
        if (ej2 != null && !TextUtils.isEmpty(this.atf)) {
            ((View) ej2).setOnClickListener(new z(this));
        }
        if (!this.fUU) {
            this.ard.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ard.zD();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("xiaoying_has_click", false)) {
            this.ard.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        Ca();
        this.fUW = new bl(this, this.ard);
        if (this.fUw != null && (ej = this.ard.ej(26)) != null && (ej instanceof View) && (el = this.ard.el(27)) != null && el.aqX != null && (el.aqX instanceof View)) {
            getWindow().setSoftInputMode(18);
            ((View) el.aqX).post(new aa(this, (View) ej));
        }
    }

    private void Ca() {
        if (this.ard != null) {
            this.ard.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.ard.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void QL() {
        this.fUM = this.mRootView.findViewById(u.g.photo_live_scroll);
        this.fUO = this.fUM.findViewById(u.g.live_post_title_container);
        this.fUL = (EditText) this.fUM.findViewById(u.g.live_post_content);
        this.fUI = (GridView) this.fUM.findViewById(u.g.photoLiveGridView);
        this.fUP = (EditText) this.fUM.findViewById(u.g.live_post_title);
        this.fUQ = (TextView) this.fUM.findViewById(u.g.titleOverPlusNumber);
        this.fUR = (TextView) this.fUM.findViewById(u.g.contentOverPlusNumber);
        this.fUN = this.fUM.findViewById(u.g.live_interval_view);
        this.fUQ.setText(String.valueOf(20));
        this.fUR.setText(String.valueOf(233));
        this.fUM.setVisibility(0);
        this.fUQ.setVisibility(0);
        this.fUR.setVisibility(0);
        this.fUP.setHint(u.j.tips_title_limit_new);
        this.fUP.setOnFocusChangeListener(new ab(this));
        if (this.faq.getType() == 4) {
            this.fUL.setHint(u.j.live_write_input_content_new);
        } else if (this.faq.getType() == 5) {
            this.fUL.setHint(u.j.live_write_input_content_update);
        }
        this.fUL.setOnFocusChangeListener(new ac(this));
        this.fUL.requestFocus();
        this.fUL.addTextChangedListener(aRF());
        this.fUP.requestFocus();
        this.fUP.addTextChangedListener(aRF());
        this.fUP.setOnClickListener(this.fVi);
        this.fUL.setOnClickListener(this.fVi);
        this.fUJ = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fUI);
        this.fUJ.sC(6);
        this.fUI.setAdapter((ListAdapter) this.fUJ);
        View findViewById = this.fUM.findViewById(u.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ad(this));
        boU();
    }

    private void boU() {
        if (this.faq.getType() == 0) {
            if (this.faq.getTitle() != null) {
                this.fUP.setText(this.faq.getTitle());
                this.fUP.setSelection(this.faq.getTitle().length());
            }
        } else if (this.faq.getType() != 1) {
            this.faq.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fUU) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bpq();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Cf();
            return;
        }
        if (this.ard.Bo()) {
            this.ard.zD();
        }
        String str = null;
        if (this.faq != null) {
            str = this.faq.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fUU) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void boV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ard.y(arrayList);
        com.baidu.tbadk.editortools.aa el = this.ard.el(5);
        if (el != null) {
            el.arS = 2;
            el.arQ = u.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.arQ = u.f.write_at;
        this.ard.b(aVar);
        this.ard.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void boW() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.arQ = u.f.write_picture;
        this.ard.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.ard.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 != null && (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) != null) {
            aaVar5.arU = true;
            aaVar5.arQ = u.f.write_graffiti;
            aaVar5.arS = 3;
            this.ard.b(aaVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 != null && (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) != null) {
            aaVar4.arS = 4;
            aaVar4.arQ = u.f.write_privilege;
            this.ard.b(aaVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 6);
        aVar.arQ = u.f.write_at;
        this.ard.b(aVar);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.arU = true;
            aaVar3.arS = 8;
            aaVar3.arQ = 0;
            this.ard.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.arU = true;
            aaVar2.arS = 9;
            aaVar2.arQ = 0;
            this.ard.b(aaVar2);
        }
        Boolean bpo = bpo();
        if (!this.fUi && bpo != null && bpo.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bgL() && com.baidu.tieba.tbadkCore.v.a(this.faq.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.arS = 5;
            aaVar.arQ = u.f.write_recorder;
            this.ard.b(aaVar);
        }
        if (this.faq != null && this.faq.getType() == 0 && !this.fUi && !this.fUj) {
            arrayList.add(13);
            arrayList.add(14);
            arrayList.add(26);
            arrayList.add(27);
        }
        if (this.fUy == null) {
            this.ard.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.ard.y(arrayList);
        com.baidu.tbadk.editortools.aa el = this.ard.el(5);
        if (el != null) {
            el.arS = 1;
            el.arQ = u.f.write_emotion;
        }
        com.baidu.tbadk.editortools.aa el2 = this.ard.el(13);
        if (el2 != null) {
            el2.arS = 7;
        }
    }

    private void boX() {
        ae aeVar = new ae(this);
        this.ard.a(16, aeVar);
        this.ard.a(21, aeVar);
        this.ard.a(43, aeVar);
        this.ard.a(45, aeVar);
        this.ard.a(14, aeVar);
        this.ard.a(24, aeVar);
        this.ard.a(3, aeVar);
        this.ard.a(10, aeVar);
        this.ard.a(11, aeVar);
        this.ard.a(12, aeVar);
        this.ard.a(13, aeVar);
        this.ard.a(22, aeVar);
        this.ard.a(23, aeVar);
        this.ard.a(15, aeVar);
        this.ard.a(18, aeVar);
        this.ard.a(25, aeVar);
        this.ard.a(27, aeVar);
        this.ard.a(29, aeVar);
        this.ard.a(40, aeVar);
    }

    public void ahp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BV() {
        if (this.asY.bgo()) {
            if (this.asY.bgm()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bgi().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.asY.bgk();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbm() {
        if (this.asZ != null) {
            this.asZ.cancelLoadData();
        }
        if (this.fUm != null) {
            this.fUm.cancelLoadData();
        }
        if (this.asY != null) {
            this.asY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bbm();
        bpn();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bor() {
        if (this.faq != null && this.faq.getType() == 2 && this.fUt) {
            finish();
        } else if (this.faq == null) {
            finish();
        } else {
            this.faq.setTitle(bpk().getText().toString());
            this.faq.setContent(bpj().getText().toString());
            int type = this.faq.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.af.b(this.faq.getForumId(), this.faq);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.af.c(this.faq.getThreadId(), this.faq);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.af.b(String.valueOf(this.faq.getForumId()) + "photolive", this.faq);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.af.c(String.valueOf(this.faq.getThreadId()) + "updatephotolive", this.faq);
            } else if (type == 7) {
                com.baidu.tieba.tbadkCore.af.b(this.faq.getForumId(), this.faq);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.faQ != null && this.faQ.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.faQ, getPageContext().getPageActivity());
                return true;
            } else if (this.ard.Bo()) {
                this.ard.zD();
                return true;
            } else {
                bbm();
                bor();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.cHo);
        getLayoutMode().w(this.fVb);
        if (this.fUY != null && i == 1) {
            this.fUY.setBorderColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.av.c(this.faO, u.d.cp_link_tip_a, 1);
        boT();
        com.baidu.tbadk.core.util.av.l(this.fUM, u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.faK, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.fUN, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(bpk(), u.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dBu)) {
            com.baidu.tbadk.core.util.av.l(bpj(), u.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_e);
        bpk().setTextColor(color);
        bpj().setTextColor(color);
        a(bpk(), color2);
        a(bpj(), color2);
        bbv();
        this.ard.onChangeSkinType(i);
        if (this.fUH != null) {
            this.fUH.vm();
        }
        com.baidu.tbadk.core.util.av.j((View) this.cIn, u.d.cp_cont_f);
        if (this.fUD != null) {
            com.baidu.tbadk.j.a.a(getPageContext(), this.fUD);
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

    private void initUI() {
        this.aBp = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fUU = this.faq.getType() == 4 || 5 == this.faq.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(u.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.agC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agC.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.agC != null && (this.agC.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.agC.getLayoutParams();
            layoutParams2.width = -2;
            this.agC.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(u.f.icon_nav_close_selector, u.f.icon_nav_close_selector);
        this.cIn = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.av.j((View) this.cIn, u.d.cp_cont_f);
        this.fUr = (TextView) findViewById(u.g.btn_image_problem);
        this.faO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.faO.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds10);
        this.faO.setLayoutParams(layoutParams3);
        this.faO.setOnFocusChangeListener(this.faH);
        this.fUK = (ScrollView) findViewById(u.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fUn = (FeedBackTopListView) findViewById(u.g.feedback_top_list);
        this.fUo = findViewById(u.g.feedback_divider);
        this.cHo = (RelativeLayout) findViewById(u.g.parent);
        this.fUl = (LinearLayout) findViewById(u.g.tool_view);
        this.fUl.setContentDescription("..");
        this.faK = findViewById(u.g.interval_view);
        bbu();
        if (this.fUU) {
            this.fUK.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            QL();
        }
        if (this.faq.getType() == 7) {
            this.fUD = (ViewGroup) ((ViewStub) findViewById(u.g.ecomm_card)).inflate();
            ((EcommCardView) this.fUD.findViewById(u.g.ecomm_card_root)).setData(this.dealInfoData);
        }
        bbw();
        if (this.fUi || this.fUj) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ZG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(u.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(u.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.faM = (LinearLayout) findViewById(u.g.post_content_container);
        this.faM.setDrawingCacheEnabled(false);
        this.faM.setOnClickListener(new af(this));
        this.agC.setOnFocusChangeListener(this.faH);
        this.agC.setOnClickListener(new ah(this));
        this.fUr.setOnClickListener(new ai(this));
        boZ();
        k(bpo());
        bpd();
        ahp();
        switch (this.faq.getType()) {
            case 0:
                if (this.fUi || this.fUj) {
                    if (this.fUk) {
                        this.cIn.setText(u.j.feedback_vcode);
                    } else {
                        this.cIn.setText(u.j.feedback);
                    }
                } else {
                    this.cIn.setText(u.j.post_new_thread);
                }
                this.faJ.setVisibility(0);
                this.faN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.cIn.setText(u.j.send_reply);
                this.faN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.faJ.setVisibility(8);
                break;
            case 4:
                this.cIn.setText(u.j.publish_photo_live);
                this.faN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cIn.setText(getPageContext().getResources().getString(u.j.update_photo_live_tip, Integer.valueOf(this.faq.getFloorNum() + 1)));
                this.fUN.setVisibility(8);
                break;
            case 7:
                this.faJ.setVisibility(0);
                this.faN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
        }
        bpe();
        bpm();
        boT();
        bpb();
        bbt();
        if (this.faq.getType() == 4 && this.faS != null && this.fUp != null) {
            this.faS.setVisibility(8);
            this.fUp.setVisibility(8);
        }
        bbv();
        ShowSoftKeyPad(this.mInputManager, this.faJ);
        bpa();
    }

    private void boY() {
        this.cdr = null;
        this.fUF = -1;
        this.fUG = -1;
        de hs = dd.Xo().hs(1);
        if (hs != null) {
            this.cdr = hs.bIn;
            this.fUF = getIntent().getIntExtra("category_id", -1);
            if (this.cdr != null && !this.cdr.isEmpty() && this.fUF >= 0) {
                this.fUE = new dc();
                this.fUE.bIj = 0;
                this.fUE.name = getPageContext().getResources().getString(u.j.category_auto);
                this.fUG = this.fUE.bIj;
                this.cdC = this.fUE.name;
                for (dc dcVar : this.cdr) {
                    if (dcVar.bIj == this.fUF) {
                        this.fUG = dcVar.bIj;
                        this.cdC = dcVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void boZ() {
        if (this.cdr != null && !this.cdr.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(u.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(u.g.interval_view_cate).setVisibility(0);
            this.fUH = (PostCategoryView) linearLayout.findViewById(u.g.category_selected);
            this.fUH.setText(this.cdC);
            this.fUH.b(this.cdr, this.fUE, this.fUG);
            this.fUH.setCategoryContainerClickCallback(new aj(this));
            linearLayout.setOnClickListener(new ak(this));
        }
    }

    private void bpa() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fVm = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fVm.setTitle(u.j.no_disturb_start_time);
        this.fVm.setButton(-1, getPageContext().getString(u.j.alert_yes_button), this.fVm);
        this.fVm.setButton(-2, getPageContext().getString(u.j.alert_no_button), this.fVm);
        return this.fVm;
    }

    private void bpb() {
        this.fUz = (RelativeLayout) findViewById(u.g.addition_container);
        this.fUA = (TextView) findViewById(u.g.addition_create_time);
        this.fUB = (TextView) findViewById(u.g.addition_last_time);
        this.fUC = (TextView) findViewById(u.g.addition_last_content);
        if (this.fUy != null) {
            this.fUz.setVisibility(0);
            this.fUA.setText(String.valueOf(getPageContext().getString(u.j.write_addition_create)) + com.baidu.tbadk.core.util.ba.t(this.fUy.getCreateTime() * 1000));
            if (this.fUy.getAlreadyCount() == 0) {
                this.fUB.setVisibility(8);
            } else {
                this.fUB.setText(String.valueOf(getPageContext().getString(u.j.write_addition_last)) + com.baidu.tbadk.core.util.ba.t(this.fUy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fUy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fUC.setText(lastAdditionContent);
            } else {
                this.fUC.setVisibility(8);
            }
            bpj().setHint(String.format(getPageContext().getString(u.j.write_addition_hint), Integer.valueOf(this.fUy.getAlreadyCount()), Integer.valueOf(this.fUy.getTotalCount())));
            this.cIn.setText(u.j.write_addition_title);
            return;
        }
        this.fUz.setVisibility(8);
    }

    private void bbt() {
        this.faS = findViewById(u.g.post_prefix_layout);
        this.faP = (TextView) findViewById(u.g.post_prefix);
        this.fUp = findViewById(u.g.prefix_divider);
        this.faR = (ImageView) findViewById(u.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.faS.setVisibility(0);
            this.fUp.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.far = 1;
            this.faS.setOnClickListener(new am(this));
            this.faR = (ImageView) findViewById(u.g.prefix_icon);
            if (size > 1) {
                this.faR.setVisibility(0);
                this.faP.setOnClickListener(new an(this));
            }
            this.faQ = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.faQ.a(this);
            this.faQ.setMaxHeight(com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds510));
            this.faQ.setOutsideTouchable(true);
            this.faQ.setFocusable(true);
            this.faQ.setOnDismissListener(this);
            this.faQ.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.k(this.faP, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.faR, u.f.icon_title_down);
            this.faP.setTextColor(color);
            this.fTk.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fTk.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.faQ.addView(aVar);
            }
            this.faQ.ss(0);
            this.faP.setText(prefixs.get(1));
            sM(1);
            return;
        }
        this.faS.setVisibility(8);
    }

    private void bpc() {
        if (this.fUi && this.faq != null) {
            this.fUn.setVisibility(0);
            this.fUo.setVisibility(0);
            this.fUm = new p(this);
            this.fUm.rJ(this.faq.getForumName());
            this.fUm.setLoadDataCallBack(new ao(this));
        }
    }

    protected void bpd() {
        this.faO.setOnClickListener(new ap(this));
    }

    protected void bpe() {
        this.fUs = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fUs.cz(getPageContext().getString(u.j.is_save_draft)).ap(false).a(getPageContext().getString(u.j.save), new aq(this)).b(getPageContext().getString(u.j.not_save), new at(this));
        this.fUs.b(getPageContext());
    }

    protected void bbu() {
        this.fSo = (HeadImageView) findViewById(u.g.user_head_portrait);
        this.fSo.setIsRound(true);
        this.fSo.setDrawBorder(false);
        this.fSo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dh = com.baidu.tbadk.core.util.q.dh(currentPortrait);
            this.fSo.setUrl(dh);
            this.fSo.c(dh, 12, false);
        }
        this.faJ = (EditText) findViewById(u.g.post_title);
        this.faJ.setOnClickListener(this.fVi);
        this.faJ.setOnFocusChangeListener(this.faH);
        if (this.faq.getType() == 0) {
            if (this.faq.getTitle() != null) {
                this.faJ.setText(this.faq.getTitle());
                this.faJ.setSelection(this.faq.getTitle().length());
            } else if (this.fUk) {
                this.faJ.setText(getResources().getString(u.j.vcode_feed_back_title));
            }
        } else if (this.faq.getType() != 1) {
            this.faq.getType();
        }
        this.faJ.addTextChangedListener(this.fVl);
    }

    private TextWatcher aRF() {
        au auVar = new au(this);
        if (this.fUU && this.fUV) {
            if (this.fUS != null) {
                this.fUP.removeTextChangedListener(this.fUS);
            }
            this.fUS = auVar;
        } else if (this.fUU) {
            if (this.fUT != null) {
                this.fUL.removeTextChangedListener(this.fUT);
            }
            this.fUT = auVar;
        }
        return auVar;
    }

    private long g(EditText editText) {
        if (editText == this.fUL) {
            return 233L;
        }
        if (editText != this.fUP) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bbw() {
        this.faN = (EditText) findViewById(u.g.post_content);
        this.faN.setDrawingCacheEnabled(false);
        this.faN.setOnClickListener(this.fVi);
        if (this.faq.getContent() != null && this.faq.getContent().length() > 0) {
            SpannableString z = TbFaceManager.CO().z(getPageContext().getPageActivity(), this.faq.getContent());
            this.faN.setText(z);
            this.faN.setSelection(z.length());
        } else if (this.faq.getType() == 2) {
            if (this.fUt) {
                if (this.fUu != null && this.fUu.length() > 0) {
                    this.faN.setText(getPageContext().getPageActivity().getString(u.j.reply_sub_floor, new Object[]{this.fUu}));
                    this.faN.setSelection(this.faN.getText().length());
                }
            } else if (this.faq.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(u.j.reply_x_floor), Integer.valueOf(this.faq.getFloorNum()));
                this.faN.setText(format);
                this.faN.setSelection(format.length());
            }
        }
        this.faN.setOnFocusChangeListener(this.faH);
        this.faN.setOnTouchListener(new av(this));
        this.faN.addTextChangedListener(this.fVl);
        lz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fUU) {
            bpj().setPadding(0, 0, 0, 0);
            bpj().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.av.l(bpj(), u.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dBu) && this.fUy == null) {
                com.baidu.adp.lib.g.c.dF().a(this.dBu, 19, new aw(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpf() {
        int i = 5000;
        if (this.fUy != null) {
            i = 1000;
        }
        return bpj().getText() != null && bpj().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpg() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.ard != null) {
                this.ard.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.beL() && this.bcs == 0) {
            showToast(u.j.baobao_over_limit);
        } else {
            String charSequence = this.cIn.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        this.fUw = null;
        this.faq.setHiContent(this.fUw);
        bpu();
        bbv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpi() {
        if (this.fUw != null) {
            if (this.ard != null) {
                this.ard.b(new com.baidu.tbadk.editortools.a(44, 27, this.fUw));
                bpu();
                return;
            }
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_HI_STARTMATCHIMAGE, new IntentConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.i iVar) {
        if (((ImageSpan[]) bpj().getText().getSpans(0, bpj().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fUv == null) {
                this.fUv = Toast.makeText(getPageContext().getPageActivity(), u.j.too_many_face, 0);
            }
            this.fUv.show();
            return;
        }
        String name = iVar.getName();
        EmotionGroupType wB = iVar.wB();
        if (name != null) {
            com.baidu.adp.lib.g.c.dF().a(name, 20, new ax(this, new SpannableStringBuilder(name), wB), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap ja = aVar.ja();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ja);
        int width = ja.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        bpj().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bpj() {
        return this.fUU ? this.fUL : this.faN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bpk() {
        return this.fUU ? this.fUP : this.faJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpl() {
        bpj().onKeyDown(67, this.fUq);
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.faq != null) {
            str = this.faq.getForumName();
        }
        if (getPageContext().getString(u.j.feedback_bar_name).equals(str)) {
            this.fUi = true;
        }
    }

    private void bpm() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bpn() {
        try {
            if (this.fUs != null) {
                this.fUs.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aBp.c(null);
        this.aBp.cI(u.j.sending);
        this.aBp.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aBp.aE(false);
    }

    private Boolean bpo() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.atf = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        if (this.faq != null) {
            String editable = bpk().getText().toString();
            String trim = bpj().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.faq.getType() == 0 || this.faq.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.far == 0) {
                        if (TextUtils.isEmpty(trim2)) {
                            this.faq.setIsNoTitle(true);
                        } else {
                            this.faq.setIsNoTitle(false);
                            lA(true);
                            return;
                        }
                    } else {
                        this.faq.setIsNoTitle(false);
                        lA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim2)) {
                    this.faq.setIsNoTitle(true);
                } else {
                    this.faq.setIsNoTitle(false);
                    lA(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fUU) {
                    lA(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lA(true);
                    return;
                }
            } else if (this.faq.getType() == 4) {
                if (!i(this.fUL) || !h(this.fUP)) {
                    r0 = false;
                }
                lA(r0);
                return;
            } else if (this.faq.getType() == 5) {
                lA(i(this.fUL));
                return;
            } else if (!TextUtils.isEmpty(trim)) {
                lA(true);
                return;
            } else if (this.asV != null) {
                lA(true);
                return;
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                lA(true);
                return;
            } else if (this.fUw != null) {
                lA(true);
                return;
            }
            if (this.faq.getVideoInfo() != null) {
                lA(true);
            } else if (this.faq.getGraffitiFileName() != null) {
                lA(true);
            } else {
                lA(false);
            }
        }
    }

    private void lA(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.av.c(this.faO, u.d.cp_link_tip_a, 1);
            this.faO.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.av.c(this.faO, u.d.cp_cont_d, 1);
        this.faO.setEnabled(false);
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
        this.asZ = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.asZ.b(this.atp);
        registerListener(this.fVg);
        this.ezF = new ay(this);
        this.faq = new WriteData();
        if (bundle != null) {
            this.faq.setType(bundle.getInt("type", 0));
            this.faq.setForumId(bundle.getString("forum_id"));
            this.faq.setForumName(bundle.getString("forum_name"));
            this.faq.setThreadId(bundle.getString("thread_id"));
            this.faq.setFloor(bundle.getString("floor_id"));
            this.faq.setFloorNum(bundle.getInt("floor_num", 0));
            this.fUi = bundle.getBoolean("feed_back", false);
            this.fUk = bundle.getBoolean("vcode_feed_back", false);
            this.fUt = bundle.getBoolean("reply_sub_pb", false);
            this.fUu = bundle.getString("sub_user_name");
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.fUw = bundle.getString(WriteActivityConfig.TOGETHERHI_DATA);
            this.fUx = bundle.getBoolean(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.asX = bundle.getString("photo_name");
            this.fUy = (AdditionData) bundle.getSerializable("addition_data");
            this.faq.setIsAddition(this.fUy != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.bcs = bundle.getInt("mem_type", 0);
            this.aaf = bundle.getString("from");
            this.faq.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.faq.setContent(bundle.getString(WriteActivityConfig.CONTENT));
        } else {
            Intent intent = getIntent();
            this.faq.setType(intent.getIntExtra("type", 0));
            this.faq.setForumId(intent.getStringExtra("forum_id"));
            this.faq.setForumName(intent.getStringExtra("forum_name"));
            this.faq.setThreadId(intent.getStringExtra("thread_id"));
            this.faq.setFloor(intent.getStringExtra("floor_id"));
            this.faq.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fUi = intent.getBooleanExtra("feed_back", false);
            this.fUk = intent.getBooleanExtra("vcode_feed_back", false);
            this.fUt = intent.getBooleanExtra("reply_sub_pb", false);
            this.fUu = intent.getStringExtra("sub_user_name");
            this.fUy = (AdditionData) intent.getSerializableExtra("addition_data");
            this.faq.setIsAddition(this.fUy != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.bcs = intent.getIntExtra("mem_type", 0);
            this.aaf = intent.getStringExtra("from");
            this.fUw = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.fUx = intent.getBooleanExtra(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.faq.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.faq.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.faq.getType() == 4 ? 6 : 10);
        this.faq.setWriteImagesInfo(this.writeImagesInfo);
        this.faq.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.faq.setHiContent(this.fUw);
        if (this.faq.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.af.c(this.faq.getForumId(), this);
            }
        } else if (this.faq.getType() == 1) {
            com.baidu.tieba.tbadkCore.af.a(this.faq.getThreadId(), this);
        } else if (this.faq.getType() == 4) {
            com.baidu.tieba.tbadkCore.af.c(String.valueOf(this.faq.getForumId()) + "photolive", this);
        } else if (this.faq.getType() == 5) {
            com.baidu.tieba.tbadkCore.af.a(String.valueOf(this.faq.getThreadId()) + "updatephotolive", this);
        } else if (this.faq.getType() == 7) {
            com.baidu.tieba.tbadkCore.af.c(this.faq.getForumId(), this);
            this.dealInfoData = (DealInfoData) getIntent().getSerializableExtra("deal_info");
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(u.j.write_no_prefix));
        }
        this.dBu = TbadkCoreApplication.m10getInst().getDefaultBubble();
        if (this.faq != null && this.faq.getForumName() != null && TbadkCoreApplication.m10getInst().getYijianfankuiFname() != null && this.faq.getForumName().equals(TbadkCoreApplication.m10getInst().getYijianfankuiFname())) {
            this.fUj = true;
        }
        boY();
        try {
            this.fUX = bpv();
        } catch (Throwable th) {
            this.fUX = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.faq != null) {
                this.faq.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bpk().getText().toString()) || ((this.fUi || this.fUj) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.faq.setTitle(writeData.getTitle());
                    bpk().setText(this.faq.getTitle());
                    bpk().setSelection(this.faq.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.faq.setVideoInfo(videoInfo);
                    this.ard.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bpj().getText().toString()) || this.fUi || this.fUj) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.faq.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.CO().a(getPageContext().getPageActivity(), this.faq.getContent(), this.fVh);
                    bpj().setText(a2);
                    bpj().setSelection(a2.length());
                    if (this.fUU) {
                        b(this.fUR, this.fUL);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.faq.setWriteImagesInfo(this.writeImagesInfo);
                    bpt();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Cf();
                    }
                    lB(false);
                }
                if (TbadkCoreApplication.m10getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.faq.setIsBaobao(writeData.getIsBaobao());
                        this.faq.setBaobaoContent(writeData.getBaobaoContent());
                        this.faq.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.faq.getIsBaobao()) {
                        Ch();
                        lC(false);
                    }
                }
                if (this.fUw == null && writeData.getHiContent() != null) {
                    this.fUw = writeData.getHiContent();
                    this.faq.setHiContent(this.fUw);
                    bpu();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bpp();
                }
                bbv();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.cdr != null) {
                    this.fUG = this.fUE.bIj;
                    this.cdC = this.fUE.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.cdr.size()) {
                            break;
                        }
                        dc dcVar = this.cdr.get(i2);
                        if (categoryTo != dcVar.bIj) {
                            i = i2 + 1;
                        } else {
                            this.fUG = categoryTo;
                            this.cdC = dcVar.name;
                            this.faq.setCategoryTo(this.fUG);
                            break;
                        }
                    }
                    if (this.fUH != null) {
                        this.fUH.setText(this.cdC);
                        this.fUH.b(this.cdr, this.fUE, this.fUG);
                    }
                }
                this.faq.setGraffitiFileName(writeData.getGraffitiFileName());
                this.ard.b(new com.baidu.tbadk.editortools.a(42, 24, this.faq.getGraffitiFileName()));
                this.ard.zD();
                return;
            }
            return;
        }
        bpp();
    }

    private void bpp() {
        if ((!this.fUU || this.fUJ != null) && this.fUI != null) {
            this.fUJ.f(this.writeImagesInfo);
            bps();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.faq.getType());
        bundle.putString("forum_id", this.faq.getForumId());
        bundle.putString("forum_name", this.faq.getForumName());
        bundle.putString("thread_id", this.faq.getThreadId());
        bundle.putString("floor_id", this.faq.getFloor());
        bundle.putInt("floor_num", this.faq.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.fUt);
        if (this.fUi) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putSerializable("baobao_images", this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.TOGETHERHI_DATA, this.fUw);
        bundle.putBoolean(WriteActivityConfig.TOGETHERHI_SHOW, this.fUx);
        bundle.putString("photo_name", this.asX);
        bundle.putSerializable("addition_data", this.fUy);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.bcs);
        bundle.putString("from", this.aaf);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bpj().getEditableText().toString();
        if (editable != null) {
            bpj().setText(TbFaceManager.CO().a(getPageContext().getPageActivity(), editable, this.fVh));
            bpj().setSelection(bpj().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        bbm();
        String editable = bpk().getText().toString();
        this.faq.setContent(bpj().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.far != 0 && this.faq.getType() != 4) {
            this.faq.setTitle(String.valueOf(this.faP.getText().toString()) + editable);
        } else {
            this.faq.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.faq.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.faq.getTitle());
        }
        if (this.fUi || this.fUj) {
            String string = getResources().getString(u.j.android_feedback);
            if (TextUtils.isEmpty(this.faq.getTitle()) || !this.faq.getTitle().startsWith(string)) {
                this.faq.setTitle(string + this.faq.getTitle());
            }
            String str = String.valueOf(getResources().getString(u.j.app_name)) + getResources().getString(u.j.tieba_client);
            if (TextUtils.isEmpty(this.faq.getContent()) || !this.faq.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.fq()) {
                    sb.append(com.baidu.adp.lib.util.i.fy());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.faq.getContent());
                this.faq.setContent(sb.toString());
            }
        }
        if (this.fUF >= 0) {
            this.faq.setCategoryFrom(this.fUF);
        }
        if (this.fUG >= 0) {
            this.faq.setCategoryTo(this.fUG);
        }
        if (this.faq.getType() == 7 && this.dealInfoData != null) {
            this.faq.productId = this.dealInfoData.productId;
        }
        this.faq.setWriteImagesInfo(this.writeImagesInfo);
        this.faq.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.faq.setHiContent(this.fUw);
        this.faq.setHasLocationData(this.asY == null ? false : this.asY.bgo());
        this.asZ.kB(this.writeImagesInfo.size() > 0);
        this.asZ.d(this.faq);
        this.faq.setVcode(null);
        if (this.asV != null) {
            if (this.asV.getId() != null) {
                this.asZ.bbo().setVoice(this.asV.getId());
                this.asZ.bbo().setVoiceDuringTime(this.asV.duration);
            } else {
                this.asZ.bbo().setVoice(null);
                this.asZ.bbo().setVoiceDuringTime(-1);
            }
        } else {
            this.asZ.bbo().setVoice(null);
            this.asZ.bbo().setVoiceDuringTime(-1);
        }
        if (!this.asZ.bgP()) {
            showToast(u.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(u.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(u.j.sending), this.ezF);
            if (!this.asZ.bgM()) {
            }
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
            if (this.fUy != null) {
                i2 = this.fUy.getTotalCount();
                i = this.fUy.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(u.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.ard != null && !this.ard.Bo()) {
                    bpj().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> z = com.baidu.tieba.tbadkCore.util.l.z(intent);
                if (z != null && z.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < z.size()) {
                            sb.append("@");
                            sb.append(z.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            bpj().getText().insert(bpj().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.faq.getType() == 0) {
                    com.baidu.tieba.tbadkCore.af.b(this.faq.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.faq.getType() == 1) {
                    com.baidu.tieba.tbadkCore.af.c(this.faq.getThreadId(), (WriteData) null);
                } else if (this.faq.getType() == 4) {
                    com.baidu.tieba.tbadkCore.af.b(String.valueOf(this.faq.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                } else if (this.faq.getType() == 7) {
                    com.baidu.tieba.tbadkCore.af.b(this.faq.getForumId(), (WriteData) null);
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
                                aTe();
                            } else {
                                F(intent);
                            }
                        } else if (intExtra == 1) {
                            y(intent);
                        } else {
                            E(intent);
                            com.baidu.adp.lib.h.h.dL().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fUU) {
                        d(intent);
                        bbv();
                        return;
                    }
                    H(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.faq.setVideoInfo(videoInfo);
                        this.ard.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ard.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ard.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bbv();
                } else if (i == 12013) {
                    e(intent);
                    bbv();
                } else if (i == 12016) {
                    J(intent);
                    bbv();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.o(intent);
                }
            }
        } else if (i2 == 0) {
            if (this.ard != null && !this.ard.Bo()) {
                this.faN.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    BY();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bpr();
                    return;
                case 12003:
                case 12004:
                case 12005:
                case 12006:
                case 12007:
                case 12008:
                case 12009:
                case 12011:
                default:
                    return;
                case 12010:
                    this.asX = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.au.b(getPageContext(), this.asX);
                    return;
                case 12012:
                    bpr();
                    return;
            }
        }
    }

    private void bpq() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bpr() {
        if (this.fUU) {
            this.fUJ.f(this.writeImagesInfo);
            bps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bps() {
        this.fUJ.notifyDataSetChanged();
        this.fUI.invalidate();
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
        bbv();
    }

    private void E(Intent intent) {
        if (this.fUU) {
            H(intent);
            bpr();
        } else {
            I(intent);
        }
        bbv();
    }

    private void H(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bpr();
            lB(true);
        }
    }

    private void F(Intent intent) {
        if (this.writeImagesInfo != null) {
            c(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aTe() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eIR.parseJson(stringExtra);
            this.eIR.updateQuality();
            if (this.eIR.getChosedFiles() != null && this.eIR.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eIR.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eIR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bpk());
        HidenSoftKeyPad(this.mInputManager, bpj());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void I(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.asX = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.asX, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bpt();
            Cf();
        }
        lB(true);
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
                bpt();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Cf();
                }
            }
            lB(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpt() {
        if (this.ard.el(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void J(Intent intent) {
        if (this.faq != null) {
            this.fUw = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.faq.setHiContent(this.fUw);
            bpu();
        }
    }

    private void e(Intent intent) {
        if (this.faq != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.faq.setIsBaobao(true);
            this.faq.setBaobaoContent(stringExtra2);
            Ch();
            lC(true);
        }
    }

    private void BY() {
        new bb(this).execute(new Void[0]);
    }

    private void lB(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void lC(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bEE == null) {
            this.bEE = VoiceManager.instance();
        }
        return this.bEE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void VR() {
        this.bEE = getVoiceManager();
        this.bEE.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rg(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(u.j.error_write);
                }
                showToast(errorString2);
            } else if (this.fUy == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ath = i;
        if (this.ard != null) {
            this.ard.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.ard.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Cf() {
        if (!this.fUU && this.ard != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.ard.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.ard.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ard.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ard.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Ch() {
        if (this.ard != null) {
            this.ard.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.ard.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.ard.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    private void bpu() {
        if (this.ard != null) {
            if (this.fUw != null) {
                this.ard.b(new com.baidu.tbadk.editortools.a(44, 27, this.fUw));
                this.ard.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
                return;
            }
            this.ard.b(new com.baidu.tbadk.editortools.a(45, 27, this.fUw));
            this.ard.b(new com.baidu.tbadk.editortools.a(2, 26, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (this.ard != null) {
            this.ard.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void sM(int i) {
        if (i < this.fTk.size()) {
            for (int i2 = 0; i2 < this.fTk.size(); i2++) {
                this.fTk.get(i2).lp(false);
            }
            this.fTk.get(i).lp(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void qB(int i) {
        this.far = i;
        this.faQ.ss(i);
        sM(i);
        this.faP.setText(this.mPrefixData.getPrefixs().get(i));
        bbv();
        com.baidu.adp.lib.h.j.a(this.faQ, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.faS.setSelected(false);
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
        if (this.faq != null) {
            if (this.faq.getType() == 4) {
                return "a015";
            }
            if (this.faq.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            BT();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.Q(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.b(getPageContext(), this.asX);
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fUW != null) {
            this.fUW.onKeyboardVisibilityChanged(z);
        }
        if (this.fVe && System.currentTimeMillis() - this.fVf < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fVe = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fVa != null) {
            rL(str);
            this.fVa.dismiss();
        }
    }

    private void aZ(Context context) {
        fVc = com.baidu.adp.lib.util.k.A(context);
        fVd = com.baidu.adp.lib.util.k.B(context);
    }

    private void rL(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(u.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fVe = true;
        bpt();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Cf();
        }
        lB(true);
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

    private File bpv() {
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

    private void bpw() {
        if (this.fUX != null && this.faq.getType() == 0) {
            aZ(getActivity());
            this.fUZ = getPageContext().getPageActivity().getLayoutInflater().inflate(u.h.rec_dialog, (ViewGroup) null);
            this.fUZ.setOnClickListener(new bc(this));
            this.fUY = (TbImageView) this.fUZ.findViewById(u.g.rec_img_view);
            this.fVb = (LinearLayout) this.fUZ.findViewById(u.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.sN().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fUX.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.sN().putString("write_rec_pic_path", this.fUX.getAbsolutePath());
                Bitmap d = d(this.fUX.getAbsolutePath(), getResources().getDimensionPixelSize(u.e.ds160));
                if (d != null) {
                    this.fUY.setImageBitmap(d);
                    this.fUY.setDrawBorder(true);
                    this.fUY.setBorderWidth(2);
                    this.fUY.setBorderColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10264));
                    this.fVa = new Dialog(getActivity(), u.k.bubble_dialog);
                    this.fVa.setCanceledOnTouchOutside(true);
                    this.fVa.setOnDismissListener(new be(this));
                    this.fVa.setContentView(this.fUZ);
                    this.fVa.show();
                    Window window = this.fVa.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(u.e.ds28);
                    attributes.y = (fVd / 18) + getResources().getDimensionPixelSize(u.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(u.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(u.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(u.a.activity_open_from_bottom, u.a.activity_close_from_top);
    }
}
