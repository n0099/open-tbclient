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
import com.baidu.tbadk.coreExtra.data.w;
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
    private NewWriteModel aZU;
    b hdA;
    private com.baidu.tieba.sharewrite.a hdD;
    private com.baidu.tieba.sharewrite.a hdE;
    private String hdt;
    private String hdu;
    private String hdv;
    private String hdw;
    private PackageInfo hdx;
    private int hdy;
    private c hdz;
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
    private boolean hdB = false;
    private boolean hdC = false;
    private a.b hdF = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b hdG = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzV());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzW());
            WriteShareActivity.this.bzO();
            aVar.dismiss();
        }
    };
    private a.b hdH = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.hdC) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b hdI = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c hdJ = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, w wVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bzJ();
                if (WriteShareActivity.this.hdD != null) {
                    WriteShareActivity.this.hdC = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.hdD.bzE();
                }
            } else if (wVar == null || writeData == null || wVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bzK();
                if (WriteShareActivity.this.hdE != null) {
                    WriteShareActivity.this.hdC = false;
                    WriteShareActivity.this.hdE.bzE();
                }
            } else {
                writeData.setVcodeMD5(wVar.getVcode_md5());
                writeData.setVcodeUrl(wVar.getVcode_pic_url());
                writeData.setVcodeExtra(wVar.GX());
                WriteShareActivity.this.hdB = true;
                if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GW())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener hdK = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.hdz != null && WriteShareActivity.this.hdz.bzX() != null && WriteShareActivity.this.hdz.bzX().isShowing()) {
                    g.a(WriteShareActivity.this.hdz.bzX(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bzL();
                if (WriteShareActivity.this.hdC) {
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
    private View.OnClickListener hdL = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bzL();
            if (WriteShareActivity.this.hdC) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener hdM = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzV());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzW());
            WriteShareActivity.this.bzO();
        }
    };
    private View.OnClickListener hdN = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.hdz.bzW().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzW());
        }
    };
    private final View.OnFocusChangeListener hdO = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.hdz != null) {
                if (view == WriteShareActivity.this.hdz.bzV() || view == WriteShareActivity.this.hdz.bzY() || view == WriteShareActivity.this.hdz.bzZ()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzV());
                    } else if (view == WriteShareActivity.this.hdz.bzV() && WriteShareActivity.this.hdz.bAa() != null) {
                        WriteShareActivity.this.hdz.bAa().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.hdz.bzW()) {
                    if (z) {
                        WriteShareActivity.this.hdz.bzW().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.hdz.bzW().setHint(e.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.hdz.bzV());
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
        amF();
        boolean bzG = bzG();
        initData(bundle);
        initUI();
        if (!bzG) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                ve(e.j.share_parameter_invalid_tip);
            } else {
                ve(e.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bzH();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void amF() {
        this.packageName = getCallingPackage();
        if (this.pm != null && this.packageName != null) {
            try {
                this.hdx = this.pm.getPackageInfo(this.packageName, 64);
                if (this.hdx != null) {
                    if (this.hdx.applicationInfo != null && this.hdx.applicationInfo.loadLabel(this.pm) != null) {
                        this.mAppName = this.hdx.applicationInfo.loadLabel(this.pm).toString();
                    }
                    if (this.hdx.signatures != null && this.hdx.signatures.length > 0 && this.hdx.signatures[0] != null) {
                        this.hdw = ar.D(this.hdx.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.hdw = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.hdt = extras.getString("ShareUrl");
            this.hdu = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.hdv = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.hdw)) {
                this.hdw = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bzG() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.hdu) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11003)));
    }

    private void bzH() {
        if (TextUtils.isEmpty(this.hdv)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bzI();
        }
    }

    private void bzI() {
        this.hdz.bzQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hdA.vj(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzJ() {
        if (this.hdD == null) {
            this.hdD = new com.baidu.tieba.sharewrite.a(getActivity());
            this.hdD.nf(false);
            this.hdD.va(e.f.icon_send_ok);
            this.hdD.vd(e.j.share_alert_success);
            this.hdD.a(e.j.share_stay_in_tieba, this.hdF);
            this.hdD.b(e.j.back, this.hdH);
            this.hdD.a(this.hdK);
            this.hdD.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzK() {
        if (this.hdE == null) {
            this.hdE = new com.baidu.tieba.sharewrite.a(getActivity());
            this.hdE.va(e.f.icon_send_error);
            this.hdE.vb(e.f.btn_w_square);
            this.hdE.vc(e.d.common_color_10039);
            this.hdE.vd(e.j.share_alert_fail);
            this.hdE.a(e.j.share_keep_sending, this.hdG);
            this.hdE.b(e.j.back, this.hdH);
            this.hdE.a(this.hdK);
            this.hdE.f(getPageContext());
        }
    }

    protected void bzL() {
        if (this.aZU != null) {
            this.aZU.cancelLoadData();
        }
    }

    protected void bzM() {
        if (this.aZU != null) {
            this.aZU.aoW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bzL();
        bzM();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bAb;
        if (this.hdz != null && (bAb = this.hdz.bAb()) != null) {
            bAb.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hdz != null && this.hdz.bzX() != null && this.hdz.bzX().isShowing()) {
                g.a(this.hdz.bzX(), getPageContext().getPageActivity());
                return true;
            }
            bzL();
            if (this.hdC) {
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
        if (this.hdz != null) {
            this.hdz.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(e.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hdz = new c(this);
        this.hdz.V(this.hdL);
        this.hdz.W(this.hdM);
        this.hdz.b(this.hdO);
        this.hdz.X(this.hdN);
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

    public void ve(int i) {
        l.g(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aZU = new NewWriteModel(this);
        this.aZU.a(this.hdJ);
        this.aZU.a(this.hdI);
        this.hdA = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(e.j.write_no_prefix));
                        if (WriteShareActivity.this.hdz != null) {
                            WriteShareActivity.this.hdz.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.hdz.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.hdz.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bzL();
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
            this.mData.setForumName(this.hdv);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.hdw);
            this.mData.setShareReferUrl(this.hdt);
            boolean fp = com.baidu.tbadk.core.util.l.fp(this.hdu);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || fp) {
                this.aZU.f(this.mShareLocalImageData, this.hdu);
                this.mData.setShareLocalImageUri(this.hdu);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aZU.axz();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.hdu);
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
        if (this.hdz != null && this.hdz.bzW() != null && (obj = this.hdz.bzW().getEditableText().toString()) != null) {
            this.hdz.bzW().setText(TbFaceManager.Nu().am(getPageContext().getContext(), obj));
            this.hdz.bzW().setSelection(this.hdz.bzW().getText().length());
        }
    }

    public void vf(int i) {
        this.hdy = i;
    }

    public int bzN() {
        return this.hdy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzO() {
        bzL();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.hdy != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.hdz.bAa().getText().toString() + this.hdz.bzV().getText().toString());
        } else {
            this.mData.setTitle(this.hdz.bzV().getText().toString());
        }
        this.mData.setContent(this.hdz.bzW().getText().toString());
        this.aZU.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aZU.getWriteData().setVoice(null);
        this.aZU.getWriteData().setVoiceDuringTime(-1);
        if (this.aZU.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.hdB = false;
            if (i2 == -1) {
                bzJ();
                if (this.hdD != null) {
                    this.hdC = true;
                    this.hdD.bzE();
                }
                setResult(-1);
                return;
            }
            bzK();
            if (this.hdE != null) {
                this.hdC = false;
                this.hdE.bzE();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.hdv = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.hdv);
                    bzI();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bzH();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.hdz.bzV());
        HidenSoftKeyPad(this.mInputManager, this.hdz.bzW());
        super.onPause();
    }

    public void bzP() {
        HidenSoftKeyPad(this.mInputManager, this.hdz.bzV());
        HidenSoftKeyPad(this.mInputManager, this.hdz.bzW());
    }
}
