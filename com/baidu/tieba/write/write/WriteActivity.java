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
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.write.cb;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ad.a, cb.a {
    public static String ddK = "from_writeActivity_livePhoto";
    private VoiceData.VoiceModel atu;
    private String atw;
    private com.baidu.tieba.tbadkCore.location.d atx;
    private com.baidu.tieba.tbadkCore.writeModel.a aty;
    private int daF;
    private TextView dbd;
    private cb dbe;
    private ImageView dbf;
    private View dbg;
    private LinearLayout dcZ;
    private com.baidu.tieba.view.a ddP;
    private View ddc;
    private View ddd;
    private Toast ddk;
    private com.baidu.tbadk.editortools.j ddl;
    private AdditionData ddm;
    private RelativeLayout ddn;
    private TextView ddo;
    private TextView ddp;
    private TextView ddq;
    private RelativeLayout dds;
    private TextView ddt;
    private View ddu;
    private LiveBroadcastCard ddv;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cTs = null;
    private boolean dcX = false;
    private boolean dcY = false;
    private InputMethodManager mInputManager = null;
    private EditText daX = null;
    private View daY = null;
    private LinearLayout dba = null;
    private EditText dbb = null;
    private o dda = null;
    private FeedBackTopListView ddb = null;
    private ArrayList<com.baidu.tieba.write.view.g> dde = new ArrayList<>();
    private String bSz = null;
    private final KeyEvent ddf = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ddg = null;
    private TextView dbc = null;
    private TextView bpb = null;
    private DialogInterface.OnCancelListener ckj = null;
    private com.baidu.tbadk.core.dialog.a ddh = null;
    private final Handler mHandler = new Handler();
    private boolean ddi = false;
    private String ddj = null;
    private RelativeLayout boe = null;
    private String atE = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int atG = 0;
    private int ddr = 0;
    private WriteImagesInfo csz = new WriteImagesInfo();
    private View mRootView = null;
    private GridView ddw = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a ddx = null;
    private ScrollView ddy = null;
    private EditText ddz = null;
    private View ddA = null;
    private View ddB = null;
    private View ddC = null;
    private EditText ddD = null;
    private TextView ddE = null;
    private TextView ddF = null;
    private TextWatcher ddG = null;
    private TextWatcher ddH = null;
    private boolean ddI = false;
    private boolean ddJ = false;
    private final HttpMessageListener ddL = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d atM = new aj(this);
    private final d.a atK = new av(this);
    private final CustomMessageListener cSO = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener ddM = new bg(this);
    private boolean ddN = true;
    private final View.OnFocusChangeListener daV = new bh(this);
    private final CustomMessageListener ddO = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0071a cga = new bj(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void BA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void BB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(i.h.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BC();
        } else if (this.atx.auV()) {
            BA();
        } else {
            this.atx.gl(false);
            a(1, true, (String) null);
            this.atx.auT();
        }
    }

    private void BC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new bk(this)).b(i.h.cancel, new z(this)).b(getPageContext());
        aVar.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int azu() {
        int selectionEnd = azK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) azK().getText().getSpans(0, azK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = azK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = azK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azv() {
        if (this.ddl != null) {
            this.ddl.setBarLauncherEnabled(!this.ddN);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.ddP != null && this.cTs != null && this.cTs.getLiveCardData() != null) {
            new Handler().postDelayed(new aa(this, new Date(this.cTs.getLiveCardData().getStartTime() * 1000)), 100L);
        }
        if (this.ddI) {
            this.daX.setVisibility(8);
            if (this.cTs.getType() == 5) {
                this.ddC.setVisibility(8);
            } else {
                this.ddC.setVisibility(0);
            }
            b(this.ddF, this.ddz);
            b(this.ddE, this.ddD);
            ayQ();
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
        azF();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.ddO.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.ddO);
        this.atx = new com.baidu.tieba.tbadkCore.location.d(this);
        this.atx.a(this.atK);
        registerListener(this.cSO);
        initEditor();
        if (this.ddI) {
            this.ddx.setEditorTools(this.ddl);
        } else {
            this.dbb.requestFocus();
        }
    }

    private void initEditor() {
        this.ddl = new com.baidu.tbadk.editortools.j(getActivity());
        this.ddl.setBarMaxLauCount(4);
        this.ddl.setMoreButtonAtEnd(true);
        this.ddl.setBarLauncherType(1);
        this.ddl.setBarLinePostion(2);
        this.ddl.setMoreLauncherIcon(i.e.write_more);
        this.ddl.setBackgroundColorId(i.c.cp_bg_line_d);
        switch (this.cTs.getType()) {
            case 4:
            case 5:
                azy();
                break;
            default:
                azz();
                break;
        }
        this.ddl.AM();
        if (this.dcZ != null) {
            this.dcZ.addView(this.ddl);
        }
        azA();
        this.ddl.ov();
        com.baidu.tbadk.editortools.p dR = this.ddl.dR(6);
        if (dR != null && !TextUtils.isEmpty(this.atE)) {
            ((View) dR).setOnClickListener(new ab(this));
        }
        com.baidu.tbadk.editortools.v dT = this.ddl.dT(5);
        if (dT != null && (dT.aqi instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dT.aqi).setFrom(1);
        }
    }

    private void azw() {
        this.ddA = this.mRootView.findViewById(i.f.live_container);
        this.ddC = this.ddA.findViewById(i.f.live_post_title_container);
        this.ddz = (EditText) this.ddA.findViewById(i.f.live_post_content);
        this.ddw = (GridView) this.ddA.findViewById(i.f.photoLiveGridView);
        this.ddD = (EditText) this.ddA.findViewById(i.f.live_post_title);
        this.ddE = (TextView) this.ddA.findViewById(i.f.titleOverPlusNumber);
        this.ddF = (TextView) this.ddA.findViewById(i.f.contentOverPlusNumber);
        this.ddB = this.ddA.findViewById(i.f.live_interval_view);
        this.ddE.setText(String.valueOf(20));
        this.ddF.setText(String.valueOf(233));
        this.ddA.setVisibility(0);
        this.ddE.setVisibility(0);
        this.ddF.setVisibility(0);
        this.ddD.setHint(i.h.tips_title_limit_new);
        this.ddD.setOnFocusChangeListener(new ac(this));
        if (this.cTs.getType() == 4) {
            this.ddz.setHint(i.h.live_write_input_content_new);
        } else if (this.cTs.getType() == 5) {
            this.ddz.setHint(i.h.live_write_input_content_update);
        }
        this.ddz.setOnFocusChangeListener(new ad(this));
        this.ddz.requestFocus();
        this.ddz.addTextChangedListener(aiE());
        this.ddD.requestFocus();
        this.ddD.addTextChangedListener(aiE());
        this.ddD.setOnClickListener(this.ddM);
        this.ddz.setOnClickListener(this.ddM);
        this.ddx = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.ddw);
        this.ddx.lg(6);
        this.ddw.setAdapter((ListAdapter) this.ddx);
        View findViewById = this.ddA.findViewById(i.f.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        azx();
    }

    private void azx() {
        if (this.cTs.getType() == 0) {
            if (this.cTs.getTitle() != null) {
                this.ddD.setText(this.cTs.getTitle());
                this.ddD.setSelection(this.cTs.getTitle().length());
            }
        } else if (this.cTs.getType() != 1) {
            this.cTs.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.ddI) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            azS();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            BN();
            return;
        }
        if (this.ddl.AO()) {
            this.ddl.zr();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()));
        if (this.ddI) {
            albumActivityConfig.getIntent().putExtra("from", ddK);
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void azy() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.aqQ = i.e.write_face;
        this.ddl.b(mVar);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aqQ = i.e.write_at;
        this.ddl.b(aVar);
        this.ddl.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void azz() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.v vVar;
        com.baidu.tbadk.editortools.v vVar2;
        com.baidu.tbadk.editortools.v vVar3;
        com.baidu.tbadk.editortools.v vVar4;
        com.baidu.tbadk.editortools.v vVar5;
        com.baidu.tbadk.editortools.v vVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        iVar.aqQ = i.e.write_picture;
        this.ddl.b(iVar);
        com.baidu.tbadk.editortools.emotiontool.m mVar = new com.baidu.tbadk.editortools.emotiontool.m(getActivity(), 2);
        mVar.aqQ = i.e.write_face;
        this.ddl.b(mVar);
        if (XiaoyingUtil.showXiaoyingTool() && this.cTs != null && !this.cTs.isAddition()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask2 != null && (vVar6 = (com.baidu.tbadk.editortools.v) runTask2.getData()) != null) {
                vVar6.aqS = 3;
                vVar6.aqQ = i.e.write_video;
                this.ddl.b(vVar6);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.v.class);
            if (runTask3 != null && (vVar5 = (com.baidu.tbadk.editortools.v) runTask3.getData()) != null) {
                this.ddl.b(vVar5);
            }
        }
        this.ddl.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask4 != null && (vVar4 = (com.baidu.tbadk.editortools.v) runTask4.getData()) != null) {
            vVar4.aqS = 4;
            vVar4.aqQ = i.e.write_privilege;
            this.ddl.b(vVar4);
        }
        this.ddl.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 5));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask5 != null && (vVar3 = (com.baidu.tbadk.editortools.v) runTask5.getData()) != null) {
            vVar3.aqU = true;
            vVar3.aqS = 8;
            vVar3.aqQ = 0;
            this.ddl.b(vVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.v.class);
        if (runTask6 != null && (vVar2 = (com.baidu.tbadk.editortools.v) runTask6.getData()) != null) {
            vVar2.aqU = true;
            vVar2.aqS = 9;
            vVar2.aqQ = 0;
            this.ddl.b(vVar2);
        }
        Boolean azP = azP();
        if (!this.dcX && azP != null && azP.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.avq() && com.baidu.tieba.tbadkCore.u.a(this.cTs.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.v.class)) != null && (vVar = (com.baidu.tbadk.editortools.v) runTask.getData()) != null) {
            vVar.aqS = 6;
            this.ddl.b(vVar);
        }
        if (this.cTs != null && this.cTs.getType() == 0 && !this.dcX && !this.dcY && TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            this.ddl.b(new com.baidu.tbadk.editortools.b.b(getActivity(), 7));
            this.ddl.b(new com.baidu.tbadk.editortools.b.a(getActivity()));
        }
        if (this.ddm == null) {
            this.ddl.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
    }

    private void azA() {
        af afVar = new af(this);
        this.ddl.a(16, afVar);
        this.ddl.a(21, afVar);
        this.ddl.a(14, afVar);
        this.ddl.a(24, afVar);
        this.ddl.a(3, afVar);
        this.ddl.a(10, afVar);
        this.ddl.a(11, afVar);
        this.ddl.a(12, afVar);
        this.ddl.a(13, afVar);
        this.ddl.a(22, afVar);
        this.ddl.a(23, afVar);
        this.ddl.a(15, afVar);
        this.ddl.a(18, afVar);
        this.ddl.a(25, afVar);
        this.ddl.a(27, afVar);
        this.ddl.a(29, afVar);
    }

    public void avO() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD() {
        if (this.atx.auX()) {
            if (this.atx.auV()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.auQ().getLocationData().auM());
                return;
            }
            a(1, true, (String) null);
            this.atx.auT();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayI() {
        if (this.aty != null) {
            this.aty.cancelLoadData();
        }
        if (this.dda != null) {
            this.dda.cancelLoadData();
        }
        if (this.atx != null) {
            this.atx.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        ayI();
        azO();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azB() {
        if (this.cTs != null && this.cTs.getType() == 2 && this.ddi) {
            finish();
        } else if (this.cTs == null) {
            finish();
        } else {
            this.cTs.setTitle(azL().getText().toString());
            this.cTs.setContent(azK().getText().toString());
            int type = this.cTs.getType();
            if (type == 0) {
                if (this.cTs.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ad.b(this.cTs.getForumId(), this.cTs);
                } else {
                    com.baidu.tieba.tbadkCore.ad.a(this.cTs.getLiveCardData().getGroupId(), this.cTs);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.cTs.getThreadId(), this.cTs);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.cTs.getForumId()) + "photolive", this.cTs);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.cTs.getThreadId()) + "updatephotolive", this.cTs);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dbe != null && this.dbe.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dbe, getPageContext().getPageActivity());
                return true;
            } else if (this.ddl.AO()) {
                this.ddl.zr();
                return true;
            } else {
                ayI();
                azB();
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
        getLayoutMode().k(this.boe);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.al.g(this.dbc, i);
        azv();
        com.baidu.tbadk.core.util.al.i(this.daY, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.al.i(this.ddB, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.al.i((View) azL(), i.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bSz)) {
            com.baidu.tbadk.core.util.al.i((View) azK(), i.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_e);
        azL().setTextColor(color);
        azK().setTextColor(color);
        a(azL(), color2);
        a(azK(), color2);
        ayQ();
        this.ddl.onChangeSkinType(i);
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
        this.ddI = this.cTs.getType() == 4 || 5 == this.cTs.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(i.g.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpb = this.mNavigationBar.setTitleText("");
        this.ddg = (TextView) findViewById(i.f.btn_image_problem);
        this.dbc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        this.dbc.setOnFocusChangeListener(this.daV);
        this.ddy = (ScrollView) findViewById(i.f.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ddb = (FeedBackTopListView) findViewById(i.f.feedback_top_list);
        this.ddc = findViewById(i.f.feedback_divider);
        this.boe = (RelativeLayout) findViewById(i.f.parent);
        this.dcZ = (LinearLayout) findViewById(i.f.tool_view);
        this.daY = findViewById(i.f.interval_view);
        ayP();
        if (this.ddI) {
            this.ddy.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            azw();
        }
        ayR();
        if (this.dcX || this.dcY) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abT) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(i.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(i.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dba = (LinearLayout) findViewById(i.f.post_content_container);
        this.dba.setDrawingCacheEnabled(false);
        this.dba.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.daV);
        this.mBack.setOnClickListener(new ah(this));
        this.ddg.setOnClickListener(new ai(this));
        i(azP());
        azD();
        azG();
        avO();
        switch (this.cTs.getType()) {
            case 0:
                if (this.dcX || this.dcY) {
                    this.bpb.setText(i.h.feedback);
                } else {
                    this.bpb.setText(i.h.post_new_thread);
                }
                this.daX.setVisibility(0);
                this.dbb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bpb.setText(i.h.send_reply);
                this.dbb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.daX.setVisibility(8);
                break;
            case 4:
                this.bpb.setText(i.h.publish_photo_live);
                this.dbb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bpb.setText(getPageContext().getResources().getString(i.h.update_photo_live_tip, Integer.valueOf(this.cTs.getFloorNum() + 1)));
                this.ddB.setVisibility(8);
                break;
        }
        azH();
        azN();
        azv();
        azE();
        ayO();
        if (this.cTs.getType() == 4 && this.dbg != null && this.ddd != null) {
            this.dbg.setVisibility(8);
            this.ddd.setVisibility(8);
        }
        ayQ();
        if (this.cTs.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.daX);
        }
        azC();
    }

    private void azC() {
    }

    private void azD() {
        this.dds = (RelativeLayout) findViewById(i.f.live_time_rel);
        this.ddt = (TextView) findViewById(i.f.live_tiem_show);
        this.ddu = findViewById(i.f.interval_view2);
        this.ddv = (LiveBroadcastCard) findViewById(i.f.live_anchor_card);
        this.dds.setOnClickListener(new ak(this));
        this.dds.setOnTouchListener(new al(this));
        if (this.cTs.getLiveCardData() != null) {
            this.dds.setVisibility(0);
            this.ddu.setVisibility(0);
            this.ddv.setVisibility(0);
            this.ddv.setClickable(false);
            this.ddt.setText(com.baidu.tbadk.core.util.aq.n(this.cTs.getLiveCardData().getStartTime() * 1000));
            this.ddv.setData(this.cTs.getLiveCardData());
            return;
        }
        this.dds.setVisibility(8);
        this.ddu.setVisibility(8);
        this.ddv.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cTs.getLiveCardData() != null) {
            Date date = new Date(this.cTs.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ddP = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.ddP.setTitle(i.h.no_disturb_start_time);
        this.ddP.setButton(-1, getPageContext().getString(i.h.alert_yes_button), this.ddP);
        this.ddP.setButton(-2, getPageContext().getString(i.h.alert_no_button), this.ddP);
        return this.ddP;
    }

    private void azE() {
        this.ddn = (RelativeLayout) findViewById(i.f.addition_container);
        this.ddo = (TextView) findViewById(i.f.addition_create_time);
        this.ddp = (TextView) findViewById(i.f.addition_last_time);
        this.ddq = (TextView) findViewById(i.f.addition_last_content);
        if (this.ddm != null) {
            this.ddn.setVisibility(0);
            this.ddo.setText(String.valueOf(getPageContext().getString(i.h.write_addition_create)) + com.baidu.tbadk.core.util.aq.m(this.ddm.getCreateTime() * 1000));
            if (this.ddm.getAlreadyCount() == 0) {
                this.ddp.setVisibility(8);
            } else {
                this.ddp.setText(String.valueOf(getPageContext().getString(i.h.write_addition_last)) + com.baidu.tbadk.core.util.aq.m(this.ddm.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ddm.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ddq.setText(lastAdditionContent);
            } else {
                this.ddq.setVisibility(8);
            }
            azK().setHint(String.format(getPageContext().getString(i.h.write_addition_hint), Integer.valueOf(this.ddm.getAlreadyCount()), Integer.valueOf(this.ddm.getTotalCount())));
            this.bpb.setText(i.h.write_addition_title);
            return;
        }
        this.ddn.setVisibility(8);
    }

    private void ayO() {
        this.dbg = findViewById(i.f.post_prefix_layout);
        this.dbd = (TextView) findViewById(i.f.post_prefix);
        this.ddd = findViewById(i.f.prefix_divider);
        this.dbf = (ImageView) findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.dbg.setVisibility(0);
            this.ddd.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.daF = 1;
            this.dbg.setOnClickListener(new an(this));
            this.dbf = (ImageView) findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dbf.setVisibility(0);
                this.dbd.setOnClickListener(new ao(this));
            }
            this.dbe = new cb(getPageContext().getPageActivity());
            this.dbe.a(this);
            this.dbe.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), i.d.ds510));
            this.dbe.setOutsideTouchable(true);
            this.dbe.setFocusable(true);
            this.dbe.setOnDismissListener(this);
            this.dbe.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.al.getColor(i.c.write_text);
            int color2 = com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c);
            com.baidu.tbadk.core.util.al.h((View) this.dbd, i.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.c(this.dbf, i.e.icon_title_down);
            this.dbd.setTextColor(color);
            this.dde.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(getActivity());
                this.dde.add(gVar);
                gVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    gVar.setPrefixTextColor(color2);
                } else {
                    gVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    gVar.setDividerStyle(false);
                }
                this.dbe.addView(gVar);
            }
            this.dbe.kU(0);
            this.dbd.setText(prefixs.get(1));
            ll(1);
            return;
        }
        this.dbg.setVisibility(8);
    }

    private void azF() {
        if (this.dcX && this.cTs != null) {
            this.ddb.setVisibility(0);
            this.ddc.setVisibility(0);
            this.dda = new o(this);
            this.dda.lK(this.cTs.getForumName());
            this.dda.setLoadDataCallBack(new ap(this));
        }
    }

    protected void azG() {
        this.dbc.setOnClickListener(new aq(this));
    }

    protected void azH() {
        this.ddh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ddh.ct(getPageContext().getString(i.h.is_save_draft)).aj(false).a(getPageContext().getString(i.h.save), new ar(this)).b(getPageContext().getString(i.h.not_save), new at(this));
        this.ddh.b(getPageContext());
    }

    protected void ayP() {
        this.daX = (EditText) findViewById(i.f.post_title);
        this.daX.setOnClickListener(this.ddM);
        this.daX.setOnFocusChangeListener(this.daV);
        if (this.cTs.getType() == 0) {
            if (this.cTs.getTitle() != null) {
                this.daX.setText(this.cTs.getTitle());
                this.daX.setSelection(this.cTs.getTitle().length());
            }
        } else if (this.cTs.getType() != 1) {
            this.cTs.getType();
        }
        this.daX.addTextChangedListener(new au(this));
    }

    private TextWatcher aiE() {
        aw awVar = new aw(this);
        if (this.ddI && this.ddJ) {
            if (this.ddG != null) {
                this.ddD.removeTextChangedListener(this.ddG);
            }
            this.ddG = awVar;
        } else if (this.ddI) {
            if (this.ddH != null) {
                this.ddz.removeTextChangedListener(this.ddH);
            }
            this.ddH = awVar;
        }
        return awVar;
    }

    private long e(EditText editText) {
        if (editText == this.ddz) {
            return 233L;
        }
        if (editText != this.ddD) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
                }
            } else if (d < 0) {
                if (d < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long d(EditText editText) {
        return com.baidu.tieba.write.d.a.f(editText.getText().toString().trim());
    }

    protected void ayR() {
        this.dbb = (EditText) findViewById(i.f.post_content);
        this.dbb.setDrawingCacheEnabled(false);
        this.dbb.setOnClickListener(this.ddM);
        if (this.cTs.getContent() != null && this.cTs.getContent().length() > 0) {
            SpannableString H = TbFaceManager.Cr().H(getPageContext().getPageActivity(), this.cTs.getContent());
            this.dbb.setText(H);
            this.dbb.setSelection(H.length());
        } else if (this.cTs.getType() == 2) {
            if (this.ddi) {
                if (this.ddj != null && this.ddj.length() > 0) {
                    this.dbb.setText(getPageContext().getPageActivity().getString(i.h.reply_sub_floor, new Object[]{this.ddj}));
                    this.dbb.setSelection(this.dbb.getText().length());
                }
            } else if (this.cTs.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(i.h.reply_x_floor), Integer.valueOf(this.cTs.getFloorNum()));
                this.dbb.setText(format);
                this.dbb.setSelection(format.length());
            }
        }
        this.dbb.setOnFocusChangeListener(this.daV);
        this.dbb.setOnTouchListener(new ax(this));
        this.dbb.addTextChangedListener(new ay(this));
        gK(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.ddI) {
            azK().setPadding(0, 0, 0, 0);
            azK().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.al.i((View) azK(), i.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bSz) && this.ddm == null) {
                com.baidu.adp.lib.f.c.gZ().a(this.bSz, 19, new az(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azI() {
        int i = 5000;
        if (this.ddm != null) {
            i = 1000;
        }
        return azK().getText() != null && azK().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azJ() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.ddl != null) {
                this.ddl.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.atJ() && this.ddr == 0) {
            showToast(i.h.baobao_over_limit);
        } else {
            String charSequence = this.bpb.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) azK().getText().getSpans(0, azK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ddk == null) {
                this.ddk = Toast.makeText(getPageContext().getPageActivity(), i.h.too_many_face, 0);
            }
            this.ddk.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType wA = fVar.wA();
        if (name != null) {
            com.baidu.adp.lib.f.c.gZ().a(name, 20, new ba(this, new SpannableStringBuilder(name), wA), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mZ = aVar.mZ();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
        int width = mZ.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        azK().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText azK() {
        return this.ddI ? this.ddz : this.dbb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText azL() {
        return this.ddI ? this.ddD : this.daX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azM() {
        azK().onKeyDown(67, this.ddf);
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.cTs != null) {
            str = this.cTs.getForumName();
        }
        if (getPageContext().getString(i.h.feedback_bar_name).equals(str)) {
            this.dcX = true;
        }
    }

    private void azN() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void azO() {
        try {
            if (this.ddh != null) {
                this.ddh.dismiss();
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

    private Boolean azP() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.atE = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayQ() {
        String str;
        String str2 = null;
        if (this.cTs != null) {
            String editable = azL().getText().toString();
            String trim = azK().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.cTs.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.daF == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.cTs.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.cTs.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cTs.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.cTs.setIsNoTitle(true);
                str = null;
            } else {
                this.cTs.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ddI) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.atu != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.cTs.getVideoInfo() != null) {
                str = "1";
            }
            if (this.cTs.getType() == 4) {
                if (g(this.ddz) && f(this.ddD)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.cTs.getType() != 5) {
                str2 = str;
            } else if (g(this.ddz)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dbc.setEnabled(false);
            } else {
                this.dbc.setEnabled(true);
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
        this.aty = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aty.b(this.atM);
        registerListener(this.ddL);
        this.ckj = new bb(this);
        this.cTs = new WriteData();
        if (bundle != null) {
            this.cTs.setType(bundle.getInt("type", 0));
            this.cTs.setForumId(bundle.getString("forum_id"));
            this.cTs.setForumName(bundle.getString("forum_name"));
            this.cTs.setThreadId(bundle.getString("thread_id"));
            this.cTs.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cTs.setFloorNum(bundle.getInt("floor_num", 0));
            this.dcX = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ddi = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ddj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.atw = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.ddm = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cTs.setIsAddition(this.ddm != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.ddr = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cTs.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.cTs.setType(intent.getIntExtra("type", 0));
            this.cTs.setForumId(intent.getStringExtra("forum_id"));
            this.cTs.setForumName(intent.getStringExtra("forum_name"));
            this.cTs.setThreadId(intent.getStringExtra("thread_id"));
            this.cTs.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cTs.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.dcX = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ddi = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ddj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.ddm = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cTs.setIsAddition(this.ddm != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.ddr = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cTs.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.cTs.getType() == 4 ? 6 : 10);
        this.cTs.setWriteImagesInfo(this.writeImagesInfo);
        this.cTs.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.cTs.getType() == 0) {
            if (this.cTs.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ad.c(this.cTs.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ad.a(this.cTs.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cTs.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.cTs.getThreadId(), this);
        } else if (this.cTs.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.cTs.getForumId()) + "photolive", this);
        } else if (this.cTs.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.cTs.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
        }
        this.bSz = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cTs != null && this.cTs.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cTs.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.dcY = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (this.cTs != null) {
                this.cTs.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(azL().getText().toString()) || ((this.dcX || this.dcY) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.cTs.setTitle(writeData.getTitle());
                    azL().setText(this.cTs.getTitle());
                    azL().setSelection(this.cTs.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.cTs.setVideoInfo(videoInfo);
                    this.ddl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.cTs.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.ddt.setText(com.baidu.tbadk.core.util.aq.n(this.cTs.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(azK().getText().toString()) || this.dcX || this.dcY) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.cTs.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Cr().a(getPageContext().getPageActivity(), this.cTs.getContent(), new bc(this));
                    azK().setText(a2);
                    azK().setSelection(a2.length());
                    if (this.ddI) {
                        b(this.ddF, this.ddz);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.cTs.setWriteImagesInfo(this.writeImagesInfo);
                    azV();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        BN();
                    }
                    gL(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.cTs.setIsBaobao(writeData.getIsBaobao());
                        this.cTs.setBaobaoContent(writeData.getBaobaoContent());
                        this.cTs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.cTs.getIsBaobao()) {
                        BP();
                        gM(false);
                    }
                }
                writeData.getType();
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    azQ();
                    ayQ();
                }
                this.ddl.zr();
                return;
            }
            return;
        }
        azQ();
    }

    private void azQ() {
        if ((!this.ddI || this.ddx != null) && this.ddw != null) {
            this.ddx.c(this.writeImagesInfo);
            azU();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cTs.getType());
        bundle.putString("forum_id", this.cTs.getForumId());
        bundle.putString("forum_name", this.cTs.getForumName());
        bundle.putString("thread_id", this.cTs.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cTs.getFloor());
        bundle.putInt("floor_num", this.cTs.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ddi);
        if (this.dcX) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.atw);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.ddm);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.ddr);
        if (this.cTs.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cTs.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cTs.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cTs.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cTs.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cTs.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cTs.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cTs.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cTs.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cTs.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = azK().getEditableText().toString();
        if (editable != null) {
            azK().setText(TbFaceManager.Cr().H(getPageContext().getPageActivity(), editable));
            azK().setSelection(azK().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azR() {
        ayI();
        if (this.cTs.getLiveCardData() != null) {
            if (!this.cTs.getLiveCardData().isModifyTime()) {
                this.cTs.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.ddt.setText(com.baidu.tbadk.core.util.aq.n(this.cTs.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cTs.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cTs.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cTs.getLiveCardData().getStartTime() / 60) {
                showToast(i.h.live_start_time_error);
                return;
            }
        }
        String editable = azL().getText().toString();
        this.cTs.setContent(azK().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.daF != 0 && this.cTs.getType() != 4) {
            this.cTs.setTitle(String.valueOf(this.dbd.getText().toString()) + editable);
        } else {
            this.cTs.setTitle(editable);
        }
        if (this.dcX || this.dcY) {
            String string = getResources().getString(i.h.android_feedback);
            if (TextUtils.isEmpty(this.cTs.getTitle()) || !this.cTs.getTitle().startsWith(string)) {
                this.cTs.setTitle(string + this.cTs.getTitle());
            }
            String str = String.valueOf(getResources().getString(i.h.app_name)) + getResources().getString(i.h.tieba_client);
            if (TextUtils.isEmpty(this.cTs.getContent()) || !this.cTs.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iL()) {
                    sb.append(com.baidu.adp.lib.util.i.iT());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.cTs.getContent());
                this.cTs.setContent(sb.toString());
            }
        }
        this.cTs.setWriteImagesInfo(this.writeImagesInfo);
        this.cTs.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cTs.setHasLocationData(this.atx == null ? false : this.atx.auX());
        this.aty.gm(this.writeImagesInfo.size() > 0);
        this.aty.c(this.cTs);
        this.cTs.setVcode(null);
        if (this.atu != null) {
            if (this.atu.getId() != null) {
                this.aty.avr().setVoice(this.atu.getId());
                this.aty.avr().setVoiceDuringTime(this.atu.duration);
            } else {
                this.aty.avr().setVoice(null);
                this.aty.avr().setVoiceDuringTime(-1);
            }
        } else {
            this.aty.avr().setVoice(null);
            this.aty.avr().setVoiceDuringTime(-1);
        }
        if (!this.aty.avu()) {
            showToast(i.h.write_img_limit);
        } else if (this.aty.avs()) {
            showLoadingDialog(getPageContext().getString(i.h.sending), this.ckj);
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
            if (this.ddm != null) {
                i2 = this.ddm.getTotalCount();
                i = this.ddm.getAlreadyCount() + 1;
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
                if (this.ddl != null && !this.ddl.AO()) {
                    azK().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> U = com.baidu.tieba.tbadkCore.util.j.U(intent);
                if (U != null && U.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < U.size()) {
                            sb.append("@");
                            sb.append(U.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            azK().getText().insert(azK().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.cTs.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.cTs.getForumId(), (WriteData) null);
                } else if (this.cTs.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.cTs.getThreadId(), (WriteData) null);
                } else if (this.cTs.getType() == 4) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.cTs.getForumId()) + "photolive", (WriteData) null);
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
                                ajI();
                            } else {
                                ab(intent);
                            }
                        } else if (intExtra == 1) {
                            T(intent);
                        } else {
                            Z(intent);
                        }
                    }
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseIntent(intent);
                    com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c10068");
                    aoVar.r("duration", videoInfo.getDuration());
                    TiebaStatic.log(aoVar);
                    this.cTs.setVideoInfo(videoInfo);
                    this.ddl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.ddl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    ayQ();
                } else if (i == 12012) {
                    if (!this.ddI) {
                        I(intent);
                        ayQ();
                        return;
                    }
                    aa(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo2 = new VideoInfo();
                    videoInfo2.parseIntent(intent);
                    com.baidu.tbadk.core.util.ao aoVar2 = new com.baidu.tbadk.core.util.ao("c10068");
                    aoVar2.r("duration", videoInfo2.getDuration());
                    TiebaStatic.log(aoVar2);
                    this.cTs.setVideoInfo(videoInfo2);
                    this.ddl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.ddl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo2));
                    ayQ();
                } else if (i == 12013) {
                    J(intent);
                    ayQ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.ddl != null && !this.ddl.AO()) {
                this.dbb.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    BG();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    azT();
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
                    this.atw = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ak.a(getPageContext(), this.atw);
                    return;
                case 12012:
                    azT();
                    return;
            }
        }
    }

    private void azS() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void azT() {
        if (this.ddI) {
            this.ddx.c(this.writeImagesInfo);
            azU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azU() {
        this.ddx.notifyDataSetChanged();
        this.ddw.invalidate();
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
        ayQ();
    }

    private void Z(Intent intent) {
        if (this.ddI) {
            aa(intent);
            azT();
        } else {
            ac(intent);
        }
        ayQ();
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            azT();
            gL(true);
        }
    }

    private void ab(Intent intent) {
        int size;
        H(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void ajI() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.csz.parseJson(stringExtra);
            this.csz.updateQuality();
            if (this.csz.getChosedFiles() != null && this.csz.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.csz.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.csz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, azL());
        HidenSoftKeyPad(this.mInputManager, azK());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ac(Intent intent) {
        b(intent, true);
    }

    private void H(Intent intent) {
        this.atw = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.atw;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cB = com.baidu.tbadk.core.util.c.cB(str);
                if (cB != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.atw, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            azV();
            BN();
        }
        gL(true);
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
                azV();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    BN();
                }
            }
            gL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azV() {
        if (this.ddl.dT(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void J(Intent intent) {
        if (this.cTs != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cTs.setIsBaobao(true);
            this.cTs.setBaobaoContent(stringExtra2);
            BP();
            gM(true);
        }
    }

    private void BG() {
        new be(this).execute(new Void[0]);
    }

    private void gL(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void gM(boolean z) {
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
            antiData.setBlock_forum_name(this.cTs.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.ddm == null) {
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            o(z, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.atG = i;
        if (this.ddl != null) {
            this.ddl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (z) {
                this.ddl.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void BN() {
        if (!this.ddI && this.ddl != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.ddl.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.ddl.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ddl.b(new com.baidu.tbadk.editortools.a(12, 15, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ddl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void BP() {
        if (this.ddl != null) {
            this.ddl.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.ddl.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.ddl.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(boolean z) {
        if (this.ddl != null) {
            this.ddl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            antiData.setBlock_forum_name(this.cTs.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.ddm == null) {
            com.baidu.tieba.tbadkCore.writeModel.c.Q(getPageContext().getPageActivity(), str);
        } else {
            o(z, str);
        }
    }

    private void ll(int i) {
        if (i < this.dde.size()) {
            for (int i2 = 0; i2 < this.dde.size(); i2++) {
                this.dde.get(i2).gI(false);
            }
            this.dde.get(i).gI(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cb.a
    public void lb(int i) {
        this.daF = i;
        this.dbe.kU(i);
        ll(i);
        this.dbd.setText(this.mPrefixData.getPrefixs().get(i));
        ayQ();
        com.baidu.adp.lib.g.j.a(this.dbe, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.dbg.setSelected(false);
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
