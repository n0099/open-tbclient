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
/* loaded from: classes24.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dwP;
    private String eGJ;
    private NewWriteModel fpI;
    private String mAppKey;
    private String mAppName;
    private String mMc;
    private String mMd;
    private String mMe;
    private PackageInfo mMf;
    private int mMh;
    private c mMi;
    b mMj;
    private com.baidu.tieba.sharewrite.a mMm;
    private com.baidu.tieba.sharewrite.a mMn;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mMg = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iyf = null;
    private boolean mMk = false;
    private boolean mMl = false;
    private a.b mMo = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mMg.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b mMp = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGC());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGD());
            WriteShareActivity.this.dGv();
            aVar.dismiss();
        }
    };
    private a.b mMq = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.mMl) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b mMr = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mMg.setShareSummaryImg("");
                WriteShareActivity.this.mMg.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mMg.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mMg.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mMg.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mMg.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c mMs = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dGq();
                if (WriteShareActivity.this.mMm != null) {
                    WriteShareActivity.this.mMl = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mMm.dGl();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dGr();
                if (WriteShareActivity.this.mMn != null) {
                    WriteShareActivity.this.mMl = false;
                    WriteShareActivity.this.mMn.dGl();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.buW());
                WriteShareActivity.this.mMk = true;
                if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener mMt = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.mMi != null && WriteShareActivity.this.mMi.dGE() != null && WriteShareActivity.this.mMi.dGE().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.mMi.dGE(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dGs();
                if (WriteShareActivity.this.mMl) {
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
    private View.OnClickListener mMu = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dGs();
            if (WriteShareActivity.this.mMl) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener mMv = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGC());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGD());
            WriteShareActivity.this.dGv();
        }
    };
    private View.OnClickListener mMw = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mMi.dGD().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGD());
        }
    };
    private final View.OnFocusChangeListener hcn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mMi != null) {
                if (view == WriteShareActivity.this.mMi.dGC() || view == WriteShareActivity.this.mMi.dGF() || view == WriteShareActivity.this.mMi.dGG()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGC());
                    } else if (view == WriteShareActivity.this.mMi.dGC() && WriteShareActivity.this.mMi.dGH() != null) {
                        WriteShareActivity.this.mMi.dGH().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.mMi.dGD()) {
                    if (z) {
                        WriteShareActivity.this.mMi.dGD().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.mMi.dGD().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mMi.dGC());
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
        this.dwP = getPageContext().getPageActivity().getPackageManager();
        ciY();
        boolean dGn = dGn();
        initData(bundle);
        initUI();
        if (!dGn) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Jf(R.string.share_parameter_invalid_tip);
            } else {
                Jf(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dGo();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void ciY() {
        this.packageName = getCallingPackage();
        if (this.dwP != null && this.packageName != null) {
            try {
                this.mMf = this.dwP.getPackageInfo(this.packageName, 64);
                if (this.mMf != null) {
                    if (this.mMf.applicationInfo != null && this.mMf.applicationInfo.loadLabel(this.dwP) != null) {
                        this.mAppName = this.mMf.applicationInfo.loadLabel(this.dwP).toString();
                    }
                    if (this.mMf.signatures != null && this.mMf.signatures.length > 0 && this.mMf.signatures[0] != null) {
                        this.mMe = av.getAPKHexMD5(this.mMf.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.mMe = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mMc = extras.getString("ShareUrl");
            this.eGJ = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mMd = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mMe)) {
                this.mMe = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dGn() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eGJ) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dGo() {
        if (TextUtils.isEmpty(this.mMd)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dGp();
        }
    }

    private void dGp() {
        this.mMi.dGx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mMj.Sm(this.mMg.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGq() {
        if (this.mMm == null) {
            this.mMm = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mMm.xa(false);
            this.mMm.Jb(R.drawable.icon_send_ok);
            this.mMm.Je(R.string.share_alert_success);
            this.mMm.a(R.string.share_stay_in_tieba, this.mMo);
            this.mMm.b(R.string.back, this.mMq);
            this.mMm.b(this.mMt);
            this.mMm.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGr() {
        if (this.mMn == null) {
            this.mMn = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mMn.Jb(R.drawable.icon_send_error);
            this.mMn.Jc(R.drawable.btn_w_square);
            this.mMn.Jd(R.color.common_color_10039);
            this.mMn.Je(R.string.share_alert_fail);
            this.mMn.a(R.string.share_keep_sending, this.mMp);
            this.mMn.b(R.string.back, this.mMq);
            this.mMn.b(this.mMt);
            this.mMn.g(getPageContext());
        }
    }

    protected void dGs() {
        if (this.fpI != null) {
            this.fpI.cancelLoadData();
        }
    }

    protected void dGt() {
        if (this.fpI != null) {
            this.fpI.dLo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dGs();
        dGt();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dGI;
        if (this.mMi != null && (dGI = this.mMi.dGI()) != null) {
            dGI.setImageBitmap(null);
        }
    }

    public WriteData cXW() {
        return this.mMg;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mMi != null && this.mMi.dGE() != null && this.mMi.dGE().isShowing()) {
                g.dismissPopupWindow(this.mMi.dGE(), getPageContext().getPageActivity());
                return true;
            }
            dGs();
            if (this.mMl) {
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
        if (this.mMi != null) {
            this.mMi.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mMi = new c(this);
        this.mMi.af(this.mMu);
        this.mMi.ag(this.mMv);
        this.mMi.b(this.hcn);
        this.mMi.ah(this.mMw);
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

    public void Jf(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fpI = new NewWriteModel(this);
        this.fpI.a(this.mMs);
        this.fpI.a(this.mMr);
        this.mMj = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.mMi != null) {
                            WriteShareActivity.this.mMi.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mMi.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mMi.a((PostPrefixData) null);
            }
        });
        this.iyf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dGs();
            }
        };
        this.mMg = new WriteData();
        this.mMg.setType(3);
        if (bundle != null) {
            this.mMg.setForumName(bundle.getString("forum_name"));
            this.mMg.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mMg.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mMg.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mMg.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mMg.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mMg.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mMg.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mMg.setForumName(this.mMd);
            this.mMg.setShareSummaryTitle(this.mShareTitle);
            this.mMg.setShareSummaryContent(this.mShareContent);
            this.mMg.setShareApiKey(this.mAppKey);
            this.mMg.setShareAppName(this.mAppName);
            this.mMg.setShareSignKey(this.mMe);
            this.mMg.setShareReferUrl(this.mMc);
            boolean isLocalImagePath = n.isLocalImagePath(this.eGJ);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fpI.d(this.mShareLocalImageData, this.eGJ);
                this.mMg.setShareLocalImageUri(this.eGJ);
                this.mMg.setShareLocalImageData(this.mShareLocalImageData);
                this.fpI.cuO();
                this.mMg.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mMg.setShareSummaryImg(this.eGJ);
                this.mMg.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mMg.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mMg.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mMg.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mMg.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mMg.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mMg.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mMg.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mMg.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mMg.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mMg.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mMg.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mMg.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mMg.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mMg.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mMg.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mMg.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mMg.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.mMi != null && this.mMi.dGD() != null && (obj = this.mMi.dGD().getEditableText().toString()) != null) {
            this.mMi.dGD().setText(TbFaceManager.bBc().aw(getPageContext().getContext(), obj));
            this.mMi.dGD().setSelection(this.mMi.dGD().getText().length());
        }
    }

    public void Jg(int i) {
        this.mMh = i;
    }

    public int dGu() {
        return this.mMh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGv() {
        dGs();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.mMh != this.mPrefixData.getPrefixs().size() - 1) {
            this.mMg.setTitle(this.mMi.dGH().getText().toString() + this.mMi.dGC().getText().toString());
        } else {
            this.mMg.setTitle(this.mMi.dGC().getText().toString());
        }
        this.mMg.setContent(this.mMi.dGD().getText().toString());
        this.fpI.e(this.mMg);
        this.mMg.setVcode(null);
        this.fpI.cXW().setVoice(null);
        this.fpI.cXW().setVoiceDuringTime(-1);
        if (this.fpI.dLm()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iyf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.mMk = false;
            if (i2 == -1) {
                dGq();
                if (this.mMm != null) {
                    this.mMl = true;
                    this.mMm.dGl();
                }
                setResult(-1);
                return;
            }
            dGr();
            if (this.mMn != null) {
                this.mMl = false;
                this.mMn.dGl();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.mMd = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mMg.setForumName(this.mMd);
                    dGp();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dGo();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mMi.dGC());
        HidenSoftKeyPad(this.mInputManager, this.mMi.dGD());
        super.onPause();
    }

    public void dGw() {
        HidenSoftKeyPad(this.mInputManager, this.mMi.dGC());
        HidenSoftKeyPad(this.mInputManager, this.mMi.dGD());
    }
}
