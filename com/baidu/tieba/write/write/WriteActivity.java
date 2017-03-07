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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
    private static int fQm = 0;
    private VoiceData.VoiceModel aAw;
    private String aAx;
    private LocationModel aAy;
    private NewWriteModel aAz;
    private String ahy;
    private com.baidu.tbadk.editortools.j ayN;
    private VoiceManager bMM;
    private View fPA;
    private Toast fPG;
    private AdditionData fPH;
    private RelativeLayout fPI;
    private TextView fPJ;
    private TextView fPK;
    private TextView fPL;
    List<com.baidu.tieba.frs.bt> fPN;
    com.baidu.tieba.frs.bt fPO;
    private int fPP;
    private String fPQ;
    private int fPR;
    private PostCategoryView fPS;
    private LinearLayout fPw;
    private View fPz;
    private com.baidu.tieba.view.c fQF;
    private HotTopicBussinessData fQq;
    private View fQr;
    private View fQs;
    private TextView fQt;
    private TextView fQu;
    private TextView fkB;
    private com.baidu.tieba.write.b fkC;
    private ImageView fkD;
    private View fkE;
    private int fke;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fPr = "";
    private boolean fPs = false;
    private WriteData mData = null;
    private boolean fPt = false;
    private boolean fPu = false;
    private boolean fPv = false;
    private InputMethodManager mInputManager = null;
    private EditText fkw = null;
    private HeadImageView fNy = null;
    private View fkx = null;
    private LinearLayout fkz = null;
    private EditText fkA = null;
    private FeedBackModel fPx = null;
    private FeedBackTopListView fPy = null;
    private ArrayList<com.baidu.tieba.write.a> fOu = new ArrayList<>();
    private String dLc = null;
    private final KeyEvent fPB = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View anY = null;
    private TextView fPC = null;
    private TextView mPost = null;
    private TextView bap = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fPD = null;
    private final Handler mHandler = new Handler();
    private boolean fPE = false;
    private String fPF = null;
    private RelativeLayout mParent = null;
    private String aAE = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aAG = 0;
    private int fPM = 0;
    private WriteImagesInfo ePz = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fPT = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fPU = null;
    private ScrollView fPV = null;
    private EditText fPW = null;
    private View fPX = null;
    private View fPY = null;
    private View fPZ = null;
    private EditText fQa = null;
    private TextView fQb = null;
    private TextView fQc = null;
    private TextWatcher fQd = null;
    private TextWatcher fQe = null;
    private boolean fQf = false;
    private boolean fQg = false;
    private com.baidu.tbadk.core.view.a aIq = null;
    private File fQh = null;
    private TbImageView fQi = null;
    private View fQj = null;
    private Dialog fQk = null;
    private LinearLayout fQl = null;
    private boolean fQn = false;
    private long fQo = -1000;
    private boolean fQp = false;
    private String fQv = "";
    private String fQw = "";
    private int fQx = 0;
    private SpannableStringBuilder fQy = new SpannableStringBuilder();
    private final HttpMessageListener fQz = new u(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fQA = new af(this);
    private final NewWriteModel.d aAO = new ar(this);
    private final LocationModel.a aAM = new bc(this);
    private final CustomMessageListener fwj = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fQB = new bg(this);
    private boolean fQC = true;
    private final View.OnFocusChangeListener fku = new bh(this);
    private TextWatcher fQD = new bi(this);
    private TextWatcher fQE = new bj(this);
    private final a.InterfaceC0073a esI = new v(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ahy)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dt() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(w.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Du();
        } else if (this.aAy.bin()) {
            Ds();
        } else {
            this.aAy.lj(false);
            b(1, true, null);
            this.aAy.bil();
        }
    }

    private void Du() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bW(w.l.location_app_permission_prompt).a(w.l.isopen, new w(this)).b(w.l.cancel, new x(this)).b(getPageContext());
        aVar.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bor() {
        int selectionEnd = boI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) boI().getText().getSpans(0, boI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = boI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = boI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        if (this.ayN != null) {
            this.ayN.setBarLauncherEnabled(!this.fQC);
            this.ayN.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fQf) {
            this.fkw.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.fPZ.setVisibility(8);
            } else {
                this.fPZ.setVisibility(0);
            }
            b(this.fQc, this.fPW);
            b(this.fQb, this.fQa);
            bds();
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
        boE();
        this.aAy = new LocationModel(this);
        this.aAy.a(this.aAM);
        registerListener(this.fwj);
        initEditor();
        boV();
        if (this.fQf) {
            this.fPU.setEditorTools(this.ayN);
        } else {
            this.fkw.requestFocus();
        }
    }

    private void initEditor() {
        this.ayN = new com.baidu.tbadk.editortools.j(getActivity());
        this.ayN.setBarMaxLauCount(5);
        this.ayN.setMoreButtonAtEnd(true);
        this.ayN.setBarLauncherType(1);
        this.ayN.bC(true);
        this.ayN.bB(true);
        this.ayN.setMoreLauncherIcon(w.g.write_more);
        this.ayN.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bov();
                break;
            default:
                bow();
                break;
        }
        this.ayN.CQ();
        if (this.fPw != null) {
            this.fPw.addView(this.ayN);
        }
        box();
        this.ayN.ml();
        com.baidu.tbadk.editortools.p ew = this.ayN.ew(6);
        if (ew != null && !TextUtils.isEmpty(this.aAE)) {
            ((View) ew).setOnClickListener(new y(this));
        }
        if (!this.fQf) {
            this.ayN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ayN.Bd();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("xiaoying_has_click", false)) {
            this.ayN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("hot_topic_has_click", false)) {
            this.ayN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bot() {
        this.fPX = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.fPZ = this.fPX.findViewById(w.h.live_post_title_container);
        this.fPW = (EditText) this.fPX.findViewById(w.h.live_post_content);
        this.fPT = (GridView) this.fPX.findViewById(w.h.photoLiveGridView);
        this.fQa = (EditText) this.fPX.findViewById(w.h.live_post_title);
        this.fQb = (TextView) this.fPX.findViewById(w.h.titleOverPlusNumber);
        this.fQc = (TextView) this.fPX.findViewById(w.h.contentOverPlusNumber);
        this.fPY = this.fPX.findViewById(w.h.live_interval_view);
        this.fQb.setText(String.valueOf(20));
        this.fQc.setText(String.valueOf(233));
        this.fPX.setVisibility(0);
        this.fQb.setVisibility(0);
        this.fQc.setVisibility(0);
        this.fQa.setHint(w.l.tips_title_limit_new);
        this.fQa.setOnFocusChangeListener(new z(this));
        if (this.mData.getType() == 4) {
            this.fPW.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.fPW.setHint(w.l.live_write_input_content_update);
        }
        this.fPW.setOnFocusChangeListener(new aa(this));
        this.fPW.requestFocus();
        this.fPW.addTextChangedListener(aSL());
        this.fQa.requestFocus();
        this.fQa.addTextChangedListener(aSL());
        this.fQa.setOnClickListener(this.fQB);
        this.fPW.setOnClickListener(this.fQB);
        this.fPU = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fPT);
        this.fPU.sW(6);
        this.fPT.setAdapter((ListAdapter) this.fPU);
        View findViewById = this.fPX.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ab(this));
        bou();
    }

    private void bou() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.fQa.setText(this.mData.getTitle());
                this.fQa.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fQf) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            boQ();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            DD();
            return;
        }
        if (this.ayN.CS()) {
            this.ayN.Bd();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fQf) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bov() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ayN.u(arrayList);
        com.baidu.tbadk.editortools.x ey = this.ayN.ey(5);
        if (ey != null) {
            ey.azt = 2;
            ey.azr = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.azr = w.g.write_at;
        this.ayN.b(aVar);
        this.ayN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bow() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        com.baidu.tbadk.editortools.x xVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.azr = w.g.write_picture;
        this.ayN.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.ayN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.ayN.b(aVar);
        aVar.azr = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar5 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar5.azv = true;
            xVar5.azr = w.g.write_graffiti;
            xVar5.azt = 4;
            this.ayN.b(xVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar4.azt = 5;
            xVar4.azr = w.g.write_privilege;
            this.ayN.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.azr = w.g.write_at;
        this.ayN.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar3.azv = true;
            xVar3.azt = 9;
            xVar3.azr = 0;
            this.ayN.b(xVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask5 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask5.getData()) != null) {
            xVar2.azv = true;
            xVar2.azt = 10;
            xVar2.azr = 0;
            this.ayN.b(xVar2);
        }
        Boolean boN = boN();
        if (!this.fPt && boN != null && boN.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.biI() && com.baidu.tieba.tbadkCore.s.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.azt = 6;
            xVar.azr = w.g.write_recorder;
            this.ayN.b(xVar);
        }
        if (this.fPH == null) {
            this.ayN.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.ayN.u(arrayList);
        com.baidu.tbadk.editortools.x ey = this.ayN.ey(5);
        if (ey != null) {
            ey.azt = 1;
            ey.azr = w.g.write_emotion;
        }
    }

    private void box() {
        ac acVar = new ac(this);
        this.ayN.a(16, acVar);
        this.ayN.a(14, acVar);
        this.ayN.a(24, acVar);
        this.ayN.a(3, acVar);
        this.ayN.a(10, acVar);
        this.ayN.a(11, acVar);
        this.ayN.a(12, acVar);
        this.ayN.a(13, acVar);
        this.ayN.a(15, acVar);
        this.ayN.a(18, acVar);
        this.ayN.a(25, acVar);
        this.ayN.a(27, acVar);
        this.ayN.a(29, acVar);
        this.ayN.a(40, acVar);
        this.ayN.a(43, acVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        if (this.aAy.PB()) {
            if (this.aAy.bin()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bij().getLocationData().bif());
                return;
            }
            b(1, true, null);
            this.aAy.bil();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdk() {
        if (this.aAz != null) {
            this.aAz.cancelLoadData();
        }
        if (this.fPx != null) {
            this.fPx.cancelLoadData();
        }
        if (this.aAy != null) {
            this.aAy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bdk();
        boM();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnQ() {
        if (this.mData != null && this.mData.getType() == 2 && this.fPE) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(boJ().getText().toString());
            this.mData.setContent(boI().getText().toString());
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
            if (this.fkC != null && this.fkC.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fkC, getPageContext().getPageActivity());
                return true;
            } else if (this.ayN.CS()) {
                this.ayN.Bd();
                return true;
            } else {
                bdk();
                bnQ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.fQl);
        if (this.fQi != null && i == 1) {
            this.fQi.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_link_tip_a, 1);
        bos();
        com.baidu.tbadk.core.util.aq.k(this.fPX, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.fkx, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.fPY, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(boJ(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dLc)) {
            com.baidu.tbadk.core.util.aq.k(boI(), w.e.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e);
        boJ().setTextColor(color);
        boI().setTextColor(color);
        a(boJ(), color2);
        a(boI(), color2);
        bds();
        this.ayN.onChangeSkinType(i);
        if (this.fPS != null) {
            this.fPS.wP();
        }
        com.baidu.tbadk.core.util.aq.i((View) this.bap, w.e.cp_cont_f);
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
        this.aIq = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fQf = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(w.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.anY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.anY != null && (this.anY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.anY.getLayoutParams();
            layoutParams2.width = -2;
            this.anY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.icon_nav_close_selector, w.g.icon_nav_close_selector);
        this.bap = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.aq.i((View) this.bap, w.e.cp_cont_f);
        this.fPC = (TextView) findViewById(w.h.btn_image_problem);
        boy();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds10);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fku);
        this.fPV = (ScrollView) findViewById(w.h.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fPy = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.fPz = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.fPw = (LinearLayout) findViewById(w.h.tool_view);
        this.fPw.setContentDescription("..");
        this.fkx = findViewById(w.h.interval_view);
        this.fQr = findViewById(w.h.hot_topic_fourm_view);
        this.fQs = findViewById(w.h.hot_topic_divider);
        this.fQt = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.fQu = (TextView) findViewById(w.h.change_one_tv);
        bdr();
        if (this.fQf) {
            this.fPV.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bot();
        }
        bdt();
        if (this.fPt || this.fPu) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().agZ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fkz = (LinearLayout) findViewById(w.h.post_content_container);
        this.fkz.setDrawingCacheEnabled(false);
        this.fkz.setOnClickListener(new ad(this));
        this.anY.setOnFocusChangeListener(this.fku);
        this.anY.setOnClickListener(new ae(this));
        this.fPC.setOnClickListener(new ag(this));
        boB();
        k(boN());
        boF();
        switch (this.mData.getType()) {
            case 0:
                if (this.fPt || this.fPu) {
                    if (this.fPv) {
                        this.bap.setText(w.l.feedback_vcode);
                    } else {
                        this.bap.setText(w.l.feedback);
                    }
                } else {
                    this.bap.setText(w.l.post_new_thread);
                }
                this.fkw.setVisibility(0);
                this.fkA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.bap.setText(w.l.send_reply);
                this.fkA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fkw.setVisibility(8);
                break;
            case 4:
                this.bap.setText(w.l.publish_photo_live);
                this.fkA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.bap.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.fPY.setVisibility(8);
                break;
            case 7:
                this.fkw.setVisibility(0);
                this.fkA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.bap.setText(w.l.post_drift_bottle);
                break;
        }
        boG();
        boL();
        bos();
        boD();
        bdq();
        if (com.baidu.tbadk.core.util.x.q(this.mList) || this.mList.get(0) == null) {
            this.fkw.getPaint().setFakeBoldText(true);
        } else {
            this.fkw.getPaint().setFakeBoldText(false);
            boO();
        }
        if (this.mData.getType() == 4 && this.fkE != null && this.fPA != null) {
            this.fkE.setVisibility(8);
            this.fPA.setVisibility(8);
        }
        bds();
        ShowSoftKeyPad(this.mInputManager, this.fkw);
        boC();
    }

    private void boy() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
        } else {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
        }
    }

    private void boz() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fPt && !this.fPu && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.au.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && boJ() != null) {
                boJ().setText(c);
                boJ().setSelection(c.length());
            }
        }
    }

    private void boA() {
        this.fPN = null;
        this.fPP = -1;
        this.fPR = -1;
        com.baidu.tieba.frs.bv hR = com.baidu.tieba.frs.bu.aad().hR(1);
        if (hR != null) {
            this.fPN = hR.bQd;
            this.fPP = getIntent().getIntExtra("category_id", -1);
            if (this.fPN != null && !this.fPN.isEmpty() && this.fPP >= 0) {
                this.fPO = new com.baidu.tieba.frs.bt();
                this.fPO.bPZ = 0;
                this.fPO.name = getPageContext().getResources().getString(w.l.category_auto);
                this.fPR = this.fPO.bPZ;
                this.fPQ = this.fPO.name;
                for (com.baidu.tieba.frs.bt btVar : this.fPN) {
                    if (btVar.bPZ == this.fPP) {
                        this.fPR = btVar.bPZ;
                        this.fPQ = btVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void boB() {
        if (this.fPN != null && !this.fPN.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.fPS = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.fPS.setText(this.fPQ);
            this.fPS.b(this.fPN, this.fPO, this.fPR);
            this.fPS.setCategoryContainerClickCallback(new ah(this));
            linearLayout.setOnClickListener(new ai(this));
        }
    }

    private void boC() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fQF = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new aj(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fQF.setTitle(w.l.no_disturb_start_time);
        this.fQF.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.fQF);
        this.fQF.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.fQF);
        return this.fQF;
    }

    private void boD() {
        this.fPI = (RelativeLayout) findViewById(w.h.addition_container);
        this.fPJ = (TextView) findViewById(w.h.addition_create_time);
        this.fPK = (TextView) findViewById(w.h.addition_last_time);
        this.fPL = (TextView) findViewById(w.h.addition_last_content);
        if (this.fPH != null) {
            this.fPI.setVisibility(0);
            this.fPJ.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.au.q(this.fPH.getCreateTime() * 1000));
            if (this.fPH.getAlreadyCount() == 0) {
                this.fPK.setVisibility(8);
            } else {
                this.fPK.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.au.q(this.fPH.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fPH.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fPL.setText(lastAdditionContent);
            } else {
                this.fPL.setVisibility(8);
            }
            boI().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.fPH.getAlreadyCount()), Integer.valueOf(this.fPH.getTotalCount())));
            this.bap.setText(w.l.write_addition_title);
            return;
        }
        this.fPI.setVisibility(8);
    }

    private void bdq() {
        this.fkE = findViewById(w.h.post_prefix_layout);
        this.fkB = (TextView) findViewById(w.h.post_prefix);
        this.fPA = findViewById(w.h.prefix_divider);
        this.fkD = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fkE.setVisibility(0);
            this.fPA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fke = 1;
            this.fkE.setOnClickListener(new ak(this));
            this.fkD = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.fkD.setVisibility(0);
                this.fkB.setOnClickListener(new al(this));
            }
            this.fkC = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fkC.a(this);
            this.fkC.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.fkC.setOutsideTouchable(true);
            this.fkC.setFocusable(true);
            this.fkC.setOnDismissListener(this);
            this.fkC.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.j(this.fkB, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.c(this.fkD, w.g.icon_title_down);
            this.fkB.setTextColor(color);
            this.fOu.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fOu.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fkC.addView(aVar);
            }
            this.fkC.sM(0);
            this.fkB.setText(prefixs.get(1));
            tg(1);
            return;
        }
        this.fkE.setVisibility(8);
    }

    private void boE() {
        if (this.fPt && this.mData != null) {
            this.fPy.setVisibility(0);
            this.fPz.setVisibility(0);
            this.fPx = new FeedBackModel(this);
            this.fPx.qS(this.mData.getForumName());
            this.fPx.setLoadDataCallBack(new am(this));
        }
    }

    protected void boF() {
        this.mPost.setOnClickListener(new an(this));
    }

    protected void boG() {
        this.fPD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fPD.cx(getPageContext().getString(w.l.is_save_draft)).at(false).a(getPageContext().getString(w.l.save), new ao(this)).b(getPageContext().getString(w.l.not_save), new aq(this));
        this.fPD.b(getPageContext());
    }

    protected void bdr() {
        this.fNy = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.fNy.setIsRound(true);
        this.fNy.setDrawBorder(false);
        this.fNy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dg = com.baidu.tbadk.core.util.q.dg(currentPortrait);
            this.fNy.setUrl(dg);
            this.fNy.c(dg, 12, false);
        }
        this.fkw = (EditText) findViewById(w.h.post_title);
        this.fkw.setOnClickListener(this.fQB);
        this.fkw.setOnFocusChangeListener(this.fku);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fkw.setText(this.mData.getTitle());
                this.fkw.setSelection(this.mData.getTitle().length());
            } else if (this.fPv) {
                this.fkw.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fkw.addTextChangedListener(this.fQD);
        if (!this.mData.getHaveDraft()) {
            boz();
            this.fQp = true;
        }
    }

    private TextWatcher aSL() {
        as asVar = new as(this);
        if (this.fQf && this.fQg) {
            if (this.fQd != null) {
                this.fQa.removeTextChangedListener(this.fQd);
            }
            this.fQd = asVar;
        } else if (this.fQf) {
            if (this.fQe != null) {
                this.fPW.removeTextChangedListener(this.fQe);
            }
            this.fQe = asVar;
        }
        return asVar;
    }

    private long h(EditText editText) {
        if (editText == this.fPW) {
            return 233L;
        }
        if (editText != this.fQa) {
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

    protected void bdt() {
        this.fkA = (EditText) findViewById(w.h.post_content);
        this.fkA.setDrawingCacheEnabled(false);
        this.fkA.setOnClickListener(this.fQB);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.Ek().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.fkA.setText(T);
            this.fkA.setSelection(T.length());
        } else if (this.mData.getType() == 2) {
            if (this.fPE) {
                if (this.fPF != null && this.fPF.length() > 0) {
                    this.fkA.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.fPF}));
                    this.fkA.setSelection(this.fkA.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fkA.setText(format);
                this.fkA.setSelection(format.length());
            }
        }
        this.fkA.setOnFocusChangeListener(this.fku);
        this.fkA.setOnTouchListener(new at(this));
        this.fkA.addTextChangedListener(this.fQE);
        lN(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fQf) {
            boI().setPadding(0, 0, 0, 0);
            boI().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.aq.k(boI(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dLc) && this.fPH == null) {
                com.baidu.adp.lib.f.c.fG().a(this.dLc, 19, new au(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boH() {
        int i = 5000;
        if (this.fPH != null) {
            i = 1000;
        }
        return boI().getText() != null && boI().getText().length() >= i;
    }

    private void fl(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.fPr)) {
                this.fPr = "";
                boI().requestFocus();
                if (boI().getText() != null && boI().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = boI().getSelectionStart();
                    editable = boI().getText();
                }
            } else if ("from_title".equals(this.fPr)) {
                this.fPr = "";
                boJ().requestFocus();
                if (boJ().getText() != null && boJ().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = boJ().getSelectionStart();
                    editable = boJ().getText();
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
    public void lO(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) boI().getText().getSpans(0, boI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fPG == null) {
                this.fPG = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.fPG.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType ya = lVar.ya();
        if (name != null) {
            com.baidu.adp.lib.f.c.fG().a(name, 20, new av(this, new SpannableStringBuilder(name), ya), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && boI() != null) {
            Bitmap kN = aVar.kN();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
            int width = kN.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            boI().getText().insert(i, spannableStringBuilder);
            Editable text = boI().getText();
            if (text != null) {
                this.fQy.clear();
                this.fQy.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fQy);
                boI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText boI() {
        return this.fQf ? this.fPW : this.fkA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText boJ() {
        return this.fQf ? this.fQa : this.fkw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boK() {
        if (boI() != null) {
            boI().onKeyDown(67, this.fPB);
            int selectionStart = boI().getSelectionStart();
            Editable text = boI().getText();
            if (text != null) {
                this.fQy.clear();
                this.fQy.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fQy);
                boI().setSelection(selectionStart);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.fPt = true;
        }
    }

    private void boL() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void boM() {
        try {
            if (this.fPD != null) {
                this.fPD.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aIq.c(null);
        this.aIq.cW(w.l.sending);
        this.aIq.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aIq.aI(false);
    }

    private Boolean boN() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aAE = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bds() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (boJ() != null) {
                str = boJ().getText().toString();
            }
            if (boI() != null) {
                str2 = boI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fke == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            lP(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        lP(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    lP(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fQf) {
                    lP(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lP(true);
                }
            }
            if (this.mData.getType() == 4) {
                lP(j(this.fPW) && i(this.fQa));
            } else if (this.mData.getType() == 5) {
                lP(j(this.fPW));
            } else if (!TextUtils.isEmpty(str2)) {
                lP(true);
            } else if (this.aAw != null) {
                lP(true);
            } else if (this.mData.getVideoInfo() != null) {
                lP(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                lP(true);
            } else {
                lP(false);
            }
        }
    }

    private void lP(boolean z) {
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
        this.aAz = new NewWriteModel(this);
        this.aAz.b(this.aAO);
        registerListener(this.fQz);
        this.mDialogCancelListener = new aw(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fPt = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fPv = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fPE = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fPF = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fPH = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fPH != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fPM = bundle.getInt("mem_type", 0);
            this.ahy = bundle.getString("from");
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fQv = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fPt = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fPv = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fPE = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fPF = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fPH = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fPH != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fPM = intent.getIntExtra("mem_type", 0);
            this.ahy = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fQv = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
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
        this.dLc = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fPu = true;
        }
        boA();
        try {
            this.fQh = boU();
        } catch (Throwable th) {
            this.fQh = null;
        }
    }

    private void boO() {
        this.fNy.setVisibility(8);
        this.fQr.setVisibility(0);
        this.fQs.setVisibility(0);
        if (this.mData.getType() != 7) {
            this.fkw.setText(qT(this.mList.get(0).mTopicName));
            this.fkw.setMovementMethod(com.baidu.tieba.view.g.blC());
        }
        this.fQt.setText(this.mList.get(0).mForumName);
        this.fkw.addTextChangedListener(new ax(this));
        this.fQu.setOnClickListener(new ay(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString fV = com.baidu.tbadk.plugins.a.fV(qT(hotTopicBussinessData.mTopicName));
            if (fV != null) {
                this.fkw.setText(fV);
            }
            this.fQt.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String qT(String str) {
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
        String qT;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(boJ().getText().toString()) || this.fQp || ((this.fPt || this.fPu) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.q(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.x.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            qT = this.mData.getTitle();
                        } else {
                            qT = qT(str);
                        }
                        SpannableString fV = com.baidu.tbadk.plugins.a.fV(qT);
                        if (fV != null) {
                            boJ().setText(fV);
                            boJ().setSelection(qT.length());
                        }
                    } else {
                        boJ().setText(this.mData.getTitle());
                        boJ().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    boz();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ayN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(boI().getText().toString()) || this.fPt || this.fPu) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ek().a(getPageContext().getPageActivity(), this.mData.getContent(), this.fQA);
                    boI().setText(a2);
                    boI().setSelection(a2.length());
                    if (this.fQf) {
                        b(this.fQc, this.fPW);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    boT();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DD();
                    }
                    lQ(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    boP();
                }
                bds();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.fPN != null) {
                    this.fPR = this.fPO.bPZ;
                    this.fPQ = this.fPO.name;
                    int i = 0;
                    while (true) {
                        if (i == this.fPN.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bt btVar = this.fPN.get(i);
                        if (categoryTo != btVar.bPZ) {
                            i++;
                        } else {
                            this.fPR = categoryTo;
                            this.fPQ = btVar.name;
                            this.mData.setCategoryTo(this.fPR);
                            break;
                        }
                    }
                    if (this.fPS != null) {
                        this.fPS.setText(this.fPQ);
                        this.fPS.b(this.fPN, this.fPO, this.fPR);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.ayN.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.ayN.Bd();
                return;
            }
            return;
        }
        boP();
        boz();
    }

    private void boP() {
        if ((!this.fQf || this.fPU != null) && this.fPT != null) {
            this.fPU.c(this.writeImagesInfo);
            boS();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fPE);
        if (this.fPt) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAx);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fPH);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fPM);
        bundle.putString("from", this.ahy);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = boI().getEditableText().toString();
        if (editable != null) {
            boI().setText(TbFaceManager.Ek().a(getPageContext().getPageActivity(), editable, this.fQA));
            boI().setSelection(boI().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnR() {
        bdk();
        String editable = boJ().getText().toString();
        this.mData.setContent(boI().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fke != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.fkB.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fPt || this.fPu) {
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
                if (com.baidu.adp.lib.util.i.he()) {
                    sb.append(com.baidu.adp.lib.util.i.hm());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.fPP >= 0) {
            this.mData.setCategoryFrom(this.fPP);
        }
        if (this.fPR >= 0) {
            this.mData.setCategoryTo(this.fPR);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aAy != null && this.aAy.PB());
        this.aAz.ll(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.q(this.mList) && this.fQq != null && this.fQq.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.fQq.mForumId));
            this.mData.setForumName(this.fQq.mForumName);
        }
        this.aAz.setWriteData(this.mData);
        this.mData.setVcode(null);
        if (this.aAw != null) {
            if (this.aAw.getId() != null) {
                this.aAz.getWriteData().setVoice(this.aAw.getId());
                this.aAz.getWriteData().setVoiceDuringTime(this.aAw.duration);
            } else {
                this.aAz.getWriteData().setVoice(null);
                this.aAz.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aAz.getWriteData().setVoice(null);
            this.aAz.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aAz.biJ()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.he()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aAz.startPostWrite();
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
            if (this.fPH != null) {
                i2 = this.fPH.getTotalCount();
                i = this.fPH.getAlreadyCount() + 1;
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
                if (this.ayN != null && !this.ayN.CS()) {
                    boI().requestFocus();
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
                            boI().getText().insert(boI().getSelectionStart(), sb.toString());
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
                                aUh();
                            } else {
                                Y(intent);
                            }
                        } else if (intExtra == 1) {
                            S(intent);
                        } else {
                            X(intent);
                            com.baidu.adp.lib.g.h.fM().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fQf) {
                        B(intent);
                        bds();
                        return;
                    }
                    aa(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ayN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ayN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ayN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bds();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.J(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fPs) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fPs = false;
                            }
                            sb2.append(stringExtra);
                            fl(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.q(this.mList) && !com.baidu.tbadk.core.util.x.q(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.fQq = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.fQq);
                }
            }
        } else if (i2 == 0) {
            if (this.ayN != null && !this.ayN.CS()) {
                this.fkA.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dy();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    boR();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aAx = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAx);
                    return;
                case 12012:
                    boR();
                    return;
                case 25004:
                    if ("from_title".equals(this.fPr)) {
                        boJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fPr)) {
                        boI().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void boQ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void boR() {
        if (this.fQf) {
            this.fPU.c(this.writeImagesInfo);
            boS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boS() {
        this.fPU.notifyDataSetChanged();
        this.fPT.invalidate();
        this.mHandler.postDelayed(new ba(this), 550L);
    }

    public void o(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bds();
    }

    private void X(Intent intent) {
        if (this.fQf) {
            aa(intent);
            boR();
        } else {
            ab(intent);
        }
        bds();
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            boR();
            lQ(true);
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

    private void aUh() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.ePz.parseJson(stringExtra);
            this.ePz.updateQuality();
            if (this.ePz.getChosedFiles() != null && this.ePz.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ePz.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.ePz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, boJ());
        HidenSoftKeyPad(this.mInputManager, boI());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ab(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aAx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAx, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            boT();
            DD();
        }
        lQ(true);
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
                boT();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DD();
                }
            }
            lQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boT() {
        if (this.ayN.ey(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void Dy() {
        new bb(this).execute(new Void[0]);
    }

    private void lQ(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bMM == null) {
            this.bMM = VoiceManager.instance();
        }
        return this.bMM;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void YT() {
        this.bMM = getVoiceManager();
        this.bMM.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.rZ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.an(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.fPH == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAG = i;
        if (this.ayN != null) {
            this.ayN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.ayN.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DD() {
        if (!this.fQf && this.ayN != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.ayN.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.ayN.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ayN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ayN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (this.ayN != null) {
            this.ayN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tg(int i) {
        if (i < this.fOu.size()) {
            for (int i2 = 0; i2 < this.fOu.size(); i2++) {
                this.fOu.get(i2).lE(false);
            }
            this.fOu.get(i).lE(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rw(int i) {
        this.fke = i;
        this.fkC.sM(i);
        tg(i);
        this.fkB.setText(this.mPrefixData.getPrefixs().get(i));
        bds();
        com.baidu.adp.lib.g.j.a(this.fkC, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fkE.setSelected(false);
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
            Dt();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ae.ay(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAx);
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
        if (this.fQn && System.currentTimeMillis() - this.fQo < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fQn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fQk != null) {
            qV(str);
            this.fQk.dismiss();
        }
    }

    private void bV(Context context) {
        fQm = com.baidu.adp.lib.util.k.ah(context);
    }

    private void qV(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fQn = true;
        boT();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DD();
        }
        lQ(true);
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

    private File boU() {
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

    private void boV() {
        if (this.fQh != null && this.mData.getType() == 0) {
            bV(getActivity());
            this.fQj = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.fQj.setOnClickListener(new bd(this));
            this.fQi = (TbImageView) this.fQj.findViewById(w.h.rec_img_view);
            this.fQl = (LinearLayout) this.fQj.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.uo().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fQh.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.uo().putString("write_rec_pic_path", this.fQh.getAbsolutePath());
                Bitmap c = c(this.fQh.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.fQi.setImageBitmap(c);
                    this.fQi.setDrawBorder(true);
                    this.fQi.setBorderWidth(2);
                    this.fQi.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10264));
                    this.fQk = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.fQk.setCanceledOnTouchOutside(true);
                    this.fQk.setOnDismissListener(new be(this));
                    this.fQk.setContentView(this.fQj);
                    this.fQk.show();
                    Window window = this.fQk.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (fQm / 18) + getResources().getDimensionPixelSize(w.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(w.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(w.f.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(w.a.activity_open_from_bottom, w.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.fPs = false;
            this.fPr = "";
            if ("from_content".equals(str)) {
                this.fPr = "from_content";
            } else if ("from_title".equals(str)) {
                this.fPr = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                lO(false);
            }
        }
    }
}
