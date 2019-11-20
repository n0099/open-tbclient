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
    private OriginalThreadCardView GL;
    private EditorTools cEt;
    private LocationModel cFY;
    private NewWriteModel cFZ;
    private int iXI;
    private TextView iYg;
    private com.baidu.tieba.write.h iYh;
    private ImageView iYi;
    private View iYj;
    private boolean isPrivacy;
    private HotTopicBussinessData jTB;
    private TextView jTC;
    private com.baidu.tieba.write.editor.b jTE;
    private e jTG;
    private com.baidu.tieba.view.b jTN;
    private LinearLayout jTi;
    private LinearLayout jTj;
    private View jTl;
    private Toast jTn;
    private AdditionData jTo;
    private RelativeLayout jTp;
    private TextView jTq;
    private TextView jTr;
    private TextView jTs;
    List<v> jTt;
    v jTu;
    private int jTv;
    private String jTw;
    private int jTx;
    private PostCategoryView jTy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jTf = "";
    private boolean jTg = false;
    private WriteData iXH = null;
    private boolean jTh = false;
    private InputMethodManager mInputManager = null;
    private EditText iYa = null;
    private View iYb = null;
    private LinearLayout iYd = null;
    private EditText iYe = null;
    private FeedBackModel jTk = null;
    private ArrayList<WritePrefixItemLayout> jTm = new ArrayList<>();
    private final KeyEvent fgG = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView iYf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener flB = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout gyn = null;
    private String cGe = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int cGf = 0;
    private View mRootView = null;
    private ScrollView jTz = null;
    private boolean jTA = false;
    private com.baidu.tbadk.core.view.b cNJ = null;
    private String mFrom = "write";
    private String fUk = "2";
    private SpannableStringBuilder jTD = new SpannableStringBuilder();
    private boolean aii = false;
    private final b jTF = new b();
    private TbFaceManager.a jTH = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a fvK = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.iXH != null) {
                TransmitPostEditActivity.this.jTF.aM(null);
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
                    TransmitPostEditActivity.this.jTF.Fv(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jTF.aM(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jTF.b(TransmitPostEditActivity.this.iYa, TransmitPostEditActivity.this.iYe);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aps());
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cGm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void auN() {
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
            if (aVar != null && !StringUtils.isNull(aVar.coS())) {
                TransmitPostEditActivity.this.b(2, true, aVar.coS());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.cFY.qT(false);
                    TransmitPostEditActivity.this.cFY.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.cFY.qT(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jTI = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jTJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int czo = TransmitPostEditActivity.this.czo();
            if (czo >= 0 && czo < TransmitPostEditActivity.this.iYe.getText().length()) {
                TransmitPostEditActivity.this.iYe.setSelection(czo);
            }
        }
    };
    private boolean jTK = true;
    private final View.OnFocusChangeListener iXY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iYa || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.iYf) {
                if (z) {
                    TransmitPostEditActivity.this.jTK = true;
                    TransmitPostEditActivity.this.czp();
                    if (TransmitPostEditActivity.this.cEt != null) {
                        TransmitPostEditActivity.this.cEt.asA();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iYa);
                } else if (view == TransmitPostEditActivity.this.iYa) {
                    TransmitPostEditActivity.this.iYg.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iYe && z) {
                TransmitPostEditActivity.this.jTK = false;
                TransmitPostEditActivity.this.czp();
                TransmitPostEditActivity.this.cEt.asA();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iYe);
            }
            TransmitPostEditActivity.this.czv();
        }
    };
    private TextWatcher jTL = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jTP = "";
        private String jTQ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTQ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTQ != null ? this.jTQ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.clh();
            TransmitPostEditActivity.this.czw();
            EditText czH = TransmitPostEditActivity.this.czH();
            if (editable != null && czH != null && czH.getText() != null) {
                if (this.jTP == null || !this.jTP.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jTF != null) {
                        this.jTP = czH.getText().toString();
                        TransmitPostEditActivity.this.jTF.m(czH);
                        return;
                    }
                    return;
                }
                czH.setSelection(czH.getSelectionEnd());
            }
        }
    };
    private TextWatcher jTM = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jTQ;
        private String jTR = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTQ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTQ != null ? this.jTQ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.clh();
            EditText czG = TransmitPostEditActivity.this.czG();
            if (editable != null && czG != null && czG.getText() != null) {
                int selectionEnd = czG.getSelectionEnd();
                if (this.jTR == null || !this.jTR.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jTF != null) {
                        this.jTR = czG.getText().toString();
                        TransmitPostEditActivity.this.jTF.m(czG);
                        return;
                    }
                    return;
                }
                czG.setSelection(selectionEnd);
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
    public void auy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void auz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auB();
        } else if (this.cFY.coZ()) {
            auy();
        } else {
            this.cFY.qT(false);
            b(1, true, null);
            this.cFY.coX();
        }
    }

    private void auB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.cFY.cpb();
                } else {
                    TransmitPostEditActivity.this.cGm.auN();
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
        aVar.akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czo() {
        int selectionEnd = czG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) czG().getText().getSpans(0, czG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = czG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = czG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czp() {
        if (this.cEt != null) {
            this.cEt.setBarLauncherEnabled(!this.jTK);
            this.cEt.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jTA) {
            this.iYa.setVisibility(8);
            clh();
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
        this.cFY = new LocationModel(this);
        this.cFY.a(this.cGm);
        registerListener(this.jjZ);
        registerListener(this.jTI);
        bLK();
        this.iYe.requestFocus();
        cgy();
        czP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void bLK() {
        this.cEt = new EditorTools(getActivity());
        this.cEt.setBarMaxLauCount(4);
        this.cEt.setMoreButtonAtEnd(true);
        this.cEt.setBarLauncherType(1);
        this.cEt.fe(true);
        this.cEt.ff(true);
        this.cEt.setBackgroundColorId(R.color.cp_bg_line_h);
        czq();
        this.cEt.build();
        if (this.jTi != null) {
            this.jTi.addView(this.cEt);
        }
        czr();
        this.cEt.le();
        com.baidu.tbadk.editortools.g jH = this.cEt.jH(6);
        if (jH != null && !TextUtils.isEmpty(this.cGe)) {
            ((View) jH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.cGe);
                }
            });
        }
        if (!this.jTA) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cEt.asA();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.iXH.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.iXH.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        czt();
    }

    private void czq() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.cEt.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.cEt.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.cFe = 4;
            kVar.cFa = R.drawable.icon_post_location_selector;
            this.cEt.b(kVar);
        }
        if (this.jTo == null) {
            if (this.jTE == null) {
                this.jTE = new com.baidu.tieba.write.editor.b(getActivity(), this.fUk);
                this.jTE.cyp();
                this.jTE.setFrom("from_share_write");
                this.jTE.bq(this.iXH.getForumId(), this.mPrivateThread);
            }
            this.cEt.b(this.jTE);
        }
        this.cEt.aC(arrayList);
        com.baidu.tbadk.editortools.k jK = this.cEt.jK(5);
        if (jK != null) {
            jK.cFe = 1;
        }
    }

    private void czr() {
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
                        if (TransmitPostEditActivity.this.czF()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.czF()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.czI();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.clh();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jTo == null) {
                            TransmitPostEditActivity.this.auC();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.cGf) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.auz();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.auy();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.cFY != null) {
                            TransmitPostEditActivity.this.cFY.qT(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.iXH != null) {
                            str = TransmitPostEditActivity.this.iXH.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bS("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.iXH == null || (videoInfo = TransmitPostEditActivity.this.iXH.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.cEt.atZ()) {
                                        TransmitPostEditActivity.this.cEt.asA();
                                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.iXH.setVideoInfo(null);
                        TransmitPostEditActivity.this.clh();
                        if (TransmitPostEditActivity.this.iYe != null) {
                            TransmitPostEditActivity.this.iYe.requestFocus();
                        }
                        TransmitPostEditActivity.this.cEt.asA();
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYe);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jTg = true;
                        TransmitPostEditActivity.this.rV(true);
                        if (TransmitPostEditActivity.this.czH().isFocused()) {
                            TransmitPostEditActivity.this.jTf = "from_title";
                        } else if (TransmitPostEditActivity.this.czG().isFocused()) {
                            TransmitPostEditActivity.this.jTf = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jTj.setVisibility(0);
                        TransmitPostEditActivity.this.jTj.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jTj.hasFocus()) {
                            TransmitPostEditActivity.this.iYe.requestFocus();
                            TransmitPostEditActivity.this.iYe.setSelection(TransmitPostEditActivity.this.iYe.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jTj.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cEt.setActionListener(31, bVar);
        this.cEt.setActionListener(16, bVar);
        this.cEt.setActionListener(14, bVar);
        this.cEt.setActionListener(24, bVar);
        this.cEt.setActionListener(3, bVar);
        this.cEt.setActionListener(10, bVar);
        this.cEt.setActionListener(11, bVar);
        this.cEt.setActionListener(12, bVar);
        this.cEt.setActionListener(13, bVar);
        this.cEt.setActionListener(15, bVar);
        this.cEt.setActionListener(18, bVar);
        this.cEt.setActionListener(20, bVar);
        this.cEt.setActionListener(25, bVar);
        this.cEt.setActionListener(27, bVar);
        this.cEt.setActionListener(29, bVar);
        this.cEt.setActionListener(43, bVar);
        this.cEt.setActionListener(45, bVar);
        this.cEt.setActionListener(53, bVar);
        this.cEt.setActionListener(48, bVar);
        this.cEt.setActionListener(46, bVar);
        this.cEt.setActionListener(49, bVar);
        this.cEt.setActionListener(47, bVar);
        this.cEt.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auC() {
        if (this.cFY.aWP()) {
            if (this.cFY.coZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.coU().getLocationData().coS());
                return;
            }
            b(1, true, null);
            this.cFY.coX();
            return;
        }
        b(0, true, null);
    }

    protected void ckY() {
        if (this.cFZ != null) {
            this.cFZ.cancelLoadData();
        }
        if (this.jTk != null) {
            this.jTk.cancelLoadData();
        }
        if (this.cFY != null) {
            this.cFY.cancelLoadData();
        }
    }

    private void czs() {
        if (this.jTG != null) {
            this.jTG.hideTip();
        }
    }

    private void czt() {
        if (this.jTG == null) {
            this.jTG = new e(getPageContext());
        }
        this.jTG.c(this.cEt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        czs();
        TiebaPrepareImageService.StopService();
        ckY();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czu() {
        if (this.iXH == null) {
            finish();
            return;
        }
        this.iXH.setTitle(czH().getText().toString());
        this.iXH.setContent(czG().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iYh != null && this.iYh.isShowing()) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYh, getPageContext().getPageActivity());
                return true;
            } else if (this.cEt.atZ()) {
                this.cEt.asA();
                return true;
            } else {
                ckY();
                czu();
                return true;
            }
        }
        if (i == 67 && (text = czG().getText()) != null) {
            int selectionStart = czG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czG().onKeyDown(67, this.fgG);
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
        getLayoutMode().onModeChanged(this.gyn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iYf, R.color.cp_link_tip_a, 1);
        czp();
        am.setBackgroundColor(this.iYb, R.color.cp_bg_line_c);
        am.setBackgroundColor(czH(), R.color.cp_bg_line_d);
        am.setBackgroundColor(czG(), R.color.cp_bg_line_d);
        clh();
        this.cEt.onChangeSkinType(i);
        if (this.jTy != null) {
            this.jTy.anM();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        czv();
        czw();
        if (this.jTF != null) {
            this.jTF.c(czH(), czG());
        }
        this.GL.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czv() {
        if (this.iYa.hasFocus()) {
            this.iYa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iYe.hasFocus()) {
            this.iYe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        if (this.iYa != null) {
            if (this.iYa.getText().toString().length() == 0) {
                this.iYa.getPaint().setFakeBoldText(false);
            } else if (this.iYa.getText().toString().length() > 0) {
                this.iYa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.cNJ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jTA = this.iXH.getType() == 4 || 5 == this.iXH.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        czy();
        this.jTz = (ScrollView) findViewById(R.id.write_scrollview);
        this.jTz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iYe != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iYe);
                    }
                    if (TransmitPostEditActivity.this.cEt != null) {
                        TransmitPostEditActivity.this.cEt.asA();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gyn = (RelativeLayout) findViewById(R.id.parent);
        this.jTi = (LinearLayout) findViewById(R.id.tool_view);
        this.jTi.setContentDescription("..");
        this.jTj = (LinearLayout) findViewById(R.id.title_view);
        this.iYb = findViewById(R.id.interval_view);
        this.jTC = (TextView) findViewById(R.id.hot_topic_title_edt);
        clg();
        if (this.jTA) {
            this.jTz.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cli();
        czE();
        this.iYd = (LinearLayout) findViewById(R.id.post_content_container);
        this.iYd.setDrawingCacheEnabled(false);
        this.iYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iYe.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.iXY);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.ckY();
                TransmitPostEditActivity.this.czu();
            }
        });
        czB();
        czD();
        czx();
        czp();
        czC();
        clf();
        czJ();
        if (this.iXH.getType() == 4 && this.iYj != null && this.jTl != null) {
            this.iYj.setVisibility(8);
            this.jTl.setVisibility(8);
        }
        clh();
        ShowSoftKeyPad(this.mInputManager, this.iYa);
    }

    private void czx() {
        String str;
        String str2;
        if (this.iXH != null) {
            switch (this.iXH.getType()) {
                case 0:
                case 9:
                    if (this.fUk != null && this.fUk.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.fUk != null && this.fUk.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.iXH.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.iYa.setVisibility(0);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iYa.setVisibility(8);
                    return;
            }
        }
    }

    private void czy() {
        this.iYf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.iYf.setLayoutParams(layoutParams);
        this.iYf.setOnFocusChangeListener(this.iXY);
    }

    private void czz() {
        if (this.iXH != null && this.iXH.getType() == 0 && this.iXH.getType() == 9 && !this.jTh && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && czH() != null) {
                czH().setText(cutStringWithSuffix);
                czH().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void czA() {
        this.jTt = null;
        this.jTv = -1;
        this.jTx = -1;
        x qH = w.blA().qH(1);
        if (qH != null) {
            this.jTt = qH.fym;
            this.jTv = getIntent().getIntExtra("category_id", -1);
            if (this.jTt != null && !this.jTt.isEmpty() && this.jTv >= 0) {
                this.jTu = new v();
                this.jTu.fyi = 0;
                this.jTu.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jTx = this.jTu.fyi;
                this.jTw = this.jTu.name;
                for (v vVar : this.jTt) {
                    if (vVar.fyi == this.jTv) {
                        this.jTx = vVar.fyi;
                        this.jTw = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void czB() {
        if (this.jTt != null && !this.jTt.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jTy = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jTy.setText(this.jTw);
            this.jTy.setCategoryContainerData(this.jTt, this.jTu, this.jTx);
            this.jTy.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jTy.setText(arVar.name);
                        TransmitPostEditActivity.this.iXH.setCategoryTo(arVar.fyi);
                        TransmitPostEditActivity.this.jTx = arVar.fyi;
                        TransmitPostEditActivity.this.jTy.czc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jTy.czb();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czG());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jTN = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jTN.setTitle(R.string.no_disturb_start_time);
        this.jTN.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jTN);
        this.jTN.setButton(-2, getPageContext().getString(R.string.cancel), this.jTN);
        return this.jTN;
    }

    private void czC() {
        this.jTp = (RelativeLayout) findViewById(R.id.addition_container);
        this.jTq = (TextView) findViewById(R.id.addition_create_time);
        this.jTr = (TextView) findViewById(R.id.addition_last_time);
        this.jTs = (TextView) findViewById(R.id.addition_last_content);
        if (this.jTo != null) {
            this.jTp.setVisibility(0);
            this.jTq.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.jTo.getCreateTime() * 1000));
            if (this.jTo.getAlreadyCount() == 0) {
                this.jTr.setVisibility(8);
            } else {
                this.jTr.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.jTo.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jTo.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jTs.setText(lastAdditionContent);
            } else {
                this.jTs.setVisibility(8);
            }
            czG().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jTo.getAlreadyCount()), Integer.valueOf(this.jTo.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jTp.setVisibility(8);
    }

    private void clf() {
        this.iYj = findViewById(R.id.post_prefix_layout);
        this.iYg = (TextView) findViewById(R.id.post_prefix);
        this.jTl = findViewById(R.id.prefix_divider);
        this.iYi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iYj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iXI = 1;
            this.iYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iYg.setVisibility(0);
                    TransmitPostEditActivity.this.iYj.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iYh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.cEt.asA();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYa);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iYe);
                }
            });
            this.iYi = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.iYi.setVisibility(0);
                this.iYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iYg.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iYh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.cEt.asA();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czH());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czG());
                    }
                });
            }
            this.iYh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iYh.a(this);
            this.iYh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.iYh.setOutsideTouchable(true);
            this.iYh.setFocusable(true);
            this.iYh.setOnDismissListener(this);
            this.iYh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.iYg, R.color.cp_bg_line_d);
            am.setImageResource(this.iYi, R.drawable.icon_frs_arrow_n);
            this.iYg.setTextColor(color);
            this.jTm.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jTm.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iYh.addView(writePrefixItemLayout);
            }
            this.iYh.setCurrentIndex(0);
            this.iYg.setText(prefixs.get(1));
            BL(1);
            return;
        }
        this.iYj.setVisibility(8);
    }

    protected void czD() {
        this.iYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jTF.a(TransmitPostEditActivity.this.iYa, TransmitPostEditActivity.this.iYe)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jTF.cxA());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.czG());
                    TransmitPostEditActivity.this.cEt.asA();
                    TiebaStatic.log(new an("c12608").O("obj_locate", 7));
                    TransmitPostEditActivity.this.czN();
                }
            }
        });
    }

    protected void clg() {
        this.iYa = (EditText) findViewById(R.id.post_title);
        this.iYa.setOnClickListener(this.jTJ);
        this.iYa.setOnFocusChangeListener(this.iXY);
        if ((this.iXH.getType() == 0 || this.iXH.getType() == 9 || this.iXH.getType() == 7) && this.iXH.getTitle() != null) {
            this.iYa.setText(this.iXH.getTitle());
            this.iYa.setSelection(this.iXH.getTitle().length());
        }
        this.iYa.addTextChangedListener(this.jTL);
        if (!this.iXH.getHaveDraft()) {
            czz();
        }
        this.iYa.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cli() {
        this.iYe = (EditText) findViewById(R.id.post_content);
        this.iYe.setDrawingCacheEnabled(false);
        this.iYe.setOnClickListener(this.jTJ);
        if (this.iXH.getContent() != null && this.iXH.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avr().ah(getPageContext().getPageActivity(), this.iXH.getContent());
            this.iYe.setText(ah);
            this.iYe.setSelection(ah.length());
        }
        this.iYe.setOnFocusChangeListener(this.iXY);
        this.iYe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iYe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYe.addTextChangedListener(this.jTM);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iYe.setHint(R.string.share_video_default);
        } else {
            this.iYe.setHint(R.string.share_txt_default);
        }
    }

    private void czE() {
        this.GL = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.GL.setVisibility(0);
        this.GL.b(this.mOriginalThreadInfo);
        this.GL.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czF() {
        int i = 5000;
        if (this.jTo != null) {
            i = 1000;
        }
        return czG().getText() != null && czG().getText().length() >= i;
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTf)) {
                this.jTf = "";
                czG().requestFocus();
                if (czG().getText() != null && czG().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czG().getSelectionStart();
                    editable = czG().getText();
                }
            } else if ("from_title".equals(this.jTf)) {
                this.jTf = "";
                czH().requestFocus();
                if (czH().getText() != null && czH().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czH().getSelectionStart();
                    editable = czH().getText();
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
            if (this.iXH != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.toLong(this.iXH.getForumId(), 0L), this.iXH.getFirstDir(), this.iXH.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) czG().getText().getSpans(0, czG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jTn == null) {
                this.jTn = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jTn.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType apk = pVar.apk();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fT().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.czG().getSelectionStart(), aVar, apk);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && czG() != null && czG().getText() != null) {
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
                int selectionStart = czG().getSelectionStart() - 1;
                if (czG().getText().length() > 1 && selectionStart >= 0 && czG().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    czG().getText().insert(czG().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            czG().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                czG().getText().insert(czG().getSelectionStart(), spannableString2);
            }
            Editable text = czG().getText();
            if (text != null) {
                this.jTD.clear();
                this.jTD.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTD);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && czG().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    czG().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                czG().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czG() {
        return this.iYe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czH() {
        return this.iYa;
    }

    protected void czI() {
        Editable text;
        if (czG() != null && (text = czG().getText()) != null) {
            int selectionStart = czG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czG().onKeyDown(67, this.fgG);
            }
            czG().onKeyDown(67, this.fgG);
            int selectionStart2 = czG().getSelectionStart();
            this.jTD.clear();
            this.jTD.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jTD);
            czG().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cNJ.setCancelListener(null);
        this.cNJ.setTipString(R.string.sending);
        this.cNJ.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cNJ.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        if (this.iXH != null) {
            String str = "";
            String str2 = "";
            if (czH() != null) {
                str = czH().getText().toString();
            }
            if (czG() != null) {
                str2 = czG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.iXH.getType() == 0 || this.iXH.getType() == 9 || this.iXH.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iXI == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.iXH.setIsNoTitle(true);
                        } else {
                            this.iXH.setIsNoTitle(false);
                            rW(true);
                            return;
                        }
                    } else {
                        this.iXH.setIsNoTitle(false);
                        rW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.iXH.setIsNoTitle(true);
                } else {
                    this.iXH.setIsNoTitle(false);
                    rW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jTA) {
                    rW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rW(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                rW(true);
            } else if (this.iXH.getVideoInfo() != null) {
                rW(true);
            } else {
                rW(false);
            }
        }
    }

    private void rW(boolean z) {
        am.setNavbarTitleColor(this.iYf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.cFZ = new NewWriteModel(this);
        this.cFZ.b(this.cGo);
        this.flB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.ckY();
            }
        };
        this.iXH = new WriteData();
        if (bundle != null) {
            this.iXH.setType(bundle.getInt("type", 0));
            this.iXH.setForumId(bundle.getString("forum_id"));
            this.iXH.setForumName(bundle.getString("forum_name"));
            this.iXH.setFirstDir(bundle.getString("forum_first_dir"));
            this.iXH.setSecondDir(bundle.getString("forum_second_dir"));
            this.iXH.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jTo = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.iXH.setIsAddition(this.jTo != null);
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
            this.iXH.setTitle(bundle.getString("write_title"));
            this.iXH.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.fUk = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.class);
            }
            str = string;
        } else {
            Intent intent = getIntent();
            this.iXH.setType(intent.getIntExtra("type", 0));
            this.iXH.setForumId(intent.getStringExtra("forum_id"));
            this.iXH.setForumName(intent.getStringExtra("forum_name"));
            this.iXH.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.iXH.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.iXH.setThreadId(intent.getStringExtra("thread_id"));
            this.jTo = (AdditionData) intent.getSerializableExtra("addition_data");
            this.iXH.setIsAddition(this.jTo != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.iXH.setTitle(intent.getStringExtra("write_title"));
            this.iXH.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fUk = intent.getStringExtra("KEY_CALL_FROM");
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
        this.writeImagesInfo.setMaxImagesAllowed(this.iXH.getType() == 4 ? 6 : 9);
        this.iXH.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.iXH.setVideoId(this.mOriginalThreadInfo.videoId);
            this.iXH.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.iXH.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.iXH != null && this.iXH.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.iXH.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jTh = true;
        }
        czA();
    }

    private void czJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iYa.setText(com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName)));
            this.iYa.setMovementMethod(com.baidu.tieba.view.c.cwN());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString qf = com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName));
            if (qf != null) {
                this.iYa.setText(qf);
            }
            this.jTC.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.iXH.getType());
        bundle.putString("forum_id", this.iXH.getForumId());
        bundle.putString("forum_name", this.iXH.getForumName());
        bundle.putString("forum_first_dir", this.iXH.getFirstDir());
        bundle.putString("forum_second_dir", this.iXH.getSecondDir());
        bundle.putString("thread_id", this.iXH.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.jTo != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jTo));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fUk);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = czG().getEditableText().toString();
        if (obj != null) {
            czG().setText(TbFaceManager.avr().a(getPageContext().getPageActivity(), obj, this.jTH));
            czG().setSelection(czG().getText().length());
        }
    }

    private String czK() {
        if (czG() == null || czG().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(czG().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return czG().getText().toString();
    }

    private String czL() {
        if (this.iXH == null || czH() == null || czH().getVisibility() != 0 || czH().getText() == null) {
            return "";
        }
        String obj = czH().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.iXI != 0 && this.iXH.getType() != 4 && this.iYg != null && this.iYg.getText() != null) {
            obj = this.iYg.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.iXH.getTitle();
        }
        return obj;
    }

    private void czM() {
        ckY();
        this.iXH.setContent(czK());
        this.iXH.setTitle(czL());
        if (this.jTv >= 0) {
            this.iXH.setCategoryFrom(this.jTv);
        }
        if (this.jTx >= 0) {
            this.iXH.setCategoryTo(this.jTx);
        }
        this.iXH.setWriteImagesInfo(this.writeImagesInfo);
        this.iXH.setHasLocationData(this.cFY != null && this.cFY.aWP());
        this.cFZ.qV(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.jTB != null && this.jTB.mIsGlobalBlock == 0) {
            this.iXH.setForumId(String.valueOf(this.jTB.mForumId));
            this.iXH.setForumName(this.jTB.mForumName);
        }
        this.cFZ.d(this.iXH);
        this.iXH.setContent(this.iXH.getContent().replaceAll("\u0000\n", ""));
        this.iXH.setContent(this.iXH.getContent().replaceAll("\u0000", ""));
        this.iXH.setVcode(null);
        this.cFZ.cla().setVoice(null);
        this.cFZ.cla().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.flB);
        this.cFZ.cpC();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jTo != null) {
                i2 = this.jTo.getTotalCount();
                i = this.jTo.getAlreadyCount() + 1;
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
                if (this.cEt != null && !this.cEt.atZ()) {
                    czG().requestFocus();
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
                            czG().getText().insert(czG().getSelectionStart(), sb.toString());
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
                        if (this.jTg) {
                            sb2.append(com.baidu.tbadk.plugins.b.cNd);
                            this.jTg = false;
                        }
                        sb2.append(stringExtra);
                        pF(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.jTB = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.jTB);
            }
        } else if (i2 == 0) {
            if (this.cEt != null && !this.cEt.atZ()) {
                this.iYe.requestFocus();
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
                        this.jTF.Fv(postWriteCallBackData.getErrorString());
                        this.jTF.aM(postWriteCallBackData.getSensitiveWords());
                        this.jTF.b(this.iYa, this.iYe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.jTf)) {
                        czH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTf)) {
                        czG().requestFocus();
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
    public void czN() {
        if ("1".equals(this.fUk)) {
            this.iXH.setCanNoForum(true);
            this.iXH.setTransmitForumData("[]");
        } else if ("2".equals(this.fUk)) {
            this.iXH.setCanNoForum(false);
        }
        czO();
        this.iXH.setPrivacy(this.isPrivacy);
        this.iXH.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.iXH.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.iXH.setCallFrom(this.fUk);
        czM();
    }

    private void czO() {
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, czH());
        HidenSoftKeyPad(this.mInputManager, czG());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvK) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.iXH.getType() != 7) {
                if (this.jTo == null) {
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
        this.cGf = i;
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czP() {
        if (!this.jTA && this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.cEt.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void BL(int i) {
        if (i < this.jTm.size()) {
            for (int i2 = 0; i2 < this.jTm.size(); i2++) {
                this.jTm.get(i2).rO(false);
            }
            this.jTm.get(i).rO(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void zv(int i) {
        this.iXI = i;
        this.iYh.setCurrentIndex(i);
        BL(i);
        this.iYg.setText(this.mPrefixData.getPrefixs().get(i));
        clh();
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iYj.setSelected(false);
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
        if (this.iXH != null) {
            if (this.iXH.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.iXH.getType() == 5) {
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
            auz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aii = z;
        if (this.jTE != null && !z) {
            this.jTE.beG();
        }
        if (this.jTG != null && !z) {
            czs();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aii && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTg = false;
            this.jTf = "";
            if ("from_content".equals(str)) {
                this.jTf = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTf = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qe(String.valueOf(charSequence.charAt(i)))) {
                rV(false);
            }
        }
    }

    public void cgy() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
            this.jTj.setVisibility(0);
            this.jTj.requestFocus();
            this.cEt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jTj.setVisibility(8);
    }
}
