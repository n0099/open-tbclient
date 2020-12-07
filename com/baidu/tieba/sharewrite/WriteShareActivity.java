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
    private String naY;
    private String naZ;
    private String nba;
    private PackageInfo nbb;
    private int nbd;
    private c nbe;
    b nbf;
    private com.baidu.tieba.sharewrite.a nbi;
    private com.baidu.tieba.sharewrite.a nbj;
    private String packageName;
    private WriteData nbc = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iJM = null;
    private boolean nbg = false;
    private boolean nbh = false;
    private a.b nbk = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.nbc.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b nbl = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLH());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLI());
            WriteShareActivity.this.dLA();
            aVar.dismiss();
        }
    };
    private a.b nbm = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nbh) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b nbn = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.nbc.setShareSummaryImg("");
                WriteShareActivity.this.nbc.setShareSummaryImgHeight(0);
                WriteShareActivity.this.nbc.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.nbc.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.nbc.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.nbc.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c nbo = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dLv();
                if (WriteShareActivity.this.nbi != null) {
                    WriteShareActivity.this.nbh = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nbi.dLq();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dLw();
                if (WriteShareActivity.this.nbj != null) {
                    WriteShareActivity.this.nbh = false;
                    WriteShareActivity.this.nbj.dLq();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bxM());
                WriteShareActivity.this.nbg = true;
                if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener nbp = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.nbe != null && WriteShareActivity.this.nbe.dLJ() != null && WriteShareActivity.this.nbe.dLJ().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.nbe.dLJ(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dLx();
                if (WriteShareActivity.this.nbh) {
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
    private View.OnClickListener nbq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dLx();
            if (WriteShareActivity.this.nbh) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener nbr = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLH());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLI());
            WriteShareActivity.this.dLA();
        }
    };
    private View.OnClickListener nbs = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.nbe.dLI().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLI());
        }
    };
    private final View.OnFocusChangeListener hlD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.nbe != null) {
                if (view == WriteShareActivity.this.nbe.dLH() || view == WriteShareActivity.this.nbe.dLK() || view == WriteShareActivity.this.nbe.dLL()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLH());
                    } else if (view == WriteShareActivity.this.nbe.dLH() && WriteShareActivity.this.nbe.dLM() != null) {
                        WriteShareActivity.this.nbe.dLM().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.nbe.dLI()) {
                    if (z) {
                        WriteShareActivity.this.nbe.dLI().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.nbe.dLI().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nbe.dLH());
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
        cml();
        boolean dLs = dLs();
        initData(bundle);
        initUI();
        if (!dLs) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Ky(R.string.share_parameter_invalid_tip);
            } else {
                Ky(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dLt();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cml() {
        this.packageName = getCallingPackage();
        if (this.dCh != null && this.packageName != null) {
            try {
                this.nbb = this.dCh.getPackageInfo(this.packageName, 64);
                if (this.nbb != null) {
                    if (this.nbb.applicationInfo != null && this.nbb.applicationInfo.loadLabel(this.dCh) != null) {
                        this.mAppName = this.nbb.applicationInfo.loadLabel(this.dCh).toString();
                    }
                    if (this.nbb.signatures != null && this.nbb.signatures.length > 0 && this.nbb.signatures[0] != null) {
                        this.nba = aw.getAPKHexMD5(this.nbb.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nba = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.naY = extras.getString("ShareUrl");
            this.eMd = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.naZ = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nba)) {
                this.nba = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dLs() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eMd) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dLt() {
        if (TextUtils.isEmpty(this.naZ)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dLu();
        }
    }

    private void dLu() {
        this.nbe.dLC();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nbf.Tb(this.nbc.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLv() {
        if (this.nbi == null) {
            this.nbi = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nbi.xI(false);
            this.nbi.Ku(R.drawable.icon_send_ok);
            this.nbi.Kx(R.string.share_alert_success);
            this.nbi.a(R.string.share_stay_in_tieba, this.nbk);
            this.nbi.b(R.string.back, this.nbm);
            this.nbi.b(this.nbp);
            this.nbi.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLw() {
        if (this.nbj == null) {
            this.nbj = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nbj.Ku(R.drawable.icon_send_error);
            this.nbj.Kv(R.drawable.btn_w_square);
            this.nbj.Kw(R.color.common_color_10039);
            this.nbj.Kx(R.string.share_alert_fail);
            this.nbj.a(R.string.share_keep_sending, this.nbl);
            this.nbj.b(R.string.back, this.nbm);
            this.nbj.b(this.nbp);
            this.nbj.g(getPageContext());
        }
    }

    protected void dLx() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
    }

    protected void dLy() {
        if (this.fwu != null) {
            this.fwu.dQF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dLx();
        dLy();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dLN;
        if (this.nbe != null && (dLN = this.nbe.dLN()) != null) {
            dLN.setImageBitmap(null);
        }
    }

    public WriteData dcD() {
        return this.nbc;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nbe != null && this.nbe.dLJ() != null && this.nbe.dLJ().isShowing()) {
                g.dismissPopupWindow(this.nbe.dLJ(), getPageContext().getPageActivity());
                return true;
            }
            dLx();
            if (this.nbh) {
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
        if (this.nbe != null) {
            this.nbe.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nbe = new c(this);
        this.nbe.af(this.nbq);
        this.nbe.ag(this.nbr);
        this.nbe.b(this.hlD);
        this.nbe.ah(this.nbs);
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
        this.fwu.a(this.nbo);
        this.fwu.a(this.nbn);
        this.nbf = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.nbe != null) {
                            WriteShareActivity.this.nbe.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nbe.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nbe.a((PostPrefixData) null);
            }
        });
        this.iJM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dLx();
            }
        };
        this.nbc = new WriteData();
        this.nbc.setType(3);
        if (bundle != null) {
            this.nbc.setForumName(bundle.getString("forum_name"));
            this.nbc.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.nbc.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.nbc.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.nbc.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.nbc.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.nbc.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.nbc.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.nbc.setForumName(this.naZ);
            this.nbc.setShareSummaryTitle(this.mShareTitle);
            this.nbc.setShareSummaryContent(this.mShareContent);
            this.nbc.setShareApiKey(this.mAppKey);
            this.nbc.setShareAppName(this.mAppName);
            this.nbc.setShareSignKey(this.nba);
            this.nbc.setShareReferUrl(this.naY);
            boolean isLocalImagePath = n.isLocalImagePath(this.eMd);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fwu.d(this.mShareLocalImageData, this.eMd);
                this.nbc.setShareLocalImageUri(this.eMd);
                this.nbc.setShareLocalImageData(this.mShareLocalImageData);
                this.fwu.cyG();
                this.nbc.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.nbc.setShareSummaryImg(this.eMd);
                this.nbc.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.nbc.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.nbc.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.nbc.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.nbc.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.nbc.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.nbc.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.nbc.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.nbc.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.nbc.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.nbc.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.nbc.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.nbc.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.nbc.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.nbc.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.nbc.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.nbc.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.nbc.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.nbe != null && this.nbe.dLI() != null && (obj = this.nbe.dLI().getEditableText().toString()) != null) {
            this.nbe.dLI().setText(TbFaceManager.bDU().aw(getPageContext().getContext(), obj));
            this.nbe.dLI().setSelection(this.nbe.dLI().getText().length());
        }
    }

    public void Kz(int i) {
        this.nbd = i;
    }

    public int dLz() {
        return this.nbd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLA() {
        dLx();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.nbd != this.mPrefixData.getPrefixs().size() - 1) {
            this.nbc.setTitle(this.nbe.dLM().getText().toString() + this.nbe.dLH().getText().toString());
        } else {
            this.nbc.setTitle(this.nbe.dLH().getText().toString());
        }
        this.nbc.setContent(this.nbe.dLI().getText().toString());
        this.fwu.e(this.nbc);
        this.nbc.setVcode(null);
        this.fwu.dcD().setVoice(null);
        this.fwu.dcD().setVoiceDuringTime(-1);
        if (this.fwu.dQD()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iJM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.nbg = false;
            if (i2 == -1) {
                dLv();
                if (this.nbi != null) {
                    this.nbh = true;
                    this.nbi.dLq();
                }
                setResult(-1);
                return;
            }
            dLw();
            if (this.nbj != null) {
                this.nbh = false;
                this.nbj.dLq();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.naZ = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.nbc.setForumName(this.naZ);
                    dLu();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dLt();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.nbe.dLH());
        HidenSoftKeyPad(this.mInputManager, this.nbe.dLI());
        super.onPause();
    }

    public void dLB() {
        HidenSoftKeyPad(this.mInputManager, this.nbe.dLH());
        HidenSoftKeyPad(this.mInputManager, this.nbe.dLI());
    }
}
