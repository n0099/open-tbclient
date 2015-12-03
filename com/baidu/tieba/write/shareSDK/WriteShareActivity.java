package com.baidu.tieba.write.shareSDK;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a asz;
    private String cfP;
    private String dMP;
    private String dMQ;
    private String dMR;
    private String dMS;
    private PackageManager dMT;
    private PackageInfo dMU;
    private int dMV;
    private o dMW;
    com.baidu.tieba.write.shareSDK.a dMX;
    private com.baidu.tieba.write.view.e dNa;
    private com.baidu.tieba.write.view.e dNb;
    private String dwA;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData dBW = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cKN = null;
    private boolean dMY = false;
    private boolean dMZ = false;
    private e.b dNc = new c(this);
    private e.b dNd = new g(this);
    private e.b dNe = new h(this);
    private final a.b dNf = new i(this);
    private final a.c dNg = new j(this);
    private DialogInterface.OnKeyListener dNh = new k(this);
    private View.OnClickListener dNi = new l(this);
    private View.OnClickListener dNj = new m(this);
    private View.OnClickListener dNk = new n(this);
    private final View.OnFocusChangeListener dNl = new d(this);

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
        this.dMT = getPageContext().getPageActivity().getPackageManager();
        aId();
        boolean aIe = aIe();
        initData(bundle);
        initUI();
        if (!aIe) {
            if (TextUtils.isEmpty(this.dwA)) {
                nq(n.i.share_parameter_invalid_tip);
            } else {
                nq(n.i.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aIg();
        } else {
            aIf();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aId() {
        this.packageName = getCallingPackage();
        if (this.dMT != null && this.packageName != null) {
            try {
                this.dMU = this.dMT.getPackageInfo(this.packageName, 64);
                if (this.dMU != null) {
                    if (this.dMU.applicationInfo != null && this.dMU.applicationInfo.loadLabel(this.dMT) != null) {
                        this.cfP = this.dMU.applicationInfo.loadLabel(this.dMT).toString();
                    }
                    if (this.dMU.signatures != null && this.dMU.signatures.length > 0 && this.dMU.signatures[0] != null) {
                        this.dMS = az.P(this.dMU.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.cfP = null;
                this.dMS = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.dMP = extras.getString("ShareUrl");
            this.dMQ = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.dMR = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.cfP)) {
                this.cfP = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.dMS)) {
                this.dMS = extras.getString("appSign");
            }
            this.dwA = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aIe() {
        return (TextUtils.isEmpty(this.dwA) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dMQ) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aIf() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aIg() {
        if (TextUtils.isEmpty(this.dMR)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aIh();
        }
    }

    private void aIh() {
        this.dMW.aIp();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.dMX.nq(this.dBW.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIi() {
        if (this.dNa == null) {
            this.dNa = new com.baidu.tieba.write.view.e(getActivity());
            this.dNa.hG(false);
            this.dNa.nt(n.e.icon_send_ok);
            this.dNa.nw(n.i.share_alert_success);
            this.dNa.a(n.i.share_stay_in_tieba, this.dNc);
            this.dNa.b(n.i.back, this.dNe);
            this.dNa.a(this.dNh);
            this.dNa.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIj() {
        if (this.dNb == null) {
            this.dNb = new com.baidu.tieba.write.view.e(getActivity());
            this.dNb.nt(n.e.icon_send_error);
            this.dNb.nu(n.e.btn_w_square);
            this.dNb.nv(n.c.dialog_bdalert_title);
            this.dNb.nw(n.i.share_alert_fail);
            this.dNb.a(n.i.share_keep_sending, this.dNd);
            this.dNb.b(n.i.back, this.dNe);
            this.dNb.a(this.dNh);
            this.dNb.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIk() {
        if (this.asz != null) {
            this.asz.cancelLoadData();
        }
    }

    protected void aIl() {
        if (this.asz != null) {
            this.asz.aEo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aIk();
        aIl();
        Ha();
        super.onDestroy();
    }

    private void Ha() {
        ShareSDKImageView aIz;
        if (this.dMW != null && (aIz = this.dMW.aIz()) != null) {
            aIz.setImageBitmap(null);
        }
    }

    public WriteData aEl() {
        return this.dBW;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dMW != null && this.dMW.aIv() != null && this.dMW.aIv().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.dMW.aIv(), getPageContext().getPageActivity());
                return true;
            }
            aIk();
            if (this.dMZ) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMW != null) {
            this.dMW.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(n.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dMW = new o(this);
        this.dMW.O(this.dNi);
        this.dMW.P(this.dNj);
        this.dMW.a(this.dNl);
        this.dMW.Q(this.dNk);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
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
                com.baidu.tbadk.core.c.b.b(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void nq(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.asz = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.asz.a(this.dNg);
        this.asz.a(this.dNf);
        this.dMX = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cKN = new f(this);
        this.dBW = new WriteData();
        this.dBW.setType(3);
        if (bundle != null) {
            this.dBW.setForumName(bundle.getString("forum_name"));
            this.dBW.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.dBW.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.dBW.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.dBW.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.dBW.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.dBW.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.dBW.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.dBW.setForumName(this.dMR);
            this.dBW.setShareSummaryTitle(this.mShareTitle);
            this.dBW.setShareSummaryContent(this.mShareContent);
            this.dBW.setShareApiKey(this.dwA);
            this.dBW.setShareAppName(this.cfP);
            this.dBW.setShareSignKey(this.dMS);
            this.dBW.setShareReferUrl(this.dMP);
            boolean dc = com.baidu.tbadk.core.util.n.dc(this.dMQ);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dc) {
                this.asz.d(this.mShareLocalImageData, this.dMQ);
                this.dBW.setShareLocalImageUri(this.dMQ);
                this.dBW.setShareLocalImageData(this.mShareLocalImageData);
                this.asz.Lo();
                this.dBW.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.dBW.setShareSummaryImg(this.dMQ);
                this.dBW.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.dBW.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.dBW.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.dBW.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.dBW.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.dBW.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.dBW.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.dBW.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.dBW.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.dBW.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.dBW.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.dBW.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.dBW.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.dBW.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.dBW.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.dBW.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.dBW.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dBW.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.dMW != null && this.dMW.asU() != null && (editable = this.dMW.asU().getEditableText().toString()) != null) {
            this.dMW.asU().setText(TbFaceManager.CW().G(getPageContext().getContext(), editable));
            this.dMW.asU().setSelection(this.dMW.asU().getText().length());
        }
    }

    public void nr(int i) {
        this.dMV = i;
    }

    public int aIm() {
        return this.dMV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIn() {
        aIk();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dMV != this.mPrefixData.getPrefixs().size() - 1) {
            this.dBW.setTitle(String.valueOf(this.dMW.aIy().getText().toString()) + this.dMW.aIu().getText().toString());
        } else {
            this.dBW.setTitle(this.dMW.aIu().getText().toString());
        }
        this.dBW.setContent(this.dMW.asU().getText().toString());
        this.asz.c(this.dBW);
        this.dBW.setVcode(null);
        this.asz.aEl().setVoice(null);
        this.asz.aEl().setVoiceDuringTime(-1);
        if (this.asz.aEm()) {
            showLoadingDialog(getPageContext().getString(n.i.sending), this.cKN);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.dMY = false;
            if (i2 == -1) {
                aIi();
                if (this.dNa != null) {
                    this.dMZ = true;
                    this.dNa.aIC();
                }
                setResult(-1);
                return;
            }
            aIj();
            if (this.dNb != null) {
                this.dMZ = false;
                this.dNb.aIC();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.dMR = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.dBW.setForumName(this.dMR);
                    aIh();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aIg();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.dMW.aIu());
        HidenSoftKeyPad(this.mInputManager, this.dMW.asU());
        super.onPause();
    }

    public void aIo() {
        HidenSoftKeyPad(this.mInputManager, this.dMW.aIu());
        HidenSoftKeyPad(this.mInputManager, this.dMW.asU());
    }
}
