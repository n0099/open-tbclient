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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager cWl;
    private NewWriteModel ePk;
    private String ego;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String mdS;
    private String mdT;
    private String mdU;
    private PackageInfo mdV;
    private int mdX;
    private c mdY;
    b mdZ;
    private com.baidu.tieba.sharewrite.a mec;
    private com.baidu.tieba.sharewrite.a med;
    private String packageName;
    private WriteData mdW = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hQL = null;
    private boolean mea = false;
    private boolean meb = false;
    private a.b mee = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mdW.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b mef = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxh());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxi());
            WriteShareActivity.this.dxa();
            aVar.dismiss();
        }
    };
    private a.b meg = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.meb) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b meh = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mdW.setShareSummaryImg("");
                WriteShareActivity.this.mdW.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mdW.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mdW.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mdW.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mdW.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c mei = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dwV();
                if (WriteShareActivity.this.mec != null) {
                    WriteShareActivity.this.meb = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mec.dwQ();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dwW();
                if (WriteShareActivity.this.med != null) {
                    WriteShareActivity.this.meb = false;
                    WriteShareActivity.this.med.dwQ();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bnT());
                WriteShareActivity.this.mea = true;
                if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener mej = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.mdY != null && WriteShareActivity.this.mdY.dxj() != null && WriteShareActivity.this.mdY.dxj().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.mdY.dxj(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dwX();
                if (WriteShareActivity.this.meb) {
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
    private View.OnClickListener mek = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dwX();
            if (WriteShareActivity.this.meb) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener mel = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxh());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxi());
            WriteShareActivity.this.dxa();
        }
    };
    private View.OnClickListener men = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mdY.dxi().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxi());
        }
    };
    private final View.OnFocusChangeListener gwb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mdY != null) {
                if (view == WriteShareActivity.this.mdY.dxh() || view == WriteShareActivity.this.mdY.dxk() || view == WriteShareActivity.this.mdY.dxl()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxh());
                    } else if (view == WriteShareActivity.this.mdY.dxh() && WriteShareActivity.this.mdY.dxm() != null) {
                        WriteShareActivity.this.mdY.dxm().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.mdY.dxi()) {
                    if (z) {
                        WriteShareActivity.this.mdY.dxi().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.mdY.dxi().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.mdY.dxh());
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
        this.cWl = getPageContext().getPageActivity().getPackageManager();
        bZW();
        boolean dwS = dwS();
        initData(bundle);
        initUI();
        if (!dwS) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                HT(R.string.share_parameter_invalid_tip);
            } else {
                HT(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dwT();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bZW() {
        this.packageName = getCallingPackage();
        if (this.cWl != null && this.packageName != null) {
            try {
                this.mdV = this.cWl.getPackageInfo(this.packageName, 64);
                if (this.mdV != null) {
                    if (this.mdV.applicationInfo != null && this.mdV.applicationInfo.loadLabel(this.cWl) != null) {
                        this.mAppName = this.mdV.applicationInfo.loadLabel(this.cWl).toString();
                    }
                    if (this.mdV.signatures != null && this.mdV.signatures.length > 0 && this.mdV.signatures[0] != null) {
                        this.mdU = av.getAPKHexMD5(this.mdV.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.mdU = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mdS = extras.getString("ShareUrl");
            this.ego = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mdT = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mdU)) {
                this.mdU = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dwS() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.ego) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dwT() {
        if (TextUtils.isEmpty(this.mdT)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dwU();
        }
    }

    private void dwU() {
        this.mdY.dxc();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mdZ.QI(this.mdW.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwV() {
        if (this.mec == null) {
            this.mec = new com.baidu.tieba.sharewrite.a(getActivity());
            this.mec.vT(false);
            this.mec.HP(R.drawable.icon_send_ok);
            this.mec.HS(R.string.share_alert_success);
            this.mec.a(R.string.share_stay_in_tieba, this.mee);
            this.mec.b(R.string.back, this.meg);
            this.mec.a(this.mej);
            this.mec.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwW() {
        if (this.med == null) {
            this.med = new com.baidu.tieba.sharewrite.a(getActivity());
            this.med.HP(R.drawable.icon_send_error);
            this.med.HQ(R.drawable.btn_w_square);
            this.med.HR(R.color.common_color_10039);
            this.med.HS(R.string.share_alert_fail);
            this.med.a(R.string.share_keep_sending, this.mef);
            this.med.b(R.string.back, this.meg);
            this.med.a(this.mej);
            this.med.g(getPageContext());
        }
    }

    protected void dwX() {
        if (this.ePk != null) {
            this.ePk.cancelLoadData();
        }
    }

    protected void dwY() {
        if (this.ePk != null) {
            this.ePk.dBS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dwX();
        dwY();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dxn;
        if (this.mdY != null && (dxn = this.mdY.dxn()) != null) {
            dxn.setImageBitmap(null);
        }
    }

    public WriteData cOG() {
        return this.mdW;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mdY != null && this.mdY.dxj() != null && this.mdY.dxj().isShowing()) {
                g.dismissPopupWindow(this.mdY.dxj(), getPageContext().getPageActivity());
                return true;
            }
            dwX();
            if (this.meb) {
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
        if (this.mdY != null) {
            this.mdY.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mdY = new c(this);
        this.mdY.ae(this.mek);
        this.mdY.af(this.mel);
        this.mdY.b(this.gwb);
        this.mdY.ag(this.men);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
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

    public void HT(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.ePk = new NewWriteModel(this);
        this.ePk.a(this.mei);
        this.ePk.a(this.meh);
        this.mdZ = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.mdY != null) {
                            WriteShareActivity.this.mdY.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mdY.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.mdY.a((PostPrefixData) null);
            }
        });
        this.hQL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dwX();
            }
        };
        this.mdW = new WriteData();
        this.mdW.setType(3);
        if (bundle != null) {
            this.mdW.setForumName(bundle.getString("forum_name"));
            this.mdW.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mdW.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mdW.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mdW.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mdW.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mdW.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mdW.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mdW.setForumName(this.mdT);
            this.mdW.setShareSummaryTitle(this.mShareTitle);
            this.mdW.setShareSummaryContent(this.mShareContent);
            this.mdW.setShareApiKey(this.mAppKey);
            this.mdW.setShareAppName(this.mAppName);
            this.mdW.setShareSignKey(this.mdU);
            this.mdW.setShareReferUrl(this.mdS);
            boolean isLocalImagePath = n.isLocalImagePath(this.ego);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.ePk.d(this.mShareLocalImageData, this.ego);
                this.mdW.setShareLocalImageUri(this.ego);
                this.mdW.setShareLocalImageData(this.mShareLocalImageData);
                this.ePk.clI();
                this.mdW.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mdW.setShareSummaryImg(this.ego);
                this.mdW.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mdW.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mdW.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mdW.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mdW.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mdW.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mdW.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mdW.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mdW.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mdW.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mdW.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mdW.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mdW.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mdW.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mdW.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mdW.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mdW.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mdW.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.mdY != null && this.mdY.dxi() != null && (obj = this.mdY.dxi().getEditableText().toString()) != null) {
            this.mdY.dxi().setText(TbFaceManager.bua().as(getPageContext().getContext(), obj));
            this.mdY.dxi().setSelection(this.mdY.dxi().getText().length());
        }
    }

    public void HU(int i) {
        this.mdX = i;
    }

    public int dwZ() {
        return this.mdX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxa() {
        dwX();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.mdX != this.mPrefixData.getPrefixs().size() - 1) {
            this.mdW.setTitle(this.mdY.dxm().getText().toString() + this.mdY.dxh().getText().toString());
        } else {
            this.mdW.setTitle(this.mdY.dxh().getText().toString());
        }
        this.mdW.setContent(this.mdY.dxi().getText().toString());
        this.ePk.e(this.mdW);
        this.mdW.setVcode(null);
        this.ePk.cOG().setVoice(null);
        this.ePk.cOG().setVoiceDuringTime(-1);
        if (this.ePk.dBQ()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hQL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.mea = false;
            if (i2 == -1) {
                dwV();
                if (this.mec != null) {
                    this.meb = true;
                    this.mec.dwQ();
                }
                setResult(-1);
                return;
            }
            dwW();
            if (this.med != null) {
                this.meb = false;
                this.med.dwQ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.mdT = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mdW.setForumName(this.mdT);
                    dwU();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dwT();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mdY.dxh());
        HidenSoftKeyPad(this.mInputManager, this.mdY.dxi());
        super.onPause();
    }

    public void dxb() {
        HidenSoftKeyPad(this.mInputManager, this.mdY.dxh());
        HidenSoftKeyPad(this.mInputManager, this.mdY.dxi());
    }
}
