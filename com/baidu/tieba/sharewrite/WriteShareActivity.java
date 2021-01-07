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
/* loaded from: classes8.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dKM;
    private String eVX;
    private NewWriteModel fGa;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String ngD;
    private String ngE;
    private String ngF;
    private PackageInfo ngG;
    private int ngI;
    private c ngJ;
    b ngK;
    private com.baidu.tieba.sharewrite.a ngN;
    private com.baidu.tieba.sharewrite.a ngO;
    private String packageName;
    private WriteData ngH = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private boolean ngL = false;
    private boolean ngM = false;
    private a.b ngP = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.ngH.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b ngQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLA());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLB());
            WriteShareActivity.this.dLt();
            aVar.dismiss();
        }
    };
    private a.b ngR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.ngM) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b ngS = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.ngH.setShareSummaryImg("");
                WriteShareActivity.this.ngH.setShareSummaryImgHeight(0);
                WriteShareActivity.this.ngH.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.ngH.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.ngH.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.ngH.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c ngT = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dLo();
                if (WriteShareActivity.this.ngN != null) {
                    WriteShareActivity.this.ngM = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.ngN.dLj();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dLp();
                if (WriteShareActivity.this.ngO != null) {
                    WriteShareActivity.this.ngM = false;
                    WriteShareActivity.this.ngO.dLj();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bAh());
                WriteShareActivity.this.ngL = true;
                if (com.baidu.tbadk.t.a.EP(ahVar.bAg())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAg())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener ngU = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.ngJ != null && WriteShareActivity.this.ngJ.dLC() != null && WriteShareActivity.this.ngJ.dLC().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.ngJ.dLC(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dLq();
                if (WriteShareActivity.this.ngM) {
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
    private View.OnClickListener ngV = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dLq();
            if (WriteShareActivity.this.ngM) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener ngW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLA());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLB());
            WriteShareActivity.this.dLt();
        }
    };
    private View.OnClickListener ngX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.ngJ.dLB().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLB());
        }
    };
    private final View.OnFocusChangeListener hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.ngJ != null) {
                if (view == WriteShareActivity.this.ngJ.dLA() || view == WriteShareActivity.this.ngJ.dLD() || view == WriteShareActivity.this.ngJ.dLE()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLA());
                    } else if (view == WriteShareActivity.this.ngJ.dLA() && WriteShareActivity.this.ngJ.dLF() != null) {
                        WriteShareActivity.this.ngJ.dLF().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.ngJ.dLB()) {
                    if (z) {
                        WriteShareActivity.this.ngJ.dLB().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.ngJ.dLB().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngJ.dLA());
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
        this.dKM = getPageContext().getPageActivity().getPackageManager();
        cpe();
        boolean dLl = dLl();
        initData(bundle);
        initUI();
        if (!dLl) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Kt(R.string.share_parameter_invalid_tip);
            } else {
                Kt(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dLm();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cpe() {
        this.packageName = getCallingPackage();
        if (this.dKM != null && this.packageName != null) {
            try {
                this.ngG = this.dKM.getPackageInfo(this.packageName, 64);
                if (this.ngG != null) {
                    if (this.ngG.applicationInfo != null && this.ngG.applicationInfo.loadLabel(this.dKM) != null) {
                        this.mAppName = this.ngG.applicationInfo.loadLabel(this.dKM).toString();
                    }
                    if (this.ngG.signatures != null && this.ngG.signatures.length > 0 && this.ngG.signatures[0] != null) {
                        this.ngF = av.getAPKHexMD5(this.ngG.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.ngF = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ngD = extras.getString("ShareUrl");
            this.eVX = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ngE = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.ngF)) {
                this.ngF = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dLl() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eVX) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dLm() {
        if (TextUtils.isEmpty(this.ngE)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dLn();
        }
    }

    private void dLn() {
        this.ngJ.dLv();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ngK.SJ(this.ngH.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLo() {
        if (this.ngN == null) {
            this.ngN = new com.baidu.tieba.sharewrite.a(getActivity());
            this.ngN.xK(false);
            this.ngN.Kp(R.drawable.icon_send_ok);
            this.ngN.Ks(R.string.share_alert_success);
            this.ngN.a(R.string.share_stay_in_tieba, this.ngP);
            this.ngN.b(R.string.back, this.ngR);
            this.ngN.b(this.ngU);
            this.ngN.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLp() {
        if (this.ngO == null) {
            this.ngO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.ngO.Kp(R.drawable.icon_send_error);
            this.ngO.Kq(R.drawable.btn_w_square);
            this.ngO.Kr(R.color.common_color_10039);
            this.ngO.Ks(R.string.share_alert_fail);
            this.ngO.a(R.string.share_keep_sending, this.ngQ);
            this.ngO.b(R.string.back, this.ngR);
            this.ngO.b(this.ngU);
            this.ngO.g(getPageContext());
        }
    }

    protected void dLq() {
        if (this.fGa != null) {
            this.fGa.cancelLoadData();
        }
    }

    protected void dLr() {
        if (this.fGa != null) {
            this.fGa.dQS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dLq();
        dLr();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dLG;
        if (this.ngJ != null && (dLG = this.ngJ.dLG()) != null) {
            dLG.setImageBitmap(null);
        }
    }

    public WriteData dcp() {
        return this.ngH;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ngJ != null && this.ngJ.dLC() != null && this.ngJ.dLC().isShowing()) {
                g.dismissPopupWindow(this.ngJ.dLC(), getPageContext().getPageActivity());
                return true;
            }
            dLq();
            if (this.ngM) {
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
        if (this.ngJ != null) {
            this.ngJ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ngJ = new c(this);
        this.ngJ.ah(this.ngV);
        this.ngJ.ai(this.ngW);
        this.ngJ.b(this.hxA);
        this.ngJ.aj(this.ngX);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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

    public void Kt(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fGa = new NewWriteModel(this);
        this.fGa.a(this.ngT);
        this.fGa.a(this.ngS);
        this.ngK = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.ngJ != null) {
                            WriteShareActivity.this.ngJ.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ngJ.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ngJ.a((PostPrefixData) null);
            }
        });
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dLq();
            }
        };
        this.ngH = new WriteData();
        this.ngH.setType(3);
        if (bundle != null) {
            this.ngH.setForumName(bundle.getString("forum_name"));
            this.ngH.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.ngH.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.ngH.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.ngH.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.ngH.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.ngH.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.ngH.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.ngH.setForumName(this.ngE);
            this.ngH.setShareSummaryTitle(this.mShareTitle);
            this.ngH.setShareSummaryContent(this.mShareContent);
            this.ngH.setShareApiKey(this.mAppKey);
            this.ngH.setShareAppName(this.mAppName);
            this.ngH.setShareSignKey(this.ngF);
            this.ngH.setShareReferUrl(this.ngD);
            boolean isLocalImagePath = n.isLocalImagePath(this.eVX);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fGa.d(this.mShareLocalImageData, this.eVX);
                this.ngH.setShareLocalImageUri(this.eVX);
                this.ngH.setShareLocalImageData(this.mShareLocalImageData);
                this.fGa.cBB();
                this.ngH.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.ngH.setShareSummaryImg(this.eVX);
                this.ngH.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.ngH.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.ngH.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.ngH.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.ngH.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.ngH.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.ngH.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.ngH.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.ngH.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.ngH.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.ngH.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.ngH.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.ngH.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.ngH.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.ngH.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.ngH.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.ngH.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ngH.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.ngJ != null && this.ngJ.dLB() != null && (obj = this.ngJ.dLB().getEditableText().toString()) != null) {
            this.ngJ.dLB().setText(TbFaceManager.bGp().aE(getPageContext().getContext(), obj));
            this.ngJ.dLB().setSelection(this.ngJ.dLB().getText().length());
        }
    }

    public void Ku(int i) {
        this.ngI = i;
    }

    public int dLs() {
        return this.ngI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLt() {
        dLq();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.ngI != this.mPrefixData.getPrefixs().size() - 1) {
            this.ngH.setTitle(this.ngJ.dLF().getText().toString() + this.ngJ.dLA().getText().toString());
        } else {
            this.ngH.setTitle(this.ngJ.dLA().getText().toString());
        }
        this.ngH.setContent(this.ngJ.dLB().getText().toString());
        this.fGa.f(this.ngH);
        this.ngH.setVcode(null);
        this.fGa.dcp().setVoice(null);
        this.fGa.dcp().setVoiceDuringTime(-1);
        if (this.fGa.dQC()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iVZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.ngL = false;
            if (i2 == -1) {
                dLo();
                if (this.ngN != null) {
                    this.ngM = true;
                    this.ngN.dLj();
                }
                setResult(-1);
                return;
            }
            dLp();
            if (this.ngO != null) {
                this.ngM = false;
                this.ngO.dLj();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.ngE = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.ngH.setForumName(this.ngE);
                    dLn();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dLm();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.ngJ.dLA());
        HidenSoftKeyPad(this.mInputManager, this.ngJ.dLB());
        super.onPause();
    }

    public void dLu() {
        HidenSoftKeyPad(this.mInputManager, this.ngJ.dLA());
        HidenSoftKeyPad(this.mInputManager, this.ngJ.dLB());
    }
}
