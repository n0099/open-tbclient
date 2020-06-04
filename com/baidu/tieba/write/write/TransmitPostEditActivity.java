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
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
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
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0125a, i.a {
    private OriginalThreadCardView afK;
    private EditorTools elb;
    private LocationModel emG;
    private NewWriteModel emH;
    List<aa> fnD;
    private String hlv;
    private String hlw;
    private boolean isPrivacy;
    private FrsTabInfoData lSC;
    private ForumTabSelectedView lXd;
    private OriginalThreadInfo.ShareInfo lYB;
    private LinearLayout lYD;
    private LinearLayout lYE;
    private View lYG;
    private Toast lYI;
    private AdditionData lYJ;
    private RelativeLayout lYK;
    private TextView lYL;
    private TextView lYM;
    private TextView lYN;
    aa lYO;
    private int lYP;
    private String lYQ;
    private int lYR;
    private PostCategoryView lYS;
    private HotTopicBussinessData lYV;
    private TextView lYW;
    private com.baidu.tieba.write.editor.b lYY;
    private e lZa;
    private com.baidu.tieba.view.b lZh;
    private TextView lbJ;
    private com.baidu.tieba.write.i lbK;
    private ImageView lbL;
    private View lbM;
    private int lbm;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String lYz = "";
    private boolean lYA = false;
    private WriteData lbl = null;
    private boolean lYC = false;
    private InputMethodManager mInputManager = null;
    private EditText lbD = null;
    private View lbE = null;
    private LinearLayout lbG = null;
    private EditText lbH = null;
    private FeedBackModel lYF = null;
    private ArrayList<WritePrefixItemLayout> lYH = new ArrayList<>();
    private final KeyEvent gZC = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lbI = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hes = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout ita = null;
    private String emL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int emM = 0;
    private View mRootView = null;
    private ScrollView lYT = null;
    private boolean lYU = false;
    private com.baidu.tbadk.core.view.a euw = null;
    private String mFrom = "write";
    private String hOW = "2";
    private SpannableStringBuilder lYX = new SpannableStringBuilder();
    private boolean aUD = false;
    private final b lYZ = new b();
    private boolean lWI = false;
    private TbFaceManager.a lZb = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan yt(String str) {
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
            return new com.baidu.tbadk.core.view.e(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a hoB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lbl != null) {
                TransmitPostEditActivity.this.lYZ.aX(null);
                if (z) {
                    TransmitPostEditActivity.this.ie(z);
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
                    TransmitPostEditActivity.this.lYZ.Og(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.lYZ.aX(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.lYZ.b(TransmitPostEditActivity.this.lbD, TransmitPostEditActivity.this.lbH);
                } else if ((abVar == null || writeData == null || abVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (abVar != null && writeData != null && abVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(abVar.getVcode_md5());
                    writeData.setVcodeUrl(abVar.getVcode_pic_url());
                    writeData.setVcodeExtra(abVar.aYn());
                    if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a emT = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bdO() {
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
            if (aVar != null && !StringUtils.isNull(aVar.dep())) {
                TransmitPostEditActivity.this.a(2, true, aVar.dep());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener loD = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.emG.uw(false);
                    TransmitPostEditActivity.this.emG.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.emG.uw(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener lZc = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lZd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dot = TransmitPostEditActivity.this.dot();
            if (dot >= 0 && dot < TransmitPostEditActivity.this.lbH.getText().length()) {
                TransmitPostEditActivity.this.lbH.setSelection(dot);
            }
        }
    };
    private boolean lZe = true;
    private final View.OnFocusChangeListener fPo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lbD || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lbI) {
                if (z) {
                    TransmitPostEditActivity.this.lZe = true;
                    TransmitPostEditActivity.this.dou();
                    if (TransmitPostEditActivity.this.elb != null) {
                        TransmitPostEditActivity.this.elb.bbA();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lbD);
                } else if (view == TransmitPostEditActivity.this.lbD) {
                    TransmitPostEditActivity.this.lbJ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.lbH && z) {
                TransmitPostEditActivity.this.lZe = false;
                TransmitPostEditActivity.this.dou();
                TransmitPostEditActivity.this.elb.bbA();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lbH);
            }
            TransmitPostEditActivity.this.doz();
        }
    };
    private TextWatcher lZf = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String lZj = "";
        private String lZk;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lZk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lZk != null ? this.lZk.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dam();
            TransmitPostEditActivity.this.doA();
            EditText doM = TransmitPostEditActivity.this.doM();
            if (editable != null && doM != null && doM.getText() != null) {
                if (this.lZj == null || !this.lZj.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.lYZ != null) {
                        this.lZj = doM.getText().toString();
                        TransmitPostEditActivity.this.lYZ.b(doM, true);
                        return;
                    }
                    return;
                }
                doM.setSelection(doM.getSelectionEnd());
            }
        }
    };
    private TextWatcher lZg = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String lZk;
        private String lZl = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lZk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lZk != null ? this.lZk.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dam();
            EditText doL = TransmitPostEditActivity.this.doL();
            if (editable != null && doL != null && doL.getText() != null) {
                int selectionEnd = doL.getSelectionEnd();
                if (this.lZl == null || !this.lZl.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.lYZ != null) {
                        this.lZl = doL.getText().toString();
                        TransmitPostEditActivity.this.lYZ.b(doL, false);
                        return;
                    }
                    return;
                }
                doL.setSelection(selectionEnd);
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
    public void bdy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bdz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdB();
        } else if (this.emG.dew()) {
            bdy();
        } else {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.deu();
        }
    }

    private void bdB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.emG.dey();
                } else {
                    TransmitPostEditActivity.this.emT.bdO();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dot() {
        int selectionEnd = doL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) doL().getText().getSpans(0, doL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = doL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = doL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dou() {
        if (this.elb != null) {
            this.elb.setBarLauncherEnabled(!this.lZe);
            this.elb.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lYU) {
            this.lbD.setVisibility(8);
            dam();
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
        this.emG = new LocationModel(getPageContext());
        this.emG.a(this.emT);
        registerListener(this.loD);
        registerListener(this.lZc);
        cxG();
        this.lbH.requestFocus();
        cVm();
        doT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cxG() {
        this.elb = new EditorTools(getActivity());
        this.elb.setBarMaxLauCount(4);
        this.elb.setMoreButtonAtEnd(true);
        this.elb.setBarLauncherType(1);
        this.elb.hW(true);
        this.elb.hX(true);
        this.elb.setBackgroundColorId(R.color.cp_bg_line_h);
        dov();
        this.elb.build();
        if (this.lWI) {
            this.elb.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.lYD != null) {
            this.lYD.addView(this.elb);
        }
        crq();
        this.elb.display();
        com.baidu.tbadk.editortools.g ne = this.elb.ne(6);
        if (ne != null && !TextUtils.isEmpty(this.emL)) {
            ((View) ne).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.emL);
                }
            });
        }
        if (!this.lYU) {
            this.elb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.elb.bbA();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lbl.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lbl.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.lWI) {
            dox();
        }
    }

    private void dov() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.lWI) {
            this.elb.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        }
        if (!this.lWI && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.elL = 4;
            lVar.elH = R.drawable.icon_post_location_selector;
            lVar.elJ = false;
            this.elb.b(lVar);
        }
        if (!this.lWI && this.lYJ == null) {
            if (this.lYY == null) {
                this.lYY = new com.baidu.tieba.write.editor.b(getActivity(), this.hOW);
                this.lYY.dni();
                this.lYY.setFrom("from_share_write");
                this.lYY.bK(this.lbl.getForumId(), this.mPrivateThread);
            }
            this.elb.b(this.lYY);
        }
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nh = this.elb.nh(5);
        if (nh != null) {
            nh.elL = 1;
            if (this.lWI) {
                nh.hZ(false);
            }
        }
    }

    private void crq() {
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
                            TiebaStatic.log(new an("c12608").ag("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.doK()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.doK()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.doN();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dam();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.lYJ == null) {
                            TransmitPostEditActivity.this.bdC();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.emM) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bdz();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bdy();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.emG != null) {
                            TransmitPostEditActivity.this.emG.uw(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.lbl != null) {
                            str = TransmitPostEditActivity.this.lbl.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.dh("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.lbl == null || (videoInfo = TransmitPostEditActivity.this.lbl.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.elb.bcZ()) {
                                        TransmitPostEditActivity.this.elb.bbA();
                                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lbl.setVideoInfo(null);
                        TransmitPostEditActivity.this.dam();
                        if (TransmitPostEditActivity.this.lbH != null) {
                            TransmitPostEditActivity.this.lbH.requestFocus();
                        }
                        TransmitPostEditActivity.this.elb.bbA();
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lbH);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.lYA = true;
                        TransmitPostEditActivity.this.vB(true);
                        if (TransmitPostEditActivity.this.doM().isFocused()) {
                            TransmitPostEditActivity.this.lYz = "from_title";
                        } else if (TransmitPostEditActivity.this.doL().isFocused()) {
                            TransmitPostEditActivity.this.lYz = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.lYE.setVisibility(0);
                        TransmitPostEditActivity.this.lYE.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.lYE.hasFocus()) {
                            TransmitPostEditActivity.this.lbH.requestFocus();
                            TransmitPostEditActivity.this.lbH.setSelection(TransmitPostEditActivity.this.lbH.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.lYE.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.elb.setActionListener(31, bVar);
        this.elb.setActionListener(16, bVar);
        this.elb.setActionListener(14, bVar);
        this.elb.setActionListener(24, bVar);
        this.elb.setActionListener(3, bVar);
        this.elb.setActionListener(10, bVar);
        this.elb.setActionListener(11, bVar);
        this.elb.setActionListener(12, bVar);
        this.elb.setActionListener(13, bVar);
        this.elb.setActionListener(15, bVar);
        this.elb.setActionListener(18, bVar);
        this.elb.setActionListener(20, bVar);
        this.elb.setActionListener(25, bVar);
        this.elb.setActionListener(27, bVar);
        this.elb.setActionListener(29, bVar);
        this.elb.setActionListener(43, bVar);
        this.elb.setActionListener(45, bVar);
        this.elb.setActionListener(53, bVar);
        this.elb.setActionListener(48, bVar);
        this.elb.setActionListener(46, bVar);
        this.elb.setActionListener(49, bVar);
        this.elb.setActionListener(47, bVar);
        this.elb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdC() {
        if (this.emG.bHo()) {
            if (this.emG.dew()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.der().getLocationData().dep());
                return;
            }
            a(1, true, (String) null);
            this.emG.deu();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dad() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lYF != null) {
            this.lYF.cancelLoadData();
        }
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    private void dow() {
        if (this.lZa != null) {
            this.lZa.hideTip();
        }
    }

    private void dox() {
        if (this.lZa == null) {
            this.lZa = new e(getPageContext());
        }
        this.lZa.c(this.elb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dow();
        TiebaPrepareImageService.StopService();
        dad();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        if (this.lbl == null) {
            finish();
            return;
        }
        this.lbl.setTitle(doM().getText().toString());
        this.lbl.setContent(doL().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lbK != null && this.lbK.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lbK, getPageContext().getPageActivity());
                return true;
            } else if (this.elb.bcZ()) {
                this.elb.bbA();
                return true;
            } else {
                dad();
                doy();
                return true;
            }
        }
        if (i == 67 && (text = doL().getText()) != null) {
            int selectionStart = doL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                doL().onKeyDown(67, this.gZC);
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
        getLayoutMode().onModeChanged(this.ita);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.lbI, R.color.cp_link_tip_a, 1);
        dou();
        am.setBackgroundColor(this.lbE, R.color.cp_bg_line_c);
        am.setBackgroundColor(doM(), R.color.cp_bg_line_d);
        am.setBackgroundColor(doL(), R.color.cp_bg_line_d);
        dam();
        this.elb.onChangeSkinType(i);
        if (this.lYS != null) {
            this.lYS.aWr();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        doz();
        doA();
        if (this.lYZ != null) {
            this.lYZ.c(doM(), doL());
        }
        if (this.afK != null) {
            this.afK.onChangeSkinType();
        }
        if (this.lXd != null) {
            this.lXd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doz() {
        if (this.lbD.hasFocus()) {
            this.lbD.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lbD.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.lbH.hasFocus()) {
            this.lbH.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lbH.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doA() {
        if (this.lbD != null) {
            if (this.lbD.getText().toString().length() == 0) {
                this.lbD.getPaint().setFakeBoldText(false);
            } else if (this.lbD.getText().toString().length() > 0) {
                this.lbD.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.euw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lYU = this.lbl.getType() == 4 || 5 == this.lbl.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        doD();
        this.lYT = (ScrollView) findViewById(R.id.write_scrollview);
        this.lYT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.lbH != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.lbH);
                    }
                    if (TransmitPostEditActivity.this.elb != null) {
                        TransmitPostEditActivity.this.elb.bbA();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ita = (RelativeLayout) findViewById(R.id.parent);
        this.lYD = (LinearLayout) findViewById(R.id.tool_view);
        this.lYD.setContentDescription(IStringUtil.TOP_PATH);
        this.lYE = (LinearLayout) findViewById(R.id.title_view);
        this.lbE = findViewById(R.id.interval_view);
        this.lYW = (TextView) findViewById(R.id.hot_topic_title_edt);
        dal();
        if (this.lYU) {
            this.lYT.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dan();
        doJ();
        this.lbG = (LinearLayout) findViewById(R.id.post_content_container);
        this.lbG.setDrawingCacheEnabled(false);
        this.lbG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.lbH.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fPo);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dad();
                TransmitPostEditActivity.this.doy();
            }
        });
        doG();
        doI();
        doC();
        dou();
        doH();
        dak();
        doO();
        doB();
        if (this.lbl.getType() == 4 && this.lbM != null && this.lYG != null) {
            this.lbM.setVisibility(8);
            this.lYG.setVisibility(8);
        }
        dam();
        ShowSoftKeyPad(this.mInputManager, this.lbD);
    }

    private void doB() {
        this.lXd = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lXd.setData(this.lSC);
        this.lXd.setActivity(this);
    }

    private void doC() {
        String str;
        String str2;
        if (this.lbl != null) {
            switch (this.lbl.getType()) {
                case 0:
                case 9:
                    if (this.hOW != null && this.hOW.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.lWI) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.hOW != null && this.hOW.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lbl.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lbD.setVisibility(0);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lbD.setVisibility(8);
                    return;
            }
        }
    }

    private void doD() {
        if (this.lWI) {
            this.lbI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lbI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lbI.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lbI.setLayoutParams(layoutParams);
        this.lbI.setOnFocusChangeListener(this.fPo);
    }

    private void doE() {
        if (this.lbl != null && this.lbl.getType() == 0 && this.lbl.getType() == 9 && !this.lYC && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && doM() != null) {
                doM().setText(cutStringWithSuffix);
                doM().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void doF() {
        this.fnD = null;
        this.lYP = -1;
        this.lYR = -1;
        ac uf = com.baidu.tieba.frs.ab.bWN().uf(1);
        if (uf != null) {
            this.fnD = uf.hri;
            this.lYP = getIntent().getIntExtra("category_id", -1);
            if (this.fnD != null && !this.fnD.isEmpty() && this.lYP >= 0) {
                this.lYO = new aa();
                this.lYO.hre = 0;
                this.lYO.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lYR = this.lYO.hre;
                this.lYQ = this.lYO.name;
                for (aa aaVar : this.fnD) {
                    if (aaVar.hre == this.lYP) {
                        this.lYR = aaVar.hre;
                        this.lYQ = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void doG() {
        if (this.fnD != null && !this.fnD.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lYS = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lYS.setText(this.lYQ);
            this.lYS.setCategoryContainerData(this.fnD, this.lYO, this.lYR);
            this.lYS.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        TransmitPostEditActivity.this.lYS.setText(axVar.name);
                        TransmitPostEditActivity.this.lbl.setCategoryTo(axVar.hre);
                        TransmitPostEditActivity.this.lYR = axVar.hre;
                        TransmitPostEditActivity.this.lYS.doh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lYS.dog();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doM());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doL());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lZh = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lZh.setTitle(R.string.no_disturb_start_time);
        this.lZh.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lZh);
        this.lZh.setButton(-2, getPageContext().getString(R.string.cancel), this.lZh);
        return this.lZh;
    }

    private void doH() {
        this.lYK = (RelativeLayout) findViewById(R.id.addition_container);
        this.lYL = (TextView) findViewById(R.id.addition_create_time);
        this.lYM = (TextView) findViewById(R.id.addition_last_time);
        this.lYN = (TextView) findViewById(R.id.addition_last_content);
        if (this.lYJ != null) {
            this.lYK.setVisibility(0);
            this.lYL.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lYJ.getCreateTime() * 1000));
            if (this.lYJ.getAlreadyCount() == 0) {
                this.lYM.setVisibility(8);
            } else {
                this.lYM.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lYJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lYJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lYN.setText(lastAdditionContent);
            } else {
                this.lYN.setVisibility(8);
            }
            doL().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lYJ.getAlreadyCount()), Integer.valueOf(this.lYJ.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lYK.setVisibility(8);
    }

    private void dak() {
        this.lbM = findViewById(R.id.post_prefix_layout);
        this.lbJ = (TextView) findViewById(R.id.post_prefix);
        this.lYG = findViewById(R.id.prefix_divider);
        this.lbL = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lbM.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lbm = 1;
            this.lbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lbJ.setVisibility(0);
                    TransmitPostEditActivity.this.lbM.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lbK, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.elb.bbA();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lbD);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lbH);
                }
            });
            this.lbL = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lbL.setVisibility(0);
                this.lbJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lbJ.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lbK, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.elb.bbA();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doM());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doL());
                    }
                });
            }
            this.lbK = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lbK.a(this);
            this.lbK.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lbK.setOutsideTouchable(true);
            this.lbK.setFocusable(true);
            this.lbK.setOnDismissListener(this);
            this.lbK.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.lbJ, R.color.cp_bg_line_d);
            am.setImageResource(this.lbL, R.drawable.icon_frs_arrow_n);
            this.lbJ.setTextColor(color);
            this.lYH.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lYH.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lbK.addView(writePrefixItemLayout);
            }
            this.lbK.setCurrentIndex(0);
            this.lbJ.setText(prefixs.get(1));
            FP(1);
            return;
        }
        this.lbM.setVisibility(8);
    }

    protected void doI() {
        this.lbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.doU()) {
                    if (TransmitPostEditActivity.this.lYZ.a(TransmitPostEditActivity.this.lbD, TransmitPostEditActivity.this.lbH)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.lYZ.dmz());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doM());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.doL());
                    TransmitPostEditActivity.this.elb.bbA();
                    TiebaStatic.log(new an("c12608").ag("obj_locate", 7));
                    TransmitPostEditActivity.this.doR();
                }
            }
        });
    }

    protected void dal() {
        this.lbD = (EditText) findViewById(R.id.post_title);
        this.lbD.setOnClickListener(this.lZd);
        this.lbD.setOnFocusChangeListener(this.fPo);
        if ((this.lbl.getType() == 0 || this.lbl.getType() == 9 || this.lbl.getType() == 7) && this.lbl.getTitle() != null) {
            this.lbD.setText(this.lbl.getTitle());
            this.lbD.setSelection(this.lbl.getTitle().length());
        }
        this.lbD.addTextChangedListener(this.lZf);
        if (!this.lbl.getHaveDraft()) {
            doE();
        }
        this.lbD.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dan() {
        this.lbH = (EditText) findViewById(R.id.post_content);
        this.lbH.setDrawingCacheEnabled(false);
        this.lbH.setOnClickListener(this.lZd);
        if (this.lbl.getContent() != null && this.lbl.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bet().ak(getPageContext().getPageActivity(), this.lbl.getContent());
            this.lbH.setText(ak);
            this.lbH.setSelection(ak.length());
        }
        if (!aq.isEmpty(this.hlv)) {
            this.lbH.setSelection(0);
        }
        this.lbH.setOnFocusChangeListener(this.fPo);
        this.lbH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.lbH.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lbH.addTextChangedListener(this.lZg);
        if (this.lWI) {
            this.lbH.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.lYB != null && this.lYB.showType == 3) {
            this.lbH.setHint(R.string.share_video_default);
        } else {
            this.lbH.setHint(R.string.share_txt_default);
        }
    }

    private void doJ() {
        this.afK = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.afK.setVisibility(0);
        this.afK.a(this.lYB);
        this.afK.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doK() {
        int i = 5000;
        if (this.lYJ != null) {
            i = 1000;
        }
        return doL().getText() != null && doL().getText().length() >= i;
    }

    private void ye(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lYz)) {
                this.lYz = "";
                doL().requestFocus();
                if (doL().getText() != null && doL().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = doL().getSelectionStart();
                    editable = doL().getText();
                }
            } else if ("from_title".equals(this.lYz)) {
                this.lYz = "";
                doM().requestFocus();
                if (doM().getText() != null && doM().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = doM().getSelectionStart();
                    editable = doM().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lbl != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lbl.getForumId(), 0L), this.lbl.getFirstDir(), this.lbl.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) doL().getText().getSpans(0, doL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lYI == null) {
                this.lYI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.lYI.getView().isShown()) {
                this.lYI.cancel();
            }
            this.lYI.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aYd = qVar.aYd();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kX().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.doL().getSelectionStart(), aVar, aYd);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && doL() != null && doL().getText() != null) {
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
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = doL().getSelectionStart() - 1;
                if (doL().getText().length() > 1 && selectionStart >= 0 && doL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    doL().getText().insert(doL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            doL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                doL().getText().insert(doL().getSelectionStart(), spannableString2);
            }
            Editable text = doL().getText();
            if (text != null) {
                this.lYX.clear();
                this.lYX.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lYX);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && doL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    doL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                doL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText doL() {
        return this.lbH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText doM() {
        return this.lbD;
    }

    protected void doN() {
        Editable text;
        if (doL() != null && (text = doL().getText()) != null) {
            int selectionStart = doL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                doL().onKeyDown(67, this.gZC);
            }
            doL().onKeyDown(67, this.gZC);
            int selectionStart2 = doL().getSelectionStart();
            this.lYX.clear();
            this.lYX.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.lYX);
            doL().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dam() {
        if (this.lbl != null) {
            String str = "";
            String str2 = "";
            if (doM() != null) {
                str = doM().getText().toString();
            }
            if (doL() != null) {
                str2 = doL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lbl.getType() == 0 || this.lbl.getType() == 9 || this.lbl.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lbm == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lbl.setIsNoTitle(true);
                        } else {
                            this.lbl.setIsNoTitle(false);
                            vC(true);
                            return;
                        }
                    } else {
                        this.lbl.setIsNoTitle(false);
                        vC(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lbl.setIsNoTitle(true);
                } else {
                    this.lbl.setIsNoTitle(false);
                    vC(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lYU) {
                    vC(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vC(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                vC(true);
            } else if (this.lbl.getVideoInfo() != null) {
                vC(true);
            } else {
                vC(false);
            }
        }
    }

    private void vC(boolean z) {
        am.setNavbarTitleColor(this.lbI, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.emH = new NewWriteModel(this);
        this.emH.b(this.emV);
        this.hes = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dad();
            }
        };
        this.lbl = new WriteData();
        if (bundle != null) {
            this.lbl.setType(bundle.getInt("type", 0));
            this.lbl.setForumId(bundle.getString("forum_id"));
            this.lbl.setForumName(bundle.getString("forum_name"));
            this.lbl.setFirstDir(bundle.getString("forum_first_dir"));
            this.lbl.setSecondDir(bundle.getString("forum_second_dir"));
            this.lbl.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lYJ = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lbl.setIsAddition(this.lYJ != null);
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
            this.lbl.setTitle(bundle.getString("write_title"));
            this.lbl.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hOW = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.lYB = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hlv = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hlw = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.lSC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lbl.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lbl.setType(intent.getIntExtra("type", 0));
            this.lbl.setForumId(intent.getStringExtra("forum_id"));
            this.lbl.setForumName(intent.getStringExtra("forum_name"));
            this.lbl.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lbl.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lbl.setThreadId(intent.getStringExtra("thread_id"));
            this.lYJ = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lbl.setIsAddition(this.lYJ != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lbl.setTitle(intent.getStringExtra("write_title"));
            this.lbl.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hOW = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.lYB = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lbl.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hlv = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hlw = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.lSC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lbl.mDynamicForwardData != null) {
            this.lWI = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lbl.getType() == 4 ? 6 : 9);
        this.lbl.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.lYB != null && this.lYB.videoId != null) {
            this.lbl.setVideoId(this.lYB.videoId);
            this.lbl.setOriginalVideoCover(this.lYB.showPicUrl);
            this.lbl.setOriginalVideoTitle(this.lYB.showText);
        }
        if (!aq.isEmpty(this.hlv)) {
            if (!aq.isEmpty(this.hlw)) {
                this.lbl.setContent("//@" + this.hlw + " :" + this.hlv);
            } else {
                this.lbl.setContent(this.hlv);
            }
        }
        if (this.lbl != null && this.lbl.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lbl.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lYC = true;
        }
        doF();
    }

    private void doO() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lbD.setText(com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName)));
            this.lbD.setMovementMethod(com.baidu.tieba.view.c.dmf());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString yI = com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName));
            if (yI != null) {
                this.lbD.setText(yI);
            }
            this.lYW.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lbl.getType());
        bundle.putString("forum_id", this.lbl.getForumId());
        bundle.putString("forum_name", this.lbl.getForumName());
        bundle.putString("forum_first_dir", this.lbl.getFirstDir());
        bundle.putString("forum_second_dir", this.lbl.getSecondDir());
        bundle.putString("thread_id", this.lbl.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOW);
        bundle.putSerializable("tab_list", this.lSC);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.lYJ != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lYJ));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOW);
        if (this.lbl.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lbl.mDynamicForwardData);
        }
        if (this.lYB != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.lYB));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = doL().getEditableText().toString();
        if (obj != null) {
            doL().setText(TbFaceManager.bet().a(getPageContext().getPageActivity(), obj, this.lZb));
            doL().setSelection(doL().getText().length());
        }
    }

    private String doP() {
        if (doL() == null || doL().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(doL().getText().toString())) {
            if (this.lYB != null && this.lYB.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return doL().getText().toString();
    }

    private String doQ() {
        if (this.lbl == null || doM() == null || doM().getVisibility() != 0 || doM().getText() == null) {
            return "";
        }
        String obj = doM().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lbm != 0 && this.lbl.getType() != 4 && this.lbJ != null && this.lbJ.getText() != null) {
            obj = this.lbJ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lbl.getTitle();
        }
        return obj;
    }

    private void bYH() {
        if (this.lbl != null && this.lbl.mDynamicForwardData != null) {
            dnO();
            return;
        }
        dad();
        this.lbl.setContent(doP());
        this.lbl.setTitle(doQ());
        if (this.lYP >= 0) {
            this.lbl.setCategoryFrom(this.lYP);
        }
        if (this.lYR >= 0) {
            this.lbl.setCategoryTo(this.lYR);
        }
        this.lbl.setWriteImagesInfo(this.writeImagesInfo);
        this.lbl.setHasLocationData(this.emG != null && this.emG.bHo());
        this.emH.uy(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.lYV != null && this.lYV.mIsGlobalBlock == 0) {
            this.lbl.setForumId(String.valueOf(this.lYV.mForumId));
            this.lbl.setForumName(this.lYV.mForumName);
        }
        dnP();
        this.emH.d(this.lbl);
        this.lbl.setContent(this.lbl.getContent().replaceAll("\u0000\n", ""));
        this.lbl.setContent(this.lbl.getContent().replaceAll("\u0000", ""));
        this.lbl.setVcode(null);
        this.emH.daf().setVoice(null);
        this.emH.daf().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hes);
        this.emH.dfc();
    }

    private void dnP() {
        FrsTabItemData selectedTabItemData;
        if (this.lbl != null && this.lXd != null && (selectedTabItemData = this.lXd.getSelectedTabItemData()) != null) {
            this.lbl.setTabId(selectedTabItemData.tabId);
            this.lbl.setTabName(selectedTabItemData.name);
            this.lbl.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dnO() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lbl.mDynamicForwardData.forward_content = doP();
        this.lbl.mDynamicForwardData.inputText = doP();
        this.lbl.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dnA().a(this.lbl.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.f(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.ie(true);
                Intent intent = new Intent();
                intent.putExtras(new Bundle());
                TransmitPostEditActivity.this.setResult(-1, intent);
                TransmitPostEditActivity.this.finish();
            }

            @Override // com.baidu.tieba.write.b.c.b.a
            public void onFail(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                if (TextUtils.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                }
                l.showToast(TbadkCoreApplication.getInst(), str);
            }
        });
    }

    private void C(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.lYJ != null) {
                i2 = this.lYJ.getTotalCount();
                i = this.lYJ.getAlreadyCount() + 1;
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
                if (this.elb != null && !this.elb.bcZ()) {
                    doL().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append(UgcConstant.AT_RULE_TAG);
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            doL().getText().insert(doL().getSelectionStart(), sb.toString());
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
                        if (this.lYA) {
                            sb2.append(com.baidu.tbadk.plugins.b.euc);
                            this.lYA = false;
                        }
                        sb2.append(stringExtra);
                        ye(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.lYV = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.lYV);
            }
        } else if (i2 == 0) {
            if (this.elb != null && !this.elb.bcZ()) {
                this.lbH.requestFocus();
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
                        this.lYZ.Og(postWriteCallBackData.getErrorString());
                        this.lYZ.aX(postWriteCallBackData.getSensitiveWords());
                        this.lYZ.b(this.lbD, this.lbH);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lYz)) {
                        doM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lYz)) {
                        doL().requestFocus();
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
    public void doR() {
        if ("1".equals(this.hOW)) {
            this.lbl.setCanNoForum(true);
            this.lbl.setTransmitForumData("[]");
        } else if ("2".equals(this.hOW)) {
            this.lbl.setCanNoForum(false);
        }
        doS();
        this.lbl.setPrivacy(this.isPrivacy);
        this.lbl.setIsShareThread(true);
        if (this.lYB != null && !StringUtils.isNull(this.lYB.threadId)) {
            this.lbl.setOriginalThreadId(this.lYB.threadId);
        }
        this.lbl.setBaijiahaoData(this.mBaijiahaoData);
        if (this.lYB != null) {
            this.lbl.setOriBaijiahaoData(this.lYB.oriUgcInfo);
        }
        this.lbl.setCallFrom(this.hOW);
        bYH();
    }

    private void doS() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, doM());
        HidenSoftKeyPad(this.mInputManager, doL());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hoB) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lbl.getType() != 7) {
                if (this.lYJ == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                C(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void doT() {
        if (!this.lYU && this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.elb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void FP(int i) {
        if (i < this.lYH.size()) {
            for (int i2 = 0; i2 < this.lYH.size(); i2++) {
                this.lYH.get(i2).vr(false);
            }
            this.lYH.get(i).vr(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Dx(int i) {
        this.lbm = i;
        this.lbK.setCurrentIndex(i);
        FP(i);
        this.lbJ.setText(this.mPrefixData.getPrefixs().get(i));
        dam();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lbK, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lbM.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
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
        if (this.lbl != null) {
            if (this.lbl.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lbl.getType() == 5) {
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
            bdz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aUD = z;
        if (this.lYY != null && !z) {
            this.lYY.bPh();
        }
        if (this.lZa != null && !z) {
            dow();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aUD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.lYA = false;
            this.lYz = "";
            if ("from_content".equals(str)) {
                this.lYz = "from_content";
            } else if ("from_title".equals(str)) {
                this.lYz = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.yH(String.valueOf(charSequence.charAt(i)))) {
                vB(false);
            }
        }
    }

    public void cVm() {
        if (!v.isEmpty(this.mList)) {
            this.lYE.setVisibility(0);
            this.lYE.requestFocus();
            return;
        }
        this.lYE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doU() {
        if (((ImageSpan[]) doL().getText().getSpans(0, doL().getText().length(), ImageSpan.class)).length > 10) {
            if (this.lYI == null) {
                this.lYI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.lYI.getView().isShown()) {
                this.lYI.cancel();
            }
            this.lYI.show();
            return true;
        }
        return false;
    }
}
