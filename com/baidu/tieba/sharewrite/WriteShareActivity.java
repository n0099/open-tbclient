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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager bNz;
    private String cPY;
    private NewWriteModel dtU;
    private String jRW;
    private String jRX;
    private String jRY;
    private PackageInfo jRZ;
    private int jSb;
    private c jSc;
    b jSd;
    private com.baidu.tieba.sharewrite.a jSg;
    private com.baidu.tieba.sharewrite.a jSh;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData jSa = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener fZZ = null;
    private boolean jSe = false;
    private boolean jSf = false;
    private a.b jSi = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.jSa.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b jSj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFr());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFs());
            WriteShareActivity.this.cFk();
            aVar.dismiss();
        }
    };
    private a.b jSk = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.jSf) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b jSl = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.jSa.setShareSummaryImg("");
                WriteShareActivity.this.jSa.setShareSummaryImgHeight(0);
                WriteShareActivity.this.jSa.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.jSa.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.jSa.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.jSa.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c jSm = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, y yVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cFe();
                if (WriteShareActivity.this.jSg != null) {
                    WriteShareActivity.this.jSf = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.jSg.cEZ();
                }
            } else if (yVar == null || writeData == null || yVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cFf();
                if (WriteShareActivity.this.jSh != null) {
                    WriteShareActivity.this.jSf = false;
                    WriteShareActivity.this.jSh.cEZ();
                }
            } else {
                writeData.setVcodeMD5(yVar.getVcode_md5());
                writeData.setVcodeUrl(yVar.getVcode_pic_url());
                writeData.setVcodeExtra(yVar.aGR());
                WriteShareActivity.this.jSe = true;
                if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener jSn = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.jSc != null && WriteShareActivity.this.jSc.cFt() != null && WriteShareActivity.this.jSc.cFt().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.jSc.cFt(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cFg();
                if (WriteShareActivity.this.jSf) {
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
    private View.OnClickListener jSo = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cFg();
            if (WriteShareActivity.this.jSf) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener jSp = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFr());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFs());
            WriteShareActivity.this.cFk();
        }
    };
    private View.OnClickListener jSq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.jSc.cFs().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFs());
        }
    };
    private final View.OnFocusChangeListener jSr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.jSc != null) {
                if (view == WriteShareActivity.this.jSc.cFr() || view == WriteShareActivity.this.jSc.cFu() || view == WriteShareActivity.this.jSc.cFv()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFr());
                    } else if (view == WriteShareActivity.this.jSc.cFr() && WriteShareActivity.this.jSc.cFw() != null) {
                        WriteShareActivity.this.jSc.cFw().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.jSc.cFs()) {
                    if (z) {
                        WriteShareActivity.this.jSc.cFs().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.jSc.cFs().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.jSc.cFr());
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
        this.bNz = getPageContext().getPageActivity().getPackageManager();
        bds();
        boolean cFb = cFb();
        initData(bundle);
        initUI();
        if (!cFb) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                BP(R.string.share_parameter_invalid_tip);
            } else {
                BP(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cFc();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bds() {
        this.packageName = getCallingPackage();
        if (this.bNz != null && this.packageName != null) {
            try {
                this.jRZ = this.bNz.getPackageInfo(this.packageName, 64);
                if (this.jRZ != null) {
                    if (this.jRZ.applicationInfo != null && this.jRZ.applicationInfo.loadLabel(this.bNz) != null) {
                        this.mAppName = this.jRZ.applicationInfo.loadLabel(this.bNz).toString();
                    }
                    if (this.jRZ.signatures != null && this.jRZ.signatures.length > 0 && this.jRZ.signatures[0] != null) {
                        this.jRY = as.getAPKHexMD5(this.jRZ.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.jRY = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.jRW = extras.getString("ShareUrl");
            this.cPY = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.jRX = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.jRY)) {
                this.jRY = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cFb() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cPY) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cFc() {
        if (TextUtils.isEmpty(this.jRX)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cFd();
        }
    }

    private void cFd() {
        this.jSc.cFm();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jSd.Ii(this.jSa.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFe() {
        if (this.jSg == null) {
            this.jSg = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jSg.sg(false);
            this.jSg.BL(R.drawable.icon_send_ok);
            this.jSg.BO(R.string.share_alert_success);
            this.jSg.a(R.string.share_stay_in_tieba, this.jSi);
            this.jSg.b(R.string.back, this.jSk);
            this.jSg.a(this.jSn);
            this.jSg.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFf() {
        if (this.jSh == null) {
            this.jSh = new com.baidu.tieba.sharewrite.a(getActivity());
            this.jSh.BL(R.drawable.icon_send_error);
            this.jSh.BM(R.drawable.btn_w_square);
            this.jSh.BN(R.color.common_color_10039);
            this.jSh.BO(R.string.share_alert_fail);
            this.jSh.a(R.string.share_keep_sending, this.jSj);
            this.jSh.b(R.string.back, this.jSk);
            this.jSh.a(this.jSn);
            this.jSh.f(getPageContext());
        }
    }

    protected void cFg() {
        if (this.dtU != null) {
            this.dtU.cancelLoadData();
        }
    }

    protected void cFh() {
        if (this.dtU != null) {
            this.dtU.cJI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cFg();
        cFh();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cFx;
        if (this.jSc != null && (cFx = this.jSc.cFx()) != null) {
            cFx.setImageBitmap(null);
        }
    }

    public WriteData cFi() {
        return this.jSa;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jSc != null && this.jSc.cFt() != null && this.jSc.cFt().isShowing()) {
                g.dismissPopupWindow(this.jSc.cFt(), getPageContext().getPageActivity());
                return true;
            }
            cFg();
            if (this.jSf) {
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
        if (this.jSc != null) {
            this.jSc.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jSc = new c(this);
        this.jSc.ac(this.jSo);
        this.jSc.ad(this.jSp);
        this.jSc.b(this.jSr);
        this.jSc.ae(this.jSq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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

    public void BP(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.dtU = new NewWriteModel(this);
        this.dtU.a(this.jSm);
        this.dtU.a(this.jSl);
        this.jSd = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.jSc != null) {
                            WriteShareActivity.this.jSc.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jSc.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.jSc.a((PostPrefixData) null);
            }
        });
        this.fZZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cFg();
            }
        };
        this.jSa = new WriteData();
        this.jSa.setType(3);
        if (bundle != null) {
            this.jSa.setForumName(bundle.getString("forum_name"));
            this.jSa.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.jSa.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.jSa.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.jSa.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.jSa.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.jSa.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.jSa.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.jSa.setForumName(this.jRX);
            this.jSa.setShareSummaryTitle(this.mShareTitle);
            this.jSa.setShareSummaryContent(this.mShareContent);
            this.jSa.setShareApiKey(this.mAppKey);
            this.jSa.setShareAppName(this.mAppName);
            this.jSa.setShareSignKey(this.jRY);
            this.jSa.setShareReferUrl(this.jRW);
            boolean isLocalImagePath = m.isLocalImagePath(this.cPY);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dtU.e(this.mShareLocalImageData, this.cPY);
                this.jSa.setShareLocalImageUri(this.cPY);
                this.jSa.setShareLocalImageData(this.mShareLocalImageData);
                this.dtU.bxZ();
                this.jSa.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.jSa.setShareSummaryImg(this.cPY);
                this.jSa.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.jSa.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.jSa.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.jSa.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.jSa.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.jSa.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.jSa.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.jSa.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.jSa.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.jSa.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.jSa.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.jSa.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.jSa.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.jSa.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.jSa.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.jSa.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.jSa.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jSa.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.jSc != null && this.jSc.cFs() != null && (obj = this.jSc.cFs().getEditableText().toString()) != null) {
            this.jSc.cFs().setText(TbFaceManager.aMY().aA(getPageContext().getContext(), obj));
            this.jSc.cFs().setSelection(this.jSc.cFs().getText().length());
        }
    }

    public void BQ(int i) {
        this.jSb = i;
    }

    public int cFj() {
        return this.jSb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFk() {
        cFg();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.jSb != this.mPrefixData.getPrefixs().size() - 1) {
            this.jSa.setTitle(this.jSc.cFw().getText().toString() + this.jSc.cFr().getText().toString());
        } else {
            this.jSa.setTitle(this.jSc.cFr().getText().toString());
        }
        this.jSa.setContent(this.jSc.cFs().getText().toString());
        this.dtU.d(this.jSa);
        this.jSa.setVcode(null);
        this.dtU.cFi().setVoice(null);
        this.dtU.cFi().setVoiceDuringTime(-1);
        if (this.dtU.cJG()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.fZZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.jSe = false;
            if (i2 == -1) {
                cFe();
                if (this.jSg != null) {
                    this.jSf = true;
                    this.jSg.cEZ();
                }
                setResult(-1);
                return;
            }
            cFf();
            if (this.jSh != null) {
                this.jSf = false;
                this.jSh.cEZ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.jRX = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.jSa.setForumName(this.jRX);
                    cFd();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cFc();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.jSc.cFr());
        HidenSoftKeyPad(this.mInputManager, this.jSc.cFs());
        super.onPause();
    }

    public void cFl() {
        HidenSoftKeyPad(this.mInputManager, this.jSc.cFr());
        HidenSoftKeyPad(this.mInputManager, this.jSc.cFs());
    }
}
