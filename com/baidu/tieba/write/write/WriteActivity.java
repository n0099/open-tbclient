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
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ad.a, cd.a {
    public static String dqc = "from_writeActivity_livePhoto";
    private VoiceData.VoiceModel arS;
    private String arU;
    private com.baidu.tieba.tbadkCore.location.d arV;
    private com.baidu.tieba.tbadkCore.writeModel.a arW;
    private TextView dmF;
    private cd dmG;
    private ImageView dmH;
    private View dmI;
    private int dmh;
    private Toast dpC;
    private com.baidu.tbadk.editortools.j dpD;
    private AdditionData dpE;
    private RelativeLayout dpF;
    private TextView dpG;
    private TextView dpH;
    private TextView dpI;
    private RelativeLayout dpK;
    private TextView dpL;
    private View dpM;
    private LiveBroadcastCard dpN;
    private LinearLayout dps;
    private View dpv;
    private View dpw;
    private com.baidu.tieba.view.a dqh;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData dbx = null;
    private boolean dpq = false;
    private boolean dpr = false;
    private InputMethodManager mInputManager = null;
    private EditText dmz = null;
    private View dmA = null;
    private LinearLayout dmC = null;
    private EditText dmD = null;
    private o dpt = null;
    private FeedBackTopListView dpu = null;
    private ArrayList<com.baidu.tieba.write.view.g> dnZ = new ArrayList<>();
    private String bWw = null;
    private final KeyEvent dpx = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView dpy = null;
    private TextView dmE = null;
    private TextView bsm = null;
    private DialogInterface.OnCancelListener cpX = null;
    private com.baidu.tbadk.core.dialog.a dpz = null;
    private final Handler mHandler = new Handler();
    private boolean dpA = false;
    private String dpB = null;
    private RelativeLayout bro = null;
    private String asc = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int ase = 0;
    private int dpJ = 0;
    private WriteImagesInfo cyL = new WriteImagesInfo();
    private View mRootView = null;
    private GridView dpO = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a dpP = null;
    private ScrollView dpQ = null;
    private EditText dpR = null;
    private View dpS = null;
    private View dpT = null;
    private View dpU = null;
    private EditText dpV = null;
    private TextView dpW = null;
    private TextView dpX = null;
    private TextWatcher dpY = null;
    private TextWatcher dpZ = null;
    private boolean dqa = false;
    private boolean dqb = false;
    private final HttpMessageListener dqd = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d ask = new aj(this);
    private final d.a asi = new av(this);
    private final CustomMessageListener daU = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener dqe = new bg(this);
    private boolean dqf = true;
    private final View.OnFocusChangeListener dmx = new bh(this);
    private final CustomMessageListener dqg = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0074a clE = new bj(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Bl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(i.h.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bm();
        } else if (this.arV.axn()) {
            Bk();
        } else {
            this.arV.gv(false);
            a(1, true, (String) null);
            this.arV.axl();
        }
    }

    private void Bm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new bk(this)).b(i.h.cancel, new z(this)).b(getPageContext());
        aVar.sO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDc() {
        int selectionEnd = aDs().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aDs().getText().getSpans(0, aDs().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aDs().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aDs().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDd() {
        if (this.dpD != null) {
            this.dpD.setBarLauncherEnabled(!this.dqf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.dqh != null && this.dbx != null && this.dbx.getLiveCardData() != null) {
            new Handler().postDelayed(new aa(this, new Date(this.dbx.getLiveCardData().getStartTime() * 1000)), 100L);
        }
        if (this.dqa) {
            this.dmz.setVisibility(8);
            if (this.dbx.getType() == 5) {
                this.dpU.setVisibility(8);
            } else {
                this.dpU.setVisibility(0);
            }
            b(this.dpX, this.dpR);
            b(this.dpW, this.dpV);
            aCf();
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
        aDn();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.dqg.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dqg);
        this.arV = new com.baidu.tieba.tbadkCore.location.d(this);
        this.arV.a(this.asi);
        registerListener(this.daU);
        initEditor();
        if (this.dqa) {
            this.dpP.setEditorTools(this.dpD);
        } else {
            this.dmD.requestFocus();
        }
    }

    private void initEditor() {
        this.dpD = new com.baidu.tbadk.editortools.j(getActivity());
        this.dpD.setBarMaxLauCount(4);
        this.dpD.setMoreButtonAtEnd(true);
        this.dpD.setBarLauncherType(1);
        this.dpD.setBarLinePostion(2);
        this.dpD.setMoreLauncherIcon(i.e.write_more);
        this.dpD.setBackgroundColorId(i.c.cp_bg_line_d);
        switch (this.dbx.getType()) {
            case 4:
            case 5:
                aDg();
                break;
            default:
                aDh();
                break;
        }
        this.dpD.Av();
        if (this.dps != null) {
            this.dps.addView(this.dpD);
        }
        aDi();
        this.dpD.ow();
        com.baidu.tbadk.editortools.p dS = this.dpD.dS(6);
        if (dS != null && !TextUtils.isEmpty(this.asc)) {
            ((View) dS).setOnClickListener(new ab(this));
        }
        com.baidu.tbadk.editortools.v dU = this.dpD.dU(5);
        if (dU != null && (dU.aoJ instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dU.aoJ).setFrom(1);
        }
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("xiaoying_has_click", false)) {
            this.dpD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aDe() {
        this.dpS = this.mRootView.findViewById(i.f.photo_live_scroll);
        this.dpU = this.dpS.findViewById(i.f.live_post_title_container);
        this.dpR = (EditText) this.dpS.findViewById(i.f.live_post_content);
        this.dpO = (GridView) this.dpS.findViewById(i.f.photoLiveGridView);
        this.dpV = (EditText) this.dpS.findViewById(i.f.live_post_title);
        this.dpW = (TextView) this.dpS.findViewById(i.f.titleOverPlusNumber);
        this.dpX = (TextView) this.dpS.findViewById(i.f.contentOverPlusNumber);
        this.dpT = this.dpS.findViewById(i.f.live_interval_view);
        this.dpW.setText(String.valueOf(20));
        this.dpX.setText(String.valueOf(233));
        this.dpS.setVisibility(0);
        this.dpW.setVisibility(0);
        this.dpX.setVisibility(0);
        this.dpV.setHint(i.h.tips_title_limit_new);
        this.dpV.setOnFocusChangeListener(new ac(this));
        if (this.dbx.getType() == 4) {
            this.dpR.setHint(i.h.live_write_input_content_new);
        } else if (this.dbx.getType() == 5) {
            this.dpR.setHint(i.h.live_write_input_content_update);
        }
        this.dpR.setOnFocusChangeListener(new ad(this));
        this.dpR.requestFocus();
        this.dpR.addTextChangedListener(akE());
        this.dpV.requestFocus();
        this.dpV.addTextChangedListener(akE());
        this.dpV.setOnClickListener(this.dqe);
        this.dpR.setOnClickListener(this.dqe);
        this.dpP = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.dpO);
        this.dpP.lX(6);
        this.dpO.setAdapter((ListAdapter) this.dpP);
        View findViewById = this.dpS.findViewById(i.f.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        aDf();
    }

    private void aDf() {
        if (this.dbx.getType() == 0) {
            if (this.dbx.getTitle() != null) {
                this.dpV.setText(this.dbx.getTitle());
                this.dpV.setSelection(this.dbx.getTitle().length());
            }
        } else if (this.dbx.getType() != 1) {
            this.dbx.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.dqa) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aDz();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Bx();
            return;
        }
        if (this.dpD.Ax()) {
            this.dpD.yX();
        }
        String str = null;
        if (this.dbx != null) {
            str = this.dbx.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.dqa) {
            albumActivityConfig.getIntent().putExtra("from", dqc);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aDg() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.aps = i.e.write_face;
        this.dpD.b(mVar);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aps = i.e.write_at;
        this.dpD.b(aVar);
        this.dpD.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aDh() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.v vVar;
        com.baidu.tbadk.editortools.v vVar2;
        com.baidu.tbadk.editortools.v vVar3;
        com.baidu.tbadk.editortools.v vVar4;
        com.baidu.tbadk.editortools.v vVar5;
        com.baidu.tbadk.editortools.v vVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        iVar.aps = i.e.write_picture;
        this.dpD.b(iVar);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.aps = i.e.write_face;
        this.dpD.b(mVar);
        if (XiaoyingUtil.showXiaoyingTool() && this.dbx != null && !this.dbx.isAddition()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask2 != null && (vVar6 = (com.baidu.tbadk.editortools.v) runTask2.getData()) != null) {
                vVar6.apu = 3;
                vVar6.aps = i.e.write_video;
                this.dpD.b(vVar6);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask3 != null && (vVar5 = (com.baidu.tbadk.editortools.v) runTask3.getData()) != null) {
                this.dpD.b(vVar5);
            }
        }
        this.dpD.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask4 != null && (vVar4 = (com.baidu.tbadk.editortools.v) runTask4.getData()) != null) {
            vVar4.apu = 4;
            vVar4.aps = i.e.write_privilege;
            this.dpD.b(vVar4);
        }
        this.dpD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 5));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask5 != null && (vVar3 = (com.baidu.tbadk.editortools.v) runTask5.getData()) != null) {
            vVar3.apw = true;
            vVar3.apu = 8;
            vVar3.aps = 0;
            this.dpD.b(vVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask6 != null && (vVar2 = (com.baidu.tbadk.editortools.v) runTask6.getData()) != null) {
            vVar2.apw = true;
            vVar2.apu = 9;
            vVar2.aps = 0;
            this.dpD.b(vVar2);
        }
        Boolean aDx = aDx();
        if (!this.dpq && aDx != null && aDx.booleanValue() && com.baidu.tieba.tbadkCore.voice.b.axJ() && com.baidu.tieba.tbadkCore.u.a(this.dbx.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.v.class)) != null && (vVar = (com.baidu.tbadk.editortools.v) runTask.getData()) != null) {
            vVar.apu = 6;
            this.dpD.b(vVar);
        }
        if (this.dbx != null && this.dbx.getType() == 0 && !this.dpq && !this.dpr && TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            this.dpD.b(new com.baidu.tbadk.editortools.b.b(getActivity(), 7));
            this.dpD.b(new com.baidu.tbadk.editortools.b.a(getActivity()));
        }
        if (this.dpE == null) {
            this.dpD.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
    }

    private void aDi() {
        af afVar = new af(this);
        this.dpD.a(16, afVar);
        this.dpD.a(21, afVar);
        this.dpD.a(14, afVar);
        this.dpD.a(24, afVar);
        this.dpD.a(3, afVar);
        this.dpD.a(10, afVar);
        this.dpD.a(11, afVar);
        this.dpD.a(12, afVar);
        this.dpD.a(13, afVar);
        this.dpD.a(22, afVar);
        this.dpD.a(23, afVar);
        this.dpD.a(15, afVar);
        this.dpD.a(18, afVar);
        this.dpD.a(25, afVar);
        this.dpD.a(27, afVar);
        this.dpD.a(29, afVar);
    }

    public void ayi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        if (this.arV.axp()) {
            if (this.arV.axn()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.axi().getLocationData().axe());
                return;
            }
            a(1, true, (String) null);
            this.arV.axl();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBX() {
        if (this.arW != null) {
            this.arW.cancelLoadData();
        }
        if (this.dpt != null) {
            this.dpt.cancelLoadData();
        }
        if (this.arV != null) {
            this.arV.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aBX();
        aDw();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDj() {
        if (this.dbx != null && this.dbx.getType() == 2 && this.dpA) {
            finish();
        } else if (this.dbx == null) {
            finish();
        } else {
            this.dbx.setTitle(aDt().getText().toString());
            this.dbx.setContent(aDs().getText().toString());
            int type = this.dbx.getType();
            if (type == 0) {
                if (this.dbx.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ad.b(this.dbx.getForumId(), this.dbx);
                } else {
                    com.baidu.tieba.tbadkCore.ad.a(this.dbx.getLiveCardData().getGroupId(), this.dbx);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.dbx.getThreadId(), this.dbx);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.dbx.getForumId()) + "photolive", this.dbx);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.dbx.getThreadId()) + "updatephotolive", this.dbx);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dmG != null && this.dmG.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dmG, getPageContext().getPageActivity());
                return true;
            } else if (this.dpD.Ax()) {
                this.dpD.yX();
                return true;
            } else {
                aBX();
                aDj();
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
        getLayoutMode().k(this.bro);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.an.i((View) this.dmE, i.e.s_navbar_button_bg);
        aDd();
        com.baidu.tbadk.core.util.an.j(this.dpS, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.an.j(this.dmA, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.an.j(this.dpT, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.an.j((View) aDt(), i.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bWw)) {
            com.baidu.tbadk.core.util.an.j((View) aDs(), i.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_e);
        aDt().setTextColor(color);
        aDs().setTextColor(color);
        a(aDt(), color2);
        a(aDs(), color2);
        aCf();
        this.dpD.onChangeSkinType(i);
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
        this.dqa = this.dbx.getType() == 4 || 5 == this.dbx.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(i.g.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsm = this.mNavigationBar.setTitleText("");
        this.dpy = (TextView) findViewById(i.f.btn_image_problem);
        this.dmE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmE.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dmE.setLayoutParams(layoutParams);
        this.dmE.setOnFocusChangeListener(this.dmx);
        this.dpQ = (ScrollView) findViewById(i.f.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dpu = (FeedBackTopListView) findViewById(i.f.feedback_top_list);
        this.dpv = findViewById(i.f.feedback_divider);
        this.bro = (RelativeLayout) findViewById(i.f.parent);
        this.dps = (LinearLayout) findViewById(i.f.tool_view);
        this.dmA = findViewById(i.f.interval_view);
        aCe();
        if (this.dqa) {
            this.dpQ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aDe();
        }
        aCg();
        if (this.dpq || this.dpr) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abV) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(i.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(i.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dmC = (LinearLayout) findViewById(i.f.post_content_container);
        this.dmC.setDrawingCacheEnabled(false);
        this.dmC.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.dmx);
        this.mBack.setOnClickListener(new ah(this));
        this.dpy.setOnClickListener(new ai(this));
        i(aDx());
        aDl();
        aDo();
        ayi();
        switch (this.dbx.getType()) {
            case 0:
                if (this.dpq || this.dpr) {
                    this.bsm.setText(i.h.feedback);
                } else {
                    this.bsm.setText(i.h.post_new_thread);
                }
                this.dmz.setVisibility(0);
                this.dmD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bsm.setText(i.h.send_reply);
                this.dmD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.dmz.setVisibility(8);
                break;
            case 4:
                this.bsm.setText(i.h.publish_photo_live);
                this.dmD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bsm.setText(getPageContext().getResources().getString(i.h.update_photo_live_tip, Integer.valueOf(this.dbx.getFloorNum() + 1)));
                this.dpT.setVisibility(8);
                break;
        }
        aDp();
        aDv();
        aDd();
        aDm();
        aCd();
        if (this.dbx.getType() == 4 && this.dmI != null && this.dpw != null) {
            this.dmI.setVisibility(8);
            this.dpw.setVisibility(8);
        }
        aCf();
        if (this.dbx.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.dmz);
        }
        aDk();
    }

    private void aDk() {
    }

    private void aDl() {
        this.dpK = (RelativeLayout) findViewById(i.f.live_time_rel);
        this.dpL = (TextView) findViewById(i.f.live_tiem_show);
        this.dpM = findViewById(i.f.interval_view2);
        this.dpN = (LiveBroadcastCard) findViewById(i.f.live_anchor_card);
        this.dpK.setOnClickListener(new ak(this));
        this.dpK.setOnTouchListener(new al(this));
        if (this.dbx.getLiveCardData() != null) {
            this.dpK.setVisibility(0);
            this.dpM.setVisibility(0);
            this.dpN.setVisibility(0);
            this.dpN.setClickable(false);
            this.dpL.setText(com.baidu.tbadk.core.util.as.n(this.dbx.getLiveCardData().getStartTime() * 1000));
            this.dpN.setData(this.dbx.getLiveCardData());
            return;
        }
        this.dpK.setVisibility(8);
        this.dpM.setVisibility(8);
        this.dpN.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.dbx.getLiveCardData() != null) {
            Date date = new Date(this.dbx.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.dqh = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.dqh.setTitle(i.h.no_disturb_start_time);
        this.dqh.setButton(-1, getPageContext().getString(i.h.alert_yes_button), this.dqh);
        this.dqh.setButton(-2, getPageContext().getString(i.h.alert_no_button), this.dqh);
        return this.dqh;
    }

    private void aDm() {
        this.dpF = (RelativeLayout) findViewById(i.f.addition_container);
        this.dpG = (TextView) findViewById(i.f.addition_create_time);
        this.dpH = (TextView) findViewById(i.f.addition_last_time);
        this.dpI = (TextView) findViewById(i.f.addition_last_content);
        if (this.dpE != null) {
            this.dpF.setVisibility(0);
            this.dpG.setText(String.valueOf(getPageContext().getString(i.h.write_addition_create)) + com.baidu.tbadk.core.util.as.m(this.dpE.getCreateTime() * 1000));
            if (this.dpE.getAlreadyCount() == 0) {
                this.dpH.setVisibility(8);
            } else {
                this.dpH.setText(String.valueOf(getPageContext().getString(i.h.write_addition_last)) + com.baidu.tbadk.core.util.as.m(this.dpE.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.dpE.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.dpI.setText(lastAdditionContent);
            } else {
                this.dpI.setVisibility(8);
            }
            aDs().setHint(String.format(getPageContext().getString(i.h.write_addition_hint), Integer.valueOf(this.dpE.getAlreadyCount()), Integer.valueOf(this.dpE.getTotalCount())));
            this.bsm.setText(i.h.write_addition_title);
            return;
        }
        this.dpF.setVisibility(8);
    }

    private void aCd() {
        this.dmI = findViewById(i.f.post_prefix_layout);
        this.dmF = (TextView) findViewById(i.f.post_prefix);
        this.dpw = findViewById(i.f.prefix_divider);
        this.dmH = (ImageView) findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.dmI.setVisibility(0);
            this.dpw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dmh = 1;
            this.dmI.setOnClickListener(new an(this));
            this.dmH = (ImageView) findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dmH.setVisibility(0);
                this.dmF.setOnClickListener(new ao(this));
            }
            this.dmG = new cd(getPageContext().getPageActivity());
            this.dmG.a(this);
            this.dmG.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), i.d.ds510));
            this.dmG.setOutsideTouchable(true);
            this.dmG.setFocusable(true);
            this.dmG.setOnDismissListener(this);
            this.dmG.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.an.getColor(i.c.write_text);
            int color2 = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.i((View) this.dmF, i.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.an.c(this.dmH, i.e.icon_title_down);
            this.dmF.setTextColor(color);
            this.dnZ.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(getActivity());
                this.dnZ.add(gVar);
                gVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    gVar.setPrefixTextColor(color2);
                } else {
                    gVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    gVar.setDividerStyle(false);
                }
                this.dmG.addView(gVar);
            }
            this.dmG.lL(0);
            this.dmF.setText(prefixs.get(1));
            mg(1);
            return;
        }
        this.dmI.setVisibility(8);
    }

    private void aDn() {
        if (this.dpq && this.dbx != null) {
            this.dpu.setVisibility(0);
            this.dpv.setVisibility(0);
            this.dpt = new o(this);
            this.dpt.mv(this.dbx.getForumName());
            this.dpt.setLoadDataCallBack(new ap(this));
        }
    }

    protected void aDo() {
        this.dmE.setOnClickListener(new aq(this));
    }

    protected void aDp() {
        this.dpz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dpz.cu(getPageContext().getString(i.h.is_save_draft)).aj(false).a(getPageContext().getString(i.h.save), new ar(this)).b(getPageContext().getString(i.h.not_save), new at(this));
        this.dpz.b(getPageContext());
    }

    protected void aCe() {
        this.dmz = (EditText) findViewById(i.f.post_title);
        this.dmz.setOnClickListener(this.dqe);
        this.dmz.setOnFocusChangeListener(this.dmx);
        if (this.dbx.getType() == 0) {
            if (this.dbx.getTitle() != null) {
                this.dmz.setText(this.dbx.getTitle());
                this.dmz.setSelection(this.dbx.getTitle().length());
            }
        } else if (this.dbx.getType() != 1) {
            this.dbx.getType();
        }
        this.dmz.addTextChangedListener(new au(this));
    }

    private TextWatcher akE() {
        aw awVar = new aw(this);
        if (this.dqa && this.dqb) {
            if (this.dpY != null) {
                this.dpV.removeTextChangedListener(this.dpY);
            }
            this.dpY = awVar;
        } else if (this.dqa) {
            if (this.dpZ != null) {
                this.dpR.removeTextChangedListener(this.dpZ);
            }
            this.dpZ = awVar;
        }
        return awVar;
    }

    private long e(EditText editText) {
        if (editText == this.dpR) {
            return 233L;
        }
        if (editText != this.dpV) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
                }
            } else if (d < 0) {
                if (d < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long d(EditText editText) {
        return com.baidu.tieba.write.c.a.f(editText.getText().toString().trim());
    }

    protected void aCg() {
        this.dmD = (EditText) findViewById(i.f.post_content);
        this.dmD.setDrawingCacheEnabled(false);
        this.dmD.setOnClickListener(this.dqe);
        if (this.dbx.getContent() != null && this.dbx.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Cb().G(getPageContext().getPageActivity(), this.dbx.getContent());
            this.dmD.setText(G);
            this.dmD.setSelection(G.length());
        } else if (this.dbx.getType() == 2) {
            if (this.dpA) {
                if (this.dpB != null && this.dpB.length() > 0) {
                    this.dmD.setText(getPageContext().getPageActivity().getString(i.h.reply_sub_floor, new Object[]{this.dpB}));
                    this.dmD.setSelection(this.dmD.getText().length());
                }
            } else if (this.dbx.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(i.h.reply_x_floor), Integer.valueOf(this.dbx.getFloorNum()));
                this.dmD.setText(format);
                this.dmD.setSelection(format.length());
            }
        }
        this.dmD.setOnFocusChangeListener(this.dmx);
        this.dmD.setOnTouchListener(new ax(this));
        this.dmD.addTextChangedListener(new ay(this));
        hb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.dqa) {
            aDs().setPadding(0, 0, 0, 0);
            aDs().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.an.j((View) aDs(), i.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bWw) && this.dpE == null) {
                com.baidu.adp.lib.f.c.ha().a(this.bWw, 19, new az(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDq() {
        int i = 5000;
        if (this.dpE != null) {
            i = 1000;
        }
        return aDs().getText() != null && aDs().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDr() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.dpD != null) {
                this.dpD.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.awd() && this.dpJ == 0) {
            showToast(i.h.baobao_over_limit);
        } else {
            String charSequence = this.bsm.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) aDs().getText().getSpans(0, aDs().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.dpC == null) {
                this.dpC = Toast.makeText(getPageContext().getPageActivity(), i.h.too_many_face, 0);
            }
            this.dpC.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType wh = fVar.wh();
        if (name != null) {
            com.baidu.adp.lib.f.c.ha().a(name, 20, new ba(this, new SpannableStringBuilder(name), wh), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap na = aVar.na();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(na);
        int width = na.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        aDs().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aDs() {
        return this.dqa ? this.dpR : this.dmD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aDt() {
        return this.dqa ? this.dpV : this.dmz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDu() {
        aDs().onKeyDown(67, this.dpx);
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.dbx != null) {
            str = this.dbx.getForumName();
        }
        if (getPageContext().getString(i.h.feedback_bar_name).equals(str)) {
            this.dpq = true;
        }
    }

    private void aDv() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aDw() {
        try {
            if (this.dpz != null) {
                this.dpz.dismiss();
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

    private Boolean aDx() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.asc = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCf() {
        String str;
        String str2 = null;
        if (this.dbx != null) {
            String editable = aDt().getText().toString();
            String trim = aDs().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.dbx.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.dmh == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.dbx.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.dbx.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dbx.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.dbx.setIsNoTitle(true);
                str = null;
            } else {
                this.dbx.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.dqa) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.arS != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.dbx.getVideoInfo() != null) {
                str = "1";
            }
            if (this.dbx.getType() == 4) {
                if (g(this.dpR) && f(this.dpV)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.dbx.getType() != 5) {
                str2 = str;
            } else if (g(this.dpR)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dmE.setEnabled(false);
            } else {
                this.dmE.setEnabled(true);
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
        this.arW = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arW.b(this.ask);
        registerListener(this.dqd);
        this.cpX = new bb(this);
        this.dbx = new WriteData();
        if (bundle != null) {
            this.dbx.setType(bundle.getInt("type", 0));
            this.dbx.setForumId(bundle.getString("forum_id"));
            this.dbx.setForumName(bundle.getString("forum_name"));
            this.dbx.setThreadId(bundle.getString("thread_id"));
            this.dbx.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.dbx.setFloorNum(bundle.getInt("floor_num", 0));
            this.dpq = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.dpA = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dpB = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.arU = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.dpE = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.dbx.setIsAddition(this.dpE != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.dpJ = bundle.getInt("mem_type", 0);
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
                this.dbx.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.dbx.setType(intent.getIntExtra("type", 0));
            this.dbx.setForumId(intent.getStringExtra("forum_id"));
            this.dbx.setForumName(intent.getStringExtra("forum_name"));
            this.dbx.setThreadId(intent.getStringExtra("thread_id"));
            this.dbx.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.dbx.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.dpq = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.dpA = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dpB = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.dpE = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.dbx.setIsAddition(this.dpE != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.dpJ = intent.getIntExtra("mem_type", 0);
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
                this.dbx.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.dbx.getType() == 4 ? 6 : 10);
        this.dbx.setWriteImagesInfo(this.writeImagesInfo);
        this.dbx.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.dbx.getType() == 0) {
            if (this.dbx.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ad.c(this.dbx.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ad.a(this.dbx.getLiveCardData().getGroupId(), this);
            }
        } else if (this.dbx.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.dbx.getThreadId(), this);
        } else if (this.dbx.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.dbx.getForumId()) + "photolive", this);
        } else if (this.dbx.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.dbx.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
        }
        this.bWw = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.dbx != null && this.dbx.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.dbx.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.dpr = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (this.dbx != null) {
                this.dbx.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aDt().getText().toString()) || ((this.dpq || this.dpr) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.dbx.setTitle(writeData.getTitle());
                    aDt().setText(this.dbx.getTitle());
                    aDt().setSelection(this.dbx.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.dbx.setVideoInfo(videoInfo);
                    this.dpD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.dbx.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.dpL.setText(com.baidu.tbadk.core.util.as.n(this.dbx.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aDs().getText().toString()) || this.dpq || this.dpr) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.dbx.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Cb().a(getPageContext().getPageActivity(), this.dbx.getContent(), new bc(this));
                    aDs().setText(a2);
                    aDs().setSelection(a2.length());
                    if (this.dqa) {
                        b(this.dpX, this.dpR);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.dbx.setWriteImagesInfo(this.writeImagesInfo);
                    aDC();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Bx();
                    }
                    hc(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.dbx.setIsBaobao(writeData.getIsBaobao());
                        this.dbx.setBaobaoContent(writeData.getBaobaoContent());
                        this.dbx.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.dbx.getIsBaobao()) {
                        Bz();
                        hd(false);
                    }
                }
                writeData.getType();
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aDy();
                    aCf();
                }
                this.dpD.yX();
                return;
            }
            return;
        }
        aDy();
    }

    private void aDy() {
        if ((!this.dqa || this.dpP != null) && this.dpO != null) {
            this.dpP.d(this.writeImagesInfo);
            aDB();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.dbx.getType());
        bundle.putString("forum_id", this.dbx.getForumId());
        bundle.putString("forum_name", this.dbx.getForumName());
        bundle.putString("thread_id", this.dbx.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.dbx.getFloor());
        bundle.putInt("floor_num", this.dbx.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.dpA);
        if (this.dpq) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arU);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.dpE);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.dpJ);
        if (this.dbx.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.dbx.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.dbx.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.dbx.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.dbx.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.dbx.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.dbx.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.dbx.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.dbx.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.dbx.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aDs().getEditableText().toString();
        if (editable != null) {
            aDs().setText(TbFaceManager.Cb().G(getPageContext().getPageActivity(), editable));
            aDs().setSelection(aDs().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCC() {
        aBX();
        if (this.dbx.getLiveCardData() != null) {
            if (!this.dbx.getLiveCardData().isModifyTime()) {
                this.dbx.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.dpL.setText(com.baidu.tbadk.core.util.as.n(this.dbx.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.dbx.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.dbx.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.dbx.getLiveCardData().getStartTime() / 60) {
                showToast(i.h.live_start_time_error);
                return;
            }
        }
        String editable = aDt().getText().toString();
        this.dbx.setContent(aDs().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dmh != 0 && this.dbx.getType() != 4) {
            this.dbx.setTitle(String.valueOf(this.dmF.getText().toString()) + editable);
        } else {
            this.dbx.setTitle(editable);
        }
        if (this.dpq || this.dpr) {
            String string = getResources().getString(i.h.android_feedback);
            if (TextUtils.isEmpty(this.dbx.getTitle()) || !this.dbx.getTitle().startsWith(string)) {
                this.dbx.setTitle(string + this.dbx.getTitle());
            }
            String str = String.valueOf(getResources().getString(i.h.app_name)) + getResources().getString(i.h.tieba_client);
            if (TextUtils.isEmpty(this.dbx.getContent()) || !this.dbx.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iM()) {
                    sb.append(com.baidu.adp.lib.util.i.iU());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.dbx.getContent());
                this.dbx.setContent(sb.toString());
            }
        }
        this.dbx.setWriteImagesInfo(this.writeImagesInfo);
        this.dbx.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.dbx.setHasLocationData(this.arV == null ? false : this.arV.axp());
        this.arW.gw(this.writeImagesInfo.size() > 0);
        this.arW.c(this.dbx);
        this.dbx.setVcode(null);
        if (this.arS != null) {
            if (this.arS.getId() != null) {
                this.arW.axK().setVoice(this.arS.getId());
                this.arW.axK().setVoiceDuringTime(this.arS.duration);
            } else {
                this.arW.axK().setVoice(null);
                this.arW.axK().setVoiceDuringTime(-1);
            }
        } else {
            this.arW.axK().setVoice(null);
            this.arW.axK().setVoiceDuringTime(-1);
        }
        if (!this.arW.axO()) {
            showToast(i.h.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(i.h.sending), this.cpX);
        if (!this.arW.axL()) {
        }
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.dpE != null) {
                i2 = this.dpE.getTotalCount();
                i = this.dpE.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(i.h.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.dpD != null && !this.dpD.Ax()) {
                    aDs().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                if (T != null && T.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < T.size()) {
                            sb.append("@");
                            sb.append(T.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            aDs().getText().insert(aDs().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.dbx.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.dbx.getForumId(), (WriteData) null);
                } else if (this.dbx.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.dbx.getThreadId(), (WriteData) null);
                } else if (this.dbx.getType() == 4) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.dbx.getForumId()) + "photolive", (WriteData) null);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                }
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                alH();
                            } else {
                                Z(intent);
                            }
                        } else if (intExtra == 1) {
                            S(intent);
                        } else {
                            Y(intent);
                        }
                    }
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseIntent(intent);
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10068");
                    aqVar.r("duration", videoInfo.getDuration());
                    TiebaStatic.log(aqVar);
                    this.dbx.setVideoInfo(videoInfo);
                    this.dpD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.dpD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    aCf();
                } else if (i == 12012) {
                    if (!this.dqa) {
                        H(intent);
                        aCf();
                        return;
                    }
                    ab(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo2 = new VideoInfo();
                    videoInfo2.parseIntent(intent);
                    com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c10068");
                    aqVar2.r("duration", videoInfo2.getDuration());
                    TiebaStatic.log(aqVar2);
                    this.dbx.setVideoInfo(videoInfo2);
                    this.dpD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.dpD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo2));
                    aCf();
                } else if (i == 12013) {
                    I(intent);
                    aCf();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.dpD != null && !this.dpD.Ax()) {
                this.dmD.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Bq();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aDA();
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
                    this.arU = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.am.a(getPageContext(), this.arU);
                    return;
                case 12012:
                    aDA();
                    return;
            }
        }
    }

    private void aDz() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aDA() {
        if (this.dqa) {
            this.dpP.d(this.writeImagesInfo);
            aDB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDB() {
        this.dpP.notifyDataSetChanged();
        this.dpO.invalidate();
        this.mHandler.postDelayed(new bd(this), 550L);
    }

    public void n(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        aCf();
    }

    private void Y(Intent intent) {
        if (this.dqa) {
            ab(intent);
            aDA();
        } else {
            ac(intent);
        }
        aCf();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aDA();
            hc(true);
        }
    }

    private void Z(Intent intent) {
        int size;
        G(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void alH() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.cyL.parseJson(stringExtra);
            this.cyL.updateQuality();
            if (this.cyL.getChosedFiles() != null && this.cyL.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.cyL.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.cyL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aDt());
        HidenSoftKeyPad(this.mInputManager, aDs());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ac(Intent intent) {
        b(intent, true);
    }

    private void G(Intent intent) {
        this.arU = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arU;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cC = com.baidu.tbadk.core.util.c.cC(str);
                if (cC != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arU, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aDC();
            Bx();
        }
        hc(true);
    }

    private void H(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                aDC();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Bx();
                }
            }
            hc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDC() {
        if (this.dpD.dU(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void I(Intent intent) {
        if (this.dbx != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.dbx.setIsBaobao(true);
            this.dbx.setBaobaoContent(stringExtra2);
            Bz();
            hd(true);
        }
    }

    private void Bq() {
        new be(this).execute(new Void[0]);
    }

    private void hc(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void hd(boolean z) {
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
            if (AntiHelper.lc(postWriteCallBackData.getErrorCode())) {
                AntiHelper.P(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(i.h.error_write);
                }
                showToast(errorString2);
            } else if (this.dpE == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.ase = i;
        if (this.dpD != null) {
            this.dpD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (z) {
                this.dpD.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Bx() {
        if (!this.dqa && this.dpD != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.dpD.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.dpD.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.dpD.b(new com.baidu.tbadk.editortools.a(12, 15, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dpD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Bz() {
        if (this.dpD != null) {
            this.dpD.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.dpD.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.dpD.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (this.dpD != null) {
            this.dpD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void mg(int i) {
        if (i < this.dnZ.size()) {
            for (int i2 = 0; i2 < this.dnZ.size(); i2++) {
                this.dnZ.get(i2).gX(false);
            }
            this.dnZ.get(i).gX(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lS(int i) {
        this.dmh = i;
        this.dmG.lL(i);
        mg(i);
        this.dmF.setText(this.mPrefixData.getPrefixs().get(i));
        aCf();
        com.baidu.adp.lib.g.j.a(this.dmG, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.dmI.setSelected(false);
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
