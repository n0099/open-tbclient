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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager bSB;
    private String cUz;
    private NewWriteModel dyM;
    private c jYA;
    b jYB;
    private com.baidu.tieba.sharewrite.a jYE;
    private com.baidu.tieba.sharewrite.a jYF;
    private String jYu;
    private String jYv;
    private String jYw;
    private PackageInfo jYx;
    private int jYz;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jYy = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ggh = null;
    private boolean jYC = false;
    private boolean jYD = false;
    private a.b jYG = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jYy.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jYH = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIy());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIz());
            WriteShareActivity.this.cIr();
            aVar.dismiss();
        }
    };
    private a.b jYI = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jYD) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jYJ = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jYy.setShareSummaryImg("");
                WriteShareActivity.this.jYy.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jYy.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jYy.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jYy.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jYy.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jYK = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cIl();
                if (WriteShareActivity.this.jYE != null) {
                    WriteShareActivity.this.jYD = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jYE.cIg();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cIm();
                if (WriteShareActivity.this.jYF != null) {
                    WriteShareActivity.this.jYD = false;
                    WriteShareActivity.this.jYF.cIg();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aJL());
                WriteShareActivity.this.jYC = true;
                if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jYL = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jYA != null && WriteShareActivity.this.jYA.cIA() != null && WriteShareActivity.this.jYA.cIA().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jYA.cIA(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cIn();
                if (WriteShareActivity.this.jYD) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener jYM = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cIn();
            if (WriteShareActivity.this.jYD) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jYN = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIy());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIz());
            WriteShareActivity.this.cIr();
        }
    };
    private View.OnClickListener jYO = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jYA.cIz().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIz());
        }
    };
    private final View.OnFocusChangeListener eWH = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jYA != null) {
                if (view == WriteShareActivity.this.jYA.cIy() || view == WriteShareActivity.this.jYA.cIB() || view == WriteShareActivity.this.jYA.cIC()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIy());
                    } else if (view == WriteShareActivity.this.jYA.cIy() && WriteShareActivity.this.jYA.cID() != null) {
                        WriteShareActivity.this.jYA.cID().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jYA.cIz()) {
                    if (z) {
                        WriteShareActivity.this.jYA.cIz().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jYA.cIz().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jYA.cIy());
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
        this.bSB = getPageContext().getPageActivity().getPackageManager();
        bgf();
        boolean cIi = cIi();
        initData(bundle);
        initUI();
        if (!cIi) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Cj(R.string.share_parameter_invalid_tip);
            } else {
                Cj(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cIj();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bgf() {
        this.packageName = getCallingPackage();
        if (this.bSB != null && this.packageName != null) {
            try {
                this.jYx = this.bSB.getPackageInfo(this.packageName, 64);
                if (this.jYx != null) {
                    if (this.jYx.applicationInfo != null && this.jYx.applicationInfo.loadLabel(this.bSB) != null) {
                        this.mAppName = this.jYx.applicationInfo.loadLabel(this.bSB).toString();
                    }
                    if (this.jYx.signatures != null && this.jYx.signatures.length > 0 && this.jYx.signatures[0] != null) {
                        this.jYw = as.getAPKHexMD5(this.jYx.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jYw = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jYu = extras.getString("ShareUrl");
            this.cUz = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jYv = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jYw)) {
                this.jYw = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cIi() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cUz) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cIj() {
        if (TextUtils.isEmpty(this.jYv)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cIk();
        }
    }

    private void cIk() {
        this.jYA.cIt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jYB.IH(this.jYy.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIl() {
        if (this.jYE == null) {
            this.jYE = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jYE.sC(false);
            this.jYE.Cf(R.drawable.icon_send_ok);
            this.jYE.Ci(R.string.share_alert_success);
            this.jYE.a(R.string.share_stay_in_tieba, this.jYG);
            this.jYE.b(R.string.back, this.jYI);
            this.jYE.a(this.jYL);
            this.jYE.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIm() {
        if (this.jYF == null) {
            this.jYF = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jYF.Cf(R.drawable.icon_send_error);
            this.jYF.Cg(R.drawable.btn_w_square);
            this.jYF.Ch(R.color.common_color_10039);
            this.jYF.Ci(R.string.share_alert_fail);
            this.jYF.a(R.string.share_keep_sending, this.jYH);
            this.jYF.b(R.string.back, this.jYI);
            this.jYF.a(this.jYL);
            this.jYF.f(getPageContext());
        }
    }

    protected void cIn() {
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
    }

    protected void cIo() {
        if (this.dyM != null) {
            this.dyM.cMG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cIn();
        cIo();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cIE;
        if (this.jYA != null && (cIE = this.jYA.cIE()) != null) {
            cIE.setImageBitmap(null);
        }
    }

    public WriteData cIp() {
        return this.jYy;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jYA != null && this.jYA.cIA() != null && this.jYA.cIA().isShowing()) {
                g.dismissPopupWindow(this.jYA.cIA(), getPageContext().getPageActivity());
                return true;
            }
            cIn();
            if (this.jYD) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jYA != null) {
            this.jYA.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jYA = new c(this);
        this.jYA.ab(this.jYM);
        this.jYA.ac(this.jYN);
        this.jYA.b(this.eWH);
        this.jYA.ad(this.jYO);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
                com.baidu.tbadk.core.e.b.c(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void Cj(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.dyM = new NewWriteModel(this);
        this.dyM.a(this.jYK);
        this.dyM.a(this.jYJ);
        this.jYB = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jYA != null) {
                            WriteShareActivity.this.jYA.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jYA.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jYA.a((PostPrefixData) null);
            }
        });
        this.ggh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cIn();
            }
        };
        this.jYy = new WriteData();
        this.jYy.setType(3);
        if (bundle != null) {
            this.jYy.setForumName(bundle.getString("forum_name"));
            this.jYy.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jYy.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jYy.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jYy.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jYy.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jYy.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jYy.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jYy.setForumName(this.jYv);
            this.jYy.setShareSummaryTitle(this.mShareTitle);
            this.jYy.setShareSummaryContent(this.mShareContent);
            this.jYy.setShareApiKey(this.mAppKey);
            this.jYy.setShareAppName(this.mAppName);
            this.jYy.setShareSignKey(this.jYw);
            this.jYy.setShareReferUrl(this.jYu);
            boolean isLocalImagePath = m.isLocalImagePath(this.cUz);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dyM.e(this.mShareLocalImageData, this.cUz);
                this.jYy.setShareLocalImageUri(this.cUz);
                this.jYy.setShareLocalImageData(this.mShareLocalImageData);
                this.dyM.bAM();
                this.jYy.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jYy.setShareSummaryImg(this.cUz);
                this.jYy.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jYy.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jYy.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jYy.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jYy.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jYy.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jYy.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jYy.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jYy.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jYy.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jYy.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jYy.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jYy.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jYy.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jYy.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jYy.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jYy.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jYy.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jYA != null && this.jYA.cIz() != null && (obj = this.jYA.cIz().getEditableText().toString()) != null) {
            this.jYA.cIz().setText(TbFaceManager.aPU().aB(getPageContext().getContext(), obj));
            this.jYA.cIz().setSelection(this.jYA.cIz().getText().length());
        }
    }

    public void Ck(int i) {
        this.jYz = i;
    }

    public int cIq() {
        return this.jYz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIr() {
        cIn();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jYz != this.mPrefixData.getPrefixs().size() - 1) {
            this.jYy.setTitle(this.jYA.cID().getText().toString() + this.jYA.cIy().getText().toString());
        } else {
            this.jYy.setTitle(this.jYA.cIy().getText().toString());
        }
        this.jYy.setContent(this.jYA.cIz().getText().toString());
        this.dyM.d(this.jYy);
        this.jYy.setVcode(null);
        this.dyM.cIp().setVoice(null);
        this.dyM.cIp().setVoiceDuringTime(-1);
        if (this.dyM.cME()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.ggh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jYC = false;
            if (i2 == -1) {
                cIl();
                if (this.jYE != null) {
                    this.jYD = true;
                    this.jYE.cIg();
                }
                setResult(-1);
                return;
            }
            cIm();
            if (this.jYF != null) {
                this.jYD = false;
                this.jYF.cIg();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jYv = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jYy.setForumName(this.jYv);
                    cIk();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cIj();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jYA.cIy());
        HidenSoftKeyPad(this.mInputManager, this.jYA.cIz());
        super.onPause();
    }

    public void cIs() {
        HidenSoftKeyPad(this.mInputManager, this.jYA.cIy());
        HidenSoftKeyPad(this.mInputManager, this.jYA.cIz());
    }
}
