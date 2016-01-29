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
import com.baidu.tieba.frs.en;
import com.baidu.tieba.frs.eo;
import com.baidu.tieba.frs.ep;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.write.cc;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ad.a, cc.a {
    public static String etm = "from_writeActivity_livePhoto";
    private com.baidu.tbadk.editortools.k ath;
    private VoiceData.VoiceModel auR;
    private String auT;
    private com.baidu.tieba.tbadkCore.location.d auU;
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private VoiceManager ben;
    List<en> byj;
    private String byu;
    private int eoZ;
    private View epA;
    private TextView epx;
    private cc epy;
    private ImageView epz;
    private LinearLayout esC;
    private View esF;
    private View esG;
    private Toast esM;
    private AdditionData esN;
    private RelativeLayout esO;
    private TextView esP;
    private TextView esQ;
    private TextView esR;
    en esT;
    private int esU;
    private int esV;
    private PostCategoryView esW;
    private com.baidu.tieba.view.a etr;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData dZC = null;
    private boolean esA = false;
    private boolean esB = false;
    private InputMethodManager mInputManager = null;
    private EditText epr = null;
    private View eps = null;
    private LinearLayout epu = null;
    private EditText epv = null;
    private o esD = null;
    private FeedBackTopListView esE = null;
    private ArrayList<com.baidu.tieba.write.view.j> erj = new ArrayList<>();
    private String cxU = null;
    private final KeyEvent esH = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View ajk = null;
    private TextView esI = null;
    private TextView epw = null;
    private TextView bPr = null;
    private DialogInterface.OnCancelListener cYA = null;
    private com.baidu.tbadk.core.dialog.a esJ = null;
    private final Handler mHandler = new Handler();
    private boolean esK = false;
    private String esL = null;
    private RelativeLayout bOs = null;
    private String avb = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int avd = 0;
    private int esS = 0;
    private WriteImagesInfo dqy = new WriteImagesInfo();
    private View mRootView = null;
    private GridView esX = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a esY = null;
    private ScrollView esZ = null;
    private EditText eta = null;
    private View etb = null;
    private View etd = null;
    private View ete = null;
    private EditText etf = null;
    private TextView etg = null;
    private TextView eth = null;
    private TextWatcher eti = null;
    private TextWatcher etj = null;
    private boolean etk = false;
    private boolean etl = false;
    private final HttpMessageListener etn = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d avl = new aj(this);
    private final d.a avj = new av(this);
    private final CustomMessageListener dYT = new be(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener eto = new bf(this);
    private boolean etp = true;
    private final View.OnFocusChangeListener epp = new bg(this);
    private final CustomMessageListener etq = new bh(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0084a cRX = new bi(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(t.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Di();
        } else if (this.auU.aNg()) {
            Dg();
        } else {
            this.auU.hW(false);
            a(1, true, (String) null);
            this.auU.aNe();
        }
    }

    private void Di() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(t.j.location_app_permission_prompt).a(t.j.isopen, new bj(this)).b(t.j.cancel, new z(this)).b(getPageContext());
        aVar.uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aUH() {
        int selectionEnd = aUY().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aUY().getText().getSpans(0, aUY().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aUY().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aUY().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUI() {
        if (this.ath != null) {
            this.ath.setBarLauncherEnabled(!this.etp);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.etk) {
            this.epr.setVisibility(8);
            if (this.dZC.getType() == 5) {
                this.ete.setVisibility(8);
            } else {
                this.ete.setVisibility(0);
            }
            b(this.eth, this.eta);
            b(this.etg, this.etf);
            aTx();
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
        qD();
        aUT();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.etq.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.etq);
        this.auU = new com.baidu.tieba.tbadkCore.location.d(this);
        this.auU.a(this.avj);
        registerListener(this.dYT);
        initEditor();
        if (this.etk) {
            this.esY.setEditorTools(this.ath);
        } else {
            this.epv.requestFocus();
        }
    }

    private void initEditor() {
        this.ath = new com.baidu.tbadk.editortools.k(getActivity());
        this.ath.setBarMaxLauCount(4);
        this.ath.setMoreButtonAtEnd(true);
        this.ath.setBarLauncherType(1);
        this.ath.setBarLinePostion(2);
        this.ath.setMoreLauncherIcon(t.f.write_more);
        this.ath.setBackgroundColorId(t.d.cp_bg_line_d);
        switch (this.dZC.getType()) {
            case 4:
            case 5:
                aUL();
                break;
            default:
                aUM();
                break;
        }
        this.ath.CA();
        if (this.esC != null) {
            this.esC.addView(this.ath);
        }
        aUN();
        this.ath.ow();
        com.baidu.tbadk.editortools.r ev = this.ath.ev(6);
        if (ev != null && !TextUtils.isEmpty(this.avb)) {
            ((View) ev).setOnClickListener(new aa(this));
        }
        if (!this.etk) {
            this.ath.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ath.Ba();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("xiaoying_has_click", false)) {
            this.ath.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aUJ() {
        this.etb = this.mRootView.findViewById(t.g.photo_live_scroll);
        this.ete = this.etb.findViewById(t.g.live_post_title_container);
        this.eta = (EditText) this.etb.findViewById(t.g.live_post_content);
        this.esX = (GridView) this.etb.findViewById(t.g.photoLiveGridView);
        this.etf = (EditText) this.etb.findViewById(t.g.live_post_title);
        this.etg = (TextView) this.etb.findViewById(t.g.titleOverPlusNumber);
        this.eth = (TextView) this.etb.findViewById(t.g.contentOverPlusNumber);
        this.etd = this.etb.findViewById(t.g.live_interval_view);
        this.etg.setText(String.valueOf(20));
        this.eth.setText(String.valueOf(233));
        this.etb.setVisibility(0);
        this.etg.setVisibility(0);
        this.eth.setVisibility(0);
        this.etf.setHint(t.j.tips_title_limit_new);
        this.etf.setOnFocusChangeListener(new ab(this));
        if (this.dZC.getType() == 4) {
            this.eta.setHint(t.j.live_write_input_content_new);
        } else if (this.dZC.getType() == 5) {
            this.eta.setHint(t.j.live_write_input_content_update);
        }
        this.eta.setOnFocusChangeListener(new ac(this));
        this.eta.requestFocus();
        this.eta.addTextChangedListener(axC());
        this.etf.requestFocus();
        this.etf.addTextChangedListener(axC());
        this.etf.setOnClickListener(this.eto);
        this.eta.setOnClickListener(this.eto);
        this.esY = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.esX);
        this.esY.pK(6);
        this.esX.setAdapter((ListAdapter) this.esY);
        View findViewById = this.etb.findViewById(t.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ad(this));
        aUK();
    }

    private void aUK() {
        if (this.dZC.getType() == 0) {
            if (this.dZC.getTitle() != null) {
                this.etf.setText(this.dZC.getTitle());
                this.etf.setSelection(this.dZC.getTitle().length());
            }
        } else if (this.dZC.getType() != 1) {
            this.dZC.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.etk) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aVf();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Dt();
            return;
        }
        if (this.ath.CC()) {
            this.ath.Ba();
        }
        String str = null;
        if (this.dZC != null) {
            str = this.dZC.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.etk) {
            albumActivityConfig.getIntent().putExtra("from", etm);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aUL() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ath.u(arrayList);
        com.baidu.tbadk.editortools.y ex = this.ath.ex(5);
        if (ex != null) {
            ex.launcherPriority = 2;
            ex.launcherIcon = t.f.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.launcherIcon = t.f.write_at;
        this.ath.b(aVar);
        this.ath.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aUM() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.y yVar;
        com.baidu.tbadk.editortools.y yVar2;
        com.baidu.tbadk.editortools.y yVar3;
        com.baidu.tbadk.editortools.y yVar4;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        iVar.launcherIcon = t.f.write_picture;
        this.ath.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.ath.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask2 != null && (yVar4 = (com.baidu.tbadk.editortools.y) runTask2.getData()) != null) {
            yVar4.launcherPriority = 4;
            yVar4.launcherIcon = t.f.write_privilege;
            this.ath.b(yVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar.launcherIcon = t.f.write_at;
        this.ath.b(aVar);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask3 != null && (yVar3 = (com.baidu.tbadk.editortools.y) runTask3.getData()) != null) {
            yVar3.toolNeedAction = true;
            yVar3.launcherPriority = 8;
            yVar3.launcherIcon = 0;
            this.ath.b(yVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask4 != null && (yVar2 = (com.baidu.tbadk.editortools.y) runTask4.getData()) != null) {
            yVar2.toolNeedAction = true;
            yVar2.launcherPriority = 9;
            yVar2.launcherIcon = 0;
            this.ath.b(yVar2);
        }
        Boolean aVd = aVd();
        if (!this.esA && aVd != null && aVd.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.aNC() && com.baidu.tieba.tbadkCore.u.a(this.dZC.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.y.class)) != null && (yVar = (com.baidu.tbadk.editortools.y) runTask.getData()) != null) {
            yVar.launcherPriority = 6;
            this.ath.b(yVar);
        }
        if (this.dZC != null && this.dZC.getType() == 0 && !this.esA && !this.esB) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.esN == null) {
            this.ath.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.ath.u(arrayList);
        com.baidu.tbadk.editortools.y ex = this.ath.ex(5);
        if (ex != null) {
            ex.launcherPriority = 2;
            ex.launcherIcon = t.f.write_face;
        }
        com.baidu.tbadk.editortools.y ex2 = this.ath.ex(13);
        if (ex2 != null) {
            ex2.launcherPriority = 7;
        }
    }

    private void aUN() {
        ae aeVar = new ae(this);
        this.ath.a(16, aeVar);
        this.ath.a(21, aeVar);
        this.ath.a(14, aeVar);
        this.ath.a(24, aeVar);
        this.ath.a(3, aeVar);
        this.ath.a(10, aeVar);
        this.ath.a(11, aeVar);
        this.ath.a(12, aeVar);
        this.ath.a(13, aeVar);
        this.ath.a(22, aeVar);
        this.ath.a(23, aeVar);
        this.ath.a(15, aeVar);
        this.ath.a(18, aeVar);
        this.ath.a(25, aeVar);
        this.ath.a(27, aeVar);
        this.ath.a(29, aeVar);
    }

    public void aOa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        if (this.auU.aNi()) {
            if (this.auU.aNg()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aNb().getLocationData().aMX());
                return;
            }
            a(1, true, (String) null);
            this.auU.aNe();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aTp() {
        if (this.auV != null) {
            this.auV.cancelLoadData();
        }
        if (this.esD != null) {
            this.esD.cancelLoadData();
        }
        if (this.auU != null) {
            this.auU.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aTp();
        aVc();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUO() {
        if (this.dZC != null && this.dZC.getType() == 2 && this.esK) {
            finish();
        } else if (this.dZC == null) {
            finish();
        } else {
            this.dZC.setTitle(aUZ().getText().toString());
            this.dZC.setContent(aUY().getText().toString());
            int type = this.dZC.getType();
            if (type == 0) {
                com.baidu.tieba.tbadkCore.ad.b(this.dZC.getForumId(), this.dZC);
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.dZC.getThreadId(), this.dZC);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.dZC.getForumId()) + "photolive", this.dZC);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.dZC.getThreadId()) + "updatephotolive", this.dZC);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.epy != null && this.epy.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.epy, getPageContext().getPageActivity());
                return true;
            } else if (this.ath.CC()) {
                this.ath.Ba();
                return true;
            } else {
                aTp();
                aUO();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.bOs);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ar.k(this.epw, t.f.s_navbar_button_bg);
        aUI();
        com.baidu.tbadk.core.util.ar.l(this.etb, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(this.eps, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.etd, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(aUZ(), t.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.cxU)) {
            com.baidu.tbadk.core.util.ar.l(aUY(), t.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_e);
        aUZ().setTextColor(color);
        aUY().setTextColor(color);
        a(aUZ(), color2);
        a(aUY(), color2);
        aTx();
        this.ath.onChangeSkinType(i);
        if (this.esW != null) {
            this.esW.xf();
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

    private void qD() {
        this.etk = this.dZC.getType() == 4 || 5 == this.dZC.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(t.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bPr = this.mNavigationBar.setTitleText("");
        this.esI = (TextView) findViewById(t.g.btn_image_problem);
        this.epw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.epw.setLayoutParams(layoutParams);
        this.epw.setOnFocusChangeListener(this.epp);
        this.esZ = (ScrollView) findViewById(t.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.esE = (FeedBackTopListView) findViewById(t.g.feedback_top_list);
        this.esF = findViewById(t.g.feedback_divider);
        this.bOs = (RelativeLayout) findViewById(t.g.parent);
        this.esC = (LinearLayout) findViewById(t.g.tool_view);
        this.eps = findViewById(t.g.interval_view);
        aTw();
        if (this.etk) {
            this.esZ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aUJ();
        }
        aTy();
        if (this.esA || this.esB) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(t.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(t.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.epu = (LinearLayout) findViewById(t.g.post_content_container);
        this.epu.setDrawingCacheEnabled(false);
        this.epu.setOnClickListener(new af(this));
        this.ajk.setOnFocusChangeListener(this.epp);
        this.ajk.setOnClickListener(new ag(this));
        this.esI.setOnClickListener(new ah(this));
        aUQ();
        j(aVd());
        aUU();
        aOa();
        switch (this.dZC.getType()) {
            case 0:
                if (this.esA || this.esB) {
                    this.bPr.setText(t.j.feedback);
                } else {
                    this.bPr.setText(t.j.post_new_thread);
                }
                this.epr.setVisibility(0);
                this.epv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bPr.setText(t.j.send_reply);
                this.epv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.epr.setVisibility(8);
                break;
            case 4:
                this.bPr.setText(t.j.publish_photo_live);
                this.epv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bPr.setText(getPageContext().getResources().getString(t.j.update_photo_live_tip, Integer.valueOf(this.dZC.getFloorNum() + 1)));
                this.etd.setVisibility(8);
                break;
        }
        aUV();
        aVb();
        aUI();
        aUS();
        aTv();
        if (this.dZC.getType() == 4 && this.epA != null && this.esG != null) {
            this.epA.setVisibility(8);
            this.esG.setVisibility(8);
        }
        aTx();
        ShowSoftKeyPad(this.mInputManager, this.epr);
        aUR();
    }

    private void aUP() {
        this.byj = null;
        this.esU = -1;
        this.esV = -1;
        ep gz = eo.Qz().gz(1);
        if (gz != null) {
            this.byj = gz.bly;
            this.esU = getIntent().getIntExtra("category_id", -1);
            if (this.byj != null && !this.byj.isEmpty() && this.esU >= 0) {
                this.esT = new en();
                this.esT.blu = 0;
                this.esT.name = getPageContext().getResources().getString(t.j.category_auto);
                this.esV = this.esT.blu;
                this.byu = this.esT.name;
                for (en enVar : this.byj) {
                    if (enVar.blu == this.esU) {
                        this.esV = enVar.blu;
                        this.byu = enVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void aUQ() {
        if (this.byj != null && !this.byj.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(t.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(t.g.interval_view_cate).setVisibility(0);
            this.esW = (PostCategoryView) linearLayout.findViewById(t.g.category_selected);
            this.esW.setText(this.byu);
            this.esW.b(this.byj, this.esT, this.esV);
            this.esW.setCategoryContainerClickCallback(new ai(this));
            linearLayout.setOnClickListener(new ak(this));
        }
    }

    private void aUR() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.etr = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.etr.setTitle(t.j.no_disturb_start_time);
        this.etr.setButton(-1, getPageContext().getString(t.j.alert_yes_button), this.etr);
        this.etr.setButton(-2, getPageContext().getString(t.j.alert_no_button), this.etr);
        return this.etr;
    }

    private void aUS() {
        this.esO = (RelativeLayout) findViewById(t.g.addition_container);
        this.esP = (TextView) findViewById(t.g.addition_create_time);
        this.esQ = (TextView) findViewById(t.g.addition_last_time);
        this.esR = (TextView) findViewById(t.g.addition_last_content);
        if (this.esN != null) {
            this.esO.setVisibility(0);
            this.esP.setText(String.valueOf(getPageContext().getString(t.j.write_addition_create)) + com.baidu.tbadk.core.util.aw.t(this.esN.getCreateTime() * 1000));
            if (this.esN.getAlreadyCount() == 0) {
                this.esQ.setVisibility(8);
            } else {
                this.esQ.setText(String.valueOf(getPageContext().getString(t.j.write_addition_last)) + com.baidu.tbadk.core.util.aw.t(this.esN.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.esN.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.esR.setText(lastAdditionContent);
            } else {
                this.esR.setVisibility(8);
            }
            aUY().setHint(String.format(getPageContext().getString(t.j.write_addition_hint), Integer.valueOf(this.esN.getAlreadyCount()), Integer.valueOf(this.esN.getTotalCount())));
            this.bPr.setText(t.j.write_addition_title);
            return;
        }
        this.esO.setVisibility(8);
    }

    private void aTv() {
        this.epA = findViewById(t.g.post_prefix_layout);
        this.epx = (TextView) findViewById(t.g.post_prefix);
        this.esG = findViewById(t.g.prefix_divider);
        this.epz = (ImageView) findViewById(t.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.epA.setVisibility(0);
            this.esG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.eoZ = 1;
            this.epA.setOnClickListener(new am(this));
            this.epz = (ImageView) findViewById(t.g.prefix_icon);
            if (size > 1) {
                this.epz.setVisibility(0);
                this.epx.setOnClickListener(new an(this));
            }
            this.epy = new cc(getPageContext().getPageActivity());
            this.epy.a(this);
            this.epy.setMaxHeight(com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds510));
            this.epy.setOutsideTouchable(true);
            this.epy.setFocusable(true);
            this.epy.setOnDismissListener(this);
            this.epy.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ar.getColor(t.d.write_text);
            int color2 = com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.k(this.epx, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.c(this.epz, t.f.icon_title_down);
            this.epx.setTextColor(color);
            this.erj.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.erj.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.epy.addView(jVar);
            }
            this.epy.py(0);
            this.epx.setText(prefixs.get(1));
            pT(1);
            return;
        }
        this.epA.setVisibility(8);
    }

    private void aUT() {
        if (this.esA && this.dZC != null) {
            this.esE.setVisibility(0);
            this.esF.setVisibility(0);
            this.esD = new o(this);
            this.esD.nK(this.dZC.getForumName());
            this.esD.setLoadDataCallBack(new ao(this));
        }
    }

    protected void aUU() {
        this.epw.setOnClickListener(new ap(this));
    }

    protected void aUV() {
        this.esJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.esJ.cE(getPageContext().getString(t.j.is_save_draft)).aj(false).a(getPageContext().getString(t.j.save), new aq(this)).b(getPageContext().getString(t.j.not_save), new as(this));
        this.esJ.b(getPageContext());
    }

    protected void aTw() {
        this.epr = (EditText) findViewById(t.g.post_title);
        this.epr.setOnClickListener(this.eto);
        this.epr.setOnFocusChangeListener(this.epp);
        if (this.dZC.getType() == 0) {
            if (this.dZC.getTitle() != null) {
                this.epr.setText(this.dZC.getTitle());
                this.epr.setSelection(this.dZC.getTitle().length());
            }
        } else if (this.dZC.getType() != 1) {
            this.dZC.getType();
        }
        this.epr.addTextChangedListener(new at(this));
    }

    private TextWatcher axC() {
        au auVar = new au(this);
        if (this.etk && this.etl) {
            if (this.eti != null) {
                this.etf.removeTextChangedListener(this.eti);
            }
            this.eti = auVar;
        } else if (this.etk) {
            if (this.etj != null) {
                this.eta.removeTextChangedListener(this.etj);
            }
            this.etj = auVar;
        }
        return auVar;
    }

    private long g(EditText editText) {
        if (editText == this.eta) {
            return 233L;
        }
        if (editText != this.etf) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void aTy() {
        this.epv = (EditText) findViewById(t.g.post_content);
        this.epv.setDrawingCacheEnabled(false);
        this.epv.setOnClickListener(this.eto);
        if (this.dZC.getContent() != null && this.dZC.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Ec().G(getPageContext().getPageActivity(), this.dZC.getContent());
            this.epv.setText(G);
            this.epv.setSelection(G.length());
        } else if (this.dZC.getType() == 2) {
            if (this.esK) {
                if (this.esL != null && this.esL.length() > 0) {
                    this.epv.setText(getPageContext().getPageActivity().getString(t.j.reply_sub_floor, new Object[]{this.esL}));
                    this.epv.setSelection(this.epv.getText().length());
                }
            } else if (this.dZC.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(t.j.reply_x_floor), Integer.valueOf(this.dZC.getFloorNum()));
                this.epv.setText(format);
                this.epv.setSelection(format.length());
            }
        }
        this.epv.setOnFocusChangeListener(this.epp);
        this.epv.setOnTouchListener(new aw(this));
        this.epv.addTextChangedListener(new ax(this));
        iG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.etk) {
            aUY().setPadding(0, 0, 0, 0);
            aUY().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ar.l(aUY(), t.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.cxU) && this.esN == null) {
                com.baidu.adp.lib.g.c.hl().a(this.cxU, 19, new ay(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUW() {
        int i = 5000;
        if (this.esN != null) {
            i = 1000;
        }
        return aUY().getText() != null && aUY().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUX() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.ath != null) {
                this.ath.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aLK() && this.esS == 0) {
            showToast(t.j.baobao_over_limit);
        } else {
            String charSequence = this.bPr.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (((ImageSpan[]) aUY().getText().getSpans(0, aUY().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.esM == null) {
                this.esM = Toast.makeText(getPageContext().getPageActivity(), t.j.too_many_face, 0);
            }
            this.esM.show();
            return;
        }
        String name = hVar.getName();
        EmotionGroupType yd = hVar.yd();
        if (name != null) {
            com.baidu.adp.lib.g.c.hl().a(name, 20, new az(this, new SpannableStringBuilder(name), yd), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mS = aVar.mS();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mS);
        int width = mS.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        aUY().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aUY() {
        return this.etk ? this.eta : this.epv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aUZ() {
        return this.etk ? this.etf : this.epr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVa() {
        aUY().onKeyDown(67, this.esH);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.dZC != null) {
            str = this.dZC.getForumName();
        }
        if (getPageContext().getString(t.j.feedback_bar_name).equals(str)) {
            this.esA = true;
        }
    }

    private void aVb() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aVc() {
        try {
            if (this.esJ != null) {
                this.esJ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    private Boolean aVd() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.avb = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTx() {
        String str;
        String str2 = null;
        if (this.dZC != null) {
            String editable = aUZ().getText().toString();
            String trim = aUY().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.dZC.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.eoZ == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.dZC.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.dZC.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dZC.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.dZC.setIsNoTitle(true);
                str = null;
            } else {
                this.dZC.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.etk) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.auR != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.dZC.getVideoInfo() != null) {
                str = "1";
            }
            if (this.dZC.getType() == 4) {
                if (i(this.eta) && h(this.etf)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.dZC.getType() != 5) {
                str2 = str;
            } else if (i(this.eta)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.epw.setEnabled(false);
            } else {
                this.epw.setEnabled(true);
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
        this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.auV.b(this.avl);
        registerListener(this.etn);
        this.cYA = new ba(this);
        this.dZC = new WriteData();
        if (bundle != null) {
            this.dZC.setType(bundle.getInt("type", 0));
            this.dZC.setForumId(bundle.getString("forum_id"));
            this.dZC.setForumName(bundle.getString("forum_name"));
            this.dZC.setThreadId(bundle.getString("thread_id"));
            this.dZC.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.dZC.setFloorNum(bundle.getInt("floor_num", 0));
            this.esA = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.esK = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.esL = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.auT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.esN = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.dZC.setIsAddition(this.esN != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.esS = bundle.getInt("mem_type", 0);
        } else {
            Intent intent = getIntent();
            this.dZC.setType(intent.getIntExtra("type", 0));
            this.dZC.setForumId(intent.getStringExtra("forum_id"));
            this.dZC.setForumName(intent.getStringExtra("forum_name"));
            this.dZC.setThreadId(intent.getStringExtra("thread_id"));
            this.dZC.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.dZC.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.esA = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.esK = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.esL = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.esN = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.dZC.setIsAddition(this.esN != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.esS = intent.getIntExtra("mem_type", 0);
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.dZC.getType() == 4 ? 6 : 10);
        this.dZC.setWriteImagesInfo(this.writeImagesInfo);
        this.dZC.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.dZC.getType() == 0) {
            com.baidu.tieba.tbadkCore.ad.c(this.dZC.getForumId(), this);
        } else if (this.dZC.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.dZC.getThreadId(), this);
        } else if (this.dZC.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.dZC.getForumId()) + "photolive", this);
        } else if (this.dZC.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.dZC.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
        }
        this.cxU = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.dZC != null && this.dZC.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.dZC.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.esB = true;
        }
        aUP();
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.dZC != null) {
                this.dZC.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aUZ().getText().toString()) || ((this.esA || this.esB) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.dZC.setTitle(writeData.getTitle());
                    aUZ().setText(this.dZC.getTitle());
                    aUZ().setSelection(this.dZC.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.dZC.setVideoInfo(videoInfo);
                    this.ath.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aUY().getText().toString()) || this.esA || this.esB) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.dZC.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ec().a(getPageContext().getPageActivity(), this.dZC.getContent(), new bb(this));
                    aUY().setText(a2);
                    aUY().setSelection(a2.length());
                    if (this.etk) {
                        b(this.eth, this.eta);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.dZC.setWriteImagesInfo(this.writeImagesInfo);
                    aVi();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Dt();
                    }
                    iH(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.dZC.setIsBaobao(writeData.getIsBaobao());
                        this.dZC.setBaobaoContent(writeData.getBaobaoContent());
                        this.dZC.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.dZC.getIsBaobao()) {
                        Dv();
                        iI(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aVe();
                }
                aTx();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.byj != null) {
                    this.esV = this.esT.blu;
                    this.byu = this.esT.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.byj.size()) {
                            break;
                        }
                        en enVar = this.byj.get(i2);
                        if (categoryTo != enVar.blu) {
                            i = i2 + 1;
                        } else {
                            this.esV = categoryTo;
                            this.byu = enVar.name;
                            this.dZC.setCategoryTo(this.esV);
                            break;
                        }
                    }
                    if (this.esW != null) {
                        this.esW.setText(this.byu);
                        this.esW.b(this.byj, this.esT, this.esV);
                    }
                }
                this.ath.Ba();
                return;
            }
            return;
        }
        aVe();
    }

    private void aVe() {
        if ((!this.etk || this.esY != null) && this.esX != null) {
            this.esY.b(this.writeImagesInfo);
            aVh();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.dZC.getType());
        bundle.putString("forum_id", this.dZC.getForumId());
        bundle.putString("forum_name", this.dZC.getForumName());
        bundle.putString("thread_id", this.dZC.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.dZC.getFloor());
        bundle.putInt("floor_num", this.dZC.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.esK);
        if (this.esA) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.auT);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.esN);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.esS);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aUY().getEditableText().toString();
        if (editable != null) {
            aUY().setText(TbFaceManager.Ec().G(getPageContext().getPageActivity(), editable));
            aUY().setSelection(aUY().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        aTp();
        String editable = aUZ().getText().toString();
        this.dZC.setContent(aUY().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eoZ != 0 && this.dZC.getType() != 4) {
            this.dZC.setTitle(String.valueOf(this.epx.getText().toString()) + editable);
        } else {
            this.dZC.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.dZC.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.dZC.getTitle());
        }
        if (this.esA || this.esB) {
            String string = getResources().getString(t.j.android_feedback);
            if (TextUtils.isEmpty(this.dZC.getTitle()) || !this.dZC.getTitle().startsWith(string)) {
                this.dZC.setTitle(string + this.dZC.getTitle());
            }
            String str = String.valueOf(getResources().getString(t.j.app_name)) + getResources().getString(t.j.tieba_client);
            if (TextUtils.isEmpty(this.dZC.getContent()) || !this.dZC.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iZ()) {
                    sb.append(com.baidu.adp.lib.util.i.jh());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.dZC.getContent());
                this.dZC.setContent(sb.toString());
            }
        }
        if (this.esU >= 0) {
            this.dZC.setCategoryFrom(this.esU);
        }
        if (this.esV >= 0) {
            this.dZC.setCategoryTo(this.esV);
        }
        this.dZC.setWriteImagesInfo(this.writeImagesInfo);
        this.dZC.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.dZC.setHasLocationData(this.auU == null ? false : this.auU.aNi());
        this.auV.hX(this.writeImagesInfo.size() > 0);
        this.auV.c(this.dZC);
        this.dZC.setVcode(null);
        if (this.auR != null) {
            if (this.auR.getId() != null) {
                this.auV.aND().setVoice(this.auR.getId());
                this.auV.aND().setVoiceDuringTime(this.auR.duration);
            } else {
                this.auV.aND().setVoice(null);
                this.auV.aND().setVoiceDuringTime(-1);
            }
        } else {
            this.auV.aND().setVoice(null);
            this.auV.aND().setVoiceDuringTime(-1);
        }
        if (!this.auV.aNH()) {
            showToast(t.j.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(t.j.sending), this.cYA);
        if (!this.auV.aNE()) {
        }
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.esN != null) {
                i2 = this.esN.getTotalCount();
                i = this.esN.getAlreadyCount() + 1;
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
                if (this.ath != null && !this.ath.CC()) {
                    aUY().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> V = com.baidu.tieba.tbadkCore.util.l.V(intent);
                if (V != null && V.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < V.size()) {
                            sb.append("@");
                            sb.append(V.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            aUY().getText().insert(aUY().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.dZC.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.dZC.getForumId(), (WriteData) null);
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.dZC.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.dZC.getThreadId(), (WriteData) null);
                } else if (this.dZC.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.dZC.getForumId()) + "photolive", (WriteData) null);
                    a((PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"), PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                azl();
                            } else {
                                ab(intent);
                            }
                        } else if (intExtra == 1) {
                            U(intent);
                        } else {
                            aa(intent);
                        }
                    }
                } else if (i == 12012) {
                    if (!this.etk) {
                        G(intent);
                        aTx();
                        return;
                    }
                    ad(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.dZC.setVideoInfo(videoInfo);
                        this.ath.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ath.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ath.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    aTx();
                } else if (i == 12013) {
                    H(intent);
                    aTx();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.ath != null && !this.ath.CC()) {
                this.epv.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dm();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aVg();
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
                    this.auT = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.aq.b(getPageContext(), this.auT);
                    return;
                case 12012:
                    aVg();
                    return;
            }
        }
    }

    private void aVf() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aVg() {
        if (this.etk) {
            this.esY.b(this.writeImagesInfo);
            aVh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVh() {
        this.esY.notifyDataSetChanged();
        this.esX.invalidate();
        this.mHandler.postDelayed(new bc(this), 550L);
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        aTx();
    }

    private void aa(Intent intent) {
        if (this.etk) {
            ad(intent);
            aVg();
        } else {
            ae(intent);
        }
        aTx();
    }

    private void ad(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aVg();
            iH(true);
        }
    }

    private void ab(Intent intent) {
        int size;
        F(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void azl() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
        }
    }

    private void U(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.dqy.parseJson(stringExtra);
            this.dqy.updateQuality();
            if (this.dqy.getChosedFiles() != null && this.dqy.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.dqy.getChosedFiles().get(0).getFilePath(), 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
            }
            this.dqy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aUZ());
        HidenSoftKeyPad(this.mInputManager, aUY());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ae(Intent intent) {
        b(intent, true);
    }

    private void F(Intent intent) {
        this.auT = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.auT;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.auT, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aVi();
            Dt();
        }
        iH(true);
    }

    private void G(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                aVi();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Dt();
                }
            }
            iH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVi() {
        if (this.ath.ex(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void H(Intent intent) {
        if (this.dZC != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.dZC.setIsBaobao(true);
            this.dZC.setBaobaoContent(stringExtra2);
            Dv();
            iI(true);
        }
    }

    private void Dm() {
        new bd(this).execute(new Void[0]);
    }

    private void iH(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void iI(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.ben == null) {
            this.ben = VoiceManager.instance();
        }
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Oy() {
        this.ben = getVoiceManager();
        this.ben.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.or(postWriteCallBackData.getErrorCode())) {
                AntiHelper.X(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString2);
            } else if (this.esN == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.avd = i;
        if (this.ath != null) {
            this.ath.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.ath.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Dt() {
        if (!this.etk && this.ath != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.ath.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.ath.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ath.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ath.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Dv() {
        if (this.ath != null) {
            this.ath.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.ath.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.ath.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.ath != null) {
            this.ath.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void pT(int i) {
        if (i < this.erj.size()) {
            for (int i2 = 0; i2 < this.erj.size(); i2++) {
                this.erj.get(i2).iC(false);
            }
            this.erj.get(i).iC(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cc.a
    public void pF(int i) {
        this.eoZ = i;
        this.epy.py(i);
        pT(i);
        this.epx.setText(this.mPrefixData.getPrefixs().get(i));
        aTx();
        com.baidu.adp.lib.h.j.a(this.epy, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.epA.setSelected(false);
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
}
