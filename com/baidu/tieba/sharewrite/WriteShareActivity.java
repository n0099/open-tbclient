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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cUl;
    private NewWriteModel eMt;
    private String eee;
    private com.baidu.tieba.sharewrite.a lUB;
    private com.baidu.tieba.sharewrite.a lUC;
    private String lUr;
    private String lUs;
    private String lUt;
    private PackageInfo lUu;
    private int lUw;
    private c lUx;
    b lUy;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lUv = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hJK = null;
    private boolean lUz = false;
    private boolean lUA = false;
    private a.b lUD = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lUv.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lUE = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dto());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dtp());
            WriteShareActivity.this.dth();
            aVar.dismiss();
        }
    };
    private a.b lUF = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lUA) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lUG = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lUv.setShareSummaryImg("");
                WriteShareActivity.this.lUv.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lUv.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lUv.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lUv.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lUv.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lUH = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ag agVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dtc();
                if (WriteShareActivity.this.lUB != null) {
                    WriteShareActivity.this.lUA = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lUB.dsX();
                }
            } else if (agVar == null || writeData == null || agVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dtd();
                if (WriteShareActivity.this.lUC != null) {
                    WriteShareActivity.this.lUA = false;
                    WriteShareActivity.this.lUC.dsX();
                }
            } else {
                writeData.setVcodeMD5(agVar.getVcode_md5());
                writeData.setVcodeUrl(agVar.getVcode_pic_url());
                writeData.setVcodeExtra(agVar.bmZ());
                WriteShareActivity.this.lUz = true;
                if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lUI = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lUx != null && WriteShareActivity.this.lUx.dtq() != null && WriteShareActivity.this.lUx.dtq().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lUx.dtq(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dte();
                if (WriteShareActivity.this.lUA) {
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
    private View.OnClickListener lUJ = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dte();
            if (WriteShareActivity.this.lUA) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lUK = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dto());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dtp());
            WriteShareActivity.this.dth();
        }
    };
    private View.OnClickListener lUL = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lUx.dtp().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dtp());
        }
    };
    private final View.OnFocusChangeListener gsF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lUx != null) {
                if (view == WriteShareActivity.this.lUx.dto() || view == WriteShareActivity.this.lUx.dtr() || view == WriteShareActivity.this.lUx.dts()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dto());
                    } else if (view == WriteShareActivity.this.lUx.dto() && WriteShareActivity.this.lUx.dtt() != null) {
                        WriteShareActivity.this.lUx.dtt().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lUx.dtp()) {
                    if (z) {
                        WriteShareActivity.this.lUx.dtp().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lUx.dtp().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUx.dto());
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
        this.cUl = getPageContext().getPageActivity().getPackageManager();
        bYa();
        boolean dsZ = dsZ();
        initData(bundle);
        initUI();
        if (!dsZ) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Hq(R.string.share_parameter_invalid_tip);
            } else {
                Hq(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dta();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bYa() {
        this.packageName = getCallingPackage();
        if (this.cUl != null && this.packageName != null) {
            try {
                this.lUu = this.cUl.getPackageInfo(this.packageName, 64);
                if (this.lUu != null) {
                    if (this.lUu.applicationInfo != null && this.lUu.applicationInfo.loadLabel(this.cUl) != null) {
                        this.mAppName = this.lUu.applicationInfo.loadLabel(this.cUl).toString();
                    }
                    if (this.lUu.signatures != null && this.lUu.signatures.length > 0 && this.lUu.signatures[0] != null) {
                        this.lUt = av.getAPKHexMD5(this.lUu.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lUt = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lUr = extras.getString("ShareUrl");
            this.eee = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lUs = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lUt)) {
                this.lUt = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dsZ() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eee) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dta() {
        if (TextUtils.isEmpty(this.lUs)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dtb();
        }
    }

    private void dtb() {
        this.lUx.dtj();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lUy.Qi(this.lUv.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtc() {
        if (this.lUB == null) {
            this.lUB = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lUB.vL(false);
            this.lUB.Hm(R.drawable.icon_send_ok);
            this.lUB.Hp(R.string.share_alert_success);
            this.lUB.a(R.string.share_stay_in_tieba, this.lUD);
            this.lUB.b(R.string.back, this.lUF);
            this.lUB.a(this.lUI);
            this.lUB.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtd() {
        if (this.lUC == null) {
            this.lUC = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lUC.Hm(R.drawable.icon_send_error);
            this.lUC.Hn(R.drawable.btn_w_square);
            this.lUC.Ho(R.color.common_color_10039);
            this.lUC.Hp(R.string.share_alert_fail);
            this.lUC.a(R.string.share_keep_sending, this.lUE);
            this.lUC.b(R.string.back, this.lUF);
            this.lUC.a(this.lUI);
            this.lUC.g(getPageContext());
        }
    }

    protected void dte() {
        if (this.eMt != null) {
            this.eMt.cancelLoadData();
        }
    }

    protected void dtf() {
        if (this.eMt != null) {
            this.eMt.dxZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dte();
        dtf();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dtu;
        if (this.lUx != null && (dtu = this.lUx.dtu()) != null) {
            dtu.setImageBitmap(null);
        }
    }

    public WriteData cLa() {
        return this.lUv;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lUx != null && this.lUx.dtq() != null && this.lUx.dtq().isShowing()) {
                g.dismissPopupWindow(this.lUx.dtq(), getPageContext().getPageActivity());
                return true;
            }
            dte();
            if (this.lUA) {
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
        if (this.lUx != null) {
            this.lUx.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lUx = new c(this);
        this.lUx.ae(this.lUJ);
        this.lUx.af(this.lUK);
        this.lUx.b(this.gsF);
        this.lUx.ag(this.lUL);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
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

    public void Hq(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.eMt = new NewWriteModel(this);
        this.eMt.a(this.lUH);
        this.eMt.a(this.lUG);
        this.lUy = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lUx != null) {
                            WriteShareActivity.this.lUx.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lUx.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lUx.a((PostPrefixData) null);
            }
        });
        this.hJK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dte();
            }
        };
        this.lUv = new WriteData();
        this.lUv.setType(3);
        if (bundle != null) {
            this.lUv.setForumName(bundle.getString("forum_name"));
            this.lUv.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lUv.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lUv.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lUv.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lUv.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lUv.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lUv.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lUv.setForumName(this.lUs);
            this.lUv.setShareSummaryTitle(this.mShareTitle);
            this.lUv.setShareSummaryContent(this.mShareContent);
            this.lUv.setShareApiKey(this.mAppKey);
            this.lUv.setShareAppName(this.mAppName);
            this.lUv.setShareSignKey(this.lUt);
            this.lUv.setShareReferUrl(this.lUr);
            boolean isLocalImagePath = n.isLocalImagePath(this.eee);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.eMt.d(this.mShareLocalImageData, this.eee);
                this.lUv.setShareLocalImageUri(this.eee);
                this.lUv.setShareLocalImageData(this.mShareLocalImageData);
                this.eMt.civ();
                this.lUv.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lUv.setShareSummaryImg(this.eee);
                this.lUv.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lUv.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lUv.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lUv.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lUv.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lUv.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lUv.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lUv.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lUv.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lUv.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lUv.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lUv.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lUv.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lUv.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lUv.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lUv.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lUv.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lUv.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lUx != null && this.lUx.dtp() != null && (obj = this.lUx.dtp().getEditableText().toString()) != null) {
            this.lUx.dtp().setText(TbFaceManager.bsW().ap(getPageContext().getContext(), obj));
            this.lUx.dtp().setSelection(this.lUx.dtp().getText().length());
        }
    }

    public void Hr(int i) {
        this.lUw = i;
    }

    public int dtg() {
        return this.lUw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dth() {
        dte();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lUw != this.mPrefixData.getPrefixs().size() - 1) {
            this.lUv.setTitle(this.lUx.dtt().getText().toString() + this.lUx.dto().getText().toString());
        } else {
            this.lUv.setTitle(this.lUx.dto().getText().toString());
        }
        this.lUv.setContent(this.lUx.dtp().getText().toString());
        this.eMt.d(this.lUv);
        this.lUv.setVcode(null);
        this.eMt.cLa().setVoice(null);
        this.eMt.cLa().setVoiceDuringTime(-1);
        if (this.eMt.dxX()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hJK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lUz = false;
            if (i2 == -1) {
                dtc();
                if (this.lUB != null) {
                    this.lUA = true;
                    this.lUB.dsX();
                }
                setResult(-1);
                return;
            }
            dtd();
            if (this.lUC != null) {
                this.lUA = false;
                this.lUC.dsX();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lUs = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lUv.setForumName(this.lUs);
                    dtb();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dta();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lUx.dto());
        HidenSoftKeyPad(this.mInputManager, this.lUx.dtp());
        super.onPause();
    }

    public void dti() {
        HidenSoftKeyPad(this.mInputManager, this.lUx.dto());
        HidenSoftKeyPad(this.mInputManager, this.lUx.dtp());
    }
}
