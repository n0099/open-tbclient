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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
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
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.t;
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
    private static int gfh = 0;
    private static int gfi = 0;
    private String acU;
    private com.baidu.tbadk.editortools.l auk;
    private VoiceData.VoiceModel awc;
    private String awe;
    private com.baidu.tieba.tbadkCore.location.d awf;
    private com.baidu.tieba.tbadkCore.writeModel.b awg;
    private VoiceManager bQi;
    List<cy> coE;
    private String coP;
    private DealInfoData dealInfoData;
    private int fiF;
    private TextView fjd;
    private com.baidu.tieba.write.b fje;
    private ImageView fjf;
    private View fjg;
    private Toast geA;
    private String geB;
    private AdditionData geD;
    private RelativeLayout geE;
    private TextView geF;
    private TextView geG;
    private TextView geH;
    private ViewGroup geI;
    cy geJ;
    private int geK;
    private int geL;
    private PostCategoryView geM;
    private LinearLayout geq;
    private View get;
    private View geu;
    private com.baidu.tieba.view.c gfr;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData fiE = null;
    private boolean gem = false;
    private boolean gen = false;
    private boolean gep = false;
    private InputMethodManager mInputManager = null;
    private EditText fiX = null;
    private HeadImageView gct = null;
    private View fiY = null;
    private LinearLayout fja = null;
    private EditText fjb = null;
    private p ger = null;
    private FeedBackTopListView ges = null;
    private ArrayList<com.baidu.tieba.write.a> gdp = new ArrayList<>();
    private String dNj = null;
    private final KeyEvent gev = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View ajw = null;
    private TextView gew = null;
    private TextView fjc = null;
    private TextView cTS = null;
    private DialogInterface.OnCancelListener eGh = null;
    private com.baidu.tbadk.core.dialog.a gex = null;
    private final Handler mHandler = new Handler();
    private boolean gey = false;
    private String gez = null;
    private RelativeLayout cSU = null;
    private String awm = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean geC = false;
    private int awo = 0;
    private int bnO = 0;
    private WriteImagesInfo eQb = new WriteImagesInfo();
    private View mRootView = null;
    private GridView geN = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a geO = null;
    private ScrollView geP = null;
    private EditText geQ = null;
    private View geR = null;
    private View geS = null;
    private View geT = null;
    private EditText geU = null;
    private TextView geV = null;
    private TextView geW = null;
    private TextWatcher geX = null;
    private TextWatcher geY = null;
    private boolean geZ = false;
    private boolean gfa = false;
    private com.baidu.tbadk.core.view.a aEw = null;
    private bl gfb = null;
    private File gfc = null;
    private TbImageView gfd = null;
    private View gfe = null;
    private Dialog gff = null;
    private LinearLayout gfg = null;
    private boolean gfj = false;
    private long gfk = -1000;
    private final HttpMessageListener gfl = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a gfm = new ag(this);
    private final b.d aww = new as(this);
    private final d.a awu = new bd(this);
    private final CustomMessageListener fuH = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener gfn = new bg(this);
    private boolean gfo = true;
    private final View.OnFocusChangeListener fiV = new bh(this);
    private final CustomMessageListener gfp = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private TextWatcher gfq = new bj(this);
    private final a.InterfaceC0074a etZ = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if ("from_add_photo_live_in_misson".equals(this.acU)) {
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
            showToast(t.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dp();
        } else if (this.awf.bjN()) {
            Dn();
        } else {
            this.awf.kL(false);
            b(1, true, null);
            this.awf.bjL();
        }
    }

    private void Dp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(t.j.location_app_permission_prompt).a(t.j.isopen, new x(this)).b(t.j.cancel, new y(this)).b(getPageContext());
        aVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bth() {
        int selectionEnd = bty().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bty().getText().getSpans(0, bty().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bty().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bty().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.auk != null) {
            this.auk.setBarLauncherEnabled(!this.gfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.geZ) {
            this.fiX.setVisibility(8);
            if (this.fiE.getType() == 5) {
                this.geT.setVisibility(8);
            } else {
                this.geT.setVisibility(0);
            }
            b(this.geW, this.geQ);
            b(this.geV, this.geU);
            bfa();
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
        btr();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.gfp.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.gfp);
        this.awf = new com.baidu.tieba.tbadkCore.location.d(this);
        this.awf.a(this.awu);
        registerListener(this.fuH);
        initEditor();
        btL();
        if (this.geZ) {
            this.geO.setEditorTools(this.auk);
        } else {
            this.fiX.requestFocus();
        }
    }

    private void initEditor() {
        com.baidu.tbadk.editortools.s ex;
        com.baidu.tbadk.editortools.aa ez;
        this.auk = new com.baidu.tbadk.editortools.l(getActivity());
        this.auk.setBarMaxLauCount(5);
        this.auk.setMoreButtonAtEnd(true);
        this.auk.setBarLauncherType(1);
        this.auk.bA(true);
        this.auk.bz(true);
        this.auk.setMoreLauncherIcon(t.f.write_more);
        this.auk.setBackgroundColorId(t.d.cp_bg_line_d);
        this.auk.setCanshowTogetherhi(Boolean.valueOf(this.geC));
        switch (this.fiE.getType()) {
            case 4:
            case 5:
                btk();
                break;
            default:
                btl();
                break;
        }
        this.auk.CH();
        if (this.geq != null) {
            this.geq.addView(this.auk);
        }
        btm();
        this.auk.lw();
        com.baidu.tbadk.editortools.s ex2 = this.auk.ex(6);
        if (ex2 != null && !TextUtils.isEmpty(this.awm)) {
            ((View) ex2).setOnClickListener(new z(this));
        }
        if (!this.geZ) {
            this.auk.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.auk.AS();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("xiaoying_has_click", false)) {
            this.auk.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        Dv();
        this.gfb = new bl(this, this.auk);
        if (this.geB != null && (ex = this.auk.ex(26)) != null && (ex instanceof View) && (ez = this.auk.ez(27)) != null && ez.aue != null && (ez.aue instanceof View)) {
            getWindow().setSoftInputMode(18);
            ((View) ez.aue).post(new aa(this, (View) ex));
        }
    }

    private void Dv() {
        if (this.auk != null) {
            this.auk.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.auk.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void Vx() {
        this.geR = this.mRootView.findViewById(t.g.photo_live_scroll);
        this.geT = this.geR.findViewById(t.g.live_post_title_container);
        this.geQ = (EditText) this.geR.findViewById(t.g.live_post_content);
        this.geN = (GridView) this.geR.findViewById(t.g.photoLiveGridView);
        this.geU = (EditText) this.geR.findViewById(t.g.live_post_title);
        this.geV = (TextView) this.geR.findViewById(t.g.titleOverPlusNumber);
        this.geW = (TextView) this.geR.findViewById(t.g.contentOverPlusNumber);
        this.geS = this.geR.findViewById(t.g.live_interval_view);
        this.geV.setText(String.valueOf(20));
        this.geW.setText(String.valueOf(233));
        this.geR.setVisibility(0);
        this.geV.setVisibility(0);
        this.geW.setVisibility(0);
        this.geU.setHint(t.j.tips_title_limit_new);
        this.geU.setOnFocusChangeListener(new ab(this));
        if (this.fiE.getType() == 4) {
            this.geQ.setHint(t.j.live_write_input_content_new);
        } else if (this.fiE.getType() == 5) {
            this.geQ.setHint(t.j.live_write_input_content_update);
        }
        this.geQ.setOnFocusChangeListener(new ac(this));
        this.geQ.requestFocus();
        this.geQ.addTextChangedListener(aUV());
        this.geU.requestFocus();
        this.geU.addTextChangedListener(aUV());
        this.geU.setOnClickListener(this.gfn);
        this.geQ.setOnClickListener(this.gfn);
        this.geO = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.geN);
        this.geO.td(6);
        this.geN.setAdapter((ListAdapter) this.geO);
        View findViewById = this.geR.findViewById(t.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ad(this));
        btj();
    }

    private void btj() {
        if (this.fiE.getType() == 0) {
            if (this.fiE.getTitle() != null) {
                this.geU.setText(this.fiE.getTitle());
                this.geU.setSelection(this.fiE.getTitle().length());
            }
        } else if (this.fiE.getType() != 1) {
            this.fiE.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.geZ) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            btF();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            DA();
            return;
        }
        if (this.auk.CJ()) {
            this.auk.AS();
        }
        String str = null;
        if (this.fiE != null) {
            str = this.fiE.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.geZ) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void btk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.auk.y(arrayList);
        com.baidu.tbadk.editortools.aa ez = this.auk.ez(5);
        if (ez != null) {
            ez.auZ = 2;
            ez.auX = t.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.auX = t.f.write_at;
        this.auk.b(aVar);
        this.auk.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void btl() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.auX = t.f.write_picture;
        this.auk.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.auk.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 != null && (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) != null) {
            aaVar5.avb = true;
            aaVar5.auX = t.f.write_graffiti;
            aaVar5.auZ = 3;
            this.auk.b(aaVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 != null && (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) != null) {
            aaVar4.auZ = 4;
            aaVar4.auX = t.f.write_privilege;
            this.auk.b(aaVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 6);
        aVar.auX = t.f.write_at;
        this.auk.b(aVar);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.avb = true;
            aaVar3.auZ = 8;
            aaVar3.auX = 0;
            this.auk.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.avb = true;
            aaVar2.auZ = 9;
            aaVar2.auX = 0;
            this.auk.b(aaVar2);
        }
        Boolean btD = btD();
        if (!this.gem && btD != null && btD.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bkm() && com.baidu.tieba.tbadkCore.u.a(this.fiE.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.auZ = 5;
            aaVar.auX = t.f.write_recorder;
            this.auk.b(aaVar);
        }
        if (this.fiE != null && this.fiE.getType() == 0 && !this.gem && !this.gen) {
            arrayList.add(13);
            arrayList.add(14);
            arrayList.add(26);
            arrayList.add(27);
        }
        if (this.geD == null) {
            this.auk.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.auk.y(arrayList);
        com.baidu.tbadk.editortools.aa ez = this.auk.ez(5);
        if (ez != null) {
            ez.auZ = 1;
            ez.auX = t.f.write_emotion;
        }
        com.baidu.tbadk.editortools.aa ez2 = this.auk.ez(13);
        if (ez2 != null) {
            ez2.auZ = 7;
        }
    }

    private void btm() {
        ae aeVar = new ae(this);
        this.auk.a(16, aeVar);
        this.auk.a(21, aeVar);
        this.auk.a(43, aeVar);
        this.auk.a(45, aeVar);
        this.auk.a(14, aeVar);
        this.auk.a(24, aeVar);
        this.auk.a(3, aeVar);
        this.auk.a(10, aeVar);
        this.auk.a(11, aeVar);
        this.auk.a(12, aeVar);
        this.auk.a(13, aeVar);
        this.auk.a(22, aeVar);
        this.auk.a(23, aeVar);
        this.auk.a(15, aeVar);
        this.auk.a(18, aeVar);
        this.auk.a(25, aeVar);
        this.auk.a(27, aeVar);
        this.auk.a(29, aeVar);
        this.auk.a(40, aeVar);
    }

    public void ama() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        if (this.awf.bjP()) {
            if (this.awf.bjN()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bjJ().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.awf.bjL();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beR() {
        if (this.awg != null) {
            this.awg.cancelLoadData();
        }
        if (this.ger != null) {
            this.ger.cancelLoadData();
        }
        if (this.awf != null) {
            this.awf.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        beR();
        btC();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        if (this.fiE != null && this.fiE.getType() == 2 && this.gey) {
            finish();
        } else if (this.fiE == null) {
            finish();
        } else {
            this.fiE.setTitle(btz().getText().toString());
            this.fiE.setContent(bty().getText().toString());
            int type = this.fiE.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.ae.b(this.fiE.getForumId(), this.fiE);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ae.c(this.fiE.getThreadId(), this.fiE);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.fiE.getForumId()) + "photolive", this.fiE);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.fiE.getThreadId()) + "updatephotolive", this.fiE);
            } else if (type == 7) {
                com.baidu.tieba.tbadkCore.ae.b(this.fiE.getForumId(), this.fiE);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fje != null && this.fje.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.fje, getPageContext().getPageActivity());
                return true;
            } else if (this.auk.CJ()) {
                this.auk.AS();
                return true;
            } else {
                beR();
                bsG();
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
        getLayoutMode().x(this.cSU);
        getLayoutMode().x(this.gfg);
        if (this.gfd != null && i == 1) {
            this.gfd.setBorderColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.av.c(this.fjc, t.d.cp_link_tip_a, 1);
        bti();
        com.baidu.tbadk.core.util.av.l(this.geR, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.fiY, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.geS, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(btz(), t.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dNj)) {
            com.baidu.tbadk.core.util.av.l(bty(), t.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_e);
        btz().setTextColor(color);
        bty().setTextColor(color);
        a(btz(), color2);
        a(bty(), color2);
        bfa();
        this.auk.onChangeSkinType(i);
        if (this.geM != null) {
            this.geM.wq();
        }
        com.baidu.tbadk.core.util.av.j((View) this.cTS, t.d.cp_cont_f);
        if (this.geI != null) {
            com.baidu.tbadk.j.a.a(getPageContext(), this.geI);
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
        this.aEw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.geZ = this.fiE.getType() == 4 || 5 == this.fiE.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(t.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajw.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.e(getActivity(), t.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ajw != null && (this.ajw.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ajw.getLayoutParams();
            layoutParams2.width = -2;
            this.ajw.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(t.f.icon_nav_close_selector, t.f.icon_nav_close_selector);
        this.cTS = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.av.j((View) this.cTS, t.d.cp_cont_f);
        this.gew = (TextView) findViewById(t.g.btn_image_problem);
        this.fjc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fjc.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds10);
        this.fjc.setLayoutParams(layoutParams3);
        this.fjc.setOnFocusChangeListener(this.fiV);
        this.geP = (ScrollView) findViewById(t.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ges = (FeedBackTopListView) findViewById(t.g.feedback_top_list);
        this.get = findViewById(t.g.feedback_divider);
        this.cSU = (RelativeLayout) findViewById(t.g.parent);
        this.geq = (LinearLayout) findViewById(t.g.tool_view);
        this.geq.setContentDescription("..");
        this.fiY = findViewById(t.g.interval_view);
        beZ();
        if (this.geZ) {
            this.geP.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            Vx();
        }
        if (this.fiE.getType() == 7) {
            this.geI = (ViewGroup) ((ViewStub) findViewById(t.g.ecomm_card)).inflate();
            ((EcommCardView) this.geI.findViewById(t.g.ecomm_card_root)).setData(this.dealInfoData);
        }
        bfb();
        if (this.gem || this.gen) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acv) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(t.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(t.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fja = (LinearLayout) findViewById(t.g.post_content_container);
        this.fja.setDrawingCacheEnabled(false);
        this.fja.setOnClickListener(new af(this));
        this.ajw.setOnFocusChangeListener(this.fiV);
        this.ajw.setOnClickListener(new ah(this));
        this.gew.setOnClickListener(new ai(this));
        bto();
        k(btD());
        bts();
        ama();
        switch (this.fiE.getType()) {
            case 0:
                if (this.gem || this.gen) {
                    if (this.gep) {
                        this.cTS.setText(t.j.feedback_vcode);
                    } else {
                        this.cTS.setText(t.j.feedback);
                    }
                } else {
                    this.cTS.setText(t.j.post_new_thread);
                }
                this.fiX.setVisibility(0);
                this.fjb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.cTS.setText(t.j.send_reply);
                this.fjb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fiX.setVisibility(8);
                break;
            case 4:
                this.cTS.setText(t.j.publish_photo_live);
                this.fjb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cTS.setText(getPageContext().getResources().getString(t.j.update_photo_live_tip, Integer.valueOf(this.fiE.getFloorNum() + 1)));
                this.geS.setVisibility(8);
                break;
            case 7:
                this.fiX.setVisibility(0);
                this.fjb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
        }
        btt();
        btB();
        bti();
        btq();
        beY();
        if (this.fiE.getType() == 4 && this.fjg != null && this.geu != null) {
            this.fjg.setVisibility(8);
            this.geu.setVisibility(8);
        }
        bfa();
        ShowSoftKeyPad(this.mInputManager, this.fiX);
        btp();
    }

    private void btn() {
        this.coE = null;
        this.geK = -1;
        this.geL = -1;
        da hV = cz.acl().hV(1);
        if (hV != null) {
            this.coE = hV.bTt;
            this.geK = getIntent().getIntExtra("category_id", -1);
            if (this.coE != null && !this.coE.isEmpty() && this.geK >= 0) {
                this.geJ = new cy();
                this.geJ.bTp = 0;
                this.geJ.name = getPageContext().getResources().getString(t.j.category_auto);
                this.geL = this.geJ.bTp;
                this.coP = this.geJ.name;
                for (cy cyVar : this.coE) {
                    if (cyVar.bTp == this.geK) {
                        this.geL = cyVar.bTp;
                        this.coP = cyVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bto() {
        if (this.coE != null && !this.coE.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(t.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(t.g.interval_view_cate).setVisibility(0);
            this.geM = (PostCategoryView) linearLayout.findViewById(t.g.category_selected);
            this.geM.setText(this.coP);
            this.geM.b(this.coE, this.geJ, this.geL);
            this.geM.setCategoryContainerClickCallback(new aj(this));
            linearLayout.setOnClickListener(new ak(this));
        }
    }

    private void btp() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gfr = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.gfr.setTitle(t.j.no_disturb_start_time);
        this.gfr.setButton(-1, getPageContext().getString(t.j.alert_yes_button), this.gfr);
        this.gfr.setButton(-2, getPageContext().getString(t.j.alert_no_button), this.gfr);
        return this.gfr;
    }

    private void btq() {
        this.geE = (RelativeLayout) findViewById(t.g.addition_container);
        this.geF = (TextView) findViewById(t.g.addition_create_time);
        this.geG = (TextView) findViewById(t.g.addition_last_time);
        this.geH = (TextView) findViewById(t.g.addition_last_content);
        if (this.geD != null) {
            this.geE.setVisibility(0);
            this.geF.setText(String.valueOf(getPageContext().getString(t.j.write_addition_create)) + com.baidu.tbadk.core.util.ba.t(this.geD.getCreateTime() * 1000));
            if (this.geD.getAlreadyCount() == 0) {
                this.geG.setVisibility(8);
            } else {
                this.geG.setText(String.valueOf(getPageContext().getString(t.j.write_addition_last)) + com.baidu.tbadk.core.util.ba.t(this.geD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.geD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.geH.setText(lastAdditionContent);
            } else {
                this.geH.setVisibility(8);
            }
            bty().setHint(String.format(getPageContext().getString(t.j.write_addition_hint), Integer.valueOf(this.geD.getAlreadyCount()), Integer.valueOf(this.geD.getTotalCount())));
            this.cTS.setText(t.j.write_addition_title);
            return;
        }
        this.geE.setVisibility(8);
    }

    private void beY() {
        this.fjg = findViewById(t.g.post_prefix_layout);
        this.fjd = (TextView) findViewById(t.g.post_prefix);
        this.geu = findViewById(t.g.prefix_divider);
        this.fjf = (ImageView) findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fjg.setVisibility(0);
            this.geu.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fiF = 1;
            this.fjg.setOnClickListener(new am(this));
            this.fjf = (ImageView) findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.fjf.setVisibility(0);
                this.fjd.setOnClickListener(new an(this));
            }
            this.fje = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fje.a(this);
            this.fje.setMaxHeight(com.baidu.adp.lib.util.k.e(getActivity(), t.e.ds510));
            this.fje.setOutsideTouchable(true);
            this.fje.setFocusable(true);
            this.fje.setOnDismissListener(this);
            this.fje.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(t.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.k(this.fjd, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.fjf, t.f.icon_title_down);
            this.fjd.setTextColor(color);
            this.gdp.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.gdp.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fje.addView(aVar);
            }
            this.fje.sT(0);
            this.fjd.setText(prefixs.get(1));
            tn(1);
            return;
        }
        this.fjg.setVisibility(8);
    }

    private void btr() {
        if (this.gem && this.fiE != null) {
            this.ges.setVisibility(0);
            this.get.setVisibility(0);
            this.ger = new p(this);
            this.ger.st(this.fiE.getForumName());
            this.ger.setLoadDataCallBack(new ao(this));
        }
    }

    protected void bts() {
        this.fjc.setOnClickListener(new ap(this));
    }

    protected void btt() {
        this.gex = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gex.cB(getPageContext().getString(t.j.is_save_draft)).aq(false).a(getPageContext().getString(t.j.save), new aq(this)).b(getPageContext().getString(t.j.not_save), new at(this));
        this.gex.b(getPageContext());
    }

    protected void beZ() {
        this.gct = (HeadImageView) findViewById(t.g.user_head_portrait);
        this.gct.setIsRound(true);
        this.gct.setDrawBorder(false);
        this.gct.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dk = com.baidu.tbadk.core.util.q.dk(currentPortrait);
            this.gct.setUrl(dk);
            this.gct.c(dk, 12, false);
        }
        this.fiX = (EditText) findViewById(t.g.post_title);
        this.fiX.setOnClickListener(this.gfn);
        this.fiX.setOnFocusChangeListener(this.fiV);
        if (this.fiE.getType() == 0) {
            if (this.fiE.getTitle() != null) {
                this.fiX.setText(this.fiE.getTitle());
                this.fiX.setSelection(this.fiE.getTitle().length());
            } else if (this.gep) {
                this.fiX.setText(getResources().getString(t.j.vcode_feed_back_title));
            }
        } else if (this.fiE.getType() != 1) {
            this.fiE.getType();
        }
        this.fiX.addTextChangedListener(this.gfq);
    }

    private TextWatcher aUV() {
        au auVar = new au(this);
        if (this.geZ && this.gfa) {
            if (this.geX != null) {
                this.geU.removeTextChangedListener(this.geX);
            }
            this.geX = auVar;
        } else if (this.geZ) {
            if (this.geY != null) {
                this.geQ.removeTextChangedListener(this.geY);
            }
            this.geY = auVar;
        }
        return auVar;
    }

    private long g(EditText editText) {
        if (editText == this.geQ) {
            return 233L;
        }
        if (editText != this.geU) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bfb() {
        this.fjb = (EditText) findViewById(t.g.post_content);
        this.fjb.setDrawingCacheEnabled(false);
        this.fjb.setOnClickListener(this.gfn);
        if (this.fiE.getContent() != null && this.fiE.getContent().length() > 0) {
            SpannableString z = TbFaceManager.Ej().z(getPageContext().getPageActivity(), this.fiE.getContent());
            this.fjb.setText(z);
            this.fjb.setSelection(z.length());
        } else if (this.fiE.getType() == 2) {
            if (this.gey) {
                if (this.gez != null && this.gez.length() > 0) {
                    this.fjb.setText(getPageContext().getPageActivity().getString(t.j.reply_sub_floor, new Object[]{this.gez}));
                    this.fjb.setSelection(this.fjb.getText().length());
                }
            } else if (this.fiE.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(t.j.reply_x_floor), Integer.valueOf(this.fiE.getFloorNum()));
                this.fjb.setText(format);
                this.fjb.setSelection(format.length());
            }
        }
        this.fjb.setOnFocusChangeListener(this.fiV);
        this.fjb.setOnTouchListener(new av(this));
        this.fjb.addTextChangedListener(this.gfq);
        lP(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.geZ) {
            bty().setPadding(0, 0, 0, 0);
            bty().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.av.l(bty(), t.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dNj) && this.geD == null) {
                com.baidu.adp.lib.g.c.eA().a(this.dNj, 19, new aw(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btu() {
        int i = 5000;
        if (this.geD != null) {
            i = 1000;
        }
        return bty().getText() != null && bty().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.auk != null) {
                this.auk.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.biq() && this.bnO == 0) {
            showToast(t.j.baobao_over_limit);
        } else {
            String charSequence = this.cTS.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra(VrPlayerActivityConfig.TITLE, charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btw() {
        this.geB = null;
        this.fiE.setHiContent(this.geB);
        btJ();
        bfa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btx() {
        if (this.geB != null) {
            if (this.auk != null) {
                this.auk.b(new com.baidu.tbadk.editortools.a(44, 27, this.geB));
                btJ();
                return;
            }
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_HI_STARTMATCHIMAGE, new IntentConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bty().getText().getSpans(0, bty().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.geA == null) {
                this.geA = Toast.makeText(getPageContext().getPageActivity(), t.j.too_many_face, 0);
            }
            this.geA.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xL = lVar.xL();
        if (name != null) {
            com.baidu.adp.lib.g.c.eA().a(name, 20, new ax(this, new SpannableStringBuilder(name), xL), 0, 0, getUniqueId(), null, name, false, null);
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
        bty().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bty() {
        return this.geZ ? this.geQ : this.fjb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText btz() {
        return this.geZ ? this.geU : this.fiX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btA() {
        bty().onKeyDown(67, this.gev);
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.fiE != null) {
            str = this.fiE.getForumName();
        }
        if (getPageContext().getString(t.j.feedback_bar_name).equals(str)) {
            this.gem = true;
        }
    }

    private void btB() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void btC() {
        try {
            if (this.gex != null) {
                this.gex.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aEw.c(null);
        this.aEw.cW(t.j.sending);
        this.aEw.aF(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aEw.aF(false);
    }

    private Boolean btD() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.awm = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfa() {
        if (this.fiE != null) {
            String editable = btz().getText().toString();
            String trim = bty().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.fiE.getType() == 0 || this.fiE.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fiF == 0) {
                        if (TextUtils.isEmpty(trim2)) {
                            this.fiE.setIsNoTitle(true);
                        } else {
                            this.fiE.setIsNoTitle(false);
                            lQ(true);
                            return;
                        }
                    } else {
                        this.fiE.setIsNoTitle(false);
                        lQ(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim2)) {
                    this.fiE.setIsNoTitle(true);
                } else {
                    this.fiE.setIsNoTitle(false);
                    lQ(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.geZ) {
                    lQ(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lQ(true);
                    return;
                }
            } else if (this.fiE.getType() == 4) {
                if (!i(this.geQ) || !h(this.geU)) {
                    r0 = false;
                }
                lQ(r0);
                return;
            } else if (this.fiE.getType() == 5) {
                lQ(i(this.geQ));
                return;
            } else if (!TextUtils.isEmpty(trim)) {
                lQ(true);
                return;
            } else if (this.awc != null) {
                lQ(true);
                return;
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                lQ(true);
                return;
            } else if (this.geB != null) {
                lQ(true);
                return;
            }
            if (this.fiE.getVideoInfo() != null) {
                lQ(true);
            } else if (this.fiE.getGraffitiFileName() != null) {
                lQ(true);
            } else {
                lQ(false);
            }
        }
    }

    private void lQ(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.av.c(this.fjc, t.d.cp_link_tip_a, 1);
            this.fjc.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.av.c(this.fjc, t.d.cp_cont_d, 1);
        this.fjc.setEnabled(false);
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
        this.awg = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        this.awg.b(this.aww);
        registerListener(this.gfl);
        this.eGh = new ay(this);
        this.fiE = new WriteData();
        if (bundle != null) {
            this.fiE.setType(bundle.getInt("type", 0));
            this.fiE.setForumId(bundle.getString("forum_id"));
            this.fiE.setForumName(bundle.getString("forum_name"));
            this.fiE.setThreadId(bundle.getString("thread_id"));
            this.fiE.setFloor(bundle.getString("floor_id"));
            this.fiE.setFloorNum(bundle.getInt("floor_num", 0));
            this.gem = bundle.getBoolean("feed_back", false);
            this.gep = bundle.getBoolean("vcode_feed_back", false);
            this.gey = bundle.getBoolean("reply_sub_pb", false);
            this.gez = bundle.getString("sub_user_name");
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.geB = bundle.getString(WriteActivityConfig.TOGETHERHI_DATA);
            this.geC = bundle.getBoolean(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.awe = bundle.getString("photo_name");
            this.geD = (AdditionData) bundle.getSerializable("addition_data");
            this.fiE.setIsAddition(this.geD != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.bnO = bundle.getInt("mem_type", 0);
            this.acU = bundle.getString("from");
            this.fiE.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.fiE.setContent(bundle.getString(WriteActivityConfig.CONTENT));
        } else {
            Intent intent = getIntent();
            this.fiE.setType(intent.getIntExtra("type", 0));
            this.fiE.setForumId(intent.getStringExtra("forum_id"));
            this.fiE.setForumName(intent.getStringExtra("forum_name"));
            this.fiE.setThreadId(intent.getStringExtra("thread_id"));
            this.fiE.setFloor(intent.getStringExtra("floor_id"));
            this.fiE.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gem = intent.getBooleanExtra("feed_back", false);
            this.gep = intent.getBooleanExtra("vcode_feed_back", false);
            this.gey = intent.getBooleanExtra("reply_sub_pb", false);
            this.gez = intent.getStringExtra("sub_user_name");
            this.geD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.fiE.setIsAddition(this.geD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.bnO = intent.getIntExtra("mem_type", 0);
            this.acU = intent.getStringExtra("from");
            this.geB = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.geC = intent.getBooleanExtra(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.fiE.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.fiE.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.fiE.getType() == 4 ? 6 : 10);
        this.fiE.setWriteImagesInfo(this.writeImagesInfo);
        this.fiE.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.fiE.setHiContent(this.geB);
        if (this.fiE.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.ae.c(this.fiE.getForumId(), this);
            }
        } else if (this.fiE.getType() == 1) {
            com.baidu.tieba.tbadkCore.ae.a(this.fiE.getThreadId(), this);
        } else if (this.fiE.getType() == 4) {
            com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.fiE.getForumId()) + "photolive", this);
        } else if (this.fiE.getType() == 5) {
            com.baidu.tieba.tbadkCore.ae.a(String.valueOf(this.fiE.getThreadId()) + "updatephotolive", this);
        } else if (this.fiE.getType() == 7) {
            com.baidu.tieba.tbadkCore.ae.c(this.fiE.getForumId(), this);
            this.dealInfoData = (DealInfoData) getIntent().getSerializableExtra("deal_info");
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
        }
        this.dNj = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.fiE != null && this.fiE.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.fiE.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.gen = true;
        }
        btn();
        try {
            this.gfc = btK();
        } catch (Throwable th) {
            this.gfc = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.fiE != null) {
                this.fiE.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(btz().getText().toString()) || ((this.gem || this.gen) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.fiE.setTitle(writeData.getTitle());
                    btz().setText(this.fiE.getTitle());
                    btz().setSelection(this.fiE.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.fiE.setVideoInfo(videoInfo);
                    this.auk.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bty().getText().toString()) || this.gem || this.gen) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.fiE.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ej().a(getPageContext().getPageActivity(), this.fiE.getContent(), this.gfm);
                    bty().setText(a2);
                    bty().setSelection(a2.length());
                    if (this.geZ) {
                        b(this.geW, this.geQ);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.fiE.setWriteImagesInfo(this.writeImagesInfo);
                    btI();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DA();
                    }
                    lR(false);
                }
                if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.fiE.setIsBaobao(writeData.getIsBaobao());
                        this.fiE.setBaobaoContent(writeData.getBaobaoContent());
                        this.fiE.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.fiE.getIsBaobao()) {
                        DC();
                        lS(false);
                    }
                }
                if (this.geB == null && writeData.getHiContent() != null) {
                    this.geB = writeData.getHiContent();
                    this.fiE.setHiContent(this.geB);
                    btJ();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    btE();
                }
                bfa();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.coE != null) {
                    this.geL = this.geJ.bTp;
                    this.coP = this.geJ.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.coE.size()) {
                            break;
                        }
                        cy cyVar = this.coE.get(i2);
                        if (categoryTo != cyVar.bTp) {
                            i = i2 + 1;
                        } else {
                            this.geL = categoryTo;
                            this.coP = cyVar.name;
                            this.fiE.setCategoryTo(this.geL);
                            break;
                        }
                    }
                    if (this.geM != null) {
                        this.geM.setText(this.coP);
                        this.geM.b(this.coE, this.geJ, this.geL);
                    }
                }
                this.fiE.setGraffitiFileName(writeData.getGraffitiFileName());
                this.auk.b(new com.baidu.tbadk.editortools.a(42, 24, this.fiE.getGraffitiFileName()));
                this.auk.AS();
                return;
            }
            return;
        }
        btE();
    }

    private void btE() {
        if ((!this.geZ || this.geO != null) && this.geN != null) {
            this.geO.f(this.writeImagesInfo);
            btH();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.fiE.getType());
        bundle.putString("forum_id", this.fiE.getForumId());
        bundle.putString("forum_name", this.fiE.getForumName());
        bundle.putString("thread_id", this.fiE.getThreadId());
        bundle.putString("floor_id", this.fiE.getFloor());
        bundle.putInt("floor_num", this.fiE.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.gey);
        if (this.gem) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putSerializable("baobao_images", this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.TOGETHERHI_DATA, this.geB);
        bundle.putBoolean(WriteActivityConfig.TOGETHERHI_SHOW, this.geC);
        bundle.putString("photo_name", this.awe);
        bundle.putSerializable("addition_data", this.geD);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.bnO);
        bundle.putString("from", this.acU);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bty().getEditableText().toString();
        if (editable != null) {
            bty().setText(TbFaceManager.Ej().a(getPageContext().getPageActivity(), editable, this.gfm));
            bty().setSelection(bty().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsH() {
        beR();
        String editable = btz().getText().toString();
        this.fiE.setContent(bty().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fiF != 0 && this.fiE.getType() != 4) {
            this.fiE.setTitle(String.valueOf(this.fjd.getText().toString()) + editable);
        } else {
            this.fiE.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.fiE.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.fiE.getTitle());
        }
        if (this.gem || this.gen) {
            String string = getResources().getString(t.j.android_feedback);
            if (TextUtils.isEmpty(this.fiE.getTitle()) || !this.fiE.getTitle().startsWith(string)) {
                this.fiE.setTitle(string + this.fiE.getTitle());
            }
            String str = String.valueOf(getResources().getString(t.j.app_name)) + getResources().getString(t.j.tieba_client);
            if (TextUtils.isEmpty(this.fiE.getContent()) || !this.fiE.getContent().startsWith(str)) {
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
                sb.append(this.fiE.getContent());
                this.fiE.setContent(sb.toString());
            }
        }
        if (this.geK >= 0) {
            this.fiE.setCategoryFrom(this.geK);
        }
        if (this.geL >= 0) {
            this.fiE.setCategoryTo(this.geL);
        }
        if (this.fiE.getType() == 7 && this.dealInfoData != null) {
            this.fiE.productId = this.dealInfoData.productId;
        }
        this.fiE.setWriteImagesInfo(this.writeImagesInfo);
        this.fiE.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.fiE.setHiContent(this.geB);
        this.fiE.setHasLocationData(this.awf == null ? false : this.awf.bjP());
        this.awg.kN(this.writeImagesInfo.size() > 0);
        this.awg.d(this.fiE);
        this.fiE.setVcode(null);
        if (this.awc != null) {
            if (this.awc.getId() != null) {
                this.awg.beT().setVoice(this.awc.getId());
                this.awg.beT().setVoiceDuringTime(this.awc.duration);
            } else {
                this.awg.beT().setVoice(null);
                this.awg.beT().setVoiceDuringTime(-1);
            }
        } else {
            this.awg.beT().setVoice(null);
            this.awg.beT().setVoiceDuringTime(-1);
        }
        if (!this.awg.bkq()) {
            showToast(t.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(t.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.eGh);
            if (!this.awg.bkn()) {
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
            if (this.geD != null) {
                i2 = this.geD.getTotalCount();
                i = this.geD.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(t.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.auk != null && !this.auk.CJ()) {
                    bty().requestFocus();
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
                            bty().getText().insert(bty().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.fiE.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ae.b(this.fiE.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.fiE.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ae.c(this.fiE.getThreadId(), (WriteData) null);
                } else if (this.fiE.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.fiE.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                } else if (this.fiE.getType() == 7) {
                    com.baidu.tieba.tbadkCore.ae.b(this.fiE.getForumId(), (WriteData) null);
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
                                aWr();
                            } else {
                                F(intent);
                            }
                        } else if (intExtra == 1) {
                            y(intent);
                        } else {
                            E(intent);
                            com.baidu.adp.lib.h.h.eG().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.geZ) {
                        d(intent);
                        bfa();
                        return;
                    }
                    H(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.fiE.setVideoInfo(videoInfo);
                        this.auk.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.auk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.auk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bfa();
                } else if (i == 12013) {
                    e(intent);
                    bfa();
                } else if (i == 12016) {
                    J(intent);
                    bfa();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.o(intent);
                }
            }
        } else if (i2 == 0) {
            if (this.auk != null && !this.auk.CJ()) {
                this.fjb.requestFocus();
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
                    btG();
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
                    this.awe = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.au.b(getPageContext(), this.awe);
                    return;
                case 12012:
                    btG();
                    return;
            }
        }
    }

    private void btF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void btG() {
        if (this.geZ) {
            this.geO.f(this.writeImagesInfo);
            btH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        this.geO.notifyDataSetChanged();
        this.geN.invalidate();
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
        bfa();
    }

    private void E(Intent intent) {
        if (this.geZ) {
            H(intent);
            btG();
        } else {
            I(intent);
        }
        bfa();
    }

    private void H(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            btG();
            lR(true);
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

    private void aWr() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eQb.parseJson(stringExtra);
            this.eQb.updateQuality();
            if (this.eQb.getChosedFiles() != null && this.eQb.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eQb.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eQb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, btz());
        HidenSoftKeyPad(this.mInputManager, bty());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void I(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.awe = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.awe;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.awe, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            btI();
            DA();
        }
        lR(true);
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
                btI();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DA();
                }
            }
            lR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        if (this.auk.ez(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void J(Intent intent) {
        if (this.fiE != null) {
            this.geB = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.fiE.setHiContent(this.geB);
            btJ();
        }
    }

    private void e(Intent intent) {
        if (this.fiE != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.fiE.setIsBaobao(true);
            this.fiE.setBaobaoContent(stringExtra2);
            DC();
            lS(true);
        }
    }

    private void Dt() {
        new bb(this).execute(new Void[0]);
    }

    private void lR(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void lS(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bQi == null) {
            this.bQi = VoiceManager.instance();
        }
        return this.bQi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaO() {
        this.bQi = getVoiceManager();
        this.bQi.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rG(postWriteCallBackData.getErrorCode())) {
                AntiHelper.R(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString2);
            } else if (this.geD == null) {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.awo = i;
        if (this.auk != null) {
            this.auk.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.auk.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DA() {
        if (!this.geZ && this.auk != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.auk.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.auk.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.auk.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.auk.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void DC() {
        if (this.auk != null) {
            this.auk.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.auk.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.auk.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    private void btJ() {
        if (this.auk != null) {
            if (this.geB != null) {
                this.auk.b(new com.baidu.tbadk.editortools.a(44, 27, this.geB));
                this.auk.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
                return;
            }
            this.auk.b(new com.baidu.tbadk.editortools.a(45, 27, this.geB));
            this.auk.b(new com.baidu.tbadk.editortools.a(2, 26, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (this.auk != null) {
            this.auk.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tn(int i) {
        if (i < this.gdp.size()) {
            for (int i2 = 0; i2 < this.gdp.size(); i2++) {
                this.gdp.get(i2).lF(false);
            }
            this.gdp.get(i).lF(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rd(int i) {
        this.fiF = i;
        this.fje.sT(i);
        tn(i);
        this.fjd.setText(this.mPrefixData.getPrefixs().get(i));
        bfa();
        com.baidu.adp.lib.h.j.a(this.fje, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fjg.setSelected(false);
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
        if (this.fiE != null) {
            if (this.fiE.getType() == 4) {
                return "a015";
            }
            if (this.fiE.getType() == 5) {
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
                com.baidu.tbadk.core.util.au.b(getPageContext(), this.awe);
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.gfb != null) {
            this.gfb.onKeyboardVisibilityChanged(z);
        }
        if (this.gfj && System.currentTimeMillis() - this.gfk < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.gfj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.gff != null) {
            sv(str);
            this.gff.dismiss();
        }
    }

    private void bm(Context context) {
        gfh = com.baidu.adp.lib.util.k.K(context);
        gfi = com.baidu.adp.lib.util.k.L(context);
    }

    private void sv(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gfj = true;
        btI();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DA();
        }
        lR(true);
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

    private File btK() {
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

    private void btL() {
        if (this.gfc != null && this.fiE.getType() == 0) {
            bm(getActivity());
            this.gfe = getPageContext().getPageActivity().getLayoutInflater().inflate(t.h.rec_dialog, (ViewGroup) null);
            this.gfe.setOnClickListener(new bc(this));
            this.gfd = (TbImageView) this.gfe.findViewById(t.g.rec_img_view);
            this.gfg = (LinearLayout) this.gfe.findViewById(t.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.tS().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gfc.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.tS().putString("write_rec_pic_path", this.gfc.getAbsolutePath());
                Bitmap d = d(this.gfc.getAbsolutePath(), getResources().getDimensionPixelSize(t.e.ds160));
                if (d != null) {
                    this.gfd.setImageBitmap(d);
                    this.gfd.setDrawBorder(true);
                    this.gfd.setBorderWidth(2);
                    this.gfd.setBorderColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10264));
                    this.gff = new Dialog(getActivity(), t.k.bubble_dialog);
                    this.gff.setCanceledOnTouchOutside(true);
                    this.gff.setOnDismissListener(new be(this));
                    this.gff.setContentView(this.gfe);
                    this.gff.show();
                    Window window = this.gff.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(t.e.ds28);
                    attributes.y = (gfi / 18) + getResources().getDimensionPixelSize(t.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(t.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(t.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(t.a.activity_open_from_bottom, t.a.activity_close_from_top);
    }
}
