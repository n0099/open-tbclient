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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
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
    private NewWriteModel btX;
    private String gQk;
    private String gQl;
    private String gQm;
    private String gQn;
    private PackageManager gQo;
    private PackageInfo gQp;
    private int gQq;
    private d gQr;
    b gQs;
    private com.baidu.tieba.sharewrite.a gQv;
    private com.baidu.tieba.sharewrite.a gQw;
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
    private boolean gQt = false;
    private boolean gQu = false;
    private a.b gQx = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gQy = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsL());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsM());
            WriteShareActivity.this.bsE();
            aVar.dismiss();
        }
    };
    private a.b gQz = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gQu) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.e(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gQA = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gQB = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bsz();
                if (WriteShareActivity.this.gQv != null) {
                    WriteShareActivity.this.gQu = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gQv.bsu();
                }
            } else if (tVar == null || writeData == null || tVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bsA();
                if (WriteShareActivity.this.gQw != null) {
                    WriteShareActivity.this.gQu = false;
                    WriteShareActivity.this.gQw.bsu();
                }
            } else {
                writeData.setVcodeMD5(tVar.getVcode_md5());
                writeData.setVcodeUrl(tVar.getVcode_pic_url());
                writeData.setVcodeExtra(tVar.FY());
                WriteShareActivity.this.gQt = true;
                if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gQC = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gQr != null && WriteShareActivity.this.gQr.bsN() != null && WriteShareActivity.this.gQr.bsN().isShowing()) {
                    g.a(WriteShareActivity.this.gQr.bsN(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bsB();
                if (WriteShareActivity.this.gQu) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.e.b.e(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gQD = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bsB();
            if (WriteShareActivity.this.gQu) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.e(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gQE = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsL());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsM());
            WriteShareActivity.this.bsE();
        }
    };
    private View.OnClickListener gQF = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gQr.bsM().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsM());
        }
    };
    private final View.OnFocusChangeListener gQG = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gQr != null) {
                if (view == WriteShareActivity.this.gQr.bsL() || view == WriteShareActivity.this.gQr.bsO() || view == WriteShareActivity.this.gQr.bsP()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsL());
                    } else if (view == WriteShareActivity.this.gQr.bsL() && WriteShareActivity.this.gQr.bsQ() != null) {
                        WriteShareActivity.this.gQr.bsQ().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gQr.bsM()) {
                    if (z) {
                        WriteShareActivity.this.gQr.bsM().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gQr.bsM().setHint(d.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQr.bsL());
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
        this.gQo = getPageContext().getPageActivity().getPackageManager();
        ahv();
        boolean bsw = bsw();
        initData(bundle);
        initUI();
        if (!bsw) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                vk(d.j.share_parameter_invalid_tip);
            } else {
                vk(d.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bsx();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void ahv() {
        this.packageName = getCallingPackage();
        if (this.gQo != null && this.packageName != null) {
            try {
                this.gQp = this.gQo.getPackageInfo(this.packageName, 64);
                if (this.gQp != null) {
                    if (this.gQp.applicationInfo != null && this.gQp.applicationInfo.loadLabel(this.gQo) != null) {
                        this.mAppName = this.gQp.applicationInfo.loadLabel(this.gQo).toString();
                    }
                    if (this.gQp.signatures != null && this.gQp.signatures.length > 0 && this.gQp.signatures[0] != null) {
                        this.gQn = ap.v(this.gQp.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gQn = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gQk = extras.getString("ShareUrl");
            this.gQl = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gQm = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gQn)) {
                this.gQn = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bsw() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gQl) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
    }

    private void bsx() {
        if (TextUtils.isEmpty(this.gQm)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bsy();
        }
    }

    private void bsy() {
        this.gQr.bsG();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gQs.sp(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsz() {
        if (this.gQv == null) {
            this.gQv = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gQv.mw(false);
            this.gQv.vg(d.f.icon_send_ok);
            this.gQv.vj(d.j.share_alert_success);
            this.gQv.a(d.j.share_stay_in_tieba, this.gQx);
            this.gQv.b(d.j.back, this.gQz);
            this.gQv.a(this.gQC);
            this.gQv.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsA() {
        if (this.gQw == null) {
            this.gQw = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gQw.vg(d.f.icon_send_error);
            this.gQw.vh(d.f.btn_w_square);
            this.gQw.vi(d.C0141d.common_color_10039);
            this.gQw.vj(d.j.share_alert_fail);
            this.gQw.a(d.j.share_keep_sending, this.gQy);
            this.gQw.b(d.j.back, this.gQz);
            this.gQw.a(this.gQC);
            this.gQw.g(getPageContext());
        }
    }

    protected void bsB() {
        if (this.btX != null) {
            this.btX.cancelLoadData();
        }
    }

    protected void bsC() {
        if (this.btX != null) {
            this.btX.akk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bsB();
        bsC();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        c bsR;
        if (this.gQr != null && (bsR = this.gQr.bsR()) != null) {
            bsR.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gQr != null && this.gQr.bsN() != null && this.gQr.bsN().isShowing()) {
                g.a(this.gQr.bsN(), getPageContext().getPageActivity());
                return true;
            }
            bsB();
            if (this.gQu) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gQr != null) {
            this.gQr.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gQr = new d(this);
        this.gQr.Q(this.gQD);
        this.gQr.R(this.gQE);
        this.gQr.b(this.gQG);
        this.gQr.S(this.gQF);
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
                com.baidu.tbadk.core.e.b.e(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void vk(int i) {
        l.s(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.btX = new NewWriteModel(this);
        this.btX.a(this.gQB);
        this.btX.a(this.gQA);
        this.gQs = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.j.write_no_prefix));
                        if (WriteShareActivity.this.gQr != null) {
                            WriteShareActivity.this.gQr.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gQr.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gQr.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bsB();
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
            this.mData.setForumName(this.gQm);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gQn);
            this.mData.setShareReferUrl(this.gQk);
            boolean dX = k.dX(this.gQl);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dX) {
                this.btX.e(this.mShareLocalImageData, this.gQl);
                this.mData.setShareLocalImageUri(this.gQl);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.btX.arZ();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gQl);
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
        if (this.gQr != null && this.gQr.bsM() != null && (obj = this.gQr.bsM().getEditableText().toString()) != null) {
            this.gQr.bsM().setText(TbFaceManager.Mw().W(getPageContext().getContext(), obj));
            this.gQr.bsM().setSelection(this.gQr.bsM().getText().length());
        }
    }

    public void vl(int i) {
        this.gQq = i;
    }

    public int bsD() {
        return this.gQq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsE() {
        bsB();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gQq != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gQr.bsQ().getText().toString() + this.gQr.bsL().getText().toString());
        } else {
            this.mData.setTitle(this.gQr.bsL().getText().toString());
        }
        this.mData.setContent(this.gQr.bsM().getText().toString());
        this.btX.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.btX.getWriteData().setVoice(null);
        this.btX.getWriteData().setVoiceDuringTime(-1);
        if (this.btX.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gQt = false;
            if (i2 == -1) {
                bsz();
                if (this.gQv != null) {
                    this.gQu = true;
                    this.gQv.bsu();
                }
                setResult(-1);
                return;
            }
            bsA();
            if (this.gQw != null) {
                this.gQu = false;
                this.gQw.bsu();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gQm = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gQm);
                    bsy();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bsx();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gQr.bsL());
        HidenSoftKeyPad(this.mInputManager, this.gQr.bsM());
        super.onPause();
    }

    public void bsF() {
        HidenSoftKeyPad(this.mInputManager, this.gQr.bsL());
        HidenSoftKeyPad(this.mInputManager, this.gQr.bsM());
    }
}
