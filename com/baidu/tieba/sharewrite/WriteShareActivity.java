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
    private PackageInfo lCA;
    private int lCC;
    private c lCD;
    b lCE;
    private com.baidu.tieba.sharewrite.a lCH;
    private com.baidu.tieba.sharewrite.a lCI;
    private String lCx;
    private String lCy;
    private String lCz;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lCB = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hwp = null;
    private boolean lCF = false;
    private boolean lCG = false;
    private a.b lCJ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lCB.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lCK = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhO());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhP());
            WriteShareActivity.this.dhH();
            aVar.dismiss();
        }
    };
    private a.b lCL = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lCG) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lCM = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lCB.setShareSummaryImg("");
                WriteShareActivity.this.lCB.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lCB.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lCB.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lCB.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lCB.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lCN = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ad adVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dhB();
                if (WriteShareActivity.this.lCH != null) {
                    WriteShareActivity.this.lCG = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lCH.dhw();
                }
            } else if (adVar == null || writeData == null || adVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dhC();
                if (WriteShareActivity.this.lCI != null) {
                    WriteShareActivity.this.lCG = false;
                    WriteShareActivity.this.lCI.dhw();
                }
            } else {
                writeData.setVcodeMD5(adVar.getVcode_md5());
                writeData.setVcodeUrl(adVar.getVcode_pic_url());
                writeData.setVcodeExtra(adVar.bep());
                WriteShareActivity.this.lCF = true;
                if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lCO = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lCD != null && WriteShareActivity.this.lCD.dhQ() != null && WriteShareActivity.this.lCD.dhQ().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lCD.dhQ(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dhD();
                if (WriteShareActivity.this.lCG) {
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
    private View.OnClickListener lCP = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dhD();
            if (WriteShareActivity.this.lCG) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lCQ = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhO());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhP());
            WriteShareActivity.this.dhH();
        }
    };
    private View.OnClickListener lCR = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lCD.dhP().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhP());
        }
    };
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lCD != null) {
                if (view == WriteShareActivity.this.lCD.dhO() || view == WriteShareActivity.this.lCD.dhR() || view == WriteShareActivity.this.lCD.dhS()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhO());
                    } else if (view == WriteShareActivity.this.lCD.dhO() && WriteShareActivity.this.lCD.dhT() != null) {
                        WriteShareActivity.this.lCD.dhT().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lCD.dhP()) {
                    if (z) {
                        WriteShareActivity.this.lCD.dhP().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lCD.dhP().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lCD.dhO());
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
                this.lCA = this.cLj.getPackageInfo(this.packageName, 64);
                if (this.lCA != null) {
                    if (this.lCA.applicationInfo != null && this.lCA.applicationInfo.loadLabel(this.cLj) != null) {
                        this.mAppName = this.lCA.applicationInfo.loadLabel(this.cLj).toString();
                    }
                    if (this.lCA.signatures != null && this.lCA.signatures.length > 0 && this.lCA.signatures[0] != null) {
                        this.lCz = au.getAPKHexMD5(this.lCA.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lCz = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lCx = extras.getString("ShareUrl");
            this.dUE = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lCy = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lCz)) {
                this.lCz = extras.getString("appSign");
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
        if (TextUtils.isEmpty(this.lCy)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dhA();
        }
    }

    private void dhA() {
        this.lCD.dhJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lCE.Nk(this.lCB.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhB() {
        if (this.lCH == null) {
            this.lCH = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lCH.uU(false);
            this.lCH.EP(R.drawable.icon_send_ok);
            this.lCH.ES(R.string.share_alert_success);
            this.lCH.a(R.string.share_stay_in_tieba, this.lCJ);
            this.lCH.b(R.string.back, this.lCL);
            this.lCH.a(this.lCO);
            this.lCH.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhC() {
        if (this.lCI == null) {
            this.lCI = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lCI.EP(R.drawable.icon_send_error);
            this.lCI.EQ(R.drawable.btn_w_square);
            this.lCI.ER(R.color.common_color_10039);
            this.lCI.ES(R.string.share_alert_fail);
            this.lCI.a(R.string.share_keep_sending, this.lCK);
            this.lCI.b(R.string.back, this.lCL);
            this.lCI.a(this.lCO);
            this.lCI.g(getPageContext());
        }
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
    }

    protected void dhE() {
        if (this.eBQ != null) {
            this.eBQ.dmz();
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
        if (this.lCD != null && (dhU = this.lCD.dhU()) != null) {
            dhU.setImageBitmap(null);
        }
    }

    public WriteData dhF() {
        return this.lCB;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lCD != null && this.lCD.dhQ() != null && this.lCD.dhQ().isShowing()) {
                g.dismissPopupWindow(this.lCD.dhQ(), getPageContext().getPageActivity());
                return true;
            }
            dhD();
            if (this.lCG) {
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
        if (this.lCD != null) {
            this.lCD.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lCD = new c(this);
        this.lCD.ad(this.lCP);
        this.lCD.ae(this.lCQ);
        this.lCD.b(this.ggs);
        this.lCD.af(this.lCR);
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
        this.eBQ.a(this.lCN);
        this.eBQ.a(this.lCM);
        this.lCE = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lCD != null) {
                            WriteShareActivity.this.lCD.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lCD.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lCD.a((PostPrefixData) null);
            }
        });
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dhD();
            }
        };
        this.lCB = new WriteData();
        this.lCB.setType(3);
        if (bundle != null) {
            this.lCB.setForumName(bundle.getString("forum_name"));
            this.lCB.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lCB.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lCB.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lCB.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lCB.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lCB.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lCB.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lCB.setForumName(this.lCy);
            this.lCB.setShareSummaryTitle(this.mShareTitle);
            this.lCB.setShareSummaryContent(this.mShareContent);
            this.lCB.setShareApiKey(this.mAppKey);
            this.lCB.setShareAppName(this.mAppName);
            this.lCB.setShareSignKey(this.lCz);
            this.lCB.setShareReferUrl(this.lCx);
            boolean isLocalImagePath = n.isLocalImagePath(this.dUE);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.eBQ.d(this.mShareLocalImageData, this.dUE);
                this.lCB.setShareLocalImageUri(this.dUE);
                this.lCB.setShareLocalImageData(this.mShareLocalImageData);
                this.eBQ.bXY();
                this.lCB.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lCB.setShareSummaryImg(this.dUE);
                this.lCB.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lCB.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lCB.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lCB.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lCB.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lCB.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lCB.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lCB.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lCB.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lCB.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lCB.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lCB.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lCB.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lCB.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lCB.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lCB.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lCB.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lCB.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lCD != null && this.lCD.dhP() != null && (obj = this.lCD.dhP().getEditableText().toString()) != null) {
            this.lCD.dhP().setText(TbFaceManager.bkj().al(getPageContext().getContext(), obj));
            this.lCD.dhP().setSelection(this.lCD.dhP().getText().length());
        }
    }

    public void EU(int i) {
        this.lCC = i;
    }

    public int dhG() {
        return this.lCC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhH() {
        dhD();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lCC != this.mPrefixData.getPrefixs().size() - 1) {
            this.lCB.setTitle(this.lCD.dhT().getText().toString() + this.lCD.dhO().getText().toString());
        } else {
            this.lCB.setTitle(this.lCD.dhO().getText().toString());
        }
        this.lCB.setContent(this.lCD.dhP().getText().toString());
        this.eBQ.d(this.lCB);
        this.lCB.setVcode(null);
        this.eBQ.dhF().setVoice(null);
        this.eBQ.dhF().setVoiceDuringTime(-1);
        if (this.eBQ.dmx()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lCF = false;
            if (i2 == -1) {
                dhB();
                if (this.lCH != null) {
                    this.lCG = true;
                    this.lCH.dhw();
                }
                setResult(-1);
                return;
            }
            dhC();
            if (this.lCI != null) {
                this.lCG = false;
                this.lCI.dhw();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lCy = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lCB.setForumName(this.lCy);
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
        HidenSoftKeyPad(this.mInputManager, this.lCD.dhO());
        HidenSoftKeyPad(this.mInputManager, this.lCD.dhP());
        super.onPause();
    }

    public void dhI() {
        HidenSoftKeyPad(this.mInputManager, this.lCD.dhO());
        HidenSoftKeyPad(this.mInputManager, this.lCD.dhP());
    }
}
