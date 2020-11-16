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
/* loaded from: classes23.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dvi;
    private String eFb;
    private NewWriteModel foP;
    private String mAppKey;
    private String mAppName;
    private String mMV;
    private String mMW;
    private String mMX;
    private PackageInfo mMY;
    private int mNa;
    private c mNb;
    b mNc;
    private com.baidu.tieba.sharewrite.a mNf;
    private com.baidu.tieba.sharewrite.a mNg;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mMZ = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iyU = null;
    private boolean mNd = false;
    private boolean mNe = false;
    private a.b mNh = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mMZ.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b mNi = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGt());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGu());
            WriteShareActivity.this.dGm();
            aVar.dismiss();
        }
    };
    private a.b mNj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.mNe) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b mNk = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mMZ.setShareSummaryImg("");
                WriteShareActivity.this.mMZ.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mMZ.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mMZ.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mMZ.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mMZ.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c mNl = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dGh();
                if (WriteShareActivity.this.mNf != null) {
                    WriteShareActivity.this.mNe = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mNf.dGc();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dGi();
                if (WriteShareActivity.this.mNg != null) {
                    WriteShareActivity.this.mNe = false;
                    WriteShareActivity.this.mNg.dGc();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bum());
                WriteShareActivity.this.mNd = true;
                if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener mNm = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.mNb != null && WriteShareActivity.this.mNb.dGv() != null && WriteShareActivity.this.mNb.dGv().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.mNb.dGv(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dGj();
                if (WriteShareActivity.this.mNe) {
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
    private View.OnClickListener mNn = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dGj();
            if (WriteShareActivity.this.mNe) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener mNo = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGt());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGu());
            WriteShareActivity.this.dGm();
        }
    };
    private View.OnClickListener mNp = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mNb.dGu().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGu());
        }
    };
    private final View.OnFocusChangeListener hbU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mNb != null) {
                if (view == WriteShareActivity.this.mNb.dGt() || view == WriteShareActivity.this.mNb.dGw() || view == WriteShareActivity.this.mNb.dGx()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGt());
                    } else if (view == WriteShareActivity.this.mNb.dGt() && WriteShareActivity.this.mNb.dGy() != null) {
                        WriteShareActivity.this.mNb.dGy().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.mNb.dGu()) {
                    if (z) {
                        WriteShareActivity.this.mNb.dGu().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.mNb.dGu().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mNb.dGt());
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
        this.dvi = getPageContext().getPageActivity().getPackageManager();
        cir();
        boolean dGe = dGe();
        initData(bundle);
        initUI();
        if (!dGe) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                JH(R.string.share_parameter_invalid_tip);
            } else {
                JH(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dGf();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cir() {
        this.packageName = getCallingPackage();
        if (this.dvi != null && this.packageName != null) {
            try {
                this.mMY = this.dvi.getPackageInfo(this.packageName, 64);
                if (this.mMY != null) {
                    if (this.mMY.applicationInfo != null && this.mMY.applicationInfo.loadLabel(this.dvi) != null) {
                        this.mAppName = this.mMY.applicationInfo.loadLabel(this.dvi).toString();
                    }
                    if (this.mMY.signatures != null && this.mMY.signatures.length > 0 && this.mMY.signatures[0] != null) {
                        this.mMX = aw.getAPKHexMD5(this.mMY.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.mMX = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mMV = extras.getString("ShareUrl");
            this.eFb = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mMW = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mMX)) {
                this.mMX = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dGe() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eFb) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dGf() {
        if (TextUtils.isEmpty(this.mMW)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dGg();
        }
    }

    private void dGg() {
        this.mNb.dGo();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mNc.RN(this.mMZ.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGh() {
        if (this.mNf == null) {
            this.mNf = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mNf.xe(false);
            this.mNf.JD(R.drawable.icon_send_ok);
            this.mNf.JG(R.string.share_alert_success);
            this.mNf.a(R.string.share_stay_in_tieba, this.mNh);
            this.mNf.b(R.string.back, this.mNj);
            this.mNf.b(this.mNm);
            this.mNf.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGi() {
        if (this.mNg == null) {
            this.mNg = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mNg.JD(R.drawable.icon_send_error);
            this.mNg.JE(R.drawable.btn_w_square);
            this.mNg.JF(R.color.common_color_10039);
            this.mNg.JG(R.string.share_alert_fail);
            this.mNg.a(R.string.share_keep_sending, this.mNi);
            this.mNg.b(R.string.back, this.mNj);
            this.mNg.b(this.mNm);
            this.mNg.g(getPageContext());
        }
    }

    protected void dGj() {
        if (this.foP != null) {
            this.foP.cancelLoadData();
        }
    }

    protected void dGk() {
        if (this.foP != null) {
            this.foP.dLn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dGj();
        dGk();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dGz;
        if (this.mNb != null && (dGz = this.mNb.dGz()) != null) {
            dGz.setImageBitmap(null);
        }
    }

    public WriteData cXs() {
        return this.mMZ;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mNb != null && this.mNb.dGv() != null && this.mNb.dGv().isShowing()) {
                g.dismissPopupWindow(this.mNb.dGv(), getPageContext().getPageActivity());
                return true;
            }
            dGj();
            if (this.mNe) {
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
        if (this.mNb != null) {
            this.mNb.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mNb = new c(this);
        this.mNb.af(this.mNn);
        this.mNb.ag(this.mNo);
        this.mNb.b(this.hbU);
        this.mNb.ah(this.mNp);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
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

    public void JH(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.foP = new NewWriteModel(this);
        this.foP.a(this.mNl);
        this.foP.a(this.mNk);
        this.mNc = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.mNb != null) {
                            WriteShareActivity.this.mNb.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mNb.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mNb.a((PostPrefixData) null);
            }
        });
        this.iyU = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dGj();
            }
        };
        this.mMZ = new WriteData();
        this.mMZ.setType(3);
        if (bundle != null) {
            this.mMZ.setForumName(bundle.getString("forum_name"));
            this.mMZ.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mMZ.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mMZ.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mMZ.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mMZ.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mMZ.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mMZ.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mMZ.setForumName(this.mMW);
            this.mMZ.setShareSummaryTitle(this.mShareTitle);
            this.mMZ.setShareSummaryContent(this.mShareContent);
            this.mMZ.setShareApiKey(this.mAppKey);
            this.mMZ.setShareAppName(this.mAppName);
            this.mMZ.setShareSignKey(this.mMX);
            this.mMZ.setShareReferUrl(this.mMV);
            boolean isLocalImagePath = n.isLocalImagePath(this.eFb);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.foP.d(this.mShareLocalImageData, this.eFb);
                this.mMZ.setShareLocalImageUri(this.eFb);
                this.mMZ.setShareLocalImageData(this.mShareLocalImageData);
                this.foP.cur();
                this.mMZ.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mMZ.setShareSummaryImg(this.eFb);
                this.mMZ.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mMZ.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mMZ.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mMZ.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mMZ.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mMZ.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mMZ.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mMZ.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mMZ.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mMZ.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mMZ.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mMZ.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mMZ.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mMZ.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mMZ.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mMZ.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mMZ.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mMZ.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.mNb != null && this.mNb.dGu() != null && (obj = this.mNb.dGu().getEditableText().toString()) != null) {
            this.mNb.dGu().setText(TbFaceManager.bAs().at(getPageContext().getContext(), obj));
            this.mNb.dGu().setSelection(this.mNb.dGu().getText().length());
        }
    }

    public void JI(int i) {
        this.mNa = i;
    }

    public int dGl() {
        return this.mNa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGm() {
        dGj();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.mNa != this.mPrefixData.getPrefixs().size() - 1) {
            this.mMZ.setTitle(this.mNb.dGy().getText().toString() + this.mNb.dGt().getText().toString());
        } else {
            this.mMZ.setTitle(this.mNb.dGt().getText().toString());
        }
        this.mMZ.setContent(this.mNb.dGu().getText().toString());
        this.foP.e(this.mMZ);
        this.mMZ.setVcode(null);
        this.foP.cXs().setVoice(null);
        this.foP.cXs().setVoiceDuringTime(-1);
        if (this.foP.dLl()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iyU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.mNd = false;
            if (i2 == -1) {
                dGh();
                if (this.mNf != null) {
                    this.mNe = true;
                    this.mNf.dGc();
                }
                setResult(-1);
                return;
            }
            dGi();
            if (this.mNg != null) {
                this.mNe = false;
                this.mNg.dGc();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.mMW = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mMZ.setForumName(this.mMW);
                    dGg();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dGf();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mNb.dGt());
        HidenSoftKeyPad(this.mInputManager, this.mNb.dGu());
        super.onPause();
    }

    public void dGn() {
        HidenSoftKeyPad(this.mInputManager, this.mNb.dGt());
        HidenSoftKeyPad(this.mInputManager, this.mNb.dGu());
    }
}
