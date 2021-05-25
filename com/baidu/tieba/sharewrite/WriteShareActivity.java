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
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import d.a.m0.s.c.i0;
import d.a.n0.y2.a;
import d.a.n0.y2.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    public String mAppKey;
    public String mAppName;
    public String mAppSign;
    public int mCurrPrefixPos;
    public d.a.n0.y2.b mGetForumPrefixModel;
    public PostPrefixData mPrefixData;
    public String mShareContent;
    public d.a.n0.y2.a mShareFailDialog;
    public String mShareImageUrl;
    public byte[] mShareLocalImageData;
    public d.a.n0.y2.a mShareSuccessDialog;
    public String mShareTargetBaName;
    public String mShareTitle;
    public String mShareUrl;
    public d.a.n0.y2.c mView;
    public NewWriteModel mWriteModel;
    public String packageName;
    public PackageInfo packageinfo;
    public PackageManager pm;
    public WriteData mData = null;
    public InputMethodManager mInputManager = null;
    public DialogInterface.OnCancelListener mDialogCancelListener = null;
    public boolean mIsGotoVcode = false;
    public boolean mIsShareSuccess = false;
    public a.c mSuccessYesDialogClickListener = new d();
    public a.c mFailYesDialogClickListener = new e();
    public a.c mNoDialogClickListener = new f();
    public final NewWriteModel.e mOnImageUploadCallback = new g();
    public final NewWriteModel.f mOnPostWriteCallback = new h();
    public DialogInterface.OnKeyListener mDialogKeyListener = new i();
    public View.OnClickListener mNvBackClickListener = new l();
    public View.OnClickListener mPostClickListener = new a();
    public View.OnClickListener mPostContentClickListener = new b();
    public final View.OnFocusChangeListener mFocusChangeListener = new c();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity writeShareActivity = WriteShareActivity.this;
            writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, WriteShareActivity.this.mView.q());
            WriteShareActivity writeShareActivity2 = WriteShareActivity.this;
            writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, WriteShareActivity.this.mView.p());
            WriteShareActivity.this.PostNewMessage();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.mView.p().requestFocus();
            WriteShareActivity writeShareActivity = WriteShareActivity.this;
            writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, WriteShareActivity.this.mView.p());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.mView == null) {
                return;
            }
            if (view == WriteShareActivity.this.mView.q() || view == WriteShareActivity.this.mView.n() || view == WriteShareActivity.this.mView.o()) {
                if (!z) {
                    if (view == WriteShareActivity.this.mView.q() && WriteShareActivity.this.mView.r() != null) {
                        WriteShareActivity.this.mView.r().setVisibility(0);
                    }
                } else {
                    WriteShareActivity writeShareActivity = WriteShareActivity.this;
                    writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, WriteShareActivity.this.mView.q());
                }
            }
            if (view == WriteShareActivity.this.mView.p()) {
                if (z) {
                    WriteShareActivity.this.mView.p().setHint((CharSequence) null);
                } else {
                    WriteShareActivity.this.mView.p().setHint(R.string.content);
                }
                WriteShareActivity writeShareActivity2 = WriteShareActivity.this;
                writeShareActivity2.ShowSoftKeyPad(writeShareActivity2.mInputManager, WriteShareActivity.this.mView.q());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.c {
        public d() {
        }

        @Override // d.a.n0.y2.a.c
        public void a(d.a.n0.y2.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.d();
            WriteShareActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.c {
        public e() {
        }

        @Override // d.a.n0.y2.a.c
        public void a(d.a.n0.y2.a aVar) {
            WriteShareActivity writeShareActivity = WriteShareActivity.this;
            writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, WriteShareActivity.this.mView.q());
            WriteShareActivity writeShareActivity2 = WriteShareActivity.this;
            writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, WriteShareActivity.this.mView.p());
            WriteShareActivity.this.PostNewMessage();
            aVar.d();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.c {
        public f() {
        }

        @Override // d.a.n0.y2.a.c
        public void a(d.a.n0.y2.a aVar) {
            aVar.d();
            if (!WriteShareActivity.this.mIsShareSuccess) {
                WriteShareActivity.this.setResult(0);
            }
            d.a.m0.r.a0.b.g(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements NewWriteModel.e {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            ImageUploadResult.picInfo picinfo;
            if (imageUploadResult == null || (picinfo = imageUploadResult.picInfo) == null || picinfo.originPic == null) {
                WriteShareActivity.this.mData.setShareSummaryImg("");
                WriteShareActivity.this.mData.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mData.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements NewWriteModel.f {
        public h() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.f
        public void a(boolean z, String str, i0 i0Var, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.createShareSuccessDialog();
                if (WriteShareActivity.this.mShareSuccessDialog != null) {
                    WriteShareActivity.this.mIsShareSuccess = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.mShareSuccessDialog.o();
                }
            } else if (i0Var == null || writeData == null || i0Var.c() == null) {
                WriteShareActivity.this.createShareFailDialog();
                if (WriteShareActivity.this.mShareFailDialog != null) {
                    WriteShareActivity.this.mIsShareSuccess = false;
                    WriteShareActivity.this.mShareFailDialog.o();
                }
            } else {
                writeData.setVcodeMD5(i0Var.b());
                writeData.setVcodeUrl(i0Var.c());
                writeData.setVcodeExtra(i0Var.a());
                WriteShareActivity.this.mIsGotoVcode = true;
                if (d.a.m0.a1.a.b(i0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, i0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnKeyListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (WriteShareActivity.this.mView != null && WriteShareActivity.this.mView.s() != null && WriteShareActivity.this.mView.s().isShowing()) {
                    d.a.c.e.m.g.d(WriteShareActivity.this.mView.s(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.stopTask();
                if (WriteShareActivity.this.mIsShareSuccess) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                d.a.m0.r.a0.b.g(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements b.InterfaceC1750b {
        public j() {
        }

        @Override // d.a.n0.y2.b.InterfaceC1750b
        public void a(boolean z, PostPrefixData postPrefixData) {
            if (z) {
                WriteShareActivity.this.mPrefixData = postPrefixData;
                if (WriteShareActivity.this.mPrefixData == null || WriteShareActivity.this.mPrefixData.getPrefixs().size() <= 0) {
                    return;
                }
                WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                if (WriteShareActivity.this.mView != null) {
                    WriteShareActivity.this.mView.F(WriteShareActivity.this.mPrefixData);
                    return;
                }
                return;
            }
            WriteShareActivity.this.mPrefixData = null;
            WriteShareActivity.this.mView.F(null);
        }

        @Override // d.a.n0.y2.b.InterfaceC1750b
        public void onFailure() {
            WriteShareActivity.this.mPrefixData = null;
            WriteShareActivity.this.mView.F(null);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements DialogInterface.OnCancelListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WriteShareActivity.this.destroyWaitingDialog();
            WriteShareActivity.this.stopTask();
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.stopTask();
            if (WriteShareActivity.this.mIsShareSuccess) {
                WriteShareActivity.this.setResult(-1);
            }
            d.a.m0.r.a0.b.g(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Activity f20543e;

        public m(Activity activity) {
            this.f20543e = null;
            this.f20543e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20543e != null) {
                WriteShareActivity.this.setResult(0);
                d.a.m0.r.a0.b.g(this.f20543e, 200, false);
                this.f20543e.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PostNewMessage() {
        stopTask();
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0 && this.mCurrPrefixPos != this.mPrefixData.getPrefixs().size() - 1) {
            WriteData writeData = this.mData;
            writeData.setTitle(this.mView.r().getText().toString() + this.mView.q().getText().toString());
        } else {
            this.mData.setTitle(this.mView.q().getText().toString());
        }
        this.mData.setContent(this.mView.p().getText().toString());
        this.mWriteModel.f0(this.mData);
        this.mData.setVcode(null);
        this.mWriteModel.T().setVoice(null);
        this.mWriteModel.T().setVoiceDuringTime(-1);
        if (this.mWriteModel.i0()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShareFailDialog() {
        if (this.mShareFailDialog == null) {
            d.a.n0.y2.a aVar = new d.a.n0.y2.a(getActivity());
            this.mShareFailDialog = aVar;
            aVar.h(R.drawable.icon_send_error);
            this.mShareFailDialog.m(R.drawable.btn_w_square);
            this.mShareFailDialog.n(R.color.common_color_10039);
            this.mShareFailDialog.i(R.string.share_alert_fail);
            this.mShareFailDialog.l(R.string.share_keep_sending, this.mFailYesDialogClickListener);
            this.mShareFailDialog.j(R.string.back, this.mNoDialogClickListener);
            this.mShareFailDialog.k(this.mDialogKeyListener);
            this.mShareFailDialog.b(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShareSuccessDialog() {
        if (this.mShareSuccessDialog == null) {
            d.a.n0.y2.a aVar = new d.a.n0.y2.a(getActivity());
            this.mShareSuccessDialog = aVar;
            aVar.g(false);
            this.mShareSuccessDialog.h(R.drawable.icon_send_ok);
            this.mShareSuccessDialog.i(R.string.share_alert_success);
            this.mShareSuccessDialog.l(R.string.share_stay_in_tieba, this.mSuccessYesDialogClickListener);
            this.mShareSuccessDialog.j(R.string.back, this.mNoDialogClickListener);
            this.mShareSuccessDialog.k(this.mDialogKeyListener);
            this.mShareSuccessDialog.b(getPageContext());
        }
    }

    private void dealIntent() {
        String callingPackage = getCallingPackage();
        this.packageName = callingPackage;
        PackageManager packageManager = this.pm;
        if (packageManager != null && callingPackage != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(callingPackage, 64);
                this.packageinfo = packageInfo;
                if (packageInfo != null) {
                    if (packageInfo.applicationInfo != null && packageInfo.applicationInfo.loadLabel(this.pm) != null) {
                        this.mAppName = this.packageinfo.applicationInfo.loadLabel(this.pm).toString();
                    }
                    if (this.packageinfo.signatures != null && this.packageinfo.signatures.length > 0 && this.packageinfo.signatures[0] != null) {
                        this.mAppSign = TbMd5.getAPKHexMD5(this.packageinfo.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.e(e2.getMessage());
                this.mAppName = null;
                this.mAppSign = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.mShareUrl = extras.getString("ShareUrl");
            this.mShareImageUrl = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.mShareTargetBaName = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.mAppSign)) {
                this.mAppSign = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void initData(Bundle bundle) {
        NewWriteModel newWriteModel = new NewWriteModel(this);
        this.mWriteModel = newWriteModel;
        newWriteModel.c0(this.mOnPostWriteCallback);
        this.mWriteModel.a0(this.mOnImageUploadCallback);
        this.mGetForumPrefixModel = new d.a.n0.y2.b(this, new j());
        this.mDialogCancelListener = new k();
        WriteData writeData = new WriteData();
        this.mData = writeData;
        writeData.setType(3);
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
            this.mData.setForumName(this.mShareTargetBaName);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.mAppSign);
            this.mData.setShareReferUrl(this.mShareUrl);
            boolean isLocalImagePath = FileHelper.isLocalImagePath(this.mShareImageUrl);
            byte[] bArr = this.mShareLocalImageData;
            if ((bArr != null && bArr.length > 0) || isLocalImagePath) {
                this.mWriteModel.b0(this.mShareLocalImageData, this.mShareImageUrl);
                this.mData.setShareLocalImageUri(this.mShareImageUrl);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.mWriteModel.h0();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.mShareImageUrl);
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

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        d.a.n0.y2.c cVar = new d.a.n0.y2.c(this);
        this.mView = cVar;
        cVar.C(this.mNvBackClickListener);
        this.mView.D(this.mPostClickListener);
        this.mView.B(this.mFocusChangeListener);
        this.mView.E(this.mPostContentClickListener);
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void releaseResource() {
        ShareSDKImageView t;
        d.a.n0.y2.c cVar = this.mView;
        if (cVar == null || (t = cVar.t()) == null) {
            return;
        }
        t.setImageBitmap(null);
    }

    private boolean shareContentValid() {
        if (TextUtils.isEmpty(this.mAppKey)) {
            return false;
        }
        return (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.mShareImageUrl) && this.mShareLocalImageData == null) ? false : true;
    }

    private void startSelectBarActivity() {
        if (TextUtils.isEmpty(this.mShareTargetBaName)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            updateShareLayout();
        }
    }

    private void updateShareLayout() {
        this.mView.v();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mGetForumPrefixModel.b(this.mData.getForumName());
    }

    public int getCurrentPrefixPosition() {
        return this.mCurrPrefixPos;
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    public void hidenSoftKeyPad() {
        HidenSoftKeyPad(this.mInputManager, this.mView.q());
        HidenSoftKeyPad(this.mInputManager, this.mView.p());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 12006) {
            this.mIsGotoVcode = false;
            if (i3 == -1) {
                createShareSuccessDialog();
                d.a.n0.y2.a aVar = this.mShareSuccessDialog;
                if (aVar != null) {
                    this.mIsShareSuccess = true;
                    aVar.o();
                }
                setResult(-1);
                return;
            }
            createShareFailDialog();
            d.a.n0.y2.a aVar2 = this.mShareFailDialog;
            if (aVar2 != null) {
                this.mIsShareSuccess = false;
                aVar2.o();
            }
            setResult(0);
        } else if (i2 != 23008) {
            if (i2 == 11003) {
                TbadkCoreApplication.isSDKLogin = false;
                if (i3 == -1) {
                    startSelectBarActivity();
                } else {
                    finish();
                }
            }
        } else if (i3 != -1) {
            finish();
        } else if (intent != null) {
            String stringExtra = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
            this.mShareTargetBaName = stringExtra;
            this.mData.setForumName(stringExtra);
            updateShareLayout();
        } else {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.y2.c cVar = this.mView;
        if (cVar != null) {
            cVar.z(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        setSwipeBackEnabled(false);
        this.pm = getPageContext().getPageActivity().getPackageManager();
        dealIntent();
        boolean shareContentValid = shareContentValid();
        initData(bundle);
        initUI();
        if (!shareContentValid) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                shareFailed(R.string.share_parameter_invalid_tip);
            } else {
                shareFailed(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            startSelectBarActivity();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        stopTask();
        stopLoadImageTask();
        releaseResource();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            d.a.n0.y2.c cVar = this.mView;
            if (cVar != null && cVar.s() != null && this.mView.s().isShowing()) {
                d.a.c.e.m.g.d(this.mView.s(), getPageContext().getPageActivity());
                return true;
            }
            stopTask();
            if (this.mIsShareSuccess) {
                setResult(-1);
            } else {
                setResult(0);
            }
            d.a.m0.r.a0.b.g(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mView.q());
        HidenSoftKeyPad(this.mInputManager, this.mView.p());
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        d.a.n0.y2.c cVar = this.mView;
        if (cVar == null || cVar.p() == null || (obj = this.mView.p().getEditableText().toString()) == null) {
            return;
        }
        this.mView.p().setText(TbFaceManager.e().j(getPageContext().getContext(), obj));
        this.mView.p().setSelection(this.mView.p().getText().length());
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    public void setCurrentPrefixPosition(int i2) {
        this.mCurrPrefixPos = i2;
    }

    public void shareFailed(int i2) {
        d.a.c.e.p.l.I(getPageContext().getContext(), i2);
        new Handler().postDelayed(new m(getPageContext().getPageActivity()), 3500L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        d.a.m0.r.f0.a aVar = this.mWaitingDialog;
        if (aVar != null) {
            aVar.g(false);
        }
    }

    public void stopLoadImageTask() {
        NewWriteModel newWriteModel = this.mWriteModel;
        if (newWriteModel != null) {
            newWriteModel.P();
        }
    }

    public void stopTask() {
        NewWriteModel newWriteModel = this.mWriteModel;
        if (newWriteModel != null) {
            newWriteModel.cancelLoadData();
        }
    }
}
