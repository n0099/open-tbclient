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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.f;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.sina.weibo.sdk.constant.WBConstants;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private NewWriteModel aNL;
    private String gCV;
    private String gCW;
    private String gCX;
    private String gCY;
    private PackageManager gCZ;
    private PackageInfo gDa;
    private int gDb;
    private c gDc;
    b gDd;
    private com.baidu.tieba.sharewrite.a gDg;
    private com.baidu.tieba.sharewrite.a gDh;
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
    private boolean gDe = false;
    private boolean gDf = false;
    private a.b gDi = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gDj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brW());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brX());
            WriteShareActivity.this.brP();
            aVar.dismiss();
        }
    };
    private a.b gDk = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gDf) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gDl = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gDm = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, u uVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.brK();
                if (WriteShareActivity.this.gDg != null) {
                    WriteShareActivity.this.gDf = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gDg.brF();
                }
            } else if (uVar == null || writeData == null || uVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.brL();
                if (WriteShareActivity.this.gDh != null) {
                    WriteShareActivity.this.gDf = false;
                    WriteShareActivity.this.gDh.brF();
                }
            } else {
                writeData.setVcodeMD5(uVar.getVcode_md5());
                writeData.setVcodeUrl(uVar.getVcode_pic_url());
                writeData.setVcodeExtra(uVar.Cs());
                WriteShareActivity.this.gDe = true;
                if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gDn = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gDc != null && WriteShareActivity.this.gDc.brY() != null && WriteShareActivity.this.gDc.brY().isShowing()) {
                    g.a(WriteShareActivity.this.gDc.brY(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.brM();
                if (WriteShareActivity.this.gDf) {
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
    private View.OnClickListener gDo = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.brM();
            if (WriteShareActivity.this.gDf) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gDp = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brW());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brX());
            WriteShareActivity.this.brP();
        }
    };
    private View.OnClickListener gDq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gDc.brX().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brX());
        }
    };
    private final View.OnFocusChangeListener gDr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gDc != null) {
                if (view == WriteShareActivity.this.gDc.brW() || view == WriteShareActivity.this.gDc.brZ() || view == WriteShareActivity.this.gDc.bsa()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brW());
                    } else if (view == WriteShareActivity.this.gDc.brW() && WriteShareActivity.this.gDc.bsb() != null) {
                        WriteShareActivity.this.gDc.bsb().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gDc.brX()) {
                    if (z) {
                        WriteShareActivity.this.gDc.brX().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gDc.brX().setHint(f.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gDc.brW());
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
        this.gCZ = getPageContext().getPageActivity().getPackageManager();
        agf();
        boolean brH = brH();
        initData(bundle);
        initUI();
        if (!brH) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                tf(f.j.share_parameter_invalid_tip);
            } else {
                tf(f.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            brI();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void agf() {
        this.packageName = getCallingPackage();
        if (this.gCZ != null && this.packageName != null) {
            try {
                this.gDa = this.gCZ.getPackageInfo(this.packageName, 64);
                if (this.gDa != null) {
                    if (this.gDa.applicationInfo != null && this.gDa.applicationInfo.loadLabel(this.gCZ) != null) {
                        this.mAppName = this.gDa.applicationInfo.loadLabel(this.gCZ).toString();
                    }
                    if (this.gDa.signatures != null && this.gDa.signatures.length > 0 && this.gDa.signatures[0] != null) {
                        this.gCY = as.w(this.gDa.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gCY = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gCV = extras.getString("ShareUrl");
            this.gCW = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gCX = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gCY)) {
                this.gCY = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean brH() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gCW) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void brI() {
        if (TextUtils.isEmpty(this.gCX)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            brJ();
        }
    }

    private void brJ() {
        this.gDc.brR();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gDd.ts(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brK() {
        if (this.gDg == null) {
            this.gDg = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gDg.ma(false);
            this.gDg.tb(f.C0146f.icon_send_ok);
            this.gDg.te(f.j.share_alert_success);
            this.gDg.a(f.j.share_stay_in_tieba, this.gDi);
            this.gDg.b(f.j.back, this.gDk);
            this.gDg.a(this.gDn);
            this.gDg.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        if (this.gDh == null) {
            this.gDh = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gDh.tb(f.C0146f.icon_send_error);
            this.gDh.tc(f.C0146f.btn_w_square);
            this.gDh.td(f.d.common_color_10039);
            this.gDh.te(f.j.share_alert_fail);
            this.gDh.a(f.j.share_keep_sending, this.gDj);
            this.gDh.b(f.j.back, this.gDk);
            this.gDh.a(this.gDn);
            this.gDh.f(getPageContext());
        }
    }

    protected void brM() {
        if (this.aNL != null) {
            this.aNL.cancelLoadData();
        }
    }

    protected void brN() {
        if (this.aNL != null) {
            this.aNL.ahG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        brM();
        brN();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bsc;
        if (this.gDc != null && (bsc = this.gDc.bsc()) != null) {
            bsc.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gDc != null && this.gDc.brY() != null && this.gDc.brY().isShowing()) {
                g.a(this.gDc.brY(), getPageContext().getPageActivity());
                return true;
            }
            brM();
            if (this.gDf) {
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
        if (this.gDc != null) {
            this.gDc.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(f.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gDc = new c(this);
        this.gDc.U(this.gDo);
        this.gDc.V(this.gDp);
        this.gDc.b(this.gDr);
        this.gDc.W(this.gDq);
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

    public void tf(int i) {
        l.e(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aNL = new NewWriteModel(this);
        this.aNL.a(this.gDm);
        this.aNL.a(this.gDl);
        this.gDd = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(f.j.write_no_prefix));
                        if (WriteShareActivity.this.gDc != null) {
                            WriteShareActivity.this.gDc.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gDc.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gDc.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.brM();
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
            this.mData.setForumName(this.gCX);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gCY);
            this.mData.setShareReferUrl(this.gCV);
            boolean ep = com.baidu.tbadk.core.util.l.ep(this.gCW);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || ep) {
                this.aNL.e(this.mShareLocalImageData, this.gCW);
                this.mData.setShareLocalImageUri(this.gCW);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aNL.aqq();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gCW);
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
        if (this.gDc != null && this.gDc.brX() != null && (obj = this.gDc.brX().getEditableText().toString()) != null) {
            this.gDc.brX().setText(TbFaceManager.IP().W(getPageContext().getContext(), obj));
            this.gDc.brX().setSelection(this.gDc.brX().getText().length());
        }
    }

    public void tg(int i) {
        this.gDb = i;
    }

    public int brO() {
        return this.gDb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brP() {
        brM();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gDb != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gDc.bsb().getText().toString() + this.gDc.brW().getText().toString());
        } else {
            this.mData.setTitle(this.gDc.brW().getText().toString());
        }
        this.mData.setContent(this.gDc.brX().getText().toString());
        this.aNL.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aNL.getWriteData().setVoice(null);
        this.aNL.getWriteData().setVoiceDuringTime(-1);
        if (this.aNL.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(f.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gDe = false;
            if (i2 == -1) {
                brK();
                if (this.gDg != null) {
                    this.gDf = true;
                    this.gDg.brF();
                }
                setResult(-1);
                return;
            }
            brL();
            if (this.gDh != null) {
                this.gDf = false;
                this.gDh.brF();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gCX = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gCX);
                    brJ();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                brI();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gDc.brW());
        HidenSoftKeyPad(this.mInputManager, this.gDc.brX());
        super.onPause();
    }

    public void brQ() {
        HidenSoftKeyPad(this.mInputManager, this.gDc.brW());
        HidenSoftKeyPad(this.mInputManager, this.gDc.brX());
    }
}
