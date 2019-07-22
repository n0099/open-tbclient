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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager aTX;
    private String bMp;
    private NewWriteModel ctD;
    private String iVf;
    private String iVg;
    private String iVh;
    private PackageInfo iVi;
    private int iVj;
    private c iVk;
    b iVl;
    private com.baidu.tieba.sharewrite.a iVo;
    private com.baidu.tieba.sharewrite.a iVp;
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
    private boolean iVm = false;
    private boolean iVn = false;
    private a.b iVq = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iVr = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmq());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmr());
            WriteShareActivity.this.cmj();
            aVar.dismiss();
        }
    };
    private a.b iVs = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iVn) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iVt = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c iVu = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, x xVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cme();
                if (WriteShareActivity.this.iVo != null) {
                    WriteShareActivity.this.iVn = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iVo.clZ();
                }
            } else if (xVar == null || writeData == null || xVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cmf();
                if (WriteShareActivity.this.iVp != null) {
                    WriteShareActivity.this.iVn = false;
                    WriteShareActivity.this.iVp.clZ();
                }
            } else {
                writeData.setVcodeMD5(xVar.getVcode_md5());
                writeData.setVcodeUrl(xVar.getVcode_pic_url());
                writeData.setVcodeExtra(xVar.amF());
                WriteShareActivity.this.iVm = true;
                if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, xVar.amE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iVv = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.iVk != null && WriteShareActivity.this.iVk.cms() != null && WriteShareActivity.this.iVk.cms().isShowing()) {
                    g.a(WriteShareActivity.this.iVk.cms(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cmg();
                if (WriteShareActivity.this.iVn) {
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
    private View.OnClickListener iVw = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cmg();
            if (WriteShareActivity.this.iVn) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iVx = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmq());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmr());
            WriteShareActivity.this.cmj();
        }
    };
    private View.OnClickListener iVy = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.iVk.cmr().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmr());
        }
    };
    private final View.OnFocusChangeListener iVz = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.iVk != null) {
                if (view == WriteShareActivity.this.iVk.cmq() || view == WriteShareActivity.this.iVk.cmt() || view == WriteShareActivity.this.iVk.cmu()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmq());
                    } else if (view == WriteShareActivity.this.iVk.cmq() && WriteShareActivity.this.iVk.cmv() != null) {
                        WriteShareActivity.this.iVk.cmv().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.iVk.cmr()) {
                    if (z) {
                        WriteShareActivity.this.iVk.cmr().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.iVk.cmr().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iVk.cmq());
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
        this.aTX = getPageContext().getPageActivity().getPackageManager();
        aVR();
        boolean cmb = cmb();
        initData(bundle);
        initUI();
        if (!cmb) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                AH(R.string.share_parameter_invalid_tip);
            } else {
                AH(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cmc();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aVR() {
        this.packageName = getCallingPackage();
        if (this.aTX != null && this.packageName != null) {
            try {
                this.iVi = this.aTX.getPackageInfo(this.packageName, 64);
                if (this.iVi != null) {
                    if (this.iVi.applicationInfo != null && this.iVi.applicationInfo.loadLabel(this.aTX) != null) {
                        this.mAppName = this.iVi.applicationInfo.loadLabel(this.aTX).toString();
                    }
                    if (this.iVi.signatures != null && this.iVi.signatures.length > 0 && this.iVi.signatures[0] != null) {
                        this.iVh = at.G(this.iVi.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.iVh = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.iVf = extras.getString("ShareUrl");
            this.bMp = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.iVg = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.iVh)) {
                this.iVh = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cmb() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.bMp) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, SapiGIDEvent.SYSTEM_NETWORK_CHANGE_WIFI_TO_MOB)));
    }

    private void cmc() {
        if (TextUtils.isEmpty(this.iVg)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            cmd();
        }
    }

    private void cmd() {
        this.iVk.cml();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iVl.Ep(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cme() {
        if (this.iVo == null) {
            this.iVo = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iVo.qL(false);
            this.iVo.AD(R.drawable.icon_send_ok);
            this.iVo.AG(R.string.share_alert_success);
            this.iVo.a(R.string.share_stay_in_tieba, this.iVq);
            this.iVo.b(R.string.back, this.iVs);
            this.iVo.b(this.iVv);
            this.iVo.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmf() {
        if (this.iVp == null) {
            this.iVp = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iVp.AD(R.drawable.icon_send_error);
            this.iVp.AE(R.drawable.btn_w_square);
            this.iVp.AF(R.color.common_color_10039);
            this.iVp.AG(R.string.share_alert_fail);
            this.iVp.a(R.string.share_keep_sending, this.iVr);
            this.iVp.b(R.string.back, this.iVs);
            this.iVp.b(this.iVv);
            this.iVp.f(getPageContext());
        }
    }

    protected void cmg() {
        if (this.ctD != null) {
            this.ctD.cancelLoadData();
        }
    }

    protected void cmh() {
        if (this.ctD != null) {
            this.ctD.aXZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cmg();
        cmh();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cmw;
        if (this.iVk != null && (cmw = this.iVk.cmw()) != null) {
            cmw.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iVk != null && this.iVk.cms() != null && this.iVk.cms().isShowing()) {
                g.a(this.iVk.cms(), getPageContext().getPageActivity());
                return true;
            }
            cmg();
            if (this.iVn) {
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
        if (this.iVk != null) {
            this.iVk.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iVk = new c(this);
        this.iVk.aa(this.iVw);
        this.iVk.ab(this.iVx);
        this.iVk.b(this.iVz);
        this.iVk.ac(this.iVy);
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

    public void AH(int i) {
        l.f(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.ctD = new NewWriteModel(this);
        this.ctD.a(this.iVu);
        this.ctD.a(this.iVt);
        this.iVl = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.iVk != null) {
                            WriteShareActivity.this.iVk.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iVk.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iVk.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cmg();
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
            this.mData.setForumName(this.iVg);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.iVh);
            this.mData.setShareReferUrl(this.iVf);
            boolean nF = m.nF(this.bMp);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || nF) {
                this.ctD.g(this.mShareLocalImageData, this.bMp);
                this.mData.setShareLocalImageUri(this.bMp);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.ctD.bhW();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.bMp);
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
        if (this.iVk != null && this.iVk.cmr() != null && (obj = this.iVk.cmr().getEditableText().toString()) != null) {
            this.iVk.cmr().setText(TbFaceManager.atv().ak(getPageContext().getContext(), obj));
            this.iVk.cmr().setSelection(this.iVk.cmr().getText().length());
        }
    }

    public void AI(int i) {
        this.iVj = i;
    }

    public int cmi() {
        return this.iVj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmj() {
        cmg();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.iVj != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.iVk.cmv().getText().toString() + this.iVk.cmq().getText().toString());
        } else {
            this.mData.setTitle(this.iVk.cmq().getText().toString());
        }
        this.mData.setContent(this.iVk.cmr().getText().toString());
        this.ctD.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.ctD.getWriteData().setVoice(null);
        this.ctD.getWriteData().setVoiceDuringTime(-1);
        if (this.ctD.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iVm = false;
            if (i2 == -1) {
                cme();
                if (this.iVo != null) {
                    this.iVn = true;
                    this.iVo.clZ();
                }
                setResult(-1);
                return;
            }
            cmf();
            if (this.iVp != null) {
                this.iVn = false;
                this.iVp.clZ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.iVg = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.iVg);
                    cmd();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cmc();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.iVk.cmq());
        HidenSoftKeyPad(this.mInputManager, this.iVk.cmr());
        super.onPause();
    }

    public void cmk() {
        HidenSoftKeyPad(this.mInputManager, this.iVk.cmq());
        HidenSoftKeyPad(this.mInputManager, this.iVk.cmr());
    }
}
