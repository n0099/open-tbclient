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
    private PackageManager bSp;
    private String cUl;
    private NewWriteModel dym;
    private String jWG;
    private String jWH;
    private String jWI;
    private PackageInfo jWJ;
    private int jWL;
    private c jWM;
    b jWN;
    private com.baidu.tieba.sharewrite.a jWQ;
    private com.baidu.tieba.sharewrite.a jWR;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jWK = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gfm = null;
    private boolean jWO = false;
    private boolean jWP = false;
    private a.b jWS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jWK.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jWT = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cId());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cIe());
            WriteShareActivity.this.cHW();
            aVar.dismiss();
        }
    };
    private a.b jWU = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jWP) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jWV = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jWK.setShareSummaryImg("");
                WriteShareActivity.this.jWK.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jWK.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jWK.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jWK.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jWK.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jWW = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cHQ();
                if (WriteShareActivity.this.jWQ != null) {
                    WriteShareActivity.this.jWP = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jWQ.cHL();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cHR();
                if (WriteShareActivity.this.jWR != null) {
                    WriteShareActivity.this.jWP = false;
                    WriteShareActivity.this.jWR.cHL();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aJG());
                WriteShareActivity.this.jWO = true;
                if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jWX = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jWM != null && WriteShareActivity.this.jWM.cIf() != null && WriteShareActivity.this.jWM.cIf().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jWM.cIf(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cHS();
                if (WriteShareActivity.this.jWP) {
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
    private View.OnClickListener jWY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cHS();
            if (WriteShareActivity.this.jWP) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jWZ = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cId());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cIe());
            WriteShareActivity.this.cHW();
        }
    };
    private View.OnClickListener jXa = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jWM.cIe().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cIe());
        }
    };
    private final View.OnFocusChangeListener eVW = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jWM != null) {
                if (view == WriteShareActivity.this.jWM.cId() || view == WriteShareActivity.this.jWM.cIg() || view == WriteShareActivity.this.jWM.cIh()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cId());
                    } else if (view == WriteShareActivity.this.jWM.cId() && WriteShareActivity.this.jWM.cIi() != null) {
                        WriteShareActivity.this.jWM.cIi().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jWM.cIe()) {
                    if (z) {
                        WriteShareActivity.this.jWM.cIe().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jWM.cIe().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jWM.cId());
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
        this.bSp = getPageContext().getPageActivity().getPackageManager();
        bfZ();
        boolean cHN = cHN();
        initData(bundle);
        initUI();
        if (!cHN) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Cb(R.string.share_parameter_invalid_tip);
            } else {
                Cb(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cHO();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bfZ() {
        this.packageName = getCallingPackage();
        if (this.bSp != null && this.packageName != null) {
            try {
                this.jWJ = this.bSp.getPackageInfo(this.packageName, 64);
                if (this.jWJ != null) {
                    if (this.jWJ.applicationInfo != null && this.jWJ.applicationInfo.loadLabel(this.bSp) != null) {
                        this.mAppName = this.jWJ.applicationInfo.loadLabel(this.bSp).toString();
                    }
                    if (this.jWJ.signatures != null && this.jWJ.signatures.length > 0 && this.jWJ.signatures[0] != null) {
                        this.jWI = as.getAPKHexMD5(this.jWJ.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jWI = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jWG = extras.getString("ShareUrl");
            this.cUl = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jWH = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jWI)) {
                this.jWI = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cHN() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cUl) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cHO() {
        if (TextUtils.isEmpty(this.jWH)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cHP();
        }
    }

    private void cHP() {
        this.jWM.cHY();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jWN.IG(this.jWK.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        if (this.jWQ == null) {
            this.jWQ = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jWQ.sw(false);
            this.jWQ.BX(R.drawable.icon_send_ok);
            this.jWQ.Ca(R.string.share_alert_success);
            this.jWQ.a(R.string.share_stay_in_tieba, this.jWS);
            this.jWQ.b(R.string.back, this.jWU);
            this.jWQ.a(this.jWX);
            this.jWQ.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHR() {
        if (this.jWR == null) {
            this.jWR = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jWR.BX(R.drawable.icon_send_error);
            this.jWR.BY(R.drawable.btn_w_square);
            this.jWR.BZ(R.color.common_color_10039);
            this.jWR.Ca(R.string.share_alert_fail);
            this.jWR.a(R.string.share_keep_sending, this.jWT);
            this.jWR.b(R.string.back, this.jWU);
            this.jWR.a(this.jWX);
            this.jWR.f(getPageContext());
        }
    }

    protected void cHS() {
        if (this.dym != null) {
            this.dym.cancelLoadData();
        }
    }

    protected void cHT() {
        if (this.dym != null) {
            this.dym.cMl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cHS();
        cHT();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cIj;
        if (this.jWM != null && (cIj = this.jWM.cIj()) != null) {
            cIj.setImageBitmap(null);
        }
    }

    public WriteData cHU() {
        return this.jWK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jWM != null && this.jWM.cIf() != null && this.jWM.cIf().isShowing()) {
                g.dismissPopupWindow(this.jWM.cIf(), getPageContext().getPageActivity());
                return true;
            }
            cHS();
            if (this.jWP) {
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
        if (this.jWM != null) {
            this.jWM.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jWM = new c(this);
        this.jWM.ab(this.jWY);
        this.jWM.ac(this.jWZ);
        this.jWM.b(this.eVW);
        this.jWM.ad(this.jXa);
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
        this.dym = new NewWriteModel(this);
        this.dym.a(this.jWW);
        this.dym.a(this.jWV);
        this.jWN = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jWM != null) {
                            WriteShareActivity.this.jWM.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWM.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jWM.a((PostPrefixData) null);
            }
        });
        this.gfm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cHS();
            }
        };
        this.jWK = new WriteData();
        this.jWK.setType(3);
        if (bundle != null) {
            this.jWK.setForumName(bundle.getString("forum_name"));
            this.jWK.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jWK.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jWK.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jWK.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jWK.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jWK.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jWK.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jWK.setForumName(this.jWH);
            this.jWK.setShareSummaryTitle(this.mShareTitle);
            this.jWK.setShareSummaryContent(this.mShareContent);
            this.jWK.setShareApiKey(this.mAppKey);
            this.jWK.setShareAppName(this.mAppName);
            this.jWK.setShareSignKey(this.jWI);
            this.jWK.setShareReferUrl(this.jWG);
            boolean isLocalImagePath = m.isLocalImagePath(this.cUl);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dym.e(this.mShareLocalImageData, this.cUl);
                this.jWK.setShareLocalImageUri(this.cUl);
                this.jWK.setShareLocalImageData(this.mShareLocalImageData);
                this.dym.bAF();
                this.jWK.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jWK.setShareSummaryImg(this.cUl);
                this.jWK.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jWK.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jWK.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jWK.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jWK.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jWK.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jWK.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jWK.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jWK.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jWK.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jWK.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jWK.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jWK.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jWK.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jWK.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jWK.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jWK.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jWK.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jWM != null && this.jWM.cIe() != null && (obj = this.jWM.cIe().getEditableText().toString()) != null) {
            this.jWM.cIe().setText(TbFaceManager.aPP().aB(getPageContext().getContext(), obj));
            this.jWM.cIe().setSelection(this.jWM.cIe().getText().length());
        }
    }

    public void Cc(int i) {
        this.jWL = i;
    }

    public int cHV() {
        return this.jWL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHW() {
        cHS();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jWL != this.mPrefixData.getPrefixs().size() - 1) {
            this.jWK.setTitle(this.jWM.cIi().getText().toString() + this.jWM.cId().getText().toString());
        } else {
            this.jWK.setTitle(this.jWM.cId().getText().toString());
        }
        this.jWK.setContent(this.jWM.cIe().getText().toString());
        this.dym.d(this.jWK);
        this.jWK.setVcode(null);
        this.dym.cHU().setVoice(null);
        this.dym.cHU().setVoiceDuringTime(-1);
        if (this.dym.cMj()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jWO = false;
            if (i2 == -1) {
                cHQ();
                if (this.jWQ != null) {
                    this.jWP = true;
                    this.jWQ.cHL();
                }
                setResult(-1);
                return;
            }
            cHR();
            if (this.jWR != null) {
                this.jWP = false;
                this.jWR.cHL();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jWH = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jWK.setForumName(this.jWH);
                    cHP();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cHO();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jWM.cId());
        HidenSoftKeyPad(this.mInputManager, this.jWM.cIe());
        super.onPause();
    }

    public void cHX() {
        HidenSoftKeyPad(this.mInputManager, this.jWM.cId());
        HidenSoftKeyPad(this.mInputManager, this.jWM.cIe());
    }
}
