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
/* loaded from: classes7.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dGa;
    private String eRm;
    private NewWriteModel fBs;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String nbY;
    private String nbZ;
    private String nca;
    private PackageInfo ncb;
    private int ncd;
    private c nce;
    b ncf;
    private com.baidu.tieba.sharewrite.a nci;
    private com.baidu.tieba.sharewrite.a ncj;
    private String packageName;
    private WriteData ncc = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iRs = null;
    private boolean ncg = false;
    private boolean nch = false;
    private a.b nck = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.ncc.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b ncl = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHI());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHJ());
            WriteShareActivity.this.dHB();
            aVar.dismiss();
        }
    };
    private a.b ncm = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nch) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b ncn = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.ncc.setShareSummaryImg("");
                WriteShareActivity.this.ncc.setShareSummaryImgHeight(0);
                WriteShareActivity.this.ncc.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.ncc.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.ncc.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.ncc.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c nco = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dHw();
                if (WriteShareActivity.this.nci != null) {
                    WriteShareActivity.this.nch = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nci.dHr();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dHx();
                if (WriteShareActivity.this.ncj != null) {
                    WriteShareActivity.this.nch = false;
                    WriteShareActivity.this.ncj.dHr();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bwn());
                WriteShareActivity.this.ncg = true;
                if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwm())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener ncp = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.nce != null && WriteShareActivity.this.nce.dHK() != null && WriteShareActivity.this.nce.dHK().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.nce.dHK(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dHy();
                if (WriteShareActivity.this.nch) {
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
    private View.OnClickListener ncq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dHy();
            if (WriteShareActivity.this.nch) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener ncr = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHI());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHJ());
            WriteShareActivity.this.dHB();
        }
    };
    private View.OnClickListener ncs = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.nce.dHJ().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHJ());
        }
    };
    private final View.OnFocusChangeListener hsU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.nce != null) {
                if (view == WriteShareActivity.this.nce.dHI() || view == WriteShareActivity.this.nce.dHL() || view == WriteShareActivity.this.nce.dHM()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHI());
                    } else if (view == WriteShareActivity.this.nce.dHI() && WriteShareActivity.this.nce.dHN() != null) {
                        WriteShareActivity.this.nce.dHN().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.nce.dHJ()) {
                    if (z) {
                        WriteShareActivity.this.nce.dHJ().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.nce.dHJ().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nce.dHI());
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
        this.dGa = getPageContext().getPageActivity().getPackageManager();
        clm();
        boolean dHt = dHt();
        initData(bundle);
        initUI();
        if (!dHt) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                IM(R.string.share_parameter_invalid_tip);
            } else {
                IM(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dHu();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void clm() {
        this.packageName = getCallingPackage();
        if (this.dGa != null && this.packageName != null) {
            try {
                this.ncb = this.dGa.getPackageInfo(this.packageName, 64);
                if (this.ncb != null) {
                    if (this.ncb.applicationInfo != null && this.ncb.applicationInfo.loadLabel(this.dGa) != null) {
                        this.mAppName = this.ncb.applicationInfo.loadLabel(this.dGa).toString();
                    }
                    if (this.ncb.signatures != null && this.ncb.signatures.length > 0 && this.ncb.signatures[0] != null) {
                        this.nca = av.getAPKHexMD5(this.ncb.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nca = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.nbY = extras.getString("ShareUrl");
            this.eRm = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.nbZ = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nca)) {
                this.nca = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dHt() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eRm) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dHu() {
        if (TextUtils.isEmpty(this.nbZ)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dHv();
        }
    }

    private void dHv() {
        this.nce.dHD();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ncf.RB(this.ncc.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHw() {
        if (this.nci == null) {
            this.nci = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nci.xG(false);
            this.nci.II(R.drawable.icon_send_ok);
            this.nci.IL(R.string.share_alert_success);
            this.nci.a(R.string.share_stay_in_tieba, this.nck);
            this.nci.b(R.string.back, this.ncm);
            this.nci.b(this.ncp);
            this.nci.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHx() {
        if (this.ncj == null) {
            this.ncj = new com.baidu.tieba.sharewrite.a(getActivity());
            this.ncj.II(R.drawable.icon_send_error);
            this.ncj.IJ(R.drawable.btn_w_square);
            this.ncj.IK(R.color.common_color_10039);
            this.ncj.IL(R.string.share_alert_fail);
            this.ncj.a(R.string.share_keep_sending, this.ncl);
            this.ncj.b(R.string.back, this.ncm);
            this.ncj.b(this.ncp);
            this.ncj.g(getPageContext());
        }
    }

    protected void dHy() {
        if (this.fBs != null) {
            this.fBs.cancelLoadData();
        }
    }

    protected void dHz() {
        if (this.fBs != null) {
            this.fBs.dNa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dHy();
        dHz();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dHO;
        if (this.nce != null && (dHO = this.nce.dHO()) != null) {
            dHO.setImageBitmap(null);
        }
    }

    public WriteData cYx() {
        return this.ncc;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nce != null && this.nce.dHK() != null && this.nce.dHK().isShowing()) {
                g.dismissPopupWindow(this.nce.dHK(), getPageContext().getPageActivity());
                return true;
            }
            dHy();
            if (this.nch) {
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
        if (this.nce != null) {
            this.nce.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nce = new c(this);
        this.nce.ah(this.ncq);
        this.nce.ai(this.ncr);
        this.nce.b(this.hsU);
        this.nce.aj(this.ncs);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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

    public void IM(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fBs = new NewWriteModel(this);
        this.fBs.a(this.nco);
        this.fBs.a(this.ncn);
        this.ncf = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.nce != null) {
                            WriteShareActivity.this.nce.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nce.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nce.a((PostPrefixData) null);
            }
        });
        this.iRs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dHy();
            }
        };
        this.ncc = new WriteData();
        this.ncc.setType(3);
        if (bundle != null) {
            this.ncc.setForumName(bundle.getString("forum_name"));
            this.ncc.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.ncc.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.ncc.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.ncc.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.ncc.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.ncc.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.ncc.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.ncc.setForumName(this.nbZ);
            this.ncc.setShareSummaryTitle(this.mShareTitle);
            this.ncc.setShareSummaryContent(this.mShareContent);
            this.ncc.setShareApiKey(this.mAppKey);
            this.ncc.setShareAppName(this.mAppName);
            this.ncc.setShareSignKey(this.nca);
            this.ncc.setShareReferUrl(this.nbY);
            boolean isLocalImagePath = n.isLocalImagePath(this.eRm);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fBs.d(this.mShareLocalImageData, this.eRm);
                this.ncc.setShareLocalImageUri(this.eRm);
                this.ncc.setShareLocalImageData(this.mShareLocalImageData);
                this.fBs.cxJ();
                this.ncc.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.ncc.setShareSummaryImg(this.eRm);
                this.ncc.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.ncc.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.ncc.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.ncc.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.ncc.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.ncc.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.ncc.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.ncc.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.ncc.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.ncc.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.ncc.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.ncc.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.ncc.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.ncc.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.ncc.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.ncc.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.ncc.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ncc.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.nce != null && this.nce.dHJ() != null && (obj = this.nce.dHJ().getEditableText().toString()) != null) {
            this.nce.dHJ().setText(TbFaceManager.bCw().aE(getPageContext().getContext(), obj));
            this.nce.dHJ().setSelection(this.nce.dHJ().getText().length());
        }
    }

    public void IN(int i) {
        this.ncd = i;
    }

    public int dHA() {
        return this.ncd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHB() {
        dHy();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.ncd != this.mPrefixData.getPrefixs().size() - 1) {
            this.ncc.setTitle(this.nce.dHN().getText().toString() + this.nce.dHI().getText().toString());
        } else {
            this.ncc.setTitle(this.nce.dHI().getText().toString());
        }
        this.ncc.setContent(this.nce.dHJ().getText().toString());
        this.fBs.f(this.ncc);
        this.ncc.setVcode(null);
        this.fBs.cYx().setVoice(null);
        this.fBs.cYx().setVoiceDuringTime(-1);
        if (this.fBs.dMK()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iRs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.ncg = false;
            if (i2 == -1) {
                dHw();
                if (this.nci != null) {
                    this.nch = true;
                    this.nci.dHr();
                }
                setResult(-1);
                return;
            }
            dHx();
            if (this.ncj != null) {
                this.nch = false;
                this.ncj.dHr();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.nbZ = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.ncc.setForumName(this.nbZ);
                    dHv();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dHu();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.nce.dHI());
        HidenSoftKeyPad(this.mInputManager, this.nce.dHJ());
        super.onPause();
    }

    public void dHC() {
        HidenSoftKeyPad(this.mInputManager, this.nce.dHI());
        HidenSoftKeyPad(this.mInputManager, this.nce.dHJ());
    }
}
