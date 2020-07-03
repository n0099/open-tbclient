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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cIb;
    private String dOt;
    private NewWriteModel evx;
    private String lve;
    private String lvf;
    private String lvg;
    private PackageInfo lvh;
    private int lvj;
    private c lvk;
    b lvl;
    private com.baidu.tieba.sharewrite.a lvo;
    private com.baidu.tieba.sharewrite.a lvp;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lvi = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hqD = null;
    private boolean lvm = false;
    private boolean lvn = false;
    private a.b lvq = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lvi.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lvr = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deE());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deF());
            WriteShareActivity.this.dex();
            aVar.dismiss();
        }
    };
    private a.b lvs = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lvn) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lvt = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lvi.setShareSummaryImg("");
                WriteShareActivity.this.lvi.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lvi.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lvi.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lvi.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lvi.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lvu = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ad adVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.der();
                if (WriteShareActivity.this.lvo != null) {
                    WriteShareActivity.this.lvn = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lvo.dem();
                }
            } else if (adVar == null || writeData == null || adVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.des();
                if (WriteShareActivity.this.lvp != null) {
                    WriteShareActivity.this.lvn = false;
                    WriteShareActivity.this.lvp.dem();
                }
            } else {
                writeData.setVcodeMD5(adVar.getVcode_md5());
                writeData.setVcodeUrl(adVar.getVcode_pic_url());
                writeData.setVcodeExtra(adVar.bas());
                WriteShareActivity.this.lvm = true;
                if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lvv = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lvk != null && WriteShareActivity.this.lvk.deG() != null && WriteShareActivity.this.lvk.deG().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lvk.deG(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.det();
                if (WriteShareActivity.this.lvn) {
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
    private View.OnClickListener lvw = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.det();
            if (WriteShareActivity.this.lvn) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lvx = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deE());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deF());
            WriteShareActivity.this.dex();
        }
    };
    private View.OnClickListener lvy = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lvk.deF().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deF());
        }
    };
    private final View.OnFocusChangeListener gbk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lvk != null) {
                if (view == WriteShareActivity.this.lvk.deE() || view == WriteShareActivity.this.lvk.deH() || view == WriteShareActivity.this.lvk.deI()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deE());
                    } else if (view == WriteShareActivity.this.lvk.deE() && WriteShareActivity.this.lvk.deJ() != null) {
                        WriteShareActivity.this.lvk.deJ().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lvk.deF()) {
                    if (z) {
                        WriteShareActivity.this.lvk.deF().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lvk.deF().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lvk.deE());
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
        this.cIb = getPageContext().getPageActivity().getPackageManager();
        bKP();
        boolean deo = deo();
        initData(bundle);
        initUI();
        if (!deo) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Ex(R.string.share_parameter_invalid_tip);
            } else {
                Ex(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dep();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bKP() {
        this.packageName = getCallingPackage();
        if (this.cIb != null && this.packageName != null) {
            try {
                this.lvh = this.cIb.getPackageInfo(this.packageName, 64);
                if (this.lvh != null) {
                    if (this.lvh.applicationInfo != null && this.lvh.applicationInfo.loadLabel(this.cIb) != null) {
                        this.mAppName = this.lvh.applicationInfo.loadLabel(this.cIb).toString();
                    }
                    if (this.lvh.signatures != null && this.lvh.signatures.length > 0 && this.lvh.signatures[0] != null) {
                        this.lvg = at.getAPKHexMD5(this.lvh.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lvg = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lve = extras.getString("ShareUrl");
            this.dOt = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lvf = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lvg)) {
                this.lvg = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean deo() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dOt) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void dep() {
        if (TextUtils.isEmpty(this.lvf)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            deq();
        }
    }

    private void deq() {
        this.lvk.dez();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lvl.MC(this.lvi.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void der() {
        if (this.lvo == null) {
            this.lvo = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lvo.uq(false);
            this.lvo.Et(R.drawable.icon_send_ok);
            this.lvo.Ew(R.string.share_alert_success);
            this.lvo.a(R.string.share_stay_in_tieba, this.lvq);
            this.lvo.b(R.string.back, this.lvs);
            this.lvo.a(this.lvv);
            this.lvo.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void des() {
        if (this.lvp == null) {
            this.lvp = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lvp.Et(R.drawable.icon_send_error);
            this.lvp.Eu(R.drawable.btn_w_square);
            this.lvp.Ev(R.color.common_color_10039);
            this.lvp.Ew(R.string.share_alert_fail);
            this.lvp.a(R.string.share_keep_sending, this.lvr);
            this.lvp.b(R.string.back, this.lvs);
            this.lvp.a(this.lvv);
            this.lvp.f(getPageContext());
        }
    }

    protected void det() {
        if (this.evx != null) {
            this.evx.cancelLoadData();
        }
    }

    protected void deu() {
        if (this.evx != null) {
            this.evx.djp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        det();
        deu();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView deK;
        if (this.lvk != null && (deK = this.lvk.deK()) != null) {
            deK.setImageBitmap(null);
        }
    }

    public WriteData dev() {
        return this.lvi;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lvk != null && this.lvk.deG() != null && this.lvk.deG().isShowing()) {
                g.dismissPopupWindow(this.lvk.deG(), getPageContext().getPageActivity());
                return true;
            }
            det();
            if (this.lvn) {
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
        if (this.lvk != null) {
            this.lvk.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lvk = new c(this);
        this.lvk.ac(this.lvw);
        this.lvk.ad(this.lvx);
        this.lvk.b(this.gbk);
        this.lvk.ae(this.lvy);
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

    public void Ex(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.evx = new NewWriteModel(this);
        this.evx.a(this.lvu);
        this.evx.a(this.lvt);
        this.lvl = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lvk != null) {
                            WriteShareActivity.this.lvk.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lvk.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lvk.a((PostPrefixData) null);
            }
        });
        this.hqD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.det();
            }
        };
        this.lvi = new WriteData();
        this.lvi.setType(3);
        if (bundle != null) {
            this.lvi.setForumName(bundle.getString("forum_name"));
            this.lvi.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lvi.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lvi.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lvi.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lvi.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lvi.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lvi.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lvi.setForumName(this.lvf);
            this.lvi.setShareSummaryTitle(this.mShareTitle);
            this.lvi.setShareSummaryContent(this.mShareContent);
            this.lvi.setShareApiKey(this.mAppKey);
            this.lvi.setShareAppName(this.mAppName);
            this.lvi.setShareSignKey(this.lvg);
            this.lvi.setShareReferUrl(this.lve);
            boolean isLocalImagePath = n.isLocalImagePath(this.dOt);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.evx.d(this.mShareLocalImageData, this.dOt);
                this.lvi.setShareLocalImageUri(this.dOt);
                this.lvi.setShareLocalImageData(this.mShareLocalImageData);
                this.evx.bUE();
                this.lvi.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lvi.setShareSummaryImg(this.dOt);
                this.lvi.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lvi.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lvi.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lvi.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lvi.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lvi.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lvi.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lvi.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lvi.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lvi.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lvi.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lvi.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lvi.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lvi.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lvi.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lvi.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lvi.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lvi.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lvk != null && this.lvk.deF() != null && (obj = this.lvk.deF().getEditableText().toString()) != null) {
            this.lvk.deF().setText(TbFaceManager.bgy().ak(getPageContext().getContext(), obj));
            this.lvk.deF().setSelection(this.lvk.deF().getText().length());
        }
    }

    public void Ey(int i) {
        this.lvj = i;
    }

    public int dew() {
        return this.lvj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dex() {
        det();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lvj != this.mPrefixData.getPrefixs().size() - 1) {
            this.lvi.setTitle(this.lvk.deJ().getText().toString() + this.lvk.deE().getText().toString());
        } else {
            this.lvi.setTitle(this.lvk.deE().getText().toString());
        }
        this.lvi.setContent(this.lvk.deF().getText().toString());
        this.evx.d(this.lvi);
        this.lvi.setVcode(null);
        this.evx.dev().setVoice(null);
        this.evx.dev().setVoiceDuringTime(-1);
        if (this.evx.djn()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hqD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lvm = false;
            if (i2 == -1) {
                der();
                if (this.lvo != null) {
                    this.lvn = true;
                    this.lvo.dem();
                }
                setResult(-1);
                return;
            }
            des();
            if (this.lvp != null) {
                this.lvn = false;
                this.lvp.dem();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lvf = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lvi.setForumName(this.lvf);
                    deq();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dep();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lvk.deE());
        HidenSoftKeyPad(this.mInputManager, this.lvk.deF());
        super.onPause();
    }

    public void dey() {
        HidenSoftKeyPad(this.mInputManager, this.lvk.deE());
        HidenSoftKeyPad(this.mInputManager, this.lvk.deF());
    }
}
