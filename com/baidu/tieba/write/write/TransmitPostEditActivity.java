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
    private EditorTools crZ;
    private LocationModel ctC;
    private NewWriteModel ctD;
    private TextView iVG;
    private com.baidu.tieba.write.h iVH;
    private ImageView iVI;
    private View iVJ;
    private int iVj;
    private boolean isPrivacy;
    private View jSA;
    private Toast jSC;
    private AdditionData jSD;
    private RelativeLayout jSE;
    private TextView jSF;
    private TextView jSG;
    private TextView jSH;
    List<v> jSI;
    v jSJ;
    private int jSK;
    private String jSL;
    private int jSM;
    private PostCategoryView jSN;
    private HotTopicBussinessData jSQ;
    private TextView jSR;
    private com.baidu.tieba.write.editor.b jST;
    private e jSW;
    private LinearLayout jSx;
    private LinearLayout jSy;
    private com.baidu.tieba.view.b jTd;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jSu = "";
    private boolean jSv = false;
    private WriteData mData = null;
    private boolean jSw = false;
    private InputMethodManager mInputManager = null;
    private EditText iVB = null;
    private View iVC = null;
    private LinearLayout iVE = null;
    private EditText iVF = null;
    private FeedBackModel jSz = null;
    private ArrayList<WritePrefixItemLayout> jSB = new ArrayList<>();
    private final KeyEvent fcA = new KeyEvent(0, 67);
    private View cfb = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String ctH = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ctI = 0;
    private View mRootView = null;
    private ScrollView jSO = null;
    private boolean jSP = false;
    private com.baidu.tbadk.core.view.b cCo = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fTa = "2";
    private SpannableStringBuilder jSS = new SpannableStringBuilder();
    private boolean jSU = false;
    private final b jSV = new b();
    private TbFaceManager.a jSX = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a fvc = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUb));
        }
    };
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jSV.aI(null);
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
                    TransmitPostEditActivity.this.jSV.GA(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jSV.aI(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jSV.b(TransmitPostEditActivity.this.iVB, TransmitPostEditActivity.this.iVF);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amF());
                    if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, xVar.amE())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a ctP = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void asP() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cpT())) {
                TransmitPostEditActivity.this.b(2, true, aVar.cpT());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jhx = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.ctC.rg(false);
                    TransmitPostEditActivity.this.ctC.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.ctC.rg(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jSY = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jSZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cBx = TransmitPostEditActivity.this.cBx();
            if (cBx >= 0 && cBx < TransmitPostEditActivity.this.iVF.getText().length()) {
                TransmitPostEditActivity.this.iVF.setSelection(cBx);
            }
        }
    };
    private boolean jTa = true;
    private final View.OnFocusChangeListener iVz = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iVB || view == TransmitPostEditActivity.this.cfb || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jTa = true;
                    TransmitPostEditActivity.this.cBy();
                    if (TransmitPostEditActivity.this.crZ != null) {
                        TransmitPostEditActivity.this.crZ.aqu();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iVB);
                } else if (view == TransmitPostEditActivity.this.iVB) {
                    TransmitPostEditActivity.this.iVG.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iVF && z) {
                TransmitPostEditActivity.this.jTa = false;
                TransmitPostEditActivity.this.cBy();
                TransmitPostEditActivity.this.crZ.aqu();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iVF);
            }
            TransmitPostEditActivity.this.cBE();
        }
    };
    private TextWatcher jTb = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jTf = "";
        private String jTg;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTg != null ? this.jTg.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cmo();
            TransmitPostEditActivity.this.cBF();
            EditText cBQ = TransmitPostEditActivity.this.cBQ();
            if (editable != null && cBQ != null && cBQ.getText() != null) {
                if (this.jTf == null || !this.jTf.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jSV != null) {
                        this.jTf = cBQ.getText().toString();
                        TransmitPostEditActivity.this.jSV.o(cBQ);
                        return;
                    }
                    return;
                }
                cBQ.setSelection(cBQ.getSelectionEnd());
            }
        }
    };
    private TextWatcher jTc = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jTg;
        private String jTh = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTg != null ? this.jTg.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cmo();
            EditText cBP = TransmitPostEditActivity.this.cBP();
            if (editable != null && cBP != null && cBP.getText() != null) {
                int selectionEnd = cBP.getSelectionEnd();
                if (this.jTh == null || !this.jTh.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jSV != null) {
                        this.jTh = cBP.getText().toString();
                        TransmitPostEditActivity.this.jSV.o(cBP);
                        return;
                    }
                    return;
                }
                cBP.setSelection(selectionEnd);
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
    public void asA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void asB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asD();
        } else if (this.ctC.cpZ()) {
            asA();
        } else {
            this.ctC.rg(false);
            b(1, true, null);
            this.ctC.cpX();
        }
    }

    private void asD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.ctC.aVE();
                } else {
                    TransmitPostEditActivity.this.ctP.asP();
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
        aVar.agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBx() {
        int selectionEnd = cBP().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cBP().getText().getSpans(0, cBP().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cBP().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cBP().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBy() {
        if (this.crZ != null) {
            this.crZ.setBarLauncherEnabled(!this.jTa);
            this.crZ.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jSP) {
            this.iVB.setVisibility(8);
            cmo();
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
        this.ctC = new LocationModel(this);
        this.ctC.a(this.ctP);
        registerListener(this.jhx);
        registerListener(this.jSY);
        initEditor();
        this.iVF.requestFocus();
        ciq();
        cBY();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.crZ = new EditorTools(getActivity());
        this.crZ.setBarMaxLauCount(4);
        this.crZ.setMoreButtonAtEnd(true);
        this.crZ.setBarLauncherType(1);
        this.crZ.fh(true);
        this.crZ.fi(true);
        this.crZ.setMoreLauncherIcon(R.drawable.write_more);
        this.crZ.setBackgroundColorId(R.color.cp_bg_line_d);
        cBz();
        this.crZ.arZ();
        if (this.jSx != null) {
            this.jSx.addView(this.crZ);
        }
        cBA();
        this.crZ.qk();
        com.baidu.tbadk.editortools.g km = this.crZ.km(6);
        if (km != null && !TextUtils.isEmpty(this.ctH)) {
            ((View) km).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.ctH);
                }
            });
        }
        if (!this.jSP) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.crZ.aqu();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("xiaoying_has_click", false)) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("hot_topic_has_click", false)) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        cBC();
    }

    private void cBz() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.csH = R.drawable.write_at;
        this.crZ.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.crZ.b(aVar2);
        aVar2.csH = R.drawable.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.csJ = 4;
            kVar.csH = R.drawable.icon_post_location_selector;
            this.crZ.b(kVar);
        }
        if (this.jSD == null) {
            if (this.jST == null) {
                this.jST = new com.baidu.tieba.write.editor.b(getActivity(), this.fTa);
                this.jST.cAy();
                this.jST.setFrom("from_share_write");
                this.jST.bt(this.mData.getForumId(), this.mPrivateThread);
            }
            this.crZ.b(this.jST);
        }
        this.crZ.ai(arrayList);
        com.baidu.tbadk.editortools.k kp = this.crZ.kp(5);
        if (kp != null) {
            kp.csJ = 1;
            kp.csH = R.drawable.write_emotion;
        }
    }

    private void cBA() {
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
                        if (TransmitPostEditActivity.this.cBO()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cBO()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cBR();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cmo();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jSD == null) {
                            TransmitPostEditActivity.this.asE();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.ctI) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cx(pageActivity)) {
                                    TransmitPostEditActivity.this.asB();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.asA();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.ctC != null) {
                            TransmitPostEditActivity.this.ctC.rg(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bT("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.crZ.asb()) {
                                        TransmitPostEditActivity.this.crZ.aqu();
                                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.cmo();
                        if (TransmitPostEditActivity.this.iVF != null) {
                            TransmitPostEditActivity.this.iVF.requestFocus();
                        }
                        TransmitPostEditActivity.this.crZ.aqu();
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iVF);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jSv = true;
                        TransmitPostEditActivity.this.sm(true);
                        if (TransmitPostEditActivity.this.cBQ().isFocused()) {
                            TransmitPostEditActivity.this.jSu = "from_title";
                        } else if (TransmitPostEditActivity.this.cBP().isFocused()) {
                            TransmitPostEditActivity.this.jSu = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jSy.setVisibility(0);
                        TransmitPostEditActivity.this.jSy.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jSy.hasFocus()) {
                            TransmitPostEditActivity.this.iVF.requestFocus();
                            TransmitPostEditActivity.this.iVF.setSelection(TransmitPostEditActivity.this.iVF.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jSy.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.crZ.setActionListener(31, bVar);
        this.crZ.setActionListener(16, bVar);
        this.crZ.setActionListener(14, bVar);
        this.crZ.setActionListener(24, bVar);
        this.crZ.setActionListener(3, bVar);
        this.crZ.setActionListener(10, bVar);
        this.crZ.setActionListener(11, bVar);
        this.crZ.setActionListener(12, bVar);
        this.crZ.setActionListener(13, bVar);
        this.crZ.setActionListener(15, bVar);
        this.crZ.setActionListener(18, bVar);
        this.crZ.setActionListener(20, bVar);
        this.crZ.setActionListener(25, bVar);
        this.crZ.setActionListener(27, bVar);
        this.crZ.setActionListener(29, bVar);
        this.crZ.setActionListener(43, bVar);
        this.crZ.setActionListener(45, bVar);
        this.crZ.setActionListener(53, bVar);
        this.crZ.setActionListener(48, bVar);
        this.crZ.setActionListener(46, bVar);
        this.crZ.setActionListener(49, bVar);
        this.crZ.setActionListener(47, bVar);
        this.crZ.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asE() {
        if (this.ctC.aVA()) {
            if (this.ctC.cpZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cpV().getLocationData().cpT());
                return;
            }
            b(1, true, null);
            this.ctC.cpX();
            return;
        }
        b(0, true, null);
    }

    protected void cmg() {
        if (this.ctD != null) {
            this.ctD.cancelLoadData();
        }
        if (this.jSz != null) {
            this.jSz.cancelLoadData();
        }
        if (this.ctC != null) {
            this.ctC.cancelLoadData();
        }
    }

    private void cBB() {
        if (this.jSW != null) {
            this.jSW.hideTip();
        }
    }

    private void cBC() {
        if (this.jSW == null) {
            this.jSW = new e(getPageContext());
        }
        this.jSW.c(this.crZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cBB();
        TiebaPrepareImageService.StopService();
        cmg();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBD() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cBQ().getText().toString());
        this.mData.setContent(cBP().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iVH != null && this.iVH.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iVH, getPageContext().getPageActivity());
                return true;
            } else if (this.crZ.asb()) {
                this.crZ.aqu();
                return true;
            } else {
                cmg();
                cBD();
                return true;
            }
        }
        if (i == 67 && (text = cBP().getText()) != null) {
            int selectionStart = cBP().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cBP().onKeyDown(67, this.fcA);
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
        cBy();
        am.l(this.iVC, R.color.cp_bg_line_c);
        am.l(cBQ(), R.color.cp_bg_line_d);
        am.l(cBP(), R.color.cp_bg_line_d);
        cmo();
        this.crZ.onChangeSkinType(i);
        if (this.jSN != null) {
            this.jSN.akL();
        }
        am.j(this.mName, R.color.cp_cont_b);
        cBE();
        cBF();
        if (this.jSV != null) {
            this.jSV.c(cBQ(), cBP());
        }
        this.Xv.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBE() {
        if (this.iVB.hasFocus()) {
            this.iVB.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iVB.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iVF.hasFocus()) {
            this.iVF.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iVF.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBF() {
        if (this.iVB != null) {
            if (this.iVB.getText().toString().length() == 0) {
                this.iVB.getPaint().setFakeBoldText(false);
            } else if (this.iVB.getText().toString().length() > 0) {
                this.iVB.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cCo = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jSP = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.j(this.mName, R.color.cp_cont_b);
        cBH();
        this.jSO = (ScrollView) findViewById(R.id.write_scrollview);
        this.jSO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iVF != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iVF);
                    }
                    if (TransmitPostEditActivity.this.crZ != null) {
                        TransmitPostEditActivity.this.crZ.aqu();
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
        this.jSx = (LinearLayout) findViewById(R.id.tool_view);
        this.jSx.setContentDescription("..");
        this.jSy = (LinearLayout) findViewById(R.id.title_view);
        this.iVC = findViewById(R.id.interval_view);
        this.jSR = (TextView) findViewById(R.id.hot_topic_title_edt);
        cmn();
        if (this.jSP) {
            this.jSO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cmp();
        cBN();
        this.iVE = (LinearLayout) findViewById(R.id.post_content_container);
        this.iVE.setDrawingCacheEnabled(false);
        this.iVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iVF.requestFocus();
            }
        });
        this.cfb.setOnFocusChangeListener(this.iVz);
        this.cfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cmg();
                TransmitPostEditActivity.this.cBD();
            }
        });
        cBK();
        cBM();
        cBG();
        cBy();
        cBL();
        cmm();
        cBS();
        if (this.mData.getType() == 4 && this.iVJ != null && this.jSA != null) {
            this.iVJ.setVisibility(8);
            this.jSA.setVisibility(8);
        }
        cmo();
        ShowSoftKeyPad(this.mInputManager, this.iVB);
    }

    private void cBG() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fTa != null && this.fTa.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fTa != null && this.fTa.equals("2")) {
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
                    this.iVB.setVisibility(0);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iVB.setVisibility(8);
                    return;
            }
        }
    }

    private void cBH() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iVz);
    }

    private void cBI() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jSw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = aq.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cBQ() != null) {
                cBQ().setText(i);
                cBQ().setSelection(i.length());
            }
        }
    }

    private void cBJ() {
        this.jSI = null;
        this.jSK = -1;
        this.jSM = -1;
        com.baidu.tieba.frs.x rK = w.bnD().rK(1);
        if (rK != null) {
            this.jSI = rK.fxC;
            this.jSK = getIntent().getIntExtra("category_id", -1);
            if (this.jSI != null && !this.jSI.isEmpty() && this.jSK >= 0) {
                this.jSJ = new v();
                this.jSJ.fxy = 0;
                this.jSJ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jSM = this.jSJ.fxy;
                this.jSL = this.jSJ.name;
                for (v vVar : this.jSI) {
                    if (vVar.fxy == this.jSK) {
                        this.jSM = vVar.fxy;
                        this.jSL = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cBK() {
        if (this.jSI != null && !this.jSI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jSN = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jSN.setText(this.jSL);
            this.jSN.setCategoryContainerData(this.jSI, this.jSJ, this.jSM);
            this.jSN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jSN.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fxy);
                        TransmitPostEditActivity.this.jSM = arVar.fxy;
                        TransmitPostEditActivity.this.jSN.cBl();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jSN.cBk();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBQ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBP());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jTd = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jTd.setTitle(R.string.no_disturb_start_time);
        this.jTd.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jTd);
        this.jTd.setButton(-2, getPageContext().getString(R.string.cancel), this.jTd);
        return this.jTd;
    }

    private void cBL() {
        this.jSE = (RelativeLayout) findViewById(R.id.addition_container);
        this.jSF = (TextView) findViewById(R.id.addition_create_time);
        this.jSG = (TextView) findViewById(R.id.addition_last_time);
        this.jSH = (TextView) findViewById(R.id.addition_last_content);
        if (this.jSD != null) {
            this.jSE.setVisibility(0);
            this.jSF.setText(getPageContext().getString(R.string.write_addition_create) + aq.aD(this.jSD.getCreateTime() * 1000));
            if (this.jSD.getAlreadyCount() == 0) {
                this.jSG.setVisibility(8);
            } else {
                this.jSG.setText(getPageContext().getString(R.string.write_addition_last) + aq.aD(this.jSD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jSD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jSH.setText(lastAdditionContent);
            } else {
                this.jSH.setVisibility(8);
            }
            cBP().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jSD.getAlreadyCount()), Integer.valueOf(this.jSD.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jSE.setVisibility(8);
    }

    private void cmm() {
        this.iVJ = findViewById(R.id.post_prefix_layout);
        this.iVG = (TextView) findViewById(R.id.post_prefix);
        this.jSA = findViewById(R.id.prefix_divider);
        this.iVI = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iVJ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iVj = 1;
            this.iVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iVG.setVisibility(0);
                    TransmitPostEditActivity.this.iVJ.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iVH, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.crZ.aqu();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iVB);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iVF);
                }
            });
            this.iVI = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iVI.setVisibility(0);
                this.iVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iVG.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iVH, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.crZ.aqu();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBQ());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBP());
                    }
                });
            }
            this.iVH = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iVH.a(this);
            this.iVH.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iVH.setOutsideTouchable(true);
            this.iVH.setFocusable(true);
            this.iVH.setOnDismissListener(this);
            this.iVH.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.k(this.iVG, R.color.cp_bg_line_d);
            am.c(this.iVI, (int) R.drawable.icon_frs_arrow_n);
            this.iVG.setTextColor(color);
            this.jSB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jSB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iVH.addView(writePrefixItemLayout);
            }
            this.iVH.setCurrentIndex(0);
            this.iVG.setText(prefixs.get(1));
            Dk(1);
            return;
        }
        this.iVJ.setVisibility(8);
    }

    protected void cBM() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jSV.a(TransmitPostEditActivity.this.iVB, TransmitPostEditActivity.this.iVF)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jSV.czi());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBQ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cBP());
                    TransmitPostEditActivity.this.crZ.aqu();
                    TiebaStatic.log(new an("c12608").P("obj_locate", 7));
                    TransmitPostEditActivity.this.cBW();
                }
            }
        });
    }

    protected void cmn() {
        this.iVB = (EditText) findViewById(R.id.post_title);
        this.iVB.setOnClickListener(this.jSZ);
        this.iVB.setOnFocusChangeListener(this.iVz);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iVB.setText(this.mData.getTitle());
            this.iVB.setSelection(this.mData.getTitle().length());
        }
        this.iVB.addTextChangedListener(this.jTb);
        if (!this.mData.getHaveDraft()) {
            cBI();
        }
        this.iVB.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cmp() {
        this.iVF = (EditText) findViewById(R.id.post_content);
        this.iVF.setDrawingCacheEnabled(false);
        this.iVF.setOnClickListener(this.jSZ);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atv().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.iVF.setText(ak);
            this.iVF.setSelection(ak.length());
        }
        this.iVF.setOnFocusChangeListener(this.iVz);
        this.iVF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iVF.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iVF.addTextChangedListener(this.jTc);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iVF.setHint(R.string.share_video_default);
        } else {
            this.iVF.setHint(R.string.share_txt_default);
        }
    }

    private void cBN() {
        this.Xv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Xv.setVisibility(0);
        this.Xv.b(this.mOriginalThreadInfo);
        this.Xv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBO() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jSD != null) {
            i = 1000;
        }
        return cBP().getText() != null && cBP().getText().length() >= i;
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jSu)) {
                this.jSu = "";
                cBP().requestFocus();
                if (cBP().getText() != null && cBP().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cBP().getSelectionStart();
                    editable = cBP().getText();
                }
            } else if ("from_title".equals(this.jSu)) {
                this.jSu = "";
                cBQ().requestFocus();
                if (cBQ().getText() != null && cBQ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cBQ().getSelectionStart();
                    editable = cBQ().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cBP().getText().getSpans(0, cBP().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jSC == null) {
                this.jSC = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jSC.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType amu = pVar.amu();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iE().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cBP().getSelectionStart(), aVar, amu);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cBP() != null && cBP().getText() != null) {
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
                int selectionStart = cBP().getSelectionStart() - 1;
                if (cBP().getText().length() > 1 && selectionStart >= 0 && cBP().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cBP().getText().insert(cBP().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cBP().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cBP().getText().insert(cBP().getSelectionStart(), spannableString2);
            }
            Editable text = cBP().getText();
            if (text != null) {
                this.jSS.clear();
                this.jSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jSS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cBP().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cBP().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cBP().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cBP() {
        return this.iVF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cBQ() {
        return this.iVB;
    }

    protected void cBR() {
        Editable text;
        if (cBP() != null && (text = cBP().getText()) != null) {
            int selectionStart = cBP().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cBP().onKeyDown(67, this.fcA);
            }
            cBP().onKeyDown(67, this.fcA);
            int selectionStart2 = cBP().getSelectionStart();
            this.jSS.clear();
            this.jSS.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jSS);
            cBP().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cCo.e(null);
        this.cCo.iz(R.string.sending);
        this.cCo.ej(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cCo.ej(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmo() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cBQ() != null) {
                str = cBQ().getText().toString();
            }
            if (cBP() != null) {
                str2 = cBP().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iVj == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            sn(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        sn(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    sn(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jSP) {
                    sn(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    sn(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sn(true);
            } else if (this.mData.getVideoInfo() != null) {
                sn(true);
            } else {
                sn(false);
            }
        }
    }

    private void sn(boolean z) {
        am.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.ctD = new NewWriteModel(this);
        this.ctD.b(this.ctR);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cmg();
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
                this.jSD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jSD != null);
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
            this.fTa = bundle.getString("KEY_CALL_FROM");
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
            this.jSD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jSD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fTa = intent.getStringExtra("KEY_CALL_FROM");
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
            this.jSw = true;
        }
        cBJ();
    }

    private void cBS() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iVB.setText(com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName)));
            this.iVB.setMovementMethod(com.baidu.tieba.view.c.cxR());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qW = com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName));
            if (qW != null) {
                this.iVB.setText(qW);
            }
            this.jSR.setText(hotTopicBussinessData.mForumName);
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
        if (this.jSD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jSD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fTa);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cBP().getEditableText().toString();
        if (obj != null) {
            cBP().setText(TbFaceManager.atv().a(getPageContext().getPageActivity(), obj, this.jSX));
            cBP().setSelection(cBP().getText().length());
        }
    }

    private String cBT() {
        if (cBP() == null || cBP().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cBP().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cBP().getText().toString();
    }

    private String cBU() {
        if (this.mData == null || cBQ() == null || cBQ().getVisibility() != 0 || cBQ().getText() == null) {
            return "";
        }
        String obj = cBQ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iVj != 0 && this.mData.getType() != 4 && this.iVG != null && this.iVG.getText() != null) {
            obj = this.iVG.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cBV() {
        cmg();
        this.mData.setContent(cBT());
        this.mData.setTitle(cBU());
        if (this.jSK >= 0) {
            this.mData.setCategoryFrom(this.jSK);
        }
        if (this.jSM >= 0) {
            this.mData.setCategoryTo(this.jSM);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.ctC != null && this.ctC.aVA());
        this.ctD.ri(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jSQ != null && this.jSQ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jSQ.mForumId));
            this.mData.setForumName(this.jSQ.mForumName);
        }
        this.ctD.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.ctD.getWriteData().setVoice(null);
        this.ctD.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        this.ctD.startPostWrite();
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jSD != null) {
                i2 = this.jSD.getTotalCount();
                i = this.jSD.getAlreadyCount() + 1;
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
                if (this.crZ != null && !this.crZ.asb()) {
                    cBP().requestFocus();
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
                            cBP().getText().insert(cBP().getSelectionStart(), sb.toString());
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
                        if (this.jSv) {
                            sb2.append(com.baidu.tbadk.plugins.b.cBI);
                            this.jSv = false;
                        }
                        sb2.append(stringExtra);
                        ql(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jSQ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jSQ);
            }
        } else if (i2 == 0) {
            if (this.crZ != null && !this.crZ.asb()) {
                this.iVF.requestFocus();
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
                        this.jSV.GA(postWriteCallBackData.getErrorString());
                        this.jSV.aI(postWriteCallBackData.getSensitiveWords());
                        this.jSV.b(this.iVB, this.iVF);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jSu)) {
                        cBQ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jSu)) {
                        cBP().requestFocus();
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
    public void cBW() {
        if ("1".equals(this.fTa)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fTa)) {
            this.mData.setCanNoForum(false);
        }
        cBX();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fTa);
        cBV();
    }

    private void cBX() {
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cBQ());
        HidenSoftKeyPad(this.mInputManager, cBP());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvc) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jSD == null) {
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
        this.ctI = i;
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cBY() {
        if (!this.jSP && this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.crZ.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dk(int i) {
        if (i < this.jSB.size()) {
            for (int i2 = 0; i2 < this.jSB.size(); i2++) {
                this.jSB.get(i2).sd(false);
            }
            this.jSB.get(i).sd(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void AJ(int i) {
        this.iVj = i;
        this.iVH.setCurrentIndex(i);
        Dk(i);
        this.iVG.setText(this.mPrefixData.getPrefixs().get(i));
        cmo();
        com.baidu.adp.lib.g.g.a(this.iVH, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iVJ.setSelected(false);
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
            asB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jSU = z;
        if (this.jST != null && !z) {
            this.jST.bgg();
        }
        if (this.jSW != null && !z) {
            cBB();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jSU && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jSv = false;
            this.jSu = "";
            if ("from_content".equals(str)) {
                this.jSu = "from_content";
            } else if ("from_title".equals(str)) {
                this.jSu = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qV(String.valueOf(charSequence.charAt(i)))) {
                sm(false);
            }
        }
    }

    public void ciq() {
        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
            this.jSy.setVisibility(0);
            this.jSy.requestFocus();
            this.crZ.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jSy.setVisibility(8);
    }
}
