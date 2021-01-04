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
    private String ngE;
    private String ngF;
    private String ngG;
    private PackageInfo ngH;
    private int ngJ;
    private c ngK;
    b ngL;
    private com.baidu.tieba.sharewrite.a ngO;
    private com.baidu.tieba.sharewrite.a ngP;
    private String packageName;
    private WriteData ngI = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private boolean ngM = false;
    private boolean ngN = false;
    private a.b ngQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.ngI.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b ngR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLz());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLA());
            WriteShareActivity.this.dLs();
            aVar.dismiss();
        }
    };
    private a.b ngS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.ngN) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b ngT = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.ngI.setShareSummaryImg("");
                WriteShareActivity.this.ngI.setShareSummaryImgHeight(0);
                WriteShareActivity.this.ngI.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.ngI.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.ngI.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.ngI.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c ngU = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dLn();
                if (WriteShareActivity.this.ngO != null) {
                    WriteShareActivity.this.ngN = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.ngO.dLi();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dLo();
                if (WriteShareActivity.this.ngP != null) {
                    WriteShareActivity.this.ngN = false;
                    WriteShareActivity.this.ngP.dLi();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bAg());
                WriteShareActivity.this.ngM = true;
                if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAf())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener ngV = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.ngK != null && WriteShareActivity.this.ngK.dLB() != null && WriteShareActivity.this.ngK.dLB().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.ngK.dLB(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dLp();
                if (WriteShareActivity.this.ngN) {
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
    private View.OnClickListener ngW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dLp();
            if (WriteShareActivity.this.ngN) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener ngX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLz());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLA());
            WriteShareActivity.this.dLs();
        }
    };
    private View.OnClickListener ngY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.ngK.dLA().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLA());
        }
    };
    private final View.OnFocusChangeListener hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.ngK != null) {
                if (view == WriteShareActivity.this.ngK.dLz() || view == WriteShareActivity.this.ngK.dLC() || view == WriteShareActivity.this.ngK.dLD()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLz());
                    } else if (view == WriteShareActivity.this.ngK.dLz() && WriteShareActivity.this.ngK.dLE() != null) {
                        WriteShareActivity.this.ngK.dLE().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.ngK.dLA()) {
                    if (z) {
                        WriteShareActivity.this.ngK.dLA().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.ngK.dLA().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ngK.dLz());
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
        cpd();
        boolean dLk = dLk();
        initData(bundle);
        initUI();
        if (!dLk) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Kt(R.string.share_parameter_invalid_tip);
            } else {
                Kt(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dLl();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cpd() {
        this.packageName = getCallingPackage();
        if (this.dKM != null && this.packageName != null) {
            try {
                this.ngH = this.dKM.getPackageInfo(this.packageName, 64);
                if (this.ngH != null) {
                    if (this.ngH.applicationInfo != null && this.ngH.applicationInfo.loadLabel(this.dKM) != null) {
                        this.mAppName = this.ngH.applicationInfo.loadLabel(this.dKM).toString();
                    }
                    if (this.ngH.signatures != null && this.ngH.signatures.length > 0 && this.ngH.signatures[0] != null) {
                        this.ngG = av.getAPKHexMD5(this.ngH.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.ngG = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ngE = extras.getString("ShareUrl");
            this.eVX = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ngF = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.ngG)) {
                this.ngG = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dLk() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eVX) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dLl() {
        if (TextUtils.isEmpty(this.ngF)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dLm();
        }
    }

    private void dLm() {
        this.ngK.dLu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ngL.SK(this.ngI.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLn() {
        if (this.ngO == null) {
            this.ngO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.ngO.xK(false);
            this.ngO.Kp(R.drawable.icon_send_ok);
            this.ngO.Ks(R.string.share_alert_success);
            this.ngO.a(R.string.share_stay_in_tieba, this.ngQ);
            this.ngO.b(R.string.back, this.ngS);
            this.ngO.b(this.ngV);
            this.ngO.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLo() {
        if (this.ngP == null) {
            this.ngP = new com.baidu.tieba.sharewrite.a(getActivity());
            this.ngP.Kp(R.drawable.icon_send_error);
            this.ngP.Kq(R.drawable.btn_w_square);
            this.ngP.Kr(R.color.common_color_10039);
            this.ngP.Ks(R.string.share_alert_fail);
            this.ngP.a(R.string.share_keep_sending, this.ngR);
            this.ngP.b(R.string.back, this.ngS);
            this.ngP.b(this.ngV);
            this.ngP.g(getPageContext());
        }
    }

    protected void dLp() {
        if (this.fGa != null) {
            this.fGa.cancelLoadData();
        }
    }

    protected void dLq() {
        if (this.fGa != null) {
            this.fGa.dQR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dLp();
        dLq();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dLF;
        if (this.ngK != null && (dLF = this.ngK.dLF()) != null) {
            dLF.setImageBitmap(null);
        }
    }

    public WriteData dco() {
        return this.ngI;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ngK != null && this.ngK.dLB() != null && this.ngK.dLB().isShowing()) {
                g.dismissPopupWindow(this.ngK.dLB(), getPageContext().getPageActivity());
                return true;
            }
            dLp();
            if (this.ngN) {
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
        if (this.ngK != null) {
            this.ngK.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ngK = new c(this);
        this.ngK.ah(this.ngW);
        this.ngK.ai(this.ngX);
        this.ngK.b(this.hxA);
        this.ngK.aj(this.ngY);
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
        this.fGa.a(this.ngU);
        this.fGa.a(this.ngT);
        this.ngL = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.ngK != null) {
                            WriteShareActivity.this.ngK.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ngK.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ngK.a((PostPrefixData) null);
            }
        });
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dLp();
            }
        };
        this.ngI = new WriteData();
        this.ngI.setType(3);
        if (bundle != null) {
            this.ngI.setForumName(bundle.getString("forum_name"));
            this.ngI.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.ngI.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.ngI.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.ngI.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.ngI.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.ngI.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.ngI.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.ngI.setForumName(this.ngF);
            this.ngI.setShareSummaryTitle(this.mShareTitle);
            this.ngI.setShareSummaryContent(this.mShareContent);
            this.ngI.setShareApiKey(this.mAppKey);
            this.ngI.setShareAppName(this.mAppName);
            this.ngI.setShareSignKey(this.ngG);
            this.ngI.setShareReferUrl(this.ngE);
            boolean isLocalImagePath = n.isLocalImagePath(this.eVX);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fGa.d(this.mShareLocalImageData, this.eVX);
                this.ngI.setShareLocalImageUri(this.eVX);
                this.ngI.setShareLocalImageData(this.mShareLocalImageData);
                this.fGa.cBA();
                this.ngI.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.ngI.setShareSummaryImg(this.eVX);
                this.ngI.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.ngI.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.ngI.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.ngI.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.ngI.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.ngI.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.ngI.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.ngI.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.ngI.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.ngI.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.ngI.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.ngI.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.ngI.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.ngI.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.ngI.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.ngI.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.ngI.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ngI.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.ngK != null && this.ngK.dLA() != null && (obj = this.ngK.dLA().getEditableText().toString()) != null) {
            this.ngK.dLA().setText(TbFaceManager.bGo().aE(getPageContext().getContext(), obj));
            this.ngK.dLA().setSelection(this.ngK.dLA().getText().length());
        }
    }

    public void Ku(int i) {
        this.ngJ = i;
    }

    public int dLr() {
        return this.ngJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLs() {
        dLp();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.ngJ != this.mPrefixData.getPrefixs().size() - 1) {
            this.ngI.setTitle(this.ngK.dLE().getText().toString() + this.ngK.dLz().getText().toString());
        } else {
            this.ngI.setTitle(this.ngK.dLz().getText().toString());
        }
        this.ngI.setContent(this.ngK.dLA().getText().toString());
        this.fGa.f(this.ngI);
        this.ngI.setVcode(null);
        this.fGa.dco().setVoice(null);
        this.fGa.dco().setVoiceDuringTime(-1);
        if (this.fGa.dQB()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iVZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.ngM = false;
            if (i2 == -1) {
                dLn();
                if (this.ngO != null) {
                    this.ngN = true;
                    this.ngO.dLi();
                }
                setResult(-1);
                return;
            }
            dLo();
            if (this.ngP != null) {
                this.ngN = false;
                this.ngP.dLi();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.ngF = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.ngI.setForumName(this.ngF);
                    dLm();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dLl();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.ngK.dLz());
        HidenSoftKeyPad(this.mInputManager, this.ngK.dLA());
        super.onPause();
    }

    public void dLt() {
        HidenSoftKeyPad(this.mInputManager, this.ngK.dLz());
        HidenSoftKeyPad(this.mInputManager, this.ngK.dLA());
    }
}
