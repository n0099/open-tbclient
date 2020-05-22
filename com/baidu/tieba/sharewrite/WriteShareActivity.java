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
    private PackageManager cDr;
    private String dHH;
    private NewWriteModel emH;
    private String kZX;
    private String kZY;
    private String kZZ;
    private PackageInfo laa;
    private int lac;
    private c lad;
    b lae;
    private com.baidu.tieba.sharewrite.a lah;
    private com.baidu.tieba.sharewrite.a lai;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lab = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener heh = null;
    private boolean laf = false;
    private boolean lag = false;
    private a.b laj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lab.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lak = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZY());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZZ());
            WriteShareActivity.this.cZR();
            aVar.dismiss();
        }
    };
    private a.b lal = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lag) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lam = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lab.setShareSummaryImg("");
                WriteShareActivity.this.lab.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lab.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lab.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lab.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lab.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lan = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cZL();
                if (WriteShareActivity.this.lah != null) {
                    WriteShareActivity.this.lag = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lah.cZG();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cZM();
                if (WriteShareActivity.this.lai != null) {
                    WriteShareActivity.this.lag = false;
                    WriteShareActivity.this.lai.cZG();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aYm());
                WriteShareActivity.this.laf = true;
                if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lao = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lad != null && WriteShareActivity.this.lad.daa() != null && WriteShareActivity.this.lad.daa().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lad.daa(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cZN();
                if (WriteShareActivity.this.lag) {
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
    private View.OnClickListener lap = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cZN();
            if (WriteShareActivity.this.lag) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener laq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZY());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZZ());
            WriteShareActivity.this.cZR();
        }
    };
    private View.OnClickListener lar = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lad.cZZ().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZZ());
        }
    };
    private final View.OnFocusChangeListener fPd = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lad != null) {
                if (view == WriteShareActivity.this.lad.cZY() || view == WriteShareActivity.this.lad.dab() || view == WriteShareActivity.this.lad.dac()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZY());
                    } else if (view == WriteShareActivity.this.lad.cZY() && WriteShareActivity.this.lad.dad() != null) {
                        WriteShareActivity.this.lad.dad().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lad.cZZ()) {
                    if (z) {
                        WriteShareActivity.this.lad.cZZ().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lad.cZZ().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lad.cZY());
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
        bHJ();
        boolean cZI = cZI();
        initData(bundle);
        initUI();
        if (!cZI) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Dt(R.string.share_parameter_invalid_tip);
            } else {
                Dt(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cZJ();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bHJ() {
        this.packageName = getCallingPackage();
        if (this.cDr != null && this.packageName != null) {
            try {
                this.laa = this.cDr.getPackageInfo(this.packageName, 64);
                if (this.laa != null) {
                    if (this.laa.applicationInfo != null && this.laa.applicationInfo.loadLabel(this.cDr) != null) {
                        this.mAppName = this.laa.applicationInfo.loadLabel(this.cDr).toString();
                    }
                    if (this.laa.signatures != null && this.laa.signatures.length > 0 && this.laa.signatures[0] != null) {
                        this.kZZ = as.getAPKHexMD5(this.laa.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.kZZ = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.kZX = extras.getString("ShareUrl");
            this.dHH = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.kZY = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.kZZ)) {
                this.kZZ = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cZI() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dHH) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cZJ() {
        if (TextUtils.isEmpty(this.kZY)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cZK();
        }
    }

    private void cZK() {
        this.lad.cZT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lae.LZ(this.lab.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZL() {
        if (this.lah == null) {
            this.lah = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lah.ub(false);
            this.lah.Dp(R.drawable.icon_send_ok);
            this.lah.Ds(R.string.share_alert_success);
            this.lah.a(R.string.share_stay_in_tieba, this.laj);
            this.lah.b(R.string.back, this.lal);
            this.lah.a(this.lao);
            this.lah.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZM() {
        if (this.lai == null) {
            this.lai = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lai.Dp(R.drawable.icon_send_error);
            this.lai.Dq(R.drawable.btn_w_square);
            this.lai.Dr(R.color.common_color_10039);
            this.lai.Ds(R.string.share_alert_fail);
            this.lai.a(R.string.share_keep_sending, this.lak);
            this.lai.b(R.string.back, this.lal);
            this.lai.a(this.lao);
            this.lai.f(getPageContext());
        }
    }

    protected void cZN() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
    }

    protected void cZO() {
        if (this.emH != null) {
            this.emH.deP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cZN();
        cZO();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dae;
        if (this.lad != null && (dae = this.lad.dae()) != null) {
            dae.setImageBitmap(null);
        }
    }

    public WriteData cZP() {
        return this.lab;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lad != null && this.lad.daa() != null && this.lad.daa().isShowing()) {
                g.dismissPopupWindow(this.lad.daa(), getPageContext().getPageActivity());
                return true;
            }
            cZN();
            if (this.lag) {
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
        if (this.lad != null) {
            this.lad.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lad = new c(this);
        this.lad.ac(this.lap);
        this.lad.ad(this.laq);
        this.lad.b(this.fPd);
        this.lad.ae(this.lar);
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

    public void Dt(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.emH = new NewWriteModel(this);
        this.emH.a(this.lan);
        this.emH.a(this.lam);
        this.lae = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lad != null) {
                            WriteShareActivity.this.lad.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lad.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lad.a((PostPrefixData) null);
            }
        });
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cZN();
            }
        };
        this.lab = new WriteData();
        this.lab.setType(3);
        if (bundle != null) {
            this.lab.setForumName(bundle.getString("forum_name"));
            this.lab.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lab.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lab.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lab.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lab.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lab.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lab.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lab.setForumName(this.kZY);
            this.lab.setShareSummaryTitle(this.mShareTitle);
            this.lab.setShareSummaryContent(this.mShareContent);
            this.lab.setShareApiKey(this.mAppKey);
            this.lab.setShareAppName(this.mAppName);
            this.lab.setShareSignKey(this.kZZ);
            this.lab.setShareReferUrl(this.kZX);
            boolean isLocalImagePath = m.isLocalImagePath(this.dHH);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.emH.d(this.mShareLocalImageData, this.dHH);
                this.lab.setShareLocalImageUri(this.dHH);
                this.lab.setShareLocalImageData(this.mShareLocalImageData);
                this.emH.bRG();
                this.lab.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lab.setShareSummaryImg(this.dHH);
                this.lab.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lab.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lab.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lab.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lab.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lab.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lab.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lab.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lab.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lab.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lab.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lab.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lab.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lab.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lab.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lab.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lab.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lab.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lad != null && this.lad.cZZ() != null && (obj = this.lad.cZZ().getEditableText().toString()) != null) {
            this.lad.cZZ().setText(TbFaceManager.bes().ak(getPageContext().getContext(), obj));
            this.lad.cZZ().setSelection(this.lad.cZZ().getText().length());
        }
    }

    public void Du(int i) {
        this.lac = i;
    }

    public int cZQ() {
        return this.lac;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZR() {
        cZN();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lac != this.mPrefixData.getPrefixs().size() - 1) {
            this.lab.setTitle(this.lad.dad().getText().toString() + this.lad.cZY().getText().toString());
        } else {
            this.lab.setTitle(this.lad.cZY().getText().toString());
        }
        this.lab.setContent(this.lad.cZZ().getText().toString());
        this.emH.d(this.lab);
        this.lab.setVcode(null);
        this.emH.cZP().setVoice(null);
        this.emH.cZP().setVoiceDuringTime(-1);
        if (this.emH.deN()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.heh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.laf = false;
            if (i2 == -1) {
                cZL();
                if (this.lah != null) {
                    this.lag = true;
                    this.lah.cZG();
                }
                setResult(-1);
                return;
            }
            cZM();
            if (this.lai != null) {
                this.lag = false;
                this.lai.cZG();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.kZY = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lab.setForumName(this.kZY);
                    cZK();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cZJ();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lad.cZY());
        HidenSoftKeyPad(this.mInputManager, this.lad.cZZ());
        super.onPause();
    }

    public void cZS() {
        HidenSoftKeyPad(this.mInputManager, this.lad.cZY());
        HidenSoftKeyPad(this.mInputManager, this.lad.cZZ());
    }
}
