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
import android.view.ViewStub;
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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.PostPrefixData;
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
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.b;
import com.baidu.tieba.write.view.EcommCardView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, af.a, b.a {
    private static int fJl = 0;
    private static int fJm = 0;
    private String Zw;
    private com.baidu.tbadk.editortools.l aqo;
    private VoiceData.VoiceModel asg;
    private String asi;
    private com.baidu.tieba.tbadkCore.location.d asj;
    private com.baidu.tieba.tbadkCore.writeModel.a ask;
    private VoiceManager bBm;
    private String cbB;
    List<dc> cbq;
    private DealInfoData dealInfoData;
    private int fEP;
    private TextView fFn;
    private com.baidu.tieba.write.b fFo;
    private ImageView fFp;
    private View fFq;
    private Toast fIE;
    private String fIF;
    private AdditionData fIH;
    private RelativeLayout fII;
    private TextView fIJ;
    private TextView fIK;
    private TextView fIL;
    private ViewGroup fIM;
    dc fIN;
    private int fIO;
    private int fIP;
    private PostCategoryView fIQ;
    private LinearLayout fIu;
    private View fIx;
    private View fIy;
    private com.baidu.tieba.view.c fJv;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private WriteData fau = null;
    private boolean fIr = false;
    private boolean fIs = false;
    private boolean fIt = false;
    private InputMethodManager mInputManager = null;
    private EditText fFh = null;
    private HeadImageView fGn = null;
    private View fFi = null;
    private LinearLayout fFk = null;
    private EditText fFl = null;
    private p fIv = null;
    private FeedBackTopListView fIw = null;
    private ArrayList<com.baidu.tieba.write.a> fHt = new ArrayList<>();
    private String dxW = null;
    private final KeyEvent fIz = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View afN = null;
    private TextView fIA = null;
    private TextView fFm = null;
    private TextView cFy = null;
    private DialogInterface.OnCancelListener eeQ = null;
    private com.baidu.tbadk.core.dialog.a fIB = null;
    private final Handler mHandler = new Handler();
    private boolean fIC = false;
    private String fID = null;
    private RelativeLayout cEz = null;
    private String asq = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean fIG = false;
    private int ass = 0;
    private int bbu = 0;
    private WriteImagesInfo exg = new WriteImagesInfo();
    private View mRootView = null;
    private GridView fIR = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a fIS = null;
    private ScrollView fIT = null;
    private EditText fIU = null;
    private View fIV = null;
    private View fIW = null;
    private View fIX = null;
    private EditText fIY = null;
    private TextView fIZ = null;
    private TextView fJa = null;
    private TextWatcher fJb = null;
    private TextWatcher fJc = null;
    private boolean fJd = false;
    private boolean fJe = false;
    private com.baidu.tbadk.core.view.b aAz = null;
    private bl fJf = null;
    private File fJg = null;
    private TbImageView fJh = null;
    private View fJi = null;
    private Dialog fJj = null;
    private LinearLayout fJk = null;
    private boolean fJn = false;
    private long fJo = -1000;
    private final HttpMessageListener fJp = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private TbFaceManager.a fJq = new ag(this);
    private final a.d asA = new as(this);
    private final d.a asy = new bd(this);
    private final CustomMessageListener eZK = new bf(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    private final View.OnClickListener fJr = new bg(this);
    private boolean fJs = true;
    private final View.OnFocusChangeListener fFf = new bh(this);
    private final CustomMessageListener fJt = new bi(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
    private TextWatcher fJu = new bj(this);
    private final a.InterfaceC0075a dVr = new w(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if ("from_add_photo_live_in_misson".equals(this.Zw)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(u.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BU();
        } else if (this.asj.bcX()) {
            BS();
        } else {
            this.asj.kl(false);
            a(1, true, (String) null);
            this.asj.bcV();
        }
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new x(this)).b(u.j.cancel, new y(this)).b(getPageContext());
        aVar.rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int blX() {
        int selectionEnd = bmp().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bmp().getText().getSpans(0, bmp().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bmp().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bmp().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blY() {
        if (this.aqo != null) {
            this.aqo.setBarLauncherEnabled(!this.fJs);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.fJd) {
            this.fFh.setVisibility(8);
            if (this.fau.getType() == 5) {
                this.fIX.setVisibility(8);
            } else {
                this.fIX.setVisibility(0);
            }
            b(this.fJa, this.fIU);
            b(this.fIZ, this.fIY);
            bkL();
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
        nl();
        bmi();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.fJt.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.fJt);
        this.asj = new com.baidu.tieba.tbadkCore.location.d(this);
        this.asj.a(this.asy);
        registerListener(this.eZK);
        initEditor();
        bmC();
        if (this.fJd) {
            this.fIS.setEditorTools(this.aqo);
        } else {
            this.fFh.requestFocus();
        }
    }

    private void initEditor() {
        com.baidu.tbadk.editortools.s ej;
        com.baidu.tbadk.editortools.aa el;
        this.aqo = new com.baidu.tbadk.editortools.l(getActivity());
        this.aqo.setBarMaxLauCount(5);
        this.aqo.setMoreButtonAtEnd(true);
        this.aqo.setBarLauncherType(1);
        this.aqo.bv(true);
        this.aqo.bu(true);
        this.aqo.setMoreLauncherIcon(u.f.write_more);
        this.aqo.setBackgroundColorId(u.d.cp_bg_line_d);
        this.aqo.setCanshowTogetherhi(Boolean.valueOf(this.fIG));
        switch (this.fau.getType()) {
            case 4:
            case 5:
                bmb();
                break;
            default:
                bmc();
                break;
        }
        this.aqo.Bm();
        if (this.fIu != null) {
            this.fIu.addView(this.aqo);
        }
        bmd();
        this.aqo.kF();
        com.baidu.tbadk.editortools.s ej2 = this.aqo.ej(6);
        if (ej2 != null && !TextUtils.isEmpty(this.asq)) {
            ((View) ej2).setOnClickListener(new z(this));
        }
        if (!this.fJd) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aqo.zD();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("xiaoying_has_click", false)) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        Ca();
        this.fJf = new bl(this, this.aqo);
        if (this.fIF != null && (ej = this.aqo.ej(26)) != null && (ej instanceof View) && (el = this.aqo.el(27)) != null && el.aqi != null && (el.aqi instanceof View)) {
            getWindow().setSoftInputMode(18);
            ((View) el.aqi).post(new aa(this, (View) ej));
        }
    }

    private void Ca() {
        if (this.aqo != null) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(41, 24, true));
            this.aqo.b(new com.baidu.tbadk.editortools.a(2, 24, com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("graffiti_write_notice_show", true) ? "" : null));
        }
    }

    private void blZ() {
        this.fIV = this.mRootView.findViewById(u.g.photo_live_scroll);
        this.fIX = this.fIV.findViewById(u.g.live_post_title_container);
        this.fIU = (EditText) this.fIV.findViewById(u.g.live_post_content);
        this.fIR = (GridView) this.fIV.findViewById(u.g.photoLiveGridView);
        this.fIY = (EditText) this.fIV.findViewById(u.g.live_post_title);
        this.fIZ = (TextView) this.fIV.findViewById(u.g.titleOverPlusNumber);
        this.fJa = (TextView) this.fIV.findViewById(u.g.contentOverPlusNumber);
        this.fIW = this.fIV.findViewById(u.g.live_interval_view);
        this.fIZ.setText(String.valueOf(20));
        this.fJa.setText(String.valueOf(233));
        this.fIV.setVisibility(0);
        this.fIZ.setVisibility(0);
        this.fJa.setVisibility(0);
        this.fIY.setHint(u.j.tips_title_limit_new);
        this.fIY.setOnFocusChangeListener(new ab(this));
        if (this.fau.getType() == 4) {
            this.fIU.setHint(u.j.live_write_input_content_new);
        } else if (this.fau.getType() == 5) {
            this.fIU.setHint(u.j.live_write_input_content_update);
        }
        this.fIU.setOnFocusChangeListener(new ac(this));
        this.fIU.requestFocus();
        this.fIU.addTextChangedListener(aOC());
        this.fIY.requestFocus();
        this.fIY.addTextChangedListener(aOC());
        this.fIY.setOnClickListener(this.fJr);
        this.fIU.setOnClickListener(this.fJr);
        this.fIS = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.fIR);
        this.fIS.so(6);
        this.fIR.setAdapter((ListAdapter) this.fIS);
        View findViewById = this.fIV.findViewById(u.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new ad(this));
        bma();
    }

    private void bma() {
        if (this.fau.getType() == 0) {
            if (this.fau.getTitle() != null) {
                this.fIY.setText(this.fau.getTitle());
                this.fIY.setSelection(this.fau.getTitle().length());
            }
        } else if (this.fau.getType() != 1) {
            this.fau.getType();
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.fJd) {
            aVar = new com.baidu.tbadk.editortools.a(14, -1, 1);
            bmw();
        }
        if ((aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Cf();
            return;
        }
        if (this.aqo.Bo()) {
            this.aqo.zD();
        }
        String str = null;
        if (this.fau != null) {
            str = this.fau.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        if (this.fJd) {
            albumActivityConfig.getIntent().putExtra("from", "from_writeActivity_livePhoto");
        } else {
            albumActivityConfig.getIntent().putExtra("from", "frs");
        }
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bmb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aqo.y(arrayList);
        com.baidu.tbadk.editortools.aa el = this.aqo.el(5);
        if (el != null) {
            el.ard = 2;
            el.arb = u.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.arb = u.f.write_at;
        this.aqo.b(aVar);
        this.aqo.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bmc() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.aa aaVar;
        com.baidu.tbadk.editortools.aa aaVar2;
        com.baidu.tbadk.editortools.aa aaVar3;
        com.baidu.tbadk.editortools.aa aaVar4;
        com.baidu.tbadk.editortools.aa aaVar5;
        com.baidu.tbadk.editortools.imagetool.i iVar = new com.baidu.tbadk.editortools.imagetool.i(getActivity(), 2);
        ArrayList arrayList = new ArrayList();
        iVar.arb = u.f.write_picture;
        this.aqo.b(iVar);
        arrayList.add(10);
        arrayList.add(5);
        this.aqo.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity()));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask2 != null && (aaVar5 = (com.baidu.tbadk.editortools.aa) runTask2.getData()) != null) {
            aaVar5.arf = true;
            aaVar5.arb = u.f.write_graffiti;
            aaVar5.ard = 3;
            this.aqo.b(aaVar5);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask3 != null && (aaVar4 = (com.baidu.tbadk.editortools.aa) runTask3.getData()) != null) {
            aaVar4.ard = 4;
            aaVar4.arb = u.f.write_privilege;
            this.aqo.b(aaVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 6);
        aVar.arb = u.f.write_at;
        this.aqo.b(aVar);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask4 != null && (aaVar3 = (com.baidu.tbadk.editortools.aa) runTask4.getData()) != null) {
            aaVar3.arf = true;
            aaVar3.ard = 8;
            aaVar3.arb = 0;
            this.aqo.b(aaVar3);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.aa.class);
        if (runTask5 != null && (aaVar2 = (com.baidu.tbadk.editortools.aa) runTask5.getData()) != null) {
            aaVar2.arf = true;
            aaVar2.ard = 9;
            aaVar2.arb = 0;
            this.aqo.b(aaVar2);
        }
        Boolean bmu = bmu();
        if (!this.fIr && bmu != null && bmu.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bdt() && com.baidu.tieba.tbadkCore.v.a(this.fau.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.aa.class)) != null && (aaVar = (com.baidu.tbadk.editortools.aa) runTask.getData()) != null) {
            aaVar.ard = 5;
            aaVar.arb = u.f.write_recorder;
            this.aqo.b(aaVar);
        }
        if (this.fau != null && this.fau.getType() == 0 && !this.fIr && !this.fIs) {
            arrayList.add(13);
            arrayList.add(14);
            arrayList.add(26);
            arrayList.add(27);
        }
        if (this.fIH == null) {
            this.aqo.b(new com.baidu.tieba.write.a.c(getActivity()));
        }
        this.aqo.y(arrayList);
        com.baidu.tbadk.editortools.aa el = this.aqo.el(5);
        if (el != null) {
            el.ard = 1;
            el.arb = u.f.write_emotion;
        }
        com.baidu.tbadk.editortools.aa el2 = this.aqo.el(13);
        if (el2 != null) {
            el2.ard = 7;
        }
    }

    private void bmd() {
        ae aeVar = new ae(this);
        this.aqo.a(16, aeVar);
        this.aqo.a(21, aeVar);
        this.aqo.a(43, aeVar);
        this.aqo.a(45, aeVar);
        this.aqo.a(14, aeVar);
        this.aqo.a(24, aeVar);
        this.aqo.a(3, aeVar);
        this.aqo.a(10, aeVar);
        this.aqo.a(11, aeVar);
        this.aqo.a(12, aeVar);
        this.aqo.a(13, aeVar);
        this.aqo.a(22, aeVar);
        this.aqo.a(23, aeVar);
        this.aqo.a(15, aeVar);
        this.aqo.a(18, aeVar);
        this.aqo.a(25, aeVar);
        this.aqo.a(27, aeVar);
        this.aqo.a(29, aeVar);
        this.aqo.a(40, aeVar);
    }

    public void agJ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BV() {
        if (this.asj.bcZ()) {
            if (this.asj.bcX()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bcT().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.asj.bcV();
            return;
        }
        a(0, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkD() {
        if (this.ask != null) {
            this.ask.cancelLoadData();
        }
        if (this.fIv != null) {
            this.fIv.cancelLoadData();
        }
        if (this.asj != null) {
            this.asj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bkD();
        bmt();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blw() {
        if (this.fau != null && this.fau.getType() == 2 && this.fIC) {
            finish();
        } else if (this.fau == null) {
            finish();
        } else {
            this.fau.setTitle(bmq().getText().toString());
            this.fau.setContent(bmp().getText().toString());
            int type = this.fau.getType();
            if (type == 0) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    com.baidu.tieba.tbadkCore.af.b(this.fau.getForumId(), this.fau);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.af.c(this.fau.getThreadId(), this.fau);
            } else if (type == 4) {
                com.baidu.tieba.tbadkCore.af.b(String.valueOf(this.fau.getForumId()) + "photolive", this.fau);
            } else if (type == 5) {
                com.baidu.tieba.tbadkCore.af.c(String.valueOf(this.fau.getThreadId()) + "updatephotolive", this.fau);
            } else if (type == 7) {
                com.baidu.tieba.tbadkCore.af.b(this.fau.getForumId(), this.fau);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fFo != null && this.fFo.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.fFo, getPageContext().getPageActivity());
                return true;
            } else if (this.aqo.Bo()) {
                this.aqo.zD();
                return true;
            } else {
                bkD();
                blw();
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
        getLayoutMode().w(this.cEz);
        getLayoutMode().w(this.fJk);
        if (this.fJh != null && i == 1) {
            this.fJh.setBorderColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.av.c(this.fFm, u.d.cp_link_tip_a, 1);
        blY();
        com.baidu.tbadk.core.util.av.l(this.fIV, u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.fFi, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.fIW, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(bmq(), u.d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.dxW)) {
            com.baidu.tbadk.core.util.av.l(bmp(), u.d.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_e);
        bmq().setTextColor(color);
        bmp().setTextColor(color);
        a(bmq(), color2);
        a(bmp(), color2);
        bkL();
        this.aqo.onChangeSkinType(i);
        if (this.fIQ != null) {
            this.fIQ.vm();
        }
        com.baidu.tbadk.core.util.av.j((View) this.cFy, u.d.cp_cont_f);
        if (this.fIM != null) {
            com.baidu.tbadk.j.a.a(getPageContext(), this.fIM);
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

    private void nl() {
        this.aAz = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fJd = this.fau.getType() == 4 || 5 == this.fau.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(u.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afN.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.afN != null && (this.afN.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.afN.getLayoutParams();
            layoutParams2.width = -2;
            this.afN.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(u.f.icon_nav_close_selector, u.f.icon_nav_close_selector);
        this.cFy = this.mNavigationBar.setCenterTextTitle("");
        com.baidu.tbadk.core.util.av.j((View) this.cFy, u.d.cp_cont_f);
        this.fIA = (TextView) findViewById(u.g.btn_image_problem);
        this.fFm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.send_post));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fFm.getLayoutParams();
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds10);
        this.fFm.setLayoutParams(layoutParams3);
        this.fFm.setOnFocusChangeListener(this.fFf);
        this.fIT = (ScrollView) findViewById(u.g.write_scrollview);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fIw = (FeedBackTopListView) findViewById(u.g.feedback_top_list);
        this.fIx = findViewById(u.g.feedback_divider);
        this.cEz = (RelativeLayout) findViewById(u.g.parent);
        this.fIu = (LinearLayout) findViewById(u.g.tool_view);
        this.fIu.setContentDescription("..");
        this.fFi = findViewById(u.g.interval_view);
        bkK();
        if (this.fJd) {
            this.fIT.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            blZ();
        }
        if (this.fau.getType() == 7) {
            this.fIM = (ViewGroup) ((ViewStub) findViewById(u.g.ecomm_card)).inflate();
            ((EcommCardView) this.fIM.findViewById(u.g.ecomm_card_root)).setData(this.dealInfoData);
        }
        bkM();
        if (this.fIr || this.fIs) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().YX) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(u.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(u.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.fFk = (LinearLayout) findViewById(u.g.post_content_container);
        this.fFk.setDrawingCacheEnabled(false);
        this.fFk.setOnClickListener(new af(this));
        this.afN.setOnFocusChangeListener(this.fFf);
        this.afN.setOnClickListener(new ah(this));
        this.fIA.setOnClickListener(new ai(this));
        bmf();
        j(bmu());
        bmj();
        agJ();
        switch (this.fau.getType()) {
            case 0:
                if (this.fIr || this.fIs) {
                    if (this.fIt) {
                        this.cFy.setText(u.j.feedback_vcode);
                    } else {
                        this.cFy.setText(u.j.feedback);
                    }
                } else {
                    this.cFy.setText(u.j.post_new_thread);
                }
                this.fFh.setVisibility(0);
                this.fFl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            default:
                this.cFy.setText(u.j.send_reply);
                this.fFl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fFh.setVisibility(8);
                break;
            case 4:
                this.cFy.setText(u.j.publish_photo_live);
                this.fFl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.cFy.setText(getPageContext().getResources().getString(u.j.update_photo_live_tip, Integer.valueOf(this.fau.getFloorNum() + 1)));
                this.fIW.setVisibility(8);
                break;
            case 7:
                this.fFh.setVisibility(0);
                this.fFl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
        }
        bmk();
        bms();
        blY();
        bmh();
        bkJ();
        if (this.fau.getType() == 4 && this.fFq != null && this.fIy != null) {
            this.fFq.setVisibility(8);
            this.fIy.setVisibility(8);
        }
        bkL();
        ShowSoftKeyPad(this.mInputManager, this.fFh);
        bmg();
    }

    private void bme() {
        this.cbq = null;
        this.fIO = -1;
        this.fIP = -1;
        de ht = dd.WW().ht(1);
        if (ht != null) {
            this.cbq = ht.bGR;
            this.fIO = getIntent().getIntExtra("category_id", -1);
            if (this.cbq != null && !this.cbq.isEmpty() && this.fIO >= 0) {
                this.fIN = new dc();
                this.fIN.bGN = 0;
                this.fIN.name = getPageContext().getResources().getString(u.j.category_auto);
                this.fIP = this.fIN.bGN;
                this.cbB = this.fIN.name;
                for (dc dcVar : this.cbq) {
                    if (dcVar.bGN == this.fIO) {
                        this.fIP = dcVar.bGN;
                        this.cbB = dcVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bmf() {
        if (this.cbq != null && !this.cbq.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(u.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(u.g.interval_view_cate).setVisibility(0);
            this.fIQ = (PostCategoryView) linearLayout.findViewById(u.g.category_selected);
            this.fIQ.setText(this.cbB);
            this.fIQ.b(this.cbq, this.fIN, this.fIP);
            this.fIQ.setCategoryContainerClickCallback(new aj(this));
            linearLayout.setOnClickListener(new ak(this));
        }
    }

    private void bmg() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.fJv = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.fJv.setTitle(u.j.no_disturb_start_time);
        this.fJv.setButton(-1, getPageContext().getString(u.j.alert_yes_button), this.fJv);
        this.fJv.setButton(-2, getPageContext().getString(u.j.alert_no_button), this.fJv);
        return this.fJv;
    }

    private void bmh() {
        this.fII = (RelativeLayout) findViewById(u.g.addition_container);
        this.fIJ = (TextView) findViewById(u.g.addition_create_time);
        this.fIK = (TextView) findViewById(u.g.addition_last_time);
        this.fIL = (TextView) findViewById(u.g.addition_last_content);
        if (this.fIH != null) {
            this.fII.setVisibility(0);
            this.fIJ.setText(String.valueOf(getPageContext().getString(u.j.write_addition_create)) + com.baidu.tbadk.core.util.ba.y(this.fIH.getCreateTime() * 1000));
            if (this.fIH.getAlreadyCount() == 0) {
                this.fIK.setVisibility(8);
            } else {
                this.fIK.setText(String.valueOf(getPageContext().getString(u.j.write_addition_last)) + com.baidu.tbadk.core.util.ba.y(this.fIH.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.fIH.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.fIL.setText(lastAdditionContent);
            } else {
                this.fIL.setVisibility(8);
            }
            bmp().setHint(String.format(getPageContext().getString(u.j.write_addition_hint), Integer.valueOf(this.fIH.getAlreadyCount()), Integer.valueOf(this.fIH.getTotalCount())));
            this.cFy.setText(u.j.write_addition_title);
            return;
        }
        this.fII.setVisibility(8);
    }

    private void bkJ() {
        this.fFq = findViewById(u.g.post_prefix_layout);
        this.fFn = (TextView) findViewById(u.g.post_prefix);
        this.fIy = findViewById(u.g.prefix_divider);
        this.fFp = (ImageView) findViewById(u.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fFq.setVisibility(0);
            this.fIy.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fEP = 1;
            this.fFq.setOnClickListener(new am(this));
            this.fFp = (ImageView) findViewById(u.g.prefix_icon);
            if (size > 1) {
                this.fFp.setVisibility(0);
                this.fFn.setOnClickListener(new an(this));
            }
            this.fFo = new com.baidu.tieba.write.b(getPageContext().getPageActivity());
            this.fFo.a(this);
            this.fFo.setMaxHeight(com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds510));
            this.fFo.setOutsideTouchable(true);
            this.fFo.setFocusable(true);
            this.fFo.setOnDismissListener(this);
            this.fFo.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.d.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10097);
            int color2 = com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.k(this.fFn, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.fFp, u.f.icon_title_down);
            this.fFn.setTextColor(color);
            this.fHt.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.a aVar = new com.baidu.tieba.write.a(getActivity());
                this.fHt.add(aVar);
                aVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    aVar.setPrefixTextColor(color2);
                } else {
                    aVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    aVar.setDividerStyle(false);
                }
                this.fFo.addView(aVar);
            }
            this.fFo.rX(0);
            this.fFn.setText(prefixs.get(1));
            sy(1);
            return;
        }
        this.fFq.setVisibility(8);
    }

    private void bmi() {
        if (this.fIr && this.fau != null) {
            this.fIw.setVisibility(0);
            this.fIx.setVisibility(0);
            this.fIv = new p(this);
            this.fIv.qZ(this.fau.getForumName());
            this.fIv.setLoadDataCallBack(new ao(this));
        }
    }

    protected void bmj() {
        this.fFm.setOnClickListener(new ap(this));
    }

    protected void bmk() {
        this.fIB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.fIB.cz(getPageContext().getString(u.j.is_save_draft)).an(false).a(getPageContext().getString(u.j.save), new aq(this)).b(getPageContext().getString(u.j.not_save), new at(this));
        this.fIB.b(getPageContext());
    }

    protected void bkK() {
        this.fGn = (HeadImageView) findViewById(u.g.user_head_portrait);
        this.fGn.setIsRound(true);
        this.fGn.setDrawBorder(false);
        this.fGn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String di = com.baidu.tbadk.core.util.q.di(currentPortrait);
            this.fGn.setUrl(di);
            this.fGn.c(di, 12, false);
        }
        this.fFh = (EditText) findViewById(u.g.post_title);
        this.fFh.setOnClickListener(this.fJr);
        this.fFh.setOnFocusChangeListener(this.fFf);
        if (this.fau.getType() == 0) {
            if (this.fau.getTitle() != null) {
                this.fFh.setText(this.fau.getTitle());
                this.fFh.setSelection(this.fau.getTitle().length());
            } else if (this.fIt) {
                this.fFh.setText(getResources().getString(u.j.vcode_feed_back_title));
            }
        } else if (this.fau.getType() != 1) {
            this.fau.getType();
        }
        this.fFh.addTextChangedListener(this.fJu);
    }

    private TextWatcher aOC() {
        au auVar = new au(this);
        if (this.fJd && this.fJe) {
            if (this.fJb != null) {
                this.fIY.removeTextChangedListener(this.fJb);
            }
            this.fJb = auVar;
        } else if (this.fJd) {
            if (this.fJc != null) {
                this.fIU.removeTextChangedListener(this.fJc);
            }
            this.fJc = auVar;
        }
        return auVar;
    }

    private long g(EditText editText) {
        if (editText == this.fIU) {
            return 233L;
        }
        if (editText != this.fIY) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long g = g(editText);
            long e = g - e(editText);
            String valueOf = String.valueOf(e);
            if (g == 20) {
                if (e < 0) {
                    if (e < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10159));
                } else {
                    textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
                }
            } else if (e < 0) {
                if (e < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10159));
            } else {
                textView.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long e(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void bkM() {
        this.fFl = (EditText) findViewById(u.g.post_content);
        this.fFl.setDrawingCacheEnabled(false);
        this.fFl.setOnClickListener(this.fJr);
        if (this.fau.getContent() != null && this.fau.getContent().length() > 0) {
            SpannableString z = TbFaceManager.CP().z(getPageContext().getPageActivity(), this.fau.getContent());
            this.fFl.setText(z);
            this.fFl.setSelection(z.length());
        } else if (this.fau.getType() == 2) {
            if (this.fIC) {
                if (this.fID != null && this.fID.length() > 0) {
                    this.fFl.setText(getPageContext().getPageActivity().getString(u.j.reply_sub_floor, new Object[]{this.fID}));
                    this.fFl.setSelection(this.fFl.getText().length());
                }
            } else if (this.fau.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(u.j.reply_x_floor), Integer.valueOf(this.fau.getFloorNum()));
                this.fFl.setText(format);
                this.fFl.setSelection(format.length());
            }
        }
        this.fFl.setOnFocusChangeListener(this.fFf);
        this.fFl.setOnTouchListener(new av(this));
        this.fFl.addTextChangedListener(this.fJu);
        ln(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(boolean z) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.fJd) {
            bmp().setPadding(0, 0, 0, 0);
            bmp().setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.av.l(bmp(), u.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.dxW) && this.fIH == null) {
                com.baidu.adp.lib.g.c.dG().a(this.dxW, 19, new aw(this, z), getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bml() {
        int i = 5000;
        if (this.fIH != null) {
            i = 1000;
        }
        return bmp().getText() != null && bmp().getText().length() >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmm() {
        if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
            if (this.aqo != null) {
                this.aqo.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            }
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.bbw() && this.bbu == 0) {
            showToast(u.j.baobao_over_limit);
        } else {
            String charSequence = this.cFy.getText().toString();
            IntentConfig intentConfig = new IntentConfig(getPageContext().getPageActivity());
            intentConfig.getIntent().putExtra("title", charSequence);
            intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        this.fIF = null;
        this.fau.setHiContent(this.fIF);
        bmA();
        bkL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        if (this.fIF != null) {
            if (this.aqo != null) {
                this.aqo.b(new com.baidu.tbadk.editortools.a(44, 27, this.fIF));
                bmA();
                return;
            }
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_HI_STARTMATCHIMAGE, new IntentConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.coreExtra.data.i iVar) {
        if (((ImageSpan[]) bmp().getText().getSpans(0, bmp().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.fIE == null) {
                this.fIE = Toast.makeText(getPageContext().getPageActivity(), u.j.too_many_face, 0);
            }
            this.fIE.show();
            return;
        }
        String name = iVar.getName();
        EmotionGroupType wB = iVar.wB();
        if (name != null) {
            com.baidu.adp.lib.g.c.dG().a(name, 20, new ax(this, new SpannableStringBuilder(name), wB), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap jb = aVar.jb();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jb);
        int width = jb.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        bmp().getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bmp() {
        return this.fJd ? this.fIU : this.fFl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bmq() {
        return this.fJd ? this.fIY : this.fFh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmr() {
        bmp().onKeyDown(67, this.fIz);
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.fau != null) {
            str = this.fau.getForumName();
        }
        if (getPageContext().getString(u.j.feedback_bar_name).equals(str)) {
            this.fIr = true;
        }
    }

    private void bms() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bmt() {
        try {
            if (this.fIB != null) {
                this.fIB.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aAz.c(null);
        this.aAz.cI(u.j.sending);
        this.aAz.aB(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aAz.aB(false);
    }

    private Boolean bmu() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.asq = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        if (this.fau != null) {
            String editable = bmq().getText().toString();
            String trim = bmp().getText().toString().trim();
            String trim2 = editable.trim();
            if (this.fau.getType() == 0 || this.fau.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fEP == 0) {
                        if (TextUtils.isEmpty(trim2)) {
                            this.fau.setIsNoTitle(true);
                        } else {
                            this.fau.setIsNoTitle(false);
                            lo(true);
                            return;
                        }
                    } else {
                        this.fau.setIsNoTitle(false);
                        lo(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim2)) {
                    this.fau.setIsNoTitle(true);
                } else {
                    this.fau.setIsNoTitle(false);
                    lo(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.fJd) {
                    lo(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    lo(true);
                    return;
                }
            } else if (!TextUtils.isEmpty(trim)) {
                lo(true);
                return;
            } else if (this.asg != null) {
                lo(true);
                return;
            } else if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.size() > 0) {
                lo(true);
                return;
            } else if (this.fIF != null) {
                lo(true);
                return;
            }
            if (this.fau.getVideoInfo() != null) {
                lo(true);
            } else if (this.fau.getGraffitiFileName() != null) {
                lo(true);
            } else if (this.fau.getType() == 4) {
                if (!i(this.fIU) || !h(this.fIY)) {
                    r0 = false;
                }
                lo(r0);
            } else if (this.fau.getType() == 5) {
                lo(i(this.fIU));
            } else {
                lo(false);
            }
        }
    }

    private void lo(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.av.c(this.fFm, u.d.cp_link_tip_a, 1);
            this.fFm.setEnabled(true);
            return;
        }
        com.baidu.tbadk.core.util.av.c(this.fFm, u.d.cp_cont_d, 1);
        this.fFm.setEnabled(false);
    }

    private boolean h(EditText editText) {
        long e = e(editText);
        return e <= 20 && e > 0;
    }

    private boolean i(EditText editText) {
        long e = e(editText);
        if (e > 233) {
            return false;
        }
        return e > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.ask = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.ask.b(this.asA);
        registerListener(this.fJp);
        this.eeQ = new ay(this);
        this.fau = new WriteData();
        if (bundle != null) {
            this.fau.setType(bundle.getInt("type", 0));
            this.fau.setForumId(bundle.getString("forum_id"));
            this.fau.setForumName(bundle.getString("forum_name"));
            this.fau.setThreadId(bundle.getString("thread_id"));
            this.fau.setFloor(bundle.getString("floor_id"));
            this.fau.setFloorNum(bundle.getInt("floor_num", 0));
            this.fIr = bundle.getBoolean("feed_back", false);
            this.fIt = bundle.getBoolean("vcode_feed_back", false);
            this.fIC = bundle.getBoolean("reply_sub_pb", false);
            this.fID = bundle.getString("sub_user_name");
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable("baobao_images");
            this.fIF = bundle.getString(WriteActivityConfig.TOGETHERHI_DATA);
            this.fIG = bundle.getBoolean(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.asi = bundle.getString("photo_name");
            this.fIH = (AdditionData) bundle.getSerializable("addition_data");
            this.fau.setIsAddition(this.fIH != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.bbu = bundle.getInt("mem_type", 0);
            this.Zw = bundle.getString("from");
            this.fau.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.fau.setContent(bundle.getString(WriteActivityConfig.CONTENT));
        } else {
            Intent intent = getIntent();
            this.fau.setType(intent.getIntExtra("type", 0));
            this.fau.setForumId(intent.getStringExtra("forum_id"));
            this.fau.setForumName(intent.getStringExtra("forum_name"));
            this.fau.setThreadId(intent.getStringExtra("thread_id"));
            this.fau.setFloor(intent.getStringExtra("floor_id"));
            this.fau.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.fIr = intent.getBooleanExtra("feed_back", false);
            this.fIt = intent.getBooleanExtra("vcode_feed_back", false);
            this.fIC = intent.getBooleanExtra("reply_sub_pb", false);
            this.fID = intent.getStringExtra("sub_user_name");
            this.fIH = (AdditionData) intent.getSerializableExtra("addition_data");
            this.fau.setIsAddition(this.fIH != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.bbu = intent.getIntExtra("mem_type", 0);
            this.Zw = intent.getStringExtra("from");
            this.fIF = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.fIG = intent.getBooleanExtra(WriteActivityConfig.TOGETHERHI_SHOW, false);
            this.fau.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.fau.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(this.fau.getType() == 4 ? 6 : 10);
        this.fau.setWriteImagesInfo(this.writeImagesInfo);
        this.fau.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.fau.setHiContent(this.fIF);
        if (this.fau.getType() == 0) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                com.baidu.tieba.tbadkCore.af.c(this.fau.getForumId(), this);
            }
        } else if (this.fau.getType() == 1) {
            com.baidu.tieba.tbadkCore.af.a(this.fau.getThreadId(), this);
        } else if (this.fau.getType() == 4) {
            com.baidu.tieba.tbadkCore.af.c(String.valueOf(this.fau.getForumId()) + "photolive", this);
        } else if (this.fau.getType() == 5) {
            com.baidu.tieba.tbadkCore.af.a(String.valueOf(this.fau.getThreadId()) + "updatephotolive", this);
        } else if (this.fau.getType() == 7) {
            com.baidu.tieba.tbadkCore.af.c(this.fau.getForumId(), this);
            this.dealInfoData = (DealInfoData) getIntent().getSerializableExtra("deal_info");
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(u.j.write_no_prefix));
        }
        this.dxW = TbadkCoreApplication.m9getInst().getDefaultBubble();
        if (this.fau != null && this.fau.getForumName() != null && TbadkCoreApplication.m9getInst().getYijianfankuiFname() != null && this.fau.getForumName().equals(TbadkCoreApplication.m9getInst().getYijianfankuiFname())) {
            this.fIs = true;
        }
        bme();
        try {
            this.fJg = bmB();
        } catch (Throwable th) {
            this.fJg = null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void a(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (this.fau != null) {
                this.fau.setHaveDraft(true);
                if (com.baidu.adp.lib.util.j.isEmpty(bmq().getText().toString()) || ((this.fIr || this.fIs) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getTitle()))) {
                    this.fau.setTitle(writeData.getTitle());
                    bmq().setText(this.fau.getTitle());
                    bmq().setSelection(this.fau.getTitle().length());
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.fau.setVideoInfo(videoInfo);
                    this.aqo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.j.isEmpty(bmp().getText().toString()) || this.fIr || this.fIs) && !com.baidu.adp.lib.util.j.isEmpty(writeData.getContent())) {
                    this.fau.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.CP().a(getPageContext().getPageActivity(), this.fau.getContent(), this.fJq);
                    bmp().setText(a2);
                    bmp().setSelection(a2.length());
                    if (this.fJd) {
                        b(this.fJa, this.fIU);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.fau.setWriteImagesInfo(this.writeImagesInfo);
                    bmz();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Cf();
                    }
                    lp(false);
                }
                if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen()) {
                    if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                        this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                        this.fau.setIsBaobao(writeData.getIsBaobao());
                        this.fau.setBaobaoContent(writeData.getBaobaoContent());
                        this.fau.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    }
                    if (this.fau.getIsBaobao()) {
                        Ch();
                        lq(false);
                    }
                }
                if (this.fIF == null && writeData.getHiContent() != null) {
                    this.fIF = writeData.getHiContent();
                    this.fau.setHiContent(this.fIF);
                    bmA();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bmv();
                }
                bkL();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.cbq != null) {
                    this.fIP = this.fIN.bGN;
                    this.cbB = this.fIN.name;
                    while (true) {
                        int i2 = i;
                        if (i2 == this.cbq.size()) {
                            break;
                        }
                        dc dcVar = this.cbq.get(i2);
                        if (categoryTo != dcVar.bGN) {
                            i = i2 + 1;
                        } else {
                            this.fIP = categoryTo;
                            this.cbB = dcVar.name;
                            this.fau.setCategoryTo(this.fIP);
                            break;
                        }
                    }
                    if (this.fIQ != null) {
                        this.fIQ.setText(this.cbB);
                        this.fIQ.b(this.cbq, this.fIN, this.fIP);
                    }
                }
                this.fau.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aqo.b(new com.baidu.tbadk.editortools.a(42, 24, this.fau.getGraffitiFileName()));
                this.aqo.zD();
                return;
            }
            return;
        }
        bmv();
    }

    private void bmv() {
        if ((!this.fJd || this.fIS != null) && this.fIR != null) {
            this.fIS.f(this.writeImagesInfo);
            bmy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.fau.getType());
        bundle.putString("forum_id", this.fau.getForumId());
        bundle.putString("forum_name", this.fau.getForumName());
        bundle.putString("thread_id", this.fau.getThreadId());
        bundle.putString("floor_id", this.fau.getFloor());
        bundle.putInt("floor_num", this.fau.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.fIC);
        if (this.fIr) {
            bundle.putBoolean("feed_back", true);
        }
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putSerializable("baobao_images", this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.TOGETHERHI_DATA, this.fIF);
        bundle.putBoolean(WriteActivityConfig.TOGETHERHI_SHOW, this.fIG);
        bundle.putString("photo_name", this.asi);
        bundle.putSerializable("addition_data", this.fIH);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt("mem_type", this.bbu);
        bundle.putString("from", this.Zw);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = bmp().getEditableText().toString();
        if (editable != null) {
            bmp().setText(TbFaceManager.CP().a(getPageContext().getPageActivity(), editable, this.fJq));
            bmp().setSelection(bmp().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        bkD();
        String editable = bmq().getText().toString();
        this.fau.setContent(bmp().getText().toString());
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fEP != 0 && this.fau.getType() != 4) {
            this.fau.setTitle(String.valueOf(this.fFn.getText().toString()) + editable);
        } else {
            this.fau.setTitle(editable);
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            this.fau.setTitle(String.valueOf(this.mPrefixData.getImplicitTitle()) + this.fau.getTitle());
        }
        if (this.fIr || this.fIs) {
            String string = getResources().getString(u.j.android_feedback);
            if (TextUtils.isEmpty(this.fau.getTitle()) || !this.fau.getTitle().startsWith(string)) {
                this.fau.setTitle(string + this.fau.getTitle());
            }
            String str = String.valueOf(getResources().getString(u.j.app_name)) + getResources().getString(u.j.tieba_client);
            if (TextUtils.isEmpty(this.fau.getContent()) || !this.fau.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.fr()) {
                    sb.append(com.baidu.adp.lib.util.i.fz());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.fau.getContent());
                this.fau.setContent(sb.toString());
            }
        }
        if (this.fIO >= 0) {
            this.fau.setCategoryFrom(this.fIO);
        }
        if (this.fIP >= 0) {
            this.fau.setCategoryTo(this.fIP);
        }
        if (this.fau.getType() == 7 && this.dealInfoData != null) {
            this.fau.productId = this.dealInfoData.productId;
        }
        this.fau.setWriteImagesInfo(this.writeImagesInfo);
        this.fau.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.fau.setHiContent(this.fIF);
        this.fau.setHasLocationData(this.asj == null ? false : this.asj.bcZ());
        this.ask.kn(this.writeImagesInfo.size() > 0);
        this.ask.d(this.fau);
        this.fau.setVcode(null);
        if (this.asg != null) {
            if (this.asg.getId() != null) {
                this.ask.bdu().setVoice(this.asg.getId());
                this.ask.bdu().setVoiceDuringTime(this.asg.duration);
            } else {
                this.ask.bdu().setVoice(null);
                this.ask.bdu().setVoiceDuringTime(-1);
            }
        } else {
            this.ask.bdu().setVoice(null);
            this.ask.bdu().setVoiceDuringTime(-1);
        }
        if (!this.ask.bdy()) {
            showToast(u.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.fr()) {
            showToast(u.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(u.j.sending), this.eeQ);
            if (!this.ask.bdv()) {
            }
        }
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.fIH != null) {
                i2 = this.fIH.getTotalCount();
                i = this.fIH.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(u.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aqo != null && !this.aqo.Bo()) {
                    bmp().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                if (y != null && y.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < y.size()) {
                            sb.append("@");
                            sb.append(y.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            bmp().getText().insert(bmp().getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.fau.getType() == 0) {
                    com.baidu.tieba.tbadkCore.af.b(this.fau.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.fau.getType() == 1) {
                    com.baidu.tieba.tbadkCore.af.c(this.fau.getThreadId(), (WriteData) null);
                } else if (this.fau.getType() == 4) {
                    com.baidu.tieba.tbadkCore.af.b(String.valueOf(this.fau.getForumId()) + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                } else if (this.fau.getType() == 7) {
                    com.baidu.tieba.tbadkCore.af.b(this.fau.getForumId(), (WriteData) null);
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
                                aQb();
                            } else {
                                E(intent);
                            }
                        } else if (intExtra == 1) {
                            x(intent);
                        } else {
                            D(intent);
                            com.baidu.adp.lib.h.h.dM().post(new az(this));
                        }
                    }
                } else if (i == 12012) {
                    if (!this.fJd) {
                        c(intent);
                        bkL();
                        return;
                    }
                    G(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.fau.setVideoInfo(videoInfo);
                        this.aqo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aqo.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aqo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bkL();
                } else if (i == 12013) {
                    d(intent);
                    bkL();
                } else if (i == 12016) {
                    I(intent);
                    bkL();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.d.n(intent);
                }
            }
        } else if (i2 == 0) {
            if (this.aqo != null && !this.aqo.Bo()) {
                this.fFl.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    BY();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bmx();
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
                    this.asi = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.au.b(getPageContext(), this.asi);
                    return;
                case 12012:
                    bmx();
                    return;
            }
        }
    }

    private void bmw() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bmx() {
        if (this.fJd) {
            this.fIS.f(this.writeImagesInfo);
            bmy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmy() {
        this.fIS.notifyDataSetChanged();
        this.fIR.invalidate();
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
        bkL();
    }

    private void D(Intent intent) {
        if (this.fJd) {
            G(intent);
            bmx();
        } else {
            H(intent);
        }
        bkL();
    }

    private void G(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bmx();
            lp(true);
        }
    }

    private void E(Intent intent) {
        if (this.writeImagesInfo != null) {
            b(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void aQb() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void x(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.exg.parseJson(stringExtra);
            this.exg.updateQuality();
            if (this.exg.getChosedFiles() != null && this.exg.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.exg.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.exg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bmq());
        HidenSoftKeyPad(this.mInputManager, bmp());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void H(Intent intent) {
        c(intent, true);
    }

    private void b(Intent intent) {
        this.asi = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.asi, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bmz();
            Cf();
        }
        lp(true);
    }

    private void c(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bmz();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Cf();
                }
            }
            lp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        if (this.aqo.el(10) != null && this.writeImagesInfo.getChosedFiles() != null) {
            this.writeImagesInfo.getChosedFiles().size();
        }
    }

    private void I(Intent intent) {
        if (this.fau != null) {
            this.fIF = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            this.fau.setHiContent(this.fIF);
            bmA();
        }
    }

    private void d(Intent intent) {
        if (this.fau != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.fau.setIsBaobao(true);
            this.fau.setBaobaoContent(stringExtra2);
            Ch();
            lq(true);
        }
    }

    private void BY() {
        new bb(this).execute(new Void[0]);
    }

    private void lp(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    private void lq(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.bBm == null) {
            this.bBm = VoiceManager.instance();
        }
        return this.bBm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void UR() {
        this.bBm = getVoiceManager();
        this.bBm.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.qL(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(u.j.error_write);
                }
                showToast(errorString2);
            } else if (this.fIH == null) {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            } else {
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.ass = i;
        if (this.aqo != null) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (z) {
                this.aqo.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Cf() {
        if (!this.fJd && this.aqo != null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                this.aqo.b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                this.aqo.b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aqo.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aqo.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    private void Ch() {
        if (this.aqo != null) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(22, 15, this.baobaoImagesInfo));
            this.aqo.b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            this.aqo.b(new com.baidu.tbadk.editortools.a(2, 13, "1"));
        }
    }

    private void bmA() {
        if (this.aqo != null) {
            if (this.fIF != null) {
                this.aqo.b(new com.baidu.tbadk.editortools.a(44, 27, this.fIF));
                this.aqo.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
                return;
            }
            this.aqo.b(new com.baidu.tbadk.editortools.a(45, 27, this.fIF));
            this.aqo.b(new com.baidu.tbadk.editortools.a(2, 26, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (this.aqo != null) {
            this.aqo.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void sy(int i) {
        if (i < this.fHt.size()) {
            for (int i2 = 0; i2 < this.fHt.size(); i2++) {
                this.fHt.get(i2).lb(false);
            }
            this.fHt.get(i).lb(true);
        }
    }

    @Override // com.baidu.tieba.write.b.a
    public void rY(int i) {
        this.fEP = i;
        this.fFo.rX(i);
        sy(i);
        this.fFn.setText(this.mPrefixData.getPrefixs().get(i));
        bkL();
        com.baidu.adp.lib.h.j.a(this.fFo, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fFq.setSelected(false);
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
            com.baidu.adp.lib.util.k.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fau != null) {
            if (this.fau.getType() == 4) {
                return "a015";
            }
            if (this.fau.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            BT();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (com.baidu.tbadk.core.util.ag.Q(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.b(getPageContext(), this.asi);
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        if (this.fJf != null) {
            this.fJf.onKeyboardVisibilityChanged(z);
        }
        if (this.fJn && System.currentTimeMillis() - this.fJo < 800) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.fJn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(String str) {
        if (!com.baidu.adp.lib.util.j.isEmpty(str) && this.fJj != null) {
            rb(str);
            this.fJj.dismiss();
        }
    }

    private void aZ(Context context) {
        fJl = com.baidu.adp.lib.util.k.A(context);
        fJm = com.baidu.adp.lib.util.k.B(context);
    }

    private void rb(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(u.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.fJn = true;
        bmz();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Cf();
        }
        lp(true);
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

    private File bmB() {
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

    private void bmC() {
        if (this.fJg != null && this.fau.getType() == 0) {
            aZ(getActivity());
            this.fJi = getPageContext().getPageActivity().getLayoutInflater().inflate(u.h.rec_dialog, (ViewGroup) null);
            this.fJi.setOnClickListener(new bc(this));
            this.fJh = (TbImageView) this.fJi.findViewById(u.g.rec_img_view);
            this.fJk = (LinearLayout) this.fJi.findViewById(u.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.sO().getString("write_rec_pic_path", "").equalsIgnoreCase(this.fJg.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.sO().putString("write_rec_pic_path", this.fJg.getAbsolutePath());
                Bitmap c = c(this.fJg.getAbsolutePath(), getResources().getDimensionPixelSize(u.e.ds160));
                if (c != null) {
                    this.fJh.setImageBitmap(c);
                    this.fJh.setDrawBorder(true);
                    this.fJh.setBorderWidth(2);
                    this.fJh.setBorderColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10264));
                    this.fJj = new Dialog(getActivity(), u.k.bubble_dialog);
                    this.fJj.setCanceledOnTouchOutside(true);
                    this.fJj.setOnDismissListener(new be(this));
                    this.fJj.setContentView(this.fJi);
                    this.fJj.show();
                    Window window = this.fJj.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(u.e.ds28);
                    attributes.y = (fJm / 18) + getResources().getDimensionPixelSize(u.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(u.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(u.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(u.a.activity_open_from_bottom, u.a.activity_close_from_top);
    }
}
