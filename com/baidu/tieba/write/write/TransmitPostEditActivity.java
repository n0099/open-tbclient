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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes10.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0072a, h.a {
    private OriginalThreadCardView LR;
    private EditorTools dsn;
    private LocationModel dtT;
    private NewWriteModel dtU;
    private String ghe;
    private String ghf;
    private boolean isPrivacy;
    private com.baidu.tieba.write.h jSA;
    private ImageView jSB;
    private View jSC;
    private int jSb;
    private TextView jSz;
    private OriginalThreadInfo.ShareInfo kNV;
    private LinearLayout kNX;
    private LinearLayout kNY;
    private com.baidu.tieba.view.b kOC;
    private View kOa;
    private Toast kOc;
    private AdditionData kOd;
    private RelativeLayout kOe;
    private TextView kOf;
    private TextView kOg;
    private TextView kOh;
    List<w> kOi;
    w kOj;
    private int kOk;
    private String kOl;
    private int kOm;
    private PostCategoryView kOn;
    private HotTopicBussinessData kOq;
    private TextView kOr;
    private com.baidu.tieba.write.editor.b kOt;
    private e kOv;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kNT = "";
    private boolean kNU = false;
    private WriteData jSa = null;
    private boolean kNW = false;
    private InputMethodManager mInputManager = null;
    private EditText jSt = null;
    private View jSu = null;
    private LinearLayout jSw = null;
    private EditText jSx = null;
    private FeedBackModel kNZ = null;
    private ArrayList<WritePrefixItemLayout> kOb = new ArrayList<>();
    private final KeyEvent fVk = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jSy = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener fZZ = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout hmv = null;
    private String dtY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dtZ = 0;
    private View mRootView = null;
    private ScrollView kOo = null;
    private boolean kOp = false;
    private com.baidu.tbadk.core.view.a dBH = null;
    private String mFrom = "write";
    private String gIK = "2";
    private SpannableStringBuilder kOs = new SpannableStringBuilder();
    private boolean aqh = false;
    private final b kOu = new b();
    private TbFaceManager.a kOw = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan uZ(String str) {
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
    private final AntiHelper.a gkg = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jSa != null) {
                TransmitPostEditActivity.this.kOu.aV(null);
                if (z) {
                    TransmitPostEditActivity.this.gx(z);
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
                    TransmitPostEditActivity.this.kOu.Kn(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kOu.aV(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kOu.b(TransmitPostEditActivity.this.jSt, TransmitPostEditActivity.this.jSx);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aGR());
                    if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dug = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aMt() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cIY())) {
                TransmitPostEditActivity.this.b(2, true, aVar.cIY());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kek = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.dtT.sA(false);
                    TransmitPostEditActivity.this.dtT.ev(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.dtT.sA(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener kOx = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kOy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cTo = TransmitPostEditActivity.this.cTo();
            if (cTo >= 0 && cTo < TransmitPostEditActivity.this.jSx.getText().length()) {
                TransmitPostEditActivity.this.jSx.setSelection(cTo);
            }
        }
    };
    private boolean kOz = true;
    private final View.OnFocusChangeListener jSr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jSt || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jSy) {
                if (z) {
                    TransmitPostEditActivity.this.kOz = true;
                    TransmitPostEditActivity.this.cTp();
                    if (TransmitPostEditActivity.this.dsn != null) {
                        TransmitPostEditActivity.this.dsn.aJZ();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jSt);
                } else if (view == TransmitPostEditActivity.this.jSt) {
                    TransmitPostEditActivity.this.jSz.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jSx && z) {
                TransmitPostEditActivity.this.kOz = false;
                TransmitPostEditActivity.this.cTp();
                TransmitPostEditActivity.this.dsn.aJZ();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jSx);
            }
            TransmitPostEditActivity.this.cTu();
        }
    };
    private TextWatcher kOA = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kOE = "";
        private String kOF;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kOF = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kOF != null ? this.kOF.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cFp();
            TransmitPostEditActivity.this.cTv();
            EditText cTG = TransmitPostEditActivity.this.cTG();
            if (editable != null && cTG != null && cTG.getText() != null) {
                if (this.kOE == null || !this.kOE.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kOu != null) {
                        this.kOE = cTG.getText().toString();
                        TransmitPostEditActivity.this.kOu.b(cTG, true);
                        return;
                    }
                    return;
                }
                cTG.setSelection(cTG.getSelectionEnd());
            }
        }
    };
    private TextWatcher kOB = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kOF;
        private String kOG = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kOF = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kOF != null ? this.kOF.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cFp();
            EditText cTF = TransmitPostEditActivity.this.cTF();
            if (editable != null && cTF != null && cTF.getText() != null) {
                int selectionEnd = cTF.getSelectionEnd();
                if (this.kOG == null || !this.kOG.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kOu != null) {
                        this.kOG = cTF.getText().toString();
                        TransmitPostEditActivity.this.kOu.b(cTF, false);
                        return;
                    }
                    return;
                }
                cTF.setSelection(selectionEnd);
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
    public void aMd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aMe() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMg();
        } else if (this.dtT.cJf()) {
            aMd();
        } else {
            this.dtT.sA(false);
            b(1, true, null);
            this.dtT.cJd();
        }
    }

    private void aMg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.dtT.cJh();
                } else {
                    TransmitPostEditActivity.this.dug.aMt();
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
        aVar.aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cTo() {
        int selectionEnd = cTF().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cTF().getText().getSpans(0, cTF().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cTF().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cTF().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTp() {
        if (this.dsn != null) {
            this.dsn.setBarLauncherEnabled(!this.kOz);
            this.dsn.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kOp) {
            this.jSt.setVisibility(8);
            cFp();
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
        this.dtT = new LocationModel(getPageContext());
        this.dtT.a(this.dug);
        registerListener(this.kek);
        registerListener(this.kOx);
        ccX();
        this.jSx.requestFocus();
        cAB();
        cTO();
    }

    @SuppressLint({"ResourceAsColor"})
    private void ccX() {
        this.dsn = new EditorTools(getActivity());
        this.dsn.setBarMaxLauCount(4);
        this.dsn.setMoreButtonAtEnd(true);
        this.dsn.setBarLauncherType(1);
        this.dsn.gp(true);
        this.dsn.gq(true);
        this.dsn.setBackgroundColorId(R.color.cp_bg_line_h);
        cTq();
        this.dsn.build();
        if (this.kNX != null) {
            this.kNX.addView(this.dsn);
        }
        bXd();
        this.dsn.lw();
        com.baidu.tbadk.editortools.g lU = this.dsn.lU(6);
        if (lU != null && !TextUtils.isEmpty(this.dtY)) {
            ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.dtY);
                }
            });
        }
        if (!this.kOp) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dsn.aJZ();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jSa.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jSa.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cTs();
    }

    private void cTq() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dsn.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dsn.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dsY = 4;
            lVar.dsU = R.drawable.icon_post_location_selector;
            lVar.dsW = false;
            this.dsn.b(lVar);
        }
        if (this.kOd == null) {
            if (this.kOt == null) {
                this.kOt = new com.baidu.tieba.write.editor.b(getActivity(), this.gIK);
                this.kOt.cSr();
                this.kOt.setFrom("from_share_write");
                this.kOt.bz(this.jSa.getForumId(), this.mPrivateThread);
            }
            this.dsn.b(this.kOt);
        }
        this.dsn.aJ(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsn.lX(5);
        if (lX != null) {
            lX.dsY = 1;
        }
    }

    private void bXd() {
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
                        if (TransmitPostEditActivity.this.cTE()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cTE()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cTH();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cFp();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kOd == null) {
                            TransmitPostEditActivity.this.aMh();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.dtZ) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aMe();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aMd();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.dtT != null) {
                            TransmitPostEditActivity.this.dtT.sA(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jSa != null) {
                            str = TransmitPostEditActivity.this.jSa.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cp("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jSa == null || (videoInfo = TransmitPostEditActivity.this.jSa.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dsn.aLE()) {
                                        TransmitPostEditActivity.this.dsn.aJZ();
                                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jSa.setVideoInfo(null);
                        TransmitPostEditActivity.this.cFp();
                        if (TransmitPostEditActivity.this.jSx != null) {
                            TransmitPostEditActivity.this.jSx.requestFocus();
                        }
                        TransmitPostEditActivity.this.dsn.aJZ();
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jSx);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kNU = true;
                        TransmitPostEditActivity.this.tC(true);
                        if (TransmitPostEditActivity.this.cTG().isFocused()) {
                            TransmitPostEditActivity.this.kNT = "from_title";
                        } else if (TransmitPostEditActivity.this.cTF().isFocused()) {
                            TransmitPostEditActivity.this.kNT = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kNY.setVisibility(0);
                        TransmitPostEditActivity.this.kNY.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kNY.hasFocus()) {
                            TransmitPostEditActivity.this.jSx.requestFocus();
                            TransmitPostEditActivity.this.jSx.setSelection(TransmitPostEditActivity.this.jSx.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kNY.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dsn.setActionListener(31, bVar);
        this.dsn.setActionListener(16, bVar);
        this.dsn.setActionListener(14, bVar);
        this.dsn.setActionListener(24, bVar);
        this.dsn.setActionListener(3, bVar);
        this.dsn.setActionListener(10, bVar);
        this.dsn.setActionListener(11, bVar);
        this.dsn.setActionListener(12, bVar);
        this.dsn.setActionListener(13, bVar);
        this.dsn.setActionListener(15, bVar);
        this.dsn.setActionListener(18, bVar);
        this.dsn.setActionListener(20, bVar);
        this.dsn.setActionListener(25, bVar);
        this.dsn.setActionListener(27, bVar);
        this.dsn.setActionListener(29, bVar);
        this.dsn.setActionListener(43, bVar);
        this.dsn.setActionListener(45, bVar);
        this.dsn.setActionListener(53, bVar);
        this.dsn.setActionListener(48, bVar);
        this.dsn.setActionListener(46, bVar);
        this.dsn.setActionListener(49, bVar);
        this.dsn.setActionListener(47, bVar);
        this.dsn.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMh() {
        if (this.dtT.boD()) {
            if (this.dtT.cJf()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cJa().getLocationData().cIY());
                return;
            }
            b(1, true, null);
            this.dtT.cJd();
            return;
        }
        b(0, true, null);
    }

    protected void cFg() {
        if (this.dtU != null) {
            this.dtU.cancelLoadData();
        }
        if (this.kNZ != null) {
            this.kNZ.cancelLoadData();
        }
        if (this.dtT != null) {
            this.dtT.cancelLoadData();
        }
    }

    private void cTr() {
        if (this.kOv != null) {
            this.kOv.hideTip();
        }
    }

    private void cTs() {
        if (this.kOv == null) {
            this.kOv = new e(getPageContext());
        }
        this.kOv.c(this.dsn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cTr();
        TiebaPrepareImageService.StopService();
        cFg();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTt() {
        if (this.jSa == null) {
            finish();
            return;
        }
        this.jSa.setTitle(cTG().getText().toString());
        this.jSa.setContent(cTF().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jSA != null && this.jSA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jSA, getPageContext().getPageActivity());
                return true;
            } else if (this.dsn.aLE()) {
                this.dsn.aJZ();
                return true;
            } else {
                cFg();
                cTt();
                return true;
            }
        }
        if (i == 67 && (text = cTF().getText()) != null) {
            int selectionStart = cTF().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cTF().onKeyDown(67, this.fVk);
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
        getLayoutMode().onModeChanged(this.hmv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jSy, R.color.cp_link_tip_a, 1);
        cTp();
        am.setBackgroundColor(this.jSu, R.color.cp_bg_line_c);
        am.setBackgroundColor(cTG(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cTF(), R.color.cp_bg_line_d);
        cFp();
        this.dsn.onChangeSkinType(i);
        if (this.kOn != null) {
            this.kOn.aFd();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cTu();
        cTv();
        if (this.kOu != null) {
            this.kOu.c(cTG(), cTF());
        }
        this.LR.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTu() {
        if (this.jSt.hasFocus()) {
            this.jSt.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jSt.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jSx.hasFocus()) {
            this.jSx.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jSx.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTv() {
        if (this.jSt != null) {
            if (this.jSt.getText().toString().length() == 0) {
                this.jSt.getPaint().setFakeBoldText(false);
            } else if (this.jSt.getText().toString().length() > 0) {
                this.jSt.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dBH = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kOp = this.jSa.getType() == 4 || 5 == this.jSa.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cTx();
        this.kOo = (ScrollView) findViewById(R.id.write_scrollview);
        this.kOo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jSx != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jSx);
                    }
                    if (TransmitPostEditActivity.this.dsn != null) {
                        TransmitPostEditActivity.this.dsn.aJZ();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hmv = (RelativeLayout) findViewById(R.id.parent);
        this.kNX = (LinearLayout) findViewById(R.id.tool_view);
        this.kNX.setContentDescription(IStringUtil.TOP_PATH);
        this.kNY = (LinearLayout) findViewById(R.id.title_view);
        this.jSu = findViewById(R.id.interval_view);
        this.kOr = (TextView) findViewById(R.id.hot_topic_title_edt);
        cFo();
        if (this.kOp) {
            this.kOo.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cFq();
        cTD();
        this.jSw = (LinearLayout) findViewById(R.id.post_content_container);
        this.jSw.setDrawingCacheEnabled(false);
        this.jSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jSx.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.jSr);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cFg();
                TransmitPostEditActivity.this.cTt();
            }
        });
        cTA();
        cTC();
        cTw();
        cTp();
        cTB();
        cFn();
        cTI();
        if (this.jSa.getType() == 4 && this.jSC != null && this.kOa != null) {
            this.jSC.setVisibility(8);
            this.kOa.setVisibility(8);
        }
        cFp();
        ShowSoftKeyPad(this.mInputManager, this.jSt);
    }

    private void cTw() {
        String str;
        String str2;
        if (this.jSa != null) {
            switch (this.jSa.getType()) {
                case 0:
                case 9:
                    if (this.gIK != null && this.gIK.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gIK != null && this.gIK.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jSa.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jSt.setVisibility(0);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jSt.setVisibility(8);
                    return;
            }
        }
    }

    private void cTx() {
        this.jSy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jSy.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jSy.setLayoutParams(layoutParams);
        this.jSy.setOnFocusChangeListener(this.jSr);
    }

    private void cTy() {
        if (this.jSa != null && this.jSa.getType() == 0 && this.jSa.getType() == 9 && !this.kNW && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cTG() != null) {
                cTG().setText(cutStringWithSuffix);
                cTG().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cTz() {
        this.kOi = null;
        this.kOk = -1;
        this.kOm = -1;
        com.baidu.tieba.frs.y sN = x.bCW().sN(1);
        if (sN != null) {
            this.kOi = sN.gmJ;
            this.kOk = getIntent().getIntExtra("category_id", -1);
            if (this.kOi != null && !this.kOi.isEmpty() && this.kOk >= 0) {
                this.kOj = new w();
                this.kOj.gmF = 0;
                this.kOj.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kOm = this.kOj.gmF;
                this.kOl = this.kOj.name;
                for (w wVar : this.kOi) {
                    if (wVar.gmF == this.kOk) {
                        this.kOm = wVar.gmF;
                        this.kOl = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cTA() {
        if (this.kOi != null && !this.kOi.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kOn = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kOn.setText(this.kOl);
            this.kOn.setCategoryContainerData(this.kOi, this.kOj, this.kOm);
            this.kOn.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        TransmitPostEditActivity.this.kOn.setText(asVar.name);
                        TransmitPostEditActivity.this.jSa.setCategoryTo(asVar.gmF);
                        TransmitPostEditActivity.this.kOm = asVar.gmF;
                        TransmitPostEditActivity.this.kOn.cTc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kOn.cTb();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTG());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTF());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kOC = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kOC.setTitle(R.string.no_disturb_start_time);
        this.kOC.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kOC);
        this.kOC.setButton(-2, getPageContext().getString(R.string.cancel), this.kOC);
        return this.kOC;
    }

    private void cTB() {
        this.kOe = (RelativeLayout) findViewById(R.id.addition_container);
        this.kOf = (TextView) findViewById(R.id.addition_create_time);
        this.kOg = (TextView) findViewById(R.id.addition_last_time);
        this.kOh = (TextView) findViewById(R.id.addition_last_content);
        if (this.kOd != null) {
            this.kOe.setVisibility(0);
            this.kOf.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kOd.getCreateTime() * 1000));
            if (this.kOd.getAlreadyCount() == 0) {
                this.kOg.setVisibility(8);
            } else {
                this.kOg.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kOd.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kOd.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kOh.setText(lastAdditionContent);
            } else {
                this.kOh.setVisibility(8);
            }
            cTF().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kOd.getAlreadyCount()), Integer.valueOf(this.kOd.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kOe.setVisibility(8);
    }

    private void cFn() {
        this.jSC = findViewById(R.id.post_prefix_layout);
        this.jSz = (TextView) findViewById(R.id.post_prefix);
        this.kOa = findViewById(R.id.prefix_divider);
        this.jSB = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jSC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jSb = 1;
            this.jSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jSz.setVisibility(0);
                    TransmitPostEditActivity.this.jSC.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jSA, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dsn.aJZ();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jSt);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jSx);
                }
            });
            this.jSB = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jSB.setVisibility(0);
                this.jSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jSz.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jSA, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dsn.aJZ();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTG());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTF());
                    }
                });
            }
            this.jSA = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jSA.a(this);
            this.jSA.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jSA.setOutsideTouchable(true);
            this.jSA.setFocusable(true);
            this.jSA.setOnDismissListener(this);
            this.jSA.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jSz, R.color.cp_bg_line_d);
            am.setImageResource(this.jSB, R.drawable.icon_frs_arrow_n);
            this.jSz.setTextColor(color);
            this.kOb.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kOb.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jSA.addView(writePrefixItemLayout);
            }
            this.jSA.setCurrentIndex(0);
            this.jSz.setText(prefixs.get(1));
            Ei(1);
            return;
        }
        this.jSC.setVisibility(8);
    }

    protected void cTC() {
        this.jSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cTP()) {
                    if (TransmitPostEditActivity.this.kOu.a(TransmitPostEditActivity.this.jSt, TransmitPostEditActivity.this.jSx)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kOu.cRL());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTG());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cTF());
                    TransmitPostEditActivity.this.dsn.aJZ();
                    TiebaStatic.log(new an("c12608").Z("obj_locate", 7));
                    TransmitPostEditActivity.this.cTM();
                }
            }
        });
    }

    protected void cFo() {
        this.jSt = (EditText) findViewById(R.id.post_title);
        this.jSt.setOnClickListener(this.kOy);
        this.jSt.setOnFocusChangeListener(this.jSr);
        if ((this.jSa.getType() == 0 || this.jSa.getType() == 9 || this.jSa.getType() == 7) && this.jSa.getTitle() != null) {
            this.jSt.setText(this.jSa.getTitle());
            this.jSt.setSelection(this.jSa.getTitle().length());
        }
        this.jSt.addTextChangedListener(this.kOA);
        if (!this.jSa.getHaveDraft()) {
            cTy();
        }
        this.jSt.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cFq() {
        this.jSx = (EditText) findViewById(R.id.post_content);
        this.jSx.setDrawingCacheEnabled(false);
        this.jSx.setOnClickListener(this.kOy);
        if (this.jSa.getContent() != null && this.jSa.getContent().length() > 0) {
            SpannableString aA = TbFaceManager.aMY().aA(getPageContext().getPageActivity(), this.jSa.getContent());
            this.jSx.setText(aA);
            this.jSx.setSelection(aA.length());
        }
        if (!aq.isEmpty(this.ghe)) {
            this.jSx.setSelection(0);
        }
        this.jSx.setOnFocusChangeListener(this.jSr);
        this.jSx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jSx.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jSx.addTextChangedListener(this.kOB);
        if (this.kNV != null && this.kNV.showType == 3) {
            this.jSx.setHint(R.string.share_video_default);
        } else {
            this.jSx.setHint(R.string.share_txt_default);
        }
    }

    private void cTD() {
        this.LR = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.LR.setVisibility(0);
        this.LR.a(this.kNV);
        this.LR.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTE() {
        int i = 5000;
        if (this.kOd != null) {
            i = 1000;
        }
        return cTF().getText() != null && cTF().getText().length() >= i;
    }

    private void uL(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kNT)) {
                this.kNT = "";
                cTF().requestFocus();
                if (cTF().getText() != null && cTF().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cTF().getSelectionStart();
                    editable = cTF().getText();
                }
            } else if ("from_title".equals(this.kNT)) {
                this.kNT = "";
                cTG().requestFocus();
                if (cTG().getText() != null && cTG().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cTG().getSelectionStart();
                    editable = cTG().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jSa != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jSa.getForumId(), 0L), this.jSa.getFirstDir(), this.jSa.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cTF().getText().getSpans(0, cTF().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kOc == null) {
                this.kOc = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kOc.getView().isShown()) {
                this.kOc.cancel();
            }
            this.kOc.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType aGJ = pVar.aGJ();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gs().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cTF().getSelectionStart(), aVar, aGJ);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cTF() != null && cTF().getText() != null) {
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
                int selectionStart = cTF().getSelectionStart() - 1;
                if (cTF().getText().length() > 1 && selectionStart >= 0 && cTF().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cTF().getText().insert(cTF().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cTF().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cTF().getText().insert(cTF().getSelectionStart(), spannableString2);
            }
            Editable text = cTF().getText();
            if (text != null) {
                this.kOs.clear();
                this.kOs.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kOs);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cTF().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cTF().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cTF().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cTF() {
        return this.jSx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cTG() {
        return this.jSt;
    }

    protected void cTH() {
        Editable text;
        if (cTF() != null && (text = cTF().getText()) != null) {
            int selectionStart = cTF().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cTF().onKeyDown(67, this.fVk);
            }
            cTF().onKeyDown(67, this.fVk);
            int selectionStart2 = cTF().getSelectionStart();
            this.kOs.clear();
            this.kOs.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kOs);
            cTF().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dBH.setCancelListener(null);
        this.dBH.setTipString(R.string.sending);
        this.dBH.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dBH.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFp() {
        if (this.jSa != null) {
            String str = "";
            String str2 = "";
            if (cTG() != null) {
                str = cTG().getText().toString();
            }
            if (cTF() != null) {
                str2 = cTF().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jSa.getType() == 0 || this.jSa.getType() == 9 || this.jSa.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jSb == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jSa.setIsNoTitle(true);
                        } else {
                            this.jSa.setIsNoTitle(false);
                            tD(true);
                            return;
                        }
                    } else {
                        this.jSa.setIsNoTitle(false);
                        tD(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jSa.setIsNoTitle(true);
                } else {
                    this.jSa.setIsNoTitle(false);
                    tD(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kOp) {
                    tD(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tD(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tD(true);
            } else if (this.jSa.getVideoInfo() != null) {
                tD(true);
            } else {
                tD(false);
            }
        }
    }

    private void tD(boolean z) {
        am.setNavbarTitleColor(this.jSy, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.dtU = new NewWriteModel(this);
        this.dtU.b(this.dui);
        this.fZZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cFg();
            }
        };
        this.jSa = new WriteData();
        if (bundle != null) {
            this.jSa.setType(bundle.getInt("type", 0));
            this.jSa.setForumId(bundle.getString("forum_id"));
            this.jSa.setForumName(bundle.getString("forum_name"));
            this.jSa.setFirstDir(bundle.getString("forum_first_dir"));
            this.jSa.setSecondDir(bundle.getString("forum_second_dir"));
            this.jSa.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kOd = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jSa.setIsAddition(this.kOd != null);
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
            this.jSa.setTitle(bundle.getString("write_title"));
            this.jSa.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gIK = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kNV = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.ghe = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.ghf = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = string;
        } else {
            Intent intent = getIntent();
            this.jSa.setType(intent.getIntExtra("type", 0));
            this.jSa.setForumId(intent.getStringExtra("forum_id"));
            this.jSa.setForumName(intent.getStringExtra("forum_name"));
            this.jSa.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jSa.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jSa.setThreadId(intent.getStringExtra("thread_id"));
            this.kOd = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jSa.setIsAddition(this.kOd != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jSa.setTitle(intent.getStringExtra("write_title"));
            this.jSa.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gIK = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kNV = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.ghe = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.ghf = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jSa.getType() == 4 ? 6 : 9);
        this.jSa.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kNV != null && this.kNV.videoId != null) {
            this.jSa.setVideoId(this.kNV.videoId);
            this.jSa.setOriginalVideoCover(this.kNV.showPicUrl);
            this.jSa.setOriginalVideoTitle(this.kNV.showText);
        }
        if (!aq.isEmpty(this.ghe)) {
            if (!aq.isEmpty(this.ghf)) {
                this.jSa.setContent("//@" + this.ghf + " :" + this.ghe);
            } else {
                this.jSa.setContent(this.ghe);
            }
        }
        if (this.jSa != null && this.jSa.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jSa.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kNW = true;
        }
        cTz();
    }

    private void cTI() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jSt.setText(com.baidu.tbadk.plugins.b.vj(com.baidu.tbadk.plugins.b.vk(hotTopicBussinessData.mTopicName)));
            this.jSt.setMovementMethod(com.baidu.tieba.view.c.cQS());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vj = com.baidu.tbadk.plugins.b.vj(com.baidu.tbadk.plugins.b.vk(hotTopicBussinessData.mTopicName));
            if (vj != null) {
                this.jSt.setText(vj);
            }
            this.kOr.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jSa.getType());
        bundle.putString("forum_id", this.jSa.getForumId());
        bundle.putString("forum_name", this.jSa.getForumName());
        bundle.putString("forum_first_dir", this.jSa.getFirstDir());
        bundle.putString("forum_second_dir", this.jSa.getSecondDir());
        bundle.putString("thread_id", this.jSa.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kOd != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kOd));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gIK);
        if (this.kNV != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kNV));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cTF().getEditableText().toString();
        if (obj != null) {
            cTF().setText(TbFaceManager.aMY().a(getPageContext().getPageActivity(), obj, this.kOw));
            cTF().setSelection(cTF().getText().length());
        }
    }

    private String cTJ() {
        if (cTF() == null || cTF().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cTF().getText().toString())) {
            if (this.kNV != null && this.kNV.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cTF().getText().toString();
    }

    private String cTK() {
        if (this.jSa == null || cTG() == null || cTG().getVisibility() != 0 || cTG().getText() == null) {
            return "";
        }
        String obj = cTG().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jSb != 0 && this.jSa.getType() != 4 && this.jSz != null && this.jSz.getText() != null) {
            obj = this.jSz.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jSa.getTitle();
        }
        return obj;
    }

    private void cTL() {
        cFg();
        this.jSa.setContent(cTJ());
        this.jSa.setTitle(cTK());
        if (this.kOk >= 0) {
            this.jSa.setCategoryFrom(this.kOk);
        }
        if (this.kOm >= 0) {
            this.jSa.setCategoryTo(this.kOm);
        }
        this.jSa.setWriteImagesInfo(this.writeImagesInfo);
        this.jSa.setHasLocationData(this.dtT != null && this.dtT.boD());
        this.dtU.sC(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kOq != null && this.kOq.mIsGlobalBlock == 0) {
            this.jSa.setForumId(String.valueOf(this.kOq.mForumId));
            this.jSa.setForumName(this.kOq.mForumName);
        }
        this.dtU.d(this.jSa);
        this.jSa.setContent(this.jSa.getContent().replaceAll("\u0000\n", ""));
        this.jSa.setContent(this.jSa.getContent().replaceAll("\u0000", ""));
        this.jSa.setVcode(null);
        this.dtU.cFi().setVoice(null);
        this.dtU.cFi().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.fZZ);
        this.dtU.cJG();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kOd != null) {
                i2 = this.kOd.getTotalCount();
                i = this.kOd.getAlreadyCount() + 1;
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
                if (this.dsn != null && !this.dsn.aLE()) {
                    cTF().requestFocus();
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
                            cTF().getText().insert(cTF().getSelectionStart(), sb.toString());
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
                        if (this.kNU) {
                            sb2.append(com.baidu.tbadk.plugins.b.dBn);
                            this.kNU = false;
                        }
                        sb2.append(stringExtra);
                        uL(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kOq = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kOq);
            }
        } else if (i2 == 0) {
            if (this.dsn != null && !this.dsn.aLE()) {
                this.jSx.requestFocus();
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
                        this.kOu.Kn(postWriteCallBackData.getErrorString());
                        this.kOu.aV(postWriteCallBackData.getSensitiveWords());
                        this.kOu.b(this.jSt, this.jSx);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kNT)) {
                        cTG().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kNT)) {
                        cTF().requestFocus();
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
    public void cTM() {
        if ("1".equals(this.gIK)) {
            this.jSa.setCanNoForum(true);
            this.jSa.setTransmitForumData("[]");
        } else if ("2".equals(this.gIK)) {
            this.jSa.setCanNoForum(false);
        }
        cTN();
        this.jSa.setPrivacy(this.isPrivacy);
        this.jSa.setIsShareThread(true);
        if (this.kNV != null && !StringUtils.isNull(this.kNV.threadId)) {
            this.jSa.setOriginalThreadId(this.kNV.threadId);
        }
        this.jSa.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kNV != null) {
            this.jSa.setOriBaijiahaoData(this.kNV.oriUgcInfo);
        }
        this.jSa.setCallFrom(this.gIK);
        cTL();
    }

    private void cTN() {
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cTG());
        HidenSoftKeyPad(this.mInputManager, cTF());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aW(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gkg) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jSa.getType() != 7) {
                if (this.kOd == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        this.dtZ = i;
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cTO() {
        if (!this.kOp && this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dsn.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ei(int i) {
        if (i < this.kOb.size()) {
            for (int i2 = 0; i2 < this.kOb.size(); i2++) {
                this.kOb.get(i2).tu(false);
            }
            this.kOb.get(i).tu(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void BR(int i) {
        this.jSb = i;
        this.jSA.setCurrentIndex(i);
        Ei(i);
        this.jSz.setText(this.mPrefixData.getPrefixs().get(i));
        cFp();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jSA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jSC.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes10.dex */
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
        if (this.jSa != null) {
            if (this.jSa.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jSa.getType() == 5) {
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
            aMe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aqh = z;
        if (this.kOt != null && !z) {
            this.kOt.bwa();
        }
        if (this.kOv != null && !z) {
            cTr();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aqh && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kNU = false;
            this.kNT = "";
            if ("from_content".equals(str)) {
                this.kNT = "from_content";
            } else if ("from_title".equals(str)) {
                this.kNT = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vi(String.valueOf(charSequence.charAt(i)))) {
                tC(false);
            }
        }
    }

    public void cAB() {
        if (!v.isEmpty(this.mList)) {
            this.kNY.setVisibility(0);
            this.kNY.requestFocus();
            return;
        }
        this.kNY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTP() {
        if (((ImageSpan[]) cTF().getText().getSpans(0, cTF().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kOc == null) {
                this.kOc = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kOc.getView().isShown()) {
                this.kOc.cancel();
            }
            this.kOc.show();
            return true;
        }
        return false;
    }
}
