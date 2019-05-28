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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0041a, h.a {
    private OriginalThreadCardView Xb;
    private EditorTools cqK;
    private LocationModel cso;
    private NewWriteModel csp;
    private int iOO;
    private TextView iPl;
    private com.baidu.tieba.write.h iPm;
    private ImageView iPn;
    private View iPo;
    private boolean isPrivacy;
    private Toast jLA;
    private AdditionData jLB;
    private RelativeLayout jLC;
    private TextView jLD;
    private TextView jLE;
    private TextView jLF;
    List<v> jLG;
    v jLH;
    private int jLI;
    private String jLJ;
    private int jLK;
    private PostCategoryView jLL;
    private HotTopicBussinessData jLO;
    private TextView jLP;
    private com.baidu.tieba.write.editor.b jLR;
    private e jLU;
    private LinearLayout jLv;
    private LinearLayout jLw;
    private View jLy;
    private com.baidu.tieba.view.b jMb;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jLs = "";
    private boolean jLt = false;
    private WriteData mData = null;
    private boolean jLu = false;
    private InputMethodManager mInputManager = null;
    private EditText iPg = null;
    private View iPh = null;
    private LinearLayout iPj = null;
    private EditText iPk = null;
    private FeedBackModel jLx = null;
    private ArrayList<WritePrefixItemLayout> jLz = new ArrayList<>();
    private final KeyEvent eXz = new KeyEvent(0, 67);
    private View cdX = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String cst = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int csu = 0;
    private View mRootView = null;
    private ScrollView jLM = null;
    private boolean jLN = false;
    private com.baidu.tbadk.core.view.b cAW = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fOb = "2";
    private SpannableStringBuilder jLQ = new SpannableStringBuilder();
    private boolean jLS = false;
    private final b jLT = new b();
    private TbFaceManager.a jLV = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qn(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.ns());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.g(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a fqe = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bSZ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bSZ));
        }
    };
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jLT.aI(null);
                if (z) {
                    TransmitPostEditActivity.this.fl(z);
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
                    TransmitPostEditActivity.this.jLT.FE(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jLT.aI(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jLT.b(TransmitPostEditActivity.this.iPg, TransmitPostEditActivity.this.iPk);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.alA());
                    if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a csB = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void arJ() {
            TransmitPostEditActivity.this.showToast(R.string.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(R.string.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cmZ())) {
                TransmitPostEditActivity.this.b(2, true, aVar.cmZ());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jbc = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.cso.qQ(false);
                    TransmitPostEditActivity.this.cso.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.cso.qQ(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jLW = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jLX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cyA = TransmitPostEditActivity.this.cyA();
            if (cyA >= 0 && cyA < TransmitPostEditActivity.this.iPk.getText().length()) {
                TransmitPostEditActivity.this.iPk.setSelection(cyA);
            }
        }
    };
    private boolean jLY = true;
    private final View.OnFocusChangeListener iPe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iPg || view == TransmitPostEditActivity.this.cdX || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jLY = true;
                    TransmitPostEditActivity.this.cyB();
                    if (TransmitPostEditActivity.this.cqK != null) {
                        TransmitPostEditActivity.this.cqK.app();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iPg);
                } else if (view == TransmitPostEditActivity.this.iPg) {
                    TransmitPostEditActivity.this.iPl.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iPk && z) {
                TransmitPostEditActivity.this.jLY = false;
                TransmitPostEditActivity.this.cyB();
                TransmitPostEditActivity.this.cqK.app();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iPk);
            }
            TransmitPostEditActivity.this.cyH();
        }
    };
    private TextWatcher jLZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jMd = "";
        private String jMe;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMe != null ? this.jMe.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cjw();
            TransmitPostEditActivity.this.cyI();
            EditText cyT = TransmitPostEditActivity.this.cyT();
            if (editable != null && cyT != null && cyT.getText() != null) {
                if (this.jMd == null || !this.jMd.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jLT != null) {
                        this.jMd = cyT.getText().toString();
                        TransmitPostEditActivity.this.jLT.o(cyT);
                        return;
                    }
                    return;
                }
                cyT.setSelection(cyT.getSelectionEnd());
            }
        }
    };
    private TextWatcher jMa = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jMe;
        private String jMf = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMe != null ? this.jMe.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cjw();
            EditText cyS = TransmitPostEditActivity.this.cyS();
            if (editable != null && cyS != null && cyS.getText() != null) {
                int selectionEnd = cyS.getSelectionEnd();
                if (this.jMf == null || !this.jMf.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jLT != null) {
                        this.jMf = cyS.getText().toString();
                        TransmitPostEditActivity.this.jLT.o(cyS);
                        return;
                    }
                    return;
                }
                cyS.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aru() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void arv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            arx();
        } else if (this.cso.cnf()) {
            aru();
        } else {
            this.cso.qQ(false);
            b(1, true, null);
            this.cso.cnd();
        }
    }

    private void arx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.cso.aTL();
                } else {
                    TransmitPostEditActivity.this.csB.arJ();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyA() {
        int selectionEnd = cyS().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cyS().getText().getSpans(0, cyS().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cyS().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cyS().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyB() {
        if (this.cqK != null) {
            this.cqK.setBarLauncherEnabled(!this.jLY);
            this.cqK.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jLN) {
            this.iPg.setVisibility(8);
            cjw();
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
        this.cso = new LocationModel(this);
        this.cso.a(this.csB);
        registerListener(this.jbc);
        registerListener(this.jLW);
        initEditor();
        this.iPk.requestFocus();
        cfy();
        czb();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.cqK = new EditorTools(getActivity());
        this.cqK.setBarMaxLauCount(4);
        this.cqK.setMoreButtonAtEnd(true);
        this.cqK.setBarLauncherType(1);
        this.cqK.fd(true);
        this.cqK.fe(true);
        this.cqK.setMoreLauncherIcon(R.drawable.write_more);
        this.cqK.setBackgroundColorId(R.color.cp_bg_line_d);
        cyC();
        this.cqK.aqT();
        if (this.jLv != null) {
            this.jLv.addView(this.cqK);
        }
        cyD();
        this.cqK.pO();
        com.baidu.tbadk.editortools.g kg = this.cqK.kg(6);
        if (kg != null && !TextUtils.isEmpty(this.cst)) {
            ((View) kg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.cst);
                }
            });
        }
        if (!this.jLN) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cqK.app();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("xiaoying_has_click", false)) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("hot_topic_has_click", false)) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        cyF();
    }

    private void cyC() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.crt = R.drawable.write_at;
        this.cqK.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.cqK.b(aVar2);
        aVar2.crt = R.drawable.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.crv = 4;
            kVar.crt = R.drawable.icon_post_location_selector;
            this.cqK.b(kVar);
        }
        if (this.jLB == null) {
            if (this.jLR == null) {
                this.jLR = new com.baidu.tieba.write.editor.b(getActivity(), this.fOb);
                this.jLR.cxA();
                this.jLR.setFrom("from_share_write");
                this.jLR.bs(this.mData.getForumId(), this.mPrivateThread);
            }
            this.cqK.b(this.jLR);
        }
        this.cqK.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqK.kj(5);
        if (kj != null) {
            kj.crv = 1;
            kj.crt = R.drawable.write_emotion;
        }
    }

    private void cyD() {
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
                            TiebaStatic.log(new am("c12608").P("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.cyR()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cyR()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cyU();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cjw();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jLB == null) {
                            TransmitPostEditActivity.this.ary();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.csu) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cw(pageActivity)) {
                                    TransmitPostEditActivity.this.arv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aru();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.cso != null) {
                            TransmitPostEditActivity.this.cso.qQ(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.bT("fid", str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.cqK.aqV()) {
                                        TransmitPostEditActivity.this.cqK.app();
                                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.cjw();
                        if (TransmitPostEditActivity.this.iPk != null) {
                            TransmitPostEditActivity.this.iPk.requestFocus();
                        }
                        TransmitPostEditActivity.this.cqK.app();
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPk);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jLt = true;
                        TransmitPostEditActivity.this.rW(true);
                        if (TransmitPostEditActivity.this.cyT().isFocused()) {
                            TransmitPostEditActivity.this.jLs = "from_title";
                        } else if (TransmitPostEditActivity.this.cyS().isFocused()) {
                            TransmitPostEditActivity.this.jLs = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jLw.setVisibility(0);
                        TransmitPostEditActivity.this.jLw.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jLw.hasFocus()) {
                            TransmitPostEditActivity.this.iPk.requestFocus();
                            TransmitPostEditActivity.this.iPk.setSelection(TransmitPostEditActivity.this.iPk.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jLw.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cqK.setActionListener(31, bVar);
        this.cqK.setActionListener(16, bVar);
        this.cqK.setActionListener(14, bVar);
        this.cqK.setActionListener(24, bVar);
        this.cqK.setActionListener(3, bVar);
        this.cqK.setActionListener(10, bVar);
        this.cqK.setActionListener(11, bVar);
        this.cqK.setActionListener(12, bVar);
        this.cqK.setActionListener(13, bVar);
        this.cqK.setActionListener(15, bVar);
        this.cqK.setActionListener(18, bVar);
        this.cqK.setActionListener(20, bVar);
        this.cqK.setActionListener(25, bVar);
        this.cqK.setActionListener(27, bVar);
        this.cqK.setActionListener(29, bVar);
        this.cqK.setActionListener(43, bVar);
        this.cqK.setActionListener(45, bVar);
        this.cqK.setActionListener(53, bVar);
        this.cqK.setActionListener(48, bVar);
        this.cqK.setActionListener(46, bVar);
        this.cqK.setActionListener(49, bVar);
        this.cqK.setActionListener(47, bVar);
        this.cqK.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ary() {
        if (this.cso.aTH()) {
            if (this.cso.cnf()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cnb().getLocationData().cmZ());
                return;
            }
            b(1, true, null);
            this.cso.cnd();
            return;
        }
        b(0, true, null);
    }

    protected void cjo() {
        if (this.csp != null) {
            this.csp.cancelLoadData();
        }
        if (this.jLx != null) {
            this.jLx.cancelLoadData();
        }
        if (this.cso != null) {
            this.cso.cancelLoadData();
        }
    }

    private void cyE() {
        if (this.jLU != null) {
            this.jLU.hideTip();
        }
    }

    private void cyF() {
        if (this.jLU == null) {
            this.jLU = new e(getPageContext());
        }
        this.jLU.c(this.cqK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cyE();
        TiebaPrepareImageService.StopService();
        cjo();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cyT().getText().toString());
        this.mData.setContent(cyS().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iPm != null && this.iPm.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iPm, getPageContext().getPageActivity());
                return true;
            } else if (this.cqK.aqV()) {
                this.cqK.app();
                return true;
            } else {
                cjo();
                cyG();
                return true;
            }
        }
        if (i == 67 && (text = cyS().getText()) != null) {
            int selectionStart = cyS().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyS().onKeyDown(67, this.eXz);
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
        al.f(this.mPost, R.color.cp_link_tip_a, 1);
        cyB();
        al.l(this.iPh, R.color.cp_bg_line_c);
        al.l(cyT(), R.color.cp_bg_line_d);
        al.l(cyS(), R.color.cp_bg_line_d);
        cjw();
        this.cqK.onChangeSkinType(i);
        if (this.jLL != null) {
            this.jLL.ajG();
        }
        al.j(this.mName, R.color.cp_cont_b);
        cyH();
        cyI();
        if (this.jLT != null) {
            this.jLT.c(cyT(), cyS());
        }
        this.Xb.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        if (this.iPg.hasFocus()) {
            this.iPg.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPg.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
        if (this.iPk.hasFocus()) {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyI() {
        if (this.iPg != null) {
            if (this.iPg.getText().toString().length() == 0) {
                this.iPg.getPaint().setFakeBoldText(false);
            } else if (this.iPg.getText().toString().length() > 0) {
                this.iPg.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cAW = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jLN = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, R.color.cp_cont_b);
        cyK();
        this.jLM = (ScrollView) findViewById(R.id.write_scrollview);
        this.jLM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iPk != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iPk);
                    }
                    if (TransmitPostEditActivity.this.cqK != null) {
                        TransmitPostEditActivity.this.cqK.app();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jLv = (LinearLayout) findViewById(R.id.tool_view);
        this.jLv.setContentDescription("..");
        this.jLw = (LinearLayout) findViewById(R.id.title_view);
        this.iPh = findViewById(R.id.interval_view);
        this.jLP = (TextView) findViewById(R.id.hot_topic_title_edt);
        cjv();
        if (this.jLN) {
            this.jLM.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cjx();
        cyQ();
        this.iPj = (LinearLayout) findViewById(R.id.post_content_container);
        this.iPj.setDrawingCacheEnabled(false);
        this.iPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iPk.requestFocus();
            }
        });
        this.cdX.setOnFocusChangeListener(this.iPe);
        this.cdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cjo();
                TransmitPostEditActivity.this.cyG();
            }
        });
        cyN();
        cyP();
        cyJ();
        cyB();
        cyO();
        cju();
        cyV();
        if (this.mData.getType() == 4 && this.iPo != null && this.jLy != null) {
            this.iPo.setVisibility(8);
            this.jLy.setVisibility(8);
        }
        cjw();
        ShowSoftKeyPad(this.mInputManager, this.iPg);
    }

    private void cyJ() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fOb != null && this.fOb.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fOb != null && this.fOb.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.iPg.setVisibility(0);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iPg.setVisibility(8);
                    return;
            }
        }
    }

    private void cyK() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iPe);
    }

    private void cyL() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jLu && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = ap.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cyT() != null) {
                cyT().setText(i);
                cyT().setSelection(i.length());
            }
        }
    }

    private void cyM() {
        this.jLG = null;
        this.jLI = -1;
        this.jLK = -1;
        com.baidu.tieba.frs.x rs = w.blC().rs(1);
        if (rs != null) {
            this.jLG = rs.fsG;
            this.jLI = getIntent().getIntExtra("category_id", -1);
            if (this.jLG != null && !this.jLG.isEmpty() && this.jLI >= 0) {
                this.jLH = new v();
                this.jLH.fsC = 0;
                this.jLH.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jLK = this.jLH.fsC;
                this.jLJ = this.jLH.name;
                for (v vVar : this.jLG) {
                    if (vVar.fsC == this.jLI) {
                        this.jLK = vVar.fsC;
                        this.jLJ = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cyN() {
        if (this.jLG != null && !this.jLG.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jLL = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jLL.setText(this.jLJ);
            this.jLL.setCategoryContainerData(this.jLG, this.jLH, this.jLK);
            this.jLL.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jLL.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fsC);
                        TransmitPostEditActivity.this.jLK = arVar.fsC;
                        TransmitPostEditActivity.this.jLL.cyo();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jLL.cyn();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyT());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyS());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jMb = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jMb.setTitle(R.string.no_disturb_start_time);
        this.jMb.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jMb);
        this.jMb.setButton(-2, getPageContext().getString(R.string.cancel), this.jMb);
        return this.jMb;
    }

    private void cyO() {
        this.jLC = (RelativeLayout) findViewById(R.id.addition_container);
        this.jLD = (TextView) findViewById(R.id.addition_create_time);
        this.jLE = (TextView) findViewById(R.id.addition_last_time);
        this.jLF = (TextView) findViewById(R.id.addition_last_content);
        if (this.jLB != null) {
            this.jLC.setVisibility(0);
            this.jLD.setText(getPageContext().getString(R.string.write_addition_create) + ap.aC(this.jLB.getCreateTime() * 1000));
            if (this.jLB.getAlreadyCount() == 0) {
                this.jLE.setVisibility(8);
            } else {
                this.jLE.setText(getPageContext().getString(R.string.write_addition_last) + ap.aC(this.jLB.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jLB.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jLF.setText(lastAdditionContent);
            } else {
                this.jLF.setVisibility(8);
            }
            cyS().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jLB.getAlreadyCount()), Integer.valueOf(this.jLB.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jLC.setVisibility(8);
    }

    private void cju() {
        this.iPo = findViewById(R.id.post_prefix_layout);
        this.iPl = (TextView) findViewById(R.id.post_prefix);
        this.jLy = findViewById(R.id.prefix_divider);
        this.iPn = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iPo.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iOO = 1;
            this.iPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iPl.setVisibility(0);
                    TransmitPostEditActivity.this.iPo.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iPm, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.cqK.app();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPg);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPk);
                }
            });
            this.iPn = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iPn.setVisibility(0);
                this.iPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iPl.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iPm, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.cqK.app();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyT());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyS());
                    }
                });
            }
            this.iPm = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iPm.a(this);
            this.iPm.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iPm.setOutsideTouchable(true);
            this.iPm.setFocusable(true);
            this.iPm.setOnDismissListener(this);
            this.iPm.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_d));
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_c);
            al.k(this.iPl, R.color.cp_bg_line_d);
            al.c(this.iPn, (int) R.drawable.icon_frs_arrow_n);
            this.iPl.setTextColor(color);
            this.jLz.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jLz.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iPm.addView(writePrefixItemLayout);
            }
            this.iPm.setCurrentIndex(0);
            this.iPl.setText(prefixs.get(1));
            CD(1);
            return;
        }
        this.iPo.setVisibility(8);
    }

    protected void cyP() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jLT.a(TransmitPostEditActivity.this.iPg, TransmitPostEditActivity.this.iPk)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jLT.cwi());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyT());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyS());
                    TransmitPostEditActivity.this.cqK.app();
                    TiebaStatic.log(new am("c12608").P("obj_locate", 7));
                    TransmitPostEditActivity.this.cyZ();
                }
            }
        });
    }

    protected void cjv() {
        this.iPg = (EditText) findViewById(R.id.post_title);
        this.iPg.setOnClickListener(this.jLX);
        this.iPg.setOnFocusChangeListener(this.iPe);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iPg.setText(this.mData.getTitle());
            this.iPg.setSelection(this.mData.getTitle().length());
        }
        this.iPg.addTextChangedListener(this.jLZ);
        if (!this.mData.getHaveDraft()) {
            cyL();
        }
        this.iPg.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cjx() {
        this.iPk = (EditText) findViewById(R.id.post_content);
        this.iPk.setDrawingCacheEnabled(false);
        this.iPk.setOnClickListener(this.jLX);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.iPk.setText(al);
            this.iPk.setSelection(al.length());
        }
        this.iPk.setOnFocusChangeListener(this.iPe);
        this.iPk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iPk.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPk.addTextChangedListener(this.jMa);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iPk.setHint(R.string.share_video_default);
        } else {
            this.iPk.setHint(R.string.share_txt_default);
        }
    }

    private void cyQ() {
        this.Xb = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Xb.setVisibility(0);
        this.Xb.b(this.mOriginalThreadInfo);
        this.Xb.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyR() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jLB != null) {
            i = 1000;
        }
        return cyS().getText() != null && cyS().getText().length() >= i;
    }

    private void pV(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jLs)) {
                this.jLs = "";
                cyS().requestFocus();
                if (cyS().getText() != null && cyS().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyS().getSelectionStart();
                    editable = cyS().getText();
                }
            } else if ("from_title".equals(this.jLs)) {
                this.jLs = "";
                cyT().requestFocus();
                if (cyT().getText() != null && cyT().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyT().getSelectionStart();
                    editable = cyT().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cyS().getText().getSpans(0, cyS().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jLA == null) {
                this.jLA = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jLA.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType alp = pVar.alp();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iv().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cyS().getSelectionStart(), aVar, alp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cyS() != null && cyS().getText() != null) {
            Bitmap ns = aVar.ns();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ns);
            int width = ns.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, ns.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cyS().getSelectionStart() - 1;
                if (cyS().getText().length() > 1 && selectionStart >= 0 && cyS().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cyS().getText().insert(cyS().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cyS().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cyS().getText().insert(cyS().getSelectionStart(), spannableString2);
            }
            Editable text = cyS().getText();
            if (text != null) {
                this.jLQ.clear();
                this.jLQ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLQ);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cyS().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cyS().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cyS().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyS() {
        return this.iPk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyT() {
        return this.iPg;
    }

    protected void cyU() {
        Editable text;
        if (cyS() != null && (text = cyS().getText()) != null) {
            int selectionStart = cyS().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyS().onKeyDown(67, this.eXz);
            }
            cyS().onKeyDown(67, this.eXz);
            int selectionStart2 = cyS().getSelectionStart();
            this.jLQ.clear();
            this.jLQ.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jLQ);
            cyS().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cAW.e(null);
        this.cAW.it(R.string.sending);
        this.cAW.ef(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cAW.ef(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjw() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cyT() != null) {
                str = cyT().getText().toString();
            }
            if (cyS() != null) {
                str2 = cyS().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iOO == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            rX(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        rX(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    rX(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jLN) {
                    rX(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rX(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                rX(true);
            } else if (this.mData.getVideoInfo() != null) {
                rX(true);
            } else {
                rX(false);
            }
        }
    }

    private void rX(boolean z) {
        al.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.csp = new NewWriteModel(this);
        this.csp.b(this.csD);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cjo();
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
                this.jLB = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jLB != null);
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
            this.fOb = bundle.getString("KEY_CALL_FROM");
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
            this.jLB = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jLB != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fOb = intent.getStringExtra("KEY_CALL_FROM");
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
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jLu = true;
        }
        cyM();
    }

    private void cyV() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iPg.setText(com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName)));
            this.iPg.setMovementMethod(com.baidu.tieba.view.c.cvd());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qF = com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName));
            if (qF != null) {
                this.iPg.setText(qF);
            }
            this.jLP.setText(hotTopicBussinessData.mForumName);
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
        if (this.jLB != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jLB));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fOb);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cyS().getEditableText().toString();
        if (obj != null) {
            cyS().setText(TbFaceManager.aso().a(getPageContext().getPageActivity(), obj, this.jLV));
            cyS().setSelection(cyS().getText().length());
        }
    }

    private String cyW() {
        if (cyS() == null || cyS().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cyS().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cyS().getText().toString();
    }

    private String cyX() {
        if (this.mData == null || cyT() == null || cyT().getVisibility() != 0 || cyT().getText() == null) {
            return "";
        }
        String obj = cyT().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iOO != 0 && this.mData.getType() != 4 && this.iPl != null && this.iPl.getText() != null) {
            obj = this.iPl.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cyY() {
        cjo();
        this.mData.setContent(cyW());
        this.mData.setTitle(cyX());
        if (this.jLI >= 0) {
            this.mData.setCategoryFrom(this.jLI);
        }
        if (this.jLK >= 0) {
            this.mData.setCategoryTo(this.jLK);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.cso != null && this.cso.aTH());
        this.csp.qS(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jLO != null && this.jLO.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jLO.mForumId));
            this.mData.setForumName(this.jLO.mForumName);
        }
        this.csp.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.csp.getWriteData().setVoice(null);
        this.csp.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        this.csp.startPostWrite();
    }

    private void z(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jLB != null) {
                i2 = this.jLB.getTotalCount();
                i = this.jLB.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.cqK != null && !this.cqK.aqV()) {
                    cyS().requestFocus();
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
                            cyS().getText().insert(cyS().getSelectionStart(), sb.toString());
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
                        if (this.jLt) {
                            sb2.append(com.baidu.tbadk.plugins.b.cAq);
                            this.jLt = false;
                        }
                        sb2.append(stringExtra);
                        pV(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jLO = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jLO);
            }
        } else if (i2 == 0) {
            if (this.cqK != null && !this.cqK.aqV()) {
                this.iPk.requestFocus();
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
                        this.jLT.FE(postWriteCallBackData.getErrorString());
                        this.jLT.aI(postWriteCallBackData.getSensitiveWords());
                        this.jLT.b(this.iPg, this.iPk);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jLs)) {
                        cyT().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jLs)) {
                        cyS().requestFocus();
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
    public void cyZ() {
        if ("1".equals(this.fOb)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fOb)) {
            this.mData.setCanNoForum(false);
        }
        cza();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fOb);
        cyY();
    }

    private void cza() {
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cyT());
        HidenSoftKeyPad(this.mInputManager, cyS());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fqe) != null) {
                    TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bSZ));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jLB == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                z(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.csu = i;
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czb() {
        if (!this.jLN && this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.cqK.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void CD(int i) {
        if (i < this.jLz.size()) {
            for (int i2 = 0; i2 < this.jLz.size(); i2++) {
                this.jLz.get(i2).rN(false);
            }
            this.jLz.get(i).rN(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Ad(int i) {
        this.iOO = i;
        this.iPm.setCurrentIndex(i);
        CD(i);
        this.iPl.setText(this.mPrefixData.getPrefixs().get(i));
        cjw();
        com.baidu.adp.lib.g.g.a(this.iPm, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iPo.setSelected(false);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
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
            arv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jLS = z;
        if (this.jLR != null && !z) {
            this.jLR.bed();
        }
        if (this.jLU != null && !z) {
            cyE();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jLS && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jLt = false;
            this.jLs = "";
            if ("from_content".equals(str)) {
                this.jLs = "from_content";
            } else if ("from_title".equals(str)) {
                this.jLs = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qE(String.valueOf(charSequence.charAt(i)))) {
                rW(false);
            }
        }
    }

    public void cfy() {
        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
            this.jLw.setVisibility(0);
            this.jLw.requestFocus();
            this.cqK.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jLw.setVisibility(8);
    }
}
