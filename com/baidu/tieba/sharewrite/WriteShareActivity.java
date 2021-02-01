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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager dIe;
    private String eTy;
    private NewWriteModel fDH;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String nlG;
    private String nlH;
    private String nlI;
    private PackageInfo nlJ;
    private int nlL;
    private c nlM;
    b nlN;
    private com.baidu.tieba.sharewrite.a nlQ;
    private com.baidu.tieba.sharewrite.a nlR;
    private String packageName;
    private WriteData nlK = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iWZ = null;
    private boolean nlO = false;
    private boolean nlP = false;
    private a.b nlS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.nlK.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b nlT = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJT());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJU());
            WriteShareActivity.this.dJM();
            aVar.dismiss();
        }
    };
    private a.b nlU = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.nlP) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b nlV = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.nlK.setShareSummaryImg("");
                WriteShareActivity.this.nlK.setShareSummaryImgHeight(0);
                WriteShareActivity.this.nlK.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.nlK.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.nlK.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.nlK.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c nlW = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.dJH();
                if (WriteShareActivity.this.nlQ != null) {
                    WriteShareActivity.this.nlP = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.nlQ.dJC();
                }
            } else if (ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.dJI();
                if (WriteShareActivity.this.nlR != null) {
                    WriteShareActivity.this.nlP = false;
                    WriteShareActivity.this.nlR.dJC();
                }
            } else {
                writeData.setVcodeMD5(ahVar.getVcode_md5());
                writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                writeData.setVcodeExtra(ahVar.bwF());
                WriteShareActivity.this.nlO = true;
                if (com.baidu.tbadk.t.a.Ea(ahVar.bwE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener nlX = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.nlM != null && WriteShareActivity.this.nlM.dJV() != null && WriteShareActivity.this.nlM.dJV().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.nlM.dJV(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.dJJ();
                if (WriteShareActivity.this.nlP) {
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
    private View.OnClickListener nlY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.dJJ();
            if (WriteShareActivity.this.nlP) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener nlZ = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJT());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJU());
            WriteShareActivity.this.dJM();
        }
    };
    private View.OnClickListener nma = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.nlM.dJU().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJU());
        }
    };
    private final View.OnFocusChangeListener hxe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.nlM != null) {
                if (view == WriteShareActivity.this.nlM.dJT() || view == WriteShareActivity.this.nlM.dJW() || view == WriteShareActivity.this.nlM.dJX()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJT());
                    } else if (view == WriteShareActivity.this.nlM.dJT() && WriteShareActivity.this.nlM.dJY() != null) {
                        WriteShareActivity.this.nlM.dJY().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.nlM.dJU()) {
                    if (z) {
                        WriteShareActivity.this.nlM.dJU().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.nlM.dJU().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.nlM.dJT());
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
        this.dIe = getPageContext().getPageActivity().getPackageManager();
        cmk();
        boolean dJE = dJE();
        initData(bundle);
        initUI();
        if (!dJE) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                Jg(R.string.share_parameter_invalid_tip);
            } else {
                Jg(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            dJF();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void cmk() {
        this.packageName = getCallingPackage();
        if (this.dIe != null && this.packageName != null) {
            try {
                this.nlJ = this.dIe.getPackageInfo(this.packageName, 64);
                if (this.nlJ != null) {
                    if (this.nlJ.applicationInfo != null && this.nlJ.applicationInfo.loadLabel(this.dIe) != null) {
                        this.mAppName = this.nlJ.applicationInfo.loadLabel(this.dIe).toString();
                    }
                    if (this.nlJ.signatures != null && this.nlJ.signatures.length > 0 && this.nlJ.signatures[0] != null) {
                        this.nlI = aw.getAPKHexMD5(this.nlJ.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.nlI = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.nlG = extras.getString("ShareUrl");
            this.eTy = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.nlH = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.nlI)) {
                this.nlI = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean dJE() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eTy) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
    }

    private void dJF() {
        if (TextUtils.isEmpty(this.nlH)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            dJG();
        }
    }

    private void dJG() {
        this.nlM.dJO();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nlN.Sz(this.nlK.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJH() {
        if (this.nlQ == null) {
            this.nlQ = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nlQ.xZ(false);
            this.nlQ.Jc(R.drawable.icon_send_ok);
            this.nlQ.Jf(R.string.share_alert_success);
            this.nlQ.a(R.string.share_stay_in_tieba, this.nlS);
            this.nlQ.b(R.string.back, this.nlU);
            this.nlQ.b(this.nlX);
            this.nlQ.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJI() {
        if (this.nlR == null) {
            this.nlR = new com.baidu.tieba.sharewrite.a(getActivity());
            this.nlR.Jc(R.drawable.icon_send_error);
            this.nlR.Jd(R.drawable.btn_w_square);
            this.nlR.Je(R.color.common_color_10039);
            this.nlR.Jf(R.string.share_alert_fail);
            this.nlR.a(R.string.share_keep_sending, this.nlT);
            this.nlR.b(R.string.back, this.nlU);
            this.nlR.b(this.nlX);
            this.nlR.g(getPageContext());
        }
    }

    protected void dJJ() {
        if (this.fDH != null) {
            this.fDH.cancelLoadData();
        }
    }

    protected void dJK() {
        if (this.fDH != null) {
            this.fDH.dPl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dJJ();
        dJK();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView dJZ;
        if (this.nlM != null && (dJZ = this.nlM.dJZ()) != null) {
            dJZ.setImageBitmap(null);
        }
    }

    public WriteData dav() {
        return this.nlK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nlM != null && this.nlM.dJV() != null && this.nlM.dJV().isShowing()) {
                g.dismissPopupWindow(this.nlM.dJV(), getPageContext().getPageActivity());
                return true;
            }
            dJJ();
            if (this.nlP) {
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
        if (this.nlM != null) {
            this.nlM.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nlM = new c(this);
        this.nlM.ah(this.nlY);
        this.nlM.ai(this.nlZ);
        this.nlM.b(this.hxe);
        this.nlM.aj(this.nma);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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

    public void Jg(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.fDH = new NewWriteModel(this);
        this.fDH.a(this.nlW);
        this.fDH.a(this.nlV);
        this.nlN = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.nlM != null) {
                            WriteShareActivity.this.nlM.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nlM.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.nlM.a((PostPrefixData) null);
            }
        });
        this.iWZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.dJJ();
            }
        };
        this.nlK = new WriteData();
        this.nlK.setType(3);
        if (bundle != null) {
            this.nlK.setForumName(bundle.getString("forum_name"));
            this.nlK.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.nlK.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.nlK.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.nlK.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.nlK.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.nlK.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.nlK.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.nlK.setForumName(this.nlH);
            this.nlK.setShareSummaryTitle(this.mShareTitle);
            this.nlK.setShareSummaryContent(this.mShareContent);
            this.nlK.setShareApiKey(this.mAppKey);
            this.nlK.setShareAppName(this.mAppName);
            this.nlK.setShareSignKey(this.nlI);
            this.nlK.setShareReferUrl(this.nlG);
            boolean isLocalImagePath = o.isLocalImagePath(this.eTy);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.fDH.e(this.mShareLocalImageData, this.eTy);
                this.nlK.setShareLocalImageUri(this.eTy);
                this.nlK.setShareLocalImageData(this.mShareLocalImageData);
                this.fDH.cyU();
                this.nlK.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.nlK.setShareSummaryImg(this.eTy);
                this.nlK.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.nlK.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.nlK.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.nlK.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.nlK.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.nlK.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.nlK.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.nlK.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.nlK.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.nlK.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.nlK.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.nlK.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.nlK.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.nlK.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.nlK.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.nlK.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.nlK.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.nlK.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.nlM != null && this.nlM.dJU() != null && (obj = this.nlM.dJU().getEditableText().toString()) != null) {
            this.nlM.dJU().setText(TbFaceManager.bCO().aD(getPageContext().getContext(), obj));
            this.nlM.dJU().setSelection(this.nlM.dJU().getText().length());
        }
    }

    public void Jh(int i) {
        this.nlL = i;
    }

    public int dJL() {
        return this.nlL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJM() {
        dJJ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.nlL != this.mPrefixData.getPrefixs().size() - 1) {
            this.nlK.setTitle(this.nlM.dJY().getText().toString() + this.nlM.dJT().getText().toString());
        } else {
            this.nlK.setTitle(this.nlM.dJT().getText().toString());
        }
        this.nlK.setContent(this.nlM.dJU().getText().toString());
        this.fDH.f(this.nlK);
        this.nlK.setVcode(null);
        this.fDH.dav().setVoice(null);
        this.fDH.dav().setVoiceDuringTime(-1);
        if (this.fDH.dOV()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iWZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.nlO = false;
            if (i2 == -1) {
                dJH();
                if (this.nlQ != null) {
                    this.nlP = true;
                    this.nlQ.dJC();
                }
                setResult(-1);
                return;
            }
            dJI();
            if (this.nlR != null) {
                this.nlP = false;
                this.nlR.dJC();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.nlH = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.nlK.setForumName(this.nlH);
                    dJG();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                dJF();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.nlM.dJT());
        HidenSoftKeyPad(this.mInputManager, this.nlM.dJU());
        super.onPause();
    }

    public void dJN() {
        HidenSoftKeyPad(this.mInputManager, this.nlM.dJT());
        HidenSoftKeyPad(this.mInputManager, this.nlM.dJU());
    }
}
