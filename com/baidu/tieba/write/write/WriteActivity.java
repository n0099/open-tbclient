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
    public static String dQY = "from_writeActivity_livePhoto";
    private com.baidu.tbadk.editortools.k aqK;
    private VoiceData.VoiceModel asv;
    private String asx;
    private com.baidu.tieba.tbadkCore.location.d asy;
    private com.baidu.tieba.tbadkCore.writeModel.a asz;
    List<ec> brn;
    private String brx;
    private int dMV;
    private TextView dNt;
    private cf dNu;
    private ImageView dNv;
    private View dNw;
    private TextView dQA;
    private RelativeLayout dQC;
    private TextView dQD;
    private View dQE;
    private LiveBroadcastCard dQF;
    ec dQG;
    private int dQH;
    private int dQI;
    private PostCategoryView dQJ;
    private LinearLayout dQl;
    private View dQo;
    private View dQp;
    private Toast dQv;
    private AdditionData dQw;
    private RelativeLayout dQx;
    private TextView dQy;
    private TextView dQz;
    private com.baidu.tieba.view.a dRe;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData dBW = null;
    private boolean dQj = false;
    private boolean dQk = false;
    private InputMethodManager mInputManager = null;
    private EditText dNn = null;
    private View dNo = null;
    private LinearLayout dNq = null;
    private EditText dNr = null;
    private o dQm = null;
    private FeedBackTopListView dQn = null;
    private ArrayList<com.baidu.tieba.write.view.j> dOR = new ArrayList<>();
    private String cnl = null;
    private final KeyEvent dQq = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView dQr = null;
    private TextView dNs = null;
    private TextView bHW = null;
    private DialogInterface.OnCancelListener cKN = null;
    private com.baidu.tbadk.core.dialog.a dQs = null;
    private final Handler mHandler = new Handler();
    private boolean dQt = false;
    private String dQu = null;
    private RelativeLayout bGY = null;
    private String asF = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int asH = 0;
    private int dQB = 0;
    private WriteImagesInfo cYm = new WriteImagesInfo();
    private View mRootView = null;
    private GridView dQK = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a dQL = null;
    private ScrollView dQM = null;
    private EditText dQN = null;
    private View dQO = null;
    private View dQP = null;
    private View dQQ = null;
    private EditText dQR = null;
    private TextView dQS = null;
    private TextView dQT = null;
    private TextWatcher dQU = null;
    private TextWatcher dQV = null;
    private boolean dQW = false;
    private boolean dQX = false;
    private final HttpMessageListener dQZ = new y(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final a.d asP = new aj(this);
    private final d.a asN = new av(this);
    private final CustomMessageListener dBq = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener dRa = new bi(this);
    private Runnable dRb = new bj(this);
    private boolean dRc = true;
    private final View.OnFocusChangeListener dNl = new bk(this);
    private final CustomMessageListener dRd = new bl(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private final a.InterfaceC0084a cFT = new bm(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Cc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(n.i.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Cd();
        } else if (this.asy.aDO()) {
            Cb();
        } else {
            this.asy.hm(false);
            a(1, true, (String) null);
            this.asy.aDM();
        }
    }

    private void Cd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bN(n.i.location_app_permission_prompt).a(n.i.isopen, new z(this)).b(n.i.cancel, new aa(this)).b(getPageContext());
        aVar.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aJr() {
        int selectionEnd = aJJ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) aJJ().getText().getSpans(0, aJJ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = aJJ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = aJJ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJs() {
        if (this.aqK != null) {
            this.aqK.setBarLauncherEnabled(!this.dRc);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.dRe != null && this.dBW != null && this.dBW.getLiveCardData() != null) {
            this.mHandler.postDelayed(this.dRb, 100L);
        }
        if (this.dQW) {
            this.dNn.setVisibility(8);
            if (this.dBW.getType() == 5) {
                this.dQQ.setVisibility(8);
            } else {
                this.dQQ.setVisibility(0);
            }
            b(this.dQT, this.dQN);
            b(this.dQS, this.dQR);
            aIs();
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
        aJE();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.dRd.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dRd);
        this.asy = new com.baidu.tieba.tbadkCore.location.d(this);
        this.asy.a(this.asN);
        registerListener(this.dBq);
        initEditor();
        if (this.dQW) {
            this.dQL.setEditorTools(this.aqK);
        } else {
            this.dNr.requestFocus();
        }
    }

    private void initEditor() {
        this.aqK = new com.baidu.tbadk.editortools.k(getActivity());
        this.aqK.setBarMaxLauCount(4);
        this.aqK.setMoreButtonAtEnd(true);
        this.aqK.setBarLauncherType(1);
        this.aqK.setBarLinePostion(2);
        this.aqK.setMoreLauncherIcon(n.e.write_more);
        this.aqK.setBackgroundColorId(n.c.cp_bg_line_d);
        switch (this.dBW.getType()) {
            case 4:
            case 5:
                aJv();
                break;
            default:
                aJw();
                break;
        }
        this.aqK.Bv();
        if (this.dQl != null) {
            this.dQl.addView(this.aqK);
        }
        aJx();
        this.aqK.oD();
        com.baidu.tbadk.editortools.r eg = this.aqK.eg(6);
        if (eg != null && !TextUtils.isEmpty(this.asF)) {
            ((View) eg).setOnClickListener(new ab(this));
        }
        if (!this.dQW) {
            this.aqK.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aqK.zY();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("xiaoying_has_click", false)) {
            this.aqK.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
    }

    private void aJt() {
        this.dQO = this.mRootView.findViewById(n.f.photo_live_scroll);
        this.dQQ = this.dQO.findViewById(n.f.live_post_title_container);
        this.dQN = (EditText) this.dQO.findViewById(n.f.live_post_content);
        this.dQK = (GridView) this.dQO.findViewById(n.f.photoLiveGridView);
        this.dQR = (EditText) this.dQO.findViewById(n.f.live_post_title);
        this.dQS = (TextView) this.dQO.findViewById(n.f.titleOverPlusNumber);
        this.dQT = (TextView) this.dQO.findViewById(n.f.contentOverPlusNumber);
        this.dQP = this.dQO.findViewById(n.f.live_interval_view);
        this.dQS.setText(String.valueOf(20));
        this.dQT.setText(String.valueOf(233));
        this.dQO.setVisibility(0);
        this.dQS.setVisibility(0);
        this.dQT.setVisibility(0);
        this.dQR.setHint(n.i.tips_title_limit_new);
        this.dQR.setOnFocusChangeListener(new ac(this));
        if (this.dBW.getType() == 4) {
            this.dQN.setHint(n.i.live_write_input_content_new);
        } else if (this.dBW.getType() == 5) {
            this.dQN.setHint(n.i.live_write_input_content_update);
        }
        this.dQN.setOnFocusChangeListener(new ad(this));
        this.dQN.requestFocus();
        this.dQN.addTextChangedListener(aqn());
        this.dQR.requestFocus();
        this.dQR.addTextChangedListener(aqn());
        this.dQR.setOnClickListener(this.dRa);
        this.dQN.setOnClickListener(this.dRa);
        this.dQL = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.dQK);
        this.dQL.nx(6);
        this.dQK.setAdapter((ListAdapter) this.dQL);
        View findViewById = this.dQO.findViewById(n.f.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ae(this));
        aJu();
    }

    private void aJu() {
        if (this.dBW.getType() == 0) {
            if (this.dBW.getTitle() != null) {
                this.dQR.setText(this.dBW.getTitle());
                this.dQR.setSelection(this.dBW.getTitle().length());
            }
        } else if (this.dBW.getType() != 1) {
            this.dBW.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.dQW) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            aJQ();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Co();
            return;
        }
        if (this.aqK.Bx()) {
            this.aqK.zY();
        }
        String str = null;
        if (this.dBW != null) {
            str = this.dBW.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.dQW) {
            albumActivityConfig.getIntent().putExtra("from", dQY);
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void aJv() {
        new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aqK.p(arrayList);
        com.baidu.tbadk.editortools.y ei = this.aqK.ei(5);
        if (ei != null) {
            ei.launcherPriority = 2;
            ei.launcherIcon = n.e.write_face;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.launcherIcon = n.e.write_at;
        this.aqK.b(aVar);
        this.aqK.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void aJw() {
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
        iVar.launcherIcon = n.e.write_picture;
        this.aqK.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        if (!XiaoyingUtil.showXiaoyingTool() || this.dBW == null || this.dBW.isAddition() || this.dQj) {
            z = false;
        } else {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, getActivity()), com.baidu.tbadk.editortools.y.class);
            if (runTask2 == null || (yVar6 = (com.baidu.tbadk.editortools.y) runTask2.getData()) == null) {
                z = false;
            } else {
                yVar6.launcherPriority = 3;
                yVar6.launcherIcon = n.e.write_video;
                this.aqK.b(yVar6);
                z = true;
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, getActivity()), com.baidu.tbadk.editortools.y.class);
            if (runTask3 != null && (yVar5 = (com.baidu.tbadk.editortools.y) runTask3.getData()) != null) {
                this.aqK.b(yVar5);
            }
        }
        this.aqK.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask4 != null && (yVar4 = (com.baidu.tbadk.editortools.y) runTask4.getData()) != null) {
            yVar4.launcherPriority = 4;
            yVar4.launcherIcon = n.e.write_privilege;
            this.aqK.b(yVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        if (!z) {
            aVar.launcherIcon = n.e.write_at;
        }
        this.aqK.b(aVar);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask5 != null && (yVar3 = (com.baidu.tbadk.editortools.y) runTask5.getData()) != null) {
            yVar3.toolNeedAction = true;
            yVar3.launcherPriority = 8;
            yVar3.launcherIcon = 0;
            this.aqK.b(yVar3);
        }
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.y.class);
        if (runTask6 != null && (yVar2 = (com.baidu.tbadk.editortools.y) runTask6.getData()) != null) {
            yVar2.toolNeedAction = true;
            yVar2.launcherPriority = 9;
            yVar2.launcherIcon = 0;
            this.aqK.b(yVar2);
        }
        Boolean aJO = aJO();
        if (!this.dQj && aJO != null && aJO.booleanValue() && com.baidu.tieba.tbadkCore.voice.b.aEk() && com.baidu.tieba.tbadkCore.v.a(this.dBW.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.y.class)) != null && (yVar = (com.baidu.tbadk.editortools.y) runTask.getData()) != null) {
            yVar.launcherPriority = 6;
            this.aqK.b(yVar);
        }
        if (this.dBW != null && this.dBW.getType() == 0 && !this.dQj && !this.dQk) {
            arrayList.add(13);
            arrayList.add(14);
        }
        if (this.dQw == null) {
            this.aqK.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.aqK.p(arrayList);
        com.baidu.tbadk.editortools.y ei = this.aqK.ei(5);
        if (ei != null) {
            ei.launcherPriority = 2;
            ei.launcherIcon = n.e.write_face;
        }
        com.baidu.tbadk.editortools.y ei2 = this.aqK.ei(13);
        if (ei2 != null) {
            ei2.launcherPriority = 7;
        }
    }

    private void aJx() {
        af afVar = new af(this);
        this.aqK.a(16, afVar);
        this.aqK.a(21, afVar);
        this.aqK.a(14, afVar);
        this.aqK.a(24, afVar);
        this.aqK.a(3, afVar);
        this.aqK.a(10, afVar);
        this.aqK.a(11, afVar);
        this.aqK.a(12, afVar);
        this.aqK.a(13, afVar);
        this.aqK.a(22, afVar);
        this.aqK.a(23, afVar);
        this.aqK.a(15, afVar);
        this.aqK.a(18, afVar);
        this.aqK.a(25, afVar);
        this.aqK.a(27, afVar);
        this.aqK.a(29, afVar);
    }

    public void aEI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        if (this.asy.aDQ()) {
            if (this.asy.aDO()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.aDJ().getLocationData().aDF());
                return;
            }
            a(1, true, (String) null);
            this.asy.aDM();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIk() {
        if (this.asz != null) {
            this.asz.cancelLoadData();
        }
        if (this.dQm != null) {
            this.dQm.cancelLoadData();
        }
        if (this.asy != null) {
            this.asy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aIk();
        aJN();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJy() {
        if (this.dBW != null && this.dBW.getType() == 2 && this.dQt) {
            finish();
        } else if (this.dBW == null) {
            finish();
        } else {
            this.dBW.setTitle(aJK().getText().toString());
            this.dBW.setContent(aJJ().getText().toString());
            int type = this.dBW.getType();
            if (type == 0) {
                if (this.dBW.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ae.b(this.dBW.getForumId(), this.dBW);
                } else {
                    com.baidu.tieba.tbadkCore.ae.a(this.dBW.getLiveCardData().getGroupId(), this.dBW);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ae.c(this.dBW.getThreadId(), this.dBW);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.dBW.getForumId()) + "photolive", this.dBW);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.dBW.getThreadId()) + "updatephotolive", this.dBW);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dNu != null && this.dNu.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.dNu, getPageContext().getPageActivity());
                return true;
            } else if (this.aqK.Bx()) {
                this.aqK.zY();
                return true;
            } else {
                aIk();
                aJy();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.bGY);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.as.i((View) this.dNs, n.e.s_navbar_button_bg);
        aJs();
        com.baidu.tbadk.core.util.as.j(this.dQO, n.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.j(this.dNo, n.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.j(this.dQP, n.c.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.j((View) aJK(), n.c.cp_bg_line_d);
        if (TextUtils.isEmpty(this.cnl)) {
            com.baidu.tbadk.core.util.as.j((View) aJJ(), n.c.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_e);
        aJK().setTextColor(color);
        aJJ().setTextColor(color);
        a(aJK(), color2);
        a(aJJ(), color2);
        aIs();
        this.aqK.onChangeSkinType(i);
        if (this.dQJ != null) {
            this.dQJ.wh();
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
        this.dQW = this.dBW.getType() == 4 || 5 == this.dBW.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(n.g.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bHW = this.mNavigationBar.setTitleText("");
        this.dQr = (TextView) findViewById(n.f.btn_image_problem);
        this.dNs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dNs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.dNs.setLayoutParams(layoutParams);
        this.dNs.setOnFocusChangeListener(this.dNl);
        this.dQM = (ScrollView) findViewById(n.f.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dQn = (FeedBackTopListView) findViewById(n.f.feedback_top_list);
        this.dQo = findViewById(n.f.feedback_divider);
        this.bGY = (RelativeLayout) findViewById(n.f.parent);
        this.dQl = (LinearLayout) findViewById(n.f.tool_view);
        this.dNo = findViewById(n.f.interval_view);
        aIr();
        if (this.dQW) {
            this.dQM.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            aJt();
        }
        aIt();
        if (this.dQj || this.dQk) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(n.f.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(n.f.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.dNq = (LinearLayout) findViewById(n.f.post_content_container);
        this.dNq.setDrawingCacheEnabled(false);
        this.dNq.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.dNl);
        this.mBack.setOnClickListener(new ah(this));
        this.dQr.setOnClickListener(new ai(this));
        aJA();
        j(aJO());
        aJC();
        aJF();
        aEI();
        switch (this.dBW.getType()) {
            case 0:
                if (this.dQj || this.dQk) {
                    this.bHW.setText(n.i.feedback);
                } else {
                    this.bHW.setText(n.i.post_new_thread);
                }
                this.dNn.setVisibility(0);
                this.dNr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.bHW.setText(n.i.send_reply);
                this.dNr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.dNn.setVisibility(8);
                break;
            case 4:
                this.bHW.setText(n.i.publish_photo_live);
                this.dNr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bHW.setText(getPageContext().getResources().getString(n.i.update_photo_live_tip, Integer.valueOf(this.dBW.getFloorNum() + 1)));
                this.dQP.setVisibility(8);
                break;
        }
        aJG();
        aJM();
        aJs();
        aJD();
        aIq();
        if (this.dBW.getType() == 4 && this.dNw != null && this.dQp != null) {
            this.dNw.setVisibility(8);
            this.dQp.setVisibility(8);
        }
        aIs();
        if (this.dBW.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.dNn);
        }
        aJB();
    }

    private void aJz() {
        this.brn = null;
        this.dQH = -1;
        this.dQI = -1;
        ee gj = ed.Oe().gj(1);
        if (gj != null) {
            this.brn = gj.beJ;
            this.dQH = getIntent().getIntExtra("category_id", -1);
            if (this.brn != null && !this.brn.isEmpty() && this.dQH >= 0) {
                this.dQG = new ec();
                this.dQG.beF = 0;
                this.dQG.name = getPageContext().getResources().getString(n.i.category_auto);
                this.dQI = this.dQG.beF;
                this.brx = this.dQG.name;
                for (ec ecVar : this.brn) {
                    if (ecVar.beF == this.dQH) {
                        this.dQI = ecVar.beF;
                        this.brx = ecVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void aJA() {
        if (this.brn != null && !this.brn.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(n.f.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(n.f.interval_view_cate).setVisibility(0);
            this.dQJ = (PostCategoryView) linearLayout.findViewById(n.f.category_selected);
            this.dQJ.setText(this.brx);
            this.dQJ.b(this.brn, this.dQG, this.dQI);
            this.dQJ.setCategoryContainerClickCallback(new ak(this));
            linearLayout.setOnClickListener(new al(this));
        }
    }

    private void aJB() {
    }

    private void aJC() {
        this.dQC = (RelativeLayout) findViewById(n.f.live_time_rel);
        this.dQD = (TextView) findViewById(n.f.live_tiem_show);
        this.dQE = findViewById(n.f.interval_view2);
        this.dQF = (LiveBroadcastCard) findViewById(n.f.live_anchor_card);
        this.dQC.setOnClickListener(new am(this));
        this.dQC.setOnTouchListener(new an(this));
        if (this.dBW.getLiveCardData() != null) {
            this.dQC.setVisibility(0);
            this.dQE.setVisibility(0);
            this.dQF.setVisibility(0);
            this.dQF.setClickable(false);
            this.dQD.setText(com.baidu.tbadk.core.util.ax.u(this.dBW.getLiveCardData().getStartTime() * 1000));
            this.dQF.setData(this.dBW.getLiveCardData());
            return;
        }
        this.dQC.setVisibility(8);
        this.dQE.setVisibility(8);
        this.dQF.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.dBW.getLiveCardData() != null) {
            Date date = new Date(this.dBW.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.dRe = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ao(this), new Date().getHours(), new Date().getMinutes(), false);
        this.dRe.setTitle(n.i.no_disturb_start_time);
        this.dRe.setButton(-1, getPageContext().getString(n.i.alert_yes_button), this.dRe);
        this.dRe.setButton(-2, getPageContext().getString(n.i.alert_no_button), this.dRe);
        return this.dRe;
    }

    private void aJD() {
        this.dQx = (RelativeLayout) findViewById(n.f.addition_container);
        this.dQy = (TextView) findViewById(n.f.addition_create_time);
        this.dQz = (TextView) findViewById(n.f.addition_last_time);
        this.dQA = (TextView) findViewById(n.f.addition_last_content);
        if (this.dQw != null) {
            this.dQx.setVisibility(0);
            this.dQy.setText(String.valueOf(getPageContext().getString(n.i.write_addition_create)) + com.baidu.tbadk.core.util.ax.s(this.dQw.getCreateTime() * 1000));
            if (this.dQw.getAlreadyCount() == 0) {
                this.dQz.setVisibility(8);
            } else {
                this.dQz.setText(String.valueOf(getPageContext().getString(n.i.write_addition_last)) + com.baidu.tbadk.core.util.ax.s(this.dQw.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.dQw.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.dQA.setText(lastAdditionContent);
            } else {
                this.dQA.setVisibility(8);
            }
            aJJ().setHint(String.format(getPageContext().getString(n.i.write_addition_hint), Integer.valueOf(this.dQw.getAlreadyCount()), Integer.valueOf(this.dQw.getTotalCount())));
            this.bHW.setText(n.i.write_addition_title);
            return;
        }
        this.dQx.setVisibility(8);
    }

    private void aIq() {
        this.dNw = findViewById(n.f.post_prefix_layout);
        this.dNt = (TextView) findViewById(n.f.post_prefix);
        this.dQp = findViewById(n.f.prefix_divider);
        this.dNv = (ImageView) findViewById(n.f.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.dNw.setVisibility(0);
            this.dQp.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.dMV = 1;
            this.dNw.setOnClickListener(new ap(this));
            this.dNv = (ImageView) findViewById(n.f.prefix_icon);
            if (size > 1) {
                this.dNv.setVisibility(0);
                this.dNt.setOnClickListener(new aq(this));
            }
            this.dNu = new cf(getPageContext().getPageActivity());
            this.dNu.a(this);
            this.dNu.setMaxHeight(com.baidu.adp.lib.util.k.d(getActivity(), n.d.ds510));
            this.dNu.setOutsideTouchable(true);
            this.dNu.setFocusable(true);
            this.dNu.setOnDismissListener(this);
            this.dNu.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.c.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.as.getColor(n.c.write_text);
            int color2 = com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_c);
            com.baidu.tbadk.core.util.as.i((View) this.dNt, n.c.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.c(this.dNv, n.e.icon_title_down);
            this.dNt.setTextColor(color);
            this.dOR.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.dOR.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.dNu.addView(jVar);
            }
            this.dNu.nl(0);
            this.dNt.setText(prefixs.get(1));
            nG(1);
            return;
        }
        this.dNw.setVisibility(8);
    }

    private void aJE() {
        if (this.dQj && this.dBW != null) {
            this.dQn.setVisibility(0);
            this.dQo.setVisibility(0);
            this.dQm = new o(this);
            this.dQm.nu(this.dBW.getForumName());
            this.dQm.setLoadDataCallBack(new ar(this));
        }
    }

    protected void aJF() {
        this.dNs.setOnClickListener(new as(this));
    }

    protected void aJG() {
        this.dQs = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dQs.cC(getPageContext().getString(n.i.is_save_draft)).al(false).a(getPageContext().getString(n.i.save), new at(this)).b(getPageContext().getString(n.i.not_save), new aw(this));
        this.dQs.b(getPageContext());
    }

    protected void aIr() {
        this.dNn = (EditText) findViewById(n.f.post_title);
        this.dNn.setOnClickListener(this.dRa);
        this.dNn.setOnFocusChangeListener(this.dNl);
        if (this.dBW.getType() == 0) {
            if (this.dBW.getTitle() != null) {
                this.dNn.setText(this.dBW.getTitle());
                this.dNn.setSelection(this.dBW.getTitle().length());
            }
        } else if (this.dBW.getType() != 1) {
            this.dBW.getType();
        }
        this.dNn.addTextChangedListener(new ax(this));
    }

    private TextWatcher aqn() {
        ay ayVar = new ay(this);
        if (this.dQW && this.dQX) {
            if (this.dQU != null) {
                this.dQR.removeTextChangedListener(this.dQU);
            }
            this.dQU = ayVar;
        } else if (this.dQW) {
            if (this.dQV != null) {
                this.dQN.removeTextChangedListener(this.dQV);
            }
            this.dQV = ayVar;
        }
        return ayVar;
    }

    private long e(EditText editText) {
        if (editText == this.dQN) {
            return 233L;
        }
        if (editText != this.dQR) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.person_change_up_limit_text));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_d));
                }
            } else if (d < 0) {
                if (d < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.person_change_up_limit_text));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long d(EditText editText) {
        return com.baidu.tieba.write.c.a.h(editText.getText().toString().trim());
    }

    protected void aIt() {
        this.dNr = (EditText) findViewById(n.f.post_content);
        this.dNr.setDrawingCacheEnabled(false);
        this.dNr.setOnClickListener(this.dRa);
        if (this.dBW.getContent() != null && this.dBW.getContent().length() > 0) {
            SpannableString G = TbFaceManager.CW().G(getPageContext().getPageActivity(), this.dBW.getContent());
            this.dNr.setText(G);
            this.dNr.setSelection(G.length());
        } else if (this.dBW.getType() == 2) {
            if (this.dQt) {
                if (this.dQu != null && this.dQu.length() > 0) {
                    this.dNr.setText(getPageContext().getPageActivity().getString(n.i.reply_sub_floor, new Object[]{this.dQu}));
                    this.dNr.setSelection(this.dNr.getText().length());
                }
            } else if (this.dBW.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(n.i.reply_x_floor), Integer.valueOf(this.dBW.getFloorNum()));
                this.dNr.setText(format);
                this.dNr.setSelection(format.length());
            }
        }
        this.dNr.setOnFocusChangeListener(this.dNl);
        this.dNr.setOnTouchListener(new az(this));
        this.dNr.addTextChangedListener(new ba(this));
        hM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.dQW) {
            aJJ().setPadding(0, 0, 0, 0);
            aJJ().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.as.j((View) aJJ(), n.c.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.cnl) && this.dQw == null) {
                com.baidu.adp.lib.g.c.hd().a(this.cnl, 19, new bb(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJH() {
        int i = 5000;
        if (this.dQw != null) {
            i = 1000;
        }
        return aJJ().getText() != null && aJJ().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.aqK != null) {
                this.aqK.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aCx() && this.dQB == 0) {
            showToast(n.i.baobao_over_limit);
        } else {
            String charSequence = this.bHW.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (((ImageSpan[]) aJJ().getText().getSpans(0, aJJ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.dQv == null) {
                this.dQv = Toast.makeText(getPageContext().getPageActivity(), n.i.too_many_face, 0);
            }
            this.dQv.show();
            return;
        }
        String name = hVar.getName();
        EmotionGroupType xh = hVar.xh();
        if (name != null) {
            com.baidu.adp.lib.g.c.hd().a(name, 20, new bc(this, new SpannableStringBuilder(name), xh), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap ng = aVar.ng();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ng);
        int width = ng.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        aJJ().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aJJ() {
        return this.dQW ? this.dQN : this.dNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText aJK() {
        return this.dQW ? this.dQR : this.dNn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJL() {
        aJJ().onKeyDown(67, this.dQq);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.dBW != null) {
            str = this.dBW.getForumName();
        }
        if (getPageContext().getString(n.i.feedback_bar_name).equals(str)) {
            this.dQj = true;
        }
    }

    private void aJM() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aJN() {
        try {
            if (this.dQs != null) {
                this.dQs.dismiss();
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

    private Boolean aJO() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.asF = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIs() {
        String str;
        String str2 = null;
        if (this.dBW != null) {
            String editable = aJK().getText().toString();
            String trim = aJJ().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.dBW.getType() != 0) {
                str = null;
            } else if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.dMV == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.dBW.setIsNoTitle(true);
                        str = null;
                    } else {
                        this.dBW.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.dBW.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.dBW.setIsNoTitle(true);
                str = null;
            } else {
                this.dBW.setIsNoTitle(false);
                str = "1";
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.dQW) {
                    str = "1";
                } else if (this.writeImagesInfo.size() >= 1) {
                    str = "1";
                }
            } else if (!TextUtils.isEmpty(trim)) {
                str = "1";
            } else if (this.asv != null) {
                str = "1";
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                str = "1";
            }
            if (this.dBW.getVideoInfo() != null) {
                str = "1";
            }
            if (this.dBW.getType() == 4) {
                if (g(this.dQN) && f(this.dQR)) {
                    str2 = String.valueOf(1);
                }
            } else if (this.dBW.getType() != 5) {
                str2 = str;
            } else if (g(this.dQN)) {
                str2 = String.valueOf(1);
            }
            if (str2 == null || str2.length() <= 0) {
                this.dNs.setEnabled(false);
            } else {
                this.dNs.setEnabled(true);
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
        this.asz = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.asz.b(this.asP);
        registerListener(this.dQZ);
        this.cKN = new bd(this);
        this.dBW = new WriteData();
        if (bundle != null) {
            this.dBW.setType(bundle.getInt("type", 0));
            this.dBW.setForumId(bundle.getString("forum_id"));
            this.dBW.setForumName(bundle.getString("forum_name"));
            this.dBW.setThreadId(bundle.getString("thread_id"));
            this.dBW.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.dBW.setFloorNum(bundle.getInt("floor_num", 0));
            this.dQj = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.dQt = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dQu = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.asx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.dQw = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.dBW.setIsAddition(this.dQw != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.dQB = bundle.getInt("mem_type", 0);
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
                this.dBW.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.dBW.setType(intent.getIntExtra("type", 0));
            this.dBW.setForumId(intent.getStringExtra("forum_id"));
            this.dBW.setForumName(intent.getStringExtra("forum_name"));
            this.dBW.setThreadId(intent.getStringExtra("thread_id"));
            this.dBW.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.dBW.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.dQj = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.dQt = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.dQu = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.dQw = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.dBW.setIsAddition(this.dQw != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.dQB = intent.getIntExtra("mem_type", 0);
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
                this.dBW.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.dBW.getType() == 4 ? 6 : 10);
        this.dBW.setWriteImagesInfo(this.writeImagesInfo);
        this.dBW.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.dBW.getType() == 0) {
            if (this.dBW.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ae.c(this.dBW.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ae.a(this.dBW.getLiveCardData().getGroupId(), this);
            }
        } else if (this.dBW.getType() == 1) {
            com.baidu.tieba.tbadkCore.ae.a(this.dBW.getThreadId(), this);
        } else if (this.dBW.getType() == 4) {
            com.baidu.tieba.tbadkCore.ae.c(String.valueOf(this.dBW.getForumId()) + "photolive", this);
        } else if (this.dBW.getType() == 5) {
            com.baidu.tieba.tbadkCore.ae.a(String.valueOf(this.dBW.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(n.i.write_no_prefix));
        }
        this.cnl = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.dBW != null && this.dBW.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.dBW.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.dQk = true;
        }
        aJz();
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.dBW != null) {
                this.dBW.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(aJK().getText().toString()) || ((this.dQj || this.dQk) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.dBW.setTitle(writeData.getTitle());
                    aJK().setText(this.dBW.getTitle());
                    aJK().setSelection(this.dBW.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.dBW.setVideoInfo(videoInfo);
                    this.aqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if (writeData.getLiveCardData() != null) {
                    Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                    Date date2 = new Date();
                    date.setYear(date2.getYear());
                    date.setMonth(date2.getMonth());
                    date.setDate(date2.getDate());
                    this.dBW.getLiveCardData().setStartTime(date.getTime() / 1000);
                    this.dQD.setText(com.baidu.tbadk.core.util.ax.u(this.dBW.getLiveCardData().getStartTime() * 1000));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(aJJ().getText().toString()) || this.dQj || this.dQk) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.dBW.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.CW().a(getPageContext().getPageActivity(), this.dBW.getContent(), new be(this));
                    aJJ().setText(a2);
                    aJJ().setSelection(a2.length());
                    if (this.dQW) {
                        b(this.dQT, this.dQN);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.dBW.setWriteImagesInfo(this.writeImagesInfo);
                    aJT();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Co();
                    }
                    hN(false);
                }
                if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.dBW.setIsBaobao(writeData.getIsBaobao());
                        this.dBW.setBaobaoContent(writeData.getBaobaoContent());
                        this.dBW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.dBW.getIsBaobao()) {
                        Cq();
                        hO(false);
                    }
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    aJP();
                }
                aIs();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.brn != null) {
                    this.dQI = this.dQG.beF;
                    this.brx = this.dQG.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.brn.size()) {
                            break;
                        }
                        ec ecVar = this.brn.get(i2);
                        if (categoryTo != ecVar.beF) {
                            i = i2 + 1;
                        } else {
                            this.dQI = categoryTo;
                            this.brx = ecVar.name;
                            this.dBW.setCategoryTo(this.dQI);
                            break;
                        }
                    }
                    if (this.dQJ != null) {
                        this.dQJ.setText(this.brx);
                        this.dQJ.b(this.brn, this.dQG, this.dQI);
                    }
                }
                this.aqK.zY();
                return;
            }
            return;
        }
        aJP();
    }

    private void aJP() {
        if ((!this.dQW || this.dQL != null) && this.dQK != null) {
            this.dQL.b(this.writeImagesInfo);
            aJS();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.dBW.getType());
        bundle.putString("forum_id", this.dBW.getForumId());
        bundle.putString("forum_name", this.dBW.getForumName());
        bundle.putString("thread_id", this.dBW.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.dBW.getFloor());
        bundle.putInt("floor_num", this.dBW.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.dQt);
        if (this.dQj) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.asx);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.dQw);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.dQB);
        if (this.dBW.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.dBW.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.dBW.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.dBW.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.dBW.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.dBW.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.dBW.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.dBW.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.dBW.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.dBW.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = aJJ().getEditableText().toString();
        if (editable != null) {
            aJJ().setText(TbFaceManager.CW().G(getPageContext().getPageActivity(), editable));
            aJJ().setSelection(aJJ().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIR() {
        aIk();
        if (this.dBW.getLiveCardData() != null) {
            if (!this.dBW.getLiveCardData().isModifyTime()) {
                this.dBW.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.dQD.setText(com.baidu.tbadk.core.util.ax.u(this.dBW.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.dBW.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.dBW.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.dBW.getLiveCardData().getStartTime() / 60) {
                showToast(n.i.live_start_time_error);
                return;
            }
        }
        String editable = aJK().getText().toString();
        this.dBW.setContent(aJJ().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dMV != 0 && this.dBW.getType() != 4) {
            this.dBW.setTitle(String.valueOf(this.dNt.getText().toString()) + editable);
        } else {
            this.dBW.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.dBW.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.dBW.getTitle());
        }
        if (this.dQj || this.dQk) {
            String string = getResources().getString(n.i.android_feedback);
            if (TextUtils.isEmpty(this.dBW.getTitle()) || !this.dBW.getTitle().startsWith(string)) {
                this.dBW.setTitle(string + this.dBW.getTitle());
            }
            String str = String.valueOf(getResources().getString(n.i.app_name)) + getResources().getString(n.i.tieba_client);
            if (TextUtils.isEmpty(this.dBW.getContent()) || !this.dBW.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.iP()) {
                    sb.append(com.baidu.adp.lib.util.i.iX());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.dBW.getContent());
                this.dBW.setContent(sb.toString());
            }
        }
        if (this.dQH >= 0) {
            this.dBW.setCategoryFrom(this.dQH);
        }
        if (this.dQI >= 0) {
            this.dBW.setCategoryTo(this.dQI);
        }
        this.dBW.setWriteImagesInfo(this.writeImagesInfo);
        this.dBW.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.dBW.setHasLocationData(this.asy == null ? false : this.asy.aDQ());
        this.asz.hn(this.writeImagesInfo.size() > 0);
        this.asz.c(this.dBW);
        this.dBW.setVcode(null);
        if (this.asv != null) {
            if (this.asv.getId() != null) {
                this.asz.aEl().setVoice(this.asv.getId());
                this.asz.aEl().setVoiceDuringTime(this.asv.duration);
            } else {
                this.asz.aEl().setVoice(null);
                this.asz.aEl().setVoiceDuringTime(-1);
            }
        } else {
            this.asz.aEl().setVoice(null);
            this.asz.aEl().setVoiceDuringTime(-1);
        }
        if (!this.asz.aEp()) {
            showToast(n.i.write_img_limit);
            return;
        }
        showLoadingDialog(getPageContext().getString(n.i.sending), this.cKN);
        if (!this.asz.aEm()) {
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
            if (this.dQw != null) {
                i2 = this.dQw.getTotalCount();
                i = this.dQw.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(n.i.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aqK != null && !this.aqK.Bx()) {
                    aJJ().requestFocus();
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
                            aJJ().getText().insert(aJJ().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.dBW.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ae.b(this.dBW.getForumId(), (WriteData) null);
                } else if (this.dBW.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ae.c(this.dBW.getThreadId(), (WriteData) null);
                } else if (this.dBW.getType() == 4) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    com.baidu.tieba.tbadkCore.ae.b(String.valueOf(this.dBW.getForumId()) + "photolive", (WriteData) null);
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
                                arE();
                            } else {
                                Z(intent);
                            }
                        } else if (intExtra == 1) {
                            S(intent);
                        } else {
                            Y(intent);
                        }
                    }
                } else if (i == 12012) {
                    if (!this.dQW) {
                        H(intent);
                        aIs();
                        return;
                    }
                    ab(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.dBW.setVideoInfo(videoInfo);
                        this.aqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aqK.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    aIs();
                } else if (i == 12013) {
                    I(intent);
                    aIs();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                }
            }
        } else if (i2 == 0) {
            if (this.aqK != null && !this.aqK.Bx()) {
                this.dNr.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Ch();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    aJR();
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
                    this.asx = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ar.b(getPageContext(), this.asx);
                    return;
                case 12012:
                    aJR();
                    return;
            }
        }
    }

    private void aJQ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void aJR() {
        if (this.dQW) {
            this.dQL.b(this.writeImagesInfo);
            aJS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJS() {
        this.dQL.notifyDataSetChanged();
        this.dQK.invalidate();
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
        aIs();
    }

    private void Y(Intent intent) {
        if (this.dQW) {
            ab(intent);
            aJR();
        } else {
            ac(intent);
        }
        aIs();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            aJR();
            hN(true);
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

    private void arE() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.cYm.parseJson(stringExtra);
            this.cYm.updateQuality();
            if (this.cYm.getChosedFiles() != null && this.cYm.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.cYm.getChosedFiles().get(0).getFilePath(), 0.56f, EditHeadActivityConfig.FROM_PHOTO_LIVE)));
            }
            this.cYm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, aJK());
        HidenSoftKeyPad(this.mInputManager, aJJ());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        this.mHandler.removeCallbacks(this.dRb);
    }

    private void ac(Intent intent) {
        b(intent, true);
    }

    private void G(Intent intent) {
        this.asx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cK = com.baidu.tbadk.core.util.c.cK(str);
                if (cK != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cK);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.asx, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            aJT();
            Co();
        }
        hN(true);
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
                aJT();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Co();
                }
            }
            hN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJT() {
        if (this.aqK.ei(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void I(Intent intent) {
        if (this.dBW != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.dBW.setIsBaobao(true);
            this.dBW.setBaobaoContent(stringExtra2);
            Cq();
            hO(true);
        }
    }

    private void Ch() {
        new bh(this).execute(new Void[0]);
    }

    private void hN(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void hO(boolean z) {
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
            if (AntiHelper.mC(postWriteCallBackData.getErrorCode())) {
                AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(n.i.error_write);
                }
                showToast(errorString2);
            } else if (this.dQw == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.asH = i;
        if (this.aqK != null) {
            this.aqK.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.aqK.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Co() {
        if (!this.dQW && this.aqK != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.aqK.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.aqK.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aqK.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aqK.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Cq() {
        if (this.aqK != null) {
            this.aqK.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.aqK.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.aqK.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (this.aqK != null) {
            this.aqK.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void nG(int i) {
        if (i < this.dOR.size()) {
            for (int i2 = 0; i2 < this.dOR.size(); i2++) {
                this.dOR.get(i2).hI(false);
            }
            this.dOR.get(i).hI(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ns(int i) {
        this.dMV = i;
        this.dNu.nl(i);
        nG(i);
        this.dNt.setText(this.mPrefixData.getPrefixs().get(i));
        aIs();
        com.baidu.adp.lib.h.j.a(this.dNu, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.dNw.setSelected(false);
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
