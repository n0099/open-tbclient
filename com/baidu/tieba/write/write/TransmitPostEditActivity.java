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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
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
    private OriginalThreadCardView Xv;
    private EditorTools csg;
    private LocationModel ctJ;
    private NewWriteModel ctK;
    private TextView iWK;
    private com.baidu.tieba.write.h iWL;
    private ImageView iWM;
    private View iWN;
    private int iWn;
    private boolean isPrivacy;
    private LinearLayout jTD;
    private LinearLayout jTE;
    private View jTG;
    private Toast jTI;
    private AdditionData jTJ;
    private RelativeLayout jTK;
    private TextView jTL;
    private TextView jTM;
    private TextView jTN;
    List<v> jTO;
    v jTP;
    private int jTQ;
    private String jTR;
    private int jTS;
    private PostCategoryView jTT;
    private HotTopicBussinessData jTW;
    private TextView jTX;
    private com.baidu.tieba.write.editor.b jTZ;
    private e jUc;
    private com.baidu.tieba.view.b jUj;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jTA = "";
    private boolean jTB = false;
    private WriteData mData = null;
    private boolean jTC = false;
    private InputMethodManager mInputManager = null;
    private EditText iWF = null;
    private View iWG = null;
    private LinearLayout iWI = null;
    private EditText iWJ = null;
    private FeedBackModel jTF = null;
    private ArrayList<WritePrefixItemLayout> jTH = new ArrayList<>();
    private final KeyEvent fda = new KeyEvent(0, 67);
    private View cfi = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String ctO = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ctP = 0;
    private View mRootView = null;
    private ScrollView jTU = null;
    private boolean jTV = false;
    private com.baidu.tbadk.core.view.b cCv = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fTQ = "2";
    private SpannableStringBuilder jTY = new SpannableStringBuilder();
    private boolean jUa = false;
    private final b jUb = new b();
    private TbFaceManager.a jUd = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qD(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nK());
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
    private final AntiHelper.a fvB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUh));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUh));
        }
    };
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jUb.aI(null);
                if (z) {
                    TransmitPostEditActivity.this.fp(z);
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
                    TransmitPostEditActivity.this.jUb.GB(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jUb.aI(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jUb.b(TransmitPostEditActivity.this.iWF, TransmitPostEditActivity.this.iWJ);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amH());
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, xVar.amG())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a ctW = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void asR() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cqp())) {
                TransmitPostEditActivity.this.b(2, true, aVar.cqp());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jiF = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.ctJ.rh(false);
                    TransmitPostEditActivity.this.ctJ.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.ctJ.rh(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jUe = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jUf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cBS = TransmitPostEditActivity.this.cBS();
            if (cBS >= 0 && cBS < TransmitPostEditActivity.this.iWJ.getText().length()) {
                TransmitPostEditActivity.this.iWJ.setSelection(cBS);
            }
        }
    };
    private boolean jUg = true;
    private final View.OnFocusChangeListener iWD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iWF || view == TransmitPostEditActivity.this.cfi || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jUg = true;
                    TransmitPostEditActivity.this.cBT();
                    if (TransmitPostEditActivity.this.csg != null) {
                        TransmitPostEditActivity.this.csg.aqw();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iWF);
                } else if (view == TransmitPostEditActivity.this.iWF) {
                    TransmitPostEditActivity.this.iWK.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iWJ && z) {
                TransmitPostEditActivity.this.jUg = false;
                TransmitPostEditActivity.this.cBT();
                TransmitPostEditActivity.this.csg.aqw();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iWJ);
            }
            TransmitPostEditActivity.this.cBZ();
        }
    };
    private TextWatcher jUh = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jUl = "";
        private String jUm;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUm = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUm != null ? this.jUm.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cmG();
            TransmitPostEditActivity.this.cCa();
            EditText cCl = TransmitPostEditActivity.this.cCl();
            if (editable != null && cCl != null && cCl.getText() != null) {
                if (this.jUl == null || !this.jUl.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jUb != null) {
                        this.jUl = cCl.getText().toString();
                        TransmitPostEditActivity.this.jUb.o(cCl);
                        return;
                    }
                    return;
                }
                cCl.setSelection(cCl.getSelectionEnd());
            }
        }
    };
    private TextWatcher jUi = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jUm;
        private String jUn = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUm = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUm != null ? this.jUm.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cmG();
            EditText cCk = TransmitPostEditActivity.this.cCk();
            if (editable != null && cCk != null && cCk.getText() != null) {
                int selectionEnd = cCk.getSelectionEnd();
                if (this.jUn == null || !this.jUn.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jUb != null) {
                        this.jUn = cCk.getText().toString();
                        TransmitPostEditActivity.this.jUb.o(cCk);
                        return;
                    }
                    return;
                }
                cCk.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void asD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asF();
        } else if (this.ctJ.cqv()) {
            asC();
        } else {
            this.ctJ.rh(false);
            b(1, true, null);
            this.ctJ.cqt();
        }
    }

    private void asF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.ctJ.aVG();
                } else {
                    TransmitPostEditActivity.this.ctW.asR();
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
        aVar.agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBS() {
        int selectionEnd = cCk().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cCk().getText().getSpans(0, cCk().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cCk().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cCk().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBT() {
        if (this.csg != null) {
            this.csg.setBarLauncherEnabled(!this.jUg);
            this.csg.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jTV) {
            this.iWF.setVisibility(8);
            cmG();
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
        this.ctJ = new LocationModel(this);
        this.ctJ.a(this.ctW);
        registerListener(this.jiF);
        registerListener(this.jUe);
        initEditor();
        this.iWJ.requestFocus();
        ciI();
        cCt();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.csg = new EditorTools(getActivity());
        this.csg.setBarMaxLauCount(4);
        this.csg.setMoreButtonAtEnd(true);
        this.csg.setBarLauncherType(1);
        this.csg.fh(true);
        this.csg.fi(true);
        this.csg.setMoreLauncherIcon(R.drawable.write_more);
        this.csg.setBackgroundColorId(R.color.cp_bg_line_d);
        cBU();
        this.csg.asb();
        if (this.jTD != null) {
            this.jTD.addView(this.csg);
        }
        cBV();
        this.csg.qk();
        com.baidu.tbadk.editortools.g kn = this.csg.kn(6);
        if (kn != null && !TextUtils.isEmpty(this.ctO)) {
            ((View) kn).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.ctO);
                }
            });
        }
        if (!this.jTV) {
            this.csg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.csg.aqw();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("xiaoying_has_click", false)) {
            this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("hot_topic_has_click", false)) {
            this.csg.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        cBX();
    }

    private void cBU() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.csO = R.drawable.write_at;
        this.csg.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.csg.b(aVar2);
        aVar2.csO = R.drawable.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.csQ = 4;
            kVar.csO = R.drawable.icon_post_location_selector;
            this.csg.b(kVar);
        }
        if (this.jTJ == null) {
            if (this.jTZ == null) {
                this.jTZ = new com.baidu.tieba.write.editor.b(getActivity(), this.fTQ);
                this.jTZ.cAT();
                this.jTZ.setFrom("from_share_write");
                this.jTZ.bt(this.mData.getForumId(), this.mPrivateThread);
            }
            this.csg.b(this.jTZ);
        }
        this.csg.ai(arrayList);
        com.baidu.tbadk.editortools.k kq = this.csg.kq(5);
        if (kq != null) {
            kq.csQ = 1;
            kq.csO = R.drawable.write_emotion;
        }
    }

    private void cBV() {
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
                            TiebaStatic.log(new an("c12608").P("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.cCj()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cCj()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cCm();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cmG();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jTJ == null) {
                            TransmitPostEditActivity.this.asG();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.ctP) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cx(pageActivity)) {
                                    TransmitPostEditActivity.this.asD();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.asC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.ctJ != null) {
                            TransmitPostEditActivity.this.ctJ.rh(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bT("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.csg.asd()) {
                                        TransmitPostEditActivity.this.csg.aqw();
                                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.cmG();
                        if (TransmitPostEditActivity.this.iWJ != null) {
                            TransmitPostEditActivity.this.iWJ.requestFocus();
                        }
                        TransmitPostEditActivity.this.csg.aqw();
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iWJ);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jTB = true;
                        TransmitPostEditActivity.this.sn(true);
                        if (TransmitPostEditActivity.this.cCl().isFocused()) {
                            TransmitPostEditActivity.this.jTA = "from_title";
                        } else if (TransmitPostEditActivity.this.cCk().isFocused()) {
                            TransmitPostEditActivity.this.jTA = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jTE.setVisibility(0);
                        TransmitPostEditActivity.this.jTE.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jTE.hasFocus()) {
                            TransmitPostEditActivity.this.iWJ.requestFocus();
                            TransmitPostEditActivity.this.iWJ.setSelection(TransmitPostEditActivity.this.iWJ.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jTE.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.csg.setActionListener(31, bVar);
        this.csg.setActionListener(16, bVar);
        this.csg.setActionListener(14, bVar);
        this.csg.setActionListener(24, bVar);
        this.csg.setActionListener(3, bVar);
        this.csg.setActionListener(10, bVar);
        this.csg.setActionListener(11, bVar);
        this.csg.setActionListener(12, bVar);
        this.csg.setActionListener(13, bVar);
        this.csg.setActionListener(15, bVar);
        this.csg.setActionListener(18, bVar);
        this.csg.setActionListener(20, bVar);
        this.csg.setActionListener(25, bVar);
        this.csg.setActionListener(27, bVar);
        this.csg.setActionListener(29, bVar);
        this.csg.setActionListener(43, bVar);
        this.csg.setActionListener(45, bVar);
        this.csg.setActionListener(53, bVar);
        this.csg.setActionListener(48, bVar);
        this.csg.setActionListener(46, bVar);
        this.csg.setActionListener(49, bVar);
        this.csg.setActionListener(47, bVar);
        this.csg.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asG() {
        if (this.ctJ.aVC()) {
            if (this.ctJ.cqv()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cqr().getLocationData().cqp());
                return;
            }
            b(1, true, null);
            this.ctJ.cqt();
            return;
        }
        b(0, true, null);
    }

    protected void cmy() {
        if (this.ctK != null) {
            this.ctK.cancelLoadData();
        }
        if (this.jTF != null) {
            this.jTF.cancelLoadData();
        }
        if (this.ctJ != null) {
            this.ctJ.cancelLoadData();
        }
    }

    private void cBW() {
        if (this.jUc != null) {
            this.jUc.hideTip();
        }
    }

    private void cBX() {
        if (this.jUc == null) {
            this.jUc = new e(getPageContext());
        }
        this.jUc.c(this.csg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cBW();
        TiebaPrepareImageService.StopService();
        cmy();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBY() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cCl().getText().toString());
        this.mData.setContent(cCk().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iWL != null && this.iWL.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iWL, getPageContext().getPageActivity());
                return true;
            } else if (this.csg.asd()) {
                this.csg.aqw();
                return true;
            } else {
                cmy();
                cBY();
                return true;
            }
        }
        if (i == 67 && (text = cCk().getText()) != null) {
            int selectionStart = cCk().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCk().onKeyDown(67, this.fda);
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
        am.f(this.mPost, R.color.cp_link_tip_a, 1);
        cBT();
        am.l(this.iWG, R.color.cp_bg_line_c);
        am.l(cCl(), R.color.cp_bg_line_d);
        am.l(cCk(), R.color.cp_bg_line_d);
        cmG();
        this.csg.onChangeSkinType(i);
        if (this.jTT != null) {
            this.jTT.akN();
        }
        am.j(this.mName, R.color.cp_cont_b);
        cBZ();
        cCa();
        if (this.jUb != null) {
            this.jUb.c(cCl(), cCk());
        }
        this.Xv.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBZ() {
        if (this.iWF.hasFocus()) {
            this.iWF.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iWF.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iWJ.hasFocus()) {
            this.iWJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iWJ.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCa() {
        if (this.iWF != null) {
            if (this.iWF.getText().toString().length() == 0) {
                this.iWF.getPaint().setFakeBoldText(false);
            } else if (this.iWF.getText().toString().length() > 0) {
                this.iWF.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cCv = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jTV = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.j(this.mName, R.color.cp_cont_b);
        cCc();
        this.jTU = (ScrollView) findViewById(R.id.write_scrollview);
        this.jTU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iWJ != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iWJ);
                    }
                    if (TransmitPostEditActivity.this.csg != null) {
                        TransmitPostEditActivity.this.csg.aqw();
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
        this.jTD = (LinearLayout) findViewById(R.id.tool_view);
        this.jTD.setContentDescription("..");
        this.jTE = (LinearLayout) findViewById(R.id.title_view);
        this.iWG = findViewById(R.id.interval_view);
        this.jTX = (TextView) findViewById(R.id.hot_topic_title_edt);
        cmF();
        if (this.jTV) {
            this.jTU.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cmH();
        cCi();
        this.iWI = (LinearLayout) findViewById(R.id.post_content_container);
        this.iWI.setDrawingCacheEnabled(false);
        this.iWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iWJ.requestFocus();
            }
        });
        this.cfi.setOnFocusChangeListener(this.iWD);
        this.cfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cmy();
                TransmitPostEditActivity.this.cBY();
            }
        });
        cCf();
        cCh();
        cCb();
        cBT();
        cCg();
        cmE();
        cCn();
        if (this.mData.getType() == 4 && this.iWN != null && this.jTG != null) {
            this.iWN.setVisibility(8);
            this.jTG.setVisibility(8);
        }
        cmG();
        ShowSoftKeyPad(this.mInputManager, this.iWF);
    }

    private void cCb() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fTQ != null && this.fTQ.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fTQ != null && this.fTQ.equals("2")) {
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
                    this.iWF.setVisibility(0);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iWF.setVisibility(8);
                    return;
            }
        }
    }

    private void cCc() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iWD);
    }

    private void cCd() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jTC && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = aq.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cCl() != null) {
                cCl().setText(i);
                cCl().setSelection(i.length());
            }
        }
    }

    private void cCe() {
        this.jTO = null;
        this.jTQ = -1;
        this.jTS = -1;
        com.baidu.tieba.frs.x rM = w.bnN().rM(1);
        if (rM != null) {
            this.jTO = rM.fyb;
            this.jTQ = getIntent().getIntExtra("category_id", -1);
            if (this.jTO != null && !this.jTO.isEmpty() && this.jTQ >= 0) {
                this.jTP = new v();
                this.jTP.fxX = 0;
                this.jTP.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jTS = this.jTP.fxX;
                this.jTR = this.jTP.name;
                for (v vVar : this.jTO) {
                    if (vVar.fxX == this.jTQ) {
                        this.jTS = vVar.fxX;
                        this.jTR = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cCf() {
        if (this.jTO != null && !this.jTO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jTT = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jTT.setText(this.jTR);
            this.jTT.setCategoryContainerData(this.jTO, this.jTP, this.jTS);
            this.jTT.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jTT.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fxX);
                        TransmitPostEditActivity.this.jTS = arVar.fxX;
                        TransmitPostEditActivity.this.jTT.cBG();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jTT.cBF();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCl());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCk());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jUj = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jUj.setTitle(R.string.no_disturb_start_time);
        this.jUj.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jUj);
        this.jUj.setButton(-2, getPageContext().getString(R.string.cancel), this.jUj);
        return this.jUj;
    }

    private void cCg() {
        this.jTK = (RelativeLayout) findViewById(R.id.addition_container);
        this.jTL = (TextView) findViewById(R.id.addition_create_time);
        this.jTM = (TextView) findViewById(R.id.addition_last_time);
        this.jTN = (TextView) findViewById(R.id.addition_last_content);
        if (this.jTJ != null) {
            this.jTK.setVisibility(0);
            this.jTL.setText(getPageContext().getString(R.string.write_addition_create) + aq.aD(this.jTJ.getCreateTime() * 1000));
            if (this.jTJ.getAlreadyCount() == 0) {
                this.jTM.setVisibility(8);
            } else {
                this.jTM.setText(getPageContext().getString(R.string.write_addition_last) + aq.aD(this.jTJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jTJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jTN.setText(lastAdditionContent);
            } else {
                this.jTN.setVisibility(8);
            }
            cCk().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jTJ.getAlreadyCount()), Integer.valueOf(this.jTJ.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jTK.setVisibility(8);
    }

    private void cmE() {
        this.iWN = findViewById(R.id.post_prefix_layout);
        this.iWK = (TextView) findViewById(R.id.post_prefix);
        this.jTG = findViewById(R.id.prefix_divider);
        this.iWM = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iWN.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iWn = 1;
            this.iWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iWK.setVisibility(0);
                    TransmitPostEditActivity.this.iWN.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iWL, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.csg.aqw();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iWF);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iWJ);
                }
            });
            this.iWM = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iWM.setVisibility(0);
                this.iWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iWK.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iWL, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.csg.aqw();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCl());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCk());
                    }
                });
            }
            this.iWL = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iWL.a(this);
            this.iWL.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iWL.setOutsideTouchable(true);
            this.iWL.setFocusable(true);
            this.iWL.setOnDismissListener(this);
            this.iWL.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.k(this.iWK, R.color.cp_bg_line_d);
            am.c(this.iWM, (int) R.drawable.icon_frs_arrow_n);
            this.iWK.setTextColor(color);
            this.jTH.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jTH.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iWL.addView(writePrefixItemLayout);
            }
            this.iWL.setCurrentIndex(0);
            this.iWK.setText(prefixs.get(1));
            Dm(1);
            return;
        }
        this.iWN.setVisibility(8);
    }

    protected void cCh() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jUb.a(TransmitPostEditActivity.this.iWF, TransmitPostEditActivity.this.iWJ)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jUb.czD());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCl());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cCk());
                    TransmitPostEditActivity.this.csg.aqw();
                    TiebaStatic.log(new an("c12608").P("obj_locate", 7));
                    TransmitPostEditActivity.this.cCr();
                }
            }
        });
    }

    protected void cmF() {
        this.iWF = (EditText) findViewById(R.id.post_title);
        this.iWF.setOnClickListener(this.jUf);
        this.iWF.setOnFocusChangeListener(this.iWD);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iWF.setText(this.mData.getTitle());
            this.iWF.setSelection(this.mData.getTitle().length());
        }
        this.iWF.addTextChangedListener(this.jUh);
        if (!this.mData.getHaveDraft()) {
            cCd();
        }
        this.iWF.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cmH() {
        this.iWJ = (EditText) findViewById(R.id.post_content);
        this.iWJ.setDrawingCacheEnabled(false);
        this.iWJ.setOnClickListener(this.jUf);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atx().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.iWJ.setText(ak);
            this.iWJ.setSelection(ak.length());
        }
        this.iWJ.setOnFocusChangeListener(this.iWD);
        this.iWJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iWJ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iWJ.addTextChangedListener(this.jUi);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iWJ.setHint(R.string.share_video_default);
        } else {
            this.iWJ.setHint(R.string.share_txt_default);
        }
    }

    private void cCi() {
        this.Xv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Xv.setVisibility(0);
        this.Xv.b(this.mOriginalThreadInfo);
        this.Xv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cCj() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jTJ != null) {
            i = 1000;
        }
        return cCk().getText() != null && cCk().getText().length() >= i;
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTA)) {
                this.jTA = "";
                cCk().requestFocus();
                if (cCk().getText() != null && cCk().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCk().getSelectionStart();
                    editable = cCk().getText();
                }
            } else if ("from_title".equals(this.jTA)) {
                this.jTA = "";
                cCl().requestFocus();
                if (cCl().getText() != null && cCl().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCl().getSelectionStart();
                    editable = cCl().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cCk().getText().getSpans(0, cCk().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jTI == null) {
                this.jTI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jTI.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType amw = pVar.amw();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iE().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cCk().getSelectionStart(), aVar, amw);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cCk() != null && cCk().getText() != null) {
            Bitmap nK = aVar.nK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nK);
            int width = nK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cCk().getSelectionStart() - 1;
                if (cCk().getText().length() > 1 && selectionStart >= 0 && cCk().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cCk().getText().insert(cCk().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cCk().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cCk().getText().insert(cCk().getSelectionStart(), spannableString2);
            }
            Editable text = cCk().getText();
            if (text != null) {
                this.jTY.clear();
                this.jTY.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTY);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cCk().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cCk().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cCk().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCk() {
        return this.iWJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCl() {
        return this.iWF;
    }

    protected void cCm() {
        Editable text;
        if (cCk() != null && (text = cCk().getText()) != null) {
            int selectionStart = cCk().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCk().onKeyDown(67, this.fda);
            }
            cCk().onKeyDown(67, this.fda);
            int selectionStart2 = cCk().getSelectionStart();
            this.jTY.clear();
            this.jTY.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jTY);
            cCk().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cCv.e(null);
        this.cCv.iz(R.string.sending);
        this.cCv.ej(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cCv.ej(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmG() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cCl() != null) {
                str = cCl().getText().toString();
            }
            if (cCk() != null) {
                str2 = cCk().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iWn == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            so(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        so(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    so(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jTV) {
                    so(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    so(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                so(true);
            } else if (this.mData.getVideoInfo() != null) {
                so(true);
            } else {
                so(false);
            }
        }
    }

    private void so(boolean z) {
        am.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.ctK = new NewWriteModel(this);
        this.ctK.b(this.ctY);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cmy();
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
                this.jTJ = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jTJ != null);
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
            this.fTQ = bundle.getString("KEY_CALL_FROM");
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
            this.jTJ = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jTJ != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fTQ = intent.getStringExtra("KEY_CALL_FROM");
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
            this.jTC = true;
        }
        cCe();
    }

    private void cCn() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iWF.setText(com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName)));
            this.iWF.setMovementMethod(com.baidu.tieba.view.c.cyn());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qW = com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName));
            if (qW != null) {
                this.iWF.setText(qW);
            }
            this.jTX.setText(hotTopicBussinessData.mForumName);
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
        if (this.jTJ != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jTJ));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fTQ);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cCk().getEditableText().toString();
        if (obj != null) {
            cCk().setText(TbFaceManager.atx().a(getPageContext().getPageActivity(), obj, this.jUd));
            cCk().setSelection(cCk().getText().length());
        }
    }

    private String cCo() {
        if (cCk() == null || cCk().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cCk().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cCk().getText().toString();
    }

    private String cCp() {
        if (this.mData == null || cCl() == null || cCl().getVisibility() != 0 || cCl().getText() == null) {
            return "";
        }
        String obj = cCl().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iWn != 0 && this.mData.getType() != 4 && this.iWK != null && this.iWK.getText() != null) {
            obj = this.iWK.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cCq() {
        cmy();
        this.mData.setContent(cCo());
        this.mData.setTitle(cCp());
        if (this.jTQ >= 0) {
            this.mData.setCategoryFrom(this.jTQ);
        }
        if (this.jTS >= 0) {
            this.mData.setCategoryTo(this.jTS);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.ctJ != null && this.ctJ.aVC());
        this.ctK.rj(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jTW != null && this.jTW.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jTW.mForumId));
            this.mData.setForumName(this.jTW.mForumName);
        }
        this.ctK.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.ctK.getWriteData().setVoice(null);
        this.ctK.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        this.ctK.startPostWrite();
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jTJ != null) {
                i2 = this.jTJ.getTotalCount();
                i = this.jTJ.getAlreadyCount() + 1;
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
                if (this.csg != null && !this.csg.asd()) {
                    cCk().requestFocus();
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
                            cCk().getText().insert(cCk().getSelectionStart(), sb.toString());
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
                        if (this.jTB) {
                            sb2.append(com.baidu.tbadk.plugins.b.cBP);
                            this.jTB = false;
                        }
                        sb2.append(stringExtra);
                        ql(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jTW = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jTW);
            }
        } else if (i2 == 0) {
            if (this.csg != null && !this.csg.asd()) {
                this.iWJ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jUb.GB(postWriteCallBackData.getErrorString());
                        this.jUb.aI(postWriteCallBackData.getSensitiveWords());
                        this.jUb.b(this.iWF, this.iWJ);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jTA)) {
                        cCl().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTA)) {
                        cCk().requestFocus();
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
    public void cCr() {
        if ("1".equals(this.fTQ)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fTQ)) {
            this.mData.setCanNoForum(false);
        }
        cCs();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fTQ);
        cCq();
    }

    private void cCs() {
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cCl());
        HidenSoftKeyPad(this.mInputManager, cCk());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvB) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUh));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jTJ == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ctP = i;
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cCt() {
        if (!this.jTV && this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.csg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dm(int i) {
        if (i < this.jTH.size()) {
            for (int i2 = 0; i2 < this.jTH.size(); i2++) {
                this.jTH.get(i2).se(false);
            }
            this.jTH.get(i).se(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void AL(int i) {
        this.iWn = i;
        this.iWL.setCurrentIndex(i);
        Dm(i);
        this.iWK.setText(this.mPrefixData.getPrefixs().get(i));
        cmG();
        com.baidu.adp.lib.g.g.a(this.iWL, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iWN.setSelected(false);
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
            asD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jUa = z;
        if (this.jTZ != null && !z) {
            this.jTZ.bgj();
        }
        if (this.jUc != null && !z) {
            cBW();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jUa && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTB = false;
            this.jTA = "";
            if ("from_content".equals(str)) {
                this.jTA = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTA = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qV(String.valueOf(charSequence.charAt(i)))) {
                sn(false);
            }
        }
    }

    public void ciI() {
        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
            this.jTE.setVisibility(0);
            this.jTE.requestFocus();
            this.csg.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jTE.setVisibility(8);
    }
}
