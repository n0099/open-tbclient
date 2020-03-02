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
    private EditorTools dwG;
    private LocationModel dyl;
    private NewWriteModel dym;
    private String gmr;
    private String gms;
    private boolean isPrivacy;
    private int jWL;
    private TextView jXi;
    private com.baidu.tieba.write.h jXj;
    private ImageView jXk;
    private View jXl;
    private int kSA;
    private PostCategoryView kSB;
    private HotTopicBussinessData kSE;
    private TextView kSF;
    private com.baidu.tieba.write.editor.b kSH;
    private e kSJ;
    private com.baidu.tieba.view.b kSQ;
    private OriginalThreadInfo.ShareInfo kSj;
    private LinearLayout kSl;
    private LinearLayout kSm;
    private View kSo;
    private Toast kSq;
    private AdditionData kSr;
    private RelativeLayout kSs;
    private TextView kSt;
    private TextView kSu;
    private TextView kSv;
    List<w> kSw;
    w kSx;
    private int kSy;
    private String kSz;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kSh = "";
    private boolean kSi = false;
    private WriteData jWK = null;
    private boolean kSk = false;
    private InputMethodManager mInputManager = null;
    private EditText jXc = null;
    private View jXd = null;
    private LinearLayout jXf = null;
    private EditText jXg = null;
    private FeedBackModel kSn = null;
    private ArrayList<WritePrefixItemLayout> kSp = new ArrayList<>();
    private final KeyEvent gav = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jXh = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfm = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout hrZ = null;
    private String dyq = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyr = 0;
    private View mRootView = null;
    private ScrollView kSC = null;
    private boolean kSD = false;
    private com.baidu.tbadk.core.view.a dFT = null;
    private String mFrom = "write";
    private String gNY = "2";
    private SpannableStringBuilder kSG = new SpannableStringBuilder();
    private boolean auD = false;
    private final b kSI = new b();
    private TbFaceManager.a kSK = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a gps = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jWK != null) {
                TransmitPostEditActivity.this.kSI.aU(null);
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
                    TransmitPostEditActivity.this.kSI.KK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kSI.aU(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kSI.b(TransmitPostEditActivity.this.jXc, TransmitPostEditActivity.this.jXg);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJG());
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dyy = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPk() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLE())) {
                TransmitPostEditActivity.this.a(2, true, aVar.cLE());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kiW = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.dyl.sQ(false);
                    TransmitPostEditActivity.this.dyl.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.dyl.sQ(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSL = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSM = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVJ = TransmitPostEditActivity.this.cVJ();
            if (cVJ >= 0 && cVJ < TransmitPostEditActivity.this.jXg.getText().length()) {
                TransmitPostEditActivity.this.jXg.setSelection(cVJ);
            }
        }
    };
    private boolean kSN = true;
    private final View.OnFocusChangeListener eVW = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jXc || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jXh) {
                if (z) {
                    TransmitPostEditActivity.this.kSN = true;
                    TransmitPostEditActivity.this.cVK();
                    if (TransmitPostEditActivity.this.dwG != null) {
                        TransmitPostEditActivity.this.dwG.aMQ();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXc);
                } else if (view == TransmitPostEditActivity.this.jXc) {
                    TransmitPostEditActivity.this.jXi.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jXg && z) {
                TransmitPostEditActivity.this.kSN = false;
                TransmitPostEditActivity.this.cVK();
                TransmitPostEditActivity.this.dwG.aMQ();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXg);
            }
            TransmitPostEditActivity.this.cVP();
        }
    };
    private TextWatcher kSO = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kSS = "";
        private String kST;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kST = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kST != null ? this.kST.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIb();
            TransmitPostEditActivity.this.cVQ();
            EditText cWb = TransmitPostEditActivity.this.cWb();
            if (editable != null && cWb != null && cWb.getText() != null) {
                if (this.kSS == null || !this.kSS.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSI != null) {
                        this.kSS = cWb.getText().toString();
                        TransmitPostEditActivity.this.kSI.b(cWb, true);
                        return;
                    }
                    return;
                }
                cWb.setSelection(cWb.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSP = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kST;
        private String kSU = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kST = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kST != null ? this.kST.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIb();
            EditText cWa = TransmitPostEditActivity.this.cWa();
            if (editable != null && cWa != null && cWa.getText() != null) {
                int selectionEnd = cWa.getSelectionEnd();
                if (this.kSU == null || !this.kSU.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSI != null) {
                        this.kSU = cWa.getText().toString();
                        TransmitPostEditActivity.this.kSI.b(cWa, false);
                        return;
                    }
                    return;
                }
                cWa.setSelection(selectionEnd);
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
    public void aOU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOX();
        } else if (this.dyl.cLL()) {
            aOU();
        } else {
            this.dyl.sQ(false);
            a(1, true, (String) null);
            this.dyl.cLJ();
        }
    }

    private void aOX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.dyl.cLN();
                } else {
                    TransmitPostEditActivity.this.dyy.aPk();
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
        aVar.aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cVJ() {
        int selectionEnd = cWa().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWa().getText().getSpans(0, cWa().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWa().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWa().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVK() {
        if (this.dwG != null) {
            this.dwG.setBarLauncherEnabled(!this.kSN);
            this.dwG.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kSD) {
            this.jXc.setVisibility(8);
            cIb();
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
        this.dyl = new LocationModel(getPageContext());
        this.dyl.a(this.dyy);
        registerListener(this.kiW);
        registerListener(this.kSL);
        cfM();
        this.jXg.requestFocus();
        cDh();
        cWj();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfM() {
        this.dwG = new EditorTools(getActivity());
        this.dwG.setBarMaxLauCount(4);
        this.dwG.setMoreButtonAtEnd(true);
        this.dwG.setBarLauncherType(1);
        this.dwG.gB(true);
        this.dwG.gC(true);
        this.dwG.setBackgroundColorId(R.color.cp_bg_line_h);
        cVL();
        this.dwG.build();
        if (this.kSl != null) {
            this.kSl.addView(this.dwG);
        }
        bZP();
        this.dwG.display();
        com.baidu.tbadk.editortools.g mm = this.dwG.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyq)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.dyq);
                }
            });
        }
        if (!this.kSD) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwG.aMQ();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jWK.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWK.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cVN();
    }

    private void cVL() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dwG.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dwG.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dxq = 4;
            lVar.dxm = R.drawable.icon_post_location_selector;
            lVar.dxo = false;
            this.dwG.b(lVar);
        }
        if (this.kSr == null) {
            if (this.kSH == null) {
                this.kSH = new com.baidu.tieba.write.editor.b(getActivity(), this.gNY);
                this.kSH.cUM();
                this.kSH.setFrom("from_share_write");
                this.kSH.bz(this.jWK.getForumId(), this.mPrivateThread);
            }
            this.dwG.b(this.kSH);
        }
        this.dwG.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwG.mp(5);
        if (mp != null) {
            mp.dxq = 1;
        }
    }

    private void bZP() {
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
                        if (TransmitPostEditActivity.this.cVZ()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cVZ()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cWc();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cIb();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kSr == null) {
                            TransmitPostEditActivity.this.aOY();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.dyr) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aOV();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aOU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.dyl != null) {
                            TransmitPostEditActivity.this.dyl.sQ(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jWK != null) {
                            str = TransmitPostEditActivity.this.jWK.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jWK == null || (videoInfo = TransmitPostEditActivity.this.jWK.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dwG.aOv()) {
                                        TransmitPostEditActivity.this.dwG.aMQ();
                                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jWK.setVideoInfo(null);
                        TransmitPostEditActivity.this.cIb();
                        if (TransmitPostEditActivity.this.jXg != null) {
                            TransmitPostEditActivity.this.jXg.requestFocus();
                        }
                        TransmitPostEditActivity.this.dwG.aMQ();
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXg);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kSi = true;
                        TransmitPostEditActivity.this.tS(true);
                        if (TransmitPostEditActivity.this.cWb().isFocused()) {
                            TransmitPostEditActivity.this.kSh = "from_title";
                        } else if (TransmitPostEditActivity.this.cWa().isFocused()) {
                            TransmitPostEditActivity.this.kSh = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kSm.setVisibility(0);
                        TransmitPostEditActivity.this.kSm.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kSm.hasFocus()) {
                            TransmitPostEditActivity.this.jXg.requestFocus();
                            TransmitPostEditActivity.this.jXg.setSelection(TransmitPostEditActivity.this.jXg.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kSm.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dwG.setActionListener(31, bVar);
        this.dwG.setActionListener(16, bVar);
        this.dwG.setActionListener(14, bVar);
        this.dwG.setActionListener(24, bVar);
        this.dwG.setActionListener(3, bVar);
        this.dwG.setActionListener(10, bVar);
        this.dwG.setActionListener(11, bVar);
        this.dwG.setActionListener(12, bVar);
        this.dwG.setActionListener(13, bVar);
        this.dwG.setActionListener(15, bVar);
        this.dwG.setActionListener(18, bVar);
        this.dwG.setActionListener(20, bVar);
        this.dwG.setActionListener(25, bVar);
        this.dwG.setActionListener(27, bVar);
        this.dwG.setActionListener(29, bVar);
        this.dwG.setActionListener(43, bVar);
        this.dwG.setActionListener(45, bVar);
        this.dwG.setActionListener(53, bVar);
        this.dwG.setActionListener(48, bVar);
        this.dwG.setActionListener(46, bVar);
        this.dwG.setActionListener(49, bVar);
        this.dwG.setActionListener(47, bVar);
        this.dwG.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOY() {
        if (this.dyl.brl()) {
            if (this.dyl.cLL()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLG().getLocationData().cLE());
                return;
            }
            a(1, true, (String) null);
            this.dyl.cLJ();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHS() {
        if (this.dym != null) {
            this.dym.cancelLoadData();
        }
        if (this.kSn != null) {
            this.kSn.cancelLoadData();
        }
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
    }

    private void cVM() {
        if (this.kSJ != null) {
            this.kSJ.hideTip();
        }
    }

    private void cVN() {
        if (this.kSJ == null) {
            this.kSJ = new e(getPageContext());
        }
        this.kSJ.c(this.dwG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVM();
        TiebaPrepareImageService.StopService();
        cHS();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVO() {
        if (this.jWK == null) {
            finish();
            return;
        }
        this.jWK.setTitle(cWb().getText().toString());
        this.jWK.setContent(cWa().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXj != null && this.jXj.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXj, getPageContext().getPageActivity());
                return true;
            } else if (this.dwG.aOv()) {
                this.dwG.aMQ();
                return true;
            } else {
                cHS();
                cVO();
                return true;
            }
        }
        if (i == 67 && (text = cWa().getText()) != null) {
            int selectionStart = cWa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWa().onKeyDown(67, this.gav);
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
        getLayoutMode().onModeChanged(this.hrZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXh, R.color.cp_link_tip_a, 1);
        cVK();
        am.setBackgroundColor(this.jXd, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWb(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cWa(), R.color.cp_bg_line_d);
        cIb();
        this.dwG.onChangeSkinType(i);
        if (this.kSB != null) {
            this.kSB.aHN();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cVP();
        cVQ();
        if (this.kSI != null) {
            this.kSI.c(cWb(), cWa());
        }
        this.Mv.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        if (this.jXc.hasFocus()) {
            this.jXc.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXc.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXg.hasFocus()) {
            this.jXg.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXg.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        if (this.jXc != null) {
            if (this.jXc.getText().toString().length() == 0) {
                this.jXc.getPaint().setFakeBoldText(false);
            } else if (this.jXc.getText().toString().length() > 0) {
                this.jXc.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dFT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSD = this.jWK.getType() == 4 || 5 == this.jWK.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cVS();
        this.kSC = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jXg != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jXg);
                    }
                    if (TransmitPostEditActivity.this.dwG != null) {
                        TransmitPostEditActivity.this.dwG.aMQ();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hrZ = (RelativeLayout) findViewById(R.id.parent);
        this.kSl = (LinearLayout) findViewById(R.id.tool_view);
        this.kSl.setContentDescription(IStringUtil.TOP_PATH);
        this.kSm = (LinearLayout) findViewById(R.id.title_view);
        this.jXd = findViewById(R.id.interval_view);
        this.kSF = (TextView) findViewById(R.id.hot_topic_title_edt);
        cIa();
        if (this.kSD) {
            this.kSC.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cIc();
        cVY();
        this.jXf = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXf.setDrawingCacheEnabled(false);
        this.jXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jXg.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eVW);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cHS();
                TransmitPostEditActivity.this.cVO();
            }
        });
        cVV();
        cVX();
        cVR();
        cVK();
        cVW();
        cHZ();
        cWd();
        if (this.jWK.getType() == 4 && this.jXl != null && this.kSo != null) {
            this.jXl.setVisibility(8);
            this.kSo.setVisibility(8);
        }
        cIb();
        ShowSoftKeyPad(this.mInputManager, this.jXc);
    }

    private void cVR() {
        String str;
        String str2;
        if (this.jWK != null) {
            switch (this.jWK.getType()) {
                case 0:
                case 9:
                    if (this.gNY != null && this.gNY.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gNY != null && this.gNY.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jWK.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jXc.setVisibility(0);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXc.setVisibility(8);
                    return;
            }
        }
    }

    private void cVS() {
        this.jXh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXh.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXh.setLayoutParams(layoutParams);
        this.jXh.setOnFocusChangeListener(this.eVW);
    }

    private void cVT() {
        if (this.jWK != null && this.jWK.getType() == 0 && this.jWK.getType() == 9 && !this.kSk && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWb() != null) {
                cWb().setText(cutStringWithSuffix);
                cWb().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cVU() {
        this.kSw = null;
        this.kSy = -1;
        this.kSA = -1;
        y sY = x.bFD().sY(1);
        if (sY != null) {
            this.kSw = sY.grV;
            this.kSy = getIntent().getIntExtra("category_id", -1);
            if (this.kSw != null && !this.kSw.isEmpty() && this.kSy >= 0) {
                this.kSx = new w();
                this.kSx.grR = 0;
                this.kSx.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSA = this.kSx.grR;
                this.kSz = this.kSx.name;
                for (w wVar : this.kSw) {
                    if (wVar.grR == this.kSy) {
                        this.kSA = wVar.grR;
                        this.kSz = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVV() {
        if (this.kSw != null && !this.kSw.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSB = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSB.setText(this.kSz);
            this.kSB.setCategoryContainerData(this.kSw, this.kSx, this.kSA);
            this.kSB.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        TransmitPostEditActivity.this.kSB.setText(asVar.name);
                        TransmitPostEditActivity.this.jWK.setCategoryTo(asVar.grR);
                        TransmitPostEditActivity.this.kSA = asVar.grR;
                        TransmitPostEditActivity.this.kSB.cVx();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kSB.cVw();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWa());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSQ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSQ.setTitle(R.string.no_disturb_start_time);
        this.kSQ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSQ);
        this.kSQ.setButton(-2, getPageContext().getString(R.string.cancel), this.kSQ);
        return this.kSQ;
    }

    private void cVW() {
        this.kSs = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSt = (TextView) findViewById(R.id.addition_create_time);
        this.kSu = (TextView) findViewById(R.id.addition_last_time);
        this.kSv = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSr != null) {
            this.kSs.setVisibility(0);
            this.kSt.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSr.getCreateTime() * 1000));
            if (this.kSr.getAlreadyCount() == 0) {
                this.kSu.setVisibility(8);
            } else {
                this.kSu.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSr.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSr.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSv.setText(lastAdditionContent);
            } else {
                this.kSv.setVisibility(8);
            }
            cWa().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSr.getAlreadyCount()), Integer.valueOf(this.kSr.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSs.setVisibility(8);
    }

    private void cHZ() {
        this.jXl = findViewById(R.id.post_prefix_layout);
        this.jXi = (TextView) findViewById(R.id.post_prefix);
        this.kSo = findViewById(R.id.prefix_divider);
        this.jXk = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXl.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWL = 1;
            this.jXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jXi.setVisibility(0);
                    TransmitPostEditActivity.this.jXl.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXj, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dwG.aMQ();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXc);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXg);
                }
            });
            this.jXk = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXk.setVisibility(0);
                this.jXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jXi.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXj, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dwG.aMQ();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWa());
                    }
                });
            }
            this.jXj = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXj.a(this);
            this.jXj.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXj.setOutsideTouchable(true);
            this.jXj.setFocusable(true);
            this.jXj.setOnDismissListener(this);
            this.jXj.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXi, R.color.cp_bg_line_d);
            am.setImageResource(this.jXk, R.drawable.icon_frs_arrow_n);
            this.jXi.setTextColor(color);
            this.kSp.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSp.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jXj.addView(writePrefixItemLayout);
            }
            this.jXj.setCurrentIndex(0);
            this.jXi.setText(prefixs.get(1));
            Es(1);
            return;
        }
        this.jXl.setVisibility(8);
    }

    protected void cVX() {
        this.jXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cWk()) {
                    if (TransmitPostEditActivity.this.kSI.a(TransmitPostEditActivity.this.jXc, TransmitPostEditActivity.this.jXg)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kSI.cUg());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWa());
                    TransmitPostEditActivity.this.dwG.aMQ();
                    TiebaStatic.log(new an("c12608").X("obj_locate", 7));
                    TransmitPostEditActivity.this.cWh();
                }
            }
        });
    }

    protected void cIa() {
        this.jXc = (EditText) findViewById(R.id.post_title);
        this.jXc.setOnClickListener(this.kSM);
        this.jXc.setOnFocusChangeListener(this.eVW);
        if ((this.jWK.getType() == 0 || this.jWK.getType() == 9 || this.jWK.getType() == 7) && this.jWK.getTitle() != null) {
            this.jXc.setText(this.jWK.getTitle());
            this.jXc.setSelection(this.jWK.getTitle().length());
        }
        this.jXc.addTextChangedListener(this.kSO);
        if (!this.jWK.getHaveDraft()) {
            cVT();
        }
        this.jXc.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cIc() {
        this.jXg = (EditText) findViewById(R.id.post_content);
        this.jXg.setDrawingCacheEnabled(false);
        this.jXg.setOnClickListener(this.kSM);
        if (this.jWK.getContent() != null && this.jWK.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPP().aB(getPageContext().getPageActivity(), this.jWK.getContent());
            this.jXg.setText(aB);
            this.jXg.setSelection(aB.length());
        }
        if (!aq.isEmpty(this.gmr)) {
            this.jXg.setSelection(0);
        }
        this.jXg.setOnFocusChangeListener(this.eVW);
        this.jXg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jXg.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXg.addTextChangedListener(this.kSP);
        if (this.kSj != null && this.kSj.showType == 3) {
            this.jXg.setHint(R.string.share_video_default);
        } else {
            this.jXg.setHint(R.string.share_txt_default);
        }
    }

    private void cVY() {
        this.Mv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Mv.setVisibility(0);
        this.Mv.a(this.kSj);
        this.Mv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVZ() {
        int i = 5000;
        if (this.kSr != null) {
            i = 1000;
        }
        return cWa().getText() != null && cWa().getText().length() >= i;
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSh)) {
                this.kSh = "";
                cWa().requestFocus();
                if (cWa().getText() != null && cWa().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWa().getSelectionStart();
                    editable = cWa().getText();
                }
            } else if ("from_title".equals(this.kSh)) {
                this.kSh = "";
                cWb().requestFocus();
                if (cWb().getText() != null && cWb().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWb().getSelectionStart();
                    editable = cWb().getText();
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
            if (this.jWK != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWK.getForumId(), 0L), this.jWK.getFirstDir(), this.jWK.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWa().getText().getSpans(0, cWa().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSq == null) {
                this.kSq = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSq.getView().isShown()) {
                this.kSq.cancel();
            }
            this.kSq.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJw = qVar.aJw();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cWa().getSelectionStart(), aVar, aJw);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWa() != null && cWa().getText() != null) {
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
                int selectionStart = cWa().getSelectionStart() - 1;
                if (cWa().getText().length() > 1 && selectionStart >= 0 && cWa().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWa().getText().insert(cWa().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWa().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWa().getText().insert(cWa().getSelectionStart(), spannableString2);
            }
            Editable text = cWa().getText();
            if (text != null) {
                this.kSG.clear();
                this.kSG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSG);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWa().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWa().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWa().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWa() {
        return this.jXg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWb() {
        return this.jXc;
    }

    protected void cWc() {
        Editable text;
        if (cWa() != null && (text = cWa().getText()) != null) {
            int selectionStart = cWa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWa().onKeyDown(67, this.gav);
            }
            cWa().onKeyDown(67, this.gav);
            int selectionStart2 = cWa().getSelectionStart();
            this.kSG.clear();
            this.kSG.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kSG);
            cWa().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dFT.setCancelListener(null);
        this.dFT.setTipString(R.string.sending);
        this.dFT.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dFT.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIb() {
        if (this.jWK != null) {
            String str = "";
            String str2 = "";
            if (cWb() != null) {
                str = cWb().getText().toString();
            }
            if (cWa() != null) {
                str2 = cWa().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWK.getType() == 0 || this.jWK.getType() == 9 || this.jWK.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jWL == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWK.setIsNoTitle(true);
                        } else {
                            this.jWK.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else {
                        this.jWK.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWK.setIsNoTitle(true);
                } else {
                    this.jWK.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSD) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tT(true);
            } else if (this.jWK.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    private void tT(boolean z) {
        am.setNavbarTitleColor(this.jXh, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.dym = new NewWriteModel(this);
        this.dym.b(this.dyA);
        this.gfm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cHS();
            }
        };
        this.jWK = new WriteData();
        if (bundle != null) {
            this.jWK.setType(bundle.getInt("type", 0));
            this.jWK.setForumId(bundle.getString("forum_id"));
            this.jWK.setForumName(bundle.getString("forum_name"));
            this.jWK.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWK.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWK.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSr = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWK.setIsAddition(this.kSr != null);
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
            this.jWK.setTitle(bundle.getString("write_title"));
            this.jWK.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gNY = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kSj = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.gmr = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gms = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = string;
        } else {
            Intent intent = getIntent();
            this.jWK.setType(intent.getIntExtra("type", 0));
            this.jWK.setForumId(intent.getStringExtra("forum_id"));
            this.jWK.setForumName(intent.getStringExtra("forum_name"));
            this.jWK.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWK.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWK.setThreadId(intent.getStringExtra("thread_id"));
            this.kSr = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWK.setIsAddition(this.kSr != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jWK.setTitle(intent.getStringExtra("write_title"));
            this.jWK.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gNY = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kSj = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.gmr = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gms = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWK.getType() == 4 ? 6 : 9);
        this.jWK.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kSj != null && this.kSj.videoId != null) {
            this.jWK.setVideoId(this.kSj.videoId);
            this.jWK.setOriginalVideoCover(this.kSj.showPicUrl);
            this.jWK.setOriginalVideoTitle(this.kSj.showText);
        }
        if (!aq.isEmpty(this.gmr)) {
            if (!aq.isEmpty(this.gms)) {
                this.jWK.setContent("//@" + this.gms + " :" + this.gmr);
            } else {
                this.jWK.setContent(this.gmr);
            }
        }
        if (this.jWK != null && this.jWK.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWK.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSk = true;
        }
        cVU();
    }

    private void cWd() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXc.setText(com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName)));
            this.jXc.setMovementMethod(com.baidu.tieba.view.c.cTu());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vI = com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName));
            if (vI != null) {
                this.jXc.setText(vI);
            }
            this.kSF.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWK.getType());
        bundle.putString("forum_id", this.jWK.getForumId());
        bundle.putString("forum_name", this.jWK.getForumName());
        bundle.putString("forum_first_dir", this.jWK.getFirstDir());
        bundle.putString("forum_second_dir", this.jWK.getSecondDir());
        bundle.putString("thread_id", this.jWK.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kSr != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSr));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gNY);
        if (this.kSj != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kSj));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWa().getEditableText().toString();
        if (obj != null) {
            cWa().setText(TbFaceManager.aPP().a(getPageContext().getPageActivity(), obj, this.kSK));
            cWa().setSelection(cWa().getText().length());
        }
    }

    private String cWe() {
        if (cWa() == null || cWa().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cWa().getText().toString())) {
            if (this.kSj != null && this.kSj.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cWa().getText().toString();
    }

    private String cWf() {
        if (this.jWK == null || cWb() == null || cWb().getVisibility() != 0 || cWb().getText() == null) {
            return "";
        }
        String obj = cWb().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWL != 0 && this.jWK.getType() != 4 && this.jXi != null && this.jXi.getText() != null) {
            obj = this.jXi.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWK.getTitle();
        }
        return obj;
    }

    private void cWg() {
        cHS();
        this.jWK.setContent(cWe());
        this.jWK.setTitle(cWf());
        if (this.kSy >= 0) {
            this.jWK.setCategoryFrom(this.kSy);
        }
        if (this.kSA >= 0) {
            this.jWK.setCategoryTo(this.kSA);
        }
        this.jWK.setWriteImagesInfo(this.writeImagesInfo);
        this.jWK.setHasLocationData(this.dyl != null && this.dyl.brl());
        this.dym.sS(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kSE != null && this.kSE.mIsGlobalBlock == 0) {
            this.jWK.setForumId(String.valueOf(this.kSE.mForumId));
            this.jWK.setForumName(this.kSE.mForumName);
        }
        this.dym.d(this.jWK);
        this.jWK.setContent(this.jWK.getContent().replaceAll("\u0000\n", ""));
        this.jWK.setContent(this.jWK.getContent().replaceAll("\u0000", ""));
        this.jWK.setVcode(null);
        this.dym.cHU().setVoice(null);
        this.dym.cHU().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.gfm);
        this.dym.cMj();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kSr != null) {
                i2 = this.kSr.getTotalCount();
                i = this.kSr.getAlreadyCount() + 1;
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
                if (this.dwG != null && !this.dwG.aOv()) {
                    cWa().requestFocus();
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
                            cWa().getText().insert(cWa().getSelectionStart(), sb.toString());
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
                        if (this.kSi) {
                            sb2.append(com.baidu.tbadk.plugins.b.dFz);
                            this.kSi = false;
                        }
                        sb2.append(stringExtra);
                        vh(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kSE = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kSE);
            }
        } else if (i2 == 0) {
            if (this.dwG != null && !this.dwG.aOv()) {
                this.jXg.requestFocus();
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
                        this.kSI.KK(postWriteCallBackData.getErrorString());
                        this.kSI.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSI.b(this.jXc, this.jXg);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSh)) {
                        cWb().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSh)) {
                        cWa().requestFocus();
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
    public void cWh() {
        if ("1".equals(this.gNY)) {
            this.jWK.setCanNoForum(true);
            this.jWK.setTransmitForumData("[]");
        } else if ("2".equals(this.gNY)) {
            this.jWK.setCanNoForum(false);
        }
        cWi();
        this.jWK.setPrivacy(this.isPrivacy);
        this.jWK.setIsShareThread(true);
        if (this.kSj != null && !StringUtils.isNull(this.kSj.threadId)) {
            this.jWK.setOriginalThreadId(this.kSj.threadId);
        }
        this.jWK.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kSj != null) {
            this.jWK.setOriBaijiahaoData(this.kSj.oriUgcInfo);
        }
        this.jWK.setCallFrom(this.gNY);
        cWg();
    }

    private void cWi() {
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWb());
        HidenSoftKeyPad(this.mInputManager, cWa());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gps) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jWK.getType() != 7) {
                if (this.kSr == null) {
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
        this.dyr = i;
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWj() {
        if (!this.kSD && this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dwG.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSp.size()) {
            for (int i2 = 0; i2 < this.kSp.size(); i2++) {
                this.kSp.get(i2).tK(false);
            }
            this.kSp.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        this.jWL = i;
        this.jXj.setCurrentIndex(i);
        Es(i);
        this.jXi.setText(this.mPrefixData.getPrefixs().get(i));
        cIb();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXj, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXl.setSelected(false);
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
        if (this.jWK != null) {
            if (this.jWK.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWK.getType() == 5) {
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
            aOV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auD = z;
        if (this.kSH != null && !z) {
            this.kSH.byJ();
        }
        if (this.kSJ != null && !z) {
            cVM();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.auD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kSi = false;
            this.kSh = "";
            if ("from_content".equals(str)) {
                this.kSh = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSh = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vH(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDh() {
        if (!v.isEmpty(this.mList)) {
            this.kSm.setVisibility(0);
            this.kSm.requestFocus();
            return;
        }
        this.kSm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWk() {
        if (((ImageSpan[]) cWa().getText().getSpans(0, cWa().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kSq == null) {
                this.kSq = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSq.getView().isShown()) {
                this.kSq.cancel();
            }
            this.kSq.show();
            return true;
        }
        return false;
    }
}
