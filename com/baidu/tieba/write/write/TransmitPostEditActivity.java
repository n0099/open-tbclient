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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes13.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0078a, h.a {
    private OriginalThreadCardView Mv;
    private EditorTools dxg;
    private LocationModel dyL;
    private NewWriteModel dyM;
    private String gnm;
    private String gnn;
    private boolean isPrivacy;
    private TextView jYW;
    private com.baidu.tieba.write.h jYX;
    private ImageView jYY;
    private View jYZ;
    private int jYz;
    private FrsTabInfoData kOH;
    private ForumTabSelectedView kSA;
    private OriginalThreadInfo.ShareInfo kTY;
    private com.baidu.tieba.view.b kUF;
    private LinearLayout kUa;
    private LinearLayout kUb;
    private View kUd;
    private Toast kUf;
    private AdditionData kUg;
    private RelativeLayout kUh;
    private TextView kUi;
    private TextView kUj;
    private TextView kUk;
    List<x> kUl;
    x kUm;
    private int kUn;
    private String kUo;
    private int kUp;
    private PostCategoryView kUq;
    private HotTopicBussinessData kUt;
    private TextView kUu;
    private com.baidu.tieba.write.editor.b kUw;
    private e kUy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String kTW = "";
    private boolean kTX = false;
    private WriteData jYy = null;
    private boolean kTZ = false;
    private InputMethodManager mInputManager = null;
    private EditText jYQ = null;
    private View jYR = null;
    private LinearLayout jYT = null;
    private EditText jYU = null;
    private FeedBackModel kUc = null;
    private ArrayList<WritePrefixItemLayout> kUe = new ArrayList<>();
    private final KeyEvent gbq = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView jYV = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener ggh = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout htL = null;
    private String dyQ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyR = 0;
    private View mRootView = null;
    private ScrollView kUr = null;
    private boolean kUs = false;
    private com.baidu.tbadk.core.view.a dGw = null;
    private String mFrom = "write";
    private String gPr = "2";
    private SpannableStringBuilder kUv = new SpannableStringBuilder();
    private boolean auO = false;
    private final b kUx = new b();
    private TbFaceManager.a kUz = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a gqp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.jYy != null) {
                TransmitPostEditActivity.this.kUx.aU(null);
                if (z) {
                    TransmitPostEditActivity.this.gK(z);
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
                    TransmitPostEditActivity.this.kUx.KK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.kUx.aU(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.kUx.b(TransmitPostEditActivity.this.jYQ, TransmitPostEditActivity.this.jYU);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJL());
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJK())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a dyY = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPp() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLZ())) {
                TransmitPostEditActivity.this.a(2, true, aVar.cLZ());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kkK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.dyL.sW(false);
                    TransmitPostEditActivity.this.dyL.eE(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.dyL.sW(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kUA = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kUB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cWh = TransmitPostEditActivity.this.cWh();
            if (cWh >= 0 && cWh < TransmitPostEditActivity.this.jYU.getText().length()) {
                TransmitPostEditActivity.this.jYU.setSelection(cWh);
            }
        }
    };
    private boolean kUC = true;
    private final View.OnFocusChangeListener eWH = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.jYQ || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.jYV) {
                if (z) {
                    TransmitPostEditActivity.this.kUC = true;
                    TransmitPostEditActivity.this.cWi();
                    if (TransmitPostEditActivity.this.dxg != null) {
                        TransmitPostEditActivity.this.dxg.aMV();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jYQ);
                } else if (view == TransmitPostEditActivity.this.jYQ) {
                    TransmitPostEditActivity.this.jYW.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.jYU && z) {
                TransmitPostEditActivity.this.kUC = false;
                TransmitPostEditActivity.this.cWi();
                TransmitPostEditActivity.this.dxg.aMV();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.jYU);
            }
            TransmitPostEditActivity.this.cWn();
        }
    };
    private TextWatcher kUD = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String kUH = "";
        private String kUI;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kUI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kUI != null ? this.kUI.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIw();
            TransmitPostEditActivity.this.cWo();
            EditText cWA = TransmitPostEditActivity.this.cWA();
            if (editable != null && cWA != null && cWA.getText() != null) {
                if (this.kUH == null || !this.kUH.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kUx != null) {
                        this.kUH = cWA.getText().toString();
                        TransmitPostEditActivity.this.kUx.b(cWA, true);
                        return;
                    }
                    return;
                }
                cWA.setSelection(cWA.getSelectionEnd());
            }
        }
    };
    private TextWatcher kUE = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String kUI;
        private String kUJ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kUI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kUI != null ? this.kUI.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cIw();
            EditText cWz = TransmitPostEditActivity.this.cWz();
            if (editable != null && cWz != null && cWz.getText() != null) {
                int selectionEnd = cWz.getSelectionEnd();
                if (this.kUJ == null || !this.kUJ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.kUx != null) {
                        this.kUJ = cWz.getText().toString();
                        TransmitPostEditActivity.this.kUx.b(cWz, false);
                        return;
                    }
                    return;
                }
                cWz.setSelection(selectionEnd);
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
    public void aOZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aPa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aPc();
        } else if (this.dyL.cMg()) {
            aOZ();
        } else {
            this.dyL.sW(false);
            a(1, true, (String) null);
            this.dyL.cMe();
        }
    }

    private void aPc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.dyL.cMi();
                } else {
                    TransmitPostEditActivity.this.dyY.aPp();
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
        aVar.aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cWh() {
        int selectionEnd = cWz().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWz().getText().getSpans(0, cWz().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWz().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWz().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWi() {
        if (this.dxg != null) {
            this.dxg.setBarLauncherEnabled(!this.kUC);
            this.dxg.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kUs) {
            this.jYQ.setVisibility(8);
            cIw();
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
        this.dyL = new LocationModel(getPageContext());
        this.dyL.a(this.dyY);
        registerListener(this.kkK);
        registerListener(this.kUA);
        cgh();
        this.jYU.requestFocus();
        cDC();
        cWI();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cgh() {
        this.dxg = new EditorTools(getActivity());
        this.dxg.setBarMaxLauCount(4);
        this.dxg.setMoreButtonAtEnd(true);
        this.dxg.setBarLauncherType(1);
        this.dxg.gC(true);
        this.dxg.gD(true);
        this.dxg.setBackgroundColorId(R.color.cp_bg_line_h);
        cWj();
        this.dxg.build();
        if (this.kUa != null) {
            this.kUa.addView(this.dxg);
        }
        cai();
        this.dxg.display();
        com.baidu.tbadk.editortools.g mo = this.dxg.mo(6);
        if (mo != null && !TextUtils.isEmpty(this.dyQ)) {
            ((View) mo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.dyQ);
                }
            });
        }
        if (!this.kUs) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dxg.aMV();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        if (this.jYy.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jYy.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        cWl();
    }

    private void cWj() {
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.dxg.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        this.dxg.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dxQ = 4;
            lVar.dxM = R.drawable.icon_post_location_selector;
            lVar.dxO = false;
            this.dxg.b(lVar);
        }
        if (this.kUg == null) {
            if (this.kUw == null) {
                this.kUw = new com.baidu.tieba.write.editor.b(getActivity(), this.gPr);
                this.kUw.cVi();
                this.kUw.setFrom("from_share_write");
                this.kUw.bz(this.jYy.getForumId(), this.mPrivateThread);
            }
            this.dxg.b(this.kUw);
        }
        this.dxg.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = this.dxg.mr(5);
        if (mr != null) {
            mr.dxQ = 1;
        }
    }

    private void cai() {
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
                        if (TransmitPostEditActivity.this.cWy()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cWy()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cWB();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cIw();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.kUg == null) {
                            TransmitPostEditActivity.this.aPd();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.dyR) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.aPa();
                                    return;
                                } else {
                                    ab.e(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.aOZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.dyL != null) {
                            TransmitPostEditActivity.this.dyL.sW(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.jYy != null) {
                            str = TransmitPostEditActivity.this.jYy.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cx("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.jYy == null || (videoInfo = TransmitPostEditActivity.this.jYy.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.dxg.aOA()) {
                                        TransmitPostEditActivity.this.dxg.aMV();
                                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.jYy.setVideoInfo(null);
                        TransmitPostEditActivity.this.cIw();
                        if (TransmitPostEditActivity.this.jYU != null) {
                            TransmitPostEditActivity.this.jYU.requestFocus();
                        }
                        TransmitPostEditActivity.this.dxg.aMV();
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jYU);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.kTX = true;
                        TransmitPostEditActivity.this.tZ(true);
                        if (TransmitPostEditActivity.this.cWA().isFocused()) {
                            TransmitPostEditActivity.this.kTW = "from_title";
                        } else if (TransmitPostEditActivity.this.cWz().isFocused()) {
                            TransmitPostEditActivity.this.kTW = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.kUb.setVisibility(0);
                        TransmitPostEditActivity.this.kUb.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.kUb.hasFocus()) {
                            TransmitPostEditActivity.this.jYU.requestFocus();
                            TransmitPostEditActivity.this.jYU.setSelection(TransmitPostEditActivity.this.jYU.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.kUb.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dxg.setActionListener(31, bVar);
        this.dxg.setActionListener(16, bVar);
        this.dxg.setActionListener(14, bVar);
        this.dxg.setActionListener(24, bVar);
        this.dxg.setActionListener(3, bVar);
        this.dxg.setActionListener(10, bVar);
        this.dxg.setActionListener(11, bVar);
        this.dxg.setActionListener(12, bVar);
        this.dxg.setActionListener(13, bVar);
        this.dxg.setActionListener(15, bVar);
        this.dxg.setActionListener(18, bVar);
        this.dxg.setActionListener(20, bVar);
        this.dxg.setActionListener(25, bVar);
        this.dxg.setActionListener(27, bVar);
        this.dxg.setActionListener(29, bVar);
        this.dxg.setActionListener(43, bVar);
        this.dxg.setActionListener(45, bVar);
        this.dxg.setActionListener(53, bVar);
        this.dxg.setActionListener(48, bVar);
        this.dxg.setActionListener(46, bVar);
        this.dxg.setActionListener(49, bVar);
        this.dxg.setActionListener(47, bVar);
        this.dxg.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        if (this.dyL.brr()) {
            if (this.dyL.cMg()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cMb().getLocationData().cLZ());
                return;
            }
            a(1, true, (String) null);
            this.dyL.cMe();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cIn() {
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
        if (this.kUc != null) {
            this.kUc.cancelLoadData();
        }
        if (this.dyL != null) {
            this.dyL.cancelLoadData();
        }
    }

    private void cWk() {
        if (this.kUy != null) {
            this.kUy.hideTip();
        }
    }

    private void cWl() {
        if (this.kUy == null) {
            this.kUy = new e(getPageContext());
        }
        this.kUy.c(this.dxg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cWk();
        TiebaPrepareImageService.StopService();
        cIn();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWm() {
        if (this.jYy == null) {
            finish();
            return;
        }
        this.jYy.setTitle(cWA().getText().toString());
        this.jYy.setContent(cWz().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jYX != null && this.jYX.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jYX, getPageContext().getPageActivity());
                return true;
            } else if (this.dxg.aOA()) {
                this.dxg.aMV();
                return true;
            } else {
                cIn();
                cWm();
                return true;
            }
        }
        if (i == 67 && (text = cWz().getText()) != null) {
            int selectionStart = cWz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWz().onKeyDown(67, this.gbq);
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
        getLayoutMode().onModeChanged(this.htL);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jYV, R.color.cp_link_tip_a, 1);
        cWi();
        am.setBackgroundColor(this.jYR, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWA(), R.color.cp_bg_line_d);
        am.setBackgroundColor(cWz(), R.color.cp_bg_line_d);
        cIw();
        this.dxg.onChangeSkinType(i);
        if (this.kUq != null) {
            this.kUq.aHS();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cWn();
        cWo();
        if (this.kUx != null) {
            this.kUx.c(cWA(), cWz());
        }
        if (this.Mv != null) {
            this.Mv.onChangeSkinType();
        }
        if (this.kSA != null) {
            this.kSA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWn() {
        if (this.jYQ.hasFocus()) {
            this.jYQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jYQ.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jYU.hasFocus()) {
            this.jYU.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jYU.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWo() {
        if (this.jYQ != null) {
            if (this.jYQ.getText().toString().length() == 0) {
                this.jYQ.getPaint().setFakeBoldText(false);
            } else if (this.jYQ.getText().toString().length() > 0) {
                this.jYQ.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.dGw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kUs = this.jYy.getType() == 4 || 5 == this.jYy.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        cWr();
        this.kUr = (ScrollView) findViewById(R.id.write_scrollview);
        this.kUr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.jYU != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.jYU);
                    }
                    if (TransmitPostEditActivity.this.dxg != null) {
                        TransmitPostEditActivity.this.dxg.aMV();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.htL = (RelativeLayout) findViewById(R.id.parent);
        this.kUa = (LinearLayout) findViewById(R.id.tool_view);
        this.kUa.setContentDescription(IStringUtil.TOP_PATH);
        this.kUb = (LinearLayout) findViewById(R.id.title_view);
        this.jYR = findViewById(R.id.interval_view);
        this.kUu = (TextView) findViewById(R.id.hot_topic_title_edt);
        cIv();
        if (this.kUs) {
            this.kUr.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cIx();
        cWx();
        this.jYT = (LinearLayout) findViewById(R.id.post_content_container);
        this.jYT.setDrawingCacheEnabled(false);
        this.jYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.jYU.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eWH);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cIn();
                TransmitPostEditActivity.this.cWm();
            }
        });
        cWu();
        cWw();
        cWq();
        cWi();
        cWv();
        cIu();
        cWC();
        cWp();
        if (this.jYy.getType() == 4 && this.jYZ != null && this.kUd != null) {
            this.jYZ.setVisibility(8);
            this.kUd.setVisibility(8);
        }
        cIw();
        ShowSoftKeyPad(this.mInputManager, this.jYQ);
    }

    private void cWp() {
        this.kSA = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.kSA.setData(this.kOH);
        this.kSA.setActivity(this);
    }

    private void cWq() {
        String str;
        String str2;
        if (this.jYy != null) {
            switch (this.jYy.getType()) {
                case 0:
                case 9:
                    if (this.gPr != null && this.gPr.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.gPr != null && this.gPr.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.jYy.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.jYQ.setVisibility(0);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jYQ.setVisibility(8);
                    return;
            }
        }
    }

    private void cWr() {
        this.jYV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jYV.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jYV.setLayoutParams(layoutParams);
        this.jYV.setOnFocusChangeListener(this.eWH);
    }

    private void cWs() {
        if (this.jYy != null && this.jYy.getType() == 0 && this.jYy.getType() == 9 && !this.kTZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWA() != null) {
                cWA().setText(cutStringWithSuffix);
                cWA().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void cWt() {
        this.kUl = null;
        this.kUn = -1;
        this.kUp = -1;
        z ta = y.bFO().ta(1);
        if (ta != null) {
            this.kUl = ta.gsS;
            this.kUn = getIntent().getIntExtra("category_id", -1);
            if (this.kUl != null && !this.kUl.isEmpty() && this.kUn >= 0) {
                this.kUm = new x();
                this.kUm.gsO = 0;
                this.kUm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kUp = this.kUm.gsO;
                this.kUo = this.kUm.name;
                for (x xVar : this.kUl) {
                    if (xVar.gsO == this.kUn) {
                        this.kUp = xVar.gsO;
                        this.kUo = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cWu() {
        if (this.kUl != null && !this.kUl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kUq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kUq.setText(this.kUo);
            this.kUq.setCategoryContainerData(this.kUl, this.kUm, this.kUp);
            this.kUq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.kUq.setText(atVar.name);
                        TransmitPostEditActivity.this.jYy.setCategoryTo(atVar.gsO);
                        TransmitPostEditActivity.this.kUp = atVar.gsO;
                        TransmitPostEditActivity.this.kUq.cVV();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.kUq.cVU();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWA());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWz());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kUF = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kUF.setTitle(R.string.no_disturb_start_time);
        this.kUF.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kUF);
        this.kUF.setButton(-2, getPageContext().getString(R.string.cancel), this.kUF);
        return this.kUF;
    }

    private void cWv() {
        this.kUh = (RelativeLayout) findViewById(R.id.addition_container);
        this.kUi = (TextView) findViewById(R.id.addition_create_time);
        this.kUj = (TextView) findViewById(R.id.addition_last_time);
        this.kUk = (TextView) findViewById(R.id.addition_last_content);
        if (this.kUg != null) {
            this.kUh.setVisibility(0);
            this.kUi.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kUg.getCreateTime() * 1000));
            if (this.kUg.getAlreadyCount() == 0) {
                this.kUj.setVisibility(8);
            } else {
                this.kUj.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kUg.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kUg.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kUk.setText(lastAdditionContent);
            } else {
                this.kUk.setVisibility(8);
            }
            cWz().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kUg.getAlreadyCount()), Integer.valueOf(this.kUg.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kUh.setVisibility(8);
    }

    private void cIu() {
        this.jYZ = findViewById(R.id.post_prefix_layout);
        this.jYW = (TextView) findViewById(R.id.post_prefix);
        this.kUd = findViewById(R.id.prefix_divider);
        this.jYY = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jYZ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jYz = 1;
            this.jYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jYW.setVisibility(0);
                    TransmitPostEditActivity.this.jYZ.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jYX, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.dxg.aMV();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jYQ);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.jYU);
                }
            });
            this.jYY = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.jYY.setVisibility(0);
                this.jYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.jYW.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.jYX, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.dxg.aMV();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWA());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWz());
                    }
                });
            }
            this.jYX = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jYX.a(this);
            this.jYX.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jYX.setOutsideTouchable(true);
            this.jYX.setFocusable(true);
            this.jYX.setOnDismissListener(this);
            this.jYX.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jYW, R.color.cp_bg_line_d);
            am.setImageResource(this.jYY, R.drawable.icon_frs_arrow_n);
            this.jYW.setTextColor(color);
            this.kUe.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kUe.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jYX.addView(writePrefixItemLayout);
            }
            this.jYX.setCurrentIndex(0);
            this.jYW.setText(prefixs.get(1));
            Ez(1);
            return;
        }
        this.jYZ.setVisibility(8);
    }

    protected void cWw() {
        this.jYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.cWJ()) {
                    if (TransmitPostEditActivity.this.kUx.a(TransmitPostEditActivity.this.jYQ, TransmitPostEditActivity.this.jYU)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.kUx.cUB());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWA());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cWz());
                    TransmitPostEditActivity.this.dxg.aMV();
                    TiebaStatic.log(new an("c12608").X("obj_locate", 7));
                    TransmitPostEditActivity.this.cWG();
                }
            }
        });
    }

    protected void cIv() {
        this.jYQ = (EditText) findViewById(R.id.post_title);
        this.jYQ.setOnClickListener(this.kUB);
        this.jYQ.setOnFocusChangeListener(this.eWH);
        if ((this.jYy.getType() == 0 || this.jYy.getType() == 9 || this.jYy.getType() == 7) && this.jYy.getTitle() != null) {
            this.jYQ.setText(this.jYy.getTitle());
            this.jYQ.setSelection(this.jYy.getTitle().length());
        }
        this.jYQ.addTextChangedListener(this.kUD);
        if (!this.jYy.getHaveDraft()) {
            cWs();
        }
        this.jYQ.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cIx() {
        this.jYU = (EditText) findViewById(R.id.post_content);
        this.jYU.setDrawingCacheEnabled(false);
        this.jYU.setOnClickListener(this.kUB);
        if (this.jYy.getContent() != null && this.jYy.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPU().aB(getPageContext().getPageActivity(), this.jYy.getContent());
            this.jYU.setText(aB);
            this.jYU.setSelection(aB.length());
        }
        if (!aq.isEmpty(this.gnm)) {
            this.jYU.setSelection(0);
        }
        this.jYU.setOnFocusChangeListener(this.eWH);
        this.jYU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.jYU.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jYU.addTextChangedListener(this.kUE);
        if (this.kTY != null && this.kTY.showType == 3) {
            this.jYU.setHint(R.string.share_video_default);
        } else {
            this.jYU.setHint(R.string.share_txt_default);
        }
    }

    private void cWx() {
        this.Mv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.Mv.setVisibility(0);
        this.Mv.a(this.kTY);
        this.Mv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWy() {
        int i = 5000;
        if (this.kUg != null) {
            i = 1000;
        }
        return cWz().getText() != null && cWz().getText().length() >= i;
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kTW)) {
                this.kTW = "";
                cWz().requestFocus();
                if (cWz().getText() != null && cWz().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWz().getSelectionStart();
                    editable = cWz().getText();
                }
            } else if ("from_title".equals(this.kTW)) {
                this.kTW = "";
                cWA().requestFocus();
                if (cWA().getText() != null && cWA().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWA().getSelectionStart();
                    editable = cWA().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jYy != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jYy.getForumId(), 0L), this.jYy.getFirstDir(), this.jYy.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWz().getText().getSpans(0, cWz().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kUf == null) {
                this.kUf = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kUf.getView().isShown()) {
                this.kUf.cancel();
            }
            this.kUf.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJB = qVar.aJB();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cWz().getSelectionStart(), aVar, aJB);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWz() != null && cWz().getText() != null) {
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
                int selectionStart = cWz().getSelectionStart() - 1;
                if (cWz().getText().length() > 1 && selectionStart >= 0 && cWz().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWz().getText().insert(cWz().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWz().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWz().getText().insert(cWz().getSelectionStart(), spannableString2);
            }
            Editable text = cWz().getText();
            if (text != null) {
                this.kUv.clear();
                this.kUv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kUv);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWz().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWz().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWz().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWz() {
        return this.jYU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWA() {
        return this.jYQ;
    }

    protected void cWB() {
        Editable text;
        if (cWz() != null && (text = cWz().getText()) != null) {
            int selectionStart = cWz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWz().onKeyDown(67, this.gbq);
            }
            cWz().onKeyDown(67, this.gbq);
            int selectionStart2 = cWz().getSelectionStart();
            this.kUv.clear();
            this.kUv.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.kUv);
            cWz().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dGw.setCancelListener(null);
        this.dGw.setTipString(R.string.sending);
        this.dGw.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dGw.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIw() {
        if (this.jYy != null) {
            String str = "";
            String str2 = "";
            if (cWA() != null) {
                str = cWA().getText().toString();
            }
            if (cWz() != null) {
                str2 = cWz().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jYy.getType() == 0 || this.jYy.getType() == 9 || this.jYy.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.jYz == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jYy.setIsNoTitle(true);
                        } else {
                            this.jYy.setIsNoTitle(false);
                            ua(true);
                            return;
                        }
                    } else {
                        this.jYy.setIsNoTitle(false);
                        ua(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jYy.setIsNoTitle(true);
                } else {
                    this.jYy.setIsNoTitle(false);
                    ua(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kUs) {
                    ua(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ua(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ua(true);
            } else if (this.jYy.getVideoInfo() != null) {
                ua(true);
            } else {
                ua(false);
            }
        }
    }

    private void ua(boolean z) {
        am.setNavbarTitleColor(this.jYV, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.dyM = new NewWriteModel(this);
        this.dyM.b(this.dza);
        this.ggh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cIn();
            }
        };
        this.jYy = new WriteData();
        if (bundle != null) {
            this.jYy.setType(bundle.getInt("type", 0));
            this.jYy.setForumId(bundle.getString("forum_id"));
            this.jYy.setForumName(bundle.getString("forum_name"));
            this.jYy.setFirstDir(bundle.getString("forum_first_dir"));
            this.jYy.setSecondDir(bundle.getString("forum_second_dir"));
            this.jYy.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kUg = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jYy.setIsAddition(this.kUg != null);
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
            this.jYy.setTitle(bundle.getString("write_title"));
            this.jYy.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gPr = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.kTY = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.gnm = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gnn = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.kOH = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.jYy.setType(intent.getIntExtra("type", 0));
            this.jYy.setForumId(intent.getStringExtra("forum_id"));
            this.jYy.setForumName(intent.getStringExtra("forum_name"));
            this.jYy.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jYy.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jYy.setThreadId(intent.getStringExtra("thread_id"));
            this.kUg = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jYy.setIsAddition(this.kUg != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.jYy.setTitle(intent.getStringExtra("write_title"));
            this.jYy.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gPr = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.kTY = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.gnm = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gnn = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.kOH = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jYy.getType() == 4 ? 6 : 9);
        this.jYy.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.kTY != null && this.kTY.videoId != null) {
            this.jYy.setVideoId(this.kTY.videoId);
            this.jYy.setOriginalVideoCover(this.kTY.showPicUrl);
            this.jYy.setOriginalVideoTitle(this.kTY.showText);
        }
        if (!aq.isEmpty(this.gnm)) {
            if (!aq.isEmpty(this.gnn)) {
                this.jYy.setContent("//@" + this.gnn + " :" + this.gnm);
            } else {
                this.jYy.setContent(this.gnm);
            }
        }
        if (this.jYy != null && this.jYy.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jYy.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kTZ = true;
        }
        cWt();
    }

    private void cWC() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jYQ.setText(com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName)));
            this.jYQ.setMovementMethod(com.baidu.tieba.view.c.cTP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString vJ = com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName));
            if (vJ != null) {
                this.jYQ.setText(vJ);
            }
            this.kUu.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jYy.getType());
        bundle.putString("forum_id", this.jYy.getForumId());
        bundle.putString("forum_name", this.jYy.getForumName());
        bundle.putString("forum_first_dir", this.jYy.getFirstDir());
        bundle.putString("forum_second_dir", this.jYy.getSecondDir());
        bundle.putString("thread_id", this.jYy.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gPr);
        bundle.putSerializable("tab_list", this.kOH);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.kUg != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kUg));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        if (this.kTY != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.kTY));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWz().getEditableText().toString();
        if (obj != null) {
            cWz().setText(TbFaceManager.aPU().a(getPageContext().getPageActivity(), obj, this.kUz));
            cWz().setSelection(cWz().getText().length());
        }
    }

    private String cWD() {
        if (cWz() == null || cWz().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cWz().getText().toString())) {
            if (this.kTY != null && this.kTY.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return cWz().getText().toString();
    }

    private String cWE() {
        if (this.jYy == null || cWA() == null || cWA().getVisibility() != 0 || cWA().getText() == null) {
            return "";
        }
        String obj = cWA().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jYz != 0 && this.jYy.getType() != 4 && this.jYW != null && this.jYW.getText() != null) {
            obj = this.jYW.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jYy.getTitle();
        }
        return obj;
    }

    private void cWF() {
        cIn();
        this.jYy.setContent(cWD());
        this.jYy.setTitle(cWE());
        if (this.kUn >= 0) {
            this.jYy.setCategoryFrom(this.kUn);
        }
        if (this.kUp >= 0) {
            this.jYy.setCategoryTo(this.kUp);
        }
        this.jYy.setWriteImagesInfo(this.writeImagesInfo);
        this.jYy.setHasLocationData(this.dyL != null && this.dyL.brr());
        this.dyM.sY(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.kUt != null && this.kUt.mIsGlobalBlock == 0) {
            this.jYy.setForumId(String.valueOf(this.kUt.mForumId));
            this.jYy.setForumName(this.kUt.mForumName);
        }
        cVB();
        this.dyM.d(this.jYy);
        this.jYy.setContent(this.jYy.getContent().replaceAll("\u0000\n", ""));
        this.jYy.setContent(this.jYy.getContent().replaceAll("\u0000", ""));
        this.jYy.setVcode(null);
        this.dyM.cIp().setVoice(null);
        this.dyM.cIp().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.ggh);
        this.dyM.cME();
    }

    private void cVB() {
        FrsTabItemData selectedTabItemData;
        if (this.jYy != null && this.kSA != null && (selectedTabItemData = this.kSA.getSelectedTabItemData()) != null) {
            this.jYy.setTabId(selectedTabItemData.tabId);
            this.jYy.setTabName(selectedTabItemData.name);
            this.jYy.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.kUg != null) {
                i2 = this.kUg.getTotalCount();
                i = this.kUg.getAlreadyCount() + 1;
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
                if (this.dxg != null && !this.dxg.aOA()) {
                    cWz().requestFocus();
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
                            cWz().getText().insert(cWz().getSelectionStart(), sb.toString());
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
                        if (this.kTX) {
                            sb2.append(com.baidu.tbadk.plugins.b.dGc);
                            this.kTX = false;
                        }
                        sb2.append(stringExtra);
                        vh(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.kUt = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.kUt);
            }
        } else if (i2 == 0) {
            if (this.dxg != null && !this.dxg.aOA()) {
                this.jYU.requestFocus();
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
                        this.kUx.KK(postWriteCallBackData.getErrorString());
                        this.kUx.aU(postWriteCallBackData.getSensitiveWords());
                        this.kUx.b(this.jYQ, this.jYU);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kTW)) {
                        cWA().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kTW)) {
                        cWz().requestFocus();
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
    public void cWG() {
        if ("1".equals(this.gPr)) {
            this.jYy.setCanNoForum(true);
            this.jYy.setTransmitForumData("[]");
        } else if ("2".equals(this.gPr)) {
            this.jYy.setCanNoForum(false);
        }
        cWH();
        this.jYy.setPrivacy(this.isPrivacy);
        this.jYy.setIsShareThread(true);
        if (this.kTY != null && !StringUtils.isNull(this.kTY.threadId)) {
            this.jYy.setOriginalThreadId(this.kTY.threadId);
        }
        this.jYy.setBaijiahaoData(this.mBaijiahaoData);
        if (this.kTY != null) {
            this.jYy.setOriBaijiahaoData(this.kTY.oriUgcInfo);
        }
        this.jYy.setCallFrom(this.gPr);
        cWF();
    }

    private void cWH() {
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWA());
        HidenSoftKeyPad(this.mInputManager, cWz());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gqp) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.jYy.getType() != 7) {
                if (this.kUg == null) {
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
        this.dyR = i;
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWI() {
        if (!this.kUs && this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.dxg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ez(int i) {
        if (i < this.kUe.size()) {
            for (int i2 = 0; i2 < this.kUe.size(); i2++) {
                this.kUe.get(i2).tR(false);
            }
            this.kUe.get(i).tR(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cl(int i) {
        this.jYz = i;
        this.jYX.setCurrentIndex(i);
        Ez(i);
        this.jYW.setText(this.mPrefixData.getPrefixs().get(i));
        cIw();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jYX, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jYZ.setSelected(false);
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
        if (this.jYy != null) {
            if (this.jYy.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jYy.getType() == 5) {
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
            aPa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auO = z;
        if (this.kUw != null && !z) {
            this.kUw.byQ();
        }
        if (this.kUy != null && !z) {
            cWk();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.auO && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kTX = false;
            this.kTW = "";
            if ("from_content".equals(str)) {
                this.kTW = "from_content";
            } else if ("from_title".equals(str)) {
                this.kTW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vI(String.valueOf(charSequence.charAt(i)))) {
                tZ(false);
            }
        }
    }

    public void cDC() {
        if (!v.isEmpty(this.mList)) {
            this.kUb.setVisibility(0);
            this.kUb.requestFocus();
            return;
        }
        this.kUb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWJ() {
        if (((ImageSpan[]) cWz().getText().getSpans(0, cWz().getText().length(), ImageSpan.class)).length > 10) {
            if (this.kUf == null) {
                this.kUf = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.kUf.getView().isShown()) {
                this.kUf.cancel();
            }
            this.kUf.show();
            return true;
        }
        return false;
    }
}
