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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cLj;
    private String dUE;
    private NewWriteModel eBQ;
    private int lCA;
    private c lCB;
    b lCC;
    private com.baidu.tieba.sharewrite.a lCF;
    private com.baidu.tieba.sharewrite.a lCG;
    private String lCv;
    private String lCw;
    private String lCx;
    private PackageInfo lCy;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lCz = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hwp = null;
    private boolean lCD = false;
    private boolean lCE = false;
    private a.b lCH = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lCz.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lCI = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhO());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhP());
            WriteShareActivity.this.dhH();
            aVar.dismiss();
        }
    };
    private a.b lCJ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lCE) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lCK = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lCz.setShareSummaryImg("");
                WriteShareActivity.this.lCz.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lCz.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lCz.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lCz.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lCz.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lCL = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ad adVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dhB();
                if (WriteShareActivity.this.lCF != null) {
                    WriteShareActivity.this.lCE = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lCF.dhw();
                }
            } else if (adVar == null || writeData == null || adVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dhC();
                if (WriteShareActivity.this.lCG != null) {
                    WriteShareActivity.this.lCE = false;
                    WriteShareActivity.this.lCG.dhw();
                }
            } else {
                writeData.setVcodeMD5(adVar.getVcode_md5());
                writeData.setVcodeUrl(adVar.getVcode_pic_url());
                writeData.setVcodeExtra(adVar.bep());
                WriteShareActivity.this.lCD = true;
                if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lCM = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lCB != null && WriteShareActivity.this.lCB.dhQ() != null && WriteShareActivity.this.lCB.dhQ().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lCB.dhQ(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dhD();
                if (WriteShareActivity.this.lCE) {
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
    private View.OnClickListener lCN = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dhD();
            if (WriteShareActivity.this.lCE) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lCO = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhO());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhP());
            WriteShareActivity.this.dhH();
        }
    };
    private View.OnClickListener lCP = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lCB.dhP().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhP());
        }
    };
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lCB != null) {
                if (view == WriteShareActivity.this.lCB.dhO() || view == WriteShareActivity.this.lCB.dhR() || view == WriteShareActivity.this.lCB.dhS()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhO());
                    } else if (view == WriteShareActivity.this.lCB.dhO() && WriteShareActivity.this.lCB.dhT() != null) {
                        WriteShareActivity.this.lCB.dhT().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lCB.dhP()) {
                    if (z) {
                        WriteShareActivity.this.lCB.dhP().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lCB.dhP().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCB.dhO());
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
        this.cLj = getPageContext().getPageActivity().getPackageManager();
        bNZ();
        boolean dhy = dhy();
        initData(bundle);
        initUI();
        if (!dhy) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                ET(R.string.share_parameter_invalid_tip);
            } else {
                ET(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dhz();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bNZ() {
        this.packageName = getCallingPackage();
        if (this.cLj != null && this.packageName != null) {
            try {
                this.lCy = this.cLj.getPackageInfo(this.packageName, 64);
                if (this.lCy != null) {
                    if (this.lCy.applicationInfo != null && this.lCy.applicationInfo.loadLabel(this.cLj) != null) {
                        this.mAppName = this.lCy.applicationInfo.loadLabel(this.cLj).toString();
                    }
                    if (this.lCy.signatures != null && this.lCy.signatures.length > 0 && this.lCy.signatures[0] != null) {
                        this.lCx = au.getAPKHexMD5(this.lCy.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lCx = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lCv = extras.getString("ShareUrl");
            this.dUE = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lCw = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lCx)) {
                this.lCx = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dhy() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dUE) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void dhz() {
        if (TextUtils.isEmpty(this.lCw)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dhA();
        }
    }

    private void dhA() {
        this.lCB.dhJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lCC.Nk(this.lCz.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhB() {
        if (this.lCF == null) {
            this.lCF = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lCF.uU(false);
            this.lCF.EP(R.drawable.icon_send_ok);
            this.lCF.ES(R.string.share_alert_success);
            this.lCF.a(R.string.share_stay_in_tieba, this.lCH);
            this.lCF.b(R.string.back, this.lCJ);
            this.lCF.a(this.lCM);
            this.lCF.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhC() {
        if (this.lCG == null) {
            this.lCG = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lCG.EP(R.drawable.icon_send_error);
            this.lCG.EQ(R.drawable.btn_w_square);
            this.lCG.ER(R.color.common_color_10039);
            this.lCG.ES(R.string.share_alert_fail);
            this.lCG.a(R.string.share_keep_sending, this.lCI);
            this.lCG.b(R.string.back, this.lCJ);
            this.lCG.a(this.lCM);
            this.lCG.g(getPageContext());
        }
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
    }

    protected void dhE() {
        if (this.eBQ != null) {
            this.eBQ.dmy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dhD();
        dhE();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dhU;
        if (this.lCB != null && (dhU = this.lCB.dhU()) != null) {
            dhU.setImageBitmap(null);
        }
    }

    public WriteData dhF() {
        return this.lCz;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lCB != null && this.lCB.dhQ() != null && this.lCB.dhQ().isShowing()) {
                g.dismissPopupWindow(this.lCB.dhQ(), getPageContext().getPageActivity());
                return true;
            }
            dhD();
            if (this.lCE) {
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
        if (this.lCB != null) {
            this.lCB.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lCB = new c(this);
        this.lCB.ad(this.lCN);
        this.lCB.ae(this.lCO);
        this.lCB.b(this.ggs);
        this.lCB.af(this.lCP);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
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

    public void ET(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.eBQ = new NewWriteModel(this);
        this.eBQ.a(this.lCL);
        this.eBQ.a(this.lCK);
        this.lCC = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lCB != null) {
                            WriteShareActivity.this.lCB.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lCB.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lCB.a((PostPrefixData) null);
            }
        });
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dhD();
            }
        };
        this.lCz = new WriteData();
        this.lCz.setType(3);
        if (bundle != null) {
            this.lCz.setForumName(bundle.getString("forum_name"));
            this.lCz.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lCz.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lCz.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lCz.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lCz.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lCz.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lCz.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lCz.setForumName(this.lCw);
            this.lCz.setShareSummaryTitle(this.mShareTitle);
            this.lCz.setShareSummaryContent(this.mShareContent);
            this.lCz.setShareApiKey(this.mAppKey);
            this.lCz.setShareAppName(this.mAppName);
            this.lCz.setShareSignKey(this.lCx);
            this.lCz.setShareReferUrl(this.lCv);
            boolean isLocalImagePath = n.isLocalImagePath(this.dUE);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.eBQ.d(this.mShareLocalImageData, this.dUE);
                this.lCz.setShareLocalImageUri(this.dUE);
                this.lCz.setShareLocalImageData(this.mShareLocalImageData);
                this.eBQ.bXY();
                this.lCz.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lCz.setShareSummaryImg(this.dUE);
                this.lCz.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lCz.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lCz.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lCz.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lCz.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lCz.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lCz.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lCz.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lCz.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lCz.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lCz.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lCz.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lCz.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lCz.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lCz.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lCz.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lCz.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lCz.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lCB != null && this.lCB.dhP() != null && (obj = this.lCB.dhP().getEditableText().toString()) != null) {
            this.lCB.dhP().setText(TbFaceManager.bkj().al(getPageContext().getContext(), obj));
            this.lCB.dhP().setSelection(this.lCB.dhP().getText().length());
        }
    }

    public void EU(int i) {
        this.lCA = i;
    }

    public int dhG() {
        return this.lCA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhH() {
        dhD();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lCA != this.mPrefixData.getPrefixs().size() - 1) {
            this.lCz.setTitle(this.lCB.dhT().getText().toString() + this.lCB.dhO().getText().toString());
        } else {
            this.lCz.setTitle(this.lCB.dhO().getText().toString());
        }
        this.lCz.setContent(this.lCB.dhP().getText().toString());
        this.eBQ.d(this.lCz);
        this.lCz.setVcode(null);
        this.eBQ.dhF().setVoice(null);
        this.eBQ.dhF().setVoiceDuringTime(-1);
        if (this.eBQ.dmw()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lCD = false;
            if (i2 == -1) {
                dhB();
                if (this.lCF != null) {
                    this.lCE = true;
                    this.lCF.dhw();
                }
                setResult(-1);
                return;
            }
            dhC();
            if (this.lCG != null) {
                this.lCE = false;
                this.lCG.dhw();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lCw = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lCz.setForumName(this.lCw);
                    dhA();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dhz();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lCB.dhO());
        HidenSoftKeyPad(this.mInputManager, this.lCB.dhP());
        super.onPause();
    }

    public void dhI() {
        HidenSoftKeyPad(this.mInputManager, this.lCB.dhO());
        HidenSoftKeyPad(this.mInputManager, this.lCB.dhP());
    }
}
