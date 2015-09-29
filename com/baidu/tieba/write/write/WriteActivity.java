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
    public static String dpC = "from_writeActivity_livePhoto";
    private VoiceData.VoiceModel arR;
    private String arT;
    private com.baidu.tieba.tbadkCore.location.d arU;
    private com.baidu.tieba.tbadkCore.writeModel.a arV;
    private int dlH;
    private TextView dmf;
    private cd dmg;
    private ImageView dmh;
    private View dmi;
    private LinearLayout doR;
    private View doU;
    private View doV;
    private com.baidu.tieba.view.a dpH;
    private Toast dpb;
    private com.baidu.tbadk.editortools.j dpc;
    private AdditionData dpd;
    private RelativeLayout dpe;
    private TextView dpf;
    private TextView dpg;
    private TextView dph;
    private RelativeLayout dpk;
    private TextView dpl;
    private View dpm;
    private LiveBroadcastCard dpn;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData daX = null;
    private boolean doP = false;
    private boolean doQ = false;
    private InputMethodManager mInputManager = null;
    private EditText dlZ = null;
    private View dma = null;
    private LinearLayout dmc = null;
    private EditText dmd = null;
    private o doS = null;
    private FeedBackTopListView doT = null;
    private ArrayList<com.baidu.tieba.write.view.g> dnz = new ArrayList<>();
    private String bWl = null;
    private final KeyEvent doW = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView doX = null;
    private TextView dme = null;
    private TextView bsb = null;
    private DialogInterface.OnCancelListener cpM = null;
    private com.baidu.tbadk.core.dialog.a doY = null;
    private final Handler mHandler = new Handler();
    private boolean doZ = false;
    private String dpa = null;
    private RelativeLayout brd = null;
    private String asb = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int asd = 0;
    private int dpj = 0;
    private WriteImagesInfo cyA = new WriteImagesInfo();
    private View mRootView = null;
    private GridView dpo = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a dpp = null;
    private ScrollView dpq = null;
    private EditText dpr = null;
    private View dps = null;
    private View dpt = null;
    private View dpu = null;
    private EditText dpv = null;
    private TextView dpw = null;
    private TextView dpx = null;
    private TextWatcher dpy = null;
    private TextWatcher dpz = null;
    private boolean dpA = false;
    private boolean dpB = false;
    private final HttpMessageListener dpD = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d asj = new aj(this);
    private final d.a ash = new av(this);
    private final CustomMessageListener das = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener dpE = new bg(this);
    private boolean dpF = true;
    private final View.OnFocusChangeListener dlX = new bh(this);
    private final CustomMessageListener dpG = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0074a clt = new bj(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Bo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(i.h.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bp();
        } else if (this.arU.axh()) {
            Bn();
        } else {
            this.arU.gv(false);
            a(1, true, (String) null);
            this.arU.axf();
        }
    }

    private void Bp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new bk(this)).b(i.h.cancel, new z(this)).b(getPageContext());
        aVar.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCW() {
        int selectionEnd = aDm().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aDm().getText().getSpans(0, aDm().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aDm().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aDm().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCX() {
        if (this.dpc != null) {
            this.dpc.setBarLauncherEnabled(!this.dpF);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.dpH != null && this.daX != null && this.daX.getLiveCardData() != null) {
            new Handler().postDelayed(new aa(this, new Date(this.daX.getLiveCardData().getStartTime() * 1000)), 100L);
        }
        if (this.dpA) {
            this.dlZ.setVisibility(8);
            if (this.daX.getType() == 5) {
                this.dpu.setVisibility(8);
            } else {
                this.dpu.setVisibility(0);
            }
            b(this.dpx, this.dpr);
            b(this.dpw, this.dpv);
            aBZ();
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
        aDh();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.dpG.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dpG);
        this.arU = new com.baidu.tieba.tbadkCore.location.d(this);
        this.arU.a(this.ash);
        registerListener(this.das);
        initEditor();
        if (this.dpA) {
            this.dpp.setEditorTools(this.dpc);
        } else {
            this.dmd.requestFocus();
        }
    }

    private void initEditor() {
        this.dpc = new com.baidu.tbadk.editortools.j(getActivity());
        this.dpc.setBarMaxLauCount(4);
        this.dpc.setMoreButtonAtEnd(true);
        this.dpc.setBarLauncherType(1);
        this.dpc.setBarLinePostion(2);
        this.dpc.setMoreLauncherIcon(i.e.write_more);
        this.dpc.setBackgroundColorId(i.c.cp_bg_line_d);
        switch (this.daX.getType()) {
            case 4:
            case 5:
                aDa();
                break;
            default:
                aDb();
                break;
        }
        this.dpc.Ay();
        if (this.doR != null) {
            this.doR.addView(this.dpc);
        }
        aDc();
        this.dpc.ow();
        com.baidu.tbadk.editortools.p dS = this.dpc.dS(6);
        if (dS != null && !TextUtils.isEmpty(this.asb)) {
            ((View) dS).setOnClickListener(new ab(this));
        }
        com.baidu.tbadk.editortools.v dU = this.dpc.dU(5);
        if (dU != null && (dU.aoI instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dU.aoI).setFrom(1);
        }
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("xiaoying_has_click", false)) {
            this.dpc.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aCY() {
        this.dps = this.mRootView.findViewById(i.f.photo_live_scroll);
        this.dpu = this.dps.findViewById(i.f.live_post_title_container);
        this.dpr = (EditText) this.dps.findViewById(i.f.live_post_content);
        this.dpo = (GridView) this.dps.findViewById(i.f.photoLiveGridView);
        this.dpv = (EditText) this.dps.findViewById(i.f.live_post_title);
        this.dpw = (TextView) this.dps.findViewById(i.f.titleOverPlusNumber);
        this.dpx = (TextView) this.dps.findViewById(i.f.contentOverPlusNumber);
        this.dpt = this.dps.findViewById(i.f.live_interval_view);
        this.dpw.setText(String.valueOf(20));
        this.dpx.setText(String.valueOf(233));
        this.dps.setVisibility(0);
        this.dpw.setVisibility(0);
        this.dpx.setVisibility(0);
        this.dpv.setHint(i.h.tips_title_limit_new);
        this.dpv.setOnFocusChangeListener(new ac(this));
        if (this.daX.getType() == 4) {
            this.dpr.setHint(i.h.live_write_input_content_new);
        } else if (this.daX.getType() == 5) {
            this.dpr.setHint(i.h.live_write_input_content_update);
        }
        this.dpr.setOnFocusChangeListener(new ad(this));
        this.dpr.requestFocus();
        this.dpr.addTextChangedListener(akI());
        this.dpv.requestFocus();
        this.dpv.addTextChangedListener(akI());
        this.dpv.setOnClickListener(this.dpE);
        this.dpr.setOnClickListener(this.dpE);
        this.dpp = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.dpo);
        this.dpp.lV(6);
        this.dpo.setAdapter((ListAdapter) this.dpp);
        View findViewById = this.dps.findViewById(i.f.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        aCZ();
    }

    private void aCZ() {
        if (this.daX.getType() == 0) {
            if (this.daX.getTitle() != null) {
                this.dpv.setText(this.daX.getTitle());
                this.dpv.setSelection(this.daX.getTitle().length());
            }
        } else if (this.daX.getType() != 1) {
            this.daX.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.dpA) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aDt();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            BA();
            return;
        }
        if (this.dpc.AA()) {
            this.dpc.za();
        }
        String str = null;
        if (this.daX != null) {
            str = this.daX.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.dpA) {
            albumActivityConfig.getIntent().putExtra("from", dpC);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aDa() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.apr = i.e.write_face;
        this.dpc.b(mVar);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.apr = i.e.write_at;
        this.dpc.b(aVar);
        this.dpc.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aDb() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.v vVar;
        com.baidu.tbadk.editortools.v vVar2;
        com.baidu.tbadk.editortools.v vVar3;
        com.baidu.tbadk.editortools.v vVar4;
        com.baidu.tbadk.editortools.v vVar5;
        com.baidu.tbadk.editortools.v vVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        iVar.apr = i.e.write_picture;
        this.dpc.b(iVar);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.apr = i.e.write_face;
        this.dpc.b(mVar);
        if (XiaoyingUtil.showXiaoyingTool() && this.daX != null && !this.daX.isAddition()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask2 != null && (vVar6 = (com.baidu.tbadk.editortools.v) runTask2.getData()) != null) {
                vVar6.apt = 3;
                vVar6.apr = i.e.write_video;
                this.dpc.b(vVar6);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask3 != null && (vVar5 = (com.baidu.tbadk.editortools.v) runTask3.getData()) != null) {
                this.dpc.b(vVar5);
            }
        }
        this.dpc.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask4 != null && (vVar4 = (com.baidu.tbadk.editortools.v) runTask4.getData()) != null) {
            vVar4.apt = 4;
            vVar4.apr = i.e.write_privilege;
            this.dpc.b(vVar4);
        }
        this.dpc.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 5));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask5 != null && (vVar3 = (com.baidu.tbadk.editortools.v) runTask5.getData()) != null) {
            vVar3.apv = true;
            vVar3.apt = 8;
            vVar3.apr = 0;
            this.dpc.b(vVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask6 != null && (vVar2 = (com.baidu.tbadk.editortools.v) runTask6.getData()) != null) {
            vVar2.apv = true;
            vVar2.apt = 9;
            vVar2.apr = 0;
            this.dpc.b(vVar2);
        }
        Boolean aDr = aDr();
        if (!this.doP && aDr != null && aDr.booleanValue() && com.baidu.tieba.tbadkCore.voice.b.axD() && com.baidu.tieba.tbadkCore.u.a(this.daX.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.v.class)) != null && (vVar = (com.baidu.tbadk.editortools.v) runTask.getData()) != null) {
            vVar.apt = 6;
            this.dpc.b(vVar);
        }
        if (this.daX != null && this.daX.getType() == 0 && !this.doP && !this.doQ && TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            this.dpc.b(new com.baidu.tbadk.editortools.b.b(getActivity(), 7));
            this.dpc.b(new com.baidu.tbadk.editortools.b.a(getActivity()));
        }
        if (this.dpd == null) {
            this.dpc.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
    }

    private void aDc() {
        af afVar = new af(this);
        this.dpc.a(16, afVar);
        this.dpc.a(21, afVar);
        this.dpc.a(14, afVar);
        this.dpc.a(24, afVar);
        this.dpc.a(3, afVar);
        this.dpc.a(10, afVar);
        this.dpc.a(11, afVar);
        this.dpc.a(12, afVar);
        this.dpc.a(13, afVar);
        this.dpc.a(22, afVar);
        this.dpc.a(23, afVar);
        this.dpc.a(15, afVar);
        this.dpc.a(18, afVar);
        this.dpc.a(25, afVar);
        this.dpc.a(27, afVar);
        this.dpc.a(29, afVar);
    }

    public void ayc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq() {
        if (this.arU.axj()) {
            if (this.arU.axh()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.axc().getLocationData().awY());
                return;
            }
            a(1, true, (String) null);
            this.arU.axf();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBR() {
        if (this.arV != null) {
            this.arV.cancelLoadData();
        }
        if (this.doS != null) {
            this.doS.cancelLoadData();
        }
        if (this.arU != null) {
            this.arU.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aBR();
        aDq();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDd() {
        if (this.daX != null && this.daX.getType() == 2 && this.doZ) {
            finish();
        } else if (this.daX == null) {
            finish();
        } else {
            this.daX.setTitle(aDn().getText().toString());
            this.daX.setContent(aDm().getText().toString());
            int type = this.daX.getType();
            if (type == 0) {
                if (this.daX.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ad.b(this.daX.getForumId(), this.daX);
                } else {
                    com.baidu.tieba.tbadkCore.ad.a(this.daX.getLiveCardData().getGroupId(), this.daX);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.daX.getThreadId(), this.daX);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.daX.getForumId()) + "photolive", this.daX);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.daX.getThreadId()) + "updatephotolive", this.daX);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dmg != null && this.dmg.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dmg, getPageContext().getPageActivity());
                return true;
            } else if (this.dpc.AA()) {
                this.dpc.za();
                return true;
            } else {
                aBR();
                aDd();
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
        getLayoutMode().k(this.brd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.am.i((View) this.dme, i.e.s_navbar_button_bg);
        aCX();
        com.baidu.tbadk.core.util.am.j(this.dps, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.j(this.dma, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.j(this.dpt, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.j((View) aDn(), i.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bWl)) {
            com.baidu.tbadk.core.util.am.j((View) aDm(), i.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_e);
        aDn().setTextColor(color);
        aDm().setTextColor(color);
        a(aDn(), color2);
        a(aDm(), color2);
        aBZ();
        this.dpc.onChangeSkinType(i);
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
        this.dpA = this.daX.getType() == 4 || 5 == this.daX.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(i.g.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsb = this.mNavigationBar.setTitleText("");
        this.doX = (TextView) findViewById(i.f.btn_image_problem);
        this.dme = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dme.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dme.setLayoutParams(layoutParams);
        this.dme.setOnFocusChangeListener(this.dlX);
        this.dpq = (ScrollView) findViewById(i.f.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.doT = (FeedBackTopListView) findViewById(i.f.feedback_top_list);
        this.doU = findViewById(i.f.feedback_divider);
        this.brd = (RelativeLayout) findViewById(i.f.parent);
        this.doR = (LinearLayout) findViewById(i.f.tool_view);
        this.dma = findViewById(i.f.interval_view);
        aBY();
        if (this.dpA) {
            this.dpq.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aCY();
        }
        aCa();
        if (this.doP || this.doQ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(i.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(i.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dmc = (LinearLayout) findViewById(i.f.post_content_container);
        this.dmc.setDrawingCacheEnabled(false);
        this.dmc.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.dlX);
        this.mBack.setOnClickListener(new ah(this));
        this.doX.setOnClickListener(new ai(this));
        i(aDr());
        aDf();
        aDi();
        ayc();
        switch (this.daX.getType()) {
            case 0:
                if (this.doP || this.doQ) {
                    this.bsb.setText(i.h.feedback);
                } else {
                    this.bsb.setText(i.h.post_new_thread);
                }
                this.dlZ.setVisibility(0);
                this.dmd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bsb.setText(i.h.send_reply);
                this.dmd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.dlZ.setVisibility(8);
                break;
            case 4:
                this.bsb.setText(i.h.publish_photo_live);
                this.dmd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bsb.setText(getPageContext().getResources().getString(i.h.update_photo_live_tip, Integer.valueOf(this.daX.getFloorNum() + 1)));
                this.dpt.setVisibility(8);
                break;
        }
        aDj();
        aDp();
        aCX();
        aDg();
        aBX();
        if (this.daX.getType() == 4 && this.dmi != null && this.doV != null) {
            this.dmi.setVisibility(8);
            this.doV.setVisibility(8);
        }
        aBZ();
        if (this.daX.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.dlZ);
        }
        aDe();
    }

    private void aDe() {
    }

    private void aDf() {
        this.dpk = (RelativeLayout) findViewById(i.f.live_time_rel);
        this.dpl = (TextView) findViewById(i.f.live_tiem_show);
        this.dpm = findViewById(i.f.interval_view2);
        this.dpn = (LiveBroadcastCard) findViewById(i.f.live_anchor_card);
        this.dpk.setOnClickListener(new ak(this));
        this.dpk.setOnTouchListener(new al(this));
        if (this.daX.getLiveCardData() != null) {
            this.dpk.setVisibility(0);
            this.dpm.setVisibility(0);
            this.dpn.setVisibility(0);
            this.dpn.setClickable(false);
            this.dpl.setText(com.baidu.tbadk.core.util.ar.p(this.daX.getLiveCardData().getStartTime() * 1000));
            this.dpn.setData(this.daX.getLiveCardData());
            return;
        }
        this.dpk.setVisibility(8);
        this.dpm.setVisibility(8);
        this.dpn.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.daX.getLiveCardData() != null) {
            Date date = new Date(this.daX.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.dpH = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.dpH.setTitle(i.h.no_disturb_start_time);
        this.dpH.setButton(-1, getPageContext().getString(i.h.alert_yes_button), this.dpH);
        this.dpH.setButton(-2, getPageContext().getString(i.h.alert_no_button), this.dpH);
        return this.dpH;
    }

    private void aDg() {
        this.dpe = (RelativeLayout) findViewById(i.f.addition_container);
        this.dpf = (TextView) findViewById(i.f.addition_create_time);
        this.dpg = (TextView) findViewById(i.f.addition_last_time);
        this.dph = (TextView) findViewById(i.f.addition_last_content);
        if (this.dpd != null) {
            this.dpe.setVisibility(0);
            this.dpf.setText(String.valueOf(getPageContext().getString(i.h.write_addition_create)) + com.baidu.tbadk.core.util.ar.o(this.dpd.getCreateTime() * 1000));
            if (this.dpd.getAlreadyCount() == 0) {
                this.dpg.setVisibility(8);
            } else {
                this.dpg.setText(String.valueOf(getPageContext().getString(i.h.write_addition_last)) + com.baidu.tbadk.core.util.ar.o(this.dpd.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.dpd.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.dph.setText(lastAdditionContent);
            } else {
                this.dph.setVisibility(8);
            }
            aDm().setHint(String.format(getPageContext().getString(i.h.write_addition_hint), Integer.valueOf(this.dpd.getAlreadyCount()), Integer.valueOf(this.dpd.getTotalCount())));
            this.bsb.setText(i.h.write_addition_title);
            return;
        }
        this.dpe.setVisibility(8);
    }

    private void aBX() {
        this.dmi = findViewById(i.f.post_prefix_layout);
        this.dmf = (TextView) findViewById(i.f.post_prefix);
        this.doV = findViewById(i.f.prefix_divider);
        this.dmh = (ImageView) findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.dmi.setVisibility(0);
            this.doV.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dlH = 1;
            this.dmi.setOnClickListener(new an(this));
            this.dmh = (ImageView) findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dmh.setVisibility(0);
                this.dmf.setOnClickListener(new ao(this));
            }
            this.dmg = new cd(getPageContext().getPageActivity());
            this.dmg.a(this);
            this.dmg.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), i.d.ds510));
            this.dmg.setOutsideTouchable(true);
            this.dmg.setFocusable(true);
            this.dmg.setOnDismissListener(this);
            this.dmg.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.am.getColor(i.c.write_text);
            int color2 = com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_c);
            com.baidu.tbadk.core.util.am.i((View) this.dmf, i.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.c(this.dmh, i.e.icon_title_down);
            this.dmf.setTextColor(color);
            this.dnz.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(getActivity());
                this.dnz.add(gVar);
                gVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    gVar.setPrefixTextColor(color2);
                } else {
                    gVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    gVar.setDividerStyle(false);
                }
                this.dmg.addView(gVar);
            }
            this.dmg.lJ(0);
            this.dmf.setText(prefixs.get(1));
            me(1);
            return;
        }
        this.dmi.setVisibility(8);
    }

    private void aDh() {
        if (this.doP && this.daX != null) {
            this.doT.setVisibility(0);
            this.doU.setVisibility(0);
            this.doS = new o(this);
            this.doS.ms(this.daX.getForumName());
            this.doS.setLoadDataCallBack(new ap(this));
        }
    }

    protected void aDi() {
        this.dme.setOnClickListener(new aq(this));
    }

    protected void aDj() {
        this.doY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.doY.ct(getPageContext().getString(i.h.is_save_draft)).aj(false).a(getPageContext().getString(i.h.save), new ar(this)).b(getPageContext().getString(i.h.not_save), new at(this));
        this.doY.b(getPageContext());
    }

    protected void aBY() {
        this.dlZ = (EditText) findViewById(i.f.post_title);
        this.dlZ.setOnClickListener(this.dpE);
        this.dlZ.setOnFocusChangeListener(this.dlX);
        if (this.daX.getType() == 0) {
            if (this.daX.getTitle() != null) {
                this.dlZ.setText(this.daX.getTitle());
                this.dlZ.setSelection(this.daX.getTitle().length());
            }
        } else if (this.daX.getType() != 1) {
            this.daX.getType();
        }
        this.dlZ.addTextChangedListener(new au(this));
    }

    private TextWatcher akI() {
        aw awVar = new aw(this);
        if (this.dpA && this.dpB) {
            if (this.dpy != null) {
                this.dpv.removeTextChangedListener(this.dpy);
            }
            this.dpy = awVar;
        } else if (this.dpA) {
            if (this.dpz != null) {
                this.dpr.removeTextChangedListener(this.dpz);
            }
            this.dpz = awVar;
        }
        return awVar;
    }

    private long e(EditText editText) {
        if (editText == this.dpr) {
            return 233L;
        }
        if (editText != this.dpv) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_d));
                }
            } else if (d < 0) {
                if (d < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long d(EditText editText) {
        return com.baidu.tieba.write.c.a.f(editText.getText().toString().trim());
    }

    protected void aCa() {
        this.dmd = (EditText) findViewById(i.f.post_content);
        this.dmd.setDrawingCacheEnabled(false);
        this.dmd.setOnClickListener(this.dpE);
        if (this.daX.getContent() != null && this.daX.getContent().length() > 0) {
            SpannableString G = TbFaceManager.Ce().G(getPageContext().getPageActivity(), this.daX.getContent());
            this.dmd.setText(G);
            this.dmd.setSelection(G.length());
        } else if (this.daX.getType() == 2) {
            if (this.doZ) {
                if (this.dpa != null && this.dpa.length() > 0) {
                    this.dmd.setText(getPageContext().getPageActivity().getString(i.h.reply_sub_floor, new Object[]{this.dpa}));
                    this.dmd.setSelection(this.dmd.getText().length());
                }
            } else if (this.daX.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(i.h.reply_x_floor), Integer.valueOf(this.daX.getFloorNum()));
                this.dmd.setText(format);
                this.dmd.setSelection(format.length());
            }
        }
        this.dmd.setOnFocusChangeListener(this.dlX);
        this.dmd.setOnTouchListener(new ax(this));
        this.dmd.addTextChangedListener(new ay(this));
        hb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.dpA) {
            aDm().setPadding(0, 0, 0, 0);
            aDm().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.am.j((View) aDm(), i.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bWl) && this.dpd == null) {
                com.baidu.adp.lib.f.c.ha().a(this.bWl, 19, new az(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDk() {
        int i = 5000;
        if (this.dpd != null) {
            i = 1000;
        }
        return aDm().getText() != null && aDm().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDl() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.dpc != null) {
                this.dpc.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.avZ() && this.dpj == 0) {
            showToast(i.h.baobao_over_limit);
        } else {
            String charSequence = this.bsb.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) aDm().getText().getSpans(0, aDm().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.dpb == null) {
                this.dpb = Toast.makeText(getPageContext().getPageActivity(), i.h.too_many_face, 0);
            }
            this.dpb.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType wk = fVar.wk();
        if (name != null) {
            com.baidu.adp.lib.f.c.ha().a(name, 20, new ba(this, new SpannableStringBuilder(name), wk), 0, 0, getUniqueId(), null, name, false, null);
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
        aDm().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aDm() {
        return this.dpA ? this.dpr : this.dmd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aDn() {
        return this.dpA ? this.dpv : this.dlZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDo() {
        aDm().onKeyDown(67, this.doW);
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.daX != null) {
            str = this.daX.getForumName();
        }
        if (getPageContext().getString(i.h.feedback_bar_name).equals(str)) {
            this.doP = true;
        }
    }

    private void aDp() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aDq() {
        try {
            if (this.doY != null) {
                this.doY.dismiss();
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

    private Boolean aDr() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.asb = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBZ() {
        String str;
        String str2 = null;
        if (this.daX != null) {
            String editable = aDn().getText().toString();
            String trim = aDm().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.daX.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.dlH == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.daX.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.daX.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.daX.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.daX.setIsNoTitle(true);
                str = null;
            } else {
                this.daX.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.dpA) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.arR != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.daX.getVideoInfo() != null) {
                str = "1";
            }
            if (this.daX.getType() == 4) {
                if (g(this.dpr) && f(this.dpv)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.daX.getType() != 5) {
                str2 = str;
            } else if (g(this.dpr)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dme.setEnabled(false);
            } else {
                this.dme.setEnabled(true);
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
        this.arV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arV.b(this.asj);
        registerListener(this.dpD);
        this.cpM = new bb(this);
        this.daX = new WriteData();
        if (bundle != null) {
            this.daX.setType(bundle.getInt("type", 0));
            this.daX.setForumId(bundle.getString("forum_id"));
            this.daX.setForumName(bundle.getString("forum_name"));
            this.daX.setThreadId(bundle.getString("thread_id"));
            this.daX.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.daX.setFloorNum(bundle.getInt("floor_num", 0));
            this.doP = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.doZ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dpa = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.arT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.dpd = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.daX.setIsAddition(this.dpd != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.dpj = bundle.getInt("mem_type", 0);
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
                this.daX.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.daX.setType(intent.getIntExtra("type", 0));
            this.daX.setForumId(intent.getStringExtra("forum_id"));
            this.daX.setForumName(intent.getStringExtra("forum_name"));
            this.daX.setThreadId(intent.getStringExtra("thread_id"));
            this.daX.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.daX.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.doP = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.doZ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dpa = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.dpd = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.daX.setIsAddition(this.dpd != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.dpj = intent.getIntExtra("mem_type", 0);
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
                this.daX.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.daX.getType() == 4 ? 6 : 10);
        this.daX.setWriteImagesInfo(this.writeImagesInfo);
        this.daX.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.daX.getType() == 0) {
            if (this.daX.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ad.c(this.daX.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ad.a(this.daX.getLiveCardData().getGroupId(), this);
            }
        } else if (this.daX.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.daX.getThreadId(), this);
        } else if (this.daX.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.daX.getForumId()) + "photolive", this);
        } else if (this.daX.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.daX.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
        }
        this.bWl = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.daX != null && this.daX.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.daX.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.doQ = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (this.daX != null) {
                this.daX.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aDn().getText().toString()) || ((this.doP || this.doQ) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.daX.setTitle(writeData.getTitle());
                    aDn().setText(this.daX.getTitle());
                    aDn().setSelection(this.daX.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.daX.setVideoInfo(videoInfo);
                    this.dpc.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.daX.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.dpl.setText(com.baidu.tbadk.core.util.ar.p(this.daX.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aDm().getText().toString()) || this.doP || this.doQ) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.daX.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ce().a(getPageContext().getPageActivity(), this.daX.getContent(), new bc(this));
                    aDm().setText(a2);
                    aDm().setSelection(a2.length());
                    if (this.dpA) {
                        b(this.dpx, this.dpr);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.daX.setWriteImagesInfo(this.writeImagesInfo);
                    aDw();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        BA();
                    }
                    hc(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.daX.setIsBaobao(writeData.getIsBaobao());
                        this.daX.setBaobaoContent(writeData.getBaobaoContent());
                        this.daX.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.daX.getIsBaobao()) {
                        BC();
                        hd(false);
                    }
                }
                writeData.getType();
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aDs();
                    aBZ();
                }
                this.dpc.za();
                return;
            }
            return;
        }
        aDs();
    }

    private void aDs() {
        if ((!this.dpA || this.dpp != null) && this.dpo != null) {
            this.dpp.d(this.writeImagesInfo);
            aDv();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.daX.getType());
        bundle.putString("forum_id", this.daX.getForumId());
        bundle.putString("forum_name", this.daX.getForumName());
        bundle.putString("thread_id", this.daX.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.daX.getFloor());
        bundle.putInt("floor_num", this.daX.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.doZ);
        if (this.doP) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arT);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.dpd);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.dpj);
        if (this.daX.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.daX.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.daX.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.daX.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.daX.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.daX.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.daX.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.daX.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.daX.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.daX.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aDm().getEditableText().toString();
        if (editable != null) {
            aDm().setText(TbFaceManager.Ce().G(getPageContext().getPageActivity(), editable));
            aDm().setSelection(aDm().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCw() {
        aBR();
        if (this.daX.getLiveCardData() != null) {
            if (!this.daX.getLiveCardData().isModifyTime()) {
                this.daX.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.dpl.setText(com.baidu.tbadk.core.util.ar.p(this.daX.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.daX.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.daX.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.daX.getLiveCardData().getStartTime() / 60) {
                showToast(i.h.live_start_time_error);
                return;
            }
        }
        String editable = aDn().getText().toString();
        this.daX.setContent(aDm().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dlH != 0 && this.daX.getType() != 4) {
            this.daX.setTitle(String.valueOf(this.dmf.getText().toString()) + editable);
        } else {
            this.daX.setTitle(editable);
        }
        if (this.doP || this.doQ) {
            String string = getResources().getString(i.h.android_feedback);
            if (TextUtils.isEmpty(this.daX.getTitle()) || !this.daX.getTitle().startsWith(string)) {
                this.daX.setTitle(string + this.daX.getTitle());
            }
            String str = String.valueOf(getResources().getString(i.h.app_name)) + getResources().getString(i.h.tieba_client);
            if (TextUtils.isEmpty(this.daX.getContent()) || !this.daX.getContent().startsWith(str)) {
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
                sb.append(this.daX.getContent());
                this.daX.setContent(sb.toString());
            }
        }
        this.daX.setWriteImagesInfo(this.writeImagesInfo);
        this.daX.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.daX.setHasLocationData(this.arU == null ? false : this.arU.axj());
        this.arV.gw(this.writeImagesInfo.size() > 0);
        this.arV.c(this.daX);
        this.daX.setVcode(null);
        if (this.arR != null) {
            if (this.arR.getId() != null) {
                this.arV.axE().setVoice(this.arR.getId());
                this.arV.axE().setVoiceDuringTime(this.arR.duration);
            } else {
                this.arV.axE().setVoice(null);
                this.arV.axE().setVoiceDuringTime(-1);
            }
        } else {
            this.arV.axE().setVoice(null);
            this.arV.axE().setVoiceDuringTime(-1);
        }
        if (!this.arV.axI()) {
            showToast(i.h.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(i.h.sending), this.cpM);
        if (!this.arV.axF()) {
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
            if (this.dpd != null) {
                i2 = this.dpd.getTotalCount();
                i = this.dpd.getAlreadyCount() + 1;
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
                if (this.dpc != null && !this.dpc.AA()) {
                    aDm().requestFocus();
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
                            aDm().getText().insert(aDm().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.daX.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.daX.getForumId(), (WriteData) null);
                } else if (this.daX.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.daX.getThreadId(), (WriteData) null);
                } else if (this.daX.getType() == 4) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.daX.getForumId()) + "photolive", (WriteData) null);
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
                                alL();
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
                    com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c10068");
                    apVar.r("duration", videoInfo.getDuration());
                    TiebaStatic.log(apVar);
                    this.daX.setVideoInfo(videoInfo);
                    this.dpc.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.dpc.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    aBZ();
                } else if (i == 12012) {
                    if (!this.dpA) {
                        H(intent);
                        aBZ();
                        return;
                    }
                    ab(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo2 = new VideoInfo();
                    videoInfo2.parseIntent(intent);
                    com.baidu.tbadk.core.util.ap apVar2 = new com.baidu.tbadk.core.util.ap("c10068");
                    apVar2.r("duration", videoInfo2.getDuration());
                    TiebaStatic.log(apVar2);
                    this.daX.setVideoInfo(videoInfo2);
                    this.dpc.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.dpc.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo2));
                    aBZ();
                } else if (i == 12013) {
                    I(intent);
                    aBZ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.dpc != null && !this.dpc.AA()) {
                this.dmd.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Bt();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aDu();
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
                    this.arT = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.al.a(getPageContext(), this.arT);
                    return;
                case 12012:
                    aDu();
                    return;
            }
        }
    }

    private void aDt() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aDu() {
        if (this.dpA) {
            this.dpp.d(this.writeImagesInfo);
            aDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDv() {
        this.dpp.notifyDataSetChanged();
        this.dpo.invalidate();
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
        aBZ();
    }

    private void Y(Intent intent) {
        if (this.dpA) {
            ab(intent);
            aDu();
        } else {
            ac(intent);
        }
        aBZ();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aDu();
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

    private void alL() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.cyA.parseJson(stringExtra);
            this.cyA.updateQuality();
            if (this.cyA.getChosedFiles() != null && this.cyA.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.cyA.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.cyA.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aDn());
        HidenSoftKeyPad(this.mInputManager, aDm());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ac(Intent intent) {
        b(intent, true);
    }

    private void G(Intent intent) {
        this.arT = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arT;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cB = com.baidu.tbadk.core.util.c.cB(str);
                if (cB != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arT, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aDw();
            BA();
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
                aDw();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    BA();
                }
            }
            hc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDw() {
        if (this.dpc.dU(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void I(Intent intent) {
        if (this.daX != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.daX.setIsBaobao(true);
            this.daX.setBaobaoContent(stringExtra2);
            BC();
            hd(true);
        }
    }

    private void Bt() {
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
            if (AntiHelper.la(postWriteCallBackData.getErrorCode())) {
                AntiHelper.P(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(i.h.error_write);
                }
                showToast(errorString2);
            } else if (this.dpd == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.asd = i;
        if (this.dpc != null) {
            this.dpc.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (z) {
                this.dpc.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void BA() {
        if (!this.dpA && this.dpc != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.dpc.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.dpc.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.dpc.b(new com.baidu.tbadk.editortools.a(12, 15, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dpc.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void BC() {
        if (this.dpc != null) {
            this.dpc.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.dpc.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.dpc.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (this.dpc != null) {
            this.dpc.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void me(int i) {
        if (i < this.dnz.size()) {
            for (int i2 = 0; i2 < this.dnz.size(); i2++) {
                this.dnz.get(i2).gX(false);
            }
            this.dnz.get(i).gX(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lQ(int i) {
        this.dlH = i;
        this.dmg.lJ(i);
        me(i);
        this.dmf.setText(this.mPrefixData.getPrefixs().get(i));
        aBZ();
        com.baidu.adp.lib.g.j.a(this.dmg, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.dmi.setSelected(false);
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
