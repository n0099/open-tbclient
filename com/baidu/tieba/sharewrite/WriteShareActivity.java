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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.o;
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
    private PackageManager dIe;
    private String eTy;
    private NewWriteModel fDH;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String nmg;
    private String nmh;
    private String nmi;
    private PackageInfo nmj;
    private int nml;
    private c nmm;
    b nmn;
    private com.baidu.tieba.sharewrite.a nmq;
    private com.baidu.tieba.sharewrite.a nmr;
    private String packageName;
    private WriteData nmk = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iXn = null;
    private boolean nmo = false;
    private boolean nmp = false;
    private a.b nms = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.nmk.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b nmt = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKb());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKc());
            WriteShareActivity.this.dJU();
            aVar.dismiss();
        }
    };
    private a.b nmu = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nmp) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b nmv = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.nmk.setShareSummaryImg("");
                WriteShareActivity.this.nmk.setShareSummaryImgHeight(0);
                WriteShareActivity.this.nmk.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.nmk.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.nmk.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.nmk.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c nmw = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dJP();
                if (WriteShareActivity.this.nmq != null) {
                    WriteShareActivity.this.nmp = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nmq.dJK();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dJQ();
                if (WriteShareActivity.this.nmr != null) {
                    WriteShareActivity.this.nmp = false;
                    WriteShareActivity.this.nmr.dJK();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bwF());
                WriteShareActivity.this.nmo = true;
                if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener nmx = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.nmm != null && WriteShareActivity.this.nmm.dKd() != null && WriteShareActivity.this.nmm.dKd().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.nmm.dKd(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dJR();
                if (WriteShareActivity.this.nmp) {
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
    private View.OnClickListener nmy = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dJR();
            if (WriteShareActivity.this.nmp) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener nmz = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKb());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKc());
            WriteShareActivity.this.dJU();
        }
    };
    private View.OnClickListener nmA = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.nmm.dKc().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKc());
        }
    };
    private final View.OnFocusChangeListener hxs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.nmm != null) {
                if (view == WriteShareActivity.this.nmm.dKb() || view == WriteShareActivity.this.nmm.dKe() || view == WriteShareActivity.this.nmm.dKf()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKb());
                    } else if (view == WriteShareActivity.this.nmm.dKb() && WriteShareActivity.this.nmm.dKg() != null) {
                        WriteShareActivity.this.nmm.dKg().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.nmm.dKc()) {
                    if (z) {
                        WriteShareActivity.this.nmm.dKc().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.nmm.dKc().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nmm.dKb());
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
        this.dIe = getPageContext().getPageActivity().getPackageManager();
        cmr();
        boolean dJM = dJM();
        initData(bundle);
        initUI();
        if (!dJM) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Jg(R.string.share_parameter_invalid_tip);
            } else {
                Jg(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dJN();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cmr() {
        this.packageName = getCallingPackage();
        if (this.dIe != null && this.packageName != null) {
            try {
                this.nmj = this.dIe.getPackageInfo(this.packageName, 64);
                if (this.nmj != null) {
                    if (this.nmj.applicationInfo != null && this.nmj.applicationInfo.loadLabel(this.dIe) != null) {
                        this.mAppName = this.nmj.applicationInfo.loadLabel(this.dIe).toString();
                    }
                    if (this.nmj.signatures != null && this.nmj.signatures.length > 0 && this.nmj.signatures[0] != null) {
                        this.nmi = aw.getAPKHexMD5(this.nmj.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nmi = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.nmg = extras.getString("ShareUrl");
            this.eTy = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.nmh = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nmi)) {
                this.nmi = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dJM() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eTy) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dJN() {
        if (TextUtils.isEmpty(this.nmh)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dJO();
        }
    }

    private void dJO() {
        this.nmm.dJW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nmn.SL(this.nmk.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJP() {
        if (this.nmq == null) {
            this.nmq = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nmq.xZ(false);
            this.nmq.Jc(R.drawable.icon_send_ok);
            this.nmq.Jf(R.string.share_alert_success);
            this.nmq.a(R.string.share_stay_in_tieba, this.nms);
            this.nmq.b(R.string.back, this.nmu);
            this.nmq.b(this.nmx);
            this.nmq.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJQ() {
        if (this.nmr == null) {
            this.nmr = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nmr.Jc(R.drawable.icon_send_error);
            this.nmr.Jd(R.drawable.btn_w_square);
            this.nmr.Je(R.color.common_color_10039);
            this.nmr.Jf(R.string.share_alert_fail);
            this.nmr.a(R.string.share_keep_sending, this.nmt);
            this.nmr.b(R.string.back, this.nmu);
            this.nmr.b(this.nmx);
            this.nmr.g(getPageContext());
        }
    }

    protected void dJR() {
        if (this.fDH != null) {
            this.fDH.cancelLoadData();
        }
    }

    protected void dJS() {
        if (this.fDH != null) {
            this.fDH.dPt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dJR();
        dJS();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dKh;
        if (this.nmm != null && (dKh = this.nmm.dKh()) != null) {
            dKh.setImageBitmap(null);
        }
    }

    public WriteData daC() {
        return this.nmk;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nmm != null && this.nmm.dKd() != null && this.nmm.dKd().isShowing()) {
                g.dismissPopupWindow(this.nmm.dKd(), getPageContext().getPageActivity());
                return true;
            }
            dJR();
            if (this.nmp) {
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
        if (this.nmm != null) {
            this.nmm.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nmm = new c(this);
        this.nmm.ah(this.nmy);
        this.nmm.ai(this.nmz);
        this.nmm.b(this.hxs);
        this.nmm.aj(this.nmA);
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

    public void Jg(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fDH = new NewWriteModel(this);
        this.fDH.a(this.nmw);
        this.fDH.a(this.nmv);
        this.nmn = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.nmm != null) {
                            WriteShareActivity.this.nmm.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nmm.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nmm.a((PostPrefixData) null);
            }
        });
        this.iXn = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dJR();
            }
        };
        this.nmk = new WriteData();
        this.nmk.setType(3);
        if (bundle != null) {
            this.nmk.setForumName(bundle.getString("forum_name"));
            this.nmk.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.nmk.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.nmk.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.nmk.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.nmk.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.nmk.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.nmk.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.nmk.setForumName(this.nmh);
            this.nmk.setShareSummaryTitle(this.mShareTitle);
            this.nmk.setShareSummaryContent(this.mShareContent);
            this.nmk.setShareApiKey(this.mAppKey);
            this.nmk.setShareAppName(this.mAppName);
            this.nmk.setShareSignKey(this.nmi);
            this.nmk.setShareReferUrl(this.nmg);
            boolean isLocalImagePath = o.isLocalImagePath(this.eTy);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fDH.e(this.mShareLocalImageData, this.eTy);
                this.nmk.setShareLocalImageUri(this.eTy);
                this.nmk.setShareLocalImageData(this.mShareLocalImageData);
                this.fDH.czb();
                this.nmk.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.nmk.setShareSummaryImg(this.eTy);
                this.nmk.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.nmk.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.nmk.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.nmk.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.nmk.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.nmk.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.nmk.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.nmk.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.nmk.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.nmk.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.nmk.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.nmk.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.nmk.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.nmk.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.nmk.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.nmk.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.nmk.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.nmk.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.nmm != null && this.nmm.dKc() != null && (obj = this.nmm.dKc().getEditableText().toString()) != null) {
            this.nmm.dKc().setText(TbFaceManager.bCO().aD(getPageContext().getContext(), obj));
            this.nmm.dKc().setSelection(this.nmm.dKc().getText().length());
        }
    }

    public void Jh(int i) {
        this.nml = i;
    }

    public int dJT() {
        return this.nml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJU() {
        dJR();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.nml != this.mPrefixData.getPrefixs().size() - 1) {
            this.nmk.setTitle(this.nmm.dKg().getText().toString() + this.nmm.dKb().getText().toString());
        } else {
            this.nmk.setTitle(this.nmm.dKb().getText().toString());
        }
        this.nmk.setContent(this.nmm.dKc().getText().toString());
        this.fDH.f(this.nmk);
        this.nmk.setVcode(null);
        this.fDH.daC().setVoice(null);
        this.fDH.daC().setVoiceDuringTime(-1);
        if (this.fDH.dPd()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iXn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.nmo = false;
            if (i2 == -1) {
                dJP();
                if (this.nmq != null) {
                    this.nmp = true;
                    this.nmq.dJK();
                }
                setResult(-1);
                return;
            }
            dJQ();
            if (this.nmr != null) {
                this.nmp = false;
                this.nmr.dJK();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.nmh = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.nmk.setForumName(this.nmh);
                    dJO();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dJN();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.nmm.dKb());
        HidenSoftKeyPad(this.mInputManager, this.nmm.dKc());
        super.onPause();
    }

    public void dJV() {
        HidenSoftKeyPad(this.mInputManager, this.nmm.dKb());
        HidenSoftKeyPad(this.mInputManager, this.nmm.dKc());
    }
}
