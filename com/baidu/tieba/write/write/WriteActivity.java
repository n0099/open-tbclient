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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, aa.a, b.a {
    private static int fLR = 0;
    private String aci;
    private com.baidu.tbadk.editortools.j ats;
    private VoiceData.VoiceModel avb;
    private String avc;
    private LocationModel avd;
    private NewWriteModel ave;
    private VoiceManager bFE;
    List<com.baidu.tieba.frs.bt> cfO;
    private String cfZ;
    private HotTopicBussinessData fLV;
    private View fLW;
    private View fLX;
    private TextView fLY;
    private TextView fLZ;
    private LinearLayout fLd;
    private View fLg;
    private View fLh;
    private Toast fLn;
    private AdditionData fLo;
    private RelativeLayout fLp;
    private TextView fLq;
    private TextView fLr;
    private TextView fLs;
    com.baidu.tieba.frs.bt fLu;
    private int fLv;
    private int fLw;
    private PostCategoryView fLx;
    private com.baidu.tieba.view.c fMk;
    private int ffH;
    private TextView fge;
    private com.baidu.tieba.write.b fgf;
    private ImageView fgg;
    private View fgh;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String fKY = "";
    private boolean fKZ = false;
    private WriteData mData = null;
    private boolean fLa = false;
    private boolean fLb = false;
    private boolean fLc = false;
    private InputMethodManager mInputManager = null;
    private EditText ffZ = null;
    private HeadImageView fJf = null;
    private View fga = null;
    private LinearLayout fgc = null;
    private EditText fgd = null;
    private FeedBackModel fLe = null;
    private FeedBackTopListView fLf = null;
    private ArrayList<com.baidu.tieba.write.a> fKb = new ArrayList<>();
    private String dIu = null;
    private final KeyEvent fLi = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aiC = null;
    private TextView fLj = null;
    private TextView mPost = null;
    private TextView aUd = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a fLk = null;
    private final Handler mHandler = new Handler();
    private boolean fLl = false;
    private String fLm = null;
    private RelativeLayout mParent = null;
    private String avj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int avl = 0;
    private int fLt = 0;
    private WriteImagesInfo eLW = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fLy = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fLz = null;
    private ScrollView fLA = null;
    private EditText fLB = null;
    private View fLC = null;
    private View fLD = null;
    private View fLE = null;
    private EditText fLF = null;
    private TextView fLG = null;
    private TextView fLH = null;
    private TextWatcher fLI = null;
    private TextWatcher fLJ = null;
    private boolean fLK = false;
    private boolean fLL = false;
    private com.baidu.tbadk.core.view.a aCT = null;
    private File fLM = null;
    private TbImageView fLN = null;
    private View fLO = null;
    private Dialog fLP = null;
    private LinearLayout fLQ = null;
    private boolean fLS = false;
    private long fLT = -1000;
    private boolean fLU = false;
    private String fMa = "";
    private String fMb = "";
    private int fMc = 0;
    private SpannableStringBuilder fMd = new SpannableStringBuilder();
    private final HttpMessageListener fMe = new u(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fMf = new af(this);
    private final NewWriteModel.d avt = new ar(this);
    private final LocationModel.a avr = new bc(this);
    private final CustomMessageListener frM = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fMg = new bg(this);
    private boolean fMh = true;
    private final View.OnFocusChangeListener ffX = new bh(this);
    private TextWatcher fMi = new bi(this);
    private TextWatcher fMj = new bj(this);
    private final a.InterfaceC0074a epC = new v(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aci)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Da() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(r.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Db();
        } else if (this.avd.bix()) {
            CZ();
        } else {
            this.avd.lk(false);
            b(1, true, null);
            this.avd.biv();
        }
    }

    private void Db() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(r.l.location_app_permission_prompt).a(r.l.isopen, new w(this)).b(r.l.cancel, new x(this)).b(getPageContext());
        aVar.sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int boE() {
        int selectionEnd = boU().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) boU().getText().getSpans(0, boU().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = boU().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = boU().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boF() {
        if (this.ats != null) {
            this.ats.setBarLauncherEnabled(!this.fMh);
            this.ats.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fLK) {
            this.ffZ.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.fLE.setVisibility(8);
            } else {
                this.fLE.setVisibility(0);
            }
            b(this.fLH, this.fLB);
            b(this.fLG, this.fLF);
            bdH();
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
        boQ();
        this.avd = new LocationModel(this);
        this.avd.a(this.avr);
        registerListener(this.frM);
        initEditor();
        bph();
        if (this.fLK) {
            this.fLz.setEditorTools(this.ats);
        } else {
            this.ffZ.requestFocus();
        }
    }

    private void initEditor() {
        this.ats = new com.baidu.tbadk.editortools.j(getActivity());
        this.ats.setBarMaxLauCount(5);
        this.ats.setMoreButtonAtEnd(true);
        this.ats.setBarLauncherType(1);
        this.ats.bD(true);
        this.ats.bC(true);
        this.ats.setMoreLauncherIcon(r.g.write_more);
        this.ats.setBackgroundColorId(r.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                boI();
                break;
            default:
                boJ();
                break;
        }
        this.ats.Cx();
        if (this.fLd != null) {
            this.fLd.addView(this.ats);
        }
        boK();
        this.ats.lr();
        com.baidu.tbadk.editortools.p eB = this.ats.eB(6);
        if (eB != null && !TextUtils.isEmpty(this.avj)) {
            ((View) eB).setOnClickListener(new y(this));
        }
        if (!this.fLK) {
            this.ats.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ats.AK();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("xiaoying_has_click", false)) {
            this.ats.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("hot_topic_has_click", false)) {
            this.ats.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void boG() {
        this.fLC = this.mRootView.findViewById(r.h.photo_live_scroll);
        this.fLE = this.fLC.findViewById(r.h.live_post_title_container);
        this.fLB = (EditText) this.fLC.findViewById(r.h.live_post_content);
        this.fLy = (GridView) this.fLC.findViewById(r.h.photoLiveGridView);
        this.fLF = (EditText) this.fLC.findViewById(r.h.live_post_title);
        this.fLG = (TextView) this.fLC.findViewById(r.h.titleOverPlusNumber);
        this.fLH = (TextView) this.fLC.findViewById(r.h.contentOverPlusNumber);
        this.fLD = this.fLC.findViewById(r.h.live_interval_view);
        this.fLG.setText(String.valueOf(20));
        this.fLH.setText(String.valueOf(233));
        this.fLC.setVisibility(0);
        this.fLG.setVisibility(0);
        this.fLH.setVisibility(0);
        this.fLF.setHint(r.l.tips_title_limit_new);
        this.fLF.setOnFocusChangeListener(new z(this));
        if (this.mData.getType() == 4) {
            this.fLB.setHint(r.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.fLB.setHint(r.l.live_write_input_content_update);
        }
        this.fLB.setOnFocusChangeListener(new aa(this));
        this.fLB.requestFocus();
        this.fLB.addTextChangedListener(aTi());
        this.fLF.requestFocus();
        this.fLF.addTextChangedListener(aTi());
        this.fLF.setOnClickListener(this.fMg);
        this.fLB.setOnClickListener(this.fMg);
        this.fLz = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fLy);
        this.fLz.sX(6);
        this.fLy.setAdapter((ListAdapter) this.fLz);
        View findViewById = this.fLC.findViewById(r.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ab(this));
        boH();
    }

    private void boH() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.fLF.setText(this.mData.getTitle());
                this.fLF.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fLK) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bpc();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Dk();
            return;
        }
        if (this.ats.Cz()) {
            this.ats.AK();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fLK) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void boI() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ats.w(arrayList);
        com.baidu.tbadk.editortools.x eD = this.ats.eD(5);
        if (eD != null) {
            eD.atY = 2;
            eD.atW = r.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.atW = r.g.write_at;
        this.ats.b(aVar);
        this.ats.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void boJ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.x xVar;
        com.baidu.tbadk.editortools.x xVar2;
        com.baidu.tbadk.editortools.x xVar3;
        com.baidu.tbadk.editortools.x xVar4;
        com.baidu.tbadk.editortools.x xVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.atW = r.g.write_picture;
        this.ats.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.ats.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.ats.b(aVar);
        aVar.atW = r.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask2 != null && (xVar5 = (com.baidu.tbadk.editortools.x) runTask2.getData()) != null) {
            xVar5.aua = true;
            xVar5.atW = r.g.write_graffiti;
            xVar5.atY = 4;
            this.ats.b(xVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask3 != null && (xVar4 = (com.baidu.tbadk.editortools.x) runTask3.getData()) != null) {
            xVar4.atY = 5;
            xVar4.atW = r.g.write_privilege;
            this.ats.b(xVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.atW = r.g.write_at;
        this.ats.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask4 != null && (xVar3 = (com.baidu.tbadk.editortools.x) runTask4.getData()) != null) {
            xVar3.aua = true;
            xVar3.atY = 9;
            xVar3.atW = 0;
            this.ats.b(xVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.x.class);
        if (runTask5 != null && (xVar2 = (com.baidu.tbadk.editortools.x) runTask5.getData()) != null) {
            xVar2.aua = true;
            xVar2.atY = 10;
            xVar2.atW = 0;
            this.ats.b(xVar2);
        }
        Boolean boZ = boZ();
        if (!this.fLa && boZ != null && boZ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.biS() && com.baidu.tieba.tbadkCore.s.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.x.class)) != null && (xVar = (com.baidu.tbadk.editortools.x) runTask.getData()) != null) {
            xVar.atY = 6;
            xVar.atW = r.g.write_recorder;
            this.ats.b(xVar);
        }
        if (this.fLo == null) {
            this.ats.b(new com.baidu.tieba.write.b.c(getActivity()));
        }
        this.ats.w(arrayList);
        com.baidu.tbadk.editortools.x eD = this.ats.eD(5);
        if (eD != null) {
            eD.atY = 1;
            eD.atW = r.g.write_emotion;
        }
    }

    private void boK() {
        ac acVar = new ac(this);
        this.ats.a(16, acVar);
        this.ats.a(14, acVar);
        this.ats.a(24, acVar);
        this.ats.a(3, acVar);
        this.ats.a(10, acVar);
        this.ats.a(11, acVar);
        this.ats.a(12, acVar);
        this.ats.a(13, acVar);
        this.ats.a(15, acVar);
        this.ats.a(18, acVar);
        this.ats.a(25, acVar);
        this.ats.a(27, acVar);
        this.ats.a(29, acVar);
        this.ats.a(40, acVar);
        this.ats.a(43, acVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc() {
        if (this.avd.OH()) {
            if (this.avd.bix()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bit().getLocationData().bip());
                return;
            }
            b(1, true, null);
            this.avd.biv();
            return;
        }
        b(0, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdz() {
        if (this.ave != null) {
            this.ave.cancelLoadData();
        }
        if (this.fLe != null) {
            this.fLe.cancelLoadData();
        }
        if (this.avd != null) {
            this.avd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bdz();
        boY();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bod() {
        if (this.mData != null && this.mData.getType() == 2 && this.fLl) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(boV().getText().toString());
            this.mData.setContent(boU().getText().toString());
            int type = this.mData.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.aa.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.aa.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.aa.b(String.valueOf(this.mData.getForumId()) + "photolive", this.mData);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.aa.c(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fgf != null && this.fgf.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.fgf, getPageContext().getPageActivity());
                return true;
            } else if (this.ats.Cz()) {
                this.ats.AK();
                return true;
            } else {
                bdz();
                bod();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.mParent);
        getLayoutMode().v(this.fLQ);
        if (this.fLN != null && i == 1) {
            this.fLN.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ap.c(this.mPost, r.e.cp_link_tip_a, 1);
        boF();
        com.baidu.tbadk.core.util.ap.k(this.fLC, r.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.k(this.fga, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(this.fLD, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(boV(), r.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dIu)) {
            com.baidu.tbadk.core.util.ap.k(boU(), r.e.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_e);
        boV().setTextColor(color);
        boU().setTextColor(color);
        a(boV(), color2);
        a(boU(), color2);
        bdH();
        this.ats.onChangeSkinType(i);
        if (this.fLx != null) {
            this.fLx.ws();
        }
        com.baidu.tbadk.core.util.ap.i((View) this.aUd, r.e.cp_cont_f);
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
        this.aCT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fLK = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(r.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.aiC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiC.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.e(getActivity(), r.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aiC != null && (this.aiC.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aiC.getLayoutParams();
            layoutParams2.width = -2;
            this.aiC.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.g.icon_nav_close_selector, r.g.icon_nav_close_selector);
        this.aUd = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.ap.i((View) this.aUd, r.e.cp_cont_f);
        this.fLj = (TextView) findViewById(r.h.btn_image_problem);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.l.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.f.ds10);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.ffX);
        this.fLA = (ScrollView) findViewById(r.h.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fLf = (FeedBackTopListView) findViewById(r.h.feedback_top_list);
        this.fLg = findViewById(r.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(r.h.parent);
        this.fLd = (LinearLayout) findViewById(r.h.tool_view);
        this.fLd.setContentDescription("..");
        this.fga = findViewById(r.h.interval_view);
        this.fLW = findViewById(r.h.hot_topic_fourm_view);
        this.fLX = findViewById(r.h.hot_topic_divider);
        this.fLY = (TextView) findViewById(r.h.hot_topic_title_edt);
        this.fLZ = (TextView) findViewById(r.h.change_one_tv);
        bdG();
        if (this.fLK) {
            this.fLA.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            boG();
        }
        bdI();
        if (this.fLa || this.fLb) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(r.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(r.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fgc = (LinearLayout) findViewById(r.h.post_content_container);
        this.fgc.setDrawingCacheEnabled(false);
        this.fgc.setOnClickListener(new ad(this));
        this.aiC.setOnFocusChangeListener(this.ffX);
        this.aiC.setOnClickListener(new ae(this));
        this.fLj.setOnClickListener(new ag(this));
        boN();
        k(boZ());
        boR();
        switch (this.mData.getType()) {
            case 0:
                if (this.fLa || this.fLb) {
                    if (this.fLc) {
                        this.aUd.setText(r.l.feedback_vcode);
                    } else {
                        this.aUd.setText(r.l.feedback);
                    }
                } else {
                    this.aUd.setText(r.l.post_new_thread);
                }
                this.ffZ.setVisibility(0);
                this.fgd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            default:
                this.aUd.setText(r.l.send_reply);
                this.fgd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.ffZ.setVisibility(8);
                break;
            case 4:
                this.aUd.setText(r.l.publish_photo_live);
                this.fgd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.aUd.setText(getPageContext().getResources().getString(r.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.fLD.setVisibility(8);
                break;
        }
        boS();
        boX();
        boF();
        boP();
        bdF();
        if (com.baidu.tbadk.core.util.w.s(this.mList) || this.mList.get(0) == null) {
            this.ffZ.getPaint().setFakeBoldText(true);
        } else {
            this.ffZ.getPaint().setFakeBoldText(false);
            bpa();
        }
        if (this.mData.getType() == 4 && this.fgh != null && this.fLh != null) {
            this.fgh.setVisibility(8);
            this.fLh.setVisibility(8);
        }
        bdH();
        ShowSoftKeyPad(this.mInputManager, this.ffZ);
        boO();
    }

    private void boL() {
        if (this.mData != null && this.mData.getType() == 0 && !this.fLa && !this.fLb && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = com.baidu.tbadk.core.util.at.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && boV() != null) {
                boV().setText(c);
                boV().setSelection(c.length());
            }
        }
    }

    private void boM() {
        this.cfO = null;
        this.fLv = -1;
        this.fLw = -1;
        com.baidu.tieba.frs.bv hV = com.baidu.tieba.frs.bu.Ze().hV(1);
        if (hV != null) {
            this.cfO = hV.bIU;
            this.fLv = getIntent().getIntExtra("category_id", -1);
            if (this.cfO != null && !this.cfO.isEmpty() && this.fLv >= 0) {
                this.fLu = new com.baidu.tieba.frs.bt();
                this.fLu.bIQ = 0;
                this.fLu.name = getPageContext().getResources().getString(r.l.category_auto);
                this.fLw = this.fLu.bIQ;
                this.cfZ = this.fLu.name;
                for (com.baidu.tieba.frs.bt btVar : this.cfO) {
                    if (btVar.bIQ == this.fLv) {
                        this.fLw = btVar.bIQ;
                        this.cfZ = btVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void boN() {
        if (this.cfO != null && !this.cfO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(r.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(r.h.interval_view_cate).setVisibility(0);
            this.fLx = (PostCategoryView) linearLayout.findViewById(r.h.category_selected);
            this.fLx.setText(this.cfZ);
            this.fLx.b(this.cfO, this.fLu, this.fLw);
            this.fLx.setCategoryContainerClickCallback(new ah(this));
            linearLayout.setOnClickListener(new ai(this));
        }
    }

    private void boO() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fMk = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new aj(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fMk.setTitle(r.l.no_disturb_start_time);
        this.fMk.setButton(-1, getPageContext().getString(r.l.alert_yes_button), this.fMk);
        this.fMk.setButton(-2, getPageContext().getString(r.l.alert_no_button), this.fMk);
        return this.fMk;
    }

    private void boP() {
        this.fLp = (RelativeLayout) findViewById(r.h.addition_container);
        this.fLq = (TextView) findViewById(r.h.addition_create_time);
        this.fLr = (TextView) findViewById(r.h.addition_last_time);
        this.fLs = (TextView) findViewById(r.h.addition_last_content);
        if (this.fLo != null) {
            this.fLp.setVisibility(0);
            this.fLq.setText(String.valueOf(getPageContext().getString(r.l.write_addition_create)) + com.baidu.tbadk.core.util.at.r(this.fLo.getCreateTime() * 1000));
            if (this.fLo.getAlreadyCount() == 0) {
                this.fLr.setVisibility(8);
            } else {
                this.fLr.setText(String.valueOf(getPageContext().getString(r.l.write_addition_last)) + com.baidu.tbadk.core.util.at.r(this.fLo.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fLo.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fLs.setText(lastAdditionContent);
            } else {
                this.fLs.setVisibility(8);
            }
            boU().setHint(String.format(getPageContext().getString(r.l.write_addition_hint), Integer.valueOf(this.fLo.getAlreadyCount()), Integer.valueOf(this.fLo.getTotalCount())));
            this.aUd.setText(r.l.write_addition_title);
            return;
        }
        this.fLp.setVisibility(8);
    }

    private void bdF() {
        this.fgh = findViewById(r.h.post_prefix_layout);
        this.fge = (TextView) findViewById(r.h.post_prefix);
        this.fLh = findViewById(r.h.prefix_divider);
        this.fgg = (ImageView) findViewById(r.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fgh.setVisibility(0);
            this.fLh.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ffH = 1;
            this.fgh.setOnClickListener(new ak(this));
            this.fgg = (ImageView) findViewById(r.h.prefix_icon);
            if (size > 1) {
                this.fgg.setVisibility(0);
                this.fge.setOnClickListener(new al(this));
            }
            this.fgf = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fgf.a(this);
            this.fgf.setMaxHeight(com.baidu.adp.lib.util.k.e(getActivity(), r.f.ds510));
            this.fgf.setOutsideTouchable(true);
            this.fgf.setFocusable(true);
            this.fgf.setOnDismissListener(this);
            this.fgf.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.getDrawable(r.e.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_c);
            com.baidu.tbadk.core.util.ap.j((View) this.fge, r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.c(this.fgg, r.g.icon_title_down);
            this.fge.setTextColor(color);
            this.fKb.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fKb.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fgf.addView(aVar);
            }
            this.fgf.sN(0);
            this.fge.setText(prefixs.get(1));
            th(1);
            return;
        }
        this.fgh.setVisibility(8);
    }

    private void boQ() {
        if (this.fLa && this.mData != null) {
            this.fLf.setVisibility(0);
            this.fLg.setVisibility(0);
            this.fLe = new FeedBackModel(this);
            this.fLe.rK(this.mData.getForumName());
            this.fLe.setLoadDataCallBack(new am(this));
        }
    }

    protected void boR() {
        this.mPost.setOnClickListener(new an(this));
    }

    protected void boS() {
        this.fLk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fLk.cE(getPageContext().getString(r.l.is_save_draft)).au(false).a(getPageContext().getString(r.l.save), new ao(this)).b(getPageContext().getString(r.l.not_save), new aq(this));
        this.fLk.b(getPageContext());
    }

    protected void bdG() {
        this.fJf = (HeadImageView) findViewById(r.h.user_head_portrait);
        this.fJf.setIsRound(true);
        this.fJf.setDrawBorder(false);
        this.fJf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = com.baidu.tbadk.core.util.p.dn(currentPortrait);
            this.fJf.setUrl(dn);
            this.fJf.c(dn, 12, false);
        }
        this.ffZ = (EditText) findViewById(r.h.post_title);
        this.ffZ.setOnClickListener(this.fMg);
        this.ffZ.setOnFocusChangeListener(this.ffX);
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.ffZ.setText(this.mData.getTitle());
                this.ffZ.setSelection(this.mData.getTitle().length());
            } else if (this.fLc) {
                this.ffZ.setText(getResources().getString(r.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
        this.ffZ.addTextChangedListener(this.fMi);
        if (!this.mData.getHaveDraft()) {
            boL();
            this.fLU = true;
        }
    }

    private TextWatcher aTi() {
        as asVar = new as(this);
        if (this.fLK && this.fLL) {
            if (this.fLI != null) {
                this.fLF.removeTextChangedListener(this.fLI);
            }
            this.fLI = asVar;
        } else if (this.fLK) {
            if (this.fLJ != null) {
                this.fLB.removeTextChangedListener(this.fLJ);
            }
            this.fLJ = asVar;
        }
        return asVar;
    }

    private long h(EditText editText) {
        if (editText == this.fLB) {
            return 233L;
        }
        if (editText != this.fLF) {
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
                    textView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.d.a.g(editText.getText().toString().trim());
    }

    protected void bdI() {
        this.fgd = (EditText) findViewById(r.h.post_content);
        this.fgd.setDrawingCacheEnabled(false);
        this.fgd.setOnClickListener(this.fMg);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString z = TbFaceManager.DR().z(getPageContext().getPageActivity(), this.mData.getContent());
            this.fgd.setText(z);
            this.fgd.setSelection(z.length());
        } else if (this.mData.getType() == 2) {
            if (this.fLl) {
                if (this.fLm != null && this.fLm.length() > 0) {
                    this.fgd.setText(getPageContext().getPageActivity().getString(r.l.reply_sub_floor, new Object[]{this.fLm}));
                    this.fgd.setSelection(this.fgd.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(r.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.fgd.setText(format);
                this.fgd.setSelection(format.length());
            }
        }
        this.fgd.setOnFocusChangeListener(this.ffX);
        this.fgd.setOnTouchListener(new at(this));
        this.fgd.addTextChangedListener(this.fMj);
        lO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fLK) {
            boU().setPadding(0, 0, 0, 0);
            boU().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ap.k(boU(), r.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dIu) && this.fLo == null) {
                com.baidu.adp.lib.f.c.ey().a(this.dIu, 19, new au(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boT() {
        int i = 5000;
        if (this.fLo != null) {
            i = 1000;
        }
        return boU().getText() != null && boU().getText().length() >= i;
    }

    private void fw(String str) {
        if (!StringUtils.isNull(str)) {
            if ("from_content".equals(this.fKY)) {
                this.fKY = "";
                boU().requestFocus();
                if (boU().getText() != null && boU().getText().length() + str.length() > 5000) {
                    showToast(r.l.over_limit_tip);
                    return;
                }
                boU().getText().insert(boU().getSelectionStart(), str);
            } else if ("from_title".equals(this.fKY)) {
                this.fKY = "";
                boV().requestFocus();
                if (boV().getText() != null && boV().getText().length() + str.length() > 31) {
                    showToast(r.l.over_limit_tip);
                    return;
                }
                boV().getText().insert(boV().getSelectionStart(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) boU().getText().getSpans(0, boU().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fLn == null) {
                this.fLn = Toast.makeText(getPageContext().getPageActivity(), r.l.too_many_face, 0);
            }
            this.fLn.show();
            return;
        }
        String name = lVar.getName();
        EmotionGroupType xE = lVar.xE();
        if (name != null) {
            com.baidu.adp.lib.f.c.ey().a(name, 20, new av(this, new SpannableStringBuilder(name), xE), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && boU() != null) {
            Bitmap jT = aVar.jT();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(jT);
            int width = jT.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (0.5d * width);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            boU().getText().insert(i, spannableStringBuilder);
            Editable text = boU().getText();
            if (text != null) {
                this.fMd.clear();
                this.fMd.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fMd);
                boU().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText boU() {
        return this.fLK ? this.fLB : this.fgd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText boV() {
        return this.fLK ? this.fLF : this.ffZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boW() {
        if (boU() != null) {
            boU().onKeyDown(67, this.fLi);
            int selectionStart = boU().getSelectionStart();
            Editable text = boU().getText();
            if (text != null) {
                this.fMd.clear();
                this.fMd.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.fMd);
                boU().setSelection(selectionStart);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(r.l.feedback_bar_name).equals(str)) {
            this.fLa = true;
        }
    }

    private void boX() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void boY() {
        try {
            if (this.fLk != null) {
                this.fLk.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aCT.c(null);
        this.aCT.da(r.l.sending);
        this.aCT.aJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aCT.aJ(false);
    }

    private Boolean boZ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.avj = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdH() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (boV() != null) {
                str = boV().getText().toString();
            }
            if (boU() != null) {
                str2 = boU().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ffH == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            lQ(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        lQ(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    lQ(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fLK) {
                    lQ(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lQ(true);
                }
            }
            if (this.mData.getType() == 4) {
                lQ(j(this.fLB) && i(this.fLF));
            } else if (this.mData.getType() == 5) {
                lQ(j(this.fLB));
            } else if (!TextUtils.isEmpty(str2)) {
                lQ(true);
            } else if (this.avb != null) {
                lQ(true);
            } else if (this.mData.getVideoInfo() != null) {
                lQ(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                lQ(true);
            } else {
                lQ(false);
            }
        }
    }

    private void lQ(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.ap.b(this.mPost, r.e.cp_link_tip_a, r.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.ap.c(this.mPost, r.e.cp_cont_d, 1);
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
        this.ave = new NewWriteModel(this);
        this.ave.b(this.avt);
        registerListener(this.fMe);
        this.mDialogCancelListener = new aw(this);
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.fLa = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.fLc = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fLl = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fLm = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.avc = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.fLo = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fLo != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.fLt = bundle.getInt("mem_type", 0);
            this.aci = bundle.getString("from");
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fMa = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fLa = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.fLc = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.fLl = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.fLm = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.fLo = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.fLo != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.fLt = intent.getIntExtra("mem_type", 0);
            this.aci = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.fMa = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.aa.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 1) {
            com.baidu.tieba.tbadkCore.aa.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            com.baidu.tieba.tbadkCore.aa.c(String.valueOf(this.mData.getForumId()) + "photolive", this);
        } else if (this.mData.getType() == 5) {
            com.baidu.tieba.tbadkCore.aa.a(String.valueOf(this.mData.getThreadId()) + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(r.l.write_no_prefix));
        }
        this.dIu = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fLb = true;
        }
        boM();
        try {
            this.fLM = bpg();
        } catch (Throwable th) {
            this.fLM = null;
        }
    }

    private void bpa() {
        this.fJf.setVisibility(8);
        this.fLW.setVisibility(0);
        this.fLX.setVisibility(0);
        this.ffZ.setText(rL(this.mList.get(0).mTopicName));
        this.ffZ.setMovementMethod(com.baidu.tieba.view.g.blN());
        this.fLY.setText(this.mList.get(0).mForumName);
        this.ffZ.addTextChangedListener(new ax(this));
        this.fLZ.setOnClickListener(new ay(this));
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gg = com.baidu.tbadk.plugins.a.gg(rL(hotTopicBussinessData.mTopicName));
            if (gg != null) {
                this.ffZ.setText(gg);
            }
            this.fLY.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String rL(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(boV().getText().toString()) || this.fLU || ((this.fLa || this.fLb) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!com.baidu.tbadk.core.util.w.s(this.mList)) {
                        SpannableString gg = com.baidu.tbadk.plugins.a.gg(this.mData.getTitle());
                        if (gg != null) {
                            boV().setText(gg);
                        }
                    } else {
                        boV().setText(this.mData.getTitle());
                    }
                    boV().setSelection(this.mData.getTitle().length());
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    boL();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ats.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(boU().getText().toString()) || this.fLa || this.fLb) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DR().a(getPageContext().getPageActivity(), this.mData.getContent(), this.fMf);
                    boU().setText(a2);
                    boU().setSelection(a2.length());
                    if (this.fLK) {
                        b(this.fLH, this.fLB);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bpf();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Dk();
                    }
                    lR(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bpb();
                }
                bdH();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.cfO != null) {
                    this.fLw = this.fLu.bIQ;
                    this.cfZ = this.fLu.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.cfO.size()) {
                            break;
                        }
                        com.baidu.tieba.frs.bt btVar = this.cfO.get(i2);
                        if (categoryTo != btVar.bIQ) {
                            i = i2 + 1;
                        } else {
                            this.fLw = categoryTo;
                            this.cfZ = btVar.name;
                            this.mData.setCategoryTo(this.fLw);
                            break;
                        }
                    }
                    if (this.fLx != null) {
                        this.fLx.setText(this.cfZ);
                        this.fLx.b(this.cfO, this.fLu, this.fLw);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.ats.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.ats.AK();
                return;
            }
            return;
        }
        bpb();
        boL();
    }

    private void bpb() {
        if ((!this.fLK || this.fLz != null) && this.fLy != null) {
            this.fLz.c(this.writeImagesInfo);
            bpe();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.fLl);
        if (this.fLa) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avc);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.fLo);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.fLt);
        bundle.putString("from", this.aci);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = boU().getEditableText().toString();
        if (editable != null) {
            boU().setText(TbFaceManager.DR().a(getPageContext().getPageActivity(), editable, this.fMf));
            boU().setSelection(boU().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boe() {
        bdz();
        String editable = boV().getText().toString();
        this.mData.setContent(boU().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.ffH != 0 && this.mData.getType() != 4) {
            this.mData.setTitle(String.valueOf(this.fge.getText().toString()) + editable);
        } else {
            this.mData.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.mData.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.mData.getTitle());
        }
        if (this.fLa || this.fLb) {
            String string = getResources().getString(r.l.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
            }
            String str = String.valueOf(getResources().getString(r.l.app_name)) + getResources().getString(r.l.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.gk()) {
                    sb.append(com.baidu.adp.lib.util.i.gs());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.fLv >= 0) {
            this.mData.setCategoryFrom(this.fLv);
        }
        if (this.fLw >= 0) {
            this.mData.setCategoryTo(this.fLw);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.avd != null && this.avd.OH());
        this.ave.lm(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.w.s(this.mList) && this.fLV != null && this.fLV.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.fLV.mForumId));
            this.mData.setForumName(this.fLV.mForumName);
        }
        this.ave.setWriteData(this.mData);
        this.mData.setVcode(null);
        if (this.avb != null) {
            if (this.avb.getId() != null) {
                this.ave.getWriteData().setVoice(this.avb.getId());
                this.ave.getWriteData().setVoiceDuringTime(this.avb.duration);
            } else {
                this.ave.getWriteData().setVoice(null);
                this.ave.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.ave.getWriteData().setVoice(null);
            this.ave.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.ave.biT()) {
            showToast(r.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.gk()) {
            showToast(r.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(r.l.sending), this.mDialogCancelListener);
            this.ave.startPostWrite();
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
            if (this.fLo != null) {
                i2 = this.fLo.getTotalCount();
                i = this.fLo.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(r.l.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.ats != null && !this.ats.Cz()) {
                    boU().requestFocus();
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
                            boU().getText().insert(boU().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0) {
                    com.baidu.tieba.tbadkCore.aa.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    com.baidu.tieba.tbadkCore.aa.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    com.baidu.tieba.tbadkCore.aa.b(String.valueOf(this.mData.getForumId()) + "photolive", (WriteData) null);
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
                                aUE();
                            } else {
                                C(intent);
                            }
                        } else if (intExtra == 1) {
                            w(intent);
                        } else {
                            B(intent);
                            com.baidu.adp.lib.g.h.eE().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fLK) {
                        d(intent);
                        bdH();
                        return;
                    }
                    E(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ats.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ats.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ats.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bdH();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.c.n(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.fKZ) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.fKZ = false;
                            }
                            sb2.append(stringExtra);
                            fw(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.w.s(this.mList) && !com.baidu.tbadk.core.util.w.s(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.fLV = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.fLV);
                }
            }
        } else if (i2 == 0) {
            if (this.ats != null && !this.ats.Cz()) {
                this.fgd.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Df();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bpd();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.avc = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ao.b(getPageContext(), this.avc);
                    return;
                case 12012:
                    bpd();
                    return;
                case 25004:
                    if ("from_title".equals(this.fKY)) {
                        boV().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fKY)) {
                        boU().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private void bpc() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bpd() {
        if (this.fLK) {
            this.fLz.c(this.writeImagesInfo);
            bpe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpe() {
        this.fLz.notifyDataSetChanged();
        this.fLy.invalidate();
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
        bdH();
    }

    private void B(Intent intent) {
        if (this.fLK) {
            E(intent);
            bpd();
        } else {
            F(intent);
        }
        bdH();
    }

    private void E(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bpd();
            lR(true);
        }
    }

    private void C(Intent intent) {
        if (this.writeImagesInfo != null) {
            c(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aUE() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void w(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.eLW.parseJson(stringExtra);
            this.eLW.updateQuality();
            if (this.eLW.getChosedFiles() != null && this.eLW.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.eLW.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.eLW.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, boV());
        HidenSoftKeyPad(this.mInputManager, boU());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void F(Intent intent) {
        c(intent, true);
    }

    private void c(Intent intent) {
        this.avc = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avc;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.I(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.J(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.avc, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bpf();
            Dk();
        }
        lR(true);
    }

    private void d(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bpf();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Dk();
                }
            }
            lR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpf() {
        if (this.ats.eD(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void Df() {
        new bb(this).execute(new Void[0]);
    }

    private void lR(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bFE == null) {
            this.bFE = VoiceManager.instance();
        }
        return this.bFE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void XU() {
        this.bFE = getVoiceManager();
        this.bFE.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.sa(postWriteCallBackData.getErrorCode())) {
                AntiHelper.T(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(r.l.error_write);
                }
                showToast(errorString2);
            } else if (this.fLo == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avl = i;
        if (this.ats != null) {
            this.ats.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.ats.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Dk() {
        if (!this.fLK && this.ats != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.ats.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.ats.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ats.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ats.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (this.ats != null) {
            this.ats.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void th(int i) {
        if (i < this.fKb.size()) {
            for (int i2 = 0; i2 < this.fKb.size(); i2++) {
                this.fKb.get(i2).lF(false);
            }
            this.fKb.get(i).lF(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rx(int i) {
        this.ffH = i;
        this.fgf.sN(i);
        th(i);
        this.fge.setText(this.mPrefixData.getPrefixs().get(i));
        bdH();
        com.baidu.adp.lib.g.j.a(this.fgf, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fgh.setSelected(false);
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
            Da();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ad.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ad.aa(getApplicationContext())) {
                com.baidu.tbadk.core.util.ao.b(getPageContext(), this.avc);
            } else {
                showToast(r.l.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(r.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fLS && System.currentTimeMillis() - this.fLT < 800) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.fLS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fLP != null) {
            rN(str);
            this.fLP.dismiss();
        }
    }

    private void bx(Context context) {
        fLR = com.baidu.adp.lib.util.k.J(context);
    }

    private void rN(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(r.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fLS = true;
        bpf();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Dk();
        }
        lR(true);
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

    private File bpg() {
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

    private void bph() {
        if (this.fLM != null && this.mData.getType() == 0) {
            bx(getActivity());
            this.fLO = getPageContext().getPageActivity().getLayoutInflater().inflate(r.j.rec_dialog, (ViewGroup) null);
            this.fLO.setOnClickListener(new bd(this));
            this.fLN = (TbImageView) this.fLO.findViewById(r.h.rec_img_view);
            this.fLQ = (LinearLayout) this.fLO.findViewById(r.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.tQ().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fLM.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.tQ().putString("write_rec_pic_path", this.fLM.getAbsolutePath());
                Bitmap c = c(this.fLM.getAbsolutePath(), getResources().getDimensionPixelSize(r.f.ds160));
                if (c != null) {
                    this.fLN.setImageBitmap(c);
                    this.fLN.setDrawBorder(true);
                    this.fLN.setBorderWidth(2);
                    this.fLN.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10264));
                    this.fLP = new Dialog(getActivity(), r.m.bubble_dialog);
                    this.fLP.setCanceledOnTouchOutside(true);
                    this.fLP.setOnDismissListener(new be(this));
                    this.fLP.setContentView(this.fLO);
                    this.fLP.show();
                    Window window = this.fLP.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(r.f.ds28);
                    attributes.y = (fLR / 18) + getResources().getDimensionPixelSize(r.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(r.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(r.f.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(r.a.activity_open_from_bottom, r.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.fKZ = false;
            this.fKY = "";
            if ("from_content".equals(str)) {
                this.fKY = "from_content";
            } else if ("from_title".equals(str)) {
                this.fKY = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                lP(false);
            }
        }
    }
}
