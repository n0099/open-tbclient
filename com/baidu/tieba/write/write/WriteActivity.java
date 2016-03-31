package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.write.cg;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, ad.a, cg.a {
    public static String eMX = "from_writeActivity_livePhoto";
    private String adH;
    private com.baidu.tbadk.editortools.l atG;
    private VoiceData.VoiceModel avr;
    private String avt;
    private com.baidu.tieba.tbadkCore.location.d avu;
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    List<ev> bDI;
    private String bDT;
    private VoiceManager bja;
    private int eIV;
    private TextView eJt;
    private cg eJu;
    private ImageView eJv;
    private View eJw;
    private TextView eMA;
    private TextView eMB;
    private TextView eMC;
    ev eME;
    private int eMF;
    private int eMG;
    private PostCategoryView eMH;
    private LinearLayout eMn;
    private View eMq;
    private View eMr;
    private Toast eMx;
    private AdditionData eMy;
    private RelativeLayout eMz;
    private com.baidu.tieba.view.b eNc;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData esv = null;
    private boolean eMk = false;
    private boolean eMl = false;
    private boolean eMm = false;
    private InputMethodManager mInputManager = null;
    private EditText eJn = null;
    private View eJo = null;
    private LinearLayout eJq = null;
    private EditText eJr = null;
    private p eMo = null;
    private FeedBackTopListView eMp = null;
    private ArrayList<com.baidu.tieba.write.view.j> eLc = new ArrayList<>();
    private String cRp = null;
    private final KeyEvent eMs = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View ajA = null;
    private TextView eMt = null;
    private TextView eJs = null;
    private TextView bZJ = null;
    private DialogInterface.OnCancelListener dtc = null;
    private com.baidu.tbadk.core.dialog.a eMu = null;
    private final Handler mHandler = new Handler();
    private boolean eMv = false;
    private String eMw = null;
    private RelativeLayout bYK = null;
    private String avB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int avD = 0;
    private int eMD = 0;
    private WriteImagesInfo dKU = new WriteImagesInfo();
    private View mRootView = null;
    private GridView eMI = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a eMJ = null;
    private ScrollView eMK = null;
    private EditText eML = null;
    private View eMM = null;
    private View eMN = null;
    private View eMO = null;
    private EditText eMP = null;
    private TextView eMQ = null;
    private TextView eMR = null;
    private TextWatcher eMS = null;
    private TextWatcher eMT = null;
    private boolean eMU = false;
    private boolean eMV = false;
    private com.baidu.tbadk.core.view.b aDD = null;
    private bm eMW = null;
    private final HttpMessageListener eMY = new z(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d avL = new ak(this);
    private final d.a avJ = new aw(this);
    private final CustomMessageListener erL = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener eMZ = new bg(this);
    private boolean eNa = true;
    private final View.OnFocusChangeListener eJl = new bh(this);
    private final CustomMessageListener eNb = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0081a dmy = new bj(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.adH)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(t.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            DR();
        } else if (this.avu.aUi()) {
            DO();
        } else {
            this.avu.iL(false);
            a(1, true, (String) null);
            this.avu.aUg();
        }
    }

    private void DR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(t.j.location_app_permission_prompt).a(t.j.isopen, new bk(this)).b(t.j.cancel, new aa(this)).b(getPageContext());
        aVar.up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bbi() {
        int selectionEnd = bby().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bby().getText().getSpans(0, bby().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bby().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bby().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbj() {
        if (this.atG != null) {
            this.atG.setBarLauncherEnabled(!this.eNa);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.eMU) {
            this.eJn.setVisibility(8);
            if (this.esv.getType() == 5) {
                this.eMO.setVisibility(8);
            } else {
                this.eMO.setVisibility(0);
            }
            b(this.eMR, this.eML);
            b(this.eMQ, this.eMP);
            aZX();
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
        pU();
        bbt();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.eNb.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.eNb);
        this.avu = new com.baidu.tieba.tbadkCore.location.d(this);
        this.avu.a(this.avJ);
        registerListener(this.erL);
        initEditor();
        if (this.eMU) {
            this.eMJ.setEditorTools(this.atG);
        } else {
            this.eJr.requestFocus();
        }
    }

    private void initEditor() {
        this.atG = new com.baidu.tbadk.editortools.l(getActivity());
        this.atG.setBarMaxLauCount(4);
        this.atG.setMoreButtonAtEnd(true);
        this.atG.setBarLauncherType(1);
        this.atG.setBarLinePostion(2);
        this.atG.setMoreLauncherIcon(t.f.write_more);
        this.atG.setBackgroundColorId(t.d.cp_bg_line_d);
        switch (this.esv.getType()) {
            case 4:
            case 5:
                bbm();
                break;
            default:
                bbn();
                break;
        }
        this.atG.Di();
        if (this.eMn != null) {
            this.eMn.addView(this.atG);
        }
        bbo();
        this.atG.op();
        com.baidu.tbadk.editortools.s eA = this.atG.eA(6);
        if (eA != null && !TextUtils.isEmpty(this.avB)) {
            ((View) eA).setOnClickListener(new ab(this));
        }
        if (!this.eMU) {
            this.atG.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.atG.BD();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("xiaoying_has_click", false)) {
            this.atG.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        DX();
        this.eMW = new bm(this, this.atG);
    }

    private void DX() {
        if (this.atG != null) {
            this.atG.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.atG.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void bbk() {
        this.eMM = this.mRootView.findViewById(t.g.photo_live_scroll);
        this.eMO = this.eMM.findViewById(t.g.live_post_title_container);
        this.eML = (EditText) this.eMM.findViewById(t.g.live_post_content);
        this.eMI = (GridView) this.eMM.findViewById(t.g.photoLiveGridView);
        this.eMP = (EditText) this.eMM.findViewById(t.g.live_post_title);
        this.eMQ = (TextView) this.eMM.findViewById(t.g.titleOverPlusNumber);
        this.eMR = (TextView) this.eMM.findViewById(t.g.contentOverPlusNumber);
        this.eMN = this.eMM.findViewById(t.g.live_interval_view);
        this.eMQ.setText(String.valueOf(20));
        this.eMR.setText(String.valueOf(233));
        this.eMM.setVisibility(0);
        this.eMQ.setVisibility(0);
        this.eMR.setVisibility(0);
        this.eMP.setHint(t.j.tips_title_limit_new);
        this.eMP.setOnFocusChangeListener(new ac(this));
        if (this.esv.getType() == 4) {
            this.eML.setHint(t.j.live_write_input_content_new);
        } else if (this.esv.getType() == 5) {
            this.eML.setHint(t.j.live_write_input_content_update);
        }
        this.eML.setOnFocusChangeListener(new ad(this));
        this.eML.requestFocus();
        this.eML.addTextChangedListener(aFg());
        this.eMP.requestFocus();
        this.eMP.addTextChangedListener(aFg());
        this.eMP.setOnClickListener(this.eMZ);
        this.eML.setOnClickListener(this.eMZ);
        this.eMJ = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.eMI);
        this.eMJ.qD(6);
        this.eMI.setAdapter((ListAdapter) this.eMJ);
        View findViewById = this.eMM.findViewById(t.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        bbl();
    }

    private void bbl() {
        if (this.esv.getType() == 0) {
            if (this.esv.getTitle() != null) {
                this.eMP.setText(this.esv.getTitle());
                this.eMP.setSelection(this.esv.getTitle().length());
            }
        } else if (this.esv.getType() != 1) {
            this.esv.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.eMU) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bbF();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Ed();
            return;
        }
        if (this.atG.Dk()) {
            this.atG.BD();
        }
        String str = null;
        if (this.esv != null) {
            str = this.esv.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.eMU) {
            albumActivityConfig.getIntent().putExtra("from", eMX);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bbm() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.atG.v(arrayList);
        com.baidu.tbadk.editortools.aa eC = this.atG.eC(5);
        if (eC != null) {
            eC.launcherPriority = 2;
            eC.launcherIcon = t.f.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.launcherIcon = t.f.write_at;
        this.atG.b(aVar);
        this.atG.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bbn() {
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
        iVar.launcherIcon = t.f.write_picture;
        this.atG.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.atG.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 == null || (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) == null) {
            z = false;
        } else {
            aaVar5.toolNeedAction = true;
            aaVar5.launcherIcon = t.f.write_graffiti;
            aaVar5.launcherPriority = 2;
            this.atG.b(aaVar5);
            z = true;
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 == null || (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) == null) {
            z2 = false;
        } else {
            aaVar4.launcherPriority = 4;
            aaVar4.launcherIcon = t.f.write_privilege;
            this.atG.b(aaVar4);
            z2 = true;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        if (!z || !z2) {
            aVar.launcherIcon = t.f.write_at;
        }
        this.atG.b(aVar);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.toolNeedAction = true;
            aaVar3.launcherPriority = 8;
            aaVar3.launcherIcon = 0;
            this.atG.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.toolNeedAction = true;
            aaVar2.launcherPriority = 9;
            aaVar2.launcherIcon = 0;
            this.atG.b(aaVar2);
        }
        Boolean bbD = bbD();
        if (!this.eMk && bbD != null && bbD.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.aUE() && com.baidu.tieba.tbadkCore.u.a(this.esv.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.launcherPriority = 6;
            this.atG.b(aaVar);
        }
        if (this.esv != null && this.esv.getType() == 0 && !this.eMk && !this.eMl) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.eMy == null) {
            this.atG.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.atG.v(arrayList);
        com.baidu.tbadk.editortools.aa eC = this.atG.eC(5);
        if (eC != null) {
            eC.launcherPriority = 3;
            eC.launcherIcon = t.f.write_face;
        }
        com.baidu.tbadk.editortools.aa eC2 = this.atG.eC(13);
        if (eC2 != null) {
            eC2.launcherPriority = 7;
        }
    }

    private void bbo() {
        af afVar = new af(this);
        this.atG.a(16, afVar);
        this.atG.a(21, afVar);
        this.atG.a(14, afVar);
        this.atG.a(24, afVar);
        this.atG.a(3, afVar);
        this.atG.a(10, afVar);
        this.atG.a(11, afVar);
        this.atG.a(12, afVar);
        this.atG.a(13, afVar);
        this.atG.a(22, afVar);
        this.atG.a(23, afVar);
        this.atG.a(15, afVar);
        this.atG.a(18, afVar);
        this.atG.a(25, afVar);
        this.atG.a(27, afVar);
        this.atG.a(29, afVar);
        this.atG.a(40, afVar);
    }

    public void aVc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS() {
        if (this.avu.aUk()) {
            if (this.avu.aUi()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aUd().getLocationData().aTZ());
                return;
            }
            a(1, true, (String) null);
            this.avu.aUg();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZP() {
        if (this.avv != null) {
            this.avv.cancelLoadData();
        }
        if (this.eMo != null) {
            this.eMo.cancelLoadData();
        }
        if (this.avu != null) {
            this.avu.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aZP();
        bbC();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        if (this.esv != null && this.esv.getType() == 2 && this.eMv) {
            finish();
        } else if (this.esv == null) {
            finish();
        } else {
            this.esv.setTitle(bbz().getText().toString());
            this.esv.setContent(bby().getText().toString());
            int type = this.esv.getType();
            if (type == 0) {
                com.baidu.tieba.tbadkCore.ad.b(this.esv.getForumId(), this.esv);
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.esv.getThreadId(), this.esv);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.esv.getForumId()) + "photolive", this.esv);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.esv.getThreadId()) + "updatephotolive", this.esv);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eJu != null && this.eJu.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.eJu, getPageContext().getPageActivity());
                return true;
            } else if (this.atG.Dk()) {
                this.atG.BD();
                return true;
            } else {
                aZP();
                baG();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.bYK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.eJs, t.f.s_navbar_button_bg);
        bbj();
        com.baidu.tbadk.core.util.at.l(this.eMM, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.eJo, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.eMN, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(bbz(), t.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.cRp)) {
            com.baidu.tbadk.core.util.at.l(bby(), t.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_e);
        bbz().setTextColor(color);
        bby().setTextColor(color);
        a(bbz(), color2);
        a(bby(), color2);
        aZX();
        this.atG.onChangeSkinType(i);
        if (this.eMH != null) {
            this.eMH.xy();
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

    private void pU() {
        this.aDD = new com.baidu.tbadk.core.view.b(getPageContext());
        this.eMU = this.esv.getType() == 4 || 5 == this.esv.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(t.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bZJ = this.mNavigationBar.setTitleText("");
        this.eMt = (TextView) findViewById(t.g.btn_image_problem);
        this.eJs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.eJs.setLayoutParams(layoutParams);
        this.eJs.setOnFocusChangeListener(this.eJl);
        this.eMK = (ScrollView) findViewById(t.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.eMp = (FeedBackTopListView) findViewById(t.g.feedback_top_list);
        this.eMq = findViewById(t.g.feedback_divider);
        this.bYK = (RelativeLayout) findViewById(t.g.parent);
        this.eMn = (LinearLayout) findViewById(t.g.tool_view);
        this.eMn.setContentDescription("..");
        this.eJo = findViewById(t.g.interval_view);
        aZW();
        if (this.eMU) {
            this.eMK.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bbk();
        }
        aZY();
        if (this.eMk || this.eMl) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adi) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(t.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(t.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.eJq = (LinearLayout) findViewById(t.g.post_content_container);
        this.eJq.setDrawingCacheEnabled(false);
        this.eJq.setOnClickListener(new ag(this));
        this.ajA.setOnFocusChangeListener(this.eJl);
        this.ajA.setOnClickListener(new ah(this));
        this.eMt.setOnClickListener(new ai(this));
        bbq();
        j(bbD());
        bbu();
        aVc();
        switch (this.esv.getType()) {
            case 0:
                if (this.eMk || this.eMl) {
                    if (this.eMm) {
                        this.bZJ.setText(t.j.feedback_vcode);
                    } else {
                        this.bZJ.setText(t.j.feedback);
                    }
                } else {
                    this.bZJ.setText(t.j.post_new_thread);
                }
                this.eJn.setVisibility(0);
                this.eJr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bZJ.setText(t.j.send_reply);
                this.eJr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.eJn.setVisibility(8);
                break;
            case 4:
                this.bZJ.setText(t.j.publish_photo_live);
                this.eJr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bZJ.setText(getPageContext().getResources().getString(t.j.update_photo_live_tip, Integer.valueOf(this.esv.getFloorNum() + 1)));
                this.eMN.setVisibility(8);
                break;
        }
        bbv();
        bbB();
        bbj();
        bbs();
        aZV();
        if (this.esv.getType() == 4 && this.eJw != null && this.eMr != null) {
            this.eJw.setVisibility(8);
            this.eMr.setVisibility(8);
        }
        aZX();
        ShowSoftKeyPad(this.mInputManager, this.eJn);
        bbr();
    }

    private void bbp() {
        this.bDI = null;
        this.eMF = -1;
        this.eMG = -1;
        ex gR = ew.St().gR(1);
        if (gR != null) {
            this.bDI = gR.bqQ;
            this.eMF = getIntent().getIntExtra("category_id", -1);
            if (this.bDI != null && !this.bDI.isEmpty() && this.eMF >= 0) {
                this.eME = new ev();
                this.eME.bqM = 0;
                this.eME.name = getPageContext().getResources().getString(t.j.category_auto);
                this.eMG = this.eME.bqM;
                this.bDT = this.eME.name;
                for (ev evVar : this.bDI) {
                    if (evVar.bqM == this.eMF) {
                        this.eMG = evVar.bqM;
                        this.bDT = evVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bbq() {
        if (this.bDI != null && !this.bDI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(t.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(t.g.interval_view_cate).setVisibility(0);
            this.eMH = (PostCategoryView) linearLayout.findViewById(t.g.category_selected);
            this.eMH.setText(this.bDT);
            this.eMH.b(this.bDI, this.eME, this.eMG);
            this.eMH.setCategoryContainerClickCallback(new aj(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void bbr() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.eNc = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.eNc.setTitle(t.j.no_disturb_start_time);
        this.eNc.setButton(-1, getPageContext().getString(t.j.alert_yes_button), this.eNc);
        this.eNc.setButton(-2, getPageContext().getString(t.j.alert_no_button), this.eNc);
        return this.eNc;
    }

    private void bbs() {
        this.eMz = (RelativeLayout) findViewById(t.g.addition_container);
        this.eMA = (TextView) findViewById(t.g.addition_create_time);
        this.eMB = (TextView) findViewById(t.g.addition_last_time);
        this.eMC = (TextView) findViewById(t.g.addition_last_content);
        if (this.eMy != null) {
            this.eMz.setVisibility(0);
            this.eMA.setText(String.valueOf(getPageContext().getString(t.j.write_addition_create)) + com.baidu.tbadk.core.util.ay.w(this.eMy.getCreateTime() * 1000));
            if (this.eMy.getAlreadyCount() == 0) {
                this.eMB.setVisibility(8);
            } else {
                this.eMB.setText(String.valueOf(getPageContext().getString(t.j.write_addition_last)) + com.baidu.tbadk.core.util.ay.w(this.eMy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.eMy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.eMC.setText(lastAdditionContent);
            } else {
                this.eMC.setVisibility(8);
            }
            bby().setHint(String.format(getPageContext().getString(t.j.write_addition_hint), Integer.valueOf(this.eMy.getAlreadyCount()), Integer.valueOf(this.eMy.getTotalCount())));
            this.bZJ.setText(t.j.write_addition_title);
            return;
        }
        this.eMz.setVisibility(8);
    }

    private void aZV() {
        this.eJw = findViewById(t.g.post_prefix_layout);
        this.eJt = (TextView) findViewById(t.g.post_prefix);
        this.eMr = findViewById(t.g.prefix_divider);
        this.eJv = (ImageView) findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.eJw.setVisibility(0);
            this.eMr.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.eIV = 1;
            this.eJw.setOnClickListener(new an(this));
            this.eJv = (ImageView) findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.eJv.setVisibility(0);
                this.eJt.setOnClickListener(new ao(this));
            }
            this.eJu = new cg(getPageContext().getPageActivity());
            this.eJu.a(this);
            this.eJu.setMaxHeight(com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds510));
            this.eJu.setOutsideTouchable(true);
            this.eJu.setFocusable(true);
            this.eJu.setOnDismissListener(this);
            this.eJu.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.at.getColor(t.d.write_text);
            int color2 = com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(this.eJt, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(this.eJv, t.f.icon_title_down);
            this.eJt.setTextColor(color);
            this.eLc.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.eLc.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.eJu.addView(jVar);
            }
            this.eJu.qr(0);
            this.eJt.setText(prefixs.get(1));
            qN(1);
            return;
        }
        this.eJw.setVisibility(8);
    }

    private void bbt() {
        if (this.eMk && this.esv != null) {
            this.eMp.setVisibility(0);
            this.eMq.setVisibility(0);
            this.eMo = new p(this);
            this.eMo.oZ(this.esv.getForumName());
            this.eMo.setLoadDataCallBack(new ap(this));
        }
    }

    protected void bbu() {
        this.eJs.setOnClickListener(new aq(this));
    }

    protected void bbv() {
        this.eMu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eMu.cC(getPageContext().getString(t.j.is_save_draft)).am(false).a(getPageContext().getString(t.j.save), new ar(this)).b(getPageContext().getString(t.j.not_save), new at(this));
        this.eMu.b(getPageContext());
    }

    protected void aZW() {
        this.eJn = (EditText) findViewById(t.g.post_title);
        this.eJn.setOnClickListener(this.eMZ);
        this.eJn.setOnFocusChangeListener(this.eJl);
        if (this.esv.getType() == 0) {
            if (this.esv.getTitle() != null) {
                this.eJn.setText(this.esv.getTitle());
                this.eJn.setSelection(this.esv.getTitle().length());
            } else if (this.eMm) {
                this.eJn.setText(getResources().getString(t.j.vcode_feed_back_title));
            }
        } else if (this.esv.getType() != 1) {
            this.esv.getType();
        }
        this.eJn.addTextChangedListener(new au(this));
    }

    private TextWatcher aFg() {
        av avVar = new av(this);
        if (this.eMU && this.eMV) {
            if (this.eMS != null) {
                this.eMP.removeTextChangedListener(this.eMS);
            }
            this.eMS = avVar;
        } else if (this.eMU) {
            if (this.eMT != null) {
                this.eML.removeTextChangedListener(this.eMT);
            }
            this.eMT = avVar;
        }
        return avVar;
    }

    private long g(EditText editText) {
        if (editText == this.eML) {
            return 233L;
        }
        if (editText != this.eMP) {
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

    protected void aZY() {
        this.eJr = (EditText) findViewById(t.g.post_content);
        this.eJr.setDrawingCacheEnabled(false);
        this.eJr.setOnClickListener(this.eMZ);
        if (this.esv.getContent() != null && this.esv.getContent().length() > 0) {
            SpannableString x = TbFaceManager.EN().x(getPageContext().getPageActivity(), this.esv.getContent());
            this.eJr.setText(x);
            this.eJr.setSelection(x.length());
        } else if (this.esv.getType() == 2) {
            if (this.eMv) {
                if (this.eMw != null && this.eMw.length() > 0) {
                    this.eJr.setText(getPageContext().getPageActivity().getString(t.j.reply_sub_floor, new Object[]{this.eMw}));
                    this.eJr.setSelection(this.eJr.getText().length());
                }
            } else if (this.esv.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(t.j.reply_x_floor), Integer.valueOf(this.esv.getFloorNum()));
                this.eJr.setText(format);
                this.eJr.setSelection(format.length());
            }
        }
        this.eJr.setOnFocusChangeListener(this.eJl);
        this.eJr.setOnTouchListener(new ax(this));
        this.eJr.addTextChangedListener(new ay(this));
        jw(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.eMU) {
            bby().setPadding(0, 0, 0, 0);
            bby().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.at.l(bby(), t.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.cRp) && this.eMy == null) {
                com.baidu.adp.lib.g.c.hr().a(this.cRp, 19, new az(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbw() {
        int i = 5000;
        if (this.eMy != null) {
            i = 1000;
        }
        return bby().getText() != null && bby().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.atG != null) {
                this.atG.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aSE() && this.eMD == 0) {
            showToast(t.j.baobao_over_limit);
        } else {
            String charSequence = this.bZJ.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (((ImageSpan[]) bby().getText().getSpans(0, bby().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.eMx == null) {
                this.eMx = Toast.makeText(getPageContext().getPageActivity(), t.j.too_many_face, 0);
            }
            this.eMx.show();
            return;
        }
        String name = hVar.getName();
        EmotionGroupType yE = hVar.yE();
        if (name != null) {
            com.baidu.adp.lib.g.c.hr().a(name, 20, new ba(this, new SpannableStringBuilder(name), yE), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mK = aVar.mK();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mK);
        int width = mK.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        bby().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bby() {
        return this.eMU ? this.eML : this.eJr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bbz() {
        return this.eMU ? this.eMP : this.eJn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbA() {
        bby().onKeyDown(67, this.eMs);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.esv != null) {
            str = this.esv.getForumName();
        }
        if (getPageContext().getString(t.j.feedback_bar_name).equals(str)) {
            this.eMk = true;
        }
    }

    private void bbB() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bbC() {
        try {
            if (this.eMu != null) {
                this.eMu.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aDD.c(null);
        this.aDD.cY(t.j.sending);
        this.aDD.ay(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aDD.ay(false);
    }

    private Boolean bbD() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.avB = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZX() {
        String str;
        String str2 = null;
        if (this.esv != null) {
            String editable = bbz().getText().toString();
            String trim = bby().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.esv.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.eIV == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.esv.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.esv.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.esv.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.esv.setIsNoTitle(true);
                str = null;
            } else {
                this.esv.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.eMU) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.avr != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.esv.getVideoInfo() != null) {
                str = "1";
            }
            if (this.esv.getGraffitiFileName() != null) {
                str = "1";
            }
            if (this.esv.getType() == 4) {
                if (i(this.eML) && h(this.eMP)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.esv.getType() != 5) {
                str2 = str;
            } else if (i(this.eML)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.eJs.setEnabled(false);
            } else {
                this.eJs.setEnabled(true);
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
        this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.avv.b(this.avL);
        registerListener(this.eMY);
        this.dtc = new bb(this);
        this.esv = new WriteData();
        if (bundle != null) {
            this.esv.setType(bundle.getInt("type", 0));
            this.esv.setForumId(bundle.getString("forum_id"));
            this.esv.setForumName(bundle.getString("forum_name"));
            this.esv.setThreadId(bundle.getString("thread_id"));
            this.esv.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.esv.setFloorNum(bundle.getInt("floor_num", 0));
            this.eMk = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.eMm = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.eMv = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.eMw = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.avt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.eMy = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.esv.setIsAddition(this.eMy != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.eMD = bundle.getInt("mem_type", 0);
            this.adH = bundle.getString("from");
        } else {
            Intent intent = getIntent();
            this.esv.setType(intent.getIntExtra("type", 0));
            this.esv.setForumId(intent.getStringExtra("forum_id"));
            this.esv.setForumName(intent.getStringExtra("forum_name"));
            this.esv.setThreadId(intent.getStringExtra("thread_id"));
            this.esv.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.esv.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.eMk = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.eMm = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.eMv = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.eMw = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.eMy = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.esv.setIsAddition(this.eMy != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.eMD = intent.getIntExtra("mem_type", 0);
            this.adH = intent.getStringExtra("from");
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.esv.getType() == 4 ? 6 : 10);
        this.esv.setWriteImagesInfo(this.writeImagesInfo);
        this.esv.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.esv.getType() == 0) {
            com.baidu.tieba.tbadkCore.ad.c(this.esv.getForumId(), this);
        } else if (this.esv.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.esv.getThreadId(), this);
        } else if (this.esv.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.esv.getForumId()) + "photolive", this);
        } else if (this.esv.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.esv.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
        }
        this.cRp = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.esv != null && this.esv.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.esv.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.eMl = true;
        }
        bbp();
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.esv != null) {
                this.esv.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bbz().getText().toString()) || ((this.eMk || this.eMl) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.esv.setTitle(writeData.getTitle());
                    bbz().setText(this.esv.getTitle());
                    bbz().setSelection(this.esv.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.esv.setVideoInfo(videoInfo);
                    this.atG.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bby().getText().toString()) || this.eMk || this.eMl) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.esv.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.EN().a(getPageContext().getPageActivity(), this.esv.getContent(), new bc(this));
                    bby().setText(a2);
                    bby().setSelection(a2.length());
                    if (this.eMU) {
                        b(this.eMR, this.eML);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.esv.setWriteImagesInfo(this.writeImagesInfo);
                    bbI();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Ed();
                    }
                    jx(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.esv.setIsBaobao(writeData.getIsBaobao());
                        this.esv.setBaobaoContent(writeData.getBaobaoContent());
                        this.esv.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.esv.getIsBaobao()) {
                        Ef();
                        jy(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bbE();
                }
                aZX();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.bDI != null) {
                    this.eMG = this.eME.bqM;
                    this.bDT = this.eME.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.bDI.size()) {
                            break;
                        }
                        ev evVar = this.bDI.get(i2);
                        if (categoryTo != evVar.bqM) {
                            i = i2 + 1;
                        } else {
                            this.eMG = categoryTo;
                            this.bDT = evVar.name;
                            this.esv.setCategoryTo(this.eMG);
                            break;
                        }
                    }
                    if (this.eMH != null) {
                        this.eMH.setText(this.bDT);
                        this.eMH.b(this.bDI, this.eME, this.eMG);
                    }
                }
                this.esv.setGraffitiFileName(writeData.getGraffitiFileName());
                this.atG.b(new com.baidu.tbadk.editortools.a(42, 24, this.esv.getGraffitiFileName()));
                this.atG.BD();
                return;
            }
            return;
        }
        bbE();
    }

    private void bbE() {
        if ((!this.eMU || this.eMJ != null) && this.eMI != null) {
            this.eMJ.b(this.writeImagesInfo);
            bbH();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.esv.getType());
        bundle.putString("forum_id", this.esv.getForumId());
        bundle.putString("forum_name", this.esv.getForumName());
        bundle.putString("thread_id", this.esv.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.esv.getFloor());
        bundle.putInt("floor_num", this.esv.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.eMv);
        if (this.eMk) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avt);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.eMy);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.eMD);
        bundle.putString("from", this.adH);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bby().getEditableText().toString();
        if (editable != null) {
            bby().setText(TbFaceManager.EN().x(getPageContext().getPageActivity(), editable));
            bby().setSelection(bby().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baH() {
        aZP();
        String editable = bbz().getText().toString();
        this.esv.setContent(bby().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eIV != 0 && this.esv.getType() != 4) {
            this.esv.setTitle(String.valueOf(this.eJt.getText().toString()) + editable);
        } else {
            this.esv.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.esv.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.esv.getTitle());
        }
        if (this.eMk || this.eMl) {
            String string = getResources().getString(t.j.android_feedback);
            if (TextUtils.isEmpty(this.esv.getTitle()) || !this.esv.getTitle().startsWith(string)) {
                this.esv.setTitle(string + this.esv.getTitle());
            }
            String str = String.valueOf(getResources().getString(t.j.app_name)) + getResources().getString(t.j.tieba_client);
            if (TextUtils.isEmpty(this.esv.getContent()) || !this.esv.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.jf()) {
                    sb.append(com.baidu.adp.lib.util.i.jn());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.esv.getContent());
                this.esv.setContent(sb.toString());
            }
        }
        if (this.eMF >= 0) {
            this.esv.setCategoryFrom(this.eMF);
        }
        if (this.eMG >= 0) {
            this.esv.setCategoryTo(this.eMG);
        }
        this.esv.setWriteImagesInfo(this.writeImagesInfo);
        this.esv.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.esv.setHasLocationData(this.avu == null ? false : this.avu.aUk());
        this.avv.iN(this.writeImagesInfo.size() > 0);
        this.avv.d(this.esv);
        this.esv.setVcode(null);
        if (this.avr != null) {
            if (this.avr.getId() != null) {
                this.avv.aUF().setVoice(this.avr.getId());
                this.avv.aUF().setVoiceDuringTime(this.avr.duration);
            } else {
                this.avv.aUF().setVoice(null);
                this.avv.aUF().setVoiceDuringTime(-1);
            }
        } else {
            this.avv.aUF().setVoice(null);
            this.avv.aUF().setVoiceDuringTime(-1);
        }
        if (!this.avv.aUJ()) {
            showToast(t.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.dtc);
            if (!this.avv.aUG()) {
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
            if (this.eMy != null) {
                i2 = this.eMy.getTotalCount();
                i = this.eMy.getAlreadyCount() + 1;
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
                if (this.atG != null && !this.atG.Dk()) {
                    bby().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> t = com.baidu.tieba.tbadkCore.util.l.t(intent);
                if (t != null && t.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < t.size()) {
                            sb.append("@");
                            sb.append(t.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            bby().getText().insert(bby().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.esv.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.esv.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.esv.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.esv.getThreadId(), (WriteData) null);
                } else if (this.esv.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.esv.getForumId()) + "photolive", (WriteData) null);
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
                                aGG();
                            } else {
                                z(intent);
                            }
                        } else if (intExtra == 1) {
                            s(intent);
                        } else {
                            y(intent);
                        }
                    }
                } else if (i == 12012) {
                    if (!this.eMU) {
                        c(intent);
                        aZX();
                        return;
                    }
                    B(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.esv.setVideoInfo(videoInfo);
                        this.atG.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.atG.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.atG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    aZX();
                } else if (i == 12013) {
                    d(intent);
                    aZX();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.l(intent);
                }
            }
        } else if (i2 == 0) {
            if (this.atG != null && !this.atG.Dk()) {
                this.eJr.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DV();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bbG();
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
                    this.avt = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.as.b(getPageContext(), this.avt);
                    return;
                case 12012:
                    bbG();
                    return;
            }
        }
    }

    private void bbF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bbG() {
        if (this.eMU) {
            this.eMJ.b(this.writeImagesInfo);
            bbH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbH() {
        this.eMJ.notifyDataSetChanged();
        this.eMI.invalidate();
        this.mHandler.postDelayed(new bd(this), 550L);
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        aZX();
    }

    private void y(Intent intent) {
        if (this.eMU) {
            B(intent);
            bbG();
        } else {
            C(intent);
        }
        aZX();
    }

    private void B(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bbG();
            jx(true);
        }
    }

    private void z(Intent intent) {
        int size;
        b(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void aGG() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void s(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.dKU.parseJson(stringExtra);
            this.dKU.updateQuality();
            if (this.dKU.getChosedFiles() != null && this.dKU.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.dKU.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.dKU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bbz());
        HidenSoftKeyPad(this.mInputManager, bby());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent) {
        this.avt = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avt;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.avt, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bbI();
            Ed();
        }
        jx(true);
    }

    private void c(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bbI();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Ed();
                }
            }
            jx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbI() {
        if (this.atG.eC(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void d(Intent intent) {
        if (this.esv != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.esv.setIsBaobao(true);
            this.esv.setBaobaoContent(stringExtra2);
            Ef();
            jy(true);
        }
    }

    private void DV() {
        new be(this).execute(new Void[0]);
    }

    private void jx(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void jy(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bja == null) {
            this.bja = VoiceManager.instance();
        }
        return this.bja;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Qn() {
        this.bja = getVoiceManager();
        this.bja.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.pB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString2);
            } else if (this.eMy == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.avD = i;
        if (this.atG != null) {
            this.atG.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.atG.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Ed() {
        if (!this.eMU && this.atG != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.atG.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.atG.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.atG.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.atG.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Ef() {
        if (this.atG != null) {
            this.atG.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.atG.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.atG.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (this.atG != null) {
            this.atG.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void qN(int i) {
        if (i < this.eLc.size()) {
            for (int i2 = 0; i2 < this.eLc.size(); i2++) {
                this.eLc.get(i2).js(false);
            }
            this.eLc.get(i).js(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cg.a
    public void qy(int i) {
        this.eIV = i;
        this.eJu.qr(i);
        qN(i);
        this.eJt.setText(this.mPrefixData.getPrefixs().get(i));
        aZX();
        com.baidu.adp.lib.h.j.a(this.eJu, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.eJw.setSelected(false);
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
            com.baidu.adp.lib.util.k.c(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.esv != null) {
            if (this.esv.getType() == 4) {
                return "a015";
            }
            if (this.esv.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DQ();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.S(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.b(getPageContext(), this.avt);
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
        if (this.eMW != null) {
            this.eMW.onKeyboardVisibilityChanged(z);
        }
    }
}
