package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.write.bx;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ac.a, bx.a {
    private VoiceData.VoiceModel arK;
    private String arM;
    private com.baidu.tieba.tbadkCore.location.d arN;
    private com.baidu.tieba.tbadkCore.writeModel.a arO;
    private int cRS;
    private TextView cSq;
    private bx cSr;
    private ImageView cSs;
    private View cSt;
    private TextView cUA;
    private TextView cUB;
    private TbImageView cUD;
    private TextView cUE;
    private boolean cUF;
    private PhotoUrlData cUG;
    private com.baidu.tieba.view.a cUL;
    private LinearLayout cUc;
    private View cUf;
    private View cUg;
    private Toast cUn;
    private com.baidu.tbadk.editortools.j cUo;
    private AdditionData cUp;
    private RelativeLayout cUq;
    private TextView cUr;
    private TextView cUs;
    private TextView cUt;
    private RelativeLayout cUv;
    private TextView cUw;
    private View cUx;
    private LiveBroadcastCard cUy;
    private RelativeLayout cUz;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cKS = null;
    private boolean cUa = false;
    private boolean cUb = false;
    private InputMethodManager mInputManager = null;
    private EditText cSk = null;
    private View cSl = null;
    private LinearLayout cSn = null;
    private EditText cSo = null;
    private o cUd = null;
    private FeedBackTopListView cUe = null;
    private ArrayList<com.baidu.tieba.write.view.g> cUh = new ArrayList<>();
    private String bRT = null;
    private final KeyEvent cUi = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cUj = null;
    private TextView cSp = null;
    private TextView boD = null;
    private DialogInterface.OnCancelListener cjo = null;
    private com.baidu.tbadk.core.dialog.a cUk = null;
    private final Handler mHandler = new Handler();
    private boolean cUl = false;
    private String cUm = null;
    private RelativeLayout bnG = null;
    private String arU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int arW = 0;
    private int cUu = 0;
    private WriteImagesInfo cUC = new WriteImagesInfo();
    private final HttpMessageListener cUH = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d asc = new aj(this);
    private final d.a asa = new av(this);
    private final CustomMessageListener cKo = new bb(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener cUI = new bc(this);
    private boolean cUJ = true;
    private final View.OnFocusChangeListener cSi = new bd(this);
    private final CustomMessageListener cUK = new be(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0069a cfd = new bf(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Bo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(i.C0057i.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bp();
        } else if (this.arN.aqH()) {
            Bn();
        } else {
            this.arN.fA(false);
            a(1, true, (String) null);
            this.arN.aqF();
        }
    }

    private void Bp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bC(i.C0057i.location_app_permission_prompt).a(i.C0057i.isopen, new bg(this)).b(i.C0057i.cancel, new z(this)).b(getPageContext());
        aVar.sP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auW() {
        int selectionEnd = this.cSo.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.cSo.getText().getSpans(0, this.cSo.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.cSo.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.cSo.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        if (this.cUo != null) {
            this.cUo.setBarLauncherEnabled(!this.cUJ);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.cUL != null && this.cKS != null && this.cKS.getLiveCardData() != null) {
            new Handler().postDelayed(new aa(this, new Date(this.cKS.getLiveCardData().getStartTime() * 1000)), 100L);
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
        avf();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cUK.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cUK);
        this.arN = new com.baidu.tieba.tbadkCore.location.d(this);
        this.arN.a(this.asa);
        registerListener(this.cKo);
        initEditor();
        this.cSo.requestFocus();
    }

    private void initEditor() {
        this.cUo = new com.baidu.tbadk.editortools.j(getActivity());
        this.cUo.setBarMaxLauCount(4);
        this.cUo.setMoreButtonAtEnd(true);
        this.cUo.setBarLauncherType(1);
        this.cUo.setBarLinePostion(2);
        this.cUo.setMoreLauncherIcon(i.e.write_more);
        this.cUo.setBackgroundColorId(i.c.cp_bg_line_d);
        switch (this.cKS.getType()) {
            case 4:
            case 5:
                auY();
                break;
            default:
                auZ();
                break;
        }
        this.cUo.Az();
        if (this.cUc != null) {
            this.cUc.addView(this.cUo);
        }
        ava();
        this.cUo.oy();
        com.baidu.tbadk.editortools.p dJ = this.cUo.dJ(6);
        if (dJ != null && !TextUtils.isEmpty(this.arU)) {
            ((View) dJ).setOnClickListener(new ab(this));
        }
        com.baidu.tbadk.editortools.v dL = this.cUo.dL(5);
        if (dL != null && (dL.aox instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dL.aox).setFrom(1);
        }
    }

    private void auY() {
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        iVar.apf = i.e.write_picture;
        this.cUo.b(iVar);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.apf = i.e.write_face;
        this.cUo.b(mVar);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.apf = i.e.write_at;
        this.cUo.b(aVar);
        this.cUo.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
    }

    private void auZ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.v vVar;
        com.baidu.tbadk.editortools.v vVar2;
        com.baidu.tbadk.editortools.v vVar3;
        com.baidu.tbadk.editortools.v vVar4;
        com.baidu.tbadk.editortools.v vVar5;
        com.baidu.tbadk.editortools.v vVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        iVar.apf = i.e.write_picture;
        this.cUo.b(iVar);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.apf = i.e.write_face;
        this.cUo.b(mVar);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.apf = i.e.write_at;
        this.cUo.b(aVar);
        this.cUo.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask2 != null && (vVar6 = (com.baidu.tbadk.editortools.v) runTask2.getData()) != null) {
            vVar6.aph = 4;
            vVar6.apf = i.e.write_privilege;
            this.cUo.b(vVar6);
        }
        if (XiaoyingUtil.showXiaoyingTool() && this.cKS != null && !this.cKS.isAddition()) {
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask3 != null && (vVar5 = (com.baidu.tbadk.editortools.v) runTask3.getData()) != null) {
                vVar5.aph = 5;
                this.cUo.b(vVar5);
            }
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask4 != null && (vVar4 = (com.baidu.tbadk.editortools.v) runTask4.getData()) != null) {
                this.cUo.b(vVar4);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask5 != null && (vVar3 = (com.baidu.tbadk.editortools.v) runTask5.getData()) != null) {
            vVar3.apj = true;
            vVar3.aph = 8;
            vVar3.apf = 0;
            this.cUo.b(vVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask6 != null && (vVar2 = (com.baidu.tbadk.editortools.v) runTask6.getData()) != null) {
            vVar2.apj = true;
            vVar2.aph = 9;
            vVar2.apf = 0;
            this.cUo.b(vVar2);
        }
        Boolean avn = avn();
        if (!this.cUa && avn != null && avn.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.arc() && com.baidu.tieba.tbadkCore.t.a(this.cKS.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.v.class)) != null && (vVar = (com.baidu.tbadk.editortools.v) runTask.getData()) != null) {
            vVar.aph = 6;
            this.cUo.b(vVar);
        }
        if (this.cKS != null && this.cKS.getType() == 0 && !this.cUa && !this.cUb && TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            this.cUo.b(new com.baidu.tbadk.editortools.b.b(getActivity(), 7));
            this.cUo.b(new com.baidu.tbadk.editortools.b.a(getActivity()));
        }
        if (this.cUp == null) {
            this.cUo.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
    }

    private void ava() {
        ac acVar = new ac(this);
        this.cUo.a(16, acVar);
        this.cUo.a(21, acVar);
        this.cUo.a(14, acVar);
        this.cUo.a(24, acVar);
        this.cUo.a(3, acVar);
        this.cUo.a(10, acVar);
        this.cUo.a(11, acVar);
        this.cUo.a(12, acVar);
        this.cUo.a(13, acVar);
        this.cUo.a(22, acVar);
        this.cUo.a(23, acVar);
        this.cUo.a(15, acVar);
        this.cUo.a(18, acVar);
        this.cUo.a(25, acVar);
        this.cUo.a(27, acVar);
        this.cUo.a(29, acVar);
    }

    public void arB() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq() {
        if (this.arN.aqJ()) {
            if (this.arN.aqH()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aqC().getLocationData().aqy());
                return;
            }
            a(1, true, (String) null);
            this.arN.aqF();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auo() {
        if (this.arO != null) {
            this.arO.cancelLoadData();
        }
        if (this.cUd != null) {
            this.cUd.cancelLoadData();
        }
        if (this.arN != null) {
            this.arN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        auo();
        avm();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avb() {
        if (this.cKS != null && this.cKS.getType() == 2 && this.cUl) {
            finish();
        } else if (this.cKS == null) {
            finish();
        } else {
            this.cKS.setTitle(this.cSk.getText().toString());
            this.cKS.setContent(this.cSo.getText().toString());
            int type = this.cKS.getType();
            if (type == 0) {
                if (this.cKS.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ac.b(this.cKS.getForumId(), this.cKS);
                } else {
                    com.baidu.tieba.tbadkCore.ac.a(this.cKS.getLiveCardData().getGroupId(), this.cKS);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ac.c(this.cKS.getThreadId(), this.cKS);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ac.b(String.valueOf(this.cKS.getForumId()) + "photolive", this.cKS);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ac.c(String.valueOf(this.cKS.getThreadId()) + "updatephotolive", this.cKS);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cSr != null && this.cSr.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.cSr, getPageContext().getPageActivity());
                return true;
            } else if (this.cUo.AB()) {
                this.cUo.zk();
                return true;
            } else {
                auo();
                avb();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bnG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.al.g(this.cSp, i);
        auX();
        com.baidu.tbadk.core.util.al.j(this.cSl, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.al.j((View) this.cSk, i.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bRT)) {
            com.baidu.tbadk.core.util.al.j((View) this.cSo, i.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_e);
        this.cSk.setTextColor(color);
        this.cSo.setTextColor(color);
        a(this.cSk, color2);
        a(this.cSo, color2);
        auw();
        this.cUo.onChangeSkinType(i);
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
        setContentView(i.g.write_activity);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.boD = this.mNavigationBar.setTitleText("");
        this.cUj = (TextView) findViewById(i.f.btn_image_problem);
        this.cSp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.send_post));
        this.cSp.setOnFocusChangeListener(this.cSi);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cUe = (FeedBackTopListView) findViewById(i.f.feedback_top_list);
        this.cUf = findViewById(i.f.feedback_divider);
        this.bnG = (RelativeLayout) findViewById(i.f.parent);
        this.cUc = (LinearLayout) findViewById(i.f.tool_view);
        this.cSl = findViewById(i.f.interval_view);
        this.cUz = (RelativeLayout) findViewById(i.f.photo_live_cover_setting_container);
        this.cUA = (TextView) findViewById(i.f.photo_live_cover_tips);
        this.cUB = (TextView) findViewById(i.f.photo_live_cover_change_tips);
        this.cUD = (TbImageView) findViewById(i.f.photo_live_cover_imageview);
        this.cUE = (TextView) findViewById(i.f.photo_live_cover_view);
        auv();
        aux();
        if (this.cUa || this.cUb) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().abL) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.httpNet.e.getInstance().hasImageProblem()) {
                    findViewById(i.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(i.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.cSn = (LinearLayout) findViewById(i.f.post_content_container);
        this.cSn.setDrawingCacheEnabled(false);
        this.cSn.setOnClickListener(new ad(this));
        this.mBack.setOnFocusChangeListener(this.cSi);
        this.mBack.setOnClickListener(new ae(this));
        this.cUj.setOnClickListener(new af(this));
        i(avn());
        avd();
        avg();
        arB();
        switch (this.cKS.getType()) {
            case 0:
                if (this.cUa || this.cUb) {
                    this.boD.setText(i.C0057i.feedback);
                } else {
                    this.boD.setText(i.C0057i.post_new_thread);
                }
                this.cSk.setVisibility(0);
                this.cSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.boD.setText(i.C0057i.send_reply);
                this.cSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.cSk.setVisibility(8);
                break;
            case 4:
                this.boD.setText(i.C0057i.publish_photo_live);
                this.cSk.setVisibility(0);
                this.cUz.setVisibility(0);
                this.cUz.setOnClickListener(new ag(this));
                this.cSk.setHint(i.C0057i.tips_title_limit);
                this.cSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.boD.setText(getPageContext().getResources().getString(i.C0057i.update_photo_live_tip, Integer.valueOf(this.cKS.getFloorNum() + 1)));
                this.cSo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.cSk.setVisibility(8);
                break;
        }
        avh();
        avl();
        auX();
        ave();
        auu();
        if (this.cKS.getType() == 4 && this.cSt != null && this.cUg != null) {
            this.cSt.setVisibility(8);
            this.cUg.setVisibility(8);
        }
        auw();
        if (this.cKS.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.cSk);
        }
        avc();
    }

    private void avc() {
    }

    private void avd() {
        this.cUv = (RelativeLayout) findViewById(i.f.live_time_rel);
        this.cUw = (TextView) findViewById(i.f.live_tiem_show);
        this.cUx = findViewById(i.f.interval_view2);
        this.cUy = (LiveBroadcastCard) findViewById(i.f.live_anchor_card);
        this.cUv.setOnClickListener(new ah(this));
        this.cUv.setOnTouchListener(new ai(this));
        if (this.cKS.getLiveCardData() != null) {
            this.cUv.setVisibility(0);
            this.cUx.setVisibility(0);
            this.cUy.setVisibility(0);
            this.cUy.setClickable(false);
            this.cUw.setText(com.baidu.tbadk.core.util.aq.n(this.cKS.getLiveCardData().getStartTime() * 1000));
            this.cUy.setData(this.cKS.getLiveCardData());
            return;
        }
        this.cUv.setVisibility(8);
        this.cUx.setVisibility(8);
        this.cUy.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cKS.getLiveCardData() != null) {
            Date date = new Date(this.cKS.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cUL = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ak(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cUL.setTitle(i.C0057i.no_disturb_start_time);
        this.cUL.setButton(-1, getPageContext().getString(i.C0057i.alert_yes_button), this.cUL);
        this.cUL.setButton(-2, getPageContext().getString(i.C0057i.alert_no_button), this.cUL);
        return this.cUL;
    }

    private void ave() {
        this.cUq = (RelativeLayout) findViewById(i.f.addition_container);
        this.cUr = (TextView) findViewById(i.f.addition_create_time);
        this.cUs = (TextView) findViewById(i.f.addition_last_time);
        this.cUt = (TextView) findViewById(i.f.addition_last_content);
        if (this.cUp != null) {
            this.cUq.setVisibility(0);
            this.cUr.setText(String.valueOf(getPageContext().getString(i.C0057i.write_addition_create)) + com.baidu.tbadk.core.util.aq.m(this.cUp.getCreateTime() * 1000));
            if (this.cUp.getAlreadyCount() == 0) {
                this.cUs.setVisibility(8);
            } else {
                this.cUs.setText(String.valueOf(getPageContext().getString(i.C0057i.write_addition_last)) + com.baidu.tbadk.core.util.aq.m(this.cUp.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cUp.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cUt.setText(lastAdditionContent);
            } else {
                this.cUt.setVisibility(8);
            }
            this.cSo.setHint(String.format(getPageContext().getString(i.C0057i.write_addition_hint), Integer.valueOf(this.cUp.getAlreadyCount()), Integer.valueOf(this.cUp.getTotalCount())));
            this.boD.setText(i.C0057i.write_addition_title);
            return;
        }
        this.cUq.setVisibility(8);
    }

    private void auu() {
        this.cSt = findViewById(i.f.post_prefix_layout);
        this.cSq = (TextView) findViewById(i.f.post_prefix);
        this.cUg = findViewById(i.f.prefix_divider);
        this.cSs = (ImageView) findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.cSt.setVisibility(0);
            this.cUg.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cRS = 1;
            this.cSt.setOnClickListener(new al(this));
            this.cSs = (ImageView) findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.cSs.setVisibility(0);
                this.cSq.setOnClickListener(new am(this));
            }
            this.cSr = new bx(getPageContext().getPageActivity());
            this.cSr.a(this);
            this.cSr.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), i.d.ds510));
            this.cSr.setOutsideTouchable(true);
            this.cSr.setFocusable(true);
            this.cSr.setOnDismissListener(this);
            this.cSr.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.al.getColor(i.c.write_text);
            int color2 = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c);
            com.baidu.tbadk.core.util.al.i((View) this.cSq, i.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.c(this.cSs, i.e.icon_title_down);
            this.cSq.setTextColor(color);
            this.cUh.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(getActivity());
                this.cUh.add(gVar);
                gVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    gVar.setPrefixTextColor(color2);
                } else {
                    gVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    gVar.setDividerStyle(false);
                }
                this.cSr.addView(gVar);
            }
            this.cSr.kj(0);
            this.cSq.setText(prefixs.get(1));
            ky(1);
            return;
        }
        this.cSt.setVisibility(8);
    }

    private void avf() {
        if (this.cUa && this.cKS != null) {
            this.cUe.setVisibility(0);
            this.cUf.setVisibility(0);
            this.cUd = new o(this);
            this.cUd.ld(this.cKS.getForumName());
            this.cUd.setLoadDataCallBack(new an(this));
        }
    }

    protected void avg() {
        this.cSp.setOnClickListener(new ao(this));
    }

    protected void avh() {
        this.cUk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cUk.cn(getPageContext().getString(i.C0057i.is_save_draft)).aj(false).a(getPageContext().getString(i.C0057i.save), new ap(this)).b(getPageContext().getString(i.C0057i.not_save), new ar(this));
        this.cUk.b(getPageContext());
    }

    protected void auv() {
        this.cSk = (EditText) findViewById(i.f.post_title);
        this.cSk.setOnClickListener(this.cUI);
        this.cSk.setOnFocusChangeListener(this.cSi);
        if (this.cKS.getType() == 0) {
            if (this.cKS.getTitle() != null) {
                this.cSk.setText(this.cKS.getTitle());
                this.cSk.setSelection(this.cKS.getTitle().length());
            }
        } else if (this.cKS.getType() != 1) {
            this.cKS.getType();
        }
        this.cSk.addTextChangedListener(new as(this));
    }

    protected void aux() {
        this.cSo = (EditText) findViewById(i.f.post_content);
        this.cSo.setDrawingCacheEnabled(false);
        this.cSo.setOnClickListener(this.cUI);
        if (this.cKS.getContent() != null && this.cKS.getContent().length() > 0) {
            SpannableString H = TbFaceManager.Cd().H(getPageContext().getPageActivity(), this.cKS.getContent());
            this.cSo.setText(H);
            this.cSo.setSelection(H.length());
        } else if (this.cKS.getType() == 2) {
            if (this.cUl) {
                if (this.cUm != null && this.cUm.length() > 0) {
                    this.cSo.setText(getPageContext().getPageActivity().getString(i.C0057i.reply_sub_floor, new Object[]{this.cUm}));
                    this.cSo.setSelection(this.cSo.getText().length());
                }
            } else if (this.cKS.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(i.C0057i.reply_x_floor), Integer.valueOf(this.cKS.getFloorNum()));
                this.cSo.setText(format);
                this.cSo.setSelection(format.length());
            }
        }
        this.cSo.setOnFocusChangeListener(this.cSi);
        this.cSo.setOnTouchListener(new at(this));
        this.cSo.addTextChangedListener(new au(this));
        fZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.cSo.setPadding(0, 0, 0, 0);
            this.cSo.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.al.j((View) this.cSo, i.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bRT) && this.cUp == null) {
                com.baidu.adp.lib.f.c.hc().a(this.bRT, 19, new aw(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avi() {
        int i = 5000;
        if (this.cUp != null) {
            i = 1000;
        }
        return this.cSo.getText() != null && this.cSo.getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avj() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.cUo != null) {
                this.cUo.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.apw() && this.cUu == 0) {
            showToast(i.C0057i.baobao_over_limit);
        } else {
            String charSequence = this.boD.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.cSo.getText().getSpans(0, this.cSo.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cUn == null) {
                this.cUn = Toast.makeText(getPageContext().getPageActivity(), i.C0057i.too_many_face, 0);
            }
            this.cUn.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType wu = fVar.wu();
        if (name != null) {
            com.baidu.adp.lib.f.c.hc().a(name, 20, new ax(this, new SpannableStringBuilder(name), this.cSo.getSelectionStart(), wu), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap nc = aVar.nc();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nc);
        int width = nc.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.cSo.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avk() {
        this.cSo.onKeyDown(67, this.cUi);
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.cKS != null) {
            str = this.cKS.getForumName();
        }
        if (getPageContext().getString(i.C0057i.feedback_bar_name).equals(str)) {
            this.cUa = true;
        }
    }

    private void avl() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void avm() {
        try {
            if (this.cUk != null) {
                this.cUk.dismiss();
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

    private Boolean avn() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.arU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auw() {
        String str;
        String str2 = null;
        if (this.cKS != null) {
            String trim = this.cSk.getText().toString().trim();
            String trim2 = this.cSo.getText().toString().trim();
            if (this.cKS.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.cRS == 0) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cKS.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.cKS.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cKS.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cKS.setIsNoTitle(true);
                str = null;
            } else {
                this.cKS.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                str = "1";
            } else if (!TextUtils.isEmpty(trim2)) {
                str = "1";
            } else if (this.arK != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                str = "1";
            }
            if (this.cKS.getType() != 4) {
                str2 = str;
            } else if (this.cUF && !StringUtils.isNull(trim2) && !StringUtils.isNull(trim)) {
                str2 = "1";
            }
            if (this.cKS.getVideoInfo() != null) {
                str2 = "1";
            }
            if (str2 == null || str2.length() <= 0) {
                this.cSp.setEnabled(false);
            } else {
                this.cSp.setEnabled(true);
            }
        }
    }

    private void initData(Bundle bundle) {
        this.arO = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arO.b(this.asc);
        registerListener(this.cUH);
        this.cjo = new ay(this);
        this.cKS = new WriteData();
        if (bundle != null) {
            this.cKS.setType(bundle.getInt("type", 0));
            this.cKS.setForumId(bundle.getString("forum_id"));
            this.cKS.setForumName(bundle.getString("forum_name"));
            this.cKS.setThreadId(bundle.getString("thread_id"));
            this.cKS.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cKS.setFloorNum(bundle.getInt("floor_num", 0));
            this.cUa = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cUl = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cUm = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.arM = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cUp = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cKS.setIsAddition(this.cUp != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cUu = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cKS.setLiveCardData(liveCardData);
            }
            if (bundle.getInt("type", 0) == 4) {
                this.cUG = (PhotoUrlData) bundle.getSerializable(WriteActivityConfig.PHOTO_LIVE_COVER_IMAGE);
            }
        } else {
            Intent intent = getIntent();
            this.cKS.setType(intent.getIntExtra("type", 0));
            this.cKS.setForumId(intent.getStringExtra("forum_id"));
            this.cKS.setForumName(intent.getStringExtra("forum_name"));
            this.cKS.setThreadId(intent.getStringExtra("thread_id"));
            this.cKS.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cKS.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.cUa = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cUl = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cUm = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cUp = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cKS.setIsAddition(this.cUp != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cUu = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cKS.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.cKS.setWriteImagesInfo(this.writeImagesInfo);
        this.cKS.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cKS.setPhotoLiveCoverUlrData(this.cUG);
        if (this.cKS.getType() == 0) {
            if (this.cKS.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ac.c(this.cKS.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ac.a(this.cKS.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cKS.getType() == 1) {
            com.baidu.tieba.tbadkCore.ac.a(this.cKS.getThreadId(), this);
        } else if (this.cKS.getType() == 4) {
            com.baidu.tieba.tbadkCore.ac.c(String.valueOf(this.cKS.getForumId()) + "photolive", this);
        } else if (this.cKS.getType() == 5) {
            com.baidu.tieba.tbadkCore.ac.a(String.valueOf(this.cKS.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.C0057i.write_no_prefix));
        }
        this.bRT = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cKS != null && this.cKS.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cKS.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.cUb = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (this.cKS != null) {
                this.cKS.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(this.cSk.getText().toString()) || ((this.cUa || this.cUb) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.cKS.setTitle(writeData.getTitle());
                    this.cSk.setText(this.cKS.getTitle());
                    this.cSk.setSelection(this.cKS.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.cKS.setVideoInfo(videoInfo);
                    this.cUo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.cKS.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.cUw.setText(com.baidu.tbadk.core.util.aq.n(this.cKS.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(this.cSo.getText().toString()) || this.cUa || this.cUb) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.cKS.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Cd().a(getPageContext().getPageActivity(), this.cKS.getContent(), new az(this));
                    this.cSo.setText(a2);
                    this.cSo.setSelection(a2.length());
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.cKS.setWriteImagesInfo(this.writeImagesInfo);
                    avp();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        BA();
                    }
                    ga(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.cKS.setIsBaobao(writeData.getIsBaobao());
                        this.cKS.setBaobaoContent(writeData.getBaobaoContent());
                        this.cKS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.cKS.getIsBaobao()) {
                        BC();
                        gb(false);
                    }
                }
                if (writeData.getType() == 4 && writeData.getPhotoLiveCoverUlrData() != null) {
                    this.cKS.setPhotoLiveCoverUlrData(writeData.getPhotoLiveCoverUlrData());
                    this.cUD.setVisibility(0);
                    this.cUE.setVisibility(0);
                    this.cUD.setImageDrawable(null);
                    this.cUD.d(writeData.getPhotoLiveCoverUlrData().getBigurl(), 10, false);
                    this.cUE.getBackground().setAlpha(TransportMediator.KEYCODE_MEDIA_PAUSE);
                    this.cUA.setVisibility(8);
                    this.cUB.setVisibility(0);
                    this.cUF = true;
                }
                this.cUo.zk();
            } else {
                return;
            }
        }
        auw();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cKS.getType());
        bundle.putString("forum_id", this.cKS.getForumId());
        bundle.putString("forum_name", this.cKS.getForumName());
        bundle.putString("thread_id", this.cKS.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cKS.getFloor());
        bundle.putInt("floor_num", this.cKS.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cUl);
        if (this.cUa) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arM);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cUp);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cUu);
        bundle.putSerializable(WriteActivityConfig.PHOTO_LIVE_COVER_IMAGE, this.cUG);
        if (this.cKS.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cKS.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cKS.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cKS.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cKS.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cKS.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cKS.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cKS.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cKS.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cKS.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.cSo.getEditableText().toString();
        if (editable != null) {
            this.cSo.setText(TbFaceManager.Cd().H(getPageContext().getPageActivity(), editable));
            this.cSo.setSelection(this.cSo.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aur() {
        auo();
        if (this.cKS.getLiveCardData() != null) {
            if (!this.cKS.getLiveCardData().isModifyTime()) {
                this.cKS.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cUw.setText(com.baidu.tbadk.core.util.aq.n(this.cKS.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cKS.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cKS.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cKS.getLiveCardData().getStartTime() / 60) {
                showToast(i.C0057i.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cRS != 0) {
            this.cKS.setTitle(String.valueOf(this.cSq.getText().toString()) + this.cSk.getText().toString());
        } else {
            this.cKS.setTitle(this.cSk.getText().toString());
        }
        this.cKS.setContent(this.cSo.getText().toString());
        if (this.cUa || this.cUb) {
            String string = getResources().getString(i.C0057i.android_feedback);
            if (TextUtils.isEmpty(this.cKS.getTitle()) || !this.cKS.getTitle().startsWith(string)) {
                this.cKS.setTitle(string + this.cKS.getTitle());
            }
            String str = String.valueOf(getResources().getString(i.C0057i.app_name)) + getResources().getString(i.C0057i.tieba_client);
            if (TextUtils.isEmpty(this.cKS.getContent()) || !this.cKS.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iO()) {
                    sb.append(com.baidu.adp.lib.util.i.iW());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.cKS.getContent());
                this.cKS.setContent(sb.toString());
            }
        }
        this.cKS.setWriteImagesInfo(this.writeImagesInfo);
        this.cKS.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cKS.setHasLocationData(this.arN == null ? false : this.arN.aqJ());
        this.arO.fB(this.writeImagesInfo.size() > 0);
        this.arO.c(this.cKS);
        this.cKS.setVcode(null);
        if (this.arK != null) {
            if (this.arK.getId() != null) {
                this.arO.ard().setVoice(this.arK.getId());
                this.arO.ard().setVoiceDuringTime(this.arK.duration);
            } else {
                this.arO.ard().setVoice(null);
                this.arO.ard().setVoiceDuringTime(-1);
            }
        } else {
            this.arO.ard().setVoice(null);
            this.arO.ard().setVoiceDuringTime(-1);
        }
        if (!this.arO.arg()) {
            showToast(i.C0057i.write_img_limit);
        } else if (this.arO.are()) {
            showLoadingDialog(getPageContext().getString(i.C0057i.sending), this.cjo);
        }
    }

    private void l(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.cUp != null) {
                i2 = this.cUp.getTotalCount();
                i = this.cUp.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(i.C0057i.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.cUo != null && !this.cUo.AB()) {
                    this.cSo.requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> R = com.baidu.tieba.tbadkCore.util.j.R(intent);
                if (R != null && R.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < R.size(); i3++) {
                        sb.append("@");
                        sb.append(R.get(i3));
                        sb.append(" ");
                    }
                    String sb2 = sb.toString();
                    this.cSo.getText().insert(this.cSo.getSelectionStart(), sb2);
                }
            } else if (i == 12006) {
                if (this.cKS.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ac.b(this.cKS.getForumId(), (WriteData) null);
                } else if (this.cKS.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ac.c(this.cKS.getThreadId(), (WriteData) null);
                }
                setResult(-1, intent);
                finish();
            } else if (i == 12010 || i == 12009) {
                this.cUG = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
                if (this.cUG != null) {
                    this.cKS.setPhotoLiveCoverUlrData(this.cUG);
                    this.cUD.setVisibility(0);
                    this.cUE.setVisibility(0);
                    this.cUD.setImageDrawable(null);
                    this.cUD.d(this.cUG.getBigurl(), 10, false);
                    this.cUE.getBackground().setAlpha(TransportMediator.KEYCODE_MEDIA_PAUSE);
                    this.cUA.setVisibility(8);
                    this.cUB.setVisibility(0);
                    this.cUF = true;
                    auw();
                    com.baidu.tbadk.core.util.aa.uo().c(this.cUG.getSmallurl(), com.baidu.tbadk.core.util.n.cB(TbConfig.PHOTO_LIVE_COVER_FILE), true, false, true);
                }
            } else if (i == 12002) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        if (intExtra == 1) {
                            avo();
                        } else {
                            W(intent);
                        }
                    } else if (intExtra == 1) {
                        X(intent);
                    } else {
                        V(intent);
                    }
                }
            } else if (i == 12012) {
                I(intent);
                auw();
            } else if (i == 12013) {
                J(intent);
                auw();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
            } else if (i == 13010) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseIntent(intent);
                com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c10068");
                aoVar.r("duration", videoInfo.getDuration());
                TiebaStatic.log(aoVar);
                this.cKS.setVideoInfo(videoInfo);
                this.cUo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                this.cUo.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                auw();
            }
        } else if (i2 == 0) {
            if (this.cUo != null && !this.cUo.AB()) {
                this.cSo.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Bt();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.arM = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ak.a(getPageContext(), this.arM);
                    return;
            }
        }
    }

    private void V(Intent intent) {
        Y(intent);
        auw();
    }

    private void W(Intent intent) {
        int size;
        H(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void avo() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f)));
        }
    }

    private void X(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.cUC.parseJson(stringExtra);
            this.cUC.updateQuality();
            if (this.cUC.getChosedFiles() != null && this.cUC.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.cUC.getChosedFiles().get(0).getFilePath(), 0.56f)));
            }
            this.cUC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cSk);
        HidenSoftKeyPad(this.mInputManager, this.cSo);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void Y(Intent intent) {
        b(intent, true);
    }

    private void H(Intent intent) {
        this.arM = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arM;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cv = com.baidu.tbadk.core.util.c.cv(str);
                if (cv != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cv);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arM, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            avp();
            BA();
        }
        ga(true);
    }

    private void I(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                avp();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    BA();
                }
            }
            ga(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avp() {
        if (this.cUo.dL(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void J(Intent intent) {
        if (this.cKS != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cKS.setIsBaobao(true);
            this.cKS.setBaobaoContent(stringExtra2);
            BC();
            gb(true);
        }
    }

    private void Bt() {
        new ba(this).execute(new Void[0]);
    }

    private void ga(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void gb(boolean z) {
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
    public void a(boolean z, AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            antiData.setBlock_forum_name(this.cKS.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cUp == null) {
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            l(z, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.arW = i;
        if (this.cUo != null) {
            this.cUo.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (z) {
                this.cUo.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void BA() {
        if (this.cUo != null) {
            this.cUo.b(new com.baidu.tbadk.editortools.a(12, 15, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.cUo.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                this.cUo.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.cUo.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    private void BC() {
        if (this.cUo != null) {
            this.cUo.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.cUo.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.cUo.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(boolean z) {
        if (this.cUo != null) {
            this.cUo.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            antiData.setBlock_forum_name(this.cKS.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cUp == null) {
            com.baidu.tieba.tbadkCore.writeModel.c.Q(getPageContext().getPageActivity(), str);
        } else {
            l(z, str);
        }
    }

    private void ky(int i) {
        if (i < this.cUh.size()) {
            for (int i2 = 0; i2 < this.cUh.size(); i2++) {
                this.cUh.get(i2).fX(false);
            }
            this.cUh.get(i).fX(true);
        }
    }

    @Override // com.baidu.tieba.write.write.bx.a
    public void kq(int i) {
        this.cRS = i;
        this.cSr.kj(i);
        ky(i);
        this.cSq.setText(this.mPrefixData.getPrefixs().get(i));
        auw();
        com.baidu.adp.lib.g.j.a(this.cSr, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.cSt.setSelected(false);
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
