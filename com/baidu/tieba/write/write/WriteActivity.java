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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
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
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.w;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, z.a, b.a {
    private static int fRW = 0;
    private VoiceData.VoiceModel aAM;
    private String aAN;
    private LocationModel aAO;
    private NewWriteModel aAP;
    private String ahM;
    private com.baidu.tbadk.editortools.j azd;
    private VoiceManager bMC;
    private String fRA;
    private int fRB;
    private PostCategoryView fRC;
    private LinearLayout fRg;
    private View fRj;
    private View fRk;
    private Toast fRq;
    private AdditionData fRr;
    private RelativeLayout fRs;
    private TextView fRt;
    private TextView fRu;
    private TextView fRv;
    List<com.baidu.tieba.frs.bv> fRx;
    com.baidu.tieba.frs.bv fRy;
    private int fRz;
    private HotTopicBussinessData fSa;
    private View fSb;
    private View fSc;
    private TextView fSd;
    private TextView fSe;
    private com.baidu.tieba.view.c fSp;
    private int flM;
    private TextView fmj;
    private com.baidu.tieba.write.b fmk;
    private ImageView fml;
    private View fmm;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fRb = "";
    private boolean fRc = false;
    private WriteData mData = null;
    private boolean fRd = false;
    private boolean fRe = false;
    private boolean fRf = false;
    private InputMethodManager mInputManager = null;
    private EditText fme = null;
    private HeadImageView fPh = null;
    private View fmf = null;
    private LinearLayout fmh = null;
    private EditText fmi = null;
    private FeedBackModel fRh = null;
    private FeedBackTopListView fRi = null;
    private ArrayList<com.baidu.tieba.write.a> fQe = new ArrayList<>();
    private String dHB = null;
    private final KeyEvent fRl = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aom = null;
    private TextView fRm = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fRn = null;
    private final Handler mHandler = new Handler();
    private boolean fRo = false;
    private String fRp = null;
    private RelativeLayout mParent = null;
    private String aAU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aAW = 0;
    private int fRw = 0;
    private WriteImagesInfo eNu = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fRD = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fRE = null;
    private ScrollView fRF = null;
    private EditText fRG = null;
    private View fRH = null;
    private View fRI = null;
    private View fRJ = null;
    private EditText fRK = null;
    private TextView fRL = null;
    private TextView fRM = null;
    private TextWatcher fRN = null;
    private TextWatcher fRO = null;
    private boolean fRP = false;
    private boolean fRQ = false;
    private com.baidu.tbadk.core.view.a aIG = null;
    private File fRR = null;
    private TbImageView fRS = null;
    private View fRT = null;
    private Dialog fRU = null;
    private LinearLayout fRV = null;
    private boolean fRX = false;
    private long fRY = -1000;
    private boolean fRZ = false;
    private String fSf = "";
    private String fSg = "";
    private int fSh = 0;
    private SpannableStringBuilder fSi = new SpannableStringBuilder();
    private final HttpMessageListener fSj = new t(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fSk = new ae(this);
    private final NewWriteModel.d aBe = new aq(this);
    private final LocationModel.a aBc = new bb(this);
    private final CustomMessageListener fxT = new be(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fSl = new bf(this);
    private boolean fSm = true;
    private final View.OnFocusChangeListener fmc = new bg(this);
    private TextWatcher fSn = new bh(this);
    private TextWatcher fSo = new bi(this);
    private final a.InterfaceC0072a eqR = new u(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ahM)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(w.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            DS();
        } else if (this.aAO.biY()) {
            DQ();
        } else {
            this.aAO.lm(false);
            b(1, true, null);
            this.aAO.biW();
        }
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new v(this)).b(w.l.cancel, new w(this)).b(getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpa() {
        int selectionEnd = bpr().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bpr().getText().getSpans(0, bpr().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bpr().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bpr().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpb() {
        if (this.azd != null) {
            this.azd.setBarLauncherEnabled(!this.fSm);
            this.azd.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fRP) {
            this.fme.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.fRJ.setVisibility(8);
            } else {
                this.fRJ.setVisibility(0);
            }
            b(this.fRM, this.fRG);
            b(this.fRL, this.fRK);
            bee();
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
        bpn();
        this.aAO = new LocationModel(this);
        this.aAO.a(this.aBc);
        registerListener(this.fxT);
        initEditor();
        bpD();
        if (this.fRP) {
            this.fRE.setEditorTools(this.azd);
        } else {
            this.fme.requestFocus();
        }
    }

    private void initEditor() {
        this.azd = new com.baidu.tbadk.editortools.j(getActivity());
        this.azd.setBarMaxLauCount(5);
        this.azd.setMoreButtonAtEnd(true);
        this.azd.setBarLauncherType(1);
        this.azd.bE(true);
        this.azd.bD(true);
        this.azd.setMoreLauncherIcon(w.g.write_more);
        this.azd.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bpe();
                break;
            default:
                bpf();
                break;
        }
        this.azd.Do();
        if (this.fRg != null) {
            this.fRg.addView(this.azd);
        }
        bpg();
        this.azd.mp();
        com.baidu.tbadk.editortools.p ez = this.azd.ez(6);
        if (ez != null && !TextUtils.isEmpty(this.aAU)) {
            ((View) ez).setOnClickListener(new x(this));
        }
        if (!this.fRP) {
            this.azd.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.azd.BC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("xiaoying_has_click", false)) {
            this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("hot_topic_has_click", false)) {
            this.azd.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bpc() {
        this.fRH = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.fRJ = this.fRH.findViewById(w.h.live_post_title_container);
        this.fRG = (EditText) this.fRH.findViewById(w.h.live_post_content);
        this.fRD = (GridView) this.fRH.findViewById(w.h.photoLiveGridView);
        this.fRK = (EditText) this.fRH.findViewById(w.h.live_post_title);
        this.fRL = (TextView) this.fRH.findViewById(w.h.titleOverPlusNumber);
        this.fRM = (TextView) this.fRH.findViewById(w.h.contentOverPlusNumber);
        this.fRI = this.fRH.findViewById(w.h.live_interval_view);
        this.fRL.setText(String.valueOf(20));
        this.fRM.setText(String.valueOf(233));
        this.fRH.setVisibility(0);
        this.fRL.setVisibility(0);
        this.fRM.setVisibility(0);
        this.fRK.setHint(w.l.tips_title_limit_new);
        this.fRK.setOnFocusChangeListener(new y(this));
        if (this.mData.getType() == 4) {
            this.fRG.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.fRG.setHint(w.l.live_write_input_content_update);
        }
        this.fRG.setOnFocusChangeListener(new z(this));
        this.fRG.requestFocus();
        this.fRG.addTextChangedListener(aSU());
        this.fRK.requestFocus();
        this.fRK.addTextChangedListener(aSU());
        this.fRK.setOnClickListener(this.fSl);
        this.fRG.setOnClickListener(this.fSl);
        this.fRE = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fRD);
        this.fRE.sU(6);
        this.fRD.setAdapter((ListAdapter) this.fRE);
        View findViewById = this.fRH.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new aa(this));
        bpd();
    }

    private void bpd() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.fRK.setText(this.mData.getTitle());
                this.fRK.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fRP) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bpz();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Eb();
            return;
        }
        if (this.azd.Dq()) {
            this.azd.BC();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fRP) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bpe() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.azd.u(arrayList);
        com.baidu.tbadk.editortools.x eB = this.azd.eB(5);
        if (eB != null) {
            eB.azJ = 2;
            eB.azH = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.azH = w.g.write_at;
        this.azd.b(aVar);
        this.azd.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bpf() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        com.baidu.tbadk.editortools.x xVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.azH = w.g.write_picture;
        this.azd.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.azd.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.azd.b(aVar);
        aVar.azH = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar5 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar5.azL = true;
            xVar5.azH = w.g.write_graffiti;
            xVar5.azJ = 4;
            this.azd.b(xVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar4.azJ = 5;
            xVar4.azH = w.g.write_privilege;
            this.azd.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.azH = w.g.write_at;
        this.azd.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar3.azL = true;
            xVar3.azJ = 9;
            xVar3.azH = 0;
            this.azd.b(xVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask5 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask5.getData()) != null) {
            xVar2.azL = true;
            xVar2.azJ = 10;
            xVar2.azH = 0;
            this.azd.b(xVar2);
        }
        Boolean bpw = bpw();
        if (!this.fRd && bpw != null && bpw.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bjt() && com.baidu.tieba.tbadkCore.s.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.azJ = 6;
            xVar.azH = w.g.write_recorder;
            this.azd.b(xVar);
        }
        if (this.fRr == null) {
            this.azd.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.azd.u(arrayList);
        com.baidu.tbadk.editortools.x eB = this.azd.eB(5);
        if (eB != null) {
            eB.azJ = 1;
            eB.azH = w.g.write_emotion;
        }
    }

    private void bpg() {
        ab abVar = new ab(this);
        this.azd.a(16, abVar);
        this.azd.a(14, abVar);
        this.azd.a(24, abVar);
        this.azd.a(3, abVar);
        this.azd.a(10, abVar);
        this.azd.a(11, abVar);
        this.azd.a(12, abVar);
        this.azd.a(13, abVar);
        this.azd.a(15, abVar);
        this.azd.a(18, abVar);
        this.azd.a(25, abVar);
        this.azd.a(27, abVar);
        this.azd.a(29, abVar);
        this.azd.a(40, abVar);
        this.azd.a(43, abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT() {
        if (this.aAO.PZ()) {
            if (this.aAO.biY()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.d.biU().getLocationData().biQ());
                return;
            }
            b(1, true, null);
            this.aAO.biW();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdW() {
        if (this.aAP != null) {
            this.aAP.cancelLoadData();
        }
        if (this.fRh != null) {
            this.fRh.cancelLoadData();
        }
        if (this.aAO != null) {
            this.aAO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bdW();
        bpv();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boz() {
        if (this.mData != null && this.mData.getType() == 2 && this.fRo) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bps().getText().toString());
            this.mData.setContent(bpr().getText().toString());
            int type = this.mData.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.z.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.z.b("24591571", this.mData);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.z.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.z.b(String.valueOf(this.mData.getForumId()) + "photolive", this.mData);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.z.c(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fmk != null && this.fmk.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fmk, getPageContext().getPageActivity());
                return true;
            } else if (this.azd.Dq()) {
                this.azd.BC();
                return true;
            } else {
                bdW();
                boz();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.fRV);
        if (this.fRS != null && i == 1) {
            this.fRS.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_link_tip_a, 1);
        bpb();
        com.baidu.tbadk.core.util.aq.k(this.fRH, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.fmf, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.fRI, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(bps(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dHB)) {
            com.baidu.tbadk.core.util.aq.k(bpr(), w.e.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e);
        bps().setTextColor(color);
        bpr().setTextColor(color);
        a(bps(), color2);
        a(bpr(), color2);
        bee();
        this.azd.onChangeSkinType(i);
        if (this.fRC != null) {
            this.fRC.xl();
        }
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_f);
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart <= selectionEnd) {
            editText.setSelection(selectionStart, selectionEnd);
        }
    }

    private void initUI() {
        this.aIG = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fRP = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(w.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aom = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aom != null && (this.aom.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            layoutParams2.width = -2;
            this.aom.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.icon_nav_close_selector, w.g.icon_nav_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.aq.i(this.mName, w.e.cp_cont_f);
        this.fRm = (TextView) findViewById(w.h.btn_image_problem);
        bph();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds10);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fmc);
        this.fRF = (ScrollView) findViewById(w.h.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fRi = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.fRj = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.fRg = (LinearLayout) findViewById(w.h.tool_view);
        this.fRg.setContentDescription("..");
        this.fmf = findViewById(w.h.interval_view);
        this.fSb = findViewById(w.h.hot_topic_fourm_view);
        this.fSc = findViewById(w.h.hot_topic_divider);
        this.fSd = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.fSe = (TextView) findViewById(w.h.change_one_tv);
        bed();
        if (this.fRP) {
            this.fRF.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bpc();
        }
        bef();
        if (this.fRd || this.fRe) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahn) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fmh = (LinearLayout) findViewById(w.h.post_content_container);
        this.fmh.setDrawingCacheEnabled(false);
        this.fmh.setOnClickListener(new ac(this));
        this.aom.setOnFocusChangeListener(this.fmc);
        this.aom.setOnClickListener(new ad(this));
        this.fRm.setOnClickListener(new af(this));
        bpk();
        j(bpw());
        bpo();
        switch (this.mData.getType()) {
            case 0:
                if (this.fRd || this.fRe) {
                    if (this.fRf) {
                        this.mName.setText(w.l.feedback_vcode);
                    } else {
                        this.mName.setText(w.l.feedback);
                    }
                } else {
                    this.mName.setText(w.l.post_new_thread);
                }
                this.fme.setVisibility(0);
                this.fmi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.mName.setText(w.l.send_reply);
                this.fmi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fme.setVisibility(8);
                break;
            case 4:
                this.mName.setText(w.l.publish_photo_live);
                this.fmi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.fRI.setVisibility(8);
                break;
            case 7:
                this.fme.setVisibility(0);
                this.fmi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.fmi.setHint(w.l.bottle_input_hint);
                this.mName.setText(w.l.post_drift_bottle);
                break;
        }
        bpp();
        bpu();
        bpb();
        bpm();
        bec();
        if (com.baidu.tbadk.core.util.x.q(this.mList) || this.mList.get(0) == null) {
            this.fme.getPaint().setFakeBoldText(true);
        } else {
            this.fme.getPaint().setFakeBoldText(false);
            bpx();
        }
        if (this.mData.getType() == 4 && this.fmm != null && this.fRk != null) {
            this.fmm.setVisibility(8);
            this.fRk.setVisibility(8);
        }
        bee();
        ShowSoftKeyPad(this.mInputManager, this.fme);
        bpl();
    }

    private void bph() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
        } else {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
        }
    }

    private void bpi() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fRd && !this.fRe && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.au.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bps() != null) {
                bps().setText(c);
                bps().setSelection(c.length());
            }
        }
    }

    private void bpj() {
        this.fRx = null;
        this.fRz = -1;
        this.fRB = -1;
        com.baidu.tieba.frs.bx hU = com.baidu.tieba.frs.bw.aaB().hU(1);
        if (hU != null) {
            this.fRx = hU.bPS;
            this.fRz = getIntent().getIntExtra("category_id", -1);
            if (this.fRx != null && !this.fRx.isEmpty() && this.fRz >= 0) {
                this.fRy = new com.baidu.tieba.frs.bv();
                this.fRy.bPO = 0;
                this.fRy.name = getPageContext().getResources().getString(w.l.category_auto);
                this.fRB = this.fRy.bPO;
                this.fRA = this.fRy.name;
                for (com.baidu.tieba.frs.bv bvVar : this.fRx) {
                    if (bvVar.bPO == this.fRz) {
                        this.fRB = bvVar.bPO;
                        this.fRA = bvVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bpk() {
        if (this.fRx != null && !this.fRx.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.fRC = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.fRC.setText(this.fRA);
            this.fRC.b(this.fRx, this.fRy, this.fRB);
            this.fRC.setCategoryContainerClickCallback(new ag(this));
            linearLayout.setOnClickListener(new ah(this));
        }
    }

    private void bpl() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fSp = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new ai(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fSp.setTitle(w.l.no_disturb_start_time);
        this.fSp.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.fSp);
        this.fSp.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.fSp);
        return this.fSp;
    }

    private void bpm() {
        this.fRs = (RelativeLayout) findViewById(w.h.addition_container);
        this.fRt = (TextView) findViewById(w.h.addition_create_time);
        this.fRu = (TextView) findViewById(w.h.addition_last_time);
        this.fRv = (TextView) findViewById(w.h.addition_last_content);
        if (this.fRr != null) {
            this.fRs.setVisibility(0);
            this.fRt.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.au.q(this.fRr.getCreateTime() * 1000));
            if (this.fRr.getAlreadyCount() == 0) {
                this.fRu.setVisibility(8);
            } else {
                this.fRu.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.au.q(this.fRr.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fRr.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fRv.setText(lastAdditionContent);
            } else {
                this.fRv.setVisibility(8);
            }
            bpr().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.fRr.getAlreadyCount()), Integer.valueOf(this.fRr.getTotalCount())));
            this.mName.setText(w.l.write_addition_title);
            return;
        }
        this.fRs.setVisibility(8);
    }

    private void bec() {
        this.fmm = findViewById(w.h.post_prefix_layout);
        this.fmj = (TextView) findViewById(w.h.post_prefix);
        this.fRk = findViewById(w.h.prefix_divider);
        this.fml = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fmm.setVisibility(0);
            this.fRk.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.flM = 1;
            this.fmm.setOnClickListener(new aj(this));
            this.fml = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.fml.setVisibility(0);
                this.fmj.setOnClickListener(new ak(this));
            }
            this.fmk = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fmk.a(this);
            this.fmk.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.fmk.setOutsideTouchable(true);
            this.fmk.setFocusable(true);
            this.fmk.setOnDismissListener(this);
            this.fmk.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.j(this.fmj, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.c(this.fml, w.g.icon_title_down);
            this.fmj.setTextColor(color);
            this.fQe.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fQe.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fmk.addView(aVar);
            }
            this.fmk.sK(0);
            this.fmj.setText(prefixs.get(1));
            te(1);
            return;
        }
        this.fmm.setVisibility(8);
    }

    private void bpn() {
        if (this.fRd && this.mData != null) {
            this.fRi.setVisibility(0);
            this.fRj.setVisibility(0);
            this.fRh = new FeedBackModel(this);
            this.fRh.rl(this.mData.getForumName());
            this.fRh.setLoadDataCallBack(new al(this));
        }
    }

    protected void bpo() {
        this.mPost.setOnClickListener(new am(this));
    }

    protected void bpp() {
        this.fRn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fRn.cE(getPageContext().getString(w.l.is_save_draft)).av(false).a(getPageContext().getString(w.l.save), new an(this)).b(getPageContext().getString(w.l.not_save), new ap(this));
        this.fRn.b(getPageContext());
    }

    protected void bed() {
        this.fPh = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.fPh.setIsRound(true);
        this.fPh.setDrawBorder(false);
        this.fPh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = com.baidu.tbadk.core.util.q.dn(currentPortrait);
            this.fPh.setUrl(dn);
            this.fPh.c(dn, 12, false);
        }
        this.fme = (EditText) findViewById(w.h.post_title);
        this.fme.setOnClickListener(this.fSl);
        this.fme.setOnFocusChangeListener(this.fmc);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fme.setText(this.mData.getTitle());
                this.fme.setSelection(this.mData.getTitle().length());
            } else if (this.fRf) {
                this.fme.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fme.addTextChangedListener(this.fSn);
        if (!this.mData.getHaveDraft()) {
            bpi();
            this.fRZ = true;
        }
    }

    private TextWatcher aSU() {
        ar arVar = new ar(this);
        if (this.fRP && this.fRQ) {
            if (this.fRN != null) {
                this.fRK.removeTextChangedListener(this.fRN);
            }
            this.fRN = arVar;
        } else if (this.fRP) {
            if (this.fRO != null) {
                this.fRG.removeTextChangedListener(this.fRO);
            }
            this.fRO = arVar;
        }
        return arVar;
    }

    private long h(EditText editText) {
        if (editText == this.fRG) {
            return 233L;
        }
        if (editText != this.fRK) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long h = h(editText);
            long f = h - f(editText);
            String valueOf = String.valueOf(f);
            if (h == 20) {
                if (f < 0) {
                    if (f < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bef() {
        this.fmi = (EditText) findViewById(w.h.post_content);
        this.fmi.setDrawingCacheEnabled(false);
        this.fmi.setOnClickListener(this.fSl);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString X = TbFaceManager.EI().X(getPageContext().getPageActivity(), this.mData.getContent());
            this.fmi.setText(X);
            this.fmi.setSelection(X.length());
        } else if (this.mData.getType() == 2) {
            if (this.fRo) {
                if (this.fRp != null && this.fRp.length() > 0) {
                    this.fmi.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.fRp}));
                    this.fmi.setSelection(this.fmi.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fmi.setText(format);
                this.fmi.setSelection(format.length());
            }
        }
        this.fmi.setOnFocusChangeListener(this.fmc);
        this.fmi.setOnTouchListener(new as(this));
        this.fmi.addTextChangedListener(this.fSo);
        lQ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fRP) {
            bpr().setPadding(0, 0, 0, 0);
            bpr().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.aq.k(bpr(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dHB) && this.fRr == null) {
                com.baidu.adp.lib.f.c.fL().a(this.dHB, 19, new at(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpq() {
        int i = 5000;
        if (this.fRr != null) {
            i = 1000;
        }
        return bpr().getText() != null && bpr().getText().length() >= i;
    }

    private void fr(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.fRb)) {
                this.fRb = "";
                bpr().requestFocus();
                if (bpr().getText() != null && bpr().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bpr().getSelectionStart();
                    editable = bpr().getText();
                }
            } else if ("from_title".equals(this.fRb)) {
                this.fRb = "";
                bps().requestFocus();
                if (bps().getText() != null && bps().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bps().getSelectionStart();
                    editable = bps().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bpr().getText().getSpans(0, bpr().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fRq == null) {
                this.fRq = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.fRq.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType yy = lVar.yy();
        if (name != null) {
            com.baidu.adp.lib.f.c.fL().a(name, 20, new au(this, new SpannableStringBuilder(name), yy), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bpr() != null) {
            Bitmap kR = aVar.kR();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
            int width = kR.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            bpr().getText().insert(i, spannableStringBuilder);
            Editable text = bpr().getText();
            if (text != null) {
                this.fSi.clear();
                this.fSi.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fSi);
                bpr().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bpr() {
        return this.fRP ? this.fRG : this.fmi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bps() {
        return this.fRP ? this.fRK : this.fme;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpt() {
        if (bpr() != null) {
            bpr().onKeyDown(67, this.fRl);
            int selectionStart = bpr().getSelectionStart();
            Editable text = bpr().getText();
            if (text != null) {
                this.fSi.clear();
                this.fSi.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fSi);
                bpr().setSelection(selectionStart);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.fRd = true;
        }
    }

    private void bpu() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bpv() {
        try {
            if (this.fRn != null) {
                this.fRn.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aIG.c(null);
        this.aIG.cZ(w.l.sending);
        this.aIG.aK(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aIG.aK(false);
    }

    private Boolean bpw() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aAU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bee() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bps() != null) {
                str = bps().getText().toString();
            }
            if (bpr() != null) {
                str2 = bpr().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.flM == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            lS(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        lS(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    lS(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fRP) {
                    lS(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lS(true);
                }
            }
            if (this.mData.getType() == 4) {
                lS(j(this.fRG) && i(this.fRK));
            } else if (this.mData.getType() == 5) {
                lS(j(this.fRG));
            } else if (!TextUtils.isEmpty(str2)) {
                lS(true);
            } else if (this.aAM != null) {
                lS(true);
            } else if (this.mData.getVideoInfo() != null) {
                lS(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                lS(true);
            } else {
                lS(false);
            }
        }
    }

    private void lS(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.aq.b(this.mPost, w.e.cp_link_tip_a, w.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean i(EditText editText) {
        long f = f(editText);
        return f <= 20 && f > 0;
    }

    private boolean j(EditText editText) {
        long f = f(editText);
        if (f > 233) {
            return false;
        }
        return f > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.aAP = new NewWriteModel(this);
        this.aAP.b(this.aBe);
        registerListener(this.fSj);
        this.mDialogCancelListener = new av(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fRd = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fRf = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fRo = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fRp = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fRr = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fRr != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fRw = bundle.getInt("mem_type", 0);
            this.ahM = bundle.getString("from");
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fSf = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fRd = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fRf = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fRo = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fRp = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fRr = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fRr != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fRw = intent.getIntExtra("mem_type", 0);
            this.ahM = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fSf = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.z.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.z.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            com.baidu.tieba.tbadkCore.z.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            com.baidu.tieba.tbadkCore.z.c(String.valueOf(this.mData.getForumId()) + "photolive", this);
        } else if (this.mData.getType() == 5) {
            com.baidu.tieba.tbadkCore.z.a(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(w.l.write_no_prefix));
        }
        this.dHB = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fRe = true;
        }
        bpj();
        try {
            this.fRR = bpC();
        } catch (Throwable th) {
            this.fRR = null;
        }
    }

    private void bpx() {
        this.fPh.setVisibility(8);
        this.fSb.setVisibility(0);
        this.fSc.setVisibility(0);
        if (this.mData.getType() != 7) {
            this.fme.setText(rm(this.mList.get(0).mTopicName));
            this.fme.setMovementMethod(com.baidu.tieba.view.g.bmm());
        }
        this.fSd.setText(this.mList.get(0).mForumName);
        this.fme.addTextChangedListener(new aw(this));
        this.fSe.setOnClickListener(new ax(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gb = com.baidu.tbadk.plugins.a.gb(rm(hotTopicBussinessData.mTopicName));
            if (gb != null) {
                this.fme.setText(gb);
            }
            this.fSd.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rm(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void a(WriteData writeData) {
        String str;
        String rm;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bps().getText().toString()) || this.fRZ || ((this.fRd || this.fRe) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.q(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.x.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            rm = this.mData.getTitle();
                        } else {
                            rm = rm(str);
                        }
                        SpannableString gb = com.baidu.tbadk.plugins.a.gb(rm);
                        if (gb != null) {
                            bps().setText(gb);
                            bps().setSelection(rm.length());
                        }
                    } else {
                        bps().setText(this.mData.getTitle());
                        bps().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bpi();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bpr().getText().toString()) || this.fRd || this.fRe) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.EI().a(getPageContext().getPageActivity(), this.mData.getContent(), this.fSk);
                    bpr().setText(a2);
                    bpr().setSelection(a2.length());
                    if (this.fRP) {
                        b(this.fRM, this.fRG);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bpB();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Eb();
                    }
                    lT(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bpy();
                }
                bee();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.fRx != null) {
                    this.fRB = this.fRy.bPO;
                    this.fRA = this.fRy.name;
                    int i = 0;
                    while (true) {
                        if (i == this.fRx.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bv bvVar = this.fRx.get(i);
                        if (categoryTo != bvVar.bPO) {
                            i++;
                        } else {
                            this.fRB = categoryTo;
                            this.fRA = bvVar.name;
                            this.mData.setCategoryTo(this.fRB);
                            break;
                        }
                    }
                    if (this.fRC != null) {
                        this.fRC.setText(this.fRA);
                        this.fRC.b(this.fRx, this.fRy, this.fRB);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.azd.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.azd.BC();
                return;
            }
            return;
        }
        bpy();
        bpi();
    }

    private void bpy() {
        if ((!this.fRP || this.fRE != null) && this.fRD != null) {
            this.fRE.c(this.writeImagesInfo);
            aBw();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fRo);
        if (this.fRd) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAN);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fRr);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fRw);
        bundle.putString("from", this.ahM);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bpr().getEditableText().toString();
        if (editable != null) {
            bpr().setText(TbFaceManager.EI().a(getPageContext().getPageActivity(), editable, this.fSk));
            bpr().setSelection(bpr().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boA() {
        bdW();
        String editable = bps().getText().toString();
        this.mData.setContent(bpr().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.flM != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.fmj.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fRd || this.fRe) {
            String string = getResources().getString(w.l.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
            }
            String str = String.valueOf(getResources().getString(w.l.app_name)) + getResources().getString(w.l.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.hj()) {
                    sb.append(com.baidu.adp.lib.util.i.hr());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.fRz >= 0) {
            this.mData.setCategoryFrom(this.fRz);
        }
        if (this.fRB >= 0) {
            this.mData.setCategoryTo(this.fRB);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aAO != null && this.aAO.PZ());
        this.aAP.lo(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.q(this.mList) && this.fSa != null && this.fSa.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.fSa.mForumId));
            this.mData.setForumName(this.fSa.mForumName);
        }
        this.aAP.setWriteData(this.mData);
        this.mData.setVcode(null);
        if (this.aAM != null) {
            if (this.aAM.getId() != null) {
                this.aAP.getWriteData().setVoice(this.aAM.getId());
                this.aAP.getWriteData().setVoiceDuringTime(this.aAM.duration);
            } else {
                this.aAP.getWriteData().setVoice(null);
                this.aAP.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aAP.getWriteData().setVoice(null);
            this.aAP.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aAP.bju()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aAP.startPostWrite();
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
            if (this.fRr != null) {
                i2 = this.fRr.getTotalCount();
                i = this.fRr.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(w.l.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.azd != null && !this.azd.Dq()) {
                    bpr().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra(IntentConfig.NAME_SHOW) : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            bpr().getText().insert(bpr().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0) {
                    com.baidu.tieba.tbadkCore.z.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    com.baidu.tieba.tbadkCore.z.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    com.baidu.tieba.tbadkCore.z.b(String.valueOf(this.mData.getForumId()) + "photolive", (WriteData) null);
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
                                aUq();
                            } else {
                                Y(intent);
                            }
                        } else if (intExtra == 1) {
                            S(intent);
                        } else {
                            X(intent);
                            com.baidu.adp.lib.g.h.fR().post(new ay(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fRP) {
                        B(intent);
                        bee();
                        return;
                    }
                    aa(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.azd.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.azd.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.azd.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bee();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.J(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fRc) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fRc = false;
                            }
                            sb2.append(stringExtra);
                            fr(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.q(this.mList) && !com.baidu.tbadk.core.util.x.q(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.fSa = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.fSa);
                }
            }
        } else if (i2 == 0) {
            if (this.azd != null && !this.azd.Dq()) {
                this.fmi.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DW();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bpA();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aAN = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAN);
                    return;
                case 12012:
                    bpA();
                    return;
                case 25004:
                    if ("from_title".equals(this.fRb)) {
                        bps().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fRb)) {
                        bpr().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bpz() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bpA() {
        if (this.fRP) {
            this.fRE.c(this.writeImagesInfo);
            aBw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        this.fRE.notifyDataSetChanged();
        this.fRD.invalidate();
        this.mHandler.postDelayed(new az(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bee();
    }

    private void X(Intent intent) {
        if (this.fRP) {
            aa(intent);
            bpA();
        } else {
            ab(intent);
        }
        bee();
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bpA();
            lT(true);
        }
    }

    private void Y(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aUq() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eNu.parseJson(stringExtra);
            this.eNu.updateQuality();
            if (this.eNu.getChosedFiles() != null && this.eNu.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eNu.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eNu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bps());
        HidenSoftKeyPad(this.mInputManager, bpr());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ab(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aAN = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAN, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bpB();
            Eb();
        }
        lT(true);
    }

    private void B(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bpB();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Eb();
                }
            }
            lT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpB() {
        if (this.azd.eB(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void DW() {
        new ba(this).execute(new Void[0]);
    }

    private void lT(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bMC == null) {
            this.bMC = VoiceManager.instance();
        }
        return this.bMC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Zp() {
        this.bMC = getVoiceManager();
        this.bMC.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rX(postWriteCallBackData.getErrorCode())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.fRr == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAW = i;
        if (this.azd != null) {
            this.azd.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.azd.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Eb() {
        if (!this.fRP && this.azd != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.azd.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.azd.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.azd.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.azd.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.azd != null) {
            this.azd.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void te(int i) {
        if (i < this.fQe.size()) {
            for (int i2 = 0; i2 < this.fQe.size(); i2++) {
                this.fQe.get(i2).lH(false);
            }
            this.fQe.get(i).lH(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void ru(int i) {
        this.flM = i;
        this.fmk.sK(i);
        te(i);
        this.fmj.setText(this.mPrefixData.getPrefixs().get(i));
        bee();
        com.baidu.adp.lib.g.j.a(this.fmk, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fmm.setSelected(false);
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
            com.baidu.adp.lib.util.k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mData != null) {
            if (this.mData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DR();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.aA(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAN);
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fRX && System.currentTimeMillis() - this.fRY < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fRX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fRU != null) {
            ro(str);
            this.fRU.dismiss();
        }
    }

    private void bP(Context context) {
        fRW = com.baidu.adp.lib.util.k.ag(context);
    }

    private void ro(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fRX = true;
        bpB();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Eb();
        }
        lT(true);
    }

    private static Bitmap c(String str, float f) {
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

    private File bpC() {
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

    private void bpD() {
        if (this.fRR != null && this.mData.getType() == 0) {
            bP(getActivity());
            this.fRT = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.fRT.setOnClickListener(new bc(this));
            this.fRS = (TbImageView) this.fRT.findViewById(w.h.rec_img_view);
            this.fRV = (LinearLayout) this.fRT.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.uL().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fRR.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.uL().putString("write_rec_pic_path", this.fRR.getAbsolutePath());
                Bitmap c = c(this.fRR.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.fRS.setImageBitmap(c);
                    this.fRS.setDrawBorder(true);
                    this.fRS.setBorderWidth(2);
                    this.fRS.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10264));
                    this.fRU = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.fRU.setCanceledOnTouchOutside(true);
                    this.fRU.setOnDismissListener(new bd(this));
                    this.fRU.setContentView(this.fRT);
                    this.fRU.show();
                    Window window = this.fRU.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (fRW / 18) + getResources().getDimensionPixelSize(w.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(w.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(w.f.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.fRc = false;
            this.fRb = "";
            if ("from_content".equals(str)) {
                this.fRb = "from_content";
            } else if ("from_title".equals(str)) {
                this.fRb = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                lR(false);
            }
        }
    }
}
