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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager aTn;
    private String bLp;
    private NewWriteModel csq;
    private String iOO;
    private String iOP;
    private String iOQ;
    private PackageInfo iOR;
    private int iOS;
    private c iOT;
    b iOU;
    private com.baidu.tieba.sharewrite.a iOX;
    private com.baidu.tieba.sharewrite.a iOY;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mData = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private boolean iOV = false;
    private boolean iOW = false;
    private a.b iOZ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iPa = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjz());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjA());
            WriteShareActivity.this.cjs();
            aVar.dismiss();
        }
    };
    private a.b iPb = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iOW) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iPc = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mData.setShareSummaryImg("");
                WriteShareActivity.this.mData.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mData.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c iPd = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, x xVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cjn();
                if (WriteShareActivity.this.iOX != null) {
                    WriteShareActivity.this.iOW = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iOX.cji();
                }
            } else if (xVar == null || writeData == null || xVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cjo();
                if (WriteShareActivity.this.iOY != null) {
                    WriteShareActivity.this.iOW = false;
                    WriteShareActivity.this.iOY.cji();
                }
            } else {
                writeData.setVcodeMD5(xVar.getVcode_md5());
                writeData.setVcodeUrl(xVar.getVcode_pic_url());
                writeData.setVcodeExtra(xVar.alA());
                WriteShareActivity.this.iOV = true;
                if (com.baidu.tbadk.v.a.rc(xVar.alz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iPe = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.iOT != null && WriteShareActivity.this.iOT.cjB() != null && WriteShareActivity.this.iOT.cjB().isShowing()) {
                    g.a(WriteShareActivity.this.iOT.cjB(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cjp();
                if (WriteShareActivity.this.iOW) {
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
    private View.OnClickListener iPf = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cjp();
            if (WriteShareActivity.this.iOW) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iPg = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjz());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjA());
            WriteShareActivity.this.cjs();
        }
    };
    private View.OnClickListener iPh = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.iOT.cjA().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjA());
        }
    };
    private final View.OnFocusChangeListener iPi = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.iOT != null) {
                if (view == WriteShareActivity.this.iOT.cjz() || view == WriteShareActivity.this.iOT.cjC() || view == WriteShareActivity.this.iOT.cjD()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjz());
                    } else if (view == WriteShareActivity.this.iOT.cjz() && WriteShareActivity.this.iOT.cjE() != null) {
                        WriteShareActivity.this.iOT.cjE().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.iOT.cjA()) {
                    if (z) {
                        WriteShareActivity.this.iOT.cjA().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.iOT.cjA().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iOT.cjz());
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
        this.aTn = getPageContext().getPageActivity().getPackageManager();
        aTT();
        boolean cjk = cjk();
        initData(bundle);
        initUI();
        if (!cjk) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Ab(R.string.share_parameter_invalid_tip);
            } else {
                Ab(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cjl();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aTT() {
        this.packageName = getCallingPackage();
        if (this.aTn != null && this.packageName != null) {
            try {
                this.iOR = this.aTn.getPackageInfo(this.packageName, 64);
                if (this.iOR != null) {
                    if (this.iOR.applicationInfo != null && this.iOR.applicationInfo.loadLabel(this.aTn) != null) {
                        this.mAppName = this.iOR.applicationInfo.loadLabel(this.aTn).toString();
                    }
                    if (this.iOR.signatures != null && this.iOR.signatures.length > 0 && this.iOR.signatures[0] != null) {
                        this.iOQ = as.F(this.iOR.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.iOQ = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.iOO = extras.getString("ShareUrl");
            this.bLp = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.iOP = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.iOQ)) {
                this.iOQ = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cjk() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.bLp) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cjl() {
        if (TextUtils.isEmpty(this.iOP)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            cjm();
        }
    }

    private void cjm() {
        this.iOT.cju();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iOU.DC(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjn() {
        if (this.iOX == null) {
            this.iOX = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iOX.qw(false);
            this.iOX.zX(R.drawable.icon_send_ok);
            this.iOX.Aa(R.string.share_alert_success);
            this.iOX.a(R.string.share_stay_in_tieba, this.iOZ);
            this.iOX.b(R.string.back, this.iPb);
            this.iOX.a(this.iPe);
            this.iOX.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjo() {
        if (this.iOY == null) {
            this.iOY = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iOY.zX(R.drawable.icon_send_error);
            this.iOY.zY(R.drawable.btn_w_square);
            this.iOY.zZ(R.color.common_color_10039);
            this.iOY.Aa(R.string.share_alert_fail);
            this.iOY.a(R.string.share_keep_sending, this.iPa);
            this.iOY.b(R.string.back, this.iPb);
            this.iOY.a(this.iPe);
            this.iOY.f(getPageContext());
        }
    }

    protected void cjp() {
        if (this.csq != null) {
            this.csq.cancelLoadData();
        }
    }

    protected void cjq() {
        if (this.csq != null) {
            this.csq.aWd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cjp();
        cjq();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cjF;
        if (this.iOT != null && (cjF = this.iOT.cjF()) != null) {
            cjF.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iOT != null && this.iOT.cjB() != null && this.iOT.cjB().isShowing()) {
                g.a(this.iOT.cjB(), getPageContext().getPageActivity());
                return true;
            }
            cjp();
            if (this.iOW) {
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
        if (this.iOT != null) {
            this.iOT.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iOT = new c(this);
        this.iOT.Y(this.iPf);
        this.iOT.Z(this.iPg);
        this.iOT.b(this.iPi);
        this.iOT.aa(this.iPh);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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

    public void Ab(int i) {
        l.f(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.csq = new NewWriteModel(this);
        this.csq.a(this.iPd);
        this.csq.a(this.iPc);
        this.iOU = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.iOT != null) {
                            WriteShareActivity.this.iOT.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iOT.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iOT.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cjp();
            }
        };
        this.mData = new WriteData();
        this.mData.setType(3);
        if (bundle != null) {
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mData.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mData.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mData.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mData.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mData.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mData.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mData.setForumName(this.iOP);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.iOQ);
            this.mData.setShareReferUrl(this.iOO);
            boolean nt = m.nt(this.bLp);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || nt) {
                this.csq.g(this.mShareLocalImageData, this.bLp);
                this.mData.setShareLocalImageUri(this.bLp);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.csq.bfT();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.bLp);
                this.mData.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mData.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mData.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mData.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mData.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mData.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mData.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mData.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mData.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mData.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mData.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mData.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mData.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mData.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mData.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mData.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mData.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.iOT != null && this.iOT.cjA() != null && (obj = this.iOT.cjA().getEditableText().toString()) != null) {
            this.iOT.cjA().setText(TbFaceManager.aso().al(getPageContext().getContext(), obj));
            this.iOT.cjA().setSelection(this.iOT.cjA().getText().length());
        }
    }

    public void Ac(int i) {
        this.iOS = i;
    }

    public int cjr() {
        return this.iOS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjs() {
        cjp();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.iOS != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.iOT.cjE().getText().toString() + this.iOT.cjz().getText().toString());
        } else {
            this.mData.setTitle(this.iOT.cjz().getText().toString());
        }
        this.mData.setContent(this.iOT.cjA().getText().toString());
        this.csq.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.csq.getWriteData().setVoice(null);
        this.csq.getWriteData().setVoiceDuringTime(-1);
        if (this.csq.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iOV = false;
            if (i2 == -1) {
                cjn();
                if (this.iOX != null) {
                    this.iOW = true;
                    this.iOX.cji();
                }
                setResult(-1);
                return;
            }
            cjo();
            if (this.iOY != null) {
                this.iOW = false;
                this.iOY.cji();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.iOP = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.iOP);
                    cjm();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cjl();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.iOT.cjz());
        HidenSoftKeyPad(this.mInputManager, this.iOT.cjA());
        super.onPause();
    }

    public void cjt() {
        HidenSoftKeyPad(this.mInputManager, this.iOT.cjz());
        HidenSoftKeyPad(this.mInputManager, this.iOT.cjA());
    }
}
