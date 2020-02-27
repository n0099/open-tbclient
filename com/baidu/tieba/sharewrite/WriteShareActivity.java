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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager bSo;
    private String cUk;
    private NewWriteModel dyl;
    private String jWE;
    private String jWF;
    private String jWG;
    private PackageInfo jWH;
    private int jWJ;
    private c jWK;
    b jWL;
    private com.baidu.tieba.sharewrite.a jWO;
    private com.baidu.tieba.sharewrite.a jWP;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jWI = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gfk = null;
    private boolean jWM = false;
    private boolean jWN = false;
    private a.b jWQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jWI.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jWR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIb());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIc());
            WriteShareActivity.this.cHU();
            aVar.dismiss();
        }
    };
    private a.b jWS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jWN) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jWT = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jWI.setShareSummaryImg("");
                WriteShareActivity.this.jWI.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jWI.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jWI.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jWI.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jWI.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jWU = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cHO();
                if (WriteShareActivity.this.jWO != null) {
                    WriteShareActivity.this.jWN = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jWO.cHJ();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cHP();
                if (WriteShareActivity.this.jWP != null) {
                    WriteShareActivity.this.jWN = false;
                    WriteShareActivity.this.jWP.cHJ();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aJE());
                WriteShareActivity.this.jWM = true;
                if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jWV = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jWK != null && WriteShareActivity.this.jWK.cId() != null && WriteShareActivity.this.jWK.cId().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jWK.cId(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cHQ();
                if (WriteShareActivity.this.jWN) {
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
    private View.OnClickListener jWW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cHQ();
            if (WriteShareActivity.this.jWN) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jWX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIb());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIc());
            WriteShareActivity.this.cHU();
        }
    };
    private View.OnClickListener jWY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jWK.cIc().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIc());
        }
    };
    private final View.OnFocusChangeListener eVV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jWK != null) {
                if (view == WriteShareActivity.this.jWK.cIb() || view == WriteShareActivity.this.jWK.cIe() || view == WriteShareActivity.this.jWK.cIf()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIb());
                    } else if (view == WriteShareActivity.this.jWK.cIb() && WriteShareActivity.this.jWK.cIg() != null) {
                        WriteShareActivity.this.jWK.cIg().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jWK.cIc()) {
                    if (z) {
                        WriteShareActivity.this.jWK.cIc().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jWK.cIc().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWK.cIb());
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
        this.bSo = getPageContext().getPageActivity().getPackageManager();
        bfX();
        boolean cHL = cHL();
        initData(bundle);
        initUI();
        if (!cHL) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Cb(R.string.share_parameter_invalid_tip);
            } else {
                Cb(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cHM();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bfX() {
        this.packageName = getCallingPackage();
        if (this.bSo != null && this.packageName != null) {
            try {
                this.jWH = this.bSo.getPackageInfo(this.packageName, 64);
                if (this.jWH != null) {
                    if (this.jWH.applicationInfo != null && this.jWH.applicationInfo.loadLabel(this.bSo) != null) {
                        this.mAppName = this.jWH.applicationInfo.loadLabel(this.bSo).toString();
                    }
                    if (this.jWH.signatures != null && this.jWH.signatures.length > 0 && this.jWH.signatures[0] != null) {
                        this.jWG = as.getAPKHexMD5(this.jWH.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jWG = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jWE = extras.getString("ShareUrl");
            this.cUk = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jWF = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jWG)) {
                this.jWG = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cHL() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cUk) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cHM() {
        if (TextUtils.isEmpty(this.jWF)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cHN();
        }
    }

    private void cHN() {
        this.jWK.cHW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jWL.IG(this.jWI.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHO() {
        if (this.jWO == null) {
            this.jWO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jWO.sw(false);
            this.jWO.BX(R.drawable.icon_send_ok);
            this.jWO.Ca(R.string.share_alert_success);
            this.jWO.a(R.string.share_stay_in_tieba, this.jWQ);
            this.jWO.b(R.string.back, this.jWS);
            this.jWO.a(this.jWV);
            this.jWO.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHP() {
        if (this.jWP == null) {
            this.jWP = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jWP.BX(R.drawable.icon_send_error);
            this.jWP.BY(R.drawable.btn_w_square);
            this.jWP.BZ(R.color.common_color_10039);
            this.jWP.Ca(R.string.share_alert_fail);
            this.jWP.a(R.string.share_keep_sending, this.jWR);
            this.jWP.b(R.string.back, this.jWS);
            this.jWP.a(this.jWV);
            this.jWP.f(getPageContext());
        }
    }

    protected void cHQ() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
    }

    protected void cHR() {
        if (this.dyl != null) {
            this.dyl.cMj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cHQ();
        cHR();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cIh;
        if (this.jWK != null && (cIh = this.jWK.cIh()) != null) {
            cIh.setImageBitmap(null);
        }
    }

    public WriteData cHS() {
        return this.jWI;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jWK != null && this.jWK.cId() != null && this.jWK.cId().isShowing()) {
                g.dismissPopupWindow(this.jWK.cId(), getPageContext().getPageActivity());
                return true;
            }
            cHQ();
            if (this.jWN) {
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
        if (this.jWK != null) {
            this.jWK.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jWK = new c(this);
        this.jWK.ab(this.jWW);
        this.jWK.ac(this.jWX);
        this.jWK.b(this.eVV);
        this.jWK.ad(this.jWY);
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

    public void Cb(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.dyl = new NewWriteModel(this);
        this.dyl.a(this.jWU);
        this.dyl.a(this.jWT);
        this.jWL = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jWK != null) {
                            WriteShareActivity.this.jWK.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWK.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWK.a((PostPrefixData) null);
            }
        });
        this.gfk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cHQ();
            }
        };
        this.jWI = new WriteData();
        this.jWI.setType(3);
        if (bundle != null) {
            this.jWI.setForumName(bundle.getString("forum_name"));
            this.jWI.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jWI.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jWI.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jWI.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jWI.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jWI.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jWI.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jWI.setForumName(this.jWF);
            this.jWI.setShareSummaryTitle(this.mShareTitle);
            this.jWI.setShareSummaryContent(this.mShareContent);
            this.jWI.setShareApiKey(this.mAppKey);
            this.jWI.setShareAppName(this.mAppName);
            this.jWI.setShareSignKey(this.jWG);
            this.jWI.setShareReferUrl(this.jWE);
            boolean isLocalImagePath = m.isLocalImagePath(this.cUk);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dyl.e(this.mShareLocalImageData, this.cUk);
                this.jWI.setShareLocalImageUri(this.cUk);
                this.jWI.setShareLocalImageData(this.mShareLocalImageData);
                this.dyl.bAD();
                this.jWI.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jWI.setShareSummaryImg(this.cUk);
                this.jWI.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jWI.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jWI.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jWI.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jWI.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jWI.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jWI.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jWI.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jWI.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jWI.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jWI.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jWI.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jWI.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jWI.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jWI.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jWI.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jWI.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jWI.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jWK != null && this.jWK.cIc() != null && (obj = this.jWK.cIc().getEditableText().toString()) != null) {
            this.jWK.cIc().setText(TbFaceManager.aPN().aB(getPageContext().getContext(), obj));
            this.jWK.cIc().setSelection(this.jWK.cIc().getText().length());
        }
    }

    public void Cc(int i) {
        this.jWJ = i;
    }

    public int cHT() {
        return this.jWJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHU() {
        cHQ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jWJ != this.mPrefixData.getPrefixs().size() - 1) {
            this.jWI.setTitle(this.jWK.cIg().getText().toString() + this.jWK.cIb().getText().toString());
        } else {
            this.jWI.setTitle(this.jWK.cIb().getText().toString());
        }
        this.jWI.setContent(this.jWK.cIc().getText().toString());
        this.dyl.d(this.jWI);
        this.jWI.setVcode(null);
        this.dyl.cHS().setVoice(null);
        this.dyl.cHS().setVoiceDuringTime(-1);
        if (this.dyl.cMh()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jWM = false;
            if (i2 == -1) {
                cHO();
                if (this.jWO != null) {
                    this.jWN = true;
                    this.jWO.cHJ();
                }
                setResult(-1);
                return;
            }
            cHP();
            if (this.jWP != null) {
                this.jWN = false;
                this.jWP.cHJ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jWF = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jWI.setForumName(this.jWF);
                    cHN();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cHM();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jWK.cIb());
        HidenSoftKeyPad(this.mInputManager, this.jWK.cIc());
        super.onPause();
    }

    public void cHV() {
        HidenSoftKeyPad(this.mInputManager, this.jWK.cIb());
        HidenSoftKeyPad(this.mInputManager, this.jWK.cIc());
    }
}
