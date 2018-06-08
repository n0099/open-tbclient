package com.baidu.tieba.sharewrite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.d;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.sina.weibo.sdk.constant.WBConstants;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private NewWriteModel aMT;
    private String gxR;
    private String gxS;
    private String gxT;
    private String gxU;
    private PackageManager gxV;
    private PackageInfo gxW;
    private int gxX;
    private c gxY;
    b gxZ;
    private com.baidu.tieba.sharewrite.a gyc;
    private com.baidu.tieba.sharewrite.a gyd;
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
    private boolean gya = false;
    private boolean gyb = false;
    private a.b gye = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gyf = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsS());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsT());
            WriteShareActivity.this.bsL();
            aVar.dismiss();
        }
    };
    private a.b gyg = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gyb) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gyh = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gyi = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bsG();
                if (WriteShareActivity.this.gyc != null) {
                    WriteShareActivity.this.gyb = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gyc.bsB();
                }
            } else if (tVar == null || writeData == null || tVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bsH();
                if (WriteShareActivity.this.gyd != null) {
                    WriteShareActivity.this.gyb = false;
                    WriteShareActivity.this.gyd.bsB();
                }
            } else {
                writeData.setVcodeMD5(tVar.getVcode_md5());
                writeData.setVcodeUrl(tVar.getVcode_pic_url());
                writeData.setVcodeExtra(tVar.Ck());
                WriteShareActivity.this.gya = true;
                if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gyj = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gxY != null && WriteShareActivity.this.gxY.bsU() != null && WriteShareActivity.this.gxY.bsU().isShowing()) {
                    g.a(WriteShareActivity.this.gxY.bsU(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bsI();
                if (WriteShareActivity.this.gyb) {
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
    private View.OnClickListener gyk = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bsI();
            if (WriteShareActivity.this.gyb) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gyl = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsS());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsT());
            WriteShareActivity.this.bsL();
        }
    };
    private View.OnClickListener gym = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gxY.bsT().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsT());
        }
    };
    private final View.OnFocusChangeListener gyn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gxY != null) {
                if (view == WriteShareActivity.this.gxY.bsS() || view == WriteShareActivity.this.gxY.bsV() || view == WriteShareActivity.this.gxY.bsW()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsS());
                    } else if (view == WriteShareActivity.this.gxY.bsS() && WriteShareActivity.this.gxY.bsX() != null) {
                        WriteShareActivity.this.gxY.bsX().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gxY.bsT()) {
                    if (z) {
                        WriteShareActivity.this.gxY.bsT().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gxY.bsT().setHint(d.k.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gxY.bsS());
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
        this.gxV = getPageContext().getPageActivity().getPackageManager();
        afb();
        boolean bsD = bsD();
        initData(bundle);
        initUI();
        if (!bsD) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                sX(d.k.share_parameter_invalid_tip);
            } else {
                sX(d.k.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bsE();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void afb() {
        this.packageName = getCallingPackage();
        if (this.gxV != null && this.packageName != null) {
            try {
                this.gxW = this.gxV.getPackageInfo(this.packageName, 64);
                if (this.gxW != null) {
                    if (this.gxW.applicationInfo != null && this.gxW.applicationInfo.loadLabel(this.gxV) != null) {
                        this.mAppName = this.gxW.applicationInfo.loadLabel(this.gxV).toString();
                    }
                    if (this.gxW.signatures != null && this.gxW.signatures.length > 0 && this.gxW.signatures[0] != null) {
                        this.gxU = ar.x(this.gxW.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gxU = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gxR = extras.getString("ShareUrl");
            this.gxS = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gxT = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gxU)) {
                this.gxU = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bsD() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gxS) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
    }

    private void bsE() {
        if (TextUtils.isEmpty(this.gxT)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bsF();
        }
    }

    private void bsF() {
        this.gxY.bsN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gxZ.tr(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        if (this.gyc == null) {
            this.gyc = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gyc.me(false);
            this.gyc.sT(d.f.icon_send_ok);
            this.gyc.sW(d.k.share_alert_success);
            this.gyc.a(d.k.share_stay_in_tieba, this.gye);
            this.gyc.b(d.k.back, this.gyg);
            this.gyc.a(this.gyj);
            this.gyc.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsH() {
        if (this.gyd == null) {
            this.gyd = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gyd.sT(d.f.icon_send_error);
            this.gyd.sU(d.f.btn_w_square);
            this.gyd.sV(d.C0141d.common_color_10039);
            this.gyd.sW(d.k.share_alert_fail);
            this.gyd.a(d.k.share_keep_sending, this.gyf);
            this.gyd.b(d.k.back, this.gyg);
            this.gyd.a(this.gyj);
            this.gyd.g(getPageContext());
        }
    }

    protected void bsI() {
        if (this.aMT != null) {
            this.aMT.cancelLoadData();
        }
    }

    protected void bsJ() {
        if (this.aMT != null) {
            this.aMT.ahM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bsI();
        bsJ();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bsY;
        if (this.gxY != null && (bsY = this.gxY.bsY()) != null) {
            bsY.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gxY != null && this.gxY.bsU() != null && this.gxY.bsU().isShowing()) {
                g.a(this.gxY.bsU(), getPageContext().getPageActivity());
                return true;
            }
            bsI();
            if (this.gyb) {
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
        if (this.gxY != null) {
            this.gxY.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.i.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gxY = new c(this);
        this.gxY.S(this.gyk);
        this.gxY.T(this.gyl);
        this.gxY.b(this.gyn);
        this.gxY.U(this.gym);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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

    public void sX(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aMT = new NewWriteModel(this);
        this.aMT.a(this.gyi);
        this.aMT.a(this.gyh);
        this.gxZ = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.k.write_no_prefix));
                        if (WriteShareActivity.this.gxY != null) {
                            WriteShareActivity.this.gxY.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gxY.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gxY.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bsI();
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
            this.mData.setForumName(this.gxT);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gxU);
            this.mData.setShareReferUrl(this.gxR);
            boolean eo = com.baidu.tbadk.core.util.l.eo(this.gxS);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || eo) {
                this.aMT.e(this.mShareLocalImageData, this.gxS);
                this.mData.setShareLocalImageUri(this.gxS);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aMT.aqv();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gxS);
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
        if (this.gxY != null && this.gxY.bsT() != null && (obj = this.gxY.bsT().getEditableText().toString()) != null) {
            this.gxY.bsT().setText(TbFaceManager.IC().U(getPageContext().getContext(), obj));
            this.gxY.bsT().setSelection(this.gxY.bsT().getText().length());
        }
    }

    public void sY(int i) {
        this.gxX = i;
    }

    public int bsK() {
        return this.gxX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsL() {
        bsI();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gxX != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gxY.bsX().getText().toString() + this.gxY.bsS().getText().toString());
        } else {
            this.mData.setTitle(this.gxY.bsS().getText().toString());
        }
        this.mData.setContent(this.gxY.bsT().getText().toString());
        this.aMT.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aMT.getWriteData().setVoice(null);
        this.aMT.getWriteData().setVoiceDuringTime(-1);
        if (this.aMT.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gya = false;
            if (i2 == -1) {
                bsG();
                if (this.gyc != null) {
                    this.gyb = true;
                    this.gyc.bsB();
                }
                setResult(-1);
                return;
            }
            bsH();
            if (this.gyd != null) {
                this.gyb = false;
                this.gyd.bsB();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gxT = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gxT);
                    bsF();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bsE();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gxY.bsS());
        HidenSoftKeyPad(this.mInputManager, this.gxY.bsT());
        super.onPause();
    }

    public void bsM() {
        HidenSoftKeyPad(this.mInputManager, this.gxY.bsS());
        HidenSoftKeyPad(this.mInputManager, this.gxY.bsT());
    }
}
