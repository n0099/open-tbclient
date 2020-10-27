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
    private PackageManager dqU;
    private String eAU;
    private NewWriteModel fjQ;
    private String mAppKey;
    private String mAppName;
    private String mGb;
    private String mGc;
    private String mGd;
    private PackageInfo mGe;
    private int mGg;
    private c mGh;
    b mGi;
    private com.baidu.tieba.sharewrite.a mGm;
    private com.baidu.tieba.sharewrite.a mGn;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mGf = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener isi = null;
    private boolean mGj = false;
    private boolean mGk = false;
    private a.b mGo = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mGf.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b mGp = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEa());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEb());
            WriteShareActivity.this.dDT();
            aVar.dismiss();
        }
    };
    private a.b mGq = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.mGk) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b mGr = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mGf.setShareSummaryImg("");
                WriteShareActivity.this.mGf.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mGf.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mGf.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mGf.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mGf.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c mGs = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dDO();
                if (WriteShareActivity.this.mGm != null) {
                    WriteShareActivity.this.mGk = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mGm.dDJ();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dDP();
                if (WriteShareActivity.this.mGn != null) {
                    WriteShareActivity.this.mGk = false;
                    WriteShareActivity.this.mGn.dDJ();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bsw());
                WriteShareActivity.this.mGj = true;
                if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bsv())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener mGt = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.mGh != null && WriteShareActivity.this.mGh.dEc() != null && WriteShareActivity.this.mGh.dEc().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.mGh.dEc(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dDQ();
                if (WriteShareActivity.this.mGk) {
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
    private View.OnClickListener mGu = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dDQ();
            if (WriteShareActivity.this.mGk) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener mGv = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEa());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEb());
            WriteShareActivity.this.dDT();
        }
    };
    private View.OnClickListener mGw = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mGh.dEb().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEb());
        }
    };
    private final View.OnFocusChangeListener gWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mGh != null) {
                if (view == WriteShareActivity.this.mGh.dEa() || view == WriteShareActivity.this.mGh.dEd() || view == WriteShareActivity.this.mGh.dEe()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEa());
                    } else if (view == WriteShareActivity.this.mGh.dEa() && WriteShareActivity.this.mGh.dEf() != null) {
                        WriteShareActivity.this.mGh.dEf().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.mGh.dEb()) {
                    if (z) {
                        WriteShareActivity.this.mGh.dEb().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.mGh.dEb().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mGh.dEa());
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
        this.dqU = getPageContext().getPageActivity().getPackageManager();
        cgw();
        boolean dDL = dDL();
        initData(bundle);
        initUI();
        if (!dDL) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                IS(R.string.share_parameter_invalid_tip);
            } else {
                IS(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dDM();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cgw() {
        this.packageName = getCallingPackage();
        if (this.dqU != null && this.packageName != null) {
            try {
                this.mGe = this.dqU.getPackageInfo(this.packageName, 64);
                if (this.mGe != null) {
                    if (this.mGe.applicationInfo != null && this.mGe.applicationInfo.loadLabel(this.dqU) != null) {
                        this.mAppName = this.mGe.applicationInfo.loadLabel(this.dqU).toString();
                    }
                    if (this.mGe.signatures != null && this.mGe.signatures.length > 0 && this.mGe.signatures[0] != null) {
                        this.mGd = av.getAPKHexMD5(this.mGe.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.mGd = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mGb = extras.getString("ShareUrl");
            this.eAU = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mGc = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mGd)) {
                this.mGd = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dDL() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eAU) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dDM() {
        if (TextUtils.isEmpty(this.mGc)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dDN();
        }
    }

    private void dDN() {
        this.mGh.dDV();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mGi.RV(this.mGf.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDO() {
        if (this.mGm == null) {
            this.mGm = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mGm.wR(false);
            this.mGm.IO(R.drawable.icon_send_ok);
            this.mGm.IR(R.string.share_alert_success);
            this.mGm.a(R.string.share_stay_in_tieba, this.mGo);
            this.mGm.b(R.string.back, this.mGq);
            this.mGm.b(this.mGt);
            this.mGm.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDP() {
        if (this.mGn == null) {
            this.mGn = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mGn.IO(R.drawable.icon_send_error);
            this.mGn.IP(R.drawable.btn_w_square);
            this.mGn.IQ(R.color.common_color_10039);
            this.mGn.IR(R.string.share_alert_fail);
            this.mGn.a(R.string.share_keep_sending, this.mGp);
            this.mGn.b(R.string.back, this.mGq);
            this.mGn.b(this.mGt);
            this.mGn.g(getPageContext());
        }
    }

    protected void dDQ() {
        if (this.fjQ != null) {
            this.fjQ.cancelLoadData();
        }
    }

    protected void dDR() {
        if (this.fjQ != null) {
            this.fjQ.dIM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dDQ();
        dDR();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dEg;
        if (this.mGh != null && (dEg = this.mGh.dEg()) != null) {
            dEg.setImageBitmap(null);
        }
    }

    public WriteData cVv() {
        return this.mGf;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mGh != null && this.mGh.dEc() != null && this.mGh.dEc().isShowing()) {
                g.dismissPopupWindow(this.mGh.dEc(), getPageContext().getPageActivity());
                return true;
            }
            dDQ();
            if (this.mGk) {
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
        if (this.mGh != null) {
            this.mGh.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mGh = new c(this);
        this.mGh.ae(this.mGu);
        this.mGh.af(this.mGv);
        this.mGh.b(this.gWj);
        this.mGh.ag(this.mGw);
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

    public void IS(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fjQ = new NewWriteModel(this);
        this.fjQ.a(this.mGs);
        this.fjQ.a(this.mGr);
        this.mGi = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.mGh != null) {
                            WriteShareActivity.this.mGh.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mGh.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mGh.a((PostPrefixData) null);
            }
        });
        this.isi = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dDQ();
            }
        };
        this.mGf = new WriteData();
        this.mGf.setType(3);
        if (bundle != null) {
            this.mGf.setForumName(bundle.getString("forum_name"));
            this.mGf.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mGf.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mGf.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mGf.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mGf.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mGf.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mGf.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mGf.setForumName(this.mGc);
            this.mGf.setShareSummaryTitle(this.mShareTitle);
            this.mGf.setShareSummaryContent(this.mShareContent);
            this.mGf.setShareApiKey(this.mAppKey);
            this.mGf.setShareAppName(this.mAppName);
            this.mGf.setShareSignKey(this.mGd);
            this.mGf.setShareReferUrl(this.mGb);
            boolean isLocalImagePath = n.isLocalImagePath(this.eAU);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fjQ.d(this.mShareLocalImageData, this.eAU);
                this.mGf.setShareLocalImageUri(this.eAU);
                this.mGf.setShareLocalImageData(this.mShareLocalImageData);
                this.fjQ.csn();
                this.mGf.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mGf.setShareSummaryImg(this.eAU);
                this.mGf.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mGf.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mGf.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mGf.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mGf.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mGf.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mGf.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mGf.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mGf.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mGf.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mGf.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mGf.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mGf.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mGf.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mGf.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mGf.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mGf.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mGf.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.mGh != null && this.mGh.dEb() != null && (obj = this.mGh.dEb().getEditableText().toString()) != null) {
            this.mGh.dEb().setText(TbFaceManager.byD().aw(getPageContext().getContext(), obj));
            this.mGh.dEb().setSelection(this.mGh.dEb().getText().length());
        }
    }

    public void IT(int i) {
        this.mGg = i;
    }

    public int dDS() {
        return this.mGg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDT() {
        dDQ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.mGg != this.mPrefixData.getPrefixs().size() - 1) {
            this.mGf.setTitle(this.mGh.dEf().getText().toString() + this.mGh.dEa().getText().toString());
        } else {
            this.mGf.setTitle(this.mGh.dEa().getText().toString());
        }
        this.mGf.setContent(this.mGh.dEb().getText().toString());
        this.fjQ.e(this.mGf);
        this.mGf.setVcode(null);
        this.fjQ.cVv().setVoice(null);
        this.fjQ.cVv().setVoiceDuringTime(-1);
        if (this.fjQ.dIK()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.isi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.mGj = false;
            if (i2 == -1) {
                dDO();
                if (this.mGm != null) {
                    this.mGk = true;
                    this.mGm.dDJ();
                }
                setResult(-1);
                return;
            }
            dDP();
            if (this.mGn != null) {
                this.mGk = false;
                this.mGn.dDJ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.mGc = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mGf.setForumName(this.mGc);
                    dDN();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dDM();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mGh.dEa());
        HidenSoftKeyPad(this.mInputManager, this.mGh.dEb());
        super.onPause();
    }

    public void dDU() {
        HidenSoftKeyPad(this.mInputManager, this.mGh.dEa());
        HidenSoftKeyPad(this.mInputManager, this.mGh.dEb());
    }
}
