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
/* loaded from: classes6.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager bnh;
    private NewWriteModel cFZ;
    private String cdK;
    private String iXC;
    private String iXD;
    private String iXE;
    private String iXF;
    private PackageInfo iXG;
    private int iXI;
    private c iXJ;
    b iXK;
    private com.baidu.tieba.sharewrite.a iXN;
    private com.baidu.tieba.sharewrite.a iXO;
    private String mAppKey;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData iXH = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener flB = null;
    private boolean iXL = false;
    private boolean iXM = false;
    private a.b iXP = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.iXH.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b iXQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clk());
            WriteShareActivity.this.clc();
            aVar.dismiss();
        }
    };
    private a.b iXR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.iXM) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b iXS = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.iXH.setShareSummaryImg("");
                WriteShareActivity.this.iXH.setShareSummaryImgHeight(0);
                WriteShareActivity.this.iXH.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.iXH.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.iXH.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.iXH.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c iXT = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, y yVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.ckW();
                if (WriteShareActivity.this.iXN != null) {
                    WriteShareActivity.this.iXM = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.iXN.ckR();
                }
            } else if (yVar == null || writeData == null || yVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.ckX();
                if (WriteShareActivity.this.iXO != null) {
                    WriteShareActivity.this.iXM = false;
                    WriteShareActivity.this.iXO.ckR();
                }
            } else {
                writeData.setVcodeMD5(yVar.getVcode_md5());
                writeData.setVcodeUrl(yVar.getVcode_pic_url());
                writeData.setVcodeExtra(yVar.aps());
                WriteShareActivity.this.iXL = true;
                if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener iXU = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.iXJ != null && WriteShareActivity.this.iXJ.cll() != null && WriteShareActivity.this.iXJ.cll().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.iXJ.cll(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.ckY();
                if (WriteShareActivity.this.iXM) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener iXV = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.ckY();
            if (WriteShareActivity.this.iXM) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.f.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener iXW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clk());
            WriteShareActivity.this.clc();
        }
    };
    private View.OnClickListener iXX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.iXJ.clk().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clk());
        }
    };
    private final View.OnFocusChangeListener iXY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.iXJ != null) {
                if (view == WriteShareActivity.this.iXJ.clj() || view == WriteShareActivity.this.iXJ.clm() || view == WriteShareActivity.this.iXJ.cln()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clj());
                    } else if (view == WriteShareActivity.this.iXJ.clj() && WriteShareActivity.this.iXJ.clo() != null) {
                        WriteShareActivity.this.iXJ.clo().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.iXJ.clk()) {
                    if (z) {
                        WriteShareActivity.this.iXJ.clk().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.iXJ.clk().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.iXJ.clj());
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
        this.bnh = getPageContext().getPageActivity().getPackageManager();
        aXe();
        boolean ckT = ckT();
        initData(bundle);
        initUI();
        if (!ckT) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                zt(R.string.share_parameter_invalid_tip);
            } else {
                zt(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            ckU();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void aXe() {
        this.packageName = getCallingPackage();
        if (this.bnh != null && this.packageName != null) {
            try {
                this.iXG = this.bnh.getPackageInfo(this.packageName, 64);
                if (this.iXG != null) {
                    if (this.iXG.applicationInfo != null && this.iXG.applicationInfo.loadLabel(this.bnh) != null) {
                        this.iXE = this.iXG.applicationInfo.loadLabel(this.bnh).toString();
                    }
                    if (this.iXG.signatures != null && this.iXG.signatures.length > 0 && this.iXG.signatures[0] != null) {
                        this.iXF = as.getAPKHexMD5(this.iXG.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.iXE = null;
                this.iXF = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.iXC = extras.getString("ShareUrl");
            this.cdK = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.iXD = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.iXE)) {
                this.iXE = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.iXF)) {
                this.iXF = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean ckT() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cdK) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void ckU() {
        if (TextUtils.isEmpty(this.iXD)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            ckV();
        }
    }

    private void ckV() {
        this.iXJ.cle();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iXK.Dv(this.iXH.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckW() {
        if (this.iXN == null) {
            this.iXN = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iXN.qy(false);
            this.iXN.zp(R.drawable.icon_send_ok);
            this.iXN.zs(R.string.share_alert_success);
            this.iXN.a(R.string.share_stay_in_tieba, this.iXP);
            this.iXN.b(R.string.back, this.iXR);
            this.iXN.a(this.iXU);
            this.iXN.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckX() {
        if (this.iXO == null) {
            this.iXO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.iXO.zp(R.drawable.icon_send_error);
            this.iXO.zq(R.drawable.btn_w_square);
            this.iXO.zr(R.color.common_color_10039);
            this.iXO.zs(R.string.share_alert_fail);
            this.iXO.a(R.string.share_keep_sending, this.iXQ);
            this.iXO.b(R.string.back, this.iXR);
            this.iXO.a(this.iXU);
            this.iXO.f(getPageContext());
        }
    }

    protected void ckY() {
        if (this.cFZ != null) {
            this.cFZ.cancelLoadData();
        }
    }

    protected void ckZ() {
        if (this.cFZ != null) {
            this.cFZ.cpE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ckY();
        ckZ();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView clp;
        if (this.iXJ != null && (clp = this.iXJ.clp()) != null) {
            clp.setImageBitmap(null);
        }
    }

    public WriteData cla() {
        return this.iXH;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.iXJ != null && this.iXJ.cll() != null && this.iXJ.cll().isShowing()) {
                g.dismissPopupWindow(this.iXJ.cll(), getPageContext().getPageActivity());
                return true;
            }
            ckY();
            if (this.iXM) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iXJ != null) {
            this.iXJ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iXJ = new c(this);
        this.iXJ.ab(this.iXV);
        this.iXJ.ac(this.iXW);
        this.iXJ.b(this.iXY);
        this.iXJ.ad(this.iXX);
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
                com.baidu.tbadk.core.f.b.c(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void zt(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.cFZ = new NewWriteModel(this);
        this.cFZ.a(this.iXT);
        this.cFZ.a(this.iXS);
        this.iXK = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.iXJ != null) {
                            WriteShareActivity.this.iXJ.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iXJ.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.iXJ.a((PostPrefixData) null);
            }
        });
        this.flB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.ckY();
            }
        };
        this.iXH = new WriteData();
        this.iXH.setType(3);
        if (bundle != null) {
            this.iXH.setForumName(bundle.getString("forum_name"));
            this.iXH.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.iXH.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.iXH.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.iXH.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.iXH.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.iXH.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.iXH.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.iXH.setForumName(this.iXD);
            this.iXH.setShareSummaryTitle(this.mShareTitle);
            this.iXH.setShareSummaryContent(this.mShareContent);
            this.iXH.setShareApiKey(this.mAppKey);
            this.iXH.setShareAppName(this.iXE);
            this.iXH.setShareSignKey(this.iXF);
            this.iXH.setShareReferUrl(this.iXC);
            boolean isLocalImagePath = m.isLocalImagePath(this.cdK);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.cFZ.e(this.mShareLocalImageData, this.cdK);
                this.iXH.setShareLocalImageUri(this.cdK);
                this.iXH.setShareLocalImageData(this.mShareLocalImageData);
                this.cFZ.bgE();
                this.iXH.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.iXH.setShareSummaryImg(this.cdK);
                this.iXH.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.iXH.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.iXH.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.iXH.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.iXH.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.iXH.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.iXH.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.iXH.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.iXH.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.iXH.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.iXH.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.iXH.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.iXH.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.iXH.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.iXH.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.iXH.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.iXH.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.iXH.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.iXJ != null && this.iXJ.clk() != null && (obj = this.iXJ.clk().getEditableText().toString()) != null) {
            this.iXJ.clk().setText(TbFaceManager.avr().ah(getPageContext().getContext(), obj));
            this.iXJ.clk().setSelection(this.iXJ.clk().getText().length());
        }
    }

    public void zu(int i) {
        this.iXI = i;
    }

    public int clb() {
        return this.iXI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clc() {
        ckY();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.iXI != this.mPrefixData.getPrefixs().size() - 1) {
            this.iXH.setTitle(this.iXJ.clo().getText().toString() + this.iXJ.clj().getText().toString());
        } else {
            this.iXH.setTitle(this.iXJ.clj().getText().toString());
        }
        this.iXH.setContent(this.iXJ.clk().getText().toString());
        this.cFZ.d(this.iXH);
        this.iXH.setVcode(null);
        this.cFZ.cla().setVoice(null);
        this.cFZ.cla().setVoiceDuringTime(-1);
        if (this.cFZ.cpC()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.flB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.iXL = false;
            if (i2 == -1) {
                ckW();
                if (this.iXN != null) {
                    this.iXM = true;
                    this.iXN.ckR();
                }
                setResult(-1);
                return;
            }
            ckX();
            if (this.iXO != null) {
                this.iXM = false;
                this.iXO.ckR();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.iXD = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.iXH.setForumName(this.iXD);
                    ckV();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                ckU();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.iXJ.clj());
        HidenSoftKeyPad(this.mInputManager, this.iXJ.clk());
        super.onPause();
    }

    public void cld() {
        HidenSoftKeyPad(this.mInputManager, this.iXJ.clj());
        HidenSoftKeyPad(this.mInputManager, this.iXJ.clk());
    }
}
