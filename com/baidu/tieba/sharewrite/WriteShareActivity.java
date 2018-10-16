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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.e;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.sina.weibo.sdk.constant.WBConstants;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private NewWriteModel aVE;
    private String gRW;
    private String gRX;
    private String gRY;
    private String gRZ;
    private PackageInfo gSa;
    private int gSb;
    private c gSc;
    b gSd;
    private com.baidu.tieba.sharewrite.a gSg;
    private com.baidu.tieba.sharewrite.a gSh;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private PackageManager pm;
    private WriteData mData = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private boolean gSe = false;
    private boolean gSf = false;
    private a.b gSi = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gSj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxQ());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxR());
            WriteShareActivity.this.bxJ();
            aVar.dismiss();
        }
    };
    private a.b gSk = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gSf) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gSl = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gSm = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, v vVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bxE();
                if (WriteShareActivity.this.gSg != null) {
                    WriteShareActivity.this.gSf = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gSg.bxz();
                }
            } else if (vVar == null || writeData == null || vVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bxF();
                if (WriteShareActivity.this.gSh != null) {
                    WriteShareActivity.this.gSf = false;
                    WriteShareActivity.this.gSh.bxz();
                }
            } else {
                writeData.setVcodeMD5(vVar.getVcode_md5());
                writeData.setVcodeUrl(vVar.getVcode_pic_url());
                writeData.setVcodeExtra(vVar.FG());
                WriteShareActivity.this.gSe = true;
                if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.FF())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gSn = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gSc != null && WriteShareActivity.this.gSc.bxS() != null && WriteShareActivity.this.gSc.bxS().isShowing()) {
                    g.a(WriteShareActivity.this.gSc.bxS(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bxG();
                if (WriteShareActivity.this.gSf) {
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
    private View.OnClickListener gSo = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bxG();
            if (WriteShareActivity.this.gSf) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gSp = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxQ());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxR());
            WriteShareActivity.this.bxJ();
        }
    };
    private View.OnClickListener gSq = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gSc.bxR().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxR());
        }
    };
    private final View.OnFocusChangeListener gSr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gSc != null) {
                if (view == WriteShareActivity.this.gSc.bxQ() || view == WriteShareActivity.this.gSc.bxT() || view == WriteShareActivity.this.gSc.bxU()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxQ());
                    } else if (view == WriteShareActivity.this.gSc.bxQ() && WriteShareActivity.this.gSc.bxV() != null) {
                        WriteShareActivity.this.gSc.bxV().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gSc.bxR()) {
                    if (z) {
                        WriteShareActivity.this.gSc.bxR().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gSc.bxR().setHint(e.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gSc.bxQ());
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
        this.pm = getPageContext().getPageActivity().getPackageManager();
        alw();
        boolean bxB = bxB();
        initData(bundle);
        initUI();
        if (!bxB) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                uc(e.j.share_parameter_invalid_tip);
            } else {
                uc(e.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bxC();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void alw() {
        this.packageName = getCallingPackage();
        if (this.pm != null && this.packageName != null) {
            try {
                this.gSa = this.pm.getPackageInfo(this.packageName, 64);
                if (this.gSa != null) {
                    if (this.gSa.applicationInfo != null && this.gSa.applicationInfo.loadLabel(this.pm) != null) {
                        this.mAppName = this.gSa.applicationInfo.loadLabel(this.pm).toString();
                    }
                    if (this.gSa.signatures != null && this.gSa.signatures.length > 0 && this.gSa.signatures[0] != null) {
                        this.gRZ = ar.E(this.gSa.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gRZ = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gRW = extras.getString("ShareUrl");
            this.gRX = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gRY = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gRZ)) {
                this.gRZ = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bxB() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gRX) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void bxC() {
        if (TextUtils.isEmpty(this.gRY)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bxD();
        }
    }

    private void bxD() {
        this.gSc.bxL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gSd.uB(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxE() {
        if (this.gSg == null) {
            this.gSg = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gSg.mP(false);
            this.gSg.tY(e.f.icon_send_ok);
            this.gSg.ub(e.j.share_alert_success);
            this.gSg.a(e.j.share_stay_in_tieba, this.gSi);
            this.gSg.b(e.j.back, this.gSk);
            this.gSg.a(this.gSn);
            this.gSg.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxF() {
        if (this.gSh == null) {
            this.gSh = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gSh.tY(e.f.icon_send_error);
            this.gSh.tZ(e.f.btn_w_square);
            this.gSh.ua(e.d.common_color_10039);
            this.gSh.ub(e.j.share_alert_fail);
            this.gSh.a(e.j.share_keep_sending, this.gSj);
            this.gSh.b(e.j.back, this.gSk);
            this.gSh.a(this.gSn);
            this.gSh.f(getPageContext());
        }
    }

    protected void bxG() {
        if (this.aVE != null) {
            this.aVE.cancelLoadData();
        }
    }

    protected void bxH() {
        if (this.aVE != null) {
            this.aVE.amW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bxG();
        bxH();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bxW;
        if (this.gSc != null && (bxW = this.gSc.bxW()) != null) {
            bxW.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gSc != null && this.gSc.bxS() != null && this.gSc.bxS().isShowing()) {
                g.a(this.gSc.bxS(), getPageContext().getPageActivity());
                return true;
            }
            bxG();
            if (this.gSf) {
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
        if (this.gSc != null) {
            this.gSc.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(e.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gSc = new c(this);
        this.gSc.T(this.gSo);
        this.gSc.U(this.gSp);
        this.gSc.b(this.gSr);
        this.gSc.V(this.gSq);
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
                com.baidu.tbadk.core.e.b.d(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void uc(int i) {
        l.g(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aVE = new NewWriteModel(this);
        this.aVE.a(this.gSm);
        this.aVE.a(this.gSl);
        this.gSd = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(e.j.write_no_prefix));
                        if (WriteShareActivity.this.gSc != null) {
                            WriteShareActivity.this.gSc.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gSc.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gSc.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bxG();
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
            this.mData.setForumName(this.gRY);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gRZ);
            this.mData.setShareReferUrl(this.gRW);
            boolean eX = com.baidu.tbadk.core.util.l.eX(this.gRX);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || eX) {
                this.aVE.f(this.mShareLocalImageData, this.gRX);
                this.mData.setShareLocalImageUri(this.gRX);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aVE.avA();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gRX);
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
        if (this.gSc != null && this.gSc.bxR() != null && (obj = this.gSc.bxR().getEditableText().toString()) != null) {
            this.gSc.bxR().setText(TbFaceManager.Md().al(getPageContext().getContext(), obj));
            this.gSc.bxR().setSelection(this.gSc.bxR().getText().length());
        }
    }

    public void ud(int i) {
        this.gSb = i;
    }

    public int bxI() {
        return this.gSb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxJ() {
        bxG();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gSb != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gSc.bxV().getText().toString() + this.gSc.bxQ().getText().toString());
        } else {
            this.mData.setTitle(this.gSc.bxQ().getText().toString());
        }
        this.mData.setContent(this.gSc.bxR().getText().toString());
        this.aVE.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aVE.getWriteData().setVoice(null);
        this.aVE.getWriteData().setVoiceDuringTime(-1);
        if (this.aVE.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gSe = false;
            if (i2 == -1) {
                bxE();
                if (this.gSg != null) {
                    this.gSf = true;
                    this.gSg.bxz();
                }
                setResult(-1);
                return;
            }
            bxF();
            if (this.gSh != null) {
                this.gSf = false;
                this.gSh.bxz();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gRY = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gRY);
                    bxD();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bxC();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gSc.bxQ());
        HidenSoftKeyPad(this.mInputManager, this.gSc.bxR());
        super.onPause();
    }

    public void bxK() {
        HidenSoftKeyPad(this.mInputManager, this.gSc.bxQ());
        HidenSoftKeyPad(this.mInputManager, this.gSc.bxR());
    }
}
