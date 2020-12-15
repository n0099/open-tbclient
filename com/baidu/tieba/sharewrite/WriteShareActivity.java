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
/* loaded from: classes24.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dCh;
    private String eMd;
    private NewWriteModel fwu;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String nba;
    private String nbb;
    private String nbc;
    private PackageInfo nbd;
    private int nbf;
    private c nbg;
    b nbh;
    private com.baidu.tieba.sharewrite.a nbk;
    private com.baidu.tieba.sharewrite.a nbl;
    private String packageName;
    private WriteData nbe = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iJO = null;
    private boolean nbi = false;
    private boolean nbj = false;
    private a.b nbm = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.nbe.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b nbn = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLI());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLJ());
            WriteShareActivity.this.dLB();
            aVar.dismiss();
        }
    };
    private a.b nbo = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nbj) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b nbp = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.nbe.setShareSummaryImg("");
                WriteShareActivity.this.nbe.setShareSummaryImgHeight(0);
                WriteShareActivity.this.nbe.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.nbe.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.nbe.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.nbe.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c nbq = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dLw();
                if (WriteShareActivity.this.nbk != null) {
                    WriteShareActivity.this.nbj = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nbk.dLr();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dLx();
                if (WriteShareActivity.this.nbl != null) {
                    WriteShareActivity.this.nbj = false;
                    WriteShareActivity.this.nbl.dLr();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bxM());
                WriteShareActivity.this.nbi = true;
                if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener nbr = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.nbg != null && WriteShareActivity.this.nbg.dLK() != null && WriteShareActivity.this.nbg.dLK().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.nbg.dLK(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dLy();
                if (WriteShareActivity.this.nbj) {
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
    private View.OnClickListener nbs = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dLy();
            if (WriteShareActivity.this.nbj) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener nbt = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLI());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLJ());
            WriteShareActivity.this.dLB();
        }
    };
    private View.OnClickListener nbu = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.nbg.dLJ().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLJ());
        }
    };
    private final View.OnFocusChangeListener hlF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.nbg != null) {
                if (view == WriteShareActivity.this.nbg.dLI() || view == WriteShareActivity.this.nbg.dLL() || view == WriteShareActivity.this.nbg.dLM()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLI());
                    } else if (view == WriteShareActivity.this.nbg.dLI() && WriteShareActivity.this.nbg.dLN() != null) {
                        WriteShareActivity.this.nbg.dLN().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.nbg.dLJ()) {
                    if (z) {
                        WriteShareActivity.this.nbg.dLJ().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.nbg.dLJ().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbg.dLI());
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
        this.dCh = getPageContext().getPageActivity().getPackageManager();
        cmm();
        boolean dLt = dLt();
        initData(bundle);
        initUI();
        if (!dLt) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Ky(R.string.share_parameter_invalid_tip);
            } else {
                Ky(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dLu();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cmm() {
        this.packageName = getCallingPackage();
        if (this.dCh != null && this.packageName != null) {
            try {
                this.nbd = this.dCh.getPackageInfo(this.packageName, 64);
                if (this.nbd != null) {
                    if (this.nbd.applicationInfo != null && this.nbd.applicationInfo.loadLabel(this.dCh) != null) {
                        this.mAppName = this.nbd.applicationInfo.loadLabel(this.dCh).toString();
                    }
                    if (this.nbd.signatures != null && this.nbd.signatures.length > 0 && this.nbd.signatures[0] != null) {
                        this.nbc = aw.getAPKHexMD5(this.nbd.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nbc = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.nba = extras.getString("ShareUrl");
            this.eMd = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.nbb = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nbc)) {
                this.nbc = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dLt() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eMd) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dLu() {
        if (TextUtils.isEmpty(this.nbb)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dLv();
        }
    }

    private void dLv() {
        this.nbg.dLD();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nbh.Tb(this.nbe.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLw() {
        if (this.nbk == null) {
            this.nbk = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nbk.xI(false);
            this.nbk.Ku(R.drawable.icon_send_ok);
            this.nbk.Kx(R.string.share_alert_success);
            this.nbk.a(R.string.share_stay_in_tieba, this.nbm);
            this.nbk.b(R.string.back, this.nbo);
            this.nbk.b(this.nbr);
            this.nbk.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLx() {
        if (this.nbl == null) {
            this.nbl = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nbl.Ku(R.drawable.icon_send_error);
            this.nbl.Kv(R.drawable.btn_w_square);
            this.nbl.Kw(R.color.common_color_10039);
            this.nbl.Kx(R.string.share_alert_fail);
            this.nbl.a(R.string.share_keep_sending, this.nbn);
            this.nbl.b(R.string.back, this.nbo);
            this.nbl.b(this.nbr);
            this.nbl.g(getPageContext());
        }
    }

    protected void dLy() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
    }

    protected void dLz() {
        if (this.fwu != null) {
            this.fwu.dQG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dLy();
        dLz();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dLO;
        if (this.nbg != null && (dLO = this.nbg.dLO()) != null) {
            dLO.setImageBitmap(null);
        }
    }

    public WriteData dcE() {
        return this.nbe;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nbg != null && this.nbg.dLK() != null && this.nbg.dLK().isShowing()) {
                g.dismissPopupWindow(this.nbg.dLK(), getPageContext().getPageActivity());
                return true;
            }
            dLy();
            if (this.nbj) {
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
        if (this.nbg != null) {
            this.nbg.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nbg = new c(this);
        this.nbg.af(this.nbs);
        this.nbg.ag(this.nbt);
        this.nbg.b(this.hlF);
        this.nbg.ah(this.nbu);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
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

    public void Ky(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fwu = new NewWriteModel(this);
        this.fwu.a(this.nbq);
        this.fwu.a(this.nbp);
        this.nbh = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.nbg != null) {
                            WriteShareActivity.this.nbg.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nbg.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nbg.a((PostPrefixData) null);
            }
        });
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dLy();
            }
        };
        this.nbe = new WriteData();
        this.nbe.setType(3);
        if (bundle != null) {
            this.nbe.setForumName(bundle.getString("forum_name"));
            this.nbe.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.nbe.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.nbe.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.nbe.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.nbe.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.nbe.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.nbe.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.nbe.setForumName(this.nbb);
            this.nbe.setShareSummaryTitle(this.mShareTitle);
            this.nbe.setShareSummaryContent(this.mShareContent);
            this.nbe.setShareApiKey(this.mAppKey);
            this.nbe.setShareAppName(this.mAppName);
            this.nbe.setShareSignKey(this.nbc);
            this.nbe.setShareReferUrl(this.nba);
            boolean isLocalImagePath = n.isLocalImagePath(this.eMd);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fwu.d(this.mShareLocalImageData, this.eMd);
                this.nbe.setShareLocalImageUri(this.eMd);
                this.nbe.setShareLocalImageData(this.mShareLocalImageData);
                this.fwu.cyH();
                this.nbe.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.nbe.setShareSummaryImg(this.eMd);
                this.nbe.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.nbe.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.nbe.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.nbe.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.nbe.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.nbe.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.nbe.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.nbe.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.nbe.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.nbe.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.nbe.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.nbe.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.nbe.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.nbe.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.nbe.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.nbe.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.nbe.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.nbe.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.nbg != null && this.nbg.dLJ() != null && (obj = this.nbg.dLJ().getEditableText().toString()) != null) {
            this.nbg.dLJ().setText(TbFaceManager.bDU().aw(getPageContext().getContext(), obj));
            this.nbg.dLJ().setSelection(this.nbg.dLJ().getText().length());
        }
    }

    public void Kz(int i) {
        this.nbf = i;
    }

    public int dLA() {
        return this.nbf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLB() {
        dLy();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.nbf != this.mPrefixData.getPrefixs().size() - 1) {
            this.nbe.setTitle(this.nbg.dLN().getText().toString() + this.nbg.dLI().getText().toString());
        } else {
            this.nbe.setTitle(this.nbg.dLI().getText().toString());
        }
        this.nbe.setContent(this.nbg.dLJ().getText().toString());
        this.fwu.e(this.nbe);
        this.nbe.setVcode(null);
        this.fwu.dcE().setVoice(null);
        this.fwu.dcE().setVoiceDuringTime(-1);
        if (this.fwu.dQE()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iJO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.nbi = false;
            if (i2 == -1) {
                dLw();
                if (this.nbk != null) {
                    this.nbj = true;
                    this.nbk.dLr();
                }
                setResult(-1);
                return;
            }
            dLx();
            if (this.nbl != null) {
                this.nbj = false;
                this.nbl.dLr();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.nbb = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.nbe.setForumName(this.nbb);
                    dLv();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dLu();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.nbg.dLI());
        HidenSoftKeyPad(this.mInputManager, this.nbg.dLJ());
        super.onPause();
    }

    public void dLC() {
        HidenSoftKeyPad(this.mInputManager, this.nbg.dLI());
        HidenSoftKeyPad(this.mInputManager, this.nbg.dLJ());
    }
}
