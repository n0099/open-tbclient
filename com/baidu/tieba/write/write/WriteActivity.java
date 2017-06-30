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
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.w;
import com.baidu.tieba.write.p;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, x.a, p.a {
    private static int gls = 0;
    private VoiceData.VoiceModel aBB;
    private String aBC;
    private LocationModel aBD;
    private NewWriteModel aBE;
    private String ahE;
    private com.baidu.tbadk.editortools.j azR;
    private VoiceManager cci;
    private LinearLayout eiG;
    private TextView fCE;
    private com.baidu.tieba.write.p fCF;
    private ImageView fCG;
    private View fCH;
    private int fCh;
    private LinearLayout gkB;
    private View gkE;
    private View gkF;
    private Toast gkL;
    private AdditionData gkM;
    private RelativeLayout gkN;
    private TextView gkO;
    private TextView gkP;
    private TextView gkQ;
    List<com.baidu.tieba.frs.bq> gkS;
    com.baidu.tieba.frs.bq gkT;
    private int gkU;
    private String gkV;
    private int gkW;
    private PostCategoryView gkX;
    private NewFrameMultiImgToolView gkY;
    private View glA;
    private TextView glB;
    private TextView glC;
    private com.baidu.tieba.write.b.f glH;
    private com.baidu.tieba.view.c glO;
    private com.baidu.tieba.write.a glw;
    private HotTopicBussinessData gly;
    private View glz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gkw = "";
    private boolean gkx = false;
    private WriteData mData = null;
    private boolean gky = false;
    private boolean gkz = false;
    private boolean gkA = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fCz = null;
    private HeadImageView giz = null;
    private View fCA = null;
    private LinearLayout fCC = null;
    private EditText fCD = null;
    private FeedBackModel gkC = null;
    private FeedBackTopListView gkD = null;
    private ArrayList<com.baidu.tieba.write.o> gjA = new ArrayList<>();
    private String dSk = null;
    private final KeyEvent gkG = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View apb = null;
    private TextView gkH = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gkI = null;
    private final Handler mHandler = new Handler();
    private boolean gkJ = false;
    private String gkK = null;
    private RelativeLayout mParent = null;
    private String aBJ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aBL = 0;
    private int gkR = 0;
    private WriteImagesInfo feL = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gkZ = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gla = null;
    private ScrollView glb = null;
    private EditText glc = null;
    private View gld = null;
    private View gle = null;
    private View glf = null;
    private EditText glg = null;
    private TextView glh = null;
    private TextView gli = null;
    private TextWatcher glj = null;
    private TextWatcher glk = null;
    private boolean gll = false;
    private boolean glm = false;
    private com.baidu.tbadk.core.view.a aJN = null;
    private File gln = null;
    private TbImageView glo = null;
    private View glp = null;
    private Dialog glq = null;
    private LinearLayout glr = null;
    private boolean glt = false;
    private long glu = -1000;
    private boolean glv = false;
    private String ggZ = "2";
    private boolean glx = false;
    private String glD = "";
    private String glE = "";
    private int glF = 0;
    private SpannableStringBuilder glG = new SpannableStringBuilder();
    private final HttpMessageListener glI = new t(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a glJ = new ae(this);
    private final NewWriteModel.d aBU = new ap(this);
    private final LocationModel.a aBS = new bb(this);
    private final CustomMessageListener fOp = new bg(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener glK = new bh(this);
    private boolean glL = true;
    private final View.OnFocusChangeListener fCx = new bi(this);
    private TextWatcher glM = new bj(this);
    private TextWatcher glN = new bk(this);
    private final a.InterfaceC0083a eDV = new u(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ahE)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(w.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dk();
        } else if (this.aBD.bne()) {
            Di();
        } else {
            this.aBD.lU(false);
            b(1, true, null);
            this.aBD.bnc();
        }
    }

    private void Dk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.location_app_permission_prompt).a(w.l.isopen, new v(this)).b(w.l.cancel, new w(this)).b(getPageContext());
        aVar.ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bua() {
        int selectionEnd = bus().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bus().getText().getSpans(0, bus().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bus().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bus().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bub() {
        if (this.azR != null) {
            this.azR.setBarLauncherEnabled(!this.glL);
            this.azR.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gll) {
            this.fCz.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.glf.setVisibility(8);
            } else {
                this.glf.setVisibility(0);
            }
            b(this.gli, this.glc);
            b(this.glh, this.glg);
            bis();
        }
        if (this.gky) {
            this.fCz.requestFocus();
            ShowSoftKeyPadDelay(this.fCz);
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
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        buo();
        this.aBD = new LocationModel(this);
        this.aBD.a(this.aBS);
        registerListener(this.fOp);
        initEditor();
        buG();
        if (this.gll) {
            this.gla.setEditorTools(this.azR);
        } else {
            this.fCD.requestFocus();
        }
        Bd();
        Dt();
        this.glw = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    private void initEditor() {
        this.azR = new com.baidu.tbadk.editortools.j(getActivity());
        this.azR.setBarMaxLauCount(5);
        this.azR.setMoreButtonAtEnd(true);
        this.azR.setBarLauncherType(1);
        this.azR.bB(true);
        this.azR.setMoreLauncherIcon(w.g.write_more);
        this.azR.setBackgroundColorId(w.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bue();
                break;
            default:
                buf();
                break;
        }
        this.azR.CH();
        if (this.gkB != null) {
            this.gkB.addView(this.azR);
        }
        bug();
        this.azR.lM();
        com.baidu.tbadk.editortools.p ey = this.azR.ey(6);
        if (ey != null && !TextUtils.isEmpty(this.aBJ)) {
            ((View) ey).setOnClickListener(new x(this));
        }
        if (!this.gll) {
            this.azR.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.azR.Bb();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.azR.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.azR.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.ggT = String.valueOf(this.mData.getForumName()) + getResources().getString(w.l.bar);
        }
        this.azR.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gkY != null) {
            this.gkY.setEditorTools(this.azR);
            this.gkY.btm();
        }
    }

    private void buc() {
        this.gld = this.mRootView.findViewById(w.h.photo_live_scroll);
        this.glf = this.gld.findViewById(w.h.live_post_title_container);
        this.glc = (EditText) this.gld.findViewById(w.h.live_post_content);
        this.gkZ = (GridView) this.gld.findViewById(w.h.photoLiveGridView);
        this.glg = (EditText) this.gld.findViewById(w.h.live_post_title);
        this.glh = (TextView) this.gld.findViewById(w.h.titleOverPlusNumber);
        this.gli = (TextView) this.gld.findViewById(w.h.contentOverPlusNumber);
        this.gle = this.gld.findViewById(w.h.live_interval_view);
        this.glh.setText(String.valueOf(20));
        this.gli.setText(String.valueOf(233));
        this.gld.setVisibility(0);
        this.glh.setVisibility(0);
        this.gli.setVisibility(0);
        this.glg.setHint(w.l.tips_title_limit_new);
        this.glg.setOnFocusChangeListener(new y(this));
        if (this.mData.getType() == 4) {
            this.glc.setHint(w.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.glc.setHint(w.l.live_write_input_content_update);
        }
        this.glc.setOnFocusChangeListener(new z(this));
        this.glc.requestFocus();
        this.glc.addTextChangedListener(aWV());
        this.glg.requestFocus();
        this.glg.addTextChangedListener(aWV());
        this.glg.setOnClickListener(this.glK);
        this.glc.setOnClickListener(this.glK);
        this.gla = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gkZ);
        this.gla.tO(6);
        this.gkZ.setAdapter((ListAdapter) this.gla);
        View findViewById = this.gld.findViewById(w.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new aa(this));
        bud();
    }

    private void bud() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.glg.setText(this.mData.getTitle());
                this.glg.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gll) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            buC();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Dt();
            return;
        }
        if (this.azR.CJ()) {
            this.azR.Bb();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.azR.x(arrayList);
        com.baidu.tbadk.editortools.x eA = this.azR.eA(5);
        if (eA != null) {
            eA.aAy = 2;
            eA.aAw = w.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aAw = w.g.write_at;
        this.azR.b(aVar);
        this.azR.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void buf() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.azR.b(aVar);
        aVar.aAw = w.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar4.aAy = 5;
            xVar4.aAw = w.g.write_privilege;
            this.azR.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar2.aAw = w.g.write_at;
        this.azR.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar3.aAA = true;
            xVar3.aAy = 9;
            xVar3.aAw = 0;
            this.azR.b(xVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar2.aAA = true;
            xVar2.aAy = 10;
            xVar2.aAw = 0;
            this.azR.b(xVar2);
        }
        Boolean bux = bux();
        if (!this.gky && bux != null && bux.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bnz() && com.baidu.tieba.tbadkCore.r.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.aAy = 2;
            xVar.aAw = w.g.write_recorder;
            this.azR.b(xVar);
        }
        if (this.gkM == null) {
            if (this.glH == null) {
                this.glH = new com.baidu.tieba.write.b.f(getActivity(), this.ggZ);
            }
            this.azR.b(this.glH);
        }
        this.azR.x(arrayList);
        com.baidu.tbadk.editortools.x eA = this.azR.eA(5);
        if (eA != null) {
            eA.aAy = 1;
            eA.aAw = w.g.write_emotion;
        }
    }

    private void bug() {
        ab abVar = new ab(this);
        this.azR.a(16, abVar);
        this.azR.a(14, abVar);
        this.azR.a(24, abVar);
        this.azR.a(3, abVar);
        this.azR.a(10, abVar);
        this.azR.a(11, abVar);
        this.azR.a(12, abVar);
        this.azR.a(13, abVar);
        this.azR.a(15, abVar);
        this.azR.a(18, abVar);
        this.azR.a(25, abVar);
        this.azR.a(27, abVar);
        this.azR.a(29, abVar);
        this.azR.a(40, abVar);
        this.azR.a(43, abVar);
        this.azR.a(45, abVar);
        this.azR.a(48, abVar);
        this.azR.a(46, abVar);
        this.azR.a(49, abVar);
        this.azR.a(47, abVar);
        this.azR.a(51, abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        if (this.aBD.Sy()) {
            if (this.aBD.bne()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.d.bna().getLocationData().bmW());
                return;
            }
            b(1, true, null);
            this.aBD.bnc();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bik() {
        if (this.aBE != null) {
            this.aBE.cancelLoadData();
        }
        if (this.gkC != null) {
            this.gkC.cancelLoadData();
        }
        if (this.aBD != null) {
            this.aBD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bik();
        buw();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.glw != null) {
            this.glw.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btz() {
        if (this.mData != null && this.mData.getType() == 2 && this.gkJ) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(but().getText().toString());
            this.mData.setContent(bus().getText().toString());
            int type = this.mData.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.x.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.x.b("24591571", this.mData);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.x.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.x.b(String.valueOf(this.mData.getForumId()) + "photolive", this.mData);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.x.c(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fCF != null && this.fCF.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fCF, getPageContext().getPageActivity());
                return true;
            } else if (this.azR.CJ()) {
                this.azR.Bb();
                return true;
            } else {
                bik();
                btz();
                return true;
            }
        }
        if (i == 67 && (text = bus().getText()) != null) {
            int selectionStart = bus().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bus().onKeyDown(67, this.gkG);
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
        getLayoutMode().t(this.glr);
        if (this.glo != null && i == 1) {
            this.glo.setBorderColor(com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.as.c(this.mPost, w.e.cp_link_tip_a, 1);
        bub();
        com.baidu.tbadk.core.util.as.k(this.gld, w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.k(this.fCA, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.gle, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(but(), w.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dSk)) {
            com.baidu.tbadk.core.util.as.k(bus(), w.e.cp_bg_line_d);
        }
        bis();
        this.azR.onChangeSkinType(i);
        if (this.gkX != null) {
            this.gkX.wK();
        }
        com.baidu.tbadk.core.util.as.i(this.mName, w.e.cp_cont_b);
        this.fCz.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e));
        this.fCD.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e));
    }

    private void buh() {
        this.gkY = (NewFrameMultiImgToolView) this.mRootView.findViewById(w.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gkY.initView();
        this.gkY.setVisibility(0);
        this.gkY.setAsyncLocalImageLoader(bVar);
        if (this.gkY.getDragLayer() != null && this.gkY.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gkY.getDragLayer());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.g) this.gkY.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.f) this.gkY.getDragHorizonScrollView());
            this.gkY.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(w.f.ds44));
            this.gkY.getDragHorizonScrollView().setPadding((int) getResources().getDimension(w.f.ds0));
            this.gkY.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            this.gkY.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gkY));
            this.gkY.getDragHorizonScrollView().setOnSwapDataListener(this.gkY);
            this.gkY.getDragHorizonScrollView().setMaxItemNum(10);
        }
    }

    private View a(Context context, com.baidu.tbadk.editortools.y yVar) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dimension = (int) getResources().getDimension(w.f.ds194);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(dimension, dimension);
        }
        imageView.setLayoutParams(layoutParams);
        com.baidu.tbadk.core.util.as.c(imageView, w.g.new_frame_btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(w.l.add));
        imageView.setOnClickListener(new ac(this, yVar));
        return imageView;
    }

    private void initUI() {
        this.aJN = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gll = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(w.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.apb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apb.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apb != null && (this.apb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apb.getLayoutParams();
            layoutParams2.width = -2;
            this.apb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.write_close_selector, w.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.as.i(this.mName, w.e.cp_cont_b);
        this.gkH = (TextView) findViewById(w.h.btn_image_problem);
        bui();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.fCx);
        this.glb = (ScrollView) findViewById(w.h.write_scrollview);
        this.glb.setOnTouchListener(new ad(this));
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gkD = (FeedBackTopListView) findViewById(w.h.feedback_top_list);
        this.gkE = findViewById(w.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.gkB = (LinearLayout) findViewById(w.h.tool_view);
        this.gkB.setContentDescription("..");
        this.eiG = (LinearLayout) findViewById(w.h.title_view);
        this.fCA = findViewById(w.h.interval_view);
        this.glz = findViewById(w.h.hot_topic_fourm_view);
        this.glA = findViewById(w.h.hot_topic_divider);
        this.glB = (TextView) findViewById(w.h.hot_topic_title_edt);
        this.glC = (TextView) findViewById(w.h.change_one_tv);
        bir();
        if (this.gll) {
            this.glb.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            buc();
        } else {
            buh();
        }
        bit();
        if (this.gky || this.gkz) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahf) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(w.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(w.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fCC = (LinearLayout) findViewById(w.h.post_content_container);
        this.fCC.setDrawingCacheEnabled(false);
        this.fCC.setOnClickListener(new af(this));
        this.apb.setOnFocusChangeListener(this.fCx);
        this.apb.setOnClickListener(new ag(this));
        this.gkH.setOnClickListener(new ah(this));
        bul();
        j(bux());
        bup();
        switch (this.mData.getType()) {
            case 0:
                if (this.gky || this.gkz) {
                    if (this.gkA) {
                        this.mName.setText(w.l.feedback_vcode);
                    } else {
                        this.mName.setText(w.l.feedback);
                    }
                } else {
                    this.mName.setText(w.l.post_new_thread);
                }
                this.fCz.setVisibility(0);
                this.fCD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.mName.setText(w.l.send_reply);
                this.fCD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fCz.setVisibility(8);
                break;
            case 4:
                this.mName.setText(w.l.publish_photo_live);
                this.fCD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(w.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gle.setVisibility(8);
                break;
            case 7:
                this.fCz.setVisibility(0);
                this.fCD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(w.l.post_drift_bottle);
                break;
        }
        buq();
        buv();
        bub();
        bun();
        biq();
        buy();
        if (this.mData.getType() == 4 && this.fCH != null && this.gkF != null) {
            this.fCH.setVisibility(8);
            this.gkF.setVisibility(8);
        }
        bis();
        ShowSoftKeyPad(this.mInputManager, this.fCz);
        bum();
    }

    private void bui() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.send_post));
    }

    private void buj() {
        if (this.mData != null && this.mData.getType() == 0 && !this.gky && !this.gkz && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.aw.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && but() != null) {
                but().setText(c);
                but().setSelection(c.length());
            }
        }
    }

    private void buk() {
        this.gkS = null;
        this.gkU = -1;
        this.gkW = -1;
        com.baidu.tieba.frs.bs iA = com.baidu.tieba.frs.br.aeU().iA(1);
        if (iA != null) {
            this.gkS = iA.ceU;
            this.gkU = getIntent().getIntExtra("category_id", -1);
            if (this.gkS != null && !this.gkS.isEmpty() && this.gkU >= 0) {
                this.gkT = new com.baidu.tieba.frs.bq();
                this.gkT.ceQ = 0;
                this.gkT.name = getPageContext().getResources().getString(w.l.category_auto);
                this.gkW = this.gkT.ceQ;
                this.gkV = this.gkT.name;
                for (com.baidu.tieba.frs.bq bqVar : this.gkS) {
                    if (bqVar.ceQ == this.gkU) {
                        this.gkW = bqVar.ceQ;
                        this.gkV = bqVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bul() {
        if (this.gkS != null && !this.gkS.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(w.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(w.h.interval_view_cate).setVisibility(0);
            this.gkX = (PostCategoryView) linearLayout.findViewById(w.h.category_selected);
            this.gkX.setText(this.gkV);
            this.gkX.b(this.gkS, this.gkT, this.gkW);
            this.gkX.setCategoryContainerClickCallback(new ai(this));
            linearLayout.setOnClickListener(new aj(this));
        }
    }

    private void bum() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.glO = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new ak(this), new Date().getHours(), new Date().getMinutes(), false);
        this.glO.setTitle(w.l.no_disturb_start_time);
        this.glO.setButton(-1, getPageContext().getString(w.l.alert_yes_button), this.glO);
        this.glO.setButton(-2, getPageContext().getString(w.l.alert_no_button), this.glO);
        return this.glO;
    }

    private void bun() {
        this.gkN = (RelativeLayout) findViewById(w.h.addition_container);
        this.gkO = (TextView) findViewById(w.h.addition_create_time);
        this.gkP = (TextView) findViewById(w.h.addition_last_time);
        this.gkQ = (TextView) findViewById(w.h.addition_last_content);
        if (this.gkM != null) {
            this.gkN.setVisibility(0);
            this.gkO.setText(String.valueOf(getPageContext().getString(w.l.write_addition_create)) + com.baidu.tbadk.core.util.aw.q(this.gkM.getCreateTime() * 1000));
            if (this.gkM.getAlreadyCount() == 0) {
                this.gkP.setVisibility(8);
            } else {
                this.gkP.setText(String.valueOf(getPageContext().getString(w.l.write_addition_last)) + com.baidu.tbadk.core.util.aw.q(this.gkM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gkM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gkQ.setText(lastAdditionContent);
            } else {
                this.gkQ.setVisibility(8);
            }
            bus().setHint(String.format(getPageContext().getString(w.l.write_addition_hint), Integer.valueOf(this.gkM.getAlreadyCount()), Integer.valueOf(this.gkM.getTotalCount())));
            this.mName.setText(w.l.write_addition_title);
            return;
        }
        this.gkN.setVisibility(8);
    }

    private void biq() {
        this.fCH = findViewById(w.h.post_prefix_layout);
        this.fCE = (TextView) findViewById(w.h.post_prefix);
        this.gkF = findViewById(w.h.prefix_divider);
        this.fCG = (ImageView) findViewById(w.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fCH.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fCh = 1;
            this.fCH.setOnClickListener(new al(this));
            this.fCG = (ImageView) findViewById(w.h.prefix_icon);
            if (size > 1) {
                this.fCG.setVisibility(0);
                this.fCE.setOnClickListener(new am(this));
            }
            this.fCF = new com.baidu.tieba.write.p(getPageContext().getPageActivity());
            this.fCF.a(this);
            this.fCF.setMaxHeight(com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds510));
            this.fCF.setOutsideTouchable(true);
            this.fCF.setFocusable(true);
            this.fCF.setOnDismissListener(this);
            this.fCF.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(w.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_b);
            int color2 = com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_c);
            com.baidu.tbadk.core.util.as.j(this.fCE, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.c(this.fCG, w.g.icon_frs_arrow_n);
            this.fCE.setTextColor(color);
            this.gjA.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.o oVar = new com.baidu.tieba.write.o(getActivity());
                this.gjA.add(oVar);
                oVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    oVar.setPrefixTextColor(color2);
                } else {
                    oVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    oVar.setDividerStyle(false);
                }
                this.fCF.addView(oVar);
            }
            this.fCF.tz(0);
            this.fCE.setText(prefixs.get(1));
            tY(1);
            return;
        }
        this.fCH.setVisibility(8);
    }

    private void buo() {
        if (this.gky && this.mData != null) {
            this.gkD.setVisibility(0);
            this.gkE.setVisibility(0);
            this.gkC = new FeedBackModel(this);
            this.gkC.sw(this.mData.getForumName());
            this.gkC.setLoadDataCallBack(new an(this));
        }
    }

    protected void bup() {
        this.mPost.setOnClickListener(new ao(this));
    }

    protected void buq() {
        this.gkI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gkI.cI(getPageContext().getString(w.l.is_save_draft)).as(false).a(getPageContext().getString(w.l.save), new aq(this)).b(getPageContext().getString(w.l.not_save), new as(this));
        this.gkI.b(getPageContext());
    }

    protected void bir() {
        this.giz = (HeadImageView) findViewById(w.h.user_head_portrait);
        this.giz.setIsRound(true);
        this.giz.setDrawBorder(false);
        this.giz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dC = com.baidu.tbadk.core.util.s.dC(currentPortrait);
            this.giz.setUrl(dC);
            this.giz.c(dC, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.giz.setVisibility(0);
        }
        this.fCz = (EditText) findViewById(w.h.post_title);
        this.fCz.setOnClickListener(this.glK);
        this.fCz.setOnFocusChangeListener(this.fCx);
        if (this.mData.getType() == 0 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fCz.setText(this.mData.getTitle());
                this.fCz.setSelection(this.mData.getTitle().length());
            } else if (this.gkA) {
                this.fCz.setText(getResources().getString(w.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.fCz.addTextChangedListener(this.glM);
        if (!this.mData.getHaveDraft()) {
            buj();
            this.glv = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fCz.setHint(getResources().getString(w.l.feedback_title_hint));
        } else {
            this.fCz.setHint(getResources().getString(w.l.post_title_hint));
        }
    }

    private TextWatcher aWV() {
        at atVar = new at(this);
        if (this.gll && this.glm) {
            if (this.glj != null) {
                this.glg.removeTextChangedListener(this.glj);
            }
            this.glj = atVar;
        } else if (this.gll) {
            if (this.glk != null) {
                this.glc.removeTextChangedListener(this.glk);
            }
            this.glk = atVar;
        }
        return atVar;
    }

    private long h(EditText editText) {
        if (editText == this.glc) {
            return 233L;
        }
        if (editText != this.glg) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void bit() {
        this.fCD = (EditText) findViewById(w.h.post_content);
        this.fCD.setDrawingCacheEnabled(false);
        this.fCD.setOnClickListener(this.glK);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Ea().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.fCD.setText(Y);
            this.fCD.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gkJ) {
                if (this.gkK != null && this.gkK.length() > 0) {
                    this.fCD.setText(getPageContext().getPageActivity().getString(w.l.reply_sub_floor, new Object[]{this.gkK}));
                    this.fCD.setSelection(this.fCD.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(w.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fCD.setText(format);
                this.fCD.setSelection(format.length());
            }
        }
        this.fCD.setOnFocusChangeListener(this.fCx);
        this.fCD.setOnTouchListener(new au(this));
        this.fCD.addTextChangedListener(this.glN);
        mD(true);
        if (this.mData.isUserFeedback()) {
            this.fCD.setHint(w.l.write_input_content);
        } else {
            this.fCD.setHint(w.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gll) {
            bus().setPadding(0, 0, 0, 0);
            bus().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.as.k(bus(), w.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dSk) && this.gkM == null) {
                com.baidu.adp.lib.f.c.fL().a(this.dSk, 19, new av(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bur() {
        int i = 5000;
        if (this.gkM != null) {
            i = 1000;
        }
        return bus().getText() != null && bus().getText().length() >= i;
    }

    private void fG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gkw)) {
                this.gkw = "";
                bus().requestFocus();
                if (bus().getText() != null && bus().getText().length() + str.length() > 5000) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = bus().getSelectionStart();
                    editable = bus().getText();
                }
            } else if ("from_title".equals(this.gkw)) {
                this.gkw = "";
                but().requestFocus();
                if (but().getText() != null && but().getText().length() + str.length() > 31) {
                    showToast(w.l.over_limit_tip);
                    return;
                } else {
                    i = but().getSelectionStart();
                    editable = but().getText();
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
    public void mE(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bus().getText().getSpans(0, bus().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gkL == null) {
                this.gkL = Toast.makeText(getPageContext().getPageActivity(), w.l.too_many_face, 0);
            }
            this.gkL.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xW = lVar.xW();
        if (name != null) {
            com.baidu.adp.lib.f.c.fL().a(name, 20, new aw(this, new SpannableStringBuilder(name), xW), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bus() != null && bus().getText() != null) {
            Bitmap kP = aVar.kP();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kP);
            int width = kP.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT) {
                bitmapDrawable.setBounds(0, 0, width, kP.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bus().getSelectionStart() - 1;
                if (bus().getText().length() > 1 && selectionStart >= 0 && bus().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bus().getText().insert(bus().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bus().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bus().getText().insert(bus().getSelectionStart(), spannableString2);
            }
            Editable text = bus().getText();
            if (text != null) {
                this.glG.clear();
                this.glG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.glG);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bus().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bus().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bus().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bus() {
        return this.gll ? this.glc : this.fCD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText but() {
        return this.gll ? this.glg : this.fCz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buu() {
        Editable text;
        if (bus() != null && (text = bus().getText()) != null) {
            int selectionStart = bus().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bus().onKeyDown(67, this.gkG);
            }
            bus().onKeyDown(67, this.gkG);
            int selectionStart2 = bus().getSelectionStart();
            if (text != null) {
                this.glG.clear();
                this.glG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.glG);
                bus().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(w.l.feedback_bar_name).equals(str)) {
            this.gky = true;
        }
    }

    private void buv() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void buw() {
        try {
            if (this.gkI != null) {
                this.gkI.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aJN.c(null);
        this.aJN.cY(w.l.sending);
        this.aJN.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aJN.aI(false);
    }

    private Boolean bux() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aBJ = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bis() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (but() != null) {
                str = but().getText().toString();
            }
            if (bus() != null) {
                str2 = bus().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fCh == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            mF(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        mF(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    mF(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gll) {
                    mF(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    mF(true);
                }
            }
            if (this.mData.getType() == 4) {
                mF(j(this.glc) && i(this.glg));
            } else if (this.mData.getType() == 5) {
                mF(j(this.glc));
            } else if (!TextUtils.isEmpty(str2) || this.aBB != null) {
                mF(true);
            } else if (this.mData.getVideoInfo() != null) {
                mF(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                mF(true);
            } else {
                mF(false);
            }
        }
    }

    private void mF(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.as.b(this.mPost, w.e.cp_link_tip_a, w.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.as.c(this.mPost, w.e.cp_cont_d, 1);
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
        String stringExtra;
        this.aBE = new NewWriteModel(this);
        this.aBE.b(this.aBU);
        registerListener(this.glI);
        this.mDialogCancelListener = new ax(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.gky = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gkA = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gkJ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gkK = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aBC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gkM = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gkM != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gkR = bundle.getInt("mem_type", 0);
            this.ahE = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.glD = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.ggZ = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gky = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gkA = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gkJ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gkK = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gkM = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gkM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gkR = intent.getIntExtra("mem_type", 0);
            this.ahE = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.glD = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.ggZ = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gky);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.x.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.x.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            com.baidu.tieba.tbadkCore.x.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            com.baidu.tieba.tbadkCore.x.c(String.valueOf(this.mData.getForumId()) + "photolive", this);
        } else if (this.mData.getType() == 5) {
            com.baidu.tieba.tbadkCore.x.a(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(w.l.write_no_prefix));
        }
        this.dSk = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.gkz = true;
        }
        buk();
        try {
            this.gln = buF();
        } catch (Throwable th) {
            this.gln = null;
        }
    }

    private void buy() {
        if (com.baidu.tbadk.core.util.z.s(this.mList) > 0 && this.mList.get(0) != null) {
            this.giz.setVisibility(8);
            this.glz.setVisibility(0);
            this.glA.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fCz.setText(com.baidu.tbadk.plugins.a.gs(sx(this.mList.get(0).mTopicName)));
                this.fCz.setMovementMethod(com.baidu.tieba.view.g.bqB());
            }
            this.glB.setText(this.mList.get(0).mForumName);
            this.fCz.addTextChangedListener(new ay(this));
            this.glC.setOnClickListener(new az(this));
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gs = com.baidu.tbadk.plugins.a.gs(sx(hotTopicBussinessData.mTopicName));
            if (gs != null) {
                this.fCz.setText(gs);
            }
            this.glB.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String sx(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        String sx;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle())) {
                    this.eiG.setVisibility(0);
                    this.eiG.requestFocus();
                    this.azR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (com.baidu.adp.lib.util.j.isEmpty(but().getText().toString()) || this.glv || ((this.gky || this.gkz) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.z.t(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.z.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            sx = this.mData.getTitle();
                        } else {
                            sx = sx(str);
                        }
                        SpannableString gs = com.baidu.tbadk.plugins.a.gs(sx);
                        if (gs != null) {
                            but().setText(gs);
                            but().setSelection(sx.length());
                        }
                    } else {
                        but().setText(com.baidu.tbadk.plugins.a.gs(this.mData.getTitle()));
                        but().setSelection(this.mData.getTitle().length());
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    buj();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.azR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bus().getText().toString()) || this.gky || this.gkz) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ea().a(getPageContext().getPageActivity(), this.mData.getContent(), this.glJ);
                    bus().setText(a2);
                    bus().setSelection(a2.length());
                    if (this.gll) {
                        b(this.gli, this.glc);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    buE();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Dt();
                    }
                    mG(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    buz();
                }
                bis();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gkS != null) {
                    this.gkW = this.gkT.ceQ;
                    this.gkV = this.gkT.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gkS.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bq bqVar = this.gkS.get(i);
                        if (categoryTo != bqVar.ceQ) {
                            i++;
                        } else {
                            this.gkW = categoryTo;
                            this.gkV = bqVar.name;
                            this.mData.setCategoryTo(this.gkW);
                            break;
                        }
                    }
                    if (this.gkX != null) {
                        this.gkX.setText(this.gkV);
                        this.gkX.b(this.gkS, this.gkT, this.gkW);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.azR.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.azR.Bb();
                return;
            }
            return;
        }
        buz();
        buj();
    }

    private void buz() {
        if ((!this.gll || this.gla != null) && this.gkZ != null) {
            this.gla.c(this.writeImagesInfo);
            aEk();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gkJ);
        if (this.gky) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBC);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gkM);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gkR);
        bundle.putString("from", this.ahE);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.ggZ);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bus().getEditableText().toString();
        if (editable != null) {
            bus().setText(TbFaceManager.Ea().a(getPageContext().getPageActivity(), editable, this.glJ));
            bus().setSelection(bus().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buA() {
        return (bus() == null || bus().getText() == null) ? "" : bus().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || but() == null || but().getText() == null) {
            return "";
        }
        String editable = but().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.z.s(this.mPrefixData.getPrefixs()) > 0 && this.fCh != 0 && this.mData.getType() != 4 && this.fCE != null && this.fCE.getText() != null) {
            editable = String.valueOf(this.fCE.getText().toString()) + editable;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle();
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btA() {
        bik();
        this.mData.setContent(buA());
        this.mData.setTitle(getThreadTitle());
        if (this.gky || this.gkz) {
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
        if (this.gkU >= 0) {
            this.mData.setCategoryFrom(this.gkU);
        }
        if (this.gkW >= 0) {
            this.mData.setCategoryTo(this.gkW);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aBD != null && this.aBD.Sy());
        this.aBE.lW(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.z.t(this.mList) && this.gly != null && this.gly.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gly.mForumId));
            this.mData.setForumName(this.gly.mForumName);
        }
        this.aBE.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aBB != null) {
            if (this.aBB.getId() != null) {
                this.aBE.getWriteData().setVoice(this.aBB.getId());
                this.aBE.getWriteData().setVoiceDuringTime(this.aBB.duration);
            } else {
                this.aBE.getWriteData().setVoice(null);
                this.aBE.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aBE.getWriteData().setVoice(null);
            this.aBE.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aBE.bnA()) {
            showToast(w.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(w.l.sending), this.mDialogCancelListener);
            this.aBE.startPostWrite();
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
            if (this.gkM != null) {
                i2 = this.gkM.getTotalCount();
                i = this.gkM.getAlreadyCount() + 1;
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
                if (this.azR != null && !this.azR.CJ()) {
                    bus().requestFocus();
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
                            bus().getText().insert(bus().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.mData.getType() == 0) {
                    com.baidu.tieba.tbadkCore.x.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    com.baidu.tieba.tbadkCore.x.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    com.baidu.tieba.tbadkCore.x.b(String.valueOf(this.mData.getForumId()) + "photolive", (WriteData) null);
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
                                aYs();
                            } else {
                                ad(intent);
                            }
                        } else if (intExtra == 1) {
                            W(intent);
                        } else {
                            ac(intent);
                            com.baidu.adp.lib.g.h.fR().post(new ba(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gll) {
                        B(intent);
                        bis();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.azR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.azR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.azR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bis();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.M(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gkx) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gkx = false;
                            }
                            sb2.append(stringExtra);
                            fG(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.z.t(this.mList)) {
                    if (!com.baidu.tbadk.core.util.z.t(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gly = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gly);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.glw.aa(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.ggT = this.glw.bru();
                        this.azR.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.glx) {
                        buB();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.azR != null && !this.azR.CJ()) {
                this.fCD.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Do();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    buD();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aBC = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ar.b(getPageContext(), this.aBC);
                    return;
                case 12012:
                    buD();
                    return;
                case 25004:
                    if ("from_title".equals(this.gkw)) {
                        but().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gkw)) {
                        bus().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buB() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.glw.brt());
        this.mData.setCallFrom(this.ggZ);
        this.mData.setRecommendExt(this.glw.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        btA();
    }

    private void buC() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void buD() {
        if (this.gll) {
            this.gla.c(this.writeImagesInfo);
            aEk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEk() {
        this.gla.notifyDataSetChanged();
        this.gkZ.invalidate();
        this.mHandler.postDelayed(new bc(this), 550L);
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bis();
    }

    private void ac(Intent intent) {
        if (this.gll) {
            af(intent);
            buD();
        } else {
            ag(intent);
        }
        bis();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            buD();
            mG(true);
        }
    }

    private void ad(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aYs() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void W(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.feL.parseJson(stringExtra);
            this.feL.updateQuality();
            if (this.feL.getChosedFiles() != null && this.feL.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.feL.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.feL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, but());
        HidenSoftKeyPad(this.mInputManager, bus());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ag(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aBC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aBC, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            buE();
            Dt();
        }
        mG(true);
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
                buE();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Dt();
                }
            }
            mG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buE() {
        if (this.azR.eA(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void Do() {
        new bd(this).execute(new Void[0]);
    }

    private void mG(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cci == null) {
            this.cci = VoiceManager.instance();
        }
        return this.cci;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aei() {
        this.cci = getVoiceManager();
        this.cci.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.sK(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gkM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aBL = i;
        if (this.azR != null) {
            this.azR.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.azR.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Dt() {
        if (!this.gll) {
            if (this.azR != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.azR.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.azR.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.azR.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.azR.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gkY != null) {
                if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                    this.gkY.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
                } else {
                    this.gkY.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                }
                this.gkY.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gkY.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.azR != null) {
            this.azR.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void tY(int i) {
        if (i < this.gjA.size()) {
            for (int i2 = 0; i2 < this.gjA.size(); i2++) {
                this.gjA.get(i2).mt(false);
            }
            this.gjA.get(i).mt(true);
        }
    }

    @Override // com.baidu.tieba.write.p.a
    public void si(int i) {
        this.fCh = i;
        this.fCF.tz(i);
        tY(i);
        this.fCE.setText(this.mPrefixData.getPrefixs().get(i));
        bis();
        com.baidu.adp.lib.g.j.a(this.fCF, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fCH.setSelected(false);
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
            Dj();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ar.b(getPageContext(), this.aBC);
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
        if (this.glt && System.currentTimeMillis() - this.glu < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.glt = false;
        }
        if (this.glH != null && !z) {
            this.glH.bsL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.glq != null) {
            sz(str);
            this.glq.dismiss();
        }
    }

    private void bQ(Context context) {
        gls = com.baidu.adp.lib.util.k.ag(context);
    }

    private void sz(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.glt = true;
        buE();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Dt();
        }
        mG(true);
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

    private File buF() {
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

    private void buG() {
        if (this.gln != null && this.mData.getType() == 0) {
            bQ(getActivity());
            this.glp = getPageContext().getPageActivity().getLayoutInflater().inflate(w.j.rec_dialog, (ViewGroup) null);
            this.glp.setOnClickListener(new be(this));
            this.glo = (TbImageView) this.glp.findViewById(w.h.rec_img_view);
            this.glr = (LinearLayout) this.glp.findViewById(w.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gln.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gln.getAbsolutePath());
                Bitmap c = c(this.gln.getAbsolutePath(), getResources().getDimensionPixelSize(w.f.ds160));
                if (c != null) {
                    this.glo.setImageBitmap(c);
                    this.glo.setDrawBorder(true);
                    this.glo.setBorderWidth(2);
                    this.glo.setBorderColor(com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10264));
                    this.glq = new Dialog(getActivity(), w.m.bubble_dialog);
                    this.glq.setCanceledOnTouchOutside(true);
                    this.glq.setOnDismissListener(new bf(this));
                    this.glq.setContentView(this.glp);
                    this.glq.show();
                    Window window = this.glq.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(w.f.ds28);
                    attributes.y = (gls / 18) + getResources().getDimensionPixelSize(w.f.ds12);
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
            this.gkx = false;
            this.gkw = "";
            if ("from_content".equals(str)) {
                this.gkw = "from_content";
            } else if ("from_title".equals(str)) {
                this.gkw = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                mE(false);
            }
        }
    }

    public void Bd() {
        if (this.gky || !com.baidu.tbadk.core.util.z.t(this.mList)) {
            this.eiG.setVisibility(0);
            this.eiG.requestFocus();
            this.azR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.eiG.setVisibility(8);
    }
}
