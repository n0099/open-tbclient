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
    private int iOM;
    private TextView iPj;
    private com.baidu.tieba.write.h iPk;
    private ImageView iPl;
    private View iPm;
    private boolean isPrivacy;
    private AdditionData jLA;
    private RelativeLayout jLB;
    private TextView jLC;
    private TextView jLD;
    private TextView jLE;
    List<v> jLF;
    v jLG;
    private int jLH;
    private String jLI;
    private int jLJ;
    private PostCategoryView jLK;
    private HotTopicBussinessData jLN;
    private TextView jLO;
    private com.baidu.tieba.write.editor.b jLQ;
    private e jLT;
    private LinearLayout jLu;
    private LinearLayout jLv;
    private View jLx;
    private Toast jLz;
    private com.baidu.tieba.view.b jMa;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jLr = "";
    private boolean jLs = false;
    private WriteData mData = null;
    private boolean jLt = false;
    private InputMethodManager mInputManager = null;
    private EditText iPe = null;
    private View iPf = null;
    private LinearLayout iPh = null;
    private EditText iPi = null;
    private FeedBackModel jLw = null;
    private ArrayList<WritePrefixItemLayout> jLy = new ArrayList<>();
    private final KeyEvent eXy = new KeyEvent(0, 67);
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
    private ScrollView jLL = null;
    private boolean jLM = false;
    private com.baidu.tbadk.core.view.b cAW = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fOa = "2";
    private SpannableStringBuilder jLP = new SpannableStringBuilder();
    private boolean jLR = false;
    private final b jLS = new b();
    private TbFaceManager.a jLU = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a fqd = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
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
                TransmitPostEditActivity.this.jLS.aI(null);
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
                    TransmitPostEditActivity.this.jLS.FE(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jLS.aI(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jLS.b(TransmitPostEditActivity.this.iPe, TransmitPostEditActivity.this.iPi);
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
            if (aVar != null && !StringUtils.isNull(aVar.cmX())) {
                TransmitPostEditActivity.this.b(2, true, aVar.cmX());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jba = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
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
    private CustomMessageListener jLV = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jLW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cyy = TransmitPostEditActivity.this.cyy();
            if (cyy >= 0 && cyy < TransmitPostEditActivity.this.iPi.getText().length()) {
                TransmitPostEditActivity.this.iPi.setSelection(cyy);
            }
        }
    };
    private boolean jLX = true;
    private final View.OnFocusChangeListener iPc = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iPe || view == TransmitPostEditActivity.this.cdX || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jLX = true;
                    TransmitPostEditActivity.this.cyz();
                    if (TransmitPostEditActivity.this.cqK != null) {
                        TransmitPostEditActivity.this.cqK.app();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iPe);
                } else if (view == TransmitPostEditActivity.this.iPe) {
                    TransmitPostEditActivity.this.iPj.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iPi && z) {
                TransmitPostEditActivity.this.jLX = false;
                TransmitPostEditActivity.this.cyz();
                TransmitPostEditActivity.this.cqK.app();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iPi);
            }
            TransmitPostEditActivity.this.cyF();
        }
    };
    private TextWatcher jLY = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jMc = "";
        private String jMd;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMd = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMd != null ? this.jMd.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cju();
            TransmitPostEditActivity.this.cyG();
            EditText cyR = TransmitPostEditActivity.this.cyR();
            if (editable != null && cyR != null && cyR.getText() != null) {
                if (this.jMc == null || !this.jMc.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jLS != null) {
                        this.jMc = cyR.getText().toString();
                        TransmitPostEditActivity.this.jLS.o(cyR);
                        return;
                    }
                    return;
                }
                cyR.setSelection(cyR.getSelectionEnd());
            }
        }
    };
    private TextWatcher jLZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jMd;
        private String jMe = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMd = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMd != null ? this.jMd.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cju();
            EditText cyQ = TransmitPostEditActivity.this.cyQ();
            if (editable != null && cyQ != null && cyQ.getText() != null) {
                int selectionEnd = cyQ.getSelectionEnd();
                if (this.jMe == null || !this.jMe.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jLS != null) {
                        this.jMe = cyQ.getText().toString();
                        TransmitPostEditActivity.this.jLS.o(cyQ);
                        return;
                    }
                    return;
                }
                cyQ.setSelection(selectionEnd);
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
        } else if (this.cso.cnd()) {
            aru();
        } else {
            this.cso.qQ(false);
            b(1, true, null);
            this.cso.cnb();
        }
    }

    private void arx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.cso.aTI();
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
    public int cyy() {
        int selectionEnd = cyQ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cyQ().getText().getSpans(0, cyQ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cyQ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cyQ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyz() {
        if (this.cqK != null) {
            this.cqK.setBarLauncherEnabled(!this.jLX);
            this.cqK.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jLM) {
            this.iPe.setVisibility(8);
            cju();
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
        registerListener(this.jba);
        registerListener(this.jLV);
        initEditor();
        this.iPi.requestFocus();
        cfw();
        cyZ();
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
        cyA();
        this.cqK.aqT();
        if (this.jLu != null) {
            this.jLu.addView(this.cqK);
        }
        cyB();
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
        if (!this.jLM) {
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
        cyD();
    }

    private void cyA() {
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
        if (this.jLA == null) {
            if (this.jLQ == null) {
                this.jLQ = new com.baidu.tieba.write.editor.b(getActivity(), this.fOa);
                this.jLQ.cxy();
                this.jLQ.setFrom("from_share_write");
                this.jLQ.bs(this.mData.getForumId(), this.mPrivateThread);
            }
            this.cqK.b(this.jLQ);
        }
        this.cqK.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqK.kj(5);
        if (kj != null) {
            kj.crv = 1;
            kj.crt = R.drawable.write_emotion;
        }
    }

    private void cyB() {
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
                        if (TransmitPostEditActivity.this.cyP()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cyP()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cyS();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cju();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jLA == null) {
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
                        TransmitPostEditActivity.this.cju();
                        if (TransmitPostEditActivity.this.iPi != null) {
                            TransmitPostEditActivity.this.iPi.requestFocus();
                        }
                        TransmitPostEditActivity.this.cqK.app();
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPi);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jLs = true;
                        TransmitPostEditActivity.this.rW(true);
                        if (TransmitPostEditActivity.this.cyR().isFocused()) {
                            TransmitPostEditActivity.this.jLr = "from_title";
                        } else if (TransmitPostEditActivity.this.cyQ().isFocused()) {
                            TransmitPostEditActivity.this.jLr = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jLv.setVisibility(0);
                        TransmitPostEditActivity.this.jLv.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jLv.hasFocus()) {
                            TransmitPostEditActivity.this.iPi.requestFocus();
                            TransmitPostEditActivity.this.iPi.setSelection(TransmitPostEditActivity.this.iPi.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jLv.setVisibility(8);
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
        if (this.cso.aTE()) {
            if (this.cso.cnd()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cmZ().getLocationData().cmX());
                return;
            }
            b(1, true, null);
            this.cso.cnb();
            return;
        }
        b(0, true, null);
    }

    protected void cjm() {
        if (this.csp != null) {
            this.csp.cancelLoadData();
        }
        if (this.jLw != null) {
            this.jLw.cancelLoadData();
        }
        if (this.cso != null) {
            this.cso.cancelLoadData();
        }
    }

    private void cyC() {
        if (this.jLT != null) {
            this.jLT.hideTip();
        }
    }

    private void cyD() {
        if (this.jLT == null) {
            this.jLT = new e(getPageContext());
        }
        this.jLT.c(this.cqK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cyC();
        TiebaPrepareImageService.StopService();
        cjm();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyE() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cyR().getText().toString());
        this.mData.setContent(cyQ().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iPk != null && this.iPk.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iPk, getPageContext().getPageActivity());
                return true;
            } else if (this.cqK.aqV()) {
                this.cqK.app();
                return true;
            } else {
                cjm();
                cyE();
                return true;
            }
        }
        if (i == 67 && (text = cyQ().getText()) != null) {
            int selectionStart = cyQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyQ().onKeyDown(67, this.eXy);
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
        cyz();
        al.l(this.iPf, R.color.cp_bg_line_c);
        al.l(cyR(), R.color.cp_bg_line_d);
        al.l(cyQ(), R.color.cp_bg_line_d);
        cju();
        this.cqK.onChangeSkinType(i);
        if (this.jLK != null) {
            this.jLK.ajG();
        }
        al.j(this.mName, R.color.cp_cont_b);
        cyF();
        cyG();
        if (this.jLS != null) {
            this.jLS.c(cyR(), cyQ());
        }
        this.Xb.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        if (this.iPe.hasFocus()) {
            this.iPe.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPe.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
        if (this.iPi.hasFocus()) {
            this.iPi.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPi.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.iPe != null) {
            if (this.iPe.getText().toString().length() == 0) {
                this.iPe.getPaint().setFakeBoldText(false);
            } else if (this.iPe.getText().toString().length() > 0) {
                this.iPe.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cAW = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jLM = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, R.color.cp_cont_b);
        cyI();
        this.jLL = (ScrollView) findViewById(R.id.write_scrollview);
        this.jLL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iPi != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iPi);
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
        this.jLu = (LinearLayout) findViewById(R.id.tool_view);
        this.jLu.setContentDescription("..");
        this.jLv = (LinearLayout) findViewById(R.id.title_view);
        this.iPf = findViewById(R.id.interval_view);
        this.jLO = (TextView) findViewById(R.id.hot_topic_title_edt);
        cjt();
        if (this.jLM) {
            this.jLL.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cjv();
        cyO();
        this.iPh = (LinearLayout) findViewById(R.id.post_content_container);
        this.iPh.setDrawingCacheEnabled(false);
        this.iPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iPi.requestFocus();
            }
        });
        this.cdX.setOnFocusChangeListener(this.iPc);
        this.cdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cjm();
                TransmitPostEditActivity.this.cyE();
            }
        });
        cyL();
        cyN();
        cyH();
        cyz();
        cyM();
        cjs();
        cyT();
        if (this.mData.getType() == 4 && this.iPm != null && this.jLx != null) {
            this.iPm.setVisibility(8);
            this.jLx.setVisibility(8);
        }
        cju();
        ShowSoftKeyPad(this.mInputManager, this.iPe);
    }

    private void cyH() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fOa != null && this.fOa.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fOa != null && this.fOa.equals("2")) {
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
                    this.iPe.setVisibility(0);
                    this.iPi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iPi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iPi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iPe.setVisibility(8);
                    return;
            }
        }
    }

    private void cyI() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iPc);
    }

    private void cyJ() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jLt && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = ap.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cyR() != null) {
                cyR().setText(i);
                cyR().setSelection(i.length());
            }
        }
    }

    private void cyK() {
        this.jLF = null;
        this.jLH = -1;
        this.jLJ = -1;
        com.baidu.tieba.frs.x rs = w.blz().rs(1);
        if (rs != null) {
            this.jLF = rs.fsF;
            this.jLH = getIntent().getIntExtra("category_id", -1);
            if (this.jLF != null && !this.jLF.isEmpty() && this.jLH >= 0) {
                this.jLG = new v();
                this.jLG.fsB = 0;
                this.jLG.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jLJ = this.jLG.fsB;
                this.jLI = this.jLG.name;
                for (v vVar : this.jLF) {
                    if (vVar.fsB == this.jLH) {
                        this.jLJ = vVar.fsB;
                        this.jLI = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cyL() {
        if (this.jLF != null && !this.jLF.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jLK = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jLK.setText(this.jLI);
            this.jLK.setCategoryContainerData(this.jLF, this.jLG, this.jLJ);
            this.jLK.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jLK.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fsB);
                        TransmitPostEditActivity.this.jLJ = arVar.fsB;
                        TransmitPostEditActivity.this.jLK.cym();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jLK.cyl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyR());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyQ());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jMa = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jMa.setTitle(R.string.no_disturb_start_time);
        this.jMa.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jMa);
        this.jMa.setButton(-2, getPageContext().getString(R.string.cancel), this.jMa);
        return this.jMa;
    }

    private void cyM() {
        this.jLB = (RelativeLayout) findViewById(R.id.addition_container);
        this.jLC = (TextView) findViewById(R.id.addition_create_time);
        this.jLD = (TextView) findViewById(R.id.addition_last_time);
        this.jLE = (TextView) findViewById(R.id.addition_last_content);
        if (this.jLA != null) {
            this.jLB.setVisibility(0);
            this.jLC.setText(getPageContext().getString(R.string.write_addition_create) + ap.aC(this.jLA.getCreateTime() * 1000));
            if (this.jLA.getAlreadyCount() == 0) {
                this.jLD.setVisibility(8);
            } else {
                this.jLD.setText(getPageContext().getString(R.string.write_addition_last) + ap.aC(this.jLA.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jLA.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jLE.setText(lastAdditionContent);
            } else {
                this.jLE.setVisibility(8);
            }
            cyQ().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jLA.getAlreadyCount()), Integer.valueOf(this.jLA.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jLB.setVisibility(8);
    }

    private void cjs() {
        this.iPm = findViewById(R.id.post_prefix_layout);
        this.iPj = (TextView) findViewById(R.id.post_prefix);
        this.jLx = findViewById(R.id.prefix_divider);
        this.iPl = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iPm.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iOM = 1;
            this.iPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iPj.setVisibility(0);
                    TransmitPostEditActivity.this.iPm.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iPk, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.cqK.app();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPe);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iPi);
                }
            });
            this.iPl = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iPl.setVisibility(0);
                this.iPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iPj.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iPk, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.cqK.app();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyR());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyQ());
                    }
                });
            }
            this.iPk = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iPk.a(this);
            this.iPk.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iPk.setOutsideTouchable(true);
            this.iPk.setFocusable(true);
            this.iPk.setOnDismissListener(this);
            this.iPk.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_d));
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_c);
            al.k(this.iPj, R.color.cp_bg_line_d);
            al.c(this.iPl, (int) R.drawable.icon_frs_arrow_n);
            this.iPj.setTextColor(color);
            this.jLy.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jLy.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iPk.addView(writePrefixItemLayout);
            }
            this.iPk.setCurrentIndex(0);
            this.iPj.setText(prefixs.get(1));
            CD(1);
            return;
        }
        this.iPm.setVisibility(8);
    }

    protected void cyN() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jLS.a(TransmitPostEditActivity.this.iPe, TransmitPostEditActivity.this.iPi)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jLS.cwg());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyR());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cyQ());
                    TransmitPostEditActivity.this.cqK.app();
                    TiebaStatic.log(new am("c12608").P("obj_locate", 7));
                    TransmitPostEditActivity.this.cyX();
                }
            }
        });
    }

    protected void cjt() {
        this.iPe = (EditText) findViewById(R.id.post_title);
        this.iPe.setOnClickListener(this.jLW);
        this.iPe.setOnFocusChangeListener(this.iPc);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iPe.setText(this.mData.getTitle());
            this.iPe.setSelection(this.mData.getTitle().length());
        }
        this.iPe.addTextChangedListener(this.jLY);
        if (!this.mData.getHaveDraft()) {
            cyJ();
        }
        this.iPe.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cjv() {
        this.iPi = (EditText) findViewById(R.id.post_content);
        this.iPi.setDrawingCacheEnabled(false);
        this.iPi.setOnClickListener(this.jLW);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.iPi.setText(al);
            this.iPi.setSelection(al.length());
        }
        this.iPi.setOnFocusChangeListener(this.iPc);
        this.iPi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iPi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPi.addTextChangedListener(this.jLZ);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iPi.setHint(R.string.share_video_default);
        } else {
            this.iPi.setHint(R.string.share_txt_default);
        }
    }

    private void cyO() {
        this.Xb = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Xb.setVisibility(0);
        this.Xb.b(this.mOriginalThreadInfo);
        this.Xb.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyP() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jLA != null) {
            i = 1000;
        }
        return cyQ().getText() != null && cyQ().getText().length() >= i;
    }

    private void pV(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jLr)) {
                this.jLr = "";
                cyQ().requestFocus();
                if (cyQ().getText() != null && cyQ().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyQ().getSelectionStart();
                    editable = cyQ().getText();
                }
            } else if ("from_title".equals(this.jLr)) {
                this.jLr = "";
                cyR().requestFocus();
                if (cyR().getText() != null && cyR().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyR().getSelectionStart();
                    editable = cyR().getText();
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
        if (((ImageSpan[]) cyQ().getText().getSpans(0, cyQ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jLz == null) {
                this.jLz = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jLz.show();
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
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cyQ().getSelectionStart(), aVar, alp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cyQ() != null && cyQ().getText() != null) {
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
                int selectionStart = cyQ().getSelectionStart() - 1;
                if (cyQ().getText().length() > 1 && selectionStart >= 0 && cyQ().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cyQ().getText().insert(cyQ().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cyQ().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cyQ().getText().insert(cyQ().getSelectionStart(), spannableString2);
            }
            Editable text = cyQ().getText();
            if (text != null) {
                this.jLP.clear();
                this.jLP.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLP);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cyQ().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cyQ().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cyQ().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyQ() {
        return this.iPi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyR() {
        return this.iPe;
    }

    protected void cyS() {
        Editable text;
        if (cyQ() != null && (text = cyQ().getText()) != null) {
            int selectionStart = cyQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyQ().onKeyDown(67, this.eXy);
            }
            cyQ().onKeyDown(67, this.eXy);
            int selectionStart2 = cyQ().getSelectionStart();
            this.jLP.clear();
            this.jLP.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jLP);
            cyQ().setSelection(selectionStart2);
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
    public void cju() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cyR() != null) {
                str = cyR().getText().toString();
            }
            if (cyQ() != null) {
                str2 = cyQ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iOM == 0) {
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
                if (!this.jLM) {
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
                TransmitPostEditActivity.this.cjm();
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
                this.jLA = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jLA != null);
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
            this.fOa = bundle.getString("KEY_CALL_FROM");
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
            this.jLA = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jLA != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fOa = intent.getStringExtra("KEY_CALL_FROM");
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
            this.jLt = true;
        }
        cyK();
    }

    private void cyT() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iPe.setText(com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName)));
            this.iPe.setMovementMethod(com.baidu.tieba.view.c.cvb());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qF = com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName));
            if (qF != null) {
                this.iPe.setText(qF);
            }
            this.jLO.setText(hotTopicBussinessData.mForumName);
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
        if (this.jLA != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jLA));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fOa);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cyQ().getEditableText().toString();
        if (obj != null) {
            cyQ().setText(TbFaceManager.aso().a(getPageContext().getPageActivity(), obj, this.jLU));
            cyQ().setSelection(cyQ().getText().length());
        }
    }

    private String cyU() {
        if (cyQ() == null || cyQ().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cyQ().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cyQ().getText().toString();
    }

    private String cyV() {
        if (this.mData == null || cyR() == null || cyR().getVisibility() != 0 || cyR().getText() == null) {
            return "";
        }
        String obj = cyR().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iOM != 0 && this.mData.getType() != 4 && this.iPj != null && this.iPj.getText() != null) {
            obj = this.iPj.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cyW() {
        cjm();
        this.mData.setContent(cyU());
        this.mData.setTitle(cyV());
        if (this.jLH >= 0) {
            this.mData.setCategoryFrom(this.jLH);
        }
        if (this.jLJ >= 0) {
            this.mData.setCategoryTo(this.jLJ);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.cso != null && this.cso.aTE());
        this.csp.qS(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jLN != null && this.jLN.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jLN.mForumId));
            this.mData.setForumName(this.jLN.mForumName);
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
            if (this.jLA != null) {
                i2 = this.jLA.getTotalCount();
                i = this.jLA.getAlreadyCount() + 1;
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
                    cyQ().requestFocus();
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
                            cyQ().getText().insert(cyQ().getSelectionStart(), sb.toString());
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
                        if (this.jLs) {
                            sb2.append(com.baidu.tbadk.plugins.b.cAq);
                            this.jLs = false;
                        }
                        sb2.append(stringExtra);
                        pV(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jLN = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jLN);
            }
        } else if (i2 == 0) {
            if (this.cqK != null && !this.cqK.aqV()) {
                this.iPi.requestFocus();
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
                        this.jLS.FE(postWriteCallBackData.getErrorString());
                        this.jLS.aI(postWriteCallBackData.getSensitiveWords());
                        this.jLS.b(this.iPe, this.iPi);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jLr)) {
                        cyR().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jLr)) {
                        cyQ().requestFocus();
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
    public void cyX() {
        if ("1".equals(this.fOa)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fOa)) {
            this.mData.setCanNoForum(false);
        }
        cyY();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fOa);
        cyW();
    }

    private void cyY() {
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cyR());
        HidenSoftKeyPad(this.mInputManager, cyQ());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fqd) != null) {
                    TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bSZ));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jLA == null) {
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

    private void cyZ() {
        if (!this.jLM && this.cqK != null) {
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
        if (i < this.jLy.size()) {
            for (int i2 = 0; i2 < this.jLy.size(); i2++) {
                this.jLy.get(i2).rN(false);
            }
            this.jLy.get(i).rN(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Ad(int i) {
        this.iOM = i;
        this.iPk.setCurrentIndex(i);
        CD(i);
        this.iPj.setText(this.mPrefixData.getPrefixs().get(i));
        cju();
        com.baidu.adp.lib.g.g.a(this.iPk, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iPm.setSelected(false);
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
        this.jLR = z;
        if (this.jLQ != null && !z) {
            this.jLQ.bea();
        }
        if (this.jLT != null && !z) {
            cyC();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jLR && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jLs = false;
            this.jLr = "";
            if ("from_content".equals(str)) {
                this.jLr = "from_content";
            } else if ("from_title".equals(str)) {
                this.jLr = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qE(String.valueOf(charSequence.charAt(i)))) {
                rW(false);
            }
        }
    }

    public void cfw() {
        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
            this.jLv.setVisibility(0);
            this.jLv.requestFocus();
            this.cqK.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jLv.setVisibility(8);
    }
}
