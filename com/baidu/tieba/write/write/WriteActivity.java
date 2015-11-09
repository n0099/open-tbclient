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
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.c.a;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, VoiceManager.c, ad.a, cf.a {
    public static String drU = "from_writeActivity_livePhoto";
    private VoiceData.VoiceModel aqr;
    private String aqt;
    private com.baidu.tieba.tbadkCore.location.d aqu;
    private com.baidu.tieba.tbadkCore.writeModel.a aqv;
    List<dm> bjL;
    private String bjV;
    private int dnP;
    private TextView don;
    private cf doo;
    private ImageView dop;
    private View doq;
    private View drA;
    private LiveBroadcastCard drB;
    dm drC;
    private int drD;
    private int drE;
    private PostCategoryView drF;
    private com.baidu.tieba.view.a drZ;
    private LinearLayout drg;
    private View drj;
    private View drk;
    private Toast drq;
    private com.baidu.tbadk.editortools.j drr;
    private AdditionData drs;
    private RelativeLayout drt;
    private TextView dru;
    private TextView drv;
    private TextView drw;
    private RelativeLayout dry;
    private TextView drz;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData ddI = null;
    private boolean dre = false;
    private boolean drf = false;
    private InputMethodManager mInputManager = null;
    private EditText doh = null;
    private View doi = null;
    private LinearLayout dok = null;
    private EditText dol = null;
    private o drh = null;
    private FeedBackTopListView dri = null;
    private ArrayList<com.baidu.tieba.write.view.j> dpO = new ArrayList<>();
    private String bWX = null;
    private final KeyEvent drl = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView drm = null;
    private TextView dom = null;
    private TextView bsQ = null;
    private DialogInterface.OnCancelListener crt = null;
    private com.baidu.tbadk.core.dialog.a drn = null;
    private final Handler mHandler = new Handler();
    private boolean dro = false;
    private String drp = null;
    private RelativeLayout brS = null;
    private String aqB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int aqD = 0;
    private int drx = 0;
    private WriteImagesInfo cAh = new WriteImagesInfo();
    private View mRootView = null;
    private GridView drG = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a drH = null;
    private ScrollView drI = null;
    private EditText drJ = null;
    private View drK = null;
    private View drL = null;
    private View drM = null;
    private EditText drN = null;
    private TextView drO = null;
    private TextView drP = null;
    private TextWatcher drQ = null;
    private TextWatcher drR = null;
    private boolean drS = false;
    private boolean drT = false;
    private final HttpMessageListener drV = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d aqM = new aj(this);
    private final d.a aqK = new av(this);
    private final CustomMessageListener ddf = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener drW = new bi(this);
    private boolean drX = true;
    private final View.OnFocusChangeListener dof = new bj(this);
    private final CustomMessageListener drY = new bk(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0075a cmS = new bl(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Bc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(i.h.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bd();
        } else if (this.aqu.ayw()) {
            Bb();
        } else {
            this.aqu.gB(false);
            a(1, true, (String) null);
            this.aqu.ayu();
        }
    }

    private void Bd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new bm(this)).b(i.h.cancel, new z(this)).b(getPageContext());
        aVar.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDU() {
        int selectionEnd = aEm().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aEm().getText().getSpans(0, aEm().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aEm().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aEm().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDV() {
        if (this.drr != null) {
            this.drr.setBarLauncherEnabled(!this.drX);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.drZ != null && this.ddI != null && this.ddI.getLiveCardData() != null) {
            new Handler().postDelayed(new aa(this, new Date(this.ddI.getLiveCardData().getStartTime() * 1000)), 100L);
        }
        if (this.drS) {
            this.doh.setVisibility(8);
            if (this.ddI.getType() == 5) {
                this.drM.setVisibility(8);
            } else {
                this.drM.setVisibility(0);
            }
            b(this.drP, this.drJ);
            b(this.drO, this.drN);
            aCV();
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
        aEh();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.drY.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.drY);
        this.aqu = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aqu.a(this.aqK);
        registerListener(this.ddf);
        initEditor();
        if (this.drS) {
            this.drH.setEditorTools(this.drr);
        } else {
            this.dol.requestFocus();
        }
    }

    private void initEditor() {
        this.drr = new com.baidu.tbadk.editortools.j(getActivity());
        this.drr.setBarMaxLauCount(4);
        this.drr.setMoreButtonAtEnd(true);
        this.drr.setBarLauncherType(1);
        this.drr.setBarLinePostion(2);
        this.drr.setMoreLauncherIcon(i.e.write_more);
        this.drr.setBackgroundColorId(i.c.cp_bg_line_d);
        switch (this.ddI.getType()) {
            case 4:
            case 5:
                aDY();
                break;
            default:
                aDZ();
                break;
        }
        this.drr.AA();
        if (this.drg != null) {
            this.drg.addView(this.drr);
        }
        aEa();
        this.drr.ox();
        com.baidu.tbadk.editortools.p dS = this.drr.dS(6);
        if (dS != null && !TextUtils.isEmpty(this.aqB)) {
            ((View) dS).setOnClickListener(new ab(this));
        }
        this.drr.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("xiaoying_has_click", false)) {
            this.drr.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aDW() {
        this.drK = this.mRootView.findViewById(i.f.photo_live_scroll);
        this.drM = this.drK.findViewById(i.f.live_post_title_container);
        this.drJ = (EditText) this.drK.findViewById(i.f.live_post_content);
        this.drG = (GridView) this.drK.findViewById(i.f.photoLiveGridView);
        this.drN = (EditText) this.drK.findViewById(i.f.live_post_title);
        this.drO = (TextView) this.drK.findViewById(i.f.titleOverPlusNumber);
        this.drP = (TextView) this.drK.findViewById(i.f.contentOverPlusNumber);
        this.drL = this.drK.findViewById(i.f.live_interval_view);
        this.drO.setText(String.valueOf(20));
        this.drP.setText(String.valueOf(233));
        this.drK.setVisibility(0);
        this.drO.setVisibility(0);
        this.drP.setVisibility(0);
        this.drN.setHint(i.h.tips_title_limit_new);
        this.drN.setOnFocusChangeListener(new ac(this));
        if (this.ddI.getType() == 4) {
            this.drJ.setHint(i.h.live_write_input_content_new);
        } else if (this.ddI.getType() == 5) {
            this.drJ.setHint(i.h.live_write_input_content_update);
        }
        this.drJ.setOnFocusChangeListener(new ad(this));
        this.drJ.requestFocus();
        this.drJ.addTextChangedListener(alk());
        this.drN.requestFocus();
        this.drN.addTextChangedListener(alk());
        this.drN.setOnClickListener(this.drW);
        this.drJ.setOnClickListener(this.drW);
        this.drH = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.drG);
        this.drH.ml(6);
        this.drG.setAdapter((ListAdapter) this.drH);
        View findViewById = this.drK.findViewById(i.f.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        aDX();
    }

    private void aDX() {
        if (this.ddI.getType() == 0) {
            if (this.ddI.getTitle() != null) {
                this.drN.setText(this.ddI.getTitle());
                this.drN.setSelection(this.ddI.getTitle().length());
            }
        } else if (this.ddI.getType() != 1) {
            this.ddI.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.drS) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aEt();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Bo();
            return;
        }
        if (this.drr.AC()) {
            this.drr.zc();
        }
        String str = null;
        if (this.ddI != null) {
            str = this.ddI.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.drS) {
            albumActivityConfig.getIntent().putExtra("from", drU);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aDY() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.drr.q(arrayList);
        com.baidu.tbadk.editortools.w dU = this.drr.dU(5);
        if (dU != null) {
            dU.launcherPriority = 2;
            dU.launcherIcon = i.e.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.launcherIcon = i.e.write_at;
        this.drr.b(aVar);
        this.drr.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aDZ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.w wVar;
        com.baidu.tbadk.editortools.w wVar2;
        com.baidu.tbadk.editortools.w wVar3;
        com.baidu.tbadk.editortools.w wVar4;
        com.baidu.tbadk.editortools.w wVar5;
        com.baidu.tbadk.editortools.w wVar6;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        iVar.launcherIcon = i.e.write_picture;
        this.drr.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        if (XiaoyingUtil.showXiaoyingTool() && this.ddI != null && !this.ddI.isAddition()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.w.class);
            if (runTask2 != null && (wVar6 = (com.baidu.tbadk.editortools.w) runTask2.getData()) != null) {
                wVar6.launcherPriority = 3;
                wVar6.launcherIcon = i.e.write_video;
                this.drr.b(wVar6);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.w.class);
            if (runTask3 != null && (wVar5 = (com.baidu.tbadk.editortools.w) runTask3.getData()) != null) {
                this.drr.b(wVar5);
            }
        }
        this.drr.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.w.class);
        if (runTask4 != null && (wVar4 = (com.baidu.tbadk.editortools.w) runTask4.getData()) != null) {
            wVar4.launcherPriority = 4;
            wVar4.launcherIcon = i.e.write_privilege;
            this.drr.b(wVar4);
        }
        this.drr.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 5));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.w.class);
        if (runTask5 != null && (wVar3 = (com.baidu.tbadk.editortools.w) runTask5.getData()) != null) {
            wVar3.toolNeedAction = true;
            wVar3.launcherPriority = 8;
            wVar3.launcherIcon = 0;
            this.drr.b(wVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.w.class);
        if (runTask6 != null && (wVar2 = (com.baidu.tbadk.editortools.w) runTask6.getData()) != null) {
            wVar2.toolNeedAction = true;
            wVar2.launcherPriority = 9;
            wVar2.launcherIcon = 0;
            this.drr.b(wVar2);
        }
        Boolean aEr = aEr();
        if (!this.dre && aEr != null && aEr.booleanValue() && com.baidu.tieba.tbadkCore.voice.b.ayS() && com.baidu.tieba.tbadkCore.u.a(this.ddI.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.w.class)) != null && (wVar = (com.baidu.tbadk.editortools.w) runTask.getData()) != null) {
            wVar.launcherPriority = 6;
            this.drr.b(wVar);
        }
        if (this.ddI != null && this.ddI.getType() == 0 && !this.dre && !this.drf) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.drs == null) {
            this.drr.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.drr.q(arrayList);
        com.baidu.tbadk.editortools.w dU = this.drr.dU(5);
        if (dU != null) {
            dU.launcherPriority = 2;
            dU.launcherIcon = i.e.write_face;
        }
        com.baidu.tbadk.editortools.w dU2 = this.drr.dU(13);
        if (dU2 != null) {
            dU2.launcherPriority = 7;
        }
    }

    private void aEa() {
        af afVar = new af(this);
        this.drr.a(16, afVar);
        this.drr.a(21, afVar);
        this.drr.a(14, afVar);
        this.drr.a(24, afVar);
        this.drr.a(3, afVar);
        this.drr.a(10, afVar);
        this.drr.a(11, afVar);
        this.drr.a(12, afVar);
        this.drr.a(13, afVar);
        this.drr.a(22, afVar);
        this.drr.a(23, afVar);
        this.drr.a(15, afVar);
        this.drr.a(18, afVar);
        this.drr.a(25, afVar);
        this.drr.a(27, afVar);
        this.drr.a(29, afVar);
    }

    public void axZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be() {
        if (this.aqu.ayy()) {
            if (this.aqu.ayw()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.ayr().getLocationData().ayn());
                return;
            }
            a(1, true, (String) null);
            this.aqu.ayu();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCN() {
        if (this.aqv != null) {
            this.aqv.cancelLoadData();
        }
        if (this.drh != null) {
            this.drh.cancelLoadData();
        }
        if (this.aqu != null) {
            this.aqu.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aCN();
        aEq();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEb() {
        if (this.ddI != null && this.ddI.getType() == 2 && this.dro) {
            finish();
        } else if (this.ddI == null) {
            finish();
        } else {
            this.ddI.setTitle(aEn().getText().toString());
            this.ddI.setContent(aEm().getText().toString());
            int type = this.ddI.getType();
            if (type == 0) {
                if (this.ddI.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ad.b(this.ddI.getForumId(), this.ddI);
                } else {
                    com.baidu.tieba.tbadkCore.ad.a(this.ddI.getLiveCardData().getGroupId(), this.ddI);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ad.c(this.ddI.getThreadId(), this.ddI);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.ddI.getForumId()) + "photolive", this.ddI);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.ddI.getThreadId()) + "updatephotolive", this.ddI);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.doo != null && this.doo.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.doo, getPageContext().getPageActivity());
                return true;
            } else if (this.drr.AC()) {
                this.drr.zc();
                return true;
            } else {
                aCN();
                aEb();
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
        getLayoutMode().k(this.brS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.an.i((View) this.dom, i.e.s_navbar_button_bg);
        aDV();
        com.baidu.tbadk.core.util.an.j(this.drK, i.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.an.j(this.doi, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.an.j(this.drL, i.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.an.j((View) aEn(), i.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bWX)) {
            com.baidu.tbadk.core.util.an.j((View) aEm(), i.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_e);
        aEn().setTextColor(color);
        aEm().setTextColor(color);
        a(aEn(), color2);
        a(aEm(), color2);
        aCV();
        this.drr.onChangeSkinType(i);
        if (this.drF != null) {
            this.drF.vB();
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
        this.drS = this.ddI.getType() == 4 || 5 == this.ddI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(i.g.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsQ = this.mNavigationBar.setTitleText("");
        this.drm = (TextView) findViewById(i.f.btn_image_problem);
        this.dom = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dom.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dom.setLayoutParams(layoutParams);
        this.dom.setOnFocusChangeListener(this.dof);
        this.drI = (ScrollView) findViewById(i.f.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dri = (FeedBackTopListView) findViewById(i.f.feedback_top_list);
        this.drj = findViewById(i.f.feedback_divider);
        this.brS = (RelativeLayout) findViewById(i.f.parent);
        this.drg = (LinearLayout) findViewById(i.f.tool_view);
        this.doi = findViewById(i.f.interval_view);
        aCU();
        if (this.drS) {
            this.drI.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aDW();
        }
        aCW();
        if (this.dre || this.drf) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aca) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(i.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(i.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dok = (LinearLayout) findViewById(i.f.post_content_container);
        this.dok.setDrawingCacheEnabled(false);
        this.dok.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.dof);
        this.mBack.setOnClickListener(new ah(this));
        this.drm.setOnClickListener(new ai(this));
        aEd();
        i(aEr());
        aEf();
        aEi();
        axZ();
        switch (this.ddI.getType()) {
            case 0:
                if (this.dre || this.drf) {
                    this.bsQ.setText(i.h.feedback);
                } else {
                    this.bsQ.setText(i.h.post_new_thread);
                }
                this.doh.setVisibility(0);
                this.dol.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bsQ.setText(i.h.send_reply);
                this.dol.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.doh.setVisibility(8);
                break;
            case 4:
                this.bsQ.setText(i.h.publish_photo_live);
                this.dol.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bsQ.setText(getPageContext().getResources().getString(i.h.update_photo_live_tip, Integer.valueOf(this.ddI.getFloorNum() + 1)));
                this.drL.setVisibility(8);
                break;
        }
        aEj();
        aEp();
        aDV();
        aEg();
        aCT();
        if (this.ddI.getType() == 4 && this.doq != null && this.drk != null) {
            this.doq.setVisibility(8);
            this.drk.setVisibility(8);
        }
        aCV();
        if (this.ddI.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.doh);
        }
        aEe();
    }

    private void aEc() {
        this.bjL = null;
        this.drD = -1;
        this.drE = -1;
        Cdo fN = dn.MH().fN(1);
        if (fN != null) {
            this.bjL = fN.aYK;
            this.drD = getIntent().getIntExtra("category_id", -1);
            if (this.bjL != null && !this.bjL.isEmpty() && this.drD >= 0) {
                this.drC = new dm();
                this.drC.aYG = 0;
                this.drC.name = getPageContext().getResources().getString(i.h.category_auto);
                this.drE = this.drC.aYG;
                this.bjV = this.drC.name;
                for (dm dmVar : this.bjL) {
                    if (dmVar.aYG == this.drD) {
                        this.drE = dmVar.aYG;
                        this.bjV = dmVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void aEd() {
        if (this.bjL != null && !this.bjL.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(i.f.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(i.f.interval_view_cate).setVisibility(0);
            this.drF = (PostCategoryView) linearLayout.findViewById(i.f.category_selected);
            this.drF.setText(this.bjV);
            this.drF.b(this.bjL, this.drC, this.drE);
            this.drF.setCategoryContainerClickCallback(new ak(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void aEe() {
    }

    private void aEf() {
        this.dry = (RelativeLayout) findViewById(i.f.live_time_rel);
        this.drz = (TextView) findViewById(i.f.live_tiem_show);
        this.drA = findViewById(i.f.interval_view2);
        this.drB = (LiveBroadcastCard) findViewById(i.f.live_anchor_card);
        this.dry.setOnClickListener(new am(this));
        this.dry.setOnTouchListener(new an(this));
        if (this.ddI.getLiveCardData() != null) {
            this.dry.setVisibility(0);
            this.drA.setVisibility(0);
            this.drB.setVisibility(0);
            this.drB.setClickable(false);
            this.drz.setText(com.baidu.tbadk.core.util.as.n(this.ddI.getLiveCardData().getStartTime() * 1000));
            this.drB.setData(this.ddI.getLiveCardData());
            return;
        }
        this.dry.setVisibility(8);
        this.drA.setVisibility(8);
        this.drB.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.ddI.getLiveCardData() != null) {
            Date date = new Date(this.ddI.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.drZ = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ao(this), new Date().getHours(), new Date().getMinutes(), false);
        this.drZ.setTitle(i.h.no_disturb_start_time);
        this.drZ.setButton(-1, getPageContext().getString(i.h.alert_yes_button), this.drZ);
        this.drZ.setButton(-2, getPageContext().getString(i.h.alert_no_button), this.drZ);
        return this.drZ;
    }

    private void aEg() {
        this.drt = (RelativeLayout) findViewById(i.f.addition_container);
        this.dru = (TextView) findViewById(i.f.addition_create_time);
        this.drv = (TextView) findViewById(i.f.addition_last_time);
        this.drw = (TextView) findViewById(i.f.addition_last_content);
        if (this.drs != null) {
            this.drt.setVisibility(0);
            this.dru.setText(String.valueOf(getPageContext().getString(i.h.write_addition_create)) + com.baidu.tbadk.core.util.as.m(this.drs.getCreateTime() * 1000));
            if (this.drs.getAlreadyCount() == 0) {
                this.drv.setVisibility(8);
            } else {
                this.drv.setText(String.valueOf(getPageContext().getString(i.h.write_addition_last)) + com.baidu.tbadk.core.util.as.m(this.drs.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.drs.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.drw.setText(lastAdditionContent);
            } else {
                this.drw.setVisibility(8);
            }
            aEm().setHint(String.format(getPageContext().getString(i.h.write_addition_hint), Integer.valueOf(this.drs.getAlreadyCount()), Integer.valueOf(this.drs.getTotalCount())));
            this.bsQ.setText(i.h.write_addition_title);
            return;
        }
        this.drt.setVisibility(8);
    }

    private void aCT() {
        this.doq = findViewById(i.f.post_prefix_layout);
        this.don = (TextView) findViewById(i.f.post_prefix);
        this.drk = findViewById(i.f.prefix_divider);
        this.dop = (ImageView) findViewById(i.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.doq.setVisibility(0);
            this.drk.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dnP = 1;
            this.doq.setOnClickListener(new ap(this));
            this.dop = (ImageView) findViewById(i.f.prefix_icon);
            if (size > 1) {
                this.dop.setVisibility(0);
                this.don.setOnClickListener(new aq(this));
            }
            this.doo = new cf(getPageContext().getPageActivity());
            this.doo.a(this);
            this.doo.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), i.d.ds510));
            this.doo.setOutsideTouchable(true);
            this.doo.setFocusable(true);
            this.doo.setOnDismissListener(this);
            this.doo.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.an.getColor(i.c.write_text);
            int color2 = com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.i((View) this.don, i.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.an.c(this.dop, i.e.icon_title_down);
            this.don.setTextColor(color);
            this.dpO.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.dpO.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.doo.addView(jVar);
            }
            this.doo.lZ(0);
            this.don.setText(prefixs.get(1));
            mu(1);
            return;
        }
        this.doq.setVisibility(8);
    }

    private void aEh() {
        if (this.dre && this.ddI != null) {
            this.dri.setVisibility(0);
            this.drj.setVisibility(0);
            this.drh = new o(this);
            this.drh.mz(this.ddI.getForumName());
            this.drh.setLoadDataCallBack(new ar(this));
        }
    }

    protected void aEi() {
        this.dom.setOnClickListener(new as(this));
    }

    protected void aEj() {
        this.drn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.drn.cu(getPageContext().getString(i.h.is_save_draft)).aj(false).a(getPageContext().getString(i.h.save), new at(this)).b(getPageContext().getString(i.h.not_save), new aw(this));
        this.drn.b(getPageContext());
    }

    protected void aCU() {
        this.doh = (EditText) findViewById(i.f.post_title);
        this.doh.setOnClickListener(this.drW);
        this.doh.setOnFocusChangeListener(this.dof);
        if (this.ddI.getType() == 0) {
            if (this.ddI.getTitle() != null) {
                this.doh.setText(this.ddI.getTitle());
                this.doh.setSelection(this.ddI.getTitle().length());
            }
        } else if (this.ddI.getType() != 1) {
            this.ddI.getType();
        }
        this.doh.addTextChangedListener(new ax(this));
    }

    private TextWatcher alk() {
        ay ayVar = new ay(this);
        if (this.drS && this.drT) {
            if (this.drQ != null) {
                this.drN.removeTextChangedListener(this.drQ);
            }
            this.drQ = ayVar;
        } else if (this.drS) {
            if (this.drR != null) {
                this.drJ.removeTextChangedListener(this.drR);
            }
            this.drR = ayVar;
        }
        return ayVar;
    }

    private long e(EditText editText) {
        if (editText == this.drJ) {
            return 233L;
        }
        if (editText != this.drN) {
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

    protected void aCW() {
        this.dol = (EditText) findViewById(i.f.post_content);
        this.dol.setDrawingCacheEnabled(false);
        this.dol.setOnClickListener(this.drW);
        if (this.ddI.getContent() != null && this.ddI.getContent().length() > 0) {
            SpannableString G = TbFaceManager.BU().G(getPageContext().getPageActivity(), this.ddI.getContent());
            this.dol.setText(G);
            this.dol.setSelection(G.length());
        } else if (this.ddI.getType() == 2) {
            if (this.dro) {
                if (this.drp != null && this.drp.length() > 0) {
                    this.dol.setText(getPageContext().getPageActivity().getString(i.h.reply_sub_floor, new Object[]{this.drp}));
                    this.dol.setSelection(this.dol.getText().length());
                }
            } else if (this.ddI.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(i.h.reply_x_floor), Integer.valueOf(this.ddI.getFloorNum()));
                this.dol.setText(format);
                this.dol.setSelection(format.length());
            }
        }
        this.dol.setOnFocusChangeListener(this.dof);
        this.dol.setOnTouchListener(new az(this));
        this.dol.addTextChangedListener(new ba(this));
        he(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.drS) {
            aEm().setPadding(0, 0, 0, 0);
            aEm().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.an.j((View) aEm(), i.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bWX) && this.drs == null) {
                com.baidu.adp.lib.f.c.hb().a(this.bWX, 19, new bb(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEk() {
        int i = 5000;
        if (this.drs != null) {
            i = 1000;
        }
        return aEm().getText() != null && aEm().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEl() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.drr != null) {
                this.drr.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.awL() && this.drx == 0) {
            showToast(i.h.baobao_over_limit);
        } else {
            String charSequence = this.bsQ.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) aEm().getText().getSpans(0, aEm().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.drq == null) {
                this.drq = Toast.makeText(getPageContext().getPageActivity(), i.h.too_many_face, 0);
            }
            this.drq.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType wm = fVar.wm();
        if (name != null) {
            com.baidu.adp.lib.f.c.hb().a(name, 20, new bc(this, new SpannableStringBuilder(name), wm), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap nb = aVar.nb();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
        int width = nb.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        aEm().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aEm() {
        return this.drS ? this.drJ : this.dol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aEn() {
        return this.drS ? this.drN : this.doh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEo() {
        aEm().onKeyDown(67, this.drl);
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.ddI != null) {
            str = this.ddI.getForumName();
        }
        if (getPageContext().getString(i.h.feedback_bar_name).equals(str)) {
            this.dre = true;
        }
    }

    private void aEp() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aEq() {
        try {
            if (this.drn != null) {
                this.drn.dismiss();
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

    private Boolean aEr() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aqB = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCV() {
        String str;
        String str2 = null;
        if (this.ddI != null) {
            String editable = aEn().getText().toString();
            String trim = aEm().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.ddI.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.dnP == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.ddI.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.ddI.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.ddI.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.ddI.setIsNoTitle(true);
                str = null;
            } else {
                this.ddI.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.drS) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.aqr != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.ddI.getVideoInfo() != null) {
                str = "1";
            }
            if (this.ddI.getType() == 4) {
                if (g(this.drJ) && f(this.drN)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.ddI.getType() != 5) {
                str2 = str;
            } else if (g(this.drJ)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dom.setEnabled(false);
            } else {
                this.dom.setEnabled(true);
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
        this.aqv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aqv.b(this.aqM);
        registerListener(this.drV);
        this.crt = new bd(this);
        this.ddI = new WriteData();
        if (bundle != null) {
            this.ddI.setType(bundle.getInt("type", 0));
            this.ddI.setForumId(bundle.getString("forum_id"));
            this.ddI.setForumName(bundle.getString("forum_name"));
            this.ddI.setThreadId(bundle.getString("thread_id"));
            this.ddI.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.ddI.setFloorNum(bundle.getInt("floor_num", 0));
            this.dre = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.dro = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.drp = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aqt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.drs = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.ddI.setIsAddition(this.drs != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.drx = bundle.getInt("mem_type", 0);
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
                this.ddI.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.ddI.setType(intent.getIntExtra("type", 0));
            this.ddI.setForumId(intent.getStringExtra("forum_id"));
            this.ddI.setForumName(intent.getStringExtra("forum_name"));
            this.ddI.setThreadId(intent.getStringExtra("thread_id"));
            this.ddI.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.ddI.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.dre = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.dro = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.drp = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.drs = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.ddI.setIsAddition(this.drs != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.drx = intent.getIntExtra("mem_type", 0);
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
                this.ddI.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.ddI.getType() == 4 ? 6 : 10);
        this.ddI.setWriteImagesInfo(this.writeImagesInfo);
        this.ddI.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.ddI.getType() == 0) {
            if (this.ddI.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ad.c(this.ddI.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ad.a(this.ddI.getLiveCardData().getGroupId(), this);
            }
        } else if (this.ddI.getType() == 1) {
            com.baidu.tieba.tbadkCore.ad.a(this.ddI.getThreadId(), this);
        } else if (this.ddI.getType() == 4) {
            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(this.ddI.getForumId()) + "photolive", this);
        } else if (this.ddI.getType() == 5) {
            com.baidu.tieba.tbadkCore.ad.a(String.valueOf(this.ddI.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
        }
        this.bWX = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.ddI != null && this.ddI.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.ddI.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.drf = true;
        }
        aEc();
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.ddI != null) {
                this.ddI.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aEn().getText().toString()) || ((this.dre || this.drf) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.ddI.setTitle(writeData.getTitle());
                    aEn().setText(this.ddI.getTitle());
                    aEn().setSelection(this.ddI.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.ddI.setVideoInfo(videoInfo);
                    this.drr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.ddI.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.drz.setText(com.baidu.tbadk.core.util.as.n(this.ddI.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aEm().getText().toString()) || this.dre || this.drf) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.ddI.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.BU().a(getPageContext().getPageActivity(), this.ddI.getContent(), new be(this));
                    aEm().setText(a2);
                    aEm().setSelection(a2.length());
                    if (this.drS) {
                        b(this.drP, this.drJ);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.ddI.setWriteImagesInfo(this.writeImagesInfo);
                    aEw();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Bo();
                    }
                    hf(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.ddI.setIsBaobao(writeData.getIsBaobao());
                        this.ddI.setBaobaoContent(writeData.getBaobaoContent());
                        this.ddI.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.ddI.getIsBaobao()) {
                        Bq();
                        hg(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aEs();
                    aCV();
                }
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.bjL != null) {
                    this.drE = this.drC.aYG;
                    this.bjV = this.drC.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.bjL.size()) {
                            break;
                        }
                        dm dmVar = this.bjL.get(i2);
                        if (categoryTo != dmVar.aYG) {
                            i = i2 + 1;
                        } else {
                            this.drE = categoryTo;
                            this.bjV = dmVar.name;
                            this.ddI.setCategoryTo(this.drE);
                            break;
                        }
                    }
                    if (this.drF != null) {
                        this.drF.setText(this.bjV);
                        this.drF.b(this.bjL, this.drC, this.drE);
                    }
                }
                this.drr.zc();
                return;
            }
            return;
        }
        aEs();
    }

    private void aEs() {
        if ((!this.drS || this.drH != null) && this.drG != null) {
            this.drH.d(this.writeImagesInfo);
            aEv();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ddI.getType());
        bundle.putString("forum_id", this.ddI.getForumId());
        bundle.putString("forum_name", this.ddI.getForumName());
        bundle.putString("thread_id", this.ddI.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.ddI.getFloor());
        bundle.putInt("floor_num", this.ddI.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.dro);
        if (this.dre) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aqt);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.drs);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.drx);
        if (this.ddI.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.ddI.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.ddI.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.ddI.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.ddI.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.ddI.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.ddI.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.ddI.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.ddI.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.ddI.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aEm().getEditableText().toString();
        if (editable != null) {
            aEm().setText(TbFaceManager.BU().G(getPageContext().getPageActivity(), editable));
            aEm().setSelection(aEm().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDu() {
        aCN();
        if (this.ddI.getLiveCardData() != null) {
            if (!this.ddI.getLiveCardData().isModifyTime()) {
                this.ddI.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.drz.setText(com.baidu.tbadk.core.util.as.n(this.ddI.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.ddI.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.ddI.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.ddI.getLiveCardData().getStartTime() / 60) {
                showToast(i.h.live_start_time_error);
                return;
            }
        }
        String editable = aEn().getText().toString();
        this.ddI.setContent(aEm().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dnP != 0 && this.ddI.getType() != 4) {
            this.ddI.setTitle(String.valueOf(this.don.getText().toString()) + editable);
        } else {
            this.ddI.setTitle(editable);
        }
        if (this.dre || this.drf) {
            String string = getResources().getString(i.h.android_feedback);
            if (TextUtils.isEmpty(this.ddI.getTitle()) || !this.ddI.getTitle().startsWith(string)) {
                this.ddI.setTitle(string + this.ddI.getTitle());
            }
            String str = String.valueOf(getResources().getString(i.h.app_name)) + getResources().getString(i.h.tieba_client);
            if (TextUtils.isEmpty(this.ddI.getContent()) || !this.ddI.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iN()) {
                    sb.append(com.baidu.adp.lib.util.i.iV());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.ddI.getContent());
                this.ddI.setContent(sb.toString());
            }
        }
        if (this.drD >= 0) {
            this.ddI.setCategoryFrom(this.drD);
        }
        if (this.drE >= 0) {
            this.ddI.setCategoryTo(this.drE);
        }
        this.ddI.setWriteImagesInfo(this.writeImagesInfo);
        this.ddI.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.ddI.setHasLocationData(this.aqu == null ? false : this.aqu.ayy());
        this.aqv.gC(this.writeImagesInfo.size() > 0);
        this.aqv.c(this.ddI);
        this.ddI.setVcode(null);
        if (this.aqr != null) {
            if (this.aqr.getId() != null) {
                this.aqv.ayT().setVoice(this.aqr.getId());
                this.aqv.ayT().setVoiceDuringTime(this.aqr.duration);
            } else {
                this.aqv.ayT().setVoice(null);
                this.aqv.ayT().setVoiceDuringTime(-1);
            }
        } else {
            this.aqv.ayT().setVoice(null);
            this.aqv.ayT().setVoiceDuringTime(-1);
        }
        if (!this.aqv.ayX()) {
            showToast(i.h.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(i.h.sending), this.crt);
        if (!this.aqv.ayU()) {
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
            if (this.drs != null) {
                i2 = this.drs.getTotalCount();
                i = this.drs.getAlreadyCount() + 1;
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
                if (this.drr != null && !this.drr.AC()) {
                    aEm().requestFocus();
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
                            aEm().getText().insert(aEm().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.ddI.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ad.b(this.ddI.getForumId(), (WriteData) null);
                } else if (this.ddI.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ad.c(this.ddI.getThreadId(), (WriteData) null);
                } else if (this.ddI.getType() == 4) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    com.baidu.tieba.tbadkCore.ad.b(String.valueOf(this.ddI.getForumId()) + "photolive", (WriteData) null);
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
                                amn();
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
                    this.ddI.setVideoInfo(videoInfo);
                    this.drr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.drr.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    aCV();
                } else if (i == 12012) {
                    if (!this.drS) {
                        H(intent);
                        aCV();
                        return;
                    }
                    ab(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo2 = new VideoInfo();
                    videoInfo2.parseIntent(intent);
                    com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c10068");
                    aqVar2.r("duration", videoInfo2.getDuration());
                    TiebaStatic.log(aqVar2);
                    this.ddI.setVideoInfo(videoInfo2);
                    this.drr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    this.drr.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo2));
                    aCV();
                } else if (i == 12013) {
                    I(intent);
                    aCV();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.drr != null && !this.drr.AC()) {
                this.dol.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Bh();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aEu();
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
                    this.aqt = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.am.a(getPageContext(), this.aqt);
                    return;
                case 12012:
                    aEu();
                    return;
            }
        }
    }

    private void aEt() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aEu() {
        if (this.drS) {
            this.drH.d(this.writeImagesInfo);
            aEv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEv() {
        this.drH.notifyDataSetChanged();
        this.drG.invalidate();
        this.mHandler.postDelayed(new bf(this), 550L);
    }

    public void n(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        aCV();
    }

    private void Y(Intent intent) {
        if (this.drS) {
            ab(intent);
            aEu();
        } else {
            ac(intent);
        }
        aCV();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aEu();
            hf(true);
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

    private void amn() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.cAh.parseJson(stringExtra);
            this.cAh.updateQuality();
            if (this.cAh.getChosedFiles() != null && this.cAh.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.cAh.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.cAh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aEn());
        HidenSoftKeyPad(this.mInputManager, aEm());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ac(Intent intent) {
        b(intent, true);
    }

    private void G(Intent intent) {
        this.aqt = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aqt;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cC = com.baidu.tbadk.core.util.c.cC(str);
                if (cC != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aqt, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aEw();
            Bo();
        }
        hf(true);
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
                aEw();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Bo();
                }
            }
            hf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEw() {
        if (this.drr.dU(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void I(Intent intent) {
        if (this.ddI != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.ddI.setIsBaobao(true);
            this.ddI.setBaobaoContent(stringExtra2);
            Bq();
            hg(true);
        }
    }

    private void Bh() {
        new bh(this).execute(new Void[0]);
    }

    private void hf(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void hg(boolean z) {
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
            if (AntiHelper.lr(postWriteCallBackData.getErrorCode())) {
                AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(i.h.error_write);
                }
                showToast(errorString2);
            } else if (this.drs == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aqD = i;
        if (this.drr != null) {
            this.drr.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.b.a(i, z, str)));
            if (z) {
                this.drr.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Bo() {
        if (!this.drS && this.drr != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.drr.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.drr.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.drr.b(new com.baidu.tbadk.editortools.a(12, 15, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.drr.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Bq() {
        if (this.drr != null) {
            this.drr.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.drr.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.drr.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        if (this.drr != null) {
            this.drr.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void mu(int i) {
        if (i < this.dpO.size()) {
            for (int i2 = 0; i2 < this.dpO.size(); i2++) {
                this.dpO.get(i2).ha(false);
            }
            this.dpO.get(i).ha(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void mg(int i) {
        this.dnP = i;
        this.doo.lZ(i);
        mu(i);
        this.don.setText(this.mPrefixData.getPrefixs().get(i));
        aCV();
        com.baidu.adp.lib.g.j.a(this.doo, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.doq.setSelected(false);
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
