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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
import com.repackage.qd5;
import com.repackage.qt4;
import com.repackage.qx4;
import com.repackage.rf8;
import com.repackage.rg;
import com.repackage.sf8;
import com.repackage.tf8;
import com.repackage.xt4;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppKey;
    public String mAppName;
    public String mAppSign;
    public int mCurrPrefixPos;
    public WriteData mData;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public DialogInterface.OnKeyListener mDialogKeyListener;
    public rf8.c mFailYesDialogClickListener;
    public final View.OnFocusChangeListener mFocusChangeListener;
    public sf8 mGetForumPrefixModel;
    public InputMethodManager mInputManager;
    public boolean mIsGotoVcode;
    public boolean mIsShareSuccess;
    public rf8.c mNoDialogClickListener;
    public View.OnClickListener mNvBackClickListener;
    public final NewWriteModel.e mOnImageUploadCallback;
    public final NewWriteModel.f mOnPostWriteCallback;
    public View.OnClickListener mPostClickListener;
    public View.OnClickListener mPostContentClickListener;
    public PostPrefixData mPrefixData;
    public String mShareContent;
    public rf8 mShareFailDialog;
    public String mShareImageUrl;
    public byte[] mShareLocalImageData;
    public rf8 mShareSuccessDialog;
    public String mShareTargetBaName;
    public String mShareTitle;
    public String mShareUrl;
    public rf8.c mSuccessYesDialogClickListener;
    public tf8 mView;
    public NewWriteModel mWriteModel;
    public String packageName;
    public PackageInfo packageinfo;
    public PackageManager pm;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public a(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                WriteShareActivity writeShareActivity = this.a;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.a.mView.q());
                WriteShareActivity writeShareActivity2 = this.a;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.a.mView.p());
                this.a.PostNewMessage();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public b(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mView.p().requestFocus();
                WriteShareActivity writeShareActivity = this.a;
                writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.a.mView.p());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public c(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || this.a.mView == null) {
                return;
            }
            if (view2 == this.a.mView.q() || view2 == this.a.mView.n() || view2 == this.a.mView.o()) {
                if (!z) {
                    if (view2 == this.a.mView.q() && this.a.mView.r() != null) {
                        this.a.mView.r().setVisibility(0);
                    }
                } else {
                    WriteShareActivity writeShareActivity = this.a;
                    writeShareActivity.ShowSoftKeyPad(writeShareActivity.mInputManager, this.a.mView.q());
                }
            }
            if (view2 == this.a.mView.p()) {
                if (z) {
                    this.a.mView.p().setHint((CharSequence) null);
                } else {
                    this.a.mView.p().setHint(R.string.obfuscated_res_0x7f0f0433);
                }
                WriteShareActivity writeShareActivity2 = this.a;
                writeShareActivity2.ShowSoftKeyPad(writeShareActivity2.mInputManager, this.a.mView.q());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements rf8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public d(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.repackage.rf8.c
        public void a(rf8 rf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rf8Var) == null) {
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createBackSpecialCfg(this.a.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
                rf8Var.d();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements rf8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public e(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.repackage.rf8.c
        public void a(rf8 rf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rf8Var) == null) {
                WriteShareActivity writeShareActivity = this.a;
                writeShareActivity.HidenSoftKeyPad(writeShareActivity.mInputManager, this.a.mView.q());
                WriteShareActivity writeShareActivity2 = this.a;
                writeShareActivity2.HidenSoftKeyPad(writeShareActivity2.mInputManager, this.a.mView.p());
                this.a.PostNewMessage();
                rf8Var.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements rf8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public f(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.repackage.rf8.c
        public void a(rf8 rf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rf8Var) == null) {
                rf8Var.d();
                if (!this.a.mIsShareSuccess) {
                    this.a.setResult(0);
                }
                qt4.g(this.a.getPageContext().getPageActivity(), 200, false);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public g(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageUploadResult, z) == null) {
                if (imageUploadResult == null || (picinfo = imageUploadResult.picInfo) == null || picinfo.originPic == null) {
                    this.a.mData.setShareSummaryImg("");
                    this.a.mData.setShareSummaryImgHeight(0);
                    this.a.mData.setShareSummaryImgWidth(0);
                    return;
                }
                this.a.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
                this.a.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
                this.a.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements NewWriteModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public h(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.f
        public void a(boolean z, String str, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, qx4Var, writeData, antiData}) == null) {
                this.a.closeLoadingDialog();
                if (z) {
                    this.a.createShareSuccessDialog();
                    if (this.a.mShareSuccessDialog != null) {
                        this.a.mIsShareSuccess = true;
                        this.a.setResult(-1);
                        this.a.mShareSuccessDialog.o();
                    }
                } else if (qx4Var == null || writeData == null || qx4Var.c() == null) {
                    this.a.createShareFailDialog();
                    if (this.a.mShareFailDialog != null) {
                        this.a.mIsShareSuccess = false;
                        this.a.mShareFailDialog.o();
                    }
                } else {
                    writeData.setVcodeMD5(qx4Var.b());
                    writeData.setVcodeUrl(qx4Var.c());
                    writeData.setVcodeExtra(qx4Var.a());
                    this.a.mIsGotoVcode = true;
                    if (qd5.b(qx4Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, qx4Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public i(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (i == 4) {
                    if (this.a.mView != null && this.a.mView.s() != null && this.a.mView.s().isShowing()) {
                        rg.d(this.a.mView.s(), this.a.getPageContext().getPageActivity());
                        return true;
                    }
                    this.a.stopTask();
                    if (this.a.mIsShareSuccess) {
                        this.a.setResult(-1);
                    } else {
                        this.a.setResult(0);
                    }
                    qt4.g(this.a.getPageContext().getPageActivity(), 200, false);
                    this.a.finish();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements sf8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public j(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // com.repackage.sf8.b
        public void a(boolean z, PostPrefixData postPrefixData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, postPrefixData) == null) {
                if (z) {
                    this.a.mPrefixData = postPrefixData;
                    if (this.a.mPrefixData == null || this.a.mPrefixData.getPrefixs().size() <= 0) {
                        return;
                    }
                    this.a.mPrefixData.getPrefixs().add(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f158b));
                    if (this.a.mView != null) {
                        this.a.mView.F(this.a.mPrefixData);
                        return;
                    }
                    return;
                }
                this.a.mPrefixData = null;
                this.a.mView.F(null);
            }
        }

        @Override // com.repackage.sf8.b
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mPrefixData = null;
                this.a.mView.F(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public k(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                this.a.stopTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteShareActivity a;

        public l(WriteShareActivity writeShareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeShareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.stopTask();
                if (this.a.mIsShareSuccess) {
                    this.a.setResult(-1);
                }
                qt4.g(this.a.getPageContext().getPageActivity(), 200, false);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public final /* synthetic */ WriteShareActivity b;

        public m(WriteShareActivity writeShareActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeShareActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeShareActivity;
            this.a = null;
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            this.b.setResult(0);
            qt4.g(this.a, 200, false);
            this.a.finish();
        }
    }

    public WriteShareActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mData = null;
        this.mInputManager = null;
        this.mDialogCancelListener = null;
        this.mIsGotoVcode = false;
        this.mIsShareSuccess = false;
        this.mSuccessYesDialogClickListener = new d(this);
        this.mFailYesDialogClickListener = new e(this);
        this.mNoDialogClickListener = new f(this);
        this.mOnImageUploadCallback = new g(this);
        this.mOnPostWriteCallback = new h(this);
        this.mDialogKeyListener = new i(this);
        this.mNvBackClickListener = new l(this);
        this.mPostClickListener = new a(this);
        this.mPostContentClickListener = new b(this);
        this.mFocusChangeListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PostNewMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            stopTask();
            PostPrefixData postPrefixData = this.mPrefixData;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0 && this.mCurrPrefixPos != this.mPrefixData.getPrefixs().size() - 1) {
                WriteData writeData = this.mData;
                writeData.setTitle(this.mView.r().getText().toString() + this.mView.q().getText().toString());
            } else {
                this.mData.setTitle(this.mView.q().getText().toString());
            }
            this.mData.setContent(this.mView.p().getText().toString());
            this.mWriteModel.setWriteData(this.mData);
            this.mData.setVcode(null);
            this.mWriteModel.b0().setVoice(null);
            this.mWriteModel.b0().setVoiceDuringTime(-1);
            if (this.mWriteModel.r0()) {
                showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f10ef), this.mDialogCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShareFailDialog() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.mShareFailDialog == null) {
            rf8 rf8Var = new rf8(getActivity());
            this.mShareFailDialog = rf8Var;
            rf8Var.h(R.drawable.obfuscated_res_0x7f080a14);
            this.mShareFailDialog.m(R.drawable.btn_w_square);
            this.mShareFailDialog.n(R.color.common_color_10039);
            this.mShareFailDialog.i(R.string.obfuscated_res_0x7f0f110f);
            this.mShareFailDialog.l(R.string.obfuscated_res_0x7f0f111e, this.mFailYesDialogClickListener);
            this.mShareFailDialog.j(R.string.obfuscated_res_0x7f0f02bb, this.mNoDialogClickListener);
            this.mShareFailDialog.k(this.mDialogKeyListener);
            this.mShareFailDialog.b(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShareSuccessDialog() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.mShareSuccessDialog == null) {
            rf8 rf8Var = new rf8(getActivity());
            this.mShareSuccessDialog = rf8Var;
            rf8Var.g(false);
            this.mShareSuccessDialog.h(R.drawable.obfuscated_res_0x7f080a18);
            this.mShareSuccessDialog.i(R.string.obfuscated_res_0x7f0f1110);
            this.mShareSuccessDialog.l(R.string.obfuscated_res_0x7f0f113f, this.mSuccessYesDialogClickListener);
            this.mShareSuccessDialog.j(R.string.obfuscated_res_0x7f0f02bb, this.mNoDialogClickListener);
            this.mShareSuccessDialog.k(this.mDialogKeyListener);
            this.mShareSuccessDialog.b(getPageContext());
        }
    }

    private void dealIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
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
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.mWriteModel = newWriteModel;
            newWriteModel.m0(this.mOnPostWriteCallback);
            this.mWriteModel.j0(this.mOnImageUploadCallback);
            this.mGetForumPrefixModel = new sf8(this, new j(this));
            this.mDialogCancelListener = new k(this);
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
                    this.mWriteModel.k0(this.mShareLocalImageData, this.mShareImageUrl);
                    this.mData.setShareLocalImageUri(this.mShareImageUrl);
                    this.mData.setShareLocalImageData(this.mShareLocalImageData);
                    this.mWriteModel.q0();
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
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d08dd);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            tf8 tf8Var = new tf8(this);
            this.mView = tf8Var;
            tf8Var.C(this.mNvBackClickListener);
            this.mView.D(this.mPostClickListener);
            this.mView.B(this.mFocusChangeListener);
            this.mView.E(this.mPostContentClickListener);
        }
    }

    private void login() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            TbadkCoreApplication.isSDKLogin = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
        }
    }

    private void releaseResource() {
        tf8 tf8Var;
        ShareSDKImageView t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (tf8Var = this.mView) == null || (t = tf8Var.t()) == null) {
            return;
        }
        t.setImageBitmap(null);
    }

    private boolean shareContentValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                return false;
            }
            return (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.mShareImageUrl) && this.mShareLocalImageData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void startSelectBarActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (TextUtils.isEmpty(this.mShareTargetBaName)) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
            } else {
                updateShareLayout();
            }
        }
    }

    private void updateShareLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.mView.v();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mGetForumPrefixModel.b(this.mData.getForumName());
        }
    }

    public int getCurrentPrefixPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrPrefixPos : invokeV.intValue;
    }

    public WriteData getWriteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (WriteData) invokeV.objValue;
    }

    public void hidenSoftKeyPad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HidenSoftKeyPad(this.mInputManager, this.mView.q());
            HidenSoftKeyPad(this.mInputManager, this.mView.p());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 12006) {
                this.mIsGotoVcode = false;
                if (i3 == -1) {
                    createShareSuccessDialog();
                    rf8 rf8Var = this.mShareSuccessDialog;
                    if (rf8Var != null) {
                        this.mIsShareSuccess = true;
                        rf8Var.o();
                    }
                    setResult(-1);
                    return;
                }
                createShareFailDialog();
                rf8 rf8Var2 = this.mShareFailDialog;
                if (rf8Var2 != null) {
                    this.mIsShareSuccess = false;
                    rf8Var2.o();
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
                String stringExtra = intent.getStringExtra("bar_name");
                this.mShareTargetBaName = stringExtra;
                this.mData.setForumName(stringExtra);
                updateShareLayout();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            tf8 tf8Var = this.mView;
            if (tf8Var != null) {
                tf8Var.z(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
                    shareFailed(R.string.obfuscated_res_0x7f0f1125);
                } else {
                    shareFailed(R.string.obfuscated_res_0x7f0f1115);
                }
            } else if (TbadkCoreApplication.isLogin()) {
                startSelectBarActivity();
            } else {
                login();
            }
            TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            stopTask();
            stopLoadImageTask();
            releaseResource();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                tf8 tf8Var = this.mView;
                if (tf8Var != null && tf8Var.s() != null && this.mView.s().isShowing()) {
                    rg.d(this.mView.s(), getPageContext().getPageActivity());
                    return true;
                }
                stopTask();
                if (this.mIsShareSuccess) {
                    setResult(-1);
                } else {
                    setResult(0);
                }
                qt4.g(getPageContext().getPageActivity(), 200, false);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HidenSoftKeyPad(this.mInputManager, this.mView.q());
            HidenSoftKeyPad(this.mInputManager, this.mView.p());
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            tf8 tf8Var = this.mView;
            if (tf8Var == null || tf8Var.p() == null || (obj = this.mView.p().getEditableText().toString()) == null) {
                return;
            }
            this.mView.p().setText(TbFaceManager.e().j(getPageContext().getContext(), obj));
            this.mView.p().setSelection(this.mView.p().getText().length());
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    public void setCurrentPrefixPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mCurrPrefixPos = i2;
        }
    }

    public void shareFailed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            oi.J(getPageContext().getContext(), i2);
            new Handler().postDelayed(new m(this, getPageContext().getPageActivity()), 3500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, onCancelListener) == null) {
            super.showLoadingDialog(str, onCancelListener);
            xt4 xt4Var = this.mWaitingDialog;
            if (xt4Var != null) {
                xt4Var.g(false);
            }
        }
    }

    public void stopLoadImageTask() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (newWriteModel = this.mWriteModel) == null) {
            return;
        }
        newWriteModel.X();
    }

    public void stopTask() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (newWriteModel = this.mWriteModel) == null) {
            return;
        }
        newWriteModel.cancelLoadData();
    }
}
