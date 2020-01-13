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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager bOj;
    private String cQi;
    private NewWriteModel duf;
    private String jVA;
    private String jVB;
    private PackageInfo jVC;
    private int jVE;
    private c jVF;
    b jVG;
    private com.baidu.tieba.sharewrite.a jVJ;
    private com.baidu.tieba.sharewrite.a jVK;
    private String jVz;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jVD = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gdj = null;
    private boolean jVH = false;
    private boolean jVI = false;
    private a.b jVL = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jVD.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jVM = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGv());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGw());
            WriteShareActivity.this.cGo();
            aVar.dismiss();
        }
    };
    private a.b jVN = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jVI) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jVO = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jVD.setShareSummaryImg("");
                WriteShareActivity.this.jVD.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jVD.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jVD.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jVD.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jVD.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jVP = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, z zVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cGi();
                if (WriteShareActivity.this.jVJ != null) {
                    WriteShareActivity.this.jVI = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jVJ.cGd();
                }
            } else if (zVar == null || writeData == null || zVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cGj();
                if (WriteShareActivity.this.jVK != null) {
                    WriteShareActivity.this.jVI = false;
                    WriteShareActivity.this.jVK.cGd();
                }
            } else {
                writeData.setVcodeMD5(zVar.getVcode_md5());
                writeData.setVcodeUrl(zVar.getVcode_pic_url());
                writeData.setVcodeExtra(zVar.aHl());
                WriteShareActivity.this.jVH = true;
                if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jVQ = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jVF != null && WriteShareActivity.this.jVF.cGx() != null && WriteShareActivity.this.jVF.cGx().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jVF.cGx(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cGk();
                if (WriteShareActivity.this.jVI) {
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
    private View.OnClickListener jVR = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cGk();
            if (WriteShareActivity.this.jVI) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jVS = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGv());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGw());
            WriteShareActivity.this.cGo();
        }
    };
    private View.OnClickListener jVT = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jVF.cGw().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGw());
        }
    };
    private final View.OnFocusChangeListener eSe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jVF != null) {
                if (view == WriteShareActivity.this.jVF.cGv() || view == WriteShareActivity.this.jVF.cGy() || view == WriteShareActivity.this.jVF.cGz()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGv());
                    } else if (view == WriteShareActivity.this.jVF.cGv() && WriteShareActivity.this.jVF.cGA() != null) {
                        WriteShareActivity.this.jVF.cGA().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jVF.cGw()) {
                    if (z) {
                        WriteShareActivity.this.jVF.cGw().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jVF.cGw().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVF.cGv());
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
        this.bOj = getPageContext().getPageActivity().getPackageManager();
        bdN();
        boolean cGf = cGf();
        initData(bundle);
        initUI();
        if (!cGf) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                BU(R.string.share_parameter_invalid_tip);
            } else {
                BU(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cGg();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bdN() {
        this.packageName = getCallingPackage();
        if (this.bOj != null && this.packageName != null) {
            try {
                this.jVC = this.bOj.getPackageInfo(this.packageName, 64);
                if (this.jVC != null) {
                    if (this.jVC.applicationInfo != null && this.jVC.applicationInfo.loadLabel(this.bOj) != null) {
                        this.mAppName = this.jVC.applicationInfo.loadLabel(this.bOj).toString();
                    }
                    if (this.jVC.signatures != null && this.jVC.signatures.length > 0 && this.jVC.signatures[0] != null) {
                        this.jVB = as.getAPKHexMD5(this.jVC.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jVB = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jVz = extras.getString("ShareUrl");
            this.cQi = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jVA = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jVB)) {
                this.jVB = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cGf() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cQi) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cGg() {
        if (TextUtils.isEmpty(this.jVA)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cGh();
        }
    }

    private void cGh() {
        this.jVF.cGq();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jVG.Is(this.jVD.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGi() {
        if (this.jVJ == null) {
            this.jVJ = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jVJ.ss(false);
            this.jVJ.BQ(R.drawable.icon_send_ok);
            this.jVJ.BT(R.string.share_alert_success);
            this.jVJ.a(R.string.share_stay_in_tieba, this.jVL);
            this.jVJ.b(R.string.back, this.jVN);
            this.jVJ.a(this.jVQ);
            this.jVJ.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGj() {
        if (this.jVK == null) {
            this.jVK = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jVK.BQ(R.drawable.icon_send_error);
            this.jVK.BR(R.drawable.btn_w_square);
            this.jVK.BS(R.color.common_color_10039);
            this.jVK.BT(R.string.share_alert_fail);
            this.jVK.a(R.string.share_keep_sending, this.jVM);
            this.jVK.b(R.string.back, this.jVN);
            this.jVK.a(this.jVQ);
            this.jVK.f(getPageContext());
        }
    }

    protected void cGk() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
    }

    protected void cGl() {
        if (this.duf != null) {
            this.duf.cKM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cGk();
        cGl();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cGB;
        if (this.jVF != null && (cGB = this.jVF.cGB()) != null) {
            cGB.setImageBitmap(null);
        }
    }

    public WriteData cGm() {
        return this.jVD;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jVF != null && this.jVF.cGx() != null && this.jVF.cGx().isShowing()) {
                g.dismissPopupWindow(this.jVF.cGx(), getPageContext().getPageActivity());
                return true;
            }
            cGk();
            if (this.jVI) {
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
        if (this.jVF != null) {
            this.jVF.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVF = new c(this);
        this.jVF.ab(this.jVR);
        this.jVF.ac(this.jVS);
        this.jVF.b(this.eSe);
        this.jVF.ad(this.jVT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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

    public void BU(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.duf = new NewWriteModel(this);
        this.duf.a(this.jVP);
        this.duf.a(this.jVO);
        this.jVG = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jVF != null) {
                            WriteShareActivity.this.jVF.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jVF.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jVF.a((PostPrefixData) null);
            }
        });
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cGk();
            }
        };
        this.jVD = new WriteData();
        this.jVD.setType(3);
        if (bundle != null) {
            this.jVD.setForumName(bundle.getString("forum_name"));
            this.jVD.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jVD.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jVD.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jVD.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jVD.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jVD.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jVD.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jVD.setForumName(this.jVA);
            this.jVD.setShareSummaryTitle(this.mShareTitle);
            this.jVD.setShareSummaryContent(this.mShareContent);
            this.jVD.setShareApiKey(this.mAppKey);
            this.jVD.setShareAppName(this.mAppName);
            this.jVD.setShareSignKey(this.jVB);
            this.jVD.setShareReferUrl(this.jVz);
            boolean isLocalImagePath = m.isLocalImagePath(this.cQi);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.duf.e(this.mShareLocalImageData, this.cQi);
                this.jVD.setShareLocalImageUri(this.cQi);
                this.jVD.setShareLocalImageData(this.mShareLocalImageData);
                this.duf.bzb();
                this.jVD.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jVD.setShareSummaryImg(this.cQi);
                this.jVD.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jVD.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jVD.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jVD.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jVD.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jVD.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jVD.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jVD.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jVD.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jVD.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jVD.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jVD.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jVD.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jVD.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jVD.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jVD.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jVD.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jVD.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jVF != null && this.jVF.cGw() != null && (obj = this.jVF.cGw().getEditableText().toString()) != null) {
            this.jVF.cGw().setText(TbFaceManager.aNr().aB(getPageContext().getContext(), obj));
            this.jVF.cGw().setSelection(this.jVF.cGw().getText().length());
        }
    }

    public void BV(int i) {
        this.jVE = i;
    }

    public int cGn() {
        return this.jVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGo() {
        cGk();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jVE != this.mPrefixData.getPrefixs().size() - 1) {
            this.jVD.setTitle(this.jVF.cGA().getText().toString() + this.jVF.cGv().getText().toString());
        } else {
            this.jVD.setTitle(this.jVF.cGv().getText().toString());
        }
        this.jVD.setContent(this.jVF.cGw().getText().toString());
        this.duf.d(this.jVD);
        this.jVD.setVcode(null);
        this.duf.cGm().setVoice(null);
        this.duf.cGm().setVoiceDuringTime(-1);
        if (this.duf.cKK()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gdj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jVH = false;
            if (i2 == -1) {
                cGi();
                if (this.jVJ != null) {
                    this.jVI = true;
                    this.jVJ.cGd();
                }
                setResult(-1);
                return;
            }
            cGj();
            if (this.jVK != null) {
                this.jVI = false;
                this.jVK.cGd();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jVA = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jVD.setForumName(this.jVA);
                    cGh();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cGg();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jVF.cGv());
        HidenSoftKeyPad(this.mInputManager, this.jVF.cGw());
        super.onPause();
    }

    public void cGp() {
        HidenSoftKeyPad(this.mInputManager, this.jVF.cGv());
        HidenSoftKeyPad(this.mInputManager, this.jVF.cGw());
    }
}
