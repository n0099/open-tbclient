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
    private static int fUs = 0;
    private VoiceData.VoiceModel aAO;
    private String aAP;
    private LocationModel aAQ;
    private NewWriteModel aAR;
    private String ahN;
    private com.baidu.tbadk.editortools.j azf;
    private VoiceManager bOT;
    private LinearLayout fTC;
    private View fTF;
    private View fTG;
    private Toast fTM;
    private AdditionData fTN;
    private RelativeLayout fTO;
    private TextView fTP;
    private TextView fTQ;
    private TextView fTR;
    List<com.baidu.tieba.frs.bv> fTT;
    com.baidu.tieba.frs.bv fTU;
    private int fTV;
    private String fTW;
    private int fTX;
    private PostCategoryView fTY;
    private TextView fUA;
    private com.baidu.tieba.view.c fUL;
    private HotTopicBussinessData fUw;
    private View fUx;
    private View fUy;
    private TextView fUz;
    private TextView foB;
    private com.baidu.tieba.write.b foC;
    private ImageView foD;
    private View foE;
    private int fod;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fTx = "";
    private boolean fTy = false;
    private WriteData mData = null;
    private boolean fTz = false;
    private boolean fTA = false;
    private boolean fTB = false;
    private InputMethodManager mInputManager = null;
    private EditText fow = null;
    private HeadImageView fRD = null;
    private View fox = null;
    private LinearLayout foz = null;
    private EditText foA = null;
    private FeedBackModel fTD = null;
    private FeedBackTopListView fTE = null;
    private ArrayList<com.baidu.tieba.write.a> fSA = new ArrayList<>();
    private String dJR = null;
    private final KeyEvent fTH = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aom = null;
    private TextView fTI = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fTJ = null;
    private final Handler mHandler = new Handler();
    private boolean fTK = false;
    private String fTL = null;
    private RelativeLayout mParent = null;
    private String aAW = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aAY = 0;
    private int fTS = 0;
    private WriteImagesInfo ePK = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fTZ = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fUa = null;
    private ScrollView fUb = null;
    private EditText fUc = null;
    private View fUd = null;
    private View fUe = null;
    private View fUf = null;
    private EditText fUg = null;
    private TextView fUh = null;
    private TextView fUi = null;
    private TextWatcher fUj = null;
    private TextWatcher fUk = null;
    private boolean fUl = false;
    private boolean fUm = false;
    private com.baidu.tbadk.core.view.a aII = null;
    private File fUn = null;
    private TbImageView fUo = null;
    private View fUp = null;
    private Dialog fUq = null;
    private LinearLayout fUr = null;
    private boolean fUt = false;
    private long fUu = -1000;
    private boolean fUv = false;
    private String fUB = "";
    private String fUC = "";
    private int fUD = 0;
    private SpannableStringBuilder fUE = new SpannableStringBuilder();
    private final HttpMessageListener fUF = new t(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fUG = new ae(this);
    private final NewWriteModel.d aBg = new aq(this);
    private final LocationModel.a aBe = new bb(this);
    private final CustomMessageListener fAj = new be(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fUH = new bf(this);
    private boolean fUI = true;
    private final View.OnFocusChangeListener fou = new bg(this);
    private TextWatcher fUJ = new bh(this);
    private TextWatcher fUK = new bi(this);
    private final a.InterfaceC0072a etj = new u(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ahN)) {
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
        } else if (this.aAQ.bjZ()) {
            DQ();
        } else {
            this.aAQ.lw(false);
            b(1, true, null);
            this.aAQ.bjX();
        }
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new v(this)).b(w.l.cancel, new w(this)).b(getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bqb() {
        int selectionEnd = bqs().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bqs().getText().getSpans(0, bqs().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bqs().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bqs().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqc() {
        if (this.azf != null) {
            this.azf.setBarLauncherEnabled(!this.fUI);
            this.azf.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fUl) {
            this.fow.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.fUf.setVisibility(8);
            } else {
                this.fUf.setVisibility(0);
            }
            b(this.fUi, this.fUc);
            b(this.fUh, this.fUg);
            bfg();
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
        bqo();
        this.aAQ = new LocationModel(this);
        this.aAQ.a(this.aBe);
        registerListener(this.fAj);
        initEditor();
        bqE();
        if (this.fUl) {
            this.fUa.setEditorTools(this.azf);
        } else {
            this.fow.requestFocus();
        }
    }

    private void initEditor() {
        this.azf = new com.baidu.tbadk.editortools.j(getActivity());
        this.azf.setBarMaxLauCount(5);
        this.azf.setMoreButtonAtEnd(true);
        this.azf.setBarLauncherType(1);
        this.azf.bE(true);
        this.azf.bD(true);
        this.azf.setMoreLauncherIcon(w.g.write_more);
        this.azf.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bqf();
                break;
            default:
                bqg();
                break;
        }
        this.azf.Do();
        if (this.fTC != null) {
            this.fTC.addView(this.azf);
        }
        bqh();
        this.azf.mp();
        com.baidu.tbadk.editortools.p ez = this.azf.ez(6);
        if (ez != null && !TextUtils.isEmpty(this.aAW)) {
            ((View) ez).setOnClickListener(new x(this));
        }
        if (!this.fUl) {
            this.azf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.azf.BC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("xiaoying_has_click", false)) {
            this.azf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("hot_topic_has_click", false)) {
            this.azf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bqd() {
        this.fUd = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.fUf = this.fUd.findViewById(w.h.live_post_title_container);
        this.fUc = (EditText) this.fUd.findViewById(w.h.live_post_content);
        this.fTZ = (GridView) this.fUd.findViewById(w.h.photoLiveGridView);
        this.fUg = (EditText) this.fUd.findViewById(w.h.live_post_title);
        this.fUh = (TextView) this.fUd.findViewById(w.h.titleOverPlusNumber);
        this.fUi = (TextView) this.fUd.findViewById(w.h.contentOverPlusNumber);
        this.fUe = this.fUd.findViewById(w.h.live_interval_view);
        this.fUh.setText(String.valueOf(20));
        this.fUi.setText(String.valueOf(233));
        this.fUd.setVisibility(0);
        this.fUh.setVisibility(0);
        this.fUi.setVisibility(0);
        this.fUg.setHint(w.l.tips_title_limit_new);
        this.fUg.setOnFocusChangeListener(new y(this));
        if (this.mData.getType() == 4) {
            this.fUc.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.fUc.setHint(w.l.live_write_input_content_update);
        }
        this.fUc.setOnFocusChangeListener(new z(this));
        this.fUc.requestFocus();
        this.fUc.addTextChangedListener(aTV());
        this.fUg.requestFocus();
        this.fUg.addTextChangedListener(aTV());
        this.fUg.setOnClickListener(this.fUH);
        this.fUc.setOnClickListener(this.fUH);
        this.fUa = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fTZ);
        this.fUa.ta(6);
        this.fTZ.setAdapter((ListAdapter) this.fUa);
        View findViewById = this.fUd.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new aa(this));
        bqe();
    }

    private void bqe() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.fUg.setText(this.mData.getTitle());
                this.fUg.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fUl) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bqA();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Eb();
            return;
        }
        if (this.azf.Dq()) {
            this.azf.BC();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fUl) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bqf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.azf.u(arrayList);
        com.baidu.tbadk.editortools.x eB = this.azf.eB(5);
        if (eB != null) {
            eB.azL = 2;
            eB.azJ = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.azJ = w.g.write_at;
        this.azf.b(aVar);
        this.azf.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bqg() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        com.baidu.tbadk.editortools.x xVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.azJ = w.g.write_picture;
        this.azf.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.azf.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.azf.b(aVar);
        aVar.azJ = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar5 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar5.azN = true;
            xVar5.azJ = w.g.write_graffiti;
            xVar5.azL = 4;
            this.azf.b(xVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar4.azL = 5;
            xVar4.azJ = w.g.write_privilege;
            this.azf.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.azJ = w.g.write_at;
        this.azf.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar3.azN = true;
            xVar3.azL = 9;
            xVar3.azJ = 0;
            this.azf.b(xVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask5 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask5.getData()) != null) {
            xVar2.azN = true;
            xVar2.azL = 10;
            xVar2.azJ = 0;
            this.azf.b(xVar2);
        }
        Boolean bqx = bqx();
        if (!this.fTz && bqx != null && bqx.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bku() && com.baidu.tieba.tbadkCore.s.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.azL = 6;
            xVar.azJ = w.g.write_recorder;
            this.azf.b(xVar);
        }
        if (this.fTN == null) {
            this.azf.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.azf.u(arrayList);
        com.baidu.tbadk.editortools.x eB = this.azf.eB(5);
        if (eB != null) {
            eB.azL = 1;
            eB.azJ = w.g.write_emotion;
        }
    }

    private void bqh() {
        ab abVar = new ab(this);
        this.azf.a(16, abVar);
        this.azf.a(14, abVar);
        this.azf.a(24, abVar);
        this.azf.a(3, abVar);
        this.azf.a(10, abVar);
        this.azf.a(11, abVar);
        this.azf.a(12, abVar);
        this.azf.a(13, abVar);
        this.azf.a(15, abVar);
        this.azf.a(18, abVar);
        this.azf.a(25, abVar);
        this.azf.a(27, abVar);
        this.azf.a(29, abVar);
        this.azf.a(40, abVar);
        this.azf.a(43, abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT() {
        if (this.aAQ.QZ()) {
            if (this.aAQ.bjZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.d.bjV().getLocationData().bjR());
                return;
            }
            b(1, true, null);
            this.aAQ.bjX();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beY() {
        if (this.aAR != null) {
            this.aAR.cancelLoadData();
        }
        if (this.fTD != null) {
            this.fTD.cancelLoadData();
        }
        if (this.aAQ != null) {
            this.aAQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        beY();
        bqw();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpA() {
        if (this.mData != null && this.mData.getType() == 2 && this.fTK) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bqt().getText().toString());
            this.mData.setContent(bqs().getText().toString());
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
            if (this.foC != null && this.foC.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.foC, getPageContext().getPageActivity());
                return true;
            } else if (this.azf.Dq()) {
                this.azf.BC();
                return true;
            } else {
                beY();
                bpA();
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
        getLayoutMode().t(this.fUr);
        if (this.fUo != null && i == 1) {
            this.fUo.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.aq.c(this.mPost, w.e.cp_link_tip_a, 1);
        bqc();
        com.baidu.tbadk.core.util.aq.k(this.fUd, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.fox, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.fUe, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(bqt(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dJR)) {
            com.baidu.tbadk.core.util.aq.k(bqs(), w.e.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e);
        bqt().setTextColor(color);
        bqs().setTextColor(color);
        a(bqt(), color2);
        a(bqs(), color2);
        bfg();
        this.azf.onChangeSkinType(i);
        if (this.fTY != null) {
            this.fTY.xl();
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
        this.aII = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fUl = this.mData.getType() == 4 || 5 == this.mData.getType();
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
        this.fTI = (TextView) findViewById(w.h.btn_image_problem);
        bqi();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds10);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fou);
        this.fUb = (ScrollView) findViewById(w.h.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fTE = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.fTF = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.fTC = (LinearLayout) findViewById(w.h.tool_view);
        this.fTC.setContentDescription("..");
        this.fox = findViewById(w.h.interval_view);
        this.fUx = findViewById(w.h.hot_topic_fourm_view);
        this.fUy = findViewById(w.h.hot_topic_divider);
        this.fUz = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.fUA = (TextView) findViewById(w.h.change_one_tv);
        bff();
        if (this.fUl) {
            this.fUb.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bqd();
        }
        bfh();
        if (this.fTz || this.fTA) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aho) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.foz = (LinearLayout) findViewById(w.h.post_content_container);
        this.foz.setDrawingCacheEnabled(false);
        this.foz.setOnClickListener(new ac(this));
        this.aom.setOnFocusChangeListener(this.fou);
        this.aom.setOnClickListener(new ad(this));
        this.fTI.setOnClickListener(new af(this));
        bql();
        j(bqx());
        bqp();
        switch (this.mData.getType()) {
            case 0:
                if (this.fTz || this.fTA) {
                    if (this.fTB) {
                        this.mName.setText(w.l.feedback_vcode);
                    } else {
                        this.mName.setText(w.l.feedback);
                    }
                } else {
                    this.mName.setText(w.l.post_new_thread);
                }
                this.fow.setVisibility(0);
                this.foA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.mName.setText(w.l.send_reply);
                this.foA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fow.setVisibility(8);
                break;
            case 4:
                this.mName.setText(w.l.publish_photo_live);
                this.foA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.fUe.setVisibility(8);
                break;
            case 7:
                this.fow.setVisibility(0);
                this.foA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.foA.setHint(w.l.bottle_input_hint);
                this.mName.setText(w.l.post_drift_bottle);
                break;
        }
        bqq();
        bqv();
        bqc();
        bqn();
        bfe();
        if (com.baidu.tbadk.core.util.x.q(this.mList) || this.mList.get(0) == null) {
            this.fow.getPaint().setFakeBoldText(true);
        } else {
            this.fow.getPaint().setFakeBoldText(false);
            bqy();
        }
        if (this.mData.getType() == 4 && this.foE != null && this.fTG != null) {
            this.foE.setVisibility(8);
            this.fTG.setVisibility(8);
        }
        bfg();
        ShowSoftKeyPad(this.mInputManager, this.fow);
        bqm();
    }

    private void bqi() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
        } else {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
        }
    }

    private void bqj() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fTz && !this.fTA && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.au.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bqt() != null) {
                bqt().setText(c);
                bqt().setSelection(c.length());
            }
        }
    }

    private void bqk() {
        this.fTT = null;
        this.fTV = -1;
        this.fTX = -1;
        com.baidu.tieba.frs.bx ia = com.baidu.tieba.frs.bw.abC().ia(1);
        if (ia != null) {
            this.fTT = ia.bSj;
            this.fTV = getIntent().getIntExtra("category_id", -1);
            if (this.fTT != null && !this.fTT.isEmpty() && this.fTV >= 0) {
                this.fTU = new com.baidu.tieba.frs.bv();
                this.fTU.bSf = 0;
                this.fTU.name = getPageContext().getResources().getString(w.l.category_auto);
                this.fTX = this.fTU.bSf;
                this.fTW = this.fTU.name;
                for (com.baidu.tieba.frs.bv bvVar : this.fTT) {
                    if (bvVar.bSf == this.fTV) {
                        this.fTX = bvVar.bSf;
                        this.fTW = bvVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bql() {
        if (this.fTT != null && !this.fTT.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.fTY = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.fTY.setText(this.fTW);
            this.fTY.b(this.fTT, this.fTU, this.fTX);
            this.fTY.setCategoryContainerClickCallback(new ag(this));
            linearLayout.setOnClickListener(new ah(this));
        }
    }

    private void bqm() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fUL = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new ai(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fUL.setTitle(w.l.no_disturb_start_time);
        this.fUL.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.fUL);
        this.fUL.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.fUL);
        return this.fUL;
    }

    private void bqn() {
        this.fTO = (RelativeLayout) findViewById(w.h.addition_container);
        this.fTP = (TextView) findViewById(w.h.addition_create_time);
        this.fTQ = (TextView) findViewById(w.h.addition_last_time);
        this.fTR = (TextView) findViewById(w.h.addition_last_content);
        if (this.fTN != null) {
            this.fTO.setVisibility(0);
            this.fTP.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.au.q(this.fTN.getCreateTime() * 1000));
            if (this.fTN.getAlreadyCount() == 0) {
                this.fTQ.setVisibility(8);
            } else {
                this.fTQ.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.au.q(this.fTN.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fTN.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fTR.setText(lastAdditionContent);
            } else {
                this.fTR.setVisibility(8);
            }
            bqs().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.fTN.getAlreadyCount()), Integer.valueOf(this.fTN.getTotalCount())));
            this.mName.setText(w.l.write_addition_title);
            return;
        }
        this.fTO.setVisibility(8);
    }

    private void bfe() {
        this.foE = findViewById(w.h.post_prefix_layout);
        this.foB = (TextView) findViewById(w.h.post_prefix);
        this.fTG = findViewById(w.h.prefix_divider);
        this.foD = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.foE.setVisibility(0);
            this.fTG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fod = 1;
            this.foE.setOnClickListener(new aj(this));
            this.foD = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.foD.setVisibility(0);
                this.foB.setOnClickListener(new ak(this));
            }
            this.foC = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.foC.a(this);
            this.foC.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.foC.setOutsideTouchable(true);
            this.foC.setFocusable(true);
            this.foC.setOnDismissListener(this);
            this.foC.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.j(this.foB, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.c(this.foD, w.g.icon_title_down);
            this.foB.setTextColor(color);
            this.fSA.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fSA.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.foC.addView(aVar);
            }
            this.foC.sQ(0);
            this.foB.setText(prefixs.get(1));
            tk(1);
            return;
        }
        this.foE.setVisibility(8);
    }

    private void bqo() {
        if (this.fTz && this.mData != null) {
            this.fTE.setVisibility(0);
            this.fTF.setVisibility(0);
            this.fTD = new FeedBackModel(this);
            this.fTD.rm(this.mData.getForumName());
            this.fTD.setLoadDataCallBack(new al(this));
        }
    }

    protected void bqp() {
        this.mPost.setOnClickListener(new am(this));
    }

    protected void bqq() {
        this.fTJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fTJ.cE(getPageContext().getString(w.l.is_save_draft)).av(false).a(getPageContext().getString(w.l.save), new an(this)).b(getPageContext().getString(w.l.not_save), new ap(this));
        this.fTJ.b(getPageContext());
    }

    protected void bff() {
        this.fRD = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.fRD.setIsRound(true);
        this.fRD.setDrawBorder(false);
        this.fRD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = com.baidu.tbadk.core.util.q.dn(currentPortrait);
            this.fRD.setUrl(dn);
            this.fRD.c(dn, 12, false);
        }
        this.fow = (EditText) findViewById(w.h.post_title);
        this.fow.setOnClickListener(this.fUH);
        this.fow.setOnFocusChangeListener(this.fou);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fow.setText(this.mData.getTitle());
                this.fow.setSelection(this.mData.getTitle().length());
            } else if (this.fTB) {
                this.fow.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fow.addTextChangedListener(this.fUJ);
        if (!this.mData.getHaveDraft()) {
            bqj();
            this.fUv = true;
        }
    }

    private TextWatcher aTV() {
        ar arVar = new ar(this);
        if (this.fUl && this.fUm) {
            if (this.fUj != null) {
                this.fUg.removeTextChangedListener(this.fUj);
            }
            this.fUj = arVar;
        } else if (this.fUl) {
            if (this.fUk != null) {
                this.fUc.removeTextChangedListener(this.fUk);
            }
            this.fUk = arVar;
        }
        return arVar;
    }

    private long h(EditText editText) {
        if (editText == this.fUc) {
            return 233L;
        }
        if (editText != this.fUg) {
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

    protected void bfh() {
        this.foA = (EditText) findViewById(w.h.post_content);
        this.foA.setDrawingCacheEnabled(false);
        this.foA.setOnClickListener(this.fUH);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString X = TbFaceManager.EI().X(getPageContext().getPageActivity(), this.mData.getContent());
            this.foA.setText(X);
            this.foA.setSelection(X.length());
        } else if (this.mData.getType() == 2) {
            if (this.fTK) {
                if (this.fTL != null && this.fTL.length() > 0) {
                    this.foA.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.fTL}));
                    this.foA.setSelection(this.foA.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.foA.setText(format);
                this.foA.setSelection(format.length());
            }
        }
        this.foA.setOnFocusChangeListener(this.fou);
        this.foA.setOnTouchListener(new as(this));
        this.foA.addTextChangedListener(this.fUK);
        ma(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fUl) {
            bqs().setPadding(0, 0, 0, 0);
            bqs().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.aq.k(bqs(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dJR) && this.fTN == null) {
                com.baidu.adp.lib.f.c.fM().a(this.dJR, 19, new at(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqr() {
        int i = 5000;
        if (this.fTN != null) {
            i = 1000;
        }
        return bqs().getText() != null && bqs().getText().length() >= i;
    }

    private void fr(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.fTx)) {
                this.fTx = "";
                bqs().requestFocus();
                if (bqs().getText() != null && bqs().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bqs().getSelectionStart();
                    editable = bqs().getText();
                }
            } else if ("from_title".equals(this.fTx)) {
                this.fTx = "";
                bqt().requestFocus();
                if (bqt().getText() != null && bqt().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bqt().getSelectionStart();
                    editable = bqt().getText();
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
    public void mb(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bqs().getText().getSpans(0, bqs().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fTM == null) {
                this.fTM = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.fTM.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType yy = lVar.yy();
        if (name != null) {
            com.baidu.adp.lib.f.c.fM().a(name, 20, new au(this, new SpannableStringBuilder(name), yy), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bqs() != null) {
            Bitmap kS = aVar.kS();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kS);
            int width = kS.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            bqs().getText().insert(i, spannableStringBuilder);
            Editable text = bqs().getText();
            if (text != null) {
                this.fUE.clear();
                this.fUE.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fUE);
                bqs().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bqs() {
        return this.fUl ? this.fUc : this.foA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bqt() {
        return this.fUl ? this.fUg : this.fow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqu() {
        if (bqs() != null) {
            bqs().onKeyDown(67, this.fTH);
            int selectionStart = bqs().getSelectionStart();
            Editable text = bqs().getText();
            if (text != null) {
                this.fUE.clear();
                this.fUE.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fUE);
                bqs().setSelection(selectionStart);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.fTz = true;
        }
    }

    private void bqv() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bqw() {
        try {
            if (this.fTJ != null) {
                this.fTJ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aII.c(null);
        this.aII.cZ(w.l.sending);
        this.aII.aK(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aII.aK(false);
    }

    private Boolean bqx() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aAW = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfg() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bqt() != null) {
                str = bqt().getText().toString();
            }
            if (bqs() != null) {
                str2 = bqs().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fod == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            mc(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        mc(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    mc(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fUl) {
                    mc(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    mc(true);
                }
            }
            if (this.mData.getType() == 4) {
                mc(j(this.fUc) && i(this.fUg));
            } else if (this.mData.getType() == 5) {
                mc(j(this.fUc));
            } else if (!TextUtils.isEmpty(str2)) {
                mc(true);
            } else if (this.aAO != null) {
                mc(true);
            } else if (this.mData.getVideoInfo() != null) {
                mc(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                mc(true);
            } else {
                mc(false);
            }
        }
    }

    private void mc(boolean z) {
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
        this.aAR = new NewWriteModel(this);
        this.aAR.b(this.aBg);
        registerListener(this.fUF);
        this.mDialogCancelListener = new av(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fTz = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fTB = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fTK = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fTL = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAP = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fTN = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fTN != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fTS = bundle.getInt("mem_type", 0);
            this.ahN = bundle.getString("from");
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fUB = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fTz = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fTB = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fTK = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fTL = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fTN = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fTN != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fTS = intent.getIntExtra("mem_type", 0);
            this.ahN = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fUB = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
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
        this.dJR = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fTA = true;
        }
        bqk();
        try {
            this.fUn = bqD();
        } catch (Throwable th) {
            this.fUn = null;
        }
    }

    private void bqy() {
        this.fRD.setVisibility(8);
        this.fUx.setVisibility(0);
        this.fUy.setVisibility(0);
        if (this.mData.getType() != 7) {
            this.fow.setText(rn(this.mList.get(0).mTopicName));
            this.fow.setMovementMethod(com.baidu.tieba.view.g.bnn());
        }
        this.fUz.setText(this.mList.get(0).mForumName);
        this.fow.addTextChangedListener(new aw(this));
        this.fUA.setOnClickListener(new ax(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gb = com.baidu.tbadk.plugins.a.gb(rn(hotTopicBussinessData.mTopicName));
            if (gb != null) {
                this.fow.setText(gb);
            }
            this.fUz.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rn(String str) {
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
        String rn;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bqt().getText().toString()) || this.fUv || ((this.fTz || this.fTA) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.x.q(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.x.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            rn = this.mData.getTitle();
                        } else {
                            rn = rn(str);
                        }
                        SpannableString gb = com.baidu.tbadk.plugins.a.gb(rn);
                        if (gb != null) {
                            bqt().setText(gb);
                            bqt().setSelection(rn.length());
                        }
                    } else {
                        bqt().setText(this.mData.getTitle());
                        bqt().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bqj();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.azf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bqs().getText().toString()) || this.fTz || this.fTA) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.EI().a(getPageContext().getPageActivity(), this.mData.getContent(), this.fUG);
                    bqs().setText(a2);
                    bqs().setSelection(a2.length());
                    if (this.fUl) {
                        b(this.fUi, this.fUc);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bqC();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Eb();
                    }
                    md(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bqz();
                }
                bfg();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.fTT != null) {
                    this.fTX = this.fTU.bSf;
                    this.fTW = this.fTU.name;
                    int i = 0;
                    while (true) {
                        if (i == this.fTT.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bv bvVar = this.fTT.get(i);
                        if (categoryTo != bvVar.bSf) {
                            i++;
                        } else {
                            this.fTX = categoryTo;
                            this.fTW = bvVar.name;
                            this.mData.setCategoryTo(this.fTX);
                            break;
                        }
                    }
                    if (this.fTY != null) {
                        this.fTY.setText(this.fTW);
                        this.fTY.b(this.fTT, this.fTU, this.fTX);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.azf.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.azf.BC();
                return;
            }
            return;
        }
        bqz();
        bqj();
    }

    private void bqz() {
        if ((!this.fUl || this.fUa != null) && this.fTZ != null) {
            this.fUa.c(this.writeImagesInfo);
            aCx();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fTK);
        if (this.fTz) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAP);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fTN);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fTS);
        bundle.putString("from", this.ahN);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bqs().getEditableText().toString();
        if (editable != null) {
            bqs().setText(TbFaceManager.EI().a(getPageContext().getPageActivity(), editable, this.fUG));
            bqs().setSelection(bqs().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpB() {
        beY();
        String editable = bqt().getText().toString();
        this.mData.setContent(bqs().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fod != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.foB.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fTz || this.fTA) {
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
                if (com.baidu.adp.lib.util.i.hk()) {
                    sb.append(com.baidu.adp.lib.util.i.hs());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.fTV >= 0) {
            this.mData.setCategoryFrom(this.fTV);
        }
        if (this.fTX >= 0) {
            this.mData.setCategoryTo(this.fTX);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aAQ != null && this.aAQ.QZ());
        this.aAR.ly(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.x.q(this.mList) && this.fUw != null && this.fUw.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.fUw.mForumId));
            this.mData.setForumName(this.fUw.mForumName);
        }
        this.aAR.setWriteData(this.mData);
        this.mData.setVcode(null);
        if (this.aAO != null) {
            if (this.aAO.getId() != null) {
                this.aAR.getWriteData().setVoice(this.aAO.getId());
                this.aAR.getWriteData().setVoiceDuringTime(this.aAO.duration);
            } else {
                this.aAR.getWriteData().setVoice(null);
                this.aAR.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aAR.getWriteData().setVoice(null);
            this.aAR.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aAR.bkv()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aAR.startPostWrite();
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
            if (this.fTN != null) {
                i2 = this.fTN.getTotalCount();
                i = this.fTN.getAlreadyCount() + 1;
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
                if (this.azf != null && !this.azf.Dq()) {
                    bqs().requestFocus();
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
                            bqs().getText().insert(bqs().getSelectionStart(), sb.toString());
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
                                aVr();
                            } else {
                                Z(intent);
                            }
                        } else if (intExtra == 1) {
                            T(intent);
                        } else {
                            Y(intent);
                            com.baidu.adp.lib.g.h.fS().post(new ay(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fUl) {
                        B(intent);
                        bfg();
                        return;
                    }
                    ab(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.azf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.azf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.azf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bfg();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.K(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fTy) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fTy = false;
                            }
                            sb2.append(stringExtra);
                            fr(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.x.q(this.mList) && !com.baidu.tbadk.core.util.x.q(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.fUw = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.fUw);
                }
            }
        } else if (i2 == 0) {
            if (this.azf != null && !this.azf.Dq()) {
                this.foA.requestFocus();
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
                    bqB();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aAP = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAP);
                    return;
                case 12012:
                    bqB();
                    return;
                case 25004:
                    if ("from_title".equals(this.fTx)) {
                        bqt().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fTx)) {
                        bqs().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bqA() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bqB() {
        if (this.fUl) {
            this.fUa.c(this.writeImagesInfo);
            aCx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        this.fUa.notifyDataSetChanged();
        this.fTZ.invalidate();
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
        bfg();
    }

    private void Y(Intent intent) {
        if (this.fUl) {
            ab(intent);
            bqB();
        } else {
            ac(intent);
        }
        bfg();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bqB();
            md(true);
        }
    }

    private void Z(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aVr() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.ePK.parseJson(stringExtra);
            this.ePK.updateQuality();
            if (this.ePK.getChosedFiles() != null && this.ePK.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ePK.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.ePK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bqt());
        HidenSoftKeyPad(this.mInputManager, bqs());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ac(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aAP = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAP;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAP, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bqC();
            Eb();
        }
        md(true);
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
                bqC();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Eb();
                }
            }
            md(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqC() {
        if (this.azf.eB(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void DW() {
        new ba(this).execute(new Void[0]);
    }

    private void md(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bOT == null) {
            this.bOT = VoiceManager.instance();
        }
        return this.bOT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaq() {
        this.bOT = getVoiceManager();
        this.bOT.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.sd(postWriteCallBackData.getErrorCode())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.fTN == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAY = i;
        if (this.azf != null) {
            this.azf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.azf.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Eb() {
        if (!this.fUl && this.azf != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.azf.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.azf.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.azf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.azf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.azf != null) {
            this.azf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tk(int i) {
        if (i < this.fSA.size()) {
            for (int i2 = 0; i2 < this.fSA.size(); i2++) {
                this.fSA.get(i2).lR(false);
            }
            this.fSA.get(i).lR(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rA(int i) {
        this.fod = i;
        this.foC.sQ(i);
        tk(i);
        this.foB.setText(this.mPrefixData.getPrefixs().get(i));
        bfg();
        com.baidu.adp.lib.g.j.a(this.foC, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.foE.setSelected(false);
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
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.aAP);
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
        if (this.fUt && System.currentTimeMillis() - this.fUu < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fUt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fUq != null) {
            rp(str);
            this.fUq.dismiss();
        }
    }

    private void bP(Context context) {
        fUs = com.baidu.adp.lib.util.k.ag(context);
    }

    private void rp(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fUt = true;
        bqC();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Eb();
        }
        md(true);
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

    private File bqD() {
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

    private void bqE() {
        if (this.fUn != null && this.mData.getType() == 0) {
            bP(getActivity());
            this.fUp = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.fUp.setOnClickListener(new bc(this));
            this.fUo = (TbImageView) this.fUp.findViewById(w.h.rec_img_view);
            this.fUr = (LinearLayout) this.fUp.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.uL().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fUn.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.uL().putString("write_rec_pic_path", this.fUn.getAbsolutePath());
                Bitmap c = c(this.fUn.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.fUo.setImageBitmap(c);
                    this.fUo.setDrawBorder(true);
                    this.fUo.setBorderWidth(2);
                    this.fUo.setBorderColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10264));
                    this.fUq = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.fUq.setCanceledOnTouchOutside(true);
                    this.fUq.setOnDismissListener(new bd(this));
                    this.fUq.setContentView(this.fUp);
                    this.fUq.show();
                    Window window = this.fUq.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (fUs / 18) + getResources().getDimensionPixelSize(w.f.ds12);
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
            this.fTy = false;
            this.fTx = "";
            if ("from_content".equals(str)) {
                this.fTx = "from_content";
            } else if ("from_title".equals(str)) {
                this.fTx = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                mb(false);
            }
        }
    }
}
