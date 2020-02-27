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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.q;
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
/* loaded from: classes13.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0078a, h.a {
    private OriginalThreadCardView Mv;
    private EditorTools dwF;
    private LocationModel dyk;
    private NewWriteModel dyl;
    private String gmp;
    private String gmq;
    private boolean isPrivacy;
    private int jWJ;
    private TextView jXg;
    private com.baidu.tieba.write.h jXh;
    private ImageView jXi;
    private View jXj;
    private HotTopicBussinessData kSC;
    private TextView kSD;
    private com.baidu.tieba.write.editor.b kSF;
    private e kSH;
    private com.baidu.tieba.view.b kSO;
    private OriginalThreadInfo.ShareInfo kSh;
    private LinearLayout kSj;
    private LinearLayout kSk;
    private View kSm;
    private Toast kSo;
    private AdditionData kSp;
    private RelativeLayout kSq;
    private TextView kSr;
    private TextView kSs;
    private TextView kSt;
    List<w> kSu;
    w kSv;
    private int kSw;
    private String kSx;
    private int kSy;
    private PostCategoryView kSz;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kSf = "";
    private boolean kSg = false;
    private WriteData jWI = null;
    private boolean kSi = false;
    private InputMethodManager mInputManager = null;
    private EditText jXa = null;
    private View jXb = null;
    private LinearLayout jXd = null;
    private EditText jXe = null;
    private FeedBackModel kSl = null;
    private ArrayList<WritePrefixItemLayout> kSn = new ArrayList<>();
    private final KeyEvent gat = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jXf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfk = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout hrX = null;
    private String dyp = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyq = 0;
    private View mRootView = null;
    private ScrollView kSA = null;
    private boolean kSB = false;
    private com.baidu.tbadk.core.view.a dFS = null;
    private String mFrom = "write";
    private String gNW = "2";
    private SpannableStringBuilder kSE = new SpannableStringBuilder();
    private boolean auD = false;
    private final b kSG = new b();
    private TbFaceManager.a kSI = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan vv(String str) {
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
    private final AntiHelper.a gpq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jWI != null) {
                TransmitPostEditActivity.this.kSG.aU(null);
                if (z) {
                    TransmitPostEditActivity.this.gJ(z);
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
                    TransmitPostEditActivity.this.kSG.KK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kSG.aU(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kSG.b(TransmitPostEditActivity.this.jXa, TransmitPostEditActivity.this.jXe);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJE());
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dyx = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPi() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLC())) {
                TransmitPostEditActivity.this.a(2, true, aVar.cLC());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kiU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.dyk.sQ(false);
                    TransmitPostEditActivity.this.dyk.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.dyk.sQ(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSJ = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVH = TransmitPostEditActivity.this.cVH();
            if (cVH >= 0 && cVH < TransmitPostEditActivity.this.jXe.getText().length()) {
                TransmitPostEditActivity.this.jXe.setSelection(cVH);
            }
        }
    };
    private boolean kSL = true;
    private final View.OnFocusChangeListener eVV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jXa || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jXf) {
                if (z) {
                    TransmitPostEditActivity.this.kSL = true;
                    TransmitPostEditActivity.this.cVI();
                    if (TransmitPostEditActivity.this.dwF != null) {
                        TransmitPostEditActivity.this.dwF.aMO();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXa);
                } else if (view == TransmitPostEditActivity.this.jXa) {
                    TransmitPostEditActivity.this.jXg.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jXe && z) {
                TransmitPostEditActivity.this.kSL = false;
                TransmitPostEditActivity.this.cVI();
                TransmitPostEditActivity.this.dwF.aMO();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXe);
            }
            TransmitPostEditActivity.this.cVN();
        }
    };
    private TextWatcher kSM = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kSQ = "";
        private String kSR;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSR = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSR != null ? this.kSR.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cHZ();
            TransmitPostEditActivity.this.cVO();
            EditText cVZ = TransmitPostEditActivity.this.cVZ();
            if (editable != null && cVZ != null && cVZ.getText() != null) {
                if (this.kSQ == null || !this.kSQ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSG != null) {
                        this.kSQ = cVZ.getText().toString();
                        TransmitPostEditActivity.this.kSG.b(cVZ, true);
                        return;
                    }
                    return;
                }
                cVZ.setSelection(cVZ.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSN = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kSR;
        private String kSS = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSR = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSR != null ? this.kSR.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cHZ();
            EditText cVY = TransmitPostEditActivity.this.cVY();
            if (editable != null && cVY != null && cVY.getText() != null) {
                int selectionEnd = cVY.getSelectionEnd();
                if (this.kSS == null || !this.kSS.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSG != null) {
                        this.kSS = cVY.getText().toString();
                        TransmitPostEditActivity.this.kSG.b(cVY, false);
                        return;
                    }
                    return;
                }
                cVY.setSelection(selectionEnd);
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
    public void aOS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOV();
        } else if (this.dyk.cLJ()) {
            aOS();
        } else {
            this.dyk.sQ(false);
            a(1, true, (String) null);
            this.dyk.cLH();
        }
    }

    private void aOV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.dyk.cLL();
                } else {
                    TransmitPostEditActivity.this.dyx.aPi();
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
        aVar.aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cVH() {
        int selectionEnd = cVY().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cVY().getText().getSpans(0, cVY().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cVY().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cVY().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVI() {
        if (this.dwF != null) {
            this.dwF.setBarLauncherEnabled(!this.kSL);
            this.dwF.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kSB) {
            this.jXa.setVisibility(8);
            cHZ();
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
        this.dyk = new LocationModel(getPageContext());
        this.dyk.a(this.dyx);
        registerListener(this.kiU);
        registerListener(this.kSJ);
        cfK();
        this.jXe.requestFocus();
        cDf();
        cWh();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfK() {
        this.dwF = new EditorTools(getActivity());
        this.dwF.setBarMaxLauCount(4);
        this.dwF.setMoreButtonAtEnd(true);
        this.dwF.setBarLauncherType(1);
        this.dwF.gB(true);
        this.dwF.gC(true);
        this.dwF.setBackgroundColorId(R.color.cp_bg_line_h);
        cVJ();
        this.dwF.build();
        if (this.kSj != null) {
            this.kSj.addView(this.dwF);
        }
        bZN();
        this.dwF.display();
        com.baidu.tbadk.editortools.g mm = this.dwF.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyp)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.dyp);
                }
            });
        }
        if (!this.kSB) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwF.aMO();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jWI.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWI.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cVL();
    }

    private void cVJ() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dwF.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dwF.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dxp = 4;
            lVar.dxl = R.drawable.icon_post_location_selector;
            lVar.dxn = false;
            this.dwF.b(lVar);
        }
        if (this.kSp == null) {
            if (this.kSF == null) {
                this.kSF = new com.baidu.tieba.write.editor.b(getActivity(), this.gNW);
                this.kSF.cUK();
                this.kSF.setFrom("from_share_write");
                this.kSF.bz(this.jWI.getForumId(), this.mPrivateThread);
            }
            this.dwF.b(this.kSF);
        }
        this.dwF.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwF.mp(5);
        if (mp != null) {
            mp.dxp = 1;
        }
    }

    private void bZN() {
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
                            TiebaStatic.log(new an("c12608").X("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.cVX()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cVX()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cWa();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cHZ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kSp == null) {
                            TransmitPostEditActivity.this.aOW();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.dyq) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aOT();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aOS();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.dyk != null) {
                            TransmitPostEditActivity.this.dyk.sQ(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jWI != null) {
                            str = TransmitPostEditActivity.this.jWI.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jWI == null || (videoInfo = TransmitPostEditActivity.this.jWI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dwF.aOt()) {
                                        TransmitPostEditActivity.this.dwF.aMO();
                                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jWI.setVideoInfo(null);
                        TransmitPostEditActivity.this.cHZ();
                        if (TransmitPostEditActivity.this.jXe != null) {
                            TransmitPostEditActivity.this.jXe.requestFocus();
                        }
                        TransmitPostEditActivity.this.dwF.aMO();
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXe);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kSg = true;
                        TransmitPostEditActivity.this.tS(true);
                        if (TransmitPostEditActivity.this.cVZ().isFocused()) {
                            TransmitPostEditActivity.this.kSf = "from_title";
                        } else if (TransmitPostEditActivity.this.cVY().isFocused()) {
                            TransmitPostEditActivity.this.kSf = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kSk.setVisibility(0);
                        TransmitPostEditActivity.this.kSk.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kSk.hasFocus()) {
                            TransmitPostEditActivity.this.jXe.requestFocus();
                            TransmitPostEditActivity.this.jXe.setSelection(TransmitPostEditActivity.this.jXe.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kSk.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dwF.setActionListener(31, bVar);
        this.dwF.setActionListener(16, bVar);
        this.dwF.setActionListener(14, bVar);
        this.dwF.setActionListener(24, bVar);
        this.dwF.setActionListener(3, bVar);
        this.dwF.setActionListener(10, bVar);
        this.dwF.setActionListener(11, bVar);
        this.dwF.setActionListener(12, bVar);
        this.dwF.setActionListener(13, bVar);
        this.dwF.setActionListener(15, bVar);
        this.dwF.setActionListener(18, bVar);
        this.dwF.setActionListener(20, bVar);
        this.dwF.setActionListener(25, bVar);
        this.dwF.setActionListener(27, bVar);
        this.dwF.setActionListener(29, bVar);
        this.dwF.setActionListener(43, bVar);
        this.dwF.setActionListener(45, bVar);
        this.dwF.setActionListener(53, bVar);
        this.dwF.setActionListener(48, bVar);
        this.dwF.setActionListener(46, bVar);
        this.dwF.setActionListener(49, bVar);
        this.dwF.setActionListener(47, bVar);
        this.dwF.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        if (this.dyk.brj()) {
            if (this.dyk.cLJ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLE().getLocationData().cLC());
                return;
            }
            a(1, true, (String) null);
            this.dyk.cLH();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHQ() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
        if (this.kSl != null) {
            this.kSl.cancelLoadData();
        }
        if (this.dyk != null) {
            this.dyk.cancelLoadData();
        }
    }

    private void cVK() {
        if (this.kSH != null) {
            this.kSH.hideTip();
        }
    }

    private void cVL() {
        if (this.kSH == null) {
            this.kSH = new e(getPageContext());
        }
        this.kSH.c(this.dwF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVK();
        TiebaPrepareImageService.StopService();
        cHQ();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVM() {
        if (this.jWI == null) {
            finish();
            return;
        }
        this.jWI.setTitle(cVZ().getText().toString());
        this.jWI.setContent(cVY().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXh != null && this.jXh.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXh, getPageContext().getPageActivity());
                return true;
            } else if (this.dwF.aOt()) {
                this.dwF.aMO();
                return true;
            } else {
                cHQ();
                cVM();
                return true;
            }
        }
        if (i == 67 && (text = cVY().getText()) != null) {
            int selectionStart = cVY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cVY().onKeyDown(67, this.gat);
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
        getLayoutMode().onModeChanged(this.hrX);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXf, R.color.cp_link_tip_a, 1);
        cVI();
        am.setBackgroundColor(this.jXb, R.color.cp_bg_line_c);
        am.setBackgroundColor(cVZ(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cVY(), R.color.cp_bg_line_d);
        cHZ();
        this.dwF.onChangeSkinType(i);
        if (this.kSz != null) {
            this.kSz.aHL();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cVN();
        cVO();
        if (this.kSG != null) {
            this.kSG.c(cVZ(), cVY());
        }
        this.Mv.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVN() {
        if (this.jXa.hasFocus()) {
            this.jXa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXe.hasFocus()) {
            this.jXe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVO() {
        if (this.jXa != null) {
            if (this.jXa.getText().toString().length() == 0) {
                this.jXa.getPaint().setFakeBoldText(false);
            } else if (this.jXa.getText().toString().length() > 0) {
                this.jXa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dFS = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSB = this.jWI.getType() == 4 || 5 == this.jWI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGA().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cVQ();
        this.kSA = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jXe != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jXe);
                    }
                    if (TransmitPostEditActivity.this.dwF != null) {
                        TransmitPostEditActivity.this.dwF.aMO();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hrX = (RelativeLayout) findViewById(R.id.parent);
        this.kSj = (LinearLayout) findViewById(R.id.tool_view);
        this.kSj.setContentDescription(IStringUtil.TOP_PATH);
        this.kSk = (LinearLayout) findViewById(R.id.title_view);
        this.jXb = findViewById(R.id.interval_view);
        this.kSD = (TextView) findViewById(R.id.hot_topic_title_edt);
        cHY();
        if (this.kSB) {
            this.kSA.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cIa();
        cVW();
        this.jXd = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXd.setDrawingCacheEnabled(false);
        this.jXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jXe.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eVV);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cHQ();
                TransmitPostEditActivity.this.cVM();
            }
        });
        cVT();
        cVV();
        cVP();
        cVI();
        cVU();
        cHX();
        cWb();
        if (this.jWI.getType() == 4 && this.jXj != null && this.kSm != null) {
            this.jXj.setVisibility(8);
            this.kSm.setVisibility(8);
        }
        cHZ();
        ShowSoftKeyPad(this.mInputManager, this.jXa);
    }

    private void cVP() {
        String str;
        String str2;
        if (this.jWI != null) {
            switch (this.jWI.getType()) {
                case 0:
                case 9:
                    if (this.gNW != null && this.gNW.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gNW != null && this.gNW.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jWI.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jXa.setVisibility(0);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXa.setVisibility(8);
                    return;
            }
        }
    }

    private void cVQ() {
        this.jXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXf.setLayoutParams(layoutParams);
        this.jXf.setOnFocusChangeListener(this.eVV);
    }

    private void cVR() {
        if (this.jWI != null && this.jWI.getType() == 0 && this.jWI.getType() == 9 && !this.kSi && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cVZ() != null) {
                cVZ().setText(cutStringWithSuffix);
                cVZ().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cVS() {
        this.kSu = null;
        this.kSw = -1;
        this.kSy = -1;
        y sY = x.bFB().sY(1);
        if (sY != null) {
            this.kSu = sY.grT;
            this.kSw = getIntent().getIntExtra("category_id", -1);
            if (this.kSu != null && !this.kSu.isEmpty() && this.kSw >= 0) {
                this.kSv = new w();
                this.kSv.grP = 0;
                this.kSv.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSy = this.kSv.grP;
                this.kSx = this.kSv.name;
                for (w wVar : this.kSu) {
                    if (wVar.grP == this.kSw) {
                        this.kSy = wVar.grP;
                        this.kSx = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVT() {
        if (this.kSu != null && !this.kSu.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSz = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSz.setText(this.kSx);
            this.kSz.setCategoryContainerData(this.kSu, this.kSv, this.kSy);
            this.kSz.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        TransmitPostEditActivity.this.kSz.setText(asVar.name);
                        TransmitPostEditActivity.this.jWI.setCategoryTo(asVar.grP);
                        TransmitPostEditActivity.this.kSy = asVar.grP;
                        TransmitPostEditActivity.this.kSz.cVv();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kSz.cVu();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVZ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVY());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSO = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSO.setTitle(R.string.no_disturb_start_time);
        this.kSO.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSO);
        this.kSO.setButton(-2, getPageContext().getString(R.string.cancel), this.kSO);
        return this.kSO;
    }

    private void cVU() {
        this.kSq = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSr = (TextView) findViewById(R.id.addition_create_time);
        this.kSs = (TextView) findViewById(R.id.addition_last_time);
        this.kSt = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSp != null) {
            this.kSq.setVisibility(0);
            this.kSr.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSp.getCreateTime() * 1000));
            if (this.kSp.getAlreadyCount() == 0) {
                this.kSs.setVisibility(8);
            } else {
                this.kSs.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSp.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSp.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSt.setText(lastAdditionContent);
            } else {
                this.kSt.setVisibility(8);
            }
            cVY().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSp.getAlreadyCount()), Integer.valueOf(this.kSp.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSq.setVisibility(8);
    }

    private void cHX() {
        this.jXj = findViewById(R.id.post_prefix_layout);
        this.jXg = (TextView) findViewById(R.id.post_prefix);
        this.kSm = findViewById(R.id.prefix_divider);
        this.jXi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXj.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWJ = 1;
            this.jXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jXg.setVisibility(0);
                    TransmitPostEditActivity.this.jXj.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dwF.aMO();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXa);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXe);
                }
            });
            this.jXi = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXi.setVisibility(0);
                this.jXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jXg.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXh, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dwF.aMO();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVZ());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVY());
                    }
                });
            }
            this.jXh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXh.a(this);
            this.jXh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXh.setOutsideTouchable(true);
            this.jXh.setFocusable(true);
            this.jXh.setOnDismissListener(this);
            this.jXh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXg, R.color.cp_bg_line_d);
            am.setImageResource(this.jXi, R.drawable.icon_frs_arrow_n);
            this.jXg.setTextColor(color);
            this.kSn.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSn.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jXh.addView(writePrefixItemLayout);
            }
            this.jXh.setCurrentIndex(0);
            this.jXg.setText(prefixs.get(1));
            Es(1);
            return;
        }
        this.jXj.setVisibility(8);
    }

    protected void cVV() {
        this.jXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cWi()) {
                    if (TransmitPostEditActivity.this.kSG.a(TransmitPostEditActivity.this.jXa, TransmitPostEditActivity.this.jXe)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kSG.cUe());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVZ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cVY());
                    TransmitPostEditActivity.this.dwF.aMO();
                    TiebaStatic.log(new an("c12608").X("obj_locate", 7));
                    TransmitPostEditActivity.this.cWf();
                }
            }
        });
    }

    protected void cHY() {
        this.jXa = (EditText) findViewById(R.id.post_title);
        this.jXa.setOnClickListener(this.kSK);
        this.jXa.setOnFocusChangeListener(this.eVV);
        if ((this.jWI.getType() == 0 || this.jWI.getType() == 9 || this.jWI.getType() == 7) && this.jWI.getTitle() != null) {
            this.jXa.setText(this.jWI.getTitle());
            this.jXa.setSelection(this.jWI.getTitle().length());
        }
        this.jXa.addTextChangedListener(this.kSM);
        if (!this.jWI.getHaveDraft()) {
            cVR();
        }
        this.jXa.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cIa() {
        this.jXe = (EditText) findViewById(R.id.post_content);
        this.jXe.setDrawingCacheEnabled(false);
        this.jXe.setOnClickListener(this.kSK);
        if (this.jWI.getContent() != null && this.jWI.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPN().aB(getPageContext().getPageActivity(), this.jWI.getContent());
            this.jXe.setText(aB);
            this.jXe.setSelection(aB.length());
        }
        if (!aq.isEmpty(this.gmp)) {
            this.jXe.setSelection(0);
        }
        this.jXe.setOnFocusChangeListener(this.eVV);
        this.jXe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jXe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXe.addTextChangedListener(this.kSN);
        if (this.kSh != null && this.kSh.showType == 3) {
            this.jXe.setHint(R.string.share_video_default);
        } else {
            this.jXe.setHint(R.string.share_txt_default);
        }
    }

    private void cVW() {
        this.Mv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Mv.setVisibility(0);
        this.Mv.a(this.kSh);
        this.Mv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVX() {
        int i = 5000;
        if (this.kSp != null) {
            i = 1000;
        }
        return cVY().getText() != null && cVY().getText().length() >= i;
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSf)) {
                this.kSf = "";
                cVY().requestFocus();
                if (cVY().getText() != null && cVY().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cVY().getSelectionStart();
                    editable = cVY().getText();
                }
            } else if ("from_title".equals(this.kSf)) {
                this.kSf = "";
                cVZ().requestFocus();
                if (cVZ().getText() != null && cVZ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cVZ().getSelectionStart();
                    editable = cVZ().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jWI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWI.getForumId(), 0L), this.jWI.getFirstDir(), this.jWI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cVY().getText().getSpans(0, cVY().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSo == null) {
                this.kSo = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSo.getView().isShown()) {
                this.kSo.cancel();
            }
            this.kSo.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJu = qVar.aJu();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cVY().getSelectionStart(), aVar, aJu);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cVY() != null && cVY().getText() != null) {
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
                int selectionStart = cVY().getSelectionStart() - 1;
                if (cVY().getText().length() > 1 && selectionStart >= 0 && cVY().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cVY().getText().insert(cVY().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cVY().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cVY().getText().insert(cVY().getSelectionStart(), spannableString2);
            }
            Editable text = cVY().getText();
            if (text != null) {
                this.kSE.clear();
                this.kSE.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSE);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cVY().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cVY().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cVY().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cVY() {
        return this.jXe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cVZ() {
        return this.jXa;
    }

    protected void cWa() {
        Editable text;
        if (cVY() != null && (text = cVY().getText()) != null) {
            int selectionStart = cVY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cVY().onKeyDown(67, this.gat);
            }
            cVY().onKeyDown(67, this.gat);
            int selectionStart2 = cVY().getSelectionStart();
            this.kSE.clear();
            this.kSE.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kSE);
            cVY().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dFS.setCancelListener(null);
        this.dFS.setTipString(R.string.sending);
        this.dFS.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dFS.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHZ() {
        if (this.jWI != null) {
            String str = "";
            String str2 = "";
            if (cVZ() != null) {
                str = cVZ().getText().toString();
            }
            if (cVY() != null) {
                str2 = cVY().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWI.getType() == 0 || this.jWI.getType() == 9 || this.jWI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jWJ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWI.setIsNoTitle(true);
                        } else {
                            this.jWI.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else {
                        this.jWI.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWI.setIsNoTitle(true);
                } else {
                    this.jWI.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSB) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tT(true);
            } else if (this.jWI.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    private void tT(boolean z) {
        am.setNavbarTitleColor(this.jXf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.dyl = new NewWriteModel(this);
        this.dyl.b(this.dyz);
        this.gfk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cHQ();
            }
        };
        this.jWI = new WriteData();
        if (bundle != null) {
            this.jWI.setType(bundle.getInt("type", 0));
            this.jWI.setForumId(bundle.getString("forum_id"));
            this.jWI.setForumName(bundle.getString("forum_name"));
            this.jWI.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWI.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWI.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSp = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWI.setIsAddition(this.kSp != null);
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
            this.jWI.setTitle(bundle.getString("write_title"));
            this.jWI.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gNW = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kSh = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.gmp = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gmq = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = string;
        } else {
            Intent intent = getIntent();
            this.jWI.setType(intent.getIntExtra("type", 0));
            this.jWI.setForumId(intent.getStringExtra("forum_id"));
            this.jWI.setForumName(intent.getStringExtra("forum_name"));
            this.jWI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWI.setThreadId(intent.getStringExtra("thread_id"));
            this.kSp = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWI.setIsAddition(this.kSp != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jWI.setTitle(intent.getStringExtra("write_title"));
            this.jWI.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gNW = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kSh = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.gmp = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gmq = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWI.getType() == 4 ? 6 : 9);
        this.jWI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kSh != null && this.kSh.videoId != null) {
            this.jWI.setVideoId(this.kSh.videoId);
            this.jWI.setOriginalVideoCover(this.kSh.showPicUrl);
            this.jWI.setOriginalVideoTitle(this.kSh.showText);
        }
        if (!aq.isEmpty(this.gmp)) {
            if (!aq.isEmpty(this.gmq)) {
                this.jWI.setContent("//@" + this.gmq + " :" + this.gmp);
            } else {
                this.jWI.setContent(this.gmp);
            }
        }
        if (this.jWI != null && this.jWI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSi = true;
        }
        cVS();
    }

    private void cWb() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXa.setText(com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName)));
            this.jXa.setMovementMethod(com.baidu.tieba.view.c.cTs());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vI = com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName));
            if (vI != null) {
                this.jXa.setText(vI);
            }
            this.kSD.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWI.getType());
        bundle.putString("forum_id", this.jWI.getForumId());
        bundle.putString("forum_name", this.jWI.getForumName());
        bundle.putString("forum_first_dir", this.jWI.getFirstDir());
        bundle.putString("forum_second_dir", this.jWI.getSecondDir());
        bundle.putString("thread_id", this.jWI.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kSp != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSp));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gNW);
        if (this.kSh != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kSh));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cVY().getEditableText().toString();
        if (obj != null) {
            cVY().setText(TbFaceManager.aPN().a(getPageContext().getPageActivity(), obj, this.kSI));
            cVY().setSelection(cVY().getText().length());
        }
    }

    private String cWc() {
        if (cVY() == null || cVY().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cVY().getText().toString())) {
            if (this.kSh != null && this.kSh.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cVY().getText().toString();
    }

    private String cWd() {
        if (this.jWI == null || cVZ() == null || cVZ().getVisibility() != 0 || cVZ().getText() == null) {
            return "";
        }
        String obj = cVZ().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWJ != 0 && this.jWI.getType() != 4 && this.jXg != null && this.jXg.getText() != null) {
            obj = this.jXg.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWI.getTitle();
        }
        return obj;
    }

    private void cWe() {
        cHQ();
        this.jWI.setContent(cWc());
        this.jWI.setTitle(cWd());
        if (this.kSw >= 0) {
            this.jWI.setCategoryFrom(this.kSw);
        }
        if (this.kSy >= 0) {
            this.jWI.setCategoryTo(this.kSy);
        }
        this.jWI.setWriteImagesInfo(this.writeImagesInfo);
        this.jWI.setHasLocationData(this.dyk != null && this.dyk.brj());
        this.dyl.sS(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kSC != null && this.kSC.mIsGlobalBlock == 0) {
            this.jWI.setForumId(String.valueOf(this.kSC.mForumId));
            this.jWI.setForumName(this.kSC.mForumName);
        }
        this.dyl.d(this.jWI);
        this.jWI.setContent(this.jWI.getContent().replaceAll("\u0000\n", ""));
        this.jWI.setContent(this.jWI.getContent().replaceAll("\u0000", ""));
        this.jWI.setVcode(null);
        this.dyl.cHS().setVoice(null);
        this.dyl.cHS().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.gfk);
        this.dyl.cMh();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kSp != null) {
                i2 = this.kSp.getTotalCount();
                i = this.kSp.getAlreadyCount() + 1;
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
                if (this.dwF != null && !this.dwF.aOt()) {
                    cVY().requestFocus();
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
                            cVY().getText().insert(cVY().getSelectionStart(), sb.toString());
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
                        if (this.kSg) {
                            sb2.append(com.baidu.tbadk.plugins.b.dFy);
                            this.kSg = false;
                        }
                        sb2.append(stringExtra);
                        vh(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kSC = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kSC);
            }
        } else if (i2 == 0) {
            if (this.dwF != null && !this.dwF.aOt()) {
                this.jXe.requestFocus();
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
                        this.kSG.KK(postWriteCallBackData.getErrorString());
                        this.kSG.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSG.b(this.jXa, this.jXe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSf)) {
                        cVZ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSf)) {
                        cVY().requestFocus();
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
    public void cWf() {
        if ("1".equals(this.gNW)) {
            this.jWI.setCanNoForum(true);
            this.jWI.setTransmitForumData("[]");
        } else if ("2".equals(this.gNW)) {
            this.jWI.setCanNoForum(false);
        }
        cWg();
        this.jWI.setPrivacy(this.isPrivacy);
        this.jWI.setIsShareThread(true);
        if (this.kSh != null && !StringUtils.isNull(this.kSh.threadId)) {
            this.jWI.setOriginalThreadId(this.kSh.threadId);
        }
        this.jWI.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kSh != null) {
            this.jWI.setOriBaijiahaoData(this.kSh.oriUgcInfo);
        }
        this.jWI.setCallFrom(this.gNW);
        cWe();
    }

    private void cWg() {
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cVZ());
        HidenSoftKeyPad(this.mInputManager, cVY());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gpq) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jWI.getType() != 7) {
                if (this.kSp == null) {
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
        this.dyq = i;
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWh() {
        if (!this.kSB && this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dwF.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSn.size()) {
            for (int i2 = 0; i2 < this.kSn.size(); i2++) {
                this.kSn.get(i2).tK(false);
            }
            this.kSn.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        this.jWJ = i;
        this.jXh.setCurrentIndex(i);
        Es(i);
        this.jXg.setText(this.mPrefixData.getPrefixs().get(i));
        cHZ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXj.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes13.dex */
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
        if (this.jWI != null) {
            if (this.jWI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWI.getType() == 5) {
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
            aOT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auD = z;
        if (this.kSF != null && !z) {
            this.kSF.byH();
        }
        if (this.kSH != null && !z) {
            cVK();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.auD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kSg = false;
            this.kSf = "";
            if ("from_content".equals(str)) {
                this.kSf = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSf = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vH(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDf() {
        if (!v.isEmpty(this.mList)) {
            this.kSk.setVisibility(0);
            this.kSk.requestFocus();
            return;
        }
        this.kSk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWi() {
        if (((ImageSpan[]) cVY().getText().getSpans(0, cVY().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kSo == null) {
                this.kSo = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSo.getView().isShown()) {
                this.kSo.cancel();
            }
            this.kSo.show();
            return true;
        }
        return false;
    }
}
