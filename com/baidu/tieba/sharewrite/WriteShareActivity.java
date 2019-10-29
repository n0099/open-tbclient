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
    private PackageManager bnz;
    private NewWriteModel cGQ;
    private String ceB;
    private c iYA;
    b iYB;
    private com.baidu.tieba.sharewrite.a iYE;
    private com.baidu.tieba.sharewrite.a iYF;
    private String iYt;
    private String iYu;
    private String iYv;
    private String iYw;
    private PackageInfo iYx;
    private int iYz;
    private String mAppKey;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData iYy = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener fms = null;
    private boolean iYC = false;
    private boolean iYD = false;
    private a.b iYG = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.iYy.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iYH = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.cll());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.clm());
            WriteShareActivity.this.cle();
            aVar.dismiss();
        }
    };
    private a.b iYI = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iYD) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iYJ = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.iYy.setShareSummaryImg("");
                WriteShareActivity.this.iYy.setShareSummaryImgHeight(0);
                WriteShareActivity.this.iYy.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.iYy.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.iYy.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.iYy.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c iYK = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, y yVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.ckY();
                if (WriteShareActivity.this.iYE != null) {
                    WriteShareActivity.this.iYD = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iYE.ckT();
                }
            } else if (yVar == null || writeData == null || yVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.ckZ();
                if (WriteShareActivity.this.iYF != null) {
                    WriteShareActivity.this.iYD = false;
                    WriteShareActivity.this.iYF.ckT();
                }
            } else {
                writeData.setVcodeMD5(yVar.getVcode_md5());
                writeData.setVcodeUrl(yVar.getVcode_pic_url());
                writeData.setVcodeExtra(yVar.apu());
                WriteShareActivity.this.iYC = true;
                if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iYL = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.iYA != null && WriteShareActivity.this.iYA.cln() != null && WriteShareActivity.this.iYA.cln().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.iYA.cln(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cla();
                if (WriteShareActivity.this.iYD) {
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
    private View.OnClickListener iYM = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cla();
            if (WriteShareActivity.this.iYD) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iYN = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.cll());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.clm());
            WriteShareActivity.this.cle();
        }
    };
    private View.OnClickListener iYO = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.iYA.clm().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.clm());
        }
    };
    private final View.OnFocusChangeListener iYP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.iYA != null) {
                if (view == WriteShareActivity.this.iYA.cll() || view == WriteShareActivity.this.iYA.clo() || view == WriteShareActivity.this.iYA.clp()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.cll());
                    } else if (view == WriteShareActivity.this.iYA.cll() && WriteShareActivity.this.iYA.clq() != null) {
                        WriteShareActivity.this.iYA.clq().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.iYA.clm()) {
                    if (z) {
                        WriteShareActivity.this.iYA.clm().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.iYA.clm().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iYA.cll());
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
        this.bnz = getPageContext().getPageActivity().getPackageManager();
        aXg();
        boolean ckV = ckV();
        initData(bundle);
        initUI();
        if (!ckV) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                zu(R.string.share_parameter_invalid_tip);
            } else {
                zu(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            ckW();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void aXg() {
        this.packageName = getCallingPackage();
        if (this.bnz != null && this.packageName != null) {
            try {
                this.iYx = this.bnz.getPackageInfo(this.packageName, 64);
                if (this.iYx != null) {
                    if (this.iYx.applicationInfo != null && this.iYx.applicationInfo.loadLabel(this.bnz) != null) {
                        this.iYv = this.iYx.applicationInfo.loadLabel(this.bnz).toString();
                    }
                    if (this.iYx.signatures != null && this.iYx.signatures.length > 0 && this.iYx.signatures[0] != null) {
                        this.iYw = as.getAPKHexMD5(this.iYx.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.iYv = null;
                this.iYw = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.iYt = extras.getString("ShareUrl");
            this.ceB = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.iYu = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.iYv)) {
                this.iYv = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.iYw)) {
                this.iYw = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean ckV() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.ceB) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void ckW() {
        if (TextUtils.isEmpty(this.iYu)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            ckX();
        }
    }

    private void ckX() {
        this.iYA.clg();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iYB.Dv(this.iYy.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckY() {
        if (this.iYE == null) {
            this.iYE = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iYE.qy(false);
            this.iYE.zq(R.drawable.icon_send_ok);
            this.iYE.zt(R.string.share_alert_success);
            this.iYE.a(R.string.share_stay_in_tieba, this.iYG);
            this.iYE.b(R.string.back, this.iYI);
            this.iYE.a(this.iYL);
            this.iYE.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckZ() {
        if (this.iYF == null) {
            this.iYF = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iYF.zq(R.drawable.icon_send_error);
            this.iYF.zr(R.drawable.btn_w_square);
            this.iYF.zs(R.color.common_color_10039);
            this.iYF.zt(R.string.share_alert_fail);
            this.iYF.a(R.string.share_keep_sending, this.iYH);
            this.iYF.b(R.string.back, this.iYI);
            this.iYF.a(this.iYL);
            this.iYF.f(getPageContext());
        }
    }

    protected void cla() {
        if (this.cGQ != null) {
            this.cGQ.cancelLoadData();
        }
    }

    protected void clb() {
        if (this.cGQ != null) {
            this.cGQ.cpG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cla();
        clb();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView clr;
        if (this.iYA != null && (clr = this.iYA.clr()) != null) {
            clr.setImageBitmap(null);
        }
    }

    public WriteData clc() {
        return this.iYy;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iYA != null && this.iYA.cln() != null && this.iYA.cln().isShowing()) {
                g.dismissPopupWindow(this.iYA.cln(), getPageContext().getPageActivity());
                return true;
            }
            cla();
            if (this.iYD) {
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
        if (this.iYA != null) {
            this.iYA.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iYA = new c(this);
        this.iYA.ab(this.iYM);
        this.iYA.ac(this.iYN);
        this.iYA.b(this.iYP);
        this.iYA.ad(this.iYO);
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

    public void zu(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.cGQ = new NewWriteModel(this);
        this.cGQ.a(this.iYK);
        this.cGQ.a(this.iYJ);
        this.iYB = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.iYA != null) {
                            WriteShareActivity.this.iYA.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iYA.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iYA.a((PostPrefixData) null);
            }
        });
        this.fms = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cla();
            }
        };
        this.iYy = new WriteData();
        this.iYy.setType(3);
        if (bundle != null) {
            this.iYy.setForumName(bundle.getString("forum_name"));
            this.iYy.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.iYy.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.iYy.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.iYy.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.iYy.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.iYy.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.iYy.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.iYy.setForumName(this.iYu);
            this.iYy.setShareSummaryTitle(this.mShareTitle);
            this.iYy.setShareSummaryContent(this.mShareContent);
            this.iYy.setShareApiKey(this.mAppKey);
            this.iYy.setShareAppName(this.iYv);
            this.iYy.setShareSignKey(this.iYw);
            this.iYy.setShareReferUrl(this.iYt);
            boolean isLocalImagePath = m.isLocalImagePath(this.ceB);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.cGQ.e(this.mShareLocalImageData, this.ceB);
                this.iYy.setShareLocalImageUri(this.ceB);
                this.iYy.setShareLocalImageData(this.mShareLocalImageData);
                this.cGQ.bgG();
                this.iYy.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.iYy.setShareSummaryImg(this.ceB);
                this.iYy.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.iYy.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.iYy.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.iYy.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.iYy.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.iYy.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.iYy.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.iYy.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.iYy.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.iYy.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.iYy.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.iYy.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.iYy.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.iYy.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.iYy.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.iYy.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.iYy.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.iYy.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.iYA != null && this.iYA.clm() != null && (obj = this.iYA.clm().getEditableText().toString()) != null) {
            this.iYA.clm().setText(TbFaceManager.avt().ah(getPageContext().getContext(), obj));
            this.iYA.clm().setSelection(this.iYA.clm().getText().length());
        }
    }

    public void zv(int i) {
        this.iYz = i;
    }

    public int cld() {
        return this.iYz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cle() {
        cla();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.iYz != this.mPrefixData.getPrefixs().size() - 1) {
            this.iYy.setTitle(this.iYA.clq().getText().toString() + this.iYA.cll().getText().toString());
        } else {
            this.iYy.setTitle(this.iYA.cll().getText().toString());
        }
        this.iYy.setContent(this.iYA.clm().getText().toString());
        this.cGQ.d(this.iYy);
        this.iYy.setVcode(null);
        this.cGQ.clc().setVoice(null);
        this.cGQ.clc().setVoiceDuringTime(-1);
        if (this.cGQ.cpE()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.fms);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iYC = false;
            if (i2 == -1) {
                ckY();
                if (this.iYE != null) {
                    this.iYD = true;
                    this.iYE.ckT();
                }
                setResult(-1);
                return;
            }
            ckZ();
            if (this.iYF != null) {
                this.iYD = false;
                this.iYF.ckT();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.iYu = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.iYy.setForumName(this.iYu);
                    ckX();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                ckW();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.iYA.cll());
        HidenSoftKeyPad(this.mInputManager, this.iYA.clm());
        super.onPause();
    }

    public void clf() {
        HidenSoftKeyPad(this.mInputManager, this.iYA.cll());
        HidenSoftKeyPad(this.mInputManager, this.iYA.clm());
    }
}
