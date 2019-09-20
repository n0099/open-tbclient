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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager aUv;
    private String bMS;
    private NewWriteModel cuH;
    private String iYE;
    private String iYF;
    private String iYG;
    private PackageInfo iYH;
    private int iYI;
    private c iYJ;
    b iYK;
    private com.baidu.tieba.sharewrite.a iYN;
    private com.baidu.tieba.sharewrite.a iYO;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mData = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private boolean iYL = false;
    private boolean iYM = false;
    private a.b iYP = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iYQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnv());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnw());
            WriteShareActivity.this.cno();
            aVar.dismiss();
        }
    };
    private a.b iYR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iYM) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iYS = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mData.setShareSummaryImg("");
                WriteShareActivity.this.mData.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mData.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c iYT = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, y yVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cnj();
                if (WriteShareActivity.this.iYN != null) {
                    WriteShareActivity.this.iYM = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iYN.cne();
                }
            } else if (yVar == null || writeData == null || yVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cnk();
                if (WriteShareActivity.this.iYO != null) {
                    WriteShareActivity.this.iYM = false;
                    WriteShareActivity.this.iYO.cne();
                }
            } else {
                writeData.setVcodeMD5(yVar.getVcode_md5());
                writeData.setVcodeUrl(yVar.getVcode_pic_url());
                writeData.setVcodeExtra(yVar.amT());
                WriteShareActivity.this.iYL = true;
                if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, yVar.amS())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iYU = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.iYJ != null && WriteShareActivity.this.iYJ.cnx() != null && WriteShareActivity.this.iYJ.cnx().isShowing()) {
                    g.a(WriteShareActivity.this.iYJ.cnx(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cnl();
                if (WriteShareActivity.this.iYM) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener iYV = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cnl();
            if (WriteShareActivity.this.iYM) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iYW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnv());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnw());
            WriteShareActivity.this.cno();
        }
    };
    private View.OnClickListener iYX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.iYJ.cnw().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnw());
        }
    };
    private final View.OnFocusChangeListener iYY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.iYJ != null) {
                if (view == WriteShareActivity.this.iYJ.cnv() || view == WriteShareActivity.this.iYJ.cny() || view == WriteShareActivity.this.iYJ.cnz()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnv());
                    } else if (view == WriteShareActivity.this.iYJ.cnv() && WriteShareActivity.this.iYJ.cnA() != null) {
                        WriteShareActivity.this.iYJ.cnA().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.iYJ.cnw()) {
                    if (z) {
                        WriteShareActivity.this.iYJ.cnw().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.iYJ.cnw().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYJ.cnv());
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
        this.aUv = getPageContext().getPageActivity().getPackageManager();
        aWx();
        boolean cng = cng();
        initData(bundle);
        initUI();
        if (!cng) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                AM(R.string.share_parameter_invalid_tip);
            } else {
                AM(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cnh();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aWx() {
        this.packageName = getCallingPackage();
        if (this.aUv != null && this.packageName != null) {
            try {
                this.iYH = this.aUv.getPackageInfo(this.packageName, 64);
                if (this.iYH != null) {
                    if (this.iYH.applicationInfo != null && this.iYH.applicationInfo.loadLabel(this.aUv) != null) {
                        this.mAppName = this.iYH.applicationInfo.loadLabel(this.aUv).toString();
                    }
                    if (this.iYH.signatures != null && this.iYH.signatures.length > 0 && this.iYH.signatures[0] != null) {
                        this.iYG = as.G(this.iYH.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.iYG = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.iYE = extras.getString("ShareUrl");
            this.bMS = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.iYF = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.iYG)) {
                this.iYG = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cng() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.bMS) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, SapiGIDEvent.SYSTEM_NETWORK_CHANGE_WIFI_TO_MOB)));
    }

    private void cnh() {
        if (TextUtils.isEmpty(this.iYF)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            cni();
        }
    }

    private void cni() {
        this.iYJ.cnq();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iYK.EQ(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        if (this.iYN == null) {
            this.iYN = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iYN.qP(false);
            this.iYN.AI(R.drawable.icon_send_ok);
            this.iYN.AL(R.string.share_alert_success);
            this.iYN.a(R.string.share_stay_in_tieba, this.iYP);
            this.iYN.b(R.string.back, this.iYR);
            this.iYN.b(this.iYU);
            this.iYN.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnk() {
        if (this.iYO == null) {
            this.iYO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iYO.AI(R.drawable.icon_send_error);
            this.iYO.AJ(R.drawable.btn_w_square);
            this.iYO.AK(R.color.common_color_10039);
            this.iYO.AL(R.string.share_alert_fail);
            this.iYO.a(R.string.share_keep_sending, this.iYQ);
            this.iYO.b(R.string.back, this.iYR);
            this.iYO.b(this.iYU);
            this.iYO.f(getPageContext());
        }
    }

    protected void cnl() {
        if (this.cuH != null) {
            this.cuH.cancelLoadData();
        }
    }

    protected void cnm() {
        if (this.cuH != null) {
            this.cuH.aYF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cnl();
        cnm();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cnB;
        if (this.iYJ != null && (cnB = this.iYJ.cnB()) != null) {
            cnB.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iYJ != null && this.iYJ.cnx() != null && this.iYJ.cnx().isShowing()) {
                g.a(this.iYJ.cnx(), getPageContext().getPageActivity());
                return true;
            }
            cnl();
            if (this.iYM) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iYJ != null) {
            this.iYJ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iYJ = new c(this);
        this.iYJ.aa(this.iYV);
        this.iYJ.ab(this.iYW);
        this.iYJ.b(this.iYY);
        this.iYJ.ac(this.iYX);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
                com.baidu.tbadk.core.f.b.c(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void AM(int i) {
        l.f(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.cuH = new NewWriteModel(this);
        this.cuH.a(this.iYT);
        this.cuH.a(this.iYS);
        this.iYK = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.iYJ != null) {
                            WriteShareActivity.this.iYJ.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iYJ.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iYJ.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cnl();
            }
        };
        this.mData = new WriteData();
        this.mData.setType(3);
        if (bundle != null) {
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mData.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mData.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mData.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mData.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mData.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mData.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mData.setForumName(this.iYF);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.iYG);
            this.mData.setShareReferUrl(this.iYE);
            boolean nH = m.nH(this.bMS);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || nH) {
                this.cuH.g(this.mShareLocalImageData, this.bMS);
                this.mData.setShareLocalImageUri(this.bMS);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.cuH.biO();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.bMS);
                this.mData.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mData.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mData.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mData.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mData.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mData.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mData.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mData.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mData.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mData.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mData.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mData.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mData.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mData.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mData.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mData.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mData.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.iYJ != null && this.iYJ.cnw() != null && (obj = this.iYJ.cnw().getEditableText().toString()) != null) {
            this.iYJ.cnw().setText(TbFaceManager.atJ().ak(getPageContext().getContext(), obj));
            this.iYJ.cnw().setSelection(this.iYJ.cnw().getText().length());
        }
    }

    public void AN(int i) {
        this.iYI = i;
    }

    public int cnn() {
        return this.iYI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cno() {
        cnl();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.iYI != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.iYJ.cnA().getText().toString() + this.iYJ.cnv().getText().toString());
        } else {
            this.mData.setTitle(this.iYJ.cnv().getText().toString());
        }
        this.mData.setContent(this.iYJ.cnw().getText().toString());
        this.cuH.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.cuH.getWriteData().setVoice(null);
        this.cuH.getWriteData().setVoiceDuringTime(-1);
        if (this.cuH.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iYL = false;
            if (i2 == -1) {
                cnj();
                if (this.iYN != null) {
                    this.iYM = true;
                    this.iYN.cne();
                }
                setResult(-1);
                return;
            }
            cnk();
            if (this.iYO != null) {
                this.iYM = false;
                this.iYO.cne();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.iYF = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.iYF);
                    cni();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cnh();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.iYJ.cnv());
        HidenSoftKeyPad(this.mInputManager, this.iYJ.cnw());
        super.onPause();
    }

    public void cnp() {
        HidenSoftKeyPad(this.mInputManager, this.iYJ.cnv());
        HidenSoftKeyPad(this.mInputManager, this.iYJ.cnw());
    }
}
