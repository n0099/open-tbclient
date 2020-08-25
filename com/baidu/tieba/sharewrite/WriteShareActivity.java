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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cUh;
    private NewWriteModel eMp;
    private String eea;
    private String lUc;
    private String lUd;
    private String lUe;
    private PackageInfo lUf;
    private int lUh;
    private c lUi;
    b lUj;
    private com.baidu.tieba.sharewrite.a lUm;
    private com.baidu.tieba.sharewrite.a lUn;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData lUg = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hJE = null;
    private boolean lUk = false;
    private boolean lUl = false;
    private a.b lUo = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.lUg.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b lUp = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtk());
            WriteShareActivity.this.dtc();
            aVar.dismiss();
        }
    };
    private a.b lUq = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.lUl) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b lUr = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.lUg.setShareSummaryImg("");
                WriteShareActivity.this.lUg.setShareSummaryImgHeight(0);
                WriteShareActivity.this.lUg.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.lUg.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.lUg.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.lUg.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c lUs = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ag agVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dsX();
                if (WriteShareActivity.this.lUm != null) {
                    WriteShareActivity.this.lUl = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.lUm.dsS();
                }
            } else if (agVar == null || writeData == null || agVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dsY();
                if (WriteShareActivity.this.lUn != null) {
                    WriteShareActivity.this.lUl = false;
                    WriteShareActivity.this.lUn.dsS();
                }
            } else {
                writeData.setVcodeMD5(agVar.getVcode_md5());
                writeData.setVcodeUrl(agVar.getVcode_pic_url());
                writeData.setVcodeExtra(agVar.bmZ());
                WriteShareActivity.this.lUk = true;
                if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener lUt = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.lUi != null && WriteShareActivity.this.lUi.dtl() != null && WriteShareActivity.this.lUi.dtl().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.lUi.dtl(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dsZ();
                if (WriteShareActivity.this.lUl) {
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
    private View.OnClickListener lUu = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dsZ();
            if (WriteShareActivity.this.lUl) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener lUv = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtj());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtk());
            WriteShareActivity.this.dtc();
        }
    };
    private View.OnClickListener lUw = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.lUi.dtk().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtk());
        }
    };
    private final View.OnFocusChangeListener gsB = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.lUi != null) {
                if (view == WriteShareActivity.this.lUi.dtj() || view == WriteShareActivity.this.lUi.dtm() || view == WriteShareActivity.this.lUi.dtn()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtj());
                    } else if (view == WriteShareActivity.this.lUi.dtj() && WriteShareActivity.this.lUi.dto() != null) {
                        WriteShareActivity.this.lUi.dto().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.lUi.dtk()) {
                    if (z) {
                        WriteShareActivity.this.lUi.dtk().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.lUi.dtk().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.lUi.dtj());
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
        this.cUh = getPageContext().getPageActivity().getPackageManager();
        bXZ();
        boolean dsU = dsU();
        initData(bundle);
        initUI();
        if (!dsU) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Hq(R.string.share_parameter_invalid_tip);
            } else {
                Hq(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dsV();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bXZ() {
        this.packageName = getCallingPackage();
        if (this.cUh != null && this.packageName != null) {
            try {
                this.lUf = this.cUh.getPackageInfo(this.packageName, 64);
                if (this.lUf != null) {
                    if (this.lUf.applicationInfo != null && this.lUf.applicationInfo.loadLabel(this.cUh) != null) {
                        this.mAppName = this.lUf.applicationInfo.loadLabel(this.cUh).toString();
                    }
                    if (this.lUf.signatures != null && this.lUf.signatures.length > 0 && this.lUf.signatures[0] != null) {
                        this.lUe = av.getAPKHexMD5(this.lUf.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.lUe = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.lUc = extras.getString("ShareUrl");
            this.eea = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.lUd = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.lUe)) {
                this.lUe = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dsU() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eea) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dsV() {
        if (TextUtils.isEmpty(this.lUd)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dsW();
        }
    }

    private void dsW() {
        this.lUi.dte();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lUj.Qi(this.lUg.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsX() {
        if (this.lUm == null) {
            this.lUm = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lUm.vJ(false);
            this.lUm.Hm(R.drawable.icon_send_ok);
            this.lUm.Hp(R.string.share_alert_success);
            this.lUm.a(R.string.share_stay_in_tieba, this.lUo);
            this.lUm.b(R.string.back, this.lUq);
            this.lUm.a(this.lUt);
            this.lUm.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsY() {
        if (this.lUn == null) {
            this.lUn = new com.baidu.tieba.sharewrite.a(getActivity());
            this.lUn.Hm(R.drawable.icon_send_error);
            this.lUn.Hn(R.drawable.btn_w_square);
            this.lUn.Ho(R.color.common_color_10039);
            this.lUn.Hp(R.string.share_alert_fail);
            this.lUn.a(R.string.share_keep_sending, this.lUp);
            this.lUn.b(R.string.back, this.lUq);
            this.lUn.a(this.lUt);
            this.lUn.g(getPageContext());
        }
    }

    protected void dsZ() {
        if (this.eMp != null) {
            this.eMp.cancelLoadData();
        }
    }

    protected void dta() {
        if (this.eMp != null) {
            this.eMp.dxU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dsZ();
        dta();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dtp;
        if (this.lUi != null && (dtp = this.lUi.dtp()) != null) {
            dtp.setImageBitmap(null);
        }
    }

    public WriteData cKZ() {
        return this.lUg;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lUi != null && this.lUi.dtl() != null && this.lUi.dtl().isShowing()) {
                g.dismissPopupWindow(this.lUi.dtl(), getPageContext().getPageActivity());
                return true;
            }
            dsZ();
            if (this.lUl) {
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
        if (this.lUi != null) {
            this.lUi.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lUi = new c(this);
        this.lUi.ae(this.lUu);
        this.lUi.af(this.lUv);
        this.lUi.b(this.gsB);
        this.lUi.ag(this.lUw);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
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

    public void Hq(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.eMp = new NewWriteModel(this);
        this.eMp.a(this.lUs);
        this.eMp.a(this.lUr);
        this.lUj = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.lUi != null) {
                            WriteShareActivity.this.lUi.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lUi.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.lUi.a((PostPrefixData) null);
            }
        });
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dsZ();
            }
        };
        this.lUg = new WriteData();
        this.lUg.setType(3);
        if (bundle != null) {
            this.lUg.setForumName(bundle.getString("forum_name"));
            this.lUg.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.lUg.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.lUg.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.lUg.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.lUg.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.lUg.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.lUg.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.lUg.setForumName(this.lUd);
            this.lUg.setShareSummaryTitle(this.mShareTitle);
            this.lUg.setShareSummaryContent(this.mShareContent);
            this.lUg.setShareApiKey(this.mAppKey);
            this.lUg.setShareAppName(this.mAppName);
            this.lUg.setShareSignKey(this.lUe);
            this.lUg.setShareReferUrl(this.lUc);
            boolean isLocalImagePath = n.isLocalImagePath(this.eea);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.eMp.d(this.mShareLocalImageData, this.eea);
                this.lUg.setShareLocalImageUri(this.eea);
                this.lUg.setShareLocalImageData(this.mShareLocalImageData);
                this.eMp.ciu();
                this.lUg.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.lUg.setShareSummaryImg(this.eea);
                this.lUg.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.lUg.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.lUg.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.lUg.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.lUg.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.lUg.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.lUg.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.lUg.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.lUg.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.lUg.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.lUg.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.lUg.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.lUg.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.lUg.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.lUg.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.lUg.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.lUg.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lUg.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.lUi != null && this.lUi.dtk() != null && (obj = this.lUi.dtk().getEditableText().toString()) != null) {
            this.lUi.dtk().setText(TbFaceManager.bsV().ap(getPageContext().getContext(), obj));
            this.lUi.dtk().setSelection(this.lUi.dtk().getText().length());
        }
    }

    public void Hr(int i) {
        this.lUh = i;
    }

    public int dtb() {
        return this.lUh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtc() {
        dsZ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.lUh != this.mPrefixData.getPrefixs().size() - 1) {
            this.lUg.setTitle(this.lUi.dto().getText().toString() + this.lUi.dtj().getText().toString());
        } else {
            this.lUg.setTitle(this.lUi.dtj().getText().toString());
        }
        this.lUg.setContent(this.lUi.dtk().getText().toString());
        this.eMp.d(this.lUg);
        this.lUg.setVcode(null);
        this.eMp.cKZ().setVoice(null);
        this.eMp.cKZ().setVoiceDuringTime(-1);
        if (this.eMp.dxS()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hJE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.lUk = false;
            if (i2 == -1) {
                dsX();
                if (this.lUm != null) {
                    this.lUl = true;
                    this.lUm.dsS();
                }
                setResult(-1);
                return;
            }
            dsY();
            if (this.lUn != null) {
                this.lUl = false;
                this.lUn.dsS();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.lUd = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.lUg.setForumName(this.lUd);
                    dsW();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dsV();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.lUi.dtj());
        HidenSoftKeyPad(this.mInputManager, this.lUi.dtk());
        super.onPause();
    }

    public void dtd() {
        HidenSoftKeyPad(this.mInputManager, this.lUi.dtj());
        HidenSoftKeyPad(this.mInputManager, this.lUi.dtk());
    }
}
