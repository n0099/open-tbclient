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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dJF;
    private String eUZ;
    private NewWriteModel fFg;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String nok;
    private String nol;
    private String nom;
    private PackageInfo non;
    private int nop;
    private c noq;
    b nor;
    private com.baidu.tieba.sharewrite.a nov;
    private com.baidu.tieba.sharewrite.a nox;
    private String packageName;
    private WriteData noo = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iYW = null;
    private boolean nos = false;
    private boolean nou = false;
    private a.b noy = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.noo.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b noz = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKk());
            WriteShareActivity.this.dKc();
            aVar.dismiss();
        }
    };
    private a.b noA = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nou) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b noB = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.noo.setShareSummaryImg("");
                WriteShareActivity.this.noo.setShareSummaryImgHeight(0);
                WriteShareActivity.this.noo.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.noo.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.noo.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.noo.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c noC = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dJX();
                if (WriteShareActivity.this.nov != null) {
                    WriteShareActivity.this.nou = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nov.dJS();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dJY();
                if (WriteShareActivity.this.nox != null) {
                    WriteShareActivity.this.nou = false;
                    WriteShareActivity.this.nox.dJS();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bwI());
                WriteShareActivity.this.nos = true;
                if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwH())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener noD = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.noq != null && WriteShareActivity.this.noq.dKl() != null && WriteShareActivity.this.noq.dKl().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.noq.dKl(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dJZ();
                if (WriteShareActivity.this.nou) {
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
    private View.OnClickListener noE = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dJZ();
            if (WriteShareActivity.this.nou) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener noF = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKk());
            WriteShareActivity.this.dKc();
        }
    };
    private View.OnClickListener noG = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.noq.dKk().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKk());
        }
    };
    private final View.OnFocusChangeListener hzb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.noq != null) {
                if (view == WriteShareActivity.this.noq.dKj() || view == WriteShareActivity.this.noq.dKm() || view == WriteShareActivity.this.noq.dKn()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKj());
                    } else if (view == WriteShareActivity.this.noq.dKj() && WriteShareActivity.this.noq.dKo() != null) {
                        WriteShareActivity.this.noq.dKo().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.noq.dKk()) {
                    if (z) {
                        WriteShareActivity.this.noq.dKk().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.noq.dKk().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.noq.dKj());
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
        this.dJF = getPageContext().getPageActivity().getPackageManager();
        cmx();
        boolean dJU = dJU();
        initData(bundle);
        initUI();
        if (!dJU) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Jk(R.string.share_parameter_invalid_tip);
            } else {
                Jk(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dJV();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cmx() {
        this.packageName = getCallingPackage();
        if (this.dJF != null && this.packageName != null) {
            try {
                this.non = this.dJF.getPackageInfo(this.packageName, 64);
                if (this.non != null) {
                    if (this.non.applicationInfo != null && this.non.applicationInfo.loadLabel(this.dJF) != null) {
                        this.mAppName = this.non.applicationInfo.loadLabel(this.dJF).toString();
                    }
                    if (this.non.signatures != null && this.non.signatures.length > 0 && this.non.signatures[0] != null) {
                        this.nom = aw.getAPKHexMD5(this.non.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nom = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.nok = extras.getString("ShareUrl");
            this.eUZ = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.nol = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nom)) {
                this.nom = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dJU() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eUZ) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dJV() {
        if (TextUtils.isEmpty(this.nol)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dJW();
        }
    }

    private void dJW() {
        this.noq.dKe();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nor.SR(this.noo.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJX() {
        if (this.nov == null) {
            this.nov = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nov.xZ(false);
            this.nov.Jg(R.drawable.icon_send_ok);
            this.nov.Jj(R.string.share_alert_success);
            this.nov.a(R.string.share_stay_in_tieba, this.noy);
            this.nov.b(R.string.back, this.noA);
            this.nov.b(this.noD);
            this.nov.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJY() {
        if (this.nox == null) {
            this.nox = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nox.Jg(R.drawable.icon_send_error);
            this.nox.Jh(R.drawable.btn_w_square);
            this.nox.Ji(R.color.common_color_10039);
            this.nox.Jj(R.string.share_alert_fail);
            this.nox.a(R.string.share_keep_sending, this.noz);
            this.nox.b(R.string.back, this.noA);
            this.nox.b(this.noD);
            this.nox.g(getPageContext());
        }
    }

    protected void dJZ() {
        if (this.fFg != null) {
            this.fFg.cancelLoadData();
        }
    }

    protected void dKa() {
        if (this.fFg != null) {
            this.fFg.dPC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dJZ();
        dKa();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dKp;
        if (this.noq != null && (dKp = this.noq.dKp()) != null) {
            dKp.setImageBitmap(null);
        }
    }

    public WriteData daL() {
        return this.noo;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.noq != null && this.noq.dKl() != null && this.noq.dKl().isShowing()) {
                g.dismissPopupWindow(this.noq.dKl(), getPageContext().getPageActivity());
                return true;
            }
            dJZ();
            if (this.nou) {
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
        if (this.noq != null) {
            this.noq.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.noq = new c(this);
        this.noq.ai(this.noE);
        this.noq.aj(this.noF);
        this.noq.b(this.hzb);
        this.noq.ak(this.noG);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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

    public void Jk(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fFg = new NewWriteModel(this);
        this.fFg.a(this.noC);
        this.fFg.a(this.noB);
        this.nor = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.noq != null) {
                            WriteShareActivity.this.noq.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.noq.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.noq.a((PostPrefixData) null);
            }
        });
        this.iYW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dJZ();
            }
        };
        this.noo = new WriteData();
        this.noo.setType(3);
        if (bundle != null) {
            this.noo.setForumName(bundle.getString("forum_name"));
            this.noo.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.noo.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.noo.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.noo.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.noo.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.noo.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.noo.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.noo.setForumName(this.nol);
            this.noo.setShareSummaryTitle(this.mShareTitle);
            this.noo.setShareSummaryContent(this.mShareContent);
            this.noo.setShareApiKey(this.mAppKey);
            this.noo.setShareAppName(this.mAppName);
            this.noo.setShareSignKey(this.nom);
            this.noo.setShareReferUrl(this.nok);
            boolean isLocalImagePath = o.isLocalImagePath(this.eUZ);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fFg.e(this.mShareLocalImageData, this.eUZ);
                this.noo.setShareLocalImageUri(this.eUZ);
                this.noo.setShareLocalImageData(this.mShareLocalImageData);
                this.fFg.czh();
                this.noo.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.noo.setShareSummaryImg(this.eUZ);
                this.noo.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.noo.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.noo.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.noo.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.noo.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.noo.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.noo.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.noo.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.noo.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.noo.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.noo.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.noo.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.noo.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.noo.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.noo.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.noo.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.noo.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.noo.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.noq != null && this.noq.dKk() != null && (obj = this.noq.dKk().getEditableText().toString()) != null) {
            this.noq.dKk().setText(TbFaceManager.bCR().aD(getPageContext().getContext(), obj));
            this.noq.dKk().setSelection(this.noq.dKk().getText().length());
        }
    }

    public void Jl(int i) {
        this.nop = i;
    }

    public int dKb() {
        return this.nop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKc() {
        dJZ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.nop != this.mPrefixData.getPrefixs().size() - 1) {
            this.noo.setTitle(this.noq.dKo().getText().toString() + this.noq.dKj().getText().toString());
        } else {
            this.noo.setTitle(this.noq.dKj().getText().toString());
        }
        this.noo.setContent(this.noq.dKk().getText().toString());
        this.fFg.f(this.noo);
        this.noo.setVcode(null);
        this.fFg.daL().setVoice(null);
        this.fFg.daL().setVoiceDuringTime(-1);
        if (this.fFg.dPm()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iYW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.nos = false;
            if (i2 == -1) {
                dJX();
                if (this.nov != null) {
                    this.nou = true;
                    this.nov.dJS();
                }
                setResult(-1);
                return;
            }
            dJY();
            if (this.nox != null) {
                this.nou = false;
                this.nox.dJS();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.nol = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.noo.setForumName(this.nol);
                    dJW();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dJV();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.noq.dKj());
        HidenSoftKeyPad(this.mInputManager, this.noq.dKk());
        super.onPause();
    }

    public void dKd() {
        HidenSoftKeyPad(this.mInputManager, this.noq.dKj());
        HidenSoftKeyPad(this.mInputManager, this.noq.dKk());
    }
}
