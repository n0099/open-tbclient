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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.frs.em;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.frs.eo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, ae.a, b.a {
    private static int fdR = 0;
    private static int fdS = 0;
    private String Zf;
    private com.baidu.tbadk.editortools.l apy;
    private VoiceData.VoiceModel arq;
    private String ars;
    private com.baidu.tieba.tbadkCore.location.d art;
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    List<em> bDN;
    private String bDY;
    private VoiceManager beZ;
    private int eZL;
    private TextView faj;
    private com.baidu.tieba.write.b fak;
    private ImageView fal;
    private View fam;
    private com.baidu.tieba.view.c fdZ;
    private LinearLayout fda;
    private View fdd;
    private View fde;
    private Toast fdk;
    private String fdl;
    private AdditionData fdn;
    private RelativeLayout fdo;
    private TextView fdp;
    private TextView fdq;
    private TextView fdr;
    em fdt;
    private int fdu;
    private int fdv;
    private PostCategoryView fdw;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData evE = null;
    private boolean fcX = false;
    private boolean fcY = false;
    private boolean fcZ = false;
    private InputMethodManager mInputManager = null;
    private EditText fad = null;
    private View fae = null;
    private LinearLayout fag = null;
    private EditText fah = null;
    private p fdb = null;
    private FeedBackTopListView fdc = null;
    private ArrayList<com.baidu.tieba.write.a> fbP = new ArrayList<>();
    private String cSm = null;
    private final KeyEvent fdf = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View afm = null;
    private TextView fdg = null;
    private TextView fai = null;
    private TextView cao = null;
    private DialogInterface.OnCancelListener dwy = null;
    private com.baidu.tbadk.core.dialog.a fdh = null;
    private final Handler mHandler = new Handler();
    private boolean fdi = false;
    private String fdj = null;
    private RelativeLayout bZp = null;
    private String arA = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean fdm = false;
    private int arC = 0;
    private int fds = 0;
    private WriteImagesInfo dOe = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fdx = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fdy = null;
    private ScrollView fdz = null;
    private EditText fdA = null;
    private View fdB = null;
    private View fdC = null;
    private View fdD = null;
    private EditText fdE = null;
    private TextView fdF = null;
    private TextView fdG = null;
    private TextWatcher fdH = null;
    private TextWatcher fdI = null;
    private boolean fdJ = false;
    private boolean fdK = false;
    private com.baidu.tbadk.core.view.b azH = null;
    private bp fdL = null;
    private File fdM = null;
    private TbImageView fdN = null;
    private View fdO = null;
    private Dialog fdP = null;
    private LinearLayout fdQ = null;
    private boolean fdT = false;
    private long fdU = -1000;
    private final HttpMessageListener fdV = new z(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d arK = new ak(this);
    private final d.a arI = new aw(this);
    private final CustomMessageListener euU = new bh(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fdW = new bj(this);
    private boolean fdX = true;
    private final View.OnFocusChangeListener fab = new bk(this);
    private final CustomMessageListener fdY = new bl(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0073a doS = new bm(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.Zf)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void BK() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(t.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m11getInst().getLocationShared()) {
            BL();
        } else if (this.art.aUJ()) {
            BJ();
        } else {
            this.art.jA(false);
            a(1, true, (String) null);
            this.art.aUH();
        }
    }

    private void BL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bL(t.j.location_app_permission_prompt).a(t.j.isopen, new bn(this)).b(t.j.cancel, new aa(this)).b(getPageContext());
        aVar.rV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdC() {
        int selectionEnd = bdU().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bdU().getText().getSpans(0, bdU().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bdU().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bdU().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdD() {
        if (this.apy != null) {
            this.apy.setBarLauncherEnabled(!this.fdX);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fdJ) {
            this.fad.setVisibility(8);
            if (this.evE.getType() == 5) {
                this.fdD.setVisibility(8);
            } else {
                this.fdD.setVisibility(0);
            }
            b(this.fdG, this.fdA);
            b(this.fdF, this.fdE);
            bcq();
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
        nq();
        bdN();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.fdY.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.fdY);
        this.art = new com.baidu.tieba.tbadkCore.location.d(this);
        this.art.a(this.arI);
        registerListener(this.euU);
        initEditor();
        beh();
        if (this.fdJ) {
            this.fdy.setEditorTools(this.apy);
        } else {
            this.fah.requestFocus();
        }
    }

    private void initEditor() {
        com.baidu.tbadk.editortools.s ef;
        com.baidu.tbadk.editortools.aa eh;
        this.apy = new com.baidu.tbadk.editortools.l(getActivity());
        this.apy.setBarMaxLauCount(5);
        this.apy.setMoreButtonAtEnd(true);
        this.apy.setBarLauncherType(1);
        this.apy.setBarLinePostion(2);
        this.apy.setMoreLauncherIcon(t.f.write_more);
        this.apy.setBackgroundColorId(t.d.cp_bg_line_d);
        this.apy.setCanshowTogetherhi(Boolean.valueOf(this.fdm));
        switch (this.evE.getType()) {
            case 4:
            case 5:
                bdG();
                break;
            default:
                bdH();
                break;
        }
        this.apy.Bd();
        if (this.fda != null) {
            this.fda.addView(this.apy);
        }
        bdI();
        this.apy.kC();
        com.baidu.tbadk.editortools.s ef2 = this.apy.ef(6);
        if (ef2 != null && !TextUtils.isEmpty(this.arA)) {
            ((View) ef2).setOnClickListener(new ab(this));
        }
        if (!this.fdJ) {
            this.apy.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.apy.zy();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("xiaoying_has_click", false)) {
            this.apy.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        BR();
        this.fdL = new bp(this, this.apy);
        if (this.fdl != null && (ef = this.apy.ef(26)) != null && (ef instanceof View) && (eh = this.apy.eh(27)) != null && eh.aps != null && (eh.aps instanceof View)) {
            getWindow().setSoftInputMode(18);
            ((View) eh.aps).post(new ac(this, (View) ef));
        }
    }

    private void BR() {
        if (this.apy != null) {
            this.apy.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.apy.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void bdE() {
        this.fdB = this.mRootView.findViewById(t.g.photo_live_scroll);
        this.fdD = this.fdB.findViewById(t.g.live_post_title_container);
        this.fdA = (EditText) this.fdB.findViewById(t.g.live_post_content);
        this.fdx = (GridView) this.fdB.findViewById(t.g.photoLiveGridView);
        this.fdE = (EditText) this.fdB.findViewById(t.g.live_post_title);
        this.fdF = (TextView) this.fdB.findViewById(t.g.titleOverPlusNumber);
        this.fdG = (TextView) this.fdB.findViewById(t.g.contentOverPlusNumber);
        this.fdC = this.fdB.findViewById(t.g.live_interval_view);
        this.fdF.setText(String.valueOf(20));
        this.fdG.setText(String.valueOf(233));
        this.fdB.setVisibility(0);
        this.fdF.setVisibility(0);
        this.fdG.setVisibility(0);
        this.fdE.setHint(t.j.tips_title_limit_new);
        this.fdE.setOnFocusChangeListener(new ad(this));
        if (this.evE.getType() == 4) {
            this.fdA.setHint(t.j.live_write_input_content_new);
        } else if (this.evE.getType() == 5) {
            this.fdA.setHint(t.j.live_write_input_content_update);
        }
        this.fdA.setOnFocusChangeListener(new ae(this));
        this.fdA.requestFocus();
        this.fdA.addTextChangedListener(aFI());
        this.fdE.requestFocus();
        this.fdE.addTextChangedListener(aFI());
        this.fdE.setOnClickListener(this.fdW);
        this.fdA.setOnClickListener(this.fdW);
        this.fdy = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fdx);
        this.fdy.qX(6);
        this.fdx.setAdapter((ListAdapter) this.fdy);
        View findViewById = this.fdB.findViewById(t.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new af(this));
        bdF();
    }

    private void bdF() {
        if (this.evE.getType() == 0) {
            if (this.evE.getTitle() != null) {
                this.fdE.setText(this.evE.getTitle());
                this.fdE.setSelection(this.evE.getTitle().length());
            }
        } else if (this.evE.getType() != 1) {
            this.evE.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fdJ) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            beb();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            BX();
            return;
        }
        if (this.apy.Bf()) {
            this.apy.zy();
        }
        String str = null;
        if (this.evE != null) {
            str = this.evE.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fdJ) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bdG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.apy.x(arrayList);
        com.baidu.tbadk.editortools.aa eh = this.apy.eh(5);
        if (eh != null) {
            eh.aqn = 2;
            eh.aql = t.f.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aql = t.f.write_at;
        this.apy.b(aVar);
        this.apy.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bdH() {
        boolean z;
        boolean z2;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        iVar.aql = t.f.write_picture;
        this.apy.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.apy.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 == null || (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) == null) {
            z = false;
        } else {
            aaVar5.aqp = true;
            aaVar5.aql = t.f.write_graffiti;
            aaVar5.aqn = 2;
            this.apy.b(aaVar5);
            z = true;
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 == null || (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) == null) {
            z2 = false;
        } else {
            aaVar4.aqn = 4;
            aaVar4.aql = t.f.write_privilege;
            this.apy.b(aaVar4);
            z2 = true;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        if (!z || !z2) {
            aVar.aql = t.f.write_at;
        }
        this.apy.b(aVar);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.aqp = true;
            aaVar3.aqn = 8;
            aaVar3.aql = 0;
            this.apy.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.aqp = true;
            aaVar2.aqn = 9;
            aaVar2.aql = 0;
            this.apy.b(aaVar2);
        }
        Boolean bdZ = bdZ();
        if (!this.fcX && bdZ != null && bdZ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.aVf() && com.baidu.tieba.tbadkCore.u.a(this.evE.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.aqn = 6;
            if (!z || !z2) {
                aaVar.aql = t.f.write_recorder;
            }
            this.apy.b(aaVar);
        }
        if (this.evE != null && this.evE.getType() == 0 && !this.fcX && !this.fcY) {
            arrayList.add(13);
            arrayList.add(14);
            arrayList.add(26);
            arrayList.add(27);
        }
        if (this.fdn == null) {
            this.apy.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.apy.x(arrayList);
        com.baidu.tbadk.editortools.aa eh = this.apy.eh(5);
        if (eh != null) {
            eh.aqn = 3;
            eh.aql = t.f.write_face;
        }
        com.baidu.tbadk.editortools.aa eh2 = this.apy.eh(13);
        if (eh2 != null) {
            eh2.aqn = 7;
        }
    }

    private void bdI() {
        ag agVar = new ag(this);
        this.apy.a(16, agVar);
        this.apy.a(21, agVar);
        this.apy.a(43, agVar);
        this.apy.a(45, agVar);
        this.apy.a(14, agVar);
        this.apy.a(24, agVar);
        this.apy.a(3, agVar);
        this.apy.a(10, agVar);
        this.apy.a(11, agVar);
        this.apy.a(12, agVar);
        this.apy.a(13, agVar);
        this.apy.a(22, agVar);
        this.apy.a(23, agVar);
        this.apy.a(15, agVar);
        this.apy.a(18, agVar);
        this.apy.a(25, agVar);
        this.apy.a(27, agVar);
        this.apy.a(29, agVar);
        this.apy.a(40, agVar);
    }

    public void aMp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BM() {
        if (this.art.aUL()) {
            if (this.art.aUJ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aUF().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.art.aUH();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bci() {
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
        if (this.fdb != null) {
            this.fdb.cancelLoadData();
        }
        if (this.art != null) {
            this.art.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bci();
        bdY();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bda() {
        if (this.evE != null && this.evE.getType() == 2 && this.fdi) {
            finish();
        } else if (this.evE == null) {
            finish();
        } else {
            this.evE.setTitle(bdV().getText().toString());
            this.evE.setContent(bdU().getText().toString());
            int type = this.evE.getType();
            if (type == 0) {
                com.baidu.tieba.tbadkCore.ae.b(this.evE.getForumId(), this.evE);
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ae.c(this.evE.getThreadId(), this.evE);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.evE.getForumId()) + "photolive", this.evE);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.evE.getThreadId()) + "updatephotolive", this.evE);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fak != null && this.fak.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.fak, getPageContext().getPageActivity());
                return true;
            } else if (this.apy.Bf()) {
                this.apy.zy();
                return true;
            } else {
                bci();
                bda();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.bZp);
        getLayoutMode().x(this.fdQ);
        if (this.fdN != null && i == 1) {
            this.fdN.setBorderColor(com.baidu.tbadk.core.util.at.getColor(t.d.black_alpha10));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.c(this.fai, t.d.navbar_btn_color, 1);
        com.baidu.tbadk.core.util.at.k(this.fai, t.f.s_navbar_button_bg);
        bdD();
        com.baidu.tbadk.core.util.at.l(this.fdB, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.fae, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.fdC, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(bdV(), t.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.cSm)) {
            com.baidu.tbadk.core.util.at.l(bdU(), t.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_e);
        bdV().setTextColor(color);
        bdU().setTextColor(color);
        a(bdV(), color2);
        a(bdU(), color2);
        bcq();
        this.apy.onChangeSkinType(i);
        if (this.fdw != null) {
            this.fdw.vm();
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

    private void nq() {
        this.azH = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fdJ = this.evE.getType() == 4 || 5 == this.evE.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(t.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cao = this.mNavigationBar.setTitleText("");
        this.fdg = (TextView) findViewById(t.g.btn_image_problem);
        this.fai = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fai.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.fai.setLayoutParams(layoutParams);
        this.fai.setOnFocusChangeListener(this.fab);
        this.fdz = (ScrollView) findViewById(t.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fdc = (FeedBackTopListView) findViewById(t.g.feedback_top_list);
        this.fdd = findViewById(t.g.feedback_divider);
        this.bZp = (RelativeLayout) findViewById(t.g.parent);
        this.fda = (LinearLayout) findViewById(t.g.tool_view);
        this.fda.setContentDescription("..");
        this.fae = findViewById(t.g.interval_view);
        bcp();
        if (this.fdJ) {
            this.fdz.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bdE();
        }
        bcr();
        if (this.fcX || this.fcY) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().YG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(t.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(t.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fag = (LinearLayout) findViewById(t.g.post_content_container);
        this.fag.setDrawingCacheEnabled(false);
        this.fag.setOnClickListener(new ah(this));
        this.afm.setOnFocusChangeListener(this.fab);
        this.afm.setOnClickListener(new ai(this));
        this.fdg.setOnClickListener(new aj(this));
        bdK();
        j(bdZ());
        bdO();
        aMp();
        switch (this.evE.getType()) {
            case 0:
                if (this.fcX || this.fcY) {
                    if (this.fcZ) {
                        this.cao.setText(t.j.feedback_vcode);
                    } else {
                        this.cao.setText(t.j.feedback);
                    }
                } else {
                    this.cao.setText(t.j.post_new_thread);
                }
                this.fad.setVisibility(0);
                this.fah.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.cao.setText(t.j.send_reply);
                this.fah.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fad.setVisibility(8);
                break;
            case 4:
                this.cao.setText(t.j.publish_photo_live);
                this.fah.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cao.setText(getPageContext().getResources().getString(t.j.update_photo_live_tip, Integer.valueOf(this.evE.getFloorNum() + 1)));
                this.fdC.setVisibility(8);
                break;
        }
        bdP();
        bdX();
        bdD();
        bdM();
        bco();
        if (this.evE.getType() == 4 && this.fam != null && this.fde != null) {
            this.fam.setVisibility(8);
            this.fde.setVisibility(8);
        }
        bcq();
        ShowSoftKeyPad(this.mInputManager, this.fad);
        bdL();
    }

    private void bdJ() {
        this.bDN = null;
        this.fdu = -1;
        this.fdv = -1;
        eo gs = en.RC().gs(1);
        if (gs != null) {
            this.bDN = gs.bmd;
            this.fdu = getIntent().getIntExtra("category_id", -1);
            if (this.bDN != null && !this.bDN.isEmpty() && this.fdu >= 0) {
                this.fdt = new em();
                this.fdt.blZ = 0;
                this.fdt.name = getPageContext().getResources().getString(t.j.category_auto);
                this.fdv = this.fdt.blZ;
                this.bDY = this.fdt.name;
                for (em emVar : this.bDN) {
                    if (emVar.blZ == this.fdu) {
                        this.fdv = emVar.blZ;
                        this.bDY = emVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bdK() {
        if (this.bDN != null && !this.bDN.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(t.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(t.g.interval_view_cate).setVisibility(0);
            this.fdw = (PostCategoryView) linearLayout.findViewById(t.g.category_selected);
            this.fdw.setText(this.bDY);
            this.fdw.b(this.bDN, this.fdt, this.fdv);
            this.fdw.setCategoryContainerClickCallback(new al(this));
            linearLayout.setOnClickListener(new am(this));
        }
    }

    private void bdL() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fdZ = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new an(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fdZ.setTitle(t.j.no_disturb_start_time);
        this.fdZ.setButton(-1, getPageContext().getString(t.j.alert_yes_button), this.fdZ);
        this.fdZ.setButton(-2, getPageContext().getString(t.j.alert_no_button), this.fdZ);
        return this.fdZ;
    }

    private void bdM() {
        this.fdo = (RelativeLayout) findViewById(t.g.addition_container);
        this.fdp = (TextView) findViewById(t.g.addition_create_time);
        this.fdq = (TextView) findViewById(t.g.addition_last_time);
        this.fdr = (TextView) findViewById(t.g.addition_last_content);
        if (this.fdn != null) {
            this.fdo.setVisibility(0);
            this.fdp.setText(String.valueOf(getPageContext().getString(t.j.write_addition_create)) + com.baidu.tbadk.core.util.ay.x(this.fdn.getCreateTime() * 1000));
            if (this.fdn.getAlreadyCount() == 0) {
                this.fdq.setVisibility(8);
            } else {
                this.fdq.setText(String.valueOf(getPageContext().getString(t.j.write_addition_last)) + com.baidu.tbadk.core.util.ay.x(this.fdn.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fdn.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fdr.setText(lastAdditionContent);
            } else {
                this.fdr.setVisibility(8);
            }
            bdU().setHint(String.format(getPageContext().getString(t.j.write_addition_hint), Integer.valueOf(this.fdn.getAlreadyCount()), Integer.valueOf(this.fdn.getTotalCount())));
            this.cao.setText(t.j.write_addition_title);
            return;
        }
        this.fdo.setVisibility(8);
    }

    private void bco() {
        this.fam = findViewById(t.g.post_prefix_layout);
        this.faj = (TextView) findViewById(t.g.post_prefix);
        this.fde = findViewById(t.g.prefix_divider);
        this.fal = (ImageView) findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fam.setVisibility(0);
            this.fde.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.eZL = 1;
            this.fam.setOnClickListener(new ao(this));
            this.fal = (ImageView) findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.fal.setVisibility(0);
                this.faj.setOnClickListener(new ap(this));
            }
            this.fak = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fak.a(this);
            this.fak.setMaxHeight(com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds510));
            this.fak.setOutsideTouchable(true);
            this.fak.setFocusable(true);
            this.fak.setOnDismissListener(this);
            this.fak.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.at.getColor(t.d.write_text);
            int color2 = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(this.faj, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(this.fal, t.f.icon_title_down);
            this.faj.setTextColor(color);
            this.fbP.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fbP.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fak.addView(aVar);
            }
            this.fak.qG(0);
            this.faj.setText(prefixs.get(1));
            rh(1);
            return;
        }
        this.fam.setVisibility(8);
    }

    private void bdN() {
        if (this.fcX && this.evE != null) {
            this.fdc.setVisibility(0);
            this.fdd.setVisibility(0);
            this.fdb = new p(this);
            this.fdb.pn(this.evE.getForumName());
            this.fdb.setLoadDataCallBack(new aq(this));
        }
    }

    protected void bdO() {
        this.fai.setOnClickListener(new ar(this));
    }

    protected void bdP() {
        this.fdh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fdh.cA(getPageContext().getString(t.j.is_save_draft)).ap(false).a(getPageContext().getString(t.j.save), new as(this)).b(getPageContext().getString(t.j.not_save), new au(this));
        this.fdh.b(getPageContext());
    }

    protected void bcp() {
        this.fad = (EditText) findViewById(t.g.post_title);
        this.fad.setOnClickListener(this.fdW);
        this.fad.setOnFocusChangeListener(this.fab);
        if (this.evE.getType() == 0) {
            if (this.evE.getTitle() != null) {
                this.fad.setText(this.evE.getTitle());
                this.fad.setSelection(this.evE.getTitle().length());
            } else if (this.fcZ) {
                this.fad.setText(getResources().getString(t.j.vcode_feed_back_title));
            }
        } else if (this.evE.getType() != 1) {
            this.evE.getType();
        }
        this.fad.addTextChangedListener(new av(this));
    }

    private TextWatcher aFI() {
        ax axVar = new ax(this);
        if (this.fdJ && this.fdK) {
            if (this.fdH != null) {
                this.fdE.removeTextChangedListener(this.fdH);
            }
            this.fdH = axVar;
        } else if (this.fdJ) {
            if (this.fdI != null) {
                this.fdA.removeTextChangedListener(this.fdI);
            }
            this.fdI = axVar;
        }
        return axVar;
    }

    private long g(EditText editText) {
        if (editText == this.fdA) {
            return 233L;
        }
        if (editText != this.fdE) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void bcr() {
        this.fah = (EditText) findViewById(t.g.post_content);
        this.fah.setDrawingCacheEnabled(false);
        this.fah.setOnClickListener(this.fdW);
        if (this.evE.getContent() != null && this.evE.getContent().length() > 0) {
            SpannableString y = TbFaceManager.CH().y(getPageContext().getPageActivity(), this.evE.getContent());
            this.fah.setText(y);
            this.fah.setSelection(y.length());
        } else if (this.evE.getType() == 2) {
            if (this.fdi) {
                if (this.fdj != null && this.fdj.length() > 0) {
                    this.fah.setText(getPageContext().getPageActivity().getString(t.j.reply_sub_floor, new Object[]{this.fdj}));
                    this.fah.setSelection(this.fah.getText().length());
                }
            } else if (this.evE.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(t.j.reply_x_floor), Integer.valueOf(this.evE.getFloorNum()));
                this.fah.setText(format);
                this.fah.setSelection(format.length());
            }
        }
        this.fah.setOnFocusChangeListener(this.fab);
        this.fah.setOnTouchListener(new ay(this));
        this.fah.addTextChangedListener(new az(this));
        kB(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(boolean z) {
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fdJ) {
            bdU().setPadding(0, 0, 0, 0);
            bdU().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.at.l(bdU(), t.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.cSm) && this.fdn == null) {
                com.baidu.adp.lib.g.c.dF().a(this.cSm, 19, new ba(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdQ() {
        int i = 5000;
        if (this.fdn != null) {
            i = 1000;
        }
        return bdU().getText() != null && bdU().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdR() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.apy != null) {
                this.apy.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aTj() && this.fds == 0) {
            showToast(t.j.baobao_over_limit);
        } else {
            String charSequence = this.cao.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdS() {
        this.fdl = null;
        this.evE.setHiContent(this.fdl);
        bef();
        bcq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdT() {
        if (this.fdl != null) {
            if (this.apy != null) {
                this.apy.b(new com.baidu.tbadk.editortools.a(44, 27, this.fdl));
                bef();
                return;
            }
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_HI_STARTMATCHIMAGE, new IntentConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (((ImageSpan[]) bdU().getText().getSpans(0, bdU().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fdk == null) {
                this.fdk = Toast.makeText(getPageContext().getPageActivity(), t.j.too_many_face, 0);
            }
            this.fdk.show();
            return;
        }
        String name = hVar.getName();
        EmotionGroupType wy = hVar.wy();
        if (name != null) {
            com.baidu.adp.lib.g.c.dF().a(name, 20, new bb(this, new SpannableStringBuilder(name), wy), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap iY = aVar.iY();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(iY);
        int width = iY.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        bdU().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bdU() {
        return this.fdJ ? this.fdA : this.fah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bdV() {
        return this.fdJ ? this.fdE : this.fad;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdW() {
        bdU().onKeyDown(67, this.fdf);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.evE != null) {
            str = this.evE.getForumName();
        }
        if (getPageContext().getString(t.j.feedback_bar_name).equals(str)) {
            this.fcX = true;
        }
    }

    private void bdX() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bdY() {
        try {
            if (this.fdh != null) {
                this.fdh.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.azH.c(null);
        this.azH.cG(t.j.sending);
        this.azH.aD(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.azH.aD(false);
    }

    private Boolean bdZ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.arA = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcq() {
        String str;
        String str2 = null;
        if (this.evE != null) {
            String editable = bdV().getText().toString();
            String trim = bdU().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.evE.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.eZL == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.evE.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.evE.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.evE.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.evE.setIsNoTitle(true);
                str = null;
            } else {
                this.evE.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fdJ) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.arq != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            } else if (this.fdl != null) {
                str = "1";
            }
            if (this.evE.getVideoInfo() != null) {
                str = "1";
            }
            if (this.evE.getGraffitiFileName() != null) {
                str = "1";
            }
            if (this.evE.getType() == 4) {
                if (i(this.fdA) && h(this.fdE)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.evE.getType() != 5) {
                str2 = str;
            } else if (i(this.fdA)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.fai.setEnabled(false);
            } else {
                this.fai.setEnabled(true);
            }
        }
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
        this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aru.b(this.arK);
        registerListener(this.fdV);
        this.dwy = new bc(this);
        this.evE = new WriteData();
        if (bundle != null) {
            this.evE.setType(bundle.getInt("type", 0));
            this.evE.setForumId(bundle.getString("forum_id"));
            this.evE.setForumName(bundle.getString("forum_name"));
            this.evE.setThreadId(bundle.getString("thread_id"));
            this.evE.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.evE.setFloorNum(bundle.getInt("floor_num", 0));
            this.fcX = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fcZ = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fdi = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fdj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.fdl = bundle.getString(WriteActivityConfig.TOGETHERHI_DATA);
            this.fdm = bundle.getBoolean(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.ars = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fdn = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.evE.setIsAddition(this.fdn != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.fds = bundle.getInt("mem_type", 0);
            this.Zf = bundle.getString("from");
        } else {
            Intent intent = getIntent();
            this.evE.setType(intent.getIntExtra("type", 0));
            this.evE.setForumId(intent.getStringExtra("forum_id"));
            this.evE.setForumName(intent.getStringExtra("forum_name"));
            this.evE.setThreadId(intent.getStringExtra("thread_id"));
            this.evE.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.evE.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fcX = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fcZ = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fdi = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fdj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fdn = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.evE.setIsAddition(this.fdn != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.fds = intent.getIntExtra("mem_type", 0);
            this.Zf = intent.getStringExtra("from");
            this.fdl = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.fdm = intent.getBooleanExtra(WriteActivityConfig.TOGETHERHI_SHOW, false);
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.evE.getType() == 4 ? 6 : 10);
        this.evE.setWriteImagesInfo(this.writeImagesInfo);
        this.evE.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.evE.setHiContent(this.fdl);
        if (this.evE.getType() == 0) {
            com.baidu.tieba.tbadkCore.ae.c(this.evE.getForumId(), this);
        } else if (this.evE.getType() == 1) {
            com.baidu.tieba.tbadkCore.ae.a(this.evE.getThreadId(), this);
        } else if (this.evE.getType() == 4) {
            com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.evE.getForumId()) + "photolive", this);
        } else if (this.evE.getType() == 5) {
            com.baidu.tieba.tbadkCore.ae.a(String.valueOf(this.evE.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
        }
        this.cSm = TbadkCoreApplication.m11getInst().getDefaultBubble();
        if (this.evE != null && this.evE.getForumName() != null && TbadkCoreApplication.m11getInst().getYijianfankuiFname() != null && this.evE.getForumName().equals(TbadkCoreApplication.m11getInst().getYijianfankuiFname())) {
            this.fcY = true;
        }
        bdJ();
        try {
            this.fdM = beg();
        } catch (Throwable th) {
            this.fdM = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.evE != null) {
                this.evE.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bdV().getText().toString()) || ((this.fcX || this.fcY) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.evE.setTitle(writeData.getTitle());
                    bdV().setText(this.evE.getTitle());
                    bdV().setSelection(this.evE.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.evE.setVideoInfo(videoInfo);
                    this.apy.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bdU().getText().toString()) || this.fcX || this.fcY) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.evE.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.CH().a(getPageContext().getPageActivity(), this.evE.getContent(), new bd(this));
                    bdU().setText(a2);
                    bdU().setSelection(a2.length());
                    if (this.fdJ) {
                        b(this.fdG, this.fdA);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.evE.setWriteImagesInfo(this.writeImagesInfo);
                    bee();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        BX();
                    }
                    kC(false);
                }
                if (TbadkCoreApplication.m11getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.evE.setIsBaobao(writeData.getIsBaobao());
                        this.evE.setBaobaoContent(writeData.getBaobaoContent());
                        this.evE.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.evE.getIsBaobao()) {
                        BZ();
                        kD(false);
                    }
                }
                if (this.fdl == null && writeData.getHiContent() != null) {
                    this.fdl = writeData.getHiContent();
                    this.evE.setHiContent(this.fdl);
                    bef();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bea();
                }
                bcq();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.bDN != null) {
                    this.fdv = this.fdt.blZ;
                    this.bDY = this.fdt.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.bDN.size()) {
                            break;
                        }
                        em emVar = this.bDN.get(i2);
                        if (categoryTo != emVar.blZ) {
                            i = i2 + 1;
                        } else {
                            this.fdv = categoryTo;
                            this.bDY = emVar.name;
                            this.evE.setCategoryTo(this.fdv);
                            break;
                        }
                    }
                    if (this.fdw != null) {
                        this.fdw.setText(this.bDY);
                        this.fdw.b(this.bDN, this.fdt, this.fdv);
                    }
                }
                this.evE.setGraffitiFileName(writeData.getGraffitiFileName());
                this.apy.b(new com.baidu.tbadk.editortools.a(42, 24, this.evE.getGraffitiFileName()));
                this.apy.zy();
                return;
            }
            return;
        }
        bea();
    }

    private void bea() {
        if ((!this.fdJ || this.fdy != null) && this.fdx != null) {
            this.fdy.b(this.writeImagesInfo);
            bed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.evE.getType());
        bundle.putString("forum_id", this.evE.getForumId());
        bundle.putString("forum_name", this.evE.getForumName());
        bundle.putString("thread_id", this.evE.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.evE.getFloor());
        bundle.putInt("floor_num", this.evE.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fdi);
        if (this.fcX) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.TOGETHERHI_DATA, this.fdl);
        bundle.putBoolean(WriteActivityConfig.TOGETHERHI_SHOW, this.fdm);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ars);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fdn);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.fds);
        bundle.putString("from", this.Zf);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bdU().getEditableText().toString();
        if (editable != null) {
            bdU().setText(TbFaceManager.CH().y(getPageContext().getPageActivity(), editable));
            bdU().setSelection(bdU().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdb() {
        bci();
        String editable = bdV().getText().toString();
        this.evE.setContent(bdU().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eZL != 0 && this.evE.getType() != 4) {
            this.evE.setTitle(String.valueOf(this.faj.getText().toString()) + editable);
        } else {
            this.evE.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.evE.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.evE.getTitle());
        }
        if (this.fcX || this.fcY) {
            String string = getResources().getString(t.j.android_feedback);
            if (TextUtils.isEmpty(this.evE.getTitle()) || !this.evE.getTitle().startsWith(string)) {
                this.evE.setTitle(string + this.evE.getTitle());
            }
            String str = String.valueOf(getResources().getString(t.j.app_name)) + getResources().getString(t.j.tieba_client);
            if (TextUtils.isEmpty(this.evE.getContent()) || !this.evE.getContent().startsWith(str)) {
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
                sb.append(this.evE.getContent());
                this.evE.setContent(sb.toString());
            }
        }
        if (this.fdu >= 0) {
            this.evE.setCategoryFrom(this.fdu);
        }
        if (this.fdv >= 0) {
            this.evE.setCategoryTo(this.fdv);
        }
        this.evE.setWriteImagesInfo(this.writeImagesInfo);
        this.evE.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.evE.setHiContent(this.fdl);
        this.evE.setHasLocationData(this.art == null ? false : this.art.aUL());
        this.aru.jC(this.writeImagesInfo.size() > 0);
        this.aru.d(this.evE);
        this.evE.setVcode(null);
        if (this.arq != null) {
            if (this.arq.getId() != null) {
                this.aru.aVg().setVoice(this.arq.getId());
                this.aru.aVg().setVoiceDuringTime(this.arq.duration);
            } else {
                this.aru.aVg().setVoice(null);
                this.aru.aVg().setVoiceDuringTime(-1);
            }
        } else {
            this.aru.aVg().setVoice(null);
            this.aru.aVg().setVoiceDuringTime(-1);
        }
        if (!this.aru.aVk()) {
            showToast(t.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.dwy);
            if (!this.aru.aVh()) {
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
            if (this.fdn != null) {
                i2 = this.fdn.getTotalCount();
                i = this.fdn.getAlreadyCount() + 1;
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
                if (this.apy != null && !this.apy.Bf()) {
                    bdU().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> v = com.baidu.tieba.tbadkCore.util.l.v(intent);
                if (v != null && v.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < v.size()) {
                            sb.append("@");
                            sb.append(v.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            bdU().getText().insert(bdU().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.evE.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ae.b(this.evE.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.evE.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ae.c(this.evE.getThreadId(), (WriteData) null);
                } else if (this.evE.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.evE.getForumId()) + "photolive", (WriteData) null);
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
                                aHh();
                            } else {
                                B(intent);
                            }
                        } else if (intExtra == 1) {
                            u(intent);
                        } else {
                            A(intent);
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fdJ) {
                        c(intent);
                        bcq();
                        return;
                    }
                    D(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.evE.setVideoInfo(videoInfo);
                        this.apy.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.apy.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.apy.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bcq();
                } else if (i == 12013) {
                    d(intent);
                    bcq();
                } else if (i == 12016) {
                    F(intent);
                    bcq();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.m(intent);
                }
            }
        } else if (i2 == 0) {
            if (this.apy != null && !this.apy.Bf()) {
                this.fah.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    BP();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bec();
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
                    this.ars = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.as.b(getPageContext(), this.ars);
                    return;
                case 12012:
                    bec();
                    return;
            }
        }
    }

    private void beb() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bec() {
        if (this.fdJ) {
            this.fdy.b(this.writeImagesInfo);
            bed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        this.fdy.notifyDataSetChanged();
        this.fdx.invalidate();
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
        bcq();
    }

    private void A(Intent intent) {
        if (this.fdJ) {
            D(intent);
            bec();
        } else {
            E(intent);
        }
        bcq();
    }

    private void D(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bec();
            kC(true);
        }
    }

    private void B(Intent intent) {
        if (this.writeImagesInfo != null) {
            b(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aHh() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void u(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.dOe.parseJson(stringExtra);
            this.dOe.updateQuality();
            if (this.dOe.getChosedFiles() != null && this.dOe.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.dOe.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.dOe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bdV());
        HidenSoftKeyPad(this.mInputManager, bdU());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void E(Intent intent) {
        c(intent, true);
    }

    private void b(Intent intent) {
        this.ars = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ars;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.ars, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bee();
            BX();
        }
        kC(true);
    }

    private void c(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bee();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    BX();
                }
            }
            kC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bee() {
        if (this.apy.eh(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void F(Intent intent) {
        if (this.evE != null) {
            this.fdl = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.evE.setHiContent(this.fdl);
            bef();
        }
    }

    private void d(Intent intent) {
        if (this.evE != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.evE.setIsBaobao(true);
            this.evE.setBaobaoContent(stringExtra2);
            BZ();
            kD(true);
        }
    }

    private void BP() {
        new bf(this).execute(new Void[0]);
    }

    private void kC(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void kD(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.beZ == null) {
            this.beZ = VoiceManager.instance();
        }
        return this.beZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Pm() {
        this.beZ = getVoiceManager();
        this.beZ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.pv(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString2);
            } else if (this.fdn == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.arC = i;
        if (this.apy != null) {
            this.apy.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.apy.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void BX() {
        if (!this.fdJ && this.apy != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.apy.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.apy.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.apy.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.apy.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void BZ() {
        if (this.apy != null) {
            this.apy.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.apy.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.apy.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    private void bef() {
        if (this.apy != null) {
            if (this.fdl != null) {
                this.apy.b(new com.baidu.tbadk.editortools.a(44, 27, this.fdl));
                this.apy.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
                return;
            }
            this.apy.b(new com.baidu.tbadk.editortools.a(45, 27, this.fdl));
            this.apy.b(new com.baidu.tbadk.editortools.a(2, 26, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (this.apy != null) {
            this.apy.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void rh(int i) {
        if (i < this.fbP.size()) {
            for (int i2 = 0; i2 < this.fbP.size(); i2++) {
                this.fbP.get(i2).kr(false);
            }
            this.fbP.get(i).kr(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void qH(int i) {
        this.eZL = i;
        this.fak.qG(i);
        rh(i);
        this.faj.setText(this.mPrefixData.getPrefixs().get(i));
        bcq();
        com.baidu.adp.lib.h.j.a(this.fak, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fam.setSelected(false);
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
            com.baidu.adp.lib.util.k.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.evE != null) {
            if (this.evE.getType() == 4) {
                return "a015";
            }
            if (this.evE.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            BK();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.R(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.b(getPageContext(), this.ars);
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
        if (this.fdL != null) {
            this.fdL.onKeyboardVisibilityChanged(z);
        }
        if (this.fdT && System.currentTimeMillis() - this.fdU < 800) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.fdT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fdP != null) {
            pr(str);
            this.fdP.dismiss();
        }
    }

    private void aX(Context context) {
        fdR = com.baidu.adp.lib.util.k.B(context);
        fdS = com.baidu.adp.lib.util.k.C(context);
    }

    private void pr(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fdT = true;
        bee();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            BX();
        }
        kC(true);
    }

    private static Bitmap b(String str, float f) {
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

    private File beg() {
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

    private void beh() {
        if (this.fdM != null && this.evE.getType() == 0) {
            aX(getActivity());
            this.fdO = getPageContext().getPageActivity().getLayoutInflater().inflate(t.h.rec_dialog, (ViewGroup) null);
            this.fdO.setOnClickListener(new bg(this));
            this.fdN = (TbImageView) this.fdO.findViewById(t.g.rec_img_view);
            this.fdQ = (LinearLayout) this.fdO.findViewById(t.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.sR().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fdM.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.sR().putString("write_rec_pic_path", this.fdM.getAbsolutePath());
                Bitmap b = b(this.fdM.getAbsolutePath(), getResources().getDimensionPixelSize(t.e.ds160));
                if (b != null) {
                    this.fdN.setImageBitmap(b);
                    this.fdN.setDrawBorder(true);
                    this.fdN.setBorderWidth(2);
                    this.fdN.setBorderColor(com.baidu.tbadk.core.util.at.getColor(t.d.black_alpha4));
                    this.fdP = new Dialog(getActivity(), t.k.bubble_dialog);
                    this.fdP.setCanceledOnTouchOutside(true);
                    this.fdP.setOnDismissListener(new bi(this));
                    this.fdP.setContentView(this.fdO);
                    this.fdP.show();
                    Window window = this.fdP.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(t.e.ds28);
                    attributes.y = (fdS / 18) + getResources().getDimensionPixelSize(t.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(t.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(t.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }
}
