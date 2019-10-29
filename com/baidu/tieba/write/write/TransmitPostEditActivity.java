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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.y;
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
import com.baidu.tieba.frs.x;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0055a, h.a {
    private OriginalThreadCardView Hn;
    private EditorTools cFk;
    private LocationModel cGP;
    private NewWriteModel cGQ;
    private TextView iYX;
    private com.baidu.tieba.write.h iYY;
    private ImageView iYZ;
    private int iYz;
    private View iZa;
    private boolean isPrivacy;
    private LinearLayout jTZ;
    private com.baidu.tieba.view.b jUE;
    private LinearLayout jUa;
    private View jUc;
    private Toast jUe;
    private AdditionData jUf;
    private RelativeLayout jUg;
    private TextView jUh;
    private TextView jUi;
    private TextView jUj;
    List<v> jUk;
    v jUl;
    private int jUm;
    private String jUn;
    private int jUo;
    private PostCategoryView jUp;
    private HotTopicBussinessData jUs;
    private TextView jUt;
    private com.baidu.tieba.write.editor.b jUv;
    private e jUx;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jTW = "";
    private boolean jTX = false;
    private WriteData iYy = null;
    private boolean jTY = false;
    private InputMethodManager mInputManager = null;
    private EditText iYR = null;
    private View iYS = null;
    private LinearLayout iYU = null;
    private EditText iYV = null;
    private FeedBackModel jUb = null;
    private ArrayList<WritePrefixItemLayout> jUd = new ArrayList<>();
    private final KeyEvent fhx = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView iYW = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener fms = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout gze = null;
    private String cGV = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int cGW = 0;
    private View mRootView = null;
    private ScrollView jUq = null;
    private boolean jUr = false;
    private com.baidu.tbadk.core.view.b cOA = null;
    private String mFrom = "write";
    private String fVb = "2";
    private SpannableStringBuilder jUu = new SpannableStringBuilder();
    private boolean aiA = false;
    private final b jUw = new b();
    private TbFaceManager.a jUy = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pW(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
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
    private final AntiHelper.a fwB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.iYy != null) {
                TransmitPostEditActivity.this.jUw.aM(null);
                if (z) {
                    TransmitPostEditActivity.this.fm(z);
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
                    TransmitPostEditActivity.this.jUw.Fv(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jUw.aM(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jUw.b(TransmitPostEditActivity.this.iYR, TransmitPostEditActivity.this.iYV);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.apu());
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cHd = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void auP() {
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
            if (aVar != null && !StringUtils.isNull(aVar.coU())) {
                TransmitPostEditActivity.this.b(2, true, aVar.coU());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jkQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.cGP.qT(false);
                    TransmitPostEditActivity.this.cGP.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.cGP.qT(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jUz = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jUA = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int czq = TransmitPostEditActivity.this.czq();
            if (czq >= 0 && czq < TransmitPostEditActivity.this.iYV.getText().length()) {
                TransmitPostEditActivity.this.iYV.setSelection(czq);
            }
        }
    };
    private boolean jUB = true;
    private final View.OnFocusChangeListener iYP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iYR || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.iYW) {
                if (z) {
                    TransmitPostEditActivity.this.jUB = true;
                    TransmitPostEditActivity.this.czr();
                    if (TransmitPostEditActivity.this.cFk != null) {
                        TransmitPostEditActivity.this.cFk.asC();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iYR);
                } else if (view == TransmitPostEditActivity.this.iYR) {
                    TransmitPostEditActivity.this.iYX.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iYV && z) {
                TransmitPostEditActivity.this.jUB = false;
                TransmitPostEditActivity.this.czr();
                TransmitPostEditActivity.this.cFk.asC();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iYV);
            }
            TransmitPostEditActivity.this.czx();
        }
    };
    private TextWatcher jUC = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jUG = "";
        private String jUH;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUH = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUH != null ? this.jUH.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.clj();
            TransmitPostEditActivity.this.czy();
            EditText czJ = TransmitPostEditActivity.this.czJ();
            if (editable != null && czJ != null && czJ.getText() != null) {
                if (this.jUG == null || !this.jUG.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jUw != null) {
                        this.jUG = czJ.getText().toString();
                        TransmitPostEditActivity.this.jUw.m(czJ);
                        return;
                    }
                    return;
                }
                czJ.setSelection(czJ.getSelectionEnd());
            }
        }
    };
    private TextWatcher jUD = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jUH;
        private String jUI = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUH = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUH != null ? this.jUH.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.clj();
            EditText czI = TransmitPostEditActivity.this.czI();
            if (editable != null && czI != null && czI.getText() != null) {
                int selectionEnd = czI.getSelectionEnd();
                if (this.jUI == null || !this.jUI.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jUw != null) {
                        this.jUI = czI.getText().toString();
                        TransmitPostEditActivity.this.jUw.m(czI);
                        return;
                    }
                    return;
                }
                czI.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void auB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auD();
        } else if (this.cGP.cpb()) {
            auA();
        } else {
            this.cGP.qT(false);
            b(1, true, null);
            this.cGP.coZ();
        }
    }

    private void auD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hU(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.cGP.cpd();
                } else {
                    TransmitPostEditActivity.this.cHd.auP();
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
        aVar.akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czq() {
        int selectionEnd = czI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) czI().getText().getSpans(0, czI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = czI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = czI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czr() {
        if (this.cFk != null) {
            this.cFk.setBarLauncherEnabled(!this.jUB);
            this.cFk.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jUr) {
            this.iYR.setVisibility(8);
            clj();
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
        this.cGP = new LocationModel(this);
        this.cGP.a(this.cHd);
        registerListener(this.jkQ);
        registerListener(this.jUz);
        bLM();
        this.iYV.requestFocus();
        cgA();
        czR();
    }

    @SuppressLint({"ResourceAsColor"})
    private void bLM() {
        this.cFk = new EditorTools(getActivity());
        this.cFk.setBarMaxLauCount(4);
        this.cFk.setMoreButtonAtEnd(true);
        this.cFk.setBarLauncherType(1);
        this.cFk.fe(true);
        this.cFk.ff(true);
        this.cFk.setBackgroundColorId(R.color.cp_bg_line_h);
        czs();
        this.cFk.build();
        if (this.jTZ != null) {
            this.jTZ.addView(this.cFk);
        }
        czt();
        this.cFk.le();
        com.baidu.tbadk.editortools.g jI = this.cFk.jI(6);
        if (jI != null && !TextUtils.isEmpty(this.cGV)) {
            ((View) jI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.cGV);
                }
            });
        }
        if (!this.jUr) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cFk.asC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.iYy.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.iYy.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        czv();
    }

    private void czs() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.cFk.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.cFk.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.cFV = 4;
            kVar.cFR = R.drawable.icon_post_location_selector;
            this.cFk.b(kVar);
        }
        if (this.jUf == null) {
            if (this.jUv == null) {
                this.jUv = new com.baidu.tieba.write.editor.b(getActivity(), this.fVb);
                this.jUv.cyr();
                this.jUv.setFrom("from_share_write");
                this.jUv.bq(this.iYy.getForumId(), this.mPrivateThread);
            }
            this.cFk.b(this.jUv);
        }
        this.cFk.aC(arrayList);
        com.baidu.tbadk.editortools.k jL = this.cFk.jL(5);
        if (jL != null) {
            jL.cFV = 1;
        }
    }

    private void czt() {
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
                            TiebaStatic.log(new an("c12608").O("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.czH()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.czH()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.czK();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.clj();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jUf == null) {
                            TransmitPostEditActivity.this.auE();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.cGW) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.auB();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.auA();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.cGP != null) {
                            TransmitPostEditActivity.this.cGP.qT(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.iYy != null) {
                            str = TransmitPostEditActivity.this.iYy.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bS("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.iYy == null || (videoInfo = TransmitPostEditActivity.this.iYy.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.cFk.aub()) {
                                        TransmitPostEditActivity.this.cFk.asC();
                                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.iYy.setVideoInfo(null);
                        TransmitPostEditActivity.this.clj();
                        if (TransmitPostEditActivity.this.iYV != null) {
                            TransmitPostEditActivity.this.iYV.requestFocus();
                        }
                        TransmitPostEditActivity.this.cFk.asC();
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYV);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jTX = true;
                        TransmitPostEditActivity.this.rV(true);
                        if (TransmitPostEditActivity.this.czJ().isFocused()) {
                            TransmitPostEditActivity.this.jTW = "from_title";
                        } else if (TransmitPostEditActivity.this.czI().isFocused()) {
                            TransmitPostEditActivity.this.jTW = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jUa.setVisibility(0);
                        TransmitPostEditActivity.this.jUa.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jUa.hasFocus()) {
                            TransmitPostEditActivity.this.iYV.requestFocus();
                            TransmitPostEditActivity.this.iYV.setSelection(TransmitPostEditActivity.this.iYV.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jUa.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cFk.setActionListener(31, bVar);
        this.cFk.setActionListener(16, bVar);
        this.cFk.setActionListener(14, bVar);
        this.cFk.setActionListener(24, bVar);
        this.cFk.setActionListener(3, bVar);
        this.cFk.setActionListener(10, bVar);
        this.cFk.setActionListener(11, bVar);
        this.cFk.setActionListener(12, bVar);
        this.cFk.setActionListener(13, bVar);
        this.cFk.setActionListener(15, bVar);
        this.cFk.setActionListener(18, bVar);
        this.cFk.setActionListener(20, bVar);
        this.cFk.setActionListener(25, bVar);
        this.cFk.setActionListener(27, bVar);
        this.cFk.setActionListener(29, bVar);
        this.cFk.setActionListener(43, bVar);
        this.cFk.setActionListener(45, bVar);
        this.cFk.setActionListener(53, bVar);
        this.cFk.setActionListener(48, bVar);
        this.cFk.setActionListener(46, bVar);
        this.cFk.setActionListener(49, bVar);
        this.cFk.setActionListener(47, bVar);
        this.cFk.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auE() {
        if (this.cGP.aWR()) {
            if (this.cGP.cpb()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.coW().getLocationData().coU());
                return;
            }
            b(1, true, null);
            this.cGP.coZ();
            return;
        }
        b(0, true, null);
    }

    protected void cla() {
        if (this.cGQ != null) {
            this.cGQ.cancelLoadData();
        }
        if (this.jUb != null) {
            this.jUb.cancelLoadData();
        }
        if (this.cGP != null) {
            this.cGP.cancelLoadData();
        }
    }

    private void czu() {
        if (this.jUx != null) {
            this.jUx.hideTip();
        }
    }

    private void czv() {
        if (this.jUx == null) {
            this.jUx = new e(getPageContext());
        }
        this.jUx.c(this.cFk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        czu();
        TiebaPrepareImageService.StopService();
        cla();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        if (this.iYy == null) {
            finish();
            return;
        }
        this.iYy.setTitle(czJ().getText().toString());
        this.iYy.setContent(czI().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iYY != null && this.iYY.isShowing()) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYY, getPageContext().getPageActivity());
                return true;
            } else if (this.cFk.aub()) {
                this.cFk.asC();
                return true;
            } else {
                cla();
                czw();
                return true;
            }
        }
        if (i == 67 && (text = czI().getText()) != null) {
            int selectionStart = czI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czI().onKeyDown(67, this.fhx);
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
        getLayoutMode().onModeChanged(this.gze);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iYW, R.color.cp_link_tip_a, 1);
        czr();
        am.setBackgroundColor(this.iYS, R.color.cp_bg_line_c);
        am.setBackgroundColor(czJ(), R.color.cp_bg_line_d);
        am.setBackgroundColor(czI(), R.color.cp_bg_line_d);
        clj();
        this.cFk.onChangeSkinType(i);
        if (this.jUp != null) {
            this.jUp.anO();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        czx();
        czy();
        if (this.jUw != null) {
            this.jUw.c(czJ(), czI());
        }
        this.Hn.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czx() {
        if (this.iYR.hasFocus()) {
            this.iYR.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYR.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iYV.hasFocus()) {
            this.iYV.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYV.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czy() {
        if (this.iYR != null) {
            if (this.iYR.getText().toString().length() == 0) {
                this.iYR.getPaint().setFakeBoldText(false);
            } else if (this.iYR.getText().toString().length() > 0) {
                this.iYR.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cOA = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jUr = this.iYy.getType() == 4 || 5 == this.iYy.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        czA();
        this.jUq = (ScrollView) findViewById(R.id.write_scrollview);
        this.jUq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iYV != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iYV);
                    }
                    if (TransmitPostEditActivity.this.cFk != null) {
                        TransmitPostEditActivity.this.cFk.asC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gze = (RelativeLayout) findViewById(R.id.parent);
        this.jTZ = (LinearLayout) findViewById(R.id.tool_view);
        this.jTZ.setContentDescription("..");
        this.jUa = (LinearLayout) findViewById(R.id.title_view);
        this.iYS = findViewById(R.id.interval_view);
        this.jUt = (TextView) findViewById(R.id.hot_topic_title_edt);
        cli();
        if (this.jUr) {
            this.jUq.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        clk();
        czG();
        this.iYU = (LinearLayout) findViewById(R.id.post_content_container);
        this.iYU.setDrawingCacheEnabled(false);
        this.iYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iYV.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.iYP);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cla();
                TransmitPostEditActivity.this.czw();
            }
        });
        czD();
        czF();
        czz();
        czr();
        czE();
        clh();
        czL();
        if (this.iYy.getType() == 4 && this.iZa != null && this.jUc != null) {
            this.iZa.setVisibility(8);
            this.jUc.setVisibility(8);
        }
        clj();
        ShowSoftKeyPad(this.mInputManager, this.iYR);
    }

    private void czz() {
        String str;
        String str2;
        if (this.iYy != null) {
            switch (this.iYy.getType()) {
                case 0:
                case 9:
                    if (this.fVb != null && this.fVb.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fVb != null && this.fVb.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.iYy.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.iYR.setVisibility(0);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iYR.setVisibility(8);
                    return;
            }
        }
    }

    private void czA() {
        this.iYW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYW.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.iYW.setLayoutParams(layoutParams);
        this.iYW.setOnFocusChangeListener(this.iYP);
    }

    private void czB() {
        if (this.iYy != null && this.iYy.getType() == 0 && this.iYy.getType() == 9 && !this.jTY && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && czJ() != null) {
                czJ().setText(cutStringWithSuffix);
                czJ().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void czC() {
        this.jUk = null;
        this.jUm = -1;
        this.jUo = -1;
        x qI = w.blC().qI(1);
        if (qI != null) {
            this.jUk = qI.fzd;
            this.jUm = getIntent().getIntExtra("category_id", -1);
            if (this.jUk != null && !this.jUk.isEmpty() && this.jUm >= 0) {
                this.jUl = new v();
                this.jUl.fyZ = 0;
                this.jUl.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jUo = this.jUl.fyZ;
                this.jUn = this.jUl.name;
                for (v vVar : this.jUk) {
                    if (vVar.fyZ == this.jUm) {
                        this.jUo = vVar.fyZ;
                        this.jUn = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void czD() {
        if (this.jUk != null && !this.jUk.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jUp = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jUp.setText(this.jUn);
            this.jUp.setCategoryContainerData(this.jUk, this.jUl, this.jUo);
            this.jUp.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jUp.setText(arVar.name);
                        TransmitPostEditActivity.this.iYy.setCategoryTo(arVar.fyZ);
                        TransmitPostEditActivity.this.jUo = arVar.fyZ;
                        TransmitPostEditActivity.this.jUp.cze();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jUp.czd();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czJ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czI());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jUE = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jUE.setTitle(R.string.no_disturb_start_time);
        this.jUE.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jUE);
        this.jUE.setButton(-2, getPageContext().getString(R.string.cancel), this.jUE);
        return this.jUE;
    }

    private void czE() {
        this.jUg = (RelativeLayout) findViewById(R.id.addition_container);
        this.jUh = (TextView) findViewById(R.id.addition_create_time);
        this.jUi = (TextView) findViewById(R.id.addition_last_time);
        this.jUj = (TextView) findViewById(R.id.addition_last_content);
        if (this.jUf != null) {
            this.jUg.setVisibility(0);
            this.jUh.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.jUf.getCreateTime() * 1000));
            if (this.jUf.getAlreadyCount() == 0) {
                this.jUi.setVisibility(8);
            } else {
                this.jUi.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.jUf.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jUf.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jUj.setText(lastAdditionContent);
            } else {
                this.jUj.setVisibility(8);
            }
            czI().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jUf.getAlreadyCount()), Integer.valueOf(this.jUf.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jUg.setVisibility(8);
    }

    private void clh() {
        this.iZa = findViewById(R.id.post_prefix_layout);
        this.iYX = (TextView) findViewById(R.id.post_prefix);
        this.jUc = findViewById(R.id.prefix_divider);
        this.iYZ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iZa.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iYz = 1;
            this.iZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iYX.setVisibility(0);
                    TransmitPostEditActivity.this.iZa.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iYY, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.cFk.asC();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYR);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYV);
                }
            });
            this.iYZ = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iYZ.setVisibility(0);
                this.iYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iYX.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iYY, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.cFk.asC();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czJ());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czI());
                    }
                });
            }
            this.iYY = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iYY.a(this);
            this.iYY.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.iYY.setOutsideTouchable(true);
            this.iYY.setFocusable(true);
            this.iYY.setOnDismissListener(this);
            this.iYY.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.iYX, R.color.cp_bg_line_d);
            am.setImageResource(this.iYZ, R.drawable.icon_frs_arrow_n);
            this.iYX.setTextColor(color);
            this.jUd.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jUd.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iYY.addView(writePrefixItemLayout);
            }
            this.iYY.setCurrentIndex(0);
            this.iYX.setText(prefixs.get(1));
            BM(1);
            return;
        }
        this.iZa.setVisibility(8);
    }

    protected void czF() {
        this.iYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jUw.a(TransmitPostEditActivity.this.iYR, TransmitPostEditActivity.this.iYV)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jUw.cxC());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czJ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czI());
                    TransmitPostEditActivity.this.cFk.asC();
                    TiebaStatic.log(new an("c12608").O("obj_locate", 7));
                    TransmitPostEditActivity.this.czP();
                }
            }
        });
    }

    protected void cli() {
        this.iYR = (EditText) findViewById(R.id.post_title);
        this.iYR.setOnClickListener(this.jUA);
        this.iYR.setOnFocusChangeListener(this.iYP);
        if ((this.iYy.getType() == 0 || this.iYy.getType() == 9 || this.iYy.getType() == 7) && this.iYy.getTitle() != null) {
            this.iYR.setText(this.iYy.getTitle());
            this.iYR.setSelection(this.iYy.getTitle().length());
        }
        this.iYR.addTextChangedListener(this.jUC);
        if (!this.iYy.getHaveDraft()) {
            czB();
        }
        this.iYR.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void clk() {
        this.iYV = (EditText) findViewById(R.id.post_content);
        this.iYV.setDrawingCacheEnabled(false);
        this.iYV.setOnClickListener(this.jUA);
        if (this.iYy.getContent() != null && this.iYy.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avt().ah(getPageContext().getPageActivity(), this.iYy.getContent());
            this.iYV.setText(ah);
            this.iYV.setSelection(ah.length());
        }
        this.iYV.setOnFocusChangeListener(this.iYP);
        this.iYV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iYV.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYV.addTextChangedListener(this.jUD);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iYV.setHint(R.string.share_video_default);
        } else {
            this.iYV.setHint(R.string.share_txt_default);
        }
    }

    private void czG() {
        this.Hn = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Hn.setVisibility(0);
        this.Hn.b(this.mOriginalThreadInfo);
        this.Hn.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czH() {
        int i = 5000;
        if (this.jUf != null) {
            i = 1000;
        }
        return czI().getText() != null && czI().getText().length() >= i;
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTW)) {
                this.jTW = "";
                czI().requestFocus();
                if (czI().getText() != null && czI().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czI().getSelectionStart();
                    editable = czI().getText();
                }
            } else if ("from_title".equals(this.jTW)) {
                this.jTW = "";
                czJ().requestFocus();
                if (czJ().getText() != null && czJ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czJ().getSelectionStart();
                    editable = czJ().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rV(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.iYy != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.toLong(this.iYy.getForumId(), 0L), this.iYy.getFirstDir(), this.iYy.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) czI().getText().getSpans(0, czI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jUe == null) {
                this.jUe = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jUe.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType apm = pVar.apm();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fT().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.czI().getSelectionStart(), aVar, apm);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && czI() != null && czI().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = czI().getSelectionStart() - 1;
                if (czI().getText().length() > 1 && selectionStart >= 0 && czI().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    czI().getText().insert(czI().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            czI().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                czI().getText().insert(czI().getSelectionStart(), spannableString2);
            }
            Editable text = czI().getText();
            if (text != null) {
                this.jUu.clear();
                this.jUu.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jUu);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && czI().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    czI().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                czI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czI() {
        return this.iYV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czJ() {
        return this.iYR;
    }

    protected void czK() {
        Editable text;
        if (czI() != null && (text = czI().getText()) != null) {
            int selectionStart = czI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czI().onKeyDown(67, this.fhx);
            }
            czI().onKeyDown(67, this.fhx);
            int selectionStart2 = czI().getSelectionStart();
            this.jUu.clear();
            this.jUu.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jUu);
            czI().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cOA.setCancelListener(null);
        this.cOA.setTipString(R.string.sending);
        this.cOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cOA.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clj() {
        if (this.iYy != null) {
            String str = "";
            String str2 = "";
            if (czJ() != null) {
                str = czJ().getText().toString();
            }
            if (czI() != null) {
                str2 = czI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.iYy.getType() == 0 || this.iYy.getType() == 9 || this.iYy.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iYz == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.iYy.setIsNoTitle(true);
                        } else {
                            this.iYy.setIsNoTitle(false);
                            rW(true);
                            return;
                        }
                    } else {
                        this.iYy.setIsNoTitle(false);
                        rW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.iYy.setIsNoTitle(true);
                } else {
                    this.iYy.setIsNoTitle(false);
                    rW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jUr) {
                    rW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rW(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                rW(true);
            } else if (this.iYy.getVideoInfo() != null) {
                rW(true);
            } else {
                rW(false);
            }
        }
    }

    private void rW(boolean z) {
        am.setNavbarTitleColor(this.iYW, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.cGQ = new NewWriteModel(this);
        this.cGQ.b(this.cHf);
        this.fms = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cla();
            }
        };
        this.iYy = new WriteData();
        if (bundle != null) {
            this.iYy.setType(bundle.getInt("type", 0));
            this.iYy.setForumId(bundle.getString("forum_id"));
            this.iYy.setForumName(bundle.getString("forum_name"));
            this.iYy.setFirstDir(bundle.getString("forum_first_dir"));
            this.iYy.setSecondDir(bundle.getString("forum_second_dir"));
            this.iYy.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jUf = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.iYy.setIsAddition(this.jUf != null);
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
            this.iYy.setTitle(bundle.getString("write_title"));
            this.iYy.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.fVb = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.class);
            }
            str = string;
        } else {
            Intent intent = getIntent();
            this.iYy.setType(intent.getIntExtra("type", 0));
            this.iYy.setForumId(intent.getStringExtra("forum_id"));
            this.iYy.setForumName(intent.getStringExtra("forum_name"));
            this.iYy.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.iYy.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.iYy.setThreadId(intent.getStringExtra("thread_id"));
            this.jUf = (AdditionData) intent.getSerializableExtra("addition_data");
            this.iYy.setIsAddition(this.jUf != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.iYy.setTitle(intent.getStringExtra("write_title"));
            this.iYy.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fVb = intent.getStringExtra("KEY_CALL_FROM");
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
        this.writeImagesInfo.setMaxImagesAllowed(this.iYy.getType() == 4 ? 6 : 9);
        this.iYy.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.iYy.setVideoId(this.mOriginalThreadInfo.videoId);
            this.iYy.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.iYy.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.iYy != null && this.iYy.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.iYy.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jTY = true;
        }
        czC();
    }

    private void czL() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iYR.setText(com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName)));
            this.iYR.setMovementMethod(com.baidu.tieba.view.c.cwP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qf = com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName));
            if (qf != null) {
                this.iYR.setText(qf);
            }
            this.jUt.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.iYy.getType());
        bundle.putString("forum_id", this.iYy.getForumId());
        bundle.putString("forum_name", this.iYy.getForumName());
        bundle.putString("forum_first_dir", this.iYy.getFirstDir());
        bundle.putString("forum_second_dir", this.iYy.getSecondDir());
        bundle.putString("thread_id", this.iYy.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.jUf != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jUf));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fVb);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = czI().getEditableText().toString();
        if (obj != null) {
            czI().setText(TbFaceManager.avt().a(getPageContext().getPageActivity(), obj, this.jUy));
            czI().setSelection(czI().getText().length());
        }
    }

    private String czM() {
        if (czI() == null || czI().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(czI().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return czI().getText().toString();
    }

    private String czN() {
        if (this.iYy == null || czJ() == null || czJ().getVisibility() != 0 || czJ().getText() == null) {
            return "";
        }
        String obj = czJ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.iYz != 0 && this.iYy.getType() != 4 && this.iYX != null && this.iYX.getText() != null) {
            obj = this.iYX.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.iYy.getTitle();
        }
        return obj;
    }

    private void czO() {
        cla();
        this.iYy.setContent(czM());
        this.iYy.setTitle(czN());
        if (this.jUm >= 0) {
            this.iYy.setCategoryFrom(this.jUm);
        }
        if (this.jUo >= 0) {
            this.iYy.setCategoryTo(this.jUo);
        }
        this.iYy.setWriteImagesInfo(this.writeImagesInfo);
        this.iYy.setHasLocationData(this.cGP != null && this.cGP.aWR());
        this.cGQ.qV(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.jUs != null && this.jUs.mIsGlobalBlock == 0) {
            this.iYy.setForumId(String.valueOf(this.jUs.mForumId));
            this.iYy.setForumName(this.jUs.mForumName);
        }
        this.cGQ.d(this.iYy);
        this.iYy.setContent(this.iYy.getContent().replaceAll("\u0000\n", ""));
        this.iYy.setContent(this.iYy.getContent().replaceAll("\u0000", ""));
        this.iYy.setVcode(null);
        this.cGQ.clc().setVoice(null);
        this.cGQ.clc().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.fms);
        this.cGQ.cpE();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jUf != null) {
                i2 = this.jUf.getTotalCount();
                i = this.jUf.getAlreadyCount() + 1;
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
                if (this.cFk != null && !this.cFk.aub()) {
                    czI().requestFocus();
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
                            sb.append(HanziToPinyin.Token.SEPARATOR);
                            i3 = i4 + 1;
                        } else {
                            czI().getText().insert(czI().getSelectionStart(), sb.toString());
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
                        if (this.jTX) {
                            sb2.append(com.baidu.tbadk.plugins.b.cNU);
                            this.jTX = false;
                        }
                        sb2.append(stringExtra);
                        pF(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.jUs = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.jUs);
            }
        } else if (i2 == 0) {
            if (this.cFk != null && !this.cFk.aub()) {
                this.iYV.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jUw.Fv(postWriteCallBackData.getErrorString());
                        this.jUw.aM(postWriteCallBackData.getSensitiveWords());
                        this.jUw.b(this.iYR, this.iYV);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.jTW)) {
                        czJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTW)) {
                        czI().requestFocus();
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
    public void czP() {
        if ("1".equals(this.fVb)) {
            this.iYy.setCanNoForum(true);
            this.iYy.setTransmitForumData("[]");
        } else if ("2".equals(this.fVb)) {
            this.iYy.setCanNoForum(false);
        }
        czQ();
        this.iYy.setPrivacy(this.isPrivacy);
        this.iYy.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.iYy.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.iYy.setCallFrom(this.fVb);
        czO();
    }

    private void czQ() {
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, czJ());
        HidenSoftKeyPad(this.mInputManager, czI());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fwB) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.iYy.getType() != 7) {
                if (this.jUf == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cGW = i;
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czR() {
        if (!this.jUr && this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.cFk.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void BM(int i) {
        if (i < this.jUd.size()) {
            for (int i2 = 0; i2 < this.jUd.size(); i2++) {
                this.jUd.get(i2).rO(false);
            }
            this.jUd.get(i).rO(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void zw(int i) {
        this.iYz = i;
        this.iYY.setCurrentIndex(i);
        BM(i);
        this.iYX.setText(this.mPrefixData.getPrefixs().get(i));
        clj();
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYY, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iZa.setSelected(false);
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
            l.hideSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.iYy != null) {
            if (this.iYy.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.iYy.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            auB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aiA = z;
        if (this.jUv != null && !z) {
            this.jUv.beI();
        }
        if (this.jUx != null && !z) {
            czu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aiA && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTX = false;
            this.jTW = "";
            if ("from_content".equals(str)) {
                this.jTW = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qe(String.valueOf(charSequence.charAt(i)))) {
                rV(false);
            }
        }
    }

    public void cgA() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
            this.jUa.setVisibility(0);
            this.jUa.requestFocus();
            this.cFk.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jUa.setVisibility(8);
    }
}
