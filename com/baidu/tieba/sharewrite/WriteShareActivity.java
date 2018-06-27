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
    private NewWriteModel aNP;
    private String gBK;
    private String gBL;
    private String gBM;
    private String gBN;
    private PackageManager gBO;
    private PackageInfo gBP;
    private int gBQ;
    private c gBR;
    b gBS;
    private com.baidu.tieba.sharewrite.a gBV;
    private com.baidu.tieba.sharewrite.a gBW;
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
    private boolean gBT = false;
    private boolean gBU = false;
    private a.b gBX = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gBY = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.bts());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.btt());
            WriteShareActivity.this.btl();
            aVar.dismiss();
        }
    };
    private a.b gBZ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gBU) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gCa = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gCb = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.btg();
                if (WriteShareActivity.this.gBV != null) {
                    WriteShareActivity.this.gBU = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gBV.btb();
                }
            } else if (tVar == null || writeData == null || tVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bth();
                if (WriteShareActivity.this.gBW != null) {
                    WriteShareActivity.this.gBU = false;
                    WriteShareActivity.this.gBW.btb();
                }
            } else {
                writeData.setVcodeMD5(tVar.getVcode_md5());
                writeData.setVcodeUrl(tVar.getVcode_pic_url());
                writeData.setVcodeExtra(tVar.CC());
                WriteShareActivity.this.gBT = true;
                if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.CB())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gCc = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gBR != null && WriteShareActivity.this.gBR.btu() != null && WriteShareActivity.this.gBR.btu().isShowing()) {
                    g.a(WriteShareActivity.this.gBR.btu(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bti();
                if (WriteShareActivity.this.gBU) {
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
    private View.OnClickListener gCd = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bti();
            if (WriteShareActivity.this.gBU) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gCe = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.bts());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.btt());
            WriteShareActivity.this.btl();
        }
    };
    private View.OnClickListener gCf = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gBR.btt().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.btt());
        }
    };
    private final View.OnFocusChangeListener gCg = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gBR != null) {
                if (view == WriteShareActivity.this.gBR.bts() || view == WriteShareActivity.this.gBR.btv() || view == WriteShareActivity.this.gBR.btw()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.bts());
                    } else if (view == WriteShareActivity.this.gBR.bts() && WriteShareActivity.this.gBR.btx() != null) {
                        WriteShareActivity.this.gBR.btx().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gBR.btt()) {
                    if (z) {
                        WriteShareActivity.this.gBR.btt().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gBR.btt().setHint(d.k.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gBR.bts());
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
        this.gBO = getPageContext().getPageActivity().getPackageManager();
        afJ();
        boolean btd = btd();
        initData(bundle);
        initUI();
        if (!btd) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                th(d.k.share_parameter_invalid_tip);
            } else {
                th(d.k.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bte();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void afJ() {
        this.packageName = getCallingPackage();
        if (this.gBO != null && this.packageName != null) {
            try {
                this.gBP = this.gBO.getPackageInfo(this.packageName, 64);
                if (this.gBP != null) {
                    if (this.gBP.applicationInfo != null && this.gBP.applicationInfo.loadLabel(this.gBO) != null) {
                        this.mAppName = this.gBP.applicationInfo.loadLabel(this.gBO).toString();
                    }
                    if (this.gBP.signatures != null && this.gBP.signatures.length > 0 && this.gBP.signatures[0] != null) {
                        this.gBN = as.y(this.gBP.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gBN = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gBK = extras.getString("ShareUrl");
            this.gBL = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gBM = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gBN)) {
                this.gBN = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean btd() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gBL) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void bte() {
        if (TextUtils.isEmpty(this.gBM)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            btf();
        }
    }

    private void btf() {
        this.gBR.btn();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gBS.tq(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btg() {
        if (this.gBV == null) {
            this.gBV = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gBV.mp(false);
            this.gBV.td(d.f.icon_send_ok);
            this.gBV.tg(d.k.share_alert_success);
            this.gBV.a(d.k.share_stay_in_tieba, this.gBX);
            this.gBV.b(d.k.back, this.gBZ);
            this.gBV.a(this.gCc);
            this.gBV.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        if (this.gBW == null) {
            this.gBW = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gBW.td(d.f.icon_send_error);
            this.gBW.te(d.f.btn_w_square);
            this.gBW.tf(d.C0142d.common_color_10039);
            this.gBW.tg(d.k.share_alert_fail);
            this.gBW.a(d.k.share_keep_sending, this.gBY);
            this.gBW.b(d.k.back, this.gBZ);
            this.gBW.a(this.gCc);
            this.gBW.g(getPageContext());
        }
    }

    protected void bti() {
        if (this.aNP != null) {
            this.aNP.cancelLoadData();
        }
    }

    protected void btj() {
        if (this.aNP != null) {
            this.aNP.ahf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bti();
        btj();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bty;
        if (this.gBR != null && (bty = this.gBR.bty()) != null) {
            bty.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gBR != null && this.gBR.btu() != null && this.gBR.btu().isShowing()) {
                g.a(this.gBR.btu(), getPageContext().getPageActivity());
                return true;
            }
            bti();
            if (this.gBU) {
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
        if (this.gBR != null) {
            this.gBR.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.i.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gBR = new c(this);
        this.gBR.W(this.gCd);
        this.gBR.X(this.gCe);
        this.gBR.b(this.gCg);
        this.gBR.Y(this.gCf);
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

    public void th(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aNP = new NewWriteModel(this);
        this.aNP.a(this.gCb);
        this.aNP.a(this.gCa);
        this.gBS = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.k.write_no_prefix));
                        if (WriteShareActivity.this.gBR != null) {
                            WriteShareActivity.this.gBR.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gBR.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gBR.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bti();
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
            this.mData.setForumName(this.gBM);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gBN);
            this.mData.setShareReferUrl(this.gBK);
            boolean er = com.baidu.tbadk.core.util.l.er(this.gBL);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || er) {
                this.aNP.e(this.mShareLocalImageData, this.gBL);
                this.mData.setShareLocalImageUri(this.gBL);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aNP.apQ();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gBL);
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
        if (this.gBR != null && this.gBR.btt() != null && (obj = this.gBR.btt().getEditableText().toString()) != null) {
            this.gBR.btt().setText(TbFaceManager.IU().U(getPageContext().getContext(), obj));
            this.gBR.btt().setSelection(this.gBR.btt().getText().length());
        }
    }

    public void ti(int i) {
        this.gBQ = i;
    }

    public int btk() {
        return this.gBQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btl() {
        bti();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gBQ != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gBR.btx().getText().toString() + this.gBR.bts().getText().toString());
        } else {
            this.mData.setTitle(this.gBR.bts().getText().toString());
        }
        this.mData.setContent(this.gBR.btt().getText().toString());
        this.aNP.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aNP.getWriteData().setVoice(null);
        this.aNP.getWriteData().setVoiceDuringTime(-1);
        if (this.aNP.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gBT = false;
            if (i2 == -1) {
                btg();
                if (this.gBV != null) {
                    this.gBU = true;
                    this.gBV.btb();
                }
                setResult(-1);
                return;
            }
            bth();
            if (this.gBW != null) {
                this.gBU = false;
                this.gBW.btb();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gBM = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gBM);
                    btf();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bte();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gBR.bts());
        HidenSoftKeyPad(this.mInputManager, this.gBR.btt());
        super.onPause();
    }

    public void btm() {
        HidenSoftKeyPad(this.mInputManager, this.gBR.bts());
        HidenSoftKeyPad(this.mInputManager, this.gBR.btt());
    }
}
