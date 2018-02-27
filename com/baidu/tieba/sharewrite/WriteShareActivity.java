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
    private NewWriteModel btU;
    private String gPU;
    private String gPV;
    private String gPW;
    private String gPX;
    private PackageManager gPY;
    private PackageInfo gPZ;
    private int gQa;
    private d gQb;
    b gQc;
    private com.baidu.tieba.sharewrite.a gQf;
    private com.baidu.tieba.sharewrite.a gQg;
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
    private boolean gQd = false;
    private boolean gQe = false;
    private a.b gQh = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gQi = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsK());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsL());
            WriteShareActivity.this.bsD();
            aVar.dismiss();
        }
    };
    private a.b gQj = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gQe) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.e(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gQk = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
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
    private final NewWriteModel.c gQl = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bsy();
                if (WriteShareActivity.this.gQf != null) {
                    WriteShareActivity.this.gQe = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gQf.bst();
                }
            } else if (tVar == null || writeData == null || tVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.bsz();
                if (WriteShareActivity.this.gQg != null) {
                    WriteShareActivity.this.gQe = false;
                    WriteShareActivity.this.gQg.bst();
                }
            } else {
                writeData.setVcodeMD5(tVar.getVcode_md5());
                writeData.setVcodeUrl(tVar.getVcode_pic_url());
                writeData.setVcodeExtra(tVar.FX());
                WriteShareActivity.this.gQd = true;
                if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FW())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gQm = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gQb != null && WriteShareActivity.this.gQb.bsM() != null && WriteShareActivity.this.gQb.bsM().isShowing()) {
                    g.a(WriteShareActivity.this.gQb.bsM(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bsA();
                if (WriteShareActivity.this.gQe) {
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
    private View.OnClickListener gQn = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bsA();
            if (WriteShareActivity.this.gQe) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.e(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gQo = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsK());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsL());
            WriteShareActivity.this.bsD();
        }
    };
    private View.OnClickListener gQp = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gQb.bsL().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsL());
        }
    };
    private final View.OnFocusChangeListener gQq = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gQb != null) {
                if (view == WriteShareActivity.this.gQb.bsK() || view == WriteShareActivity.this.gQb.bsN() || view == WriteShareActivity.this.gQb.bsO()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsK());
                    } else if (view == WriteShareActivity.this.gQb.bsK() && WriteShareActivity.this.gQb.bsP() != null) {
                        WriteShareActivity.this.gQb.bsP().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gQb.bsL()) {
                    if (z) {
                        WriteShareActivity.this.gQb.bsL().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gQb.bsL().setHint(d.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gQb.bsK());
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
        this.gPY = getPageContext().getPageActivity().getPackageManager();
        ahu();
        boolean bsv = bsv();
        initData(bundle);
        initUI();
        if (!bsv) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                vk(d.j.share_parameter_invalid_tip);
            } else {
                vk(d.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bsw();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void ahu() {
        this.packageName = getCallingPackage();
        if (this.gPY != null && this.packageName != null) {
            try {
                this.gPZ = this.gPY.getPackageInfo(this.packageName, 64);
                if (this.gPZ != null) {
                    if (this.gPZ.applicationInfo != null && this.gPZ.applicationInfo.loadLabel(this.gPY) != null) {
                        this.mAppName = this.gPZ.applicationInfo.loadLabel(this.gPY).toString();
                    }
                    if (this.gPZ.signatures != null && this.gPZ.signatures.length > 0 && this.gPZ.signatures[0] != null) {
                        this.gPX = ap.v(this.gPZ.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gPX = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gPU = extras.getString("ShareUrl");
            this.gPV = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gPW = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gPX)) {
                this.gPX = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bsv() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gPV) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
    }

    private void bsw() {
        if (TextUtils.isEmpty(this.gPW)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bsx();
        }
    }

    private void bsx() {
        this.gQb.bsF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gQc.sp(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsy() {
        if (this.gQf == null) {
            this.gQf = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gQf.mr(false);
            this.gQf.vg(d.f.icon_send_ok);
            this.gQf.vj(d.j.share_alert_success);
            this.gQf.a(d.j.share_stay_in_tieba, this.gQh);
            this.gQf.b(d.j.back, this.gQj);
            this.gQf.a(this.gQm);
            this.gQf.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsz() {
        if (this.gQg == null) {
            this.gQg = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gQg.vg(d.f.icon_send_error);
            this.gQg.vh(d.f.btn_w_square);
            this.gQg.vi(d.C0141d.common_color_10039);
            this.gQg.vj(d.j.share_alert_fail);
            this.gQg.a(d.j.share_keep_sending, this.gQi);
            this.gQg.b(d.j.back, this.gQj);
            this.gQg.a(this.gQm);
            this.gQg.g(getPageContext());
        }
    }

    protected void bsA() {
        if (this.btU != null) {
            this.btU.cancelLoadData();
        }
    }

    protected void bsB() {
        if (this.btU != null) {
            this.btU.akj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bsA();
        bsB();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        c bsQ;
        if (this.gQb != null && (bsQ = this.gQb.bsQ()) != null) {
            bsQ.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gQb != null && this.gQb.bsM() != null && this.gQb.bsM().isShowing()) {
                g.a(this.gQb.bsM(), getPageContext().getPageActivity());
                return true;
            }
            bsA();
            if (this.gQe) {
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
        if (this.gQb != null) {
            this.gQb.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(d.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gQb = new d(this);
        this.gQb.Q(this.gQn);
        this.gQb.R(this.gQo);
        this.gQb.b(this.gQq);
        this.gQb.S(this.gQp);
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
        this.btU = new NewWriteModel(this);
        this.btU.a(this.gQl);
        this.btU.a(this.gQk);
        this.gQc = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(d.j.write_no_prefix));
                        if (WriteShareActivity.this.gQb != null) {
                            WriteShareActivity.this.gQb.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gQb.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gQb.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bsA();
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
            this.mData.setForumName(this.gPW);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gPX);
            this.mData.setShareReferUrl(this.gPU);
            boolean dX = k.dX(this.gPV);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dX) {
                this.btU.e(this.mShareLocalImageData, this.gPV);
                this.mData.setShareLocalImageUri(this.gPV);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.btU.arY();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gPV);
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
        if (this.gQb != null && this.gQb.bsL() != null && (obj = this.gQb.bsL().getEditableText().toString()) != null) {
            this.gQb.bsL().setText(TbFaceManager.Mv().W(getPageContext().getContext(), obj));
            this.gQb.bsL().setSelection(this.gQb.bsL().getText().length());
        }
    }

    public void vl(int i) {
        this.gQa = i;
    }

    public int bsC() {
        return this.gQa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsD() {
        bsA();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gQa != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gQb.bsP().getText().toString() + this.gQb.bsK().getText().toString());
        } else {
            this.mData.setTitle(this.gQb.bsK().getText().toString());
        }
        this.mData.setContent(this.gQb.bsL().getText().toString());
        this.btU.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.btU.getWriteData().setVoice(null);
        this.btU.getWriteData().setVoiceDuringTime(-1);
        if (this.btU.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gQd = false;
            if (i2 == -1) {
                bsy();
                if (this.gQf != null) {
                    this.gQe = true;
                    this.gQf.bst();
                }
                setResult(-1);
                return;
            }
            bsz();
            if (this.gQg != null) {
                this.gQe = false;
                this.gQg.bst();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gPW = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gPW);
                    bsx();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bsw();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gQb.bsK());
        HidenSoftKeyPad(this.mInputManager, this.gQb.bsL());
        super.onPause();
    }

    public void bsE() {
        HidenSoftKeyPad(this.mInputManager, this.gQb.bsK());
        HidenSoftKeyPad(this.mInputManager, this.gQb.bsL());
    }
}
