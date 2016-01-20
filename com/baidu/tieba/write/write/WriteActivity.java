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
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ae.a, cf.a {
    public static String dYw = "from_writeActivity_livePhoto";
    private com.baidu.tbadk.editortools.k aso;
    private VoiceData.VoiceModel atZ;
    private String aub;
    private com.baidu.tieba.tbadkCore.location.d auc;
    private com.baidu.tieba.tbadkCore.writeModel.a aud;
    List<ec> bve;
    private String bvo;
    private TextView dUS;
    private cf dUT;
    private ImageView dUU;
    private View dUV;
    private int dUu;
    private LinearLayout dXJ;
    private View dXM;
    private View dXN;
    private Toast dXT;
    private AdditionData dXU;
    private RelativeLayout dXV;
    private TextView dXW;
    private TextView dXX;
    private TextView dXY;
    private com.baidu.tieba.view.a dYC;
    private RelativeLayout dYa;
    private TextView dYb;
    private View dYc;
    private LiveBroadcastCard dYd;
    ec dYe;
    private int dYf;
    private int dYg;
    private PostCategoryView dYh;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData dJy = null;
    private boolean dXH = false;
    private boolean dXI = false;
    private InputMethodManager mInputManager = null;
    private EditText dUM = null;
    private View dUN = null;
    private LinearLayout dUP = null;
    private EditText dUQ = null;
    private o dXK = null;
    private FeedBackTopListView dXL = null;
    private ArrayList<com.baidu.tieba.write.view.j> dWq = new ArrayList<>();
    private String cro = null;
    private final KeyEvent dXO = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView dXP = null;
    private TextView dUR = null;
    private TextView bLD = null;
    private DialogInterface.OnCancelListener cPd = null;
    private com.baidu.tbadk.core.dialog.a dXQ = null;
    private final Handler mHandler = new Handler();
    private boolean dXR = false;
    private String dXS = null;
    private RelativeLayout bKF = null;
    private String auj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int aul = 0;
    private int dXZ = 0;
    private WriteImagesInfo ddo = new WriteImagesInfo();
    private View mRootView = null;
    private GridView dYi = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a dYj = null;
    private ScrollView dYk = null;
    private EditText dYl = null;
    private View dYm = null;
    private View dYn = null;
    private View dYo = null;
    private EditText dYp = null;
    private TextView dYq = null;
    private TextView dYr = null;
    private TextWatcher dYs = null;
    private TextWatcher dYt = null;
    private boolean dYu = false;
    private boolean dYv = false;
    private final HttpMessageListener dYx = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d aut = new aj(this);
    private final d.a aur = new av(this);
    private final CustomMessageListener dIT = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener dYy = new bi(this);
    private Runnable dYz = new bj(this);
    private boolean dYA = true;
    private final View.OnFocusChangeListener dUK = new bk(this);
    private final CustomMessageListener dYB = new bl(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0080a cJS = new bm(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void BR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(n.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BS();
        } else if (this.auc.aGb()) {
            BQ();
        } else {
            this.auc.hv(false);
            a(1, true, (String) null);
            this.auc.aFZ();
        }
    }

    private void BS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bG(n.j.location_app_permission_prompt).a(n.j.isopen, new z(this)).b(n.j.cancel, new aa(this)).b(getPageContext());
        aVar.tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aLM() {
        int selectionEnd = aMe().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aMe().getText().getSpans(0, aMe().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aMe().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aMe().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLN() {
        if (this.aso != null) {
            this.aso.setBarLauncherEnabled(!this.dYA);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.dYC != null && this.dJy != null && this.dJy.getLiveCardData() != null) {
            this.mHandler.postDelayed(this.dYz, 100L);
        }
        if (this.dYu) {
            this.dUM.setVisibility(8);
            if (this.dJy.getType() == 5) {
                this.dYo.setVisibility(8);
            } else {
                this.dYo.setVisibility(0);
            }
            b(this.dYr, this.dYl);
            b(this.dYq, this.dYp);
            aKN();
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
        aLZ();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.dYB.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dYB);
        this.auc = new com.baidu.tieba.tbadkCore.location.d(this);
        this.auc.a(this.aur);
        registerListener(this.dIT);
        initEditor();
        if (this.dYu) {
            this.dYj.setEditorTools(this.aso);
        } else {
            this.dUQ.requestFocus();
        }
    }

    private void initEditor() {
        this.aso = new com.baidu.tbadk.editortools.k(getActivity());
        this.aso.setBarMaxLauCount(4);
        this.aso.setMoreButtonAtEnd(true);
        this.aso.setBarLauncherType(1);
        this.aso.setBarLinePostion(2);
        this.aso.setMoreLauncherIcon(n.f.write_more);
        this.aso.setBackgroundColorId(n.d.cp_bg_line_d);
        switch (this.dJy.getType()) {
            case 4:
            case 5:
                aLQ();
                break;
            default:
                aLR();
                break;
        }
        this.aso.Bk();
        if (this.dXJ != null) {
            this.dXJ.addView(this.aso);
        }
        aLS();
        this.aso.ob();
        com.baidu.tbadk.editortools.r ea = this.aso.ea(6);
        if (ea != null && !TextUtils.isEmpty(this.auj)) {
            ((View) ea).setOnClickListener(new ab(this));
        }
        if (!this.dYu) {
            this.aso.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aso.zK();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("xiaoying_has_click", false)) {
            this.aso.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aLO() {
        this.dYm = this.mRootView.findViewById(n.g.photo_live_scroll);
        this.dYo = this.dYm.findViewById(n.g.live_post_title_container);
        this.dYl = (EditText) this.dYm.findViewById(n.g.live_post_content);
        this.dYi = (GridView) this.dYm.findViewById(n.g.photoLiveGridView);
        this.dYp = (EditText) this.dYm.findViewById(n.g.live_post_title);
        this.dYq = (TextView) this.dYm.findViewById(n.g.titleOverPlusNumber);
        this.dYr = (TextView) this.dYm.findViewById(n.g.contentOverPlusNumber);
        this.dYn = this.dYm.findViewById(n.g.live_interval_view);
        this.dYq.setText(String.valueOf(20));
        this.dYr.setText(String.valueOf(233));
        this.dYm.setVisibility(0);
        this.dYq.setVisibility(0);
        this.dYr.setVisibility(0);
        this.dYp.setHint(n.j.tips_title_limit_new);
        this.dYp.setOnFocusChangeListener(new ac(this));
        if (this.dJy.getType() == 4) {
            this.dYl.setHint(n.j.live_write_input_content_new);
        } else if (this.dJy.getType() == 5) {
            this.dYl.setHint(n.j.live_write_input_content_update);
        }
        this.dYl.setOnFocusChangeListener(new ad(this));
        this.dYl.requestFocus();
        this.dYl.addTextChangedListener(arI());
        this.dYp.requestFocus();
        this.dYp.addTextChangedListener(arI());
        this.dYp.setOnClickListener(this.dYy);
        this.dYl.setOnClickListener(this.dYy);
        this.dYj = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.dYi);
        this.dYj.op(6);
        this.dYi.setAdapter((ListAdapter) this.dYj);
        View findViewById = this.dYm.findViewById(n.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        aLP();
    }

    private void aLP() {
        if (this.dJy.getType() == 0) {
            if (this.dJy.getTitle() != null) {
                this.dYp.setText(this.dJy.getTitle());
                this.dYp.setSelection(this.dJy.getTitle().length());
            }
        } else if (this.dJy.getType() != 1) {
            this.dJy.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.dYu) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aMl();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Cd();
            return;
        }
        if (this.aso.Bm()) {
            this.aso.zK();
        }
        String str = null;
        if (this.dJy != null) {
            str = this.dJy.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.dYu) {
            albumActivityConfig.getIntent().putExtra("from", dYw);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aLQ() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aso.q(arrayList);
        com.baidu.tbadk.editortools.y ec = this.aso.ec(5);
        if (ec != null) {
            ec.launcherPriority = 2;
            ec.launcherIcon = n.f.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.launcherIcon = n.f.write_at;
        this.aso.b(aVar);
        this.aso.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aLR() {
        boolean z;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.y yVar;
        com.baidu.tbadk.editortools.y yVar2;
        com.baidu.tbadk.editortools.y yVar3;
        com.baidu.tbadk.editortools.y yVar4;
        com.baidu.tbadk.editortools.y yVar5;
        com.baidu.tbadk.editortools.y yVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        iVar.launcherIcon = n.f.write_picture;
        this.aso.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        if (!XiaoyingUtil.showXiaoyingTool() || this.dJy == null || this.dJy.isAddition() || this.dXH) {
            z = false;
        } else {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.y.class);
            if (runTask2 == null || (yVar6 = (com.baidu.tbadk.editortools.y) runTask2.getData()) == null) {
                z = false;
            } else {
                yVar6.launcherPriority = 3;
                yVar6.launcherIcon = n.f.write_video;
                this.aso.b(yVar6);
                z = true;
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.y.class);
            if (runTask3 != null && (yVar5 = (com.baidu.tbadk.editortools.y) runTask3.getData()) != null) {
                this.aso.b(yVar5);
            }
        }
        this.aso.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask4 != null && (yVar4 = (com.baidu.tbadk.editortools.y) runTask4.getData()) != null) {
            yVar4.launcherPriority = 4;
            yVar4.launcherIcon = n.f.write_privilege;
            this.aso.b(yVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        if (!z) {
            aVar.launcherIcon = n.f.write_at;
        }
        this.aso.b(aVar);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask5 != null && (yVar3 = (com.baidu.tbadk.editortools.y) runTask5.getData()) != null) {
            yVar3.toolNeedAction = true;
            yVar3.launcherPriority = 8;
            yVar3.launcherIcon = 0;
            this.aso.b(yVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask6 != null && (yVar2 = (com.baidu.tbadk.editortools.y) runTask6.getData()) != null) {
            yVar2.toolNeedAction = true;
            yVar2.launcherPriority = 9;
            yVar2.launcherIcon = 0;
            this.aso.b(yVar2);
        }
        Boolean aMj = aMj();
        if (!this.dXH && aMj != null && aMj.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.aGy() && com.baidu.tieba.tbadkCore.v.a(this.dJy.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.y.class)) != null && (yVar = (com.baidu.tbadk.editortools.y) runTask.getData()) != null) {
            yVar.launcherPriority = 6;
            this.aso.b(yVar);
        }
        if (this.dJy != null && this.dJy.getType() == 0 && !this.dXH && !this.dXI) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.dXU == null) {
            this.aso.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.aso.q(arrayList);
        com.baidu.tbadk.editortools.y ec = this.aso.ec(5);
        if (ec != null) {
            ec.launcherPriority = 2;
            ec.launcherIcon = n.f.write_face;
        }
        com.baidu.tbadk.editortools.y ec2 = this.aso.ec(13);
        if (ec2 != null) {
            ec2.launcherPriority = 7;
        }
    }

    private void aLS() {
        af afVar = new af(this);
        this.aso.a(16, afVar);
        this.aso.a(21, afVar);
        this.aso.a(14, afVar);
        this.aso.a(24, afVar);
        this.aso.a(3, afVar);
        this.aso.a(10, afVar);
        this.aso.a(11, afVar);
        this.aso.a(12, afVar);
        this.aso.a(13, afVar);
        this.aso.a(22, afVar);
        this.aso.a(23, afVar);
        this.aso.a(15, afVar);
        this.aso.a(18, afVar);
        this.aso.a(25, afVar);
        this.aso.a(27, afVar);
        this.aso.a(29, afVar);
    }

    public void aGW() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        if (this.auc.aGd()) {
            if (this.auc.aGb()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aFW().getLocationData().aFS());
                return;
            }
            a(1, true, (String) null);
            this.auc.aFZ();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKF() {
        if (this.aud != null) {
            this.aud.cancelLoadData();
        }
        if (this.dXK != null) {
            this.dXK.cancelLoadData();
        }
        if (this.auc != null) {
            this.auc.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aKF();
        aMi();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        if (this.dJy != null && this.dJy.getType() == 2 && this.dXR) {
            finish();
        } else if (this.dJy == null) {
            finish();
        } else {
            this.dJy.setTitle(aMf().getText().toString());
            this.dJy.setContent(aMe().getText().toString());
            int type = this.dJy.getType();
            if (type == 0) {
                if (this.dJy.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ae.b(this.dJy.getForumId(), this.dJy);
                } else {
                    com.baidu.tieba.tbadkCore.ae.a(this.dJy.getLiveCardData().getGroupId(), this.dJy);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ae.c(this.dJy.getThreadId(), this.dJy);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.dJy.getForumId()) + "photolive", this.dJy);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.dJy.getThreadId()) + "updatephotolive", this.dJy);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dUT != null && this.dUT.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.dUT, getPageContext().getPageActivity());
                return true;
            } else if (this.aso.Bm()) {
                this.aso.zK();
                return true;
            } else {
                aKF();
                aLT();
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
        getLayoutMode().k(this.bKF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.as.i((View) this.dUR, n.f.s_navbar_button_bg);
        aLN();
        com.baidu.tbadk.core.util.as.j(this.dYm, n.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.j(this.dUN, n.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.j(this.dYn, n.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.j((View) aMf(), n.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.cro)) {
            com.baidu.tbadk.core.util.as.j((View) aMe(), n.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_e);
        aMf().setTextColor(color);
        aMe().setTextColor(color);
        a(aMf(), color2);
        a(aMe(), color2);
        aKN();
        this.aso.onChangeSkinType(i);
        if (this.dYh != null) {
            this.dYh.vR();
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
        this.dYu = this.dJy.getType() == 4 || 5 == this.dJy.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(n.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bLD = this.mNavigationBar.setTitleText("");
        this.dXP = (TextView) findViewById(n.g.btn_image_problem);
        this.dUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.dUR.setLayoutParams(layoutParams);
        this.dUR.setOnFocusChangeListener(this.dUK);
        this.dYk = (ScrollView) findViewById(n.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dXL = (FeedBackTopListView) findViewById(n.g.feedback_top_list);
        this.dXM = findViewById(n.g.feedback_divider);
        this.bKF = (RelativeLayout) findViewById(n.g.parent);
        this.dXJ = (LinearLayout) findViewById(n.g.tool_view);
        this.dUN = findViewById(n.g.interval_view);
        aKM();
        if (this.dYu) {
            this.dYk.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aLO();
        }
        aKO();
        if (this.dXH || this.dXI) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(n.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(n.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dUP = (LinearLayout) findViewById(n.g.post_content_container);
        this.dUP.setDrawingCacheEnabled(false);
        this.dUP.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.dUK);
        this.mBack.setOnClickListener(new ah(this));
        this.dXP.setOnClickListener(new ai(this));
        aLV();
        j(aMj());
        aLX();
        aMa();
        aGW();
        switch (this.dJy.getType()) {
            case 0:
                if (this.dXH || this.dXI) {
                    this.bLD.setText(n.j.feedback);
                } else {
                    this.bLD.setText(n.j.post_new_thread);
                }
                this.dUM.setVisibility(0);
                this.dUQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bLD.setText(n.j.send_reply);
                this.dUQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.dUM.setVisibility(8);
                break;
            case 4:
                this.bLD.setText(n.j.publish_photo_live);
                this.dUQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bLD.setText(getPageContext().getResources().getString(n.j.update_photo_live_tip, Integer.valueOf(this.dJy.getFloorNum() + 1)));
                this.dYn.setVisibility(8);
                break;
        }
        aMb();
        aMh();
        aLN();
        aLY();
        aKL();
        if (this.dJy.getType() == 4 && this.dUV != null && this.dXN != null) {
            this.dUV.setVisibility(8);
            this.dXN.setVisibility(8);
        }
        aKN();
        if (this.dJy.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.dUM);
        }
        aLW();
    }

    private void aLU() {
        this.bve = null;
        this.dYf = -1;
        this.dYg = -1;
        ee gc = ed.Ox().gc(1);
        if (gc != null) {
            this.bve = gc.biD;
            this.dYf = getIntent().getIntExtra("category_id", -1);
            if (this.bve != null && !this.bve.isEmpty() && this.dYf >= 0) {
                this.dYe = new ec();
                this.dYe.biz = 0;
                this.dYe.name = getPageContext().getResources().getString(n.j.category_auto);
                this.dYg = this.dYe.biz;
                this.bvo = this.dYe.name;
                for (ec ecVar : this.bve) {
                    if (ecVar.biz == this.dYf) {
                        this.dYg = ecVar.biz;
                        this.bvo = ecVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void aLV() {
        if (this.bve != null && !this.bve.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(n.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(n.g.interval_view_cate).setVisibility(0);
            this.dYh = (PostCategoryView) linearLayout.findViewById(n.g.category_selected);
            this.dYh.setText(this.bvo);
            this.dYh.b(this.bve, this.dYe, this.dYg);
            this.dYh.setCategoryContainerClickCallback(new ak(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void aLW() {
    }

    private void aLX() {
        this.dYa = (RelativeLayout) findViewById(n.g.live_time_rel);
        this.dYb = (TextView) findViewById(n.g.live_tiem_show);
        this.dYc = findViewById(n.g.interval_view2);
        this.dYd = (LiveBroadcastCard) findViewById(n.g.live_anchor_card);
        this.dYa.setOnClickListener(new am(this));
        this.dYa.setOnTouchListener(new an(this));
        if (this.dJy.getLiveCardData() != null) {
            this.dYa.setVisibility(0);
            this.dYc.setVisibility(0);
            this.dYd.setVisibility(0);
            this.dYd.setClickable(false);
            this.dYb.setText(com.baidu.tbadk.core.util.ax.v(this.dJy.getLiveCardData().getStartTime() * 1000));
            this.dYd.setData(this.dJy.getLiveCardData());
            return;
        }
        this.dYa.setVisibility(8);
        this.dYc.setVisibility(8);
        this.dYd.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.dJy.getLiveCardData() != null) {
            Date date = new Date(this.dJy.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.dYC = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ao(this), new Date().getHours(), new Date().getMinutes(), false);
        this.dYC.setTitle(n.j.no_disturb_start_time);
        this.dYC.setButton(-1, getPageContext().getString(n.j.alert_yes_button), this.dYC);
        this.dYC.setButton(-2, getPageContext().getString(n.j.alert_no_button), this.dYC);
        return this.dYC;
    }

    private void aLY() {
        this.dXV = (RelativeLayout) findViewById(n.g.addition_container);
        this.dXW = (TextView) findViewById(n.g.addition_create_time);
        this.dXX = (TextView) findViewById(n.g.addition_last_time);
        this.dXY = (TextView) findViewById(n.g.addition_last_content);
        if (this.dXU != null) {
            this.dXV.setVisibility(0);
            this.dXW.setText(String.valueOf(getPageContext().getString(n.j.write_addition_create)) + com.baidu.tbadk.core.util.ax.s(this.dXU.getCreateTime() * 1000));
            if (this.dXU.getAlreadyCount() == 0) {
                this.dXX.setVisibility(8);
            } else {
                this.dXX.setText(String.valueOf(getPageContext().getString(n.j.write_addition_last)) + com.baidu.tbadk.core.util.ax.s(this.dXU.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.dXU.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.dXY.setText(lastAdditionContent);
            } else {
                this.dXY.setVisibility(8);
            }
            aMe().setHint(String.format(getPageContext().getString(n.j.write_addition_hint), Integer.valueOf(this.dXU.getAlreadyCount()), Integer.valueOf(this.dXU.getTotalCount())));
            this.bLD.setText(n.j.write_addition_title);
            return;
        }
        this.dXV.setVisibility(8);
    }

    private void aKL() {
        this.dUV = findViewById(n.g.post_prefix_layout);
        this.dUS = (TextView) findViewById(n.g.post_prefix);
        this.dXN = findViewById(n.g.prefix_divider);
        this.dUU = (ImageView) findViewById(n.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.dUV.setVisibility(0);
            this.dXN.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dUu = 1;
            this.dUV.setOnClickListener(new ap(this));
            this.dUU = (ImageView) findViewById(n.g.prefix_icon);
            if (size > 1) {
                this.dUU.setVisibility(0);
                this.dUS.setOnClickListener(new aq(this));
            }
            this.dUT = new cf(getPageContext().getPageActivity());
            this.dUT.a(this);
            this.dUT.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), n.e.ds510));
            this.dUT.setOutsideTouchable(true);
            this.dUT.setFocusable(true);
            this.dUT.setOnDismissListener(this);
            this.dUT.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.as.getColor(n.d.write_text);
            int color2 = com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_c);
            com.baidu.tbadk.core.util.as.i((View) this.dUS, n.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.c(this.dUU, n.f.icon_title_down);
            this.dUS.setTextColor(color);
            this.dWq.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.dWq.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.dUT.addView(jVar);
            }
            this.dUT.od(0);
            this.dUS.setText(prefixs.get(1));
            oy(1);
            return;
        }
        this.dUV.setVisibility(8);
    }

    private void aLZ() {
        if (this.dXH && this.dJy != null) {
            this.dXL.setVisibility(0);
            this.dXM.setVisibility(0);
            this.dXK = new o(this);
            this.dXK.nt(this.dJy.getForumName());
            this.dXK.setLoadDataCallBack(new ar(this));
        }
    }

    protected void aMa() {
        this.dUR.setOnClickListener(new as(this));
    }

    protected void aMb() {
        this.dXQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dXQ.cF(getPageContext().getString(n.j.is_save_draft)).ai(false).a(getPageContext().getString(n.j.save), new at(this)).b(getPageContext().getString(n.j.not_save), new aw(this));
        this.dXQ.b(getPageContext());
    }

    protected void aKM() {
        this.dUM = (EditText) findViewById(n.g.post_title);
        this.dUM.setOnClickListener(this.dYy);
        this.dUM.setOnFocusChangeListener(this.dUK);
        if (this.dJy.getType() == 0) {
            if (this.dJy.getTitle() != null) {
                this.dUM.setText(this.dJy.getTitle());
                this.dUM.setSelection(this.dJy.getTitle().length());
            }
        } else if (this.dJy.getType() != 1) {
            this.dJy.getType();
        }
        this.dUM.addTextChangedListener(new ax(this));
    }

    private TextWatcher arI() {
        ay ayVar = new ay(this);
        if (this.dYu && this.dYv) {
            if (this.dYs != null) {
                this.dYp.removeTextChangedListener(this.dYs);
            }
            this.dYs = ayVar;
        } else if (this.dYu) {
            if (this.dYt != null) {
                this.dYl.removeTextChangedListener(this.dYt);
            }
            this.dYt = ayVar;
        }
        return ayVar;
    }

    private long e(EditText editText) {
        if (editText == this.dYl) {
            return 233L;
        }
        if (editText != this.dYp) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long e = e(editText);
            long d = e - d(editText);
            String valueOf = String.valueOf(d);
            if (e == 20) {
                if (d < 0) {
                    if (d < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_d));
                }
            } else if (d < 0) {
                if (d < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long d(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void aKO() {
        this.dUQ = (EditText) findViewById(n.g.post_content);
        this.dUQ.setDrawingCacheEnabled(false);
        this.dUQ.setOnClickListener(this.dYy);
        if (this.dJy.getContent() != null && this.dJy.getContent().length() > 0) {
            SpannableString G = TbFaceManager.CL().G(getPageContext().getPageActivity(), this.dJy.getContent());
            this.dUQ.setText(G);
            this.dUQ.setSelection(G.length());
        } else if (this.dJy.getType() == 2) {
            if (this.dXR) {
                if (this.dXS != null && this.dXS.length() > 0) {
                    this.dUQ.setText(getPageContext().getPageActivity().getString(n.j.reply_sub_floor, new Object[]{this.dXS}));
                    this.dUQ.setSelection(this.dUQ.getText().length());
                }
            } else if (this.dJy.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(n.j.reply_x_floor), Integer.valueOf(this.dJy.getFloorNum()));
                this.dUQ.setText(format);
                this.dUQ.setSelection(format.length());
            }
        }
        this.dUQ.setOnFocusChangeListener(this.dUK);
        this.dUQ.setOnTouchListener(new az(this));
        this.dUQ.addTextChangedListener(new ba(this));
        hV(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.dYu) {
            aMe().setPadding(0, 0, 0, 0);
            aMe().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.as.j((View) aMe(), n.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.cro) && this.dXU == null) {
                com.baidu.adp.lib.g.c.hd().a(this.cro, 19, new bb(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMc() {
        int i = 5000;
        if (this.dXU != null) {
            i = 1000;
        }
        return aMe().getText() != null && aMe().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMd() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.aso != null) {
                this.aso.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aEE() && this.dXZ == 0) {
            showToast(n.j.baobao_over_limit);
        } else {
            String charSequence = this.bLD.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (((ImageSpan[]) aMe().getText().getSpans(0, aMe().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.dXT == null) {
                this.dXT = Toast.makeText(getPageContext().getPageActivity(), n.j.too_many_face, 0);
            }
            this.dXT.show();
            return;
        }
        String name = hVar.getName();
        EmotionGroupType wQ = hVar.wQ();
        if (name != null) {
            com.baidu.adp.lib.g.c.hd().a(name, 20, new bc(this, new SpannableStringBuilder(name), wQ), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mE = aVar.mE();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mE);
        int width = mE.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        aMe().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aMe() {
        return this.dYu ? this.dYl : this.dUQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aMf() {
        return this.dYu ? this.dYp : this.dUM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMg() {
        aMe().onKeyDown(67, this.dXO);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.dJy != null) {
            str = this.dJy.getForumName();
        }
        if (getPageContext().getString(n.j.feedback_bar_name).equals(str)) {
            this.dXH = true;
        }
    }

    private void aMh() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aMi() {
        try {
            if (this.dXQ != null) {
                this.dXQ.dismiss();
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

    private Boolean aMj() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.auj = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        String str;
        String str2 = null;
        if (this.dJy != null) {
            String editable = aMf().getText().toString();
            String trim = aMe().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.dJy.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.dUu == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.dJy.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.dJy.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dJy.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.dJy.setIsNoTitle(true);
                str = null;
            } else {
                this.dJy.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.dYu) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.atZ != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.dJy.getVideoInfo() != null) {
                str = "1";
            }
            if (this.dJy.getType() == 4) {
                if (g(this.dYl) && f(this.dYp)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.dJy.getType() != 5) {
                str2 = str;
            } else if (g(this.dYl)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dUR.setEnabled(false);
            } else {
                this.dUR.setEnabled(true);
            }
        }
    }

    private boolean f(EditText editText) {
        long d = d(editText);
        return d <= 20 && d > 0;
    }

    private boolean g(EditText editText) {
        long d = d(editText);
        if (d > 233) {
            return false;
        }
        return d > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.aud = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aud.b(this.aut);
        registerListener(this.dYx);
        this.cPd = new bd(this);
        this.dJy = new WriteData();
        if (bundle != null) {
            this.dJy.setType(bundle.getInt("type", 0));
            this.dJy.setForumId(bundle.getString("forum_id"));
            this.dJy.setForumName(bundle.getString("forum_name"));
            this.dJy.setThreadId(bundle.getString("thread_id"));
            this.dJy.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.dJy.setFloorNum(bundle.getInt("floor_num", 0));
            this.dXH = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.dXR = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dXS = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aub = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.dXU = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.dJy.setIsAddition(this.dXU != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.dXZ = bundle.getInt("mem_type", 0);
            if (bundle.getBoolean(WriteActivityConfig.IS_LIVE_POST)) {
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setStartTime(bundle.getLong(WriteActivityConfig.LIVE_DATE));
                liveCardData.setAuthorName(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData.setPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData.setIntro(bundle.getString(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData.setListeners(bundle.getInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData.setName(bundle.getString(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData.setLikers(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData.setGroupId(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData.setModifyTime(bundle.getBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY));
                liveCardData.setPublisherPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.dJy.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.dJy.setType(intent.getIntExtra("type", 0));
            this.dJy.setForumId(intent.getStringExtra("forum_id"));
            this.dJy.setForumName(intent.getStringExtra("forum_name"));
            this.dJy.setThreadId(intent.getStringExtra("thread_id"));
            this.dJy.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.dJy.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.dXH = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.dXR = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dXS = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.dXU = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.dJy.setIsAddition(this.dXU != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.dXZ = intent.getIntExtra("mem_type", 0);
            if (intent.getBooleanExtra(WriteActivityConfig.IS_LIVE_POST, false)) {
                LiveCardData liveCardData2 = new LiveCardData();
                liveCardData2.setStartTime(new Date().getTime() / 1000);
                liveCardData2.setAuthorName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData2.setPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData2.setIntro(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData2.setListeners(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData2.setName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData2.setLikers(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData2.setGroupId(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData2.setPublisherPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.dJy.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.dJy.getType() == 4 ? 6 : 10);
        this.dJy.setWriteImagesInfo(this.writeImagesInfo);
        this.dJy.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.dJy.getType() == 0) {
            if (this.dJy.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ae.c(this.dJy.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ae.a(this.dJy.getLiveCardData().getGroupId(), this);
            }
        } else if (this.dJy.getType() == 1) {
            com.baidu.tieba.tbadkCore.ae.a(this.dJy.getThreadId(), this);
        } else if (this.dJy.getType() == 4) {
            com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.dJy.getForumId()) + "photolive", this);
        } else if (this.dJy.getType() == 5) {
            com.baidu.tieba.tbadkCore.ae.a(String.valueOf(this.dJy.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(n.j.write_no_prefix));
        }
        this.cro = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.dJy != null && this.dJy.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.dJy.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.dXI = true;
        }
        aLU();
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.dJy != null) {
                this.dJy.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aMf().getText().toString()) || ((this.dXH || this.dXI) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.dJy.setTitle(writeData.getTitle());
                    aMf().setText(this.dJy.getTitle());
                    aMf().setSelection(this.dJy.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.dJy.setVideoInfo(videoInfo);
                    this.aso.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.dJy.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.dYb.setText(com.baidu.tbadk.core.util.ax.v(this.dJy.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aMe().getText().toString()) || this.dXH || this.dXI) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.dJy.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.CL().a(getPageContext().getPageActivity(), this.dJy.getContent(), new be(this));
                    aMe().setText(a2);
                    aMe().setSelection(a2.length());
                    if (this.dYu) {
                        b(this.dYr, this.dYl);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.dJy.setWriteImagesInfo(this.writeImagesInfo);
                    aMo();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Cd();
                    }
                    hW(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.dJy.setIsBaobao(writeData.getIsBaobao());
                        this.dJy.setBaobaoContent(writeData.getBaobaoContent());
                        this.dJy.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.dJy.getIsBaobao()) {
                        Cf();
                        hX(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aMk();
                }
                aKN();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.bve != null) {
                    this.dYg = this.dYe.biz;
                    this.bvo = this.dYe.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.bve.size()) {
                            break;
                        }
                        ec ecVar = this.bve.get(i2);
                        if (categoryTo != ecVar.biz) {
                            i = i2 + 1;
                        } else {
                            this.dYg = categoryTo;
                            this.bvo = ecVar.name;
                            this.dJy.setCategoryTo(this.dYg);
                            break;
                        }
                    }
                    if (this.dYh != null) {
                        this.dYh.setText(this.bvo);
                        this.dYh.b(this.bve, this.dYe, this.dYg);
                    }
                }
                this.aso.zK();
                return;
            }
            return;
        }
        aMk();
    }

    private void aMk() {
        if ((!this.dYu || this.dYj != null) && this.dYi != null) {
            this.dYj.b(this.writeImagesInfo);
            aMn();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.dJy.getType());
        bundle.putString("forum_id", this.dJy.getForumId());
        bundle.putString("forum_name", this.dJy.getForumName());
        bundle.putString("thread_id", this.dJy.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.dJy.getFloor());
        bundle.putInt("floor_num", this.dJy.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.dXR);
        if (this.dXH) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aub);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.dXU);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.dXZ);
        if (this.dJy.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.dJy.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.dJy.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.dJy.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.dJy.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.dJy.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.dJy.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.dJy.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.dJy.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.dJy.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aMe().getEditableText().toString();
        if (editable != null) {
            aMe().setText(TbFaceManager.CL().G(getPageContext().getPageActivity(), editable));
            aMe().setSelection(aMe().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLm() {
        aKF();
        if (this.dJy.getLiveCardData() != null) {
            if (!this.dJy.getLiveCardData().isModifyTime()) {
                this.dJy.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.dYb.setText(com.baidu.tbadk.core.util.ax.v(this.dJy.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.dJy.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.dJy.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.dJy.getLiveCardData().getStartTime() / 60) {
                showToast(n.j.live_start_time_error);
                return;
            }
        }
        String editable = aMf().getText().toString();
        this.dJy.setContent(aMe().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dUu != 0 && this.dJy.getType() != 4) {
            this.dJy.setTitle(String.valueOf(this.dUS.getText().toString()) + editable);
        } else {
            this.dJy.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.dJy.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.dJy.getTitle());
        }
        if (this.dXH || this.dXI) {
            String string = getResources().getString(n.j.android_feedback);
            if (TextUtils.isEmpty(this.dJy.getTitle()) || !this.dJy.getTitle().startsWith(string)) {
                this.dJy.setTitle(string + this.dJy.getTitle());
            }
            String str = String.valueOf(getResources().getString(n.j.app_name)) + getResources().getString(n.j.tieba_client);
            if (TextUtils.isEmpty(this.dJy.getContent()) || !this.dJy.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iQ()) {
                    sb.append(com.baidu.adp.lib.util.i.iY());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.dJy.getContent());
                this.dJy.setContent(sb.toString());
            }
        }
        if (this.dYf >= 0) {
            this.dJy.setCategoryFrom(this.dYf);
        }
        if (this.dYg >= 0) {
            this.dJy.setCategoryTo(this.dYg);
        }
        this.dJy.setWriteImagesInfo(this.writeImagesInfo);
        this.dJy.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.dJy.setHasLocationData(this.auc == null ? false : this.auc.aGd());
        this.aud.hw(this.writeImagesInfo.size() > 0);
        this.aud.c(this.dJy);
        this.dJy.setVcode(null);
        if (this.atZ != null) {
            if (this.atZ.getId() != null) {
                this.aud.aGz().setVoice(this.atZ.getId());
                this.aud.aGz().setVoiceDuringTime(this.atZ.duration);
            } else {
                this.aud.aGz().setVoice(null);
                this.aud.aGz().setVoiceDuringTime(-1);
            }
        } else {
            this.aud.aGz().setVoice(null);
            this.aud.aGz().setVoiceDuringTime(-1);
        }
        if (!this.aud.aGD()) {
            showToast(n.j.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(n.j.sending), this.cPd);
        if (!this.aud.aGA()) {
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
            if (this.dXU != null) {
                i2 = this.dXU.getTotalCount();
                i = this.dXU.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(n.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aso != null && !this.aso.Bm()) {
                    aMe().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> S = com.baidu.tieba.tbadkCore.util.l.S(intent);
                if (S != null && S.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < S.size()) {
                            sb.append("@");
                            sb.append(S.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            aMe().getText().insert(aMe().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.dJy.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ae.b(this.dJy.getForumId(), (WriteData) null);
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.dJy.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ae.c(this.dJy.getThreadId(), (WriteData) null);
                } else if (this.dJy.getType() == 4) {
                    com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.dJy.getForumId()) + "photolive", (WriteData) null);
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
                                atc();
                            } else {
                                Y(intent);
                            }
                        } else if (intExtra == 1) {
                            R(intent);
                        } else {
                            X(intent);
                        }
                    }
                } else if (i == 12012) {
                    if (!this.dYu) {
                        G(intent);
                        aKN();
                        return;
                    }
                    aa(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.dJy.setVideoInfo(videoInfo);
                        this.aso.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aso.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aso.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    aKN();
                } else if (i == 12013) {
                    H(intent);
                    aKN();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.aso != null && !this.aso.Bm()) {
                this.dUQ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    BW();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aMm();
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
                    this.aub = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ar.b(getPageContext(), this.aub);
                    return;
                case 12012:
                    aMm();
                    return;
            }
        }
    }

    private void aMl() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aMm() {
        if (this.dYu) {
            this.dYj.b(this.writeImagesInfo);
            aMn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMn() {
        this.dYj.notifyDataSetChanged();
        this.dYi.invalidate();
        this.mHandler.postDelayed(new bf(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        aKN();
    }

    private void X(Intent intent) {
        if (this.dYu) {
            aa(intent);
            aMm();
        } else {
            ab(intent);
        }
        aKN();
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aMm();
            hW(true);
        }
    }

    private void Y(Intent intent) {
        int size;
        F(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void atc() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
        }
    }

    private void R(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.ddo.parseJson(stringExtra);
            this.ddo.updateQuality();
            if (this.ddo.getChosedFiles() != null && this.ddo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ddo.getChosedFiles().get(0).getFilePath(), 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
            }
            this.ddo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aMf());
        HidenSoftKeyPad(this.mInputManager, aMe());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        this.mHandler.removeCallbacks(this.dYz);
    }

    private void ab(Intent intent) {
        b(intent, true);
    }

    private void F(Intent intent) {
        this.aub = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aub;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cN = com.baidu.tbadk.core.util.c.cN(str);
                if (cN != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cN);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aub, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aMo();
            Cd();
        }
        hW(true);
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
                aMo();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Cd();
                }
            }
            hW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMo() {
        if (this.aso.ec(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void H(Intent intent) {
        if (this.dJy != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.dJy.setIsBaobao(true);
            this.dJy.setBaobaoContent(stringExtra2);
            Cf();
            hX(true);
        }
    }

    private void BW() {
        new bh(this).execute(new Void[0]);
    }

    private void hW(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void hX(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ne(postWriteCallBackData.getErrorCode())) {
                AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(n.j.error_write);
                }
                showToast(errorString2);
            } else if (this.dXU == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aul = i;
        if (this.aso != null) {
            this.aso.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.aso.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Cd() {
        if (!this.dYu && this.aso != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.aso.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.aso.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aso.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aso.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Cf() {
        if (this.aso != null) {
            this.aso.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.aso.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.aso.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (this.aso != null) {
            this.aso.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void oy(int i) {
        if (i < this.dWq.size()) {
            for (int i2 = 0; i2 < this.dWq.size(); i2++) {
                this.dWq.get(i2).hR(false);
            }
            this.dWq.get(i).hR(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ok(int i) {
        this.dUu = i;
        this.dUT.od(i);
        oy(i);
        this.dUS.setText(this.mPrefixData.getPrefixs().get(i));
        aKN();
        com.baidu.adp.lib.h.j.a(this.dUT, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.dUV.setSelected(false);
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
