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
    private String jVE;
    private String jVF;
    private String jVG;
    private PackageInfo jVH;
    private int jVJ;
    private c jVK;
    b jVL;
    private com.baidu.tieba.sharewrite.a jVO;
    private com.baidu.tieba.sharewrite.a jVP;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jVI = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gdj = null;
    private boolean jVM = false;
    private boolean jVN = false;
    private a.b jVQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jVI.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jVR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGx());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGy());
            WriteShareActivity.this.cGq();
            aVar.dismiss();
        }
    };
    private a.b jVS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jVN) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jVT = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jVI.setShareSummaryImg("");
                WriteShareActivity.this.jVI.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jVI.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jVI.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jVI.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jVI.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jVU = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, z zVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cGk();
                if (WriteShareActivity.this.jVO != null) {
                    WriteShareActivity.this.jVN = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jVO.cGf();
                }
            } else if (zVar == null || writeData == null || zVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cGl();
                if (WriteShareActivity.this.jVP != null) {
                    WriteShareActivity.this.jVN = false;
                    WriteShareActivity.this.jVP.cGf();
                }
            } else {
                writeData.setVcodeMD5(zVar.getVcode_md5());
                writeData.setVcodeUrl(zVar.getVcode_pic_url());
                writeData.setVcodeExtra(zVar.aHl());
                WriteShareActivity.this.jVM = true;
                if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jVV = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jVK != null && WriteShareActivity.this.jVK.cGz() != null && WriteShareActivity.this.jVK.cGz().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jVK.cGz(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cGm();
                if (WriteShareActivity.this.jVN) {
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
    private View.OnClickListener jVW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cGm();
            if (WriteShareActivity.this.jVN) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jVX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGx());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGy());
            WriteShareActivity.this.cGq();
        }
    };
    private View.OnClickListener jVY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jVK.cGy().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGy());
        }
    };
    private final View.OnFocusChangeListener eSe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jVK != null) {
                if (view == WriteShareActivity.this.jVK.cGx() || view == WriteShareActivity.this.jVK.cGA() || view == WriteShareActivity.this.jVK.cGB()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGx());
                    } else if (view == WriteShareActivity.this.jVK.cGx() && WriteShareActivity.this.jVK.cGC() != null) {
                        WriteShareActivity.this.jVK.cGC().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jVK.cGy()) {
                    if (z) {
                        WriteShareActivity.this.jVK.cGy().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jVK.cGy().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jVK.cGx());
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
        boolean cGh = cGh();
        initData(bundle);
        initUI();
        if (!cGh) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                BU(R.string.share_parameter_invalid_tip);
            } else {
                BU(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cGi();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bdN() {
        this.packageName = getCallingPackage();
        if (this.bOj != null && this.packageName != null) {
            try {
                this.jVH = this.bOj.getPackageInfo(this.packageName, 64);
                if (this.jVH != null) {
                    if (this.jVH.applicationInfo != null && this.jVH.applicationInfo.loadLabel(this.bOj) != null) {
                        this.mAppName = this.jVH.applicationInfo.loadLabel(this.bOj).toString();
                    }
                    if (this.jVH.signatures != null && this.jVH.signatures.length > 0 && this.jVH.signatures[0] != null) {
                        this.jVG = as.getAPKHexMD5(this.jVH.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jVG = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jVE = extras.getString("ShareUrl");
            this.cQi = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jVF = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jVG)) {
                this.jVG = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cGh() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cQi) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cGi() {
        if (TextUtils.isEmpty(this.jVF)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cGj();
        }
    }

    private void cGj() {
        this.jVK.cGs();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jVL.Is(this.jVI.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGk() {
        if (this.jVO == null) {
            this.jVO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jVO.ss(false);
            this.jVO.BQ(R.drawable.icon_send_ok);
            this.jVO.BT(R.string.share_alert_success);
            this.jVO.a(R.string.share_stay_in_tieba, this.jVQ);
            this.jVO.b(R.string.back, this.jVS);
            this.jVO.a(this.jVV);
            this.jVO.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGl() {
        if (this.jVP == null) {
            this.jVP = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jVP.BQ(R.drawable.icon_send_error);
            this.jVP.BR(R.drawable.btn_w_square);
            this.jVP.BS(R.color.common_color_10039);
            this.jVP.BT(R.string.share_alert_fail);
            this.jVP.a(R.string.share_keep_sending, this.jVR);
            this.jVP.b(R.string.back, this.jVS);
            this.jVP.a(this.jVV);
            this.jVP.f(getPageContext());
        }
    }

    protected void cGm() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
    }

    protected void cGn() {
        if (this.duf != null) {
            this.duf.cKO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cGm();
        cGn();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cGD;
        if (this.jVK != null && (cGD = this.jVK.cGD()) != null) {
            cGD.setImageBitmap(null);
        }
    }

    public WriteData cGo() {
        return this.jVI;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jVK != null && this.jVK.cGz() != null && this.jVK.cGz().isShowing()) {
                g.dismissPopupWindow(this.jVK.cGz(), getPageContext().getPageActivity());
                return true;
            }
            cGm();
            if (this.jVN) {
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
        if (this.jVK != null) {
            this.jVK.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVK = new c(this);
        this.jVK.ab(this.jVW);
        this.jVK.ac(this.jVX);
        this.jVK.b(this.eSe);
        this.jVK.ad(this.jVY);
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
        this.duf.a(this.jVU);
        this.duf.a(this.jVT);
        this.jVL = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jVK != null) {
                            WriteShareActivity.this.jVK.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jVK.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jVK.a((PostPrefixData) null);
            }
        });
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cGm();
            }
        };
        this.jVI = new WriteData();
        this.jVI.setType(3);
        if (bundle != null) {
            this.jVI.setForumName(bundle.getString("forum_name"));
            this.jVI.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jVI.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jVI.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jVI.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jVI.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jVI.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jVI.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jVI.setForumName(this.jVF);
            this.jVI.setShareSummaryTitle(this.mShareTitle);
            this.jVI.setShareSummaryContent(this.mShareContent);
            this.jVI.setShareApiKey(this.mAppKey);
            this.jVI.setShareAppName(this.mAppName);
            this.jVI.setShareSignKey(this.jVG);
            this.jVI.setShareReferUrl(this.jVE);
            boolean isLocalImagePath = m.isLocalImagePath(this.cQi);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.duf.e(this.mShareLocalImageData, this.cQi);
                this.jVI.setShareLocalImageUri(this.cQi);
                this.jVI.setShareLocalImageData(this.mShareLocalImageData);
                this.duf.bzb();
                this.jVI.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jVI.setShareSummaryImg(this.cQi);
                this.jVI.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jVI.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jVI.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jVI.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jVI.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jVI.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jVI.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jVI.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jVI.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jVI.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jVI.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jVI.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jVI.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jVI.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jVI.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jVI.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jVI.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jVI.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jVK != null && this.jVK.cGy() != null && (obj = this.jVK.cGy().getEditableText().toString()) != null) {
            this.jVK.cGy().setText(TbFaceManager.aNr().aB(getPageContext().getContext(), obj));
            this.jVK.cGy().setSelection(this.jVK.cGy().getText().length());
        }
    }

    public void BV(int i) {
        this.jVJ = i;
    }

    public int cGp() {
        return this.jVJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGq() {
        cGm();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jVJ != this.mPrefixData.getPrefixs().size() - 1) {
            this.jVI.setTitle(this.jVK.cGC().getText().toString() + this.jVK.cGx().getText().toString());
        } else {
            this.jVI.setTitle(this.jVK.cGx().getText().toString());
        }
        this.jVI.setContent(this.jVK.cGy().getText().toString());
        this.duf.d(this.jVI);
        this.jVI.setVcode(null);
        this.duf.cGo().setVoice(null);
        this.duf.cGo().setVoiceDuringTime(-1);
        if (this.duf.cKM()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gdj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jVM = false;
            if (i2 == -1) {
                cGk();
                if (this.jVO != null) {
                    this.jVN = true;
                    this.jVO.cGf();
                }
                setResult(-1);
                return;
            }
            cGl();
            if (this.jVP != null) {
                this.jVN = false;
                this.jVP.cGf();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jVF = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jVI.setForumName(this.jVF);
                    cGj();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cGi();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jVK.cGx());
        HidenSoftKeyPad(this.mInputManager, this.jVK.cGy());
        super.onPause();
    }

    public void cGr() {
        HidenSoftKeyPad(this.mInputManager, this.jVK.cGx());
        HidenSoftKeyPad(this.mInputManager, this.jVK.cGy());
    }
}
