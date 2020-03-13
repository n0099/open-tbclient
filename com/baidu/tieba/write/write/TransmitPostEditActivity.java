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
    private EditorTools dwT;
    private LocationModel dyy;
    private NewWriteModel dyz;
    private String gmE;
    private String gmF;
    private boolean isPrivacy;
    private int jWX;
    private TextView jXu;
    private com.baidu.tieba.write.h jXv;
    private ImageView jXw;
    private View jXx;
    private View kSA;
    private Toast kSC;
    private AdditionData kSD;
    private RelativeLayout kSE;
    private TextView kSF;
    private TextView kSG;
    private TextView kSH;
    List<w> kSI;
    w kSJ;
    private int kSK;
    private String kSL;
    private int kSM;
    private PostCategoryView kSN;
    private HotTopicBussinessData kSQ;
    private TextView kSR;
    private com.baidu.tieba.write.editor.b kST;
    private e kSV;
    private OriginalThreadInfo.ShareInfo kSv;
    private LinearLayout kSx;
    private LinearLayout kSy;
    private com.baidu.tieba.view.b kTc;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kSt = "";
    private boolean kSu = false;
    private WriteData jWW = null;
    private boolean kSw = false;
    private InputMethodManager mInputManager = null;
    private EditText jXo = null;
    private View jXp = null;
    private LinearLayout jXr = null;
    private EditText jXs = null;
    private FeedBackModel kSz = null;
    private ArrayList<WritePrefixItemLayout> kSB = new ArrayList<>();
    private final KeyEvent gaI = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jXt = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfz = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout hsl = null;
    private String dyD = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyE = 0;
    private View mRootView = null;
    private ScrollView kSO = null;
    private boolean kSP = false;
    private com.baidu.tbadk.core.view.a dGg = null;
    private String mFrom = "write";
    private String gOk = "2";
    private SpannableStringBuilder kSS = new SpannableStringBuilder();
    private boolean auE = false;
    private final b kSU = new b();
    private TbFaceManager.a kSW = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan vw(String str) {
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
    private final AntiHelper.a gpF = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jWW != null) {
                TransmitPostEditActivity.this.kSU.aU(null);
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
                    TransmitPostEditActivity.this.kSU.KL(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kSU.aU(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kSU.b(TransmitPostEditActivity.this.jXo, TransmitPostEditActivity.this.jXs);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJH());
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dyL = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPl() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLF())) {
                TransmitPostEditActivity.this.a(2, true, aVar.cLF());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kji = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.dyy.sQ(false);
                    TransmitPostEditActivity.this.dyy.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.dyy.sQ(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSX = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSY = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVK = TransmitPostEditActivity.this.cVK();
            if (cVK >= 0 && cVK < TransmitPostEditActivity.this.jXs.getText().length()) {
                TransmitPostEditActivity.this.jXs.setSelection(cVK);
            }
        }
    };
    private boolean kSZ = true;
    private final View.OnFocusChangeListener eWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jXo || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jXt) {
                if (z) {
                    TransmitPostEditActivity.this.kSZ = true;
                    TransmitPostEditActivity.this.cVL();
                    if (TransmitPostEditActivity.this.dwT != null) {
                        TransmitPostEditActivity.this.dwT.aMR();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXo);
                } else if (view == TransmitPostEditActivity.this.jXo) {
                    TransmitPostEditActivity.this.jXu.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jXs && z) {
                TransmitPostEditActivity.this.kSZ = false;
                TransmitPostEditActivity.this.cVL();
                TransmitPostEditActivity.this.dwT.aMR();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jXs);
            }
            TransmitPostEditActivity.this.cVQ();
        }
    };
    private TextWatcher kTa = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kTe = "";
        private String kTf;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kTf = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kTf != null ? this.kTf.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIc();
            TransmitPostEditActivity.this.cVR();
            EditText cWc = TransmitPostEditActivity.this.cWc();
            if (editable != null && cWc != null && cWc.getText() != null) {
                if (this.kTe == null || !this.kTe.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSU != null) {
                        this.kTe = cWc.getText().toString();
                        TransmitPostEditActivity.this.kSU.b(cWc, true);
                        return;
                    }
                    return;
                }
                cWc.setSelection(cWc.getSelectionEnd());
            }
        }
    };
    private TextWatcher kTb = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kTf;
        private String kTg = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kTf = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kTf != null ? this.kTf.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIc();
            EditText cWb = TransmitPostEditActivity.this.cWb();
            if (editable != null && cWb != null && cWb.getText() != null) {
                int selectionEnd = cWb.getSelectionEnd();
                if (this.kTg == null || !this.kTg.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kSU != null) {
                        this.kTg = cWb.getText().toString();
                        TransmitPostEditActivity.this.kSU.b(cWb, false);
                        return;
                    }
                    return;
                }
                cWb.setSelection(selectionEnd);
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
    public void aOV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOY();
        } else if (this.dyy.cLM()) {
            aOV();
        } else {
            this.dyy.sQ(false);
            a(1, true, (String) null);
            this.dyy.cLK();
        }
    }

    private void aOY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.dyy.cLO();
                } else {
                    TransmitPostEditActivity.this.dyL.aPl();
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
    public int cVK() {
        int selectionEnd = cWb().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWb().getText().getSpans(0, cWb().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWb().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWb().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVL() {
        if (this.dwT != null) {
            this.dwT.setBarLauncherEnabled(!this.kSZ);
            this.dwT.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kSP) {
            this.jXo.setVisibility(8);
            cIc();
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
        this.dyy = new LocationModel(getPageContext());
        this.dyy.a(this.dyL);
        registerListener(this.kji);
        registerListener(this.kSX);
        cfN();
        this.jXs.requestFocus();
        cDi();
        cWk();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfN() {
        this.dwT = new EditorTools(getActivity());
        this.dwT.setBarMaxLauCount(4);
        this.dwT.setMoreButtonAtEnd(true);
        this.dwT.setBarLauncherType(1);
        this.dwT.gB(true);
        this.dwT.gC(true);
        this.dwT.setBackgroundColorId(R.color.cp_bg_line_h);
        cVM();
        this.dwT.build();
        if (this.kSx != null) {
            this.kSx.addView(this.dwT);
        }
        bZQ();
        this.dwT.display();
        com.baidu.tbadk.editortools.g mm = this.dwT.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyD)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.dyD);
                }
            });
        }
        if (!this.kSP) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwT.aMR();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jWW.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWW.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cVO();
    }

    private void cVM() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dwT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dwT.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dxD = 4;
            lVar.dxz = R.drawable.icon_post_location_selector;
            lVar.dxB = false;
            this.dwT.b(lVar);
        }
        if (this.kSD == null) {
            if (this.kST == null) {
                this.kST = new com.baidu.tieba.write.editor.b(getActivity(), this.gOk);
                this.kST.cUN();
                this.kST.setFrom("from_share_write");
                this.kST.bz(this.jWW.getForumId(), this.mPrivateThread);
            }
            this.dwT.b(this.kST);
        }
        this.dwT.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwT.mp(5);
        if (mp != null) {
            mp.dxD = 1;
        }
    }

    private void bZQ() {
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
                        if (TransmitPostEditActivity.this.cWa()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cWa()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cWd();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cIc();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kSD == null) {
                            TransmitPostEditActivity.this.aOZ();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.dyE) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aOW();
                                    return;
                                } else {
                                    ab.e(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aOV();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.dyy != null) {
                            TransmitPostEditActivity.this.dyy.sQ(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jWW != null) {
                            str = TransmitPostEditActivity.this.jWW.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jWW == null || (videoInfo = TransmitPostEditActivity.this.jWW.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dwT.aOw()) {
                                        TransmitPostEditActivity.this.dwT.aMR();
                                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jWW.setVideoInfo(null);
                        TransmitPostEditActivity.this.cIc();
                        if (TransmitPostEditActivity.this.jXs != null) {
                            TransmitPostEditActivity.this.jXs.requestFocus();
                        }
                        TransmitPostEditActivity.this.dwT.aMR();
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXs);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kSu = true;
                        TransmitPostEditActivity.this.tS(true);
                        if (TransmitPostEditActivity.this.cWc().isFocused()) {
                            TransmitPostEditActivity.this.kSt = "from_title";
                        } else if (TransmitPostEditActivity.this.cWb().isFocused()) {
                            TransmitPostEditActivity.this.kSt = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kSy.setVisibility(0);
                        TransmitPostEditActivity.this.kSy.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kSy.hasFocus()) {
                            TransmitPostEditActivity.this.jXs.requestFocus();
                            TransmitPostEditActivity.this.jXs.setSelection(TransmitPostEditActivity.this.jXs.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kSy.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dwT.setActionListener(31, bVar);
        this.dwT.setActionListener(16, bVar);
        this.dwT.setActionListener(14, bVar);
        this.dwT.setActionListener(24, bVar);
        this.dwT.setActionListener(3, bVar);
        this.dwT.setActionListener(10, bVar);
        this.dwT.setActionListener(11, bVar);
        this.dwT.setActionListener(12, bVar);
        this.dwT.setActionListener(13, bVar);
        this.dwT.setActionListener(15, bVar);
        this.dwT.setActionListener(18, bVar);
        this.dwT.setActionListener(20, bVar);
        this.dwT.setActionListener(25, bVar);
        this.dwT.setActionListener(27, bVar);
        this.dwT.setActionListener(29, bVar);
        this.dwT.setActionListener(43, bVar);
        this.dwT.setActionListener(45, bVar);
        this.dwT.setActionListener(53, bVar);
        this.dwT.setActionListener(48, bVar);
        this.dwT.setActionListener(46, bVar);
        this.dwT.setActionListener(49, bVar);
        this.dwT.setActionListener(47, bVar);
        this.dwT.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOZ() {
        if (this.dyy.brm()) {
            if (this.dyy.cLM()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLH().getLocationData().cLF());
                return;
            }
            a(1, true, (String) null);
            this.dyy.cLK();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHT() {
        if (this.dyz != null) {
            this.dyz.cancelLoadData();
        }
        if (this.kSz != null) {
            this.kSz.cancelLoadData();
        }
        if (this.dyy != null) {
            this.dyy.cancelLoadData();
        }
    }

    private void cVN() {
        if (this.kSV != null) {
            this.kSV.hideTip();
        }
    }

    private void cVO() {
        if (this.kSV == null) {
            this.kSV = new e(getPageContext());
        }
        this.kSV.c(this.dwT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVN();
        TiebaPrepareImageService.StopService();
        cHT();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        if (this.jWW == null) {
            finish();
            return;
        }
        this.jWW.setTitle(cWc().getText().toString());
        this.jWW.setContent(cWb().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXv != null && this.jXv.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXv, getPageContext().getPageActivity());
                return true;
            } else if (this.dwT.aOw()) {
                this.dwT.aMR();
                return true;
            } else {
                cHT();
                cVP();
                return true;
            }
        }
        if (i == 67 && (text = cWb().getText()) != null) {
            int selectionStart = cWb().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWb().onKeyDown(67, this.gaI);
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
        getLayoutMode().onModeChanged(this.hsl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXt, R.color.cp_link_tip_a, 1);
        cVL();
        am.setBackgroundColor(this.jXp, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWc(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cWb(), R.color.cp_bg_line_d);
        cIc();
        this.dwT.onChangeSkinType(i);
        if (this.kSN != null) {
            this.kSN.aHO();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cVQ();
        cVR();
        if (this.kSU != null) {
            this.kSU.c(cWc(), cWb());
        }
        this.Mv.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        if (this.jXo.hasFocus()) {
            this.jXo.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXo.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXs.hasFocus()) {
            this.jXs.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXs.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVR() {
        if (this.jXo != null) {
            if (this.jXo.getText().toString().length() == 0) {
                this.jXo.getPaint().setFakeBoldText(false);
            } else if (this.jXo.getText().toString().length() > 0) {
                this.jXo.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dGg = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSP = this.jWW.getType() == 4 || 5 == this.jWW.getType();
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
        cVT();
        this.kSO = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jXs != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jXs);
                    }
                    if (TransmitPostEditActivity.this.dwT != null) {
                        TransmitPostEditActivity.this.dwT.aMR();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hsl = (RelativeLayout) findViewById(R.id.parent);
        this.kSx = (LinearLayout) findViewById(R.id.tool_view);
        this.kSx.setContentDescription(IStringUtil.TOP_PATH);
        this.kSy = (LinearLayout) findViewById(R.id.title_view);
        this.jXp = findViewById(R.id.interval_view);
        this.kSR = (TextView) findViewById(R.id.hot_topic_title_edt);
        cIb();
        if (this.kSP) {
            this.kSO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cId();
        cVZ();
        this.jXr = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXr.setDrawingCacheEnabled(false);
        this.jXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jXs.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eWj);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cHT();
                TransmitPostEditActivity.this.cVP();
            }
        });
        cVW();
        cVY();
        cVS();
        cVL();
        cVX();
        cIa();
        cWe();
        if (this.jWW.getType() == 4 && this.jXx != null && this.kSA != null) {
            this.jXx.setVisibility(8);
            this.kSA.setVisibility(8);
        }
        cIc();
        ShowSoftKeyPad(this.mInputManager, this.jXo);
    }

    private void cVS() {
        String str;
        String str2;
        if (this.jWW != null) {
            switch (this.jWW.getType()) {
                case 0:
                case 9:
                    if (this.gOk != null && this.gOk.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gOk != null && this.gOk.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jWW.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jXo.setVisibility(0);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXo.setVisibility(8);
                    return;
            }
        }
    }

    private void cVT() {
        this.jXt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXt.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXt.setLayoutParams(layoutParams);
        this.jXt.setOnFocusChangeListener(this.eWj);
    }

    private void cVU() {
        if (this.jWW != null && this.jWW.getType() == 0 && this.jWW.getType() == 9 && !this.kSw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWc() != null) {
                cWc().setText(cutStringWithSuffix);
                cWc().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cVV() {
        this.kSI = null;
        this.kSK = -1;
        this.kSM = -1;
        y sY = x.bFE().sY(1);
        if (sY != null) {
            this.kSI = sY.gsi;
            this.kSK = getIntent().getIntExtra("category_id", -1);
            if (this.kSI != null && !this.kSI.isEmpty() && this.kSK >= 0) {
                this.kSJ = new w();
                this.kSJ.gse = 0;
                this.kSJ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSM = this.kSJ.gse;
                this.kSL = this.kSJ.name;
                for (w wVar : this.kSI) {
                    if (wVar.gse == this.kSK) {
                        this.kSM = wVar.gse;
                        this.kSL = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVW() {
        if (this.kSI != null && !this.kSI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSN = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSN.setText(this.kSL);
            this.kSN.setCategoryContainerData(this.kSI, this.kSJ, this.kSM);
            this.kSN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        TransmitPostEditActivity.this.kSN.setText(asVar.name);
                        TransmitPostEditActivity.this.jWW.setCategoryTo(asVar.gse);
                        TransmitPostEditActivity.this.kSM = asVar.gse;
                        TransmitPostEditActivity.this.kSN.cVy();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kSN.cVx();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWc());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kTc = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kTc.setTitle(R.string.no_disturb_start_time);
        this.kTc.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kTc);
        this.kTc.setButton(-2, getPageContext().getString(R.string.cancel), this.kTc);
        return this.kTc;
    }

    private void cVX() {
        this.kSE = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSF = (TextView) findViewById(R.id.addition_create_time);
        this.kSG = (TextView) findViewById(R.id.addition_last_time);
        this.kSH = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSD != null) {
            this.kSE.setVisibility(0);
            this.kSF.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSD.getCreateTime() * 1000));
            if (this.kSD.getAlreadyCount() == 0) {
                this.kSG.setVisibility(8);
            } else {
                this.kSG.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSH.setText(lastAdditionContent);
            } else {
                this.kSH.setVisibility(8);
            }
            cWb().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSD.getAlreadyCount()), Integer.valueOf(this.kSD.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSE.setVisibility(8);
    }

    private void cIa() {
        this.jXx = findViewById(R.id.post_prefix_layout);
        this.jXu = (TextView) findViewById(R.id.post_prefix);
        this.kSA = findViewById(R.id.prefix_divider);
        this.jXw = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXx.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWX = 1;
            this.jXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jXu.setVisibility(0);
                    TransmitPostEditActivity.this.jXx.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXv, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dwT.aMR();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXo);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jXs);
                }
            });
            this.jXw = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jXw.setVisibility(0);
                this.jXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jXu.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jXv, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dwT.aMR();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWc());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                    }
                });
            }
            this.jXv = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXv.a(this);
            this.jXv.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXv.setOutsideTouchable(true);
            this.jXv.setFocusable(true);
            this.jXv.setOnDismissListener(this);
            this.jXv.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXu, R.color.cp_bg_line_d);
            am.setImageResource(this.jXw, R.drawable.icon_frs_arrow_n);
            this.jXu.setTextColor(color);
            this.kSB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jXv.addView(writePrefixItemLayout);
            }
            this.jXv.setCurrentIndex(0);
            this.jXu.setText(prefixs.get(1));
            Es(1);
            return;
        }
        this.jXx.setVisibility(8);
    }

    protected void cVY() {
        this.jXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cWl()) {
                    if (TransmitPostEditActivity.this.kSU.a(TransmitPostEditActivity.this.jXo, TransmitPostEditActivity.this.jXs)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kSU.cUh());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWc());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWb());
                    TransmitPostEditActivity.this.dwT.aMR();
                    TiebaStatic.log(new an("c12608").X("obj_locate", 7));
                    TransmitPostEditActivity.this.cWi();
                }
            }
        });
    }

    protected void cIb() {
        this.jXo = (EditText) findViewById(R.id.post_title);
        this.jXo.setOnClickListener(this.kSY);
        this.jXo.setOnFocusChangeListener(this.eWj);
        if ((this.jWW.getType() == 0 || this.jWW.getType() == 9 || this.jWW.getType() == 7) && this.jWW.getTitle() != null) {
            this.jXo.setText(this.jWW.getTitle());
            this.jXo.setSelection(this.jWW.getTitle().length());
        }
        this.jXo.addTextChangedListener(this.kTa);
        if (!this.jWW.getHaveDraft()) {
            cVU();
        }
        this.jXo.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cId() {
        this.jXs = (EditText) findViewById(R.id.post_content);
        this.jXs.setDrawingCacheEnabled(false);
        this.jXs.setOnClickListener(this.kSY);
        if (this.jWW.getContent() != null && this.jWW.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPQ().aB(getPageContext().getPageActivity(), this.jWW.getContent());
            this.jXs.setText(aB);
            this.jXs.setSelection(aB.length());
        }
        if (!aq.isEmpty(this.gmE)) {
            this.jXs.setSelection(0);
        }
        this.jXs.setOnFocusChangeListener(this.eWj);
        this.jXs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jXs.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXs.addTextChangedListener(this.kTb);
        if (this.kSv != null && this.kSv.showType == 3) {
            this.jXs.setHint(R.string.share_video_default);
        } else {
            this.jXs.setHint(R.string.share_txt_default);
        }
    }

    private void cVZ() {
        this.Mv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Mv.setVisibility(0);
        this.Mv.a(this.kSv);
        this.Mv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWa() {
        int i = 5000;
        if (this.kSD != null) {
            i = 1000;
        }
        return cWb().getText() != null && cWb().getText().length() >= i;
    }

    private void vi(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSt)) {
                this.kSt = "";
                cWb().requestFocus();
                if (cWb().getText() != null && cWb().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWb().getSelectionStart();
                    editable = cWb().getText();
                }
            } else if ("from_title".equals(this.kSt)) {
                this.kSt = "";
                cWc().requestFocus();
                if (cWc().getText() != null && cWc().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWc().getSelectionStart();
                    editable = cWc().getText();
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
            if (this.jWW != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWW.getForumId(), 0L), this.jWW.getFirstDir(), this.jWW.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWb().getText().getSpans(0, cWb().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSC == null) {
                this.kSC = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSC.getView().isShown()) {
                this.kSC.cancel();
            }
            this.kSC.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJx = qVar.aJx();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cWb().getSelectionStart(), aVar, aJx);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWb() != null && cWb().getText() != null) {
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
                int selectionStart = cWb().getSelectionStart() - 1;
                if (cWb().getText().length() > 1 && selectionStart >= 0 && cWb().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWb().getText().insert(cWb().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWb().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWb().getText().insert(cWb().getSelectionStart(), spannableString2);
            }
            Editable text = cWb().getText();
            if (text != null) {
                this.kSS.clear();
                this.kSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWb().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWb().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWb().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWb() {
        return this.jXs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWc() {
        return this.jXo;
    }

    protected void cWd() {
        Editable text;
        if (cWb() != null && (text = cWb().getText()) != null) {
            int selectionStart = cWb().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWb().onKeyDown(67, this.gaI);
            }
            cWb().onKeyDown(67, this.gaI);
            int selectionStart2 = cWb().getSelectionStart();
            this.kSS.clear();
            this.kSS.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kSS);
            cWb().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dGg.setCancelListener(null);
        this.dGg.setTipString(R.string.sending);
        this.dGg.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dGg.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIc() {
        if (this.jWW != null) {
            String str = "";
            String str2 = "";
            if (cWc() != null) {
                str = cWc().getText().toString();
            }
            if (cWb() != null) {
                str2 = cWb().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWW.getType() == 0 || this.jWW.getType() == 9 || this.jWW.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jWX == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWW.setIsNoTitle(true);
                        } else {
                            this.jWW.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else {
                        this.jWW.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWW.setIsNoTitle(true);
                } else {
                    this.jWW.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSP) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tT(true);
            } else if (this.jWW.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    private void tT(boolean z) {
        am.setNavbarTitleColor(this.jXt, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.dyz = new NewWriteModel(this);
        this.dyz.b(this.dyN);
        this.gfz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cHT();
            }
        };
        this.jWW = new WriteData();
        if (bundle != null) {
            this.jWW.setType(bundle.getInt("type", 0));
            this.jWW.setForumId(bundle.getString("forum_id"));
            this.jWW.setForumName(bundle.getString("forum_name"));
            this.jWW.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWW.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWW.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWW.setIsAddition(this.kSD != null);
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
            this.jWW.setTitle(bundle.getString("write_title"));
            this.jWW.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gOk = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kSv = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.gmE = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gmF = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = string;
        } else {
            Intent intent = getIntent();
            this.jWW.setType(intent.getIntExtra("type", 0));
            this.jWW.setForumId(intent.getStringExtra("forum_id"));
            this.jWW.setForumName(intent.getStringExtra("forum_name"));
            this.jWW.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWW.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWW.setThreadId(intent.getStringExtra("thread_id"));
            this.kSD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWW.setIsAddition(this.kSD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jWW.setTitle(intent.getStringExtra("write_title"));
            this.jWW.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gOk = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kSv = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.gmE = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gmF = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWW.getType() == 4 ? 6 : 9);
        this.jWW.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kSv != null && this.kSv.videoId != null) {
            this.jWW.setVideoId(this.kSv.videoId);
            this.jWW.setOriginalVideoCover(this.kSv.showPicUrl);
            this.jWW.setOriginalVideoTitle(this.kSv.showText);
        }
        if (!aq.isEmpty(this.gmE)) {
            if (!aq.isEmpty(this.gmF)) {
                this.jWW.setContent("//@" + this.gmF + " :" + this.gmE);
            } else {
                this.jWW.setContent(this.gmE);
            }
        }
        if (this.jWW != null && this.jWW.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWW.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSw = true;
        }
        cVV();
    }

    private void cWe() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXo.setText(com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName)));
            this.jXo.setMovementMethod(com.baidu.tieba.view.c.cTv());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vJ = com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName));
            if (vJ != null) {
                this.jXo.setText(vJ);
            }
            this.kSR.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWW.getType());
        bundle.putString("forum_id", this.jWW.getForumId());
        bundle.putString("forum_name", this.jWW.getForumName());
        bundle.putString("forum_first_dir", this.jWW.getFirstDir());
        bundle.putString("forum_second_dir", this.jWW.getSecondDir());
        bundle.putString("thread_id", this.jWW.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kSD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gOk);
        if (this.kSv != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kSv));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWb().getEditableText().toString();
        if (obj != null) {
            cWb().setText(TbFaceManager.aPQ().a(getPageContext().getPageActivity(), obj, this.kSW));
            cWb().setSelection(cWb().getText().length());
        }
    }

    private String cWf() {
        if (cWb() == null || cWb().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cWb().getText().toString())) {
            if (this.kSv != null && this.kSv.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cWb().getText().toString();
    }

    private String cWg() {
        if (this.jWW == null || cWc() == null || cWc().getVisibility() != 0 || cWc().getText() == null) {
            return "";
        }
        String obj = cWc().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWX != 0 && this.jWW.getType() != 4 && this.jXu != null && this.jXu.getText() != null) {
            obj = this.jXu.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWW.getTitle();
        }
        return obj;
    }

    private void cWh() {
        cHT();
        this.jWW.setContent(cWf());
        this.jWW.setTitle(cWg());
        if (this.kSK >= 0) {
            this.jWW.setCategoryFrom(this.kSK);
        }
        if (this.kSM >= 0) {
            this.jWW.setCategoryTo(this.kSM);
        }
        this.jWW.setWriteImagesInfo(this.writeImagesInfo);
        this.jWW.setHasLocationData(this.dyy != null && this.dyy.brm());
        this.dyz.sS(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kSQ != null && this.kSQ.mIsGlobalBlock == 0) {
            this.jWW.setForumId(String.valueOf(this.kSQ.mForumId));
            this.jWW.setForumName(this.kSQ.mForumName);
        }
        this.dyz.d(this.jWW);
        this.jWW.setContent(this.jWW.getContent().replaceAll("\u0000\n", ""));
        this.jWW.setContent(this.jWW.getContent().replaceAll("\u0000", ""));
        this.jWW.setVcode(null);
        this.dyz.cHV().setVoice(null);
        this.dyz.cHV().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.gfz);
        this.dyz.cMk();
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kSD != null) {
                i2 = this.kSD.getTotalCount();
                i = this.kSD.getAlreadyCount() + 1;
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
                if (this.dwT != null && !this.dwT.aOw()) {
                    cWb().requestFocus();
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
                            cWb().getText().insert(cWb().getSelectionStart(), sb.toString());
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
                        if (this.kSu) {
                            sb2.append(com.baidu.tbadk.plugins.b.dFM);
                            this.kSu = false;
                        }
                        sb2.append(stringExtra);
                        vi(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kSQ = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kSQ);
            }
        } else if (i2 == 0) {
            if (this.dwT != null && !this.dwT.aOw()) {
                this.jXs.requestFocus();
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
                        this.kSU.KL(postWriteCallBackData.getErrorString());
                        this.kSU.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSU.b(this.jXo, this.jXs);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSt)) {
                        cWc().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSt)) {
                        cWb().requestFocus();
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
    public void cWi() {
        if ("1".equals(this.gOk)) {
            this.jWW.setCanNoForum(true);
            this.jWW.setTransmitForumData("[]");
        } else if ("2".equals(this.gOk)) {
            this.jWW.setCanNoForum(false);
        }
        cWj();
        this.jWW.setPrivacy(this.isPrivacy);
        this.jWW.setIsShareThread(true);
        if (this.kSv != null && !StringUtils.isNull(this.kSv.threadId)) {
            this.jWW.setOriginalThreadId(this.kSv.threadId);
        }
        this.jWW.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kSv != null) {
            this.jWW.setOriBaijiahaoData(this.kSv.oriUgcInfo);
        }
        this.jWW.setCallFrom(this.gOk);
        cWh();
    }

    private void cWj() {
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWc());
        HidenSoftKeyPad(this.mInputManager, cWb());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gpF) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jWW.getType() != 7) {
                if (this.kSD == null) {
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
        this.dyE = i;
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWk() {
        if (!this.kSP && this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dwT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSB.size()) {
            for (int i2 = 0; i2 < this.kSB.size(); i2++) {
                this.kSB.get(i2).tK(false);
            }
            this.kSB.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        this.jWX = i;
        this.jXv.setCurrentIndex(i);
        Es(i);
        this.jXu.setText(this.mPrefixData.getPrefixs().get(i));
        cIc();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXv, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXx.setSelected(false);
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
        if (this.jWW != null) {
            if (this.jWW.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWW.getType() == 5) {
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
            aOW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auE = z;
        if (this.kST != null && !z) {
            this.kST.byK();
        }
        if (this.kSV != null && !z) {
            cVN();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.auE && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kSu = false;
            this.kSt = "";
            if ("from_content".equals(str)) {
                this.kSt = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSt = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vI(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDi() {
        if (!v.isEmpty(this.mList)) {
            this.kSy.setVisibility(0);
            this.kSy.requestFocus();
            return;
        }
        this.kSy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWl() {
        if (((ImageSpan[]) cWb().getText().getSpans(0, cWb().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kSC == null) {
                this.kSC = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kSC.getView().isShown()) {
                this.kSC.cancel();
            }
            this.kSC.show();
            return true;
        }
        return false;
    }
}
