package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.e.a.a;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0073a, d.a {
    private EditorTools aYo;
    private LocationModel aZQ;
    private NewWriteModel aZR;
    private OriginalThreadCardView fHt;
    private String hXA;
    private int hXB;
    private PostCategoryView hXC;
    private HotTopicBussinessData hXF;
    private TextView hXG;
    private com.baidu.tieba.write.editor.b hXI;
    private e hXL;
    private com.baidu.tieba.view.b hXS;
    private LinearLayout hXm;
    private LinearLayout hXn;
    private View hXp;
    private Toast hXr;
    private AdditionData hXs;
    private RelativeLayout hXt;
    private TextView hXu;
    private TextView hXv;
    private TextView hXw;
    List<x> hXx;
    x hXy;
    private int hXz;
    private TextView haR;
    private com.baidu.tieba.write.d haS;
    private ImageView haT;
    private View haU;
    private int hau;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hXj = "";
    private boolean hXk = false;
    private WriteData mData = null;
    private boolean hXl = false;
    private InputMethodManager mInputManager = null;
    private EditText haM = null;
    private View haN = null;
    private LinearLayout haP = null;
    private EditText haQ = null;
    private FeedBackModel hXo = null;
    private ArrayList<WritePrefixItemLayout> hXq = new ArrayList<>();
    private final KeyEvent dqR = new KeyEvent(0, 67);
    private View aMU = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aZV = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aZW = 0;
    private View mRootView = null;
    private ScrollView hXD = null;
    private boolean hXE = false;
    private com.baidu.tbadk.core.view.d bib = null;
    private String mFrom = "write";
    private String eeJ = "2";
    private SpannableStringBuilder hXH = new SpannableStringBuilder();
    private boolean hXJ = false;
    private final b hXK = new b();
    private TbFaceManager.a hXM = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ic(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.op());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.i(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dJg = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCK));
        }
    };
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hXK.az(null);
                if (z) {
                    TransmitPostEditActivity.this.cy(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hXK.xr(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hXK.az(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hXK.b(TransmitPostEditActivity.this.haM, TransmitPostEditActivity.this.haQ);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GW());
                    if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GV())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a bad = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void MN() {
            TransmitPostEditActivity.this.showToast(e.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void dj(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(e.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bDT())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bDT());
            } else {
                dj(null);
            }
        }
    };
    private final CustomMessageListener hnA = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aZQ.nx(false);
                    TransmitPostEditActivity.this.aZQ.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aZQ.nx(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hXN = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hXO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bOZ = TransmitPostEditActivity.this.bOZ();
            if (bOZ >= 0 && bOZ < TransmitPostEditActivity.this.haQ.getText().length()) {
                TransmitPostEditActivity.this.haQ.setSelection(bOZ);
            }
        }
    };
    private boolean hXP = true;
    private final View.OnFocusChangeListener haK = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.haM || view == TransmitPostEditActivity.this.aMU || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hXP = true;
                    TransmitPostEditActivity.this.bPa();
                    if (TransmitPostEditActivity.this.aYo != null) {
                        TransmitPostEditActivity.this.aYo.Kw();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.haM);
                } else if (view == TransmitPostEditActivity.this.haM) {
                    TransmitPostEditActivity.this.haR.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.haQ && z) {
                TransmitPostEditActivity.this.hXP = false;
                TransmitPostEditActivity.this.bPa();
                TransmitPostEditActivity.this.aYo.Kw();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.haQ);
            }
            TransmitPostEditActivity.this.bPg();
        }
    };
    private TextWatcher hXQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hXU = "";
        private String hXV;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hXV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hXV != null ? this.hXV.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bzd();
            TransmitPostEditActivity.this.bPh();
            EditText bPs = TransmitPostEditActivity.this.bPs();
            if (editable != null && bPs != null && bPs.getText() != null) {
                if (this.hXU == null || !this.hXU.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hXK != null) {
                        this.hXU = bPs.getText().toString();
                        TransmitPostEditActivity.this.hXK.k(bPs);
                        return;
                    }
                    return;
                }
                bPs.setSelection(bPs.getSelectionEnd());
            }
        }
    };
    private TextWatcher hXR = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hXV;
        private String hXW = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hXV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hXV != null ? this.hXV.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bzd();
            EditText bPr = TransmitPostEditActivity.this.bPr();
            if (editable != null && bPr != null && bPr.getText() != null) {
                int selectionEnd = bPr.getSelectionEnd();
                if (this.hXW == null || !this.hXW.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hXK != null) {
                        this.hXW = bPr.getText().toString();
                        TransmitPostEditActivity.this.hXK.k(bPr);
                        return;
                    }
                    return;
                }
                bPr.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Mz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MB();
        } else if (this.aZQ.bEa()) {
            My();
        } else {
            this.aZQ.nx(false);
            b(1, true, null);
            this.aZQ.bDY();
        }
    }

    private void MB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aZQ.alQ();
                } else {
                    TransmitPostEditActivity.this.bad.MN();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bOZ() {
        int selectionEnd = bPr().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bPr().getText().getSpans(0, bPr().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bPr().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bPr().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        if (this.aYo != null) {
            this.aYo.setBarLauncherEnabled(!this.hXP);
            this.aYo.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hXE) {
            this.haM.setVisibility(8);
            bzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        this.aZQ = new LocationModel(this);
        this.aZQ.a(this.bad);
        registerListener(this.hnA);
        registerListener(this.hXN);
        initEditor();
        this.haQ.requestFocus();
        bvl();
        bPA();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aYo = new EditorTools(getActivity());
        this.aYo.setBarMaxLauCount(4);
        this.aYo.setMoreButtonAtEnd(true);
        this.aYo.setBarLauncherType(1);
        this.aYo.cq(true);
        this.aYo.cr(true);
        this.aYo.setMoreLauncherIcon(e.f.write_more);
        this.aYo.setBackgroundColorId(e.d.cp_bg_line_d);
        bPb();
        this.aYo.LY();
        if (this.hXm != null) {
            this.hXm.addView(this.aYo);
        }
        bPc();
        this.aYo.pN();
        com.baidu.tbadk.editortools.g fH = this.aYo.fH(6);
        if (fH != null && !TextUtils.isEmpty(this.aZV)) {
            ((View) fH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aZV);
                }
            });
        }
        if (!this.hXE) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aYo.Kw();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bPe();
    }

    private void bPb() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aYV = e.f.write_at;
        this.aYo.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aYo.b(aVar2);
        aVar2.aYV = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aYX = 4;
            kVar.aYV = e.f.icon_post_location_selector;
            this.aYo.b(kVar);
        }
        if (this.hXs == null) {
            if (this.hXI == null) {
                this.hXI = new com.baidu.tieba.write.editor.b(getActivity(), this.eeJ);
                this.hXI.bOc();
                this.hXI.setFrom("from_share_write");
                this.hXI.aZ(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aYo.b(this.hXI);
        }
        this.aYo.w(arrayList);
        com.baidu.tbadk.editortools.k fK = this.aYo.fK(5);
        if (fK != null) {
            fK.aYX = 1;
            fK.aYV = e.f.write_emotion;
        }
    }

    private void bPc() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.4
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                int i;
                if (aVar != null) {
                    if (aVar.code == 31 && (aVar.data instanceof Integer)) {
                        int intValue = ((Integer) aVar.data).intValue();
                        if (intValue == 5) {
                            i = 4;
                        } else if (intValue == 9) {
                            i = 3;
                        } else if (intValue == 26) {
                            i = 1;
                        } else {
                            i = intValue == 7 ? 2 : 0;
                        }
                        if (i > 0) {
                            TiebaStatic.log(new am("c12608").x("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bPq()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bPq()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.d((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bPt();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bzd();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hXs == null) {
                            TransmitPostEditActivity.this.MC();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aZW) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    TransmitPostEditActivity.this.Mz();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.My();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aZQ != null) {
                            TransmitPostEditActivity.this.aZQ.nx(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.aA(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aYo.Ma()) {
                                        TransmitPostEditActivity.this.aYo.Kw();
                                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(e.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bzd();
                        if (TransmitPostEditActivity.this.haQ != null) {
                            TransmitPostEditActivity.this.haQ.requestFocus();
                        }
                        TransmitPostEditActivity.this.aYo.Kw();
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.haQ);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hXk = true;
                        TransmitPostEditActivity.this.oD(true);
                        if (TransmitPostEditActivity.this.bPs().isFocused()) {
                            TransmitPostEditActivity.this.hXj = "from_title";
                        } else if (TransmitPostEditActivity.this.bPr().isFocused()) {
                            TransmitPostEditActivity.this.hXj = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hXn.setVisibility(0);
                        TransmitPostEditActivity.this.hXn.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hXn.hasFocus()) {
                            TransmitPostEditActivity.this.haQ.requestFocus();
                            TransmitPostEditActivity.this.haQ.setSelection(TransmitPostEditActivity.this.haQ.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hXn.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aYo.setActionListener(31, bVar);
        this.aYo.setActionListener(16, bVar);
        this.aYo.setActionListener(14, bVar);
        this.aYo.setActionListener(24, bVar);
        this.aYo.setActionListener(3, bVar);
        this.aYo.setActionListener(10, bVar);
        this.aYo.setActionListener(11, bVar);
        this.aYo.setActionListener(12, bVar);
        this.aYo.setActionListener(13, bVar);
        this.aYo.setActionListener(15, bVar);
        this.aYo.setActionListener(18, bVar);
        this.aYo.setActionListener(20, bVar);
        this.aYo.setActionListener(25, bVar);
        this.aYo.setActionListener(27, bVar);
        this.aYo.setActionListener(29, bVar);
        this.aYo.setActionListener(43, bVar);
        this.aYo.setActionListener(45, bVar);
        this.aYo.setActionListener(53, bVar);
        this.aYo.setActionListener(48, bVar);
        this.aYo.setActionListener(46, bVar);
        this.aYo.setActionListener(49, bVar);
        this.aYo.setActionListener(47, bVar);
        this.aYo.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC() {
        if (this.aZQ.alM()) {
            if (this.aZQ.bEa()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bDW().getLocationData().bDT());
                return;
            }
            b(1, true, null);
            this.aZQ.bDY();
            return;
        }
        b(0, true, null);
    }

    protected void byV() {
        if (this.aZR != null) {
            this.aZR.cancelLoadData();
        }
        if (this.hXo != null) {
            this.hXo.cancelLoadData();
        }
        if (this.aZQ != null) {
            this.aZQ.cancelLoadData();
        }
    }

    private void bPd() {
        if (this.hXL != null) {
            this.hXL.hideTip();
        }
    }

    private void bPe() {
        if (this.hXL == null) {
            this.hXL = new e(getPageContext());
        }
        this.hXL.c(this.aYo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bPd();
        TiebaPrepareImageService.StopService();
        byV();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPf() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bPs().getText().toString());
        this.mData.setContent(bPr().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.haS != null && this.haS.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.haS, getPageContext().getPageActivity());
                return true;
            } else if (this.aYo.Ma()) {
                this.aYo.Kw();
                return true;
            } else {
                byV();
                bPf();
                return true;
            }
        }
        if (i == 67 && (text = bPr().getText()) != null) {
            int selectionStart = bPr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bPr().onKeyDown(67, this.dqR);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bPa();
        al.j(this.haN, e.d.cp_bg_line_c);
        al.j(bPs(), e.d.cp_bg_line_d);
        al.j(bPr(), e.d.cp_bg_line_d);
        bzd();
        this.aYo.onChangeSkinType(i);
        if (this.hXC != null) {
            this.hXC.Fj();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bPg();
        bPh();
        if (this.hXK != null) {
            this.hXK.c(bPs(), bPr());
        }
        this.fHt.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPg() {
        if (this.haM.hasFocus()) {
            this.haM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.haM.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.haQ.hasFocus()) {
            this.haQ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.haQ.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        if (this.haM != null) {
            if (this.haM.getText().toString().length() == 0) {
                this.haM.getPaint().setFakeBoldText(false);
            } else if (this.haM.getText().toString().length() > 0) {
                this.haM.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bib = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hXE = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bPj();
        this.hXD = (ScrollView) findViewById(e.g.write_scrollview);
        this.hXD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.haQ != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.haQ);
                    }
                    if (TransmitPostEditActivity.this.aYo != null) {
                        TransmitPostEditActivity.this.aYo.Kw();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hXm = (LinearLayout) findViewById(e.g.tool_view);
        this.hXm.setContentDescription("..");
        this.hXn = (LinearLayout) findViewById(e.g.title_view);
        this.haN = findViewById(e.g.interval_view);
        this.hXG = (TextView) findViewById(e.g.hot_topic_title_edt);
        bzc();
        if (this.hXE) {
            this.hXD.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bze();
        bPp();
        this.haP = (LinearLayout) findViewById(e.g.post_content_container);
        this.haP.setDrawingCacheEnabled(false);
        this.haP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.haQ.requestFocus();
            }
        });
        this.aMU.setOnFocusChangeListener(this.haK);
        this.aMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.byV();
                TransmitPostEditActivity.this.bPf();
            }
        });
        bPm();
        bPo();
        bPi();
        bPa();
        bPn();
        bzb();
        bPu();
        if (this.mData.getType() == 4 && this.haU != null && this.hXp != null) {
            this.haU.setVisibility(8);
            this.hXp.setVisibility(8);
        }
        bzd();
        ShowSoftKeyPad(this.mInputManager, this.haM);
    }

    private void bPi() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.eeJ != null && this.eeJ.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.eeJ != null && this.eeJ.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(e.j.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(e.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(e.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.haM.setVisibility(0);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.haM.setVisibility(8);
                    return;
            }
        }
    }

    private void bPj() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.haK);
    }

    private void bPk() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hXl && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bPs() != null) {
                bPs().setText(c);
                bPs().setSelection(c.length());
            }
        }
    }

    private void bPl() {
        this.hXx = null;
        this.hXz = -1;
        this.hXB = -1;
        z mn = y.aCr().mn(1);
        if (mn != null) {
            this.hXx = mn.dLt;
            this.hXz = getIntent().getIntExtra("category_id", -1);
            if (this.hXx != null && !this.hXx.isEmpty() && this.hXz >= 0) {
                this.hXy = new x();
                this.hXy.dLp = 0;
                this.hXy.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hXB = this.hXy.dLp;
                this.hXA = this.hXy.name;
                for (x xVar : this.hXx) {
                    if (xVar.dLp == this.hXz) {
                        this.hXB = xVar.dLp;
                        this.hXA = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bPm() {
        if (this.hXx != null && !this.hXx.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hXC = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hXC.setText(this.hXA);
            this.hXC.setCategoryContainerData(this.hXx, this.hXy, this.hXB);
            this.hXC.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hXC.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dLp);
                        TransmitPostEditActivity.this.hXB = atVar.dLp;
                        TransmitPostEditActivity.this.hXC.bON();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hXC.bOM();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPs());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPr());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hXS = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hXS.setTitle(e.j.no_disturb_start_time);
        this.hXS.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hXS);
        this.hXS.setButton(-2, getPageContext().getString(e.j.cancel), this.hXS);
        return this.hXS;
    }

    private void bPn() {
        this.hXt = (RelativeLayout) findViewById(e.g.addition_container);
        this.hXu = (TextView) findViewById(e.g.addition_create_time);
        this.hXv = (TextView) findViewById(e.g.addition_last_time);
        this.hXw = (TextView) findViewById(e.g.addition_last_content);
        if (this.hXs != null) {
            this.hXt.setVisibility(0);
            this.hXu.setText(getPageContext().getString(e.j.write_addition_create) + ao.L(this.hXs.getCreateTime() * 1000));
            if (this.hXs.getAlreadyCount() == 0) {
                this.hXv.setVisibility(8);
            } else {
                this.hXv.setText(getPageContext().getString(e.j.write_addition_last) + ao.L(this.hXs.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hXs.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hXw.setText(lastAdditionContent);
            } else {
                this.hXw.setVisibility(8);
            }
            bPr().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hXs.getAlreadyCount()), Integer.valueOf(this.hXs.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hXt.setVisibility(8);
    }

    private void bzb() {
        this.haU = findViewById(e.g.post_prefix_layout);
        this.haR = (TextView) findViewById(e.g.post_prefix);
        this.hXp = findViewById(e.g.prefix_divider);
        this.haT = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.haU.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hau = 1;
            this.haU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.haR.setVisibility(0);
                    TransmitPostEditActivity.this.haU.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.haS, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aYo.Kw();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.haM);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.haQ);
                }
            });
            this.haT = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.haT.setVisibility(0);
                this.haR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.haR.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.haS, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aYo.Kw();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPs());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPr());
                    }
                });
            }
            this.haS = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.haS.a(this);
            this.haS.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.haS.setOutsideTouchable(true);
            this.haS.setFocusable(true);
            this.haS.setOnDismissListener(this);
            this.haS.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.haR, e.d.cp_bg_line_d);
            al.c(this.haT, e.f.icon_frs_arrow_n);
            this.haR.setTextColor(color);
            this.hXq.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hXq.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.haS.addView(writePrefixItemLayout);
            }
            this.haS.setCurrentIndex(0);
            this.haR.setText(prefixs.get(1));
            xt(1);
            return;
        }
        this.haU.setVisibility(8);
    }

    protected void bPo() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hXK.a(TransmitPostEditActivity.this.haM, TransmitPostEditActivity.this.haQ)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hXK.bMY());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPs());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bPr());
                    TransmitPostEditActivity.this.aYo.Kw();
                    TiebaStatic.log(new am("c12608").x("obj_locate", 7));
                    TransmitPostEditActivity.this.bPy();
                }
            }
        });
    }

    protected void bzc() {
        this.haM = (EditText) findViewById(e.g.post_title);
        this.haM.setOnClickListener(this.hXO);
        this.haM.setOnFocusChangeListener(this.haK);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.haM.setText(this.mData.getTitle());
            this.haM.setSelection(this.mData.getTitle().length());
        }
        this.haM.addTextChangedListener(this.hXQ);
        if (!this.mData.getHaveDraft()) {
            bPk();
        }
        this.haM.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void bze() {
        this.haQ = (EditText) findViewById(e.g.post_content);
        this.haQ.setDrawingCacheEnabled(false);
        this.haQ.setOnClickListener(this.hXO);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nt().am(getPageContext().getPageActivity(), this.mData.getContent());
            this.haQ.setText(am);
            this.haQ.setSelection(am.length());
        }
        this.haQ.setOnFocusChangeListener(this.haK);
        this.haQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.haQ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.haQ.addTextChangedListener(this.hXR);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.haQ.setHint(e.j.share_video_default);
        } else {
            this.haQ.setHint(e.j.share_txt_default);
        }
    }

    private void bPp() {
        this.fHt = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.fHt.setVisibility(0);
        this.fHt.b(this.mOriginalThreadInfo);
        this.fHt.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPq() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.hXs != null) {
            i = 1000;
        }
        return bPr().getText() != null && bPr().getText().length() >= i;
    }

    private void hJ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hXj)) {
                this.hXj = "";
                bPr().requestFocus();
                if (bPr().getText() != null && bPr().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bPr().getSelectionStart();
                    editable = bPr().getText();
                }
            } else if ("from_title".equals(this.hXj)) {
                this.hXj = "";
                bPs().requestFocus();
                if (bPs().getText() != null && bPs().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bPs().getSelectionStart();
                    editable = bPs().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oD(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(p pVar) {
        if (((ImageSpan[]) bPr().getText().getSpans(0, bPr().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hXr == null) {
                this.hXr = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hXr.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType GM = pVar.GM();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bPr().getSelectionStart(), aVar, GM);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bPr() != null && bPr().getText() != null) {
            Bitmap op = aVar.op();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(op);
            int width = op.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, op.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bPr().getSelectionStart() - 1;
                if (bPr().getText().length() > 1 && selectionStart >= 0 && bPr().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bPr().getText().insert(bPr().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bPr().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bPr().getText().insert(bPr().getSelectionStart(), spannableString2);
            }
            Editable text = bPr().getText();
            if (text != null) {
                this.hXH.clear();
                this.hXH.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hXH);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bPr().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bPr().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bPr().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bPr() {
        return this.haQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bPs() {
        return this.haM;
    }

    protected void bPt() {
        Editable text;
        if (bPr() != null && (text = bPr().getText()) != null) {
            int selectionStart = bPr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bPr().onKeyDown(67, this.dqR);
            }
            bPr().onKeyDown(67, this.dqR);
            int selectionStart2 = bPr().getSelectionStart();
            this.hXH.clear();
            this.hXH.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hXH);
            bPr().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bib.d(null);
        this.bib.ec(e.j.sending);
        this.bib.bA(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bib.bA(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzd() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bPs() != null) {
                str = bPs().getText().toString();
            }
            if (bPr() != null) {
                str2 = bPr().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.hau == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            oE(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        oE(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    oE(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hXE) {
                    oE(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oE(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                oE(true);
            } else if (this.mData.getVideoInfo() != null) {
                oE(true);
            } else {
                oE(false);
            }
        }
    }

    private void oE(boolean z) {
        al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aZR = new NewWriteModel(this);
        this.aZR.b(this.baf);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.byV();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hXs = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hXs != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.mPrivateThread = bundle.getInt("private_thread");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.eeJ = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.class);
            }
            str = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.hXs = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hXs != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.eeJ = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mOriginalThreadInfo = (OriginalThreadInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(e.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hXl = true;
        }
        bPl();
    }

    private void bPu() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.haM.setText(com.baidu.tbadk.plugins.b.is(com.baidu.tbadk.plugins.b.it(hotTopicBussinessData.mTopicName)));
            this.haM.setMovementMethod(com.baidu.tieba.view.c.bLZ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString is = com.baidu.tbadk.plugins.b.is(com.baidu.tbadk.plugins.b.it(hotTopicBussinessData.mTopicName));
            if (is != null) {
                this.haM.setText(is);
            }
            this.hXG.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.hXs != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hXs));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.eeJ);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bPr().getEditableText().toString();
        if (obj != null) {
            bPr().setText(TbFaceManager.Nt().a(getPageContext().getPageActivity(), obj, this.hXM));
            bPr().setSelection(bPr().getText().length());
        }
    }

    private String bPv() {
        if (bPr() == null || bPr().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bPr().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(e.j.share_video_default);
            }
            return getString(e.j.share_txt_default);
        }
        return bPr().getText().toString();
    }

    private String bPw() {
        if (this.mData == null || bPs() == null || bPs().getVisibility() != 0 || bPs().getText() == null) {
            return "";
        }
        String obj = bPs().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.hau != 0 && this.mData.getType() != 4 && this.haR != null && this.haR.getText() != null) {
            obj = this.haR.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bPx() {
        byV();
        this.mData.setContent(bPv());
        this.mData.setTitle(bPw());
        if (this.hXz >= 0) {
            this.mData.setCategoryFrom(this.hXz);
        }
        if (this.hXB >= 0) {
            this.mData.setCategoryTo(this.hXB);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aZQ != null && this.aZQ.alM());
        this.aZR.nz(this.writeImagesInfo.size() > 0);
        if (!v.I(this.mList) && this.hXF != null && this.hXF.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hXF.mForumId));
            this.mData.setForumName(this.hXF.mForumName);
        }
        this.aZR.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aZR.getWriteData().setVoice(null);
        this.aZR.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.aZR.startPostWrite();
    }

    private void u(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hXs != null) {
                i2 = this.hXs.getTotalCount();
                i = this.hXs.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(e.j.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aYo != null && !this.aYo.Ma()) {
                    bPr().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
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
                            bPr().getText().insert(bPr().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                k((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.hXk) {
                            sb2.append(com.baidu.tbadk.plugins.b.bhy);
                            this.hXk = false;
                        }
                        sb2.append(stringExtra);
                        hJ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hXF = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hXF);
            }
        } else if (i2 == 0) {
            if (this.aYo != null && !this.aYo.Ma()) {
                this.haQ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hXK.xr(postWriteCallBackData.getErrorString());
                        this.hXK.az(postWriteCallBackData.getSensitiveWords());
                        this.hXK.b(this.haM, this.haQ);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hXj)) {
                        bPs().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hXj)) {
                        bPr().requestFocus();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if ("1".equals(this.eeJ)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.eeJ)) {
            this.mData.setCanNoForum(false);
        }
        bPz();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.eeJ);
        bPx();
    }

    private void bPz() {
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bPs());
        HidenSoftKeyPad(this.mInputManager, bPr());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dJg) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCK));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hXs == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZW = i;
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bPA() {
        if (!this.hXE && this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aYo.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xt(int i) {
        if (i < this.hXq.size()) {
            for (int i2 = 0; i2 < this.hXq.size(); i2++) {
                this.hXq.get(i2).ou(false);
            }
            this.hXq.get(i).ou(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void uT(int i) {
        this.hau = i;
        this.haS.setCurrentIndex(i);
        xt(i);
        this.haR.setText(this.mPrefixData.getPrefixs().get(i));
        bzd();
        com.baidu.adp.lib.g.g.a(this.haS, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.haU.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Mz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hXJ = z;
        if (this.hXI != null && !z) {
            this.hXI.blc();
        }
        if (this.hXL != null && !z) {
            bPd();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hXJ && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hXk = false;
            this.hXj = "";
            if ("from_content".equals(str)) {
                this.hXj = "from_content";
            } else if ("from_title".equals(str)) {
                this.hXj = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ir(String.valueOf(charSequence.charAt(i)))) {
                oD(false);
            }
        }
    }

    public void bvl() {
        if (!v.I(this.mList)) {
            this.hXn.setVisibility(0);
            this.hXn.requestFocus();
            this.aYo.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hXn.setVisibility(8);
    }
}
