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
import com.baidu.tieba.d;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager aQy;
    private NewWriteModel ckg;
    private String ivT;
    private String ivU;
    private String ivV;
    private String ivW;
    private PackageInfo ivX;
    private int ivY;
    private c ivZ;
    b iwa;
    private com.baidu.tieba.sharewrite.a iwd;
    private com.baidu.tieba.sharewrite.a iwe;
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
    private boolean iwb = false;
    private boolean iwc = false;
    private a.b iwf = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iwg = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbr());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbs());
            WriteShareActivity.this.cbk();
            aVar.dismiss();
        }
    };
    private a.b iwh = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iwc) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iwi = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c iwj = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, x xVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cbf();
                if (WriteShareActivity.this.iwd != null) {
                    WriteShareActivity.this.iwc = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iwd.cba();
                }
            } else if (xVar == null || writeData == null || xVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cbg();
                if (WriteShareActivity.this.iwe != null) {
                    WriteShareActivity.this.iwc = false;
                    WriteShareActivity.this.iwe.cba();
                }
            } else {
                writeData.setVcodeMD5(xVar.getVcode_md5());
                writeData.setVcodeUrl(xVar.getVcode_pic_url());
                writeData.setVcodeExtra(xVar.agB());
                WriteShareActivity.this.iwb = true;
                if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agA())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iwk = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.ivZ != null && WriteShareActivity.this.ivZ.cbt() != null && WriteShareActivity.this.ivZ.cbt().isShowing()) {
                    g.a(WriteShareActivity.this.ivZ.cbt(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cbh();
                if (WriteShareActivity.this.iwc) {
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
    private View.OnClickListener iwl = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cbh();
            if (WriteShareActivity.this.iwc) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iwm = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbr());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbs());
            WriteShareActivity.this.cbk();
        }
    };
    private View.OnClickListener iwn = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.ivZ.cbs().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbs());
        }
    };
    private final View.OnFocusChangeListener iwo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.ivZ != null) {
                if (view == WriteShareActivity.this.ivZ.cbr() || view == WriteShareActivity.this.ivZ.cbu() || view == WriteShareActivity.this.ivZ.cbv()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbr());
                    } else if (view == WriteShareActivity.this.ivZ.cbr() && WriteShareActivity.this.ivZ.cbw() != null) {
                        WriteShareActivity.this.ivZ.cbw().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.ivZ.cbs()) {
                    if (z) {
                        WriteShareActivity.this.ivZ.cbs().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.ivZ.cbs().setHint(d.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.ivZ.cbr());
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
        this.aQy = getPageContext().getPageActivity().getPackageManager();
        aNG();
        boolean cbc = cbc();
        initData(bundle);
        initUI();
        if (!cbc) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                yT(d.j.share_parameter_invalid_tip);
            } else {
                yT(d.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cbd();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aNG() {
        this.packageName = getCallingPackage();
        if (this.aQy != null && this.packageName != null) {
            try {
                this.ivX = this.aQy.getPackageInfo(this.packageName, 64);
                if (this.ivX != null) {
                    if (this.ivX.applicationInfo != null && this.ivX.applicationInfo.loadLabel(this.aQy) != null) {
                        this.mAppName = this.ivX.applicationInfo.loadLabel(this.aQy).toString();
                    }
                    if (this.ivX.signatures != null && this.ivX.signatures.length > 0 && this.ivX.signatures[0] != null) {
                        this.ivW = as.L(this.ivX.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.ivW = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ivT = extras.getString("ShareUrl");
            this.ivU = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ivV = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.ivW)) {
                this.ivW = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cbc() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.ivU) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cbd() {
        if (TextUtils.isEmpty(this.ivV)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            cbe();
        }
    }

    private void cbe() {
        this.ivZ.cbm();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iwa.Ce(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbf() {
        if (this.iwd == null) {
            this.iwd = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iwd.pG(false);
            this.iwd.yP(d.f.icon_send_ok);
            this.iwd.yS(d.j.share_alert_success);
            this.iwd.a(d.j.share_stay_in_tieba, this.iwf);
            this.iwd.b(d.j.back, this.iwh);
            this.iwd.a(this.iwk);
            this.iwd.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbg() {
        if (this.iwe == null) {
            this.iwe = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iwe.yP(d.f.icon_send_error);
            this.iwe.yQ(d.f.btn_w_square);
            this.iwe.yR(d.C0277d.common_color_10039);
            this.iwe.yS(d.j.share_alert_fail);
            this.iwe.a(d.j.share_keep_sending, this.iwg);
            this.iwe.b(d.j.back, this.iwh);
            this.iwe.a(this.iwk);
            this.iwe.f(getPageContext());
        }
    }

    protected void cbh() {
        if (this.ckg != null) {
            this.ckg.cancelLoadData();
        }
    }

    protected void cbi() {
        if (this.ckg != null) {
            this.ckg.aPQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cbh();
        cbi();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cbx;
        if (this.ivZ != null && (cbx = this.ivZ.cbx()) != null) {
            cbx.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ivZ != null && this.ivZ.cbt() != null && this.ivZ.cbt().isShowing()) {
                g.a(this.ivZ.cbt(), getPageContext().getPageActivity());
                return true;
            }
            cbh();
            if (this.iwc) {
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
        if (this.ivZ != null) {
            this.ivZ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ivZ = new c(this);
        this.ivZ.V(this.iwl);
        this.ivZ.W(this.iwm);
        this.ivZ.b(this.iwo);
        this.ivZ.X(this.iwn);
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
                com.baidu.tbadk.core.e.b.d(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void yT(int i) {
        l.g(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.ckg = new NewWriteModel(this);
        this.ckg.a(this.iwj);
        this.ckg.a(this.iwi);
        this.iwa = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.j.write_no_prefix));
                        if (WriteShareActivity.this.ivZ != null) {
                            WriteShareActivity.this.ivZ.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ivZ.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.ivZ.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cbh();
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
            this.mData.setForumName(this.ivV);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.ivW);
            this.mData.setShareReferUrl(this.ivT);
            boolean mm = m.mm(this.ivU);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || mm) {
                this.ckg.f(this.mShareLocalImageData, this.ivU);
                this.mData.setShareLocalImageUri(this.ivU);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.ckg.aYw();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.ivU);
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
        if (this.ivZ != null && this.ivZ.cbs() != null && (obj = this.ivZ.cbs().getEditableText().toString()) != null) {
            this.ivZ.cbs().setText(TbFaceManager.anl().ax(getPageContext().getContext(), obj));
            this.ivZ.cbs().setSelection(this.ivZ.cbs().getText().length());
        }
    }

    public void yU(int i) {
        this.ivY = i;
    }

    public int cbj() {
        return this.ivY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        cbh();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.ivY != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.ivZ.cbw().getText().toString() + this.ivZ.cbr().getText().toString());
        } else {
            this.mData.setTitle(this.ivZ.cbr().getText().toString());
        }
        this.mData.setContent(this.ivZ.cbs().getText().toString());
        this.ckg.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.ckg.getWriteData().setVoice(null);
        this.ckg.getWriteData().setVoiceDuringTime(-1);
        if (this.ckg.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iwb = false;
            if (i2 == -1) {
                cbf();
                if (this.iwd != null) {
                    this.iwc = true;
                    this.iwd.cba();
                }
                setResult(-1);
                return;
            }
            cbg();
            if (this.iwe != null) {
                this.iwc = false;
                this.iwe.cba();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.ivV = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.ivV);
                    cbe();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cbd();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.ivZ.cbr());
        HidenSoftKeyPad(this.mInputManager, this.ivZ.cbs());
        super.onPause();
    }

    public void cbl() {
        HidenSoftKeyPad(this.mInputManager, this.ivZ.cbr());
        HidenSoftKeyPad(this.mInputManager, this.ivZ.cbs());
    }
}
