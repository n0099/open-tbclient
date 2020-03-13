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
    private PackageManager bSq;
    private String cUm;
    private NewWriteModel dyz;
    private String jWS;
    private String jWT;
    private String jWU;
    private PackageInfo jWV;
    private int jWX;
    private c jWY;
    b jWZ;
    private com.baidu.tieba.sharewrite.a jXc;
    private com.baidu.tieba.sharewrite.a jXd;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jWW = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gfz = null;
    private boolean jXa = false;
    private boolean jXb = false;
    private a.b jXe = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jWW.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jXf = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIe());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIf());
            WriteShareActivity.this.cHX();
            aVar.dismiss();
        }
    };
    private a.b jXg = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jXb) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jXh = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jWW.setShareSummaryImg("");
                WriteShareActivity.this.jWW.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jWW.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jWW.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jWW.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jWW.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jXi = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cHR();
                if (WriteShareActivity.this.jXc != null) {
                    WriteShareActivity.this.jXb = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jXc.cHM();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cHS();
                if (WriteShareActivity.this.jXd != null) {
                    WriteShareActivity.this.jXb = false;
                    WriteShareActivity.this.jXd.cHM();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aJH());
                WriteShareActivity.this.jXa = true;
                if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jXj = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jWY != null && WriteShareActivity.this.jWY.cIg() != null && WriteShareActivity.this.jWY.cIg().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jWY.cIg(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cHT();
                if (WriteShareActivity.this.jXb) {
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
    private View.OnClickListener jXk = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cHT();
            if (WriteShareActivity.this.jXb) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jXl = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIe());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIf());
            WriteShareActivity.this.cHX();
        }
    };
    private View.OnClickListener jXm = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jWY.cIf().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIf());
        }
    };
    private final View.OnFocusChangeListener eWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jWY != null) {
                if (view == WriteShareActivity.this.jWY.cIe() || view == WriteShareActivity.this.jWY.cIh() || view == WriteShareActivity.this.jWY.cIi()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIe());
                    } else if (view == WriteShareActivity.this.jWY.cIe() && WriteShareActivity.this.jWY.cIj() != null) {
                        WriteShareActivity.this.jWY.cIj().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jWY.cIf()) {
                    if (z) {
                        WriteShareActivity.this.jWY.cIf().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jWY.cIf().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWY.cIe());
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
        this.bSq = getPageContext().getPageActivity().getPackageManager();
        bga();
        boolean cHO = cHO();
        initData(bundle);
        initUI();
        if (!cHO) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Cb(R.string.share_parameter_invalid_tip);
            } else {
                Cb(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cHP();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bga() {
        this.packageName = getCallingPackage();
        if (this.bSq != null && this.packageName != null) {
            try {
                this.jWV = this.bSq.getPackageInfo(this.packageName, 64);
                if (this.jWV != null) {
                    if (this.jWV.applicationInfo != null && this.jWV.applicationInfo.loadLabel(this.bSq) != null) {
                        this.mAppName = this.jWV.applicationInfo.loadLabel(this.bSq).toString();
                    }
                    if (this.jWV.signatures != null && this.jWV.signatures.length > 0 && this.jWV.signatures[0] != null) {
                        this.jWU = as.getAPKHexMD5(this.jWV.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jWU = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jWS = extras.getString("ShareUrl");
            this.cUm = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jWT = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jWU)) {
                this.jWU = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cHO() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cUm) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cHP() {
        if (TextUtils.isEmpty(this.jWT)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cHQ();
        }
    }

    private void cHQ() {
        this.jWY.cHZ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jWZ.IH(this.jWW.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHR() {
        if (this.jXc == null) {
            this.jXc = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jXc.sw(false);
            this.jXc.BX(R.drawable.icon_send_ok);
            this.jXc.Ca(R.string.share_alert_success);
            this.jXc.a(R.string.share_stay_in_tieba, this.jXe);
            this.jXc.b(R.string.back, this.jXg);
            this.jXc.a(this.jXj);
            this.jXc.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHS() {
        if (this.jXd == null) {
            this.jXd = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jXd.BX(R.drawable.icon_send_error);
            this.jXd.BY(R.drawable.btn_w_square);
            this.jXd.BZ(R.color.common_color_10039);
            this.jXd.Ca(R.string.share_alert_fail);
            this.jXd.a(R.string.share_keep_sending, this.jXf);
            this.jXd.b(R.string.back, this.jXg);
            this.jXd.a(this.jXj);
            this.jXd.f(getPageContext());
        }
    }

    protected void cHT() {
        if (this.dyz != null) {
            this.dyz.cancelLoadData();
        }
    }

    protected void cHU() {
        if (this.dyz != null) {
            this.dyz.cMm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cHT();
        cHU();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cIk;
        if (this.jWY != null && (cIk = this.jWY.cIk()) != null) {
            cIk.setImageBitmap(null);
        }
    }

    public WriteData cHV() {
        return this.jWW;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jWY != null && this.jWY.cIg() != null && this.jWY.cIg().isShowing()) {
                g.dismissPopupWindow(this.jWY.cIg(), getPageContext().getPageActivity());
                return true;
            }
            cHT();
            if (this.jXb) {
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
        if (this.jWY != null) {
            this.jWY.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jWY = new c(this);
        this.jWY.ab(this.jXk);
        this.jWY.ac(this.jXl);
        this.jWY.b(this.eWj);
        this.jWY.ad(this.jXm);
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

    public void Cb(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.dyz = new NewWriteModel(this);
        this.dyz.a(this.jXi);
        this.dyz.a(this.jXh);
        this.jWZ = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jWY != null) {
                            WriteShareActivity.this.jWY.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWY.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWY.a((PostPrefixData) null);
            }
        });
        this.gfz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cHT();
            }
        };
        this.jWW = new WriteData();
        this.jWW.setType(3);
        if (bundle != null) {
            this.jWW.setForumName(bundle.getString("forum_name"));
            this.jWW.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jWW.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jWW.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jWW.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jWW.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jWW.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jWW.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jWW.setForumName(this.jWT);
            this.jWW.setShareSummaryTitle(this.mShareTitle);
            this.jWW.setShareSummaryContent(this.mShareContent);
            this.jWW.setShareApiKey(this.mAppKey);
            this.jWW.setShareAppName(this.mAppName);
            this.jWW.setShareSignKey(this.jWU);
            this.jWW.setShareReferUrl(this.jWS);
            boolean isLocalImagePath = m.isLocalImagePath(this.cUm);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dyz.e(this.mShareLocalImageData, this.cUm);
                this.jWW.setShareLocalImageUri(this.cUm);
                this.jWW.setShareLocalImageData(this.mShareLocalImageData);
                this.dyz.bAG();
                this.jWW.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jWW.setShareSummaryImg(this.cUm);
                this.jWW.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jWW.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jWW.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jWW.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jWW.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jWW.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jWW.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jWW.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jWW.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jWW.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jWW.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jWW.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jWW.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jWW.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jWW.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jWW.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jWW.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jWW.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jWY != null && this.jWY.cIf() != null && (obj = this.jWY.cIf().getEditableText().toString()) != null) {
            this.jWY.cIf().setText(TbFaceManager.aPQ().aB(getPageContext().getContext(), obj));
            this.jWY.cIf().setSelection(this.jWY.cIf().getText().length());
        }
    }

    public void Cc(int i) {
        this.jWX = i;
    }

    public int cHW() {
        return this.jWX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHX() {
        cHT();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jWX != this.mPrefixData.getPrefixs().size() - 1) {
            this.jWW.setTitle(this.jWY.cIj().getText().toString() + this.jWY.cIe().getText().toString());
        } else {
            this.jWW.setTitle(this.jWY.cIe().getText().toString());
        }
        this.jWW.setContent(this.jWY.cIf().getText().toString());
        this.dyz.d(this.jWW);
        this.jWW.setVcode(null);
        this.dyz.cHV().setVoice(null);
        this.dyz.cHV().setVoiceDuringTime(-1);
        if (this.dyz.cMk()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jXa = false;
            if (i2 == -1) {
                cHR();
                if (this.jXc != null) {
                    this.jXb = true;
                    this.jXc.cHM();
                }
                setResult(-1);
                return;
            }
            cHS();
            if (this.jXd != null) {
                this.jXb = false;
                this.jXd.cHM();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jWT = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jWW.setForumName(this.jWT);
                    cHQ();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cHP();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jWY.cIe());
        HidenSoftKeyPad(this.mInputManager, this.jWY.cIf());
        super.onPause();
    }

    public void cHY() {
        HidenSoftKeyPad(this.mInputManager, this.jWY.cIe());
        HidenSoftKeyPad(this.mInputManager, this.jWY.cIf());
    }
}
