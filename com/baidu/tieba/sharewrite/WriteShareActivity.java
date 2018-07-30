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
    private NewWriteModel aNO;
    private String gCS;
    private String gCT;
    private String gCU;
    private String gCV;
    private PackageManager gCW;
    private PackageInfo gCX;
    private int gCY;
    private c gCZ;
    b gDa;
    private com.baidu.tieba.sharewrite.a gDd;
    private com.baidu.tieba.sharewrite.a gDe;
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
    private boolean gDb = false;
    private boolean gDc = false;
    private a.b gDf = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gDg = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brV());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brW());
            WriteShareActivity.this.brO();
            aVar.dismiss();
        }
    };
    private a.b gDh = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gDc) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gDi = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gDj = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.brJ();
                if (WriteShareActivity.this.gDd != null) {
                    WriteShareActivity.this.gDc = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gDd.brE();
                }
            } else if (tVar == null || writeData == null || tVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.brK();
                if (WriteShareActivity.this.gDe != null) {
                    WriteShareActivity.this.gDc = false;
                    WriteShareActivity.this.gDe.brE();
                }
            } else {
                writeData.setVcodeMD5(tVar.getVcode_md5());
                writeData.setVcodeUrl(tVar.getVcode_pic_url());
                writeData.setVcodeExtra(tVar.Cu());
                WriteShareActivity.this.gDb = true;
                if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Ct())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gDk = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gCZ != null && WriteShareActivity.this.gCZ.brX() != null && WriteShareActivity.this.gCZ.brX().isShowing()) {
                    g.a(WriteShareActivity.this.gCZ.brX(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.brL();
                if (WriteShareActivity.this.gDc) {
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
    private View.OnClickListener gDl = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.brL();
            if (WriteShareActivity.this.gDc) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gDm = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brV());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brW());
            WriteShareActivity.this.brO();
        }
    };
    private View.OnClickListener gDn = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gCZ.brW().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brW());
        }
    };
    private final View.OnFocusChangeListener gDo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gCZ != null) {
                if (view == WriteShareActivity.this.gCZ.brV() || view == WriteShareActivity.this.gCZ.brY() || view == WriteShareActivity.this.gCZ.brZ()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brV());
                    } else if (view == WriteShareActivity.this.gCZ.brV() && WriteShareActivity.this.gCZ.bsa() != null) {
                        WriteShareActivity.this.gCZ.bsa().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gCZ.brW()) {
                    if (z) {
                        WriteShareActivity.this.gCZ.brW().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gCZ.brW().setHint(d.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gCZ.brV());
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
        this.gCW = getPageContext().getPageActivity().getPackageManager();
        agd();
        boolean brG = brG();
        initData(bundle);
        initUI();
        if (!brG) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                tf(d.j.share_parameter_invalid_tip);
            } else {
                tf(d.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            brH();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void agd() {
        this.packageName = getCallingPackage();
        if (this.gCW != null && this.packageName != null) {
            try {
                this.gCX = this.gCW.getPackageInfo(this.packageName, 64);
                if (this.gCX != null) {
                    if (this.gCX.applicationInfo != null && this.gCX.applicationInfo.loadLabel(this.gCW) != null) {
                        this.mAppName = this.gCX.applicationInfo.loadLabel(this.gCW).toString();
                    }
                    if (this.gCX.signatures != null && this.gCX.signatures.length > 0 && this.gCX.signatures[0] != null) {
                        this.gCV = as.w(this.gCX.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gCV = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gCS = extras.getString("ShareUrl");
            this.gCT = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gCU = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gCV)) {
                this.gCV = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean brG() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gCT) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void brH() {
        if (TextUtils.isEmpty(this.gCU)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            brI();
        }
    }

    private void brI() {
        this.gCZ.brQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gDa.to(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        if (this.gDd == null) {
            this.gDd = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gDd.ma(false);
            this.gDd.tb(d.f.icon_send_ok);
            this.gDd.te(d.j.share_alert_success);
            this.gDd.a(d.j.share_stay_in_tieba, this.gDf);
            this.gDd.b(d.j.back, this.gDh);
            this.gDd.a(this.gDk);
            this.gDd.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brK() {
        if (this.gDe == null) {
            this.gDe = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gDe.tb(d.f.icon_send_error);
            this.gDe.tc(d.f.btn_w_square);
            this.gDe.td(d.C0140d.common_color_10039);
            this.gDe.te(d.j.share_alert_fail);
            this.gDe.a(d.j.share_keep_sending, this.gDg);
            this.gDe.b(d.j.back, this.gDh);
            this.gDe.a(this.gDk);
            this.gDe.f(getPageContext());
        }
    }

    protected void brL() {
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
    }

    protected void brM() {
        if (this.aNO != null) {
            this.aNO.ahE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        brL();
        brM();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView bsb;
        if (this.gCZ != null && (bsb = this.gCZ.bsb()) != null) {
            bsb.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gCZ != null && this.gCZ.brX() != null && this.gCZ.brX().isShowing()) {
                g.a(this.gCZ.brX(), getPageContext().getPageActivity());
                return true;
            }
            brL();
            if (this.gDc) {
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
        if (this.gCZ != null) {
            this.gCZ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gCZ = new c(this);
        this.gCZ.U(this.gDl);
        this.gCZ.V(this.gDm);
        this.gCZ.b(this.gDo);
        this.gCZ.W(this.gDn);
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
        this.aNO = new NewWriteModel(this);
        this.aNO.a(this.gDj);
        this.aNO.a(this.gDi);
        this.gDa = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.j.write_no_prefix));
                        if (WriteShareActivity.this.gCZ != null) {
                            WriteShareActivity.this.gCZ.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gCZ.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gCZ.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.brL();
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
            this.mData.setForumName(this.gCU);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gCV);
            this.mData.setShareReferUrl(this.gCS);
            boolean ep = com.baidu.tbadk.core.util.l.ep(this.gCT);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || ep) {
                this.aNO.e(this.mShareLocalImageData, this.gCT);
                this.mData.setShareLocalImageUri(this.gCT);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aNO.aqq();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gCT);
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
        if (this.gCZ != null && this.gCZ.brW() != null && (obj = this.gCZ.brW().getEditableText().toString()) != null) {
            this.gCZ.brW().setText(TbFaceManager.IP().W(getPageContext().getContext(), obj));
            this.gCZ.brW().setSelection(this.gCZ.brW().getText().length());
        }
    }

    public void tg(int i) {
        this.gCY = i;
    }

    public int brN() {
        return this.gCY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        brL();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gCY != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gCZ.bsa().getText().toString() + this.gCZ.brV().getText().toString());
        } else {
            this.mData.setTitle(this.gCZ.brV().getText().toString());
        }
        this.mData.setContent(this.gCZ.brW().getText().toString());
        this.aNO.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aNO.getWriteData().setVoice(null);
        this.aNO.getWriteData().setVoiceDuringTime(-1);
        if (this.aNO.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gDb = false;
            if (i2 == -1) {
                brJ();
                if (this.gDd != null) {
                    this.gDc = true;
                    this.gDd.brE();
                }
                setResult(-1);
                return;
            }
            brK();
            if (this.gDe != null) {
                this.gDc = false;
                this.gDe.brE();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gCU = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gCU);
                    brI();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                brH();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gCZ.brV());
        HidenSoftKeyPad(this.mInputManager, this.gCZ.brW());
        super.onPause();
    }

    public void brP() {
        HidenSoftKeyPad(this.mInputManager, this.gCZ.brV());
        HidenSoftKeyPad(this.mInputManager, this.gCZ.brW());
    }
}
