package com.baidu.tieba.sharewrite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes24.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager div;
    private String esu;
    private NewWriteModel fbr;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private int mtB;
    private c mtC;
    b mtD;
    private com.baidu.tieba.sharewrite.a mtG;
    private com.baidu.tieba.sharewrite.a mtH;
    private String mtw;
    private String mtx;
    private String mty;
    private PackageInfo mtz;
    private String packageName;
    private WriteData mtA = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ifK = null;
    private boolean mtE = false;
    private boolean mtF = false;
    private a.b mtI = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mtA.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b mtJ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAS());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAT());
            WriteShareActivity.this.dAL();
            aVar.dismiss();
        }
    };
    private a.b mtK = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.mtF) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b mtL = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mtA.setShareSummaryImg("");
                WriteShareActivity.this.mtA.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mtA.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mtA.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mtA.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mtA.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c mtM = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dAG();
                if (WriteShareActivity.this.mtG != null) {
                    WriteShareActivity.this.mtF = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mtG.dAB();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dAH();
                if (WriteShareActivity.this.mtH != null) {
                    WriteShareActivity.this.mtF = false;
                    WriteShareActivity.this.mtH.dAB();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bqD());
                WriteShareActivity.this.mtE = true;
                if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener mtN = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.mtC != null && WriteShareActivity.this.mtC.dAU() != null && WriteShareActivity.this.mtC.dAU().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.mtC.dAU(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dAI();
                if (WriteShareActivity.this.mtF) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener mtO = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dAI();
            if (WriteShareActivity.this.mtF) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener mtP = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAS());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAT());
            WriteShareActivity.this.dAL();
        }
    };
    private View.OnClickListener mtQ = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mtC.dAT().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAT());
        }
    };
    private final View.OnFocusChangeListener gKu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mtC != null) {
                if (view == WriteShareActivity.this.mtC.dAS() || view == WriteShareActivity.this.mtC.dAV() || view == WriteShareActivity.this.mtC.dAW()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAS());
                    } else if (view == WriteShareActivity.this.mtC.dAS() && WriteShareActivity.this.mtC.dAX() != null) {
                        WriteShareActivity.this.mtC.dAX().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.mtC.dAT()) {
                    if (z) {
                        WriteShareActivity.this.mtC.dAT().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.mtC.dAT().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mtC.dAS());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        setSwipeBackEnabled(false);
        this.div = getPageContext().getPageActivity().getPackageManager();
        cdu();
        boolean dAD = dAD();
        initData(bundle);
        initUI();
        if (!dAD) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Iz(R.string.share_parameter_invalid_tip);
            } else {
                Iz(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dAE();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cdu() {
        this.packageName = getCallingPackage();
        if (this.div != null && this.packageName != null) {
            try {
                this.mtz = this.div.getPackageInfo(this.packageName, 64);
                if (this.mtz != null) {
                    if (this.mtz.applicationInfo != null && this.mtz.applicationInfo.loadLabel(this.div) != null) {
                        this.mAppName = this.mtz.applicationInfo.loadLabel(this.div).toString();
                    }
                    if (this.mtz.signatures != null && this.mtz.signatures.length > 0 && this.mtz.signatures[0] != null) {
                        this.mty = av.getAPKHexMD5(this.mtz.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.mty = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mtw = extras.getString("ShareUrl");
            this.esu = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mtx = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mty)) {
                this.mty = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dAD() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.esu) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dAE() {
        if (TextUtils.isEmpty(this.mtx)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dAF();
        }
    }

    private void dAF() {
        this.mtC.dAN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mtD.Rw(this.mtA.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAG() {
        if (this.mtG == null) {
            this.mtG = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mtG.wA(false);
            this.mtG.Iv(R.drawable.icon_send_ok);
            this.mtG.Iy(R.string.share_alert_success);
            this.mtG.a(R.string.share_stay_in_tieba, this.mtI);
            this.mtG.b(R.string.back, this.mtK);
            this.mtG.b(this.mtN);
            this.mtG.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAH() {
        if (this.mtH == null) {
            this.mtH = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mtH.Iv(R.drawable.icon_send_error);
            this.mtH.Iw(R.drawable.btn_w_square);
            this.mtH.Ix(R.color.common_color_10039);
            this.mtH.Iy(R.string.share_alert_fail);
            this.mtH.a(R.string.share_keep_sending, this.mtJ);
            this.mtH.b(R.string.back, this.mtK);
            this.mtH.b(this.mtN);
            this.mtH.g(getPageContext());
        }
    }

    protected void dAI() {
        if (this.fbr != null) {
            this.fbr.cancelLoadData();
        }
    }

    protected void dAJ() {
        if (this.fbr != null) {
            this.fbr.dFE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dAI();
        dAJ();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dAY;
        if (this.mtC != null && (dAY = this.mtC.dAY()) != null) {
            dAY.setImageBitmap(null);
        }
    }

    public WriteData cSo() {
        return this.mtA;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mtC != null && this.mtC.dAU() != null && this.mtC.dAU().isShowing()) {
                g.dismissPopupWindow(this.mtC.dAU(), getPageContext().getPageActivity());
                return true;
            }
            dAI();
            if (this.mtF) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtC != null) {
            this.mtC.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mtC = new c(this);
        this.mtC.ae(this.mtO);
        this.mtC.af(this.mtP);
        this.mtC.b(this.gKu);
        this.mtC.ag(this.mtQ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a implements Runnable {
        private Activity mActivity;

        public a(Activity activity) {
            this.mActivity = null;
            this.mActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mActivity != null) {
                WriteShareActivity.this.setResult(0);
                com.baidu.tbadk.core.e.b.d(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void Iz(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fbr = new NewWriteModel(this);
        this.fbr.a(this.mtM);
        this.fbr.a(this.mtL);
        this.mtD = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.mtC != null) {
                            WriteShareActivity.this.mtC.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mtC.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mtC.a((PostPrefixData) null);
            }
        });
        this.ifK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dAI();
            }
        };
        this.mtA = new WriteData();
        this.mtA.setType(3);
        if (bundle != null) {
            this.mtA.setForumName(bundle.getString("forum_name"));
            this.mtA.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mtA.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mtA.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mtA.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mtA.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mtA.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mtA.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mtA.setForumName(this.mtx);
            this.mtA.setShareSummaryTitle(this.mShareTitle);
            this.mtA.setShareSummaryContent(this.mShareContent);
            this.mtA.setShareApiKey(this.mAppKey);
            this.mtA.setShareAppName(this.mAppName);
            this.mtA.setShareSignKey(this.mty);
            this.mtA.setShareReferUrl(this.mtw);
            boolean isLocalImagePath = n.isLocalImagePath(this.esu);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fbr.d(this.mShareLocalImageData, this.esu);
                this.mtA.setShareLocalImageUri(this.esu);
                this.mtA.setShareLocalImageData(this.mShareLocalImageData);
                this.fbr.cpg();
                this.mtA.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mtA.setShareSummaryImg(this.esu);
                this.mtA.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mtA.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mtA.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mtA.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mtA.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mtA.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mtA.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mtA.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mtA.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mtA.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mtA.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mtA.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mtA.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mtA.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mtA.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mtA.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mtA.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mtA.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.mtC != null && this.mtC.dAT() != null && (obj = this.mtC.dAT().getEditableText().toString()) != null) {
            this.mtC.dAT().setText(TbFaceManager.bwK().av(getPageContext().getContext(), obj));
            this.mtC.dAT().setSelection(this.mtC.dAT().getText().length());
        }
    }

    public void IA(int i) {
        this.mtB = i;
    }

    public int dAK() {
        return this.mtB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAL() {
        dAI();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.mtB != this.mPrefixData.getPrefixs().size() - 1) {
            this.mtA.setTitle(this.mtC.dAX().getText().toString() + this.mtC.dAS().getText().toString());
        } else {
            this.mtA.setTitle(this.mtC.dAS().getText().toString());
        }
        this.mtA.setContent(this.mtC.dAT().getText().toString());
        this.fbr.e(this.mtA);
        this.mtA.setVcode(null);
        this.fbr.cSo().setVoice(null);
        this.fbr.cSo().setVoiceDuringTime(-1);
        if (this.fbr.dFC()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.ifK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.mtE = false;
            if (i2 == -1) {
                dAG();
                if (this.mtG != null) {
                    this.mtF = true;
                    this.mtG.dAB();
                }
                setResult(-1);
                return;
            }
            dAH();
            if (this.mtH != null) {
                this.mtF = false;
                this.mtH.dAB();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.mtx = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mtA.setForumName(this.mtx);
                    dAF();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dAE();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mtC.dAS());
        HidenSoftKeyPad(this.mInputManager, this.mtC.dAT());
        super.onPause();
    }

    public void dAM() {
        HidenSoftKeyPad(this.mInputManager, this.mtC.dAS());
        HidenSoftKeyPad(this.mInputManager, this.mtC.dAT());
    }
}
