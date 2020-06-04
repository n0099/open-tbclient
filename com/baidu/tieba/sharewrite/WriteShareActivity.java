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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cDr;
    private String dHH;
    private NewWriteModel emH;
    private String lbh;
    private String lbi;
    private String lbj;
    private PackageInfo lbk;
    private int lbm;
    private c lbn;
    b lbo;
    private com.baidu.tieba.sharewrite.a lbr;
    private com.baidu.tieba.sharewrite.a lbs;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lbl = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hes = null;
    private boolean lbp = false;
    private boolean lbq = false;
    private a.b lbt = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lbl.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lbu = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dao());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dap());
            WriteShareActivity.this.dah();
            aVar.dismiss();
        }
    };
    private a.b lbv = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lbq) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lbw = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lbl.setShareSummaryImg("");
                WriteShareActivity.this.lbl.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lbl.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lbl.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lbl.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lbl.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lbx = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ab abVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dab();
                if (WriteShareActivity.this.lbr != null) {
                    WriteShareActivity.this.lbq = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lbr.cZW();
                }
            } else if (abVar == null || writeData == null || abVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dac();
                if (WriteShareActivity.this.lbs != null) {
                    WriteShareActivity.this.lbq = false;
                    WriteShareActivity.this.lbs.cZW();
                }
            } else {
                writeData.setVcodeMD5(abVar.getVcode_md5());
                writeData.setVcodeUrl(abVar.getVcode_pic_url());
                writeData.setVcodeExtra(abVar.aYn());
                WriteShareActivity.this.lbp = true;
                if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lby = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lbn != null && WriteShareActivity.this.lbn.daq() != null && WriteShareActivity.this.lbn.daq().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lbn.daq(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dad();
                if (WriteShareActivity.this.lbq) {
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
    private View.OnClickListener lbz = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dad();
            if (WriteShareActivity.this.lbq) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lbA = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dao());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dap());
            WriteShareActivity.this.dah();
        }
    };
    private View.OnClickListener lbB = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lbn.dap().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dap());
        }
    };
    private final View.OnFocusChangeListener fPo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lbn != null) {
                if (view == WriteShareActivity.this.lbn.dao() || view == WriteShareActivity.this.lbn.dar() || view == WriteShareActivity.this.lbn.das()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dao());
                    } else if (view == WriteShareActivity.this.lbn.dao() && WriteShareActivity.this.lbn.dat() != null) {
                        WriteShareActivity.this.lbn.dat().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lbn.dap()) {
                    if (z) {
                        WriteShareActivity.this.lbn.dap().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lbn.dap().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lbn.dao());
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
        this.cDr = getPageContext().getPageActivity().getPackageManager();
        bHL();
        boolean cZY = cZY();
        initData(bundle);
        initUI();
        if (!cZY) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Dv(R.string.share_parameter_invalid_tip);
            } else {
                Dv(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cZZ();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bHL() {
        this.packageName = getCallingPackage();
        if (this.cDr != null && this.packageName != null) {
            try {
                this.lbk = this.cDr.getPackageInfo(this.packageName, 64);
                if (this.lbk != null) {
                    if (this.lbk.applicationInfo != null && this.lbk.applicationInfo.loadLabel(this.cDr) != null) {
                        this.mAppName = this.lbk.applicationInfo.loadLabel(this.cDr).toString();
                    }
                    if (this.lbk.signatures != null && this.lbk.signatures.length > 0 && this.lbk.signatures[0] != null) {
                        this.lbj = as.getAPKHexMD5(this.lbk.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lbj = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lbh = extras.getString("ShareUrl");
            this.dHH = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lbi = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lbj)) {
                this.lbj = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cZY() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dHH) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cZZ() {
        if (TextUtils.isEmpty(this.lbi)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            daa();
        }
    }

    private void daa() {
        this.lbn.daj();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lbo.Ma(this.lbl.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dab() {
        if (this.lbr == null) {
            this.lbr = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lbr.ub(false);
            this.lbr.Dr(R.drawable.icon_send_ok);
            this.lbr.Du(R.string.share_alert_success);
            this.lbr.a(R.string.share_stay_in_tieba, this.lbt);
            this.lbr.b(R.string.back, this.lbv);
            this.lbr.a(this.lby);
            this.lbr.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dac() {
        if (this.lbs == null) {
            this.lbs = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lbs.Dr(R.drawable.icon_send_error);
            this.lbs.Ds(R.drawable.btn_w_square);
            this.lbs.Dt(R.color.common_color_10039);
            this.lbs.Du(R.string.share_alert_fail);
            this.lbs.a(R.string.share_keep_sending, this.lbu);
            this.lbs.b(R.string.back, this.lbv);
            this.lbs.a(this.lby);
            this.lbs.f(getPageContext());
        }
    }

    protected void dad() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
    }

    protected void dae() {
        if (this.emH != null) {
            this.emH.dfe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dad();
        dae();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dau;
        if (this.lbn != null && (dau = this.lbn.dau()) != null) {
            dau.setImageBitmap(null);
        }
    }

    public WriteData daf() {
        return this.lbl;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lbn != null && this.lbn.daq() != null && this.lbn.daq().isShowing()) {
                g.dismissPopupWindow(this.lbn.daq(), getPageContext().getPageActivity());
                return true;
            }
            dad();
            if (this.lbq) {
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
        if (this.lbn != null) {
            this.lbn.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lbn = new c(this);
        this.lbn.ac(this.lbz);
        this.lbn.ad(this.lbA);
        this.lbn.b(this.fPo);
        this.lbn.ae(this.lbB);
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

    public void Dv(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.emH = new NewWriteModel(this);
        this.emH.a(this.lbx);
        this.emH.a(this.lbw);
        this.lbo = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lbn != null) {
                            WriteShareActivity.this.lbn.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lbn.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lbn.a((PostPrefixData) null);
            }
        });
        this.hes = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dad();
            }
        };
        this.lbl = new WriteData();
        this.lbl.setType(3);
        if (bundle != null) {
            this.lbl.setForumName(bundle.getString("forum_name"));
            this.lbl.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lbl.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lbl.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lbl.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lbl.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lbl.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lbl.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lbl.setForumName(this.lbi);
            this.lbl.setShareSummaryTitle(this.mShareTitle);
            this.lbl.setShareSummaryContent(this.mShareContent);
            this.lbl.setShareApiKey(this.mAppKey);
            this.lbl.setShareAppName(this.mAppName);
            this.lbl.setShareSignKey(this.lbj);
            this.lbl.setShareReferUrl(this.lbh);
            boolean isLocalImagePath = m.isLocalImagePath(this.dHH);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.emH.d(this.mShareLocalImageData, this.dHH);
                this.lbl.setShareLocalImageUri(this.dHH);
                this.lbl.setShareLocalImageData(this.mShareLocalImageData);
                this.emH.bRI();
                this.lbl.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lbl.setShareSummaryImg(this.dHH);
                this.lbl.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lbl.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lbl.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lbl.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lbl.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lbl.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lbl.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lbl.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lbl.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lbl.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lbl.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lbl.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lbl.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lbl.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lbl.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lbl.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lbl.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lbl.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lbn != null && this.lbn.dap() != null && (obj = this.lbn.dap().getEditableText().toString()) != null) {
            this.lbn.dap().setText(TbFaceManager.bet().ak(getPageContext().getContext(), obj));
            this.lbn.dap().setSelection(this.lbn.dap().getText().length());
        }
    }

    public void Dw(int i) {
        this.lbm = i;
    }

    public int dag() {
        return this.lbm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dah() {
        dad();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lbm != this.mPrefixData.getPrefixs().size() - 1) {
            this.lbl.setTitle(this.lbn.dat().getText().toString() + this.lbn.dao().getText().toString());
        } else {
            this.lbl.setTitle(this.lbn.dao().getText().toString());
        }
        this.lbl.setContent(this.lbn.dap().getText().toString());
        this.emH.d(this.lbl);
        this.lbl.setVcode(null);
        this.emH.daf().setVoice(null);
        this.emH.daf().setVoiceDuringTime(-1);
        if (this.emH.dfc()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hes);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lbp = false;
            if (i2 == -1) {
                dab();
                if (this.lbr != null) {
                    this.lbq = true;
                    this.lbr.cZW();
                }
                setResult(-1);
                return;
            }
            dac();
            if (this.lbs != null) {
                this.lbq = false;
                this.lbs.cZW();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lbi = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lbl.setForumName(this.lbi);
                    daa();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cZZ();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lbn.dao());
        HidenSoftKeyPad(this.mInputManager, this.lbn.dap());
        super.onPause();
    }

    public void dai() {
        HidenSoftKeyPad(this.mInputManager, this.lbn.dao());
        HidenSoftKeyPad(this.mInputManager, this.lbn.dap());
    }
}
