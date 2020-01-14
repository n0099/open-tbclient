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
import android.os.Build;
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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.k.a.a;
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
import com.baidu.tbadk.core.data.BaijiahaoData;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
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
/* loaded from: classes11.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0072a, h.a {
    private OriginalThreadCardView LX;
    private EditorTools dsz;
    private LocationModel due;
    private NewWriteModel duf;
    private String gko;
    private String gkp;
    private boolean isPrivacy;
    private int jVJ;
    private TextView jWg;
    private com.baidu.tieba.write.h jWh;
    private ImageView jWi;
    private View jWj;
    private OriginalThreadInfo.ShareInfo kRB;
    private LinearLayout kRD;
    private LinearLayout kRE;
    private View kRG;
    private Toast kRI;
    private AdditionData kRJ;
    private RelativeLayout kRK;
    private TextView kRL;
    private TextView kRM;
    private TextView kRN;
    List<w> kRO;
    w kRP;
    private int kRQ;
    private String kRR;
    private int kRS;
    private PostCategoryView kRT;
    private HotTopicBussinessData kRW;
    private TextView kRX;
    private com.baidu.tieba.write.editor.b kRZ;
    private e kSb;
    private com.baidu.tieba.view.b kSi;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kRz = "";
    private boolean kRA = false;
    private WriteData jVI = null;
    private boolean kRC = false;
    private InputMethodManager mInputManager = null;
    private EditText jWa = null;
    private View jWb = null;
    private LinearLayout jWd = null;
    private EditText jWe = null;
    private FeedBackModel kRF = null;
    private ArrayList<WritePrefixItemLayout> kRH = new ArrayList<>();
    private final KeyEvent fYt = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jWf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gdj = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout hpY = null;
    private String duj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int duk = 0;
    private View mRootView = null;
    private ScrollView kRU = null;
    private boolean kRV = false;
    private com.baidu.tbadk.core.view.a dBR = null;
    private String mFrom = "write";
    private String gLX = "2";
    private SpannableStringBuilder kRY = new SpannableStringBuilder();
    private boolean aqT = false;
    private final b kSa = new b();
    private TbFaceManager.a kSc = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ve(String str) {
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
            return new com.baidu.tbadk.core.view.f(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a gnp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jVI != null) {
                TransmitPostEditActivity.this.kSa.aV(null);
                if (z) {
                    TransmitPostEditActivity.this.gC(z);
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
                    TransmitPostEditActivity.this.kSa.Kx(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kSa.aV(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kSa.b(TransmitPostEditActivity.this.jWa, TransmitPostEditActivity.this.jWe);
                } else if ((zVar == null || writeData == null || zVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (zVar != null && writeData != null && zVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(zVar.getVcode_md5());
                    writeData.setVcodeUrl(zVar.getVcode_pic_url());
                    writeData.setVcodeExtra(zVar.aHl());
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dur = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aMM() {
            TransmitPostEditActivity.this.showToast(R.string.no_network_guide);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(R.string.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cKe())) {
                TransmitPostEditActivity.this.a(2, true, aVar.cKe());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener khS = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.due.sM(false);
                    TransmitPostEditActivity.this.due.ex(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.due.sM(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSd = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSe = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cUt = TransmitPostEditActivity.this.cUt();
            if (cUt >= 0 && cUt < TransmitPostEditActivity.this.jWe.getText().length()) {
                TransmitPostEditActivity.this.jWe.setSelection(cUt);
            }
        }
    };
    private boolean kSf = true;
    private final View.OnFocusChangeListener eSe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jWa || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jWf) {
                if (z) {
                    TransmitPostEditActivity.this.kSf = true;
                    TransmitPostEditActivity.this.cUu();
                    if (TransmitPostEditActivity.this.dsz != null) {
                        TransmitPostEditActivity.this.dsz.aKs();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jWa);
                } else if (view == TransmitPostEditActivity.this.jWa) {
                    TransmitPostEditActivity.this.jWg.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jWe && z) {
                TransmitPostEditActivity.this.kSf = false;
                TransmitPostEditActivity.this.cUu();
                TransmitPostEditActivity.this.dsz.aKs();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jWe);
            }
            TransmitPostEditActivity.this.cUz();
        }
    };
    private TextWatcher kSg = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kSk = "";
        private String kSl;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSl = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSl != null ? this.kSl.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cGv();
            TransmitPostEditActivity.this.cUA();
            EditText cUL = TransmitPostEditActivity.this.cUL();
            if (editable != null && cUL != null && cUL.getText() != null) {
                if (this.kSk == null || !this.kSk.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSa != null) {
                        this.kSk = cUL.getText().toString();
                        TransmitPostEditActivity.this.kSa.b(cUL, true);
                        return;
                    }
                    return;
                }
                cUL.setSelection(cUL.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSh = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kSl;
        private String kSm = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSl = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSl != null ? this.kSl.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cGv();
            EditText cUK = TransmitPostEditActivity.this.cUK();
            if (editable != null && cUK != null && cUK.getText() != null) {
                int selectionEnd = cUK.getSelectionEnd();
                if (this.kSm == null || !this.kSm.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSa != null) {
                        this.kSm = cUK.getText().toString();
                        TransmitPostEditActivity.this.kSa.b(cUK, false);
                        return;
                    }
                    return;
                }
                cUK.setSelection(selectionEnd);
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
    public void aMw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aMx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due.cKl()) {
            aMw();
        } else {
            this.due.sM(false);
            a(1, true, (String) null);
            this.due.cKj();
        }
    }

    private void aMz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.due.cKn();
                } else {
                    TransmitPostEditActivity.this.dur.aMM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cUt() {
        int selectionEnd = cUK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cUK().getText().getSpans(0, cUK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cUK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cUK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUu() {
        if (this.dsz != null) {
            this.dsz.setBarLauncherEnabled(!this.kSf);
            this.dsz.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kRV) {
            this.jWa.setVisibility(8);
            cGv();
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
        this.due = new LocationModel(getPageContext());
        this.due.a(this.dur);
        registerListener(this.khS);
        registerListener(this.kSd);
        ceg();
        this.jWe.requestFocus();
        cBJ();
        cUT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void ceg() {
        this.dsz = new EditorTools(getActivity());
        this.dsz.setBarMaxLauCount(4);
        this.dsz.setMoreButtonAtEnd(true);
        this.dsz.setBarLauncherType(1);
        this.dsz.gu(true);
        this.dsz.gv(true);
        this.dsz.setBackgroundColorId(R.color.cp_bg_line_h);
        cUv();
        this.dsz.build();
        if (this.kRD != null) {
            this.kRD.addView(this.dsz);
        }
        bYm();
        this.dsz.display();
        com.baidu.tbadk.editortools.g lU = this.dsz.lU(6);
        if (lU != null && !TextUtils.isEmpty(this.duj)) {
            ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.duj);
                }
            });
        }
        if (!this.kRV) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dsz.aKs();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jVI.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jVI.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cUx();
    }

    private void cUv() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dsz.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dsz.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dtj = 4;
            lVar.dtf = R.drawable.icon_post_location_selector;
            lVar.dth = false;
            this.dsz.b(lVar);
        }
        if (this.kRJ == null) {
            if (this.kRZ == null) {
                this.kRZ = new com.baidu.tieba.write.editor.b(getActivity(), this.gLX);
                this.kRZ.cTw();
                this.kRZ.setFrom("from_share_write");
                this.kRZ.bA(this.jVI.getForumId(), this.mPrivateThread);
            }
            this.dsz.b(this.kRZ);
        }
        this.dsz.aI(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsz.lX(5);
        if (lX != null) {
            lX.dtj = 1;
        }
    }

    private void bYm() {
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
                            TiebaStatic.log(new an("c12608").Z("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.cUJ()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cUJ()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cUM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cGv();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kRJ == null) {
                            TransmitPostEditActivity.this.aMA();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.duk) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aMx();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aMw();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.due != null) {
                            TransmitPostEditActivity.this.due.sM(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jVI != null) {
                            str = TransmitPostEditActivity.this.jVI.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cp("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jVI == null || (videoInfo = TransmitPostEditActivity.this.jVI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dsz.aLX()) {
                                        TransmitPostEditActivity.this.dsz.aKs();
                                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jVI.setVideoInfo(null);
                        TransmitPostEditActivity.this.cGv();
                        if (TransmitPostEditActivity.this.jWe != null) {
                            TransmitPostEditActivity.this.jWe.requestFocus();
                        }
                        TransmitPostEditActivity.this.dsz.aKs();
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jWe);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kRA = true;
                        TransmitPostEditActivity.this.tO(true);
                        if (TransmitPostEditActivity.this.cUL().isFocused()) {
                            TransmitPostEditActivity.this.kRz = "from_title";
                        } else if (TransmitPostEditActivity.this.cUK().isFocused()) {
                            TransmitPostEditActivity.this.kRz = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kRE.setVisibility(0);
                        TransmitPostEditActivity.this.kRE.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kRE.hasFocus()) {
                            TransmitPostEditActivity.this.jWe.requestFocus();
                            TransmitPostEditActivity.this.jWe.setSelection(TransmitPostEditActivity.this.jWe.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kRE.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dsz.setActionListener(31, bVar);
        this.dsz.setActionListener(16, bVar);
        this.dsz.setActionListener(14, bVar);
        this.dsz.setActionListener(24, bVar);
        this.dsz.setActionListener(3, bVar);
        this.dsz.setActionListener(10, bVar);
        this.dsz.setActionListener(11, bVar);
        this.dsz.setActionListener(12, bVar);
        this.dsz.setActionListener(13, bVar);
        this.dsz.setActionListener(15, bVar);
        this.dsz.setActionListener(18, bVar);
        this.dsz.setActionListener(20, bVar);
        this.dsz.setActionListener(25, bVar);
        this.dsz.setActionListener(27, bVar);
        this.dsz.setActionListener(29, bVar);
        this.dsz.setActionListener(43, bVar);
        this.dsz.setActionListener(45, bVar);
        this.dsz.setActionListener(53, bVar);
        this.dsz.setActionListener(48, bVar);
        this.dsz.setActionListener(46, bVar);
        this.dsz.setActionListener(49, bVar);
        this.dsz.setActionListener(47, bVar);
        this.dsz.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        if (this.due.bpD()) {
            if (this.due.cKl()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cKg().getLocationData().cKe());
                return;
            }
            a(1, true, (String) null);
            this.due.cKj();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cGm() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
        if (this.kRF != null) {
            this.kRF.cancelLoadData();
        }
        if (this.due != null) {
            this.due.cancelLoadData();
        }
    }

    private void cUw() {
        if (this.kSb != null) {
            this.kSb.hideTip();
        }
    }

    private void cUx() {
        if (this.kSb == null) {
            this.kSb = new e(getPageContext());
        }
        this.kSb.c(this.dsz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cUw();
        TiebaPrepareImageService.StopService();
        cGm();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUy() {
        if (this.jVI == null) {
            finish();
            return;
        }
        this.jVI.setTitle(cUL().getText().toString());
        this.jVI.setContent(cUK().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jWh != null && this.jWh.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jWh, getPageContext().getPageActivity());
                return true;
            } else if (this.dsz.aLX()) {
                this.dsz.aKs();
                return true;
            } else {
                cGm();
                cUy();
                return true;
            }
        }
        if (i == 67 && (text = cUK().getText()) != null) {
            int selectionStart = cUK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cUK().onKeyDown(67, this.fYt);
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
        getLayoutMode().onModeChanged(this.hpY);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jWf, R.color.cp_link_tip_a, 1);
        cUu();
        am.setBackgroundColor(this.jWb, R.color.cp_bg_line_c);
        am.setBackgroundColor(cUL(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cUK(), R.color.cp_bg_line_d);
        cGv();
        this.dsz.onChangeSkinType(i);
        if (this.kRT != null) {
            this.kRT.aFw();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cUz();
        cUA();
        if (this.kSa != null) {
            this.kSa.c(cUL(), cUK());
        }
        this.LX.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUz() {
        if (this.jWa.hasFocus()) {
            this.jWa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jWa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jWe.hasFocus()) {
            this.jWe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jWe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUA() {
        if (this.jWa != null) {
            if (this.jWa.getText().toString().length() == 0) {
                this.jWa.getPaint().setFakeBoldText(false);
            } else if (this.jWa.getText().toString().length() > 0) {
                this.jWa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dBR = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kRV = this.jVI.getType() == 4 || 5 == this.jVI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cUC();
        this.kRU = (ScrollView) findViewById(R.id.write_scrollview);
        this.kRU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jWe != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jWe);
                    }
                    if (TransmitPostEditActivity.this.dsz != null) {
                        TransmitPostEditActivity.this.dsz.aKs();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hpY = (RelativeLayout) findViewById(R.id.parent);
        this.kRD = (LinearLayout) findViewById(R.id.tool_view);
        this.kRD.setContentDescription(IStringUtil.TOP_PATH);
        this.kRE = (LinearLayout) findViewById(R.id.title_view);
        this.jWb = findViewById(R.id.interval_view);
        this.kRX = (TextView) findViewById(R.id.hot_topic_title_edt);
        cGu();
        if (this.kRV) {
            this.kRU.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cGw();
        cUI();
        this.jWd = (LinearLayout) findViewById(R.id.post_content_container);
        this.jWd.setDrawingCacheEnabled(false);
        this.jWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jWe.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eSe);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cGm();
                TransmitPostEditActivity.this.cUy();
            }
        });
        cUF();
        cUH();
        cUB();
        cUu();
        cUG();
        cGt();
        cUN();
        if (this.jVI.getType() == 4 && this.jWj != null && this.kRG != null) {
            this.jWj.setVisibility(8);
            this.kRG.setVisibility(8);
        }
        cGv();
        ShowSoftKeyPad(this.mInputManager, this.jWa);
    }

    private void cUB() {
        String str;
        String str2;
        if (this.jVI != null) {
            switch (this.jVI.getType()) {
                case 0:
                case 9:
                    if (this.gLX != null && this.gLX.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gLX != null && this.gLX.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jVI.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jWa.setVisibility(0);
                    this.jWe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jWe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jWe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jWa.setVisibility(8);
                    return;
            }
        }
    }

    private void cUC() {
        this.jWf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jWf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jWf.setLayoutParams(layoutParams);
        this.jWf.setOnFocusChangeListener(this.eSe);
    }

    private void cUD() {
        if (this.jVI != null && this.jVI.getType() == 0 && this.jVI.getType() == 9 && !this.kRC && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cUL() != null) {
                cUL().setText(cutStringWithSuffix);
                cUL().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cUE() {
        this.kRO = null;
        this.kRQ = -1;
        this.kRS = -1;
        y sS = x.bDY().sS(1);
        if (sS != null) {
            this.kRO = sS.gpS;
            this.kRQ = getIntent().getIntExtra("category_id", -1);
            if (this.kRO != null && !this.kRO.isEmpty() && this.kRQ >= 0) {
                this.kRP = new w();
                this.kRP.gpO = 0;
                this.kRP.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kRS = this.kRP.gpO;
                this.kRR = this.kRP.name;
                for (w wVar : this.kRO) {
                    if (wVar.gpO == this.kRQ) {
                        this.kRS = wVar.gpO;
                        this.kRR = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cUF() {
        if (this.kRO != null && !this.kRO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kRT = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kRT.setText(this.kRR);
            this.kRT.setCategoryContainerData(this.kRO, this.kRP, this.kRS);
            this.kRT.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        TransmitPostEditActivity.this.kRT.setText(asVar.name);
                        TransmitPostEditActivity.this.jVI.setCategoryTo(asVar.gpO);
                        TransmitPostEditActivity.this.kRS = asVar.gpO;
                        TransmitPostEditActivity.this.kRT.cUh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kRT.cUg();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUK());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSi = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSi.setTitle(R.string.no_disturb_start_time);
        this.kSi.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSi);
        this.kSi.setButton(-2, getPageContext().getString(R.string.cancel), this.kSi);
        return this.kSi;
    }

    private void cUG() {
        this.kRK = (RelativeLayout) findViewById(R.id.addition_container);
        this.kRL = (TextView) findViewById(R.id.addition_create_time);
        this.kRM = (TextView) findViewById(R.id.addition_last_time);
        this.kRN = (TextView) findViewById(R.id.addition_last_content);
        if (this.kRJ != null) {
            this.kRK.setVisibility(0);
            this.kRL.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kRJ.getCreateTime() * 1000));
            if (this.kRJ.getAlreadyCount() == 0) {
                this.kRM.setVisibility(8);
            } else {
                this.kRM.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kRJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kRJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kRN.setText(lastAdditionContent);
            } else {
                this.kRN.setVisibility(8);
            }
            cUK().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kRJ.getAlreadyCount()), Integer.valueOf(this.kRJ.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kRK.setVisibility(8);
    }

    private void cGt() {
        this.jWj = findViewById(R.id.post_prefix_layout);
        this.jWg = (TextView) findViewById(R.id.post_prefix);
        this.kRG = findViewById(R.id.prefix_divider);
        this.jWi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jWj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jVJ = 1;
            this.jWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jWg.setVisibility(0);
                    TransmitPostEditActivity.this.jWj.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jWh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dsz.aKs();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jWa);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jWe);
                }
            });
            this.jWi = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jWi.setVisibility(0);
                this.jWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jWg.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jWh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dsz.aKs();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUL());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUK());
                    }
                });
            }
            this.jWh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jWh.a(this);
            this.jWh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jWh.setOutsideTouchable(true);
            this.jWh.setFocusable(true);
            this.jWh.setOnDismissListener(this);
            this.jWh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jWg, R.color.cp_bg_line_d);
            am.setImageResource(this.jWi, R.drawable.icon_frs_arrow_n);
            this.jWg.setTextColor(color);
            this.kRH.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kRH.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jWh.addView(writePrefixItemLayout);
            }
            this.jWh.setCurrentIndex(0);
            this.jWg.setText(prefixs.get(1));
            En(1);
            return;
        }
        this.jWj.setVisibility(8);
    }

    protected void cUH() {
        this.jWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cUU()) {
                    if (TransmitPostEditActivity.this.kSa.a(TransmitPostEditActivity.this.jWa, TransmitPostEditActivity.this.jWe)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kSa.cSQ());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cUK());
                    TransmitPostEditActivity.this.dsz.aKs();
                    TiebaStatic.log(new an("c12608").Z("obj_locate", 7));
                    TransmitPostEditActivity.this.cUR();
                }
            }
        });
    }

    protected void cGu() {
        this.jWa = (EditText) findViewById(R.id.post_title);
        this.jWa.setOnClickListener(this.kSe);
        this.jWa.setOnFocusChangeListener(this.eSe);
        if ((this.jVI.getType() == 0 || this.jVI.getType() == 9 || this.jVI.getType() == 7) && this.jVI.getTitle() != null) {
            this.jWa.setText(this.jVI.getTitle());
            this.jWa.setSelection(this.jVI.getTitle().length());
        }
        this.jWa.addTextChangedListener(this.kSg);
        if (!this.jVI.getHaveDraft()) {
            cUD();
        }
        this.jWa.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cGw() {
        this.jWe = (EditText) findViewById(R.id.post_content);
        this.jWe.setDrawingCacheEnabled(false);
        this.jWe.setOnClickListener(this.kSe);
        if (this.jVI.getContent() != null && this.jVI.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aNr().aB(getPageContext().getPageActivity(), this.jVI.getContent());
            this.jWe.setText(aB);
            this.jWe.setSelection(aB.length());
        }
        if (!aq.isEmpty(this.gko)) {
            this.jWe.setSelection(0);
        }
        this.jWe.setOnFocusChangeListener(this.eSe);
        this.jWe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jWe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jWe.addTextChangedListener(this.kSh);
        if (this.kRB != null && this.kRB.showType == 3) {
            this.jWe.setHint(R.string.share_video_default);
        } else {
            this.jWe.setHint(R.string.share_txt_default);
        }
    }

    private void cUI() {
        this.LX = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.LX.setVisibility(0);
        this.LX.a(this.kRB);
        this.LX.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cUJ() {
        int i = 5000;
        if (this.kRJ != null) {
            i = 1000;
        }
        return cUK().getText() != null && cUK().getText().length() >= i;
    }

    private void uQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kRz)) {
                this.kRz = "";
                cUK().requestFocus();
                if (cUK().getText() != null && cUK().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cUK().getSelectionStart();
                    editable = cUK().getText();
                }
            } else if ("from_title".equals(this.kRz)) {
                this.kRz = "";
                cUL().requestFocus();
                if (cUL().getText() != null && cUL().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cUL().getSelectionStart();
                    editable = cUL().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jVI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jVI.getForumId(), 0L), this.jVI.getFirstDir(), this.jVI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cUK().getText().getSpans(0, cUK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kRI == null) {
                this.kRI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kRI.getView().isShown()) {
                this.kRI.cancel();
            }
            this.kRI.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType aHc = pVar.aHc();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cUK().getSelectionStart(), aVar, aHc);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cUK() != null && cUK().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = 55;
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cUK().getSelectionStart() - 1;
                if (cUK().getText().length() > 1 && selectionStart >= 0 && cUK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cUK().getText().insert(cUK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cUK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cUK().getText().insert(cUK().getSelectionStart(), spannableString2);
            }
            Editable text = cUK().getText();
            if (text != null) {
                this.kRY.clear();
                this.kRY.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kRY);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cUK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cUK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cUK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cUK() {
        return this.jWe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cUL() {
        return this.jWa;
    }

    protected void cUM() {
        Editable text;
        if (cUK() != null && (text = cUK().getText()) != null) {
            int selectionStart = cUK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cUK().onKeyDown(67, this.fYt);
            }
            cUK().onKeyDown(67, this.fYt);
            int selectionStart2 = cUK().getSelectionStart();
            this.kRY.clear();
            this.kRY.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kRY);
            cUK().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dBR.setCancelListener(null);
        this.dBR.setTipString(R.string.sending);
        this.dBR.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dBR.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGv() {
        if (this.jVI != null) {
            String str = "";
            String str2 = "";
            if (cUL() != null) {
                str = cUL().getText().toString();
            }
            if (cUK() != null) {
                str2 = cUK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jVI.getType() == 0 || this.jVI.getType() == 9 || this.jVI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jVJ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jVI.setIsNoTitle(true);
                        } else {
                            this.jVI.setIsNoTitle(false);
                            tP(true);
                            return;
                        }
                    } else {
                        this.jVI.setIsNoTitle(false);
                        tP(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jVI.setIsNoTitle(true);
                } else {
                    this.jVI.setIsNoTitle(false);
                    tP(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kRV) {
                    tP(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tP(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tP(true);
            } else if (this.jVI.getVideoInfo() != null) {
                tP(true);
            } else {
                tP(false);
            }
        }
    }

    private void tP(boolean z) {
        am.setNavbarTitleColor(this.jWf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.duf = new NewWriteModel(this);
        this.duf.b(this.dut);
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cGm();
            }
        };
        this.jVI = new WriteData();
        if (bundle != null) {
            this.jVI.setType(bundle.getInt("type", 0));
            this.jVI.setForumId(bundle.getString("forum_id"));
            this.jVI.setForumName(bundle.getString("forum_name"));
            this.jVI.setFirstDir(bundle.getString("forum_first_dir"));
            this.jVI.setSecondDir(bundle.getString("forum_second_dir"));
            this.jVI.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kRJ = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jVI.setIsAddition(this.kRJ != null);
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
            this.jVI.setTitle(bundle.getString("write_title"));
            this.jVI.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gLX = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kRB = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.gko = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gkp = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = string;
        } else {
            Intent intent = getIntent();
            this.jVI.setType(intent.getIntExtra("type", 0));
            this.jVI.setForumId(intent.getStringExtra("forum_id"));
            this.jVI.setForumName(intent.getStringExtra("forum_name"));
            this.jVI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jVI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jVI.setThreadId(intent.getStringExtra("thread_id"));
            this.kRJ = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jVI.setIsAddition(this.kRJ != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jVI.setTitle(intent.getStringExtra("write_title"));
            this.jVI.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gLX = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kRB = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.gko = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gkp = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jVI.getType() == 4 ? 6 : 9);
        this.jVI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kRB != null && this.kRB.videoId != null) {
            this.jVI.setVideoId(this.kRB.videoId);
            this.jVI.setOriginalVideoCover(this.kRB.showPicUrl);
            this.jVI.setOriginalVideoTitle(this.kRB.showText);
        }
        if (!aq.isEmpty(this.gko)) {
            if (!aq.isEmpty(this.gkp)) {
                this.jVI.setContent("//@" + this.gkp + " :" + this.gko);
            } else {
                this.jVI.setContent(this.gko);
            }
        }
        if (this.jVI != null && this.jVI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jVI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kRC = true;
        }
        cUE();
    }

    private void cUN() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jWa.setText(com.baidu.tbadk.plugins.b.vo(com.baidu.tbadk.plugins.b.vp(hotTopicBussinessData.mTopicName)));
            this.jWa.setMovementMethod(com.baidu.tieba.view.c.cRX());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vo = com.baidu.tbadk.plugins.b.vo(com.baidu.tbadk.plugins.b.vp(hotTopicBussinessData.mTopicName));
            if (vo != null) {
                this.jWa.setText(vo);
            }
            this.kRX.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jVI.getType());
        bundle.putString("forum_id", this.jVI.getForumId());
        bundle.putString("forum_name", this.jVI.getForumName());
        bundle.putString("forum_first_dir", this.jVI.getFirstDir());
        bundle.putString("forum_second_dir", this.jVI.getSecondDir());
        bundle.putString("thread_id", this.jVI.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kRJ != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kRJ));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gLX);
        if (this.kRB != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kRB));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cUK().getEditableText().toString();
        if (obj != null) {
            cUK().setText(TbFaceManager.aNr().a(getPageContext().getPageActivity(), obj, this.kSc));
            cUK().setSelection(cUK().getText().length());
        }
    }

    private String cUO() {
        if (cUK() == null || cUK().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cUK().getText().toString())) {
            if (this.kRB != null && this.kRB.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cUK().getText().toString();
    }

    private String cUP() {
        if (this.jVI == null || cUL() == null || cUL().getVisibility() != 0 || cUL().getText() == null) {
            return "";
        }
        String obj = cUL().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jVJ != 0 && this.jVI.getType() != 4 && this.jWg != null && this.jWg.getText() != null) {
            obj = this.jWg.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jVI.getTitle();
        }
        return obj;
    }

    private void cUQ() {
        cGm();
        this.jVI.setContent(cUO());
        this.jVI.setTitle(cUP());
        if (this.kRQ >= 0) {
            this.jVI.setCategoryFrom(this.kRQ);
        }
        if (this.kRS >= 0) {
            this.jVI.setCategoryTo(this.kRS);
        }
        this.jVI.setWriteImagesInfo(this.writeImagesInfo);
        this.jVI.setHasLocationData(this.due != null && this.due.bpD());
        this.duf.sO(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kRW != null && this.kRW.mIsGlobalBlock == 0) {
            this.jVI.setForumId(String.valueOf(this.kRW.mForumId));
            this.jVI.setForumName(this.kRW.mForumName);
        }
        this.duf.d(this.jVI);
        this.jVI.setContent(this.jVI.getContent().replaceAll("\u0000\n", ""));
        this.jVI.setContent(this.jVI.getContent().replaceAll("\u0000", ""));
        this.jVI.setVcode(null);
        this.duf.cGo().setVoice(null);
        this.duf.cGo().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.gdj);
        this.duf.cKM();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kRJ != null) {
                i2 = this.kRJ.getTotalCount();
                i = this.kRJ.getAlreadyCount() + 1;
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
                if (this.dsz != null && !this.dsz.aLX()) {
                    cUK().requestFocus();
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
                            cUK().getText().insert(cUK().getSelectionStart(), sb.toString());
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
                        if (this.kRA) {
                            sb2.append(com.baidu.tbadk.plugins.b.dBx);
                            this.kRA = false;
                        }
                        sb2.append(stringExtra);
                        uQ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kRW = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kRW);
            }
        } else if (i2 == 0) {
            if (this.dsz != null && !this.dsz.aLX()) {
                this.jWe.requestFocus();
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
                        this.kSa.Kx(postWriteCallBackData.getErrorString());
                        this.kSa.aV(postWriteCallBackData.getSensitiveWords());
                        this.kSa.b(this.jWa, this.jWe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kRz)) {
                        cUL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kRz)) {
                        cUK().requestFocus();
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
    public void cUR() {
        if ("1".equals(this.gLX)) {
            this.jVI.setCanNoForum(true);
            this.jVI.setTransmitForumData("[]");
        } else if ("2".equals(this.gLX)) {
            this.jVI.setCanNoForum(false);
        }
        cUS();
        this.jVI.setPrivacy(this.isPrivacy);
        this.jVI.setIsShareThread(true);
        if (this.kRB != null && !StringUtils.isNull(this.kRB.threadId)) {
            this.jVI.setOriginalThreadId(this.kRB.threadId);
        }
        this.jVI.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kRB != null) {
            this.jVI.setOriBaijiahaoData(this.kRB.oriUgcInfo);
        }
        this.jVI.setCallFrom(this.gLX);
        cUQ();
    }

    private void cUS() {
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cUL());
        HidenSoftKeyPad(this.mInputManager, cUK());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gnp) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jVI.getType() != 7) {
                if (this.kRJ == null) {
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
    public void a(int i, boolean z, String str) {
        this.duk = i;
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cUT() {
        if (!this.kRV && this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dsz.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void En(int i) {
        if (i < this.kRH.size()) {
            for (int i2 = 0; i2 < this.kRH.size(); i2++) {
                this.kRH.get(i2).tG(false);
            }
            this.kRH.get(i).tG(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void BW(int i) {
        this.jVJ = i;
        this.jWh.setCurrentIndex(i);
        En(i);
        this.jWg.setText(this.mPrefixData.getPrefixs().get(i));
        cGv();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jWh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jWj.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes11.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.hideSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jVI != null) {
            if (this.jVI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jVI.getType() == 5) {
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
            aMx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aqT = z;
        if (this.kRZ != null && !z) {
            this.kRZ.bxc();
        }
        if (this.kSb != null && !z) {
            cUw();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aqT && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kRA = false;
            this.kRz = "";
            if ("from_content".equals(str)) {
                this.kRz = "from_content";
            } else if ("from_title".equals(str)) {
                this.kRz = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vn(String.valueOf(charSequence.charAt(i)))) {
                tO(false);
            }
        }
    }

    public void cBJ() {
        if (!v.isEmpty(this.mList)) {
            this.kRE.setVisibility(0);
            this.kRE.requestFocus();
            return;
        }
        this.kRE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cUU() {
        if (((ImageSpan[]) cUK().getText().getSpans(0, cUK().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kRI == null) {
                this.kRI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kRI.getView().isShown()) {
                this.kRI.cancel();
            }
            this.kRI.show();
            return true;
        }
        return false;
    }
}
